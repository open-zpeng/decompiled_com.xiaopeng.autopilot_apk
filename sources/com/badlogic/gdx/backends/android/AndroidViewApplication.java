package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.e;
import com.badlogic.gdx.utils.j;
import com.badlogic.gdx.utils.k;
import defpackage.ij;
import defpackage.ik;
/* loaded from: classes.dex */
public abstract class AndroidViewApplication<T extends ik> extends FrameLayout implements AndroidApplicationBase {
    private static final String TAG = "AndroidViewApplication";
    private final a<AndroidEventListener> androidEventListeners;
    protected il applicationLogger;
    protected AndroidAudio audio;
    protected Callbacks callbacks;
    protected AndroidClipboard clipboard;
    protected final a<Runnable> executedRunnables;
    protected AndroidFiles files;
    protected boolean finishing;
    protected boolean firstResume;
    protected AndroidGraphics graphics;
    public Handler handler;
    protected AndroidInput input;
    protected final ai<iu> lifecycleListeners;
    protected T listener;
    protected int logLevel;
    private Handler mMainHandler;
    protected AndroidNet net;
    protected final a<Runnable> runnables;

    /* loaded from: classes.dex */
    public interface Callbacks {
        void exit();
    }

    protected void createWakeLock(boolean z) {
    }

    static {
        Log.i(TAG, "loadJni");
        j.a();
    }

    public AndroidViewApplication(Context context) {
        this(context, null);
    }

