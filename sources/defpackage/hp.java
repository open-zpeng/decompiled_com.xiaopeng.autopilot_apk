package defpackage;

import android.view.animation.Interpolator;
/* compiled from: LookupTableInterpolator.java */
/* renamed from: hp  reason: default package */
/* loaded from: classes.dex */
abstract class hp implements Interpolator {
    private final float[] a;
    private final float b;

    /* JADX INFO: Access modifiers changed from: protected */
    public hp(float[] fArr) {
        this.a = fArr;
        this.b = 1.0f / (this.a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.b;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
