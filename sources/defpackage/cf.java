package defpackage;

import defpackage.bz;
/* compiled from: Optimizer.java */
/* renamed from: cf  reason: default package */
/* loaded from: classes.dex */
public class cf {
    static boolean[] a = new boolean[3];

    public static final boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ca caVar, az azVar, bz bzVar) {
        bzVar.k = -1;
        bzVar.l = -1;
        if (caVar.J[0] != bz.a.WRAP_CONTENT && bzVar.J[0] == bz.a.MATCH_PARENT) {
            int i = bzVar.z.d;
            int F = caVar.F() - bzVar.B.d;
            bzVar.z.f = azVar.a(bzVar.z);
            bzVar.B.f = azVar.a(bzVar.B);
            azVar.a(bzVar.z.f, i);
            azVar.a(bzVar.B.f, F);
            bzVar.k = 2;
            bzVar.f(i, F);
        }
        if (caVar.J[1] == bz.a.WRAP_CONTENT || bzVar.J[1] != bz.a.MATCH_PARENT) {
            return;
        }
        int i2 = bzVar.A.d;
        int G = caVar.G() - bzVar.C.d;
        bzVar.A.f = azVar.a(bzVar.A);
        bzVar.C.f = azVar.a(bzVar.C);
        azVar.a(bzVar.A.f, i2);
        azVar.a(bzVar.C.f, G);
        if (bzVar.V > 0 || bzVar.B() == 8) {
            bzVar.D.f = azVar.a(bzVar.D);
            azVar.a(bzVar.D.f, bzVar.V + i2);
        }
        bzVar.l = 2;
        bzVar.g(i2, G);
    }
}
