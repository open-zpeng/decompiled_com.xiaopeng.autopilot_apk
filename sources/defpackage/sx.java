package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: VanEntity.java */
/* renamed from: sx  reason: default package */
/* loaded from: classes.dex */
public class sx extends sl {
    public sx() {
        this.J = "model/huoche/huoche.g3db";
        this.b = "mat_huoche_shadow";
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
                    str2 = "model/huoche/huoche_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/huoche/huoche_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/huoche/huoche_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/huoche/huoche.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_huoche").a(ln.a(f2));
        }
    }
}
