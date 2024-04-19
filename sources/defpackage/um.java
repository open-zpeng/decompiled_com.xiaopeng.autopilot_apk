package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.autopilot.parking.view.g3d.k;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: AvailableParkLotEntity.java */
/* renamed from: um  reason: default package */
/* loaded from: classes.dex */
public class um extends up {
    protected la a;
    protected up b;
    protected up c;
    private la d;
    private int e;
    private boolean f;
    private la g;

    public la a(ur urVar) {
        this.g = urVar.k_();
        return this.g;
    }

    public void a(la laVar, boolean z) {
        this.d = laVar;
        this.f = z;
    }

    public void a(la laVar) {
        this.g = laVar;
    }

    public void b(la laVar) {
        this.a = laVar;
    }

    public um() {
        this.J = "model/entity/kebochewei.g3db";
    }

    @Override // defpackage.up, defpackage.aci
    public void a(kz kzVar) {
        int i;
        int i2;
        up upVar;
        up upVar2;
        if (this.J.equals("model/entity/kebochewei.g3db") && (upVar2 = this.b) != null && upVar2.k_() != null) {
            kzVar.a(this.c.k_());
        }
        if (this.J.equals("model/entity/kebochewei_Lateral.g3db") && (upVar = this.c) != null && upVar.k_() != null) {
            kzVar.a(this.b.k_());
        }
        if (this.d != null && G() && ((i2 = this.e) == 2 || i2 == -2 || i2 == -1 || i2 == -3 || i2 == -11 || i2 == -12 || i2 == -13)) {
            this.d.f.b(k.a(C().P));
            kzVar.a(this.d);
        }
        if (this.a != null && G() && ((i = this.e) == 3 || i == -9 || i == -12 || i == -13)) {
            kzVar.a(this.a);
        }
        if (this.g == null || !G()) {
            return;
        }
        int i3 = this.e;
        if ((i3 == 3 || i3 == -9 || i3 == -12) && this.f) {
            kzVar.a(this.g);
        }
    }

    public void a(kz kzVar, kz kzVar2, jz jzVar) {
        int i;
        int i2;
        int i3;
        up upVar;
        up upVar2;
        if (this.J.equals("model/entity/kebochewei.g3db") && (upVar2 = this.b) != null && upVar2.k_() != null) {
            kzVar.a(this.c.k_());
        }
        if (this.J.equals("model/entity/kebochewei_Lateral.g3db") && (upVar = this.c) != null && upVar.k_() != null) {
            kzVar.a(this.b.k_());
        }
        if (this.d != null && G() && ((i3 = this.e) == 2 || i3 == -2 || i3 == -1 || i3 == -3 || i3 == -11 || i3 == -12)) {
            this.d.f.b(k.a(C().P));
            kzVar2.a(this.d);
        }
        if (this.a != null && G() && ((i2 = this.e) == 3 || i2 == -9 || i2 == -13)) {
            kzVar.a(this.a);
        }
        if (this.g != null && G() && (((i = this.e) == 3 || i == -9 || i == -12) && this.f)) {
            kzVar.a(this.g);
        }
        super.a(kzVar);
    }

