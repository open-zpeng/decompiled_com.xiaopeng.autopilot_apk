package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.e;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.j;
import com.badlogic.gdx.utils.k;
import defpackage.ij;
/* loaded from: classes.dex */
public class AndroidFragmentApplication extends e implements AndroidApplicationBase {
    protected il applicationLogger;
    protected AndroidAudio audio;
    protected Callbacks callbacks;
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

    /* loaded from: classes.dex */
    public interface Callbacks {
        void exit();
    }

    static {
        j.a();
    }

    @Override // androidx.fragment.app.e
    public void onAttach(Activity activity) {
        if (activity instanceof Callbacks) {
            this.callbacks = (Callbacks) activity;
        } else if (getParentFragment() instanceof Callbacks) {
            this.callbacks = (Callbacks) getParentFragment();
        } else if (getTargetFragment() instanceof Callbacks) {
            this.callbacks = (Callbacks) getTargetFragment();
        } else {
            throw new RuntimeException("Missing AndroidFragmentApplication.Callbacks. Please implement AndroidFragmentApplication.Callbacks on the parent activity, fragment or target fragment.");
        }
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.e
    public void onDetach() {
        super.onDetach();
        this.callbacks = null;
    }

    protected FrameLayout.LayoutParams createLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    protected void createWakeLock(boolean z) {
        if (z) {
            getActivity().getWindow().addFlags(128);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    @TargetApi(19)
    public void useImmersiveMode(boolean z) {
        if (!z || getVersion() < 19) {
            return;
        }
        try {
            View.class.getMethod("setSystemUiVisibility", Integer.TYPE).invoke(this.graphics.getView(), 5894);
        } catch (Exception e) {
            log("AndroidApplication", "Failed to setup immersive mode, a throwable has occurred.", e);
        }
    }

    public View initializeForView(ik ikVar) {
        return initializeForView(ikVar, new AndroidApplicationConfiguration());
    }

    public View initializeForView(ik ikVar, AndroidApplicationConfiguration androidApplicationConfiguration) {
        if (getVersion() < 9) {
            throw new k("LibGDX requires Android API Level 9 or later.");
        }
        setApplicationLogger(new AndroidApplicationLogger());
        this.graphics = new AndroidGraphics(this, androidApplicationConfiguration, androidApplicationConfiguration.resolutionStrategy == null ? new FillResolutionStrategy() : androidApplicationConfiguration.resolutionStrategy);
        this.input = AndroidInputFactory.newAndroidInput(this, getActivity(), this.graphics.view, androidApplicationConfiguration);
        this.audio = new AndroidAudio(getActivity(), androidApplicationConfiguration);
        this.files = new AndroidFiles(getResources().getAssets(), getActivity().getFilesDir().getAbsolutePath());
        this.net = new AndroidNet(this);
        this.listener = ikVar;
        this.handler = new Handler();
        this.clipboard = new AndroidClipboard(getActivity());
        addLifecycleListener(new iu() { // from class: com.badlogic.gdx.backends.android.AndroidFragmentApplication.1
            @Override // defpackage.iu
            public void resume() {
                AndroidFragmentApplication.this.audio.resume();
            }

            @Override // defpackage.iu
            public void pause() {
                AndroidFragmentApplication.this.audio.pause();
            }

            @Override // defpackage.iu
            public void dispose() {
                AndroidFragmentApplication.this.audio.dispose();
            }
        });
        io.a = this;
        io.d = m2getInput();
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
                log("AndroidApplication", "Failed to create AndroidVisibilityListener", e);
            }
        }
        return this.graphics.getView();
    }

    @Override // androidx.fragment.app.e
    public void onPause() {
        boolean isContinuousRendering = this.graphics.isContinuousRendering();
        boolean z = AndroidGraphics.enforceContinuousRendering;
        AndroidGraphics.enforceContinuousRendering = true;
        this.graphics.setContinuousRendering(true);
        this.graphics.pause();
        this.input.onPause();
        if (isRemoving() || isAnyParentFragmentRemoving() || getActivity().isFinishing()) {
            this.graphics.clearManagedCaches();
            this.graphics.destroy();
        }
        AndroidGraphics.enforceContinuousRendering = z;
        this.graphics.setContinuousRendering(isContinuousRendering);
        this.graphics.onPauseGLSurfaceView();
        super.onPause();
    }

    @Override // androidx.fragment.app.e
    public void onResume() {
        io.a = this;
        io.d = m2getInput();
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
        super.onResume();
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
    public AndroidInput m2getInput() {
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
        return new AndroidPreferences(getActivity().getSharedPreferences(str, 0));
    }

    public com.badlogic.gdx.utils.e getClipboard() {
        return this.clipboard;
    }

    @Override // defpackage.ij
    public void postRunnable(Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.a((a<Runnable>) runnable);
            io.b.requestRendering();
        }
    }

    @Override // androidx.fragment.app.e, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.input.keyboardAvailable = configuration.hardKeyboardHidden == 1;
    }

    public void exit() {
        this.handler.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidFragmentApplication.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidFragmentApplication.this.callbacks.exit();
            }
        });
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

    @Override // androidx.fragment.app.e, com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Context getContext() {
        return getActivity();
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
        getActivity().runOnUiThread(runnable);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public ai<iu> getLifecycleListeners() {
        return this.lifecycleListeners;
    }

    @Override // androidx.fragment.app.e
    public void onActivityResult(int i, int i2, Intent intent) {
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
    public Window getApplicationWindow() {
        return getActivity().getWindow();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Handler getHandler() {
        return this.handler;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public WindowManager getWindowManager() {
        return (WindowManager) getContext().getSystemService("window");
    }

    private boolean isAnyParentFragmentRemoving() {
        for (e parentFragment = getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment.isRemoving()) {
                return true;
            }
        }
        return false;
    }
}
