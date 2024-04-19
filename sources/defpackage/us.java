package defpackage;

import android.text.TextUtils;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: ParklotNumberEntity.java */
/* renamed from: us  reason: default package */
/* loaded from: classes.dex */
public class us extends up {
    @Override // defpackage.aci, com.badlogic.gdx.utils.z.a
    public void reset() {
    }

    public us() {
        this.J = null;
    }

    public void a(String str) {
        this.J = str;
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
        kx a2 = this.L.b.a(0);
        a2.c();
        a2.a(b);
        a2.a(c);
        a2.a(a);
        a2.a(leVar);
    }

    @Override // defpackage.up
    public void f() {
        lf b = lf.b(0.0f, 0.3f, 0.4f, 1.0f);
        lf c = lf.c(0.9f, 0.9f, 0.9f, 1.0f);
        lf a = lf.a(0.0f, 0.06f, 0.215f, 1.0f);
        le leVar = new le(770, 771);
        if (this.L == null || this.L.b == null) {
            return;
        }
        kx a2 = this.L.b.a(0);
        a2.c();
        a2.a(b);
        a2.a(c);
        a2.a(a);
        a2.a(leVar);
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
