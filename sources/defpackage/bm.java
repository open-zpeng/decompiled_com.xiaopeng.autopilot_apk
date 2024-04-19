package defpackage;

import java.util.Arrays;
/* compiled from: Oscillator.java */
/* renamed from: bm  reason: default package */
/* loaded from: classes.dex */
public class bm {
    public static String a = "Oscillator";
    double[] d;
    String e;
    bl f;
    int g;
    float[] b = new float[0];
    double[] c = new double[0];
    double h = 6.283185307179586d;
    private boolean i = false;

    public String toString() {
        return "pos =" + Arrays.toString(this.c) + " period=" + Arrays.toString(this.b);
    }

    public void a(int i, String str) {
        this.g = i;
        this.e = str;
        if (this.e != null) {
            this.f = bl.a(str);
        }
    }

    public void a(double d, float f) {
        int length = this.b.length + 1;
        int binarySearch = Arrays.binarySearch(this.c, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.c = Arrays.copyOf(this.c, length);
        this.b = Arrays.copyOf(this.b, length);
        this.d = new double[length];
        double[] dArr = this.c;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.c[binarySearch] = d;
        this.b[binarySearch] = f;
        this.i = false;
    }

    public void a() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i;
        int i2 = 0;
        double d = 0.0d;
        while (true) {
            if (i2 >= this.b.length) {
                break;
            }
            d += fArr[i2];
            i2++;
        }
        double d2 = 0.0d;
        int i3 = 1;
        while (true) {
            if (i3 >= this.b.length) {
                break;
            }
            double[] dArr = this.c;
            d2 += (dArr[i3] - dArr[i3 - 1]) * ((fArr2[i] + fArr2[i3]) / 2.0f);
            i3++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr4 = this.b;
            if (i4 >= fArr4.length) {
                break;
            }
            fArr4[i4] = (float) (fArr4[i4] * (d / d2));
            i4++;
        }
        this.d[0] = 0.0d;
        int i5 = 1;
        while (true) {
            if (i5 < this.b.length) {
                int i6 = i5 - 1;
                double[] dArr2 = this.c;
                double d3 = dArr2[i5] - dArr2[i6];
                double[] dArr3 = this.d;
                dArr3[i5] = dArr3[i6] + (d3 * ((fArr3[i6] + fArr3[i5]) / 2.0f));
                i5++;
            } else {
                this.i = true;
                return;
            }
        }
    }

    double a(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.c, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.b;
            int i2 = i - 1;
            double d2 = fArr[i] - fArr[i2];
            double[] dArr = this.c;
            double d3 = d2 / (dArr[i] - dArr[i2]);
            return this.d[i2] + ((fArr[i2] - (dArr[i2] * d3)) * (d - dArr[i2])) + ((d3 * ((d * d) - (dArr[i2] * dArr[i2]))) / 2.0d);
        }
        return 0.0d;
    }

    public double a(double d, double d2) {
        double a2 = a(d) + d2;
        switch (this.g) {
            case 1:
                return Math.signum(0.5d - (a2 % 1.0d));
            case 2:
                return 1.0d - Math.abs((((a2 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((a2 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((a2 * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos(this.h * (d2 + a2));
            case 6:
                double abs = 1.0d - Math.abs(((a2 * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (abs * abs);
            case 7:
                return this.f.a(a2 % 1.0d, 0);
            default:
                return Math.sin(this.h * a2);
        }
    }
}
