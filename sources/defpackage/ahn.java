package defpackage;

import com.google.protobuf.CodedOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ahn  reason: default package */
/* loaded from: classes.dex */
public final class ahn extends ahl {
    static final boolean v;
    static Class w;
    private static int x;
    private static int y;
    private int A;
    private int B;
    private ahj C;
    private final int[] D;
    private final ahp E;
    private final aho[] z;

    static {
        Class cls = w;
        if (cls == null) {
            cls = b("ahn");
            w = cls;
        }
        v = !cls.desiredAssertionStatus();
        x = CodedOutputStream.DEFAULT_BUFFER_SIZE;
        y = CodedOutputStream.DEFAULT_BUFFER_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahn(ahr ahrVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(ahrVar, ahi.a(i4, Math.max(i5, x), y, i6, 273, i7, i8), i, i2, i3, i4, i6);
        this.z = new aho[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        this.A = 0;
        this.B = 0;
        this.D = new int[4];
        this.E = new ahp();
        for (int i9 = 0; i9 < 4096; i9++) {
            this.z[i9] = new aho();
        }
    }

    private void a(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5;
        if (this.C.a[this.C.c - 1] > i3) {
            this.C.c = 0;
            while (this.C.a[this.C.c] < i3) {
                this.C.c++;
            }
            int[] iArr = this.C.a;
            ahj ahjVar = this.C;
            int i7 = ahjVar.c;
            ahjVar.c = i7 + 1;
            iArr[i7] = i3;
        }
        if (this.C.a[this.C.c - 1] < i6) {
            return;
        }
        while (this.B < this.A + this.C.a[this.C.c - 1]) {
            aho[] ahoVarArr = this.z;
            int i8 = this.B + 1;
            this.B = i8;
            ahoVarArr[i8].a();
        }
        int a = a(i4, this.z[this.A].a);
        int i9 = 0;
        while (i6 > this.C.a[i9]) {
            i9++;
        }
        while (true) {
            int i10 = this.C.b[i9];
            int a2 = a(a, i10, i6, i2);
            if (a2 < this.z[this.A + i6].c) {
                aho[] ahoVarArr2 = this.z;
                int i11 = this.A;
                ahoVarArr2[i11 + i6].a(a2, i11, i10 + 4);
            }
            if (i6 == this.C.a[i9]) {
                int a3 = this.m.a(i6 + 1, i10, Math.min(this.q, (i3 - i6) - 1));
                if (a3 >= 2) {
                    this.E.a(this.z[this.A].a);
                    this.E.d();
                    int i12 = i + i6;
                    int a4 = a2 + this.n.a(this.m.a(i6, 0), this.m.c(0), this.m.a(i6, 1), i12, this.E);
                    this.E.c();
                    int b = a4 + b(0, a3, this.E, (i12 + 1) & this.a);
                    int i13 = this.A + i6 + 1 + a3;
                    while (true) {
                        int i14 = this.B;
                        if (i14 >= i13) {
                            break;
                        }
                        aho[] ahoVarArr3 = this.z;
                        int i15 = i14 + 1;
                        this.B = i15;
                        ahoVarArr3[i15].a();
                    }
                    if (b < this.z[i13].c) {
                        this.z[i13].a(b, this.A, i10 + 4, i6, 0);
                    }
                }
                i9++;
                if (i9 == this.C.c) {
                    return;
                }
            }
            i6++;
        }
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        boolean z;
        int a;
        int c = this.m.c(0);
        int c2 = this.m.c(this.z[this.A].b[0] + 1);
        int a2 = this.z[this.A].c + this.n.a(c, c2, this.m.c(1), i, this.z[this.A].a);
        if (a2 < this.z[this.A + 1].c) {
            aho[] ahoVarArr = this.z;
            int i5 = this.A;
            ahoVarArr[i5 + 1].a(a2, i5, -1);
            z = true;
        } else {
            z = false;
        }
        if (c2 == c) {
            int i6 = this.z[this.A + 1].d;
            int i7 = this.A;
            if ((i6 == i7 || this.z[i7 + 1].e != 0) && (a = a(i4, this.z[this.A].a, i2)) <= this.z[this.A + 1].c) {
                aho[] ahoVarArr2 = this.z;
                int i8 = this.A;
                ahoVarArr2[i8 + 1].a(a, i8, 0);
                z = true;
            }
        }
        if (z || c2 == c || i3 <= 2) {
            return;
        }
        int a3 = this.m.a(1, this.z[this.A].b[0], Math.min(this.q, i3 - 1));
        if (a3 >= 2) {
            this.E.a(this.z[this.A].a);
            this.E.c();
            int b = a2 + b(0, a3, this.E, (i + 1) & this.a);
            int i9 = this.A + 1 + a3;
            while (true) {
                int i10 = this.B;
                if (i10 >= i9) {
                    break;
                }
                aho[] ahoVarArr3 = this.z;
                int i11 = i10 + 1;
                this.B = i11;
                ahoVarArr3[i11].a();
            }
            if (b < this.z[i9].c) {
                this.z[i9].b(b, this.A, 0);
            }
        }
    }

    private int c(int i, int i2, int i3, int i4) {
        int i5;
        int min = Math.min(i3, this.q);
        int i6 = 2;
        for (int i7 = 0; i7 < 4; i7++) {
            int b = this.m.b(this.z[this.A].b[i7], min);
            if (b >= 2) {
                while (true) {
                    int i8 = this.B;
                    i5 = this.A;
                    if (i8 >= i5 + b) {
                        break;
                    }
                    aho[] ahoVarArr = this.z;
                    int i9 = i8 + 1;
                    this.B = i9;
                    ahoVarArr[i9].a();
                }
                int a = a(i4, i7, this.z[i5].a, i2);
                for (int i10 = b; i10 >= 2; i10--) {
                    int b2 = this.p.b(i10, i2) + a;
                    if (b2 < this.z[this.A + i10].c) {
                        aho[] ahoVarArr2 = this.z;
                        int i11 = this.A;
                        ahoVarArr2[i11 + i10].a(b2, i11, i7);
                    }
                }
                if (i7 == 0) {
                    i6 = b + 1;
                }
                int i12 = i6;
                int a2 = this.m.a(b + 1, this.z[this.A].b[i7], Math.min(this.q, (i3 - b) - 1));
                if (a2 >= 2) {
                    int b3 = a + this.p.b(b, i2);
                    this.E.a(this.z[this.A].a);
                    this.E.e();
                    int i13 = i + b;
                    int a3 = b3 + this.n.a(this.m.a(b, 0), this.m.c(0), this.m.a(b, 1), i13, this.E);
                    this.E.c();
                    int b4 = a3 + b(0, a2, this.E, (i13 + 1) & this.a);
                    int i14 = this.A + b + 1 + a2;
                    while (true) {
                        int i15 = this.B;
                        if (i15 >= i14) {
                            break;
                        }
                        aho[] ahoVarArr3 = this.z;
                        int i16 = i15 + 1;
                        this.B = i16;
                        ahoVarArr3[i16].a();
                    }
                    if (b4 < this.z[i14].c) {
                        this.z[i14].a(b4, this.A, i7, b, 0);
                    }
                }
                i6 = i12;
            }
        }
        return i6;
    }

    private int i() {
        int i = this.A;
        this.B = i;
        int i2 = this.z[i].d;
        while (true) {
            aho ahoVar = this.z[this.A];
            if (ahoVar.f) {
                aho[] ahoVarArr = this.z;
                ahoVarArr[i2].d = this.A;
                ahoVarArr[i2].e = -1;
                int i3 = i2 - 1;
                this.A = i2;
                if (ahoVar.g) {
                    aho[] ahoVarArr2 = this.z;
                    ahoVarArr2[i3].d = i3 + 1;
                    ahoVarArr2[i3].e = ahoVar.i;
                    this.A = i3;
                    i2 = ahoVar.h;
                } else {
                    i2 = i3;
                }
            }
            int i4 = this.z[i2].d;
            aho[] ahoVarArr3 = this.z;
            ahoVarArr3[i2].d = this.A;
            this.A = i2;
            if (this.A <= 0) {
                this.A = ahoVarArr3[0].d;
                this.r = this.z[this.A].e;
                return this.A;
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ahn.j():void");
    }

    @Override // defpackage.ahl, defpackage.ahk
    public void a() {
        this.A = 0;
        this.B = 0;
        super.a();
    }

    @Override // defpackage.ahl
    int b() {
        int i;
        int a;
        int i2 = this.A;
        int i3 = this.B;
        if (i2 < i3) {
            int i4 = this.z[i2].d;
            int i5 = this.A;
            int i6 = i4 - i5;
            this.A = this.z[i5].d;
            this.r = this.z[this.A].e;
            return i6;
        } else if (v || i2 == i3) {
            this.A = 0;
            this.B = 0;
            this.r = -1;
            if (this.s == -1) {
                this.C = g();
            }
            int min = Math.min(this.m.e(), 273);
            if (min < 2) {
                return 1;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < 4; i8++) {
                this.D[i8] = this.m.b(this.b[i8], min);
                int[] iArr = this.D;
                if (iArr[i8] < 2) {
                    iArr[i8] = 0;
                } else if (iArr[i8] > iArr[i7]) {
                    i7 = i8;
                }
            }
            if (this.D[i7] >= this.q) {
                this.r = i7;
                c(this.D[i7] - 1);
                return this.D[i7];
            }
            if (this.C.c > 0) {
                i = this.C.a[this.C.c - 1];
                int i9 = this.C.b[this.C.c - 1];
                if (i >= this.q) {
                    this.r = i9 + 4;
                    c(i - 1);
                    return i;
                }
            } else {
                i = 0;
            }
            int c = this.m.c(0);
            int c2 = this.m.c(this.b[0] + 1);
            if (i >= 2 || c == c2 || this.D[i7] >= 2) {
                int f = this.m.f();
                int i10 = f & this.a;
                this.z[1].a(this.n.a(c, c2, this.m.c(1), f, this.c), 0, -1);
                int a2 = a(this.c, i10);
                int b = b(a2, this.c);
                if (c2 == c && (a = a(b, this.c, i10)) < this.z[1].c) {
                    this.z[1].a(a, 0, 0);
                }
                this.B = Math.max(i, this.D[i7]);
                int i11 = this.B;
                if (i11 < 2) {
                    if (v || i11 == 0) {
                        this.r = this.z[1].e;
                        return 1;
                    }
                    throw new AssertionError(i11);
                }
                h();
                this.z[0].a.a(this.c);
                System.arraycopy(this.b, 0, this.z[0].b, 0, 4);
                for (int i12 = this.B; i12 >= 2; i12--) {
                    this.z[i12].a();
                }
                for (int i13 = 0; i13 < 4; i13++) {
                    int i14 = this.D[i13];
                    if (i14 >= 2) {
                        int a3 = a(b, i13, this.c, i10);
                        do {
                            int b2 = this.p.b(i14, i10) + a3;
                            if (b2 < this.z[i14].c) {
                                this.z[i14].a(b2, 0, i13);
                            }
                            i14--;
                        } while (i14 >= 2);
                    }
                }
                int max = Math.max(this.D[0] + 1, 2);
                if (max <= i) {
                    int a4 = a(a2, this.c);
                    int i15 = 0;
                    while (max > this.C.a[i15]) {
                        i15++;
                    }
                    while (true) {
                        int i16 = this.C.b[i15];
                        int a5 = a(a4, i16, max, i10);
                        if (a5 < this.z[max].c) {
                            this.z[max].a(a5, 0, i16 + 4);
                        }
                        if (max == this.C.a[i15] && (i15 = i15 + 1) == this.C.c) {
                            break;
                        }
                        max++;
                    }
                }
                int min2 = Math.min(this.m.e(), 4095);
                while (true) {
                    int i17 = this.A + 1;
                    this.A = i17;
                    if (i17 >= this.B) {
                        break;
                    }
                    this.C = g();
                    if (this.C.c > 0 && this.C.a[this.C.c - 1] >= this.q) {
                        break;
                    }
                    int i18 = min2 - 1;
                    int i19 = f + 1;
                    int i20 = i19 & this.a;
                    j();
                    int a6 = this.z[this.A].c + a(this.z[this.A].a, i20);
                    int b3 = b(a6, this.z[this.A].a);
                    b(i19, i20, i18, b3);
                    if (i18 >= 2) {
                        int c3 = c(i19, i20, i18, b3);
                        if (this.C.c > 0) {
                            a(i19, i20, i18, a6, c3);
                        }
                    }
                    min2 = i18;
                    f = i19;
                }
                return i();
            }
            return 1;
        } else {
            throw new AssertionError();
        }
    }
}
