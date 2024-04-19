package defpackage;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.i;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ah;
import com.badlogic.gdx.utils.h;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.n;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.ni;
import java.util.Iterator;
/* compiled from: MeshBuilder.java */
/* renamed from: nh  reason: default package */
/* loaded from: classes.dex */
public class nh implements ni {
    private int A;
    private float[] G;
    private kt h;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private ly w;
    private static final ah a = new ah();
    private static final h b = new h();
    private static final p M = new p();
    private static n O = null;
    private final ni.a c = new ni.a();
    private final ni.a d = new ni.a();
    private final ni.a e = new ni.a();
    private final ni.a f = new ni.a();
    private final ka g = new ka();
    private h i = new h();
    private ah j = new ah();
    private a<ly> x = new a<>();
    private final ka y = new ka(ka.a);
    private boolean z = false;
    private float B = 0.0f;
    private float C = 1.0f;
    private float D = 0.0f;
    private float E = 1.0f;
    private boolean F = false;
    private boolean H = false;
    private final Matrix4 I = new Matrix4();
    private final i J = new i();
    private final nz K = new nz();
    private short L = -1;
    private final p N = new p();

    public static kt a(long j) {
        a aVar = new a();
        if ((j & 1) == 1) {
            aVar.a((a) new ks(1, 3, "a_position"));
        }
        if ((j & 2) == 2) {
            aVar.a((a) new ks(2, 4, "a_color"));
        }
        if ((j & 4) == 4) {
            aVar.a((a) new ks(4, 4, "a_color"));
        }
        if ((j & 8) == 8) {
            aVar.a((a) new ks(8, 3, "a_normal"));
        }
        if ((j & 16) == 16) {
            aVar.a((a) new ks(16, 2, "a_texCoord0"));
        }
        ks[] ksVarArr = new ks[aVar.b];
        for (int i = 0; i < ksVarArr.length; i++) {
            ksVarArr[i] = (ks) aVar.a(i);
        }
        return new kt(ksVarArr);
    }

    public void a(kt ktVar) {
        a(ktVar, -1);
    }

    public void a(long j, int i) {
        a(a(j), i);
    }

    public void a(kt ktVar, int i) {
        if (this.h != null) {
            throw new RuntimeException("Call end() first");
        }
        this.h = ktVar;
        this.i.b();
        this.j.a();
        this.x.d();
        this.l = 0;
        this.L = (short) -1;
        this.m = 0;
        this.w = null;
        this.k = ktVar.a / 4;
        float[] fArr = this.G;
        if (fArr == null || fArr.length < this.k) {
            this.G = new float[this.k];
        }
        ks a2 = ktVar.a(1);
        if (a2 == null) {
            throw new k("Cannot build mesh without position attribute");
        }
        this.n = a2.e / 4;
        this.o = a2.b;
        ks a3 = ktVar.a(8);
        this.p = a3 == null ? -1 : a3.e / 4;
        ks a4 = ktVar.a(IRadioController.TEF663x_PCHANNEL);
        this.q = a4 == null ? -1 : a4.e / 4;
        ks a5 = ktVar.a(128);
        this.r = a5 == null ? -1 : a5.e / 4;
        ks a6 = ktVar.a(2);
        this.s = a6 == null ? -1 : a6.e / 4;
        this.t = a6 != null ? a6.b : 0;
        ks a7 = ktVar.a(4);
        this.u = a7 == null ? -1 : a7.e / 4;
        ks a8 = ktVar.a(16);
        this.v = a8 != null ? a8.e / 4 : -1;
        a((ka) null);
        a((Matrix4) null);
        a((TextureRegion) null);
        this.A = i;
        this.K.a();
    }

    private void g() {
        ly lyVar = this.w;
        if (lyVar != null) {
            this.K.a(lyVar.f);
            this.K.j(this.w.g).a(0.5f);
            ly lyVar2 = this.w;
            lyVar2.h = lyVar2.g.b();
            this.K.a();
            ly lyVar3 = this.w;
            lyVar3.c = this.m;
            lyVar3.d = this.j.b - this.m;
            this.m = this.j.b;
            this.w = null;
        }
    }

    public ly a(String str, int i) {
        return a(str, i, new ly());
    }

    public ly a(String str, int i, ly lyVar) {
        if (this.h == null) {
            throw new RuntimeException("Call begin() first");
        }
        g();
        this.w = lyVar;
        ly lyVar2 = this.w;
        lyVar2.a = str;
        lyVar2.b = i;
        this.A = i;
        this.x.a((a<ly>) lyVar2);
        a((ka) null);
        a((Matrix4) null);
        a((TextureRegion) null);
        return this.w;
    }

