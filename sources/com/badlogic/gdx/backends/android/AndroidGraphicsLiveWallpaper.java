package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20API18;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.utils.k;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public final class AndroidGraphicsLiveWallpaper extends AndroidGraphics {
    public AndroidGraphicsLiveWallpaper(AndroidLiveWallpaper androidLiveWallpaper, AndroidApplicationConfiguration androidApplicationConfiguration, ResolutionStrategy resolutionStrategy) {
        super(androidLiveWallpaper, androidApplicationConfiguration, resolutionStrategy, false);
    }

    SurfaceHolder getSurfaceHolder() {
        SurfaceHolder surfaceHolder;
        synchronized (((AndroidLiveWallpaper) this.app).service.sync) {
            surfaceHolder = ((AndroidLiveWallpaper) this.app).service.getSurfaceHolder();
        }
        return surfaceHolder;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
    protected View createGLSurfaceView(AndroidApplicationBase androidApplicationBase, ResolutionStrategy resolutionStrategy) {
        if (!checkGL20()) {
            throw new k("Libgdx requires OpenGL ES 2.0");
        }
        GLSurfaceView.EGLConfigChooser eglConfigChooser = getEglConfigChooser();
        if (Build.VERSION.SDK_INT <= 10 && this.config.useGLSurfaceView20API18) {
            GLSurfaceView20API18 gLSurfaceView20API18 = new GLSurfaceView20API18(androidApplicationBase.getContext(), resolutionStrategy) { // from class: com.badlogic.gdx.backends.android.AndroidGraphicsLiveWallpaper.1
                @Override // android.view.SurfaceView
                public SurfaceHolder getHolder() {
                    return AndroidGraphicsLiveWallpaper.this.getSurfaceHolder();
                }

                public void onDestroy() {
                    onDetachedFromWindow();
                }
            };
            if (eglConfigChooser != null) {
                gLSurfaceView20API18.setEGLConfigChooser(eglConfigChooser);
            } else {
                gLSurfaceView20API18.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
            }
            gLSurfaceView20API18.setRenderer(this);
            return gLSurfaceView20API18;
        }
        GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20(androidApplicationBase.getContext(), resolutionStrategy) { // from class: com.badlogic.gdx.backends.android.AndroidGraphicsLiveWallpaper.2
            @Override // android.view.SurfaceView
            public SurfaceHolder getHolder() {
                return AndroidGraphicsLiveWallpaper.this.getSurfaceHolder();
            }

            public void onDestroy() {
                onDetachedFromWindow();
            }
        };
        if (eglConfigChooser != null) {
            gLSurfaceView20.setEGLConfigChooser(eglConfigChooser);
        } else {
            gLSurfaceView20.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
        }
        gLSurfaceView20.setRenderer(this);
        return gLSurfaceView20;
    }

    public void onDestroyGLSurfaceView() {
        if (this.view != null) {
            if ((this.view instanceof GLSurfaceView) || (this.view instanceof GLSurfaceViewAPI18)) {
                try {
                    this.view.getClass().getMethod("onDestroy", new Class[0]).invoke(this.view, new Object[0]);
                    if (AndroidLiveWallpaperService.DEBUG) {
                        Log.d("WallpaperService", " > AndroidLiveWallpaper - onDestroy() stopped GLThread managed by GLSurfaceView");
                    }
                } catch (Throwable th) {
                    Log.e("WallpaperService", "failed to destroy GLSurfaceView's thread! GLSurfaceView.onDetachedFromWindow impl changed since API lvl 16!");
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
    public void resume() {
        synchronized (this.synch) {
            this.running = true;
            this.resume = true;
            while (this.resume) {
                try {
                    requestRendering();
                    this.synch.wait();
                } catch (InterruptedException unused) {
                    io.a.log("AndroidGraphics", "waiting for resume synchronization failed!");
                }
            }
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long nanoTime = System.nanoTime();
        this.deltaTime = ((float) (nanoTime - this.lastFrameTime)) / 1.0E9f;
        this.lastFrameTime = nanoTime;
        if (!this.resume) {
            this.mean.a(this.deltaTime);
        } else {
            this.deltaTime = 0.0f;
        }
        synchronized (this.synch) {
            z = this.running;
            z2 = this.pause;
            z3 = this.destroy;
            z4 = this.resume;
            if (this.resume) {
                this.resume = false;
                this.synch.notifyAll();
            }
            if (this.pause) {
                this.pause = false;
                this.synch.notifyAll();
            }
            if (this.destroy) {
                this.destroy = false;
                this.synch.notifyAll();
            }
        }
        if (z4) {
            this.app.getApplicationListener().o_();
            io.a.log("AndroidGraphics", "resumed");
        }
        if (z) {
            synchronized (this.app.getRunnables()) {
                this.app.getExecutedRunnables().d();
                this.app.getExecutedRunnables().a(this.app.getRunnables());
                this.app.getRunnables().d();
                for (int i = 0; i < this.app.getExecutedRunnables().b; i++) {
                    this.app.getExecutedRunnables().a(i).run();
                }
            }
            this.app.getInput().processEvents();
            this.frameId++;
            this.app.getApplicationListener().q_();
        }
        if (z2) {
            this.app.getApplicationListener().p_();
            io.a.log("AndroidGraphics", "paused");
        }
        if (z3) {
            this.app.getApplicationListener().dispose();
            io.a.log("AndroidGraphics", "destroyed");
        }
        if (nanoTime - this.frameStart > 1000000000) {
            this.fps = this.frames;
            this.frames = 0;
            this.frameStart = nanoTime;
        }
        this.frames++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
    public void logManagedCachesStatus() {
        if (AndroidLiveWallpaperService.DEBUG) {
            super.logManagedCachesStatus();
        }
    }
}
