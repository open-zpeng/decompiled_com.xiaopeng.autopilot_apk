package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.i;
import com.badlogic.gdx.utils.ah;
import defpackage.ni;
/* compiled from: SphereShapeBuilder.java */
/* renamed from: ns  reason: default package */
/* loaded from: classes.dex */
public class ns extends nq {
    private static final ah x = new ah();
    private static final i y = new i();

    public static void a(ni niVar, float f, float f2, float f3, int i, int i2) {
        a(niVar, f, f2, f3, i, i2, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    public static void a(ni niVar, float f, float f2, float f3, int i, int i2, float f4, float f5, float f6, float f7) {
        a(niVar, w.c(), f, f2, f3, i, i2, f4, f5, f6, f7);
    }

    @Deprecated
    public static void a(ni niVar, Matrix4 matrix4, float f, float f2, float f3, int i, int i2, float f4, float f5, float f6, float f7) {
        float f8;
        int i3 = i;
        int i4 = i2;
        float f9 = f * 0.5f;
        float f10 = f2 * 0.5f;
        float f11 = 0.5f * f3;
        float f12 = f4 * 0.017453292f;
        float f13 = i3;
        float f14 = ((f5 - f4) * 0.017453292f) / f13;
        float f15 = f6 * 0.017453292f;
        float f16 = i4;
        float f17 = ((f7 - f6) * 0.017453292f) / f16;
        float f18 = 1.0f / f13;
        float f19 = 1.0f / f16;
        ni.a a = q.a(null, null, null, null);
        a.d = true;
        a.b = true;
        a.h = true;
        y.a(matrix4);
        int i5 = i3 + 3;
        x.a();
        x.c(i3 * 2);
        x.b = i5;
        int i6 = i3 + 1;
        niVar.a((i4 + 1) * i6);
        niVar.c(i3);
        int i7 = 0;
        int i8 = 0;
        while (i7 <= i4) {
            float f20 = i7;
            float f21 = f15 + (f17 * f20);
            float f22 = f20 * f19;
            float a2 = h.a(f21);
            float f23 = f19;
            float b = h.b(f21) * f10;
            float f24 = f10;
            float f25 = f15;
            int i9 = i8;
            int i10 = 0;
            while (i10 <= i3) {
                float f26 = f17;
                float f27 = i10;
                float f28 = f12 + (f14 * f27);
                float f29 = f12;
                float f30 = f9;
                float f31 = f11;
                a.a.a(h.b(f28) * f9 * a2, b, h.a(f28) * f11 * a2);
                a.c.a(a.a).a(y).d();
                a.a.a(matrix4);
                a.g.a(1.0f - (f27 * f18), f22);
                x.a(i9, niVar.a(a));
                int i11 = i9 + i5;
                if (i7 <= 0 || i10 <= 0) {
                    f8 = f22;
                } else {
                    f8 = f22;
                    niVar.b(x.a(i9), x.a((i11 - 1) % i5), x.a((i11 - (i3 + 2)) % i5), x.a((i11 - i6) % i5));
                }
                i9 = (i9 + 1) % x.b;
                i10++;
                f12 = f29;
                f17 = f26;
                f22 = f8;
                f11 = f31;
                f9 = f30;
                i3 = i;
            }
            i7++;
            f19 = f23;
            i8 = i9;
            f10 = f24;
            f9 = f9;
            i3 = i;
            i4 = i2;
            f15 = f25;
        }
    }
}
