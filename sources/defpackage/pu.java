package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.b;
import com.badlogic.gdx.math.o;
/* compiled from: Touchpad.java */
/* renamed from: pu  reason: default package */
/* loaded from: classes.dex */
public class pu extends px {
    private a l;
    private float m;
    private final b n;
    private final b o;
    private final b p;
    private final o q;
    private final o r;

    /* compiled from: Touchpad.java */
    /* renamed from: pu$a */
    /* loaded from: classes.dex */
    public static class a {
        public qf a;
        public qf b;
    }

    @Override // defpackage.ok
    public ok a(float f, float f2, boolean z) {
        if ((!z || i() == or.enabled) && j() && this.o.a(f, f2)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.px
    public void B() {
        float m = m() / 2.0f;
        float n = n() / 2.0f;
        float min = Math.min(m, n);
        this.o.a(m, n, min);
        if (this.l.b != null) {
            min -= Math.max(this.l.b.e(), this.l.b.f()) / 2.0f;
        }
        this.n.a(m, n, min);
        this.p.a(m, n, this.m);
        this.q.a(m, n);
        this.r.a(0.0f, 0.0f);
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        float k = k();
        float l = l();
        float m = m();
        float n = n();
        qf qfVar = this.l.a;
        if (qfVar != null) {
            qfVar.a(batch, k, l, m, n);
        }
        qf qfVar2 = this.l.b;
        if (qfVar2 != null) {
            qfVar2.a(batch, k + (this.q.d - (qfVar2.e() / 2.0f)), l + (this.q.e - (qfVar2.f() / 2.0f)), qfVar2.e(), qfVar2.f());
        }
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        if (this.l.a != null) {
            return this.l.a.e();
        }
        return 0.0f;
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        if (this.l.a != null) {
            return this.l.a.f();
        }
        return 0.0f;
    }
}
