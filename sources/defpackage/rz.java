package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.z;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.view.g3d.d;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.a;
/* compiled from: ParkedCarEntityPro.java */
/* renamed from: rz  reason: default package */
/* loaded from: classes.dex */
public class rz extends up implements z.a {
    protected la a;
    private a.k c;
    private la d;
    private boolean b = true;
    private Matrix4 e = new Matrix4();
    private Matrix4 f = new Matrix4();
    private Matrix4 g = new Matrix4();

    /* compiled from: ParkedCarEntityPro.java */
    /* renamed from: rz$a */
    /* loaded from: classes.dex */
    public static class a extends aci {
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.z.a
    public void reset() {
    }

    public rz(String str) {
        this.J = str;
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        kz T = d.q ? ((d) C()).T() : kzVar;
        la laVar = this.a;
        if (laVar != null) {
            if (kwVar != null) {
                T.a(laVar, kwVar);
            } else {
                T.a(laVar);
            }
        }
        if (this.L != null) {
            if (kwVar != null) {
                kzVar.a(this.L, kwVar);
            } else {
                kzVar.a(this.L);
            }
        }
        la laVar2 = this.d;
        if (laVar2 != null) {
            kzVar.a(laVar2);
        }
    }

    @Override // defpackage.up
    public void a(boolean z) {
        if (this.L == null || this.K == null) {
            if (C().an().c(this.J)) {
                this.K = (ky) C().an().a(this.J);
                this.L = new la(this.K, "model_jiaoche_body", "model_jiaoche_wheel");
                this.a = new la(this.K, "model_shadow", true);
                if (ThemeWatcher.getInstance().isNight()) {
                    f();
                } else {
                    e();
                }
            }
            la laVar = this.a;
            if (laVar != null) {
                laVar.b("mat_shadow").a(lj.b(0.05f));
            }
        }
    }

    private void h() {
        la laVar = this.a;
        if (laVar != null) {
            kx b = laVar.b("mat_shadow");
            le leVar = new le(770, 771);
            leVar.f = 0.7f;
            b.a(leVar);
        }
    }

    public void a(Matrix4 matrix4) {
        if (k_() == null || k_() == null || k_().f == null) {
            return;
        }
        k_().f.c();
        k_().f.b(matrix4);
        la laVar = this.a;
        if (laVar != null) {
            laVar.f.c();
            this.a.f.b(matrix4);
            this.a.f.e(0.0f, g.a(a.class), 0.0f);
        }
    }

    public String toString() {
        if (this.c == null) {
            return null;
        }
        StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
        stringBuffer.setLength(0);
        p pVar = new p(this.c.a().a(), this.c.a().b(), this.c.a().c());
        p pVar2 = new p(this.c.b().a(), this.c.b().b(), this.c.b().c());
        p pVar3 = new p(this.c.c().a(), this.c.c().b(), this.c.c().c());
        p pVar4 = new p(this.c.d().a(), this.c.d().b(), this.c.d().c());
        p pVar5 = new p(tz.e(this.c.a().a(), this.c.a().b(), this.c.a().c()));
        p pVar6 = new p(tz.e(this.c.b().a(), this.c.b().b(), this.c.b().c()));
        p pVar7 = new p(tz.e(this.c.c().a(), this.c.c().b(), this.c.c().c()));
        p pVar8 = new p(tz.e(this.c.d().a(), this.c.d().b(), this.c.d().c()));
        stringBuffer.append("ori:\t");
        stringBuffer.append("[");
        stringBuffer.append(pVar.toString());
        stringBuffer.append(pVar2.toString());
        stringBuffer.append(pVar3.toString());
        stringBuffer.append(pVar4.toString());
        stringBuffer.append("]");
        stringBuffer.append("cdu:\t");
        stringBuffer.append("[");
        stringBuffer.append(pVar5.toString());
        stringBuffer.append(pVar6.toString());
        stringBuffer.append(pVar7.toString());
        stringBuffer.append(pVar8.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void a(Matrix4 matrix4, Matrix4 matrix42) {
        if (k_() != null) {
            k_().f.c();
            k_().f.b(matrix4);
            k_().f.b(matrix42);
            la laVar = this.a;
            if (laVar != null) {
                laVar.f.c();
                this.a.f.b(matrix4);
                this.a.f.b(matrix42);
            }
        }
    }

    @Override // defpackage.up, defpackage.aci
    public void b(Matrix4 matrix4) {
        if (this.L != null) {
            this.L.f.c();
            this.L.f.b(matrix4);
        }
        la laVar = this.a;
        if (laVar != null) {
            laVar.f.c();
            this.a.f.b(matrix4);
        }
    }

    @Override // defpackage.up
    public void e() {
        lf b = lf.b(0.87058824f, 0.89411765f, 0.9019608f, 1.0f);
        lf c = lf.c(0.95f, 0.95f, 0.95f, 1.0f);
        lf a2 = lf.a(0.9f, 0.9f, 0.9f, 1.0f);
        lj a3 = lj.a(2.0f);
        if (this.L != null && this.L.b != null && this.L.b.b > 0) {
            kx b2 = this.L.b("mat_jiaoche_body");
            b2.c();
            b2.a(b);
            b2.a(c);
            b2.a(a2);
            b2.a(a3);
            kx b3 = this.L.b("mat_jiaoche_wheel");
            b3.c();
            b3.a(b);
            b3.a(c);
            b3.a(a2);
            b3.a(a3);
        }
        h();
    }

    @Override // defpackage.up
    public void f() {
        lf b = lf.b(0.2f, 0.28f, 0.4f, 1.0f);
        lf c = lf.c(0.5f, 0.5f, 0.5f, 1.0f);
        lf a2 = lf.a(0.3f, 0.3f, 0.3f, 1.0f);
        lj a3 = lj.a(2.0f);
        if (this.L != null && this.L.b != null) {
            kx b2 = this.L.b("mat_jiaoche_body");
            b2.c();
            b2.a(b);
            b2.a(c);
            b2.a(a2);
            b2.a(a3);
            kx b3 = this.L.b("mat_jiaoche_wheel");
            b3.c();
            b3.a(b);
            b3.a(c);
            b3.a(a2);
            b3.a(a3);
        }
        h();
    }

    @Override // defpackage.up, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.c = null;
        this.L = null;
        this.a = null;
    }

    public la l_() {
        return this.a;
    }
}
