package defpackage;

import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.Iterator;
/* compiled from: VirObjectEntity.java */
/* renamed from: th  reason: default package */
/* loaded from: classes.dex */
public abstract class th extends aci {
    private boolean a = false;

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.L != null) {
            if (kwVar != null) {
                kzVar.a(this.L, kwVar);
            } else {
                kzVar.a(this.L);
            }
        }
    }

    public boolean h() {
        return this.a;
    }

    public void g() {
        if ((this.L == null || this.K == null) && C().an().c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            this.L = new la(this.K);
            this.a = true;
            if (ThemeWatcher.getInstance().isNight()) {
                e();
            } else {
                f();
            }
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }

    public void e() {
        lf b = lf.b(0.086f, 0.512f, 0.972f, 1.0f);
        if (this.L == null || this.L.b == null) {
            return;
        }
        Iterator<kx> it = this.L.b.iterator();
        while (it.hasNext()) {
            it.next().a(b);
        }
    }

    public void f() {
        lf b = lf.b(0.23f, 0.597f, 0.99f, 1.0f);
        if (this.L == null || this.L.b == null) {
            return;
        }
        Iterator<kx> it = this.L.b.iterator();
        while (it.hasNext()) {
            it.next().a(b);
        }
    }
}
