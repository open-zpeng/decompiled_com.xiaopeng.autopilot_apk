package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.r;
import com.badlogic.gdx.math.f;
import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.n;
/* compiled from: ScrollPane.java */
/* renamed from: pj  reason: default package */
/* loaded from: classes.dex */
public class pj extends py {
    float A;
    boolean B;
    boolean C;
    float D;
    float E;
    boolean F;
    float G;
    float H;
    boolean I;
    boolean J;
    private a K;
    private ok L;
    private final n M;
    private final n N;
    private final n O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    final n n;
    final n o;
    final n p;
    final n q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    float v;
    float w;
    float x;
    float y;
    float z;

    /* compiled from: ScrollPane.java */
    /* renamed from: pj$a */
    /* loaded from: classes.dex */
    public static class a {
        public qf a;
        public qf b;
        public qf c;
        public qf d;
        public qf e;
        public qf f;
    }

    @Override // defpackage.py, defpackage.qh
    public float N() {
        return 0.0f;
    }

    @Override // defpackage.py, defpackage.qh
    public float O() {
        return 0.0f;
    }

    @Override // defpackage.py
    public void f_() {
        float f;
        float f2;
        float f3;
        float f4;
        float m;
        float n;
        qf qfVar = this.K.a;
        qf qfVar2 = this.K.d;
        qf qfVar3 = this.K.f;
        if (qfVar != null) {
            f2 = qfVar.a();
            f3 = qfVar.b();
            f4 = qfVar.c();
            f = qfVar.d();
        } else {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
        }
        float m2 = m();
        float n2 = n();
        float f5 = qfVar2 != null ? qfVar2.f() : 0.0f;
        if (this.K.c != null) {
            f5 = Math.max(f5, this.K.c.f());
        }
        float e = qfVar3 != null ? qfVar3.e() : 0.0f;
        if (this.K.e != null) {
            e = Math.max(e, this.K.e.e());
        }
        this.D = (m2 - f2) - f3;
        float f6 = n2 - f4;
        this.E = f6 - f;
        ok okVar = this.L;
        if (okVar == null) {
            return;
        }
        if (okVar instanceof qh) {
            qh qhVar = (qh) okVar;
            m = qhVar.L();
            n = qhVar.M();
        } else {
            m = okVar.m();
            n = this.L.n();
        }
        boolean z = false;
        this.r = this.P || (m > this.D && !this.I);
        if (this.Q || (n > this.E && !this.J)) {
            z = true;
        }
        this.s = z;
        boolean z2 = this.F;
        if (!z2) {
            if (this.s) {
                this.D -= e;
                if (!this.r && m > this.D && !this.I) {
                    this.r = true;
                }
            }
            if (this.r) {
                this.E -= f5;
                if (!this.s && n > this.E && !this.J) {
                    this.s = true;
                    this.D -= e;
                }
            }
        }
        this.M.set(f2, f, this.D, this.E);
        if (z2) {
            if (this.r && this.s) {
                this.E -= f5;
                this.D -= e;
            }
        } else if (this.R) {
            if (this.r) {
                this.M.height += f5;
            }
            if (this.s) {
                this.M.width += e;
            }
        } else {
            if (this.r && this.u) {
                this.M.y += f5;
            }
            if (this.s && !this.t) {
                this.M.x += e;
            }
        }
        float max = this.I ? this.D : Math.max(this.D, m);
        float max2 = this.J ? this.E : Math.max(this.E, n);
        this.z = max - this.D;
        this.A = max2 - this.E;
        if (z2 && this.r && this.s) {
            this.A -= f5;
            this.z -= e;
        }
        e(h.a(this.v, 0.0f, this.z));
        f(h.a(this.w, 0.0f, this.A));
        if (this.r) {
            if (qfVar2 != null) {
                float f7 = this.K.c != null ? this.K.c.f() : qfVar2.f();
                this.n.set(this.t ? f2 : e + f2, this.u ? f : f6 - f7, this.D, f7);
                if (this.S) {
                    this.p.width = Math.max(qfVar2.e(), (int) ((this.n.width * this.D) / max));
                } else {
                    this.p.width = qfVar2.e();
                }
                if (this.p.width > max) {
                    this.p.width = 0.0f;
                }
                this.p.height = qfVar2.f();
                this.p.x = this.n.x + ((int) ((this.n.width - this.p.width) * Q()));
                this.p.y = this.n.y;
            } else {
                this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.p.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        if (this.s) {
            if (qfVar3 != null) {
                float e2 = this.K.e != null ? this.K.e.e() : qfVar3.e();
                if (this.u) {
                    f = f6 - this.E;
                }
                this.o.set(this.t ? (m2 - f3) - e2 : f2, f, e2, this.E);
                this.q.width = qfVar3.e();
                if (this.S) {
                    this.q.height = Math.max(qfVar3.f(), (int) ((this.o.height * this.E) / max2));
                } else {
                    this.q.height = qfVar3.f();
                }
                if (this.q.height > max2) {
                    this.q.height = 0.0f;
                }
                if (this.t) {
                    this.q.x = (m2 - f3) - qfVar3.e();
                } else {
                    this.q.x = f2;
                }
                this.q.y = this.o.y + ((int) ((this.o.height - this.q.height) * (1.0f - R())));
            } else {
                this.o.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.q.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        S();
        this.L.c(max, max2);
        ok okVar2 = this.L;
        if (okVar2 instanceof qh) {
            ((qh) okVar2).i_();
        }
    }

    private void S() {
        float f;
        float f2 = this.M.y;
        if (!this.s) {
            f = f2 - ((int) this.A);
        } else {
            f = f2 - ((int) (this.A - this.y));
        }
        float f3 = this.M.x;
        if (this.r) {
            f3 -= (int) this.x;
        }
        if (!this.F && this.R) {
            if (this.r && this.u) {
                float f4 = this.K.d != null ? this.K.d.f() : 0.0f;
                if (this.K.c != null) {
                    f4 = Math.max(f4, this.K.c.f());
                }
                f += f4;
            }
            if (this.s && !this.t) {
                float e = this.K.d != null ? this.K.d.e() : 0.0f;
                if (this.K.c != null) {
                    e = Math.max(e, this.K.c.e());
                }
                f3 += e;
            }
        }
        this.L.a(f3, f);
        if (this.L instanceof qe) {
            this.N.x = this.M.x - f3;
            this.N.y = this.M.y - f;
            this.N.width = this.M.width;
            this.N.height = this.M.height;
            ((qe) this.L).a(this.N);
        }
    }

    @Override // defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        if (this.L == null) {
            return;
        }
        i_();
        a(batch, B());
        if (this.r) {
            this.p.x = this.n.x + ((int) ((this.n.width - this.p.width) * K()));
        }
        if (this.s) {
            this.q.y = this.o.y + ((int) ((this.o.height - this.q.height) * (1.0f - P())));
        }
        S();
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        if (this.K.a != null) {
            this.K.a.a(batch, 0.0f, 0.0f, m(), n());
        }
        e().a(this.M, this.O);
        batch.flush();
        if (qj.a(this.O)) {
            b(batch, f);
            batch.flush();
            qj.a();
        }
        a(batch, x.J, x.K, x.L, x.M * f * f.e.a(this.G / this.H));
        a(batch);
    }

    protected void a(Batch batch, float f, float f2, float f3, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        batch.setColor(f, f2, f3, f4);
        boolean z = true;
        boolean z2 = this.r && this.p.width > 0.0f;
        if (!this.s || this.q.height <= 0.0f) {
            z = false;
        }
        if (z2 && z && this.K.b != null) {
            this.K.b.a(batch, this.n.x + this.n.width, this.n.y, this.o.width, this.o.y);
        }
        if (z2) {
            if (this.K.c != null) {
                this.K.c.a(batch, this.n.x, this.n.y, this.n.width, this.n.height);
            }
            if (this.K.d != null) {
                this.K.d.a(batch, this.p.x, this.p.y, this.p.width, this.p.height);
            }
        }
        if (z) {
            if (this.K.e != null) {
                this.K.e.a(batch, this.o.x, this.o.y, this.o.width, this.o.height);
            }
            if (this.K.f != null) {
                this.K.f.a(batch, this.q.x, this.q.y, this.q.width, this.q.height);
            }
        }
    }

    @Override // defpackage.py, defpackage.qh
    public float L() {
        ok okVar = this.L;
        if (okVar instanceof qh) {
            float L = ((qh) okVar).L();
            if (this.K.a != null) {
                L += this.K.a.a() + this.K.a.b();
            }
            if (this.Q) {
                float e = this.K.f != null ? this.K.f.e() : 0.0f;
                if (this.K.e != null) {
                    e = Math.max(e, this.K.e.e());
                }
                return L + e;
            }
            return L;
        }
        return 150.0f;
    }

    @Override // defpackage.py, defpackage.qh
    public float M() {
        ok okVar = this.L;
        if (okVar instanceof qh) {
            float M = ((qh) okVar).M();
            if (this.K.a != null) {
                M += this.K.a.c() + this.K.a.d();
            }
            if (this.P) {
                float f = this.K.d != null ? this.K.d.f() : 0.0f;
                if (this.K.c != null) {
                    f = Math.max(f, this.K.c.f());
                }
                return M + f;
            }
            return M;
        }
        return 150.0f;
    }

    @Override // defpackage.on
    public void c(ok okVar) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Override // defpackage.on
    public boolean a(ok okVar, boolean z) {
        if (okVar == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (okVar != this.L) {
            return false;
        }
        this.L = null;
        return super.a(okVar, z);
    }

    @Override // defpackage.on, defpackage.ok
    public ok a(float f, float f2, boolean z) {
        if (f < 0.0f || f >= m() || f2 < 0.0f || f2 >= n()) {
            return null;
        }
        if (z && i() == or.enabled && j()) {
            if (this.r && this.B && this.n.contains(f, f2)) {
                return this;
            }
            if (this.s && this.C && this.o.contains(f, f2)) {
                return this;
            }
        }
        return super.a(f, f2, z);
    }

    protected void e(float f) {
        this.v = f;
    }

    protected void f(float f) {
        this.w = f;
    }

    public float K() {
        float f = this.z;
        if (f == 0.0f) {
            return 0.0f;
        }
        return h.a(this.x / f, 0.0f, 1.0f);
    }

    public float P() {
        float f = this.A;
        if (f == 0.0f) {
            return 0.0f;
        }
        return h.a(this.y / f, 0.0f, 1.0f);
    }

    public float Q() {
        float f = this.z;
        if (f == 0.0f) {
            return 0.0f;
        }
        return h.a(this.v / f, 0.0f, 1.0f);
    }

    public float R() {
        float f = this.A;
        if (f == 0.0f) {
            return 0.0f;
        }
        return h.a(this.w / f, 0.0f, 1.0f);
    }

    @Override // defpackage.on, defpackage.ok
    public void a(r rVar) {
        rVar.d();
        a(rVar, B());
        if (qj.a(this.O)) {
            c(rVar);
            qj.a();
        }
        d(rVar);
    }
}
