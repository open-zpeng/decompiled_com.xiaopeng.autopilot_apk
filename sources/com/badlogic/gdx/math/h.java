package com.badlogic.gdx.math;

import java.util.Random;
/* compiled from: MathUtils.java */
/* loaded from: classes.dex */
public final class h {
    public static Random a = new m();

    public static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int b(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public static boolean c(int i) {
        return i != 0 && (i & (i + (-1))) == 0;
    }

    /* compiled from: MathUtils.java */
    /* loaded from: classes.dex */
    private static class a {
        static final float[] a = new float[16384];

        static {
            float f;
            for (int i = 0; i < 16384; i++) {
                a[i] = (float) Math.sin(((i + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                a[((int) (45.511112f * i2)) & 16383] = (float) Math.sin(f * 0.017453292f);
            }
        }
    }

    public static float a(float f) {
        return a.a[((int) (f * 2607.5945f)) & 16383];
    }

    public static float b(float f) {
        return a.a[((int) ((f + 1.5707964f) * 2607.5945f)) & 16383];
    }

    public static float c(float f) {
        return a.a[((int) (f * 45.511112f)) & 16383];
    }

    public static float d(float f) {
        return a.a[((int) ((f + 90.0f) * 45.511112f)) & 16383];
    }

    public static int a(int i) {
        return a.nextInt(i + 1);
    }

    public static int a(int i, int i2) {
        return i + a.nextInt((i2 - i) + 1);
    }

    public static float a() {
        return a.nextFloat();
    }

    public static float e(float f) {
        return a.nextFloat() * f;
    }

    public static boolean f(float f) {
        return Math.abs(f) <= 1.0E-6f;
    }

    public static boolean a(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-6f;
    }
}
