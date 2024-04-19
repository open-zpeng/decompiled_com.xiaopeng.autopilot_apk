package defpackage;

import java.util.Arrays;
/* compiled from: ArcCurveFit.java */
/* renamed from: bf  reason: default package */
/* loaded from: classes.dex */
public class bf extends bg {
    a[] a;
    private final double[] b;
    private boolean c = true;

    @Override // defpackage.bg
    public void a(double d, double[] dArr) {
        if (this.c) {
            if (d < this.a[0].c) {
                double d2 = this.a[0].c;
                double d3 = d - this.a[0].c;
                if (this.a[0].r) {
                    dArr[0] = this.a[0].b(d2) + (this.a[0].d(d2) * d3);
                    dArr[1] = this.a[0].c(d2) + (d3 * this.a[0].e(d2));
                    return;
                }
                this.a[0].a(d2);
                dArr[0] = this.a[0].a() + (this.a[0].c() * d3);
                dArr[1] = this.a[0].b() + (d3 * this.a[0].d());
                return;
            }
            a[] aVarArr = this.a;
            if (d > aVarArr[aVarArr.length - 1].d) {
                a[] aVarArr2 = this.a;
                double d4 = aVarArr2[aVarArr2.length - 1].d;
                double d5 = d - d4;
                a[] aVarArr3 = this.a;
                int length = aVarArr3.length - 1;
                if (aVarArr3[length].r) {
                    dArr[0] = this.a[length].b(d4) + (this.a[length].d(d4) * d5);
                    dArr[1] = this.a[length].c(d4) + (d5 * this.a[length].e(d4));
                    return;
                }
                this.a[length].a(d);
                dArr[0] = this.a[length].a() + (this.a[length].c() * d5);
                dArr[1] = this.a[length].b() + (d5 * this.a[length].d());
                return;
            }
        } else {
            if (d < this.a[0].c) {
                d = this.a[0].c;
            }
            a[] aVarArr4 = this.a;
            if (d > aVarArr4[aVarArr4.length - 1].d) {
                a[] aVarArr5 = this.a;
                d = aVarArr5[aVarArr5.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr6 = this.a;
            if (i >= aVarArr6.length) {
                return;
            }
            if (d <= aVarArr6[i].d) {
                if (this.a[i].r) {
                    dArr[0] = this.a[i].b(d);
                    dArr[1] = this.a[i].c(d);
                    return;
                }
                this.a[i].a(d);
                dArr[0] = this.a[i].a();
                dArr[1] = this.a[i].b();
                return;
            }
            i++;
        }
    }

    @Override // defpackage.bg
    public void a(double d, float[] fArr) {
        if (this.c) {
            if (d < this.a[0].c) {
                double d2 = this.a[0].c;
                double d3 = d - this.a[0].c;
                if (this.a[0].r) {
                    fArr[0] = (float) (this.a[0].b(d2) + (this.a[0].d(d2) * d3));
                    fArr[1] = (float) (this.a[0].c(d2) + (d3 * this.a[0].e(d2)));
                    return;
                }
                this.a[0].a(d2);
                fArr[0] = (float) (this.a[0].a() + (this.a[0].c() * d3));
                fArr[1] = (float) (this.a[0].b() + (d3 * this.a[0].d()));
                return;
            }
            a[] aVarArr = this.a;
            if (d > aVarArr[aVarArr.length - 1].d) {
                a[] aVarArr2 = this.a;
                double d4 = aVarArr2[aVarArr2.length - 1].d;
                double d5 = d - d4;
                a[] aVarArr3 = this.a;
                int length = aVarArr3.length - 1;
                if (aVarArr3[length].r) {
                    fArr[0] = (float) (this.a[length].b(d4) + (this.a[length].d(d4) * d5));
                    fArr[1] = (float) (this.a[length].c(d4) + (d5 * this.a[length].e(d4)));
                    return;
                }
                this.a[length].a(d);
                fArr[0] = (float) this.a[length].a();
                fArr[1] = (float) this.a[length].b();
                return;
            }
        } else if (d < this.a[0].c) {
            d = this.a[0].c;
        } else {
            a[] aVarArr4 = this.a;
            if (d > aVarArr4[aVarArr4.length - 1].d) {
                a[] aVarArr5 = this.a;
                d = aVarArr5[aVarArr5.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr6 = this.a;
            if (i >= aVarArr6.length) {
                return;
            }
            if (d <= aVarArr6[i].d) {
                if (this.a[i].r) {
                    fArr[0] = (float) this.a[i].b(d);
                    fArr[1] = (float) this.a[i].c(d);
                    return;
                }
                this.a[i].a(d);
                fArr[0] = (float) this.a[i].a();
                fArr[1] = (float) this.a[i].b();
                return;
            }
            i++;
        }
    }

    @Override // defpackage.bg
    public void b(double d, double[] dArr) {
        if (d < this.a[0].c) {
            d = this.a[0].c;
        } else {
            a[] aVarArr = this.a;
            if (d > aVarArr[aVarArr.length - 1].d) {
                a[] aVarArr2 = this.a;
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr3 = this.a;
            if (i >= aVarArr3.length) {
                return;
            }
            if (d <= aVarArr3[i].d) {
                if (this.a[i].r) {
                    dArr[0] = this.a[i].d(d);
                    dArr[1] = this.a[i].e(d);
                    return;
                }
                this.a[i].a(d);
                dArr[0] = this.a[i].c();
                dArr[1] = this.a[i].d();
                return;
            }
            i++;
        }
    }

    @Override // defpackage.bg
    public double a(double d, int i) {
        a[] aVarArr;
        a[] aVarArr2;
        a[] aVarArr3;
        a[] aVarArr4;
        int i2 = 0;
        if (this.c) {
            if (d < this.a[0].c) {
                double d2 = this.a[0].c;
                double d3 = d - this.a[0].c;
                if (this.a[0].r) {
                    if (i == 0) {
                        return this.a[0].b(d2) + (d3 * this.a[0].d(d2));
                    }
                    return this.a[0].c(d2) + (d3 * this.a[0].e(d2));
                }
                this.a[0].a(d2);
                if (i == 0) {
                    return this.a[0].a() + (d3 * this.a[0].c());
                }
                return this.a[0].b() + (d3 * this.a[0].d());
            }
            if (d > this.a[aVarArr3.length - 1].d) {
                double d4 = this.a[aVarArr4.length - 1].d;
                double d5 = d - d4;
                a[] aVarArr5 = this.a;
                int length = aVarArr5.length - 1;
                if (i == 0) {
                    return aVarArr5[length].b(d4) + (d5 * this.a[length].d(d4));
                }
                return aVarArr5[length].c(d4) + (d5 * this.a[length].e(d4));
            }
        } else if (d < this.a[0].c) {
            d = this.a[0].c;
        } else {
            if (d > this.a[aVarArr.length - 1].d) {
                d = this.a[aVarArr2.length - 1].d;
            }
        }
        while (true) {
            a[] aVarArr6 = this.a;
            if (i2 >= aVarArr6.length) {
                return Double.NaN;
            }
            if (d <= aVarArr6[i2].d) {
                if (this.a[i2].r) {
                    if (i == 0) {
                        return this.a[i2].b(d);
                    }
                    return this.a[i2].c(d);
                }
                this.a[i2].a(d);
                if (i == 0) {
                    return this.a[i2].a();
                }
                return this.a[i2].b();
            }
            i2++;
        }
    }

    @Override // defpackage.bg
    public double[] a() {
        return this.b;
    }

    public bf(int[] iArr, double[] dArr, double[][] dArr2) {
        this.b = dArr;
        this.a = new a[dArr.length - 1];
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (i3 < this.a.length) {
            switch (iArr[i3]) {
                case 0:
                    i2 = 3;
                    break;
                case 1:
                    i = 1;
                    i2 = 1;
                    break;
                case 2:
                    i = 2;
                    i2 = 2;
                    break;
                case 3:
                    i = i != 1 ? 1 : 2;
                    i2 = i;
                    break;
            }
            int i4 = i3 + 1;
            this.a[i3] = new a(i2, dArr[i3], dArr[i4], dArr2[i3][0], dArr2[i3][1], dArr2[i4][0], dArr2[i4][1]);
            i3 = i4;
        }
    }

    /* compiled from: ArcCurveFit.java */
    /* renamed from: bf$a */
    /* loaded from: classes.dex */
    private static class a {
        private static double[] s = new double[91];
        double[] a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r;

        a(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            this.r = false;
            this.q = i == 1;
            this.c = d;
            this.d = d2;
            this.i = 1.0d / (this.d - this.c);
            if (3 == i) {
                this.r = true;
            }
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (this.r || Math.abs(d7) < 0.001d || Math.abs(d8) < 0.001d) {
                this.r = true;
                this.e = d3;
                this.f = d5;
                this.g = d4;
                this.h = d6;
                this.b = Math.hypot(d8, d7);
                this.n = this.b * this.i;
                double d9 = this.d;
                double d10 = this.c;
                this.l = d7 / (d9 - d10);
                this.m = d8 / (d9 - d10);
                return;
            }
            this.a = new double[101];
            this.j = d7 * (this.q ? -1 : 1);
            this.k = d8 * (this.q ? 1 : -1);
            this.l = this.q ? d5 : d3;
            this.m = this.q ? d4 : d6;
            a(d3, d4, d5, d6);
            this.n = this.b * this.i;
        }

        void a(double d) {
            double f = f((this.q ? this.d - d : d - this.c) * this.i) * 1.5707963267948966d;
            this.o = Math.sin(f);
            this.p = Math.cos(f);
        }

        double a() {
            return this.l + (this.j * this.o);
        }

        double b() {
            return this.m + (this.k * this.p);
        }

        double c() {
            double d = this.j * this.p;
            double hypot = this.n / Math.hypot(d, (-this.k) * this.o);
            if (this.q) {
                d = -d;
            }
            return d * hypot;
        }

        double d() {
            double d = this.j * this.p;
            double d2 = (-this.k) * this.o;
            double hypot = this.n / Math.hypot(d, d2);
            return this.q ? (-d2) * hypot : d2 * hypot;
        }

        public double b(double d) {
            double d2 = (d - this.c) * this.i;
            double d3 = this.e;
            return d3 + (d2 * (this.f - d3));
        }

        public double c(double d) {
            double d2 = (d - this.c) * this.i;
            double d3 = this.g;
            return d3 + (d2 * (this.h - d3));
        }

        public double d(double d) {
            return this.l;
        }

        public double e(double d) {
            return this.m;
        }

        double f(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.a;
            double length = d * (dArr.length - 1);
            int i = (int) length;
            return dArr[i] + ((length - i) * (dArr[i + 1] - dArr[i]));
        }

        private void a(double d, double d2, double d3, double d4) {
            double[] dArr;
            double[] dArr2;
            double d5;
            double d6 = d3 - d;
            double d7 = d2 - d4;
            int i = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            while (true) {
                if (i >= s.length) {
                    break;
                }
                double d11 = d8;
                double radians = Math.toRadians((i * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians) * d6;
                double cos = Math.cos(radians) * d7;
                if (i > 0) {
                    d5 = d11 + Math.hypot(sin - d9, cos - d10);
                    s[i] = d5;
                } else {
                    d5 = d11;
                }
                i++;
                d10 = cos;
                d8 = d5;
                d9 = sin;
            }
            double d12 = d8;
            this.b = d12;
            int i2 = 0;
            while (true) {
                double[] dArr3 = s;
                if (i2 >= dArr3.length) {
                    break;
                }
                dArr3[i2] = dArr3[i2] / d12;
                i2++;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.a.length) {
                    return;
                }
                double length = i3 / (dArr2.length - 1);
                int binarySearch = Arrays.binarySearch(s, length);
                if (binarySearch >= 0) {
                    this.a[i3] = binarySearch / (s.length - 1);
                } else if (binarySearch == -1) {
                    this.a[i3] = 0.0d;
                } else {
                    int i4 = -binarySearch;
                    int i5 = i4 - 2;
                    double[] dArr4 = s;
                    this.a[i3] = (i5 + ((length - dArr4[i5]) / (dArr4[i4 - 1] - dArr4[i5]))) / (dArr4.length - 1);
                }
                i3++;
            }
        }
    }
}
