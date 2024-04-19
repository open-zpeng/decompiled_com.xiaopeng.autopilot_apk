package com.xiaopeng.autopilot.radar.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.j;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class ReversingView extends FrameLayout implements a, ThemeWatcher.OnThemeSwitchListener {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private Handler h;
    private va i;
    private vf j;

    public ReversingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReversingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new Handler();
        a();
        c();
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        c();
    }

    private void c() {
        if (!ThemeWatcher.getInstance().isNight()) {
            this.h.post(new Runnable() { // from class: com.xiaopeng.autopilot.radar.view.ReversingView.1
                @Override // java.lang.Runnable
                public void run() {
                    ReversingView.this.e.setTextColor(j.UNDEFINED_DURATION);
                    ReversingView.this.f.setTextColor(j.UNDEFINED_DURATION);
                }
            });
        } else {
            this.h.post(new Runnable() { // from class: com.xiaopeng.autopilot.radar.view.ReversingView.2
                @Override // java.lang.Runnable
                public void run() {
                    ReversingView.this.e.setTextColor(-2130706433);
                    ReversingView.this.f.setTextColor(-2130706433);
                }
            });
        }
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_reversing, (ViewGroup) this, true);
        b();
    }

    public void b() {
        this.a = (TextView) findViewById(e.C0055e.tv_radar_distance_f);
        this.b = (TextView) findViewById(e.C0055e.tv_radar_distance_b);
        this.c = (TextView) findViewById(e.C0055e.tv_radar_distance_f_unit);
        this.d = (TextView) findViewById(e.C0055e.tv_radar_distance_b_unit);
        this.e = (TextView) findViewById(e.C0055e.radar_error_tip_f);
        this.f = (TextView) findViewById(e.C0055e.radar_error_tip_b);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (getParent() != null) {
            super.onAttachedToWindow();
        }
        c();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        c.a().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
        c.a().c(this);
    }

    @Override // com.xiaopeng.autopilot.radar.view.a
    public synchronized void a(float f) {
        PerformanceTestUnit.log("ReversingView_onDataFUpdate", "onDataFUpdate.minDist = " + f + "," + this.g, 1000L);
        if (this.g < 0) {
            this.a.setText("");
            this.a.setVisibility(8);
            this.c.setVisibility(8);
            return;
        }
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        if (i > 0) {
            if (f > 100.0f) {
                Log.i("ReversingView", "onDataFUpdate.Radar distance is more than 100");
                this.a.setText("");
                this.a.setVisibility(8);
                this.c.setVisibility(8);
                return;
            }
            this.a.setText(String.valueOf((int) f));
            if (!ThemeWatcher.getInstance().isNight()) {
                this.a.setTextColor(getResources().getColor(e.b.radar_dist_text_color_light));
                this.c.setTextColor(getResources().getColor(e.b.radar_dist_text_color_light));
            } else {
                this.a.setTextColor(getResources().getColor(e.b.radar_dist_text_color_dark));
                this.c.setTextColor(getResources().getColor(e.b.radar_dist_text_color_dark));
            }
            this.a.setVisibility(0);
            this.c.setVisibility(0);
        } else if (f == 0.0f) {
            this.a.setText("");
            this.a.setVisibility(8);
            this.c.setVisibility(8);
        } else if (i == 0 && this.i.a() != 1) {
            this.a.setText(e.i.radar_stop_text);
            this.a.setTextColor(getResources().getColor(e.b.radar_stop_text_color));
            this.a.setVisibility(0);
            this.c.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.autopilot.radar.view.a
    public synchronized void b(float f) {
        PerformanceTestUnit.log("ReversingView_onDataBUpdate", "onDataBUpdate.minDist = " + f + "," + this.g, 1000L);
        if (this.g < 0) {
            this.b.setText("");
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            return;
        }
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        if (i > 0) {
            if (f > 100.0f && this.i.a() != 0) {
                Log.i("ReversingView", "onDataBUpdate.Radar distance is more than 100");
                this.b.setText("");
                this.b.setVisibility(8);
                this.d.setVisibility(8);
                return;
            }
            this.b.setText(String.valueOf((int) f));
            if (!ThemeWatcher.getInstance().isNight()) {
                this.b.setTextColor(getResources().getColor(e.b.radar_dist_text_color_light));
                this.d.setTextColor(getResources().getColor(e.b.radar_dist_text_color_light));
            } else {
                this.b.setTextColor(getResources().getColor(e.b.radar_dist_text_color_dark));
                this.d.setTextColor(getResources().getColor(e.b.radar_dist_text_color_dark));
            }
            this.b.setVisibility(0);
            this.d.setVisibility(0);
        } else if (f == 0.0f) {
            this.b.setText("");
            this.b.setVisibility(8);
            this.d.setVisibility(8);
        } else if (i == 0 && this.i.a() != 1) {
            this.b.setText(e.i.radar_stop_text);
            this.b.setTextColor(getResources().getColor(e.b.radar_stop_text_color));
            this.b.setVisibility(0);
            this.d.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.autopilot.radar.view.a
    public void a(Pair<Boolean, Boolean> pair) {
        this.f.setVisibility(8);
        if (((Boolean) pair.first).booleanValue() && ((Boolean) pair.second).booleanValue()) {
            this.f.setText(e.i.radar_error_tip_both);
            this.f.setVisibility(0);
        } else if (((Boolean) pair.first).booleanValue() && !((Boolean) pair.second).booleanValue()) {
            this.f.setText(e.i.radar_error_tip_front);
            this.f.setVisibility(0);
        } else if (!((Boolean) pair.first).booleanValue() && ((Boolean) pair.second).booleanValue()) {
            this.f.setText(e.i.radar_error_tip_back);
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.autopilot.radar.view.a
    public void a(vf vfVar) {
        this.j = vfVar;
        this.i = new va(this.j);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IVcuController.PureDriveModeFeedbackEventMsg pureDriveModeFeedbackEventMsg) {
        if (pureDriveModeFeedbackEventMsg.getData().intValue() == 1) {
            return;
        }
        LogUtils.i("ReversingView", "3D自动泊车过程，雷达距离常显");
        setVisibility(0);
    }

    public rk getRadar3DSenceListener() {
        return this.i;
    }

    public void setDrawType(int i) {
        this.g = i;
        this.i.a(i);
        if (this.g < 0) {
            this.b.setText("");
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.b.setText("");
            this.b.setVisibility(8);
            this.d.setVisibility(8);
        }
    }
}
