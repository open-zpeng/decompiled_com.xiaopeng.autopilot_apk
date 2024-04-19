package com.badlogic.gdx.math;

import java.io.Serializable;
/* compiled from: Matrix3.java */
/* loaded from: classes.dex */
public class i implements Serializable {
    private static final long serialVersionUID = 7907569533774959788L;
    public float[] a = new float[9];
    private float[] b = new float[9];

    public i() {
        a();
    }

    public i a() {
        float[] fArr = this.a;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public String toString() {
        float[] fArr = this.a;
        return "[" + fArr[0] + "|" + fArr[3] + "|" + fArr[6] + "]\n[" + fArr[1] + "|" + fArr[4] + "|" + fArr[7] + "]\n[" + fArr[2] + "|" + fArr[5] + "|" + fArr[8] + "]";
    }

    public float b() {
        float[] fArr = this.a;
        return ((((((fArr[0] * fArr[4]) * fArr[8]) + ((fArr[3] * fArr[7]) * fArr[2])) + ((fArr[6] * fArr[1]) * fArr[5])) - ((fArr[0] * fArr[7]) * fArr[5])) - ((fArr[3] * fArr[1]) * fArr[8])) - ((fArr[6] * fArr[4]) * fArr[2]);
    }

    public i c() {
        float b = b();
        if (b == 0.0f) {
            throw new com.badlogic.gdx.utils.k("Can't invert a singular matrix");
        }
        float f = 1.0f / b;
        float[] fArr = this.b;
        float[] fArr2 = this.a;
        fArr[0] = (fArr2[4] * fArr2[8]) - (fArr2[5] * fArr2[7]);
        fArr[1] = (fArr2[2] * fArr2[7]) - (fArr2[1] * fArr2[8]);
        fArr[2] = (fArr2[1] * fArr2[5]) - (fArr2[2] * fArr2[4]);
        fArr[3] = (fArr2[5] * fArr2[6]) - (fArr2[3] * fArr2[8]);
        fArr[4] = (fArr2[0] * fArr2[8]) - (fArr2[2] * fArr2[6]);
        fArr[5] = (fArr2[2] * fArr2[3]) - (fArr2[0] * fArr2[5]);
        fArr[6] = (fArr2[3] * fArr2[7]) - (fArr2[4] * fArr2[6]);
        fArr[7] = (fArr2[1] * fArr2[6]) - (fArr2[0] * fArr2[7]);
        fArr[8] = (fArr2[0] * fArr2[4]) - (fArr2[1] * fArr2[3]);
        fArr2[0] = fArr[0] * f;
        fArr2[1] = fArr[1] * f;
        fArr2[2] = fArr[2] * f;
        fArr2[3] = fArr[3] * f;
        fArr2[4] = fArr[4] * f;
        fArr2[5] = fArr[5] * f;
        fArr2[6] = fArr[6] * f;
        fArr2[7] = fArr[7] * f;
        fArr2[8] = f * fArr[8];
        return this;
    }

    public i a(Matrix4 matrix4) {
        float[] fArr = this.a;
        fArr[0] = matrix4.a[0];
        fArr[1] = matrix4.a[1];
        fArr[2] = matrix4.a[2];
        fArr[3] = matrix4.a[4];
        fArr[4] = matrix4.a[5];
        fArr[5] = matrix4.a[6];
        fArr[6] = matrix4.a[8];
        fArr[7] = matrix4.a[9];
        fArr[8] = matrix4.a[10];
        return this;
    }

    public i d() {
        float[] fArr = this.a;
        float f = fArr[1];
        float f2 = fArr[2];
        float f3 = fArr[3];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[7];
        fArr[3] = f;
        fArr[6] = f2;
        fArr[1] = f3;
        fArr[7] = f4;
        fArr[2] = f5;
        fArr[5] = f6;
        return this;
    }
}
