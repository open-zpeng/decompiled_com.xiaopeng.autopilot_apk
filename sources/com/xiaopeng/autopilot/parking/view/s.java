package com.xiaopeng.autopilot.parking.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingAPPageRemoveEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.n;
import com.xiaopeng.lib.framework.configuration.BuildConfig;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: TrainingFinishPageView.java */
/* loaded from: classes.dex */
public class s extends RelativeLayout implements com.xiaopeng.autopilot.base.f, ThemeWatcher.OnThemeSwitchListener {
    private static final int B = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_icon_top_margin));
    private static final int C = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_distance_top_margin));
    private static final int D = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_spd_num_top_margin));
    private static final int E = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_floor_top_margin));
    private static final int F = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_fail_a_top_margin));
    private static final int G = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_fail_b_top_margin));
    private static final int H = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_fail_c_margin));
    private static final int I = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_training_finish_page_title_top_margin));
    private View A;
    private ValueAnimator J;
    private ValueAnimator K;
    private ValueAnimator L;
    private ValueAnimator M;
    private ValueAnimator N;
    private ValueAnimator O;
    private ValueAnimator P;
    private ValueAnimator Q;
    private ValueAnimator R;
    private PathInterpolator S;
    private XTextView T;
    private LinearLayout U;
    private TextView V;
    private TextView W;
    private XButton a;
    private TextView aa;
    private View ab;
    private View ac;
    private View ad;
    private int[] ae;
    private int[] af;
    private XButton b;
    private TextView c;
    private XImageButton d;
    private RelativeLayout e;
    private RelativeLayout f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private TextView k;
    private View l;
    private TextView m;
    private View n;
    private RelativeLayout o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private View t;
    private ImageView u;
    private ImageView v;
    private View w;
    private View x;
    private int y;
    private List<Integer> z;

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.R = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.S = new PathInterpolator(0.15f, 0.0f, 0.15f, 0.0f);
        this.ae = new int[]{e.g.training_fail_1, e.g.training_fail_2, e.g.training_fail_3, e.g.training_fail_4, e.g.training_fail_5, e.g.training_fail_6};
        this.af = new int[]{e.g.training_fail_1_night, e.g.training_fail_2_night, e.g.training_fail_3_night, e.g.training_fail_4_night, e.g.training_fail_5_night, e.g.training_fail_6_night};
        a();
        b();
        k();
    }

    private void k() {
        this.J = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.J.setDuration(500L);
        this.J.setInterpolator(this.S);
        this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), s.this.t, s.B, true);
            }
        });
        this.K = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.K.setDuration(500L);
        this.K.setInterpolator(this.S);
        this.K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), (View) s.this.c, s.I, false);
            }
        });
        this.K.setStartDelay(100L);
        this.L = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.L.setDuration(500L);
        this.L.setInterpolator(this.S);
        this.L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), s.this.l, s.C, false);
            }
        });
        this.L.setStartDelay(200L);
        this.M = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M.setDuration(500L);
        this.M.setInterpolator(this.S);
        this.M.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), s.this.n, s.D, false);
            }
        });
        this.M.setStartDelay(300L);
        this.N = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.N.setDuration(500L);
        this.N.setInterpolator(this.S);
        this.N.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), (View) s.this.p, s.F, false);
            }
        });
        this.N.setStartDelay(200L);
        this.O = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.O.setDuration(500L);
        this.O.setInterpolator(this.S);
        this.O.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), (View) s.this.q, s.G, false);
            }
        });
        this.O.setStartDelay(300L);
        this.P = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.P.setDuration(500L);
        this.P.setInterpolator(this.S);
        this.P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), (View) s.this.r, s.H, false);
            }
        });
        this.P.setStartDelay(400L);
        this.Q = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.Q.setDuration(36000L);
        this.Q.setRepeatCount(-1);
        this.Q.setRepeatMode(1);
        this.Q.setInterpolator(new LinearInterpolator());
        this.Q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.u.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, View view, int i, boolean z) {
        if (z) {
            float f2 = (f * 0.5f) + 0.5f;
            view.setScaleX(f2);
            view.setScaleY(f2);
        }
        view.setAlpha(f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = (int) (i + BuildConfig.VERSION_CODE + ((0.0f - f) * 150.0f));
        view.setLayoutParams(layoutParams);
    }

    private void l() {
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.J.cancel();
        }
        ValueAnimator valueAnimator2 = this.K;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.K.cancel();
        }
        ValueAnimator valueAnimator3 = this.L;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            this.L.cancel();
        }
        ValueAnimator valueAnimator4 = this.M;
        if (valueAnimator4 != null && valueAnimator4.isRunning()) {
            this.M.cancel();
        }
        ValueAnimator valueAnimator5 = this.N;
        if (valueAnimator5 != null && valueAnimator5.isRunning()) {
            this.N.cancel();
        }
        ValueAnimator valueAnimator6 = this.O;
        if (valueAnimator6 != null && valueAnimator6.isRunning()) {
            this.O.cancel();
        }
        ValueAnimator valueAnimator7 = this.P;
        if (valueAnimator7 != null && valueAnimator7.isRunning()) {
            this.P.cancel();
        }
        ValueAnimator valueAnimator8 = this.Q;
        if (valueAnimator8 == null || !valueAnimator8.isRunning()) {
            return;
        }
        this.Q.cancel();
    }

    public void a(int i, int i2, int i3, int i4) {
        Log.i("TrainingFinishPageView", "updateSuccessType.distance = " + i + "," + i2 + "," + i3 + ", finishType:" + i4);
        this.y = i4;
        this.T.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        if (this.y == 2) {
            rf.a(com.xiaopeng.autopilot.base.a.g()).a(com.xiaopeng.autopilot.parking.c.s().getMapId(), false);
            this.c.setText(e.i.training_finish_success_title);
            this.a.setText(e.i.training_finish_success_btn);
            if (com.xiaopeng.autopilot.base.d.j()) {
                this.U.setVisibility(0);
            } else {
                this.e.setVisibility(0);
            }
            this.b.setVisibility(0);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            layoutParams.leftMargin = 960;
            layoutParams.topMargin = -250;
            layoutParams2.leftMargin = 960;
            layoutParams2.topMargin = -250;
            layoutParams3.leftMargin = 1319;
            layoutParams4.leftMargin = getContext().getResources().getDimensionPixelSize(e.c.training_success_finish_pageview_title_success_left_margin);
            layoutParams4.topMargin = getContext().getResources().getDimensionPixelSize(e.c.training_success_finish_pageview_title_success_top_margin);
            layoutParams5.topMargin = 100;
            if (com.xiaopeng.autopilot.base.d.o) {
                this.T.setVisibility(0);
            }
        } else {
            this.c.setText(e.i.training_after_ap_finish_success_title);
            this.a.setText(e.i.training_finish_or_cancal_confirm);
            this.e.setVisibility(8);
            this.U.setVisibility(8);
            this.b.setVisibility(8);
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            layoutParams.leftMargin = -160;
            layoutParams.topMargin = -100;
            layoutParams2.leftMargin = -160;
            layoutParams2.topMargin = -100;
            layoutParams3.leftMargin = 187;
            layoutParams4.leftMargin = getContext().getResources().getDimensionPixelSize(e.c.training_success_finish_pageview_title_other_left_margin);
            layoutParams4.topMargin = getContext().getResources().getDimensionPixelSize(e.c.training_success_finish_pageview_title_other_top_margin);
            layoutParams5.topMargin = 250;
        }
        this.o.setVisibility(8);
        this.m.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_spd_num, new Object[]{Integer.valueOf(i2)}));
        this.k.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_distance, new Object[]{Integer.valueOf(i)}));
        this.aa.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_spd_num, new Object[]{Integer.valueOf(i2)}));
        this.W.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_distance, new Object[]{Integer.valueOf(i)}));
        this.V.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_ramp, new Object[]{Integer.valueOf(i3)}));
        if (ThemeWatcher.getInstance().isNight()) {
            if (this.y == 2) {
                this.s.setImageResource(e.g.ic_training_finish_success_night);
            } else {
                this.s.setImageResource(e.g.ic_training_after_ap_finish_success_night);
            }
            this.l.setBackgroundResource(e.g.ic_training_finish_distance_bg_night);
            this.n.setBackgroundResource(e.g.ic_training_finish_spd_num_bg_night);
            this.ad.setBackgroundResource(e.g.ic_training_finish_ramp_spd_bump_bg_night);
            this.ab.setBackgroundResource(e.g.ic_training_finish_ramp_ramp_bg_night);
            this.ac.setBackgroundResource(e.g.ic_training_finish_ramp_distance_bg_night);
            this.v.setImageResource(e.g.ic_training_finish_success_bg_night);
        } else {
            if (this.y == 2) {
                this.s.setImageResource(e.g.ic_training_finish_success);
            } else {
                this.s.setImageResource(e.g.ic_training_after_ap_finish_success);
            }
            this.l.setBackgroundResource(e.g.ic_training_finish_distance_bg);
            this.n.setBackgroundResource(e.g.ic_training_finish_spd_num_bg);
            this.ad.setBackgroundResource(e.g.ic_training_finish_ramp_spd_bump_bg);
            this.ab.setBackgroundResource(e.g.ic_training_finish_ramp_ramp_bg);
            this.ac.setBackgroundResource(e.g.ic_training_finish_ramp_distance_bg);
            this.v.setImageResource(e.g.ic_training_finish_success_bg);
        }
        m();
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
        org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
        com.xiaopeng.autopilot.base.i.a(i.y.class, 0);
        ThemeWatcher.getInstance().removeThemeListener(this);
        org.greenrobot.eventbus.c.a().c(this);
    }

    public void a(List<Integer> list, int i) {
        Log.i("TrainingFinishPageView", "updateFailType.fail = " + list + "," + i);
        this.y = i;
        this.z = list;
        int i2 = this.y;
        if (i2 == 1) {
            this.c.setText(e.i.training_finish_fail_title);
            this.a.setText(e.i.training_finish_fail_btn);
        } else if (i2 == 4) {
            this.c.setText(e.i.training_after_ap_finish_fail_title);
            this.a.setText(e.i.training_finish_or_cancal_confirm);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.leftMargin = 960;
        layoutParams.topMargin = -250;
        layoutParams2.leftMargin = 960;
        layoutParams2.topMargin = -250;
        ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).leftMargin = 1319;
        layoutParams3.leftMargin = 1445;
        layoutParams3.topMargin = 506;
        ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = 100;
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.b.setVisibility(8);
        this.e.setVisibility(8);
        this.U.setVisibility(8);
        this.T.setVisibility(8);
        if (list.size() == 0) {
            this.o.setVisibility(8);
        } else if (list.size() == 1) {
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            if (ThemeWatcher.getInstance().isNight()) {
                this.p.setImageResource(this.af[list.get(0).intValue()]);
            } else {
                this.p.setImageResource(this.ae[list.get(0).intValue()]);
            }
            this.q.setVisibility(8);
            this.r.setVisibility(8);
        } else if (list.size() == 2) {
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            if (ThemeWatcher.getInstance().isNight()) {
                this.p.setImageResource(this.af[list.get(0).intValue()]);
                this.q.setImageResource(this.af[list.get(1).intValue()]);
            } else {
                this.p.setImageResource(this.ae[list.get(0).intValue()]);
                this.q.setImageResource(this.ae[list.get(1).intValue()]);
            }
        } else {
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.r.setVisibility(0);
            if (ThemeWatcher.getInstance().isNight()) {
                this.p.setImageResource(this.af[list.get(0).intValue()]);
                this.q.setImageResource(this.af[list.get(1).intValue()]);
                this.r.setImageResource(this.af[list.get(2).intValue()]);
            } else {
                this.p.setImageResource(this.ae[list.get(0).intValue()]);
                this.q.setImageResource(this.ae[list.get(1).intValue()]);
                this.r.setImageResource(this.ae[list.get(2).intValue()]);
            }
        }
        m();
    }

    public void a() {
        this.A = LayoutInflater.from(getContext()).inflate(e.f.layout_training_success_fail_page, (ViewGroup) this, true);
        this.f = (RelativeLayout) findViewById(e.C0055e.training_after_ap_finish_page_success_layout);
        this.g = (TextView) findViewById(e.C0055e.training_after_ap_finish_page_success_title);
        this.h = (ImageView) findViewById(e.C0055e.training_after_ap_finish_page_success_img_1);
        this.i = (ImageView) findViewById(e.C0055e.training_after_ap_finish_page_success_img_2);
        this.j = (ImageView) findViewById(e.C0055e.training_after_ap_finish_page_success_img_3);
        this.a = (XButton) findViewById(e.C0055e.training_finish_page_btn_control);
        this.b = (XButton) findViewById(e.C0055e.training_finish_page_btn_share);
        this.c = (TextView) findViewById(e.C0055e.training_finish_page_title);
        this.d = (XImageButton) findViewById(e.C0055e.training_finish_page_ib_close);
        this.e = (RelativeLayout) findViewById(e.C0055e.training_finish_page_success_layout);
        this.k = (TextView) findViewById(e.C0055e.training_finish_page_success_distance);
        this.m = (TextView) findViewById(e.C0055e.training_finish_page_success_spd_num);
        this.o = (RelativeLayout) findViewById(e.C0055e.training_finish_page_fail_layout);
        this.p = (ImageView) findViewById(e.C0055e.training_finish_page_fail_a_icon);
        this.q = (ImageView) findViewById(e.C0055e.training_finish_page_fail_b_icon);
        this.r = (ImageView) findViewById(e.C0055e.training_finish_page_fail_c_icon);
        this.s = (ImageView) findViewById(e.C0055e.training_finish_page_icon);
        this.w = findViewById(e.C0055e.training_finish_page_right_bg);
        this.x = findViewById(e.C0055e.training_ap_finish_btn_layout);
        this.l = findViewById(e.C0055e.training_finish_page_success_distance_layout);
        this.n = findViewById(e.C0055e.training_finish_page_success_spd_num_layout);
        this.v = (ImageView) findViewById(e.C0055e.training_finish_success_bg);
        this.u = (ImageView) findViewById(e.C0055e.training_finish_success_light);
        this.t = findViewById(e.C0055e.training_finish_icon_layout);
        this.R.setDuration(800L);
        this.R.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.s.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.this.A.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.T = (XTextView) findViewById(e.C0055e.training_finish_page_subtitle);
        this.W = (TextView) findViewById(e.C0055e.ramp_feature_distance);
        this.V = (TextView) findViewById(e.C0055e.ramp_feature_ramp);
        this.aa = (TextView) findViewById(e.C0055e.ramp_feature_speed_bump);
        this.U = (LinearLayout) findViewById(e.C0055e.ap_finish_ramp_feature_layout);
        this.ac = findViewById(e.C0055e.ramp_feature_distance_layout);
        this.ab = findViewById(e.C0055e.ramp_feature_ramp_layout);
        this.ad = findViewById(e.C0055e.ramp_feature_speed_bump_layout);
    }

    private void m() {
        if (ThemeWatcher.getInstance().isNight()) {
            this.u.setImageResource(e.g.ic_training_finish_success_light_night);
            this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.b.setBackgroundResource(e.d.auto_btn_try_again_selector_night);
            this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color_night));
            int i = this.y;
            if (i == 3) {
                this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_title_color_night));
            } else if (i == 2) {
                this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_title_color_night));
            } else {
                this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_tips_color_night));
            }
            this.w.setBackgroundResource(e.d.ic_training_ap_right_view_bg_night);
            this.x.setBackgroundResource(e.d.ic_training_ap_top_view_bg_night);
            int i2 = this.y;
            if (i2 == 2 || i2 == 3) {
                if (this.y == 2) {
                    this.s.setImageResource(e.g.ic_training_finish_success_night);
                } else {
                    this.s.setImageResource(e.g.ic_training_after_ap_finish_success_night);
                }
                this.k.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color_night));
                this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color_night));
                this.l.setBackgroundResource(e.g.ic_training_finish_distance_bg_night);
                this.n.setBackgroundResource(e.g.ic_training_finish_spd_num_bg_night);
                this.ad.setBackgroundResource(e.g.ic_training_finish_ramp_spd_bump_bg_night);
                this.ab.setBackgroundResource(e.g.ic_training_finish_ramp_ramp_bg_night);
                this.ac.setBackgroundResource(e.g.ic_training_finish_ramp_distance_bg_night);
                this.V.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color_night));
                this.W.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color_night));
                this.aa.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color_night));
                this.v.setImageResource(e.g.ic_training_finish_success_bg_night);
                this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color_night));
                this.h.setImageResource(e.g.training_after_ap_success_1_night);
                this.i.setImageResource(e.g.training_after_ap_success_2_night);
                this.j.setImageResource(e.g.training_after_ap_success_3_night);
                this.f.setBackgroundResource(e.d.training_after_ap_success_bg_night);
                return;
            } else if (i2 == 1 || i2 == 4) {
                this.s.setImageResource(e.g.ic_training_finish_fail_night);
                List<Integer> list = this.z;
                if (list != null) {
                    if (list.size() == 1) {
                        this.p.setImageResource(this.af[this.z.get(0).intValue()]);
                        return;
                    } else if (this.z.size() == 2) {
                        this.p.setImageResource(this.af[this.z.get(0).intValue()]);
                        this.q.setImageResource(this.af[this.z.get(1).intValue()]);
                        return;
                    } else if (this.z.size() == 3) {
                        this.p.setImageResource(this.af[this.z.get(0).intValue()]);
                        this.q.setImageResource(this.af[this.z.get(1).intValue()]);
                        this.r.setImageResource(this.af[this.z.get(2).intValue()]);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else {
                return;
            }
        }
        this.u.setImageResource(e.g.ic_training_finish_success_light);
        this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.b.setBackgroundResource(e.d.auto_btn_try_again_selector);
        this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color));
        int i3 = this.y;
        if (i3 == 3) {
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_title_color));
        } else if (i3 == 2) {
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_title_color));
        } else {
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_tips_color));
        }
        this.w.setBackgroundResource(e.d.ic_training_ap_right_view_bg);
        this.x.setBackgroundResource(e.d.ic_training_ap_top_view_bg);
        int i4 = this.y;
        if (i4 == 2 || i4 == 3) {
            if (this.y == 2) {
                this.s.setImageResource(e.g.ic_training_finish_success);
            } else {
                this.s.setImageResource(e.g.ic_training_after_ap_finish_success);
            }
            this.k.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color));
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color));
            this.l.setBackgroundResource(e.g.ic_training_finish_distance_bg);
            this.n.setBackgroundResource(e.g.ic_training_finish_spd_num_bg);
            this.ad.setBackgroundResource(e.g.ic_training_finish_ramp_spd_bump_bg);
            this.ab.setBackgroundResource(e.g.ic_training_finish_ramp_ramp_bg);
            this.ac.setBackgroundResource(e.g.ic_training_finish_ramp_distance_bg);
            this.V.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color));
            this.W.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color));
            this.aa.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_success_data_color));
            this.v.setImageResource(e.g.ic_training_finish_success_bg);
            this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color));
            this.h.setImageResource(e.g.training_after_ap_success_1);
            this.i.setImageResource(e.g.training_after_ap_success_2);
            this.j.setImageResource(e.g.training_after_ap_success_3);
            this.f.setBackgroundResource(e.d.training_after_ap_success_bg);
        } else if (i4 == 1 || i4 == 4) {
            this.s.setImageResource(e.g.ic_training_finish_fail);
            List<Integer> list2 = this.z;
            if (list2 != null) {
                if (list2.size() == 1) {
                    this.p.setImageResource(this.ae[this.z.get(0).intValue()]);
                } else if (this.z.size() == 2) {
                    this.p.setImageResource(this.ae[this.z.get(0).intValue()]);
                    this.q.setImageResource(this.ae[this.z.get(1).intValue()]);
                } else if (this.z.size() == 3) {
                    this.p.setImageResource(this.ae[this.z.get(0).intValue()]);
                    this.q.setImageResource(this.ae[this.z.get(1).intValue()]);
                    this.r.setImageResource(this.ae[this.z.get(2).intValue()]);
                }
            }
        }
    }

    public void b() {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.s.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("TrainingFinishPageView", "mClose.mFinishType = " + s.this.y);
                org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
                s.this.c();
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("TrainingFinishPageView", "mControlBtn.mFinishType = " + s.this.y);
                org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
                rd.a().e();
                com.xiaopeng.autopilot.parking.c.g();
                if (s.this.y == 2 || s.this.y == 1) {
                    com.xiaopeng.autopilot.base.i.a(i.ao.class, Integer.valueOf(s.this.y));
                    com.xiaopeng.autopilot.parking.c.c();
                    return;
                }
                com.xiaopeng.autopilot.parking.c.f();
                com.xiaopeng.autopilot.base.i.a(i.ao.class, 0);
                IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.s.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ua.a(new n.a() { // from class: com.xiaopeng.autopilot.parking.view.s.4.1
                    @Override // com.xiaopeng.autopilot.parking.view.n.a
                    public void a() {
                        s.this.b.setVisibility(8);
                    }
                });
            }
        });
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        XImageButton xImageButton = this.d;
        if (xImageButton == null || xImageButton.getVisibility() != 0) {
            return;
        }
        Log.i("TrainingFinishPageView", "BackPressedEvent mClose.mFinishType = " + this.y);
        org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
        c();
    }

    public void c() {
        Log.i("TrainingFinishPageView", "closeFinishPage");
        com.xiaopeng.autopilot.parking.c.f();
        com.xiaopeng.autopilot.base.i.a(i.ao.class, 0);
        if (CarApiUtil.getGear() == 1) {
            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
        }
    }
}
