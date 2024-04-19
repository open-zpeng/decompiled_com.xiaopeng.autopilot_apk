package defpackage;

import defpackage.bd;
import defpackage.by;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: LinearSystem.java */
/* renamed from: az  reason: default package */
/* loaded from: classes.dex */
public class az {
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static ba o = null;
    public static long p = 0;
    public static long q = 0;
    private static int r = 1000;
    private a A;
    ax[] i;
    public boolean j;
    public boolean k;
    int l;
    int m;
    final ay n;
    private a t;
    private int v;
    private boolean[] w;
    private int x;
    private bd[] y;
    private int z;
    public boolean g = false;
    int h = 0;
    private HashMap<String, bd> s = null;
    private int u = 32;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* renamed from: az$a */
    /* loaded from: classes.dex */
    public interface a {
        bd a(az azVar, boolean[] zArr);

        void a(a aVar);

        void d(bd bdVar);

        boolean e();

        void f();

        bd g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* renamed from: az$b */
    /* loaded from: classes.dex */
    public class b extends ax {
        public b(ay ayVar) {
            this.e = new be(this, ayVar);
        }
    }

    public az() {
        int i = this.u;
        this.v = i;
        this.i = null;
        this.j = false;
        this.k = false;
        this.w = new boolean[i];
        this.l = 1;
        this.m = 0;
        this.x = i;
        this.y = new bd[r];
        this.z = 0;
        this.i = new ax[i];
        i();
        this.n = new ay();
        this.t = new bc(this.n);
        if (f) {
            this.A = new b(this.n);
        } else {
            this.A = new ax(this.n);
        }
    }

    public void a(ba baVar) {
        o = baVar;
    }

    public static ba a() {
        return o;
    }

    private void h() {
        this.u *= 2;
        this.i = (ax[]) Arrays.copyOf(this.i, this.u);
        ay ayVar = this.n;
        ayVar.d = (bd[]) Arrays.copyOf(ayVar.d, this.u);
        int i = this.u;
        this.w = new boolean[i];
        this.v = i;
        this.x = i;
        ba baVar = o;
        if (baVar != null) {
            baVar.d++;
            ba baVar2 = o;
            baVar2.o = Math.max(baVar2.o, this.u);
            ba baVar3 = o;
            baVar3.x = baVar3.o;
        }
    }

    private void i() {
        int i = 0;
        if (f) {
            while (i < this.m) {
                ax axVar = this.i[i];
                if (axVar != null) {
                    this.n.a.a(axVar);
                }
                this.i[i] = null;
                i++;
            }
            return;
        }
        while (i < this.m) {
            ax axVar2 = this.i[i];
            if (axVar2 != null) {
                this.n.b.a(axVar2);
            }
            this.i[i] = null;
            i++;
        }
    }

    public void b() {
        for (int i = 0; i < this.n.d.length; i++) {
            bd bdVar = this.n.d[i];
            if (bdVar != null) {
                bdVar.b();
            }
        }
        this.n.c.a(this.y, this.z);
        this.z = 0;
        Arrays.fill(this.n.d, (Object) null);
        HashMap<String, bd> hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.h = 0;
        this.t.f();
        this.l = 1;
        for (int i2 = 0; i2 < this.m; i2++) {
            ax[] axVarArr = this.i;
            if (axVarArr[i2] != null) {
                axVarArr[i2].c = false;
            }
        }
        i();
        this.m = 0;
        if (f) {
            this.A = new b(this.n);
        } else {
            this.A = new ax(this.n);
        }
    }

    public bd a(Object obj) {
        bd bdVar = null;
        if (obj == null) {
            return null;
        }
        if (this.l + 1 >= this.v) {
            h();
        }
        if (obj instanceof by) {
            by byVar = (by) obj;
            bdVar = byVar.g();
            if (bdVar == null) {
                byVar.a(this.n);
                bdVar = byVar.g();
            }
            if (bdVar.b == -1 || bdVar.b > this.h || this.n.d[bdVar.b] == null) {
                if (bdVar.b != -1) {
                    bdVar.b();
                }
                this.h++;
                this.l++;
                bdVar.b = this.h;
                bdVar.i = bd.a.UNRESTRICTED;
                this.n.d[this.h] = bdVar;
            }
        }
        return bdVar;
    }

    public ax c() {
        ax a2;
        if (f) {
            a2 = this.n.a.a();
            if (a2 == null) {
                a2 = new b(this.n);
                q++;
            } else {
                a2.c();
            }
        } else {
            a2 = this.n.b.a();
            if (a2 == null) {
                a2 = new ax(this.n);
                p++;
            } else {
                a2.c();
            }
        }
        bd.a();
        return a2;
    }

