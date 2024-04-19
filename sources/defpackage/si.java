package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: BusEntity.java */
/* renamed from: si  reason: default package */
/* loaded from: classes.dex */
public class si extends sl {
    public si() {
        this.J = "model/bus/bus.g3db";
        this.b = "mat_bus_shadow";
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
                    str2 = "model/bus/daba_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/bus/daba_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/bus/daba_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/bus/daba.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_bus").a(ln.a(f2));
        }
    }
}
