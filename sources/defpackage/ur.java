package defpackage;

import android.text.TextUtils;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: ParklotFavoriteEntity.java */
/* renamed from: ur  reason: default package */
/* loaded from: classes.dex */
public class ur extends up {
    @Override // defpackage.aci, com.badlogic.gdx.utils.z.a
    public void reset() {
    }

    public ur() {
        this.J = "model/entity/star.g3db";
    }

    @Override // defpackage.up
    public void e() {
        lf b = lf.b(0.0f, 0.7490196f, 1.0f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf a = lf.a(0.0f, 0.0f, 0.0f, 1.0f);
        le leVar = new le(770, 771);
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx b2 = this.L.b("mat_star_under");
        b2.c();
        b2.a(b);
        b2.a(c);
        b2.a(a);
        b2.a(leVar);
    }

    @Override // defpackage.up
    public void f() {
        lf b = lf.b(0.05490196f, 0.59607846f, 0.76862746f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf a = lf.a(0.0f, 0.06f, 0.215f, 1.0f);
        le leVar = new le(770, 771);
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx b2 = this.L.b("mat_star_under");
        b2.c();
        b2.a(b);
        b2.a(c);
        b2.a(a);
        b2.a(leVar);
    }

    @Override // defpackage.aci
    public la k_() {
        if (!TextUtils.isEmpty(this.J) && C().an().c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            this.L = new la(this.K);
            if (ThemeWatcher.getInstance().isNight()) {
                f();
            } else {
                e();
            }
            return this.L;
        }
        return super.k_();
    }
}
