package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ObjectMap.java */
/* loaded from: classes.dex */
public class v<K, V> implements Iterable<b<K, V>> {
    public int a;
    K[] b;
    V[] c;
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
    private e n;
    private e o;
    private c p;
    private c q;

    public v() {
        this(51, 0.8f);
    }

    public v(int i) {
        this(i, 0.8f);
    }

    public v(int i, float f) {
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
        this.c = (V[]) new Object[this.b.length];
    }

    public V a(K k, V v) {
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] kArr = this.b;
        int hashCode = k.hashCode();
        int i = hashCode & this.h;
        K k2 = kArr[i];
        if (k.equals(k2)) {
            V[] vArr = this.c;
            V v2 = vArr[i];
            vArr[i] = v;
            return v2;
        }
        int c2 = c(hashCode);
        K k3 = kArr[c2];
        if (k.equals(k3)) {
            V[] vArr2 = this.c;
            V v3 = vArr2[c2];
            vArr2[c2] = v;
            return v3;
        }
        int d2 = d(hashCode);
        K k4 = kArr[d2];
        if (k.equals(k4)) {
            V[] vArr3 = this.c;
            V v4 = vArr3[d2];
            vArr3[d2] = v;
            return v4;
        }
        int i2 = this.d;
        int i3 = this.e + i2;
        while (i2 < i3) {
            if (k.equals(kArr[i2])) {
                V[] vArr4 = this.c;
                V v5 = vArr4[i2];
                vArr4[i2] = v;
                return v5;
            }
            i2++;
        }
        if (k2 == null) {
            kArr[i] = k;
            this.c[i] = v;
            int i4 = this.a;
            this.a = i4 + 1;
            if (i4 >= this.i) {
                b(this.d << 1);
            }
            return null;
        } else if (k3 == null) {
            kArr[c2] = k;
            this.c[c2] = v;
            int i5 = this.a;
            this.a = i5 + 1;
            if (i5 >= this.i) {
                b(this.d << 1);
            }
            return null;
        } else if (k4 == null) {
            kArr[d2] = k;
            this.c[d2] = v;
            int i6 = this.a;
            this.a = i6 + 1;
            if (i6 >= this.i) {
                b(this.d << 1);
            }
            return null;
        } else {
            a(k, v, i, k2, c2, k3, d2, k4);
            return null;
        }
    }

    private void c(K k, V v) {
        int hashCode = k.hashCode();
        int i = hashCode & this.h;
        K[] kArr = this.b;
        K k2 = kArr[i];
        if (k2 == null) {
            kArr[i] = k;
            this.c[i] = v;
            int i2 = this.a;
            this.a = i2 + 1;
            if (i2 >= this.i) {
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
            this.c[c2] = v;
            int i3 = this.a;
            this.a = i3 + 1;
            if (i3 >= this.i) {
                b(this.d << 1);
                return;
            }
            return;
        }
        int d2 = d(hashCode);
        K[] kArr3 = this.b;
        K k4 = kArr3[d2];
        if (k4 == null) {
            kArr3[d2] = k;
            this.c[d2] = v;
            int i4 = this.a;
            this.a = i4 + 1;
            if (i4 >= this.i) {
                b(this.d << 1);
                return;
            }
            return;
        }
        a(k, v, i, k2, c2, k3, d2, k4);
    }

    private void a(K k, V v, int i, K k2, int i2, K k3, int i3, K k4) {
        K[] kArr = this.b;
        V[] vArr = this.c;
        int i4 = this.h;
        int i5 = this.k;
        int i6 = 0;
        while (true) {
            switch (com.badlogic.gdx.math.h.a(2)) {
                case 0:
                    V v2 = vArr[i];
                    kArr[i] = k;
                    vArr[i] = v;
                    k = k2;
                    v = v2;
                    break;
                case 1:
                    V v3 = vArr[i2];
                    kArr[i2] = k;
                    vArr[i2] = v;
                    v = v3;
                    k = k3;
                    break;
                default:
                    V v4 = vArr[i3];
                    kArr[i3] = k;
                    vArr[i3] = v;
                    v = v4;
                    k = k4;
                    break;
            }
            int hashCode = k.hashCode();
            int i7 = hashCode & i4;
            K k5 = kArr[i7];
            if (k5 == null) {
                kArr[i7] = k;
                vArr[i7] = v;
                int i8 = this.a;
                this.a = i8 + 1;
                if (i8 >= this.i) {
                    b(this.d << 1);
                    return;
                }
                return;
            }
            int c2 = c(hashCode);
            K k6 = kArr[c2];
            if (k6 == null) {
                kArr[c2] = k;
                vArr[c2] = v;
                int i9 = this.a;
                this.a = i9 + 1;
                if (i9 >= this.i) {
                    b(this.d << 1);
                    return;
                }
                return;
            }
            int d2 = d(hashCode);
            k4 = kArr[d2];
            if (k4 == null) {
                kArr[d2] = k;
                vArr[d2] = v;
                int i10 = this.a;
                this.a = i10 + 1;
                if (i10 >= this.i) {
                    b(this.d << 1);
                    return;
                }
                return;
            }
            i6++;
            if (i6 == i5) {
                d(k, v);
                return;
            }
            i3 = d2;
            i = i7;
            k2 = k5;
            i2 = c2;
            k3 = k6;
        }
    }

    private void d(K k, V v) {
        int i = this.e;
        if (i == this.j) {
            b(this.d << 1);
            c(k, v);
            return;
        }
        int i2 = this.d + i;
        this.b[i2] = k;
        this.c[i2] = v;
        this.e = i + 1;
        this.a++;
    }

    public V a(K k) {
        int hashCode = k.hashCode();
        int i = this.h & hashCode;
        if (!k.equals(this.b[i])) {
            i = c(hashCode);
            if (!k.equals(this.b[i])) {
                i = d(hashCode);
                if (!k.equals(this.b[i])) {
                    return e(k, null);
                }
            }
        }
        return this.c[i];
    }

    public V b(K k, V v) {
        int hashCode = k.hashCode();
        int i = this.h & hashCode;
        if (!k.equals(this.b[i])) {
            i = c(hashCode);
            if (!k.equals(this.b[i])) {
                i = d(hashCode);
                if (!k.equals(this.b[i])) {
                    return e(k, v);
                }
            }
        }
        return this.c[i];
    }

    private V e(K k, V v) {
        K[] kArr = this.b;
        int i = this.d;
        int i2 = this.e + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.c[i];
            }
            i++;
        }
        return v;
    }

    public V b(K k) {
        int hashCode = k.hashCode();
        int i = this.h & hashCode;
        if (k.equals(this.b[i])) {
            this.b[i] = null;
            V[] vArr = this.c;
            V v = vArr[i];
            vArr[i] = null;
            this.a--;
            return v;
        }
        int c2 = c(hashCode);
        if (k.equals(this.b[c2])) {
            this.b[c2] = null;
            V[] vArr2 = this.c;
            V v2 = vArr2[c2];
            vArr2[c2] = null;
            this.a--;
            return v2;
        }
        int d2 = d(hashCode);
        if (k.equals(this.b[d2])) {
            this.b[d2] = null;
            V[] vArr3 = this.c;
            V v3 = vArr3[d2];
            vArr3[d2] = null;
            this.a--;
            return v3;
        }
        return c((v<K, V>) k);
    }

    V c(K k) {
        K[] kArr = this.b;
        int i = this.d;
        int i2 = this.e + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                V v = this.c[i];
                a(i);
                this.a--;
                return v;
            }
            i++;
        }
        return null;
    }

    void a(int i) {
        this.e--;
        int i2 = this.d + this.e;
        if (i < i2) {
            K[] kArr = this.b;
            kArr[i] = kArr[i2];
            V[] vArr = this.c;
            vArr[i] = vArr[i2];
            kArr[i2] = null;
            vArr[i2] = null;
            return;
        }
        this.b[i] = null;
        this.c[i] = null;
    }

    public void a() {
        if (this.a == 0) {
            return;
        }
        K[] kArr = this.b;
        V[] vArr = this.c;
        int i = this.d + this.e;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                vArr[i2] = null;
                i = i2;
            } else {
                this.a = 0;
                this.e = 0;
                return;
            }
        }
    }

    public boolean d(K k) {
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
        return e(k);
    }

    private boolean e(K k) {
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
        double d2 = i;
        this.j = Math.max(3, ((int) Math.ceil(Math.log(d2))) * 2);
        this.k = Math.max(Math.min(i, 8), ((int) Math.sqrt(d2)) / 8);
        K[] kArr = this.b;
        V[] vArr = this.c;
        int i3 = this.j;
        this.b = (K[]) new Object[i + i3];
        this.c = (V[]) new Object[i + i3];
        int i4 = this.a;
        this.a = 0;
        this.e = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    c(k, vArr[i5]);
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
        V[] vArr = this.c;
        int i = this.d + this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            if (k != null) {
                i2 += k.hashCode() * 31;
                V v = vArr[i3];
                if (v != null) {
                    i2 += v.hashCode();
                }
            }
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (vVar.a != this.a) {
                return false;
            }
            K[] kArr = this.b;
            V[] vArr = this.c;
            int i = this.d + this.e;
            for (int i2 = 0; i2 < i; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    V v = vArr[i2];
                    if (v == null) {
                        if (!vVar.d((v) k) || vVar.a((v) k) != null) {
                            return false;
                        }
                    } else if (!v.equals(vVar.a((v) k))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return a(", ", true);
    }

    private String a(String str, boolean z) {
        int i;
        if (this.a == 0) {
            return z ? "{}" : "";
        }
        al alVar = new al(32);
        if (z) {
            alVar.append('{');
        }
        K[] kArr = this.b;
        V[] vArr = this.c;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    alVar.a(k);
                    alVar.append('=');
                    alVar.a(vArr[i]);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            K k2 = kArr[i2];
            if (k2 != null) {
                alVar.c(str);
                alVar.a(k2);
                alVar.append('=');
                alVar.a(vArr[i2]);
            }
            i = i2;
        }
        if (z) {
            alVar.append('}');
        }
        return alVar.toString();
    }

    @Override // java.lang.Iterable
    /* renamed from: b */
    public a<K, V> iterator() {
        return c();
    }

    public a<K, V> c() {
        if (this.l == null) {
            this.l = new a(this);
            this.m = new a(this);
        }
        if (!this.l.f) {
            this.l.c();
            a<K, V> aVar = this.l;
            aVar.f = true;
            this.m.f = false;
            return aVar;
        }
        this.m.c();
        a<K, V> aVar2 = this.m;
        aVar2.f = true;
        this.l.f = false;
        return aVar2;
    }

    public e<V> d() {
        if (this.n == null) {
            this.n = new e(this);
            this.o = new e(this);
        }
        if (!this.n.f) {
            this.n.c();
            e<V> eVar = this.n;
            eVar.f = true;
            this.o.f = false;
            return eVar;
        }
        this.o.c();
        e<V> eVar2 = this.o;
        eVar2.f = true;
        this.n.f = false;
        return eVar2;
    }

    public c<K> e() {
        if (this.p == null) {
            this.p = new c(this);
            this.q = new c(this);
        }
        if (!this.p.f) {
            this.p.c();
            c<K> cVar = this.p;
            cVar.f = true;
            this.q.f = false;
            return cVar;
        }
        this.q.c();
        c<K> cVar2 = this.q;
        cVar2.f = true;
        this.p.f = false;
        return cVar2;
    }

    /* compiled from: ObjectMap.java */
    /* loaded from: classes.dex */
    public static class b<K, V> {
        public K a;
        public V b;

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ObjectMap.java */
    /* loaded from: classes.dex */
    public static abstract class d<K, V, I> implements Iterable<I>, Iterator<I> {
        public boolean b;
        final v<K, V> c;
        int d;
        int e;
        boolean f = true;

        public d(v<K, V> vVar) {
            this.c = vVar;
            c();
        }

        public void c() {
            this.e = -1;
            this.d = -1;
            d();
        }

        void d() {
            this.b = false;
            K[] kArr = this.c.b;
            int i = this.c.d + this.c.e;
            do {
                int i2 = this.d + 1;
                this.d = i2;
                if (i2 >= i) {
                    return;
                }
            } while (kArr[this.d] == null);
            this.b = true;
        }

        public void remove() {
            int i = this.e;
            if (i < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            if (i >= this.c.d) {
                this.c.a(this.e);
                this.d = this.e - 1;
                d();
            } else {
                this.c.b[this.e] = null;
                this.c.c[this.e] = null;
            }
            this.e = -1;
            v<K, V> vVar = this.c;
            vVar.a--;
        }
    }

    /* compiled from: ObjectMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends d<K, V, b<K, V>> {
        b<K, V> a;

        @Override // java.lang.Iterable
        /* renamed from: b */
        public a<K, V> iterator() {
            return this;
        }

        @Override // com.badlogic.gdx.utils.v.d
        public /* bridge */ /* synthetic */ void c() {
            super.c();
        }

        @Override // com.badlogic.gdx.utils.v.d, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        public a(v<K, V> vVar) {
            super(vVar);
            this.a = new b<>();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public b<K, V> next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            K[] kArr = this.c.b;
            this.a.a = kArr[this.d];
            this.a.b = this.c.c[this.d];
            this.e = this.d;
            d();
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            return this.b;
        }
    }

    /* compiled from: ObjectMap.java */
    /* loaded from: classes.dex */
    public static class e<V> extends d<Object, V, V> {
        @Override // java.lang.Iterable
        /* renamed from: a */
        public e<V> iterator() {
            return this;
        }

        @Override // com.badlogic.gdx.utils.v.d
        public /* bridge */ /* synthetic */ void c() {
            super.c();
        }

        @Override // com.badlogic.gdx.utils.v.d, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        public e(v<?, V> vVar) {
            super(vVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            return this.b;
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            V v = this.c.c[this.d];
            this.e = this.d;
            d();
            return v;
        }
    }

    /* compiled from: ObjectMap.java */
    /* loaded from: classes.dex */
    public static class c<K> extends d<K, Object, K> {
        @Override // java.lang.Iterable
        /* renamed from: a */
        public c<K> iterator() {
            return this;
        }

        @Override // com.badlogic.gdx.utils.v.d
        public /* bridge */ /* synthetic */ void c() {
            super.c();
        }

        @Override // com.badlogic.gdx.utils.v.d, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        public c(v<K, ?> vVar) {
            super(vVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            return this.b;
        }

        @Override // java.util.Iterator
        public K next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            K k = this.c.b[this.d];
            this.e = this.d;
            d();
            return k;
        }

        public com.badlogic.gdx.utils.a<K> b() {
            return a(new com.badlogic.gdx.utils.a<>(true, this.c.a));
        }

        public com.badlogic.gdx.utils.a<K> a(com.badlogic.gdx.utils.a<K> aVar) {
            while (this.b) {
                aVar.a((com.badlogic.gdx.utils.a<K>) next());
            }
            return aVar;
        }
    }
}
