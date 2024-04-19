package com.badlogic.gdx.backends.android;

import android.os.Build;
import android.view.Display;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20API18;
import com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.graphics.glutils.c;
import com.badlogic.gdx.graphics.glutils.f;
import com.badlogic.gdx.graphics.glutils.q;
import defpackage.ij;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class AndroidGraphicsEx extends AndroidGraphics {
    private static final String LOG_TAG = "AndroidGraphicsEx";

    public AndroidGraphicsEx(AndroidApplicationBase androidApplicationBase, AndroidApplicationConfiguration androidApplicationConfiguration, ResolutionStrategy resolutionStrategy) {
        super(androidApplicationBase, androidApplicationConfiguration, resolutionStrategy);
    }

    public AndroidGraphicsEx(AndroidApplicationBase androidApplicationBase, AndroidApplicationConfiguration androidApplicationConfiguration, ResolutionStrategy resolutionStrategy, boolean z) {
        super(androidApplicationBase, androidApplicationConfiguration, resolutionStrategy, z);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.eglContext = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        setupGL(gl10);
        logConfig(eGLConfig);
        updatePpi();
        kj.a(this.app);
        ko.invalidateAllTextures(this.app);
        kc.b(this.app);
        kp.b(this.app);
        q.a(this.app);
        c.a(this.app);
        logManagedCachesStatus();
        Display defaultDisplay = this.app.getWindowManager().getDefaultDisplay();
        this.width = defaultDisplay.getWidth();
        this.height = defaultDisplay.getHeight();
        this.mean = new com.badlogic.gdx.math.q(5);
        this.lastFrameTime = System.nanoTime();
        gl10.glViewport(0, 0, this.width, this.height);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
    protected void preserveEGLContextOnPause() {
        if ((Build.VERSION.SDK_INT < 11 || !(this.view instanceof GLSurfaceView20)) && !(this.view instanceof GLSurfaceView20API18)) {
            return;
        }
        try {
            this.view.getClass().getMethod("setPreserveEGLContextOnPause", Boolean.TYPE).invoke(this.view, true);
        } catch (Exception unused) {
            abz.a().a.log(LOG_TAG, "Method GLSurfaceView.setPreserveEGLContextOnPause not found");
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics, defpackage.ip
    public void setGL20(kg kgVar) {
        this.gl20 = kgVar;
        if (this.gl30 == null) {
            abz.a().g = kgVar;
            abz.a().h = kgVar;
            super.setGL20(kgVar);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics, defpackage.ip
    public void setGL30(kh khVar) {
        this.gl30 = khVar;
        if (khVar != null) {
            this.gl20 = khVar;
            abz.a().g = this.gl20;
            abz.a().h = this.gl20;
            abz.a().i = khVar;
            super.setGL30(khVar);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
    protected void setupGL(GL10 gl10) {
        this.glVersion = new f(ij.a.Android, gl10.glGetString(7938), gl10.glGetString(7936), gl10.glGetString(7937));
        if (this.config.useGL30 && this.glVersion.a() > 2) {
            if (this.gl30 != null) {
                return;
            }
            AndroidGL30 androidGL30 = new AndroidGL30();
            this.gl30 = androidGL30;
            this.gl20 = androidGL30;
            abz.a().g = this.gl30;
            abz.a().h = this.gl30;
            abz.a().i = this.gl30;
            io.g = this.gl30;
            io.h = this.gl30;
            io.i = this.gl30;
        } else if (this.gl20 != null) {
            return;
        } else {
            this.gl20 = new AndroidGL20();
            abz.a().g = this.gl20;
            abz.a().h = this.gl20;
            io.g = this.gl20;
            io.h = this.gl20;
        }
        ij ijVar = abz.a().a;
        ijVar.log(LOG_TAG, "OGL renderer: " + gl10.glGetString(7937));
        ij ijVar2 = abz.a().a;
        ijVar2.log(LOG_TAG, "OGL vendor: " + gl10.glGetString(7936));
        ij ijVar3 = abz.a().a;
        ijVar3.log(LOG_TAG, "OGL version: " + gl10.glGetString(7938));
        ij ijVar4 = abz.a().a;
        ijVar4.log(LOG_TAG, "OGL extensions: " + gl10.glGetString(7939));
    }

    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
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
        ij ijVar = abz.a().a;
        ijVar.log(LOG_TAG, "framebuffer: (" + attrib + ", " + attrib2 + ", " + attrib3 + ", " + attrib4 + ")");
        ij ijVar2 = abz.a().a;
        StringBuilder sb = new StringBuilder();
        sb.append("depthbuffer: (");
        sb.append(attrib5);
        sb.append(")");
        ijVar2.log(LOG_TAG, sb.toString());
        ij ijVar3 = abz.a().a;
        ijVar3.log(LOG_TAG, "stencilbuffer: (" + attrib6 + ")");
        ij ijVar4 = abz.a().a;
        ijVar4.log(LOG_TAG, "samples: (" + max + ")");
        ij ijVar5 = abz.a().a;
        ijVar5.log(LOG_TAG, "coverage sampling: (" + z + ")");
    }

    private int getAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.value) ? this.value[0] : i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.badlogic.gdx.backends.android.AndroidGraphics
    public void logManagedCachesStatus() {
        abz.a().a.log(LOG_TAG, kj.i());
        abz.a().a.log(LOG_TAG, ko.getManagedStatus());
        abz.a().a.log(LOG_TAG, kc.b());
        abz.a().a.log(LOG_TAG, q.f());
        abz.a().a.log(LOG_TAG, c.c());
    }
}
