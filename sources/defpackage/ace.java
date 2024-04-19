package defpackage;
/* compiled from: FloatValueAnimator.java */
/* renamed from: ace  reason: default package */
/* loaded from: classes.dex */
public class ace extends acf {
    private float[] u;
    private float v;

    public void a(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        this.p = Math.max(fArr.length, 2);
        float[] fArr2 = this.u;
        if (fArr2 == null || fArr2.length < this.p || this.u.length >= this.p * 2) {
            this.u = new float[this.p];
            this.s = new float[this.p];
        }
        this.q = 0;
        this.r = this.p - 1;
        if (fArr.length == 1) {
            float[] fArr3 = this.u;
            float f = fArr[0];
            fArr3[1] = f;
            fArr3[0] = f;
            this.s[0] = 0.0f;
        } else {
            for (int i = 0; i < this.p; i++) {
                this.u[i] = fArr[i];
                this.s[i] = i / (this.p - 1);
            }
        }
        this.s[this.r] = 1.0f;
        this.v = this.u[0];
    }

    public float e() {
        return this.v;
    }

    @Override // defpackage.acf
    protected void a(float f, int i, int i2) {
        float[] fArr = this.u;
        float f2 = fArr[i];
        this.v = f2 + (f * (fArr[i2] - f2));
    }
}