    public AndroidViewApplication(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AndroidViewApplication(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.firstResume = true;
        this.runnables = new a<>();
        this.executedRunnables = new a<>();
        this.lifecycleListeners = new ai<>(iu.class);
        this.androidEventListeners = new a<>();
        this.logLevel = 2;
    }

    public Callbacks getCallbacks() {
        return this.callbacks;
    }

    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    public View initializeForView(T t) {
        return initializeForView(t, new AndroidApplicationConfiguration());
    }

    public View initializeForView(T t, AndroidApplicationConfiguration androidApplicationConfiguration) {
        log(TAG, "initializeForView");
        if (getVersion() < 9) {
            throw new k("LibGDX requires Android API Level 9 or later.");
        }
        setApplicationLogger(new AndroidApplicationLogger());
        this.graphics = new AndroidGraphics(this, androidApplicationConfiguration, androidApplicationConfiguration.resolutionStrategy == null ? new FillResolutionStrategy() : androidApplicationConfiguration.resolutionStrategy);
        this.input = AndroidInputFactory.newAndroidInput(this, getContext(), this.graphics.view, androidApplicationConfiguration);
        this.audio = new AndroidAudio(getContext(), androidApplicationConfiguration);
        this.files = new AndroidFiles(getResources().getAssets(), getContext().getFilesDir().getAbsolutePath());
        this.net = new AndroidNet(this);
        this.listener = t;
        this.handler = new Handler();
        this.clipboard = new AndroidClipboard(getContext());
        addLifecycleListener(new iu() { // from class: com.badlogic.gdx.backends.android.AndroidViewApplication.1
            @Override // defpackage.iu
            public void resume() {
                AndroidViewApplication.this.audio.resume();
            }

            @Override // defpackage.iu
            public void pause() {
                AndroidViewApplication.this.audio.pause();
            }

            @Override // defpackage.iu
            public void dispose() {
                AndroidViewApplication.this.audio.dispose();
            }
        });
        io.a = this;
        io.d = m4getInput();
        io.c = getAudio();
        io.e = getFiles();
        io.b = getGraphics();
        io.f = getNet();
        createWakeLock(androidApplicationConfiguration.useWakelock);
        useImmersiveMode(androidApplicationConfiguration.useImmersiveMode);
        if (androidApplicationConfiguration.useImmersiveMode && getVersion() >= 19) {
            try {
                Class<?> cls = Class.forName("com.badlogic.gdx.backends.android.AndroidVisibilityListener");
                cls.getDeclaredMethod("createListener", AndroidApplicationBase.class).invoke(cls.newInstance(), this);
            } catch (Exception e) {
                log(TAG, "Failed to create AndroidVisibilityListener", e);
            }
        }
        return this.graphics.getView();
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
    public void runOnUiThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public void startActivity(Intent intent) {
        getContext().startActivity(intent);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    /* renamed from: getInput */
    public AndroidInput m4getInput() {
        return this.input;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public ai<iu> getLifecycleListeners() {
        return this.lifecycleListeners;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Window getApplicationWindow() {
        throw new UnsupportedOperationException();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public WindowManager getWindowManager() {
        return (WindowManager) getContext().getSystemService("window");
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public void useImmersiveMode(boolean z) {
        if (!z || getVersion() < 19) {
            return;
        }
        try {
            View.class.getMethod("setSystemUiVisibility", Integer.TYPE).invoke(this.graphics.getView(), 5894);
        } catch (Exception e) {
            log(TAG, "Failed to setup immersive mode, a throwable has occurred.", e);
        }
    }

    @Override // android.view.View, com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Handler getHandler() {
        return this.handler;
    }

    @Override // defpackage.ij
    public ik getApplicationListener() {
        return this.listener;
    }

    @Override // defpackage.ij
    public ip getGraphics() {
        return this.graphics;
    }

    public im getAudio() {
        return this.audio;
    }

    public in getFiles() {
        return this.files;
    }

    public iv getNet() {
        return this.net;
    }

    @Override // defpackage.ij
    public void log(String str, String str2) {
        if (this.logLevel >= 2) {
            Log.i(str, str2);
        }
    }

    @Override // defpackage.ij
    public void log(String str, String str2, Throwable th) {
        if (this.logLevel >= 2) {
            Log.i(str, str2, th);
        }
    }

    @Override // defpackage.ij
    public void error(String str, String str2) {
        if (this.logLevel >= 1) {
            Log.e(str, str2);
        }
    }

    @Override // defpackage.ij
    public void error(String str, String str2, Throwable th) {
        if (this.logLevel >= 1) {
            Log.e(str, str2, th);
        }
    }

    @Override // defpackage.ij
    public void debug(String str, String str2) {
        if (this.logLevel >= 3) {
            Log.d(str, str2);
        }
    }

    public void debug(String str, String str2, Throwable th) {
        if (this.logLevel >= 3) {
            Log.d(str, str2, th);
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
        return new AndroidPreferences(getContext().getSharedPreferences(str, 0));
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

    public void exit() {
        log(TAG, "exit");
        this.handler.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidViewApplication.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidViewApplication.this.callbacks.exit();
            }
        });
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

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.input.keyboardAvailable = configuration.hardKeyboardHidden == 1;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        log(TAG, "onVisibilityChanged:" + i);
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            onResume();
        } else {
            onPause();
        }
    }

    @TargetApi(19)
    public void onPause() {
        log(TAG, "onPause");
        boolean isContinuousRendering = this.graphics.isContinuousRendering();
        boolean z = AndroidGraphics.enforceContinuousRendering;
        AndroidGraphics.enforceContinuousRendering = true;
        this.graphics.setContinuousRendering(true);
        this.graphics.pause();
        this.audio.pause();
        this.input.onPause();
        if (isFinishing() || isActivityFinishing()) {
            this.graphics.clearManagedCaches();
            this.graphics.destroy();
        }
        AndroidGraphics.enforceContinuousRendering = z;
        this.graphics.setContinuousRendering(isContinuousRendering);
        this.graphics.onPauseGLSurfaceView();
    }

    public void onResume() {
        log(TAG, "onResume");
        io.a = this;
        io.d = m4getInput();
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
            this.audio.resume();
            this.graphics.resume();
            return;
        }
        this.firstResume = false;
    }

    public void finish() {
        this.finishing = true;
        onPause();
    }

    public boolean isFinishing() {
        return this.finishing;
    }

    public Activity getActivity() {
        Context context = getContext();
        while (context != null && !(context instanceof Application)) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                context = context.getApplicationContext();
            }
        }
        return null;
    }

    public boolean isActivityFinishing() {
        Activity activity = getActivity();
        return activity != null && activity.isFinishing();
    }
}
