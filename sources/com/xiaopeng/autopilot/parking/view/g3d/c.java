package com.xiaopeng.autopilot.parking.view.g3d;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.aq;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.model.IParkingModelPro;
import defpackage.a;
import defpackage.mz;
/* compiled from: DrivingCarEntityPro.java */
/* loaded from: classes.dex */
public class c extends uf implements IParkingModelPro.IDrivingDataChangeListener {
    public static final String a = com.xiaopeng.autopilot.base.d.m;
    le b;
    private Matrix4 n;
    private Matrix4 o;
    private p p;
    private Matrix4 q;
    private int r;
    private mz s;
    private int t;
    private Matrix4 u;
    private p v;

    @Override // defpackage.uf
    public void e() {
    }

    @Override // defpackage.uf, defpackage.uc, defpackage.aci, defpackage.ik
    public void a() {
        PerformanceTestUnit.logStart("DrivingCarEntityPro");
        this.L = new la(new lu(new aq()).a(io.e.internal(this.J)));
        kx b = this.L.b("mat_shadow");
        le leVar = new le(770, 771);
        leVar.f = 0.75f;
        b.a(leVar);
        this.L.f.e(0.0f, l, 0.0f);
        a(true);
        k();
        if (g()) {
            this.s = new mz(this.L);
        }
        l();
        b.a(lj.b(0.05f));
        PerformanceTestUnit.logEnd("DrivingCarEntityPro", "DrivingCarEntityPro_create");
    }

    public c(ach achVar, String str) {
        super(achVar, str);
        this.n = new Matrix4();
        this.o = new Matrix4();
        this.p = new p();
        this.q = new Matrix4();
        this.r = 0;
        this.t = 0;
        this.u = new Matrix4();
        this.b = new le(770, 771);
        this.v = new p();
        l = g.a(c.class);
    }

    @Override // defpackage.uf, defpackage.aci
    public void a(kz kzVar) {
        if (d.q) {
            kzVar = ((d) C()).U();
        }
        a(kzVar, this.q);
    }

    @Override // defpackage.uf, defpackage.uc, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (d.q) {
            kzVar = ((d) C()).U();
        }
        if (!(i.r.e().intValue() == 2)) {
            a(kzVar, this.q);
            return;
        }
        com.xiaopeng.autopilot.base.i.a(i.q.class, true);
        b(kzVar, kwVar);
    }

    private void b(kz kzVar, kw kwVar) {
        if (this.L != null) {
            this.L.f.c();
            this.L.f.b(this.u);
            kzVar.a(this.L);
        }
    }

    private void a(kz kzVar, Matrix4 matrix4) {
        if (this.L != null) {
            if (((i.q) com.xiaopeng.autopilot.base.i.a(i.q.class)).d().booleanValue()) {
                com.xiaopeng.autopilot.base.i.a(i.q.class, false);
                this.L.f.c();
                this.L.f.e(0.0f, l, 0.0f);
            }
            int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
            kx b = this.L.b("mat_shadow");
            if (intValue == -2) {
                this.b.f = 0.0f;
            } else {
                this.b.f = 0.75f;
            }
            b.a(this.b);
            kzVar.a(this.L);
        }
        if (this.s == null || this.t == 0) {
            return;
        }
        this.s.a(io.b.getDeltaTime());
    }

    public p f() {
        return this.p;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IDrivingDataChangeListener
    public void onDrivingDataRefresh(a.c cVar) {
        if (cVar.c() > 0.0f) {
            n();
        } else if (cVar.c() < 0.0f) {
            o();
        } else {
            p();
        }
        float a2 = cVar.a().a();
        float b = cVar.a().b();
        float c = cVar.a().c();
        cVar.b().b();
        cVar.b().c();
        this.p.a(a2, b, c);
        p a3 = tz.a(a2, b, c);
        this.o.c();
        this.o.c((cVar.b().a() * 57.29578f) - 90.0f, 0.0f, 0.0f);
        this.q.c();
        this.n.c();
        this.n.e(a3.a, a3.b, a3.c);
        e(a3.a);
        f(a3.b);
        g(a3.c);
        this.u.c();
        this.u.b(this.n);
        this.u.b(this.o);
        if (cVar.f() == 1) {
            this.v.a(a3.a, a3.b, a3.c);
        }
    }

    private void n() {
        if (this.s == null || this.t == 1) {
            return;
        }
        this.t = 1;
        Log.i("DrivingCarEntityPro", "moveFront");
        this.s.a((String) null);
        this.s.a("move_forward", 2, 1.0f, new mz.b() { // from class: com.xiaopeng.autopilot.parking.view.g3d.c.1
            @Override // defpackage.mz.b
            public void a(mz.a aVar) {
            }

            @Override // defpackage.mz.b
            public void b(mz.a aVar) {
                c.this.s.b.g++;
            }
        }, 2000.0f);
        this.s.i = false;
    }

    private void o() {
        if (this.s == null || this.t == 2) {
            return;
        }
        this.t = 2;
        Log.i("DrivingCarEntityPro", "moveBack");
        this.s.a((String) null);
        this.s.a("move_back", 2, 1.0f, new mz.b() { // from class: com.xiaopeng.autopilot.parking.view.g3d.c.2
            @Override // defpackage.mz.b
            public void a(mz.a aVar) {
            }

            @Override // defpackage.mz.b
            public void b(mz.a aVar) {
                c.this.s.b.g++;
            }
        }, 2000.0f);
        this.s.i = false;
    }

    private void p() {
        if (this.s == null || this.t == 0) {
            return;
        }
        this.t = 0;
        Log.i("DrivingCarEntityPro", "moveStop");
        this.s.b.g = 1;
        this.s.a((String) null);
        this.s.i = true;
    }
}
