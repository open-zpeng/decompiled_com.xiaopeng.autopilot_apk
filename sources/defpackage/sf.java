package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import java.util.Iterator;
/* compiled from: UnParkedlotEntityPro.java */
/* renamed from: sf  reason: default package */
/* loaded from: classes.dex */
public class sf extends uv {
    rz a;
    Matrix4 b = new Matrix4();
    p c = new p();
    boolean d = true;
    boolean e = false;
    p f = new p();
    boolean g;

    public void a(p pVar) {
        this.f = pVar;
    }

    public p m_() {
        return this.f;
    }

    public boolean h() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public p i() {
        return this.c;
    }

    public void b(p pVar) {
        this.c = pVar;
    }

    public boolean j() {
        return this.g;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public Matrix4 k() {
        return this.b;
    }

    public void a(Matrix4 matrix4) {
        this.b = matrix4;
    }

    public sf() {
        this.J = "model/entity/weizhichewei.g3db";
    }

    public up l() {
        return this.a;
    }

    public boolean m() {
        return this.e;
    }

    public void a(rz rzVar) {
        this.a = rzVar;
        this.e = true;
    }

    @Override // defpackage.up, defpackage.aci, defpackage.ik
    public void a() {
        super.a();
    }

    @Override // defpackage.uv, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        super.a(kzVar, (kw) null);
        rz rzVar = this.a;
        if (rzVar != null) {
            rzVar.a(kzVar, kwVar);
        }
    }

    public void a(Matrix4 matrix4, Matrix4 matrix42) {
        if (k_() != null) {
            k_().f.c();
            k_().f.b(matrix4);
            k_().f.b(matrix42);
            rz rzVar = this.a;
            if (rzVar == null || rzVar.k_() == null) {
                return;
            }
            this.a.a(matrix4, matrix42);
            if (this.J.equals("model/entity/weizhichewei_Lateral.g3db")) {
                this.a.k_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                this.a.a.f.d(0.0f, 1.0f, 0.0f, -90.0f);
            }
        }
    }

    @Override // defpackage.uv, defpackage.up
    public void a(boolean z) {
        super.a(z);
        rz rzVar = this.a;
        if (rzVar != null) {
            rzVar.a(false);
        }
    }

    public void a(float f, boolean z) {
        rz rzVar = this.a;
        if (rzVar == null || rzVar.k_() == null) {
            return;
        }
        le leVar = new le(770, 771);
        leVar.f = f;
        Iterator<kx> it = this.a.k_().b.iterator();
        while (it.hasNext()) {
            it.next().a(leVar);
        }
    }

    @Override // defpackage.uv, defpackage.up, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.L = null;
        rz rzVar = this.a;
        if (rzVar != null) {
            rzVar.dispose();
        }
    }

    public boolean n() {
        return this.J.equals("model/entity/weizhichewei_Lateral.g3db");
    }

    @Override // defpackage.uv, defpackage.up
    public void e() {
        super.e();
        if (l() != null) {
            l().e();
        }
    }

    @Override // defpackage.uv, defpackage.up
    public void f() {
        super.f();
        if (l() != null) {
            l().f();
        }
    }
}
