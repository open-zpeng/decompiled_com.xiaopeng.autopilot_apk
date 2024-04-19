package com.badlogic.gdx.math;
/* compiled from: WindowedMean.java */
/* loaded from: classes.dex */
public final class q {
    float[] a;
    int c;
    int b = 0;
    float d = 0.0f;
    boolean e = true;

    public q(int i) {
        this.a = new float[i];
    }

    public boolean a() {
        return this.b >= this.a.length;
    }

    public void b() {
        int i = 0;
        this.b = 0;
        this.c = 0;
        while (true) {
            float[] fArr = this.a;
            if (i < fArr.length) {
                fArr[i] = 0.0f;
                i++;
            } else {
                this.e = true;
                return;
            }
        }
    }

    public void a(float f) {
        int i = this.b;
        if (i < this.a.length) {
            this.b = i + 1;
        }
        float[] fArr = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        fArr[i2] = f;
        if (this.c > fArr.length - 1) {
            this.c = 0;
        }
        this.e = true;
    }

    public float c() {
        float[] fArr;
        if (a()) {
            if (this.e) {
                float f = 0.0f;
                int i = 0;
                while (true) {
                    fArr = this.a;
                    if (i >= fArr.length) {
                        break;
                    }
                    f += fArr[i];
                    i++;
                }
                this.d = f / fArr.length;
                this.e = false;
            }
            return this.d;
        }
        return 0.0f;
    }
}
