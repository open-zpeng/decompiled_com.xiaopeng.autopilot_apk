package com.xiaopeng.autopilot.camera.view;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.Iterator;
/* compiled from: CameraSurfaceView.java */
/* loaded from: classes.dex */
public class a extends SurfaceView implements SurfaceHolder.Callback {
    private static volatile Camera a;
    private static boolean c;
    private SurfaceHolder b;
    private int d;
    private c e;
    private b f;
    private InterfaceC0054a g;
    private float[] h;
    private Object i;

    /* compiled from: CameraSurfaceView.java */
    /* renamed from: com.xiaopeng.autopilot.camera.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0054a {
        void a(float f, float f2);
    }

    /* compiled from: CameraSurfaceView.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: CameraSurfaceView.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(boolean z);

        void b();

        void c();
    }

    public a() {
        super(com.xiaopeng.autopilot.base.a.g());
        this.d = 2;
        this.h = new float[2];
        this.i = new Object();
        d();
    }

    private void d() {
        LogUtils.i("CameraSurfaceView", "Camera amount=" + Camera.getNumberOfCameras());
        this.b = getHolder();
        this.b.setFormat(-3);
        this.b.setType(3);
        this.b.addCallback(this);
        setClickable(true);
    }

    public void set2StartPreview(final boolean z) {
        LogUtils.i("CameraSurfaceView", "set2StartPreview --> needAddRetry=" + z);
        rh.a().a(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.a.1
            private Handler c = new Handler(Looper.myLooper());

            @Override // java.lang.Runnable
            public void run() {
                LogUtils.i("CameraSurfaceView", "set2StartPreview execute Runnable(), run preview 任务");
                synchronized (a.this.i) {
                    LogUtils.i("CameraSurfaceView", "set2StartPreview synchronized (mCameraLock), 获取同步锁，ok");
                    if (a.this.isAttachedToWindow() && a.this.b.getSurface().isValid()) {
                        LogUtils.i("CameraSurfaceView", "set2StartPreview surface ok ");
                        if (a.a == null) {
                            LogUtils.i("CameraSurfaceView", "set2StartPreview current sCamera==null ");
                            try {
                                Camera unused = a.a = Camera.open(a.this.d);
                                LogUtils.i("CameraSurfaceView", "Camera open success");
                                a.this.e.a();
                                a();
                            } catch (Exception e) {
                                LogUtils.i("CameraSurfaceView", "Camera open Exception-->" + e.getMessage());
                                e.printStackTrace();
                                if (a.this.e != null) {
                                    LogUtils.i("CameraSurfaceView", "onError() needAddRetry =" + z);
                                    a.this.e.a(z);
                                }
                            }
                        } else {
                            a();
                        }
                    } else {
                        LogUtils.i("CameraSurfaceView", "set2StartPreview Runnable 中断,  isAttachedToWindow()=" + a.this.isAttachedToWindow() + "， mSurfaceHolder.getSurface().isValid()=" + a.this.b.getSurface().isValid());
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                LogUtils.i("CameraSurfaceView", "doPreview() sIsPreview-->" + a.c);
                LogUtils.i("CameraSurfaceView", "doPreview() sCamera-->" + a.a);
                if (!a.c) {
                    if (a.a == null) {
                        if (a.this.e != null) {
                            LogUtils.i("CameraSurfaceView", "onPreviewFail(),  Camera startPreview fail, sCamera has been destroy");
                            a.this.e.c();
                            return;
                        }
                        return;
                    }
                    try {
                        b();
                        a.a.setPreviewDisplay(a.this.b);
                        a.a.startPreview();
                        LogUtils.i("CameraSurfaceView", "Camera startPreview success");
                        boolean unused = a.c = true;
                        if (a.this.e != null) {
                            a.this.e.b();
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        LogUtils.i("CameraSurfaceView", "Camera doPreview() Exception-->" + e.getMessage());
                        e.printStackTrace();
                        return;
                    }
                }
                if (a.a != null) {
                    a.a.stopPreview();
                }
                boolean unused2 = a.c = false;
                LogUtils.i("CameraSurfaceView", "doPreview() 停止preview，mThreadHandler.post（重新doPreview()）");
                this.c.post(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a();
                    }
                });
            }

            private void b() {
                LogUtils.i("CameraSurfaceView", "resetCameraParameters()");
                Camera unused = a.a;
                Camera.Parameters parameters = a.a.getParameters();
                if (parameters == null) {
                    LogUtils.i("CameraSurfaceView", "resetCameraParameters()，parameters = null");
                    return;
                }
                Iterator<Camera.Size> it = parameters.getSupportedPreviewSizes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next = it.next();
                    LogUtils.i("CameraSurfaceView", "getSupportedPreviewSizes() = " + next.width + "x" + next.height);
                    if (next.width == 1280 && next.height == 720) {
                        LogUtils.i("CameraSurfaceView", "setPreviewSize()， " + next.width + "x" + next.height);
                        parameters.setPreviewSize(1280, 720);
                        break;
                    }
                }
                a.a.setParameters(parameters);
                a.a.setErrorCallback(new Camera.ErrorCallback() { // from class: com.xiaopeng.autopilot.camera.view.a.1.2
                    @Override // android.hardware.Camera.ErrorCallback
                    public void onError(int i, Camera camera) {
                        LogUtils.i("CameraSurfaceView", "Camera.ErrorCallback ，i = " + i + ", sCamera = " + a.a + ", sIsPreview = " + a.c);
                    }
                });
            }
        });
    }

    public void a() {
        LogUtils.i("CameraSurfaceView", "releaseCamera --> ");
        rh.a().a(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.i) {
                    if (a.a != null) {
                        LogUtils.i("CameraSurfaceView", "releaseCamera");
                        a.a.stopPreview();
                        boolean unused = a.c = false;
                        a.a.setPreviewCallback(null);
                        a.a.setErrorCallback(null);
                        a.a.release();
                        Camera unused2 = a.a = null;
                    }
                    LogUtils.i("CameraSurfaceView", "releaseCamera over.");
                    if (a.this.f != null) {
                        a.this.f.a();
                    }
                }
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        LogUtils.i("CameraSurfaceView", "surfaceCreated");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtils.i("CameraSurfaceView", "surfaceChanged");
        if (this.b.getSurface() == null) {
            return;
        }
        set2StartPreview(false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtils.i("CameraSurfaceView", "surfaceDestroyed");
        a();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.h[0] = motionEvent.getX();
            this.h[1] = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        InterfaceC0054a interfaceC0054a = this.g;
        if (interfaceC0054a != null) {
            float[] fArr = this.h;
            interfaceC0054a.a(fArr[0], fArr[1]);
        }
        return super.performClick();
    }

    public static Camera getCamera() {
        return a;
    }

    public void setOnPreviewListener(c cVar) {
        LogUtils.i("CameraSurfaceView", "setOnPreviewListener, " + cVar.toString());
        this.e = cVar;
    }

    public void setOnCameraReleaseListener(b bVar) {
        LogUtils.i("CameraSurfaceView", "setOnCameraReleaseListener, " + bVar.toString());
        this.f = bVar;
    }

    public void setOnCameraClickListener(InterfaceC0054a interfaceC0054a) {
        this.g = interfaceC0054a;
    }
}
