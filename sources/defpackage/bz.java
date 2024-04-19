package defpackage;

import defpackage.by;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintWidget.java */
/* renamed from: bz  reason: default package */
/* loaded from: classes.dex */
public class bz {
    public static float Y = 0.5f;
    protected int W;
    protected int X;
    float Z;
    private boolean aJ;
    private Object aO;
    private int aP;
    private int aQ;
    private String aR;
    private String aS;
    float aa;
    int ab;
    int ac;
    int ad;
    int ae;
    boolean af;
    boolean ag;
    boolean ah;
    boolean ai;
    boolean aj;
    boolean ak;
    boolean al;
    int am;
    int an;
    boolean ao;
    boolean ap;
    public float[] aq;
    protected bz[] ar;
    protected bz[] as;
    bz at;
    bz au;
    public int av;
    public int aw;
    public ck d;
    public ck e;
    public boolean v;
    public boolean w;
    public boolean b = false;
    public cx[] c = new cx[2];
    public ct f = null;
    public cv g = null;
    public boolean[] h = {true, true};
    boolean i = false;
    private boolean a = true;
    private boolean ax = false;
    private boolean ay = true;
    private int az = -1;
    private int aA = -1;
    public bu j = new bu(this);
    private boolean aB = false;
    private boolean aC = false;
    private boolean aD = false;
    private boolean aE = false;
    public int k = -1;
    public int l = -1;
    private int aF = 0;
    public int m = 0;
    public int n = 0;
    public int[] o = new int[2];
    public int p = 0;
    public int q = 0;
    public float r = 1.0f;
    public int s = 0;
    public int t = 0;
    public float u = 1.0f;
    int x = -1;
    float y = 1.0f;
    private int[] aG = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float aH = 0.0f;
    private boolean aI = false;
    private boolean aK = false;
    private int aL = 0;
    private int aM = 0;
    public by z = new by(this, by.a.LEFT);
    public by A = new by(this, by.a.TOP);
    public by B = new by(this, by.a.RIGHT);
    public by C = new by(this, by.a.BOTTOM);
    public by D = new by(this, by.a.BASELINE);
    by E = new by(this, by.a.CENTER_X);
    by F = new by(this, by.a.CENTER_Y);
    public by G = new by(this, by.a.CENTER);
    public by[] H = {this.z, this.B, this.A, this.C, this.D, this.G};
    protected ArrayList<by> I = new ArrayList<>();
    private boolean[] aN = new boolean[2];
    public a[] J = {a.FIXED, a.FIXED};
    public bz K = null;
    int L = 0;
    int M = 0;
    public float N = 0.0f;
    protected int O = -1;
    protected int P = 0;
    protected int Q = 0;
    int R = 0;
    int S = 0;
    protected int T = 0;
    protected int U = 0;
    int V = 0;

    /* compiled from: ConstraintWidget.java */
    /* renamed from: bz$a */
    /* loaded from: classes.dex */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public cx c(int i) {
        if (i == 0) {
            return this.f;
        }
        if (i == 1) {
            return this.g;
        }
        return null;
    }

    public void d(int i) {
        this.z.a(i);
        this.P = i;
    }

    public void e(int i) {
        this.A.a(i);
        this.Q = i;
    }

    public boolean j() {
        return this.aD;
    }

    public boolean k() {
        return this.aE;
    }

    public void l() {
        this.aD = true;
    }

    public void m() {
        this.aE = true;
    }

    public void a(int i, int i2) {
        if (this.aB) {
            return;
        }
        this.z.a(i);
        this.B.a(i2);
        this.P = i;
        this.L = i2 - i;
        this.aB = true;
    }

    public void b(int i, int i2) {
        if (this.aC) {
            return;
        }
        this.A.a(i);
        this.C.a(i2);
        this.Q = i;
        this.M = i2 - i;
        if (this.aI) {
            this.D.a(i + this.V);
        }
        this.aC = true;
    }

    public void f(int i) {
        if (this.aI) {
            int i2 = i - this.V;
            int i3 = this.M + i2;
            this.Q = i2;
            this.A.a(i2);
            this.C.a(i3);
            this.D.a(i);
            this.aC = true;
        }
    }

