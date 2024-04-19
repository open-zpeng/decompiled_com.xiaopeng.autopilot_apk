package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20API18;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18;
import com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.graphics.glutils.c;
import com.badlogic.gdx.graphics.glutils.f;
import com.badlogic.gdx.math.q;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.k;
import defpackage.ij;
import defpackage.ip;
import defpackage.ke;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class AndroidGraphics implements GLSurfaceView.Renderer, ip {
    private static final String LOG_TAG = "AndroidGraphics";
    static volatile boolean enforceContinuousRendering = false;
    AndroidApplicationBase app;
    private ip.a bufferFormat;
    protected final AndroidApplicationConfiguration config;
    volatile boolean created;
    protected float deltaTime;
    private float density;
    volatile boolean destroy;
    EGLContext eglContext;
    String extensions;
    protected int fps;
    protected long frameId;
    protected long frameStart;
    protected int frames;
    kg gl20;
    kh gl30;
    f glVersion;
    int height;
    private boolean isContinuous;
    protected long lastFrameTime;
    protected q mean;
    volatile boolean pause;
    private float ppcX;
    private float ppcY;
    private float ppiX;
    private float ppiY;
    volatile boolean resume;
    volatile boolean running;
    Object synch;
    int[] value;
    final View view;
    int width;

    public boolean isFullscreen() {
        return true;
    }

    public ke newCursor(km kmVar, int i, int i2) {
        return null;
    }

    public void setCursor(ke keVar) {
    }

    public boolean setFullscreenMode(ip.b bVar) {
        return false;
    }

    public void setResizable(boolean z) {
    }

    public void setSystemCursor(ke.a aVar) {
    }

    public void setTitle(String str) {
    }

    public void setVSync(boolean z) {
    }

    public boolean setWindowedMode(int i, int i2) {
        return false;
    }

    public boolean supportsDisplayModeChange() {
        return false;
    }

    public AndroidGraphics(AndroidApplicationBase androidApplicationBase, AndroidApplicationConfiguration androidApplicationConfiguration, ResolutionStrategy resolutionStrategy) {
        this(androidApplicationBase, androidApplicationConfiguration, resolutionStrategy, true);
    }

    public AndroidGraphics(AndroidApplicationBase androidApplicationBase, AndroidApplicationConfiguration androidApplicationConfiguration, ResolutionStrategy resolutionStrategy, boolean z) {
        this.lastFrameTime = System.nanoTime();
        this.deltaTime = 0.0f;
        this.frameStart = System.nanoTime();
        this.frameId = -1L;
        this.frames = 0;
        this.mean = new q(5);
        this.created = false;
        this.running = false;
        this.pause = false;
        this.resume = false;
        this.destroy = false;
        this.ppiX = 0.0f;
        this.ppiY = 0.0f;
        this.ppcX = 0.0f;
        this.ppcY = 0.0f;
        this.density = 1.0f;
        this.bufferFormat = new ip.a(5, 6, 5, 0, 16, 0, 0, false);
        this.isContinuous = true;
        this.value = new int[1];
        this.synch = new Object();
        AndroidGL20.init();
        this.config = androidApplicationConfiguration;
        this.app = androidApplicationBase;
        this.view = createGLSurfaceView(androidApplicationBase, resolutionStrategy);
        preserveEGLContextOnPause();
        if (z) {
            this.view.setFocusable(true);
            this.view.setFocusableInTouchMode(true);
        }
    }

    protected void preserveEGLContextOnPause() {
        if ((Build.VERSION.SDK_INT < 11 || !(this.view instanceof GLSurfaceView20)) && !(this.view instanceof GLSurfaceView20API18)) {
            return;
        }
        try {
            this.view.getClass().getMethod("setPreserveEGLContextOnPause", Boolean.TYPE).invoke(this.view, true);
        } catch (Exception unused) {
            io.a.log(LOG_TAG, "Method GLSurfaceView.setPreserveEGLContextOnPause not found");
        }
    }

    protected View createGLSurfaceView(AndroidApplicationBase androidApplicationBase, ResolutionStrategy resolutionStrategy) {
        if (!checkGL20()) {
            throw new k("Libgdx requires OpenGL ES 2.0");
        }
        GLSurfaceView.EGLConfigChooser eglConfigChooser = getEglConfigChooser();
        if (Build.VERSION.SDK_INT <= 10 && this.config.useGLSurfaceView20API18) {
            GLSurfaceView20API18 gLSurfaceView20API18 = new GLSurfaceView20API18(androidApplicationBase.getContext(), resolutionStrategy);
            if (eglConfigChooser != null) {
                gLSurfaceView20API18.setEGLConfigChooser(eglConfigChooser);
            } else {
                gLSurfaceView20API18.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
            }
            gLSurfaceView20API18.setRenderer(this);
            return gLSurfaceView20API18;
        }
        GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20(androidApplicationBase.getContext(), resolutionStrategy, this.config.useGL30 ? 3 : 2);
        if (eglConfigChooser != null) {
            gLSurfaceView20.setEGLConfigChooser(eglConfigChooser);
        } else {
            gLSurfaceView20.setEGLConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil);
        }
        gLSurfaceView20.setRenderer(this);
        return gLSurfaceView20;
    }

    public void onPauseGLSurfaceView() {
        View view = this.view;
        if (view != null) {
            if (view instanceof GLSurfaceViewAPI18) {
                ((GLSurfaceViewAPI18) view).onPause();
            }
            View view2 = this.view;
            if (view2 instanceof GLSurfaceView) {
                ((GLSurfaceView) view2).onPause();
            }
        }
    }

    public void onResumeGLSurfaceView() {
        View view = this.view;
        if (view != null) {
            if (view instanceof GLSurfaceViewAPI18) {
                ((GLSurfaceViewAPI18) view).onResume();
            }
            View view2 = this.view;
            if (view2 instanceof GLSurfaceView) {
                ((GLSurfaceView) view2).onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GLSurfaceView.EGLConfigChooser getEglConfigChooser() {
        return new GdxEglConfigChooser(this.config.r, this.config.g, this.config.b, this.config.a, this.config.depth, this.config.stencil, this.config.numSamples);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updatePpi() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.app.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.ppiX = displayMetrics.xdpi;
        this.ppiY = displayMetrics.ydpi;
        this.ppcX = displayMetrics.xdpi / 2.54f;
        this.ppcY = displayMetrics.ydpi / 2.54f;
        this.density = displayMetrics.density;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkGL20() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, new EGLConfig[10], 10, iArr);
        egl10.eglTerminate(eglGetDisplay);
        return iArr[0] > 0;
    }

    @Override // defpackage.ip
    public kg getGL20() {
        return this.gl20;
    }

    @Override // defpackage.ip
    public void setGL20(kg kgVar) {
        this.gl20 = kgVar;
        if (this.gl30 == null) {
            io.g = kgVar;
            io.h = kgVar;
        }
    }

    @Override // defpackage.ip
    public boolean isGL30Available() {
        return this.gl30 != null;
    }

    @Override // defpackage.ip
    public kh getGL30() {
        return this.gl30;
    }

    @Override // defpackage.ip
    public void setGL30(kh khVar) {
        this.gl30 = khVar;
        if (khVar != null) {
            this.gl20 = khVar;
            kg kgVar = this.gl20;
            io.g = kgVar;
            io.h = kgVar;
            io.i = khVar;
        }
    }

    @Override // defpackage.ip
    public int getHeight() {
        return this.height;
    }

    @Override // defpackage.ip
    public int getWidth() {
        return this.width;
    }

    @Override // defpackage.ip
    public int getBackBufferWidth() {
        return this.width;
    }

    @Override // defpackage.ip
    public int getBackBufferHeight() {
        return this.height;
    }

    protected void setupGL(GL10 gl10) {
        this.glVersion = new f(ij.a.Android, gl10.glGetString(7938), gl10.glGetString(7936), gl10.glGetString(7937));
        if (this.config.useGL30 && this.glVersion.a() > 2) {
            if (this.gl30 != null) {
                return;
            }
            AndroidGL30 androidGL30 = new AndroidGL30();
            this.gl30 = androidGL30;
            this.gl20 = androidGL30;
            kh khVar = this.gl30;
            io.g = khVar;
            io.h = khVar;
            io.i = khVar;
        } else if (this.gl20 != null) {
            return;
        } else {
            this.gl20 = new AndroidGL20();
            kg kgVar = this.gl20;
            io.g = kgVar;
            io.h = kgVar;
        }
        ij ijVar = io.a;
        ijVar.log(LOG_TAG, "OGL renderer: " + gl10.glGetString(7937));
        ij ijVar2 = io.a;
        ijVar2.log(LOG_TAG, "OGL vendor: " + gl10.glGetString(7936));
        ij ijVar3 = io.a;
        ijVar3.log(LOG_TAG, "OGL version: " + gl10.glGetString(7938));
        ij ijVar4 = io.a;
        ijVar4.log(LOG_TAG, "OGL extensions: " + gl10.glGetString(7939));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.width = i;
        this.height = i2;
        updatePpi();
        gl10.glViewport(0, 0, this.width, this.height);
        if (!this.created) {
            this.app.getApplicationListener().a();
            this.created = true;
            synchronized (this) {
                this.running = true;
            }
        }
        this.app.getApplicationListener().a(i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.eglContext = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        setupGL(gl10);
        logConfig(eGLConfig);
        updatePpi();
        kj.a(this.app);
        ko.invalidateAllTextures(this.app);
        kc.b(this.app);
        kp.b(this.app);
        com.badlogic.gdx.graphics.glutils.q.a(this.app);
        c.a(this.app);
        logManagedCachesStatus();
        Display defaultDisplay = this.app.getWindowManager().getDefaultDisplay();
        this.width = defaultDisplay.getWidth();
        this.height = defaultDisplay.getHeight();
        this.mean = new q(5);
        this.lastFrameTime = System.nanoTime();
        gl10.glViewport(0, 0, this.width, this.height);
    }

    protected void logConfig(EGLConfig eGLConfig) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        int attrib = getAttrib(egl10, eglGetDisplay, eGLConfig, 12324, 0);
        int attrib2 = getAttrib(egl10, eglGetDisplay, eGLConfig, 12323, 0);
        int attrib3 = getAttrib(egl10, eglGetDisplay, eGLConfig, 12322, 0);
        int attrib4 = getAttrib(egl10, eglGetDisplay, eGLConfig, 12321, 0);
        int attrib5 = getAttrib(egl10, eglGetDisplay, eGLConfig, 12325, 0);
        int attrib6 = getAttrib(egl10, eglGetDisplay, eGLConfig, 12326, 0);
        int max = Math.max(getAttrib(egl10, eglGetDisplay, eGLConfig, 12337, 0), getAttrib(egl10, eglGetDisplay, eGLConfig, GdxEglConfigChooser.EGL_COVERAGE_SAMPLES_NV, 0));
        boolean z = getAttrib(egl10, eglGetDisplay, eGLConfig, GdxEglConfigChooser.EGL_COVERAGE_SAMPLES_NV, 0) != 0;
        ij ijVar = io.a;
        ijVar.log(LOG_TAG, "framebuffer: (" + attrib + ", " + attrib2 + ", " + attrib3 + ", " + attrib4 + ")");
        ij ijVar2 = io.a;
        StringBuilder sb = new StringBuilder();
        sb.append("depthbuffer: (");
        sb.append(attrib5);
        sb.append(")");
        ijVar2.log(LOG_TAG, sb.toString());
        ij ijVar3 = io.a;
        ijVar3.log(LOG_TAG, "stencilbuffer: (" + attrib6 + ")");
        ij ijVar4 = io.a;
        ijVar4.log(LOG_TAG, "samples: (" + max + ")");
        ij ijVar5 = io.a;
        ijVar5.log(LOG_TAG, "coverage sampling: (" + z + ")");
        this.bufferFormat = new ip.a(attrib, attrib2, attrib3, attrib4, attrib5, attrib6, max, z);
    }

    private int getAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.value) ? this.value[0] : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        synchronized (this.synch) {
            this.running = true;
            this.resume = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        synchronized (this.synch) {
            if (this.running) {
                this.running = false;
                this.pause = true;
                while (this.pause) {
                    try {
                        this.synch.wait(4000L);
                        if (this.pause) {
                            io.a.error(LOG_TAG, "waiting for pause synchronization took too long; assuming deadlock and killing");
                            Process.killProcess(Process.myPid());
                        }
                    } catch (InterruptedException unused) {
                        io.a.log(LOG_TAG, "waiting for pause synchronization failed!");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        synchronized (this.synch) {
            this.running = false;
            this.destroy = true;
            while (this.destroy) {
                try {
                    this.synch.wait();
                } catch (InterruptedException unused) {
                    io.a.log(LOG_TAG, "waiting for destroy synchronization failed!");
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
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
            ai<iu> lifecycleListeners = this.app.getLifecycleListeners();
            synchronized (lifecycleListeners) {
                iu[] f = lifecycleListeners.f();
                int i = lifecycleListeners.b;
                for (int i2 = 0; i2 < i; i2++) {
                    f[i2].resume();
                }
                lifecycleListeners.g();
            }
            this.app.getApplicationListener().o_();
            io.a.log(LOG_TAG, "resumed");
        }
        if (z) {
            synchronized (this.app.getRunnables()) {
                this.app.getExecutedRunnables().d();
                this.app.getExecutedRunnables().a(this.app.getRunnables());
                this.app.getRunnables().d();
            }
            for (int i3 = 0; i3 < this.app.getExecutedRunnables().b; i3++) {
                try {
                    this.app.getExecutedRunnables().a(i3).run();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.app.getInput().processEvents();
            this.frameId++;
            this.app.getApplicationListener().q_();
        }
        if (z2) {
            ai<iu> lifecycleListeners2 = this.app.getLifecycleListeners();
            synchronized (lifecycleListeners2) {
                iu[] f2 = lifecycleListeners2.f();
                int i4 = lifecycleListeners2.b;
                for (int i5 = 0; i5 < i4; i5++) {
                    f2[i5].pause();
                }
            }
            this.app.getApplicationListener().p_();
            io.a.log(LOG_TAG, "paused");
        }
        if (z3) {
            ai<iu> lifecycleListeners3 = this.app.getLifecycleListeners();
            synchronized (lifecycleListeners3) {
                iu[] f3 = lifecycleListeners3.f();
                int i6 = lifecycleListeners3.b;
                for (int i7 = 0; i7 < i6; i7++) {
                    f3[i7].dispose();
                }
            }
            this.app.getApplicationListener().dispose();
            io.a.log(LOG_TAG, "destroyed");
        }
        if (nanoTime - this.frameStart > 1000000000) {
            this.fps = this.frames;
            this.frames = 0;
            this.frameStart = nanoTime;
        }
        this.frames++;
    }

    public long getFrameId() {
        return this.frameId;
    }

    @Override // defpackage.ip
    public float getDeltaTime() {
        return this.mean.c() == 0.0f ? this.deltaTime : this.mean.c();
    }

    public float getRawDeltaTime() {
        return this.deltaTime;
    }

    public ip.c getType() {
        return ip.c.AndroidGL;
    }

    public f getGLVersion() {
        return this.glVersion;
    }

    @Override // defpackage.ip
    public int getFramesPerSecond() {
        return this.fps;
    }

    public void clearManagedCaches() {
        kj.b(this.app);
        ko.clearAllTextures(this.app);
        kc.a(this.app);
        kp.a(this.app);
        com.badlogic.gdx.graphics.glutils.q.b(this.app);
        c.b(this.app);
        logManagedCachesStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logManagedCachesStatus() {
        io.a.log(LOG_TAG, kj.i());
        io.a.log(LOG_TAG, ko.getManagedStatus());
        io.a.log(LOG_TAG, kc.b());
        io.a.log(LOG_TAG, com.badlogic.gdx.graphics.glutils.q.f());
        io.a.log(LOG_TAG, c.c());
    }

    public View getView() {
        return this.view;
    }

    public float getPpiX() {
        return this.ppiX;
    }

    public float getPpiY() {
        return this.ppiY;
    }

    public float getPpcX() {
        return this.ppcX;
    }

    public float getPpcY() {
        return this.ppcY;
    }

    public float getDensity() {
        return this.density;
    }

    public ip.d getPrimaryMonitor() {
        return new AndroidMonitor(0, 0, "Primary Monitor");
    }

    public ip.d getMonitor() {
        return getPrimaryMonitor();
    }

    public ip.d[] getMonitors() {
        return new ip.d[]{getPrimaryMonitor()};
    }

    public ip.b[] getDisplayModes(ip.d dVar) {
        return getDisplayModes();
    }

    public ip.b getDisplayMode(ip.d dVar) {
        return getDisplayMode();
    }

    public ip.b[] getDisplayModes() {
        return new ip.b[]{getDisplayMode()};
    }

    public void setUndecorated(boolean z) {
        this.app.getApplicationWindow().setFlags(1024, z ? 1 : 0);
    }

    @Override // defpackage.ip
    public ip.b getDisplayMode() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.app.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new AndroidDisplayMode(displayMetrics.widthPixels, displayMetrics.heightPixels, 0, 0);
    }

    public ip.a getBufferFormat() {
        return this.bufferFormat;
    }

    @Override // defpackage.ip
    public boolean supportsExtension(String str) {
        if (this.extensions == null) {
            this.extensions = io.g.glGetString(7939);
        }
        return this.extensions.contains(str);
    }

    public void setContinuousRendering(boolean z) {
        if (this.view != null) {
            this.isContinuous = enforceContinuousRendering || z;
            boolean z2 = this.isContinuous;
            View view = this.view;
            if (view instanceof GLSurfaceViewAPI18) {
                ((GLSurfaceViewAPI18) view).setRenderMode(z2 ? 1 : 0);
            }
            View view2 = this.view;
            if (view2 instanceof GLSurfaceView) {
                ((GLSurfaceView) view2).setRenderMode(z2 ? 1 : 0);
            }
            this.mean.b();
        }
    }

    @Override // defpackage.ip
    public boolean isContinuousRendering() {
        return this.isContinuous;
    }

    @Override // defpackage.ip
    public void requestRendering() {
        View view = this.view;
        if (view != null) {
            if (view instanceof GLSurfaceViewAPI18) {
                ((GLSurfaceViewAPI18) view).requestRender();
            }
            View view2 = this.view;
            if (view2 instanceof GLSurfaceView) {
                ((GLSurfaceView) view2).requestRender();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AndroidDisplayMode extends ip.b {
        protected AndroidDisplayMode(int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AndroidMonitor extends ip.d {
        public AndroidMonitor(int i, int i2, String str) {
            super(i, i2, str);
        }
    }
}
