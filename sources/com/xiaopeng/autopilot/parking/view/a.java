package com.xiaopeng.autopilot.parking.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.xui.widget.XTextView;
/* compiled from: APCancelPageView.java */
/* loaded from: classes.dex */
public class a extends RelativeLayout implements ThemeWatcher.OnThemeSwitchListener {
    private int a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private XTextView e;
    private ValueAnimator f;

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, int i) {
        this(context);
        this.a = i;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1;
        this.f = ValueAnimator.ofFloat(0.3f, 1.0f);
        b();
        c();
    }

    public void setSteerType(int i) {
        this.a = i;
    }

    public void a() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f.cancel();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        e();
    }

    private void e() {
        if (ThemeWatcher.getInstance().isNight()) {
            this.b.setImageResource(e.g.ic_ap_xpu_cancel_l_night);
            this.c.setImageResource(e.g.ic_ap_xpu_cancel_r_night);
            if (this.a == 2) {
                this.d.setImageResource(e.g.ic_ap_xpu_brake_steer_night);
                this.e.setText(e.i.ap_cancel_page_view_hold_brake_hint);
                return;
            }
            this.d.setImageResource(e.g.ic_ap_xpu_cancel_steer_night);
            this.e.setText(e.i.ap_cancel_page_view_take_over_hint);
            return;
        }
        this.b.setImageResource(e.g.ic_ap_xpu_cancel_l);
        this.c.setImageResource(e.g.ic_ap_xpu_cancel_r);
        if (this.a == 2) {
            this.d.setImageResource(e.g.ic_ap_xpu_brake_steer);
            this.e.setText(e.i.ap_cancel_page_view_hold_brake_hint);
            return;
        }
        this.d.setImageResource(e.g.ic_ap_xpu_cancel_steer);
        this.e.setText(e.i.ap_cancel_page_view_take_over_hint);
    }

    public void b() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_ap_xpu_cancel_layout, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(e.C0055e.parking_ap_xpu_cancel_l);
        this.c = (ImageView) findViewById(e.C0055e.parking_ap_xpu_cancel_r);
        this.d = (ImageView) findViewById(e.C0055e.parking_ap_xpu_cancel_steer);
        this.e = (XTextView) findViewById(e.C0055e.hint);
    }

    public void c() {
        this.f.setDuration(600L);
        this.f.setRepeatMode(2);
        this.f.setRepeatCount(-1);
        this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.view.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.b.setAlpha(floatValue);
                a.this.c.setAlpha(floatValue);
            }
        });
    }

    public void d() {
        int intValue = ((i.b) com.xiaopeng.autopilot.base.i.a(i.b.class)).d().intValue();
        Log.i("APCancelPageView", "startAnimator.apIsCancel = " + intValue);
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f.cancel();
        }
        ValueAnimator valueAnimator2 = this.f;
        if (valueAnimator2 != null && intValue == 1) {
            valueAnimator2.start();
            this.d.setAlpha(1.0f);
        } else if (intValue == 2) {
            this.b.setAlpha(0.0f);
            this.c.setAlpha(0.0f);
            this.d.setAlpha(1.0f);
        } else if (intValue == 3) {
            this.f.start();
            this.d.setAlpha(0.0f);
        } else if (intValue == 4) {
            this.d.setAlpha(1.0f);
            this.f.start();
        }
    }
}
