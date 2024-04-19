package defpackage;

import androidx.recyclerview.widget.j;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.ahk;
import java.lang.reflect.Array;
/* renamed from: ahl  reason: default package */
/* loaded from: classes.dex */
public abstract class ahl extends ahk {
    static final boolean t;
    static Class u;
    private final int[][] A;
    private final int[] B;
    private int C;
    final ahi m;
    final b n;
    final a o;
    final a p;
    final int q;
    int r;
    int s;
    private final ahr v;
    private int w;
    private int x;
    private final int y;
    private final int[][] z;

    /* renamed from: ahl$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ahl$a */
    /* loaded from: classes.dex */
    public class a extends ahk.a {
        private final int[] e;
        private final int[][] f;
        private final ahl g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ahl ahlVar, int i, int i2) {
            super(ahlVar);
            this.g = ahlVar;
            int i3 = 1 << i;
            this.e = new int[i3];
            this.f = (int[][]) Array.newInstance(int.class, i3, Math.max((i2 - 2) + 1, 16));
        }

        private void a(int i) {
            int a = ahr.a(this.a[0], 0);
            int i2 = 0;
            while (i2 < 8) {
                this.f[i][i2] = ahr.b(this.b[i], i2) + a;
                i2++;
            }
            int a2 = ahr.a(this.a[0], 1);
            int a3 = ahr.a(this.a[1], 0);
            while (i2 < 16) {
                this.f[i][i2] = a2 + a3 + ahr.b(this.c[i], i2 - 8);
                i2++;
            }
            int a4 = ahr.a(this.a[1], 1);
            while (true) {
                int[][] iArr = this.f;
                if (i2 >= iArr[i].length) {
                    return;
                }
                iArr[i][i2] = a2 + a4 + ahr.b(this.d, (i2 - 8) - 8);
                i2++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // defpackage.ahk.a
        public void a() {
            super.a();
            int i = 0;
            while (true) {
                int[] iArr = this.e;
                if (i >= iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }

        void a(int i, int i2) {
            ahr a;
            short[] sArr;
            int i3 = i - 2;
            if (i3 < 8) {
                ahl.a(this.g).a(this.a, 0, 0);
                a = ahl.a(this.g);
                sArr = this.b[i2];
            } else {
                ahl.a(this.g).a(this.a, 0, 1);
                i3 -= 8;
                if (i3 >= 8) {
                    ahl.a(this.g).a(this.a, 1, 1);
                    ahl.a(this.g).a(this.d, i3 - 8);
                    int[] iArr = this.e;
                    iArr[i2] = iArr[i2] - 1;
                }
                ahl.a(this.g).a(this.a, 1, 0);
                a = ahl.a(this.g);
                sArr = this.c[i2];
            }
            a.a(sArr, i3);
            int[] iArr2 = this.e;
            iArr2[i2] = iArr2[i2] - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int i, int i2) {
            return this.f[i2][i - 2];
        }

        void b() {
            int i = 0;
            while (true) {
                int[] iArr = this.e;
                if (i >= iArr.length) {
                    return;
                }
                if (iArr[i] <= 0) {
                    iArr[i] = 32;
                    a(i);
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ahl$b */
    /* loaded from: classes.dex */
    public class b extends ahk.b {
        static final boolean b;
        a[] a;
        private final ahl c;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ahl$b$a */
        /* loaded from: classes.dex */
        public class a extends ahk.b.a {
            private final b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private a(b bVar) {
                super(bVar);
                this.b = bVar;
            }

            a(b bVar, AnonymousClass1 anonymousClass1) {
                this(bVar);
            }

            int a(int i) {
                int i2 = i | IRadioController.TEF663x_PCHANNEL;
                int i3 = 0;
                do {
                    i3 += ahr.a(this.a[i2 >>> 8], (i2 >>> 7) & 1);
                    i2 <<= 1;
                } while (i2 < 65536);
                return i3;
            }

            int a(int i, int i2) {
                int i3 = IRadioController.TEF663x_PCHANNEL;
                int i4 = i | IRadioController.TEF663x_PCHANNEL;
                int i5 = 0;
                do {
                    i2 <<= 1;
                    i5 += ahr.a(this.a[(i2 & i3) + i3 + (i4 >>> 8)], (i4 >>> 7) & 1);
                    i4 <<= 1;
                    i3 &= ~(i2 ^ i4);
                } while (i4 < 65536);
                return i5;
            }

            void b() {
                int c = b.a(this.b).m.c(b.a(this.b).s);
                int i = IRadioController.TEF663x_PCHANNEL;
                int i2 = c | IRadioController.TEF663x_PCHANNEL;
                if (b.a(this.b).c.g()) {
                    do {
                        ahl.a(b.a(this.b)).a(this.a, i2 >>> 8, (i2 >>> 7) & 1);
                        i2 <<= 1;
                    } while (i2 < 65536);
                } else {
                    int c2 = b.a(this.b).m.c(b.a(this.b).b[0] + 1 + b.a(this.b).s);
                    do {
                        c2 <<= 1;
                        ahl.a(b.a(this.b)).a(this.a, (c2 & i) + i + (i2 >>> 8), (i2 >>> 7) & 1);
                        i2 <<= 1;
                        i &= ~(c2 ^ i2);
                    } while (i2 < 65536);
                }
                b.a(this.b).c.c();
            }
        }

        static {
            Class cls;
            if (ahl.u == null) {
                cls = ahl.a("ahl");
                ahl.u = cls;
            } else {
                cls = ahl.u;
            }
            b = !cls.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ahl ahlVar, int i, int i2) {
            super(ahlVar, i, i2);
            this.c = ahlVar;
            this.a = new a[1 << (i + i2)];
            int i3 = 0;
            while (true) {
                a[] aVarArr = this.a;
                if (i3 >= aVarArr.length) {
                    return;
                }
                aVarArr[i3] = new a(this, null);
                i3++;
            }
        }

        static ahl a(b bVar) {
            return bVar.c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int i, int i2, int i3, int i4, ahp ahpVar) {
            int a2 = ahr.a(this.c.d[ahpVar.b()][this.c.a & i4], 0);
            int a3 = a(i3, i4);
            return a2 + (ahpVar.g() ? this.a[a3].a(i) : this.a[a3].a(i, i2));
        }

        void a() {
            int i = 0;
            while (true) {
                a[] aVarArr = this.a;
                if (i >= aVarArr.length) {
                    return;
                }
                aVarArr[i].a();
                i++;
            }
        }

        void b() {
            if (!b && this.c.s < 0) {
                throw new AssertionError();
            }
            this.a[0].b();
        }

        void c() {
            if (!b && this.c.s < 0) {
                throw new AssertionError();
            }
            this.a[a(this.c.m.c(this.c.s + 1), this.c.m.f() - this.c.s)].b();
        }
    }

    static {
        Class cls = u;
        if (cls == null) {
            cls = a("ahl");
            u = cls;
        }
        t = !cls.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahl(ahr ahrVar, ahi ahiVar, int i, int i2, int i3, int i4, int i5) {
        super(i3);
        this.w = 0;
        this.x = 0;
        this.A = (int[][]) Array.newInstance(int.class, 4, 128);
        this.B = new int[16];
        this.r = 0;
        this.s = -1;
        this.C = 0;
        this.v = ahrVar;
        this.m = ahiVar;
        this.q = i5;
        this.n = new b(this, i, i2);
        this.o = new a(this, i3, i5);
        this.p = new a(this, i3, i5);
        this.y = b(i4 - 1) + 1;
        this.z = (int[][]) Array.newInstance(int.class, 4, this.y);
        a();
    }

    public static ahl a(ahr ahrVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        switch (i4) {
            case 1:
                return new ahm(ahrVar, i, i2, i3, i5, i6, i7, i8, i9);
            case 2:
                return new ahn(ahrVar, i, i2, i3, i5, i6, i7, i8, i9);
            default:
                throw new IllegalArgumentException();
        }
    }

    static ahr a(ahl ahlVar) {
        return ahlVar.v;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void a(int i, int i2, int i3) {
        this.c.d();
        this.o.a(i2, i3);
        int b2 = b(i);
        this.v.a(this.j[a(i2)], b2);
        if (b2 >= 4) {
            int i4 = (b2 >>> 1) - 1;
            int i5 = i - (((b2 & 1) | 2) << i4);
            if (b2 < 14) {
                this.v.c(this.k[b2 - 4], i5);
            } else {
                this.v.b(i5 >>> 4, i4 - 4);
                this.v.c(this.l, i5 & 15);
                this.x--;
            }
        }
        this.b[3] = this.b[2];
        this.b[2] = this.b[1];
        this.b[1] = this.b[0];
        this.b[0] = i;
        this.w--;
    }

    public static int b(int i) {
        int i2;
        int i3;
        if (i <= 4) {
            return i;
        }
        if (((-65536) & i) == 0) {
            i3 = i << 16;
            i2 = 15;
        } else {
            i2 = 31;
            i3 = i;
        }
        if (((-16777216) & i3) == 0) {
            i3 <<= 8;
            i2 -= 8;
        }
        if (((-268435456) & i3) == 0) {
            i3 <<= 4;
            i2 -= 4;
        }
        if (((-1073741824) & i3) == 0) {
            i3 <<= 2;
            i2 -= 2;
        }
        if ((i3 & j.UNDEFINED_DURATION) == 0) {
            i2--;
        }
        return (i2 << 1) + ((i >>> (i2 - 1)) & 1);
    }

    private void b(int i, int i2, int i3) {
        if (i == 0) {
            this.v.a(this.f, this.c.b(), 0);
            this.v.a(this.i[this.c.b()], i3, i2 != 1 ? 1 : 0);
        } else {
            int i4 = this.b[i];
            this.v.a(this.f, this.c.b(), 1);
            if (i == 1) {
                this.v.a(this.g, this.c.b(), 0);
            } else {
                this.v.a(this.g, this.c.b(), 1);
                this.v.a(this.h, this.c.b(), i - 2);
                if (i == 3) {
                    this.b[3] = this.b[2];
                }
                this.b[2] = this.b[1];
            }
            this.b[1] = this.b[0];
            this.b[0] = i4;
        }
        if (i2 == 1) {
            this.c.f();
            return;
        }
        this.p.a(i2, i3);
        this.c.e();
    }

    private boolean i() {
        if (t || this.s == -1) {
            if (this.m.b(0)) {
                c(1);
                this.v.a(this.d[this.c.b()], 0, 0);
                this.n.b();
                this.s--;
                if (t || this.s == -1) {
                    this.C++;
                    if (t || this.C == 1) {
                        return true;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            return false;
        }
        throw new AssertionError();
    }

    private boolean j() {
        if (this.m.b(this.s + 1)) {
            int b2 = b();
            if (t || this.s >= 0) {
                int f = (this.m.f() - this.s) & this.a;
                if (this.r != -1) {
                    this.v.a(this.d[this.c.b()], f, 1);
                    int i = this.r;
                    if (i < 4) {
                        if (!t && this.m.a(-this.s, this.b[this.r], b2) != b2) {
                            throw new AssertionError();
                        }
                        this.v.a(this.e, this.c.b(), 1);
                        b(this.r, b2, f);
                    } else if (!t && this.m.a(-this.s, i - 4, b2) != b2) {
                        throw new AssertionError();
                    } else {
                        this.v.a(this.e, this.c.b(), 0);
                        a(this.r - 4, b2, f);
                    }
                } else if (!t && b2 != 1) {
                    throw new AssertionError();
                } else {
                    this.v.a(this.d[this.c.b()], f, 0);
                    this.n.c();
                }
                this.s -= b2;
                this.C += b2;
                return true;
            }
            throw new AssertionError();
        }
        return false;
    }

    private void k() {
        this.w = 128;
        int i = 0;
        while (true) {
            if (i >= 4) {
                break;
            }
            for (int i2 = 0; i2 < this.y; i2++) {
                this.z[i][i2] = ahr.b(this.j[i], i2);
            }
            for (int i3 = 14; i3 < this.y; i3++) {
                int[] iArr = this.z[i];
                iArr[i3] = iArr[i3] + ahr.a(((i3 >>> 1) - 1) - 4);
            }
            for (int i4 = 0; i4 < 4; i4++) {
                this.A[i][i4] = this.z[i][i4];
            }
            i++;
        }
        int i5 = 4;
        int i6 = 4;
        while (i5 < 14) {
            int i7 = ((i5 & 1) | 2) << ((i5 >>> 1) - 1);
            int i8 = i5 - 4;
            int length = this.k[i8].length;
            int i9 = i6;
            for (int i10 = 0; i10 < length; i10++) {
                int d = ahr.d(this.k[i8], i9 - i7);
                for (int i11 = 0; i11 < 4; i11++) {
                    this.A[i11][i9] = this.z[i11][i5] + d;
                }
                i9++;
            }
            i5++;
            i6 = i9;
        }
        if (!t && i6 != 128) {
            throw new AssertionError();
        }
    }

    private void l() {
        this.x = 16;
        for (int i = 0; i < 16; i++) {
            this.B[i] = ahr.d(this.l, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, int i3, int i4) {
        int b2 = i + this.o.b(i3, i4);
        int a2 = a(i3);
        if (i2 < 128) {
            return b2 + this.A[a2][i2];
        }
        return b2 + this.z[a2][b(i2)] + this.B[i2 & 15];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, ahp ahpVar, int i3) {
        int a2;
        if (i2 == 0) {
            a2 = ahr.a(this.f[ahpVar.b()], 0) + ahr.a(this.i[ahpVar.b()][i3], 1);
        } else {
            i += ahr.a(this.f[ahpVar.b()], 1);
            if (i2 != 1) {
                return i + ahr.a(this.g[ahpVar.b()], 1) + ahr.a(this.h[ahpVar.b()], i2 - 2);
            }
            a2 = ahr.a(this.g[ahpVar.b()], 0);
        }
        return i + a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, ahp ahpVar) {
        return i + ahr.a(this.e[ahpVar.b()], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, ahp ahpVar, int i2) {
        return i + ahr.a(this.f[ahpVar.b()], 0) + ahr.a(this.i[ahpVar.b()][i2], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ahp ahpVar, int i) {
        return ahr.a(this.d[ahpVar.b()][i], 1);
    }

    @Override // defpackage.ahk
    public void a() {
        super.a();
        this.n.a();
        this.o.a();
        this.p.a();
        this.w = 0;
        this.x = 0;
        this.C += this.s + 1;
        this.s = -1;
    }

    abstract int b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, int i2, ahp ahpVar, int i3) {
        return a(b(a(ahpVar, i3), ahpVar), i, ahpVar, i3) + this.p.b(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, ahp ahpVar) {
        return i + ahr.a(this.e[ahpVar.b()], 1);
    }

    public ahi c() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.s += i;
        this.m.a(i);
    }

    public int d() {
        return this.C;
    }

    public void e() {
        this.C = 0;
    }

    public boolean f() {
        if (this.m.b() || i()) {
            while (this.C <= 2096879 && this.v.b() <= 65510) {
                if (!j()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahj g() {
        this.s++;
        ahj a2 = this.m.a();
        if (t || this.m.a(a2)) {
            return a2;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.w <= 0) {
            k();
        }
        if (this.x <= 0) {
            l();
        }
        this.o.b();
        this.p.b();
    }
}
