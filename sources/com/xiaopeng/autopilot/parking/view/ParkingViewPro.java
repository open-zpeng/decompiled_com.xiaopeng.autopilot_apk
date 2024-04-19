package com.xiaopeng.autopilot.parking.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraStateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.ShortcutEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.SpeechSuperParkEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingControlBtnEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingFailPageEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingLearnStepEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingPageEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingSuccessPageEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingUpdateVisibleEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IScuController;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class ParkingViewPro extends RelativeLayout implements com.xiaopeng.autopilot.parking.view.g3d.f, h, ThemeWatcher.OnThemeSwitchListener {
    private static final int I = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.parking_btn_layout_margin_left_when_right));
    private static final int J = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.parking_btn_layout_margin_left_when_left));
    private static final int K = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_map_view_left_margin_with_camera_right));
    private static final int L = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_map_view_left_margin_with_camera_left));
    private static final int M = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_map_view_top_margin_with_camera_right));
    private static final int N = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_map_view_top_margin_with_camera_left));
    private XDialog A;
    private XDialog B;
    private int C;
    private ValueAnimator D;
    private ValueAnimator E;
    private ValueAnimator F;
    private ValueAnimator G;
    private ValueAnimator H;
    private RelativeLayout O;
    private RelativeLayout P;
    private MiniMapView Q;
    private long R;
    private long S;
    private Runnable T;
    private View.OnClickListener U;
    public tw a;
    public int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    boolean h;
    boolean i;
    private InfoBoardView j;
    private View k;
    private TextView l;
    private XButton m;
    private SettingAttentionView n;
    private XImageButton o;
    private RelativeLayout p;
    private XImageView q;
    private View r;
    private TextView s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private View x;
    private View y;
    private boolean z;

    private void C() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void d() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void f(int i) {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void g(int i) {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void setProgressBarVisible(int i) {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void setSlideWarningView(View view) {
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public int getDistance() {
        Log.i("ParkingViewPro", "mParkingProPresenter.getCurrentS() = " + this.a.E() + ",mParkingProPresenter.getStartS() = " + this.a.D());
        return (int) Math.floor(this.a.E() - this.a.D());
    }

    public ParkingViewPro(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ParkingViewPro(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -100;
        this.z = false;
        this.S = System.currentTimeMillis();
        this.T = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.1
            @Override // java.lang.Runnable
            public void run() {
                ParkingViewPro.this.r.setVisibility(8);
            }
        };
        this.c = 2;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 10;
        this.h = true;
        this.i = false;
        this.U = new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogUtils.i("ParkingViewPro", "onClick ---> 点击默认泊车关闭按钮");
                ParkingViewPro.this.G();
            }
        };
        r();
        D();
        t();
        p();
    }

    public void p() {
        this.j.a();
        int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
        Log.i("ParkingViewPro", "updateTheme.ThemeWatcher.getInstance().isNight() = " + ThemeWatcher.getInstance().isNight() + "," + intValue);
        if (ThemeWatcher.getInstance().isNight()) {
            this.y.setBackgroundResource(e.g.ic_ap_ready_learn_btn_bg_night);
            this.w.setImageResource(e.g.ic_ap_key_parking_night);
            this.m.setBackgroundResource(e.d.selector_parking_view_pro_control_btn_bg_night);
            this.u.setImageResource(e.g.ic_training_ap_car_night);
            this.v.setImageResource(e.g.ic_training_ap_ready_circle_night);
            this.k.setBackgroundResource(e.g.ic_ap_ready_training_learn_tips_bg_night);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            if (intValue == -2) {
                this.P.setBackgroundResource(e.g.ic_ap_map_with_map_night);
            } else if (intValue == -1 || intValue == -14) {
                this.P.setBackgroundResource(e.g.ic_ap_map_view_bg_night);
            }
        } else {
            this.y.setBackgroundResource(e.g.ic_ap_ready_learn_btn_bg);
            this.w.setImageResource(e.g.ic_ap_key_parking);
            this.m.setBackgroundResource(e.d.selector_parking_view_pro_control_btn_bg);
            this.u.setImageResource(e.g.ic_training_ap_car);
            this.v.setImageResource(e.g.ic_training_ap_ready_circle);
            this.k.setBackgroundResource(e.g.ic_ap_ready_training_learn_tips_bg);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color));
            if (intValue == -2) {
                this.P.setBackgroundResource(e.g.ic_ap_map_with_map);
            } else if (intValue == -1 || intValue == -14) {
                this.P.setBackgroundResource(e.g.ic_ap_map_view_bg);
            }
        }
        this.n.c();
        E();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public boolean e() {
        return com.xiaopeng.autopilot.parking.c.o();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void d(boolean z) {
        org.greenrobot.eventbus.c.a().d(new TrainingUpdateVisibleEvent(z));
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        p();
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(5));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Log.i("ParkingViewPro", "onAttachedToWindow");
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
        p();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        this.n.a(this.a);
        this.n.b();
        this.z = true;
        C();
    }

    public void q() {
        Log.i("ParkingViewPro", "showLearnView");
        this.a.o(-4);
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(4));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void b_(int i, int i2) {
        Log.i("ParkingViewPro", "updateLearnView.step = " + i);
        org.greenrobot.eventbus.c.a().d(new TrainingLearnStepEvent(i, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        ThemeWatcher.getInstance().removeThemeListener(this);
        this.a.H();
        this.b = -100;
        this.z = false;
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public boolean j() {
        return this.z;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(tv tvVar) {
        this.a = (tw) tvVar;
        s();
    }

    public void r() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_pro_view, (ViewGroup) this, true);
        this.y = findViewById(e.C0055e.training_ap_btn_bg);
        this.w = (ImageView) findViewById(e.C0055e.parking_ap_key_icon);
        this.k = findViewById(e.C0055e.ap_ready_learn_tips_layout);
        this.l = (TextView) findViewById(e.C0055e.ap_ready_learn_tv_parking_tip);
        this.r = findViewById(e.C0055e.parking_ap_cancel_layout);
        this.s = (TextView) findViewById(e.C0055e.parking_ap_cancel_tv);
        this.t = (ImageView) findViewById(e.C0055e.pro_view_parking_training_normal);
        this.x = findViewById(e.C0055e.training_ap_btn_layout);
        this.o = (XImageButton) findViewById(e.C0055e.pro_view_ib_close);
        this.m = (XButton) findViewById(e.C0055e.pro_view_parking_rear_mirror);
        this.n = (SettingAttentionView) findViewById(e.C0055e.pro_view_parking_setting_attention);
        this.j = (InfoBoardView) findViewById(e.C0055e.info_board_view);
        this.j.setParkingView(this);
        this.p = (RelativeLayout) findViewById(e.C0055e.parking_pro_b_image_layout);
        this.q = (XImageView) findViewById(e.C0055e.ic_parking_pro_b_image);
        this.u = (ImageView) findViewById(e.C0055e.pro_view_parking_training_normal_car);
        this.O = (RelativeLayout) findViewById(e.C0055e.parking_btn_layout);
        this.v = (ImageView) findViewById(e.C0055e.pro_view_parking_training_normal_circle);
        this.P = (RelativeLayout) findViewById(e.C0055e.parking_ap_map_layout);
    }

    public void s() {
        if (this.Q != null) {
            PerformanceTestUnit.log("ParkingViewPro", "MINI_MAP already initMiniMapConponent view ", true);
            return;
        }
        tu d = tu.d();
        this.Q = (MiniMapView) findViewById(e.C0055e.parking_mini_map);
        d.a(this.a.s());
        d.a(this.Q);
        this.Q.a(d);
        this.Q.a(false);
        PerformanceTestUnit.log("ParkingViewPro", "MINI_MAP initMiniMapConponent view finished", true);
    }

    private void D() {
        this.E = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.E.setDuration(800L);
        this.E.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Log.i("ParkingViewPro", "mRightValueAnimator.onAnimationStart");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Log.i("ParkingViewPro", "mRightValueAnimator.onAnimationEnd");
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                layoutParams.leftMargin = ParkingViewPro.I;
                ParkingViewPro.this.O.setLayoutParams(layoutParams);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Log.i("ParkingViewPro", "mRightValueAnimator.onAnimationCancel");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Log.i("ParkingViewPro", "mRightValueAnimator.onAnimationRepeat");
            }
        });
        this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.23
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                layoutParams.leftMargin = ParkingViewPro.J + ((int) ((ParkingViewPro.I - ParkingViewPro.J) * floatValue));
                ParkingViewPro.this.O.setLayoutParams(layoutParams);
            }
        });
        this.D = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.D.setDuration(800L);
        this.D.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.24
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Log.i("ParkingViewPro", "mLeftValueAnimator.onAnimationStart");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Log.i("ParkingViewPro", "mLeftValueAnimator.onAnimationEnd");
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                layoutParams.leftMargin = ParkingViewPro.J;
                ParkingViewPro.this.O.setLayoutParams(layoutParams);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Log.i("ParkingViewPro", "mLeftValueAnimator.onAnimationCancel");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Log.i("ParkingViewPro", "mLeftValueAnimator.onAnimationRepeat");
            }
        });
        this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.25
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                layoutParams.leftMargin = ParkingViewPro.J + ((int) ((ParkingViewPro.I - ParkingViewPro.J) * floatValue));
                ParkingViewPro.this.O.setLayoutParams(layoutParams);
            }
        });
        this.H = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.H.setDuration(1000L);
        this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.26
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.i("ParkingViewPro", "mMapRightValueAnimator.percent = " + floatValue);
                ParkingViewPro.this.a(ParkingViewPro.L + ((int) (((float) (ParkingViewPro.K - ParkingViewPro.L)) * floatValue)), ParkingViewPro.N + ((int) (((float) (ParkingViewPro.M - ParkingViewPro.N)) * floatValue)), floatValue * 0.3f);
            }
        });
        this.H.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.27
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ParkingViewPro.this.a(ParkingViewPro.K, ParkingViewPro.M, 0.3f);
                Log.i("ParkingViewPro", "mMapRightValueAnimator.onAnimationEnd = " + ((RelativeLayout.LayoutParams) ParkingViewPro.this.P.getLayoutParams()).leftMargin);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Log.i("ParkingViewPro", "mMapRightValueAnimator.onAnimationCancel");
            }
        });
        this.G = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.G.setDuration(1000L);
        this.G.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.28
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.i("ParkingViewPro", "mMapLeftValueAnimator.percent = " + floatValue);
                ParkingViewPro.this.a(ParkingViewPro.L + ((int) (((float) (ParkingViewPro.K - ParkingViewPro.L)) * floatValue)), ParkingViewPro.N + ((int) (((float) (ParkingViewPro.M - ParkingViewPro.N)) * floatValue)), floatValue * 0.3f);
            }
        });
        this.G.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.29
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ParkingViewPro.this.a(ParkingViewPro.L, ParkingViewPro.N, 0.0f);
                Log.i("ParkingViewPro", "mMapLeftValueAnimator.onAnimationEnd = " + ((RelativeLayout.LayoutParams) ParkingViewPro.this.P.getLayoutParams()).leftMargin);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Log.i("ParkingViewPro", "mMapLeftValueAnimator.onAnimationCancel");
            }
        });
        this.F = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.F.setDuration(1200L);
        this.F.setRepeatCount(-1);
        this.F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ParkingViewPro.this.v.setScaleX(floatValue);
                ParkingViewPro.this.v.setScaleY(floatValue);
            }
        });
    }

    @org.greenrobot.eventbus.m
    public void onEvent(final CameraStateEvent cameraStateEvent) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.3
            @Override // java.lang.Runnable
            public void run() {
                if (ParkingViewPro.this.getVisibility() != 0) {
                    return;
                }
                if (ParkingViewPro.this.D != null && ParkingViewPro.this.D.isRunning()) {
                    ParkingViewPro.this.D.cancel();
                }
                if (ParkingViewPro.this.G != null && ParkingViewPro.this.G.isRunning()) {
                    ParkingViewPro.this.G.cancel();
                }
                if (ParkingViewPro.this.E != null && ParkingViewPro.this.E.isRunning()) {
                    ParkingViewPro.this.E.cancel();
                }
                if (ParkingViewPro.this.H != null && ParkingViewPro.this.H.isRunning()) {
                    ParkingViewPro.this.H.cancel();
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                boolean z = layoutParams.leftMargin <= ParkingViewPro.J;
                if (com.xiaopeng.autopilot.base.d.c()) {
                    Log.i("ParkingViewPro", "event.mState = " + cameraStateEvent.mState + "," + z + "," + layoutParams.leftMargin);
                }
                if (cameraStateEvent.mState == 1) {
                    if (!z) {
                        ParkingViewPro.this.D.start();
                        ParkingViewPro.this.G.start();
                        return;
                    }
                    if (!ParkingViewPro.this.D.isRunning() && !ParkingViewPro.this.E.isRunning()) {
                        Log.i("ParkingViewPro", "set btn layout left");
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                        layoutParams2.leftMargin = ParkingViewPro.J;
                        ParkingViewPro.this.O.setLayoutParams(layoutParams2);
                    }
                    if (ParkingViewPro.this.H.isRunning() || ParkingViewPro.this.G.isRunning()) {
                        return;
                    }
                    Log.i("ParkingViewPro", "set map layout left");
                    ParkingViewPro.this.a(ParkingViewPro.L, ParkingViewPro.N, 0.0f);
                } else if (cameraStateEvent.mState == 2) {
                    if (z) {
                        ParkingViewPro.this.E.start();
                        ParkingViewPro.this.H.start();
                        return;
                    }
                    if (!ParkingViewPro.this.D.isRunning() && !ParkingViewPro.this.E.isRunning()) {
                        Log.i("ParkingViewPro", "set btn layout right");
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) ParkingViewPro.this.O.getLayoutParams();
                        layoutParams3.leftMargin = ParkingViewPro.I;
                        ParkingViewPro.this.O.setLayoutParams(layoutParams3);
                    }
                    if (ParkingViewPro.this.H.isRunning() || ParkingViewPro.this.G.isRunning()) {
                        return;
                    }
                    Log.i("ParkingViewPro", "set map layout right");
                    ParkingViewPro.this.a(ParkingViewPro.K, ParkingViewPro.M, 0.3f);
                }
            }
        });
    }

    public void t() {
        final int[] iArr = {0, 0, 0, 1, 1, 1};
        findViewById(e.C0055e.test_training_tips).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_2));
                if (ParkingViewPro.this.d % ParkingViewPro.this.g == 0) {
                    ParkingViewPro.this.a.onTrainingTips(0, 4, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 1) {
                    ParkingViewPro.this.a.onTrainingTips(0, 15, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 2) {
                    ParkingViewPro.this.a.a(10.0f);
                    ParkingViewPro.this.a.onTrainingTips(6, 5, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 3) {
                    ParkingViewPro.this.a.onTrainingTips(6, 8, iArr);
                    ParkingViewPro.this.a.a(15.0f);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 4) {
                    ParkingViewPro.this.a.onTrainingTips(3, 12, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 5) {
                    if (ParkingViewPro.this.h) {
                        ParkingViewPro parkingViewPro = ParkingViewPro.this;
                        parkingViewPro.h = false;
                        parkingViewPro.a.onTrainingTips(4, 35, iArr);
                    } else {
                        ParkingViewPro parkingViewPro2 = ParkingViewPro.this;
                        parkingViewPro2.h = true;
                        parkingViewPro2.a.onTrainingTips(5, 14, iArr);
                    }
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 6) {
                    ParkingViewPro.this.a.onTrainingTips(0, 21, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 7) {
                    ParkingViewPro.this.a.onTrainingTips(0, 22, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 8) {
                    ParkingViewPro.this.a.onTrainingTips(0, 15, iArr);
                } else if (ParkingViewPro.this.d % ParkingViewPro.this.g == 9) {
                    ParkingViewPro.this.a.onTrainingTips(0, 2, iArr);
                }
                ParkingViewPro.this.d++;
            }
        });
        findViewById(e.C0055e.test_apa_tips).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ParkingViewPro.this.e % 9 == 0) {
                    ParkingViewPro.this.a.a(20.0f);
                    ParkingViewPro.this.a.onVoiceChange(1);
                    ParkingViewPro.this.a.onTipsChange(19, 1);
                } else if (ParkingViewPro.this.e % 9 == 1) {
                    ParkingViewPro.this.a.onTipsChange(22, 1);
                } else if (ParkingViewPro.this.e % 9 == 2) {
                    ParkingViewPro.this.a.onRemainDistance(950.0f);
                    ParkingViewPro.this.a.onTipsChange(3, 0);
                } else if (ParkingViewPro.this.e % 9 == 3) {
                    ParkingViewPro.this.a.onRemainDistance(950.0f);
                    ParkingViewPro.this.a.onTipsChange(6, 0);
                } else if (ParkingViewPro.this.e % 9 == 4) {
                    ParkingViewPro.this.a.onRemainDistance(950.0f);
                    ParkingViewPro.this.a.onTipsChange(0, 0);
                } else if (ParkingViewPro.this.e % 9 == 5) {
                    ParkingViewPro.this.a.onRemainDistance(950.0f);
                    ParkingViewPro.this.a.onTipsChange(19, 0);
                } else if (ParkingViewPro.this.e % 9 == 6) {
                    ParkingViewPro.this.a.onTipsChange(19, 0);
                } else if (ParkingViewPro.this.e % 9 == 7) {
                    ParkingViewPro.this.a.onTipsChange(3, 0);
                } else if (ParkingViewPro.this.e % 9 == 8) {
                    ParkingViewPro.this.a.onTipsChange(6, 0);
                }
                ParkingViewPro.this.e++;
            }
        });
        findViewById(e.C0055e.test_ap_tips).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ParkingViewPro.this.i) {
                    ParkingViewPro.this.a.onStatusIndicateChange(3);
                    ParkingViewPro.this.i = false;
                    return;
                }
                ParkingViewPro.this.a.onStatusIndicateChange(8);
                ParkingViewPro.this.i = true;
            }
        });
        findViewById(e.C0055e.show_ap).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntentUtil.sendInfoFlowCard(1);
            }
        });
        findViewById(e.C0055e.show_learn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntentUtil.sendInfoFlowCard(2);
            }
        });
        findViewById(e.C0055e.cancel_notification).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntentUtil.sendInfoFlowCard(0);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean booleanValue = ((i.ab) com.xiaopeng.autopilot.base.i.a(i.ab.class)).d().booleanValue();
                boolean booleanValue2 = ((i.w) com.xiaopeng.autopilot.base.i.a(i.w.class)).d().booleanValue();
                Log.i("ParkingViewPro", "mTrainingAPBtnLayout.parkingBFinishExit = " + booleanValue + "," + booleanValue2 + ",currentAPStatus = " + ParkingViewPro.this.C);
                if ((ParkingViewPro.this.a.c() && ParkingViewPro.this.a.e() >= 0 && ParkingViewPro.this.a.e() != 13 && ParkingViewPro.this.a.e() != 14) || ParkingViewPro.this.a.e() == 36 || ParkingViewPro.this.a.e() == 24 || booleanValue || booleanValue2) {
                    Log.i("ParkingViewPro", "mTrainingAPBtnLayout can not click");
                    SoundPlayer.getInstance().playUnOperated();
                    return;
                }
                int A = ParkingViewPro.this.a.A();
                if (CarApiUtil.getGear() == 3) {
                    if (ParkingViewPro.this.C == 2 && A == 24) {
                        String string = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_ap_resume_button_click_with_r);
                        rd.a().d(string);
                        XToast.showShort(string);
                        return;
                    }
                    String string2 = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r);
                    rd.a().d(string2);
                    XToast.showShort(string2);
                    return;
                }
                Log.i("ParkingViewPro", "mTrainingAPBtnLayout.trainingTips = " + A + ",currentAPStatus = " + ParkingViewPro.this.C);
                if (A != 12) {
                    if (ParkingViewPro.this.C == 1 || ParkingViewPro.this.C == 2) {
                        if (ParkingViewPro.this.C != 2 || A != 24) {
                            if (ParkingViewPro.this.C == 1 && A == 24) {
                                int intValue = ((i.a) com.xiaopeng.autopilot.base.i.a(i.a.class)).d().intValue();
                                Log.i("ParkingViewPro", "apErrorTips = " + intValue);
                                String str = APInfoBoardView.a[intValue];
                                XToast.showShort(APInfoBoardView.b[intValue]);
                                rd.a().d(str);
                                return;
                            }
                            ParkingViewPro.this.o();
                            return;
                        }
                        ParkingViewPro.this.u();
                        return;
                    } else if (ParkingViewPro.this.C != 3) {
                        if (ParkingViewPro.this.C == 7) {
                            ParkingViewPro.this.a.Q();
                            return;
                        } else if (A == 0 || A == 21 || A == 22) {
                            String str2 = tw.k[A];
                            rd.a().d(ParkingViewPro.this.getResources().getString(e.i.tts_training_out_of_park_click));
                            XToast.showShort(str2);
                            return;
                        } else if (A == 1 || A == 2 || A == 3 || A == 25) {
                            String str3 = tw.k[A];
                            XToast.showShort(str3);
                            if (A == 1) {
                                rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_go_to_land));
                                return;
                            } else {
                                rd.a().d(str3);
                                return;
                            }
                        } else if (A == 24) {
                            String string3 = com.xiaopeng.autopilot.base.a.g().getString(e.i.training_no_use_after_ap);
                            XToast.showShort(string3);
                            rd.a().d(string3);
                            return;
                        } else if (A == 4 || A == 30) {
                            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(3));
                            return;
                        } else if (A == 15) {
                            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(6));
                            return;
                        } else if (A == 33 || A == 34) {
                            return;
                        } else {
                            if (A == 27) {
                                String string4 = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_x_pilot_3_not_use);
                                XToast.showShort(string4);
                                rd.a().d(string4);
                                return;
                            }
                            String string5 = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_ap_not_use);
                            XToast.showShort(string5);
                            rd.a().d(string5);
                            return;
                        }
                    } else {
                        ParkingViewPro.this.a.P();
                        return;
                    }
                }
                String string6 = com.xiaopeng.autopilot.base.a.g().getString(e.i.training_save_background_can_not_training);
                rd.a().d(string6);
                XToast.showShort(string6);
            }
        });
        this.o.setOnClickListener(this.U);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("ParkingViewPro", "mParkingProPresenter.getCurrentTip()" + ParkingViewPro.this.a.e());
                if ((ParkingViewPro.this.a.c() && ParkingViewPro.this.a.e() >= 0 && ParkingViewPro.this.a.e() != 13 && ParkingViewPro.this.a.e() != 14) || ParkingViewPro.this.a.e() == 24 || ParkingViewPro.this.a.e() == 36 || ParkingViewPro.this.a.e() > 64) {
                    Log.i("ParkingViewPro", "mRearMirror mGearImageView is visible");
                    SoundPlayer.getInstance().playUnOperated();
                    return;
                }
                Log.i("ParkingViewPro", "mRearMirror.onClick");
                Intent intent = new Intent("com.xiaopeng.carcontrol.intent.action.ACTION_SHOW_MIRROR_CONTROL_PANEL");
                intent.setPackage(IpcConfig.App.CAR_CONTROL);
                com.xiaopeng.autopilot.base.a.g().getApplicationContext().sendBroadcast(intent);
            }
        });
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean booleanValue = ((i.ag) com.xiaopeng.autopilot.base.i.a(i.ag.class)).d().booleanValue();
                Log.i("ParkingViewPro", "mMapLayout.onClick.srAnimatorStart = " + booleanValue + "," + (System.currentTimeMillis() - ParkingViewPro.this.R));
                if (!booleanValue || System.currentTimeMillis() - ParkingViewPro.this.R >= 800 || System.currentTimeMillis() - ParkingViewPro.this.S >= 500) {
                    ParkingViewPro.this.S = System.currentTimeMillis();
                    int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
                    Log.i("ParkingViewPro", "mMapLayout.onClick.type = " + intValue);
                    if (intValue == -1) {
                        ParkingViewPro.this.a.o(-2);
                        ParkingViewPro.this.l(-2);
                    } else if (intValue == -2) {
                        ParkingViewPro.this.a.o(-1);
                        ParkingViewPro.this.l(-1);
                    } else if (intValue == -14) {
                        SoundPlayer.getInstance().playUnOperated();
                    }
                }
            }
        });
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void E() {
        tw twVar = this.a;
        if (twVar == null) {
            return;
        }
        int A = twVar.A();
        this.v.setVisibility(8);
        this.u.setAlpha(1.0f);
        this.F.cancel();
        if (com.xiaopeng.autopilot.base.d.c()) {
            Log.i("ParkingViewPro", "updateTrainingAPBtn.trainingTips = " + A + "," + this.C);
        }
        if (this.C == 0 && A == 33) {
            F();
        }
        if (ThemeWatcher.getInstance().isNight()) {
            int i = this.C;
            if (i == 1 || i == 2) {
                if (A == 24 && this.C == 2) {
                    this.u.setAlpha(0.0f);
                    this.t.setImageResource(e.d.selector_ap_resume_night);
                    return;
                } else if ((A == 24 || A == 33) && this.C == 1) {
                    F();
                    this.u.setAlpha(0.0f);
                    this.t.setImageResource(e.g.ic_ap_resume_disable_night);
                    return;
                } else if (this.C == 2) {
                    this.u.setAlpha(1.0f);
                    this.v.setVisibility(0);
                    this.F.start();
                    this.t.setImageResource(e.d.selector_training_ap_ready_night);
                    return;
                } else {
                    this.u.setAlpha(1.0f);
                    this.t.setImageResource(e.d.selector_training_ap_normal_night);
                    return;
                }
            } else if (A == 27) {
                this.u.setAlpha(0.0f);
                this.t.setImageResource(e.g.ic_training_ap_disable_night);
                return;
            } else if (A == 24) {
                this.u.setAlpha(0.0f);
                this.t.setImageResource(e.g.ic_ap_resume_disable_night);
                F();
                return;
            } else if (A < 4 || A == 25) {
                this.u.setAlpha(0.3f);
                this.t.setImageResource(e.g.ic_training_ap_normal_disable_night);
                return;
            } else if (A == 4 || A == 30) {
                this.u.setAlpha(1.0f);
                this.v.setVisibility(0);
                this.F.start();
                this.t.setImageResource(e.d.selector_training_ap_ready_night);
                return;
            } else if (A == 15) {
                this.u.setAlpha(1.0f);
                this.t.setImageResource(e.d.selector_training_ap_normal_night);
                return;
            } else {
                this.u.setAlpha(0.3f);
                this.t.setImageResource(e.g.ic_training_ap_normal_disable_night);
                return;
            }
        }
        int i2 = this.C;
        if (i2 == 1 || i2 == 2) {
            if (A == 24 && this.C == 2) {
                this.u.setAlpha(0.0f);
                this.t.setImageResource(e.d.selector_ap_resume);
            } else if ((A == 24 || A == 33) && this.C == 1) {
                F();
                this.u.setAlpha(0.0f);
                this.t.setImageResource(e.g.ic_ap_resume_disable);
            } else if (this.C == 2) {
                this.u.setAlpha(1.0f);
                this.v.setVisibility(0);
                this.F.start();
                this.t.setImageResource(e.d.selector_training_ap_ready);
            } else {
                this.u.setAlpha(1.0f);
                this.t.setImageResource(e.d.selector_training_ap_normal);
            }
        } else if (A == 27) {
            this.u.setAlpha(0.0f);
            this.t.setImageResource(e.g.ic_training_ap_disable);
        } else if (A == 24) {
            F();
            this.u.setAlpha(0.0f);
            this.t.setImageResource(e.g.ic_ap_resume_disable);
        } else if (A < 4 || A == 25) {
            this.u.setAlpha(0.3f);
            this.t.setImageResource(e.g.ic_training_ap_normal_disable);
        } else if (A == 4 || A == 30) {
            this.u.setAlpha(1.0f);
            this.v.setVisibility(0);
            this.F.start();
            this.t.setImageResource(e.d.selector_training_ap_ready);
        } else if (A == 15) {
            this.u.setAlpha(1.0f);
            this.t.setImageResource(e.d.selector_training_ap_normal);
        } else {
            this.u.setAlpha(0.3f);
            this.t.setImageResource(e.g.ic_training_ap_normal_disable);
        }
    }

    private void F() {
        if (((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue() == -6) {
            this.y.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void i(int i) {
        if (com.xiaopeng.autopilot.base.d.c()) {
            Log.i("ParkingViewPro", "onUpdateInfoBoardViewType.type  = " + i);
        }
        this.j.a(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void h(int i) {
        setMapLayoutVisible(i);
    }

    private void setMapLayoutVisible(int i) {
        if (this.P.getVisibility() != i) {
            this.P.setVisibility(i);
        }
        if (this.Q.getVisibility() != i) {
            this.Q.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, float f) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        this.P.setLayoutParams(layoutParams);
        float f2 = f + 1.0f;
        this.P.setScaleX(f2);
        this.P.setScaleY(f2);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void l(final int i) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.15
            @Override // java.lang.Runnable
            public void run() {
                ParkingViewPro.this.t(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i) {
        if (i != -2) {
            if (i == -1) {
                if (ThemeWatcher.getInstance().isNight()) {
                    this.P.setBackgroundResource(e.g.ic_ap_map_view_bg_night);
                } else {
                    this.P.setBackgroundResource(e.g.ic_ap_map_view_bg);
                }
                setMapLayoutVisible(0);
                return;
            }
            return;
        }
        if (ThemeWatcher.getInstance().isNight()) {
            this.P.setBackgroundResource(e.g.ic_ap_map_with_map_night);
        } else {
            this.P.setBackgroundResource(e.g.ic_ap_map_with_map);
        }
        if (this.P.getVisibility() != 0) {
            this.P.setVisibility(0);
        }
        if (this.Q.getVisibility() != 8) {
            this.Q.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(8));
        com.xiaopeng.autopilot.base.i.a(i.ao.class, 0);
        IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
        com.xiaopeng.autopilot.base.c.a().i().statisExit();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(String str, int i) {
        this.j.a(this.a.e(), this.a.f(), str, i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(String str, int i, View.OnClickListener onClickListener, boolean z) {
        this.j.a(z, this.a.e(), i, str, onClickListener);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void b(String str) {
        this.j.a(str, this.a.e());
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void j(int i) {
        this.j.b(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void b(float f) {
        this.j.a((int) Math.floor(f), (float) Math.floor(f / 2.0f));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void b(int i, int i2) {
        this.j.a(i, i2);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void m(int i) {
        this.j.f(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void n(int i) {
        this.j.g(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void o(int i) {
        this.j.h(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(int i, View.OnClickListener onClickListener) {
        if (!((i.w) com.xiaopeng.autopilot.base.i.a(i.w.class)).d().booleanValue() || this.a.c()) {
            a(i);
            if (onClickListener == null) {
                this.o.setOnClickListener(this.U);
            } else {
                this.o.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(int i) {
        if (i == 0) {
            a(true);
        } else {
            a(false);
        }
        if (i == 0) {
            if (!this.a.B()) {
                this.o.setVisibility(i);
            }
        } else {
            this.o.setVisibility(i);
        }
        if (!this.a.c()) {
            r(8);
        } else if (i == 0) {
            r(8);
        } else if (this.a.B()) {
        } else {
            r(0);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(boolean z) {
        if (z) {
            this.o.setClickable(true);
            this.o.setEnabled(true);
            return;
        }
        this.o.setClickable(false);
        this.o.setEnabled(false);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b(final int i) {
        this.a.a(i);
        u(i);
        Log.i("ParkingViewPro", "onParkLotChoseIndex.slotIndex = " + i);
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.17
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i;
                if (i2 < 0 || i2 >= 7) {
                    ParkingViewPro.this.j.a(false);
                } else {
                    ParkingViewPro.this.j.a(true);
                }
                ParkingViewPro.this.j.a(ParkingViewPro.this, false);
            }
        });
    }

    private void u(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        ParkLotItem v = v(i);
        if (v != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            boolean lowConfidence = v.lowConfidence();
            boolean narrow = v.narrow();
            hashMap.put("low", lowConfidence ? BuildInfoUtils.BID_WAN : "0");
            hashMap.put("narrow", narrow ? BuildInfoUtils.BID_WAN : "0");
            hashMap.put(Constants.INDEX, v.getSlotIndex() + "");
            com.xiaopeng.autopilot.base.c.a().i().statisChooseParkingLot(hashMap);
        }
    }

    private ParkLotItem v(int i) {
        ArrayList<ParkLotItem> d = this.a.d();
        if (d != null) {
            Iterator<ParkLotItem> it = d.iterator();
            while (it.hasNext()) {
                ParkLotItem next = it.next();
                if (next != null && next.getSlotIndex() == i) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c(int i) {
        this.j.c(i);
        this.j.i(i);
        if (this.a.B() && (this.a.e() == 3 || this.a.e() == 34)) {
            this.j.d(true);
        } else {
            this.j.d(false);
        }
        if (i == 1 || i == 3) {
            ua.a(0L);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(final float f) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.18
            @Override // java.lang.Runnable
            public void run() {
                ParkingViewPro.this.j.a(f);
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void d(int i) {
        this.j.d(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void e(int i) {
        this.j.e(i);
        this.m.setVisibility(8);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b(boolean z) {
        this.n.a(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(float f, float f2) {
        this.j.a(this.a.e(), f, f2);
        if (this.a.B()) {
            this.j.b(this.a.e(), f2, f);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void setDistanceLayoutVisible(int i) {
        this.j.setDistanceLayoutVisible(i);
    }

    public int getParkLotChoseIndex() {
        return this.b;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(boolean z, int i) {
        this.j.a(z, i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b() {
        this.n.e();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.f
    public void b(int i, boolean z) {
        String string;
        Log.i("ParkingViewPro", "choseIndexAndStart.mLastChooseIndex = " + this.b + ", index = " + i + ",start = " + z);
        if (this.b == i) {
            if (((i.e) com.xiaopeng.autopilot.base.i.a(i.e.class)).d().booleanValue()) {
                string = com.xiaopeng.autopilot.base.a.g().getString(e.i.speech_parking_tips_22_ready_pro);
            } else {
                string = com.xiaopeng.autopilot.base.a.g().getString(e.i.speech_parking_tips_22_ready);
            }
            Log.i("ParkingViewPro", "invalidate = " + rd.a().c() + ",Constant.isSwitchSoundToSpeechTTS() = " + com.xiaopeng.autopilot.base.d.a());
            if (!re.a().h() && !rd.a().c() && com.xiaopeng.autopilot.base.d.a()) {
                rd.a().a(string);
            }
        }
        SoundPlayer.getInstance().playSelectParklot();
        b(i);
        if (z) {
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.19
                @Override // java.lang.Runnable
                public void run() {
                    ParkingViewPro.this.a.a(true);
                }
            }, 500L);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.f
    public void a(int i, int i2) {
        Log.i("ParkingViewPro", "touchUp.mParkingProPresenter.isStartTraining() = " + this.a.B());
        if (this.a.B()) {
            return;
        }
        this.j.b(i, i2);
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(SpeechSuperParkEvent speechSuperParkEvent) {
        if (speechSuperParkEvent == null || !re.a().h() || speechSuperParkEvent.action == 1) {
            return;
        }
        if (speechSuperParkEvent.action == 2) {
            if (speechSuperParkEvent.index == 7) {
                b(0, true);
            } else {
                b(speechSuperParkEvent.index, true);
            }
            com.xiaopeng.autopilot.base.c.a().i().statisStartAutopilot(false, true);
        } else if (speechSuperParkEvent.action == 3) {
            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
            LogUtils.i("ParkingViewPro", "onEvent(SpeechSuperParkEvent), sendAutopilotBroadcast = ACTION_EXIT_AUTO_PARK");
        }
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onCarServicesEvent(IScuController.FsdSwitchEventMsg fsdSwitchEventMsg) {
        if (fsdSwitchEventMsg == null) {
            return;
        }
        int intValue = fsdSwitchEventMsg.getData().intValue();
        Log.i("ParkingViewPro", "onCarServicesEvent.FsdSwitchEventMsg.fsdSwitch = " + intValue);
        this.n.b(intValue);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void k(int i) {
        this.C = i;
        this.j.j(i);
        if (i == 3) {
            this.R = System.currentTimeMillis();
            com.xiaopeng.autopilot.base.i.a(i.f.class, true);
            com.xiaopeng.autopilot.base.i.a(i.j.class, false);
            this.j.d();
        } else {
            this.R = 0L;
            if (i == 7) {
                com.xiaopeng.autopilot.base.i.a(i.j.class, true);
                com.xiaopeng.autopilot.base.i.a(i.f.class, true);
            } else if (i != 6) {
                com.xiaopeng.autopilot.base.i.a(i.f.class, false);
                com.xiaopeng.autopilot.base.i.a(i.j.class, false);
            }
        }
        a();
        org.greenrobot.eventbus.c.a().d(new TrainingControlBtnEvent(i));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void a(String str) {
        this.j.a(str);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void a() {
        int I2 = this.a.I();
        if (com.xiaopeng.autopilot.base.d.c()) {
            Log.i("ParkingViewPro", "updateTrainingButtonVisible.currentAPStatus = " + I2 + "," + this.a.B());
        }
        if (this.a.B() || this.a.C() || I2 == 6) {
            this.F.cancel();
            this.x.setVisibility(8);
        } else if (this.a.e() < 64) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
            this.F.cancel();
        }
        if (this.a.s().isInNavStartPointProcedure()) {
            rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.20
                @Override // java.lang.Runnable
                public void run() {
                    ParkingViewPro.this.y.setVisibility(0);
                }
            });
        }
        E();
    }

    public void a(com.xiaopeng.autopilot.base.e eVar) {
        tw twVar = this.a;
        if (twVar != null) {
            twVar.a(eVar);
        }
    }

    public void u() {
        this.a.v();
    }

    public void v() {
        this.a.P();
    }

    public void r(int i) {
        if (this.C == 3) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(i);
        }
        if (i == 0) {
            boolean booleanValue = ((i.f) com.xiaopeng.autopilot.base.i.a(i.f.class)).d().booleanValue();
            Log.i("ParkingViewPro", "updateParkingBVisible.hasActive = " + booleanValue);
            if (booleanValue) {
                boolean booleanValue2 = ((i.j) com.xiaopeng.autopilot.base.i.a(i.j.class)).d().booleanValue();
                Log.i("ParkingViewPro", "updateParkingBVisible.apSearchingActive = " + booleanValue2);
                if (booleanValue2) {
                    if (ThemeWatcher.getInstance().isNight()) {
                        this.q.setImageResource(e.g.parking_ap_status_search_night);
                        return;
                    } else {
                        this.q.setImageResource(e.g.parking_ap_status_search);
                        return;
                    }
                } else if (ThemeWatcher.getInstance().isNight()) {
                    this.q.setImageResource(e.g.ic_ap_parking_b_night);
                    return;
                } else {
                    this.q.setImageResource(e.g.ic_ap_parking_b);
                    return;
                }
            }
            this.q.setImageResource(e.g.ic_parking_b);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void k() {
        this.j.b();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void l() {
        this.j.c();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void a(List<Integer> list, int i) {
        Log.i("ParkingViewPro", "updateFinishFailView.fail = " + list);
        org.greenrobot.eventbus.c.a().d(new TrainingFailPageEvent(list, i));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void a(int i, int i2, int i3, int i4) {
        Log.i("ParkingViewPro", "updateFinishSuccessView.distance = " + i + "," + i2 + "," + i4);
        org.greenrobot.eventbus.c.a().d(new TrainingSuccessPageEvent(i, i2, i3, i4));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void f() {
        Log.i("ParkingViewPro", "showSavingTimeOutDialog");
        if (this.A == null) {
            this.A = new XDialog(getContext(), e.j.XDialogView);
            this.A.setMessage(e.i.training_saving_timeout_message);
            this.A.setTitle(e.i.training_saving_timeout_title);
            this.A.getDialog().setCanceledOnTouchOutside(false);
            this.A.getDialog().getWindow().setType(2047);
            this.A.setPositiveButton(getResources().getString(e.i.training_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.21
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    ParkingViewPro.this.A.dismiss();
                    ParkingViewPro.this.a.w();
                    ParkingViewPro.this.a.J();
                }
            });
        }
        this.A.show();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void g() {
        Log.i("ParkingViewPro", "showTrainingUpDownOutDialog");
        if (this.B == null) {
            this.B = new XDialog(getContext(), e.j.XDialogView);
            this.B.setMessage(e.i.training_up_down_out_message);
            this.B.setTitle(e.i.training_up_down_out_title);
            this.B.getDialog().setCanceledOnTouchOutside(false);
            this.B.getDialog().getWindow().setType(2047);
            this.B.setPositiveButton(getResources().getString(e.i.training_up_down_out_btn), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingViewPro.22
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    ParkingViewPro.this.B.dismiss();
                }
            });
        }
        this.B.show();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void e(boolean z) {
        this.j.c(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void h() {
        Log.i("ParkingViewPro", "updateAPFinishPage");
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(2));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void o() {
        int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
        Log.i("ParkingViewPro", "showAPFirstPage.scene = " + intValue);
        this.a.o(-5);
        a();
        com.xiaopeng.autopilot.base.d.e(3);
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(1));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public boolean i() {
        return com.xiaopeng.autopilot.parking.c.p();
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void m() {
        this.r.setVisibility(0);
        rh.a().e(this.T);
        rh.a().a(this.T, 3000L);
        if (ThemeWatcher.getInstance().isNight()) {
            this.r.setBackgroundResource(e.g.ic_ap_cancel_bg_night);
            this.s.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_cancel_tv_color_night));
            return;
        }
        this.r.setBackgroundResource(e.g.ic_ap_cancel_bg);
        this.s.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_cancel_tv_color));
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void n() {
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(7));
    }

    @org.greenrobot.eventbus.m
    public void onEvent(String str) {
        if (str.equalsIgnoreCase(ShortcutEvent.OPEN_REVERING_HOLD_H5_EVENT)) {
            this.n.a(1);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void c(int i, int i2) {
        this.j.c(i, i2);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void p(int i) {
        this.k.setVisibility(i);
        if (i == 0) {
            this.j.setAlpha(0.0f);
        } else {
            this.j.setAlpha(1.0f);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void q(int i) {
        Log.i("ParkingViewPro", "updateAPKeyParkingVisible.visible = " + i);
        this.w.setVisibility(i);
    }

    public void s(int i) {
        Log.i("ParkingViewPro", "onParkingViewDrawTypeChange.drawType = " + i);
        if (i == -4 || i == -5 || i == -8 || i == -15 || i == -16 || i == -7) {
            this.y.setVisibility(0);
        } else if (i == -14 && this.a.S()) {
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void a(String str, boolean z, boolean z2, String str2) {
        this.j.a(str, z, z2, str2);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void f(boolean z) {
        this.j.d(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void g(boolean z) {
        this.j.e(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.h
    public void h(boolean z) {
        this.j.b(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c(boolean z) {
        if (z) {
            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(11));
        } else {
            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(12));
        }
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        SettingAttentionView settingAttentionView;
        View view;
        SettingAttentionView settingAttentionView2;
        View view2;
        if (this.o.getVisibility() == 0 && this.o.isClickable() && (settingAttentionView2 = this.n) != null && settingAttentionView2.f() && (view2 = this.k) != null && view2.getVisibility() == 8 && !com.xiaopeng.autopilot.parking.c.w() && !com.xiaopeng.autopilot.parking.c.p() && !H()) {
            LogUtils.i("ParkingViewPro", "onEvent BackPressedEvent ---> 相应泊车默认泊车关闭按钮");
            G();
        } else if (!((this.o.getVisibility() == 0 && this.o.isClickable()) || (settingAttentionView = this.n) == null || !settingAttentionView.f() || (view = this.k) == null || view.getVisibility() != 8 || com.xiaopeng.autopilot.parking.c.w() || com.xiaopeng.autopilot.parking.c.p() || this.a.B()) || H()) {
            LogUtils.i("ParkingViewPro", "onEvent BackPressedEvent ---> back_pressed_error");
            XToast.showShort(e.i.back_pressed_error);
        }
    }

    private boolean H() {
        int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
        LogUtils.i("ParkingViewPro", "ParkingScene = " + intValue);
        return intValue == 1 || intValue == -1 || intValue == -3 || intValue == -12 || intValue == -13 || intValue == -14;
    }
}
