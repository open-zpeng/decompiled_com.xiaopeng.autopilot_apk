package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.km;
import defpackage.ni;
/* compiled from: GroundSkyEntity.java */
/* renamed from: ug  reason: default package */
/* loaded from: classes.dex */
public class ug extends aci {
    public static String a = "material/ground_night.jpg";
    public static String b = "material/ground_day.jpg";
    public static String c = "material/img_skyline_night.png";
    public static String d = "material/img_skyline_day.png";
    public static String e = "material/nightmask.png";
    public static String f = "material/daymask.png";
    public static String g = "material/nightmask_clear.png";
    public static String h = "material/daymask_clear.png";
    public static String i = "material/night_start_mask.png";
    public static String j = "material/day_start_mask.png";
    private la m;
    private la n;
    private la o;
    private la p;
    private la q;
    private la r;
    private la s;
    private boolean v;
    private float k = 35.0f;
    private float l = this.k * 2.0f;
    private long t = 0;
    private boolean u = false;

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        Log.i("GroundSkyEntity", "create");
        this.v = ThemeWatcher.getInstance().isNight();
        h();
        g();
    }

    private void g() {
        float f2 = this.k;
        float f3 = f2 * 2.0f;
        float f4 = f2 * 2.0f;
        float a2 = g.a(ug.class);
        nj njVar = new nj();
        kx kxVar = new kx();
        kxVar.a(lf.c(1.0f, 1.0f, 1.0f, 1.0f));
        a(kxVar);
        this.s = new la(njVar.a(f3, 0.001f, f4, kxVar, 27L));
        this.s.f.e(0.0f, a2, 0.0f);
        this.s.f.e(0.0f, 1.0f, 0.0f, 1.5707964f);
        this.s.b.a(0).a(new acm(acm.b));
    }

    private void a(kx kxVar) {
        kxVar.a(ln.a(C().an().a(ThemeWatcher.getInstance().isNight() ? a : b, km.c.RGB888, false)));
    }

    private ky h() {
        ko f2;
        if (this.v) {
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
        this.m = new la(b2, new Matrix4().a(0.0f, 0.0f, -this.k), "mesh_rect", true);
        Matrix4 matrix4 = this.m.f;
        float f3 = this.l;
        matrix4.f(f3, f3, f3);
        this.m.b.a(0).a(new acm(acm.b));
        this.m.b.a(0).a(a3);
        this.n = new la(b2, new Matrix4().a(0.0f, 0.0f, this.k), "mesh_rect", true);
        this.n.f.c(new p(0.0f, 1.0f, 0.0f), 3.1415927f);
        Matrix4 matrix42 = this.n.f;
        float f4 = this.l;
        matrix42.f(f4, f4, f4);
        this.n.b.a(0).a(a3);
        this.n.b.a(0).a(new acm(acm.b));
        this.o = new la(b2, new Matrix4().a(-this.k, 0.0f, 0.0f), "mesh_rect", true);
        this.o.f.c(new p(0.0f, 1.0f, 0.0f), 1.5707964f);
        Matrix4 matrix43 = this.o.f;
        float f5 = this.l;
        matrix43.f(f5, f5, f5);
        this.o.b.a(0).a(a4);
        this.o.b.a(0).a(new acm(acm.b));
        this.p = new la(b2, new Matrix4().a(this.k, 0.0f, 0.0f), "mesh_rect", true);
        this.p.f.c(new p(0.0f, 1.0f, 0.0f), -1.5707964f);
        Matrix4 matrix44 = this.p.f;
        float f6 = this.l;
        matrix44.f(f6, f6, f6);
        this.p.b.a(0).a(a5);
        this.p.b.a(0).a(new acm(acm.b));
        this.q = new la(b2, new Matrix4().a(0.0f, this.k, 0.0f), "mesh_rect", true);
        this.q.f.c(new p(1.0f, 0.0f, 0.0f), 1.5707964f);
        Matrix4 matrix45 = this.q.f;
        float f7 = this.l;
        matrix45.f(f7, f7, f7);
        this.q.b.a(0).a(a6);
        this.q.b.a(0).a(new acm(acm.b));
        this.r = new la(b2, new Matrix4().a(0.0f, -this.k, 0.0f), "mesh_rect", true);
        this.r.f.c(new p(1.0f, 0.0f, 0.0f), -1.5707964f);
        Matrix4 matrix46 = this.r.f;
        float f8 = this.l;
        matrix46.f(f8, f8, f8);
        this.r.b.a(0).a(a7);
        this.r.b.a(0).a(new acm(acm.b));
        return b2;
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        super.a(kzVar);
        la laVar = this.m;
        if (laVar != null) {
            kzVar.a(laVar);
        }
        la laVar2 = this.n;
        if (laVar2 != null) {
            kzVar.a(laVar2);
        }
        la laVar3 = this.o;
        if (laVar3 != null) {
            kzVar.a(laVar3);
        }
        la laVar4 = this.p;
        if (laVar4 != null) {
            kzVar.a(laVar4);
        }
        la laVar5 = this.q;
        if (laVar5 != null) {
            kzVar.a(laVar5);
        }
        la laVar6 = this.r;
        if (laVar6 != null) {
            kzVar.a(laVar6);
        }
        la laVar7 = this.s;
        if (laVar7 != null) {
            kzVar.a(laVar7);
        }
        if (System.currentTimeMillis() - this.t > 5000) {
            Log.i("GroundSkyEntity", "batch.render，绘制地面天际线");
        }
        this.t = System.currentTimeMillis();
    }

    public void e() {
        Log.i("GroundSkyEntity", "updateDayMaterial");
        this.s.b.a(0).a(ln.a(C().an().a(b, km.c.RGB888, false)));
        ln a2 = ln.a(C().an().f(d));
        la laVar = this.n;
        if (laVar != null) {
            laVar.b.a(0).a(a2);
        }
        la laVar2 = this.m;
        if (laVar2 != null) {
            laVar2.b.a(0).a(a2);
        }
        la laVar3 = this.o;
        if (laVar3 != null) {
            laVar3.b.a(0).a(a2);
        }
        la laVar4 = this.p;
        if (laVar4 != null) {
            laVar4.b.a(0).a(a2);
        }
        la laVar5 = this.q;
        if (laVar5 != null) {
            laVar5.b.a(0).a(a2);
        }
        la laVar6 = this.r;
        if (laVar6 != null) {
            laVar6.b.a(0).a(a2);
        }
    }

    public void f() {
        Log.i("GroundSkyEntity", "updateNightMaterial");
        this.s.b.a(0).a(ln.a(C().an().a(a, km.c.RGB888, false)));
        ln a2 = ln.a(C().an().f(c));
        la laVar = this.n;
        if (laVar != null) {
            laVar.b.a(0).a(a2);
        }
        la laVar2 = this.m;
        if (laVar2 != null) {
            laVar2.b.a(0).a(a2);
        }
        la laVar3 = this.o;
        if (laVar3 != null) {
            laVar3.b.a(0).a(a2);
        }
        la laVar4 = this.p;
        if (laVar4 != null) {
            laVar4.b.a(0).a(a2);
        }
        la laVar5 = this.q;
        if (laVar5 != null) {
            laVar5.b.a(0).a(a2);
        }
        la laVar6 = this.r;
        if (laVar6 != null) {
            laVar6.b.a(0).a(a2);
        }
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        la laVar = this.m;
        if (laVar != null) {
            if (this.v) {
                kzVar.a(laVar, kwVar);
            } else {
                kzVar.a(laVar);
            }
        }
        la laVar2 = this.n;
        if (laVar2 != null) {
            if (this.v) {
                kzVar.a(laVar2, kwVar);
            } else {
                kzVar.a(laVar2);
            }
        }
        la laVar3 = this.o;
        if (laVar3 != null) {
            if (this.v) {
                kzVar.a(laVar3, kwVar);
            } else {
                kzVar.a(laVar3);
            }
        }
        la laVar4 = this.p;
        if (laVar4 != null) {
            if (this.v) {
                kzVar.a(laVar4, kwVar);
            } else {
                kzVar.a(laVar4);
            }
        }
        la laVar5 = this.q;
        if (laVar5 != null) {
            if (this.v) {
                kzVar.a(laVar5, kwVar);
            } else {
                kzVar.a(laVar5);
            }
        }
        la laVar6 = this.r;
        if (laVar6 != null) {
            if (this.v) {
                kzVar.a(laVar6, kwVar);
            } else {
                kzVar.a(laVar6);
            }
        }
        la laVar7 = this.s;
        if (laVar7 != null) {
            kzVar.a(laVar7, kwVar);
        }
    }
}
