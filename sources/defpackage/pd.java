package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.ae;
/* compiled from: Image.java */
/* renamed from: pd  reason: default package */
/* loaded from: classes.dex */
public class pd extends px {
    private ae l;
    private int m;
    private float n;
    private float o;
    private float p;
    private float q;
    private qf r;

    @Override // defpackage.px, defpackage.qh
    public float N() {
        return 0.0f;
    }

    @Override // defpackage.px, defpackage.qh
    public float O() {
        return 0.0f;
    }

    @Override // defpackage.px
    public void B() {
        qf qfVar = this.r;
        if (qfVar == null) {
            return;
        }
        float e = qfVar.e();
        float f = this.r.f();
        float m = m();
        float n = n();
        o apply = this.l.apply(e, f, m, n);
        this.p = apply.d;
        this.q = apply.e;
        int i = this.m;
        if ((i & 8) != 0) {
            this.n = 0.0f;
        } else if ((i & 16) != 0) {
            this.n = (int) (m - this.p);
        } else {
            this.n = (int) ((m / 2.0f) - (this.p / 2.0f));
        }
        int i2 = this.m;
        if ((i2 & 2) != 0) {
            this.o = (int) (n - this.q);
        } else if ((i2 & 4) != 0) {
            this.o = 0.0f;
        } else {
            this.o = (int) ((n / 2.0f) - (this.q / 2.0f));
        }
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        float k = k();
        float l = l();
        float u = u();
        float v = v();
        if (this.r instanceof qo) {
            float w = w();
            if (u != 1.0f || v != 1.0f || w != 0.0f) {
                ((qo) this.r).a(batch, k + this.n, l + this.o, s() - this.n, t() - this.o, this.p, this.q, u, v, w);
                return;
            }
        }
        qf qfVar = this.r;
        if (qfVar != null) {
            qfVar.a(batch, k + this.n, l + this.o, this.p * u, this.q * v);
        }
    }

    public void a(qf qfVar) {
        if (this.r == qfVar) {
            return;
        }
        if (qfVar != null) {
            if (L() != qfVar.e() || M() != qfVar.f()) {
                g_();
            }
        } else {
            g_();
        }
        this.r = qfVar;
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        qf qfVar = this.r;
        if (qfVar != null) {
            return qfVar.e();
        }
        return 0.0f;
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        qf qfVar = this.r;
        if (qfVar != null) {
            return qfVar.f();
        }
        return 0.0f;
    }
}
