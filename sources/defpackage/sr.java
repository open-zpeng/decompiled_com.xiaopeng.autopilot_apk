package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: PikaEntity.java */
/* renamed from: sr  reason: default package */
/* loaded from: classes.dex */
public class sr extends sl {
    public sr() {
        this.J = "model/pika/pika.g3db";
        this.b = "mat_pika_shadow";
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
                    str2 = "model/pika/pika_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/pika/pika_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/pika/pika_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/pika/pika.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_pika").a(ln.a(f2));
        }
    }
}
