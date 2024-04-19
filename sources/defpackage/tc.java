package defpackage;

import java.util.Iterator;
/* compiled from: ParkSignEntity.java */
/* renamed from: tc  reason: default package */
/* loaded from: classes.dex */
public class tc extends th {
    private static String[] a = {"Mat_Start_Dot"};

    public tc() {
        this.J = "model/start_p/Mesh_Start_Dot.g3db";
    }

    @Override // defpackage.th, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        this.M.c();
        this.M.e(0.0f, 0.15f, -10.0f);
        this.L.f.c();
        this.L.f.b(this.M);
        super.a(kzVar, kwVar);
    }

    @Override // defpackage.th
    public void e() {
        lf b = lf.b(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.L == null || this.L.b == null) {
            return;
        }
        Iterator<kx> it = this.L.b.iterator();
        while (it.hasNext()) {
            it.next().a(b);
        }
    }

    @Override // defpackage.th
    public void f() {
        lf b = lf.b(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.L == null || this.L.b == null) {
            return;
        }
        Iterator<kx> it = this.L.b.iterator();
        while (it.hasNext()) {
            it.next().a(b);
        }
    }

    @Override // defpackage.th
    public void g() {
        super.g();
        if (!C().an().c(this.J)) {
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = a;
            if (i >= strArr.length) {
                return;
            }
            kx b = this.L.b(strArr[i]);
            le leVar = new le(770, 771);
            leVar.f = 1.0f;
            b.a(leVar);
            i++;
        }
    }
}