    public ko a(int i, aca acaVar) {
        this.e = i;
        if (this.f) {
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

    public la a(int i, us usVar) {
        this.e = i;
        int x = x() + 1;
        Log.i("AvailableParkLotEntity", "curentIndex = " + x + "," + i + "," + usVar);
        if ((i == 3 || i == -9 || i == -13) && x >= 1 && x <= 6) {
            switch (x) {
                case 1:
                    usVar.a("model/entity/model_one.g3db");
                    break;
                case 2:
                    usVar.a("model/entity/model_two.g3db");
                    break;
                case 3:
                    usVar.a("model/entity/model_three.g3db");
                    break;
                case 4:
                    usVar.a("model/entity/model_four.g3db");
                    break;
                case 5:
                    usVar.a("model/entity/model_five.g3db");
                    break;
                case 6:
                    usVar.a("model/entity/model_six.g3db");
                    break;
            }
            return usVar.k_();
        }
        return null;
    }

    private ko a(aca acaVar, String str) {
        return acaVar.f(str);
    }

    @Override // defpackage.up
    public void e() {
        lf b = lf.b(0.0f, 0.7490196f, 1.0f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf a = lf.a(0.0f, 0.0f, 0.0f, 1.0f);
        le leVar = new le(770, 771);
        lf b2 = lf.b(0.27058825f, 0.78039217f, 0.9843137f, 1.0f);
        lf c2 = lf.c(0.0f, 0.0f, 0.0f, 1.0f);
        lf a2 = lf.a(0.0f, 0.0f, 0.0f, 1.0f);
        lf a3 = lf.a(0.0f, 0.0f, 0.0f, 1.0f);
        lj a4 = lj.a(1.0717734f);
        le leVar2 = new le(770, 771);
        leVar2.f = 0.2f;
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx b3 = this.L.b("mat_kebochewei_kuang");
        if (b3 != null) {
            b3.c();
            b3.a(b);
            b3.a(c);
            b3.a(a);
            b3.a(leVar);
        }
        kx b4 = this.L.b("mat_kebochewei_pian");
        if (b4 != null) {
            b4.c();
            b4.a(b2);
            b4.a(c2);
            b4.a(a2);
            b4.a(a3);
            b4.a(a4);
            b4.a(leVar2);
        }
    }

    @Override // defpackage.up
    public void f() {
        lf b = lf.b(0.05490196f, 0.59607846f, 0.76862746f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf a = lf.a(0.0f, 0.06f, 0.215f, 1.0f);
        le leVar = new le(770, 771);
        lf b2 = lf.b(0.0f, 0.627f, 1.0f, 1.0f);
        lf c2 = lf.c(0.0f, 0.0f, 0.0f, 1.0f);
        lf a2 = lf.a(0.0f, 0.0f, 0.0f, 1.0f);
        lf a3 = lf.a(0.0f, 0.0f, 0.0f, 1.0f);
        lj a4 = lj.a(1.0717734f);
        le leVar2 = new le(770, 771);
        leVar2.f = 0.1f;
        if (this.L == null || this.L.b == null || this.L.b.a(0) == null) {
            return;
        }
        kx b3 = this.L.b("mat_kebochewei_kuang");
        if (b3 != null) {
            b3.c();
            b3.a(b);
            b3.a(c);
            b3.a(a);
            b3.a(leVar);
        }
        kx b4 = this.L.b("mat_kebochewei_pian");
        if (b4 != null) {
            b4.c();
            b4.a(b2);
            b4.a(c2);
            b4.a(a2);
            b4.a(a3);
            b4.a(a4);
            b4.a(leVar2);
        }
    }

    @Override // defpackage.up
    public void g() {
        super.g();
        if (this.L == null || this.L.b == null || this.L.b.a(0) == null) {
            return;
        }
        this.L.b.a(0).c();
    }

    @Override // defpackage.up
    public void a(boolean z) {
        aca an = C().an();
        if (!TextUtils.isEmpty(this.J) && this.J.trim().equals("model/entity/kebochewei_Lateral.g3db")) {
            if (this.b == null && an.c(this.J)) {
                this.b = new up();
                this.b.b("model/entity/kebochewei_Lateral.g3db");
                this.b.a(true);
            }
            this.c = null;
            up upVar = this.b;
            if (upVar != null) {
                this.L = upVar.k_();
            }
        }
        if (!TextUtils.isEmpty(this.J) && this.J.trim().equals("model/entity/kebochewei.g3db")) {
            if (this.c == null && an.c(this.J)) {
                this.c = new up();
                this.c.b("model/entity/kebochewei.g3db");
                this.c.a(true);
            }
            this.b = null;
            up upVar2 = this.c;
            if (upVar2 != null) {
                this.L = upVar2.k_();
            }
        }
        if (ThemeWatcher.getInstance().isNight()) {
            f();
        } else {
            e();
        }
    }
}
