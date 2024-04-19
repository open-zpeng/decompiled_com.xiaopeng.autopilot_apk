package defpackage;

import android.util.Log;
import android.view.animation.PathInterpolator;
import android.view.animation.Transformation;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.parking.view.g3d.d;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.acf;
/* compiled from: CircleB0Entity.java */
/* renamed from: un  reason: default package */
/* loaded from: classes.dex */
public class un extends aci {
    private acf f;
    private acf g;
    private acf h;
    private acf i;
    private acf j;
    private acf k;
    private Transformation l;
    private Transformation m;
    private Transformation n;
    private la p;
    private ky q;
    private ky r;
    private la s;
    volatile boolean a = false;
    private float c = 0.1f;
    private float d = 0.1f;
    private float e = 0.1f;
    private float o = -1.0f;
    private int t = 300;
    private int u = 1500;
    private int v = 1500;
    le b = new le(770, 771);
    private boolean w = false;
    private boolean x = true;
    private Runnable y = new Runnable() { // from class: un.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("CircleB0Entity", "postBackground-Runnable mHideRunnable");
            un.this.g();
        }
    };

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        i();
        j();
        k();
        h();
    }

    private void h() {
        this.l = new Transformation();
        this.m = new Transformation();
        this.n = new Transformation();
        PathInterpolator pathInterpolator = new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f);
        this.f = acf.b(1.0f, 0.0f);
        this.f.a(this.v);
        this.f.b(1);
        this.f.a(-1);
        this.f.a(pathInterpolator);
        this.f.a(new acf.b() { // from class: un.2
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                un.this.l.setAlpha(((ace) acfVar).e());
            }
        });
        this.f.c(0L);
        this.g = acf.b(1.0f, 0.0f);
        this.g.a(this.v);
        this.g.b(1);
        this.g.a(-1);
        this.g.a(pathInterpolator);
        this.g.a(new acf.b() { // from class: un.3
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                un.this.m.setAlpha(((ace) acfVar).e());
            }
        });
        this.g.c(this.t + 0);
        this.h = acf.b(1.0f, 0.0f);
        this.h.a(this.v);
        this.h.b(1);
        this.h.a(-1);
        this.h.a(pathInterpolator);
        this.h.a(new acf.b() { // from class: un.4
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                un.this.n.setAlpha(((ace) acfVar).e());
            }
        });
        this.h.c((this.t * 2) + 0);
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.33f, 0.0f, 0.5f, 1.0f);
        this.i = acf.b(0.0f, 1.1f);
        this.i.a(this.u);
        this.i.b(1);
        this.i.a(-1);
        this.i.a(pathInterpolator2);
        this.i.a(new acf.b() { // from class: un.5
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                un.this.c = ((ace) acfVar).e();
            }
        });
        this.j = acf.b(0.0f, 0.95f);
        this.j.a(this.u);
        this.j.b(1);
        this.j.a(-1);
        this.j.a(pathInterpolator2);
        this.j.c(this.t);
        this.j.a(new acf.b() { // from class: un.6
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                un.this.d = ((ace) acfVar).e();
            }
        });
        this.k = acf.b(0.0f, 0.8f);
        this.k.a(this.u);
        this.k.b(1);
        this.k.a(-1);
        this.k.a(pathInterpolator2);
        this.k.c(this.t * 2);
        this.k.a(new acf.b() { // from class: un.7
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                un.this.e = ((ace) acfVar).e();
            }
        });
    }

    private void i() {
        nj njVar = new nj();
        njVar.a();
        kx kxVar = new kx();
        njVar.c().a = "rect";
        njVar.a("rect", 4, 29L, kxVar).a(new p(-4.0f, 0.0f, 4.0f), new p(4.0f, 0.0f, 4.0f), new p(4.0f, 0.0f, -4.0f), new p(-4.0f, 0.0f, -4.0f), new p(0.0f, 1.0f, 0.0f));
        this.K = njVar.b();
        this.L = new la(this.K);
    }

    private void j() {
        nj njVar = new nj();
        njVar.a();
        kx kxVar = new kx();
        njVar.c().a = "rect";
        njVar.a("rect", 4, 29L, kxVar).a(new p(-4.0f, 0.0f, 4.0f), new p(4.0f, 0.0f, 4.0f), new p(4.0f, 0.0f, -4.0f), new p(-4.0f, 0.0f, -4.0f), new p(0.0f, 1.0f, 0.0f));
        this.q = njVar.b();
        this.p = new la(this.q);
    }

    private void k() {
        nj njVar = new nj();
        njVar.a();
        kx kxVar = new kx();
        njVar.c().a = "rect";
        njVar.a("rect", 4, 29L, kxVar).a(new p(-4.0f, 0.0f, 4.0f), new p(4.0f, 0.0f, 4.0f), new p(4.0f, 0.0f, -4.0f), new p(-4.0f, 0.0f, -4.0f), new p(0.0f, 1.0f, 0.0f));
        this.r = njVar.b();
        this.s = new la(this.r);
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (d.q) {
            kzVar = ((d) C()).T();
        }
        if (!this.a && ((h) C()).ag() == 34 && this.x) {
            l();
        }
        float a = g.a(un.class);
        if (this.L != null && this.a) {
            float f = this.o;
            if (f == -1.0f) {
                f = 0.0f;
            }
            this.M.c();
            this.M.e(0.0f, a, f);
            Matrix4 matrix4 = this.M;
            float f2 = this.c;
            matrix4.f(f2, f2, f2);
            this.L.f.c();
            this.L.f.b(this.M);
            m();
            kzVar.a(this.L);
        }
        if (this.p != null && this.a) {
            float f3 = this.o;
            if (f3 == -1.0f) {
                f3 = 0.0f;
            }
            this.M.c();
            this.M.e(0.0f, a, f3);
            Matrix4 matrix42 = this.M;
            float f4 = this.d;
            matrix42.f(f4, f4, f4);
            this.p.f.c();
            this.p.f.b(this.M);
            m();
            kzVar.a(this.p);
        }
        if (this.s == null || !this.a) {
            return;
        }
        float f5 = this.o;
        if (f5 == -1.0f) {
            f5 = 0.0f;
        }
        this.M.c();
        this.M.e(0.0f, a, f5);
        Matrix4 matrix43 = this.M;
        float f6 = this.e;
        matrix43.f(f6, f6, f6);
        this.s.f.c();
        this.s.f.b(this.M);
        m();
        kzVar.a(this.s);
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }

    public void e() {
        le leVar = new le(770, 771);
        this.L.b.a(0).a(new acm(acm.b));
        this.L.b.a(0).a(leVar);
        this.p.b.a(0).a(new acm(acm.b));
        this.p.b.a(0).a(leVar);
        this.s.b.a(0).a(new acm(acm.b));
        this.s.b.a(0).a(leVar);
        Log.i("CircleB0Entity", "onLoaded.isVisiable = " + G());
    }

    public void f() {
        Log.i("CircleB0Entity", "start.mRunning = " + this.a);
        this.a = false;
        this.x = true;
        Log.i("CircleB0Entity", "start.isVisiable = " + G());
    }

    private void l() {
        Log.i("CircleB0Entity", "startAnimation.mRunning = " + this.a);
        if (this.f != null && !this.a) {
            this.f.a();
        }
        if (this.g != null && !this.a) {
            this.g.a();
        }
        if (this.h != null && !this.a) {
            this.h.a();
        }
        if (this.i != null && !this.a) {
            this.i.a();
        }
        if (this.j != null && !this.a) {
            this.j.a();
        }
        if (this.k != null && !this.a) {
            this.k.a();
        }
        this.a = true;
        rh.a().g(this.y);
        rh.a().d(this.y, 3000L);
    }

    public void g() {
        Log.i("CircleB0Entity", "stop.mRunning = " + this.a);
        rh.a().g(this.y);
        i(false);
        this.x = false;
        if (this.f != null && this.a) {
            this.f.b();
        }
        if (this.g != null && this.a) {
            this.g.b();
        }
        if (this.h != null && this.a) {
            this.h.b();
        }
        if (this.i != null && this.a) {
            this.i.b();
        }
        if (this.j != null && this.a) {
            this.j.b();
        }
        if (this.k != null && this.a) {
            this.k.b();
        }
        this.a = false;
    }

    private void m() {
        if (this.a) {
            this.b.f = this.l.getAlpha();
            this.L.b.a(0).a(this.b);
            this.b.f = this.m.getAlpha();
            this.p.b.a(0).a(this.b);
            this.b.f = this.n.getAlpha();
            this.s.b.a(0).a(this.b);
        }
    }

    public void a(float f) {
        this.o = f;
    }

    public void a(boolean z) {
        ko f;
        this.w = z;
        if (ThemeWatcher.getInstance().isNight()) {
            f = Y.an().f(z ? "material/im_circle_night_b0_left.png" : "material/im_circle_night_b0_right.png");
        } else {
            f = Y.an().f(z ? "material/im_circle_light_b0_left.png" : "material/im_circle_light_b0_right.png");
        }
        ln a = ln.a(f);
        this.L.b.a(0).a(a);
        this.p.b.a(0).a(a);
        this.s.b.a(0).a(a);
    }
}
