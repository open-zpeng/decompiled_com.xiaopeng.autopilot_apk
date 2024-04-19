package com.xiaopeng.autopilot.parking.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.NavClose4APReadyEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingAPPageRemoveEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.framework.configuration.BuildConfig;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.sr.bean.ApMapBean;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XProgressBar;
import defpackage.tu;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: TrainingAPFirstPageView.java */
/* loaded from: classes.dex */
public class q extends RelativeLayout implements com.xiaopeng.autopilot.base.f, ThemeWatcher.OnThemeSwitchListener {
    private static final int l = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_ready_title_top_margin));
    private static final int m = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_ready_distance_top_margin));
    private static final int n = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.x_pilot_3_ap_ready_time_top_margin));
    private TextView A;
    private XProgressBar B;
    private XProgressBar C;
    private View D;
    private View E;
    private MiniMapView F;
    private XProgressBar G;
    private View H;
    private Runnable I;
    private XImageButton a;
    private XButton b;
    private XButton c;
    private TextView d;
    private TextView e;
    private XDialog f;
    private ValueAnimator g;
    private ValueAnimator h;
    private ValueAnimator i;
    private ValueAnimator j;
    private PathInterpolator k;
    private View o;
    private View p;
    private View q;
    private View r;
    private View s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.h = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.i = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.j = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.k = new PathInterpolator(0.15f, 0.0f, 0.15f, 0.0f);
        this.I = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.q.1
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.isAttachedToWindow()) {
                    q.this.a();
                    rh.a().a(q.this.I, 500L);
                }
            }
        };
        b();
        k();
        d();
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        h();
    }

    private void h() {
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("TrainingAPFirstPageView", "onAttachedToWindow");
        org.greenrobot.eventbus.c.a().a(this);
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        h();
    }

    private void a(float f) {
        int i;
        if (f > 60.0f) {
            i = (int) (f / 60.0f);
            this.A.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_xpilot_3_remain_time_minute));
        } else {
            if (f <= 0.0f) {
                f = 0.0f;
            }
            i = (int) f;
            this.A.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_xpilot_3_remain_time));
        }
        Log.i("TrainingAPFirstPageView", "updateTime.time = " + i + ",originTime = " + f);
        this.y.setText(String.valueOf(i));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        Log.i("TrainingAPFirstPageView", "onDetachedFromWindow");
        ThemeWatcher.getInstance().removeThemeListener(this);
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.g.cancel();
    }

    public void setMiniMapVisibility(int i) {
        MiniMapView miniMapView = this.F;
        if (miniMapView != null) {
            miniMapView.setVisibility(i);
        }
    }

    private void i() {
        if (ThemeWatcher.getInstance().isNight()) {
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color_night));
            this.c.setBackgroundResource(e.d.auto_btn_try_again_selector_night);
            this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color_night));
            this.d.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_title_color_night));
            this.e.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_message_color_night));
            this.o.setBackgroundResource(e.d.ic_training_ap_top_view_bg_night);
            this.p.setBackgroundResource(e.d.ic_training_ap_right_view_bg_night);
            this.v.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_data_title_color_night));
            this.w.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_data_title_color_night));
            this.x.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_message_color_night));
            this.y.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_message_color_night));
            this.z.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_data_title_color_night));
            this.A.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_data_title_color_night));
            this.t.setImageResource(e.g.ic_training_ap_first_distance_night);
            this.u.setImageResource(e.g.ic_training_ap_first_time_night);
            this.B.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_ap_first_progress_drawable_night));
            this.C.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_ap_first_progress_drawable_night));
            this.G.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_ap_first_progress_drawable_night));
            this.E.setBackgroundResource(e.g.ic_training_ap_first_data_bg_night);
            this.D.setBackgroundResource(e.g.ic_training_ap_first_data_board_bg_night);
            this.H.setBackgroundResource(e.g.ic_training_ap_first_shuxian_night);
            return;
        }
        this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_learn_btn_text_color));
        this.c.setBackgroundResource(e.d.auto_btn_try_again_selector);
        this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_btn_text_color));
        this.d.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_title_color));
        this.e.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_message_color));
        this.o.setBackgroundResource(e.d.ic_training_ap_top_view_bg);
        this.p.setBackgroundResource(e.d.ic_training_ap_right_view_bg);
        this.v.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_data_title_color));
        this.w.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_ap_first_data_title_color));
        this.x.setTextColor(-16777216);
        this.y.setTextColor(-16777216);
        this.z.setTextColor(-16777216);
        this.A.setTextColor(-16777216);
        this.t.setImageResource(e.g.ic_training_ap_first_distance);
        this.u.setImageResource(e.g.ic_training_ap_first_time);
        this.B.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_ap_first_progress_drawable));
        this.C.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_ap_first_progress_drawable));
        this.E.setBackgroundResource(e.g.ic_training_ap_first_data_bg);
        this.D.setBackgroundResource(e.g.ic_training_ap_first_data_board_bg);
        this.G.setIndeterminateDrawable(com.xiaopeng.autopilot.base.a.g().getDrawable(e.d.training_ap_first_progress_drawable));
        this.H.setBackgroundResource(e.g.ic_training_ap_first_shuxian_day);
    }

    public void a() {
        int m2 = com.xiaopeng.autopilot.parking.c.m();
        Log.i("TrainingAPFirstPageView", "updateDistanceTime.distance = " + m2);
        rh.a().e(this.I);
        if (m2 < 0) {
            this.x.setText("");
            this.y.setText("");
            this.C.setVisibility(0);
            this.B.setVisibility(0);
            rh.a().a(this.I, 500L);
            return;
        }
        this.C.setVisibility(8);
        this.B.setVisibility(8);
        this.x.setText(String.valueOf(m2));
        a(m2 / 2.0f);
    }

    public void b() {
        this.q = LayoutInflater.from(getContext()).inflate(e.f.layout_training_ap_first_page, (ViewGroup) this, true);
        this.r = findViewById(e.C0055e.training_ap_first_distance_layout);
        this.t = (ImageView) findViewById(e.C0055e.training_ap_first_distance_icon);
        this.v = (TextView) findViewById(e.C0055e.training_ap_first_distance_title);
        this.x = (TextView) findViewById(e.C0055e.training_ap_first_distance);
        this.z = (TextView) findViewById(e.C0055e.training_ap_first_distance_unit);
        this.s = findViewById(e.C0055e.training_ap_first_time_layout);
        this.u = (ImageView) findViewById(e.C0055e.training_ap_first_time_icon);
        this.w = (TextView) findViewById(e.C0055e.training_ap_first_time_title);
        this.y = (TextView) findViewById(e.C0055e.training_ap_first_time);
        this.A = (TextView) findViewById(e.C0055e.training_ap_first_time_unit);
        this.a = (XImageButton) findViewById(e.C0055e.training_ap_first_page_close);
        this.b = (XButton) findViewById(e.C0055e.training_ap_first_page_btn_control);
        this.c = (XButton) findViewById(e.C0055e.training_ap_first_page_btn_learn);
        this.e = (TextView) findViewById(e.C0055e.training_ap_first_page_message);
        this.d = (TextView) findViewById(e.C0055e.training_ap_first_page_title);
        this.o = findViewById(e.C0055e.training_ap_first_page_top_bg);
        this.p = findViewById(e.C0055e.training_ap_first_page_right_bg);
        this.B = (XProgressBar) findViewById(e.C0055e.training_ap_first_distance_progress);
        this.C = (XProgressBar) findViewById(e.C0055e.training_ap_first_time_progress);
        c();
        j();
    }

    private void j() {
        String string;
        String string2;
        ApMapBean s = com.xiaopeng.autopilot.parking.c.s();
        Resources resources = com.xiaopeng.autopilot.base.a.g().getApplicationContext().getResources();
        String string3 = resources.getString(e.i.training_ap_first_page_title);
        resources.getString(e.i.training_ap_first_page_message);
        if (s.getMapType() == 2 || s.getMapType() == 3) {
            if (s.getTerminalAttr() == 1) {
                string = String.format(resources.getString(e.i.ap_first_page_title), resources.getString(e.i.memory_parking_share_type_charging_pie));
            } else if (s.getTerminalAttr() == 2) {
                string = String.format(resources.getString(e.i.ap_first_page_title), resources.getString(e.i.memory_parking_share_type_elevator));
            } else if (s.getTerminalAttr() == 3) {
                string = String.format(resources.getString(e.i.ap_first_page_title), resources.getString(e.i.memory_parking_share_type_stair));
            } else {
                string = s.getTerminalAttr() == 4 ? resources.getString(e.i.ap_first_page_title_other) : string3;
            }
            string2 = resources.getString(e.i.ap_first_page_sub_title);
        } else {
            string = resources.getString(e.i.training_ap_first_page_title);
            string2 = resources.getString(e.i.training_ap_first_page_message);
        }
        this.d.setText(string);
        this.e.setText(string2);
    }

    public void c() {
        this.G = (XProgressBar) findViewById(e.C0055e.training_ap_mini_map_progress);
        if (this.F != null) {
            PerformanceTestUnit.log("TrainingAPFirstPageView", "MINI_MAP already initMiniMapConponent view ", true);
            return;
        }
        tu d = tu.d();
        d.a(new tu.a() { // from class: com.xiaopeng.autopilot.parking.view.q.2
            @Override // defpackage.tu.a
            public void a() {
                q.this.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.q.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.G.setVisibility(8);
                    }
                });
            }
        });
        this.D = findViewById(e.C0055e.training_ap_first_data_board_bg_view);
        this.H = findViewById(e.C0055e.training_ap_first_time_divider);
        this.E = findViewById(e.C0055e.training_ap_first_map_layout);
        this.F = (MiniMapView) findViewById(e.C0055e.parking_mini_map);
        d.a(this.F);
        this.F.a(d);
        this.F.a(true);
        PerformanceTestUnit.log("TrainingAPFirstPageView", "MINI_MAP initMiniMapConponent view finished", true);
        if (d.a().ismInitFinished()) {
            this.G.setVisibility(8);
        }
    }

    private void k() {
        this.g.setDuration(1500L);
        this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.q.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                q.this.q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.h.setDuration(500L);
        this.h.setInterpolator(this.k);
        this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.q.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                q.this.d.setAlpha(floatValue);
                q.this.e.setAlpha(floatValue);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.d.getLayoutParams();
                layoutParams.topMargin = (int) (q.l + BuildConfig.VERSION_CODE + ((0.0f - floatValue) * 150.0f));
                q.this.d.setLayoutParams(layoutParams);
            }
        });
        this.h.setStartDelay(100L);
        this.i.setDuration(500L);
        this.i.setInterpolator(this.k);
        this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.q.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                q.this.r.setAlpha(floatValue);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.r.getLayoutParams();
                layoutParams.topMargin = (int) (q.m + BuildConfig.VERSION_CODE + ((0.0f - floatValue) * 150.0f));
                q.this.r.setLayoutParams(layoutParams);
            }
        });
        this.i.setStartDelay(200L);
        this.j.setDuration(500L);
        this.j.setInterpolator(this.k);
        this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.q.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                q.this.s.setAlpha(floatValue);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) q.this.s.getLayoutParams();
                layoutParams.topMargin = (int) (q.n + BuildConfig.VERSION_CODE + ((0.0f - floatValue) * 150.0f));
                q.this.s.setLayoutParams(layoutParams);
            }
        });
        this.j.setStartDelay(300L);
    }

    public void d() {
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.q.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("TrainingAPFirstPageView", "mCloseBtn onClick!");
                q.this.l();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.q.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((i.c) com.xiaopeng.autopilot.base.i.a(i.c.class)).d().intValue();
                Log.i("TrainingAPFirstPageView", "mControlBtn.apStatus = " + intValue);
                if (intValue == 2) {
                    com.xiaopeng.autopilot.parking.c.e();
                    org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
                    rd.a().e();
                } else if (intValue != 1 && intValue != 0) {
                    if (intValue == 5) {
                        String string = com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_ap_st_5);
                        XToast.showShort(string);
                        rd.a().d(string);
                    }
                } else {
                    int intValue2 = ((i.a) com.xiaopeng.autopilot.base.i.a(i.a.class)).d().intValue();
                    Log.i("TrainingAPFirstPageView", "mControlBtn.apErrorTips = " + intValue2);
                    String str = APInfoBoardView.a[intValue2];
                    XToast.showShort(str);
                    rd.a().d(str);
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int intValue = ((i.at) com.xiaopeng.autopilot.base.i.a(i.at.class)).d().intValue();
                Log.i("TrainingAPFirstPageView", "mLearnBtn.trainingTips = " + intValue);
                if (intValue == 15 || intValue == 4) {
                    if (q.this.f == null) {
                        q qVar = q.this;
                        qVar.f = new XDialog(qVar.getContext(), e.j.XDialogView);
                        q.this.f.setMessage(e.i.confirm_training_dialog_message);
                        q.this.f.getDialog().getWindow().setType(2047);
                        q.this.f.setPositiveButton(q.this.getResources().getString(e.i.confirm_training_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.q.9.1
                            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                            public void onClick(XDialog xDialog, int i) {
                                int i2;
                                Log.i("TrainingAPFirstPageView", "mLearnBtn.mTrainingConfirmDialog.startTraining.click");
                                int intValue2 = ((i.at) com.xiaopeng.autopilot.base.i.a(i.at.class)).d().intValue();
                                Log.i("TrainingAPFirstPageView", "mLearnBtn.trainingConfirmTips = " + intValue2);
                                if (intValue2 == 15 || (i2 = intValue) == 4) {
                                    org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
                                    com.xiaopeng.autopilot.parking.c.a(1);
                                    q.this.f.dismiss();
                                } else if (intValue2 == 0) {
                                    XToast.show(e.i.tts_start_training_out_of_park);
                                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_out_of_park));
                                } else if (intValue2 == 1) {
                                    XToast.show(e.i.tts_start_training_up_down);
                                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_up_down));
                                } else if (intValue2 == 2) {
                                    XToast.show(e.i.tts_start_training_with_r);
                                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_with_r));
                                } else if (i2 == 25) {
                                    XToast.show(e.i.tts_training_error_click);
                                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_error_click));
                                } else {
                                    XToast.show(e.i.tts_start_training_other);
                                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_other));
                                }
                            }
                        });
                        q.this.f.setNegativeButton(q.this.getResources().getString(e.i.confirm_training_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.q.9.2
                            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                            public void onClick(XDialog xDialog, int i) {
                                q.this.f.dismiss();
                            }
                        });
                    }
                    q.this.f.show();
                } else if (intValue == 0) {
                    XToast.show(e.i.tts_start_training_out_of_park);
                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_out_of_park));
                } else if (intValue == 1) {
                    XToast.show(e.i.tts_start_training_up_down);
                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_up_down));
                } else if (intValue == 2) {
                    XToast.show(e.i.tts_start_training_with_r);
                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_with_r));
                } else if (intValue == 25) {
                    XToast.show(e.i.tts_training_error_click);
                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_error_click));
                } else {
                    XToast.show(e.i.tts_start_training_other);
                    rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_other));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
        org.greenrobot.eventbus.c.a().d(new NavClose4APReadyEvent());
        com.xiaopeng.autopilot.parking.c.j();
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        XImageButton xImageButton = this.a;
        if (xImageButton == null || xImageButton.getVisibility() != 0) {
            return;
        }
        Log.i("TrainingAPFirstPageView", "BackPressedEvent");
        l();
    }
}