    public boolean d() {
        return this.aB || (this.z.f() && this.B.f());
    }

    public boolean e() {
        return this.aC || (this.A.f() && this.C.f());
    }

    public void n() {
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        int size = this.I.size();
        for (int i = 0; i < size; i++) {
            this.I.get(i).e();
        }
    }

    public boolean o() {
        int size = this.I.size();
        for (int i = 0; i < size; i++) {
            if (this.I.get(i).b()) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i) {
        if (i == 0) {
            return (this.z.c != null ? 1 : 0) + (this.B.c != null ? 1 : 0) < 2;
        }
        return ((this.A.c != null ? 1 : 0) + (this.C.c != null ? 1 : 0)) + (this.D.c != null ? 1 : 0) < 2;
    }

    public boolean c(int i, int i2) {
        return i == 0 ? this.z.c != null && this.z.c.f() && this.B.c != null && this.B.c.f() && (this.B.c.d() - this.B.j()) - (this.z.c.d() + this.z.j()) >= i2 : this.A.c != null && this.A.c.f() && this.C.c != null && this.C.c.f() && (this.C.c.d() - this.C.j()) - (this.A.c.d() + this.A.j()) >= i2;
        return false;
    }

    public boolean p() {
        return this.aK;
    }

    public void b(boolean z) {
        this.aK = z;
    }

    public int q() {
        return this.aG[1];
    }

    public int r() {
        return this.aG[0];
    }

    public void h(int i) {
        this.aG[0] = i;
    }

    public void i(int i) {
        this.aG[1] = i;
    }

    public void c(boolean z) {
        this.aI = z;
    }

    public boolean s() {
        return this.aJ;
    }

    public void d(boolean z) {
        this.aJ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, boolean z) {
        this.aN[i] = z;
    }

    public boolean j(int i) {
        return this.aN[i];
    }

    public void e(boolean z) {
        this.a = z;
    }

    public boolean t() {
        return this.a && this.aQ != 8;
    }

    public void k(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.aF = i;
    }

    public int u() {
        return this.aL;
    }

    public int v() {
        return this.aM;
    }

    public void d(int i, int i2) {
        this.aL = i;
        this.aM = i2;
        e(false);
    }

    public void w() {
        this.z.l();
        this.A.l();
        this.B.l();
        this.C.l();
        this.D.l();
        this.E.l();
        this.F.l();
        this.G.l();
        this.K = null;
        this.aH = 0.0f;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        float f = Y;
        this.Z = f;
        this.aa = f;
        this.J[0] = a.FIXED;
        this.J[1] = a.FIXED;
        this.aO = null;
        this.aP = 0;
        this.aQ = 0;
        this.aS = null;
        this.aj = false;
        this.ak = false;
        this.am = 0;
        this.an = 0;
        this.ao = false;
        this.ap = false;
        float[] fArr = this.aq;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.k = -1;
        this.l = -1;
        int[] iArr = this.aG;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.m = 0;
        this.n = 0;
        this.r = 1.0f;
        this.u = 1.0f;
        this.q = Integer.MAX_VALUE;
        this.t = Integer.MAX_VALUE;
        this.p = 0;
        this.s = 0;
        this.i = false;
        this.x = -1;
        this.y = 1.0f;
        this.al = false;
        boolean[] zArr = this.h;
        zArr[0] = true;
        zArr[1] = true;
        this.aK = false;
        boolean[] zArr2 = this.aN;
        zArr2[0] = false;
        zArr2[1] = false;
        this.a = true;
        int[] iArr2 = this.o;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.az = -1;
        this.aA = -1;
    }

    public boolean x() {
        return this.J[0] == a.MATCH_CONSTRAINT && this.J[1] == a.MATCH_CONSTRAINT;
    }

    public boolean y() {
        return (this.az == -1 && this.aA == -1) ? false : true;
    }

    public bz() {
        float f = Y;
        this.Z = f;
        this.aa = f;
        this.aP = 0;
        this.aQ = 0;
        this.aR = null;
        this.aS = null;
        this.al = false;
        this.am = 0;
        this.an = 0;
        this.aq = new float[]{-1.0f, -1.0f};
        this.ar = new bz[]{null, null};
        this.as = new bz[]{null, null};
        this.at = null;
        this.au = null;
        this.av = -1;
        this.aw = -1;
        b();
    }

    public void z() {
        if (this.f == null) {
            this.f = new ct(this);
        }
        if (this.g == null) {
            this.g = new cv(this);
        }
    }

    public void a(ay ayVar) {
        this.z.a(ayVar);
        this.A.a(ayVar);
        this.B.a(ayVar);
        this.C.a(ayVar);
        this.D.a(ayVar);
        this.G.a(ayVar);
        this.E.a(ayVar);
        this.F.a(ayVar);
    }

    private void b() {
        this.I.add(this.z);
        this.I.add(this.A);
        this.I.add(this.B);
        this.I.add(this.C);
        this.I.add(this.E);
        this.I.add(this.F);
        this.I.add(this.G);
        this.I.add(this.D);
    }

    public bz A() {
        return this.K;
    }

    public void a_(bz bzVar) {
        this.K = bzVar;
    }

    public void a(bz bzVar, float f, int i) {
        a(by.a.CENTER, bzVar, by.a.CENTER, i, 0);
        this.aH = f;
    }

    public void l(int i) {
        this.aQ = i;
    }

    public int B() {
        return this.aQ;
    }

    public String C() {
        return this.aR;
    }

    public void a(String str) {
        this.aR = str;
    }

    public void a(az azVar) {
        azVar.a(this.z);
        azVar.a(this.A);
        azVar.a(this.B);
        azVar.a(this.C);
        if (this.V > 0) {
            azVar.a(this.D);
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.aS != null) {
            str = "type: " + this.aS + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.aR != null) {
            str2 = "id: " + this.aR + " ";
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.P);
        sb.append(", ");
        sb.append(this.Q);
        sb.append(") - (");
        sb.append(this.L);
        sb.append(" x ");
        sb.append(this.M);
        sb.append(")");
        return sb.toString();
    }

    public int D() {
        bz bzVar = this.K;
        if (bzVar != null && (bzVar instanceof ca)) {
            return ((ca) bzVar).aB + this.P;
        }
        return this.P;
    }

    public int E() {
        bz bzVar = this.K;
        if (bzVar != null && (bzVar instanceof ca)) {
            return ((ca) bzVar).aC + this.Q;
        }
        return this.Q;
    }

    public int F() {
        if (this.aQ == 8) {
            return 0;
        }
        return this.L;
    }

    public int G() {
        if (this.aQ == 8) {
            return 0;
        }
        return this.M;
    }

    public int m(int i) {
        if (i == 0) {
            return F();
        }
        if (i == 1) {
            return G();
        }
        return 0;
    }

    public int H() {
        return this.W;
    }

    public int I() {
        return this.X;
    }

    public int J() {
        return D() + this.L;
    }

    public int K() {
        return E() + this.M;
    }

    public int L() {
        by byVar = this.z;
        int i = byVar != null ? 0 + byVar.d : 0;
        by byVar2 = this.B;
        return byVar2 != null ? i + byVar2.d : i;
    }

    public int M() {
        int i = this.z != null ? 0 + this.A.d : 0;
        return this.B != null ? i + this.C.d : i;
    }

    public float N() {
        return this.Z;
    }

    public float O() {
        return this.aa;
    }

    public float n(int i) {
        if (i == 0) {
            return this.Z;
        }
        if (i == 1) {
            return this.aa;
        }
        return -1.0f;
    }

    public boolean P() {
        return this.aI;
    }

    public int Q() {
        return this.V;
    }

    public Object R() {
        return this.aO;
    }

    public void o(int i) {
        this.P = i;
    }

    public void p(int i) {
        this.Q = i;
    }

    public void e(int i, int i2) {
        this.P = i;
        this.Q = i2;
    }

    public void q(int i) {
        this.L = i;
        int i2 = this.L;
        int i3 = this.W;
        if (i2 < i3) {
            this.L = i3;
        }
    }

    public void r(int i) {
        this.M = i;
        int i2 = this.M;
        int i3 = this.X;
        if (i2 < i3) {
            this.M = i3;
        }
    }

    public void a(int i, int i2, int i3, float f) {
        this.m = i;
        this.p = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.q = i3;
        this.r = f;
        if (f <= 0.0f || f >= 1.0f || this.m != 0) {
            return;
        }
        this.m = 2;
    }

    public void b(int i, int i2, int i3, float f) {
        this.n = i;
        this.s = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.t = i3;
        this.u = f;
        if (f <= 0.0f || f >= 1.0f || this.n != 0) {
            return;
        }
        this.n = 2;
    }

    public void b(String str) {
        float parseFloat;
        if (str == null || str.length() == 0) {
            this.N = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0 && indexOf2 < length - 1) {
            String substring2 = str.substring(i2, indexOf2);
            String substring3 = str.substring(indexOf2 + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                try {
                    float parseFloat2 = Float.parseFloat(substring2);
                    float parseFloat3 = Float.parseFloat(substring3);
                    if (parseFloat2 <= 0.0f || parseFloat3 <= 0.0f) {
                        parseFloat = 0.0f;
                    } else if (i == 1) {
                        parseFloat = Math.abs(parseFloat3 / parseFloat2);
                    } else {
                        parseFloat = Math.abs(parseFloat2 / parseFloat3);
                    }
                } catch (NumberFormatException unused) {
                }
            }
            parseFloat = 0.0f;
        } else {
            String substring4 = str.substring(i2);
            if (substring4.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring4);
                } catch (NumberFormatException unused2) {
                }
            }
            parseFloat = 0.0f;
        }
        if (parseFloat > 0.0f) {
            this.N = parseFloat;
            this.O = i;
        }
    }

    public float S() {
        return this.N;
    }

    public int T() {
        return this.O;
    }

    public void a(float f) {
        this.Z = f;
    }

    public void b(float f) {
        this.aa = f;
    }

    public void s(int i) {
        if (i < 0) {
            this.W = 0;
        } else {
            this.W = i;
        }
    }

    public void t(int i) {
        if (i < 0) {
            this.X = 0;
        } else {
            this.X = i;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.P = i;
        this.Q = i2;
        if (this.aQ == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (this.J[0] != a.FIXED || i7 >= (i5 = this.L)) {
            i5 = i7;
        }
        if (this.J[1] != a.FIXED || i8 >= (i6 = this.M)) {
            i6 = i8;
        }
        this.L = i5;
        this.M = i6;
        int i9 = this.M;
        int i10 = this.X;
        if (i9 < i10) {
            this.M = i10;
        }
        int i11 = this.L;
        int i12 = this.W;
        if (i11 < i12) {
            this.L = i12;
        }
        if (this.q > 0 && this.J[0] == a.MATCH_CONSTRAINT) {
            this.L = Math.min(this.L, this.q);
        }
        if (this.t > 0 && this.J[1] == a.MATCH_CONSTRAINT) {
            this.M = Math.min(this.M, this.t);
        }
        int i13 = this.L;
        if (i5 != i13) {
            this.az = i13;
        }
        int i14 = this.M;
        if (i6 != i14) {
            this.aA = i14;
        }
    }

    public void f(int i, int i2) {
        this.P = i;
        this.L = i2 - i;
        int i3 = this.L;
        int i4 = this.W;
        if (i3 < i4) {
            this.L = i4;
        }
    }

    public void g(int i, int i2) {
        this.Q = i;
        this.M = i2 - i;
        int i3 = this.M;
        int i4 = this.X;
        if (i3 < i4) {
            this.M = i4;
        }
    }

    public void u(int i) {
        this.V = i;
        this.aI = i > 0;
    }

    public void a(Object obj) {
        this.aO = obj;
    }

    public void c(float f) {
        this.aq[0] = f;
    }

    public void d(float f) {
        this.aq[1] = f;
    }

    public void v(int i) {
        this.am = i;
    }

    public int U() {
        return this.am;
    }

    public void w(int i) {
        this.an = i;
    }

    public int V() {
        return this.an;
    }

    public boolean a() {
        return this.aQ != 8;
    }

    public void a(by.a aVar, bz bzVar, by.a aVar2, int i, int i2) {
        a(aVar).a(bzVar.a(aVar2), i, i2, true);
    }

    public void a(by byVar, by byVar2, int i) {
        if (byVar.h() == this) {
            a(byVar.i(), byVar2.h(), byVar2.i(), i);
        }
    }

    public void a(by.a aVar, bz bzVar, by.a aVar2, int i) {
        boolean z;
        if (aVar == by.a.CENTER) {
            if (aVar2 == by.a.CENTER) {
                by a2 = a(by.a.LEFT);
                by a3 = a(by.a.RIGHT);
                by a4 = a(by.a.TOP);
                by a5 = a(by.a.BOTTOM);
                boolean z2 = true;
                if ((a2 == null || !a2.m()) && (a3 == null || !a3.m())) {
                    a(by.a.LEFT, bzVar, by.a.LEFT, 0);
                    a(by.a.RIGHT, bzVar, by.a.RIGHT, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((a4 == null || !a4.m()) && (a5 == null || !a5.m())) {
                    a(by.a.TOP, bzVar, by.a.TOP, 0);
                    a(by.a.BOTTOM, bzVar, by.a.BOTTOM, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    a(by.a.CENTER).a(bzVar.a(by.a.CENTER), 0);
                } else if (z) {
                    a(by.a.CENTER_X).a(bzVar.a(by.a.CENTER_X), 0);
                } else if (z2) {
                    a(by.a.CENTER_Y).a(bzVar.a(by.a.CENTER_Y), 0);
                }
            } else if (aVar2 == by.a.LEFT || aVar2 == by.a.RIGHT) {
                a(by.a.LEFT, bzVar, aVar2, 0);
                a(by.a.RIGHT, bzVar, aVar2, 0);
                a(by.a.CENTER).a(bzVar.a(aVar2), 0);
            } else if (aVar2 == by.a.TOP || aVar2 == by.a.BOTTOM) {
                a(by.a.TOP, bzVar, aVar2, 0);
                a(by.a.BOTTOM, bzVar, aVar2, 0);
                a(by.a.CENTER).a(bzVar.a(aVar2), 0);
            }
        } else if (aVar == by.a.CENTER_X && (aVar2 == by.a.LEFT || aVar2 == by.a.RIGHT)) {
            by a6 = a(by.a.LEFT);
            by a7 = bzVar.a(aVar2);
            by a8 = a(by.a.RIGHT);
            a6.a(a7, 0);
            a8.a(a7, 0);
            a(by.a.CENTER_X).a(a7, 0);
        } else if (aVar == by.a.CENTER_Y && (aVar2 == by.a.TOP || aVar2 == by.a.BOTTOM)) {
            by a9 = bzVar.a(aVar2);
            a(by.a.TOP).a(a9, 0);
            a(by.a.BOTTOM).a(a9, 0);
            a(by.a.CENTER_Y).a(a9, 0);
        } else if (aVar == by.a.CENTER_X && aVar2 == by.a.CENTER_X) {
            a(by.a.LEFT).a(bzVar.a(by.a.LEFT), 0);
            a(by.a.RIGHT).a(bzVar.a(by.a.RIGHT), 0);
            a(by.a.CENTER_X).a(bzVar.a(aVar2), 0);
        } else if (aVar == by.a.CENTER_Y && aVar2 == by.a.CENTER_Y) {
            a(by.a.TOP).a(bzVar.a(by.a.TOP), 0);
            a(by.a.BOTTOM).a(bzVar.a(by.a.BOTTOM), 0);
            a(by.a.CENTER_Y).a(bzVar.a(aVar2), 0);
        } else {
            by a10 = a(aVar);
            by a11 = bzVar.a(aVar2);
            if (a10.a(a11)) {
                if (aVar == by.a.BASELINE) {
                    by a12 = a(by.a.TOP);
                    by a13 = a(by.a.BOTTOM);
                    if (a12 != null) {
                        a12.l();
                    }
                    if (a13 != null) {
                        a13.l();
                    }
                } else if (aVar == by.a.TOP || aVar == by.a.BOTTOM) {
                    by a14 = a(by.a.BASELINE);
                    if (a14 != null) {
                        a14.l();
                    }
                    by a15 = a(by.a.CENTER);
                    if (a15.k() != a11) {
                        a15.l();
                    }
                    by n = a(aVar).n();
                    by a16 = a(by.a.CENTER_Y);
                    if (a16.m()) {
                        n.l();
                        a16.l();
                    }
                } else if (aVar == by.a.LEFT || aVar == by.a.RIGHT) {
                    by a17 = a(by.a.CENTER);
                    if (a17.k() != a11) {
                        a17.l();
                    }
                    by n2 = a(aVar).n();
                    by a18 = a(by.a.CENTER_X);
                    if (a18.m()) {
                        n2.l();
                        a18.l();
                    }
                }
                a10.a(a11, i);
            }
        }
    }

    public void W() {
        bz A = A();
        if (A != null && (A instanceof ca) && ((ca) A()).af()) {
            return;
        }
        int size = this.I.size();
        for (int i = 0; i < size; i++) {
            this.I.get(i).l();
        }
    }

    public by a(by.a aVar) {
        switch (aVar) {
            case LEFT:
                return this.z;
            case TOP:
                return this.A;
            case RIGHT:
                return this.B;
            case BOTTOM:
                return this.C;
            case BASELINE:
                return this.D;
            case CENTER:
                return this.G;
            case CENTER_X:
                return this.E;
            case CENTER_Y:
                return this.F;
            case NONE:
                return null;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public a X() {
        return this.J[0];
    }

    public a Y() {
        return this.J[1];
    }

    public a x(int i) {
        if (i == 0) {
            return X();
        }
        if (i == 1) {
            return Y();
        }
        return null;
    }

    public void a(a aVar) {
        this.J[0] = aVar;
    }

    public void b(a aVar) {
        this.J[1] = aVar;
    }

    public boolean Z() {
        if (this.z.c == null || this.z.c.c != this.z) {
            return this.B.c != null && this.B.c.c == this.B;
        }
        return true;
    }

    public bz y(int i) {
        if (i == 0) {
            if (this.z.c != null) {
                by byVar = this.z.c.c;
                by byVar2 = this.z;
                if (byVar == byVar2) {
                    return byVar2.c.a;
                }
                return null;
            }
            return null;
        } else if (i != 1 || this.A.c == null) {
            return null;
        } else {
            by byVar3 = this.A.c.c;
            by byVar4 = this.A;
            if (byVar3 == byVar4) {
                return byVar4.c.a;
            }
            return null;
        }
    }

    public bz z(int i) {
        if (i == 0) {
            if (this.B.c != null) {
                by byVar = this.B.c.c;
                by byVar2 = this.B;
                if (byVar == byVar2) {
                    return byVar2.c.a;
                }
                return null;
            }
            return null;
        } else if (i != 1 || this.C.c == null) {
            return null;
        } else {
            by byVar3 = this.C.c.c;
            by byVar4 = this.C;
            if (byVar3 == byVar4) {
                return byVar4.c.a;
            }
            return null;
        }
    }

    public boolean aa() {
        if (this.A.c == null || this.A.c.c != this.A) {
            return this.C.c != null && this.C.c.c == this.C;
        }
        return true;
    }

    private boolean a(int i) {
        int i2 = i * 2;
        if (this.H[i2].c != null) {
            by byVar = this.H[i2].c.c;
            by[] byVarArr = this.H;
            if (byVar != byVarArr[i2]) {
                int i3 = i2 + 1;
                if (byVarArr[i3].c != null && this.H[i3].c.c == this.H[i3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x0328, code lost:
        if (r0 == (-1)) goto L262;
     */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0679  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.az r51, boolean r52) {
        /*
            Method dump skipped, instructions count: 1674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bz.a(az, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ab() {
        return (this instanceof cg) || (this instanceof cc);
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.x == -1) {
            if (z3 && !z4) {
                this.x = 0;
            } else if (!z3 && z4) {
                this.x = 1;
                if (this.O == -1) {
                    this.y = 1.0f / this.y;
                }
            }
        }
        if (this.x == 0 && (!this.A.m() || !this.C.m())) {
            this.x = 1;
        } else if (this.x == 1 && (!this.z.m() || !this.B.m())) {
            this.x = 0;
        }
        if (this.x == -1 && (!this.A.m() || !this.C.m() || !this.z.m() || !this.B.m())) {
            if (this.A.m() && this.C.m()) {
                this.x = 0;
            } else if (this.z.m() && this.B.m()) {
                this.y = 1.0f / this.y;
                this.x = 1;
            }
        }
        if (this.x == -1) {
            if (this.p > 0 && this.s == 0) {
                this.x = 0;
            } else if (this.p != 0 || this.s <= 0) {
            } else {
                this.y = 1.0f / this.y;
                this.x = 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:263:0x0507, code lost:
        if ((r3 instanceof defpackage.bv) != false) goto L234;
     */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(defpackage.az r35, boolean r36, boolean r37, boolean r38, boolean r39, defpackage.bd r40, defpackage.bd r41, defpackage.bz.a r42, boolean r43, defpackage.by r44, defpackage.by r45, int r46, int r47, int r48, int r49, float r50, boolean r51, boolean r52, boolean r53, boolean r54, boolean r55, int r56, int r57, int r58, int r59, float r60, boolean r61) {
        /*
            Method dump skipped, instructions count: 1630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bz.a(az, boolean, boolean, boolean, boolean, bd, bd, bz$a, boolean, by, by, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void b(az azVar, boolean z) {
        cv cvVar;
        ct ctVar;
        int b = azVar.b(this.z);
        int b2 = azVar.b(this.A);
        int b3 = azVar.b(this.B);
        int b4 = azVar.b(this.C);
        if (z && (ctVar = this.f) != null && ctVar.j.j && this.f.k.j) {
            b = this.f.j.g;
            b3 = this.f.k.g;
        }
        if (z && (cvVar = this.g) != null && cvVar.j.j && this.g.k.j) {
            b2 = this.g.j.g;
            b4 = this.g.k.g;
        }
        int i = b4 - b2;
        if (b3 - b < 0 || i < 0 || b == Integer.MIN_VALUE || b == Integer.MAX_VALUE || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE) {
            b4 = 0;
            b = 0;
            b2 = 0;
            b3 = 0;
        }
        a(b, b2, b3, b4);
    }

    public void a(bz bzVar, HashMap<bz, bz> hashMap) {
        this.k = bzVar.k;
        this.l = bzVar.l;
        this.m = bzVar.m;
        this.n = bzVar.n;
        int[] iArr = this.o;
        int[] iArr2 = bzVar.o;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.p = bzVar.p;
        this.q = bzVar.q;
        this.s = bzVar.s;
        this.t = bzVar.t;
        this.u = bzVar.u;
        this.v = bzVar.v;
        this.w = bzVar.w;
        this.x = bzVar.x;
        this.y = bzVar.y;
        int[] iArr3 = bzVar.aG;
        this.aG = Arrays.copyOf(iArr3, iArr3.length);
        this.aH = bzVar.aH;
        this.aI = bzVar.aI;
        this.aJ = bzVar.aJ;
        this.z.l();
        this.A.l();
        this.B.l();
        this.C.l();
        this.D.l();
        this.E.l();
        this.F.l();
        this.G.l();
        this.J = (a[]) Arrays.copyOf(this.J, 2);
        this.K = this.K == null ? null : hashMap.get(bzVar.K);
        this.L = bzVar.L;
        this.M = bzVar.M;
        this.N = bzVar.N;
        this.O = bzVar.O;
        this.P = bzVar.P;
        this.Q = bzVar.Q;
        this.R = bzVar.R;
        this.S = bzVar.S;
        this.T = bzVar.T;
        this.U = bzVar.U;
        this.V = bzVar.V;
        this.W = bzVar.W;
        this.X = bzVar.X;
        this.Z = bzVar.Z;
        this.aa = bzVar.aa;
        this.aO = bzVar.aO;
        this.aP = bzVar.aP;
        this.aQ = bzVar.aQ;
        this.aR = bzVar.aR;
        this.aS = bzVar.aS;
        this.ab = bzVar.ab;
        this.ac = bzVar.ac;
        this.ad = bzVar.ad;
        this.ae = bzVar.ae;
        this.af = bzVar.af;
        this.ag = bzVar.ag;
        this.ah = bzVar.ah;
        this.ai = bzVar.ai;
        this.aj = bzVar.aj;
        this.ak = bzVar.ak;
        this.am = bzVar.am;
        this.an = bzVar.an;
        this.ao = bzVar.ao;
        this.ap = bzVar.ap;
        float[] fArr = this.aq;
        float[] fArr2 = bzVar.aq;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        bz[] bzVarArr = this.ar;
        bz[] bzVarArr2 = bzVar.ar;
        bzVarArr[0] = bzVarArr2[0];
        bzVarArr[1] = bzVarArr2[1];
        bz[] bzVarArr3 = this.as;
        bz[] bzVarArr4 = bzVar.as;
        bzVarArr3[0] = bzVarArr4[0];
        bzVarArr3[1] = bzVarArr4[1];
        bz bzVar2 = bzVar.at;
        this.at = bzVar2 == null ? null : hashMap.get(bzVar2);
        bz bzVar3 = bzVar.au;
        this.au = bzVar3 != null ? hashMap.get(bzVar3) : null;
    }

    public void a(boolean z, boolean z2) {
        int i;
        int i2;
        boolean g = z & this.f.g();
        boolean g2 = z2 & this.g.g();
        int i3 = this.f.j.g;
        int i4 = this.g.j.g;
        int i5 = this.f.k.g;
        int i6 = this.g.k.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (g) {
            this.P = i3;
        }
        if (g2) {
            this.Q = i4;
        }
        if (this.aQ == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (g) {
            if (this.J[0] != a.FIXED || i8 >= (i2 = this.L)) {
                i2 = i8;
            }
            this.L = i2;
            int i10 = this.L;
            int i11 = this.W;
            if (i10 < i11) {
                this.L = i11;
            }
        }
        if (g2) {
            if (this.J[1] != a.FIXED || i9 >= (i = this.M)) {
                i = i9;
            }
            this.M = i;
            int i12 = this.M;
            int i13 = this.X;
            if (i12 < i13) {
                this.M = i13;
            }
        }
    }

    public void a(ca caVar, az azVar, HashSet<bz> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            cf.a(caVar, azVar, this);
            hashSet.remove(this);
            a(azVar, caVar.b(64));
        }
        if (i == 0) {
            HashSet<by> a2 = this.z.a();
            if (a2 != null) {
                Iterator<by> it = a2.iterator();
                while (it.hasNext()) {
                    it.next().a.a(caVar, azVar, hashSet, i, true);
                }
            }
            HashSet<by> a3 = this.B.a();
            if (a3 != null) {
                Iterator<by> it2 = a3.iterator();
                while (it2.hasNext()) {
                    it2.next().a.a(caVar, azVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<by> a4 = this.A.a();
        if (a4 != null) {
            Iterator<by> it3 = a4.iterator();
            while (it3.hasNext()) {
                it3.next().a.a(caVar, azVar, hashSet, i, true);
            }
        }
        HashSet<by> a5 = this.C.a();
        if (a5 != null) {
            Iterator<by> it4 = a5.iterator();
            while (it4.hasNext()) {
                it4.next().a.a(caVar, azVar, hashSet, i, true);
            }
        }
        HashSet<by> a6 = this.D.a();
        if (a6 != null) {
            Iterator<by> it5 = a6.iterator();
            while (it5.hasNext()) {
                it5.next().a.a(caVar, azVar, hashSet, i, true);
            }
        }
    }
}
