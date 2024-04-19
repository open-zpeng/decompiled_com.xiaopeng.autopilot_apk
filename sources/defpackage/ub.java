package defpackage;

import android.util.Log;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.view.g3d.d;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.autopilot.parking.view.g3d.h;
/* compiled from: ArrowEntity.java */
/* renamed from: ub  reason: default package */
/* loaded from: classes.dex */
public class ub extends aci {
    Animation<ko> a;
    ko[] b = null;
    float c = 0.06f;
    volatile boolean d = true;
    float e = 0.0f;
    p f = new p();
    private Runnable g;
    private float h;
    private int i;
    private boolean j;

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        j();
        e();
    }

    public void e() {
        PerformanceTestUnit.logStart("ArrowEntity");
        this.b = new ko[19];
        System.currentTimeMillis();
        for (int i = 0; i < 19; i++) {
            in inVar = io.e;
            this.b[i] = new ko(inVar.internal("material/animation/arrow/" + (String.format("arrow_light_000%d", Integer.valueOf(i)) + ".png")));
        }
        this.a = new Animation<>(this.c, this.b);
        this.a.setPlayMode(Animation.PlayMode.LOOP);
        PerformanceTestUnit.logEnd("ArrowEntity", "createAninatio.arrow");
    }

    private void j() {
        nj njVar = new nj();
        njVar.a();
        kx kxVar = new kx();
        kxVar.a(ln.a(new ko(io.e.internal("material/p_icon_blue.jpg"))));
        njVar.c().a = "rect";
        njVar.a("rect", 4, 29L, kxVar).a(new p(-1.0f, 0.0f, 1.0f), new p(1.0f, 0.0f, 1.0f), new p(1.0f, 0.0f, -1.0f), new p(-1.0f, 0.0f, -1.0f), new p(0.0f, 1.0f, 0.0f));
        this.K = njVar.b();
        this.L = new la(this.K);
        le leVar = new le(770, 771);
        leVar.f = 0.75f;
        this.L.b.a(0).a(new acm(acm.b));
        this.L.b.a(0).a(leVar);
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (d.q) {
            kzVar = ((d) C()).U();
        }
        if (((h) Y).P() == 1) {
            if (this.L == null || !this.d) {
                return;
            }
            k();
            this.e += io.b.getDeltaTime();
            b(this.e);
            kzVar.a(this.L);
        } else if ((((h) Y).P() == -4 || ((h) Y).P() == -15 || ((h) Y).P() == -16) && this.L != null && this.d) {
            g.a(ub.class);
            this.M.c();
            this.M.e(0.0f, 0.0f, -7.544593f);
            this.M.d(0.0f, 1.0f, 0.0f, 180.0f);
            this.L.f.c();
            this.L.f.b(this.M);
            this.e += io.b.getDeltaTime();
            b(this.e);
            kzVar.a(this.L);
        }
    }

    private void k() {
        if (this.i == 3) {
            float a = g.a(ub.class);
            this.L.f.a(this.f);
            if (this.f.b != a || this.f.c != 3.0864244f) {
                this.M.c();
                this.M.e(0.0f, a, 3.0864244f);
                this.L.f.c();
                this.L.f.b(this.M);
            }
        }
        if (this.i == 1) {
            this.L.f.a(this.f);
            if (this.f.b == 0.0f && this.f.c == -7.544593f) {
                return;
            }
            this.M.c();
            this.M.e(0.0f, 0.0f, -7.544593f);
            this.M.d(0.0f, 1.0f, 0.0f, 180.0f);
            this.L.f.c();
            this.L.f.b(this.M);
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        ko[] koVarArr = this.b;
        if (koVarArr != null && koVarArr.length > 0) {
            int length = koVarArr.length;
            for (int i = 0; i < length; i++) {
                this.b[i].dispose();
            }
            this.b = null;
        }
        super.dispose();
    }

    public void f() {
        Log.i("ArrowEntity", "onLoaded");
        le leVar = new le(770, 771);
        leVar.f = 0.75f;
        this.L.b.a(0).a(new acm(acm.b));
        this.L.b.a(0).a(leVar);
    }

    public void g() {
        this.e = 0.0f;
        this.d = true;
        Log.i("ArrowEntity", "start()");
    }

    public void h() {
        this.e = 0.0f;
        this.d = false;
        Log.i("ArrowEntity", "stop()");
    }

    private void b(float f) {
        if (this.d) {
            this.L.b.a(0).a(ln.a(this.a.getKeyFrame(f, true)));
        }
    }

    public void a(int i) {
        this.i = i;
        l();
    }

    public void a(float f) {
        this.h = f;
        if (this.j && this.h > 0.0f && ((h) Y).P() == 1) {
            l();
        }
    }

    private void l() {
        float a = g.a(ub.class);
        if (this.h == 0.0f) {
            this.j = true;
            return;
        }
        int i = this.i;
        if (i == 3) {
            this.M.c();
            this.M.e(0.0f, a, 3.0864244f);
            this.L.f.c();
            this.L.f.b(this.M);
        } else if (i == 1) {
            this.M.c();
            this.M.e(0.0f, 0.0f, -7.544593f);
            this.M.d(0.0f, 1.0f, 0.0f, 180.0f);
            this.L.f.c();
            this.L.f.b(this.M);
        }
        g();
        this.j = false;
        if (this.g != null) {
            rh.a().g(this.g);
        }
        rh a2 = rh.a();
        Runnable runnable = new Runnable() { // from class: ub.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ArrowEntity", "postBackground-Runnable mStopRunnable");
                ub.this.h();
            }
        };
        this.g = runnable;
        a2.c(runnable, 4500L);
    }

    public boolean i() {
        return this.d;
    }
}
