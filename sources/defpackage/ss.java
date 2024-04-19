package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: PillarEntity.java */
/* renamed from: ss  reason: default package */
/* loaded from: classes.dex */
public class ss extends sl {
    @Override // defpackage.sl
    public void a(float f) {
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        this.J = "model/pillar/model_column.g3db";
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        if (this.L != null) {
            kzVar.a(this.L);
        }
    }

    @Override // defpackage.sl, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        super.a(kzVar, kwVar);
    }

    @Override // defpackage.sl, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.L = null;
        this.f = null;
        this.e = null;
    }

    @Override // defpackage.sl
    public void e() {
        ko f = C().an().f("model/pillar/column.png");
        if (f != null) {
            ln a = ln.a(f);
            kx a2 = this.L.b.a(0);
            a2.a(a);
            a2.a(lf.b(0.92f, 0.92f, 0.94f, 1.0f));
        }
    }

    @Override // defpackage.sl
    public void f() {
        this.L.b.a(0).a(lf.b(0.22f, 0.22f, 0.3f, 1.0f));
    }

    public void b(boolean z) {
        aca an = C().an();
        if ((this.K == null || this.L == null) && an.c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            try {
                this.L = new la(this.K);
            } catch (k e) {
                e.printStackTrace();
                Log.e("PillarEntity", "init pillarEntity error!");
            }
            if (z) {
                le leVar = new le(770, 771);
                a<kx> aVar = k_().b;
                try {
                    if (aVar.b > 0) {
                        for (int i = 0; i < aVar.b; i++) {
                            aVar.a(i).a(leVar);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (ThemeWatcher.getInstance().isNight()) {
                f();
            } else {
                e();
            }
        }
    }

    @Override // defpackage.sl
    public boolean a(p pVar) {
        return (this.e != null ? pVar.d(this.e) : 0.0f) < 11.5f;
    }
}
