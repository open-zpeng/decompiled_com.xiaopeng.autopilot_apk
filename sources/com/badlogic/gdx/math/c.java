package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.ah;
/* compiled from: EarClippingTriangulator.java */
/* loaded from: classes.dex */
public class c {
    private short[] b;
    private float[] c;
    private int d;
    private final ah a = new ah();
    private final com.badlogic.gdx.utils.m e = new com.badlogic.gdx.utils.m();
    private final ah f = new ah();

    public ah a(float[] fArr) {
        return a(fArr, 0, fArr.length);
    }

    public ah a(float[] fArr, int i, int i2) {
        this.c = fArr;
        int i3 = i2 / 2;
        this.d = i3;
        int i4 = i / 2;
        ah ahVar = this.a;
        ahVar.a();
        ahVar.c(i3);
        ahVar.b = i3;
        short[] sArr = ahVar.a;
        this.b = sArr;
        if (b(fArr, i, i2)) {
            for (short s = 0; s < i3; s = (short) (s + 1)) {
                sArr[s] = (short) (i4 + s);
            }
        } else {
            int i5 = i3 - 1;
            for (int i6 = 0; i6 < i3; i6++) {
                sArr[i6] = (short) ((i4 + i5) - i6);
            }
        }
        com.badlogic.gdx.utils.m mVar = this.e;
        mVar.b();
        mVar.d(i3);
        for (int i7 = 0; i7 < i3; i7++) {
            mVar.a(a(i7));
        }
        ah ahVar2 = this.f;
        ahVar2.a();
        ahVar2.c(Math.max(0, i3 - 2) * 3);
        a();
        return ahVar2;
    }

    private void a() {
        int i;
        int[] iArr = this.e.a;
        while (true) {
            i = this.d;
            if (i <= 3) {
                break;
            }
            int b = b();
            c(b);
            int d = d(b);
            if (b == this.d) {
                b = 0;
            }
            iArr[d] = a(d);
            iArr[b] = a(b);
        }
        if (i == 3) {
            ah ahVar = this.f;
            short[] sArr = this.b;
            ahVar.a(sArr[0]);
            ahVar.a(sArr[1]);
            ahVar.a(sArr[2]);
        }
    }

    private int a(int i) {
        short[] sArr = this.b;
        int i2 = sArr[d(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[e(i)] * 2;
        float[] fArr = this.c;
        return a(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
    }

    private int b() {
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (b(i2)) {
                return i2;
            }
        }
        int[] iArr = this.e.a;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] != -1) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean b(int i) {
        int i2;
        int[] iArr = this.e.a;
        if (iArr[i] == -1) {
            return false;
        }
        int d = d(i);
        int e = e(i);
        short[] sArr = this.b;
        int i3 = sArr[d] * 2;
        int i4 = sArr[i] * 2;
        int i5 = sArr[e] * 2;
        float[] fArr = this.c;
        float f = fArr[i3];
        int i6 = 1;
        float f2 = fArr[i3 + 1];
        float f3 = fArr[i4];
        float f4 = fArr[i4 + 1];
        float f5 = fArr[i5];
        float f6 = fArr[i5 + 1];
        int e2 = e(e);
        while (e2 != d) {
            if (iArr[e2] != i6) {
                int i7 = sArr[e2] * 2;
                float f7 = fArr[i7];
                float f8 = fArr[i7 + i6];
                i2 = i6;
                if (a(f5, f6, f, f2, f7, f8) >= 0 && a(f, f2, f3, f4, f7, f8) >= 0 && a(f3, f4, f5, f6, f7, f8) >= 0) {
                    return false;
                }
            } else {
                i2 = i6;
            }
            e2 = e(e2);
            i6 = i2;
        }
        return i6;
    }

    private void c(int i) {
        short[] sArr = this.b;
        ah ahVar = this.f;
        ahVar.a(sArr[d(i)]);
        ahVar.a(sArr[i]);
        ahVar.a(sArr[e(i)]);
        this.a.b(i);
        this.e.c(i);
        this.d--;
    }

    private int d(int i) {
        if (i == 0) {
            i = this.d;
        }
        return i - 1;
    }

    private int e(int i) {
        return (i + 1) % this.d;
    }

    private static boolean b(float[] fArr, int i, int i2) {
        if (i2 <= 2) {
            return false;
        }
        int i3 = i2 + i;
        int i4 = i3 - 3;
        int i5 = i;
        float f = 0.0f;
        while (i5 < i4) {
            int i6 = i5 + 2;
            f += (fArr[i5] * fArr[i5 + 3]) - (fArr[i6] * fArr[i5 + 1]);
            i5 = i6;
        }
        return (f + (fArr[i3 + (-2)] * fArr[i + 1])) - (fArr[i] * fArr[i3 - 1]) < 0.0f;
    }

    private static int a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (int) Math.signum((f * (f6 - f4)) + (f3 * (f2 - f6)) + (f5 * (f4 - f2)));
    }
}
