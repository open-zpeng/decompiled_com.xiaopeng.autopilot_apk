package com.xiaopeng.autopilot.parking.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
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
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XCircularProgressBar;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XProgressBar;
import java.text.DecimalFormat;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class TrainingInfoBoardView extends RelativeLayout {
    private static final int M = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.training_distance_layout_margin_left_when_right));
    private static final int N = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), com.xiaopeng.autopilot.base.a.g().getResources().getDimension(e.c.training_distance_layout_margin_left_when_left));
    private TextView A;
    private TextView B;
    private XCircularProgressBar C;
    private View D;
    private ImageView E;
    private ImageView F;
    private boolean G;
    private boolean H;
    private boolean I;
    private ValueAnimator J;
    private ValueAnimator K;
    private ValueAnimator L;
    private Runnable O;
    private Runnable P;
    private TextView a;
    private RelativeLayout b;
    private XDialog c;
    private XDialog d;
    private XDialog e;
    private ParkingViewPro f;
    private XImageView g;
    private TextView h;
    private XImageButton i;
    private XProgressBar j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private RelativeLayout w;
    private XButton x;
    private TextView y;
    private TextView z;

    public TrainingInfoBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrainingInfoBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.1
            @Override // java.lang.Runnable
            public void run() {
                int distance = TrainingInfoBoardView.this.f.getDistance();
                if (((i.as) com.xiaopeng.autopilot.base.i.a(i.as.class)).d().intValue() == 6) {
                    if (distance >= 80) {
                        TrainingInfoBoardView.this.o.setTextColor(-65536);
                    } else if (ThemeWatcher.getInstance().isNight()) {
                        TrainingInfoBoardView.this.o.setTextColor(TrainingInfoBoardView.this.getResources().getColor(e.b.tv_progress_bar_distance_night));
                    } else {
                        TrainingInfoBoardView.this.o.setTextColor(TrainingInfoBoardView.this.getResources().getColor(e.b.tv_progress_bar_distance));
                    }
                } else if (ThemeWatcher.getInstance().isNight()) {
                    TrainingInfoBoardView.this.o.setTextColor(TrainingInfoBoardView.this.getResources().getColor(e.b.tv_progress_bar_distance_night));
                } else {
                    TrainingInfoBoardView.this.o.setTextColor(TrainingInfoBoardView.this.getResources().getColor(e.b.tv_progress_bar_distance));
                }
                TrainingInfoBoardView.this.o.setText(String.valueOf(distance));
                rh.a().a(TrainingInfoBoardView.this.O, 1000L);
            }
        };
        this.P = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.9
            @Override // java.lang.Runnable
            public void run() {
                if (TrainingInfoBoardView.this.L != null) {
                    if (TrainingInfoBoardView.this.L.isRunning()) {
                        TrainingInfoBoardView.this.L.cancel();
                    }
                    TrainingInfoBoardView.this.L.start();
                }
            }
        };
        k();
        m();
        j();
    }

    private void j() {
        this.L = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.L.setDuration(1600L);
        this.L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrainingInfoBoardView.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.L.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Log.i("TrainingInfoBoardView", "mStartInAnimator.onAnimationStart");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Log.i("TrainingInfoBoardView", "mStartInAnimator.onAnimationEnd");
                TrainingInfoBoardView.this.b(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Log.i("TrainingInfoBoardView", "mStartInAnimator.onAnimationCancel");
            }
        });
        this.J = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.J.setDuration(800L);
        this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrainingInfoBoardView.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.K = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.K.setDuration(800L);
        this.K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrainingInfoBoardView.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    public void a() {
        Log.i("TrainingInfoBoardView", "startInAnimation");
        b(0.0f);
        rh.a().e(this.P);
        rh.a().a(this.P, 1500L);
    }

    private void a(float f) {
        this.m.setAlpha(f);
        this.t.setAlpha(f);
        this.u.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f) {
        a(f);
        this.l.setAlpha(f);
        this.q.setAlpha(f);
        this.r.setAlpha(f);
        this.s.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f) {
        a(f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
        int i = N;
        layoutParams.leftMargin = i + ((int) ((M - i) * f));
        this.w.setLayoutParams(layoutParams);
    }

    public void setParkingView(ParkingViewPro parkingViewPro) {
        this.f = parkingViewPro;
    }

    private void k() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_pro_training_view, (ViewGroup) this, true);
        this.a = (TextView) findViewById(e.C0055e.training_tv_tip);
        this.b = (RelativeLayout) findViewById(e.C0055e.training_btn_control_layout);
        this.g = (XImageView) findViewById(e.C0055e.training_control_icon);
        this.h = (TextView) findViewById(e.C0055e.training_control_title);
        this.j = (XProgressBar) findViewById(e.C0055e.training_saving_progress);
        this.i = (XImageButton) findViewById(e.C0055e.pro_training_view_ib_close);
        this.k = (ImageView) findViewById(e.C0055e.training_distance_img);
        this.n = (TextView) findViewById(e.C0055e.training_tv_distance_pre);
        this.o = (TextView) findViewById(e.C0055e.training_tv_distance);
        this.p = (TextView) findViewById(e.C0055e.training_tv_distance_unit);
        this.l = (ImageView) findViewById(e.C0055e.training_spd_num_img);
        this.q = (TextView) findViewById(e.C0055e.training_tv_spd_num_pre);
        this.r = (TextView) findViewById(e.C0055e.training_tv_spd_num);
        this.s = (TextView) findViewById(e.C0055e.training_tv_spd_num_unit);
        this.m = (ImageView) findViewById(e.C0055e.training_location_img);
        this.t = (TextView) findViewById(e.C0055e.training_tv_location_pre);
        this.u = (TextView) findViewById(e.C0055e.training_tv_location);
        this.v = (TextView) findViewById(e.C0055e.training_tv_location_num_unit);
        if (com.xiaopeng.autopilot.base.d.j()) {
            this.t.setText(e.i.training_info_board_view_ramp_left);
            this.v.setVisibility(0);
        } else {
            this.t.setText(e.i.training_info_board_view_location_left);
            this.u.setText(e.i.training_info_board_view_location_text);
            this.v.setVisibility(8);
        }
        this.w = (RelativeLayout) findViewById(e.C0055e.parking_training_distance_layout);
        this.x = (XButton) findViewById(e.C0055e.training_btn_parking_control);
        this.y = (TextView) findViewById(e.C0055e.training_tv_parking_b);
        this.z = (TextView) findViewById(e.C0055e.training_parking_distance);
        this.A = (TextView) findViewById(e.C0055e.training_distance_unit);
        this.B = (TextView) findViewById(e.C0055e.training_parking_left_distance);
        this.D = findViewById(e.C0055e.training_parking_distance_container);
        this.E = (ImageView) findViewById(e.C0055e.training_iv_gear);
        this.C = (XCircularProgressBar) findViewById(e.C0055e.training_parking_b_progress);
        this.F = (ImageView) findViewById(e.C0055e.ic_training_parking_b_image);
    }

    public void a(String str, boolean z, boolean z2, String str2) {
        Log.i("TrainingInfoBoardView", "updateControl.controlText = " + str + "," + z + "," + z2 + "," + str2);
        this.x.setText(str);
        this.G = z2;
        this.D.setVisibility(8);
        this.C.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        if (z) {
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.b.setVisibility(8);
            this.E.setVisibility(8);
            if (com.xiaopeng.autopilot.base.d.p) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
            }
        } else {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            if (com.xiaopeng.autopilot.base.d.p) {
                if (this.E.getVisibility() == 0) {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
                }
            }
        }
        this.y.setText(str2);
        this.x.setEnabled(z2);
        if (z2) {
            if (!ThemeWatcher.getInstance().isNight()) {
                this.x.setTextColor(getResources().getColor(e.b.parking_button_text_selector));
            } else {
                this.x.setTextColor(getResources().getColor(e.b.parking_button_text_selector_night));
            }
        } else if (!ThemeWatcher.getInstance().isNight()) {
            this.x.setTextColor(-7103831);
        } else {
            this.x.setTextColor(-9603694);
        }
    }

    public void a(int i, float f, float f2) {
        PerformanceTestUnit.log("TrainingInfoBoardView", "updateParkingB.tips = " + i + "," + f + "," + f2, 1000L);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        if (i != 34 && i != 3) {
            this.D.setVisibility(8);
            this.C.setVisibility(8);
            this.E.setVisibility(8);
            if (com.xiaopeng.autopilot.base.d.p) {
                if (this.x.getVisibility() == 8 && this.E.getVisibility() == 8) {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
                    return;
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
                    return;
                }
            }
            return;
        }
        if (f > 0.0f) {
            this.D.setVisibility(0);
            this.C.setVisibility(0);
        } else {
            this.D.setVisibility(8);
            this.C.setVisibility(8);
        }
        if (com.xiaopeng.autopilot.base.d.p) {
            if (this.E.getVisibility() == 8 && this.x.getVisibility() == 8) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
            } else {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
            }
        }
        String format = new DecimalFormat("##0.0").format(f2);
        this.C.setProgress((int) f);
        this.z.setText(format);
        this.A.setText(" m");
        if (i == 34) {
            this.B.setText(e.i.distance_pre_b0);
        } else {
            this.B.setText(e.i.distance_pre);
        }
    }

    public void a(boolean z) {
        Log.i("TrainingInfoBoardView", "updateGearImageView.visible = " + z);
        if (z) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        if (z || this.x.getVisibility() == 0) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
        } else {
            layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
        }
    }

    public void b(boolean z) {
        Log.i("TrainingInfoBoardView", "updateParkingBImage.visible = " + z);
        if (z) {
            this.F.setVisibility(0);
            this.b.setVisibility(8);
            this.i.setVisibility(8);
            return;
        }
        this.F.setVisibility(8);
        this.i.setVisibility(0);
    }

    public void a(int i) {
        if (!ThemeWatcher.getInstance().isNight()) {
            switch (i) {
                case 1:
                    this.E.setImageResource(e.g.im_gear_d_light);
                    break;
                case 2:
                    this.E.setImageResource(e.g.im_gear_n_light);
                    break;
                case 3:
                    this.E.setImageResource(e.g.im_gear_r_light);
                    break;
                case 4:
                    this.E.setImageResource(e.g.im_gear_p_light);
                    break;
            }
        } else {
            switch (i) {
                case 1:
                    this.E.setImageResource(e.g.im_gear_d_dark);
                    break;
                case 2:
                    this.E.setImageResource(e.g.im_gear_n_dark);
                    break;
                case 3:
                    this.E.setImageResource(e.g.im_gear_r_dark);
                    break;
                case 4:
                    this.E.setImageResource(e.g.im_gear_p_dark);
                    break;
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        if (com.xiaopeng.autopilot.base.d.p) {
            if (this.x.getVisibility() == 8 && this.E.getVisibility() == 8) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
            } else {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
        l();
        View view = this.D;
        if (view != null) {
            view.setVisibility(8);
            if (com.xiaopeng.autopilot.base.d.p) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                if (this.x.getVisibility() == 8 && this.E.getVisibility() == 8) {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
                }
            }
        }
        XCircularProgressBar xCircularProgressBar = this.C;
        if (xCircularProgressBar != null) {
            xCircularProgressBar.setVisibility(8);
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        b();
    }

    public void b() {
        rh.a().e(this.P);
        rh.a().e(this.O);
        b(0);
        this.o.setText(String.valueOf(0));
    }

    public void c() {
        o();
        l();
    }

    private void l() {
        Log.i("TrainingInfoBoardView", "updateTheme.isNight = " + ThemeWatcher.getInstance().isNight());
        a(CarApiUtil.getGear());
        if (this.G) {
            if (!ThemeWatcher.getInstance().isNight()) {
                this.x.setTextColor(getResources().getColor(e.b.parking_button_text_selector));
            } else {
                this.x.setTextColor(getResources().getColor(e.b.parking_button_text_selector_night));
            }
        } else if (!ThemeWatcher.getInstance().isNight()) {
            this.x.setTextColor(-7103831);
        } else {
            this.x.setTextColor(-9603694);
        }
        if (ThemeWatcher.getInstance().isNight()) {
            this.z.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance_night));
            this.A.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance_night));
            this.B.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance_night));
            this.y.setTextColor(getResources().getColor(e.b.tv_parking_tips_night));
            this.F.setImageResource(e.g.ic_parking_b);
            this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color_night));
            this.k.setImageResource(e.g.ic_ap_distance_night);
            this.l.setImageResource(e.g.ic_training_spd_num_night);
            if (com.xiaopeng.autopilot.base.d.j()) {
                this.m.setImageResource(e.g.ic_training_location_ramp_night);
            } else {
                this.m.setImageResource(e.g.ic_training_location_night);
            }
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.p.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.q.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.s.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.t.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.v.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color_night));
            this.o.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color_night));
            this.r.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color_night));
            this.u.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color_night));
            return;
        }
        this.z.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance));
        this.A.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance));
        this.B.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance));
        this.y.setTextColor(getResources().getColor(e.b.tv_parking_tips_day));
        this.F.setImageResource(e.g.ic_parking_b);
        this.a.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_tips_color));
        this.k.setImageResource(e.g.ic_ap_distance);
        this.l.setImageResource(e.g.ic_training_spd_num);
        if (com.xiaopeng.autopilot.base.d.j()) {
            this.m.setImageResource(e.g.ic_training_location_ramp);
        } else {
            this.m.setImageResource(e.g.ic_training_location);
        }
        this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.p.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.q.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.s.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.t.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.v.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_text_color));
        this.o.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color));
        this.r.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color));
        this.u.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_distance_time_floor_number_text_color));
    }

    public void b(int i) {
        this.r.setText(String.valueOf(i));
    }

    public void c(int i) {
        this.u.setText(String.valueOf(i));
    }

    public void d(int i) {
        if (i == 0) {
            rh.a().e(this.O);
            rh.a().a(this.O, 1000L);
            a();
            this.w.setVisibility(0);
            if (((i.as) com.xiaopeng.autopilot.base.i.a(i.as.class)).d().intValue() == 6) {
                this.p.setText(e.i.training_after_ap_distance_unit_text);
                return;
            } else {
                this.p.setText(e.i.ap_finish_success_distance_unit_text);
                return;
            }
        }
        this.w.setVisibility(8);
    }

    private void m() {
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int e = TrainingInfoBoardView.this.f.a.e();
                Log.i("TrainingInfoBoardView", "mControlBtn.currentTips = " + e);
                if (e == 22) {
                    TrainingInfoBoardView.this.f.a.a(true);
                } else if (e == 4 || e == 13) {
                    TrainingInfoBoardView.this.f.a.b();
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int A = TrainingInfoBoardView.this.f.a.A();
                Log.i("TrainingInfoBoardView", "mFinishLayout.trainingTips = " + A);
                if (A < 12) {
                    TrainingInfoBoardView.this.d();
                }
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TrainingInfoBoardView.this.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        final int A = this.f.a.A();
        Log.i("TrainingInfoBoardView", "trainingTips.trainingTips = " + A);
        if (A < 12) {
            if (this.e == null) {
                this.e = new XDialog(getContext(), e.j.XDialogView);
                this.e.setTitle(e.i.training_info_cancel_title);
                this.e.setMessage(e.i.training_info_cancel_message);
                this.e.getDialog().getWindow().setType(2047);
                this.e.setPositiveButton(getResources().getString(e.i.training_info_cancel_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.2
                    @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                    public void onClick(XDialog xDialog, int i) {
                        if (TrainingInfoBoardView.this.f.a != null && TrainingInfoBoardView.this.f.a.B()) {
                            TrainingInfoBoardView.this.f.a.n(3);
                        }
                        TrainingInfoBoardView.this.e.dismiss();
                    }
                });
                this.e.setNegativeButton(getResources().getString(e.i.training_info_cancel_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.3
                    @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                    public void onClick(XDialog xDialog, int i) {
                        TrainingInfoBoardView.this.e.dismiss();
                    }
                });
            }
            this.e.show();
        } else if (A == 12) {
            if (this.d == null) {
                this.d = new XDialog(getContext(), e.j.XDialogView);
                this.d.setTitle(e.i.training_info_save_background_title);
                this.d.setMessage(e.i.training_info_save_background_message);
                this.d.getDialog().getWindow().setType(2047);
                this.d.setPositiveButton(getResources().getString(e.i.training_info_save_background_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.4
                    @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                    public void onClick(XDialog xDialog, int i) {
                        if (A == 12) {
                            com.xiaopeng.autopilot.base.i.a(i.aq.class, true);
                            TrainingInfoBoardView.this.f.i(1);
                            TrainingInfoBoardView.this.f.a.w();
                            TrainingInfoBoardView.this.f.a.J();
                            TrainingInfoBoardView.this.f.a.G();
                            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
                            XToast.show(e.i.training_save_background);
                        }
                        TrainingInfoBoardView.this.d.dismiss();
                    }
                });
                this.d.setNegativeButton(getResources().getString(e.i.training_info_save_background_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.5
                    @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                    public void onClick(XDialog xDialog, int i) {
                        TrainingInfoBoardView.this.d.dismiss();
                    }
                });
            }
            this.d.show();
        }
    }

    public void d() {
        if (this.c == null) {
            this.c = new XDialog(getContext(), e.j.XDialogView);
            this.c.setTitle(e.i.training_finish_or_cancal_title);
            this.c.setMessage(e.i.training_finish_or_cancel_message);
            this.c.getDialog().getWindow().setType(2047);
            this.c.setPositiveButton(getResources().getString(e.i.training_finish_or_cancal_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.6
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    if (CarApiUtil.getGear() != 4) {
                        XToast.showShort(e.i.finish_training_with_p);
                        return;
                    }
                    if (((i.as) com.xiaopeng.autopilot.base.i.a(i.as.class)).d().intValue() == 6) {
                        int distance = TrainingInfoBoardView.this.f.getDistance();
                        Log.i("TrainingInfoBoardView", "showFinish.distance = " + distance);
                        if (distance >= 10) {
                            if (TrainingInfoBoardView.this.f.a != null && TrainingInfoBoardView.this.f.a.B()) {
                                TrainingInfoBoardView.this.f.a.n(2);
                            }
                        } else {
                            XToast.show(e.i.training_after_ap_less_than_10);
                        }
                    } else if (TrainingInfoBoardView.this.f.a != null && TrainingInfoBoardView.this.f.a.B()) {
                        TrainingInfoBoardView.this.f.a.n(2);
                    }
                    TrainingInfoBoardView.this.c.dismiss();
                }
            });
            this.c.setNegativeButton(getResources().getString(e.i.training_finish_or_cancal_continue), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.7
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    TrainingInfoBoardView.this.c.dismiss();
                }
            });
        }
        this.c.show();
    }

    public void e() {
        XDialog xDialog = this.c;
        if (xDialog != null) {
            xDialog.dismiss();
        }
        XDialog xDialog2 = this.e;
        if (xDialog2 != null) {
            xDialog2.dismiss();
        }
        XDialog xDialog3 = this.d;
        if (xDialog3 != null) {
            xDialog3.dismiss();
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
        }
        if (TextUtils.isEmpty(str)) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
        }
    }

    public void e(int i) {
        if (i == 0) {
            this.D.setVisibility(8);
            this.C.setVisibility(8);
            this.E.setVisibility(8);
        }
        if (com.xiaopeng.autopilot.base.d.p) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
            if (this.x.getVisibility() == 8 && this.E.getVisibility() == 8) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_gone);
            } else {
                layoutParams.topMargin = getResources().getDimensionPixelSize(e.c.training_info_board_training_tips_top_margin_control_btn_visible);
            }
        }
        this.b.setVisibility(i);
    }

    public void c(boolean z) {
        this.H = z;
        if (z) {
            this.h.setText(e.i.training_click_done);
        } else {
            this.h.setText(e.i.training_doing);
        }
        o();
    }

    private void o() {
        Log.i("TrainingInfoBoardView", "updateBtnBg.mIsFinish = " + this.H);
        if (ThemeWatcher.getInstance().isNight()) {
            if (this.H) {
                this.b.setBackgroundResource(e.g.ic_training_waiting_bg_night);
                this.h.setTextColor(-1);
                this.g.setImageResource(e.g.ic_training_icon_waiting_night);
            } else if (this.I) {
                this.b.setBackgroundResource(e.g.ic_training_waiting_bg_night);
                this.h.setTextColor(-1);
            } else {
                this.b.setBackgroundResource(e.g.ic_training_bg_night);
                this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_btn_title_color_night));
                this.g.setImageResource(e.g.ic_training_icon_night);
            }
        } else if (this.H) {
            this.b.setBackgroundResource(e.g.ic_training_waiting_bg);
            this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_btn_can_save_title_color));
            this.g.setImageResource(e.g.ic_training_icon_waiting);
        } else if (this.I) {
            this.b.setBackgroundResource(e.g.ic_training_waiting_bg);
            this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_btn_can_save_title_color));
        } else {
            this.b.setBackgroundResource(e.g.ic_training_bg);
            this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.training_btn_title_color));
            this.g.setImageResource(e.g.ic_training_icon);
        }
    }

    public void d(boolean z) {
        this.I = z;
        if (z) {
            this.j.setVisibility(0);
            this.g.setVisibility(8);
            this.h.setText(e.i.training_saving_title);
        } else {
            this.j.setVisibility(8);
            this.g.setVisibility(0);
            if (this.H) {
                this.h.setText(e.i.training_click_done);
            } else {
                this.h.setText(e.i.training_doing);
            }
        }
        o();
    }

    @org.greenrobot.eventbus.m
    public void onEvent(final CameraStateEvent cameraStateEvent) {
        rh.a().c(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.TrainingInfoBoardView.8
            @Override // java.lang.Runnable
            public void run() {
                if (TrainingInfoBoardView.this.getVisibility() != 0) {
                    if (cameraStateEvent.mState == 1) {
                        TrainingInfoBoardView.this.c(0.0f);
                        return;
                    } else if (cameraStateEvent.mState == 2) {
                        TrainingInfoBoardView.this.c(1.0f);
                        return;
                    } else {
                        return;
                    }
                }
                if (com.xiaopeng.autopilot.base.d.c()) {
                    Log.i("TrainingInfoBoardView", "event = " + cameraStateEvent.mState);
                }
                if (cameraStateEvent.mState == 1) {
                    TrainingInfoBoardView.this.f();
                } else if (cameraStateEvent.mState == 2) {
                    TrainingInfoBoardView.this.g();
                }
            }
        });
    }

    public void f() {
        Log.i("TrainingInfoBoardView", "onAnimatorLeft");
        if (h()) {
            return;
        }
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K.cancel();
        }
        ValueAnimator valueAnimator2 = this.L;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.L.cancel();
        }
        ValueAnimator valueAnimator3 = this.J;
        if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
            Log.i("TrainingInfoBoardView", "onAnimatorLeft.start");
            this.J.start();
        }
    }

    public void g() {
        Log.i("TrainingInfoBoardView", "onAnimatorRight");
        if (i()) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.J.cancel();
        }
        ValueAnimator valueAnimator2 = this.L;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.L.cancel();
        }
        ValueAnimator valueAnimator3 = this.K;
        if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
            Log.i("TrainingInfoBoardView", "onAnimatorRight.start");
            this.K.start();
        }
    }

    public boolean h() {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        Log.i("TrainingInfoBoardView", "isLeft.distanceParams.leftMargin = " + layoutParams.leftMargin);
        return layoutParams.leftMargin == N;
    }

    public boolean i() {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        Log.i("TrainingInfoBoardView", "isRight.distanceParams.leftMargin = " + layoutParams.leftMargin);
        return layoutParams.leftMargin == M;
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        XImageButton xImageButton;
        if (getVisibility() == 0 && (xImageButton = this.i) != null && xImageButton.getVisibility() == 0) {
            Log.i("TrainingInfoBoardView", "BackPressedEvent");
            n();
        }
    }
}
