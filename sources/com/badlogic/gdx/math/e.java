package com.badlogic.gdx.math;
/* compiled from: Frustum.java */
/* loaded from: classes.dex */
public class e {
    protected static final p[] a = {new p(-1.0f, -1.0f, -1.0f), new p(1.0f, -1.0f, -1.0f), new p(1.0f, 1.0f, -1.0f), new p(-1.0f, 1.0f, -1.0f), new p(-1.0f, -1.0f, 1.0f), new p(1.0f, -1.0f, 1.0f), new p(1.0f, 1.0f, 1.0f), new p(-1.0f, 1.0f, 1.0f)};
    protected static final float[] b = new float[24];
    private static final p f;
    public final j[] c = new j[6];
    public final p[] d = {new p(), new p(), new p(), new p(), new p(), new p(), new p(), new p()};
    protected final float[] e = new float[24];

    static {
        int i = 0;
        p[] pVarArr = a;
        int length = pVarArr.length;
        int i2 = 0;
        while (i < length) {
            p pVar = pVarArr[i];
            int i3 = i2 + 1;
            b[i2] = pVar.a;
            int i4 = i3 + 1;
            b[i3] = pVar.b;
            b[i4] = pVar.c;
            i++;
            i2 = i4 + 1;
        }
        f = new p();
    }

    public e() {
        for (int i = 0; i < 6; i++) {
            this.c[i] = new j(new p(), 0.0f);
        }
    }

    public void a(Matrix4 matrix4) {
        float[] fArr = b;
        System.arraycopy(fArr, 0, this.e, 0, fArr.length);
        Matrix4.prj(matrix4.a, this.e, 0, 8, 3);
        int i = 0;
        int i2 = 0;
        while (i < 8) {
            p pVar = this.d[i];
            float[] fArr2 = this.e;
            int i3 = i2 + 1;
            pVar.a = fArr2[i2];
            int i4 = i3 + 1;
            pVar.b = fArr2[i3];
            pVar.c = fArr2[i4];
            i++;
            i2 = i4 + 1;
        }
        j jVar = this.c[0];
        p[] pVarArr = this.d;
        jVar.a(pVarArr[1], pVarArr[0], pVarArr[2]);
        j jVar2 = this.c[1];
        p[] pVarArr2 = this.d;
        jVar2.a(pVarArr2[4], pVarArr2[5], pVarArr2[7]);
        j jVar3 = this.c[2];
        p[] pVarArr3 = this.d;
        jVar3.a(pVarArr3[0], pVarArr3[4], pVarArr3[3]);
        j jVar4 = this.c[3];
        p[] pVarArr4 = this.d;
        jVar4.a(pVarArr4[5], pVarArr4[1], pVarArr4[6]);
        j jVar5 = this.c[4];
        p[] pVarArr5 = this.d;
        jVar5.a(pVarArr5[2], pVarArr5[3], pVarArr5[6]);
        j jVar6 = this.c[5];
        p[] pVarArr6 = this.d;
        jVar6.a(pVarArr6[4], pVarArr6[0], pVarArr6[1]);
    }
}
