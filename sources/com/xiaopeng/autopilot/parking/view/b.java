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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingAPPageRemoveEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.n;
import com.xiaopeng.lib.framework.configuration.BuildConfig;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: APFinishPageView.java */
/* loaded from: classes.dex */
public class b extends RelativeLayout implements ThemeWatcher.OnThemeSwitchListener {
    private static final int u = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_icon_top_margin));
    private static final int v = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_distance_top_margin));
    private static final int w = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_spd_num_top_margin));
    private static final int x = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_floor_top_margin));
    private static final int y = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_title_top_margin));
    private ValueAnimator A;
    private ValueAnimator B;
    private ValueAnimator C;
    private ValueAnimator D;
    private ValueAnimator E;
    private PathInterpolator F;
    private XButton a;
    private XButton b;
    private XButton c;
    private XButton d;
    private XImageButton e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private ValueAnimator r;
    private View s;
    private View t;
    private ValueAnimator z;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.F = new PathInterpolator(0.15f, 0.0f, 0.15f, 0.0f);
        a();
        j();
        d();
    }

    private void j() {
        this.z = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z.setDuration(500L);
        this.z.setInterpolator(this.F);
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), b.this.p, b.u, true);
            }
        });
        this.A = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.A.setDuration(500L);
        this.A.setInterpolator(this.F);
        this.A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), b.this.f, b.y, false);
            }
        });
        this.A.setStartDelay(100L);
        this.B = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.B.setDuration(500L);
        this.B.setInterpolator(this.F);
        this.B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), b.this.m, b.v, false);
            }
        });
        this.B.setStartDelay(200L);
        this.C = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.C.setDuration(500L);
        this.C.setInterpolator(this.F);
        this.C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), b.this.o, b.w, false);
            }
        });
        this.C.setStartDelay(400L);
        this.D = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.D.setDuration(500L);
        this.D.setInterpolator(this.F);
        this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), b.this.n, b.x, false);
            }
        });
        this.D.setStartDelay(300L);
        this.E = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.E.setDuration(36000L);
        this.E.setRepeatCount(-1);
        this.E.setRepeatMode(1);
        this.E.setInterpolator(new LinearInterpolator());
        this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.k.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
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

    private void k() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.z.cancel();
        }
        ValueAnimator valueAnimator2 = this.A;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.A.cancel();
        }
        ValueAnimator valueAnimator3 = this.B;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            this.B.cancel();
        }
        ValueAnimator valueAnimator4 = this.C;
        if (valueAnimator4 != null && valueAnimator4.isRunning()) {
            this.C.cancel();
        }
        ValueAnimator valueAnimator5 = this.D;
        if (valueAnimator5 != null && valueAnimator5.isRunning()) {
            this.D.cancel();
        }
        ValueAnimator valueAnimator6 = this.E;
        if (valueAnimator6 == null || !valueAnimator6.isRunning()) {
            return;
        }
        this.E.cancel();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Log.i("APFinishPageView", "onAttachedToWindow");
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
        IntentUtil.apFinishPageShowLearningSummonBtnShow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Log.i("APFinishPageView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        k();
        com.xiaopeng.autopilot.base.i.a(i.h.class, false);
        com.xiaopeng.autopilot.base.i.a(i.y.class, 0);
        ThemeWatcher.getInstance().removeThemeListener(this);
        com.xiaopeng.autopilot.parking.c.h();
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        l();
    }

    private void l() {
        if (ThemeWatcher.getInstance().isNight()) {
            this.d.setBackgroundResource(e.d.auto_btn_try_again_selector_night);
            this.k.setImageResource(e.g.ic_training_finish_success_light_night);
            this.j.setImageResource(e.g.ic_ap_finish_night);
            this.d.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color_night));
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.f.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            this.i.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            this.t.setBackgroundResource(e.d.ic_training_ap_right_view_bg_night);
            this.q.setBackgroundResource(e.d.ic_training_ap_top_view_bg_night);
            this.l.setImageResource(e.g.ic_training_finish_success_bg_night);
            this.m.setBackgroundResource(e.g.ic_training_finish_distance_bg_night);
            this.o.setBackgroundResource(e.g.ic_training_finish_spd_car_bg_night);
            this.n.setBackgroundResource(e.g.ic_training_finish_spd_man_bg_night);
            return;
        }
        this.k.setImageResource(e.g.ic_training_finish_success_light);
        this.j.setImageResource(e.g.ic_ap_finish);
        this.d.setBackgroundResource(e.d.auto_btn_try_again_selector);
        this.d.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color));
        this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.f.setTextColor(-16777216);
        this.g.setTextColor(-16777216);
        this.h.setTextColor(-16777216);
        this.i.setTextColor(-16777216);
        this.t.setBackgroundResource(e.d.ic_training_ap_right_view_bg);
        this.q.setBackgroundResource(e.d.ic_training_ap_top_view_bg);
        this.l.setImageResource(e.g.ic_training_finish_success_bg);
        this.m.setBackgroundResource(e.g.ic_training_finish_distance_bg);
        this.o.setBackgroundResource(e.g.ic_training_finish_spd_car_bg);
        this.n.setBackgroundResource(e.g.ic_training_finish_spd_man_bg);
    }

    public void a() {
        this.s = LayoutInflater.from(getContext()).inflate(e.f.layout_ap_finish_page, (ViewGroup) this, true);
        this.a = (XButton) findViewById(e.C0055e.ap_finish_btn_control);
        this.b = (XButton) findViewById(e.C0055e.ap_finish_comment_btn);
        this.d = (XButton) findViewById(e.C0055e.ap_finish_btn_learn);
        this.c = (XButton) findViewById(e.C0055e.ap_finish_share_btn);
        this.e = (XImageButton) findViewById(e.C0055e.ap_finish_page_close);
        this.f = (TextView) findViewById(e.C0055e.ap_finish_title);
        this.g = (TextView) findViewById(e.C0055e.ap_finish_page_success_distance);
        this.h = (TextView) findViewById(e.C0055e.ap_finish_page_success_passing_car);
        this.i = (TextView) findViewById(e.C0055e.ap_finish_page_round_people);
        this.j = (ImageView) findViewById(e.C0055e.ap_finish_page_icon);
        this.q = findViewById(e.C0055e.ap_finish_page_top_bg);
        this.t = findViewById(e.C0055e.ap_finish_page_right_bg);
        this.k = (ImageView) findViewById(e.C0055e.ap_finish_page_light);
        this.l = (ImageView) findViewById(e.C0055e.ap_finish_page_light_bg);
        this.m = findViewById(e.C0055e.ap_finish_page_success_distance_layout);
        this.n = findViewById(e.C0055e.ap_finish_page_success_round_people_layout);
        this.o = findViewById(e.C0055e.ap_finish_page_success_passing_car_layout);
        this.p = findViewById(e.C0055e.ap_finish_icon_layout);
        this.r.setDuration(800L);
        this.r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    public void b() {
        boolean booleanValue = ((i.j) com.xiaopeng.autopilot.base.i.a(i.j.class)).d().booleanValue();
        int mapType = com.xiaopeng.autopilot.parking.c.s().getMapType();
        int intValue = ((i.at) com.xiaopeng.autopilot.base.i.a(i.at.class)).d().intValue();
        Log.i("APFinishPageView", "apSearchingActive = " + booleanValue + "," + mapType + "," + intValue);
        if (booleanValue) {
            this.f.setText(e.i.ap_searching_finish_title_text);
        } else {
            this.f.setText(e.i.ap_finish_title_text);
        }
        if (mapType == 2 || mapType == 3) {
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            this.a.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.b.getLayoutParams()).leftMargin = getContext().getResources().getDimensionPixelSize(e.c.ap_finish_comment_button_left_margin);
        } else if (mapType == 0) {
            this.b.setVisibility(8);
            if (rf.a(getContext()).a(com.xiaopeng.autopilot.parking.c.s().getMapId())) {
                this.c.setVisibility(8);
            } else if (booleanValue) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
            }
            if (booleanValue) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(8);
            }
            if (this.c.getVisibility() != 0 && this.d.getVisibility() != 0) {
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            if (this.c.getVisibility() == 0) {
                layoutParams.leftMargin = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_share_left_with_share));
            } else {
                layoutParams.leftMargin = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_share_left_without_share));
            }
            this.d.setLayoutParams(layoutParams);
        } else {
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.a.setVisibility(0);
        }
    }

    public void c() {
        int l = com.xiaopeng.autopilot.parking.c.l();
        Log.i("APFinishPageView", "showDistanceData.distance = " + l);
        this.g.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_distance, new Object[]{Integer.valueOf(l)}));
        this.h.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_passing_car, new Object[]{Integer.valueOf(com.xiaopeng.autopilot.parking.c.n())}));
        this.i.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_finish_success_round_people, new Object[]{Integer.valueOf(com.xiaopeng.autopilot.parking.c.k())}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Log.i("APFinishPageView", "mClose");
        org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
        com.xiaopeng.autopilot.base.i.a(i.h.class, false);
        com.xiaopeng.autopilot.parking.c.f();
        com.xiaopeng.autopilot.base.d.e(1);
        IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
    }

    public void d() {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.b.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.m();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.b.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("APFinishPageView", "mControlBtn");
                org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
                com.xiaopeng.autopilot.base.i.a(i.h.class, false);
                com.xiaopeng.autopilot.parking.c.f();
                com.xiaopeng.autopilot.base.d.e(1);
                IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ua.b(new n.a() { // from class: com.xiaopeng.autopilot.parking.view.b.3.1
                    @Override // com.xiaopeng.autopilot.parking.view.n.a
                    public void a() {
                        b.this.b.setVisibility(8);
                        b.this.m();
                    }
                });
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ua.a(new n.a() { // from class: com.xiaopeng.autopilot.parking.view.b.4.1
                    @Override // com.xiaopeng.autopilot.parking.view.n.a
                    public void a() {
                        b.this.c.setVisibility(8);
                        ((RelativeLayout.LayoutParams) b.this.d.getLayoutParams()).leftMargin = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_finish_share_left_without_share));
                    }
                });
            }
        });
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        XImageButton xImageButton = this.e;
        if (xImageButton == null || xImageButton.getVisibility() != 0) {
            return;
        }
        Log.i("APFinishPageView", "BackPressedEvent");
        m();
    }
}
