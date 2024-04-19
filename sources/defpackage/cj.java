package defpackage;

import defpackage.bz;
import java.util.ArrayList;
/* compiled from: BasicMeasure.java */
/* renamed from: cj  reason: default package */
/* loaded from: classes.dex */
public class cj {
    private final ArrayList<bz> a = new ArrayList<>();
    private a b = new a();
    private ca c;

    /* compiled from: BasicMeasure.java */
    /* renamed from: cj$a */
    /* loaded from: classes.dex */
    public static class a {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
        public bz.a d;
        public bz.a e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: cj$b */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(bz bzVar, a aVar);
    }

    public void a(ca caVar) {
        this.a.clear();
        int size = caVar.aT.size();
        for (int i = 0; i < size; i++) {
            bz bzVar = caVar.aT.get(i);
            if (bzVar.X() == bz.a.MATCH_CONSTRAINT || bzVar.Y() == bz.a.MATCH_CONSTRAINT) {
                this.a.add(bzVar);
            }
        }
        caVar.b();
    }

    public cj(ca caVar) {
        this.c = caVar;
    }

    private void b(ca caVar) {
        int size = caVar.aT.size();
        boolean b2 = caVar.b(64);
        b g = caVar.g();
        for (int i = 0; i < size; i++) {
            bz bzVar = caVar.aT.get(i);
            if (!(bzVar instanceof cc) && !(bzVar instanceof bv) && !bzVar.p() && (!b2 || bzVar.f == null || bzVar.g == null || !bzVar.f.g.j || !bzVar.g.g.j)) {
                bz.a x = bzVar.x(0);
                bz.a x2 = bzVar.x(1);
                boolean z = x == bz.a.MATCH_CONSTRAINT && bzVar.m != 1 && x2 == bz.a.MATCH_CONSTRAINT && bzVar.n != 1;
                if (!z && caVar.b(1) && !(bzVar instanceof cg)) {
                    if (x == bz.a.MATCH_CONSTRAINT && bzVar.m == 0 && x2 != bz.a.MATCH_CONSTRAINT && !bzVar.Z()) {
                        z = true;
                    }
                    if (x2 == bz.a.MATCH_CONSTRAINT && bzVar.n == 0 && x != bz.a.MATCH_CONSTRAINT && !bzVar.Z()) {
                        z = true;
                    }
                    if ((x == bz.a.MATCH_CONSTRAINT || x2 == bz.a.MATCH_CONSTRAINT) && bzVar.N > 0.0f) {
                        z = true;
                    }
                }
                if (!z) {
                    a(g, bzVar, a.a);
                    if (caVar.az != null) {
                        caVar.az.a++;
                    }
                }
            }
        }
        g.a();
    }

    private void a(ca caVar, String str, int i, int i2, int i3) {
        int H = caVar.H();
        int I = caVar.I();
        caVar.s(0);
        caVar.t(0);
        caVar.q(i2);
        caVar.r(i3);
        caVar.s(H);
        caVar.t(I);
        this.c.A(i);
        this.c.ae();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
        r2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(defpackage.ca r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cj.a(ca, int, int, int, int, int, int, int, int, int):long");
    }

    private boolean a(b bVar, bz bzVar, int i) {
        this.b.d = bzVar.X();
        this.b.e = bzVar.Y();
        this.b.f = bzVar.F();
        this.b.g = bzVar.G();
        a aVar = this.b;
        aVar.l = false;
        aVar.m = i;
        boolean z = aVar.d == bz.a.MATCH_CONSTRAINT;
        boolean z2 = this.b.e == bz.a.MATCH_CONSTRAINT;
        boolean z3 = z && bzVar.N > 0.0f;
        boolean z4 = z2 && bzVar.N > 0.0f;
        if (z3 && bzVar.o[0] == 4) {
            this.b.d = bz.a.FIXED;
        }
        if (z4 && bzVar.o[1] == 4) {
            this.b.e = bz.a.FIXED;
        }
        bVar.a(bzVar, this.b);
        bzVar.q(this.b.h);
        bzVar.r(this.b.i);
        bzVar.c(this.b.k);
        bzVar.u(this.b.j);
        this.b.m = a.a;
        return this.b.l;
    }
}
