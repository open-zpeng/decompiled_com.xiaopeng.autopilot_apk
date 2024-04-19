package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class ParkingProgressBar extends ProgressBar {
    private static float b = 0.25f;
    private float a;
    private float c;
    private int d;
    private int e;
    private TextView f;
    private TextView g;
    private TextView h;
    private LinearLayout i;

    public void setDistanceComponent(TextView textView) {
        this.f = textView;
    }

    public void setDistanceUnitComponent(TextView textView) {
        this.g = textView;
    }

    public void setDistanceContainer(LinearLayout linearLayout) {
        this.i = linearLayout;
    }

    public void setDistanceLeft(TextView textView) {
        this.h = textView;
    }

    public ParkingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
        setMax(1000);
    }

    private void b() {
        setProgress(0);
        this.a = 0.0f;
        this.c = 0.0f;
        this.e = 0;
        this.d = 0;
    }

    private boolean a(float f, float f2) {
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i < 0) {
            b();
        }
        LinearLayout linearLayout = this.i;
        if (linearLayout != null && i < 0) {
            linearLayout.setVisibility(8);
        }
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (!(i2 == 0 && f2 == 100.0f && this.c == 0.0f) && (i2 != 0 || f2 > 0.0f)) {
            return i < 0;
        }
        this.i.setVisibility(8);
        b();
        return true;
    }

    public void a(int i, float f, float f2) {
        if (a(f, f2)) {
            return;
        }
        boolean b2 = b(f, f2);
        if (b2) {
            this.a = 0.0f;
        }
        float[] a = a(f, f2, b2);
        int i2 = (int) a[1];
        float f3 = a[0];
        setProgress(i2);
        a(i, f3);
        this.e = 0;
        this.d = i2;
        this.c = f2;
    }

    private boolean b(float f, float f2) {
        return f2 < this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float[] a(float r17, float r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = 2
            float[] r3 = new float[r3]
            r3 = {x00c2: FILL_ARRAY_DATA  , data: [0, 0} // fill-array
            r4 = 1119092736(0x42b40000, float:90.0)
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            r5 = 1120403456(0x42c80000, float:100.0)
            r6 = 0
            if (r4 <= 0) goto L1b
            r4 = 1064514355(0x3f733333, float:0.95)
            com.xiaopeng.autopilot.parking.view.ParkingProgressBar.b = r4
            goto L29
        L1b:
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 != 0) goto L25
            r4 = 1065353216(0x3f800000, float:1.0)
            com.xiaopeng.autopilot.parking.view.ParkingProgressBar.b = r4
            r4 = r6
            goto L2b
        L25:
            r4 = 1048576000(0x3e800000, float:0.25)
            com.xiaopeng.autopilot.parking.view.ParkingProgressBar.b = r4
        L29:
            r4 = r17
        L2b:
            int r7 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            r8 = 1
            r9 = 0
            if (r7 != 0) goto L39
            r0.setProgress(r9)
            r3[r9] = r4
            r3[r8] = r6
            return r3
        L39:
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 != 0) goto L4e
            int r1 = r16.getMax()
            r0.setProgress(r1)
            r3[r9] = r17
            int r1 = r16.getMax()
            float r1 = (float) r1
            r3[r8] = r1
            return r3
        L4e:
            float r5 = r0.c
            r7 = 1106247680(0x41f00000, float:30.0)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L65
            if (r2 == 0) goto L65
            int r1 = r16.getMax()
            r0.setProgress(r1)
            r3[r9] = r6
            float r1 = (float) r1
            r3[r8] = r1
            return r3
        L65:
            r5 = 1092616192(0x41200000, float:10.0)
            float r6 = r1 * r5
            float r7 = com.xiaopeng.autopilot.parking.view.ParkingProgressBar.b
            float r10 = r1 * r7
            double r10 = (double) r10
            float r12 = r0.a
            double r12 = (double) r12
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r8 = (double) r7
            double r14 = r14 - r8
            double r12 = r12 * r14
            double r10 = r10 + r12
            float r7 = (float) r10
            r0.a = r7
            float r5 = r5 * r7
            int r5 = (int) r5
            boolean r8 = com.xiaopeng.autopilot.base.d.c()
            if (r8 == 0) goto Lba
            java.lang.String r8 = "ParkingProgressBar"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "original percent:\t"
            r9.append(r10)
            r9.append(r1)
            java.lang.String r1 = "扩大10倍:\t"
            r9.append(r1)
            r9.append(r6)
            java.lang.String r1 = "\t算法后的值:\t"
            r9.append(r1)
            r9.append(r7)
            java.lang.String r1 = "\t滤波设置值:\t"
            r9.append(r1)
            r9.append(r5)
            java.lang.String r1 = "\t是否下降:\t"
            r9.append(r1)
            r9.append(r2)
            java.lang.String r1 = r9.toString()
            android.util.Log.i(r8, r1)
            r1 = 0
            goto Lbb
        Lba:
            r1 = 0
        Lbb:
            r3[r1] = r4
            float r1 = (float) r5
            r2 = 1
            r3[r2] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.autopilot.parking.view.ParkingProgressBar.a(float, float, boolean):float[]");
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void a(int i, float f) {
        PerformanceTestUnit.log("ParkingProgressBar", "displayDistance.CarApiUtil.getGear() = " + CarApiUtil.getGear() + ",tips = " + i, 1000L);
        if (i == 2) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        this.i.setVisibility(0);
        String format = decimalFormat.format(f);
        if (i == 34) {
            this.h.setText(e.i.distance_pre_b0);
        } else {
            this.h.setText(e.i.distance_pre);
        }
        this.f.setText(format);
        this.g.setText(e.i.distance_unit_m);
    }

    public void a() {
        if (com.xiaopeng.autopilot.base.d.c()) {
            Log.i("ParkingProgressBar", "switchTheme");
        }
        if (ThemeWatcher.getInstance().isNight()) {
            setBackgroundColor(getResources().getColor(e.b.parking_progress_bar_bg_color_night));
            setProgressDrawable(getResources().getDrawable(e.d.progress_bar));
            return;
        }
        setBackgroundColor(getResources().getColor(e.b.parking_progress_bar_bg_color_day));
        setProgressDrawable(getResources().getDrawable(e.d.progress_bar_light));
    }

    public void a(int i) {
        this.e = i;
        if (com.xiaopeng.autopilot.base.d.c()) {
            Log.i("ParkingProgressBar", "产生暂停值:\t" + i);
        }
    }
}
