package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.parking.view.g3d.d;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: ParkedCarEntity.java */
/* renamed from: uj  reason: default package */
/* loaded from: classes.dex */
public class uj extends uc implements ThemeWatcher.OnThemeSwitchListener {
    protected p a = new p();
    private la b;

    public uj(String str) {
        this.J = str;
    }

    @Override // defpackage.uc, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        kz T = d.q ? ((d) C()).T() : kzVar;
        la laVar = this.b;
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
    }

    public void e() {
        if ((this.L == null || this.K == null) && C().an().c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            this.L = new la(this.K, "model_jiaoche_body", "model_jiaoche_wheel");
            this.b = new la(this.K, "model_shadow", true);
            a(true);
            if (ThemeWatcher.getInstance().isNight()) {
                j();
            } else {
                f();
            }
        }
    }

    @Override // defpackage.aci
    public void a(p pVar, float f) {
        if (k_() == null) {
            return;
        }
        k_().f.c();
        this.h.c();
        this.h.e(pVar.a, pVar.b, pVar.c);
        this.h.c(this.i, (float) ((f / 180.0f) * 3.141592653589793d));
        k_().f.b(this.h);
        la laVar = this.b;
        if (laVar == null) {
            return;
        }
        laVar.f.c();
        this.h.f(1.0f, 1.0f, 0.92f);
        this.b.f.b(this.h);
    }

    private void k() {
        la laVar = this.b;
        if (laVar != null) {
            kx b = laVar.b("mat_shadow");
            le leVar = new le(770, 771);
            leVar.f = 0.7f;
            b.a(leVar);
        }
    }

    public void f() {
        k();
        Log.i("ParkedCarEntity", "updateDayMaterial" + toString());
        lf b = lf.b(0.87058824f, 0.89411765f, 0.9019608f, 1.0f);
        lf c = lf.c(0.95f, 0.95f, 0.95f, 1.0f);
        lf a = lf.a(0.9f, 0.9f, 0.9f, 1.0f);
        lj a2 = lj.a(2.0f);
        if (this.L == null || this.L.b == null || this.L.b.b <= 0) {
            return;
        }
        kx b2 = this.L.b("mat_jiaoche_body");
        b2.c();
        b2.a(b);
        b2.a(c);
        b2.a(a);
        b2.a(a2);
        kx b3 = this.L.b("mat_jiaoche_wheel");
        b3.c();
        b3.a(b);
        b3.a(c);
        b3.a(a);
        b3.a(a2);
    }

    public void j() {
        k();
        Log.i("ParkedCarEntity", "updateNightMaterial" + toString());
        lf b = lf.b(0.2f, 0.28f, 0.4f, 1.0f);
        lf c = lf.c(0.5f, 0.5f, 0.5f, 1.0f);
        lf a = lf.a(0.3f, 0.3f, 0.3f, 1.0f);
        lj a2 = lj.a(2.0f);
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx b2 = this.L.b("mat_jiaoche_body");
        b2.c();
        b2.a(b);
        b2.a(c);
        b2.a(a);
        b2.a(a2);
        kx b3 = this.L.b("mat_jiaoche_wheel");
        b3.c();
        b3.a(b);
        b3.a(c);
        b3.a(a);
        b3.a(a2);
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        if (i == 1) {
            f();
        }
        if (i == 2) {
            j();
        }
    }
}
