package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.parking.view.g3d.g;
/* compiled from: DrivingCarEntity.java */
/* renamed from: uf  reason: default package */
/* loaded from: classes.dex */
public class uf extends uc {
    public static final String k = d.l;
    public static float l;
    protected int m;

    public String j() {
        return this.J;
    }

    public uf(ach achVar, String str) {
        super(achVar, str);
        this.m = 0;
        l = g.a(uf.class);
    }

    @Override // defpackage.uc, defpackage.aci, defpackage.ik
    public void a() {
        super.a();
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        super.a(kzVar);
    }

    @Override // defpackage.uc, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        super.a(kzVar, kwVar);
    }

    public void e() {
        if (this.L == null || this.K == null) {
            aca an = C().an();
            if (an.c(this.J)) {
                this.K = (ky) an.a(this.J);
                this.L = new la(this.K);
                kx b = this.L.b("mat_shadow");
                le leVar = new le(770, 771);
                leVar.f = 0.75f;
                b.a(leVar);
                this.L.f.e(0.0f, l, 0.0f);
                a(true);
                k();
            }
        }
    }

    public void k() {
        this.L.b("mat_p7").a(ln.a(Y.ae.f(d.o())));
    }

    public void a(float f) {
        float f2 = (-7.2016563f) * (1.0f - uc.f) * f;
        this.L.f.c();
        this.af.c();
        this.ae.c();
        this.af.f(1.0f, 1.0f, 1.0f);
        this.ae.e(0.0f, l, f2);
        this.ae.b(this.af);
        e(this.ae);
    }

    public void l() {
        this.L.f.c();
        this.L.f.e(0.0f, l, 0.0f);
    }

    public void m() {
        Matrix4 matrix4 = new Matrix4();
        matrix4.e(0.0f, l, -1.7146802f);
        this.L.f.c();
        this.L.f.b(matrix4);
    }
}
