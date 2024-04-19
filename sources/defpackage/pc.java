package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.r;
import defpackage.ok;
/* compiled from: Container.java */
/* renamed from: pc  reason: default package */
/* loaded from: classes.dex */
public class pc<T extends ok> extends py {
    private int A;
    private qf B;
    private boolean C;
    private boolean D;
    private T n;
    private pw o;
    private pw p;
    private pw q;
    private pw r;
    private pw s;
    private pw t;
    private pw u;
    private pw v;
    private pw w;
    private pw x;
    private float y;
    private float z;

    @Override // defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        if (F()) {
            a(batch, B());
            a(batch, f, 0.0f, 0.0f);
            if (this.C) {
                batch.flush();
                float a = this.v.a(this);
                float a2 = this.w.a(this);
                if (b(a, a2, (m() - a) - this.x.a(this), (n() - a2) - this.u.a(this))) {
                    b(batch, f);
                    batch.flush();
                    z();
                }
            } else {
                b(batch, f);
            }
            a(batch);
            return;
        }
        a(batch, f, k(), l());
        super.a(batch, f);
    }

    protected void a(Batch batch, float f, float f2, float f3) {
        if (this.B == null) {
            return;
        }
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        this.B.a(batch, f2, f3, m(), n());
    }

    @Override // defpackage.py
    public void f_() {
        if (this.n == null) {
            return;
        }
        float a = this.v.a(this);
        float a2 = this.w.a(this);
        float m = (m() - a) - this.x.a(this);
        float n = (n() - a2) - this.u.a(this);
        float a3 = this.o.a(this.n);
        float a4 = this.p.a(this.n);
        float a5 = this.q.a(this.n);
        float a6 = this.r.a(this.n);
        float a7 = this.s.a(this.n);
        float a8 = this.t.a(this.n);
        float f = this.y;
        float min = f > 0.0f ? f * m : Math.min(a5, m);
        if (min >= a3) {
            a3 = min;
        }
        if (a7 > 0.0f && a3 > a7) {
            a3 = a7;
        }
        float f2 = this.z;
        float min2 = f2 > 0.0f ? f2 * n : Math.min(a6, n);
        if (min2 >= a4) {
            a4 = min2;
        }
        if (a8 > 0.0f && a4 > a8) {
            a4 = a8;
        }
        int i = this.A;
        if ((i & 16) != 0) {
            a += m - a3;
        } else if ((i & 8) == 0) {
            a += (m - a3) / 2.0f;
        }
        int i2 = this.A;
        if ((i2 & 2) != 0) {
            a2 += n - a4;
        } else if ((i2 & 4) == 0) {
            a2 += (n - a4) / 2.0f;
        }
        if (this.D) {
            a = Math.round(a);
            a2 = Math.round(a2);
            a3 = Math.round(a3);
            a4 = Math.round(a4);
        }
        this.n.a(a, a2, a3, a4);
        T t = this.n;
        if (t instanceof qh) {
            ((qh) t).i_();
        }
    }

    @Override // defpackage.on
    public void c(ok okVar) {
        throw new UnsupportedOperationException("Use Container#setActor.");
    }

    @Override // defpackage.on
    public boolean a(ok okVar, boolean z) {
        if (okVar == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (okVar != this.n) {
            return false;
        }
        this.n = null;
        return super.a(okVar, z);
    }

    @Override // defpackage.py, defpackage.qh
    public float N() {
        return this.o.a(this.n) + this.v.a(this) + this.x.a(this);
    }

    @Override // defpackage.py, defpackage.qh
    public float O() {
        return this.p.a(this.n) + this.u.a(this) + this.w.a(this);
    }

    @Override // defpackage.py, defpackage.qh
    public float L() {
        float a = this.q.a(this.n);
        qf qfVar = this.B;
        if (qfVar != null) {
            a = Math.max(a, qfVar.e());
        }
        return Math.max(N(), a + this.v.a(this) + this.x.a(this));
    }

    @Override // defpackage.py, defpackage.qh
    public float M() {
        float a = this.r.a(this.n);
        qf qfVar = this.B;
        if (qfVar != null) {
            a = Math.max(a, qfVar.f());
        }
        return Math.max(O(), a + this.u.a(this) + this.w.a(this));
    }

    @Override // defpackage.py, defpackage.qh
    public float I() {
        float a = this.s.a(this.n);
        return a > 0.0f ? a + this.v.a(this) + this.x.a(this) : a;
    }

    @Override // defpackage.py, defpackage.qh
    public float J() {
        float a = this.t.a(this.n);
        return a > 0.0f ? a + this.u.a(this) + this.w.a(this) : a;
    }

    @Override // defpackage.on, defpackage.ok
    public ok a(float f, float f2, boolean z) {
        if (!this.C || (!(z && i() == or.disabled) && f >= 0.0f && f < m() && f2 >= 0.0f && f2 < n())) {
            return super.a(f, f2, z);
        }
        return null;
    }

    @Override // defpackage.on, defpackage.ok
    public void a(r rVar) {
        i_();
        if (F()) {
            a(rVar, B());
            if (this.C) {
                rVar.d();
                float a = this.v.a(this);
                float a2 = this.w.a(this);
                if (this.B == null ? b(0.0f, 0.0f, m(), n()) : b(a, a2, (m() - a) - this.x.a(this), (n() - a2) - this.u.a(this))) {
                    c(rVar);
                    z();
                }
            } else {
                c(rVar);
            }
            d(rVar);
            return;
        }
        super.a(rVar);
    }
}
