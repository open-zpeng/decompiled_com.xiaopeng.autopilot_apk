package com.xiaopeng.autopilot.parking.view.g3d;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
/* compiled from: QuaternionUtil.java */
/* loaded from: classes.dex */
public class k {
    public static Matrix4 a(jz jzVar) {
        float[] fArr = new float[16];
        p a = jzVar.b.a();
        p a2 = jzVar.c.a();
        acs b = acs.b(new act(a.a, a.b, a.c), new act(a2.a, a2.b, a2.c));
        a(fArr, b.a, b.b, b.c, b.d);
        return new Matrix4(fArr);
    }

    public static void a(float[] fArr, float f, float f2, float f3, float f4) {
        float f5 = f * f;
        float f6 = f * f2;
        float f7 = f * f3;
        float f8 = f * f4;
        float f9 = f2 * f2;
        float f10 = f2 * f3;
        float f11 = f2 * f4;
        float f12 = f3 * f3;
        float f13 = f3 * f4;
        fArr[0] = 1.0f - ((f9 + f12) * 2.0f);
        fArr[4] = (f6 - f13) * 2.0f;
        fArr[8] = (f7 + f11) * 2.0f;
        fArr[12] = 0.0f;
        fArr[1] = (f6 + f13) * 2.0f;
        fArr[5] = 1.0f - ((f12 + f5) * 2.0f);
        fArr[9] = (f10 - f8) * 2.0f;
        fArr[13] = 0.0f;
        fArr[2] = (f7 - f11) * 2.0f;
        fArr[6] = (f10 + f8) * 2.0f;
        fArr[10] = 1.0f - ((f5 + f9) * 2.0f);
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
    }
}
