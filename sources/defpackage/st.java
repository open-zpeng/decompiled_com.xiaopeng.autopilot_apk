package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: SedanEntity.java */
/* renamed from: st  reason: default package */
/* loaded from: classes.dex */
public class st extends sl {
    public st() {
        this.J = "model/jiaoche/jiaoche_sr.g3db";
        this.b = "mat_shadow";
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
                    str2 = "model/jiaoche/jiaoche_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/jiaoche/jiaoche_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/jiaoche/jiaoche_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/jiaoche/jiaoche.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_jiaoche_body").a(ln.a(f2));
        }
    }
}
