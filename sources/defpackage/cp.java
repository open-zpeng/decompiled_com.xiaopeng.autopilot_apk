package defpackage;

import defpackage.by;
import defpackage.bz;
import defpackage.cj;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: Direct.java */
/* renamed from: cp  reason: default package */
/* loaded from: classes.dex */
public class cp {
    private static cj.a a = new cj.a();
    private static int b = 0;
    private static int c = 0;

    public static void a(ca caVar, cj.b bVar) {
        bz.a X = caVar.X();
        bz.a Y = caVar.Y();
        b = 0;
        c = 0;
        caVar.n();
        ArrayList<bz> ah = caVar.ah();
        int size = ah.size();
        for (int i = 0; i < size; i++) {
            ah.get(i).n();
        }
        boolean ad = caVar.ad();
        if (X == bz.a.FIXED) {
            caVar.a(0, caVar.F());
        } else {
            caVar.d(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            bz bzVar = ah.get(i2);
            if (bzVar instanceof cc) {
                cc ccVar = (cc) bzVar;
                if (ccVar.c() == 1) {
                    if (ccVar.g() != -1) {
                        ccVar.B(ccVar.g());
                    } else if (ccVar.h() != -1 && caVar.d()) {
                        ccVar.B(caVar.F() - ccVar.h());
                    } else if (caVar.d()) {
                        ccVar.B((int) ((ccVar.f() * caVar.F()) + 0.5f));
                    }
                    z = true;
                }
            } else if ((bzVar instanceof bv) && ((bv) bzVar).h() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                bz bzVar2 = ah.get(i3);
                if (bzVar2 instanceof cc) {
                    cc ccVar2 = (cc) bzVar2;
                    if (ccVar2.c() == 1) {
                        a(0, ccVar2, bVar, ad);
                    }
                }
            }
        }
        a(0, caVar, bVar, ad);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                bz bzVar3 = ah.get(i4);
                if (bzVar3 instanceof bv) {
                    bv bvVar = (bv) bzVar3;
                    if (bvVar.h() == 0) {
                        a(0, bvVar, bVar, 0, ad);
                    }
                }
            }
        }
        if (Y == bz.a.FIXED) {
            caVar.b(0, caVar.G());
        } else {
            caVar.e(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            bz bzVar4 = ah.get(i5);
            if (bzVar4 instanceof cc) {
                cc ccVar3 = (cc) bzVar4;
                if (ccVar3.c() == 0) {
                    if (ccVar3.g() != -1) {
                        ccVar3.B(ccVar3.g());
                    } else if (ccVar3.h() != -1 && caVar.e()) {
                        ccVar3.B(caVar.G() - ccVar3.h());
                    } else if (caVar.e()) {
                        ccVar3.B((int) ((ccVar3.f() * caVar.G()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((bzVar4 instanceof bv) && ((bv) bzVar4).h() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                bz bzVar5 = ah.get(i6);
                if (bzVar5 instanceof cc) {
                    cc ccVar4 = (cc) bzVar5;
                    if (ccVar4.c() == 0) {
                        a(1, ccVar4, bVar);
                    }
                }
            }
        }
        a(0, caVar, bVar);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                bz bzVar6 = ah.get(i7);
                if (bzVar6 instanceof bv) {
                    bv bvVar2 = (bv) bzVar6;
                    if (bvVar2.h() == 1) {
                        a(0, bvVar2, bVar, 1, ad);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            bz bzVar7 = ah.get(i8);
            if (bzVar7.t() && a(0, bzVar7)) {
                ca.a(0, bzVar7, bVar, a, cj.a.a);
                if (bzVar7 instanceof cc) {
                    if (((cc) bzVar7).c() == 0) {
                        a(0, bzVar7, bVar);
                    } else {
                        a(0, bzVar7, bVar, ad);
                    }
                } else {
                    a(0, bzVar7, bVar, ad);
                    a(0, bzVar7, bVar);
                }
            }
        }
    }

    private static void a(int i, bv bvVar, cj.b bVar, int i2, boolean z) {
        if (bvVar.i()) {
            if (i2 == 0) {
                a(i + 1, bvVar, bVar, z);
            } else {
                a(i + 1, bvVar, bVar);
            }
        }
    }

    private static void a(int i, bz bzVar, cj.b bVar, boolean z) {
        if (bzVar.j()) {
            return;
        }
        b++;
        if (!(bzVar instanceof ca) && bzVar.t()) {
            int i2 = i + 1;
            if (a(i2, bzVar)) {
                ca.a(i2, bzVar, bVar, new cj.a(), cj.a.a);
            }
        }
        by a2 = bzVar.a(by.a.LEFT);
        by a3 = bzVar.a(by.a.RIGHT);
        int d = a2.d();
        int d2 = a3.d();
        if (a2.a() != null && a2.f()) {
            Iterator<by> it = a2.a().iterator();
            while (it.hasNext()) {
                by next = it.next();
                bz bzVar2 = next.a;
                int i3 = i + 1;
                boolean a4 = a(i3, bzVar2);
                if (bzVar2.t() && a4) {
                    ca.a(i3, bzVar2, bVar, new cj.a(), cj.a.a);
                }
                if (bzVar2.X() != bz.a.MATCH_CONSTRAINT || a4) {
                    if (!bzVar2.t()) {
                        if (next == bzVar2.z && bzVar2.B.c == null) {
                            int j = bzVar2.z.j() + d;
                            bzVar2.a(j, bzVar2.F() + j);
                            a(i3, bzVar2, bVar, z);
                        } else if (next == bzVar2.B && bzVar2.z.c == null) {
                            int j2 = d - bzVar2.B.j();
                            bzVar2.a(j2 - bzVar2.F(), j2);
                            a(i3, bzVar2, bVar, z);
                        } else if (next == bzVar2.z && bzVar2.B.c != null && bzVar2.B.c.f() && !bzVar2.Z()) {
                            a(i3, bVar, bzVar2, z);
                        }
                    }
                } else if (bzVar2.X() == bz.a.MATCH_CONSTRAINT && bzVar2.q >= 0 && bzVar2.p >= 0 && (bzVar2.B() == 8 || (bzVar2.m == 0 && bzVar2.S() == 0.0f))) {
                    if (!bzVar2.Z() && !bzVar2.p()) {
                        if (((next == bzVar2.z && bzVar2.B.c != null && bzVar2.B.c.f()) || (next == bzVar2.B && bzVar2.z.c != null && bzVar2.z.c.f())) && !bzVar2.Z()) {
                            a(i3, bzVar, bVar, bzVar2, z);
                        }
                    }
                }
            }
        }
        if (bzVar instanceof cc) {
            return;
        }
        if (a3.a() != null && a3.f()) {
            Iterator<by> it2 = a3.a().iterator();
            while (it2.hasNext()) {
                by next2 = it2.next();
                bz bzVar3 = next2.a;
                int i4 = i + 1;
                boolean a5 = a(i4, bzVar3);
                if (bzVar3.t() && a5) {
                    ca.a(i4, bzVar3, bVar, new cj.a(), cj.a.a);
                }
                boolean z2 = (next2 == bzVar3.z && bzVar3.B.c != null && bzVar3.B.c.f()) || (next2 == bzVar3.B && bzVar3.z.c != null && bzVar3.z.c.f());
                if (bzVar3.X() != bz.a.MATCH_CONSTRAINT || a5) {
                    if (!bzVar3.t()) {
                        if (next2 == bzVar3.z && bzVar3.B.c == null) {
                            int j3 = bzVar3.z.j() + d2;
                            bzVar3.a(j3, bzVar3.F() + j3);
                            a(i4, bzVar3, bVar, z);
                        } else if (next2 == bzVar3.B && bzVar3.z.c == null) {
                            int j4 = d2 - bzVar3.B.j();
                            bzVar3.a(j4 - bzVar3.F(), j4);
                            a(i4, bzVar3, bVar, z);
                        } else if (z2 && !bzVar3.Z()) {
                            a(i4, bVar, bzVar3, z);
                        }
                    }
                } else if (bzVar3.X() == bz.a.MATCH_CONSTRAINT && bzVar3.q >= 0 && bzVar3.p >= 0 && (bzVar3.B() == 8 || (bzVar3.m == 0 && bzVar3.S() == 0.0f))) {
                    if (!bzVar3.Z() && !bzVar3.p() && z2 && !bzVar3.Z()) {
                        a(i4, bzVar, bVar, bzVar3, z);
                    }
                }
            }
        }
        bzVar.l();
    }

    private static void a(int i, bz bzVar, cj.b bVar) {
        if (bzVar.k()) {
            return;
        }
        c++;
        if (!(bzVar instanceof ca) && bzVar.t()) {
            int i2 = i + 1;
            if (a(i2, bzVar)) {
                ca.a(i2, bzVar, bVar, new cj.a(), cj.a.a);
            }
        }
        by a2 = bzVar.a(by.a.TOP);
        by a3 = bzVar.a(by.a.BOTTOM);
        int d = a2.d();
        int d2 = a3.d();
        if (a2.a() != null && a2.f()) {
            Iterator<by> it = a2.a().iterator();
            while (it.hasNext()) {
                by next = it.next();
                bz bzVar2 = next.a;
                int i3 = i + 1;
                boolean a4 = a(i3, bzVar2);
                if (bzVar2.t() && a4) {
                    ca.a(i3, bzVar2, bVar, new cj.a(), cj.a.a);
                }
                if (bzVar2.Y() != bz.a.MATCH_CONSTRAINT || a4) {
                    if (!bzVar2.t()) {
                        if (next == bzVar2.A && bzVar2.C.c == null) {
                            int j = bzVar2.A.j() + d;
                            bzVar2.b(j, bzVar2.G() + j);
                            a(i3, bzVar2, bVar);
                        } else if (next == bzVar2.C && bzVar2.C.c == null) {
                            int j2 = d - bzVar2.C.j();
                            bzVar2.b(j2 - bzVar2.G(), j2);
                            a(i3, bzVar2, bVar);
                        } else if (next == bzVar2.A && bzVar2.C.c != null && bzVar2.C.c.f()) {
                            a(i3, bVar, bzVar2);
                        }
                    }
                } else if (bzVar2.Y() == bz.a.MATCH_CONSTRAINT && bzVar2.t >= 0 && bzVar2.s >= 0 && (bzVar2.B() == 8 || (bzVar2.n == 0 && bzVar2.S() == 0.0f))) {
                    if (!bzVar2.aa() && !bzVar2.p()) {
                        if (((next == bzVar2.A && bzVar2.C.c != null && bzVar2.C.c.f()) || (next == bzVar2.C && bzVar2.A.c != null && bzVar2.A.c.f())) && !bzVar2.aa()) {
                            a(i3, bzVar, bVar, bzVar2);
                        }
                    }
                }
            }
        }
        if (bzVar instanceof cc) {
            return;
        }
        if (a3.a() != null && a3.f()) {
            Iterator<by> it2 = a3.a().iterator();
            while (it2.hasNext()) {
                by next2 = it2.next();
                bz bzVar3 = next2.a;
                int i4 = i + 1;
                boolean a5 = a(i4, bzVar3);
                if (bzVar3.t() && a5) {
                    ca.a(i4, bzVar3, bVar, new cj.a(), cj.a.a);
                }
                boolean z = (next2 == bzVar3.A && bzVar3.C.c != null && bzVar3.C.c.f()) || (next2 == bzVar3.C && bzVar3.A.c != null && bzVar3.A.c.f());
                if (bzVar3.Y() != bz.a.MATCH_CONSTRAINT || a5) {
                    if (!bzVar3.t()) {
                        if (next2 == bzVar3.A && bzVar3.C.c == null) {
                            int j3 = bzVar3.A.j() + d2;
                            bzVar3.b(j3, bzVar3.G() + j3);
                            a(i4, bzVar3, bVar);
                        } else if (next2 == bzVar3.C && bzVar3.A.c == null) {
                            int j4 = d2 - bzVar3.C.j();
                            bzVar3.b(j4 - bzVar3.G(), j4);
                            a(i4, bzVar3, bVar);
                        } else if (z && !bzVar3.aa()) {
                            a(i4, bVar, bzVar3);
                        }
                    }
                } else if (bzVar3.Y() == bz.a.MATCH_CONSTRAINT && bzVar3.t >= 0 && bzVar3.s >= 0 && (bzVar3.B() == 8 || (bzVar3.n == 0 && bzVar3.S() == 0.0f))) {
                    if (!bzVar3.aa() && !bzVar3.p() && z && !bzVar3.aa()) {
                        a(i4, bzVar, bVar, bzVar3);
                    }
                }
            }
        }
        by a6 = bzVar.a(by.a.BASELINE);
        if (a6.a() != null && a6.f()) {
            int d3 = a6.d();
            Iterator<by> it3 = a6.a().iterator();
            while (it3.hasNext()) {
                by next3 = it3.next();
                bz bzVar4 = next3.a;
                int i5 = i + 1;
                boolean a7 = a(i5, bzVar4);
                if (bzVar4.t() && a7) {
                    ca.a(i5, bzVar4, bVar, new cj.a(), cj.a.a);
                }
                if (bzVar4.Y() != bz.a.MATCH_CONSTRAINT || a7) {
                    if (!bzVar4.t() && next3 == bzVar4.D) {
                        bzVar4.f(next3.j() + d3);
                        a(i5, bzVar4, bVar);
                    }
                }
            }
        }
        bzVar.m();
    }

    private static void a(int i, cj.b bVar, bz bzVar, boolean z) {
        float N = bzVar.N();
        int d = bzVar.z.c.d();
        int d2 = bzVar.B.c.d();
        int j = bzVar.z.j() + d;
        int j2 = d2 - bzVar.B.j();
        if (d == d2) {
            N = 0.5f;
        } else {
            d = j;
            d2 = j2;
        }
        int F = bzVar.F();
        int i2 = (d2 - d) - F;
        if (d > d2) {
            i2 = (d - d2) - F;
        }
        int i3 = (i2 > 0 ? (int) ((N * i2) + 0.5f) : (int) (N * i2)) + d;
        int i4 = i3 + F;
        if (d > d2) {
            i4 = i3 - F;
        }
        bzVar.a(i3, i4);
        a(i + 1, bzVar, bVar, z);
    }

    private static void a(int i, cj.b bVar, bz bzVar) {
        float O = bzVar.O();
        int d = bzVar.A.c.d();
        int d2 = bzVar.C.c.d();
        int j = bzVar.A.j() + d;
        int j2 = d2 - bzVar.C.j();
        if (d == d2) {
            O = 0.5f;
        } else {
            d = j;
            d2 = j2;
        }
        int G = bzVar.G();
        int i2 = (d2 - d) - G;
        if (d > d2) {
            i2 = (d - d2) - G;
        }
        int i3 = i2 > 0 ? (int) ((O * i2) + 0.5f) : (int) (O * i2);
        int i4 = d + i3;
        int i5 = i4 + G;
        if (d > d2) {
            i4 = d - i3;
            i5 = i4 - G;
        }
        bzVar.b(i4, i5);
        a(i + 1, bzVar, bVar);
    }

    private static void a(int i, bz bzVar, cj.b bVar, bz bzVar2, boolean z) {
        int F;
        float N = bzVar2.N();
        int d = bzVar2.z.c.d() + bzVar2.z.j();
        int d2 = bzVar2.B.c.d() - bzVar2.B.j();
        if (d2 >= d) {
            int F2 = bzVar2.F();
            if (bzVar2.B() != 8) {
                if (bzVar2.m == 2) {
                    if (bzVar instanceof ca) {
                        F = bzVar.F();
                    } else {
                        F = bzVar.A().F();
                    }
                    F2 = (int) (bzVar2.N() * 0.5f * F);
                } else if (bzVar2.m == 0) {
                    F2 = d2 - d;
                }
                F2 = Math.max(bzVar2.p, F2);
                if (bzVar2.q > 0) {
                    F2 = Math.min(bzVar2.q, F2);
                }
            }
            int i2 = d + ((int) ((N * ((d2 - d) - F2)) + 0.5f));
            bzVar2.a(i2, F2 + i2);
            a(i + 1, bzVar2, bVar, z);
        }
    }

    private static void a(int i, bz bzVar, cj.b bVar, bz bzVar2) {
        int G;
        float O = bzVar2.O();
        int d = bzVar2.A.c.d() + bzVar2.A.j();
        int d2 = bzVar2.C.c.d() - bzVar2.C.j();
        if (d2 >= d) {
            int G2 = bzVar2.G();
            if (bzVar2.B() != 8) {
                if (bzVar2.n == 2) {
                    if (bzVar instanceof ca) {
                        G = bzVar.G();
                    } else {
                        G = bzVar.A().G();
                    }
                    G2 = (int) (O * 0.5f * G);
                } else if (bzVar2.n == 0) {
                    G2 = d2 - d;
                }
                G2 = Math.max(bzVar2.s, G2);
                if (bzVar2.t > 0) {
                    G2 = Math.min(bzVar2.t, G2);
                }
            }
            int i2 = d + ((int) ((O * ((d2 - d) - G2)) + 0.5f));
            bzVar2.b(i2, G2 + i2);
            a(i + 1, bzVar2, bVar);
        }
    }

    private static boolean a(int i, bz bzVar) {
        bz.a X = bzVar.X();
        bz.a Y = bzVar.Y();
        ca caVar = bzVar.A() != null ? (ca) bzVar.A() : null;
        if (caVar != null) {
            caVar.X();
            bz.a aVar = bz.a.FIXED;
        }
        if (caVar != null) {
            caVar.Y();
            bz.a aVar2 = bz.a.FIXED;
        }
        boolean z = X == bz.a.FIXED || bzVar.d() || X == bz.a.WRAP_CONTENT || (X == bz.a.MATCH_CONSTRAINT && bzVar.m == 0 && bzVar.N == 0.0f && bzVar.g(0)) || (X == bz.a.MATCH_CONSTRAINT && bzVar.m == 1 && bzVar.c(0, bzVar.F()));
        boolean z2 = Y == bz.a.FIXED || bzVar.e() || Y == bz.a.WRAP_CONTENT || (Y == bz.a.MATCH_CONSTRAINT && bzVar.n == 0 && bzVar.N == 0.0f && bzVar.g(1)) || (X == bz.a.MATCH_CONSTRAINT && bzVar.n == 1 && bzVar.c(1, bzVar.G()));
        if (bzVar.N <= 0.0f || !(z || z2)) {
            return z && z2;
        }
        return true;
    }
}
