package com.badlogic.gdx.math;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Matrix4 implements Serializable {
    private static final long serialVersionUID = -2717655254359579617L;
    public final float[] a;
    private static final float[] l = new float[16];
    static l b = new l();
    static l c = new l();
    static final p d = new p();
    static final p e = new p();
    static final p f = new p();
    static final p g = new p();
    static final Matrix4 h = new Matrix4();
    static final p i = new p();
    static final p j = new p();
    static final p k = new p();

    public static native boolean inv(float[] fArr);

    public static native void mul(float[] fArr, float[] fArr2);

    public static native void prj(float[] fArr, float[] fArr2, int i2, int i3, int i4);

    public Matrix4() {
        this.a = new float[16];
        float[] fArr = this.a;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public Matrix4(Matrix4 matrix4) {
        this.a = new float[16];
        a(matrix4);
    }

    public Matrix4(float[] fArr) {
        this.a = new float[16];
        a(fArr);
    }

    public Matrix4 a(Matrix4 matrix4) {
        return a(matrix4.a);
    }

    public Matrix4 a(float[] fArr) {
        float[] fArr2 = this.a;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public Matrix4 a(l lVar) {
        return a(lVar.a, lVar.b, lVar.c, lVar.d);
    }

    public Matrix4 a(float f2, float f3, float f4, float f5) {
        return a(0.0f, 0.0f, 0.0f, f2, f3, f4, f5);
    }

    public Matrix4 a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f5 * 2.0f;
        float f10 = f6 * 2.0f;
        float f11 = 2.0f * f7;
        float f12 = f8 * f9;
        float f13 = f8 * f10;
        float f14 = f8 * f11;
        float f15 = f9 * f5;
        float f16 = f5 * f10;
        float f17 = f5 * f11;
        float f18 = f10 * f6;
        float f19 = f6 * f11;
        float f20 = f11 * f7;
        float[] fArr = this.a;
        fArr[0] = 1.0f - (f18 + f20);
        fArr[4] = f16 - f14;
        fArr[8] = f17 + f13;
        fArr[12] = f2;
        fArr[1] = f16 + f14;
        fArr[5] = 1.0f - (f20 + f15);
        fArr[9] = f19 - f12;
        fArr[13] = f3;
        fArr[2] = f17 - f13;
        fArr[6] = f19 + f12;
        fArr[10] = 1.0f - (f15 + f18);
        fArr[14] = f4;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 a(p pVar, l lVar, p pVar2) {
        return a(pVar.a, pVar.b, pVar.c, lVar.a, lVar.b, lVar.c, lVar.d, pVar2.a, pVar2.b, pVar2.c);
    }

    public Matrix4 a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = f5 * 2.0f;
        float f13 = f6 * 2.0f;
        float f14 = 2.0f * f7;
        float f15 = f8 * f12;
        float f16 = f8 * f13;
        float f17 = f8 * f14;
        float f18 = f12 * f5;
        float f19 = f5 * f13;
        float f20 = f5 * f14;
        float f21 = f13 * f6;
        float f22 = f6 * f14;
        float f23 = f14 * f7;
        float[] fArr = this.a;
        fArr[0] = (1.0f - (f21 + f23)) * f9;
        fArr[4] = (f19 - f17) * f10;
        fArr[8] = (f20 + f16) * f11;
        fArr[12] = f2;
        fArr[1] = f9 * (f19 + f17);
        fArr[5] = (1.0f - (f23 + f18)) * f10;
        fArr[9] = (f22 - f15) * f11;
        fArr[13] = f3;
        fArr[2] = f9 * (f20 - f16);
        fArr[6] = f10 * (f22 + f15);
        fArr[10] = (1.0f - (f18 + f21)) * f11;
        fArr[14] = f4;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 a() {
        return new Matrix4(this);
    }

    public Matrix4 a(float f2, float f3, float f4) {
        float[] fArr = this.a;
        fArr[12] = fArr[12] + f2;
        fArr[13] = fArr[13] + f3;
        fArr[14] = fArr[14] + f4;
        return this;
    }

    public float[] b() {
        return this.a;
    }

    public Matrix4 b(Matrix4 matrix4) {
        mul(this.a, matrix4.a);
        return this;
    }

    public Matrix4 c() {
        float[] fArr = this.a;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r2v3 ?? I:float)
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:114)
        */
    public com.badlogic.gdx.math.Matrix4 d() {
        /*
            Method dump skipped, instructions count: 1704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.math.Matrix4.d():com.badlogic.gdx.math.Matrix4");
    }

    public float e() {
        float[] fArr = this.a;
        return (((((((((((((((((((((((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])) + (((fArr[1] * fArr[7]) * fArr[10]) * fArr[12])) + (((fArr[2] * fArr[5]) * fArr[11]) * fArr[12])) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])) + (((fArr[2] * fArr[7]) * fArr[8]) * fArr[13])) + (((fArr[3] * fArr[4]) * fArr[10]) * fArr[13])) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])) + (((fArr[0] * fArr[6]) * fArr[11]) * fArr[13])) + (((fArr[3] * fArr[5]) * fArr[8]) * fArr[14])) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])) + (((fArr[0] * fArr[7]) * fArr[9]) * fArr[14])) + (((fArr[1] * fArr[4]) * fArr[11]) * fArr[14])) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])) + (((fArr[1] * fArr[6]) * fArr[8]) * fArr[15])) + (((fArr[2] * fArr[4]) * fArr[9]) * fArr[15])) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[10] * fArr[15]);
    }

    public float f() {
        float[] fArr = this.a;
        return ((((((fArr[0] * fArr[5]) * fArr[10]) + ((fArr[4] * fArr[9]) * fArr[2])) + ((fArr[8] * fArr[1]) * fArr[6])) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) - ((fArr[8] * fArr[5]) * fArr[2]);
    }

    public Matrix4 b(float f2, float f3, float f4, float f5) {
        c();
        float tan = (float) (1.0d / Math.tan((f4 * 0.017453292519943295d) / 2.0d));
        float f6 = f2 - f3;
        float[] fArr = this.a;
        fArr[0] = tan / f5;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = tan;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (f3 + f2) / f6;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = ((f3 * 2.0f) * f2) / f6;
        fArr[15] = 0.0f;
        return this;
    }

    public Matrix4 c(float f2, float f3, float f4, float f5) {
        a(f2, f2 + f4, f3, f3 + f5, 0.0f, 1.0f);
        return this;
    }

    public Matrix4 a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c();
        float f8 = f3 - f2;
        float f9 = f5 - f4;
        float f10 = f7 - f6;
        float[] fArr = this.a;
        fArr[0] = 2.0f / f8;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f9;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (-2.0f) / f10;
        fArr[11] = 0.0f;
        fArr[12] = (-(f3 + f2)) / f8;
        fArr[13] = (-(f5 + f4)) / f9;
        fArr[14] = (-(f7 + f6)) / f10;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 b(float f2, float f3, float f4) {
        c();
        float[] fArr = this.a;
        fArr[12] = f2;
        fArr[13] = f3;
        fArr[14] = f4;
        return this;
    }

    public Matrix4 a(p pVar, float f2) {
        if (f2 == 0.0f) {
            c();
            return this;
        }
        return a(b.a(pVar, f2));
    }

    public Matrix4 a(p pVar, p pVar2) {
        return a(b.a(pVar, pVar2));
    }

    public Matrix4 c(float f2, float f3, float f4) {
        b.a(f2, f3, f4);
        return a(b);
    }

    public Matrix4 d(float f2, float f3, float f4) {
        c();
        float[] fArr = this.a;
        fArr[0] = f2;
        fArr[5] = f3;
        fArr[10] = f4;
        return this;
    }

    public Matrix4 b(p pVar, p pVar2) {
        d.a(pVar).d();
        e.a(pVar).d();
        e.g(pVar2).d();
        f.a(e).g(d).d();
        c();
        this.a[0] = e.a;
        this.a[4] = e.b;
        this.a[8] = e.c;
        this.a[1] = f.a;
        this.a[5] = f.b;
        this.a[9] = f.c;
        this.a[2] = -d.a;
        this.a[6] = -d.b;
        this.a[10] = -d.c;
        return this;
    }

    public Matrix4 a(p pVar, p pVar2, p pVar3) {
        g.a(pVar2).c(pVar);
        b(g, pVar3);
        b(h.b(-pVar.a, -pVar.b, -pVar.c));
        return this;
    }

    public String toString() {
        return "[" + this.a[0] + "|" + this.a[4] + "|" + this.a[8] + "|" + this.a[12] + "]\n[" + this.a[1] + "|" + this.a[5] + "|" + this.a[9] + "|" + this.a[13] + "]\n[" + this.a[2] + "|" + this.a[6] + "|" + this.a[10] + "|" + this.a[14] + "]\n[" + this.a[3] + "|" + this.a[7] + "|" + this.a[11] + "|" + this.a[15] + "]\n";
    }

    public Matrix4 a(Matrix4 matrix4, float f2) {
        for (int i2 = 0; i2 < 16; i2++) {
            float[] fArr = this.a;
            fArr[i2] = (fArr[i2] * (1.0f - f2)) + (matrix4.a[i2] * f2);
        }
        return this;
    }

    public Matrix4 a(a aVar) {
        this.a[0] = aVar.a;
        this.a[1] = aVar.d;
        float[] fArr = this.a;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = aVar.b;
        this.a[5] = aVar.e;
        float[] fArr2 = this.a;
        fArr2[6] = 0.0f;
        fArr2[7] = 0.0f;
        fArr2[8] = 0.0f;
        fArr2[9] = 0.0f;
        fArr2[10] = 1.0f;
        fArr2[11] = 0.0f;
        fArr2[12] = aVar.c;
        this.a[13] = aVar.f;
        float[] fArr3 = this.a;
        fArr3[14] = 0.0f;
        fArr3[15] = 1.0f;
        return this;
    }

    public Matrix4 b(a aVar) {
        this.a[0] = aVar.a;
        this.a[1] = aVar.d;
        this.a[4] = aVar.b;
        this.a[5] = aVar.e;
        this.a[12] = aVar.c;
        this.a[13] = aVar.f;
        return this;
    }

    public Matrix4 c(Matrix4 matrix4) {
        float[] fArr = this.a;
        float[] fArr2 = matrix4.a;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[4] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[12] = fArr2[12];
        fArr[13] = fArr2[13];
        return this;
    }

    public Matrix4 a(float f2) {
        float[] fArr = this.a;
        fArr[0] = fArr[0] * f2;
        fArr[5] = fArr[5] * f2;
        fArr[10] = fArr[10] * f2;
        return this;
    }

    public p a(p pVar) {
        float[] fArr = this.a;
        pVar.a = fArr[12];
        pVar.b = fArr[13];
        pVar.c = fArr[14];
        return pVar;
    }

    public l b(l lVar) {
        return lVar.a(this);
    }

    public Matrix4 b(p pVar) {
        return e(pVar.a, pVar.b, pVar.c);
    }

    public Matrix4 e(float f2, float f3, float f4) {
        float[] fArr = l;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = f2;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = f3;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = f4;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        mul(this.a, fArr);
        return this;
    }

    public Matrix4 b(p pVar, float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        b.a(pVar, f2);
        return c(b);
    }

    public Matrix4 c(p pVar, float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        b.b(pVar, f2);
        return c(b);
    }

    public Matrix4 d(float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return this;
        }
        b.b(f2, f3, f4, f5);
        return c(b);
    }

    public Matrix4 e(float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return this;
        }
        b.c(f2, f3, f4, f5);
        return c(b);
    }

    public Matrix4 c(l lVar) {
        lVar.a(l);
        mul(this.a, l);
        return this;
    }

    public Matrix4 f(float f2, float f3, float f4) {
        float[] fArr = l;
        fArr[0] = f2;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = f3;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = f4;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        mul(this.a, fArr);
        return this;
    }

    public boolean g() {
        return (h.a(this.a[0], 1.0f) && h.a(this.a[5], 1.0f) && h.a(this.a[10], 1.0f) && h.f(this.a[4]) && h.f(this.a[8]) && h.f(this.a[1]) && h.f(this.a[9]) && h.f(this.a[2]) && h.f(this.a[6])) ? false : true;
    }
}
