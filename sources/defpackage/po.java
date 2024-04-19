package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.r;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.z;
/* compiled from: Table.java */
/* renamed from: po  reason: default package */
/* loaded from: classes.dex */
public class po extends py {
    private static float[] n;
    private static float[] o;
    com.badlogic.gdx.utils.a<b> A;
    qf B;
    boolean C;
    private int H;
    private boolean I;
    private final com.badlogic.gdx.utils.a<pa> J;
    private final pa K;
    private final com.badlogic.gdx.utils.a<pa> L;
    private pa M;
    private boolean N;
    private float[] O;
    private float[] P;
    private float[] Q;
    private float[] R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float[] W;
    private float[] X;
    private float[] Y;
    private float[] Z;
    private boolean aa;
    private pl ab;
    private int p;
    pw u;
    pw v;
    pw w;
    pw x;
    int y;
    a z;
    public static ka q = new ka(0.0f, 0.0f, 1.0f, 1.0f);
    public static ka r = new ka(1.0f, 0.0f, 0.0f, 1.0f);
    public static ka s = new ka(0.0f, 1.0f, 0.0f, 1.0f);
    static final z<pa> t = new z<pa>() { // from class: po.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.badlogic.gdx.utils.z
        /* renamed from: a */
        public pa newObject() {
            return new pa();
        }
    };
    public static pw D = new pw() { // from class: po.2
        @Override // defpackage.pw
        public float a(ok okVar) {
            qf qfVar = ((po) okVar).B;
            if (qfVar == null) {
                return 0.0f;
            }
            return qfVar.c();
        }
    };
    public static pw E = new pw() { // from class: po.3
        @Override // defpackage.pw
        public float a(ok okVar) {
            qf qfVar = ((po) okVar).B;
            if (qfVar == null) {
                return 0.0f;
            }
            return qfVar.a();
        }
    };
    public static pw F = new pw() { // from class: po.4
        @Override // defpackage.pw
        public float a(ok okVar) {
            qf qfVar = ((po) okVar).B;
            if (qfVar == null) {
                return 0.0f;
            }
            return qfVar.d();
        }
    };
    public static pw G = new pw() { // from class: po.5
        @Override // defpackage.pw
        public float a(ok okVar) {
            qf qfVar = ((po) okVar).B;
            if (qfVar == null) {
                return 0.0f;
            }
            return qfVar.b();
        }
    };

    /* compiled from: Table.java */
    /* renamed from: po$a */
    /* loaded from: classes.dex */
    public enum a {
        none,
        all,
        table,
        cell,
        actor
    }

    /* compiled from: Table.java */
    /* renamed from: po$b */
    /* loaded from: classes.dex */
    public static class b extends n {
        static z<b> a = aa.a(b.class);
        ka b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ok
    public void b(r rVar) {
    }

    public po() {
        this(null);
    }

    public po(pl plVar) {
        this.J = new com.badlogic.gdx.utils.a<>(4);
        this.L = new com.badlogic.gdx.utils.a<>(2);
        this.N = true;
        this.u = D;
        this.v = E;
        this.w = F;
        this.x = G;
        this.y = 1;
        this.z = a.none;
        this.C = true;
        this.ab = plVar;
        this.K = K();
        b(false);
        a(or.childrenOnly);
    }

    private pa K() {
        pa obtain = t.obtain();
        obtain.a(this);
        return obtain;
    }

    @Override // defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        if (F()) {
            a(batch, B());
            a(batch, f, 0.0f, 0.0f);
            if (this.aa) {
                batch.flush();
                float a2 = this.v.a(this);
                float a3 = this.w.a(this);
                if (b(a2, a3, (m() - a2) - this.x.a(this), (n() - a3) - this.u.a(this))) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Batch batch, float f, float f2, float f3) {
        if (this.B == null) {
            return;
        }
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        this.B.a(batch, f2, f3, m(), n());
    }

    public void a(qf qfVar) {
        if (this.B == qfVar) {
            return;
        }
        float S = S();
        float T = T();
        float U = U();
        float V = V();
        this.B = qfVar;
        float S2 = S();
        float T2 = T();
        float U2 = U();
        float V2 = V();
        if (S + U != S2 + U2 || T + V != T2 + V2) {
            g_();
        } else if (S == S2 && T == T2 && U == U2 && V == V2) {
        } else {
            j_();
        }
    }

