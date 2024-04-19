package defpackage;
/* compiled from: RadarDistData.java */
/* renamed from: vb  reason: default package */
/* loaded from: classes.dex */
public class vb {
    public static final int[] a = {0, 1, 2, 3, 4, 5};
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;

    public vb(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.b = fArr[0];
        this.c = fArr[1];
        this.d = fArr[2];
        this.e = fArr[3];
        this.f = fArr[4];
        this.g = fArr[5];
    }

    public float a(int i) {
        switch (i) {
            case 0:
                return this.b;
            case 1:
                return this.c;
            case 2:
                return this.d;
            case 3:
                return this.e;
            case 4:
                return this.f;
            case 5:
                return this.g;
            default:
                return 0.0f;
        }
    }
}
