package com.xiaopeng.autopilot.parking.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraStateEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageView;
/* loaded from: classes.dex */
public class APInfoBoardView extends RelativeLayout implements ThemeWatcher.OnThemeSwitchListener {
    private RelativeLayout A;
    private TextView B;
    private RelativeLayout C;
    private ImageView D;
    private TextView E;
    private ImageView F;
    private View G;
    private XButton H;
    private ParkingViewPro I;
    private AbsoluteSizeSpan J;
    private ValueAnimator K;
    private ValueAnimator L;
    private ValueAnimator M;
    private int S;
    private ValueAnimator T;
    private ValueAnimator U;
    private boolean V;
    private long c;
    private int d;
    private ImageView e;
    private View f;
    private TextView g;
    private TextView h;
    private XButton i;
    private ImageView j;
    private View k;
    private TextView l;
    private XImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private RelativeLayout z;
    public static final String[] a = com.xiaopeng.autopilot.base.a.g().getResources().getStringArray(e.a.array_no_use);
    public static final String[] b = com.xiaopeng.autopilot.base.a.g().getResources().getStringArray(e.a.array_no_use_toast);
    private static final int N = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.distance_layout_margin_left_when_right));
    private static final int O = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.distance_layout_margin_left_when_left));
    private static final int P = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.ap_status_layout_margin_left_when_right));
    private static final int Q = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.ap_status_layout_margin_left_when_left));
    private static final int R = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.ap_status_layout_margin_left_when_left_7));

    static /* synthetic */ int b(APInfoBoardView aPInfoBoardView) {
        int i = aPInfoBoardView.d;
        aPInfoBoardView.d = i + 1;
        return i;
    }

    public APInfoBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public APInfoBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = new AbsoluteSizeSpan(UIUtils.sp2px(getContext(), 34.0f));
        this.V = false;
        f();
        h();
    }

    private void f() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_pro_ap_view, (ViewGroup) this, true);
        this.z = (RelativeLayout) findViewById(e.C0055e.parking_ap_running_layout);
        this.e = (ImageView) findViewById(e.C0055e.parking_ap_status_bg_view);
        this.f = findViewById(e.C0055e.parking_ap_current_status_title_layout);
        this.g = (TextView) findViewById(e.C0055e.parking_ap_current_status_title);
        this.h = (TextView) findViewById(e.C0055e.parking_ap_current_status_second_title);
        this.i = (XButton) findViewById(e.C0055e.ap_btn_parking_continue);
        this.j = (ImageView) findViewById(e.C0055e.parking_ap_turn);
        this.k = findViewById(e.C0055e.parking_ap_turn_layout);
        this.B = (TextView) findViewById(e.C0055e.ap_tv_speed);
        this.l = (TextView) findViewById(e.C0055e.ap_tv_parking_tip);
        this.m = (XImageView) findViewById(e.C0055e.parking_ap_status);
        this.q = (TextView) findViewById(e.C0055e.ap_tv_distance_pre);
        this.r = (TextView) findViewById(e.C0055e.ap_tv_distance);
        this.s = (TextView) findViewById(e.C0055e.ap_tv_distance_unit);
        this.t = (TextView) findViewById(e.C0055e.ap_tv_round_people_pre);
        this.u = (TextView) findViewById(e.C0055e.ap_tv_round_people);
        this.v = (TextView) findViewById(e.C0055e.ap_tv_round_people_unit);
        this.w = (TextView) findViewById(e.C0055e.ap_tv_passing_car);
        this.x = (TextView) findViewById(e.C0055e.ap_tv_passing_car_pre);
        this.y = (TextView) findViewById(e.C0055e.ap_tv_round_passing_car_unit);
        this.A = (RelativeLayout) findViewById(e.C0055e.parking_ap_distance_layout);
        this.n = (ImageView) findViewById(e.C0055e.ap_distance_img);
        this.o = (ImageView) findViewById(e.C0055e.ap_round_people_img);
        this.p = (ImageView) findViewById(e.C0055e.ap_passing_car_img);
        this.C = (RelativeLayout) findViewById(e.C0055e.ap_crossing_layout);
        this.D = (ImageView) findViewById(e.C0055e.ap_crossing_img);
        this.E = (TextView) findViewById(e.C0055e.ap_crossing_tips);
        this.F = (ImageView) findViewById(e.C0055e.ap_crossing_bg_img);
        this.G = findViewById(e.C0055e.test_read_ap_map);
        this.H = (XButton) findViewById(e.C0055e.ap_btn_parking_control);
        BuildInfoUtils.isUserVersion();
        this.G.setVisibility(8);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (System.currentTimeMillis() - APInfoBoardView.this.c >= 5000) {
                    APInfoBoardView.this.d = 0;
                    APInfoBoardView.this.c = System.currentTimeMillis();
                } else {
                    APInfoBoardView.b(APInfoBoardView.this);
                }
                if (APInfoBoardView.this.d == 10) {
                    APInfoBoardView.this.I.a.O();
                }
            }
        });
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APInfoBoardView.this.I.a.a(true);
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APInfoBoardView.this.I.a.Q();
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APInfoBoardView.this.g();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APInfoBoardView.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int e = this.I.a.e();
        Log.i("APInfoBoardView", "apStatusClick.currentTips = " + e);
        if (e == 84) {
            XToast.show(e.i.parking_ap_can_not_change_search_with_tips_84);
            return;
        }
        int intValue = ((i.c) com.xiaopeng.autopilot.base.i.a(i.c.class)).d().intValue();
        Log.i("APInfoBoardView", "apStatusClick.status = " + intValue);
        if (intValue == 3) {
            this.I.a.P();
        } else if (intValue == 7) {
            this.I.a.v();
        }
    }

    public void setParkingView(ParkingViewPro parkingViewPro) {
        this.I = parkingViewPro;
    }

    private void h() {
        this.M = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M.setDuration(1600L);
        this.M.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                APInfoBoardView.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.K = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.K.setDuration(800L);
        this.K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                APInfoBoardView.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.L = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.L.setDuration(800L);
        this.L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                APInfoBoardView.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.T = ValueAnimator.ofFloat(0.0f, 78.0f);
        this.T.setDuration(600L);
        this.U = ValueAnimator.ofFloat(-46.5f, 99.0f);
        this.U.setDuration(800L);
        this.U.setRepeatCount(4);
        this.U.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                APInfoBoardView.this.j.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.U.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                APInfoBoardView.this.k.setVisibility(8);
            }
        });
    }

    public void a() {
        Log.i("APInfoBoardView", "startInAnimation");
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.M.cancel();
            }
            this.M.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f) {
        this.p.setAlpha(f);
        this.x.setAlpha(f);
        this.w.setAlpha(f);
        this.y.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f) {
        Log.i("APInfoBoardView", "updateLeftMargin.percent = " + f);
        b(f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
        if (this.I.a.I() == 7) {
            int i = R;
            layoutParams.leftMargin = i + ((int) ((P - i) * f));
        } else {
            int i2 = Q;
            layoutParams.leftMargin = i2 + ((int) ((P - i2) * f));
        }
        int i3 = O;
        layoutParams2.leftMargin = i3 + ((int) ((N - i3) * f));
        this.z.setLayoutParams(layoutParams);
        this.A.setLayoutParams(layoutParams2);
        this.f.setAlpha(f);
        this.e.setAlpha(f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
        i();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    private void i() {
        boolean booleanValue = ((i.j) com.xiaopeng.autopilot.base.i.a(i.j.class)).d().booleanValue();
        if (ThemeWatcher.getInstance().isNight()) {
            this.i.setBackgroundResource(e.d.auto_btn_try_again_selector_night);
            this.i.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color_night));
            this.e.setImageResource(e.g.parking_ap_status_bg_night);
            this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_status_second_title_color_night));
            this.H.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.E.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_crossing_tips_color_night));
            this.F.setImageResource(e.g.ic_ap_crossing_bg_night);
            if (this.D.getTag() != null && ((Integer) this.D.getTag()).intValue() == 3) {
                this.D.setImageResource(e.g.ic_ap_ramp_warning_night);
            } else {
                this.D.setImageResource(e.g.ic_ap_crossing_warning_night);
            }
            this.n.setImageResource(e.g.ic_ap_distance_night);
            this.o.setImageResource(e.g.ic_ap_man_night);
            this.p.setImageResource(e.g.ic_ap_car_night);
            this.k.setBackgroundResource(e.g.ic_ap_turn_bg_night);
            if (booleanValue) {
                this.m.setImageResource(e.g.parking_ap_status_search_night);
            } else {
                this.m.setImageResource(e.g.parking_ap_status_ap_night);
            }
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_status_text_color_night));
            this.B.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_status_text_color_night));
            this.q.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.s.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.t.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.v.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.y.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.x.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.r.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color_night));
            this.u.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color_night));
            this.w.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color_night));
            return;
        }
        this.i.setBackgroundResource(e.d.auto_btn_try_again_selector);
        this.i.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color));
        this.e.setImageResource(e.g.parking_ap_status_bg);
        this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color));
        this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_status_second_title_color_day));
        this.H.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.E.setTextColor(-16777216);
        this.F.setImageResource(e.g.ic_ap_crossing_bg);
        if (this.D.getTag() != null && ((Integer) this.D.getTag()).intValue() == 3) {
            this.D.setImageResource(e.g.ic_ap_ramp_warning);
        } else {
            this.D.setImageResource(e.g.ic_ap_crossing_warning);
        }
        this.D.setImageResource(e.g.ic_ap_crossing_warning);
        this.n.setImageResource(e.g.ic_ap_distance);
        this.o.setImageResource(e.g.ic_ap_man);
        this.p.setImageResource(e.g.ic_ap_car);
        this.k.setBackgroundResource(e.g.ic_ap_turn_bg);
        if (booleanValue) {
            this.m.setImageResource(e.g.parking_ap_status_search);
        } else {
            this.m.setImageResource(e.g.parking_ap_status_ap);
        }
        this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_status_text_color));
        this.B.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_status_text_color));
        this.q.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.s.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.t.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.v.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.y.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.x.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.r.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color));
        this.u.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color));
        this.w.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color));
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        i();
        c(this.S);
    }

    private void e(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.s.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_xpilot_3_remain_distance_m));
        this.r.setText(String.valueOf(i));
    }

    public void a(String str, int i) {
        int intValue;
        Log.i("APInfoBoardView", "updateTips.tips = " + str + "," + i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        if (i == 110 || i == 114 || i == 115) {
            this.H.setVisibility(0);
            this.i.setVisibility(0);
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(e.c.certain_tips_top_margin);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.c.certain_tips_left_margin);
            this.l.setTextSize(getContext().getResources().getDimensionPixelSize(e.c.certain_tips_text_size));
            this.B.setVisibility(8);
            this.A.setVisibility(8);
            if (com.xiaopeng.autopilot.base.d.n) {
                this.e.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
            }
        } else {
            this.H.setVisibility(8);
            this.i.setVisibility(8);
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(e.c.other_tips_top_margin);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.c.other_tips_left_margin);
            this.l.setTextSize(getContext().getResources().getDimensionPixelSize(e.c.other_tips_text_size));
            this.B.setVisibility(0);
            this.A.setVisibility(0);
            if (com.xiaopeng.autopilot.base.d.n && (intValue = ((i.c) com.xiaopeng.autopilot.base.i.a(i.c.class)).d().intValue()) != 8 && intValue != 9) {
                this.e.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
            }
        }
        this.l.setLayoutParams(layoutParams);
        this.l.setText(str);
    }

    public void a(int i, float f) {
        e(i);
    }

    public void a(int i) {
        this.u.setText(String.valueOf(i));
    }

    public void b(int i) {
        this.w.setText(String.valueOf(i));
    }

    public void c(int i) {
        this.S = i;
        Log.i("APInfoBoardView", "updateArrow.direction = " + i);
        switch (i) {
            case 1:
                this.j.setRotation(0.0f);
                ValueAnimator valueAnimator = this.T;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.T.cancel();
                }
                this.T.removeAllUpdateListeners();
                this.T.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        APInfoBoardView.this.j.setX(31.5f - ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                this.T.removeAllListeners();
                this.T.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.6
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Log.i("APInfoBoardView", "TURN_LEFT.mTurnAnimator.onAnimationStart");
                        APInfoBoardView.this.V = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Log.i("APInfoBoardView", "TURN_LEFT.mTurnAnimator.onAnimationEnd.mCanRepeat = " + APInfoBoardView.this.V);
                        if (APInfoBoardView.this.V) {
                            APInfoBoardView.this.V = false;
                            APInfoBoardView.this.U.reverse();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        Log.i("APInfoBoardView", "TURN_LEFT.mTurnAnimator.onAnimationCancel");
                        APInfoBoardView.this.V = false;
                    }
                });
                this.T.start();
                this.k.setVisibility(0);
                return;
            case 2:
                this.j.setRotation(180.0f);
                ValueAnimator valueAnimator2 = this.T;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.T.cancel();
                }
                this.T.removeAllUpdateListeners();
                this.T.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        APInfoBoardView.this.j.setX(((Float) valueAnimator3.getAnimatedValue()).floatValue() + 21.0f);
                    }
                });
                this.T.removeAllListeners();
                this.T.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.4
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Log.i("APInfoBoardView", "TURN_RIGHT.mTurnAnimator.onAnimationStart");
                        APInfoBoardView.this.V = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Log.i("APInfoBoardView", "TURN_RIGHT.mTurnAnimator.onAnimationEnd.mCanRepeat = " + APInfoBoardView.this.V);
                        if (APInfoBoardView.this.V) {
                            APInfoBoardView.this.V = false;
                            APInfoBoardView.this.U.start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        Log.i("APInfoBoardView", "TURN_RIGHT.mTurnAnimator.onAnimationCancel");
                        APInfoBoardView.this.V = false;
                    }
                });
                this.T.start();
                this.k.setVisibility(0);
                return;
            default:
                ValueAnimator valueAnimator3 = this.T;
                if (valueAnimator3 != null && valueAnimator3.isRunning()) {
                    this.T.cancel();
                }
                ValueAnimator valueAnimator4 = this.U;
                if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                    this.U.cancel();
                }
                this.k.setVisibility(8);
                return;
        }
    }

    public void a(float f) {
        int d = d(f);
        a(ThemeWatcher.getInstance().isNight());
        String valueOf = String.valueOf(d);
        int length = valueOf.length();
        SpannableString spannableString = new SpannableString(valueOf + " km/h");
        spannableString.setSpan(this.J, 0, length, 18);
        this.B.setText(spannableString);
    }

    private int d(float f) {
        return (int) Math.abs(Math.ceil(f * 1.05f));
    }

    public void a(boolean z) {
        if (!z) {
            this.B.setTextColor(getResources().getColor(e.b.speed_color));
        } else {
            this.B.setTextColor(getResources().getColor(e.b.speed_color_night));
        }
    }

    @org.greenrobot.eventbus.m
    public void onEvent(final CameraStateEvent cameraStateEvent) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.APInfoBoardView.7
            @Override // java.lang.Runnable
            public void run() {
                if (APInfoBoardView.this.getVisibility() != 0) {
                    if (cameraStateEvent.mState == 1) {
                        APInfoBoardView.this.c(0.0f);
                        return;
                    } else if (cameraStateEvent.mState == 2) {
                        APInfoBoardView.this.c(1.0f);
                        return;
                    } else {
                        return;
                    }
                }
                if (com.xiaopeng.autopilot.base.d.c()) {
                    Log.i("APInfoBoardView", "event = " + cameraStateEvent.mState);
                }
                if (cameraStateEvent.mState == 1) {
                    APInfoBoardView.this.b();
                } else if (cameraStateEvent.mState == 2) {
                    APInfoBoardView.this.c();
                }
            }
        });
    }

    public void b() {
        Log.i("APInfoBoardView", "onAnimatorLeft");
        if (d()) {
            return;
        }
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L.cancel();
        }
        ValueAnimator valueAnimator2 = this.M;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.M.cancel();
        }
        ValueAnimator valueAnimator3 = this.K;
        if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
            Log.i("APInfoBoardView", "onAnimatorLeft.start");
            this.K.start();
        }
    }

    public void c() {
        Log.i("APInfoBoardView", "onAnimatorRight");
        if (e()) {
            return;
        }
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K.cancel();
        }
        ValueAnimator valueAnimator2 = this.M;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.M.cancel();
        }
        ValueAnimator valueAnimator3 = this.L;
        if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
            Log.i("APInfoBoardView", "onAnimatorRight.start");
            this.L.start();
        }
    }

    public boolean d() {
        RelativeLayout relativeLayout = this.A;
        if (relativeLayout == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        Log.i("APInfoBoardView", "isLeft.distanceParams.leftMargin = " + layoutParams.leftMargin);
        return layoutParams.leftMargin == O;
    }

    public boolean e() {
        RelativeLayout relativeLayout = this.A;
        if (relativeLayout == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        Log.i("APInfoBoardView", "isRight.distanceParams.leftMargin = " + layoutParams.leftMargin);
        return layoutParams.leftMargin == N;
    }

    public void a(int i, int i2) {
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i2);
            if (i == 2) {
                this.D.setTag(2);
                this.E.setText(e.i.ap_crossing_tips_105);
                if (ThemeWatcher.getInstance().isNight()) {
                    this.D.setImageResource(e.g.ic_ap_crossing_warning_night);
                } else {
                    this.D.setImageResource(e.g.ic_ap_crossing_warning);
                }
            } else if (i == 3) {
                this.D.setTag(3);
                this.E.setText(e.i.parking_ap_pass_ramp_tips_76_77_info_board);
                if (ThemeWatcher.getInstance().isNight()) {
                    this.D.setImageResource(e.g.ic_ap_ramp_warning_night);
                } else {
                    this.D.setImageResource(e.g.ic_ap_ramp_warning);
                }
            } else {
                this.D.setTag(0);
                this.E.setText(e.i.ap_crossing_tips_text);
                if (ThemeWatcher.getInstance().isNight()) {
                    this.D.setImageResource(e.g.ic_ap_crossing_warning_night);
                } else {
                    this.D.setImageResource(e.g.ic_ap_crossing_warning);
                }
            }
        }
    }

    public void d(int i) {
        if (i == 3) {
            this.g.setText(e.i.parking_ap_status_current_ap_title);
            this.h.setText(e.i.parking_ap_status_current_ap_second_title);
            this.m.setImageResource(e.g.parking_ap_status_ap);
        } else if (i == 7) {
            this.g.setText(e.i.parking_ap_status_current_ap_searching_title);
            this.h.setText(e.i.parking_ap_status_current_ap_searching_second_title);
            this.m.setImageResource(e.g.parking_ap_status_search);
        }
        if (!com.xiaopeng.autopilot.base.d.n) {
            if (i == 8 || i == 9) {
                this.e.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                return;
            }
            this.e.setVisibility(0);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            return;
        }
        if (this.H.getVisibility() != 0 || this.i.getVisibility() != 0) {
            this.e.setVisibility(0);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
        }
        Log.d("APInfoBoardView", "status = " + i);
        if (i == 8 || i == 9) {
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
        }
    }
}
