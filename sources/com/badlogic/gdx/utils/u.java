package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ObjectIntMap.java */
/* loaded from: classes.dex */
public class u<K> implements Iterable<b<K>> {
    public int a;
    K[] b;
    int[] c;
    int d;
    int e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private a l;
    private a m;

    public u() {
        this(51, 0.8f);
    }

    public u(int i, float f) {
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
        this.f = f;
        int i2 = this.d;
        this.i = (int) (i2 * f);
        this.h = i2 - 1;
        this.g = 31 - Integer.numberOfTrailingZeros(i2);
        this.j = Math.max(3, ((int) Math.ceil(Math.log(this.d))) * 2);
        this.k = Math.max(Math.min(this.d, 8), ((int) Math.sqrt(this.d)) / 8);
        this.b = (K[]) new Object[this.d + this.j];
        this.c = new int[this.b.length];
    }

    public void a(K k, int i) {
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] kArr = this.b;
        int hashCode = k.hashCode();
        int i2 = hashCode & this.h;
        K k2 = kArr[i2];
        if (k.equals(k2)) {
            this.c[i2] = i;
            return;
        }
        int c2 = c(hashCode);
        K k3 = kArr[c2];
        if (k.equals(k3)) {
            this.c[c2] = i;
            return;
        }
        int d = d(hashCode);
        K k4 = kArr[d];
        if (k.equals(k4)) {
            this.c[d] = i;
            return;
        }
        int i3 = this.d;
        int i4 = this.e + i3;
        while (i3 < i4) {
            if (k.equals(kArr[i3])) {
                this.c[i3] = i;
                return;
            }
            i3++;
        }
        if (k2 == null) {
            kArr[i2] = k;
            this.c[i2] = i;
            int i5 = this.a;
            this.a = i5 + 1;
            if (i5 >= this.i) {
                b(this.d << 1);
            }
        } else if (k3 == null) {
            kArr[c2] = k;
            this.c[c2] = i;
            int i6 = this.a;
            this.a = i6 + 1;
            if (i6 >= this.i) {
                b(this.d << 1);
            }
        } else if (k4 == null) {
            kArr[d] = k;
            this.c[d] = i;
            int i7 = this.a;
            this.a = i7 + 1;
            if (i7 >= this.i) {
                b(this.d << 1);
            }
        } else {
            a(k, i, i2, k2, c2, k3, d, k4);
        }
    }

    private void c(K k, int i) {
        int hashCode = k.hashCode();
        int i2 = hashCode & this.h;
        K[] kArr = this.b;
        K k2 = kArr[i2];
        if (k2 == null) {
            kArr[i2] = k;
            this.c[i2] = i;
            int i3 = this.a;
            this.a = i3 + 1;
            if (i3 >= this.i) {
                b(this.d << 1);
                return;
            }
            return;
        }
        int c2 = c(hashCode);
        K[] kArr2 = this.b;
        K k3 = kArr2[c2];
        if (k3 == null) {
            kArr2[c2] = k;
            this.c[c2] = i;
            int i4 = this.a;
            this.a = i4 + 1;
            if (i4 >= this.i) {
                b(this.d << 1);
                return;
            }
            return;
        }
        int d = d(hashCode);
        K[] kArr3 = this.b;
        K k4 = kArr3[d];
        if (k4 == null) {
            kArr3[d] = k;
            this.c[d] = i;
            int i5 = this.a;
            this.a = i5 + 1;
            if (i5 >= this.i) {
                b(this.d << 1);
                return;
            }
            return;
        }
        a(k, i, i2, k2, c2, k3, d, k4);
    }

    private void a(K k, int i, int i2, K k2, int i3, K k3, int i4, K k4) {
        K[] kArr = this.b;
        int[] iArr = this.c;
        int i5 = this.h;
        int i6 = this.k;
        int i7 = 0;
        while (true) {
            switch (com.badlogic.gdx.math.h.a(2)) {
                case 0:
                    int i8 = iArr[i2];
                    kArr[i2] = k;
                    iArr[i2] = i;
                    k = k2;
                    i = i8;
                    break;
                case 1:
                    int i9 = iArr[i3];
                    kArr[i3] = k;
                    iArr[i3] = i;
                    i = i9;
                    k = k3;
                    break;
                default:
                    int i10 = iArr[i4];
                    kArr[i4] = k;
                    iArr[i4] = i;
                    i = i10;
                    k = k4;
                    break;
            }
            int hashCode = k.hashCode();
            int i11 = hashCode & i5;
            K k5 = kArr[i11];
            if (k5 == null) {
                kArr[i11] = k;
                iArr[i11] = i;
                int i12 = this.a;
                this.a = i12 + 1;
                if (i12 >= this.i) {
                    b(this.d << 1);
                    return;
                }
                return;
            }
            int c2 = c(hashCode);
            K k6 = kArr[c2];
            if (k6 == null) {
                kArr[c2] = k;
                iArr[c2] = i;
                int i13 = this.a;
                this.a = i13 + 1;
                if (i13 >= this.i) {
                    b(this.d << 1);
                    return;
                }
                return;
            }
            int d = d(hashCode);
            k4 = kArr[d];
            if (k4 == null) {
                kArr[d] = k;
                iArr[d] = i;
                int i14 = this.a;
                this.a = i14 + 1;
                if (i14 >= this.i) {
                    b(this.d << 1);
                    return;
                }
                return;
            }
            i7++;
            if (i7 == i6) {
                d(k, i);
                return;
            }
            i4 = d;
            i2 = i11;
            k2 = k5;
            i3 = c2;
            k3 = k6;
        }
    }

    private void d(K k, int i) {
        int i2 = this.e;
        if (i2 == this.j) {
            b(this.d << 1);
            c(k, i);
            return;
        }
        int i3 = this.d + i2;
        this.b[i3] = k;
        this.c[i3] = i;
        this.e = i2 + 1;
        this.a++;
    }

    public int b(K k, int i) {
        int hashCode = k.hashCode();
        int i2 = this.h & hashCode;
        if (!k.equals(this.b[i2])) {
            i2 = c(hashCode);
            if (!k.equals(this.b[i2])) {
                i2 = d(hashCode);
                if (!k.equals(this.b[i2])) {
                    return e(k, i);
                }
            }
        }
        return this.c[i2];
    }

    private int e(K k, int i) {
        K[] kArr = this.b;
        int i2 = this.d;
        int i3 = this.e + i2;
        while (i2 < i3) {
            if (k.equals(kArr[i2])) {
                return this.c[i2];
            }
            i2++;
        }
        return i;
    }

    void a(int i) {
        this.e--;
        int i2 = this.d + this.e;
        if (i < i2) {
            K[] kArr = this.b;
            kArr[i] = kArr[i2];
            int[] iArr = this.c;
            iArr[i] = iArr[i2];
            kArr[i2] = null;
        }
    }

    public void a() {
        if (this.a == 0) {
            return;
        }
        K[] kArr = this.b;
        int i = this.d + this.e;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                i = i2;
            } else {
                this.a = 0;
                this.e = 0;
                return;
            }
        }
    }

    public boolean a(K k) {
        int hashCode = k.hashCode();
        if (k.equals(this.b[this.h & hashCode])) {
            return true;
        }
        if (k.equals(this.b[c(hashCode)])) {
            return true;
        }
        if (k.equals(this.b[d(hashCode)])) {
            return true;
        }
        return b((u<K>) k);
    }

    private boolean b(K k) {
        K[] kArr = this.b;
        int i = this.d;
        int i2 = this.e + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    private void b(int i) {
        int i2 = this.d + this.e;
        this.d = i;
        this.i = (int) (i * this.f);
        this.h = i - 1;
        this.g = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.j = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.k = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        K[] kArr = this.b;
        int[] iArr = this.c;
        int i3 = this.j;
        this.b = (K[]) new Object[i + i3];
        this.c = new int[i + i3];
        int i4 = this.a;
        this.a = 0;
        this.e = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    c(k, iArr[i5]);
                }
            }
        }
    }

    private int c(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.g)) & this.h;
    }

    private int d(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.g)) & this.h;
    }

    public int hashCode() {
        K[] kArr = this.b;
        int[] iArr = this.c;
        int i = this.d + this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            if (k != null) {
                i2 = i2 + (k.hashCode() * 31) + iArr[i3];
            }
        }
        return i2;
    }

    public boolean equals(Object obj) {
        int b2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (uVar.a != this.a) {
                return false;
            }
            K[] kArr = this.b;
            int[] iArr = this.c;
            int i = this.d + this.e;
            for (int i2 = 0; i2 < i; i2++) {
                K k = kArr[i2];
                if (k != null && (((b2 = uVar.b(k, 0)) == 0 && !uVar.a((u) k)) || b2 != iArr[i2])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        int i;
        if (this.a == 0) {
            return "{}";
        }
        al alVar = new al(32);
        alVar.append('{');
        K[] kArr = this.b;
        int[] iArr = this.c;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    alVar.a(k);
                    alVar.append('=');
                    alVar.b(iArr[i]);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                K k2 = kArr[i2];
                if (k2 != null) {
                    alVar.c(", ");
                    alVar.a(k2);
                    alVar.append('=');
                    alVar.b(iArr[i2]);
                }
                i = i2;
            } else {
                alVar.append('}');
                return alVar.toString();
            }
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: b */
    public a<K> iterator() {
        return c();
    }

    public a<K> c() {
        if (this.l == null) {
            this.l = new a(this);
            this.m = new a(this);
        }
        if (!this.l.e) {
            this.l.c();
            a<K> aVar = this.l;
            aVar.e = true;
            this.m.e = false;
            return aVar;
        }
        this.m.c();
        a<K> aVar2 = this.m;
        aVar2.e = true;
        this.l.e = false;
        return aVar2;
    }

    /* compiled from: ObjectIntMap.java */
    /* loaded from: classes.dex */
    public static class b<K> {
        public K a;
        public int b;

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ObjectIntMap.java */
    /* loaded from: classes.dex */
    public static class c<K> {
        public boolean a;
        final u<K> b;
        int c;
        int d;
        boolean e = true;

        public c(u<K> uVar) {
            this.b = uVar;
            c();
        }

        public void c() {
            this.d = -1;
            this.c = -1;
            d();
        }

        void d() {
            this.a = false;
            K[] kArr = this.b.b;
            int i = this.b.d + this.b.e;
            do {
                int i2 = this.c + 1;
                this.c = i2;
                if (i2 >= i) {
                    return;
                }
            } while (kArr[this.c] == null);
            this.a = true;
        }

        public void remove() {
            int i = this.d;
            if (i < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            if (i >= this.b.d) {
                this.b.a(this.d);
                this.c = this.d - 1;
                d();
            } else {
                this.b.b[this.d] = null;
            }
            this.d = -1;
            u<K> uVar = this.b;
            uVar.a--;
        }
    }

    /* compiled from: ObjectIntMap.java */
    /* loaded from: classes.dex */
    public static class a<K> extends c<K> implements Iterable<b<K>>, Iterator<b<K>> {
        private b<K> f;

        @Override // java.lang.Iterable
        /* renamed from: b */
        public a<K> iterator() {
            return this;
        }

        @Override // com.badlogic.gdx.utils.u.c
        public /* bridge */ /* synthetic */ void c() {
            super.c();
        }

        public a(u<K> uVar) {
            super(uVar);
            this.f = new b<>();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public b<K> next() {
            if (!this.a) {
                throw new NoSuchElementException();
            }
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            K[] kArr = this.b.b;
            this.f.a = kArr[this.c];
            this.f.b = this.b.c[this.c];
            this.d = this.c;
            d();
            return this.f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            return this.a;
        }

        @Override // com.badlogic.gdx.utils.u.c, java.util.Iterator
        public void remove() {
            super.remove();
        }
    }
}
