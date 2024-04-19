package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.t;
import java.io.Serializable;
/* compiled from: Quaternion.java */
/* loaded from: classes.dex */
public class l implements Serializable {
    private static l e = new l(0.0f, 0.0f, 0.0f, 0.0f);
    private static l f = new l(0.0f, 0.0f, 0.0f, 0.0f);
    private static final long serialVersionUID = -7661875440774897168L;
    public float a;
    public float b;
    public float c;
    public float d;

    public l(float f2, float f3, float f4, float f5) {
        a(f2, f3, f4, f5);
    }

    public l() {
        d();
    }

    public l(l lVar) {
        a(lVar);
    }

    public l a(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        return this;
    }

    public l a(l lVar) {
        return a(lVar.a, lVar.b, lVar.c, lVar.d);
    }

    public l a(p pVar, float f2) {
        return b(pVar.a, pVar.b, pVar.c, f2);
    }

    public float a() {
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (f2 * f2) + (f3 * f3);
        float f5 = this.c;
        float f6 = f4 + (f5 * f5);
        float f7 = this.d;
        return (float) Math.sqrt(f6 + (f7 * f7));
    }

    public String toString() {
        return "[" + this.a + "|" + this.b + "|" + this.c + "|" + this.d + "]";
    }

    public l a(float f2, float f3, float f4) {
        return b(f2 * 0.017453292f, f3 * 0.017453292f, f4 * 0.017453292f);
    }

    public l b(float f2, float f3, float f4) {
        double d = f4 * 0.5f;
        float sin = (float) Math.sin(d);
        float cos = (float) Math.cos(d);
        double d2 = f3 * 0.5f;
        float sin2 = (float) Math.sin(d2);
        float cos2 = (float) Math.cos(d2);
        double d3 = f2 * 0.5f;
        float sin3 = (float) Math.sin(d3);
        float cos3 = (float) Math.cos(d3);
        float f5 = cos3 * sin2;
        float f6 = sin3 * cos2;
        float f7 = cos3 * cos2;
        float f8 = sin3 * sin2;
        this.a = (f5 * cos) + (f6 * sin);
        this.b = (f6 * cos) - (f5 * sin);
        this.c = (f7 * sin) - (f8 * cos);
        this.d = (f7 * cos) + (f8 * sin);
        return this;
    }

    public float b() {
        float f2 = this.a;
        float f3 = this.b;
        float f4 = (f2 * f2) + (f3 * f3);
        float f5 = this.c;
        float f6 = f4 + (f5 * f5);
        float f7 = this.d;
        return f6 + (f7 * f7);
    }

    public l c() {
        float b = b();
        if (b != 0.0f && !h.a(b, 1.0f)) {
            float sqrt = (float) Math.sqrt(b);
            this.d /= sqrt;
            this.a /= sqrt;
            this.b /= sqrt;
            this.c /= sqrt;
        }
        return this;
    }

    public void a(float[] fArr) {
        float f2 = this.a;
        float f3 = f2 * f2;
        float f4 = this.b;
        float f5 = f2 * f4;
        float f6 = this.c;
        float f7 = f2 * f6;
        float f8 = this.d;
        float f9 = f2 * f8;
        float f10 = f4 * f4;
        float f11 = f4 * f6;
        float f12 = f4 * f8;
        float f13 = f6 * f6;
        float f14 = f6 * f8;
        fArr[0] = 1.0f - ((f10 + f13) * 2.0f);
        fArr[4] = (f5 - f14) * 2.0f;
        fArr[8] = (f7 + f12) * 2.0f;
        fArr[12] = 0.0f;
        fArr[1] = (f5 + f14) * 2.0f;
        fArr[5] = 1.0f - ((f13 + f3) * 2.0f);
        fArr[9] = (f11 - f9) * 2.0f;
        fArr[13] = 0.0f;
        fArr[2] = (f7 - f12) * 2.0f;
        fArr[6] = (f11 + f9) * 2.0f;
        fArr[10] = 1.0f - ((f3 + f10) * 2.0f);
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
    }

