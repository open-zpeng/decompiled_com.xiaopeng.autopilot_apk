package defpackage;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.i;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.k;
import defpackage.mw;
import java.util.Iterator;
/* compiled from: DefaultShader.java */
/* renamed from: mx  reason: default package */
/* loaded from: classes.dex */
public class mx extends mw {
    private static String aG;
    private static String aH;
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    protected final int M;
    protected final int N;
    protected final int O;
    protected final int P;
    protected final int Q;
    protected final int R;
    protected final int S;
    protected final int T;
    protected final int U;
    protected final int V;
    protected final int W;
    protected final int X;
    protected final int Y;
    protected final int Z;
    protected final lo aA;
    protected final lq[] aB;
    protected final lr[] aC;
    protected final lt[] aD;
    protected final long aE;
    protected final a aF;
    private lb aI;
    private final long aJ;
    private final i aM;
    private float aN;
    private boolean aO;
    private final p aP;
    protected final int aa;
    protected final int ab;
    protected final int ac;
    protected final int ad;
    protected final int ae;
    protected final int af;
    protected int ag;
    protected int ah;
    protected int ai;
    protected int aj;
    protected int ak;
    protected int al;
    protected int am;
    protected int an;
    protected int ao;
    protected int ap;
    protected int aq;
    protected int ar;
    protected int as;
    protected int at;
    protected int au;
    protected int av;
    protected int aw;
    protected final boolean ax;
    protected final boolean ay;
    protected final boolean az;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;
    protected static long d = (((le.b | ln.b) | lf.b) | lf.c) | lj.b;
    @Deprecated
    public static int e = 1029;
    @Deprecated
    public static int f = 515;
    private static final long aK = lk.b | lh.b;
    private static final kv aL = new kv();

    /* compiled from: DefaultShader.java */
    /* renamed from: mx$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final mw.d a = new mw.d("u_projTrans");
        public static final mw.d b = new mw.d("u_viewTrans");
        public static final mw.d c = new mw.d("u_projViewTrans");
        public static final mw.d d = new mw.d("u_cameraPosition");
        public static final mw.d e = new mw.d("u_cameraDirection");
        public static final mw.d f = new mw.d("u_cameraUp");
        public static final mw.d g = new mw.d("u_cameraNearFar");
        public static final mw.d h = new mw.d("u_worldTrans");
        public static final mw.d i = new mw.d("u_viewWorldTrans");
        public static final mw.d j = new mw.d("u_projViewWorldTrans");
        public static final mw.d k = new mw.d("u_normalMatrix");
        public static final mw.d l = new mw.d("u_bones");
        public static final mw.d m = new mw.d("u_shininess", lj.b);
        public static final mw.d n = new mw.d("u_opacity", le.b);
        public static final mw.d o = new mw.d("u_diffuseColor", lf.b);
        public static final mw.d p = new mw.d("u_diffuseTexture", ln.b);
        public static final mw.d q = new mw.d("u_diffuseUVTransform", ln.b);
        public static final mw.d r = new mw.d("u_specularColor", lf.c);
        public static final mw.d s = new mw.d("u_specularTexture", ln.c);
        public static final mw.d t = new mw.d("u_specularUVTransform", ln.c);
        public static final mw.d u = new mw.d("u_emissiveColor", lf.e);
        public static final mw.d v = new mw.d("u_emissiveTexture", ln.g);
        public static final mw.d w = new mw.d("u_emissiveUVTransform", ln.g);
        public static final mw.d x = new mw.d("u_reflectionColor", lf.f);
        public static final mw.d y = new mw.d("u_reflectionTexture", ln.h);
        public static final mw.d z = new mw.d("u_reflectionUVTransform", ln.h);
        public static final mw.d A = new mw.d("u_normalTexture", ln.e);
        public static final mw.d B = new mw.d("u_normalUVTransform", ln.e);
        public static final mw.d C = new mw.d("u_ambientTexture", ln.f);
        public static final mw.d D = new mw.d("u_ambientUVTransform", ln.f);
        public static final mw.d E = new mw.d("u_alphaTest");
        public static final mw.d F = new mw.d("u_ambientCubemap");
        public static final mw.d G = new mw.d("u_dirLights");
        public static final mw.d H = new mw.d("u_pointLights");
        public static final mw.d I = new mw.d("u_spotLights");
        public static final mw.d J = new mw.d("u_environmentCubemap");
    }

    private static final boolean a(long j, long j2) {
        return (j & j2) == j2;
    }

    private static final boolean b(long j, long j2) {
        return (j & j2) != 0;
    }

    public boolean a(mx mxVar) {
        return mxVar == this;
    }

    /* compiled from: DefaultShader.java */
    /* renamed from: mx$a */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public int h;
        public int i;

