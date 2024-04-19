package com.badlogic.gdx.math;
/* compiled from: Polygon.java */
/* loaded from: classes.dex */
public class k {
    private float[] a;
    private float[] b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private boolean j;
    private n k;

    public k() {
        this.h = 1.0f;
        this.i = 1.0f;
        this.j = true;
        this.a = new float[0];
    }

    public k(float[] fArr) {
        this.h = 1.0f;
        this.i = 1.0f;
        this.j = true;
        if (fArr.length < 6) {
            throw new IllegalArgumentException("polygons must contain at least 3 points.");
        }
        this.a = fArr;
    }

    public float[] a() {
        return this.a;
    }

    public float[] b() {
        if (this.j) {
            this.j = false;
            float[] fArr = this.a;
            float[] fArr2 = this.b;
            if (fArr2 == null || fArr2.length != fArr.length) {
                this.b = new float[fArr.length];
            }
            float[] fArr3 = this.b;
            float f = this.c;
            float f2 = this.d;
            float f3 = this.e;
            float f4 = this.f;
            float f5 = this.h;
            float f6 = this.i;
            boolean z = (f5 == 1.0f && f6 == 1.0f) ? false : true;
            float f7 = this.g;
            float d = h.d(f7);
            float c = h.c(f7);
            int length = fArr.length;
            for (int i = 0; i < length; i += 2) {
                float f8 = fArr[i] - f3;
                int i2 = i + 1;
                float f9 = fArr[i2] - f4;
                if (z) {
                    f8 *= f5;
                    f9 *= f6;
                }
                if (f7 != 0.0f) {
                    f9 = (f8 * c) + (f9 * d);
                    f8 = (d * f8) - (c * f9);
                }
                fArr3[i] = f8 + f + f3;
                fArr3[i2] = f2 + f9 + f4;
            }
            return fArr3;
        }
        return this.b;
    }

    public void a(float[] fArr) {
        if (fArr.length < 6) {
            throw new IllegalArgumentException("polygons must contain at least 3 points.");
        }
        this.a = fArr;
        this.j = true;
    }

    public n c() {
        float[] b = b();
        float f = b[0];
        float f2 = b[1];
        float f3 = b[0];
        float f4 = b[1];
        int length = b.length;
        for (int i = 2; i < length; i += 2) {
            if (f > b[i]) {
                f = b[i];
            }
            int i2 = i + 1;
            if (f2 > b[i2]) {
                f2 = b[i2];
            }
            if (f3 < b[i]) {
                f3 = b[i];
            }
            if (f4 < b[i2]) {
                f4 = b[i2];
            }
        }
        if (this.k == null) {
            this.k = new n();
        }
        n nVar = this.k;
        nVar.x = f;
        nVar.y = f2;
        nVar.width = f3 - f;
        nVar.height = f4 - f2;
        return nVar;
    }
}
