package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.e;
import com.badlogic.gdx.utils.j;
import com.badlogic.gdx.utils.k;
import defpackage.ij;
/* loaded from: classes.dex */
public class AndroidLiveWallpaper implements AndroidApplicationBase {
    protected il applicationLogger;
    protected AndroidAudio audio;
    protected AndroidClipboard clipboard;
    protected AndroidFiles files;
    protected AndroidGraphicsLiveWallpaper graphics;
    protected AndroidInput input;
    protected ik listener;
    protected AndroidNet net;
    protected AndroidLiveWallpaperService service;
    protected boolean firstResume = true;
    protected final a<Runnable> runnables = new a<>();
    protected final a<Runnable> executedRunnables = new a<>();
    protected final ai<iu> lifecycleListeners = new ai<>(iu.class);
    protected int logLevel = 2;

    public void exit() {
    }

    static {
        j.a();
    }

    public AndroidLiveWallpaper(AndroidLiveWallpaperService androidLiveWallpaperService) {
        this.service = androidLiveWallpaperService;
    }

    public void initialize(ik ikVar, AndroidApplicationConfiguration androidApplicationConfiguration) {
        if (getVersion() < 9) {
            throw new k("LibGDX requires Android API Level 9 or later.");
        }
        setApplicationLogger(new AndroidApplicationLogger());
        this.graphics = new AndroidGraphicsLiveWallpaper(this, androidApplicationConfiguration, androidApplicationConfiguration.resolutionStrategy == null ? new FillResolutionStrategy() : androidApplicationConfiguration.resolutionStrategy);
        this.input = AndroidInputFactory.newAndroidInput(this, getService(), this.graphics.view, androidApplicationConfiguration);
        this.audio = new AndroidAudio(getService(), androidApplicationConfiguration);
        getService().getFilesDir();
        this.files = new AndroidFiles(getService().getAssets(), getService().getFilesDir().getAbsolutePath());
        this.net = new AndroidNet(this);
        this.listener = ikVar;
        this.clipboard = new AndroidClipboard(getService());
        io.a = this;
        io.d = this.input;
        io.c = this.audio;
        io.e = this.files;
        io.b = this.graphics;
        io.f = this.net;
    }

    public void onPause() {
        if (AndroidLiveWallpaperService.DEBUG) {
            Log.d("WallpaperService", " > AndroidLiveWallpaper - onPause()");
        }
        this.audio.pause();
        this.input.onPause();
        AndroidGraphicsLiveWallpaper androidGraphicsLiveWallpaper = this.graphics;
        if (androidGraphicsLiveWallpaper != null) {
            androidGraphicsLiveWallpaper.onPauseGLSurfaceView();
        }
        if (AndroidLiveWallpaperService.DEBUG) {
            Log.d("WallpaperService", " > AndroidLiveWallpaper - onPause() done!");
        }
    }

    public void onResume() {
        io.a = this;
        AndroidInput androidInput = this.input;
        io.d = androidInput;
        io.c = this.audio;
        io.e = this.files;
        io.b = this.graphics;
        io.f = this.net;
        androidInput.onResume();
        AndroidGraphicsLiveWallpaper androidGraphicsLiveWallpaper = this.graphics;
        if (androidGraphicsLiveWallpaper != null) {
            androidGraphicsLiveWallpaper.onResumeGLSurfaceView();
        }
        if (!this.firstResume) {
            this.audio.resume();
            this.graphics.resume();
            return;
        }
        this.firstResume = false;
    }

    public void onDestroy() {
        AndroidGraphicsLiveWallpaper androidGraphicsLiveWallpaper = this.graphics;
        if (androidGraphicsLiveWallpaper != null) {
            androidGraphicsLiveWallpaper.onDestroyGLSurfaceView();
        }
        AndroidAudio androidAudio = this.audio;
        if (androidAudio != null) {
            androidAudio.dispose();
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public WindowManager getWindowManager() {
        return this.service.getWindowManager();
    }

    public AndroidLiveWallpaperService getService() {
        return this.service;
    }

    @Override // defpackage.ij
    public ik getApplicationListener() {
        return this.listener;
    }

    @Override // defpackage.ij
    public void postRunnable(Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.a((a<Runnable>) runnable);
        }
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
    public AndroidInput m3getInput() {
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
        return new AndroidPreferences(this.service.getSharedPreferences(str, 0));
    }

    public e getClipboard() {
        return this.clipboard;
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
    public Context getContext() {
        return this.service;
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
    public void startActivity(Intent intent) {
        this.service.startActivity(intent);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Window getApplicationWindow() {
        throw new UnsupportedOperationException();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public Handler getHandler() {
        throw new UnsupportedOperationException();
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
