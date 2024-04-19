package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.f;
/* compiled from: ProgressBar.java */
/* renamed from: pi  reason: default package */
/* loaded from: classes.dex */
public class pi extends px {
    float l;
    final boolean m;
    boolean n;
    private a o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private f v;
    private f w;
    private boolean x;

    /* compiled from: ProgressBar.java */
    /* renamed from: pi$a */
    /* loaded from: classes.dex */
    public static class a {
        public qf a;
        public qf b;
        public qf c;
        public qf d;
        public qf e;
        public qf f;
        public qf g;
        public qf h;
    }

    public a C() {
        return this.o;
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        a aVar = this.o;
        boolean z = this.n;
        qf G = G();
        qf qfVar = (!z || aVar.b == null) ? aVar.a : aVar.b;
        qf qfVar2 = (!z || aVar.g == null) ? aVar.e : aVar.g;
        qf qfVar3 = (!z || aVar.h == null) ? aVar.f : aVar.h;
        ka x = x();
        float k = k();
        float l = l();
        float m = m();
        float n = n();
        float f8 = 0.0f;
        float f9 = G == null ? 0.0f : G.f();
        float e = G == null ? 0.0f : G.e();
        float F = F();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        if (this.m) {
            if (qfVar != null) {
                if (this.x) {
                    f5 = 0.0f;
                    qfVar.a(batch, Math.round(((m - qfVar.e()) * 0.5f) + k), l, Math.round(qfVar.e()), n);
                } else {
                    f5 = 0.0f;
                    qfVar.a(batch, (k + m) - (qfVar.e() * 0.5f), l, qfVar.e(), n);
                }
                f8 = qfVar.c();
                f6 = n - (qfVar.d() + f8);
            } else {
                f5 = 0.0f;
                f6 = n;
            }
            if (G == null) {
                f7 = qfVar2 == null ? f5 : qfVar2.f() * 0.5f;
                float f10 = f6 - f7;
                this.l = f10 * F;
                this.l = Math.min(f10, this.l);
            } else {
                float f11 = f6 - f9;
                this.l = f11 * F;
                this.l = Math.min(f11, this.l) + qfVar.d();
                f7 = f9 * 0.5f;
            }
            this.l = Math.max(f5, this.l);
            if (qfVar2 != null) {
                if (this.x) {
                    qfVar2.a(batch, Math.round(((m - qfVar2.e()) * 0.5f) + k), Math.round(f8 + l), Math.round(qfVar2.e()), Math.round(this.l + f7));
                } else {
                    qfVar2.a(batch, k + ((m - qfVar2.e()) * 0.5f), l + f8, qfVar2.e(), this.l + f7);
                }
            }
            if (qfVar3 != null) {
                if (this.x) {
                    qfVar3.a(batch, Math.round(((m - qfVar3.e()) * 0.5f) + k), Math.round(this.l + l + f7), Math.round(qfVar3.e()), Math.round((n - this.l) - f7));
                } else {
                    qfVar3.a(batch, k + ((m - qfVar3.e()) * 0.5f), this.l + l + f7, qfVar3.e(), (n - this.l) - f7);
                }
            }
            if (G != null) {
                if (this.x) {
                    G.a(batch, Math.round(k + ((m - e) * 0.5f)), Math.round(l + this.l), Math.round(e), Math.round(f9));
                    return;
                } else {
                    G.a(batch, k + ((m - e) * 0.5f), l + this.l, e, f9);
                    return;
                }
            }
            return;
        }
        if (qfVar != null) {
            if (this.x) {
                qfVar.a(batch, k, Math.round(((n - qfVar.f()) * 0.5f) + l), m, Math.round(qfVar.f()));
            } else {
                qfVar.a(batch, k, l + ((n - qfVar.f()) * 0.5f), m, qfVar.f());
            }
            f2 = qfVar.a();
            f3 = m - (qfVar.b() + f2);
        } else {
            f2 = 0.0f;
            f3 = m;
        }
        if (G == null) {
            f4 = qfVar2 == null ? 0.0f : qfVar2.e() * 0.5f;
            float f12 = f3 - f4;
            this.l = f12 * F;
            this.l = Math.min(f12, this.l);
        } else {
            f4 = e * 0.5f;
            float f13 = f3 - e;
            this.l = f13 * F;
            this.l = Math.min(f13, this.l) + f2;
        }
        this.l = Math.max(0.0f, this.l);
        if (qfVar2 != null) {
            if (this.x) {
                qfVar2.a(batch, Math.round(f2 + k), Math.round(((n - qfVar2.f()) * 0.5f) + l), Math.round(this.l + f4), Math.round(qfVar2.f()));
            } else {
                qfVar2.a(batch, k + f2, l + ((n - qfVar2.f()) * 0.5f), this.l + f4, qfVar2.f());
            }
        }
        if (qfVar3 != null) {
            if (this.x) {
                qfVar3.a(batch, Math.round(this.l + k + f4), Math.round(((n - qfVar3.f()) * 0.5f) + l), Math.round((m - this.l) - f4), Math.round(qfVar3.f()));
            } else {
                qfVar3.a(batch, this.l + k + f4, l + ((n - qfVar3.f()) * 0.5f), (m - this.l) - f4, qfVar3.f());
            }
        }
        if (G != null) {
            if (this.x) {
                G.a(batch, Math.round(k + this.l), Math.round(l + ((n - f9) * 0.5f)), Math.round(e), Math.round(f9));
            } else {
                G.a(batch, k + this.l, l + ((n - f9) * 0.5f), e, f9);
            }
        }
    }

    public float E() {
        float f = this.u;
        return f > 0.0f ? this.v.a(this.s, this.r, 1.0f - (f / this.t)) : this.r;
    }

    public float F() {
        if (this.p == this.q) {
            return 0.0f;
        }
        f fVar = this.w;
        float E = E();
        float f = this.p;
        return fVar.a((E - f) / (this.q - f));
    }

    protected qf G() {
        return (!this.n || this.o.d == null) ? this.o.c : this.o.d;
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        if (this.m) {
            qf G = G();
            return Math.max(G == null ? 0.0f : G.e(), ((!this.n || this.o.b == null) ? this.o.a : this.o.b).e());
        }
        return 140.0f;
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        if (this.m) {
            return 140.0f;
        }
        qf G = G();
        qf qfVar = (!this.n || this.o.b == null) ? this.o.a : this.o.b;
        return Math.max(G == null ? 0.0f : G.f(), qfVar != null ? qfVar.f() : 0.0f);
    }
}
