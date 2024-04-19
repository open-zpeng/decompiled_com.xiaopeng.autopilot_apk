package defpackage;
/* compiled from: Radar3DSenceListener.java */
/* renamed from: va  reason: default package */
/* loaded from: classes.dex */
public class va implements rk {
    private vf a;
    private int b;

    public va(vf vfVar) {
        this.a = vfVar;
    }

    @Override // defpackage.rk
    public void a(int i, int i2, int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2 = false;
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == 1) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (iArr2 != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= iArr2.length) {
                    break;
                } else if (iArr2[i4] == 1) {
                    z2 = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        this.a.a(i, z);
        this.a.b(i2, z2);
        this.a.a(z, z2);
    }

    public void a(int i) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }
}
