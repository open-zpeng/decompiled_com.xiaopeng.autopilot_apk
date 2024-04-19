package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: IntIntMap.java */
/* loaded from: classes.dex */
public class n implements Iterable<b> {
    public int a;
    int[] b;
    int[] c;
    int d;
    int e;
    int f;
    boolean g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private a n;
    private a o;

    public n() {
        this(51, 0.8f);
    }

    public n(int i) {
        this(i, 0.8f);
    }

    public n(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        int b2 = com.badlogic.gdx.math.h.b((int) Math.ceil(i / f));
        if (b2 > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + b2);
        }
        this.d = b2;
        if (f <= 0.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.h = f;
        int i2 = this.d;
        this.k = (int) (i2 * f);
        this.j = i2 - 1;
        this.i = 31 - Integer.numberOfTrailingZeros(i2);
        this.l = Math.max(3, ((int) Math.ceil(Math.log(this.d))) * 2);
        this.m = Math.max(Math.min(this.d, 8), ((int) Math.sqrt(this.d)) / 8);
        this.b = new int[this.d + this.l];
        this.c = new int[this.b.length];
    }

    public void a(int i, int i2) {
        if (i == 0) {
            this.f = i2;
            if (this.g) {
                return;
            }
            this.g = true;
            this.a++;
            return;
        }
        int[] iArr = this.b;
        int i3 = i & this.j;
        int i4 = iArr[i3];
        if (i == i4) {
            this.c[i3] = i2;
            return;
        }
        int f = f(i);
        int i5 = iArr[f];
        if (i == i5) {
            this.c[f] = i2;
            return;
        }
        int g = g(i);
        int i6 = iArr[g];
        if (i == i6) {
            this.c[g] = i2;
            return;
        }
        int i7 = this.d;
        int i8 = this.e + i7;
        while (i7 < i8) {
            if (i == iArr[i7]) {
                this.c[i7] = i2;
                return;
            }
            i7++;
        }
        if (i4 == 0) {
            iArr[i3] = i;
            this.c[i3] = i2;
            int i9 = this.a;
            this.a = i9 + 1;
            if (i9 >= this.k) {
                e(this.d << 1);
            }
        } else if (i5 == 0) {
            iArr[f] = i;
            this.c[f] = i2;
            int i10 = this.a;
            this.a = i10 + 1;
            if (i10 >= this.k) {
                e(this.d << 1);
            }
        } else if (i6 == 0) {
            iArr[g] = i;
            this.c[g] = i2;
            int i11 = this.a;
            this.a = i11 + 1;
            if (i11 >= this.k) {
                e(this.d << 1);
            }
        } else {
            a(i, i2, i3, i4, f, i5, g, i6);
        }
    }

    private void c(int i, int i2) {
        if (i == 0) {
            this.f = i2;
            this.g = true;
            return;
        }
        int i3 = i & this.j;
        int[] iArr = this.b;
        int i4 = iArr[i3];
        if (i4 == 0) {
            iArr[i3] = i;
            this.c[i3] = i2;
            int i5 = this.a;
            this.a = i5 + 1;
            if (i5 >= this.k) {
                e(this.d << 1);
                return;
            }
            return;
        }
        int f = f(i);
        int[] iArr2 = this.b;
        int i6 = iArr2[f];
        if (i6 == 0) {
            iArr2[f] = i;
            this.c[f] = i2;
            int i7 = this.a;
            this.a = i7 + 1;
            if (i7 >= this.k) {
                e(this.d << 1);
                return;
            }
            return;
        }
        int g = g(i);
        int[] iArr3 = this.b;
        int i8 = iArr3[g];
        if (i8 == 0) {
            iArr3[g] = i;
            this.c[g] = i2;
            int i9 = this.a;
            this.a = i9 + 1;
            if (i9 >= this.k) {
                e(this.d << 1);
                return;
            }
            return;
        }
        a(i, i2, i3, i4, f, i6, g, i8);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.b;
        int[] iArr2 = this.c;
        int i9 = this.j;
        int i10 = this.m;
        int i11 = 0;
        do {
            switch (com.badlogic.gdx.math.h.a(2)) {
                case 0:
                    int i12 = iArr2[i3];
                    iArr[i3] = i;
                    iArr2[i3] = i2;
                    i = i4;
                    i2 = i12;
                    break;
                case 1:
                    int i13 = iArr2[i5];
                    iArr[i5] = i;
                    iArr2[i5] = i2;
                    i2 = i13;
                    i = i6;
                    break;
                default:
                    int i14 = iArr2[i7];
                    iArr[i7] = i;
                    iArr2[i7] = i2;
                    i2 = i14;
                    i = i8;
                    break;
            }
            i3 = i & i9;
            i4 = iArr[i3];
            if (i4 == 0) {
                iArr[i3] = i;
                iArr2[i3] = i2;
                int i15 = this.a;
                this.a = i15 + 1;
                if (i15 >= this.k) {
                    e(this.d << 1);
                    return;
                }
                return;
            }
            i5 = f(i);
            i6 = iArr[i5];
            if (i6 == 0) {
                iArr[i5] = i;
                iArr2[i5] = i2;
                int i16 = this.a;
                this.a = i16 + 1;
                if (i16 >= this.k) {
                    e(this.d << 1);
                    return;
                }
                return;
            }
            i7 = g(i);
            i8 = iArr[i7];
            if (i8 == 0) {
                iArr[i7] = i;
                iArr2[i7] = i2;
                int i17 = this.a;
                this.a = i17 + 1;
                if (i17 >= this.k) {
                    e(this.d << 1);
                    return;
                }
                return;
            }
            i11++;
        } while (i11 != i10);
        d(i, i2);
    }

