package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.t;
import java.io.Serializable;
/* compiled from: Vector3.java */
/* loaded from: classes.dex */
public class p implements Serializable {
    public static final p d = new p(1.0f, 0.0f, 0.0f);
    public static final p e = new p(0.0f, 1.0f, 0.0f);
    public static final p f = new p(0.0f, 0.0f, 1.0f);
    public static final p g = new p(0.0f, 0.0f, 0.0f);
    private static final Matrix4 h = new Matrix4();
    private static final long serialVersionUID = 3840054589595372522L;
    public float a;
    public float b;
    public float c;

    public p() {
    }

    public p(float f2, float f3, float f4) {
        a(f2, f3, f4);
    }

    public p(p pVar) {
        a(pVar);
    }

    public p a(float f2, float f3, float f4) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        return this;
    }

    public p a(p pVar) {
        return a(pVar.a, pVar.b, pVar.c);
    }

    public p a() {
        return new p(this);
    }

    public p b(p pVar) {
        return b(pVar.a, pVar.b, pVar.c);
    }

    public p b(float f2, float f3, float f4) {
        return a(this.a + f2, this.b + f3, this.c + f4);
    }

    public p c(p pVar) {
        return c(pVar.a, pVar.b, pVar.c);
    }

    public p c(float f2, float f3, float f4) {
        return a(this.a - f2, this.b - f3, this.c - f4);
    }

    public p a(float f2) {
        return a(this.a * f2, this.b * f2, this.c * f2);
    }

    public static float d(float f2, float f3, float f4) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
    }

    public float b() {
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (f2 * f2) + (f3 * f3);
        float f5 = this.c;
        return (float) Math.sqrt(f4 + (f5 * f5));
    }

    public float c() {
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (f2 * f2) + (f3 * f3);
        float f5 = this.c;
        return f4 + (f5 * f5);
    }

    public float d(p pVar) {
        float f2 = pVar.a - this.a;
        float f3 = pVar.b - this.b;
        float f4 = pVar.c - this.c;
        return (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
    }

    public float e(p pVar) {
        float f2 = pVar.a - this.a;
        float f3 = pVar.b - this.b;
        float f4 = pVar.c - this.c;
        return (f2 * f2) + (f3 * f3) + (f4 * f4);
    }

    public p d() {
        float c = c();
        return (c == 0.0f || c == 1.0f) ? this : a(1.0f / ((float) Math.sqrt(c)));
    }

    public float f(p pVar) {
        return (this.a * pVar.a) + (this.b * pVar.b) + (this.c * pVar.c);
    }

    public p g(p pVar) {
        float f2 = this.b;
        float f3 = pVar.c;
        float f4 = this.c;
        float f5 = pVar.b;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = pVar.a;
        float f8 = this.a;
        return a(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7));
    }

    public p e(float f2, float f3, float f4) {
        float f5 = this.b;
        float f6 = this.c;
        float f7 = (f5 * f4) - (f6 * f3);
        float f8 = this.a;
        return a(f7, (f6 * f2) - (f4 * f8), (f8 * f3) - (f5 * f2));
    }

    public p a(Matrix4 matrix4) {
        float[] fArr = matrix4.a;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (fArr[0] * f2) + (fArr[4] * f3);
        float f5 = this.c;
        return a(f4 + (fArr[8] * f5) + fArr[12], (fArr[1] * f2) + (fArr[5] * f3) + (fArr[9] * f5) + fArr[13], (f2 * fArr[2]) + (f3 * fArr[6]) + (f5 * fArr[10]) + fArr[14]);
    }

    public p a(i iVar) {
        float[] fArr = iVar.a;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (fArr[0] * f2) + (fArr[3] * f3);
        float f5 = this.c;
        return a(f4 + (fArr[6] * f5), (fArr[1] * f2) + (fArr[4] * f3) + (fArr[7] * f5), (f2 * fArr[2]) + (f3 * fArr[5]) + (f5 * fArr[8]));
    }

    public p b(Matrix4 matrix4) {
        float[] fArr = matrix4.a;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (fArr[3] * f2) + (fArr[7] * f3);
        float f5 = this.c;
        float f6 = 1.0f / ((f4 + (fArr[11] * f5)) + fArr[15]);
        return a(((fArr[0] * f2) + (fArr[4] * f3) + (fArr[8] * f5) + fArr[12]) * f6, ((fArr[1] * f2) + (fArr[5] * f3) + (fArr[9] * f5) + fArr[13]) * f6, ((f2 * fArr[2]) + (f3 * fArr[6]) + (f5 * fArr[10]) + fArr[14]) * f6);
    }

    public p a(p pVar, float f2) {
        h.a(pVar, f2);
        return a(h);
    }

    public boolean e() {
        return this.a == 0.0f && this.b == 0.0f && this.c == 0.0f;
    }

    public p b(p pVar, float f2) {
        float f3 = this.a;
        this.a = f3 + ((pVar.a - f3) * f2);
        float f4 = this.b;
        this.b = f4 + ((pVar.b - f4) * f2);
        float f5 = this.c;
        this.c = f5 + (f2 * (pVar.c - f5));
        return this;
    }

    public String toString() {
        return "(" + this.a + "," + this.b + "," + this.c + ")";
    }

    public int hashCode() {
        return ((((t.a(this.a) + 31) * 31) + t.a(this.b)) * 31) + t.a(this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            p pVar = (p) obj;
            return t.a(this.a) == t.a(pVar.a) && t.a(this.b) == t.a(pVar.b) && t.a(this.c) == t.a(pVar.c);
        }
        return false;
    }

    public boolean c(p pVar, float f2) {
        return pVar != null && Math.abs(pVar.a - this.a) <= f2 && Math.abs(pVar.b - this.b) <= f2 && Math.abs(pVar.c - this.c) <= f2;
    }

    public p f() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        return this;
    }
}
