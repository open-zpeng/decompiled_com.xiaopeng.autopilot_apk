package com.badlogic.gdx.utils;
/* compiled from: NumberUtils.java */
/* loaded from: classes.dex */
public final class t {
    public static int a(float f) {
        return Float.floatToIntBits(f);
    }

    public static int b(float f) {
        return Float.floatToRawIntBits(f);
    }

    public static int c(float f) {
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        return floatToRawIntBits | (((int) ((floatToRawIntBits >>> 24) * 1.003937f)) << 24);
    }

    public static float a(int i) {
        return Float.intBitsToFloat(i & (-16777217));
    }
}