    public l d() {
        return a(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public l b(p pVar, float f2) {
        return c(pVar.a, pVar.b, pVar.c, f2);
    }

    public l b(float f2, float f3, float f4, float f5) {
        return c(f2, f3, f4, f5 * 0.017453292f);
    }

    public l c(float f2, float f3, float f4, float f5) {
        float d = p.d(f2, f3, f4);
        if (d == 0.0f) {
            return d();
        }
        float f6 = 1.0f / d;
        double d2 = (f5 < 0.0f ? 6.2831855f - ((-f5) % 6.2831855f) : f5 % 6.2831855f) / 2.0f;
        float sin = (float) Math.sin(d2);
        return a(f2 * f6 * sin, f3 * f6 * sin, f6 * f4 * sin, (float) Math.cos(d2)).c();
    }

    public l a(boolean z, Matrix4 matrix4) {
        return a(z, matrix4.a[0], matrix4.a[4], matrix4.a[8], matrix4.a[1], matrix4.a[5], matrix4.a[9], matrix4.a[2], matrix4.a[6], matrix4.a[10]);
    }

    public l a(Matrix4 matrix4) {
        return a(false, matrix4);
    }

    public l a(boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (z) {
            float d = 1.0f / p.d(f2, f3, f4);
            float d2 = 1.0f / p.d(f5, f6, f7);
            float d3 = 1.0f / p.d(f8, f9, f10);
            f2 *= d;
            f3 *= d;
            f4 *= d;
            f5 *= d2;
            f6 *= d2;
            f7 *= d2;
            f8 *= d3;
            f9 *= d3;
            f10 *= d3;
        }
        float f11 = f2 + f6 + f10;
        if (f11 >= 0.0f) {
            float sqrt = (float) Math.sqrt(f11 + 1.0f);
            this.d = sqrt * 0.5f;
            float f12 = 0.5f / sqrt;
            this.a = (f9 - f7) * f12;
            this.b = (f4 - f8) * f12;
            this.c = (f5 - f3) * f12;
        } else if (f2 > f6 && f2 > f10) {
            float sqrt2 = (float) Math.sqrt(((f2 + 1.0d) - f6) - f10);
            this.a = sqrt2 * 0.5f;
            float f13 = 0.5f / sqrt2;
            this.b = (f5 + f3) * f13;
            this.c = (f4 + f8) * f13;
            this.d = (f9 - f7) * f13;
        } else if (f6 > f10) {
            float sqrt3 = (float) Math.sqrt(((f6 + 1.0d) - f2) - f10);
            this.b = sqrt3 * 0.5f;
            float f14 = 0.5f / sqrt3;
            this.a = (f5 + f3) * f14;
            this.c = (f9 + f7) * f14;
            this.d = (f4 - f8) * f14;
        } else {
            float sqrt4 = (float) Math.sqrt(((f10 + 1.0d) - f2) - f6);
            this.c = sqrt4 * 0.5f;
            float f15 = 0.5f / sqrt4;
            this.a = (f4 + f8) * f15;
            this.b = (f9 + f7) * f15;
            this.d = (f5 - f3) * f15;
        }
        return this;
    }

    public l a(p pVar, p pVar2) {
        return c((pVar.b * pVar2.c) - (pVar.c * pVar2.b), (pVar.c * pVar2.a) - (pVar.a * pVar2.c), (pVar.a * pVar2.b) - (pVar.b * pVar2.a), (float) Math.acos(h.a(pVar.f(pVar2), -1.0f, 1.0f)));
    }

    public l a(l lVar, float f2) {
        float f3 = (this.a * lVar.a) + (this.b * lVar.b) + (this.c * lVar.c) + (this.d * lVar.d);
        int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i < 0) {
            f3 = -f3;
        }
        float f4 = 1.0f - f2;
        if (1.0f - f3 > 0.1d) {
            float acos = (float) Math.acos(f3);
            float sin = 1.0f / ((float) Math.sin(acos));
            f4 = ((float) Math.sin(f4 * acos)) * sin;
            f2 = ((float) Math.sin(f2 * acos)) * sin;
        }
        if (i < 0) {
            f2 = -f2;
        }
        this.a = (this.a * f4) + (lVar.a * f2);
        this.b = (this.b * f4) + (lVar.b * f2);
        this.c = (this.c * f4) + (lVar.c * f2);
        this.d = (f4 * this.d) + (f2 * lVar.d);
        return this;
    }

    public int hashCode() {
        return ((((((t.b(this.d) + 31) * 31) + t.b(this.a)) * 31) + t.b(this.b)) * 31) + t.b(this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof l)) {
            l lVar = (l) obj;
            return t.b(this.d) == t.b(lVar.d) && t.b(this.a) == t.b(lVar.a) && t.b(this.b) == t.b(lVar.b) && t.b(this.c) == t.b(lVar.c);
        }
        return false;
    }

    public float e() {
        float f2 = this.d;
        if (f2 > 1.0f) {
            f2 /= a();
        }
        return (float) (Math.acos(f2) * 2.0d);
    }

    public float f() {
        return e() * 57.295776f;
    }
}
