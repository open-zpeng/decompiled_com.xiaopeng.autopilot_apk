package defpackage;

import android.text.TextUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.z;
import com.xiaopeng.autopilot.parking.view.g3d.k;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.Iterator;
/* compiled from: UnAvaliableParkLotEntity.java */
/* renamed from: uv  reason: default package */
/* loaded from: classes.dex */
public class uv extends up implements z.a {
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private up f;
    private up g;
    protected la k;
    boolean j = false;
    private Matrix4 a = new Matrix4();

    @Override // defpackage.aci, com.badlogic.gdx.utils.z.a
    public void reset() {
    }

    public uv() {
        this.J = "model/entity/weizhichewei.g3db";
    }

    @Override // defpackage.up, defpackage.aci
    public void a(kz kzVar) {
        int i;
        up upVar;
        up upVar2;
        la k_ = (!this.J.equals("model/entity/weizhichewei.g3db") || (upVar2 = this.g) == null || upVar2.k_() == null) ? null : this.g.k_();
        if (this.J.equals("model/entity/weizhichewei_Lateral.g3db") && (upVar = this.f) != null && upVar.k_() != null) {
            k_ = this.f.k_();
        }
        if (k_ != null) {
            kzVar.a(k_);
        }
        if (this.k != null && G() && ((i = this.b) == 2 || i == -13 || i == -12)) {
            if (!this.e) {
                this.k.f.b(k.a(C().P));
            }
            kzVar.a(this.k);
        } else if (this.k == null || !G()) {
        } else {
            int i2 = this.b;
            if (i2 == -2 || i2 == -1 || i2 == -3) {
                kzVar.a(this.k);
            }
        }
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        int i;
        up upVar;
        up upVar2;
        la k_ = (!this.J.equals("model/entity/weizhichewei.g3db") || (upVar2 = this.g) == null || upVar2.k_() == null) ? null : this.g.k_();
        if (this.J.equals("model/entity/weizhichewei_Lateral.g3db") && (upVar = this.f) != null && upVar.k_() != null) {
            k_ = this.f.k_();
        }
        if (k_ != null) {
            if (kwVar != null) {
                kzVar.a(k_, kwVar);
            } else {
                kzVar.a(k_);
            }
        }
        if (this.k != null && G() && ((i = this.b) == 2 || i == -13 || i == -12)) {
            if (!this.e) {
                this.k.f.b(k.a(C().P));
            }
            kzVar.a(this.k);
        } else if (this.k == null || !G()) {
        } else {
            int i2 = this.b;
            if (i2 == -2 || i2 == -1 || i2 == -3) {
                kzVar.a(this.k);
            }
        }
    }

    @Override // defpackage.up
    public void e() {
        kx b;
        kx b2;
        if (this.J.equals("model/entity/weizhichewei.g3db")) {
            ln a = ln.a(C().an().f("model/entity/day_gray.png"));
            lf b3 = lf.b(1.0f, 1.0f, 1.0f, 1.0f);
            lf c = lf.c(0.392f, 0.392f, 0.392f, 1.0f);
            lf a2 = lf.a(0.31f, 0.31f, 0.31f, 1.0f);
            lf d = lf.d(1.0f, 1.0f, 1.0f, 1.0f);
            lj a3 = lj.a(2.0f);
            le leVar = new le(770, 771);
            if (this.L == null || this.L.b == null || (b2 = this.L.b("mat_weizhichewei")) == null) {
                return;
            }
            b2.c();
            b2.a(b3);
            b2.a(c);
            b2.a(a2);
            b2.a(d);
            b2.a(a3);
            b2.a(leVar);
            b2.a(a);
            return;
        }
        ln a4 = ln.a(C().an().f("model/entity/day_gray.png"));
        lf b4 = lf.b(1.0f, 1.0f, 1.0f, 1.0f);
        lf c2 = lf.c(0.392f, 0.392f, 0.392f, 1.0f);
        lf a5 = lf.a(0.31f, 0.31f, 0.31f, 1.0f);
        lf d2 = lf.d(1.0f, 1.0f, 1.0f, 1.0f);
        lj a6 = lj.a(2.0f);
        le leVar2 = new le(770, 771);
        if (this.L == null || this.L.b == null || (b = this.L.b("mat_weizhichewei")) == null) {
            return;
        }
        b.c();
        b.a(b4);
        b.a(c2);
        b.a(a5);
        b.a(d2);
        b.a(a6);
        b.a(leVar2);
        b.a(a4);
    }