    @Override // defpackage.on, defpackage.ok
    public ok a(float f, float f2, boolean z) {
        if (!this.aa || (!(z && i() == or.disabled) && f >= 0.0f && f < m() && f2 >= 0.0f && f2 < n())) {
            return super.a(f, f2, z);
        }
        return null;
    }

    @Override // defpackage.py
    public void j_() {
        this.N = true;
        super.j_();
    }

    @Override // defpackage.on
    public boolean a(ok okVar, boolean z) {
        if (super.a(okVar, z)) {
            pa d = d((po) okVar);
            if (d != null) {
                d.w = null;
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.on
    public void D() {
        com.badlogic.gdx.utils.a<pa> aVar = this.J;
        for (int i = aVar.b - 1; i >= 0; i--) {
            ok okVar = aVar.a(i).w;
            if (okVar != null) {
                okVar.a();
            }
        }
        t.freeAll(aVar);
        aVar.d();
        this.H = 0;
        this.p = 0;
        pa paVar = this.M;
        if (paVar != null) {
            t.free(paVar);
        }
        this.M = null;
        this.I = false;
        super.D();
    }

    private void W() {
        com.badlogic.gdx.utils.a<pa> aVar = this.J;
        int i = 0;
        for (int i2 = aVar.b - 1; i2 >= 0; i2--) {
            pa a2 = aVar.a(i2);
            if (a2.B) {
                break;
            }
            i += a2.t.intValue();
        }
        this.p = Math.max(this.p, i);
        this.H++;
        aVar.b().B = true;
    }

    public <T extends ok> pa<T> d(T t2) {
        com.badlogic.gdx.utils.a<pa> aVar = this.J;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            pa<T> a2 = aVar.a(i2);
            if (a2.w == t2) {
                return a2;
            }
        }
        return null;
    }

    @Override // defpackage.py, defpackage.qh
    public float L() {
        if (this.N) {
            X();
        }
        float f = this.U;
        qf qfVar = this.B;
        return qfVar != null ? Math.max(f, qfVar.e()) : f;
    }

    @Override // defpackage.py, defpackage.qh
    public float M() {
        if (this.N) {
            X();
        }
        float f = this.V;
        qf qfVar = this.B;
        return qfVar != null ? Math.max(f, qfVar.f()) : f;
    }

    @Override // defpackage.py, defpackage.qh
    public float N() {
        if (this.N) {
            X();
        }
        return this.S;
    }

    @Override // defpackage.py, defpackage.qh
    public float O() {
        if (this.N) {
            X();
        }
        return this.T;
    }

    @Override // defpackage.ok
    public void a(boolean z) {
        a(z ? a.all : a.none);
    }

    @Override // defpackage.on
    /* renamed from: R */
    public po G() {
        super.G();
        return this;
    }

    public po a(a aVar) {
        super.a(aVar != a.none);
        if (this.z != aVar) {
            this.z = aVar;
            if (aVar == a.none) {
                Y();
            } else {
                j_();
            }
        }
        return this;
    }

    public float S() {
        return this.u.a(this);
    }

    public float T() {
        return this.v.a(this);
    }

    public float U() {
        return this.w.a(this);
    }

    public float V() {
        return this.x.a(this);
    }

    private float[] a(float[] fArr, int i) {
        if (fArr == null || fArr.length < i) {
            return new float[i];
        }
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = 0.0f;
        }
        return fArr;
    }

    @Override // defpackage.py
    public void f_() {
        float m = m();
        float n2 = n();
        c(0.0f, 0.0f, m, n2);
        com.badlogic.gdx.utils.a<pa> aVar = this.J;
        if (this.C) {
            int i = aVar.b;
            for (int i2 = 0; i2 < i; i2++) {
                pa a2 = aVar.a(i2);
                float round = Math.round(a2.z);
                float round2 = Math.round(a2.A);
                float round3 = Math.round(a2.x);
                float round4 = (n2 - Math.round(a2.y)) - round2;
                a2.a(round3, round4, round, round2);
                ok okVar = a2.w;
                if (okVar != null) {
                    okVar.a(round3, round4, round, round2);
                }
            }
        } else {
            int i3 = aVar.b;
            for (int i4 = 0; i4 < i3; i4++) {
                pa a3 = aVar.a(i4);
                float f = a3.A;
                float f2 = (n2 - a3.y) - f;
                a3.a(f2);
                ok okVar2 = a3.w;
                if (okVar2 != null) {
                    okVar2.a(a3.x, f2, a3.z, f);
                }
            }
        }
        ai<ok> E2 = E();
        int i5 = E2.b;
        for (int i6 = 0; i6 < i5; i6++) {
            ok a4 = E2.a(i6);
            if (a4 instanceof qh) {
                ((qh) a4).i_();
            }
        }
    }

    private void X() {
        float f;
        float[] fArr;
        float max;
        int i;
        this.N = false;
        com.badlogic.gdx.utils.a<pa> aVar = this.J;
        int i2 = aVar.b;
        if (i2 > 0 && !aVar.b().B) {
            W();
            this.I = true;
        }
        int i3 = this.p;
        int i4 = this.H;
        float[] a2 = a(this.O, i3);
        this.O = a2;
        float[] a3 = a(this.P, i4);
        this.P = a3;
        float[] a4 = a(this.Q, i3);
        this.Q = a4;
        float[] a5 = a(this.R, i4);
        this.R = a5;
        this.W = a(this.W, i3);
        this.X = a(this.X, i4);
        float[] a6 = a(this.Y, i3);
        this.Y = a6;
        float[] a7 = a(this.Z, i4);
        this.Z = a7;
        int i5 = 0;
        float f2 = 0.0f;
        while (i5 < i2) {
            pa a8 = aVar.a(i5);
            int i6 = a8.C;
            int i7 = a8.D;
            int intValue = a8.t.intValue();
            int i8 = i2;
            ok okVar = a8.w;
            int i9 = i5;
            if (a8.s.intValue() != 0 && a7[i7] == 0.0f) {
                a7[i7] = a8.s.intValue();
            }
            if (intValue == 1 && a8.r.intValue() != 0 && a6[i6] == 0.0f) {
                a6[i6] = a8.r.intValue();
            }
            float a9 = a8.l.a(okVar);
            if (i6 == 0) {
                fArr = a7;
                max = 0.0f;
            } else {
                fArr = a7;
                max = Math.max(0.0f, a8.h.a(okVar) - f2);
            }
            a8.G = a9 + max;
            a8.F = a8.k.a(okVar);
            if (a8.E != -1) {
                a8.F += Math.max(0.0f, a8.g.a(okVar) - aVar.a(a8.E).i.a(okVar));
            }
            float a10 = a8.j.a(okVar);
            a8.I = a8.n.a(okVar) + (i6 + intValue == i3 ? 0.0f : a10);
            a8.H = a8.m.a(okVar) + (i7 == i4 + (-1) ? 0.0f : a8.i.a(okVar));
            float a11 = a8.c.a(okVar);
            float a12 = a8.d.a(okVar);
            float a13 = a8.a.a(okVar);
            int i10 = i4;
            float a14 = a8.b.a(okVar);
            int i11 = i3;
            float a15 = a8.e.a(okVar);
            float[] fArr2 = a6;
            float a16 = a8.f.a(okVar);
            if (a11 < a13) {
                a11 = a13;
            }
            if (a12 < a14) {
                a12 = a14;
            }
            if (a15 <= 0.0f || a11 <= a15) {
                a15 = a11;
            }
            if (a16 <= 0.0f || a12 <= a16) {
                a16 = a12;
                i = 1;
            } else {
                i = 1;
            }
            if (intValue == i) {
                float f3 = a8.G + a8.I;
                a4[i6] = Math.max(a4[i6], a15 + f3);
                a2[i6] = Math.max(a2[i6], a13 + f3);
            }
            float f4 = a8.F + a8.H;
            a5[i7] = Math.max(a5[i7], a16 + f4);
            a3[i7] = Math.max(a3[i7], a14 + f4);
            i5 = i9 + 1;
            i2 = i8;
            a7 = fArr;
            f2 = a10;
            i4 = i10;
            i3 = i11;
            a6 = fArr2;
        }
        int i12 = i3;
        int i13 = i4;
        float[] fArr3 = a6;
        int i14 = i2;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i15 = 0; i15 < i14; i15++) {
            pa a17 = aVar.a(i15);
            int i16 = a17.C;
            int intValue2 = a17.r.intValue();
            if (intValue2 != 0) {
                int intValue3 = a17.t.intValue() + i16;
                int i17 = i16;
                while (true) {
                    if (i17 >= intValue3) {
                        int i18 = i16;
                        while (i18 < intValue3) {
                            fArr3[i18] = intValue2;
                            i18++;
                            intValue3 = intValue3;
                        }
                    } else if (fArr3[i17] != 0.0f) {
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            if (a17.u == Boolean.TRUE && a17.t.intValue() == 1) {
                float f9 = a17.G + a17.I;
                f7 = Math.max(f7, a2[i16] - f9);
                f5 = Math.max(f5, a4[i16] - f9);
            }
            if (a17.v == Boolean.TRUE) {
                float f10 = a17.F + a17.H;
                f8 = Math.max(f8, a3[a17.D] - f10);
                f6 = Math.max(f6, a5[a17.D] - f10);
            }
        }
        int i19 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        if (i19 > 0 || f6 > 0.0f) {
            for (int i20 = 0; i20 < i14; i20++) {
                pa a18 = aVar.a(i20);
                if (i19 > 0 && a18.u == Boolean.TRUE && a18.t.intValue() == 1) {
                    float f11 = a18.G + a18.I;
                    a2[a18.C] = f7 + f11;
                    a4[a18.C] = f11 + f5;
                    f = 0.0f;
                } else {
                    f = 0.0f;
                }
                if (f6 > f && a18.v == Boolean.TRUE) {
                    float f12 = a18.F + a18.H;
                    a3[a18.D] = f8 + f12;
                    a5[a18.D] = f12 + f6;
                }
            }
        }
        for (int i21 = 0; i21 < i14; i21++) {
            pa a19 = aVar.a(i21);
            int intValue4 = a19.t.intValue();
            if (intValue4 != 1) {
                int i22 = a19.C;
                ok okVar2 = a19.w;
                float a20 = a19.a.a(okVar2);
                float a21 = a19.c.a(okVar2);
                float a22 = a19.e.a(okVar2);
                if (a21 < a20) {
                    a21 = a20;
                }
                if (a22 <= 0.0f || a21 <= a22) {
                    a22 = a21;
                }
                int i23 = i22 + intValue4;
                float f13 = -(a19.G + a19.I);
                float f14 = f13;
                float f15 = 0.0f;
                for (int i24 = i22; i24 < i23; i24++) {
                    f13 += a2[i24];
                    f14 += a4[i24];
                    f15 += fArr3[i24];
                }
                float f16 = 0.0f;
                float max2 = Math.max(0.0f, a20 - f13);
                float max3 = Math.max(0.0f, a22 - f14);
                while (i22 < i23) {
                    float f17 = f15 == f16 ? 1.0f / intValue4 : fArr3[i22] / f15;
                    a2[i22] = a2[i22] + (max2 * f17);
                    a4[i22] = a4[i22] + (f17 * max3);
                    i22++;
                    f16 = 0.0f;
                }
            }
        }
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = 0.0f;
        for (int i25 = 0; i25 < i12; i25++) {
            this.S += a2[i25];
            this.U += a4[i25];
        }
        for (int i26 = 0; i26 < i13; i26++) {
            this.T += a3[i26];
            this.V += Math.max(a3[i26], a5[i26]);
        }
        float a23 = this.v.a(this) + this.x.a(this);
        float a24 = this.u.a(this) + this.w.a(this);
        this.S += a23;
        this.T += a24;
        this.U = Math.max(this.U + a23, this.S);
        this.V = Math.max(this.V + a24, this.T);
    }

    private void c(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i;
        float f7;
        int i2;
        float[] fArr4;
        char c;
        com.badlogic.gdx.utils.a<pa> aVar = this.J;
        int i3 = aVar.b;
        if (this.N) {
            X();
        }
        float a2 = this.v.a(this);
        float a3 = a2 + this.x.a(this);
        float a4 = this.u.a(this);
        float a5 = a4 + this.w.a(this);
        int i4 = this.p;
        int i5 = this.H;
        float[] fArr5 = this.Y;
        float[] fArr6 = this.Z;
        float[] fArr7 = this.W;
        float[] fArr8 = this.X;
        float f8 = 0.0f;
        for (int i6 = 0; i6 < i4; i6++) {
            f8 += fArr5[i6];
        }
        float f9 = 0.0f;
        for (int i7 = 0; i7 < i5; i7++) {
            f9 += fArr6[i7];
        }
        float f10 = this.U;
        float f11 = this.S;
        float f12 = f10 - f11;
        if (f12 == 0.0f) {
            fArr2 = this.O;
            f6 = a2;
            f5 = a4;
            fArr = fArr6;
        } else {
            float min = Math.min(f12, Math.max(0.0f, f3 - f11));
            float[] a6 = a(n, i4);
            n = a6;
            f5 = a4;
            float[] fArr9 = this.O;
            f6 = a2;
            float[] fArr10 = this.Q;
            fArr = fArr6;
            for (int i8 = 0; i8 < i4; i8++) {
                a6[i8] = fArr9[i8] + (((fArr10[i8] - fArr9[i8]) / f12) * min);
            }
            fArr2 = a6;
        }
        float f13 = this.V - this.T;
        if (f13 == 0.0f) {
            fArr3 = this.P;
        } else {
            float[] a7 = a(o, i5);
            o = a7;
            float min2 = Math.min(f13, Math.max(0.0f, f4 - this.T));
            float[] fArr11 = this.P;
            float[] fArr12 = this.R;
            for (int i9 = 0; i9 < i5; i9++) {
                a7[i9] = fArr11[i9] + (((fArr12[i9] - fArr11[i9]) / f13) * min2);
            }
            fArr3 = a7;
        }
        int i10 = 0;
        while (i10 < i3) {
            pa a8 = aVar.a(i10);
            int i11 = a8.C;
            int i12 = a8.D;
            ok okVar = a8.w;
            com.badlogic.gdx.utils.a<pa> aVar2 = aVar;
            int intValue = a8.t.intValue();
            int i13 = i3;
            int i14 = i11 + intValue;
            int i15 = i5;
            float f14 = a5;
            float f15 = 0.0f;
            for (int i16 = i11; i16 < i14; i16++) {
                f15 += fArr2[i16];
            }
            float f16 = fArr3[i12];
            float a9 = a8.c.a(okVar);
            float[] fArr13 = fArr3;
            float a10 = a8.d.a(okVar);
            float[] fArr14 = fArr2;
            float a11 = a8.a.a(okVar);
            float[] fArr15 = fArr5;
            float a12 = a8.b.a(okVar);
            int i17 = i4;
            float a13 = a8.e.a(okVar);
            float f17 = a3;
            float a14 = a8.f.a(okVar);
            if (a9 >= a11) {
                a11 = a9;
            }
            if (a10 < a12) {
                a10 = a12;
            }
            if (a13 > 0.0f && a11 > a13) {
                a11 = a13;
            }
            if (a14 > 0.0f && a10 > a14) {
                a10 = a14;
            }
            a8.z = Math.min((f15 - a8.G) - a8.I, a11);
            a8.A = Math.min((f16 - a8.F) - a8.H, a10);
            if (intValue == 1) {
                fArr7[i11] = Math.max(fArr7[i11], f15);
            }
            fArr8[i12] = Math.max(fArr8[i12], f16);
            i10++;
            aVar = aVar2;
            i3 = i13;
            i5 = i15;
            a5 = f14;
            fArr3 = fArr13;
            fArr2 = fArr14;
            fArr5 = fArr15;
            i4 = i17;
            a3 = f17;
        }
        int i18 = i4;
        int i19 = i5;
        float[] fArr16 = fArr5;
        com.badlogic.gdx.utils.a<pa> aVar3 = aVar;
        int i20 = i3;
        float f18 = a3;
        float f19 = a5;
        float[] fArr17 = fArr2;
        float f20 = 0.0f;
        if (f8 > 0.0f) {
            float f21 = f3 - f18;
            i = i18;
            for (int i21 = 0; i21 < i; i21++) {
                f21 -= fArr7[i21];
            }
            if (f21 > 0.0f) {
                float f22 = 0.0f;
                int i22 = 0;
                int i23 = 0;
                while (i22 < i) {
                    if (fArr16[i22] != f20) {
                        float f23 = (fArr16[i22] * f21) / f8;
                        fArr7[i22] = fArr7[i22] + f23;
                        f22 += f23;
                        i23 = i22;
                    }
                    i22++;
                    f20 = 0.0f;
                }
                fArr7[i23] = fArr7[i23] + (f21 - f22);
                f7 = 0.0f;
            } else {
                f7 = 0.0f;
            }
        } else {
            i = i18;
            f7 = 0.0f;
        }
        if (f9 > f7) {
            float f24 = f4 - f19;
            i2 = i19;
            for (int i24 = 0; i24 < i2; i24++) {
                f24 -= fArr8[i24];
            }
            if (f24 > f7) {
                float f25 = f7;
                int i25 = 0;
                int i26 = 0;
                while (i25 < i2) {
                    if (fArr[i25] != f7) {
                        float f26 = (fArr[i25] * f24) / f9;
                        fArr8[i25] = fArr8[i25] + f26;
                        f25 += f26;
                        i26 = i25;
                    }
                    i25++;
                    f7 = 0.0f;
                }
                fArr8[i26] = fArr8[i26] + (f24 - f25);
            }
        } else {
            i2 = i19;
        }
        int i27 = 0;
        while (i27 < i20) {
            com.badlogic.gdx.utils.a<pa> aVar4 = aVar3;
            pa a15 = aVar4.a(i27);
            int intValue2 = a15.t.intValue();
            if (intValue2 != 1) {
                int i28 = a15.C;
                int i29 = i28 + intValue2;
                float f27 = 0.0f;
                while (i28 < i29) {
                    f27 += fArr17[i28] - fArr7[i28];
                    i28++;
                }
                float max = (f27 - Math.max(0.0f, a15.G + a15.I)) / intValue2;
                if (max > 0.0f) {
                    int i30 = a15.C;
                    int i31 = intValue2 + i30;
                    while (i30 < i31) {
                        fArr7[i30] = fArr7[i30] + max;
                        i30++;
                    }
                }
            }
            i27++;
            aVar3 = aVar4;
        }
        com.badlogic.gdx.utils.a<pa> aVar5 = aVar3;
        float f28 = f18;
        for (int i32 = 0; i32 < i; i32++) {
            f28 += fArr7[i32];
        }
        float f29 = f19;
        for (int i33 = 0; i33 < i2; i33++) {
            f29 += fArr8[i33];
        }
        int i34 = this.y;
        float f30 = f + f6;
        float f31 = (i34 & 16) != 0 ? f30 + (f3 - f28) : (i34 & 8) == 0 ? f30 + ((f3 - f28) / 2.0f) : f30;
        float f32 = f2 + f5;
        float f33 = (i34 & 4) != 0 ? f32 + (f4 - f29) : (i34 & 2) == 0 ? f32 + ((f4 - f29) / 2.0f) : f32;
        float f34 = f31;
        float f35 = f33;
        int i35 = 0;
        while (i35 < i20) {
            pa a16 = aVar5.a(i35);
            int i36 = a16.C;
            int intValue3 = a16.t.intValue() + i36;
            float f36 = 0.0f;
            while (i36 < intValue3) {
                f36 += fArr7[i36];
                i36++;
            }
            float f37 = f36 - (a16.G + a16.I);
            float f38 = f34 + a16.G;
            float floatValue = a16.o.floatValue();
            float floatValue2 = a16.p.floatValue();
            if (floatValue > 0.0f) {
                fArr4 = fArr7;
                a16.z = Math.max(floatValue * f37, a16.a.a(a16.w));
                float a17 = a16.e.a(a16.w);
                if (a17 > 0.0f) {
                    a16.z = Math.min(a16.z, a17);
                }
            } else {
                fArr4 = fArr7;
            }
            if (floatValue2 > 0.0f) {
                a16.A = Math.max(((fArr8[a16.D] * floatValue2) - a16.F) - a16.H, a16.b.a(a16.w));
                float a18 = a16.f.a(a16.w);
                if (a18 > 0.0f) {
                    a16.A = Math.min(a16.A, a18);
                }
            }
            int intValue4 = a16.q.intValue();
            if ((intValue4 & 8) != 0) {
                a16.x = f38;
            } else if ((intValue4 & 16) != 0) {
                a16.x = (f38 + f37) - a16.z;
            } else {
                a16.x = ((f37 - a16.z) / 2.0f) + f38;
            }
            if ((intValue4 & 2) != 0) {
                a16.y = a16.F + f35;
                c = 0;
            } else if ((intValue4 & 4) != 0) {
                a16.y = ((fArr8[a16.D] + f35) - a16.A) - a16.H;
                c = 0;
            } else {
                c = 0;
                a16.y = ((((fArr8[a16.D] - a16.A) + a16.F) - a16.H) / 2.0f) + f35;
            }
            if (a16.B) {
                f35 += fArr8[a16.D];
                f34 = f31;
            } else {
                f34 = f38 + f37 + a16.I;
            }
            i35++;
            fArr7 = fArr4;
        }
        float[] fArr18 = fArr7;
        if (this.z == a.none) {
            return;
        }
        Y();
        if (this.z == a.table || this.z == a.all) {
            a(f, f2, f3, f4, q);
            a(f31, f33, f28 - f18, f29 - f19, q);
        }
        float f39 = f31;
        for (int i37 = 0; i37 < i20; i37++) {
            pa a19 = aVar5.a(i37);
            if (this.z == a.actor || this.z == a.all) {
                a(a19.x, a19.y, a19.z, a19.A, s);
            }
            int i38 = a19.C;
            int intValue5 = a19.t.intValue() + i38;
            float f40 = 0.0f;
            while (i38 < intValue5) {
                f40 += fArr18[i38];
                i38++;
            }
            float f41 = f40 - (a19.G + a19.I);
            float f42 = f39 + a19.G;
            if (this.z == a.cell || this.z == a.all) {
                a(f42, f33 + a19.F, f41, (fArr8[a19.D] - a19.F) - a19.H, r);
            }
            if (a19.B) {
                f33 += fArr8[a19.D];
                f39 = f31;
            } else {
                f39 = f42 + f41 + a19.I;
            }
        }
    }

    private void Y() {
        if (this.A == null) {
            return;
        }
        b.a.freeAll(this.A);
        this.A.d();
    }

    private void a(float f, float f2, float f3, float f4, ka kaVar) {
        if (this.A == null) {
            this.A = new com.badlogic.gdx.utils.a<>();
        }
        b obtain = b.a.obtain();
        obtain.b = kaVar;
        obtain.set(f, (n() - f2) - f4, f3, f4);
        this.A.a((com.badlogic.gdx.utils.a<b>) obtain);
    }

    @Override // defpackage.on, defpackage.ok
    public void a(r rVar) {
        float f;
        if (F()) {
            a(rVar, B());
            e(rVar);
            if (this.aa) {
                rVar.d();
                float m = m();
                float n2 = n();
                float f2 = 0.0f;
                if (this.B != null) {
                    f2 = this.v.a(this);
                    f = this.w.a(this);
                    m -= this.x.a(this) + f2;
                    n2 -= this.u.a(this) + f;
                } else {
                    f = 0.0f;
                }
                if (b(f2, f, m, n2)) {
                    c(rVar);
                    z();
                }
            } else {
                c(rVar);
            }
            d(rVar);
            return;
        }
        e(rVar);
        super.a(rVar);
    }

    private void e(r rVar) {
        float f;
        if (this.A == null || !A()) {
            return;
        }
        rVar.b(r.a.Line);
        rVar.a(e().l());
        float f2 = 0.0f;
        if (F()) {
            f = 0.0f;
        } else {
            f2 = k();
            f = l();
        }
        int i = this.A.b;
        for (int i2 = 0; i2 < i; i2++) {
            b a2 = this.A.a(i2);
            rVar.a(a2.b);
            rVar.a(a2.x + f2, a2.y + f, a2.width, a2.height);
        }
    }
}
