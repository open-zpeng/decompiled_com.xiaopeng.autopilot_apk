package defpackage;
/* compiled from: LinearCurveFit.java */
/* renamed from: bk  reason: default package */
/* loaded from: classes.dex */
public class bk extends bg {
    double[] a;
    private double[] b;
    private double[][] c;
    private double d;
    private boolean e = true;

    public bk(double[] dArr, double[][] dArr2) {
        this.d = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.a = new double[length2];
        this.b = dArr;
        this.c = dArr2;
        if (length2 > 2) {
            int i = 0;
            double d = 0.0d;
            double d2 = 0.0d;
            while (i < dArr.length) {
                double d3 = dArr2[i][0];
                double d4 = dArr2[i][0];
                if (i > 0) {
                    Math.hypot(d3 - d, d4 - d2);
                }
                i++;
                d = d3;
                d2 = d4;
            }
            this.d = 0.0d;
        }
    }

    @Override // defpackage.bg
    public void a(double d, double[] dArr) {
        double[] dArr2 = this.b;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.c[0].length;
        if (this.e) {
            if (d <= dArr2[0]) {
                b(dArr2[0], this.a);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.c[0][i2] + ((d - this.b[0]) * this.a[i2]);
                }
                return;
            }
            int i3 = length - 1;
            if (d >= dArr2[i3]) {
                b(dArr2[i3], this.a);
                while (i < length2) {
                    dArr[i] = this.c[i3][i] + ((d - this.b[i3]) * this.a[i]);
                    i++;
                }
                return;
            }
        } else if (d <= dArr2[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                dArr[i4] = this.c[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = this.c[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.b[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.c[i6][i7];
                }
            }
            double[] dArr3 = this.b;
            int i8 = i6 + 1;
            if (d < dArr3[i8]) {
                double d2 = (d - dArr3[i6]) / (dArr3[i8] - dArr3[i6]);
                while (i < length2) {
                    double[][] dArr4 = this.c;
                    dArr[i] = (dArr4[i6][i] * (1.0d - d2)) + (dArr4[i8][i] * d2);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // defpackage.bg
    public void a(double d, float[] fArr) {
        double[] dArr = this.b;
        int length = dArr.length;
        int i = 0;
        int length2 = this.c[0].length;
        if (this.e) {
            if (d <= dArr[0]) {
                b(dArr[0], this.a);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.c[0][i2] + ((d - this.b[0]) * this.a[i2]));
                }
                return;
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                b(dArr[i3], this.a);
                while (i < length2) {
                    fArr[i] = (float) (this.c[i3][i] + ((d - this.b[i3]) * this.a[i]));
                    i++;
                }
                return;
            }
        } else if (d <= dArr[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                fArr[i4] = (float) this.c[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) this.c[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.b[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.c[i6][i7];
                }
            }
            double[] dArr2 = this.b;
            int i8 = i6 + 1;
            if (d < dArr2[i8]) {
                double d2 = (d - dArr2[i6]) / (dArr2[i8] - dArr2[i6]);
                while (i < length2) {
                    double[][] dArr3 = this.c;
                    fArr[i] = (float) ((dArr3[i6][i] * (1.0d - d2)) + (dArr3[i8][i] * d2));
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // defpackage.bg
    public double a(double d, int i) {
        double[] dArr = this.b;
        int length = dArr.length;
        int i2 = 0;
        if (this.e) {
            if (d <= dArr[0]) {
                return this.c[0][i] + ((d - dArr[0]) * b(dArr[0], i));
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                return this.c[i3][i] + ((d - dArr[i3]) * b(dArr[i3], i));
            }
        } else if (d <= dArr[0]) {
            return this.c[0][i];
        } else {
            int i4 = length - 1;
            if (d >= dArr[i4]) {
                return this.c[i4][i];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.b;
            if (d == dArr2[i2]) {
                return this.c[i2][i];
            }
            int i5 = i2 + 1;
            if (d < dArr2[i5]) {
                double d2 = (d - dArr2[i2]) / (dArr2[i5] - dArr2[i2]);
                double[][] dArr3 = this.c;
                return (dArr3[i2][i] * (1.0d - d2)) + (dArr3[i5][i] * d2);
            }
            i2 = i5;
        }
        return 0.0d;
    }

    @Override // defpackage.bg
    public void b(double d, double[] dArr) {
        double[] dArr2 = this.b;
        int length = dArr2.length;
        int length2 = this.c[0].length;
        if (d <= dArr2[0]) {
            d = dArr2[0];
        } else {
            int i = length - 1;
            if (d >= dArr2[i]) {
                d = dArr2[i];
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.b;
            int i3 = i2 + 1;
            if (d <= dArr3[i3]) {
                double d2 = dArr3[i3] - dArr3[i2];
                double d3 = dArr3[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.c;
                    dArr[i4] = (dArr4[i3][i4] - dArr4[i2][i4]) / d2;
                }
                return;
            }
            i2 = i3;
        }
    }

    public double b(double d, int i) {
        double[] dArr = this.b;
        int length = dArr.length;
        int i2 = 0;
        if (d < dArr[0]) {
            d = dArr[0];
        } else {
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                d = dArr[i3];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.b;
            int i4 = i2 + 1;
            if (d <= dArr2[i4]) {
                double d2 = dArr2[i2];
                double[][] dArr3 = this.c;
                return (dArr3[i4][i] - dArr3[i2][i]) / (dArr2[i4] - dArr2[i2]);
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // defpackage.bg
    public double[] a() {
        return this.b;
    }
}
