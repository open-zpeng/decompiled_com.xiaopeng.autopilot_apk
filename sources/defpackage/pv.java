package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
/* compiled from: Tree.java */
/* renamed from: pv  reason: default package */
/* loaded from: classes.dex */
public class pv extends py {
    b n;
    final com.badlogic.gdx.utils.a<a> o;
    final qk<a> p;
    float q;
    float r;
    float s;
    float t;
    float u;
    a v;
    private float w;
    private float x;
    private boolean y;

    /* compiled from: Tree.java */
    /* renamed from: pv$b */
    /* loaded from: classes.dex */
    public static class b {
        public qf a;
        public qf b;
        public qf c;
        public qf d;
        public qf e;
    }

    @Override // defpackage.on
    public void D() {
        super.D();
        a((a) null);
        this.o.d();
        this.p.f();
    }

    @Override // defpackage.py
    public void j_() {
        super.j_();
        this.y = true;
    }

    private void K() {
        this.y = false;
        this.w = this.n.a.e();
        this.w = Math.max(this.w, this.n.b.e());
        this.x = n();
        a(this.o, this.u, Math.max(this.n.a.e(), this.n.b.e()));
        this.w += this.t * 2.0f;
        this.x = n() - this.x;
    }

    private void a(com.badlogic.gdx.utils.a<a> aVar, float f, float f2) {
        float m;
        float f3 = this.q;
        float f4 = this.r + this.s;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            a a2 = aVar.a(i2);
            float f5 = f + f2;
            ok okVar = a2.a;
            if (okVar instanceof qh) {
                qh qhVar = (qh) okVar;
                m = f5 + qhVar.L();
                a2.e = qhVar.M();
                qhVar.h_();
            } else {
                m = f5 + okVar.m();
                a2.e = okVar.n();
            }
            if (a2.d != null) {
                m += a2.d.e() + f4;
                a2.e = Math.max(a2.e, a2.d.f());
            }
            this.w = Math.max(this.w, m);
            this.x -= a2.e + f3;
            if (a2.c) {
                a(a2.b, this.u + f, f2);
            }
        }
    }

    @Override // defpackage.py
    public void f_() {
        if (this.y) {
            K();
        }
        a(this.o, this.t, n() - (this.q / 2.0f), Math.max(this.n.a.e(), this.n.b.e()));
    }

    private float a(com.badlogic.gdx.utils.a<a> aVar, float f, float f2, float f3) {
        float f4 = this.q;
        float f5 = this.r + this.s;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            a a2 = aVar.a(i2);
            float f6 = f + f3;
            if (a2.d != null) {
                f6 += a2.d.e() + f5;
            }
            float a3 = f2 - a2.a();
            a2.a.a(f6, a3);
            f2 = a3 - f4;
            if (a2.c) {
                f2 = a(a2.b, this.u + f, f2, f3);
            }
        }
        return f2;
    }

    @Override // defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        c(batch, f);
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        a(batch, this.o, this.t, Math.max(this.n.a.e(), this.n.b.e()));
        super.a(batch, f);
    }

    protected void c(Batch batch, float f) {
        if (this.n.e != null) {
            ka x = x();
            batch.setColor(x.J, x.K, x.L, x.M * f);
            this.n.e.a(batch, k(), l(), m(), n());
        }
    }

    private void a(Batch batch, com.badlogic.gdx.utils.a<a> aVar, float f, float f2) {
        ok okVar;
        float f3;
        a aVar2;
        int i;
        int i2;
        com.badlogic.gdx.utils.a<a> aVar3 = aVar;
        qf qfVar = this.n.a;
        qf qfVar2 = this.n.b;
        float k = k();
        float l = l();
        float f4 = k + f;
        float f5 = f4 + f2 + this.r;
        int i3 = aVar3.b;
        int i4 = 0;
        while (i4 < i3) {
            a a2 = aVar3.a(i4);
            float f6 = a2.e;
            ok okVar2 = a2.a;
            if (this.p.a(a2) && this.n.d != null) {
                okVar = okVar2;
                f3 = f6;
                aVar2 = a2;
                i = i4;
                i2 = i3;
                this.n.d.a(batch, k, (l + okVar2.l()) - (this.q / 2.0f), m(), f6 + this.q);
            } else {
                okVar = okVar2;
                f3 = f6;
                aVar2 = a2;
                i = i4;
                i2 = i3;
                if (aVar2 == this.v && this.n.c != null) {
                    this.n.c.a(batch, k, (okVar.l() + l) - (this.q / 2.0f), m(), f3 + this.q);
                }
            }
            if (aVar2.d != null) {
                float l2 = okVar.l() + l + Math.round((f3 - aVar2.d.f()) / 2.0f);
                batch.setColor(okVar.x());
                aVar2.d.a(batch, f5, l2, aVar2.d.e(), aVar2.d.f());
                batch.setColor(ka.a);
            }
            if (aVar2.b.b != 0) {
                qf qfVar3 = aVar2.c ? qfVar2 : qfVar;
                qfVar3.a(batch, f4, okVar.l() + l + Math.round((f3 - qfVar3.f()) / 2.0f), qfVar3.e(), qfVar3.f());
                if (aVar2.c) {
                    a(batch, aVar2.b, f + this.u, f2);
                }
            }
            i4 = i + 1;
            i3 = i2;
            aVar3 = aVar;
        }
    }

    public void a(a aVar) {
        this.v = aVar;
    }

    @Override // defpackage.py, defpackage.qh
    public float L() {
        if (this.y) {
            K();
        }
        return this.w;
    }

    @Override // defpackage.py, defpackage.qh
    public float M() {
        if (this.y) {
            K();
        }
        return this.x;
    }

    /* compiled from: Tree.java */
    /* renamed from: pv$a */
    /* loaded from: classes.dex */
    public static class a {
        final ok a;
        final com.badlogic.gdx.utils.a<a> b;
        boolean c;
        qf d;
        float e;

        public float a() {
            return this.e;
        }
    }
}
