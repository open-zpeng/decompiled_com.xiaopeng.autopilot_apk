package defpackage;
/* compiled from: SpringStopEngine.java */
/* renamed from: bp  reason: default package */
/* loaded from: classes.dex */
public class bp implements br {
    private double c;
    private double d;
    private double e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    double a = 0.5d;
    private boolean b = false;
    private int k = 0;

    @Override // defpackage.br
    public float a() {
        return 0.0f;
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.d = f2;
        this.a = f6;
        this.b = false;
        this.g = f;
        this.e = f3;
        this.c = f5;
        this.i = f4;
        this.j = f7;
        this.k = i;
        this.f = 0.0f;
    }

    @Override // defpackage.br
    public float a(float f) {
        a(f - this.f);
        this.f = f;
        return this.g;
    }

    @Override // defpackage.br
    public boolean b() {
        double d = this.g - this.d;
        double d2 = this.c;
        double d3 = this.h;
        return Math.sqrt((((d3 * d3) * ((double) this.i)) + ((d2 * d) * d)) / d2) <= ((double) this.j);
    }

    private void a(double d) {
        double d2 = this.c;
        double d3 = this.a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d2 / this.i) * d) * 4.0d)) + 1.0d);
        double d4 = d / sqrt;
        int i = 0;
        while (i < sqrt) {
            float f = this.g;
            double d5 = this.d;
            float f2 = this.h;
            double d6 = d2;
            float f3 = this.i;
            double d7 = d3;
            double d8 = f2 + ((((((-d2) * (f - d5)) - (f2 * d3)) / f3) * d4) / 2.0d);
            double d9 = ((((-((f + ((d4 * d8) / 2.0d)) - d5)) * d6) - (d8 * d7)) / f3) * d4;
            this.h = (float) (f2 + d9);
            this.g = (float) (f + ((f2 + (d9 / 2.0d)) * d4));
            int i2 = this.k;
            if (i2 > 0) {
                float f4 = this.g;
                if (f4 < 0.0f && (i2 & 1) == 1) {
                    this.g = -f4;
                    this.h = -this.h;
                }
                float f5 = this.g;
                if (f5 > 1.0f && (this.k & 2) == 2) {
                    this.g = 2.0f - f5;
                    this.h = -this.h;
                }
            }
            i++;
            d2 = d6;
            d3 = d7;
        }
    }
}
