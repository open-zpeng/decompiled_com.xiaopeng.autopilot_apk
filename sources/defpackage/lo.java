package defpackage;

import com.badlogic.gdx.math.p;
/* compiled from: AmbientCubemap.java */
/* renamed from: lo  reason: default package */
/* loaded from: classes.dex */
public class lo {
    public final float[] a = new float[18];

    private static final float a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public lo a(ka kaVar) {
        return a(kaVar.J, kaVar.K, kaVar.L);
    }

    public lo a(float f, float f2, float f3) {
        for (int i = 0; i < 18; i += 3) {
            float[] fArr = this.a;
            fArr[i] = f;
            fArr[i + 1] = f2;
            fArr[i + 2] = f3;
        }
        return this;
    }

    public lo a() {
        int i = 0;
        while (true) {
            float[] fArr = this.a;
            if (i >= fArr.length) {
                return this;
            }
            fArr[i] = a(fArr[i]);
            i++;
        }
    }

    public lo a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 * f4;
        float f8 = f5 * f5;
        float f9 = f6 * f6;
        float f10 = f7 + f8 + f9;
        if (f10 == 0.0f) {
            return this;
        }
        float f11 = (1.0f / f10) * (f10 + 1.0f);
        float f12 = f * f11;
        float f13 = f2 * f11;
        float f14 = f3 * f11;
        int i = f4 > 0.0f ? 0 : 3;
        float[] fArr = this.a;
        fArr[i] = fArr[i] + (f7 * f12);
        int i2 = i + 1;
        fArr[i2] = fArr[i2] + (f7 * f13);
        int i3 = i + 2;
        fArr[i3] = fArr[i3] + (f7 * f14);
        int i4 = f5 > 0.0f ? 6 : 9;
        float[] fArr2 = this.a;
        fArr2[i4] = fArr2[i4] + (f8 * f12);
        int i5 = i4 + 1;
        fArr2[i5] = fArr2[i5] + (f8 * f13);
        int i6 = i4 + 2;
        fArr2[i6] = fArr2[i6] + (f8 * f14);
        int i7 = f6 > 0.0f ? 12 : 15;
        float[] fArr3 = this.a;
        fArr3[i7] = fArr3[i7] + (f12 * f9);
        int i8 = i7 + 1;
        fArr3[i8] = fArr3[i8] + (f13 * f9);
        int i9 = i7 + 2;
        fArr3[i9] = fArr3[i9] + (f9 * f14);
        return this;
    }

    public lo a(ka kaVar, p pVar) {
        return a(kaVar.J, kaVar.K, kaVar.L, pVar.a, pVar.b, pVar.c);
    }

    public lo a(ka kaVar, p pVar, p pVar2, float f) {
        float d = f / (pVar2.d(pVar) + 1.0f);
        return a(kaVar.J * d, kaVar.K * d, kaVar.L * d, pVar2.a - pVar.a, pVar2.b - pVar.b, pVar2.c - pVar.c);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.a.length; i += 3) {
            str = str + Float.toString(this.a[i]) + ", " + Float.toString(this.a[i + 1]) + ", " + Float.toString(this.a[i + 2]) + "\n";
        }
        return str;
    }
}
