package defpackage;
/* compiled from: ParklotPEntity.java */
/* renamed from: ut  reason: default package */
/* loaded from: classes.dex */
public class ut extends up {
    private boolean a;
    private boolean b;

    @Override // defpackage.aci, com.badlogic.gdx.utils.z.a
    public void reset() {
    }

    public ut() {
        this.J = "model/entity/p_icon.g3db";
    }

    @Override // defpackage.up
    public void e() {
        super.e();
    }

    @Override // defpackage.up
    public void f() {
        super.f();
    }

    @Override // defpackage.aci
    public la k_() {
        if (this.a) {
            if (this.b) {
                this.J = "model/entity/p_icon_gray.g3db";
            } else {
                this.J = "model/entity/p_icon_yellow.g3db";
            }
        } else {
            this.J = "model/entity/p_icon.g3db";
        }
        if (C().an().c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            this.L = new la(this.K);
            return this.L;
        }
        return super.k_();
    }

    public void b(boolean z) {
        this.a = z;
    }

    public void c(boolean z) {
        this.b = z;
    }
}
