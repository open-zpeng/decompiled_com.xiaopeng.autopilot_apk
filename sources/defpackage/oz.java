package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.ai;
/* compiled from: Button.java */
/* renamed from: oz  reason: default package */
/* loaded from: classes.dex */
public class oz extends po {
    private a H;
    private qd I;
    boolean n;
    boolean o;
    boolean p;

    /* compiled from: Button.java */
    /* renamed from: oz$a */
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
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
    }

    public boolean H() {
        return this.n;
    }

    public boolean d_() {
        return this.I.c();
    }

    public boolean e_() {
        return this.I.d();
    }

    public boolean K() {
        return this.o;
    }

    @Override // defpackage.po, defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        qf qfVar;
        float f2;
        float f3;
        i_();
        boolean K = K();
        boolean d_ = d_();
        boolean H = H();
        boolean e_ = e_();
        if (K && this.H.h != null) {
            qfVar = this.H.h;
        } else if (d_ && this.H.b != null) {
            qfVar = this.H.b;
        } else if (H && this.H.e != null) {
            if (this.H.f != null && e_) {
                qfVar = this.H.f;
            } else if (this.H.g != null && this.p) {
                qfVar = this.H.g;
            } else {
                qfVar = this.H.e;
            }
        } else if (e_ && this.H.c != null) {
            qfVar = this.H.c;
        } else if (this.p && this.H.d != null) {
            qfVar = this.H.d;
        } else {
            qfVar = this.H.a != null ? this.H.a : null;
        }
        a(qfVar);
        if (d_ && !K) {
            f2 = this.H.i;
            f3 = this.H.j;
        } else if (H && !K) {
            f2 = this.H.m;
            f3 = this.H.n;
        } else {
            f2 = this.H.k;
            f3 = this.H.l;
        }
        ai<ok> E = E();
        for (int i = 0; i < E.b; i++) {
            E.a(i).b(f2, f3);
        }
        super.a(batch, f);
        for (int i2 = 0; i2 < E.b; i2++) {
            E.a(i2).b(-f2, -f3);
        }
        oq e = e();
        if (e == null || !e.k() || d_ == this.I.b()) {
            return;
        }
        io.b.requestRendering();
    }

    @Override // defpackage.po, defpackage.py, defpackage.qh
    public float L() {
        float L = super.L();
        if (this.H.a != null) {
            L = Math.max(L, this.H.a.e());
        }
        if (this.H.b != null) {
            L = Math.max(L, this.H.b.e());
        }
        return this.H.e != null ? Math.max(L, this.H.e.e()) : L;
    }

    @Override // defpackage.po, defpackage.py, defpackage.qh
    public float M() {
        float M = super.M();
        if (this.H.a != null) {
            M = Math.max(M, this.H.a.f());
        }
        if (this.H.b != null) {
            M = Math.max(M, this.H.b.f());
        }
        return this.H.e != null ? Math.max(M, this.H.e.f()) : M;
    }

    @Override // defpackage.po, defpackage.py, defpackage.qh
    public float N() {
        return L();
    }

    @Override // defpackage.po, defpackage.py, defpackage.qh
    public float O() {
        return M();
    }
}
