package com.xiaopeng.autopilot.base.utils;

import com.xiaopeng.autopilot.base.c;
/* loaded from: classes.dex */
public class WheelUtil {
    private static final String TAG = "WheelUtil";

    @Deprecated
    public static float calculateMaxWheelAngle() {
        return 0.0f;
    }

    @Deprecated
    public static float calculateWheelAngle(float f) {
        return 0.0f;
    }

    public static double sin(double d) {
        return Math.sin((d * 3.141592653589793d) / 180.0d);
    }

    public static double cos(double d) {
        return Math.cos((d * 3.141592653589793d) / 180.0d);
    }

    public static double acos(double d) {
        return (Math.acos(d) * 180.0d) / 3.141592653589793d;
    }

    public static double tan(double d) {
        return Math.tan((d * 3.141592653589793d) / 180.0d);
    }

    public static double atan(double d) {
        return (Math.atan(d) * 180.0d) / 3.141592653589793d;
    }

    @Deprecated
    public static float getSteerAngle() {
        try {
            return calculateWheelAngle(c.a().g().getSteeringAngle()) * (-1.0f);
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
