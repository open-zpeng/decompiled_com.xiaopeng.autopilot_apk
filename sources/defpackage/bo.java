package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
/* compiled from: SplineSet.java */
/* renamed from: bo  reason: default package */
/* loaded from: classes.dex */
public abstract class bo {
    protected bg a;
    protected int[] b = new int[10];
    protected float[] c = new float[10];
    private int d;
    private String e;

    public String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.d; i++) {
            str = str + "[" + this.b[i] + " , " + decimalFormat.format(this.c[i]) + "] ";
        }
        return str;
    }

    public void a(String str) {
        this.e = str;
    }

    public float a(float f) {
        return (float) this.a.a(f, 0);
    }

    public void a(int i, float f) {
        int[] iArr = this.b;
        if (iArr.length < this.d + 1) {
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.c;
            this.c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.b;
        int i2 = this.d;
        iArr2[i2] = i;
        this.c[i2] = f;
        this.d = i2 + 1;
    }

    public void a(int i) {
        int i2;
        int i3 = this.d;
        if (i3 == 0) {
            return;
        }
        a.a(this.b, this.c, 0, i3 - 1);
        int i4 = 1;
        for (int i5 = 1; i5 < this.d; i5++) {
            int[] iArr = this.b;
            if (iArr[i5 - 1] != iArr[i5]) {
                i4++;
            }
        }
        double[] dArr = new double[i4];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i4, 1);
        int i6 = 0;
        for (i2 = 0; i2 < this.d; i2 = i2 + 1) {
            if (i2 > 0) {
                int[] iArr2 = this.b;
                i2 = iArr2[i2] == iArr2[i2 - 1] ? i2 + 1 : 0;
            }
            dArr[i6] = this.b[i2] * 0.01d;
            dArr2[i6][0] = this.c[i2];
            i6++;
        }
        this.a = bg.a(i, dArr, dArr2);
    }

    /* compiled from: SplineSet.java */
    /* renamed from: bo$a */
    /* loaded from: classes.dex */
    private static class a {
        static void a(int[] iArr, float[] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int b = b(iArr, fArr, i5, i6);
                    int i7 = i3 + 1;
                    iArr2[i3] = b - 1;
                    int i8 = i7 + 1;
                    iArr2[i7] = i5;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    i3 = i9 + 1;
                    iArr2[i9] = b + 1;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    c(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            c(iArr, fArr, i4, i2);
            return i4;
        }

        private static void c(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }
}