    private void d(int i, int i2) {
        int i3 = this.e;
        if (i3 == this.l) {
            e(this.d << 1);
            c(i, i2);
            return;
        }
        int i4 = this.d + i3;
        this.b[i4] = i;
        this.c[i4] = i2;
        this.e = i3 + 1;
        this.a++;
    }

    public int b(int i, int i2) {
        if (i == 0) {
            return !this.g ? i2 : this.f;
        }
        int i3 = this.j & i;
        if (this.b[i3] != i) {
            i3 = f(i);
            if (this.b[i3] != i) {
                i3 = g(i);
                if (this.b[i3] != i) {
                    return e(i, i2);
                }
            }
        }
        return this.c[i3];
    }

    private int e(int i, int i2) {
        int[] iArr = this.b;
        int i3 = this.d;
        int i4 = this.e + i3;
        while (i3 < i4) {
            if (i == iArr[i3]) {
                return this.c[i3];
            }
            i3++;
        }
        return i2;
    }

    void a(int i) {
        this.e--;
        int i2 = this.d + this.e;
        if (i < i2) {
            int[] iArr = this.b;
            iArr[i] = iArr[i2];
            int[] iArr2 = this.c;
            iArr2[i] = iArr2[i2];
        }
    }

    public void a() {
        if (this.a == 0) {
            return;
        }
        int[] iArr = this.b;
        int i = this.d + this.e;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                iArr[i2] = 0;
                i = i2;
            } else {
                this.a = 0;
                this.e = 0;
                this.g = false;
                return;
            }
        }
    }

    public boolean b(int i) {
        if (i == 0) {
            return this.g;
        }
        if (this.b[this.j & i] != i) {
            if (this.b[f(i)] != i) {
                if (this.b[g(i)] != i) {
                    return d(i);
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean d(int i) {
        int[] iArr = this.b;
        int i2 = this.d;
        int i3 = this.e + i2;
        while (i2 < i3) {
            if (i == iArr[i2]) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public void c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.a + i;
        if (i2 >= this.k) {
            e(com.badlogic.gdx.math.h.b((int) Math.ceil(i2 / this.h)));
        }
    }

    private void e(int i) {
        int i2 = this.d + this.e;
        this.d = i;
        this.k = (int) (i * this.h);
        this.j = i - 1;
        this.i = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.l = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.m = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        int[] iArr = this.b;
        int[] iArr2 = this.c;
        int i3 = this.l;
        this.b = new int[i + i3];
        this.c = new int[i + i3];
        int i4 = this.a;
        this.a = this.g ? 1 : 0;
        this.e = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = iArr[i5];
                if (i6 != 0) {
                    c(i6, iArr2[i5]);
                }
            }
        }
    }

    private int f(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.i)) & this.j;
    }

    private int g(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.i)) & this.j;
    }

    public int hashCode() {
        int floatToIntBits = this.g ? Float.floatToIntBits(this.f) + 0 : 0;
        int[] iArr = this.b;
        int[] iArr2 = this.c;
        int i = this.d + this.e;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                floatToIntBits = floatToIntBits + (i3 * 31) + iArr2[i2];
            }
        }
        return floatToIntBits;
    }

    public boolean equals(Object obj) {
        int b2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (nVar.a != this.a) {
                return false;
            }
            boolean z = nVar.g;
            boolean z2 = this.g;
            if (z != z2) {
                return false;
            }
            if (!z2 || nVar.f == this.f) {
                int[] iArr = this.b;
                int[] iArr2 = this.c;
                int i = this.d + this.e;
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = iArr[i2];
                    if (i3 != 0 && (((b2 = nVar.b(i3, 0)) == 0 && !nVar.b(i3)) || b2 != iArr2[i2])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:16:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r7 = this;
            int r0 = r7.a
            if (r0 != 0) goto L7
            java.lang.String r0 = "{}"
            return r0
        L7:
            com.badlogic.gdx.utils.al r0 = new com.badlogic.gdx.utils.al
            r1 = 32
            r0.<init>(r1)
            r1 = 123(0x7b, float:1.72E-43)
            r0.append(r1)
            int[] r1 = r7.b
            int[] r2 = r7.c
            int r3 = r1.length
            boolean r4 = r7.g
            r5 = 61
            if (r4 == 0) goto L29
            java.lang.String r4 = "0="
            r0.c(r4)
            int r4 = r7.f
            r0.b(r4)
            goto L3f
        L29:
            int r4 = r3 + (-1)
            if (r3 <= 0) goto L3e
            r3 = r1[r4]
            if (r3 != 0) goto L33
            r3 = r4
            goto L29
        L33:
            r0.b(r3)
            r0.append(r5)
            r3 = r2[r4]
            r0.b(r3)
        L3e:
            r3 = r4
        L3f:
            int r4 = r3 + (-1)
            if (r3 <= 0) goto L59
            r3 = r1[r4]
            if (r3 != 0) goto L48
            goto L3e
        L48:
            java.lang.String r6 = ", "
            r0.c(r6)
            r0.b(r3)
            r0.append(r5)
            r3 = r2[r4]
            r0.b(r3)
            goto L3e
        L59:
            r1 = 125(0x7d, float:1.75E-43)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.n.toString():java.lang.String");
    }

    @Override // java.lang.Iterable
    public Iterator<b> iterator() {
        return b();
    }

    public a b() {
        if (this.n == null) {
            this.n = new a(this);
            this.o = new a(this);
        }
        if (!this.n.e) {
            this.n.b();
            a aVar = this.n;
            aVar.e = true;
            this.o.e = false;
            return aVar;
        }
        this.o.b();
        a aVar2 = this.o;
        aVar2.e = true;
        this.n.e = false;
        return aVar2;
    }

    /* compiled from: IntIntMap.java */
    /* loaded from: classes.dex */
    public static class b {
        public int a;
        public int b;

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntIntMap.java */
    /* loaded from: classes.dex */
    public static class c {
        public boolean a;
        final n b;
        int c;
        int d;
        boolean e = true;

        public c(n nVar) {
            this.b = nVar;
            b();
        }

        public void b() {
            this.d = -2;
            this.c = -1;
            if (this.b.g) {
                this.a = true;
            } else {
                c();
            }
        }

        void c() {
            this.a = false;
            int[] iArr = this.b.b;
            int i = this.b.d + this.b.e;
            do {
                int i2 = this.c + 1;
                this.c = i2;
                if (i2 >= i) {
                    return;
                }
            } while (iArr[this.c] == 0);
            this.a = true;
        }

        public void remove() {
            if (this.d == -1 && this.b.g) {
                this.b.g = false;
            } else {
                int i = this.d;
                if (i < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                if (i >= this.b.d) {
                    this.b.a(this.d);
                    this.c = this.d - 1;
                    c();
                } else {
                    this.b.b[this.d] = 0;
                }
            }
            this.d = -2;
            n nVar = this.b;
            nVar.a--;
        }
    }

    /* compiled from: IntIntMap.java */
    /* loaded from: classes.dex */
    public static class a extends c implements Iterable<b>, Iterator<b> {
        private b f;

        @Override // java.lang.Iterable
        public Iterator<b> iterator() {
            return this;
        }

        @Override // com.badlogic.gdx.utils.n.c
        public /* bridge */ /* synthetic */ void b() {
            super.b();
        }

        public a(n nVar) {
            super(nVar);
            this.f = new b();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public b next() {
            if (!this.a) {
                throw new NoSuchElementException();
            }
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            int[] iArr = this.b.b;
            if (this.c == -1) {
                b bVar = this.f;
                bVar.a = 0;
                bVar.b = this.b.f;
            } else {
                this.f.a = iArr[this.c];
                this.f.b = this.b.c[this.c];
            }
            this.d = this.c;
            c();
            return this.f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            return this.a;
        }

        @Override // com.badlogic.gdx.utils.n.c, java.util.Iterator
        public void remove() {
            super.remove();
        }
    }
}
