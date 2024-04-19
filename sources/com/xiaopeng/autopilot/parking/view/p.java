package com.xiaopeng.autopilot.parking.view;

import android.view.animation.Interpolator;
/* compiled from: SpringInterpolator.java */
/* loaded from: classes.dex */
public class p implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, (-10.0f) * f) * Math.sin((((f - 0.1f) * 2.0d) * 3.141592653589793d) / 0.4f)) + 1.0d);
    }
}
