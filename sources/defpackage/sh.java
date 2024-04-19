package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: BicycleEntity.java */
/* renamed from: sh  reason: default package */
/* loaded from: classes.dex */
public class sh extends sl {
    public sh() {
        this.J = "model/bike/zixingche.g3db";
        this.b = "mat_zixingche_shadow";
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
                    str2 = "model/bike/zixingche_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/bike/zixingche_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/bike/zixingche_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/bike/zixingche.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_zixingche").a(ln.a(f2));
        }
    }
}
