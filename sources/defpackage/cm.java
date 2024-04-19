package defpackage;

import defpackage.bz;
import defpackage.cj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: DependencyGraph.java */
/* renamed from: cm  reason: default package */
/* loaded from: classes.dex */
public class cm {
    private ca b;
    private ca e;
    private boolean c = true;
    private boolean d = true;
    private ArrayList<cx> f = new ArrayList<>();
    private ArrayList<cu> g = new ArrayList<>();
    private cj.b h = null;
    private cj.a i = new cj.a();
    ArrayList<cu> a = new ArrayList<>();

    public cm(ca caVar) {
        this.b = caVar;
        this.e = caVar;
    }

    public void a(cj.b bVar) {
        this.h = bVar;
    }

    private int a(ca caVar, int i) {
        int size = this.a.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j = Math.max(j, this.a.get(i2).a(caVar, i));
        }
        return (int) j;
    }

    public boolean a(boolean z) {
        boolean z2;
        boolean z3 = z & true;
        boolean z4 = false;
        if (this.c || this.d) {
            Iterator<bz> it = this.b.aT.iterator();
            while (it.hasNext()) {
                bz next = it.next();
                next.z();
                next.b = false;
                next.f.d();
                next.g.d();
            }
            this.b.z();
            ca caVar = this.b;
            caVar.b = false;
            caVar.f.d();
            this.b.g.d();
            this.d = false;
        }
        if (a(this.e)) {
            return false;
        }
        this.b.o(0);
        this.b.p(0);
        bz.a x = this.b.x(0);
        bz.a x2 = this.b.x(1);
        if (this.c) {
            d();
        }
        int D = this.b.D();
        int E = this.b.E();
        this.b.f.j.a(D);
        this.b.g.j.a(E);
        a();
        if (x == bz.a.WRAP_CONTENT || x2 == bz.a.WRAP_CONTENT) {
            if (z3) {
                Iterator<cx> it2 = this.f.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().a()) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3 && x == bz.a.WRAP_CONTENT) {
                this.b.a(bz.a.FIXED);
                ca caVar2 = this.b;
                caVar2.q(a(caVar2, 0));
                this.b.f.g.a(this.b.F());
            }
            if (z3 && x2 == bz.a.WRAP_CONTENT) {
                this.b.b(bz.a.FIXED);
                ca caVar3 = this.b;
                caVar3.r(a(caVar3, 1));
                this.b.g.g.a(this.b.G());
            }
        }
        if (this.b.J[0] == bz.a.FIXED || this.b.J[0] == bz.a.MATCH_PARENT) {
            int F = this.b.F() + D;
            this.b.f.k.a(F);
            this.b.f.g.a(F - D);
            a();
            if (this.b.J[1] == bz.a.FIXED || this.b.J[1] == bz.a.MATCH_PARENT) {
                int G = this.b.G() + E;
                this.b.g.k.a(G);
                this.b.g.g.a(G - E);
            }
            a();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<cx> it3 = this.f.iterator();
        while (it3.hasNext()) {
            cx next2 = it3.next();
            if (next2.d != this.b || next2.i) {
                next2.e();
            }
        }
        Iterator<cx> it4 = this.f.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z4 = true;
                break;
            }
            cx next3 = it4.next();
            if (z2 || next3.d != this.b) {
                if (!next3.j.j) {
                    break;
                }
                if (!next3.k.j) {
                    if (!(next3 instanceof cr)) {
                        break;
                    }
                }
                if (!next3.g.j && !(next3 instanceof ck) && !(next3 instanceof cr)) {
                    break;
                }
            }
        }
        this.b.a(x);
        this.b.b(x2);
        return z4;
    }

    public boolean b(boolean z) {
        if (this.c) {
            Iterator<bz> it = this.b.aT.iterator();
            while (it.hasNext()) {
                bz next = it.next();
                next.z();
                next.b = false;
                next.f.g.j = false;
                next.f.i = false;
                next.f.d();
                next.g.g.j = false;
                next.g.i = false;
                next.g.d();
            }
            this.b.z();
            ca caVar = this.b;
            caVar.b = false;
            caVar.f.g.j = false;
            this.b.f.i = false;
            this.b.f.d();
            this.b.g.g.j = false;
            this.b.g.i = false;
            this.b.g.d();
            d();
        }
        if (a(this.e)) {
            return false;
        }
        this.b.o(0);
        this.b.p(0);
        this.b.f.j.a(0);
        this.b.g.j.a(0);
        return true;
    }

    public boolean a(boolean z, int i) {
        boolean z2;
        boolean z3 = z & true;
        boolean z4 = false;
        bz.a x = this.b.x(0);
        bz.a x2 = this.b.x(1);
        int D = this.b.D();
        int E = this.b.E();
        if (z3 && (x == bz.a.WRAP_CONTENT || x2 == bz.a.WRAP_CONTENT)) {
            Iterator<cx> it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cx next = it.next();
                if (next.h == i && !next.a()) {
                    z3 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z3 && x == bz.a.WRAP_CONTENT) {
                    this.b.a(bz.a.FIXED);
                    ca caVar = this.b;
                    caVar.q(a(caVar, 0));
                    this.b.f.g.a(this.b.F());
                }
            } else if (z3 && x2 == bz.a.WRAP_CONTENT) {
                this.b.b(bz.a.FIXED);
                ca caVar2 = this.b;
                caVar2.r(a(caVar2, 1));
                this.b.g.g.a(this.b.G());
            }
        }
        if (i == 0) {
            if (this.b.J[0] == bz.a.FIXED || this.b.J[0] == bz.a.MATCH_PARENT) {
                int F = this.b.F() + D;
                this.b.f.k.a(F);
                this.b.f.g.a(F - D);
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.b.J[1] == bz.a.FIXED || this.b.J[1] == bz.a.MATCH_PARENT) {
                int G = this.b.G() + E;
                this.b.g.k.a(G);
                this.b.g.g.a(G - E);
                z2 = true;
            }
            z2 = false;
        }
        a();
        Iterator<cx> it2 = this.f.iterator();
        while (it2.hasNext()) {
            cx next2 = it2.next();
            if (next2.h == i && (next2.d != this.b || next2.i)) {
                next2.e();
            }
        }
        Iterator<cx> it3 = this.f.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z4 = true;
                break;
            }
            cx next3 = it3.next();
            if (next3.h == i && (z2 || next3.d != this.b)) {
                if (!next3.j.j) {
                    break;
                } else if (!next3.k.j) {
                    break;
                } else if (!(next3 instanceof ck) && !next3.g.j) {
                    break;
                }
            }
        }
        this.b.a(x);
        this.b.b(x2);
        return z4;
    }

    private void a(bz bzVar, bz.a aVar, int i, bz.a aVar2, int i2) {
        cj.a aVar3 = this.i;
        aVar3.d = aVar;
        aVar3.e = aVar2;
        aVar3.f = i;
        aVar3.g = i2;
        this.h.a(bzVar, aVar3);
        bzVar.q(this.i.h);
        bzVar.r(this.i.i);
        bzVar.c(this.i.k);
        bzVar.u(this.i.j);
    }

    private boolean a(ca caVar) {
        int i;
        bz.a aVar;
        int i2;
        Iterator<bz> it = caVar.aT.iterator();
        while (it.hasNext()) {
            bz next = it.next();
            bz.a aVar2 = next.J[0];
            bz.a aVar3 = next.J[1];
            if (next.B() == 8) {
                next.b = true;
            } else {
                if (next.r < 1.0f && aVar2 == bz.a.MATCH_CONSTRAINT) {
                    next.m = 2;
                }
                if (next.u < 1.0f && aVar3 == bz.a.MATCH_CONSTRAINT) {
                    next.n = 2;
                }
                if (next.S() > 0.0f) {
                    if (aVar2 == bz.a.MATCH_CONSTRAINT && (aVar3 == bz.a.WRAP_CONTENT || aVar3 == bz.a.FIXED)) {
                        next.m = 3;
                    } else if (aVar3 == bz.a.MATCH_CONSTRAINT && (aVar2 == bz.a.WRAP_CONTENT || aVar2 == bz.a.FIXED)) {
                        next.n = 3;
                    } else if (aVar2 == bz.a.MATCH_CONSTRAINT && aVar3 == bz.a.MATCH_CONSTRAINT) {
                        if (next.m == 0) {
                            next.m = 3;
                        }
                        if (next.n == 0) {
                            next.n = 3;
                        }
                    }
                }
                bz.a aVar4 = (aVar2 == bz.a.MATCH_CONSTRAINT && next.m == 1 && (next.z.c == null || next.B.c == null)) ? bz.a.WRAP_CONTENT : aVar2;
                bz.a aVar5 = (aVar3 == bz.a.MATCH_CONSTRAINT && next.n == 1 && (next.A.c == null || next.C.c == null)) ? bz.a.WRAP_CONTENT : aVar3;
                next.f.f = aVar4;
                next.f.c = next.m;
                next.g.f = aVar5;
                next.g.c = next.n;
                if ((aVar4 == bz.a.MATCH_PARENT || aVar4 == bz.a.FIXED || aVar4 == bz.a.WRAP_CONTENT) && (aVar5 == bz.a.MATCH_PARENT || aVar5 == bz.a.FIXED || aVar5 == bz.a.WRAP_CONTENT)) {
                    int F = next.F();
                    if (aVar4 == bz.a.MATCH_PARENT) {
                        i = (caVar.F() - next.z.d) - next.B.d;
                        aVar4 = bz.a.FIXED;
                    } else {
                        i = F;
                    }
                    int G = next.G();
                    if (aVar5 == bz.a.MATCH_PARENT) {
                        i2 = (caVar.G() - next.A.d) - next.C.d;
                        aVar = bz.a.FIXED;
                    } else {
                        aVar = aVar5;
                        i2 = G;
                    }
                    a(next, aVar4, i, aVar, i2);
                    next.f.g.a(next.F());
                    next.g.g.a(next.G());
                    next.b = true;
                } else {
                    if (aVar4 == bz.a.MATCH_CONSTRAINT && (aVar5 == bz.a.WRAP_CONTENT || aVar5 == bz.a.FIXED)) {
                        if (next.m == 3) {
                            if (aVar5 == bz.a.WRAP_CONTENT) {
                                a(next, bz.a.WRAP_CONTENT, 0, bz.a.WRAP_CONTENT, 0);
                            }
                            int G2 = next.G();
                            a(next, bz.a.FIXED, (int) ((G2 * next.N) + 0.5f), bz.a.FIXED, G2);
                            next.f.g.a(next.F());
                            next.g.g.a(next.G());
                            next.b = true;
                        } else if (next.m == 1) {
                            a(next, bz.a.WRAP_CONTENT, 0, aVar5, 0);
                            next.f.g.m = next.F();
                        } else if (next.m == 2) {
                            if (caVar.J[0] == bz.a.FIXED || caVar.J[0] == bz.a.MATCH_PARENT) {
                                a(next, bz.a.FIXED, (int) ((next.r * caVar.F()) + 0.5f), aVar5, next.G());
                                next.f.g.a(next.F());
                                next.g.g.a(next.G());
                                next.b = true;
                            }
                        } else if (next.H[0].c == null || next.H[1].c == null) {
                            a(next, bz.a.WRAP_CONTENT, 0, aVar5, 0);
                            next.f.g.a(next.F());
                            next.g.g.a(next.G());
                            next.b = true;
                        }
                    }
                    if (aVar5 == bz.a.MATCH_CONSTRAINT && (aVar4 == bz.a.WRAP_CONTENT || aVar4 == bz.a.FIXED)) {
                        if (next.n == 3) {
                            if (aVar4 == bz.a.WRAP_CONTENT) {
                                a(next, bz.a.WRAP_CONTENT, 0, bz.a.WRAP_CONTENT, 0);
                            }
                            int F2 = next.F();
                            float f = next.N;
                            if (next.T() == -1) {
                                f = 1.0f / f;
                            }
                            a(next, bz.a.FIXED, F2, bz.a.FIXED, (int) ((F2 * f) + 0.5f));
                            next.f.g.a(next.F());
                            next.g.g.a(next.G());
                            next.b = true;
                        } else if (next.n == 1) {
                            a(next, aVar4, 0, bz.a.WRAP_CONTENT, 0);
                            next.g.g.m = next.G();
                        } else if (next.n == 2) {
                            if (caVar.J[1] == bz.a.FIXED || caVar.J[1] == bz.a.MATCH_PARENT) {
                                a(next, aVar4, next.F(), bz.a.FIXED, (int) ((next.u * caVar.G()) + 0.5f));
                                next.f.g.a(next.F());
                                next.g.g.a(next.G());
                                next.b = true;
                            }
                        } else if (next.H[2].c == null || next.H[3].c == null) {
                            a(next, bz.a.WRAP_CONTENT, 0, aVar5, 0);
                            next.f.g.a(next.F());
                            next.g.g.a(next.G());
                            next.b = true;
                        }
                    }
                    if (aVar4 == bz.a.MATCH_CONSTRAINT && aVar5 == bz.a.MATCH_CONSTRAINT) {
                        if (next.m == 1 || next.n == 1) {
                            a(next, bz.a.WRAP_CONTENT, 0, bz.a.WRAP_CONTENT, 0);
                            next.f.g.m = next.F();
                            next.g.g.m = next.G();
                        } else if (next.n == 2 && next.m == 2 && caVar.J[0] == bz.a.FIXED && caVar.J[1] == bz.a.FIXED) {
                            a(next, bz.a.FIXED, (int) ((next.r * caVar.F()) + 0.5f), bz.a.FIXED, (int) ((next.u * caVar.G()) + 0.5f));
                            next.f.g.a(next.F());
                            next.g.g.a(next.G());
                            next.b = true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void a() {
        Iterator<bz> it = this.b.aT.iterator();
        while (it.hasNext()) {
            bz next = it.next();
            if (!next.b) {
                boolean z = false;
                bz.a aVar = next.J[0];
                bz.a aVar2 = next.J[1];
                int i = next.m;
                int i2 = next.n;
                boolean z2 = aVar == bz.a.WRAP_CONTENT || (aVar == bz.a.MATCH_CONSTRAINT && i == 1);
                if (aVar2 == bz.a.WRAP_CONTENT || (aVar2 == bz.a.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                boolean z3 = next.f.g.j;
                boolean z4 = next.g.g.j;
                if (z3 && z4) {
                    a(next, bz.a.FIXED, next.f.g.g, bz.a.FIXED, next.g.g.g);
                    next.b = true;
                } else if (z3 && z) {
                    a(next, bz.a.FIXED, next.f.g.g, bz.a.WRAP_CONTENT, next.g.g.g);
                    if (aVar2 == bz.a.MATCH_CONSTRAINT) {
                        next.g.g.m = next.G();
                    } else {
                        next.g.g.a(next.G());
                        next.b = true;
                    }
                } else if (z4 && z2) {
                    a(next, bz.a.WRAP_CONTENT, next.f.g.g, bz.a.FIXED, next.g.g.g);
                    if (aVar == bz.a.MATCH_CONSTRAINT) {
                        next.f.g.m = next.F();
                    } else {
                        next.f.g.a(next.F());
                        next.b = true;
                    }
                }
                if (next.b && next.g.b != null) {
                    next.g.b.a(next.Q());
                }
            }
        }
    }

    public void b() {
        this.c = true;
    }

    public void c() {
        this.d = true;
    }

    public void d() {
        a(this.f);
        this.a.clear();
        cu.a = 0;
        a(this.b.f, 0, this.a);
        a(this.b.g, 1, this.a);
        this.c = false;
    }

    public void a(ArrayList<cx> arrayList) {
        arrayList.clear();
        this.e.f.c();
        this.e.g.c();
        arrayList.add(this.e.f);
        arrayList.add(this.e.g);
        Iterator<bz> it = this.e.aT.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            bz next = it.next();
            if (next instanceof cc) {
                arrayList.add(new cr(next));
            } else {
                if (next.Z()) {
                    if (next.d == null) {
                        next.d = new ck(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.d);
                } else {
                    arrayList.add(next.f);
                }
                if (next.aa()) {
                    if (next.e == null) {
                        next.e = new ck(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.e);
                } else {
                    arrayList.add(next.g);
                }
                if (next instanceof ce) {
                    arrayList.add(new cs(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<cx> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
        Iterator<cx> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            cx next2 = it3.next();
            if (next2.d != this.e) {
                next2.f();
            }
        }
    }

    private void a(cn cnVar, int i, int i2, cn cnVar2, ArrayList<cu> arrayList, cu cuVar) {
        cx cxVar = cnVar.d;
        if (cxVar.e != null || cxVar == this.b.f || cxVar == this.b.g) {
            return;
        }
        if (cuVar == null) {
            cuVar = new cu(cxVar, i2);
            arrayList.add(cuVar);
        }
        cxVar.e = cuVar;
        cuVar.a(cxVar);
        for (cl clVar : cxVar.j.k) {
            if (clVar instanceof cn) {
                a((cn) clVar, i, 0, cnVar2, arrayList, cuVar);
            }
        }
        for (cl clVar2 : cxVar.k.k) {
            if (clVar2 instanceof cn) {
                a((cn) clVar2, i, 1, cnVar2, arrayList, cuVar);
            }
        }
        if (i == 1 && (cxVar instanceof cv)) {
            for (cl clVar3 : ((cv) cxVar).a.k) {
                if (clVar3 instanceof cn) {
                    a((cn) clVar3, i, 2, cnVar2, arrayList, cuVar);
                }
            }
        }
        for (cn cnVar3 : cxVar.j.l) {
            if (cnVar3 == cnVar2) {
                cuVar.c = true;
            }
            a(cnVar3, i, 0, cnVar2, arrayList, cuVar);
        }
        for (cn cnVar4 : cxVar.k.l) {
            if (cnVar4 == cnVar2) {
                cuVar.c = true;
            }
            a(cnVar4, i, 1, cnVar2, arrayList, cuVar);
        }
        if (i == 1 && (cxVar instanceof cv)) {
            for (cn cnVar5 : ((cv) cxVar).a.l) {
                a(cnVar5, i, 2, cnVar2, arrayList, cuVar);
            }
        }
    }

    private void a(cx cxVar, int i, ArrayList<cu> arrayList) {
        for (cl clVar : cxVar.j.k) {
            if (clVar instanceof cn) {
                a((cn) clVar, i, 0, cxVar.k, arrayList, null);
            } else if (clVar instanceof cx) {
                a(((cx) clVar).j, i, 0, cxVar.k, arrayList, null);
            }
        }
        for (cl clVar2 : cxVar.k.k) {
            if (clVar2 instanceof cn) {
                a((cn) clVar2, i, 1, cxVar.j, arrayList, null);
            } else if (clVar2 instanceof cx) {
                a(((cx) clVar2).k, i, 1, cxVar.j, arrayList, null);
            }
        }
        if (i == 1) {
            for (cl clVar3 : ((cv) cxVar).a.k) {
                if (clVar3 instanceof cn) {
                    a((cn) clVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }
}
