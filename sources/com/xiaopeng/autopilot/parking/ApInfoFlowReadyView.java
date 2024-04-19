package com.xiaopeng.autopilot.parking;

import android.animation.Animator;
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
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* loaded from: classes.dex */
public class ApInfoFlowReadyView extends RelativeLayout implements ThemeWatcher.OnThemeSwitchListener {
    private View a;
    private ImageView b;
    private TextView c;
    private ValueAnimator d;
    private Runnable e;

    public ApInfoFlowReadyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApInfoFlowReadyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Runnable() { // from class: com.xiaopeng.autopilot.parking.ApInfoFlowReadyView.1
            @Override // java.lang.Runnable
            public void run() {
                ApInfoFlowReadyView.this.d.start();
            }
        };
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("APInfoFlow", "onAttachedToWindow");
        a();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("APInfoFlow", "onDetachedFromWindow");
        ThemeWatcher.getInstance().removeThemeListener(this);
        setVisibility(8);
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        a();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_ap_ready_start_layout, (ViewGroup) this, true);
        this.a = findViewById(e.C0055e.parking_ap_loading_layout);
        this.b = (ImageView) findViewById(e.C0055e.parking_ap_loading_bg);
        this.c = (TextView) findViewById(e.C0055e.parking_ap_loading_text);
        this.d = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.d.setDuration(1000L);
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.autopilot.parking.ApInfoFlowReadyView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ApInfoFlowReadyView.this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.d.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.autopilot.parking.ApInfoFlowReadyView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ApInfoFlowReadyView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ApInfoFlowReadyView.this.setVisibility(8);
            }
        });
    }

    public void a() {
        if (ThemeWatcher.getInstance().isNight()) {
            this.b.setImageResource(e.d.ic_ap_loading_night);
            this.c.setTextColor(-1);
            return;
        }
        this.b.setImageResource(e.d.ic_ap_loading_day);
        this.c.setTextColor(-16777216);
    }

    public void a(int i) {
        if (this.a != null) {
            setVisibility(i);
            this.a.setVisibility(i);
            if (i == 0) {
                this.a.setAlpha(1.0f);
                rh.a().e(this.e);
                boolean booleanValue = ((i.C0051i) i.a(i.C0051i.class)).d().booleanValue();
                Log.i("APInfo", "apReady = " + booleanValue);
                if (booleanValue) {
                    rh.a().a(this.e, 5000L);
                    return;
                } else {
                    rh.a().a(this.e, 2000L);
                    return;
                }
            }
            this.d.cancel();
            this.a.setAlpha(0.0f);
            rh.a().e(this.e);
        }
    }
}
