package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.parking.e;
/* loaded from: classes.dex */
public class InfoBoardView extends FrameLayout {
    private APAInfoBoardView a;
    private APInfoBoardView b;
    private TrainingInfoBoardView c;
    private int d;
    private ParkingViewPro e;

    public InfoBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InfoBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_pro_info_board_view, (ViewGroup) this, true);
        this.a = (APAInfoBoardView) findViewById(e.C0055e.apa_info_board_view);
        this.b = (APInfoBoardView) findViewById(e.C0055e.ap_info_board_view);
        this.c = (TrainingInfoBoardView) findViewById(e.C0055e.training_info_board_view);
    }

    public void setParkingView(ParkingViewPro parkingViewPro) {
        this.b.setParkingView(parkingViewPro);
        this.a.setParkingView(parkingViewPro);
        this.c.setParkingView(parkingViewPro);
        this.e = parkingViewPro;
    }

    public void a(int i) {
        this.d = i;
        switch (i) {
            case 1:
                this.b.setVisibility(8);
                this.a.setVisibility(0);
                this.c.setVisibility(8);
                this.c.b();
                return;
            case 2:
                this.b.setVisibility(0);
                this.a.setVisibility(8);
                this.c.setVisibility(8);
                this.c.b();
                return;
            case 3:
                this.b.setVisibility(8);
                this.a.setVisibility(8);
                this.c.setVisibility(0);
                int A = this.e.a.A();
                if (A == 14 || A == 13) {
                    this.c.e(8);
                    return;
                } else {
                    this.c.e(0);
                    return;
                }
            default:
                this.b.setVisibility(8);
                this.a.setVisibility(0);
                this.c.setVisibility(8);
                this.c.b();
                return;
        }
    }

    public void a(int i, float f) {
        this.b.a(i, f);
    }

    public void a(int i, int i2) {
        this.b.a(i);
        this.b.b(i2);
    }

    public void a(String str, int i) {
        this.b.a(str, i);
    }

    public void b(int i) {
        this.b.c(i);
    }

    public void a() {
        this.a.c(CarApiUtil.getGear());
        this.a.a();
        this.c.c();
    }

    public void a(int i, int i2, String str, int i3) {
        this.a.a(i, i2, str, i3);
    }

    public void a(boolean z, int i, int i2, String str, View.OnClickListener onClickListener) {
        this.a.a(z, i, i2, str, onClickListener);
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void a(ParkingViewPro parkingViewPro, boolean z) {
        this.a.a(parkingViewPro, z);
    }

    public void c(int i) {
        this.a.c(i);
        if (i == 4) {
            this.c.c(true);
        } else {
            this.c.c(false);
        }
    }

    public void b(boolean z) {
        this.c.c(z);
    }

    public void a(float f) {
        this.a.a(f);
        this.b.a(f);
    }

    public void d(int i) {
        this.a.a(i);
    }

    public void e(int i) {
        this.a.b(i);
    }

    public void a(int i, float f, float f2) {
        this.a.a(i, f, f2);
    }

    public void setDistanceLayoutVisible(int i) {
        this.a.setDistanceLayoutVisible(i);
    }

    public void a(boolean z, int i) {
        this.a.a(z, i);
    }

    public void b(int i, int i2) {
        this.a.b(i, i2);
    }

    public void a(String str) {
        this.c.a(str);
    }

    public int getInfoBoardType() {
        return this.d;
    }

    public void b() {
        this.c.d();
    }

    public void c(boolean z) {
        this.c.d(z);
    }

    public void c() {
        this.c.e();
    }

    public void c(int i, int i2) {
        this.b.a(i, i2);
    }

    public void d() {
        this.b.a();
    }

    public void f(int i) {
        this.c.b(i);
    }

    public void g(int i) {
        this.c.c(i);
    }

    public void h(int i) {
        this.c.d(i);
    }

    public void a(String str, boolean z, boolean z2, String str2) {
        this.c.a(str, z, z2, str2);
    }

    public void b(int i, float f, float f2) {
        this.c.a(i, f, f2);
    }

    public void d(boolean z) {
        this.c.a(z);
    }

    public void i(int i) {
        this.c.a(i);
    }

    public void e(boolean z) {
        this.c.b(z);
    }

    public void j(int i) {
        this.b.d(i);
    }
}