    public bd d() {
        ba baVar = o;
        if (baVar != null) {
            baVar.m++;
        }
        if (this.l + 1 >= this.v) {
            h();
        }
        bd a2 = a(bd.a.SLACK, (String) null);
        this.h++;
        this.l++;
        a2.b = this.h;
        this.n.d[this.h] = a2;
        return a2;
    }

    public bd e() {
        ba baVar = o;
        if (baVar != null) {
            baVar.n++;
        }
        if (this.l + 1 >= this.v) {
            h();
        }
        bd a2 = a(bd.a.SLACK, (String) null);
        this.h++;
        this.l++;
        a2.b = this.h;
        this.n.d[this.h] = a2;
        return a2;
    }

    void a(ax axVar, int i, int i2) {
        axVar.c(a(i2, (String) null), i);
    }

    public bd a(int i, String str) {
        ba baVar = o;
        if (baVar != null) {
            baVar.l++;
        }
        if (this.l + 1 >= this.v) {
            h();
        }
        bd a2 = a(bd.a.ERROR, str);
        this.h++;
        this.l++;
        a2.b = this.h;
        a2.d = i;
        this.n.d[this.h] = a2;
        this.t.d(a2);
        return a2;
    }

    private bd a(bd.a aVar, String str) {
        bd a2 = this.n.c.a();
        if (a2 == null) {
            a2 = new bd(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.b();
            a2.a(aVar, str);
        }
        int i = this.z;
        int i2 = r;
        if (i >= i2) {
            r = i2 * 2;
            this.y = (bd[]) Arrays.copyOf(this.y, r);
        }
        bd[] bdVarArr = this.y;
        int i3 = this.z;
        this.z = i3 + 1;
        bdVarArr[i3] = a2;
        return a2;
    }

    public int b(Object obj) {
        bd g = ((by) obj).g();
        if (g != null) {
            return (int) (g.e + 0.5f);
        }
        return 0;
    }

    public void f() throws Exception {
        ba baVar = o;
        if (baVar != null) {
            baVar.e++;
        }
        if (this.t.e()) {
            j();
        } else if (this.j || this.k) {
            ba baVar2 = o;
            if (baVar2 != null) {
                baVar2.q++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.m) {
                    z = true;
                    break;
                } else if (!this.i[i].f) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                a(this.t);
                return;
            }
            ba baVar3 = o;
            if (baVar3 != null) {
                baVar3.p++;
            }
            j();
        } else {
            a(this.t);
        }
    }

    void a(a aVar) throws Exception {
        ba baVar = o;
        if (baVar != null) {
            baVar.t++;
            ba baVar2 = o;
            baVar2.u = Math.max(baVar2.u, this.l);
            ba baVar3 = o;
            baVar3.v = Math.max(baVar3.v, this.m);
        }
        b(aVar);
        a(aVar, false);
        j();
    }

    public void a(ax axVar) {
        bd c2;
        if (axVar == null) {
            return;
        }
        ba baVar = o;
        if (baVar != null) {
            baVar.f++;
            if (axVar.f) {
                o.g++;
            }
        }
        if (this.m + 1 >= this.x || this.l + 1 >= this.v) {
            h();
        }
        boolean z = false;
        if (!axVar.f) {
            axVar.c(this);
            if (axVar.e()) {
                return;
            }
            axVar.d();
            if (axVar.a(this)) {
                bd e2 = e();
                axVar.a = e2;
                int i = this.m;
                b(axVar);
                if (this.m == i + 1) {
                    this.A.a(axVar);
                    a(this.A, true);
                    if (e2.c == -1) {
                        if (axVar.a == e2 && (c2 = axVar.c(e2)) != null) {
                            ba baVar2 = o;
                            if (baVar2 != null) {
                                baVar2.j++;
                            }
                            axVar.b(c2);
                        }
                        if (!axVar.f) {
                            axVar.a.a(this, axVar);
                        }
                        if (f) {
                            this.n.a.a(axVar);
                        } else {
                            this.n.b.a(axVar);
                        }
                        this.m--;
                    }
                    z = true;
                }
            }
            if (!axVar.a()) {
                return;
            }
        }
        if (z) {
            return;
        }
        b(axVar);
    }

