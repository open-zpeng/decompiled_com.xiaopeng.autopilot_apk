package com.badlogic.gdx.backends.android.surfaceview;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class GLSurfaceViewAPI18 extends SurfaceView implements SurfaceHolder.Callback {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceViewAPI18";
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private int mDebugFlags;
    private boolean mDetached;
    private GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private GLSurfaceView.Renderer mRenderer;
    private final WeakReference<GLSurfaceViewAPI18> mThisWeakRef;

    /* loaded from: classes.dex */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes.dex */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: classes.dex */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    public GLSurfaceViewAPI18(Context context) {
        super(context);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    public GLSurfaceViewAPI18(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        if (Build.VERSION.SDK_INT <= 8) {
            holder.setFormat(4);
        }
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(z));
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            this.mGLThread = new GLThread(this.mThisWeakRef);
            if (renderMode != 1) {
                this.mGLThread.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* loaded from: classes.dex */
    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceViewAPI18.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLSurfaceViewAPI18.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* loaded from: classes.dex */
    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(GLSurfaceViewAPI18.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes.dex */
    private abstract class BaseConfigChooser implements GLSurfaceView.EGLConfigChooser {
        protected int[] mConfigSpec;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig != null) {
                return chooseConfig;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLSurfaceViewAPI18.this.mEGLContextClientVersion != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* loaded from: classes.dex */
    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mValue = new int[1];
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLSurfaceViewAPI18.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }
    }

    /* loaded from: classes.dex */
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLSurfaceViewAPI18> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLSurfaceViewAPI18> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLSurfaceViewAPI18 gLSurfaceViewAPI18 = this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceViewAPI18 != null) {
                this.mEglConfig = gLSurfaceViewAPI18.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                this.mEglContext = gLSurfaceViewAPI18.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            } else {
                this.mEglConfig = null;
                this.mEglContext = null;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.mEglSurface = null;
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurfaceImp();
            GLSurfaceViewAPI18 gLSurfaceViewAPI18 = this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceViewAPI18 != null) {
                this.mEglSurface = gLSurfaceViewAPI18.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLSurfaceViewAPI18.getHolder());
            } else {
                this.mEglSurface = null;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.mEgl.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            EGL10 egl10 = this.mEgl;
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                return true;
            }
            logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
            return false;
        }

        GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLSurfaceViewAPI18 gLSurfaceViewAPI18 = this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceViewAPI18 != null) {
                if (gLSurfaceViewAPI18.mGLWrapper != null) {
                    gl = gLSurfaceViewAPI18.mGLWrapper.wrap(gl);
                }
                if ((gLSurfaceViewAPI18.mDebugFlags & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (gLSurfaceViewAPI18.mDebugFlags & 1) != 0 ? 1 : 0, (gLSurfaceViewAPI18.mDebugFlags & 2) != 0 ? new LogWriter() : null);
                }
                return gl;
            }
            return gl;
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLSurfaceViewAPI18 gLSurfaceViewAPI18 = this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceViewAPI18 != null) {
                gLSurfaceViewAPI18.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public void finish() {
            if (this.mEglContext != null) {
                GLSurfaceViewAPI18 gLSurfaceViewAPI18 = this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceViewAPI18 != null) {
                    gLSurfaceViewAPI18.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        private static String getErrorString(int i) {
            switch (i) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return "0x" + Integer.toHexString(i);
            }
        }

        public static String formatEglError(String str, int i) {
            return str + " failed: " + getErrorString(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLSurfaceViewAPI18> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean mSizeChanged = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;

        GLThread(WeakReference<GLSurfaceViewAPI18> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLSurfaceViewAPI18.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLSurfaceViewAPI18.sGLThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLSurfaceViewAPI18.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void guardedRun() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            this.mEglHelper = new EglHelper(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int i = 0;
            int i2 = 0;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            GL10 gl10 = null;
            Runnable runnable = null;
            while (true) {
                try {
                    synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                        while (!this.mShouldExit) {
                            if (!this.mEventQueue.isEmpty()) {
                                runnable = this.mEventQueue.remove(0);
                                z = false;
                            } else {
                                if (this.mPaused != this.mRequestPaused) {
                                    z3 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                } else {
                                    z3 = false;
                                }
                                if (this.mShouldReleaseEglContext) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    z8 = true;
                                }
                                if (z6) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    z6 = false;
                                }
                                if (z3 && this.mHaveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                if (z3 && this.mHaveEglContext) {
                                    GLSurfaceViewAPI18 gLSurfaceViewAPI18 = this.mGLSurfaceViewWeakRef.get();
                                    if (!(gLSurfaceViewAPI18 == null ? false : gLSurfaceViewAPI18.mPreserveEGLContextOnPause) || GLSurfaceViewAPI18.sGLThreadManager.shouldReleaseEGLContextWhenPausing()) {
                                        stopEglContextLocked();
                                    }
                                }
                                if (z3 && GLSurfaceViewAPI18.sGLThreadManager.shouldTerminateEGLWhenPausing()) {
                                    this.mEglHelper.finish();
                                }
                                if (!this.mHasSurface && !this.mWaitingForSurface) {
                                    if (this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                        z5 = true;
                                    } else {
                                        z5 = true;
                                    }
                                    this.mWaitingForSurface = z5;
                                    this.mSurfaceIsBad = false;
                                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                }
                                if (z7) {
                                    this.mRenderComplete = true;
                                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                    z7 = false;
                                    z13 = false;
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z8) {
                                            z8 = false;
                                        } else if (GLSurfaceViewAPI18.sGLThreadManager.tryAcquireEglContextLocked(this)) {
                                            try {
                                                this.mEglHelper.start();
                                                this.mHaveEglContext = true;
                                                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                                z9 = true;
                                            } catch (RuntimeException e) {
                                                GLSurfaceViewAPI18.sGLThreadManager.releaseEglContextLocked(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.mHaveEglContext || this.mHaveEglSurface) {
                                        z4 = z10;
                                    } else {
                                        this.mHaveEglSurface = true;
                                        z4 = true;
                                        z11 = true;
                                        z12 = true;
                                    }
                                    if (this.mHaveEglSurface) {
                                        if (this.mSizeChanged) {
                                            i = this.mWidth;
                                            i2 = this.mHeight;
                                            z = false;
                                            this.mSizeChanged = false;
                                            z4 = true;
                                            z12 = true;
                                            z13 = true;
                                        } else {
                                            z = false;
                                        }
                                        this.mRequestRender = z;
                                        GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                        z10 = z4;
                                    } else {
                                        z10 = z4;
                                    }
                                }
                                GLSurfaceViewAPI18.sGLThreadManager.wait();
                            }
                        }
                        synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                        }
                        return;
                    }
                    if (runnable != null) {
                        runnable.run();
                        runnable = null;
                    } else {
                        if (z10) {
                            if (this.mEglHelper.createSurface()) {
                                synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                                    this.mFinishedCreatingEglSurface = true;
                                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                }
                                z10 = z;
                            } else {
                                synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                                    this.mFinishedCreatingEglSurface = true;
                                    this.mSurfaceIsBad = true;
                                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                                }
                            }
                        }
                        if (z11) {
                            GL10 gl102 = (GL10) this.mEglHelper.createGL();
                            GLSurfaceViewAPI18.sGLThreadManager.checkGLDriver(gl102);
                            gl10 = gl102;
                            z11 = z;
                        }
                        if (z9) {
                            GLSurfaceViewAPI18 gLSurfaceViewAPI182 = this.mGLSurfaceViewWeakRef.get();
                            if (gLSurfaceViewAPI182 != null) {
                                gLSurfaceViewAPI182.mRenderer.onSurfaceCreated(gl10, this.mEglHelper.mEglConfig);
                            }
                            z9 = z;
                        }
                        if (z12) {
                            GLSurfaceViewAPI18 gLSurfaceViewAPI183 = this.mGLSurfaceViewWeakRef.get();
                            if (gLSurfaceViewAPI183 != null) {
                                gLSurfaceViewAPI183.mRenderer.onSurfaceChanged(gl10, i, i2);
                            }
                            z12 = z;
                        }
                        GLSurfaceViewAPI18 gLSurfaceViewAPI184 = this.mGLSurfaceViewWeakRef.get();
                        if (gLSurfaceViewAPI184 != null) {
                            gLSurfaceViewAPI184.mRenderer.onDrawFrame(gl10);
                        }
                        int swap = this.mEglHelper.swap();
                        if (swap == 12288) {
                            z2 = true;
                        } else if (swap != 12302) {
                            EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", swap);
                            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                                z2 = true;
                                this.mSurfaceIsBad = true;
                                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                            }
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        if (z13) {
                            z7 = z2;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                    this.mRenderMode = i;
                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mRequestRender = true;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        GLSurfaceViewAPI18.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mHasSurface = false;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        GLSurfaceViewAPI18.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mRequestPaused = true;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        GLSurfaceViewAPI18.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        GLSurfaceViewAPI18.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        GLSurfaceViewAPI18.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                this.mShouldExit = true;
                GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        GLSurfaceViewAPI18.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLSurfaceViewAPI18.sGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    GLSurfaceViewAPI18.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v("GLSurfaceView", this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread gLThread) {
            gLThread.mExited = true;
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
            GLThread gLThread2 = this.mEglOwner;
            if (gLThread2 == gLThread || gLThread2 == null) {
                this.mEglOwner = gLThread;
                notifyAll();
                return true;
            }
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed) {
                return true;
            }
            GLThread gLThread3 = this.mEglOwner;
            if (gLThread3 != null) {
                gLThread3.requestReleaseEglContextLocked();
                return false;
            }
            return false;
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void checkGLDriver(GL10 gl10) {
            if (!this.mGLESDriverCheckComplete) {
                checkGLESVersion();
                String glGetString = gl10.glGetString(7937);
                if (this.mGLESVersion < kGLES_20) {
                    this.mMultipleGLESContextsAllowed = !glGetString.startsWith(kMSM7K_RENDERER_PREFIX);
                    notifyAll();
                }
                this.mLimitedGLESContexts = this.mMultipleGLESContextsAllowed ? false : true;
                this.mGLESDriverCheckComplete = true;
            }
        }

        private void checkGLESVersion() {
            if (this.mGLESVersionCheckComplete) {
                return;
            }
            this.mGLESVersion = kGLES_20;
            if (this.mGLESVersion >= kGLES_20) {
                this.mMultipleGLESContextsAllowed = true;
            }
            this.mGLESVersionCheckComplete = true;
        }
    }
}
