package com.xiaopeng.autopilot.parking;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mars.xlog.Log;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.NavStartCloseEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.NavStartPointGuideWidget;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XTextView;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: GuideToAPStartPointView.java */
/* loaded from: classes.dex */
public class a extends ConstraintLayout {
    private static String a = "GuideToAPStartPointView";
    private NavStartPointGuideWidget b;
    private XImageButton c;
    private View d;
    private XDialog e;
    private XTextView f;
    private int g;
    private LinearLayout h;
    private XTextView i;
    private int j;
    private int k;
    private Runnable l;

    public a(Context context) {
        super(context);
        this.g = -1;
        this.l = new Runnable() { // from class: com.xiaopeng.autopilot.parking.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.h != null) {
                    a.this.h.setVisibility(0);
                }
            }
        };
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_guide_to_ap_startpoint_view, (ViewGroup) this, true);
        this.b = (NavStartPointGuideWidget) findViewById(e.C0055e.guide_widget);
        this.c = (XImageButton) findViewById(e.C0055e.pro_view_ib_close);
        this.f = (XTextView) findViewById(e.C0055e.hint);
        this.h = (LinearLayout) findViewById(e.C0055e.distance_layout);
        this.i = (XTextView) findViewById(e.C0055e.tv_distance);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.-$$Lambda$a$jq-iumQ2hyxdamJR6n0mV50XoH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        findViewById(e.C0055e.training_finish_learn_top_bg).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.d = findViewById(e.C0055e.training_finish_learn_right_bg);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c();
    }

    private void c() {
        if (this.e == null) {
            this.e = new XDialog(getContext(), e.j.XDialogView);
            this.e.setMessage(e.i.nav_exit_content);
            this.e.setTitle(e.i.nav_exit_title);
            this.e.getDialog().setCanceledOnTouchOutside(false);
            this.e.getDialog().getWindow().setType(2047);
            this.e.setPositiveButton(getResources().getString(e.i.training_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.-$$Lambda$a$GMTzqkLkO28iJxFiYn_XKNHsOEM
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public final void onClick(XDialog xDialog, int i) {
                    a.b(xDialog, i);
                }
            });
            this.e.setNegativeButton(getResources().getString(e.i.training_learn_close_dialog_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.-$$Lambda$a$6Ui_watJ_8V2lmRzYmZzmie8UGs
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public final void onClick(XDialog xDialog, int i) {
                    a.this.a(xDialog, i);
                }
            });
        }
        this.e.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(XDialog xDialog, int i) {
        org.greenrobot.eventbus.c.a().d(new NavStartCloseEvent());
        XToast.show(e.i.nav_fail_tips);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(XDialog xDialog, int i) {
        this.e.dismiss();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.g = -1;
    }

    public void a() {
        XDialog xDialog = this.e;
        if (xDialog == null || !xDialog.isShowing()) {
            return;
        }
        this.e.dismiss();
    }

    public void a(int i) {
        this.j = i;
        rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.e();
                if (((i.u) i.a(i.u.class)).d().intValue() == 3) {
                    a.this.b.setAlpha(0.26f);
                    a.this.h.setAlpha(0.26f);
                    return;
                }
                a.this.b.setAlpha(1.0f);
                a.this.h.setAlpha(1.0f);
            }
        }, 300L);
    }

    public void b(int i) {
        if (i == 3) {
            this.b.setAlpha(0.26f);
            this.h.setAlpha(0.26f);
            return;
        }
        this.b.setAlpha(1.0f);
        this.h.setAlpha(1.0f);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b.a(i, i2, i3, i4, this.j);
        this.k = i;
        if (i == 9) {
            this.f.setText(e.i.nav_guide_top_sub_title_instruction);
            rh.a().e(this.l);
            this.h.setVisibility(8);
        } else if (i < 9 || (i >= 14 && i <= 21)) {
            e();
            if (this.g != i3) {
                this.i.setText(String.format(getResources().getString(e.i.nav_guide_startpoint_distance_tip_2), Integer.valueOf(i3)));
                this.g = i3;
            }
        } else {
            rh.a().e(this.l);
            this.h.setVisibility(8);
            this.f.setText(e.i.nav_guide_top_sub_title_instruction);
        }
    }

    private void d() {
        if (this.j == 2) {
            rh.a().e(this.l);
            this.h.setVisibility(8);
            return;
        }
        rh.a().b(this.l, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (getVisibility() == 0) {
            if (this.j == 2) {
                rh.a().e(this.l);
                this.h.setVisibility(8);
                return;
            }
            int i = this.k;
            if (i < 9 || (i >= 14 && i <= 21)) {
                rh.a().b(this.l, 800L);
            }
        }
    }

    public void c(int i) {
        int i2 = ((ConstraintLayout.a) this.h.getLayoutParams()).leftMargin;
        int i3 = ((ConstraintLayout.a) this.h.getLayoutParams()).topMargin;
        AnimatorSet animatorSet = new AnimatorSet();
        if (i == 1) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, "translationX", ((int) getResources().getDimension(e.c.guide_distance_layout_camera_left_margin_left)) - i2);
            ofFloat.setDuration(800L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.h, "translationY", ((int) getResources().getDimension(e.c.guide_distance_layout_camera_left_margin_top)) - i3);
            ofFloat2.setDuration(800L);
            LinearLayout linearLayout = this.h;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "scaleX", linearLayout.getScaleX(), 0.76f);
            LinearLayout linearLayout2 = this.h;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout2, "scaleY", linearLayout2.getScaleY(), 0.76f);
            ofFloat3.setDuration(800L);
            ofFloat4.setDuration(800L);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        } else if (i == 2) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.h, "translationX", ((int) getResources().getDimension(e.c.guide_distance_layout_camera_right_margin_left)) - i2);
            ofFloat5.setDuration(800L);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.h, "translationY", ((int) getResources().getDimension(e.c.guide_distance_layout_camera_right_margin_top)) - i3);
            ofFloat6.setDuration(800L);
            LinearLayout linearLayout3 = this.h;
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(linearLayout3, "scaleX", linearLayout3.getScaleX(), 1.0f);
            LinearLayout linearLayout4 = this.h;
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(linearLayout4, "scaleY", linearLayout4.getScaleY(), 1.0f);
            ofFloat7.setDuration(800L);
            ofFloat8.setDuration(800L);
            animatorSet.play(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat8);
        }
        animatorSet.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        org.greenrobot.eventbus.c.a().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        org.greenrobot.eventbus.c.a().c(this);
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(BackPressedEvent backPressedEvent) {
        if (getVisibility() == 0) {
            Log.i(a, "BackPressedEvent");
            c();
        }
    }
}
