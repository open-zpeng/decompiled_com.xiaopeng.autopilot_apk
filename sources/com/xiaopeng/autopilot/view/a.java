package com.xiaopeng.autopilot.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaopeng.autopilot.R;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IPCUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.camera.view.CameraView;
import com.xiaopeng.autopilot.camera.view.c;
import com.xiaopeng.autopilot.parking.view.ParkingViewContainer;
import com.xiaopeng.autopilot.radar.view.ReversingView;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.xui.widget.XImageView;
/* compiled from: ParkingMainWidget.java */
/* loaded from: classes.dex */
public class a extends FrameLayout implements c, ThemeWatcher.OnThemeSwitchListener, rj {
    private View a;
    private ParkingViewContainer b;
    private ReversingView c;
    private CameraView d;

    @Override // defpackage.rj
    public void setWidgetAlpha(float f) {
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
        IPCUtil.sendToAppsReboot();
        f();
    }

    public void e() {
        this.a = com.xiaopeng.autopilot.parking.c.a((ViewGroup) this);
        com.xiaopeng.autopilot.parking.c.c(this);
        com.xiaopeng.autopilot.parking.c.d(this);
        this.d = (CameraView) findViewById(R.id.container_camera);
        this.b = (ParkingViewContainer) findViewById(R.id.parking_view_container);
        this.c = (ReversingView) findViewById(R.id.container_reversing);
        this.b.setReversingView(this.c);
        this.d.setCameraViewCallback(this);
        View a = com.xiaopeng.autopilot.parking.c.a(this.a);
        if (a != null) {
            this.b.setSlideWarningView(a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (getParent() != null) {
            super.onAttachedToWindow();
        }
        IPCUtil.sendAutoPilotShowIPC();
        com.xiaopeng.autopilot.parking.c.b();
        com.xiaopeng.autopilot.parking.c.v();
        com.xiaopeng.autopilot.base.c.a().k();
        PerformanceTestUnit.log("ParkingMainWidget", "StartPerformance onAttachedToWindow ", true);
        f();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PerformanceTestUnit.resetStartPerformance();
        IPCUtil.sendAutopilotCloseIPC();
        com.xiaopeng.autopilot.base.c.a().l();
        if (CarApiUtil.getGear() == 4) {
            IntentUtil.showLearningSummonCard();
        }
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.xiaopeng.autopilot.base.c.a().i().statisClickScreen(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // defpackage.rj
    public void a() {
        this.b.setAlpha(1.0f);
        this.b.a();
    }

    @Override // defpackage.rj
    public void b() {
        this.b.setAlpha(0.0f);
        this.b.e();
    }

    @Override // defpackage.rj
    public void c() {
        this.d.e();
    }

    @Override // defpackage.rj
    public void d() {
        this.d.f();
    }

    public ParkingViewContainer getParkingView() {
        return this.b;
    }

    public com.xiaopeng.autopilot.radar.view.a getReversingView() {
        return this.c;
    }

    public com.xiaopeng.autopilot.camera.view.b getCameraView() {
        return this.d;
    }

    @Override // com.xiaopeng.autopilot.camera.view.c
    public void a(boolean z) {
        ParkingViewContainer parkingViewContainer = this.b;
        if (parkingViewContainer != null) {
            parkingViewContainer.setXpilotClick(z);
        }
    }

    private void f() {
        XImageView xImageView = (XImageView) this.a.findViewById(R.id.psn_srs_enable);
        Log.i("ParkingMainWidget", "checkPsnSrsenable ，BuildConfig.FLAVOR_cartype = d55");
        Log.i("ParkingMainWidget", "checkPsnSrsenable ，Constant.isInternation() " + d.e());
        if (("vd55".equals("d55") || "ve38".equals("d55") || "ve28a".equals("d55") || "vf30".equals("d55")) && d.e()) {
            xImageView.setVisibility(0);
            if (d.d()) {
                Log.i("ParkingMainWidget", "checkPsnSrsenable enable");
                if (!ThemeWatcher.getInstance().isNight()) {
                    xImageView.setImageResource(R.mipmap.airbag_on_day);
                    return;
                } else {
                    xImageView.setImageResource(R.mipmap.airbag_on_night);
                    return;
                }
            }
            Log.i("ParkingMainWidget", "checkPsnSrsenable disable");
            if (!ThemeWatcher.getInstance().isNight()) {
                xImageView.setImageResource(R.mipmap.airbag_off_day);
                return;
            } else {
                xImageView.setImageResource(R.mipmap.airbag_off_night);
                return;
            }
        }
        xImageView.setVisibility(8);
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        f();
    }
}
