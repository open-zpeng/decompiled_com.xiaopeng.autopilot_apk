package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.e;
import com.badlogic.gdx.utils.j;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.xui.app.XDialogSystemType;
import defpackage.ij;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class AndroidApplication extends Activity implements AndroidApplicationBase {
    protected il applicationLogger;
    protected AndroidAudio audio;
    protected AndroidClipboard clipboard;
    protected AndroidFiles files;
    protected AndroidGraphics graphics;
    public Handler handler;
    protected AndroidInput input;
    protected ik listener;
    protected AndroidNet net;
    protected boolean firstResume = true;
    protected final a<Runnable> runnables = new a<>();
    protected final a<Runnable> executedRunnables = new a<>();
    protected final ai<iu> lifecycleListeners = new ai<>(iu.class);
    private final a<AndroidEventListener> androidEventListeners = new a<>();
    protected int logLevel = 2;
    protected boolean useImmersiveMode = false;
    protected boolean hideStatusBar = false;
    private int wasFocusChanged = -1;
    private boolean isWaitingForAudio = false;

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Context getContext() {
        return this;
    }

    static {
        j.a();
    }

    public void initialize(ik ikVar) {
        initialize(ikVar, new AndroidApplicationConfiguration());
    }

    public void initialize(ik ikVar, AndroidApplicationConfiguration androidApplicationConfiguration) {
        init(ikVar, androidApplicationConfiguration, false);
    }

    public View initializeForView(ik ikVar) {
        return initializeForView(ikVar, new AndroidApplicationConfiguration());
    }

    public View initializeForView(ik ikVar, AndroidApplicationConfiguration androidApplicationConfiguration) {
        init(ikVar, androidApplicationConfiguration, true);
        return this.graphics.getView();
    }

    private void init(ik ikVar, AndroidApplicationConfiguration androidApplicationConfiguration, boolean z) {
        if (getVersion() < 9) {
            throw new k("LibGDX requires Android API Level 9 or later.");
        }
        setApplicationLogger(new AndroidApplicationLogger());
        this.graphics = new AndroidGraphics(this, androidApplicationConfiguration, androidApplicationConfiguration.resolutionStrategy == null ? new FillResolutionStrategy() : androidApplicationConfiguration.resolutionStrategy);
        this.input = AndroidInputFactory.newAndroidInput(this, this, this.graphics.view, androidApplicationConfiguration);
        this.audio = new AndroidAudio(this, androidApplicationConfiguration);
        getFilesDir();
        this.files = new AndroidFiles(getAssets(), getFilesDir().getAbsolutePath());
        this.net = new AndroidNet(this);
        this.listener = ikVar;
        this.handler = new Handler();
        this.useImmersiveMode = androidApplicationConfiguration.useImmersiveMode;
        this.hideStatusBar = androidApplicationConfiguration.hideStatusBar;
        this.clipboard = new AndroidClipboard(this);
        addLifecycleListener(new iu() { // from class: com.badlogic.gdx.backends.android.AndroidApplication.1
            @Override // defpackage.iu
            public void resume() {
            }

            @Override // defpackage.iu
            public void pause() {
                AndroidApplication.this.audio.pause();
            }

            @Override // defpackage.iu
            public void dispose() {
                AndroidApplication.this.audio.dispose();
            }
        });
        io.a = this;
        io.d = m0getInput();
        io.c = getAudio();
        io.e = getFiles();
        io.b = getGraphics();
        io.f = getNet();
        if (!z) {
            try {
                requestWindowFeature(1);
            } catch (Exception e) {
                log("AndroidApplication", "Content already displayed, cannot request FEATURE_NO_TITLE", e);
            }
            getWindow().setFlags(1024, 1024);
            getWindow().clearFlags(XDialogSystemType.TYPE_LIFECYCLE_DIALOG);
            setContentView(this.graphics.getView(), createLayoutParams());
        }
        createWakeLock(androidApplicationConfiguration.useWakelock);
        hideStatusBar(this.hideStatusBar);
        useImmersiveMode(this.useImmersiveMode);
        if (this.useImmersiveMode && getVersion() >= 19) {
            try {
                Class<?> cls = Class.forName("com.badlogic.gdx.backends.android.AndroidVisibilityListener");
                cls.getDeclaredMethod("createListener", AndroidApplicationBase.class).invoke(cls.newInstance(), this);
            } catch (Exception e2) {
                log("AndroidApplication", "Failed to create AndroidVisibilityListener", e2);
            }
        }
        if (getResources().getConfiguration().keyboard != 1) {
            m0getInput().keyboardAvailable = true;
        }
    }

    protected FrameLayout.LayoutParams createLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    protected void createWakeLock(boolean z) {
        if (z) {
            getWindow().addFlags(128);
        }
    }

    protected void hideStatusBar(boolean z) {
        if (!z || getVersion() < 11) {
            return;
        }
        View decorView = getWindow().getDecorView();
        try {
            Method method = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            if (getVersion() <= 13) {
                method.invoke(decorView, 0);
            }
            method.invoke(decorView, 1);
        } catch (Exception e) {
            log("AndroidApplication", "Can't hide status bar", e);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        useImmersiveMode(this.useImmersiveMode);
        hideStatusBar(this.hideStatusBar);
        if (z) {
            this.wasFocusChanged = 1;
            if (this.isWaitingForAudio) {
                this.audio.resume();
                this.isWaitingForAudio = false;
                return;
            }
            return;
        }
        this.wasFocusChanged = 0;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    @TargetApi(19)
    public void useImmersiveMode(boolean z) {
        if (!z || getVersion() < 19) {
            return;
        }
        try {
            View.class.getMethod("setSystemUiVisibility", Integer.TYPE).invoke(getWindow().getDecorView(), 5894);
        } catch (Exception e) {
            log("AndroidApplication", "Can't set immersive mode", e);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        boolean isContinuousRendering = this.graphics.isContinuousRendering();
        boolean z = AndroidGraphics.enforceContinuousRendering;
        AndroidGraphics.enforceContinuousRendering = true;
        this.graphics.setContinuousRendering(true);
        this.graphics.pause();
        this.input.onPause();
        if (isFinishing()) {
            this.graphics.clearManagedCaches();
            this.graphics.destroy();
        }
        AndroidGraphics.enforceContinuousRendering = z;
        this.graphics.setContinuousRendering(isContinuousRendering);
        this.graphics.onPauseGLSurfaceView();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        io.a = this;
        io.d = m0getInput();
        io.c = getAudio();
        io.e = getFiles();
        io.b = getGraphics();
        io.f = getNet();
        this.input.onResume();
        AndroidGraphics androidGraphics = this.graphics;
        if (androidGraphics != null) {
            androidGraphics.onResumeGLSurfaceView();
        }
        if (!this.firstResume) {
            this.graphics.resume();
        } else {
            this.firstResume = false;
        }
        this.isWaitingForAudio = true;
        int i = this.wasFocusChanged;
        if (i == 1 || i == -1) {
            this.audio.resume();
            this.isWaitingForAudio = false;
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.ij
    public ik getApplicationListener() {
        return this.listener;
    }

    public im getAudio() {
        return this.audio;
    }

    public in getFiles() {
        return this.files;
    }

    @Override // defpackage.ij
    public ip getGraphics() {
        return this.graphics;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    /* renamed from: getInput */
    public AndroidInput m0getInput() {
        return this.input;
    }

    public iv getNet() {
        return this.net;
    }

    @Override // defpackage.ij
    public ij.a getType() {
        return ij.a.Android;
    }

    public int getVersion() {
        return Build.VERSION.SDK_INT;
    }

    public long getJavaHeap() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize();
    }

    public iw getPreferences(String str) {
        return new AndroidPreferences(getSharedPreferences(str, 0));
    }

    public e getClipboard() {
        return this.clipboard;
    }

    @Override // defpackage.ij
    public void postRunnable(Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.a((a<Runnable>) runnable);
            io.b.requestRendering();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.input.keyboardAvailable = configuration.hardKeyboardHidden == 1;
    }

    public void exit() {
        this.handler.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidApplication.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidApplication.this.finish();
            }
        });
    }

    @Override // defpackage.ij
    public void debug(String str, String str2) {
        if (this.logLevel >= 3) {
            getApplicationLogger().debug(str, str2);
        }
    }

    public void debug(String str, String str2, Throwable th) {
        if (this.logLevel >= 3) {
            getApplicationLogger().debug(str, str2, th);
        }
    }

    @Override // defpackage.ij
    public void log(String str, String str2) {
        if (this.logLevel >= 2) {
            getApplicationLogger().log(str, str2);
        }
    }

    @Override // defpackage.ij
    public void log(String str, String str2, Throwable th) {
        if (this.logLevel >= 2) {
            getApplicationLogger().log(str, str2, th);
        }
    }

    @Override // defpackage.ij
    public void error(String str, String str2) {
        if (this.logLevel >= 1) {
            getApplicationLogger().error(str, str2);
        }
    }

    @Override // defpackage.ij
    public void error(String str, String str2, Throwable th) {
        if (this.logLevel >= 1) {
            getApplicationLogger().error(str, str2, th);
        }
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void setApplicationLogger(il ilVar) {
        this.applicationLogger = ilVar;
    }

    public il getApplicationLogger() {
        return this.applicationLogger;
    }

    @Override // defpackage.ij
    public void addLifecycleListener(iu iuVar) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.a((ai<iu>) iuVar);
        }
    }

    @Override // defpackage.ij
    public void removeLifecycleListener(iu iuVar) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.c(iuVar, true);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        synchronized (this.androidEventListeners) {
            for (int i3 = 0; i3 < this.androidEventListeners.b; i3++) {
                this.androidEventListeners.a(i3).onActivityResult(i, i2, intent);
            }
        }
    }

    public void addAndroidEventListener(AndroidEventListener androidEventListener) {
        synchronized (this.androidEventListeners) {
            this.androidEventListeners.a((a<AndroidEventListener>) androidEventListener);
        }
    }

    public void removeAndroidEventListener(AndroidEventListener androidEventListener) {
        synchronized (this.androidEventListeners) {
            this.androidEventListeners.c(androidEventListener, true);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public a<Runnable> getRunnables() {
        return this.runnables;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public a<Runnable> getExecutedRunnables() {
        return this.executedRunnables;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public ai<iu> getLifecycleListeners() {
        return this.lifecycleListeners;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Window getApplicationWindow() {
        return getWindow();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Handler getHandler() {
        return this.handler;
    }
}
