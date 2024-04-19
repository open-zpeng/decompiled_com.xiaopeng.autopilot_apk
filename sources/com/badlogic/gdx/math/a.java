package com.badlogic.gdx.math;

import java.io.Serializable;
/* compiled from: Affine2.java */
/* loaded from: classes.dex */
public final class a implements Serializable {
    private static final long serialVersionUID = 1524569123485049187L;
    public float a = 1.0f;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public float e = 1.0f;
    public float f = 0.0f;

    public a a(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        return this;
    }

    public a a(Matrix4 matrix4) {
        float[] fArr = matrix4.a;
        this.a = fArr[0];
        this.b = fArr[4];
        this.c = fArr[12];
        this.d = fArr[1];
        this.e = fArr[5];
        this.f = fArr[13];
        return this;
    }

    public a a(float f, float f2, float f3, float f4, float f5) {
        this.c = f;
        this.f = f2;
        if (f3 == 0.0f) {
            this.a = f4;
            this.b = 0.0f;
            this.d = 0.0f;
            this.e = f5;
        } else {
            float c = h.c(f3);
            float d = h.d(f3);
            this.a = d * f4;
            this.b = (-c) * f5;
            this.d = c * f4;
            this.e = d * f5;
        }
        return this;
    }

    public a a() {
        float b = b();
        if (b == 0.0f) {
            throw new com.badlogic.gdx.utils.k("Can't invert a singular affine matrix");
        }
        float f = 1.0f / b;
        float f2 = this.e;
        float f3 = this.b;
        float f4 = -f3;
        float f5 = this.f;
        float f6 = this.c;
        float f7 = this.d;
        float f8 = this.a;
        this.a = f2 * f;
        this.b = f4 * f;
        this.c = ((f3 * f5) - (f2 * f6)) * f;
        this.d = (-f7) * f;
        this.e = f8 * f;
        this.f = f * ((f7 * f6) - (f5 * f8));
        return this;
    }

    public a b(a aVar) {
        float f = this.a;
        float f2 = aVar.a;
        float f3 = this.b;
        float f4 = aVar.d;
        float f5 = (f * f2) + (f3 * f4);
        float f6 = aVar.b;
        float f7 = aVar.e;
        float f8 = (f * f6) + (f3 * f7);
        float f9 = aVar.c;
        float f10 = aVar.f;
        float f11 = (f * f9) + (f3 * f10) + this.c;
        float f12 = this.d;
        float f13 = this.e;
        this.a = f5;
        this.b = f8;
        this.c = f11;
        this.d = (f2 * f12) + (f4 * f13);
        this.e = (f6 * f12) + (f7 * f13);
        this.f = (f12 * f9) + (f13 * f10) + this.f;
        return this;
    }

    public a c(a aVar) {
        float f = aVar.a;
        float f2 = this.a;
        float f3 = aVar.b;
        float f4 = this.d;
        float f5 = (f * f2) + (f3 * f4);
        float f6 = this.b;
        float f7 = this.e;
        float f8 = (f * f6) + (f3 * f7);
        float f9 = this.c;
        float f10 = this.f;
        float f11 = (f * f9) + (f3 * f10) + aVar.c;
        float f12 = aVar.d;
        float f13 = aVar.e;
        this.a = f5;
        this.b = f8;
        this.c = f11;
        this.d = (f2 * f12) + (f4 * f13);
        this.e = (f6 * f12) + (f7 * f13);
        this.f = (f12 * f9) + (f13 * f10) + aVar.f;
        return this;
    }

    public a a(float f, float f2) {
        this.c += (this.a * f) + (this.b * f2);
        this.f += (this.d * f) + (this.e * f2);
        return this;
    }

    public float b() {
        return (this.a * this.e) - (this.b * this.d);
    }

    public String toString() {
        return "[" + this.a + "|" + this.b + "|" + this.c + "]\n[" + this.d + "|" + this.e + "|" + this.f + "]\n[0.0|0.0|0.1]";
    }
}
