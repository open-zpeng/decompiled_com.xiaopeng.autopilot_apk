package defpackage;

import android.util.Log;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.autopilot.base.g;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: PathArrowEntity.java */
/* renamed from: sq  reason: default package */
/* loaded from: classes.dex */
public class sq extends sl {
    private static String g = "PathArrowEntity";
    private int h;

    @Override // defpackage.sl
    public void a(float f) {
    }

    public sq(int i) {
        this.J = g.a.get(Integer.valueOf(i));
        this.h = i;
    }

    public int l() {
        return this.h;
    }

    @Override // defpackage.sl, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.L = null;
        this.f = null;
        this.e = null;
    }

    @Override // defpackage.sl
    public void k() {
        aca an = C().an();
        if ((this.K == null || this.L == null) && an.c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            try {
                this.L = new la(this.K);
            } catch (k e) {
                e.printStackTrace();
                Log.e(g, "init pathArrowEntity error!");
            }
            if (ThemeWatcher.getInstance().isNight()) {
                f();
            } else {
                e();
            }
        }
    }

    @Override // defpackage.sl
    public void e() {
        m();
    }

    @Override // defpackage.sl
    public void f() {
        m();
    }

    private void m() {
        lf b = lf.b(0.482f, 0.545f, 0.655f, 1.0f);
        a<kx> aVar = k_().b;
        try {
            if (aVar.b > 0) {
                for (int i = 0; i < aVar.b; i++) {
                    kx a = aVar.a(i);
                    a.c();
                    a.a(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
