package com.xiaopeng.autopilot.camera.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraStateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraXPilotEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.RetryReleaseCameraEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.camera.view.a;
import com.xiaopeng.autopilot.x.protocol.bean.eventbus.IpcRouterEvent;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.watchers.XTouchAreaWatcher;
import com.xiaopeng.xui.widget.XButton;
import defpackage.rp;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class CameraView extends RelativeLayout implements b, ThemeWatcher.OnThemeSwitchListener {
    private rt a;
    private a b;
    private d c;
    private XButton d;
    private TextClock e;
    private View f;
    private XTouchAreaWatcher g;
    private long h;
    private int i;
    private XButton j;
    private ValueAnimator k;
    private ValueAnimator l;
    private ValueAnimator m;
    private boolean n;
    private boolean o;
    private c p;
    private Handler q;
    private Runnable r;

    static /* synthetic */ int g(CameraView cameraView) {
        int i = cameraView.i;
        cameraView.i = i + 1;
        return i;
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = true;
        this.o = false;
        this.q = new Handler(Looper.getMainLooper());
        this.r = new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.5
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.i("CameraView", "post(new RetryReleaseCameraEvent())");
                org.greenrobot.eventbus.c.a().d(new RetryReleaseCameraEvent());
            }
        };
        g();
        h();
    }

    private void g() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(rp.c.layout_camera_view, (ViewGroup) this, true);
        d();
        this.d = (XButton) findViewById(rp.b.camera_type_change_view);
        this.e = (TextClock) findViewById(rp.b.debug_text_clock);
        LogUtils.i("CameraView", "Constant.isXPilot3() = " + com.xiaopeng.autopilot.base.d.n());
        com.xiaopeng.autopilot.base.d.n();
    }

    @m
    public void onEvent(final CameraStateEvent cameraStateEvent) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.6
            @Override // java.lang.Runnable
            public void run() {
                int i = cameraStateEvent.mState;
                Log.i("CameraView", "onCameraAnimationState.state = " + i);
                if (i != 1) {
                    if (i == 2) {
                        if (CameraView.this.k != null && CameraView.this.k.isRunning()) {
                            CameraView.this.k.cancel();
                        }
                        if (CameraView.this.m != null && CameraView.this.m.isRunning()) {
                            CameraView.this.m.cancel();
                        }
                        if (CameraView.this.a()) {
                            CameraView.this.b(872.0f, 1822.0f);
                            return;
                        } else if (CameraView.this.c()) {
                            CameraView.this.b(1422.0f, 1822.0f);
                            return;
                        } else {
                            return;
                        }
                    } else if (i == 3) {
                        if (CameraView.this.k != null && CameraView.this.k.isRunning()) {
                            CameraView.this.k.cancel();
                        }
                        if (CameraView.this.l != null && CameraView.this.l.isRunning()) {
                            CameraView.this.l.cancel();
                        }
                        if (CameraView.this.a()) {
                            CameraView.this.c(872.0f, 1422.0f);
                            return;
                        } else if (CameraView.this.b()) {
                            CameraView.this.c(1822.0f, 1422.0f);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                boolean booleanValue = ((i.e) i.a(i.e.class)).d().booleanValue();
                i.ad adVar = (i.ad) i.a(i.ad.class);
                int intValue = adVar.d().intValue();
                Log.i("CameraView", "onCameraAnimationState.apHasActive = " + booleanValue + "," + CameraView.this.o + "," + adVar);
                if (CameraView.this.o || !booleanValue || intValue == -3 || intValue == -12 || intValue == -13) {
                    int intValue2 = ((i.y) i.a(i.y.class)).d().intValue();
                    Log.i("CameraView", "onCameraAnimationState.pageVisible = " + intValue2);
                    if (intValue2 != 2 || CarApiUtil.getGear() == 3) {
                        if (CameraView.this.l != null && CameraView.this.l.isRunning()) {
                            CameraView.this.l.cancel();
                        }
                        if (CameraView.this.m != null && CameraView.this.m.isRunning()) {
                            CameraView.this.m.cancel();
                        }
                        if (CameraView.this.b()) {
                            CameraView.this.a(1822.0f, 872.0f);
                        } else if (CameraView.this.c()) {
                            CameraView.this.a(1422.0f, 872.0f);
                        }
                    }
                }
            }
        });
    }

    public void a(float f, final float f2) {
        a(rf.a(com.xiaopeng.autopilot.base.a.g()).a(), true, true);
        ValueAnimator valueAnimator = this.k;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !a()) {
            XButton xButton = this.j;
            if (xButton != null) {
                xButton.setBackgroundResource(rp.d.parking_avm_in);
            }
            LogUtils.i("CameraView", "onAnimatorLeft.startX = " + f + ",endX = " + f2);
            this.k = ValueAnimator.ofFloat(f, f2);
            this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CameraView.this.setX(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
            this.k.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Log.i("CameraView", "mLeftAnimator.onAnimationStart");
                    i.a(i.l.class, 3);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Log.i("CameraView", "mLeftAnimator.onAnimationEnd");
                    CameraView.this.o = false;
                    if (CameraView.this.p != null) {
                        CameraView.this.p.a(CameraView.this.o);
                    }
                    CameraView.this.setX(f2);
                    i.a(i.l.class, 1);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.i("CameraView", "mLeftAnimator.onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Log.i("CameraView", "mLeftAnimator.onAnimationRepeat");
                }
            });
            this.k.setDuration(1000L);
            this.k.start();
        }
    }

    public void b(float f, final float f2) {
        a(1, true, true);
        ValueAnimator valueAnimator = this.l;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !b()) {
            XButton xButton = this.j;
            if (xButton != null) {
                xButton.setBackgroundResource(rp.d.parking_avm_out);
            }
            LogUtils.i("CameraView", "onAnimatorRight.startX = " + f + ",endX = " + f2);
            this.l = ValueAnimator.ofFloat(f, f2);
            this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CameraView.this.setX(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
            this.l.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.10
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Log.i("CameraView", "mRightAnimator.onAnimationStart");
                    i.a(i.l.class, 3);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Log.i("CameraView", "mRightAnimator.onAnimationEnd");
                    CameraView.this.setX(f2);
                    i.a(i.l.class, 2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.i("CameraView", "mRightAnimator.onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Log.i("CameraView", "mRightAnimator.onAnimationRepeat");
                }
            });
            this.l.setDuration(1000L);
            this.l.start();
        }
    }

    public void c(float f, final float f2) {
        ValueAnimator valueAnimator = this.m;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !c()) {
            XButton xButton = this.j;
            if (xButton != null) {
                xButton.setBackgroundResource(rp.d.parking_avm_out);
            }
            LogUtils.i("CameraView", "onFinishReadyAnimatorRight.startX = " + f + ",endX = " + f2);
            this.m = ValueAnimator.ofFloat(f, f2);
            this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.11
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CameraView.this.setX(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
            this.m.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.12
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Log.i("CameraView", "mFinishReadyRightAnimator.onAnimationStart");
                    i.a(i.l.class, 3);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Log.i("CameraView", "mFinishReadyRightAnimator.onAnimationEnd");
                    CameraView.this.setX(f2);
                    i.a(i.l.class, 4);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.i("CameraView", "mFinishReadyRightAnimator.onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Log.i("CameraView", "mFinishReadyRightAnimator.onAnimationRepeat");
                }
            });
            this.m.setDuration(600L);
            this.m.start();
        }
    }

    public boolean a() {
        Log.i("CameraView", "isLeft.x = " + getX());
        return getX() == 872.0f;
    }

    public boolean b() {
        Log.i("CameraView", "isRight.x = " + getX());
        return getX() == 1822.0f;
    }

    public boolean c() {
        Log.i("CameraView", "isMiddle.x = " + getX());
        return getX() == 1422.0f;
    }

    public void d() {
        this.b = new a();
        this.b.setZOrderMediaOverlay(true);
        LogUtils.i("CameraView", "update penggy autopilot surfaceView:" + System.identityHashCode(this.b));
        this.b.setOnCameraReleaseListener(new a.b() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.1
            @Override // com.xiaopeng.autopilot.camera.view.a.b
            public void a() {
                LogUtils.i("CameraView", "onCameraRelease()");
                rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtils.i("CameraView", "onCameraRelease() 通知CarCamera恢复摄像头状态，REMOTE_COMMAND_AUTOPILOT_EXIT_AUTO_PARK");
                        com.xiaopeng.autopilot.base.c.a().a(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_EXIT_AUTO_PARK, null, IpcConfig.App.CAR_CAMERA);
                        LogUtils.i("CameraView", "onCameraRelease() setCameraReleaseing(false)");
                        rc.a().a(false);
                    }
                });
            }
        });
    }

    private void h() {
        if (com.xiaopeng.autopilot.base.d.h() || com.xiaopeng.autopilot.base.d.g()) {
            LogUtils.i("CameraView", "高配和中配，有360全景影像");
            this.d.setVisibility(0);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int intValue = ((i.l) i.a(i.l.class)).d().intValue();
                    LogUtils.i("CameraView", "listener.state = " + intValue);
                    if (!BuildInfoUtils.isUserVersion()) {
                        if (System.currentTimeMillis() - CameraView.this.h >= 5000) {
                            CameraView.this.i = 0;
                            CameraView.this.h = System.currentTimeMillis();
                        } else {
                            CameraView.g(CameraView.this);
                        }
                        if (CameraView.this.i == 10) {
                            if (com.xiaopeng.autopilot.base.d.f) {
                                com.xiaopeng.autopilot.base.d.f = false;
                                rf.a(com.xiaopeng.autopilot.base.a.g().getApplicationContext()).c(false);
                                CameraView.this.e.setVisibility(8);
                                XToast.showShort("close log");
                            } else {
                                com.xiaopeng.autopilot.base.d.f = true;
                                rf.a(com.xiaopeng.autopilot.base.a.g().getApplicationContext()).c(true);
                                XToast.showShort("open log");
                                CameraView.this.e.setVisibility(0);
                            }
                        }
                        if (com.xiaopeng.autopilot.base.d.n() && CameraView.this.i == 5) {
                            if (com.xiaopeng.autopilot.base.d.g) {
                                com.xiaopeng.autopilot.base.d.g = false;
                                XToast.showShort("CHECK_SOMEIP_CONNECT");
                            } else {
                                com.xiaopeng.autopilot.base.d.g = true;
                                XToast.showShort("NOT_CHECK_SOMEIP_CONNECT");
                            }
                        }
                    }
                    int gear = CarApiUtil.getGear();
                    int pureDriveModeFeedback = CarApiUtil.getPureDriveModeFeedback();
                    boolean z = pureDriveModeFeedback == 3 || pureDriveModeFeedback == 2;
                    LogUtils.i("CameraView", "主动点击了视角切换  ");
                    int a = rf.a(com.xiaopeng.autopilot.base.a.g()).a();
                    if (a == 17) {
                        if (z) {
                            CameraView.this.a(1, false, false);
                            CameraView.this.a(gear);
                        } else {
                            CameraView.this.b(1);
                        }
                    } else if (z) {
                        CameraView.this.a(17, false, false);
                        CameraView.this.a(gear);
                    } else {
                        CameraView.this.b(17);
                    }
                    CameraView.this.c(gear);
                    com.xiaopeng.autopilot.base.c.a().i().statisEnter360Camera(a);
                }
            });
            return;
        }
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        c(i);
    }

    @Override // com.xiaopeng.autopilot.camera.view.b
    public void a(rs rsVar) {
        this.a = rsVar;
    }

    @Override // com.xiaopeng.autopilot.camera.view.b
    public void a(float f) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.setAngle(f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("CameraView", "onAttachedToWindow");
        this.g = new XTouchAreaWatcher(30, 30, 30, 30);
        XTouchAreaWatcher xTouchAreaWatcher = this.g;
        XButton xButton = this.d;
        xTouchAreaWatcher.extendTouchArea(xButton, (ViewGroup) xButton.getParent());
        org.greenrobot.eventbus.c.a().a(this);
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("CameraView", "onDetachedFromWindow");
        this.g.onDestroy();
        org.greenrobot.eventbus.c.a().c(this);
        ThemeWatcher.getInstance().removeThemeListener(this);
        this.e.setVisibility(8);
    }

    public void e() {
        LogUtils.i("CameraView", "detachCamera()");
        this.b.setOnCameraReleaseListener(new a.b() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.3
            @Override // com.xiaopeng.autopilot.camera.view.a.b
            public void a() {
                LogUtils.i("CameraView", "onCameraRelease()");
                rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtils.i("CameraView", "onCameraRelease() 通知CarCamera恢复摄像头状态，REMOTE_COMMAND_AUTOPILOT_EXIT_AUTO_PARK");
                        com.xiaopeng.autopilot.base.c.a().a(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_EXIT_AUTO_PARK, null, IpcConfig.App.CAR_CAMERA);
                        LogUtils.i("CameraView", "onCameraRelease() setCameraReleaseing(false)");
                        rc.a().a(false);
                    }
                });
            }
        });
        removeView(this.c);
        removeView(this.b);
        LogUtils.i("CameraView", "removeView(mCameraSurfaceView)");
    }

    public void f() {
        LogUtils.i("CameraView", "attachCamera()");
        if (com.xiaopeng.autopilot.base.d.f()) {
            if (this.c == null) {
                d dVar = new d(com.xiaopeng.autopilot.base.a.g());
                dVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                dVar.setBackgroundColor(0);
                this.c = dVar;
            }
            if (this.c.getParent() != null) {
                ((ViewGroup) this.c.getParent()).removeView(this.c);
                LogUtils.i("CameraView", ".removeView(mPathGuideView)");
            }
            addView(this.c, 0);
            LogUtils.i("CameraView", "addView(mPathGuideView)");
        }
        LogUtils.i("CameraView", "Constant.NEED_CAMERA_VIEW_COVER = false");
        this.b.setOnPreviewListener(new a.c() { // from class: com.xiaopeng.autopilot.camera.view.CameraView.4
            @Override // com.xiaopeng.autopilot.camera.view.a.c
            public void a() {
                CameraView.this.i();
                com.xiaopeng.autopilot.base.d.f();
            }

            @Override // com.xiaopeng.autopilot.camera.view.a.c
            public void b() {
                LogUtils.i("CameraView", "onPreview() 预览成功 再次changeChannel = 1");
                CameraView.this.a.b(1);
                CameraView.this.i();
                LogUtils.i("CameraView", "onPreview() 预览成功 removeCallbacks(mCameraRetryRunnable)");
                CameraView.this.q.removeCallbacks(CameraView.this.r);
                LogUtils.i("CameraView", "onPreview() 预览成功 setCameraStarting(false)");
                rc.a().b(false);
            }

            @Override // com.xiaopeng.autopilot.camera.view.a.c
            public void a(boolean z) {
                LogUtils.i("CameraView", "onError() 预览失败 needAddRetry = " + z);
                CameraView.this.q.removeCallbacks(CameraView.this.r);
                if (z) {
                    LogUtils.i("CameraView", "onError() 预览失败 postDelayed(mCameraRetryRunnable, 1000)");
                    CameraView.this.q.postDelayed(CameraView.this.r, 1000L);
                }
            }

            @Override // com.xiaopeng.autopilot.camera.view.a.c
            public void c() {
                if (rc.a().c()) {
                    LogUtils.i("CameraView", "onPreviewFail(),  isCameraStarting() = true 预览失败，尝试再set2StartPreview一次");
                    CameraView.this.b.set2StartPreview(false);
                }
            }
        });
        addView(this.b, 0, new RelativeLayout.LayoutParams(UIUtils.dip2px(getContext(), getResources().getDimensionPixelOffset(rp.a.camera_window_width)), UIUtils.dip2px(getContext(), getResources().getDimensionPixelOffset(rp.a.camera_window_height))));
        LogUtils.i("CameraView", "addView(mCameraSurfaceView)");
        i();
    }

    @Override // com.xiaopeng.autopilot.camera.view.b
    public a getCameraSurfaceView() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        a(i, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2) {
        LogUtils.i("CameraView", "tryHandleClick相机切换为：" + i + ",isSwitchAvm = " + z);
        if (!z2) {
            rf.a(com.xiaopeng.autopilot.base.a.g()).a(i);
        }
        setCameraNavigationView(i);
        if (z) {
            this.a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int intValue = ((i.l) i.a(i.l.class)).d().intValue();
        boolean booleanValue = ((i.e) i.a(i.e.class)).d().booleanValue();
        boolean booleanValue2 = ((i.am) i.a(i.am.class)).d().booleanValue();
        LogUtils.i("CameraView", "resetAvm.state = " + intValue + ",isApActived = " + booleanValue + "," + booleanValue2);
        int a = rf.a(com.xiaopeng.autopilot.base.a.g()).a();
        StringBuilder sb = new StringBuilder();
        sb.append("resetAvm(), 当前倒车AVM类型：");
        sb.append(a);
        LogUtils.i("CameraView", sb.toString());
        if (this.a != null) {
            b(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        LogUtils.i("CameraView", "autoAvm(gear), 当前gear：" + i);
        if (rf.a(com.xiaopeng.autopilot.base.a.g()).a() == 17) {
            if (i == 1) {
                this.a.a(16);
            } else if (i == 3 || i == 2 || i == 4) {
                this.a.a(17);
            }
        } else if (i == 1) {
            this.a.a(0);
        } else if (i == 3 || i == 2 || i == 4) {
            this.a.a(1);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(IpcRouterEvent ipcRouterEvent) {
        int msgID = ipcRouterEvent.getMsgID();
        String senderPackageName = ipcRouterEvent.getSenderPackageName();
        LogUtils.i("CameraView", "messageId: " + msgID + "  packageName: " + senderPackageName);
        if (msgID == 110006) {
            LogUtils.i("CameraView", "收到CarCamera释放摄像头ipc  .REMOTE_COMMAND_CAMERA_RELEASED_EVENT");
            LogUtils.i("CameraView", "mIsWaitingForPreview =" + rc.a().d() + " , mCurParkingType=" + rc.a().e() + " , isCameraStarting=" + rc.a().c() + " , isCameraReleaseing=" + rc.a().b());
            if (rc.a().d() && rc.a().e() != -1 && this.b.getParent() != null && rc.a().c() && !rc.a().b() && this.b != null) {
                LogUtils.i("CameraView", "需要再执行set2StartPreview(true)");
                this.b.set2StartPreview(true);
            }
            rc.a().c(false);
            LogUtils.i("CameraView", "mIsWaitingForPreview = " + rc.a().d());
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(RetryReleaseCameraEvent retryReleaseCameraEvent) {
        if (retryReleaseCameraEvent == null || !rc.a().c()) {
            return;
        }
        LogUtils.i("CameraView", "onEvent(RetryReleaseCameraEvent event) IPC重新让其它摄像头尽早释放， REMOTE_COMMAND_AUTOPILOT_REVERSING_BEGIN");
        com.xiaopeng.autopilot.base.c.a().a(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_ENTER_AUTO_PARK, null, IpcConfig.App.CAR_CAMERA);
        LogUtils.i("CameraView", "onEvent(RetryReleaseCameraEvent event) mIsWaitingForPreview = true");
        rc.a().c(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    @org.greenrobot.eventbus.m(a = org.greenrobot.eventbus.ThreadMode.MAIN, b = true)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCarServicesEvent(com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController.PureDriveModeFeedbackEventMsg r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r4.getData()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r1 = 1
            if (r0 != r1) goto Le
            return
        Le:
            java.lang.Object r0 = r4.getData()     // Catch: java.lang.Exception -> L30
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> L30
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L30
            r2 = 3
            if (r0 == r2) goto L2a
            java.lang.Object r4 = r4.getData()     // Catch: java.lang.Exception -> L30
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Exception -> L30
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L30
            r0 = 2
            if (r4 != r0) goto L29
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 != 0) goto L34
            r3.i()     // Catch: java.lang.Exception -> L30
            goto L34
        L30:
            r4 = move-exception
            r4.printStackTrace()
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.autopilot.camera.view.CameraView.onCarServicesEvent(com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController$PureDriveModeFeedbackEventMsg):void");
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IVcuController.CarGearLevelEventMsg carGearLevelEventMsg) {
        try {
            c(carGearLevelEventMsg.getData().intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        Log.i("CameraView", "onSwitchTheme.i = " + i + ",mCameraViewCover = " + this.f);
        int a = rf.a(com.xiaopeng.autopilot.base.a.g()).a();
        StringBuilder sb = new StringBuilder();
        sb.append("navigationType = ");
        sb.append(a);
        Log.i("CameraView", sb.toString());
        setCameraNavigationView(a);
    }

    private void setCameraNavigationView(final int i) {
        ThreadUtils.runOnMainThread(new Runnable() { // from class: com.xiaopeng.autopilot.camera.view.-$$Lambda$CameraView$qUcy3xzs2N4D4NKCREJX9jLYtY4
            @Override // java.lang.Runnable
            public final void run() {
                CameraView.this.d(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i) {
        if (com.xiaopeng.autopilot.base.d.f()) {
            return;
        }
        if (i == 17) {
            if (ThemeWatcher.getInstance().isNight()) {
                this.d.setBackgroundResource(rp.d.btn_avm_type_360_night);
            } else {
                this.d.setBackgroundResource(rp.d.btn_avm_type_360);
            }
        } else if (ThemeWatcher.getInstance().isNight()) {
            this.d.setBackgroundResource(rp.d.btn_avm_type_back_night);
        } else {
            this.d.setBackgroundResource(rp.d.btn_avm_type_back);
        }
    }

    public XButton getXPilot() {
        return this.j;
    }

    public void setCameraViewCallback(c cVar) {
        this.p = cVar;
    }

    @m
    public void onEvent(CameraXPilotEvent cameraXPilotEvent) {
        Log.i("CameraView", "onUpdateXPilotEvent.event = " + cameraXPilotEvent.mStatus + ",xPilot = " + this.j);
        if (cameraXPilotEvent == null || this.j == null) {
            return;
        }
        if (cameraXPilotEvent.mStatus == 3 || cameraXPilotEvent.mStatus == 7) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }
}
