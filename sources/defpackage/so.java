package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: MotoEntity.java */
/* renamed from: so  reason: default package */
/* loaded from: classes.dex */
public class so extends sl {
    public so() {
        this.J = "model/moto/moto.g3db";
        this.b = "mat_moto_shadow";
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
                    str2 = "model/moto/moto_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/moto/moto_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/moto/moto_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/moto/moto.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_moto").a(ln.a(f2));
        }
    }
}
