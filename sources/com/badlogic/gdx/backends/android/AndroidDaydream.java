package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.service.dreams.DreamService;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.e;
import com.badlogic.gdx.utils.j;
import defpackage.ij;
import java.lang.reflect.Method;
import java.util.Arrays;
/* loaded from: classes.dex */
public class AndroidDaydream extends DreamService implements AndroidApplicationBase {
    protected il applicationLogger;
    protected AndroidAudio audio;
    protected AndroidClipboard clipboard;
    protected AndroidFiles files;
    protected AndroidGraphics graphics;
    protected Handler handler;
    protected AndroidInput input;
    protected ik listener;
    protected AndroidNet net;
    protected boolean firstResume = true;
    protected final a<Runnable> runnables = new a<>();
    protected final a<Runnable> executedRunnables = new a<>();
    protected final ai<iu> lifecycleListeners = new ai<>(iu.class);
    protected int logLevel = 2;

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
        setApplicationLogger(new AndroidApplicationLogger());
        this.graphics = new AndroidGraphics(this, androidApplicationConfiguration, androidApplicationConfiguration.resolutionStrategy == null ? new FillResolutionStrategy() : androidApplicationConfiguration.resolutionStrategy);
        this.input = AndroidInputFactory.newAndroidInput(this, this, this.graphics.view, androidApplicationConfiguration);
        this.audio = new AndroidAudio(this, androidApplicationConfiguration);
        getFilesDir();
        this.files = new AndroidFiles(getAssets(), getFilesDir().getAbsolutePath());
        this.net = new AndroidNet(this);
        this.listener = ikVar;
        this.handler = new Handler();
        this.clipboard = new AndroidClipboard(this);
        addLifecycleListener(new iu() { // from class: com.badlogic.gdx.backends.android.AndroidDaydream.1
            @Override // defpackage.iu
            public void resume() {
                AndroidDaydream.this.audio.resume();
            }

            @Override // defpackage.iu
            public void pause() {
                AndroidDaydream.this.audio.pause();
            }

            @Override // defpackage.iu
            public void dispose() {
                AndroidDaydream.this.audio.dispose();
                AndroidDaydream.this.audio = null;
            }
        });
        io.a = this;
        io.d = m1getInput();
        io.c = getAudio();
        io.e = getFiles();
        io.b = getGraphics();
        io.f = getNet();
        if (!z) {
            setFullscreen(true);
            setContentView(this.graphics.getView(), createLayoutParams());
        }
        createWakeLock(androidApplicationConfiguration.useWakelock);
        hideStatusBar(androidApplicationConfiguration);
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

    protected void hideStatusBar(AndroidApplicationConfiguration androidApplicationConfiguration) {
        if (!androidApplicationConfiguration.hideStatusBar || getVersion() < 11) {
            return;
        }
        View decorView = getWindow().getDecorView();
        try {
            Method method = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            method.invoke(decorView, 0);
            method.invoke(decorView, 1);
        } catch (Exception e) {
            log("AndroidApplication", "Can't hide status bar", e);
        }
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStopped() {
        boolean isContinuousRendering = this.graphics.isContinuousRendering();
        this.graphics.setContinuousRendering(true);
        this.graphics.pause();
        this.input.unregisterSensorListeners();
        Arrays.fill(this.input.realId, -1);
        Arrays.fill(this.input.touched, false);
        this.graphics.clearManagedCaches();
        this.graphics.destroy();
        this.graphics.setContinuousRendering(isContinuousRendering);
        this.graphics.onPauseGLSurfaceView();
        super.onDreamingStopped();
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStarted() {
        io.a = this;
        io.d = m1getInput();
        io.c = getAudio();
        io.e = getFiles();
        io.b = getGraphics();
        io.f = getNet();
        m1getInput().registerSensorListeners();
        AndroidGraphics androidGraphics = this.graphics;
        if (androidGraphics != null) {
            androidGraphics.onResumeGLSurfaceView();
        }
        if (!this.firstResume) {
            this.graphics.resume();
        } else {
            this.firstResume = false;
        }
        super.onDreamingStarted();
    }

    @Override // android.service.dreams.DreamService, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
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
    public AndroidInput m1getInput() {
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

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.input.keyboardAvailable = configuration.hardKeyboardHidden == 1;
    }

    public void exit() {
        this.handler.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidDaydream.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidDaydream.this.finish();
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

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public void useImmersiveMode(boolean z) {
        throw new UnsupportedOperationException();
    }
}