    public kj a(kj kjVar) {
        g();
        kt ktVar = this.h;
        if (ktVar == null) {
            throw new k("Call begin() first");
        }
        if (!ktVar.equals(kjVar.f())) {
            throw new k("Mesh attributes don't match");
        }
        if (kjVar.c() * this.k < this.i.b) {
            throw new k("Mesh can't hold enough vertices: " + kjVar.c() + " * " + this.k + " < " + this.i.b);
        } else if (kjVar.d() < this.j.b) {
            throw new k("Mesh can't hold enough indices: " + kjVar.d() + " < " + this.j.b);
        } else {
            kjVar.a(this.i.a, 0, this.i.b);
            kjVar.a(this.j.a, 0, this.j.b);
            Iterator<ly> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().e = kjVar;
            }
            this.x.d();
            this.h = null;
            this.i.b();
            this.j.a();
            return kjVar;
        }
    }

    public kj a() {
        return a(new kj(true, this.i.b / this.k, this.j.b, this.h));
    }

    public int b() {
        return this.i.b / this.k;
    }

    public int c() {
        return this.j.b;
    }

    @Override // defpackage.ni
    public kt d() {
        return this.h;
    }

    @Override // defpackage.ni
    public int e() {
        return this.A;
    }

    @Override // defpackage.ni
    public void a(ka kaVar) {
        ka kaVar2 = this.y;
        boolean z = kaVar != null;
        this.z = z;
        if (!z) {
            kaVar = ka.a;
        }
        kaVar2.a(kaVar);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.B = f;
        this.D = f2;
        this.C = f3 - f;
        this.E = f4 - f2;
        this.F = (com.badlogic.gdx.math.h.f(f) && com.badlogic.gdx.math.h.f(f2) && com.badlogic.gdx.math.h.a(f3, 1.0f) && com.badlogic.gdx.math.h.a(f4, 1.0f)) ? false : true;
    }

    public void a(TextureRegion textureRegion) {
        boolean z = textureRegion != null;
        this.F = z;
        if (!z) {
            this.D = 0.0f;
            this.B = 0.0f;
            this.E = 1.0f;
            this.C = 1.0f;
            return;
        }
        a(textureRegion.getU(), textureRegion.getV(), textureRegion.getU2(), textureRegion.getV2());
    }

    public void a(Matrix4 matrix4) {
        this.H = matrix4 != null;
        if (this.H) {
            this.I.a(matrix4);
            this.J.a(matrix4).c().d();
            return;
        }
        this.I.c();
        this.J.a();
    }

    @Override // defpackage.ni
    public void a(int i) {
        this.i.b(this.k * i);
    }

    @Override // defpackage.ni
    public void b(int i) {
        this.j.c(i);
    }

    @Override // defpackage.ni
    public void c(int i) {
        int i2 = this.A;
        if (i2 == 0) {
            b(i * 4);
        } else if (i2 == 1) {
            b(i * 8);
        } else {
            b(i * 6);
        }
    }

    public short f() {
        return this.L;
    }

    private static final void a(float[] fArr, int i, int i2, Matrix4 matrix4) {
        if (i2 > 2) {
            int i3 = i + 1;
            int i4 = i + 2;
            M.a(fArr[i], fArr[i3], fArr[i4]).a(matrix4);
            fArr[i] = M.a;
            fArr[i3] = M.b;
            fArr[i4] = M.c;
        } else if (i2 > 1) {
            int i5 = i + 1;
            M.a(fArr[i], fArr[i5], 0.0f).a(matrix4);
            fArr[i] = M.a;
            fArr[i5] = M.b;
        } else {
            fArr[i] = M.a(fArr[i], 0.0f, 0.0f).a(matrix4).a;
        }
    }

    private static final void a(float[] fArr, int i, int i2, i iVar) {
        if (i2 > 2) {
            int i3 = i + 1;
            int i4 = i + 2;
            M.a(fArr[i], fArr[i3], fArr[i4]).a(iVar).d();
            fArr[i] = M.a;
            fArr[i3] = M.b;
            fArr[i4] = M.c;
        } else if (i2 > 1) {
            int i5 = i + 1;
            M.a(fArr[i], fArr[i5], 0.0f).a(iVar).d();
            fArr[i] = M.a;
            fArr[i5] = M.b;
        } else {
            fArr[i] = M.a(fArr[i], 0.0f, 0.0f).a(iVar).d().a;
        }
    }

    private final void a(float[] fArr, int i) {
        int i2 = this.i.b;
        this.i.a(fArr, i, this.k);
        int i3 = this.l;
        this.l = i3 + 1;
        this.L = (short) i3;
        if (this.H) {
            a(this.i.a, this.n + i2, this.o, this.I);
            if (this.p >= 0) {
                a(this.i.a, this.p + i2, 3, this.J);
            }
            if (this.q >= 0) {
                a(this.i.a, this.q + i2, 3, this.J);
            }
            if (this.r >= 0) {
                a(this.i.a, this.r + i2, 3, this.J);
            }
        }
        this.K.a(this.i.a[this.n + i2], this.o > 1 ? this.i.a[this.n + i2 + 1] : 0.0f, this.o > 2 ? this.i.a[this.n + i2 + 2] : 0.0f);
        if (this.z) {
            if (this.s >= 0) {
                float[] fArr2 = this.i.a;
                int i4 = this.s + i2;
                fArr2[i4] = fArr2[i4] * this.y.J;
                float[] fArr3 = this.i.a;
                int i5 = this.s + i2 + 1;
                fArr3[i5] = fArr3[i5] * this.y.K;
                float[] fArr4 = this.i.a;
                int i6 = this.s + i2 + 2;
                fArr4[i6] = fArr4[i6] * this.y.L;
                if (this.t > 3) {
                    float[] fArr5 = this.i.a;
                    int i7 = this.s + i2 + 3;
                    fArr5[i7] = fArr5[i7] * this.y.M;
                }
            } else if (this.u >= 0) {
                ka.a(this.g, this.i.a[this.u + i2]);
                this.i.a[this.u + i2] = this.g.b(this.y).b();
            }
        }
        if (!this.F || this.v < 0) {
            return;
        }
        this.i.a[this.v + i2] = this.B + (this.C * this.i.a[this.v + i2]);
        this.i.a[this.v + i2 + 1] = this.D + (this.E * this.i.a[i2 + this.v + 1]);
    }

    public short a(p pVar, p pVar2, ka kaVar, o oVar) {
        int i;
        if (this.l > 32767) {
            throw new k("Too many vertices used");
        }
        this.G[this.n] = pVar.a;
        if (this.o > 1) {
            this.G[this.n + 1] = pVar.b;
        }
        if (this.o > 2) {
            this.G[this.n + 2] = pVar.c;
        }
        if (this.p >= 0) {
            if (pVar2 == null) {
                pVar2 = this.N.a(pVar).d();
            }
            this.G[this.p] = pVar2.a;
            this.G[this.p + 1] = pVar2.b;
            this.G[this.p + 2] = pVar2.c;
        }
        if (this.s >= 0) {
            if (kaVar == null) {
                kaVar = ka.a;
            }
            this.G[this.s] = kaVar.J;
            this.G[this.s + 1] = kaVar.K;
            this.G[this.s + 2] = kaVar.L;
            if (this.t > 3) {
                this.G[this.s + 3] = kaVar.M;
            }
        } else if (this.u > 0) {
            if (kaVar == null) {
                kaVar = ka.a;
            }
            this.G[this.u] = kaVar.b();
        }
        if (oVar != null && (i = this.v) >= 0) {
            this.G[i] = oVar.d;
            this.G[this.v + 1] = oVar.e;
        }
        a(this.G, 0);
        return this.L;
    }

    @Override // defpackage.ni
    public short a(ni.a aVar) {
        return a(aVar.b ? aVar.a : null, aVar.d ? aVar.c : null, aVar.f ? aVar.e : null, aVar.h ? aVar.g : null);
    }

    public void a(short s) {
        this.j.a(s);
    }

    public void a(short s, short s2) {
        b(2);
        this.j.a(s);
        this.j.a(s2);
    }

    public void a(short s, short s2, short s3) {
        b(3);
        this.j.a(s);
        this.j.a(s2);
        this.j.a(s3);
    }

    public void a(short s, short s2, short s3, short s4) {
        b(4);
        this.j.a(s);
        this.j.a(s2);
        this.j.a(s3);
        this.j.a(s4);
    }

    public void a(short s, short s2, short s3, short s4, short s5, short s6) {
        b(6);
        this.j.a(s);
        this.j.a(s2);
        this.j.a(s3);
        this.j.a(s4);
        this.j.a(s5);
        this.j.a(s6);
    }

    @Override // defpackage.ni
    public void a(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8) {
        b(8);
        this.j.a(s);
        this.j.a(s2);
        this.j.a(s3);
        this.j.a(s4);
        this.j.a(s5);
        this.j.a(s6);
        this.j.a(s7);
        this.j.a(s8);
    }

    public void b(short s, short s2) {
        if (this.A != 1) {
            throw new k("Incorrect primitive type");
        }
        a(s, s2);
    }

    public void a(ni.a aVar, ni.a aVar2) {
        a(2);
        b(a(aVar), a(aVar2));
    }

    @Override // defpackage.ni
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        a(this.c.a(null, null, null, null).a(f, f2, f3), this.d.a(null, null, null, null).a(f4, f5, f6));
    }

    public void b(short s, short s2, short s3) {
        int i = this.A;
        if (i == 4 || i == 0) {
            a(s, s2, s3);
        } else if (i == 1) {
            a(s, s2, s2, s3, s3, s);
        } else {
            throw new k("Incorrect primitive type");
        }
    }

    @Override // defpackage.ni
    public void a(ni.a aVar, ni.a aVar2, ni.a aVar3) {
        a(3);
        b(a(aVar), a(aVar2), a(aVar3));
    }

    @Override // defpackage.ni
    public void a(p pVar, ka kaVar, p pVar2, ka kaVar2, p pVar3, ka kaVar3) {
        a(this.c.a(pVar, null, kaVar, null), this.d.a(pVar2, null, kaVar2, null), this.e.a(pVar3, null, kaVar3, null));
    }

    @Override // defpackage.ni
    public void b(short s, short s2, short s3, short s4) {
        int i = this.A;
        if (i == 4) {
            a(s, s2, s3, s3, s4, s);
        } else if (i == 1) {
            a(s, s2, s2, s3, s3, s4, s4, s);
        } else if (i == 0) {
            a(s, s2, s3, s4);
        } else {
            throw new k("Incorrect primitive type");
        }
    }

    @Override // defpackage.ni
    public void a(ni.a aVar, ni.a aVar2, ni.a aVar3, ni.a aVar4) {
        a(4);
        b(a(aVar), a(aVar2), a(aVar3), a(aVar4));
    }

    @Override // defpackage.ni
    public void a(p pVar, p pVar2, p pVar3, p pVar4, p pVar5) {
        a(this.c.a(pVar, pVar5, null, null).a(0.0f, 1.0f), this.d.a(pVar2, pVar5, null, null).a(1.0f, 1.0f), this.e.a(pVar3, pVar5, null, null).a(1.0f, 0.0f), this.f.a(pVar4, pVar5, null, null).a(0.0f, 0.0f));
    }

    @Override // defpackage.ni
    public void b(kj kjVar) {
        a(kjVar, 0, kjVar.a());
    }

    public void a(kj kjVar, int i, int i2) {
        if (!this.h.equals(kjVar.f())) {
            throw new k("Vertex attributes do not match");
        }
        if (i2 <= 0) {
            return;
        }
        int b2 = kjVar.b() * this.k;
        b.b();
        b.b(b2);
        h hVar = b;
        hVar.b = b2;
        kjVar.a(hVar.a);
        a.a();
        a.c(i2);
        ah ahVar = a;
        ahVar.b = i2;
        kjVar.a(i, i2, ahVar.a, 0);
        a(b.a, a.a, 0, i2);
    }

    public void a(float[] fArr, short[] sArr, int i, int i2) {
        n nVar = O;
        if (nVar == null) {
            O = new n(i2);
        } else {
            nVar.a();
            O.c(i2);
        }
        b(i2);
        int length = fArr.length / this.k;
        if (length >= i2) {
            length = i2;
        }
        a(length);
        for (int i3 = 0; i3 < i2; i3++) {
            short s = sArr[i + i3];
            int b2 = O.b(s, -1);
            if (b2 < 0) {
                a(fArr, this.k * s);
                n nVar2 = O;
                short s2 = this.L;
                nVar2.a(s, s2);
                b2 = s2;
            }
            a((short) b2);
        }
    }

    @Override // defpackage.ni
    @Deprecated
    public void a(float f, float f2, float f3) {
        nr.a(this, f, f2, f3);
    }

    @Override // defpackage.ni
    @Deprecated
    public void a(float f, float f2, float f3, int i, int i2) {
        ns.a(this, f, f2, f3, i, i2);
    }
}
