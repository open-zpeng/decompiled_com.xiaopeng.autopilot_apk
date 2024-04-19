package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: SuvEntity.java */
/* renamed from: sv  reason: default package */
/* loaded from: classes.dex */
public class sv extends sl {
    public sv() {
        this.J = "model/suv/SUV.g3db";
        this.b = "mat_SUV_shadow";
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
                    str2 = "model/suv/SUV_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/suv/SUV_map_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/suv/SUV_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/suv/SUV_map.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_SUV").a(ln.a(f2));
        }
    }
}
