package com.xiaopeng.autopilot.parking.view.g3d;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.km;
import defpackage.ni;
/* compiled from: GroundSkyEntityPro.java */
/* loaded from: classes.dex */
public class e extends aci {
    public static String a = "material/ground_night.jpg";
    public static String b = "material/ground_day.jpg";
    public static String c = "material/img_skyline_night.png";
    public static String d = "material/img_skyline_day.png";
    public static String e = "material/nightmask.png";
    public static String f = "material/daymask.png";
    public static String g = "material/night_start_mask.png";
    public static String h = "material/day_start_mask.png";
    private la k;
    private la l;
    private la m;
    private la n;
    private la o;
    private la p;
    private la q;
    private boolean t;
    private float i = 3150.0f;
    private float j = this.i * 2.0f;
    private long r = 0;
    private boolean s = false;

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        Log.i("GroundSkyEntityPro", "create");
        this.t = ThemeWatcher.getInstance().isNight();
        h();
        g();
    }

    private void g() {
        float f2 = this.i;
        float f3 = f2 * 2.0f;
        float f4 = f2 * 2.0f;
        float a2 = g.a(e.class);
        nj njVar = new nj();
        kx kxVar = new kx();
        kxVar.a(lf.c(1.0f, 1.0f, 1.0f, 1.0f));
        a(kxVar);
        this.q = new la(njVar.a(f3, 0.001f, f4, kxVar, 27L));
        this.q.f.e(0.0f, a2, 0.0f);
        this.q.f.e(0.0f, 1.0f, 0.0f, 1.5707964f);
        this.q.b.a(0).a(new acm(acm.b));
    }

    private void a(kx kxVar) {
        kxVar.a(ln.a(C().an().a(ThemeWatcher.getInstance().isNight() ? a : b, km.c.RGB888, false)));
    }

    private ky h() {
        ko f2;
        if (this.t) {
            f2 = C().an().f(c);
        } else {
            f2 = C().an().f(d);
        }
        ln a2 = ln.a(f2);
        ln a3 = ln.a(f2);
        ln a4 = ln.a(f2);
        ln a5 = ln.a(f2);
        ln a6 = ln.a(f2);
        ln a7 = ln.a(f2);
        kx kxVar = new kx();
        kxVar.a(a2);
        nh nhVar = new nh();
        nhVar.a(29L, 4);
        ni.a aVar = new ni.a();
        aVar.reset();
        aVar.a(-0.5f, 0.5f, 0.0f);
        aVar.a(0.0f, 0.0f);
        ni.a aVar2 = new ni.a();
        aVar2.reset();
        aVar2.a(0.5f, 0.5f, 0.0f);
        aVar2.a(1.0f, 0.0f);
        ni.a aVar3 = new ni.a();
        aVar3.a(0.5f, -0.5f, 0.0f);
        aVar3.a(1.0f, 1.0f);
        ni.a aVar4 = new ni.a();
        aVar4.reset();
        aVar4.a(-0.5f, -0.5f, 0.0f);
        aVar4.a(0.0f, 1.0f);
        nhVar.a(aVar, aVar4, aVar3, aVar2);
        kj a8 = nhVar.a(new kj(true, nhVar.b(), nhVar.c(), nhVar.d()));
        nj njVar = new nj();
        njVar.a();
        njVar.c().a = "mesh_rect";
        njVar.a("mesh_rect", 4, a8.f(), kxVar).b(a8);
        ky b2 = njVar.b();
        this.k = new la(b2, new Matrix4().a(0.0f, 0.0f, -this.i), "mesh_rect", true);
        Matrix4 matrix4 = this.k.f;
        float f3 = this.j;
        matrix4.f(f3, f3, f3);
        this.k.b.a(0).a(new acm(acm.b));
        this.k.b.a(0).a(a3);
        this.l = new la(b2, new Matrix4().a(0.0f, 0.0f, this.i), "mesh_rect", true);
        this.l.f.c(new p(0.0f, 1.0f, 0.0f), 3.1415927f);
        Matrix4 matrix42 = this.l.f;
        float f4 = this.j;
        matrix42.f(f4, f4, f4);
        this.l.b.a(0).a(a3);
        this.l.b.a(0).a(new acm(acm.b));
        this.m = new la(b2, new Matrix4().a(-this.i, 0.0f, 0.0f), "mesh_rect", true);
        this.m.f.c(new p(0.0f, 1.0f, 0.0f), 1.5707964f);
        Matrix4 matrix43 = this.m.f;
        float f5 = this.j;
        matrix43.f(f5, f5, f5);
        this.m.b.a(0).a(a4);
        this.m.b.a(0).a(new acm(acm.b));
        this.n = new la(b2, new Matrix4().a(this.i, 0.0f, 0.0f), "mesh_rect", true);
        this.n.f.c(new p(0.0f, 1.0f, 0.0f), -1.5707964f);
        Matrix4 matrix44 = this.n.f;
        float f6 = this.j;
        matrix44.f(f6, f6, f6);
        this.n.b.a(0).a(a5);
        this.n.b.a(0).a(new acm(acm.b));
        this.o = new la(b2, new Matrix4().a(0.0f, this.i, 0.0f), "mesh_rect", true);
        this.o.f.c(new p(1.0f, 0.0f, 0.0f), 1.5707964f);
        Matrix4 matrix45 = this.o.f;
        float f7 = this.j;
        matrix45.f(f7, f7, f7);
        this.o.b.a(0).a(a6);
        this.o.b.a(0).a(new acm(acm.b));
        this.p = new la(b2, new Matrix4().a(0.0f, -this.i, 0.0f), "mesh_rect", true);
        this.p.f.c(new p(1.0f, 0.0f, 0.0f), -1.5707964f);
        Matrix4 matrix46 = this.p.f;
        float f8 = this.j;
        matrix46.f(f8, f8, f8);
        this.p.b.a(0).a(a7);
        this.p.b.a(0).a(new acm(acm.b));
        return b2;
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        super.a(kzVar);
        la laVar = this.k;
        if (laVar != null) {
            kzVar.a(laVar);
        }
        la laVar2 = this.l;
        if (laVar2 != null) {
            kzVar.a(laVar2);
        }
        la laVar3 = this.m;
        if (laVar3 != null) {
            kzVar.a(laVar3);
        }
        la laVar4 = this.n;
        if (laVar4 != null) {
            kzVar.a(laVar4);
        }
        la laVar5 = this.o;
        if (laVar5 != null) {
            kzVar.a(laVar5);
        }
        la laVar6 = this.p;
        if (laVar6 != null) {
            kzVar.a(laVar6);
        }
        la laVar7 = this.q;
        if (laVar7 != null) {
            kzVar.a(laVar7);
        }
        if (System.currentTimeMillis() - this.r > 5000) {
            Log.i("GroundSkyEntityPro", "batch.render，绘制地面天际线");
        }
        this.r = System.currentTimeMillis();
    }

    public void e() {
        Log.i("GroundSkyEntityPro", "updateDayMaterial");
        this.q.b.a(0).a(ln.a(C().an().a(b, km.c.RGB888, false)));
        ln a2 = ln.a(C().an().f(d));
        la laVar = this.l;
        if (laVar != null) {
            laVar.b.a(0).a(a2);
        }
        la laVar2 = this.k;
        if (laVar2 != null) {
            laVar2.b.a(0).a(a2);
        }
        la laVar3 = this.m;
        if (laVar3 != null) {
            laVar3.b.a(0).a(a2);
        }
        la laVar4 = this.n;
        if (laVar4 != null) {
            laVar4.b.a(0).a(a2);
        }
        la laVar5 = this.o;
        if (laVar5 != null) {
            laVar5.b.a(0).a(a2);
        }
        la laVar6 = this.p;
        if (laVar6 != null) {
            laVar6.b.a(0).a(a2);
        }
    }

    public void f() {
        Log.i("GroundSkyEntityPro", "updateNightMaterial");
        this.q.b.a(0).a(ln.a(C().an().a(a, km.c.RGB888, false)));
        ln a2 = ln.a(C().an().f(c));
        la laVar = this.l;
        if (laVar != null) {
            laVar.b.a(0).a(a2);
        }
        la laVar2 = this.k;
        if (laVar2 != null) {
            laVar2.b.a(0).a(a2);
        }
        la laVar3 = this.m;
        if (laVar3 != null) {
            laVar3.b.a(0).a(a2);
        }
        la laVar4 = this.n;
        if (laVar4 != null) {
            laVar4.b.a(0).a(a2);
        }
        la laVar5 = this.o;
        if (laVar5 != null) {
            laVar5.b.a(0).a(a2);
        }
        la laVar6 = this.p;
        if (laVar6 != null) {
            laVar6.b.a(0).a(a2);
        }
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        la laVar = this.k;
        if (laVar != null) {
            if (this.t) {
                kzVar.a(laVar, kwVar);
            } else {
                kzVar.a(laVar);
            }
        }
        la laVar2 = this.l;
        if (laVar2 != null) {
            if (this.t) {
                kzVar.a(laVar2, kwVar);
            } else {
                kzVar.a(laVar2);
            }
        }
        la laVar3 = this.m;
        if (laVar3 != null) {
            if (this.t) {
                kzVar.a(laVar3, kwVar);
            } else {
                kzVar.a(laVar3);
            }
        }
        la laVar4 = this.n;
        if (laVar4 != null) {
            if (this.t) {
                kzVar.a(laVar4, kwVar);
            } else {
                kzVar.a(laVar4);
            }
        }
        la laVar5 = this.o;
        if (laVar5 != null) {
            if (this.t) {
                kzVar.a(laVar5, kwVar);
            } else {
                kzVar.a(laVar5);
            }
        }
        la laVar6 = this.p;
        if (laVar6 != null) {
            if (this.t) {
                kzVar.a(laVar6, kwVar);
            } else {
                kzVar.a(laVar6);
            }
        }
        la laVar7 = this.q;
        if (laVar7 != null) {
            kzVar.a(laVar7, kwVar);
        }
    }
}