        public a() {
            this.a = null;
            this.b = null;
            this.c = 2;
            this.d = 5;
            this.e = 0;
            this.f = 12;
            this.g = true;
            this.h = -1;
            this.i = -1;
        }

        public a(String str, String str2) {
            this.a = null;
            this.b = null;
            this.c = 2;
            this.d = 5;
            this.e = 0;
            this.f = 12;
            this.g = true;
            this.h = -1;
            this.i = -1;
            this.a = str;
            this.b = str2;
        }
    }

    /* compiled from: DefaultShader.java */
    /* renamed from: mx$c */
    /* loaded from: classes.dex */
    public static class c {
        public static final mw.c a = new mw.a() { // from class: mx.c.1
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.d);
            }
        };
        public static final mw.c b = new mw.a() { // from class: mx.c.12
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.e);
            }
        };
        public static final mw.c c = new mw.a() { // from class: mx.c.23
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.f);
            }
        };
        public static final mw.c d = new mw.a() { // from class: mx.c.24
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.a.a, mwVar.c.a.b, mwVar.c.a.c, 1.1881f / (mwVar.c.i * mwVar.c.i));
            }
        };
        public static final mw.c e = new mw.a() { // from class: mx.c.25
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.b);
            }
        };
        public static final mw.c f = new mw.a() { // from class: mx.c.26
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.c);
            }
        };
        public static final mw.c g = new mw.a() { // from class: mx.c.27
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.c.h, mwVar.c.i);
            }
        };
        public static final mw.c h = new mw.b() { // from class: mx.c.28
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, lbVar.a);
            }
        };
        public static final mw.c i = new mw.b() { // from class: mx.c.29
            final Matrix4 a = new Matrix4();

            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, this.a.a(mwVar.c.e).b(lbVar.a));
            }
        };
        public static final mw.c j = new mw.b() { // from class: mx.c.2
            final Matrix4 a = new Matrix4();

            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, this.a.a(mwVar.c.f).b(lbVar.a));
            }
        };
        public static final mw.c k = new mw.b() { // from class: mx.c.3
            private final i a = new i();

            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, this.a.a(lbVar.a).c().d());
            }
        };
        public static final mw.c l = new mw.b() { // from class: mx.c.4
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, ((lj) kvVar.a(lj.b)).d);
            }
        };
        public static final mw.c m = new mw.b() { // from class: mx.c.5
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, ((lf) kvVar.a(lf.b)).j);
            }
        };
        public static final mw.c n = new mw.b() { // from class: mx.c.6
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.b.a.a(((ln) kvVar.a(ln.b)).j));
            }
        };
        public static final mw.c o = new mw.b() { // from class: mx.c.7
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                ln lnVar = (ln) kvVar.a(ln.b);
                mwVar.a(i2, lnVar.k, lnVar.l, lnVar.m, lnVar.n);
            }
        };
        public static final mw.c p = new mw.b() { // from class: mx.c.8
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, ((lf) kvVar.a(lf.c)).j);
            }
        };
        public static final mw.c q = new mw.b() { // from class: mx.c.9
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.b.a.a(((ln) kvVar.a(ln.c)).j));
            }
        };
        public static final mw.c r = new mw.b() { // from class: mx.c.10
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                ln lnVar = (ln) kvVar.a(ln.c);
                mwVar.a(i2, lnVar.k, lnVar.l, lnVar.m, lnVar.n);
            }
        };
        public static final mw.c s = new mw.b() { // from class: mx.c.11
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, ((lf) kvVar.a(lf.e)).j);
            }
        };
        public static final mw.c t = new mw.b() { // from class: mx.c.13
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.b.a.a(((ln) kvVar.a(ln.g)).j));
            }
        };
        public static final mw.c u = new mw.b() { // from class: mx.c.14
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                ln lnVar = (ln) kvVar.a(ln.g);
                mwVar.a(i2, lnVar.k, lnVar.l, lnVar.m, lnVar.n);
            }
        };
        public static final mw.c v = new mw.b() { // from class: mx.c.15
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, ((lf) kvVar.a(lf.f)).j);
            }
        };
        public static final mw.c w = new mw.b() { // from class: mx.c.16
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.b.a.a(((ln) kvVar.a(ln.h)).j));
            }
        };
        public static final mw.c x = new mw.b() { // from class: mx.c.17
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                ln lnVar = (ln) kvVar.a(ln.h);
                mwVar.a(i2, lnVar.k, lnVar.l, lnVar.m, lnVar.n);
            }
        };
        public static final mw.c y = new mw.b() { // from class: mx.c.18
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.b.a.a(((ln) kvVar.a(ln.e)).j));
            }
        };
        public static final mw.c z = new mw.b() { // from class: mx.c.19
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                ln lnVar = (ln) kvVar.a(ln.e);
                mwVar.a(i2, lnVar.k, lnVar.l, lnVar.m, lnVar.n);
            }
        };
        public static final mw.c A = new mw.b() { // from class: mx.c.20
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                mwVar.a(i2, mwVar.b.a.a(((ln) kvVar.a(ln.f)).j));
            }
        };
        public static final mw.c B = new mw.b() { // from class: mx.c.21
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                ln lnVar = (ln) kvVar.a(ln.f);
                mwVar.a(i2, lnVar.k, lnVar.l, lnVar.m, lnVar.n);
            }
        };
        public static final mw.c C = new mw.b() { // from class: mx.c.22
            @Override // defpackage.mw.c
            public void a(mw mwVar, int i2, lb lbVar, kv kvVar) {
                if (kvVar.c(lg.b)) {
                    mwVar.a(i2, mwVar.b.a.a(((lg) kvVar.a(lg.b)).d));
                }
            }
        };

        /* compiled from: DefaultShader.java */
        /* renamed from: mx$c$b */
        /* loaded from: classes.dex */
        public static class b extends mw.b {
            private static final Matrix4 b = new Matrix4();
            public final float[] a;

            public b(int i) {
                this.a = new float[i * 16];
            }

            @Override // defpackage.mw.c
            public void a(mw mwVar, int i, lb lbVar, kv kvVar) {
                int i2 = 0;
                while (true) {
                    float[] fArr = this.a;
                    if (i2 < fArr.length) {
                        int i3 = i2 / 16;
                        fArr[i2] = (lbVar.e == null || i3 >= lbVar.e.length || lbVar.e[i3] == null) ? b.a[i2 % 16] : lbVar.e[i3].a[i2 % 16];
                        i2++;
                    } else {
                        q qVar = mwVar.a;
                        int b2 = mwVar.b(i);
                        float[] fArr2 = this.a;
                        qVar.b(b2, fArr2, 0, fArr2.length);
                        return;
                    }
                }
            }
        }

        /* compiled from: DefaultShader.java */
        /* renamed from: mx$c$a */
        /* loaded from: classes.dex */
        public static class a extends mw.b {
            private static final float[] c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
            private static final p e = new p();
            public final int a;
            public final int b;
            private final lo d = new lo();

            public a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // defpackage.mw.c
            public void a(mw mwVar, int i, lb lbVar, kv kvVar) {
                if (lbVar.d == null) {
                    q qVar = mwVar.a;
                    int b = mwVar.b(i);
                    float[] fArr = c;
                    qVar.a(b, fArr, 0, fArr.length);
                    return;
                }
                lbVar.a.a(e);
                if (kvVar.c(lf.g)) {
                    this.d.a(((lf) kvVar.a(lf.g)).j);
                }
                if (kvVar.c(li.b)) {
                    com.badlogic.gdx.utils.a<lq> aVar = ((li) kvVar.a(li.b)).c;
                    for (int i2 = this.a; i2 < aVar.b; i2++) {
                        this.d.a(aVar.a(i2).a, aVar.a(i2).b);
                    }
                }
                if (kvVar.c(ll.b)) {
                    com.badlogic.gdx.utils.a<lr> aVar2 = ((ll) kvVar.a(ll.b)).c;
                    for (int i3 = this.b; i3 < aVar2.b; i3++) {
                        this.d.a(aVar2.a(i3).a, aVar2.a(i3).b, e, aVar2.a(i3).c);
                    }
                }
                this.d.a();
                mwVar.a.a(mwVar.b(i), this.d.a, 0, this.d.a.length);
            }
        }
    }

    public static String c() {
        if (aG == null) {
            aG = io.e.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.vertex.glsl").readString();
        }
        return aG;
    }

    public static String d() {
        if (aH == null) {
            aH = io.e.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.fragment.glsl").readString();
        }
        return aH;
    }

    public mx(lb lbVar, a aVar) {
        this(lbVar, aVar, a(lbVar, aVar));
    }

    public mx(lb lbVar, a aVar, String str) {
        this(lbVar, aVar, str, aVar.a != null ? aVar.a : c(), aVar.b != null ? aVar.b : d());
    }

    public mx(lb lbVar, a aVar, String str, String str2, String str3) {
        this(lbVar, aVar, new q(str + str2, str + str3));
    }

    public mx(lb lbVar, a aVar, q qVar) {
        this.O = a(new mw.d("u_dirLights[0].color"));
        this.P = a(new mw.d("u_dirLights[0].direction"));
        this.Q = a(new mw.d("u_dirLights[1].color"));
        this.R = a(new mw.d("u_pointLights[0].color"));
        this.S = a(new mw.d("u_pointLights[0].position"));
        this.T = a(new mw.d("u_pointLights[0].intensity"));
        this.U = a(new mw.d("u_pointLights[1].color"));
        this.V = a(new mw.d("u_spotLights[0].color"));
        this.W = a(new mw.d("u_spotLights[0].position"));
        this.X = a(new mw.d("u_spotLights[0].intensity"));
        this.Y = a(new mw.d("u_spotLights[0].direction"));
        this.Z = a(new mw.d("u_spotLights[0].cutoffAngle"));
        this.aa = a(new mw.d("u_spotLights[0].exponent"));
        this.ab = a(new mw.d("u_spotLights[1].color"));
        this.ac = a(new mw.d("u_fogColor"));
        this.ad = a(new mw.d("u_shadowMapProjViewTrans"));
        this.ae = a(new mw.d("u_shadowTexture"));
        this.af = a(new mw.d("u_shadowPCFOffset"));
        this.aA = new lo();
        this.aM = new i();
        this.aP = new p();
        kv c2 = c(lbVar);
        this.aF = aVar;
        this.a = qVar;
        boolean z = true;
        int i = 0;
        this.ax = lbVar.d != null;
        this.ay = c2.c(lg.b) || (this.ax && c2.c(lg.b));
        this.az = (!this.ax || lbVar.d.d == null) ? false : z;
        this.aI = lbVar;
        this.aE = c2.b() | aK;
        this.aJ = lbVar.b.e.f().c();
        this.aB = new lq[(!this.ax || aVar.c <= 0) ? 0 : aVar.c];
        int i2 = 0;
        while (true) {
            lq[] lqVarArr = this.aB;
            if (i2 >= lqVarArr.length) {
                break;
            }
            lqVarArr[i2] = new lq();
            i2++;
        }
        this.aC = new lr[(!this.ax || aVar.d <= 0) ? 0 : aVar.d];
        int i3 = 0;
        while (true) {
            lr[] lrVarArr = this.aC;
            if (i3 >= lrVarArr.length) {
                break;
            }
            lrVarArr[i3] = new lr();
            i3++;
        }
        this.aD = new lt[(!this.ax || aVar.e <= 0) ? 0 : aVar.e];
        while (true) {
            lt[] ltVarArr = this.aD;
            if (i >= ltVarArr.length) {
                break;
            }
            ltVarArr[i] = new lt();
            i++;
        }
        if (!aVar.g) {
            long j = d;
            long j2 = this.aE;
            if ((j & j2) != j2) {
                throw new k("Some attributes not implemented yet (" + this.aE + ")");
            }
        }
        this.g = a(b.a, c.a);
        this.h = a(b.b, c.b);
        this.i = a(b.c, c.c);
        this.j = a(b.d, c.d);
        this.k = a(b.e, c.e);
        this.l = a(b.f, c.f);
        this.m = a(b.g, c.g);
        this.n = a(new mw.d("u_time"));
        this.o = a(b.h, c.h);
        this.p = a(b.i, c.i);
        this.q = a(b.j, c.j);
        this.r = a(b.k, c.k);
        this.s = (lbVar.e == null || aVar.f <= 0) ? -1 : a(b.l, new c.b(aVar.f));
        this.t = a(b.m, c.l);
        this.u = a(b.n);
        this.v = a(b.o, c.m);
        this.w = a(b.p, c.n);
        this.x = a(b.q, c.o);
        this.y = a(b.r, c.p);
        this.z = a(b.s, c.q);
        this.A = a(b.t, c.r);
        this.B = a(b.u, c.s);
        this.C = a(b.v, c.t);
        this.D = a(b.w, c.u);
        this.E = a(b.x, c.v);
        this.F = a(b.y, c.w);
        this.G = a(b.z, c.x);
        this.H = a(b.A, c.y);
        this.I = a(b.B, c.z);
        this.J = a(b.C, c.A);
        this.K = a(b.D, c.B);
        this.L = a(b.E);
        this.M = this.ax ? a(b.F, new c.a(aVar.c, aVar.d)) : -1;
        this.N = this.ay ? a(b.J, c.C) : -1;
    }

    @Override // defpackage.ld
    public void a() {
        q qVar = this.a;
        this.a = null;
        a(qVar, this.aI);
        this.aI = null;
        this.ag = b(this.O);
        this.ah = b(this.O) - this.ag;
        this.ai = b(this.P) - this.ag;
        this.aj = b(this.Q) - this.ag;
        if (this.aj < 0) {
            this.aj = 0;
        }
        this.ak = b(this.R);
        this.al = b(this.R) - this.ak;
        this.am = b(this.S) - this.ak;
        this.an = a(this.T) ? b(this.T) - this.ak : -1;
        this.ao = b(this.U) - this.ak;
        if (this.ao < 0) {
            this.ao = 0;
        }
        this.ap = b(this.V);
        this.aq = b(this.V) - this.ap;
        this.ar = b(this.W) - this.ap;
        this.as = b(this.Y) - this.ap;
        this.at = a(this.X) ? b(this.X) - this.ap : -1;
        this.au = b(this.Z) - this.ap;
        this.av = b(this.aa) - this.ap;
        this.aw = b(this.ab) - this.ap;
        if (this.aw < 0) {
            this.aw = 0;
        }
    }

    private static final kv c(lb lbVar) {
        aL.c();
        if (lbVar.d != null) {
            aL.a((Iterable<ku>) lbVar.d);
        }
        if (lbVar.c != null) {
            aL.a((Iterable<ku>) lbVar.c);
        }
        return aL;
    }

    private static final long d(lb lbVar) {
        long b2 = lbVar.d != null ? 0 | lbVar.d.b() : 0L;
        return lbVar.c != null ? b2 | lbVar.c.b() : b2;
    }

    public static String a(lb lbVar, a aVar) {
        kv c2 = c(lbVar);
        long b2 = c2.b();
        long b3 = lbVar.b.e.f().b();
        String str = a(b3, 1L) ? "#define positionFlag\n" : "";
        if (b(b3, 6L)) {
            str = str + "#define colorFlag\n";
        }
        if (a(b3, 256L)) {
            str = str + "#define binormalFlag\n";
        }
        if (a(b3, 128L)) {
            str = str + "#define tangentFlag\n";
        }
        if (a(b3, 8L)) {
            str = str + "#define normalFlag\n";
        }
        if ((a(b3, 8L) || a(b3, 384L)) && lbVar.d != null) {
            str = ((((str + "#define lightingFlag\n") + "#define ambientCubemapFlag\n") + "#define numDirectionalLights " + aVar.c + "\n") + "#define numPointLights " + aVar.d + "\n") + "#define numSpotLights " + aVar.e + "\n";
            if (c2.c(lf.h)) {
                str = str + "#define fogFlag\n";
            }
            if (lbVar.d.d != null) {
                str = str + "#define shadowMapFlag\n";
            }
            if (c2.c(lg.b)) {
                str = str + "#define environmentCubemapFlag\n";
            }
        }
        int a2 = lbVar.b.e.f().a();
        for (int i = 0; i < a2; i++) {
            ks b4 = lbVar.b.e.f().b(i);
            if (b4.a == 64) {
                str = str + "#define boneWeight" + b4.g + "Flag\n";
            } else if (b4.a == 16) {
                str = str + "#define texCoord" + b4.g + "Flag\n";
            }
        }
        if ((le.b & b2) == le.b) {
            str = str + "#define blendedFlag\n";
        }
        if ((ln.b & b2) == ln.b) {
            str = (str + "#define diffuseTextureFlag\n") + "#define diffuseTextureCoord texCoord0\n";
        }
        if ((ln.c & b2) == ln.c) {
            str = (str + "#define specularTextureFlag\n") + "#define specularTextureCoord texCoord0\n";
        }
        if ((ln.e & b2) == ln.e) {
            str = (str + "#define normalTextureFlag\n") + "#define normalTextureCoord texCoord0\n";
        }
        if ((ln.g & b2) == ln.g) {
            str = (str + "#define emissiveTextureFlag\n") + "#define emissiveTextureCoord texCoord0\n";
        }
        if ((ln.h & b2) == ln.h) {
            str = (str + "#define reflectionTextureFlag\n") + "#define reflectionTextureCoord texCoord0\n";
        }
        if ((ln.f & b2) == ln.f) {
            str = (str + "#define ambientTextureFlag\n") + "#define ambientTextureCoord texCoord0\n";
        }
        if ((lf.b & b2) == lf.b) {
            str = str + "#define diffuseColorFlag\n";
        }
        if ((lf.c & b2) == lf.c) {
            str = str + "#define specularColorFlag\n";
        }
        if ((lf.e & b2) == lf.e) {
            str = str + "#define emissiveColorFlag\n";
        }
        if ((lf.f & b2) == lf.f) {
            str = str + "#define reflectionColorFlag\n";
        }
        if ((lj.b & b2) == lj.b) {
            str = str + "#define shininessFlag\n";
        }
        if ((b2 & lj.c) == lj.c) {
            str = str + "#define alphaTestFlag\n";
        }
        if (lbVar.e == null || aVar.f <= 0) {
            return str;
        }
        return str + "#define numBones " + aVar.f + "\n";
    }

    @Override // defpackage.ld
    public boolean a(lb lbVar) {
        if (this.aE == (d(lbVar) | aK) && this.aJ == lbVar.b.e.f().c()) {
            if ((lbVar.d != null) == this.ax) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof mx) && a((mx) obj);
    }

    @Override // defpackage.mw, defpackage.ld
    public void a(jz jzVar, nk nkVar) {
        super.a(jzVar, nkVar);
        for (lq lqVar : this.aB) {
            lqVar.a(0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f);
        }
        for (lr lrVar : this.aC) {
            lrVar.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        for (lt ltVar : this.aD) {
            ltVar.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        }
        this.aO = false;
        if (a(this.n)) {
            int i = this.n;
            float deltaTime = this.aN + io.b.getDeltaTime();
            this.aN = deltaTime;
            a(i, deltaTime);
        }
    }

    @Override // defpackage.mw
    public void a(lb lbVar, kv kvVar) {
        if (!kvVar.c(le.b)) {
            this.b.a(false, 770, 771);
        }
        a(kvVar);
        if (this.ax) {
            b(lbVar, kvVar);
        }
        super.a(lbVar, kvVar);
    }

    @Override // defpackage.mw, defpackage.ld
    public void b() {
        super.b();
    }

    protected void a(kv kvVar) {
        int i = this.aF.h == -1 ? e : this.aF.h;
        int i2 = this.aF.i == -1 ? f : this.aF.i;
        float f2 = 0.0f;
        float f3 = 1.0f;
        Iterator<ku> it = kvVar.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ku next = it.next();
            long j = next.a;
            if (le.b(j)) {
                le leVar = (le) next;
                this.b.a(true, leVar.d, leVar.e);
                a(this.u, leVar.f);
            } else if ((lk.b & j) == lk.b) {
                i = ((lk) next).c;
            } else if ((lj.c & j) == lj.c) {
                a(this.L, ((lj) next).d);
            } else if ((j & lh.b) == lh.b) {
                lh lhVar = (lh) next;
                i2 = lhVar.d;
                f2 = lhVar.e;
                f3 = lhVar.f;
                z = lhVar.g;
            } else if (!this.aF.g) {
                throw new k("Unknown material attribute: " + next.toString());
            }
        }
        this.b.a(i);
        this.b.a(i2, f2, f3);
        this.b.a(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x00ec A[EDGE_INSN: B:107:0x00ec->B:43:0x00ec ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ac A[EDGE_INSN: B:112:0x01ac->B:71:0x01ac ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0284 A[EDGE_INSN: B:118:0x0284->B:98:0x0284 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0280 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void b(defpackage.lb r14, defpackage.kv r15) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mx.b(lb, kv):void");
    }

    @Override // defpackage.mw, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.a.dispose();
        super.dispose();
    }
}