    private final void b(ax axVar) {
        int i;
        if (c && axVar.f) {
            axVar.a.a(this, axVar.b);
        } else {
            this.i[this.m] = axVar;
            bd bdVar = axVar.a;
            int i2 = this.m;
            bdVar.c = i2;
            this.m = i2 + 1;
            axVar.a.a(this, axVar);
        }
        if (c && this.g) {
            int i3 = 0;
            while (i3 < this.m) {
                if (this.i[i3] == null) {
                    System.out.println("WTF");
                }
                ax[] axVarArr = this.i;
                if (axVarArr[i3] != null && axVarArr[i3].f) {
                    ax axVar2 = this.i[i3];
                    axVar2.a.a(this, axVar2.b);
                    if (f) {
                        this.n.a.a(axVar2);
                    } else {
                        this.n.b.a(axVar2);
                    }
                    this.i[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.m;
                        if (i4 >= i) {
                            break;
                        }
                        ax[] axVarArr2 = this.i;
                        int i6 = i4 - 1;
                        axVarArr2[i6] = axVarArr2[i4];
                        if (axVarArr2[i6].a.c == i4) {
                            this.i[i6].a.c = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.i[i5] = null;
                    }
                    this.m--;
                    i3--;
                }
                i3++;
            }
            this.g = false;
        }
    }

    private final int a(a aVar, boolean z) {
        ba baVar = o;
        if (baVar != null) {
            baVar.h++;
        }
        for (int i = 0; i < this.l; i++) {
            this.w[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            ba baVar2 = o;
            if (baVar2 != null) {
                baVar2.i++;
            }
            i2++;
            if (i2 >= this.l * 2) {
                return i2;
            }
            if (aVar.g() != null) {
                this.w[aVar.g().b] = true;
            }
            bd a2 = aVar.a(this, this.w);
            if (a2 != null) {
                if (this.w[a2.b]) {
                    return i2;
                }
                this.w[a2.b] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.m; i4++) {
                    ax axVar = this.i[i4];
                    if (axVar.a.i != bd.a.UNRESTRICTED && !axVar.f && axVar.a(a2)) {
                        float b2 = axVar.e.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-axVar.b) / b2;
                            if (f3 < f2) {
                                i3 = i4;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    ax axVar2 = this.i[i3];
                    axVar2.a.c = -1;
                    ba baVar3 = o;
                    if (baVar3 != null) {
                        baVar3.j++;
                    }
                    axVar2.b(a2);
                    axVar2.a.c = i3;
                    axVar2.a.a(this, axVar2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    private int b(a aVar) throws Exception {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.m) {
                z = false;
                break;
            } else if (this.i[i].a.i != bd.a.UNRESTRICTED && this.i[i].b < 0.0f) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            boolean z2 = false;
            int i2 = 0;
            while (!z2) {
                ba baVar = o;
                if (baVar != null) {
                    baVar.k++;
                }
                i2++;
                float f2 = Float.MAX_VALUE;
                int i3 = -1;
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < this.m; i6++) {
                    ax axVar = this.i[i6];
                    if (axVar.a.i != bd.a.UNRESTRICTED && !axVar.f && axVar.b < 0.0f) {
                        int i7 = 9;
                        if (e) {
                            int c2 = axVar.e.c();
                            int i8 = i5;
                            float f3 = f2;
                            int i9 = i4;
                            int i10 = i3;
                            int i11 = 0;
                            while (i11 < c2) {
                                bd a2 = axVar.e.a(i11);
                                float b2 = axVar.e.b(a2);
                                if (b2 > 0.0f) {
                                    int i12 = i8;
                                    int i13 = 0;
                                    while (i13 < i7) {
                                        float f4 = a2.g[i13] / b2;
                                        if ((f4 < f3 && i13 == i12) || i13 > i12) {
                                            i10 = i6;
                                            i9 = a2.b;
                                            f3 = f4;
                                            i12 = i13;
                                        }
                                        i13++;
                                        i7 = 9;
                                    }
                                    i8 = i12;
                                }
                                i11++;
                                i7 = 9;
                            }
                            i3 = i10;
                            i4 = i9;
                            f2 = f3;
                            i5 = i8;
                        } else {
                            for (int i14 = 1; i14 < this.l; i14++) {
                                bd bdVar = this.n.d[i14];
                                float b3 = axVar.e.b(bdVar);
                                if (b3 > 0.0f) {
                                    for (int i15 = 0; i15 < 9; i15++) {
                                        float f5 = bdVar.g[i15] / b3;
                                        if ((f5 < f2 && i15 == i5) || i15 > i5) {
                                            i4 = i14;
                                            i3 = i6;
                                            i5 = i15;
                                            f2 = f5;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i3 != -1) {
                    ax axVar2 = this.i[i3];
                    axVar2.a.c = -1;
                    ba baVar2 = o;
                    if (baVar2 != null) {
                        baVar2.j++;
                    }
                    axVar2.b(this.n.d[i4]);
                    axVar2.a.c = i3;
                    axVar2.a.a(this, axVar2);
                } else {
                    z2 = true;
                }
                if (i2 > this.l / 2) {
                    z2 = true;
                }
            }
            return i2;
        }
        return 0;
    }

    private void j() {
        for (int i = 0; i < this.m; i++) {
            ax axVar = this.i[i];
            axVar.a.e = axVar.b;
        }
    }

    public ay g() {
        return this.n;
    }

    public void a(bd bdVar, bd bdVar2, int i, int i2) {
        ax c2 = c();
        bd d2 = d();
        d2.d = 0;
        c2.a(bdVar, bdVar2, d2, i);
        if (i2 != 8) {
            a(c2, (int) (c2.e.b(d2) * (-1.0f)), i2);
        }
        a(c2);
    }

    public void a(bd bdVar, bd bdVar2, int i, boolean z) {
        ax c2 = c();
        bd d2 = d();
        d2.d = 0;
        c2.a(bdVar, bdVar2, d2, i);
        a(c2);
    }

    public void b(bd bdVar, bd bdVar2, int i, int i2) {
        ax c2 = c();
        bd d2 = d();
        d2.d = 0;
        c2.b(bdVar, bdVar2, d2, i);
        if (i2 != 8) {
            a(c2, (int) (c2.e.b(d2) * (-1.0f)), i2);
        }
        a(c2);
    }

    public void b(bd bdVar, bd bdVar2, int i, boolean z) {
        ax c2 = c();
        bd d2 = d();
        d2.d = 0;
        c2.b(bdVar, bdVar2, d2, i);
        a(c2);
    }

    public void a(bd bdVar, bd bdVar2, int i, float f2, bd bdVar3, bd bdVar4, int i2, int i3) {
        ax c2 = c();
        c2.a(bdVar, bdVar2, i, f2, bdVar3, bdVar4, i2);
        if (i3 != 8) {
            c2.a(this, i3);
        }
        a(c2);
    }

    public void a(bd bdVar, bd bdVar2, bd bdVar3, bd bdVar4, float f2, int i) {
        ax c2 = c();
        c2.a(bdVar, bdVar2, bdVar3, bdVar4, f2);
        if (i != 8) {
            c2.a(this, i);
        }
        a(c2);
    }

    public ax c(bd bdVar, bd bdVar2, int i, int i2) {
        if (b && i2 == 8 && bdVar2.f && bdVar.c == -1) {
            bdVar.a(this, bdVar2.e + i);
            return null;
        }
        ax c2 = c();
        c2.a(bdVar, bdVar2, i);
        if (i2 != 8) {
            c2.a(this, i2);
        }
        a(c2);
        return c2;
    }

    public void a(bd bdVar, int i) {
        if (b && bdVar.c == -1) {
            float f2 = i;
            bdVar.a(this, f2);
            for (int i2 = 0; i2 < this.h + 1; i2++) {
                bd bdVar2 = this.n.d[i2];
                if (bdVar2 != null && bdVar2.m && bdVar2.n == bdVar.b) {
                    bdVar2.a(this, bdVar2.o + f2);
                }
            }
            return;
        }
        int i3 = bdVar.c;
        if (bdVar.c != -1) {
            ax axVar = this.i[i3];
            if (axVar.f) {
                axVar.b = i;
                return;
            } else if (axVar.e.c() == 0) {
                axVar.f = true;
                axVar.b = i;
                return;
            } else {
                ax c2 = c();
                c2.b(bdVar, i);
                a(c2);
                return;
            }
        }
        ax c3 = c();
        c3.a(bdVar, i);
        a(c3);
    }

    public static ax a(az azVar, bd bdVar, bd bdVar2, float f2) {
        return azVar.c().a(bdVar, bdVar2, f2);
    }

    public void a(bz bzVar, bz bzVar2, float f2, int i) {
        bd a2 = a(bzVar.a(by.a.LEFT));
        bd a3 = a(bzVar.a(by.a.TOP));
        bd a4 = a(bzVar.a(by.a.RIGHT));
        bd a5 = a(bzVar.a(by.a.BOTTOM));
        bd a6 = a(bzVar2.a(by.a.LEFT));
        bd a7 = a(bzVar2.a(by.a.TOP));
        bd a8 = a(bzVar2.a(by.a.RIGHT));
        bd a9 = a(bzVar2.a(by.a.BOTTOM));
        ax c2 = c();
        double d2 = f2;
        double d3 = i;
        c2.b(a3, a5, a7, a9, (float) (Math.sin(d2) * d3));
        a(c2);
        ax c3 = c();
        c3.b(a2, a4, a6, a8, (float) (Math.cos(d2) * d3));
        a(c3);
    }
}
