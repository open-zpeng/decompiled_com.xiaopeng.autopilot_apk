package com.xiaopeng.autopilot.parking.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.ShortcutEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.SpeechSuperParkEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.l;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IScuController;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.watchers.XTouchAreaWatcher;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XCircularProgressBar;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class ParkingView extends RelativeLayout implements com.xiaopeng.autopilot.parking.b, g, com.xiaopeng.autopilot.parking.view.g3d.f, ThemeWatcher.OnThemeSwitchListener {
    private int A;
    private Handler B;
    private ValueAnimator C;
    private ValueAnimator D;
    private AnimationDrawable E;
    private XCircularProgressBar F;
    private boolean G;
    private Runnable H;
    private Runnable I;
    private View.OnClickListener J;
    tn a;
    TextView b;
    private TextView c;
    private ImageView d;
    private ParkingProgressBar e;
    private ImageView f;
    private ImageView g;
    private RelativeLayout h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private View n;
    private View o;
    private XImageButton p;
    private XButton q;
    private ParkingHotAreaInterceptView r;
    private XTouchAreaWatcher s;
    private View t;
    private XImageView u;
    private m v;
    private a w;
    private l x;
    private boolean y;
    private AbsoluteSizeSpan z;

    private void k() {
    }

    public ParkingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ParkingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = false;
        this.z = new AbsoluteSizeSpan(UIUtils.sp2px(getContext(), getResources().getDimensionPixelSize(e.c.speed_size_span_original)));
        this.A = -100;
        this.B = new Handler(Looper.getMainLooper());
        this.G = false;
        this.H = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.1
            @Override // java.lang.Runnable
            public void run() {
                ParkingView.this.q.setText("");
            }
        };
        this.I = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.7
            @Override // java.lang.Runnable
            public void run() {
                ParkingView.this.e.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingView.this.f.getLayoutParams();
                layoutParams.width = (int) (ParkingView.this.h.getWidth() * (ParkingView.this.e.getProgress() / 1000.0d));
                ParkingView.this.f.setLayoutParams(layoutParams);
                Log.i("progressbar", "暂停Ui值:\t" + ParkingView.this.e.getProgress());
                ParkingView.this.f.setVisibility(0);
                ParkingView.this.g.setVisibility(0);
                ParkingView.this.e.a(ParkingView.this.e.getProgress());
            }
        };
        this.J = new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogUtils.i("ParkingView", "onClick ---> 点击默认泊车关闭按钮");
                ParkingView.this.m();
            }
        };
        f();
        h();
        e();
    }

    public void e() {
        Log.i("ParkingView", "updateTheme.ThemeWatcher.getInstance().isNight() = " + ThemeWatcher.getInstance().isNight());
        c(CarApiUtil.getGear());
        ParkingProgressBar parkingProgressBar = this.e;
        if (parkingProgressBar != null) {
            parkingProgressBar.a();
        }
        if (!ThemeWatcher.getInstance().isNight()) {
            this.B.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.10
                @Override // java.lang.Runnable
                public void run() {
                    ParkingView.this.b.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_parking_tips_day));
                    ParkingView.this.a(0, ThemeWatcher.getInstance().isNight());
                    ParkingView.this.g.setBackgroundColor(-3090972);
                    ParkingView.this.j.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_progress_bar_distance));
                    ParkingView.this.k.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_progress_bar_distance));
                    ParkingView.this.l.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_progress_bar_distance));
                }
            });
        } else {
            this.B.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.11
                @Override // java.lang.Runnable
                public void run() {
                    ParkingView.this.b.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_parking_tips_night));
                    ParkingView.this.a(0, ThemeWatcher.getInstance().isNight());
                    ParkingView.this.g.setBackgroundColor(-13221788);
                    ParkingView.this.j.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_progress_bar_distance_night));
                    ParkingView.this.k.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_progress_bar_distance_night));
                    ParkingView.this.l.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_progress_bar_distance_night));
                }
            });
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c(int i) {
        if (!ThemeWatcher.getInstance().isNight()) {
            switch (i) {
                case 1:
                    this.d.setImageResource(e.g.im_gear_d_light);
                    return;
                case 2:
                    this.d.setImageResource(e.g.im_gear_n_light);
                    return;
                case 3:
                    this.d.setImageResource(e.g.im_gear_r_light);
                    return;
                case 4:
                    this.d.setImageResource(e.g.im_gear_p_light);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 1:
                this.d.setImageResource(e.g.im_gear_d_dark);
                return;
            case 2:
                this.d.setImageResource(e.g.im_gear_n_dark);
                return;
            case 3:
                this.d.setImageResource(e.g.im_gear_r_dark);
                return;
            case 4:
                this.d.setImageResource(e.g.im_gear_p_dark);
                return;
            default:
                return;
        }
    }

    public void a(int i, boolean z) {
        if (z) {
            if (i >= 25) {
                this.c.setTextColor(getResources().getColor(e.b.speed_over_color));
            } else {
                this.c.setTextColor(getResources().getColor(e.b.speed_color_night));
            }
        } else if (i >= 25) {
            this.c.setTextColor(getResources().getColor(e.b.speed_over_color));
        } else {
            this.c.setTextColor(getResources().getColor(e.b.speed_color));
        }
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        Log.i("ParkingView", "onSwitchTheme.i = " + i);
        e();
    }

    public void f() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_view, (ViewGroup) this, true);
        this.h = (RelativeLayout) findViewById(e.C0055e.process_bar_container);
        this.j = (TextView) findViewById(e.C0055e.parking_distance);
        this.k = (TextView) findViewById(e.C0055e.distance_unit);
        this.l = (TextView) findViewById(e.C0055e.parking_left_distance);
        this.i = (LinearLayout) findViewById(e.C0055e.parking_distance_container);
        i();
        k();
        this.F = (XCircularProgressBar) findViewById(e.C0055e.parking_b_progress);
        this.C = ValueAnimator.ofFloat(0.3f, 1.0f);
        this.C.setInterpolator(new p());
        this.C.setDuration(1200L);
        this.C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ParkingView.this.u.setScaleX(floatValue);
                ParkingView.this.u.setScaleY(floatValue);
            }
        });
        this.D = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.D.setDuration(900L);
        this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ParkingView.this.F.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.D.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ParkingView.this.F.setAlpha(0.0f);
                ParkingView.this.F.setVisibility(0);
            }
        });
        this.v = new m(getContext());
        this.u = (XImageView) findViewById(e.C0055e.ic_parking_b_image);
        this.t = findViewById(e.C0055e.ll_tip);
        this.o = findViewById(e.C0055e.parking_settings);
        this.m = findViewById(e.C0055e.parking_attention);
        this.p = (XImageButton) findViewById(e.C0055e.ib_close);
        File file = new File("/system/fonts/Xpeng-Medium.ttf");
        if (file.exists()) {
            this.b.setTypeface(Typeface.createFromFile(file));
        }
        this.n = findViewById(e.C0055e.parking_rear_mirror);
        this.r = (ParkingHotAreaInterceptView) findViewById(e.C0055e.parking_intercept_view);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("ParkingView", "mRearMirror.mGearImageView.getVisibility() = " + ParkingView.this.d.getVisibility() + ",mParkingPresenter.getCurrentTip()" + ParkingView.this.a.e());
                if ((ParkingView.this.d.getVisibility() == 0 && ParkingView.this.a.e() >= 0 && ParkingView.this.a.e() != 13 && ParkingView.this.a.e() != 14) || ParkingView.this.a.e() == 24 || ParkingView.this.a.e() == 36) {
                    Log.i("ParkingView", "mRearMirror mGearImageView is visible");
                    SoundPlayer.getInstance().playUnOperated();
                    return;
                }
                Log.i("ParkingView", "mRearMirror.onClick");
                Intent intent = new Intent("com.xiaopeng.carcontrol.intent.action.ACTION_SHOW_MIRROR_CONTROL_PANEL");
                intent.setPackage(IpcConfig.App.CAR_CONTROL);
                com.xiaopeng.autopilot.base.a.g().getApplicationContext().sendBroadcast(intent);
            }
        });
    }

    public void g() {
        h(0);
    }

    public void h(int i) {
        if (this.x != null) {
            b();
        }
        this.x = new l(com.xiaopeng.autopilot.base.a.g().getApplicationContext());
        this.x.setAttentionListener(this);
        this.x.a(i);
        this.x.setOnOkListener(new l.a() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.16
            @Override // com.xiaopeng.autopilot.parking.view.l.a
            public void a() {
                ParkingView.this.b();
            }
        });
        ((ViewGroup) getRootView()).addView(this.x, -1, -1);
        com.xiaopeng.autopilot.base.c.a().i().statisEnterHelp();
    }

    public void h() {
        this.p.setOnClickListener(this.J);
        this.o.setVisibility(0);
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("ParkingView", "mParkingSetting");
                if ((ParkingView.this.a.c() && ParkingView.this.a.e() >= 0 && ParkingView.this.a.e() != 13 && ParkingView.this.a.e() != 14) || ParkingView.this.a.e() == 24 || ParkingView.this.a.e() == 36) {
                    SoundPlayer.getInstance().playUnOperated();
                    return;
                }
                Log.i("ParkingView", "mParkingSetting.mSettingDialog = " + ParkingView.this.v);
                ParkingView.this.v.b();
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ParkingView.this.a.c() && ParkingView.this.a.e() >= 0 && ParkingView.this.a.e() != 13 && ParkingView.this.a.e() != 14) || ParkingView.this.a.e() == 24 || ParkingView.this.a.e() == 36) {
                    SoundPlayer.getInstance().playUnOperated();
                } else {
                    ParkingView.this.g();
                }
            }
        });
    }

    public void i() {
        this.b = (TextView) findViewById(e.C0055e.tv_parking_tip);
        this.c = (TextView) findViewById(e.C0055e.tv_speed);
        this.d = (ImageView) findViewById(e.C0055e.iv_gear);
        this.e = (ParkingProgressBar) findViewById(e.C0055e.parking_progress_bar);
        this.e.setDistanceComponent(this.j);
        this.e.setDistanceUnitComponent(this.k);
        this.e.setDistanceLeft(this.l);
        this.e.setDistanceContainer(this.i);
        this.f = (ImageView) findViewById(e.C0055e.process_pause);
        this.g = (ImageView) findViewById(e.C0055e.process_bg);
        this.q = (XButton) findViewById(e.C0055e.btn_parking_control);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (getParent() != null) {
            super.onAttachedToWindow();
        }
        org.greenrobot.eventbus.c.a().a(this);
        e();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        ((i.s) com.xiaopeng.autopilot.base.i.a(i.s.class)).a();
        this.s = new XTouchAreaWatcher(40, 40, 40, 40);
        XTouchAreaWatcher xTouchAreaWatcher = this.s;
        XButton xButton = this.q;
        xTouchAreaWatcher.extendTouchArea(xButton, (ViewGroup) xButton.getParent());
        XTouchAreaWatcher xTouchAreaWatcher2 = this.s;
        XImageButton xImageButton = this.p;
        xTouchAreaWatcher2.extendTouchArea(xImageButton, (ViewGroup) xImageButton.getParent());
        Log.i("ParkingView", "Constant.isSwitchSoundToSpeechTTS() = " + com.xiaopeng.autopilot.base.d.a());
        this.v.a();
        this.b.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(0);
        if (com.xiaopeng.autopilot.base.d.h() || com.xiaopeng.autopilot.base.d.g()) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.s.onDestroy();
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
        ThemeWatcher.getInstance().removeThemeListener(this);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.A = -100;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(tv tvVar) {
        this.a = tvVar;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void setProgressBarVisible(int i) {
        this.h.setVisibility(8);
    }

    public int getParkLotChoseIndex() {
        return this.A;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.f
    public void b(int i, boolean z) {
        Log.i("ParkingView", "choseIndexAndStart.mLastChooseIndex = " + this.A + ", index = " + i);
        if (this.A == i) {
            String string = com.xiaopeng.autopilot.base.a.g().getString(e.i.speech_parking_tips_22_ready);
            Log.i("ParkingView", "invalidate = " + rd.a().c() + ",Constant.isSwitchSoundToSpeechTTS() = " + com.xiaopeng.autopilot.base.d.a());
            if (!re.a().h() && !rd.a().c() && com.xiaopeng.autopilot.base.d.a()) {
                rd.a().a(string);
            }
        }
        SoundPlayer.getInstance().playSelectParklot();
        b(i);
        if (z) {
            LogUtils.i("ParkingView", "choseIndexAndStart(), 拖拽或语音，直接触发开始");
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.3
                @Override // java.lang.Runnable
                public void run() {
                    ParkingView.this.a.a(true);
                }
            }, 500L);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(final String str, final int i) {
        this.B.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.4
            @Override // java.lang.Runnable
            public void run() {
                ParkingView.this.b.setText(str);
                if (i != -1) {
                    ParkingView.this.b.setTextColor(i);
                } else if (!ThemeWatcher.getInstance().isNight()) {
                    ParkingView.this.b.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_parking_tips_day));
                } else {
                    ParkingView.this.b.setTextColor(ParkingView.this.getResources().getColor(e.b.tv_parking_tips_night));
                }
                int e = ParkingView.this.a.e();
                if ((e > 1 && e < 15) || (e >= 34 && e != 36)) {
                    if (e == 6 || e == 5 || e == 35 || e == 2 || e == 11 || e == 12) {
                        ParkingView.this.b.setTextSize(UIUtils.dip2px(ParkingView.this.getContext(), ParkingView.this.getResources().getDimensionPixelSize(e.c.tips_size_span_original)));
                    } else {
                        ParkingView.this.b.setTextSize(UIUtils.dip2px(ParkingView.this.getContext(), 29.0f));
                    }
                } else if (e == 21 && ParkingView.this.a.f() == 8) {
                    ParkingView.this.b.setTextSize(UIUtils.dip2px(ParkingView.this.getContext(), ParkingView.this.getResources().getDimensionPixelSize(e.c.tips_size_span_original)));
                } else if (e == 33) {
                    ParkingView.this.b.setTextSize(UIUtils.dip2px(ParkingView.this.getContext(), 29.0f));
                } else if (e == 18) {
                    ParkingView.this.b.setTextSize(UIUtils.dip2px(ParkingView.this.getContext(), 32.0f));
                } else {
                    ParkingView.this.b.setTextSize(UIUtils.dip2px(ParkingView.this.getContext(), ParkingView.this.getResources().getDimensionPixelSize(e.c.tips_size_span_original)));
                }
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(float f) {
        int b = b(f);
        a(b, ThemeWatcher.getInstance().isNight());
        String valueOf = String.valueOf(b);
        int length = valueOf.length();
        SpannableString spannableString = new SpannableString(valueOf + " km/h");
        spannableString.setSpan(this.z, 0, length, 18);
        this.c.setText(spannableString);
    }

    private int b(float f) {
        return (int) Math.abs(Math.ceil(f * 1.05f));
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void d(int i) {
        this.c.setVisibility(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void e(int i) {
        this.d.setVisibility(i);
        XCircularProgressBar xCircularProgressBar = this.F;
        if (xCircularProgressBar != null) {
            xCircularProgressBar.setVisibility(i);
        }
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setVisibility(i);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(final String str, final int i, final View.OnClickListener onClickListener, final boolean z) {
        this.B.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.5
            @Override // java.lang.Runnable
            public void run() {
                ParkingView.this.l();
                ParkingView.this.q.setText(str);
                ParkingView.this.q.setVisibility(i);
                ParkingView.this.q.setOnClickListener(onClickListener);
                if (!z) {
                    ParkingView.this.d(true);
                } else {
                    ParkingView.this.d(false);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ParkingView.this.t.getLayoutParams();
                if (i == 0) {
                    layoutParams.topMargin = UIUtils.dip2px(ParkingView.this.getContext(), ParkingView.this.getResources().getDimensionPixelSize(e.c.tips_small_size_top_margin));
                    ParkingView.this.b.setTextSize(29.0f);
                } else {
                    int e = ParkingView.this.a.e();
                    if ((e <= 1 || e >= 15) && (e < 34 || e == 36)) {
                        if (e == 33) {
                            layoutParams.topMargin = UIUtils.dip2px(ParkingView.this.getContext(), ParkingView.this.getResources().getDimensionPixelSize(e.c.tips_small_size_top_margin));
                        } else {
                            layoutParams.topMargin = UIUtils.dip2px(ParkingView.this.getContext(), 70.0f);
                        }
                    } else if (e == 6 || e == 5 || e == 35 || e == 2 || e == 11 || e == 12) {
                        layoutParams.topMargin = UIUtils.dip2px(ParkingView.this.getContext(), 70.0f);
                    } else {
                        layoutParams.topMargin = UIUtils.dip2px(ParkingView.this.getContext(), ParkingView.this.getResources().getDimensionPixelSize(e.c.tips_small_size_top_margin));
                    }
                }
                ParkingView.this.t.setLayoutParams(layoutParams);
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(final int i, final View.OnClickListener onClickListener) {
        this.B.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!((i.w) com.xiaopeng.autopilot.base.i.a(i.w.class)).d().booleanValue() || ParkingView.this.a.c()) {
                    ParkingView.this.a(i);
                    if (onClickListener == null) {
                        ParkingView.this.p.setOnClickListener(ParkingView.this.J);
                    } else {
                        ParkingView.this.p.setOnClickListener(onClickListener);
                    }
                }
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(int i) {
        if (i == 0) {
            a(true);
        } else {
            a(false);
        }
        this.p.setVisibility(i);
        if (i == 0) {
            this.u.setVisibility(8);
        } else if (this.a.c()) {
            this.u.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(boolean z) {
        if (z) {
            this.p.setClickable(true);
            this.p.setEnabled(true);
            return;
        }
        this.p.setClickable(false);
        this.p.setEnabled(false);
    }

    public void d(boolean z) {
        if (z) {
            int parkLotChoseIndex = getParkLotChoseIndex();
            if (parkLotChoseIndex < 0 || parkLotChoseIndex >= 7) {
                this.q.setEnabled(false);
                if (!ThemeWatcher.getInstance().isNight()) {
                    this.q.setTextColor(-7103831);
                    return;
                } else {
                    this.q.setTextColor(-9603694);
                    return;
                }
            }
            this.q.setEnabled(true);
            if (!ThemeWatcher.getInstance().isNight()) {
                this.q.setTextColor(getResources().getColor(e.b.parking_button_text_selector));
                return;
            } else {
                this.q.setTextColor(getResources().getColor(e.b.parking_button_text_selector_night));
                return;
            }
        }
        this.q.setEnabled(false);
        if (!ThemeWatcher.getInstance().isNight()) {
            this.q.setTextColor(-7103831);
        } else {
            this.q.setTextColor(-9603694);
        }
    }

    public void i(int i) {
        this.B.postDelayed(this.I, 500L);
    }

    public void j() {
        Log.i("progressbar", "继续");
        this.B.removeCallbacks(this.I);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.e.setVisibility(0);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void f(int i) {
        i(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void g(int i) {
        j();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b(boolean z) {
        Log.i("ParkingView", "onPureDriveModeChange.b = " + z);
        if (z) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(8);
        }
        if (com.xiaopeng.autopilot.base.d.h() || com.xiaopeng.autopilot.base.d.g()) {
            if (!z) {
                this.m.setVisibility(0);
                this.o.setVisibility(0);
                this.u.setVisibility(8);
                return;
            }
            b();
            this.m.setVisibility(0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b() {
        if (this.x != null) {
            ((ViewGroup) getRootView()).removeView(this.x);
            this.x = null;
        }
        m mVar = this.v;
        if (mVar != null) {
            mVar.c();
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(boolean z, int i) {
        this.r.a(z, i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c() {
        this.u.setVisibility(0);
        this.p.setVisibility(8);
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C.cancel();
        }
        this.C.start();
        if (ThemeWatcher.getInstance().isNight()) {
            this.q.setBackgroundResource(e.d.auto_start_anim_night);
        } else {
            this.q.setBackgroundResource(e.d.auto_start_anim);
        }
        this.E = (AnimationDrawable) this.q.getBackground();
        this.E.start();
        ValueAnimator valueAnimator2 = this.D;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.D.cancel();
        }
        this.D.start();
        this.B.removeCallbacks(this.H);
        this.B.postDelayed(this.H, 200L);
        this.G = true;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void d() {
        this.u.setVisibility(8);
        this.p.setVisibility(0);
        l();
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.D.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Log.i("ParkingView", "resetBtnAutoPark.mStartParkingB = " + this.G);
        this.F.setVisibility(8);
        if (this.G) {
            this.B.removeCallbacks(this.H);
            this.G = false;
            this.q.setBackgroundResource(e.d.auto_btn_real_positive_selector);
            this.q.setVisibility(0);
            this.q.setText(com.xiaopeng.autopilot.base.a.g().getString(e.i.start_parking));
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(float f, float f2) {
        PerformanceTestUnit.log("ParkingView", "scu original ds:\t" + f + "\tpercent:\t" + f2 + "," + this.F.getVisibility() + "," + this.F.getAlpha(), 1000L);
        this.e.a(this.a.e(), f, f2);
        this.a.c(f2);
        if (this.F.getVisibility() != 0 && f2 > 0.0f) {
            this.F.setVisibility(0);
        }
        this.F.setProgress((int) f2);
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
            LogUtils.i("ParkingView", "onEvent(SpeechSuperParkEvent), sendAutopilotBroadcast = ACTION_EXIT_AUTO_PARK");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
        com.xiaopeng.autopilot.base.c.a().i().statisExit();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b(final int i) {
        this.a.a(i);
        j(i);
        this.B.post(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.ParkingView.9
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i;
                if (i2 < 0 || i2 >= 7) {
                    ParkingView.this.d(false);
                } else {
                    ParkingView.this.d(true);
                }
                ParkingView.this.e(false);
            }
        });
        LogUtils.i("ParkingView", "onParkLotChoseIndex(), " + i);
        if (this.A == i) {
            Log.i("ParkingView", "index not change :" + this.A + "\t" + i);
            return;
        }
        this.A = i;
    }

    private void j(int i) {
        if (this.A == i) {
            return;
        }
        this.A = i;
        ParkLotItem k = k(i);
        if (k != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            boolean lowConfidence = k.lowConfidence();
            boolean narrow = k.narrow();
            hashMap.put("low", lowConfidence ? BuildInfoUtils.BID_WAN : "0");
            hashMap.put("narrow", narrow ? BuildInfoUtils.BID_WAN : "0");
            hashMap.put(Constants.INDEX, k.getSlotIndex() + "");
            com.xiaopeng.autopilot.base.c.a().i().statisChooseParkingLot(hashMap);
        }
    }

    private ParkLotItem k(int i) {
        Iterator<ParkLotItem> it = this.a.d().iterator();
        while (it.hasNext()) {
            ParkLotItem next = it.next();
            if (next != null && next.getSlotIndex() == i) {
                return next;
            }
        }
        return null;
    }

    public void e(boolean z) {
        int i = this.A;
        ParkLotItem parkLotItem = null;
        if (z) {
            if (i < 0 || i >= 7) {
                this.b.setText(e.i.parking_tips_22_select);
                return;
            }
            if (this.b.getText().equals(getResources().getString(e.i.parking_tips_22_drag))) {
                Iterator<ParkLotItem> it = this.a.d().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ParkLotItem next = it.next();
                    if (next != null && next.getSlotIndex() == i) {
                        parkLotItem = next;
                        break;
                    }
                }
                if (parkLotItem != null) {
                    parkLotItem.narrow();
                }
                this.b.setText(e.i.parking_tips_22_ready);
            }
        } else if (this.a.e() == 22 || this.a.e() == 1) {
            if (i < 0 || i >= 7) {
                this.b.setText(e.i.parking_tips_22_select);
                return;
            }
            Iterator<ParkLotItem> it2 = this.a.d().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ParkLotItem next2 = it2.next();
                if (next2 != null && next2.getSlotIndex() == i) {
                    parkLotItem = next2;
                    break;
                }
            }
            if (parkLotItem != null) {
                parkLotItem.narrow();
            }
            this.b.setText(e.i.parking_tips_22_ready);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.f
    public void a(int i, int i2) {
        this.r.a(i, i2);
    }

    @org.greenrobot.eventbus.m
    public void onEvent(String str) {
        if (str.equalsIgnoreCase(ShortcutEvent.OPEN_REVERING_HOLD_H5_EVENT)) {
            h(1);
        }
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onCarServicesEvent(IScuController.FsdSwitchEventMsg fsdSwitchEventMsg) {
        if (fsdSwitchEventMsg == null) {
            return;
        }
        int intValue = fsdSwitchEventMsg.getData().intValue();
        Log.i("ParkingView", "onCarServicesEvent.FsdSwitchEventMsg.fsdSwitch = " + intValue);
        m mVar = this.v;
        if (mVar != null) {
            mVar.a(intValue);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.b
    public void a() {
        b();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c(boolean z) {
        if (z) {
            this.w.setVisibility(0);
            this.w.d();
            return;
        }
        this.w.setVisibility(8);
        this.w.a();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void setSlideWarningView(View view) {
        if (view instanceof a) {
            this.w = (a) view;
            this.w.setSteerType(2);
        }
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        if (this.p.getVisibility() == 0) {
            LogUtils.i("ParkingView", "onEvent BackPressedEvent ---> 相应泊车默认泊车关闭按钮");
            m();
            return;
        }
        LogUtils.i("ParkingView", "onEvent BackPressedEvent ---> back_pressed_error");
        XToast.showShort(e.i.back_pressed_error);
    }
}
