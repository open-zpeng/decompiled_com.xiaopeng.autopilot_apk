package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
/* compiled from: TimeCycleSplineSet.java */
/* renamed from: bt  reason: default package */
/* loaded from: classes.dex */
public abstract class bt {
    protected static float h = 6.2831855f;
    protected bg a;
    protected int e;
    protected String f;
    protected long j;
    protected int b = 0;
    protected int[] c = new int[10];
    protected float[][] d = (float[][]) Array.newInstance(float.class, 10, 3);
    protected float[] g = new float[3];
    protected boolean i = false;
    protected float k = Float.NaN;

    public String toString() {
        String str = this.f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.e; i++) {
            str = str + "[" + this.c[i] + " , " + decimalFormat.format(this.d[i]) + "] ";
        }
        return str;
    }

    public void a(String str) {
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(float f) {
        switch (this.b) {
            case 1:
                return Math.signum(f * h);
            case 2:
                return 1.0f - Math.abs(f);
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(f * h);
            case 6:
                float abs = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (abs * abs);
            default:
                return (float) Math.sin(f * h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j) {
        this.j = j;
    }

    public void a(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.c;
        int i3 = this.e;
        iArr[i3] = i;
        float[][] fArr = this.d;
        fArr[i3][0] = f;
        fArr[i3][1] = f2;
        fArr[i3][2] = f3;
        this.b = Math.max(this.b, i2);
        this.e++;
    }

    public void a(int i) {
        int i2;
        int i3 = this.e;
        if (i3 == 0) {
            System.err.println("Error no points added to " + this.f);
            return;
        }
        a.a(this.c, this.d, 0, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.c;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i5, 3);
        int i6 = 0;
        for (i2 = 0; i2 < this.e; i2 = i2 + 1) {
            if (i2 > 0) {
                int[] iArr2 = this.c;
                i2 = iArr2[i2] == iArr2[i2 - 1] ? i2 + 1 : 0;
            }
            dArr[i6] = this.c[i2] * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[][] fArr = this.d;
            dArr3[0] = fArr[i2][0];
            dArr2[i6][1] = fArr[i2][1];
            dArr2[i6][2] = fArr[i2][2];
            i6++;
        }
        this.a = bg.a(i, dArr, dArr2);
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* renamed from: bt$a */
    /* loaded from: classes.dex */
    protected static class a {
        static void a(int[] iArr, float[][] fArr, int i, int i2) {
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

        private static int b(int[] iArr, float[][] fArr, int i, int i2) {
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

        private static void c(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = fArr2;
        }
    }
}
