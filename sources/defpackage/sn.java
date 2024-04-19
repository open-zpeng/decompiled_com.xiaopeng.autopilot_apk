package defpackage;

import com.xiaopeng.autopilot.parking.view.g3d.d;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: ManEntity.java */
/* renamed from: sn  reason: default package */
/* loaded from: classes.dex */
public class sn extends sl {
    public sn() {
        this.J = "model/man/cartoon_man.g3db";
        this.b = "mat_zixingche_shadow";
    }

    @Override // defpackage.sl, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (d.q) {
            kzVar = ((d) C()).U();
        }
        if (this.L != null) {
            if (ThemeWatcher.getInstance().isNight()) {
                kzVar.a(this.L);
            } else if (kwVar != null) {
                kzVar.a(this.L, kwVar);
            } else {
                kzVar.a(this.L);
            }
        }
    }

    @Override // defpackage.sl
    public void a(float f) {
        aca an;
        String str;
        ko f2;
        aca an2;
        String str2;
        if (j()) {
            if (f == 1.0f) {
                if (ThemeWatcher.getInstance().isNight()) {
                    an2 = Y.an();
                    str2 = "model/man/cartoon_man_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/man/cartoon_man_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/man/cartoon_man_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/man/cartoon_man.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_cartoon_man").a(ln.a(f2));
        }
    }
}
