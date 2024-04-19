package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.animation.PathInterpolator;
import android.view.animation.Transformation;
import com.badlogic.gdx.math.g;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.autopilot.parking.view.g3d.k;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.acf;
import defpackage.ko;
/* compiled from: SelectedParkLotEntity.java */
/* renamed from: uu  reason: default package */
/* loaded from: classes.dex */
public class uu extends up {
    private la a;
    private int b;
    private up c;
    private up d;
    private acf e;
    private Transformation f;
    private boolean g = false;
    private int j = 1500;
    private boolean k;

    public uu() {
        this.J = "model/entity/xuanzhongchewei.g3db";
        h();
    }

    public void a(la laVar, boolean z) {
        this.a = laVar;
        this.k = z;
    }

    @Override // defpackage.up, defpackage.aci
    public void a(kz kzVar) {
        int i;
        up upVar;
        up upVar2;
        if (this.J.equals("model/entity/xuanzhongchewei.g3db") && (upVar2 = this.c) != null && upVar2.k_() != null) {
            kzVar.a(this.c.k_());
        }
        if (this.J.equals("model/entity/xuanzhongchewei_Lateral.g3db") && (upVar = this.d) != null && upVar.k_() != null) {
            kzVar.a(this.d.k_());
        }
        if (this.a != null && ((i = this.b) == 3 || i == -9 || i == -13)) {
            this.a.f.b(k.a(C().P));
            kzVar.a(this.a);
        }
        if (this.L == null || !this.g) {
            return;
        }
        le leVar = new le(770, 771);
        leVar.f = this.f.getAlpha();
        this.L.b("mat_xuanzhongchewei").a(leVar);
    }

    public ko a(int i, aca acaVar) {
        int x = x() + 1;
        this.b = i;
        if (x < 1 || x > 6) {
            return null;
        }
        if (this.k) {
            if (ThemeWatcher.getInstance().isNight()) {
                return a(acaVar, "material/favourite/day/p_icon_yellow.jpg");
            }
            return a(acaVar, "material/favourite/day/p_icon_yellow.jpg");
        } else if (ThemeWatcher.getInstance().isNight()) {
            return a(acaVar, "model/entity/p_icon_blue.jpg");
        } else {
            return a(acaVar, "material/p_icon_blue.jpg");
        }
    }

    private ko a(aca acaVar, String str) {
        return acaVar.f(str);
    }

    @Override // defpackage.up
    public void e() {
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx b = this.L.b("mat_xuanzhongchewei");
        ko k = k();
        if (k == null) {
            return;
        }
        k.setFilter(ko.a.Linear, ko.a.Linear);
        k.setFilter(ko.a.Nearest, ko.a.Nearest);
        ln a = ln.a(k);
        lf.b(0.011f, 0.58f, 0.88f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf c2 = lf.c(0.0f, 0.0f, 0.0f, 1.0f);
        lf c3 = lf.c(0.0f, 0.0f, 0.0f, 1.0f);
        lj a2 = lj.a(2.0f);
        if (b != null) {
            if (!d.n()) {
                b.c();
            }
            b.a(c);
            b.a(c2);
            b.a(c3);
            b.a(a2);
            b.a(a);
        }
    }

    public void h() {
        PathInterpolator pathInterpolator = new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f);
        this.f = new Transformation();
        this.e = acf.b(0.3f, 0.9f, 0.3f);
        this.e.a(this.j);
        this.e.b(1);
        this.e.a(-1);
        this.e.a(pathInterpolator);
        this.e.a(new acf.b() { // from class: uu.1
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uu.this.f.setAlpha(((ace) acfVar).e());
            }
        });
    }

    public void i() {
        if (this.g) {
            return;
        }
        acf acfVar = this.e;
        if (acfVar != null) {
            acfVar.a();
        }
        this.g = true;
    }

    public void j() {
        if (this.g) {
            acf acfVar = this.e;
            if (acfVar != null) {
                acfVar.b();
            }
            this.g = false;
        }
    }

    public ko k() {
        int P = ((h) C()).P();
        if (P == 1 || P == -10) {
            if (ThemeWatcher.getInstance().isNight()) {
                return C().an().f("material/parkingb/night/map_parking_cyan.png");
            }
            return C().an().f("material/parkingb/day/map_parking_cyan.png");
        } else if (ThemeWatcher.getInstance().isNight()) {
            return C().an().f("model/entity/map_parking_cyan.png");
        } else {
            return C().an().f("material/map_parking_cyan.png");
        }
    }

    @Override // defpackage.up
    public void f() {
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx b = this.L.b("mat_xuanzhongchewei");
        ko k = k();
        if (k == null) {
            return;
        }
        k.setFilter(ko.a.Linear, ko.a.Linear);
        k.setFilter(ko.a.Nearest, ko.a.Nearest);
        ln a = ln.a(k);
        lf.b(0.011f, 0.58f, 0.88f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf c2 = lf.c(0.0f, 0.0f, 0.0f, 1.0f);
        lf c3 = lf.c(0.0f, 0.0f, 0.0f, 1.0f);
        lj a2 = lj.a(2.0f);
        if (b != null) {
            if (!d.n()) {
                b.c();
            }
            b.a(c);
            b.a(c2);
            b.a(c3);
            b.a(a2);
            b.a(a);
        }
    }

    @Override // defpackage.up
    public void a(boolean z) {
        aca an = C().an();
        if (an.c(this.J)) {
            if (!TextUtils.isEmpty(this.J) && this.J.trim().equals("model/entity/xuanzhongchewei.g3db")) {
                if (this.c == null && an.c(this.J)) {
                    this.c = new up();
                    this.c.b("model/entity/xuanzhongchewei.g3db");
                    this.c.a(true);
                }
                this.L = this.c.k_();
            }
            if (!TextUtils.isEmpty(this.J) && this.J.trim().equals("model/entity/xuanzhongchewei_Lateral.g3db")) {
                if (this.d == null && an.c(this.J)) {
                    this.d = new up();
                    this.d.b("model/entity/xuanzhongchewei_Lateral.g3db");
                    this.d.a(true);
                }
                this.L = this.d.k_();
            }
            if (ThemeWatcher.getInstance().isNight()) {
                f();
            } else {
                e();
            }
        }
    }

    @Override // defpackage.up, defpackage.aci
    public boolean a(jz jzVar, int i, int i2) {
        Log.i("SelectedParkLotEntity", "isTouched");
        boolean z = false;
        boolean a = this.L != null ? super.a(jzVar, i, i2) : false;
        la laVar = this.a;
        if (laVar != null) {
            laVar.a(E());
            oa a2 = jzVar.a(i, i2);
            this.O.a(this.a.f);
            z = g.a(a2, this.O);
        }
        return a | z;
    }
}
