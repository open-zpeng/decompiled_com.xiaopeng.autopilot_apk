package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.n;
/* compiled from: SplitPane.java */
/* renamed from: pn  reason: default package */
/* loaded from: classes.dex */
public class pn extends py {
    a n;
    boolean o;
    float p;
    float q;
    float r;
    n s;
    private ok t;
    private ok u;
    private n v;
    private n w;
    private n x;

    /* compiled from: SplitPane.java */
    /* renamed from: pn$a */
    /* loaded from: classes.dex */
    public static class a {
        public qf a;
    }

    @Override // defpackage.py
    public void f_() {
        K();
        if (!this.o) {
            S();
        } else {
            T();
        }
        ok okVar = this.t;
        if (okVar != null) {
            n nVar = this.v;
            okVar.a(nVar.x, nVar.y, nVar.width, nVar.height);
            if (okVar instanceof qh) {
                ((qh) okVar).i_();
            }
        }
        ok okVar2 = this.u;
        if (okVar2 != null) {
            n nVar2 = this.w;
            okVar2.a(nVar2.x, nVar2.y, nVar2.width, nVar2.height);
            if (okVar2 instanceof qh) {
                ((qh) okVar2).i_();
            }
        }
    }

    @Override // defpackage.py, defpackage.qh
    public float L() {
        float L;
        ok okVar = this.t;
        float f = 0.0f;
        if (okVar == null) {
            L = 0.0f;
        } else {
            L = okVar instanceof qh ? ((qh) okVar).L() : okVar.m();
        }
        ok okVar2 = this.u;
        if (okVar2 != null) {
            f = okVar2 instanceof qh ? ((qh) okVar2).L() : okVar2.m();
        }
        return this.o ? Math.max(L, f) : L + this.n.a.e() + f;
    }

    @Override // defpackage.py, defpackage.qh
    public float M() {
        float M;
        ok okVar = this.t;
        float f = 0.0f;
        if (okVar == null) {
            M = 0.0f;
        } else {
            M = okVar instanceof qh ? ((qh) okVar).M() : okVar.n();
        }
        ok okVar2 = this.u;
        if (okVar2 != null) {
            f = okVar2 instanceof qh ? ((qh) okVar2).M() : okVar2.n();
        }
        return !this.o ? Math.max(M, f) : M + this.n.a.f() + f;
    }

    @Override // defpackage.py, defpackage.qh
    public float N() {
        ok okVar = this.t;
        float N = okVar instanceof qh ? ((qh) okVar).N() : 0.0f;
        ok okVar2 = this.u;
        float N2 = okVar2 instanceof qh ? ((qh) okVar2).N() : 0.0f;
        return this.o ? Math.max(N, N2) : N + this.n.a.e() + N2;
    }

    @Override // defpackage.py, defpackage.qh
    public float O() {
        ok okVar = this.t;
        float O = okVar instanceof qh ? ((qh) okVar).O() : 0.0f;
        ok okVar2 = this.u;
        float O2 = okVar2 instanceof qh ? ((qh) okVar2).O() : 0.0f;
        return !this.o ? Math.max(O, O2) : O + this.n.a.f() + O2;
    }

    private void S() {
        qf qfVar = this.n.a;
        float n = n();
        float m = m() - qfVar.e();
        float f = (int) (this.p * m);
        float e = qfVar.e();
        this.v.set(0.0f, 0.0f, f, n);
        this.w.set(f + e, 0.0f, m - f, n);
        this.s.set(f, 0.0f, e, n);
    }

    private void T() {
        qf qfVar = this.n.a;
        float m = m();
        float n = n();
        float f = n - qfVar.f();
        float f2 = (int) (this.p * f);
        float f3 = f - f2;
        float f4 = qfVar.f();
        this.v.set(0.0f, n - f2, m, f2);
        this.w.set(0.0f, 0.0f, m, f3);
        this.s.set(0.0f, f3, m, f4);
    }

    @Override // defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        ka x = x();
        float f2 = x.M * f;
        a(batch, B());
        ok okVar = this.t;
        if (okVar != null && okVar.j()) {
            batch.flush();
            e().a(this.v, this.x);
            if (qj.a(this.x)) {
                this.t.a(batch, f2);
                batch.flush();
                qj.a();
            }
        }
        ok okVar2 = this.u;
        if (okVar2 != null && okVar2.j()) {
            batch.flush();
            e().a(this.w, this.x);
            if (qj.a(this.x)) {
                this.u.a(batch, f2);
                batch.flush();
                qj.a();
            }
        }
        batch.setColor(x.J, x.K, x.L, f2);
        this.n.a.a(batch, this.s.x, this.s.y, this.s.width, this.s.height);
        a(batch);
    }

    protected void K() {
        float f = this.q;
        float f2 = this.r;
        if (this.o) {
            float n = n() - this.n.a.f();
            ok okVar = this.t;
            if (okVar instanceof qh) {
                f = Math.max(f, Math.min(((qh) okVar).O() / n, 1.0f));
            }
            ok okVar2 = this.u;
            if (okVar2 instanceof qh) {
                f2 = Math.min(f2, 1.0f - Math.min(((qh) okVar2).O() / n, 1.0f));
            }
        } else {
            float m = m() - this.n.a.e();
            ok okVar3 = this.t;
            if (okVar3 instanceof qh) {
                f = Math.max(f, Math.min(((qh) okVar3).N() / m, 1.0f));
            }
            ok okVar4 = this.u;
            if (okVar4 instanceof qh) {
                f2 = Math.min(f2, 1.0f - Math.min(((qh) okVar4).N() / m, 1.0f));
            }
        }
        if (f > f2) {
            this.p = (f + f2) * 0.5f;
        } else {
            this.p = Math.max(Math.min(this.p, f2), f);
        }
    }

    @Override // defpackage.on
    public void c(ok okVar) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override // defpackage.on
    public boolean a(ok okVar, boolean z) {
        if (okVar == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (okVar == this.t) {
            super.a(okVar, z);
            this.t = null;
            j_();
            return true;
        } else if (okVar == this.u) {
            super.a(okVar, z);
            this.u = null;
            j_();
            return true;
        } else {
            return false;
        }
    }
}