    @Override // defpackage.up
    public void f() {
        kx b;
        kx b2;
        if (this.J.equals("model/entity/weizhichewei.g3db")) {
            ln a = ln.a(C().an().f("model/entity/night_gray.png"));
            lf b3 = lf.b(0.5f, 0.5f, 0.5f, 1.0f);
            lf c = lf.c(0.392f, 0.392f, 0.392f, 1.0f);
            lf a2 = lf.a(0.31f, 0.31f, 0.31f, 1.0f);
            lf d = lf.d(0.5f, 0.5f, 0.5f, 1.0f);
            lj a3 = lj.a(2.0f);
            le leVar = new le(770, 771);
            if (this.L == null || this.L.b == null || (b2 = this.L.b("mat_weizhichewei")) == null) {
                return;
            }
            b2.c();
            b2.a(b3);
            b2.a(c);
            b2.a(a2);
            b2.a(d);
            b2.a(a3);
            b2.a(leVar);
            b2.a(a);
        } else if (this.J.equals("model/entity/weizhichewei_Lateral.g3db")) {
            ln a4 = ln.a(C().an().f("model/entity/night_gray.png"));
            lf b4 = lf.b(0.5f, 0.5f, 0.5f, 1.0f);
            lf c2 = lf.c(0.392f, 0.392f, 0.392f, 1.0f);
            lf a5 = lf.a(0.31f, 0.31f, 0.31f, 1.0f);
            lf d2 = lf.d(0.5f, 0.5f, 0.5f, 1.0f);
            lj a6 = lj.a(2.0f);
            le leVar2 = new le(770, 771);
            if (this.L == null || this.L.b == null || (b = this.L.b("mat_weizhichewei")) == null) {
                return;
            }
            b.c();
            b.a(b4);
            b.a(c2);
            b.a(a5);
            b.a(d2);
            b.a(a6);
            b.a(leVar2);
            b.a(a4);
        }
    }

    @Override // defpackage.up
    public void a(boolean z) {
        if (C() == null) {
            return;
        }
        aca an = C().an();
        if (this.K == null || this.L == null) {
            if (!TextUtils.isEmpty(this.J) && this.J.trim().equals("model/entity/weizhichewei_Lateral.g3db")) {
                if (this.f == null && an.c(this.J)) {
                    this.f = new up();
                    this.f.b("model/entity/weizhichewei_Lateral.g3db");
                    this.f.a(true);
                }
                this.g = null;
                up upVar = this.f;
                if (upVar != null) {
                    this.L = upVar.k_();
                }
            }
            if (!TextUtils.isEmpty(this.J) && this.J.trim().equals("model/entity/weizhichewei.g3db")) {
                if (this.g == null && an.c(this.J)) {
                    this.g = new up();
                    this.g.b("model/entity/weizhichewei.g3db");
                    this.g.a(true);
                }
                this.f = null;
                up upVar2 = this.g;
                if (upVar2 != null) {
                    this.L = upVar2.k_();
                }
            }
            if (this.g == null && this.f == null) {
                return;
            }
            if (z && k_() != null) {
                le leVar = new le(770, 771);
                Iterator<kx> it = k_().b.iterator();
                while (it.hasNext()) {
                    it.next().a(leVar);
                }
            }
            if (ThemeWatcher.getInstance().isNight()) {
                g();
                f();
                return;
            }
            g();
            e();
        }
    }

    public void f(boolean z) {
        kx b;
        kx b2;
        if (this.J.equals("model/entity/weizhichewei.g3db")) {
            if (this.L == null || this.L.b == null || (b2 = this.L.b("mat_weizhichewei")) == null) {
                return;
            }
            le leVar = new le(770, 771);
            if (z) {
                leVar.f = 0.2f;
                b2.a(leVar);
                return;
            }
            leVar.f = 1.0f;
            b2.a(leVar);
        } else if (!this.J.equals("model/entity/weizhichewei_Lateral.g3db") || this.L == null || this.L.b == null || (b = this.L.b("mat_weizhichewei")) == null) {
        } else {
            le leVar2 = new le(770, 771);
            if (z) {
                if (ThemeWatcher.getInstance().isNight()) {
                    leVar2.f = 0.2f;
                } else {
                    leVar2.f = 0.05f;
                }
                b.a(leVar2);
                return;
            }
            if (ThemeWatcher.getInstance().isNight()) {
                leVar2.f = 0.4f;
            } else {
                leVar2.f = 0.25f;
            }
            b.a(leVar2);
        }
    }

    @Override // defpackage.up, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.L == null || this.L.e == null) {
            return;
        }
        this.L.e.dispose();
        this.L = null;
    }

    public void a(la laVar, boolean z, boolean z2) {
        this.k = laVar;
        this.c = z;
        this.d = z2;
    }

    public void g(boolean z) {
        this.e = z;
    }

    public ko a(int i, aca acaVar) {
        this.b = i;
        if (this.c) {
            if (this.d) {
                if (ThemeWatcher.getInstance().isNight()) {
                    return a(acaVar, "material/favourite/day/p_icon_gray.jpg");
                }
                return a(acaVar, "material/favourite/day/p_icon_gray.jpg");
            } else if (ThemeWatcher.getInstance().isNight()) {
                return a(acaVar, "material/favourite/day/p_icon_yellow.jpg");
            } else {
                return a(acaVar, "material/favourite/day/p_icon_yellow.jpg");
            }
        }
        return null;
    }

    private ko a(aca acaVar, String str) {
        return acaVar.f(str);
    }
}
