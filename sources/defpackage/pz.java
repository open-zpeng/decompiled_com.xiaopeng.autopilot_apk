package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.o;
/* compiled from: Window.java */
/* renamed from: pz  reason: default package */
/* loaded from: classes.dex */
public class pz extends po {
    private static final o I = new o();
    private static final o J = new o();
    boolean H;
    private a K;
    boolean n;
    boolean o;
    po p;

    /* compiled from: Window.java */
    /* renamed from: pz$a */
    /* loaded from: classes.dex */
    public static class a {
        public ka a = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        public qf b;
    }

    public void K() {
        oq e;
        if (this.o && (e = e()) != null) {
            jz i = e.i();
            if (i instanceof kk) {
                kk kkVar = (kk) i;
                float g = e.g();
                float h = e.h();
                float f = g / 2.0f;
                if (a(16) - i.a.a > f / kkVar.m) {
                    a(i.a.a + (f / kkVar.m), b(16), 16);
                }
                if (a(8) - i.a.a < ((-g) / 2.0f) / kkVar.m) {
                    a(i.a.a - (f / kkVar.m), b(8), 8);
                }
                float f2 = h / 2.0f;
                if (b(2) - i.a.b > f2 / kkVar.m) {
                    a(a(2), i.a.b + (f2 / kkVar.m), 2);
                }
                if (b(4) - i.a.b < ((-h) / 2.0f) / kkVar.m) {
                    a(a(4), i.a.b - (f2 / kkVar.m), 4);
                }
            } else if (g() == e.j()) {
                float g2 = e.g();
                float h2 = e.h();
                if (k() < 0.0f) {
                    a(0.0f);
                }
                if (p() > g2) {
                    a(g2 - m());
                }
                if (l() < 0.0f) {
                    b(0.0f);
                }
                if (o() > h2) {
                    b(h2 - n());
                }
            }
        }
    }

    @Override // defpackage.po, defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        oq e = e();
        if (e.e() == null) {
            e.d(this);
        }
        K();
        if (this.K.b != null) {
            a(I.a(0.0f, 0.0f));
            a(J.a(e.g(), e.h()));
            a(batch, f, k() + I.d, l() + I.e, k() + J.d, l() + J.e);
        }
        super.a(batch, f);
    }

    protected void a(Batch batch, float f, float f2, float f3, float f4, float f5) {
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        this.K.b.a(batch, f2, f3, f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.po
    public void a(Batch batch, float f, float f2, float f3) {
        super.a(batch, f, f2, f3);
        this.p.x().M = x().M;
        float S = S();
        float T = T();
        this.p.c((m() - T) - V(), S);
        this.p.a(T, n() - S);
        this.H = true;
        this.p.a(batch, f);
        this.H = false;
    }

    @Override // defpackage.po, defpackage.on, defpackage.ok
    public ok a(float f, float f2, boolean z) {
        if (j()) {
            ok a2 = super.a(f, f2, z);
            if (a2 == null && this.n && (!z || i() == or.enabled)) {
                return this;
            }
            float n = n();
            if (a2 != null && a2 != this && f2 <= n && f2 >= n - S() && f >= 0.0f && f <= m()) {
                ok okVar = a2;
                while (okVar.g() != this) {
                    okVar = okVar.g();
                }
                if (d((pz) okVar) != null) {
                    return this;
                }
            }
            return a2;
        }
        return null;
    }

    @Override // defpackage.po, defpackage.py, defpackage.qh
    public float L() {
        return Math.max(super.L(), this.p.L() + T() + V());
    }
}
