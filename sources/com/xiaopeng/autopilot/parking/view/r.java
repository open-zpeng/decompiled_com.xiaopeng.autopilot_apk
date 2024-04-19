package com.xiaopeng.autopilot.parking.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingAPPageRemoveEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XProgressBar;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: TrainingFinishLearnView.java */
/* loaded from: classes.dex */
public class r extends RelativeLayout implements com.xiaopeng.autopilot.base.f, ThemeWatcher.OnThemeSwitchListener {
    private Runnable A;
    private XButton a;
    private View b;
    private TextView c;
    private View d;
    private View e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private XProgressBar i;
    private XProgressBar j;
    private XProgressBar k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private View r;
    private View s;
    private View t;
    private ValueAnimator u;
    private XImageButton v;
    private View w;
    private int x;
    private XDialog y;
    private Runnable z;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.r.1
            @Override // java.lang.Runnable
            public void run() {
                rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_2_go_on));
            }
        };
        this.A = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.r.2
            @Override // java.lang.Runnable
            public void run() {
                rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_1));
            }
        };
        a();
        g();
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        j();
    }

    private void j() {
        Log.i("TrainingFinishLearnView", "isNight = " + ThemeWatcher.getInstance().isNight());
        if (ThemeWatcher.getInstance().isNight()) {
            this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.tv_parking_attention_title_night));
            this.d.setBackgroundResource(e.d.ic_training_ap_top_view_bg_night);
            this.e.setBackgroundResource(e.d.ic_training_ap_right_view_bg_night);
            switch (this.x) {
                case 1:
                    this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
                    this.o.setImageResource(e.g.ic_training_finish_learn_01_night);
                    this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
                    this.p.setImageResource(e.g.ic_training_unfinish_learn_02_night);
                    this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color_night));
                    this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg_night));
                    this.q.setImageResource(e.g.ic_training_unfinish_learn_03_night);
                    this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color_night));
                    this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg_night));
                    return;
                case 2:
                    this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
                    this.p.setImageResource(e.g.ic_training_finish_learn_02_night);
                    this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
                    this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
                    this.f.setImageResource(e.g.ic_training_learn_completed_night);
                    this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
                    this.q.setImageResource(e.g.ic_training_unfinish_learn_03_night);
                    this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color_night));
                    this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg_night));
                    return;
                case 3:
                    this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
                    this.q.setImageResource(e.g.ic_training_finish_learn_03_night);
                    this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
                    this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
                    this.f.setImageResource(e.g.ic_training_learn_completed_night);
                    this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
                    this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
                    this.g.setImageResource(e.g.ic_training_learn_completed_night);
                    this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
                    return;
                case 4:
                    this.h.setImageResource(e.g.ic_training_learn_large_completed_night);
                    return;
                default:
                    return;
            }
        }
        this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.tv_parking_attention_title_day));
        this.d.setBackgroundResource(e.d.ic_training_ap_top_view_bg);
        this.e.setBackgroundResource(e.d.ic_training_ap_right_view_bg);
        switch (this.x) {
            case 1:
                this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
                this.o.setImageResource(e.g.ic_training_finish_learn_01);
                this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
                this.p.setImageResource(e.g.ic_training_unfinish_learn_02);
                this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color));
                this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg));
                this.q.setImageResource(e.g.ic_training_unfinish_learn_03);
                this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color));
                this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg));
                return;
            case 2:
                this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
                this.p.setImageResource(e.g.ic_training_finish_learn_02);
                this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
                this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
                this.f.setImageResource(e.g.ic_training_learn_completed);
                this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
                this.q.setImageResource(e.g.ic_training_unfinish_learn_03);
                this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color));
                this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg));
                return;
            case 3:
                this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
                this.q.setImageResource(e.g.ic_training_finish_learn_03);
                this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
                this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
                this.f.setImageResource(e.g.ic_training_learn_completed);
                this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
                this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
                this.g.setImageResource(e.g.ic_training_learn_completed);
                this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
                return;
            case 4:
                this.h.setImageResource(e.g.ic_training_learn_large_completed);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    public void a() {
        this.w = LayoutInflater.from(getContext()).inflate(e.f.layout_training_finish_learn_page, (ViewGroup) this, true);
        this.a = (XButton) findViewById(e.C0055e.training_learn_btn_control);
        this.b = findViewById(e.C0055e.training_learn_btn_control_view);
        this.c = (TextView) findViewById(e.C0055e.training_success_learn_title);
        this.v = (XImageButton) findViewById(e.C0055e.training_learn_page_close);
        this.d = findViewById(e.C0055e.training_finish_learn_top_bg);
        this.e = findViewById(e.C0055e.training_finish_learn_right_bg);
        this.f = (ImageView) findViewById(e.C0055e.training_finish_learn_one_done_img);
        this.g = (ImageView) findViewById(e.C0055e.training_finish_learn_two_done_img);
        this.h = (ImageView) findViewById(e.C0055e.training_finish_learn_three_done_img);
        this.i = (XProgressBar) findViewById(e.C0055e.training_learning_step_one_progress);
        this.j = (XProgressBar) findViewById(e.C0055e.training_learning_step_two_progress);
        this.k = (XProgressBar) findViewById(e.C0055e.training_learning_step_three_progress);
        this.o = (ImageView) findViewById(e.C0055e.training_finish_step_one_number_img);
        this.p = (ImageView) findViewById(e.C0055e.training_finish_step_two_number_img);
        this.q = (ImageView) findViewById(e.C0055e.training_finish_step_three_number_img);
        this.l = (TextView) findViewById(e.C0055e.training_finish_learn_step_one_message);
        this.m = (TextView) findViewById(e.C0055e.training_finish_learn_step_two_message);
        this.n = (TextView) findViewById(e.C0055e.training_finish_learn_step_three_message);
        this.r = findViewById(e.C0055e.training_finish_learn_step_one_layout);
        this.s = findViewById(e.C0055e.training_finish_learn_step_two_layout);
        this.t = findViewById(e.C0055e.training_finish_learn_step_three_layout);
        this.u.setDuration(800L);
        this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.r.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                r.this.w.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    public void b() {
        int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
        Log.i("TrainingFinishLearnView", "attachWindow.finishType = " + intValue);
        if (intValue == 1) {
            this.c.setText(e.i.training_finish_learn_training_title);
            this.a.setText(e.i.training_first_page_btn_control_title);
            rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_1));
            f();
            rh.a().a(this.z, 10000L);
        } else if (intValue == 2) {
            this.c.setText(e.i.training_finish_learn_ap_title);
            this.a.setText(e.i.start_parking_ap);
            rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_learn_step_1_before));
            rh.a().e(this.A);
            rh.a().a(this.A, 2000L);
            f();
            rh.a().a(this.z, 10000L);
        }
        if (ThemeWatcher.getInstance().isNight()) {
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.tv_parking_attention_title_night));
            this.d.setBackgroundResource(e.d.ic_training_ap_top_view_bg_night);
            this.e.setBackgroundResource(e.d.ic_training_ap_right_view_bg_night);
            return;
        }
        this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.tv_parking_attention_title_day));
        this.d.setBackgroundResource(e.d.ic_training_ap_top_view_bg);
        this.e.setBackgroundResource(e.d.ic_training_ap_right_view_bg);
    }

    public void c() {
        Log.i("TrainingFinishLearnView", "updateOneFinish.mStep = " + this.x);
        if (this.x == 2) {
            return;
        }
        rh.a().e(this.A);
        this.x = 2;
        com.xiaopeng.autopilot.base.i.a(i.t.class, Integer.valueOf(this.x));
        com.xiaopeng.autopilot.base.i.a(i.ar.class, 2);
        rh.a().e(this.z);
        this.o.setVisibility(8);
        this.i.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.p.setVisibility(0);
        this.j.setVisibility(0);
        this.j.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_learn_progress_drawable));
        this.h.setVisibility(8);
        this.q.setVisibility(0);
        this.k.setVisibility(8);
        int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
        Log.i("TrainingFinishLearnView", "updateOneFinish.finishType = " + intValue);
        if (intValue == 1) {
            this.n.setText(e.i.training_learn_three_step_fail);
            this.b.setVisibility(8);
        } else {
            this.n.setText(e.i.training_learn_three_step);
            this.b.setVisibility(0);
        }
        if (ThemeWatcher.getInstance().isNight()) {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.f.setImageResource(e.g.ic_training_learn_completed_night);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
            this.p.setImageResource(e.g.ic_training_finish_learn_02_night);
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
            this.q.setImageResource(e.g.ic_training_unfinish_learn_03_night);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg_night));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color_night));
        } else {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.f.setImageResource(e.g.ic_training_learn_completed);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
            this.p.setImageResource(e.g.ic_training_finish_learn_02);
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
            this.q.setImageResource(e.g.ic_training_unfinish_learn_03);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color));
        }
        this.a.setEnabled(false);
    }

    public void d() {
        Log.i("TrainingFinishLearnView", "updateTwoFinish.mStep = " + this.x);
        if (this.x == 3) {
            return;
        }
        this.x = 3;
        com.xiaopeng.autopilot.base.i.a(i.t.class, Integer.valueOf(this.x));
        rh.a().e(this.A);
        this.o.setVisibility(8);
        this.i.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.p.setVisibility(8);
        this.j.setVisibility(8);
        this.h.setVisibility(8);
        this.q.setVisibility(0);
        this.k.setVisibility(0);
        this.k.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_learn_progress_drawable));
        int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
        Log.i("TrainingFinishLearnView", "updateTwoFinish.finishType = " + intValue);
        if (intValue == 1) {
            this.n.setText(e.i.training_learn_three_step_fail);
            com.xiaopeng.autopilot.base.i.a(i.ar.class, 7);
            this.b.setVisibility(8);
        } else {
            this.n.setText(e.i.training_learn_three_step);
            com.xiaopeng.autopilot.base.i.a(i.ar.class, 3);
            this.b.setVisibility(0);
        }
        if (ThemeWatcher.getInstance().isNight()) {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.f.setImageResource(e.g.ic_training_learn_completed_night);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.g.setImageResource(e.g.ic_training_learn_completed_night);
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
            this.q.setImageResource(e.g.ic_training_finish_learn_03_night);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
        } else {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.f.setImageResource(e.g.ic_training_learn_completed);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.g.setImageResource(e.g.ic_training_learn_completed);
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
            this.q.setImageResource(e.g.ic_training_finish_learn_03);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
        }
        this.a.setEnabled(false);
    }

    public void e() {
        Log.i("TrainingFinishLearnView", "updateThreeFinish.mStep = " + this.x);
        if (this.x == 4) {
            return;
        }
        this.x = 4;
        com.xiaopeng.autopilot.base.i.a(i.t.class, Integer.valueOf(this.x));
        rh.a().e(this.A);
        int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
        Log.i("TrainingFinishLearnView", "updateThreeFinish.finishType = " + intValue);
        if (intValue == 1) {
            com.xiaopeng.autopilot.base.i.a(i.ar.class, 8);
            this.n.setText(e.i.training_learn_three_step_fail);
        } else {
            com.xiaopeng.autopilot.base.i.a(i.ar.class, 4);
            this.n.setText(e.i.training_learn_three_step);
        }
        this.o.setVisibility(8);
        this.i.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.p.setVisibility(8);
        this.j.setVisibility(8);
        this.m.setText(e.i.training_learn_two_step);
        this.h.setVisibility(0);
        this.q.setVisibility(8);
        this.k.setVisibility(8);
        if (ThemeWatcher.getInstance().isNight()) {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.f.setImageResource(e.g.ic_training_learn_completed_night);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.g.setImageResource(e.g.ic_training_learn_completed_night);
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color_night));
            this.h.setImageResource(e.g.ic_training_learn_large_completed_night);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
        } else {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.f.setImageResource(e.g.ic_training_learn_completed);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.g.setImageResource(e.g.ic_training_learn_completed);
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learned_text_color));
            this.h.setImageResource(e.g.ic_training_learn_large_completed);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
        }
        this.a.setEnabled(true);
        this.b.setVisibility(8);
    }

    public void f() {
        Log.i("TrainingFinishLearnView", "backToOrigin.mStep = " + this.x);
        if (this.x == 1) {
            return;
        }
        this.x = 1;
        com.xiaopeng.autopilot.base.i.a(i.t.class, Integer.valueOf(this.x));
        com.xiaopeng.autopilot.base.i.a(i.ar.class, 1);
        this.i.setVisibility(0);
        this.i.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_learn_progress_drawable));
        this.o.setVisibility(0);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.p.setVisibility(0);
        this.j.setVisibility(8);
        this.h.setVisibility(8);
        this.q.setVisibility(0);
        this.k.setVisibility(8);
        int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
        Log.i("TrainingFinishLearnView", "backToOrigin.finishType = " + intValue);
        if (intValue == 1) {
            this.n.setText(e.i.training_learn_three_step_fail);
            this.b.setVisibility(8);
        } else {
            this.n.setText(e.i.training_learn_three_step);
            this.b.setVisibility(0);
        }
        if (ThemeWatcher.getInstance().isNight()) {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg_night));
            this.o.setImageResource(e.g.ic_training_finish_learn_01_night);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color_night));
            this.p.setImageResource(e.g.ic_training_unfinish_learn_02_night);
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg_night));
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color_night));
            this.q.setImageResource(e.g.ic_training_unfinish_learn_03_night);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg_night));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color_night));
        } else {
            this.r.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_step_bg));
            this.o.setImageResource(e.g.ic_training_finish_learn_01);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_learning_text_color));
            this.p.setImageResource(e.g.ic_training_unfinish_learn_02);
            this.s.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg));
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color));
            this.q.setImageResource(e.g.ic_training_unfinish_learn_03);
            this.t.setBackground(com.xiaopeng.autopilot.base.a.g().getDrawable(e.g.ic_training_learn_unfinish_step_bg));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_finish_learn_unlearn_text_color));
        }
        this.a.setEnabled(false);
    }

    public void g() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.r.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
                int intValue2 = ((i.c) com.xiaopeng.autopilot.base.i.a(i.c.class)).d().intValue();
                Log.i("TrainingFinishLearnView", "mControlView.finishType = " + intValue + ",apStatus = " + intValue2 + "," + r.this.x);
                if (intValue == 2) {
                    if (intValue2 != 1) {
                        if (r.this.x < 4) {
                            SoundPlayer.getInstance().playUnOperated();
                            XToast.showShort(com.xiaopeng.autopilot.base.a.g().getString(e.i.toast_training_learn_before_can_use));
                            return;
                        } else if (intValue2 == 5) {
                            String string = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_ap_st_5);
                            XToast.showShort(string);
                            rd.a().d(string);
                            return;
                        } else {
                            return;
                        }
                    }
                    int intValue3 = ((i.a) com.xiaopeng.autopilot.base.i.a(i.a.class)).d().intValue();
                    Log.i("TrainingFinishLearnView", "mControlView.apErrorTips = " + intValue3);
                    String str = APInfoBoardView.a[intValue3];
                    XToast.showShort(str);
                    rd.a().d(str);
                }
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.r.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((i.at) com.xiaopeng.autopilot.base.i.a(i.at.class)).d().intValue();
                int intValue2 = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
                int intValue3 = ((i.c) com.xiaopeng.autopilot.base.i.a(i.c.class)).d().intValue();
                Log.i("TrainingFinishLearnView", "mControlBtn.finishType = " + intValue2 + ",trainingTips = " + intValue + ",apStatus = " + intValue3);
                if (intValue2 == 2) {
                    if (intValue3 == 2) {
                        com.xiaopeng.autopilot.parking.c.e();
                        r.this.h();
                    } else if (intValue3 == 1) {
                        int intValue4 = ((i.a) com.xiaopeng.autopilot.base.i.a(i.a.class)).d().intValue();
                        Log.i("TrainingFinishLearnView", "mControlBtn.apErrorTips = " + intValue4);
                        String str = APInfoBoardView.a[intValue4];
                        XToast.showShort(str);
                        rd.a().d(str);
                    }
                } else if (intValue2 == 1) {
                    if (intValue == 4) {
                        Log.i("TrainingFinishLearnView", "mControlBtn.startTraining.CarApiUtil.getGear() = " + CarApiUtil.getGear());
                        if (CarApiUtil.getGear() == 3) {
                            Log.i("TrainingFinishLearnView", "mControlBtn.TRAINING_TIPS_READY.startTraining.Constant.REVERSING_R");
                            XToast.showShort(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                            rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                            return;
                        }
                        Log.i("TrainingFinishLearnView", "mControlBtn.startTraining.click");
                        r.this.f();
                        com.xiaopeng.autopilot.parking.c.a(1);
                        r.this.h();
                    } else if (intValue == 15) {
                        if (CarApiUtil.getGear() == 3) {
                            Log.i("TrainingFinishLearnView", "mControlBtn.TRAINING_TIPS_START_CONFIRM.startTraining.Constant.REVERSING_R");
                            XToast.showShort(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                            rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                            return;
                        }
                        com.xiaopeng.autopilot.parking.c.a(1);
                        r.this.h();
                    } else if (intValue == 0 || intValue == 21 || intValue == 22) {
                        String str2 = tw.k[intValue];
                        XToast.showShort(str2);
                        rd.a().d(str2);
                    } else if (intValue == 1 || intValue == 2 || intValue == 3) {
                        String str3 = tw.k[intValue];
                        XToast.showShort(str3);
                        rd.a().d(str3);
                    } else {
                        String string = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_ap_not_use);
                        XToast.showShort(string);
                        rd.a().d(string);
                    }
                }
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.this.i();
            }
        });
    }

    public void h() {
        this.x = -1;
        com.xiaopeng.autopilot.base.i.a(i.y.class, 0);
        com.xiaopeng.autopilot.base.i.a(i.ar.class, 0);
        org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
        com.xiaopeng.autopilot.base.i.a(i.ao.class, 0);
    }

    public void a(boolean z) {
        int intValue = ((i.ao) com.xiaopeng.autopilot.base.i.a(i.ao.class)).d().intValue();
        Log.i("TrainingFinishLearnView", "updateControlBtnEnable.finishType = " + intValue + "," + z);
        if (intValue == 2) {
            this.a.setEnabled(z);
            if (z) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
            }
        }
    }

    public void i() {
        Log.i("TrainingFinishLearnView", "showCloseDialog");
        if (this.y == null) {
            this.y = new XDialog(getContext(), e.j.XDialogView);
            this.y.setMessage(e.i.training_learn_close_dialog_title);
            this.y.getDialog().setCanceledOnTouchOutside(false);
            this.y.getDialog().getWindow().setType(2047);
            this.y.setPositiveButton(getResources().getString(e.i.training_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.r.7
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    r.this.y.dismiss();
                    r.this.h();
                    com.xiaopeng.autopilot.parking.c.f();
                    com.xiaopeng.autopilot.base.d.e(1);
                    rh.a().e(r.this.z);
                }
            });
            this.y.setNegativeButton(getResources().getString(e.i.training_learn_close_dialog_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.r.8
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    r.this.y.dismiss();
                }
            });
        }
        this.y.show();
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        XImageButton xImageButton = this.v;
        if (xImageButton == null || xImageButton.getVisibility() != 0) {
            return;
        }
        Log.i("TrainingFinishLearnView", "BackPressedEvent");
        i();
    }
}
