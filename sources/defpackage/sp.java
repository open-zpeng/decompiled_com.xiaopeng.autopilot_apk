package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: MpvEntity.java */
/* renamed from: sp  reason: default package */
/* loaded from: classes.dex */
public class sp extends sl {
    public sp() {
        this.J = "model/mpv/MPV.g3db";
        this.b = "mat_shadow_mpv";
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
                    str2 = "model/mpv/MPV_night_red.jpg";
                } else {
                    an2 = Y.an();
                    str2 = "model/mpv/MPV_map_red.jpg";
                }
                f2 = an2.f(str2);
            } else {
                if (ThemeWatcher.getInstance().isNight()) {
                    an = Y.an();
                    str = "model/mpv/MPV_night.jpg";
                } else {
                    an = Y.an();
                    str = "model/mpv/MPV_map.jpg";
                }
                f2 = an.f(str);
            }
            this.L.b("mat_mpv").a(ln.a(f2));
        }
    }
}
