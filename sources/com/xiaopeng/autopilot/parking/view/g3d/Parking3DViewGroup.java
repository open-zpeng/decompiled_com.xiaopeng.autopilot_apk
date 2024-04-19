package com.xiaopeng.autopilot.parking.view.g3d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AdapterViewApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraStateEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class Parking3DViewGroup extends RelativeLayout {
    private AdapterViewApplication a;
    private h b;
    private tj c;
    private GLSurfaceView d;
    private ValueAnimator e;
    private ValueAnimator f;
    private ValueAnimator g;
    private boolean h;
    private boolean i;
    private boolean j;

    public void setParking3dPresenter(tj tjVar) {
        this.c = tjVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this.b);
        org.greenrobot.eventbus.c.a().a(this);
        this.b.t();
        PerformanceTestUnit.sLogLastTimeMap.put("Parking3DViewGroup_onAttachedToWindow", Long.valueOf(System.currentTimeMillis()));
        Log.i("3DViewContainer", "StartPerformance onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("3DViewContainer", "onDetachedFromWindow");
        ThemeWatcher.getInstance().removeThemeListener(this.b);
        org.greenrobot.eventbus.c.a().c(this);
        this.b.u();
    }

    public Parking3DViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.j = false;
        Log.i("3DViewContainer", "Parking3DViewGroup");
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = new AdapterViewApplication(getContext());
        AndroidApplicationConfiguration androidApplicationConfiguration = new AndroidApplicationConfiguration();
        androidApplicationConfiguration.a = 8;
        androidApplicationConfiguration.b = 8;
        androidApplicationConfiguration.g = 8;
        androidApplicationConfiguration.r = 8;
        androidApplicationConfiguration.numSamples = 2;
        this.b = com.xiaopeng.autopilot.parking.c.a();
        this.b.a(this.a);
        this.d = (GLSurfaceView) this.a.initializeForView(this.b, androidApplicationConfiguration);
        this.d.setVisibility(4);
        addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
        this.d.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.i("3DViewContainer", "surfaceCreated");
                Parking3DViewGroup.this.h = true;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.i("3DViewContainer", "surfaceDestroyed");
                Parking3DViewGroup.this.h = false;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Log.d("3DViewContainer", "dispatchTouchEvent, action: " + motionEvent.getAction() + "," + motionEvent.getX() + "," + motionEvent.getY());
        if (motionEvent.getAction() == 0) {
            com.xiaopeng.autopilot.parking.c.a((int) motionEvent.getX(), (int) motionEvent.getY(), true);
        } else if (motionEvent.getAction() == 1) {
            com.xiaopeng.autopilot.parking.c.a((int) motionEvent.getX(), (int) motionEvent.getY(), false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setXpilotClick(boolean z) {
        this.i = z;
    }

    public void a(tv tvVar) {
        Log.d("3DViewContainer", "bindPresenter, parkingPresenter: " + tvVar);
        this.b.a(tvVar);
        this.c = com.xiaopeng.autopilot.parking.c.a(tvVar);
        this.b.a(this.c);
        this.c.a(this.b);
    }

    public h getParking3DSence() {
        return this.b;
    }

    public void a() {
        Log.i("3DViewContainer", "startSurfaceDraw isExcutedClosed: false");
        this.j = false;
        this.b.Q();
        rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.3
            @Override // java.lang.Runnable
            public void run() {
                Parking3DViewGroup.this.d.onResume();
                Parking3DViewGroup.this.d.setVisibility(0);
            }
        }, 1L);
    }

    public void b() {
        Log.i("3DViewContainer", "stopSurfaceDraw");
        this.b.R();
        if (this.h) {
            Log.i("3DViewContainer", "GLThread onPause");
            this.d.onPause();
            ThreadUtils.postBackground(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.4
                @Override // java.lang.Runnable
                public void run() {
                    if (Parking3DViewGroup.this.j) {
                        return;
                    }
                    Log.i("3DViewContainer", "GLThread wakeup locked ");
                    Parking3DViewGroup.this.d.requestRender();
                }
            }, 1000L);
            this.d.setVisibility(4);
            this.j = true;
        }
    }

    @m
    public void onCameraAnimationState(final CameraStateEvent cameraStateEvent) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.5
            @Override // java.lang.Runnable
            public void run() {
                int i = cameraStateEvent.mState;
                Log.i("3DViewContainer", "onCameraAnimationState.state = " + i);
                if (i != 1) {
                    if (i == 2) {
                        if (Parking3DViewGroup.this.e != null && Parking3DViewGroup.this.e.isRunning()) {
                            Parking3DViewGroup.this.e.cancel();
                        }
                        if (Parking3DViewGroup.this.g != null && Parking3DViewGroup.this.g.isRunning()) {
                            Parking3DViewGroup.this.g.cancel();
                        }
                        if (Parking3DViewGroup.this.c()) {
                            Parking3DViewGroup.this.b(-470.0f, 0.0f);
                            return;
                        } else if (Parking3DViewGroup.this.e()) {
                            Parking3DViewGroup.this.b(-370.0f, 0.0f);
                            return;
                        } else {
                            return;
                        }
                    } else if (i == 3) {
                        if (Parking3DViewGroup.this.e != null && Parking3DViewGroup.this.e.isRunning()) {
                            Parking3DViewGroup.this.e.cancel();
                        }
                        if (Parking3DViewGroup.this.f != null && Parking3DViewGroup.this.f.isRunning()) {
                            Parking3DViewGroup.this.f.cancel();
                        }
                        if (Parking3DViewGroup.this.c()) {
                            Parking3DViewGroup.this.c(-470.0f, -370.0f);
                            return;
                        } else if (Parking3DViewGroup.this.d()) {
                            Parking3DViewGroup.this.c(0.0f, -370.0f);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                boolean booleanValue = ((i.e) com.xiaopeng.autopilot.base.i.a(i.e.class)).d().booleanValue();
                i.ad adVar = (i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class);
                int intValue = adVar.d().intValue();
                Log.i("3DViewContainer", "onCameraAnimationState.apHasActive = " + booleanValue + "," + Parking3DViewGroup.this.i + "," + adVar);
                if (Parking3DViewGroup.this.i || !booleanValue || intValue == -3 || intValue == -12 || intValue == -13) {
                    if (Parking3DViewGroup.this.f != null && Parking3DViewGroup.this.f.isRunning()) {
                        Parking3DViewGroup.this.f.cancel();
                    }
                    if (Parking3DViewGroup.this.g != null && Parking3DViewGroup.this.g.isRunning()) {
                        Parking3DViewGroup.this.g.cancel();
                    }
                    if (Parking3DViewGroup.this.d()) {
                        Parking3DViewGroup.this.a(0.0f, -470.0f);
                    } else if (Parking3DViewGroup.this.e()) {
                        Parking3DViewGroup.this.a(-370.0f, -470.0f);
                    }
                }
            }
        });
    }

    public void a(float f, final float f2) {
        ValueAnimator valueAnimator = this.e;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !c()) {
            Log.i("3DViewContainer", "onAnimatorLeft.startX = " + f + ",endX = " + f2);
            this.e = ValueAnimator.ofFloat(f, f2);
            this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    Log.i("3DViewContainer", "onAnimatorLeft.newX = " + floatValue);
                    Parking3DViewGroup.this.setX(floatValue);
                }
            });
            this.e.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Log.i("3DViewContainer", "mLeftAnimator.onAnimationStart");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Log.i("3DViewContainer", "mLeftAnimator.onAnimationEnd");
                    Parking3DViewGroup.this.setX(f2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.i("3DViewContainer", "mLeftAnimator.onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Log.i("3DViewContainer", "mLeftAnimator.onAnimationRepeat");
                }
            });
            this.e.setDuration(750L);
            this.e.start();
        }
    }

    public void b(float f, final float f2) {
        ValueAnimator valueAnimator = this.f;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !d()) {
            Log.i("3DViewContainer", "onAnimatorRight.startX = " + f + ",endX = " + f2);
            this.f = ValueAnimator.ofFloat(f, f2);
            this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    Log.i("3DViewContainer", "onAnimatorRight.newX = " + floatValue);
                    Parking3DViewGroup.this.setX(floatValue);
                }
            });
            this.f.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Log.i("3DViewContainer", "mRightAnimator.onAnimationStart");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Log.i("3DViewContainer", "mRightAnimator.onAnimationEnd");
                    Parking3DViewGroup.this.setX(f2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.i("3DViewContainer", "mRightAnimator.onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Log.i("3DViewContainer", "mRightAnimator.onAnimationRepeat");
                }
            });
            this.f.setDuration(750L);
            this.f.start();
        }
    }

    public void c(float f, final float f2) {
        ValueAnimator valueAnimator = this.g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !e()) {
            LogUtils.i("3DViewContainer", "onFinishReadyAnimatorRight.startX = " + f + ",endX = " + f2);
            this.g = ValueAnimator.ofFloat(f, f2);
            this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    LogUtils.i("3DViewContainer", "onFinishReadyAnimatorRight.newX = " + floatValue);
                    Parking3DViewGroup.this.setX(floatValue);
                }
            });
            this.g.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Log.i("3DViewContainer", "mFinishReadyRightAnimator.onAnimationStart");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Log.i("3DViewContainer", "mFinishReadyRightAnimator.onAnimationEnd");
                    Parking3DViewGroup.this.setX(f2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.i("3DViewContainer", "mFinishReadyRightAnimator.onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Log.i("3DViewContainer", "mFinishReadyRightAnimator.onAnimationRepeat");
                }
            });
            this.g.setDuration(750L);
            this.g.start();
        }
    }

    public boolean c() {
        float x = getX();
        Log.i("3DViewContainer", "isLeft.x = " + x);
        return x == -470.0f;
    }

    public boolean d() {
        Log.i("3DViewContainer", "isRight.x = " + getX());
        return getX() == 0.0f;
    }

    public boolean e() {
        Log.i("3DViewContainer", "isMiddle.x = " + getX());
        return getX() == -370.0f;
    }
}
