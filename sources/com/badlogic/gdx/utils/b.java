package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.v;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<v.b<K, V>> {
    public K[] a;
    public V[] b;
    public int c;
    public boolean d;
    private a e;
    private a f;

    public b() {
        this(true, 16);
    }

    public b(boolean z, int i) {
        this.d = z;
        this.a = (K[]) new Object[i];
        this.b = (V[]) new Object[i];
    }

    public b(boolean z, int i, Class cls, Class cls2) {
        this.d = z;
        this.a = (K[]) ((Object[]) qt.a(cls, i));
        this.b = (V[]) ((Object[]) qt.a(cls2, i));
    }

    public b(Class cls, Class cls2) {
        this(false, 16, cls, cls2);
    }

    public int a(K k, V v) {
        int c = c(k);
        if (c == -1) {
            int i = this.c;
            if (i == this.a.length) {
                b(Math.max(8, (int) (i * 1.75f)));
            }
            c = this.c;
            this.c = c + 1;
        }
        this.a[c] = k;
        this.b[c] = v;
        return c;
    }

    public void a(b<? extends K, ? extends V> bVar) {
        a(bVar, 0, bVar.c);
    }

    public void a(b<? extends K, ? extends V> bVar, int i, int i2) {
        if (i + i2 > bVar.c) {
            throw new IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + bVar.c);
        }
        int i3 = (this.c + i2) - i;
        if (i3 >= this.a.length) {
            b(Math.max(8, (int) (i3 * 1.75f)));
        }
        System.arraycopy(bVar.a, i, this.a, this.c, i2);
        System.arraycopy(bVar.b, i, this.b, this.c, i2);
        this.c += i2;
    }

    public V a(K k) {
        K[] kArr = this.a;
        int i = this.c - 1;
        if (k == null) {
            while (i >= 0) {
                if (kArr[i] == k) {
                    return this.b[i];
                }
                i--;
            }
            return null;
        }
        while (i >= 0) {
            if (k.equals(kArr[i])) {
                return this.b[i];
            }
            i--;
        }
        return null;
    }

    public boolean b(K k) {
        K[] kArr = this.a;
        int i = this.c - 1;
        if (k == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (kArr[i] == k) {
                    return true;
                }
                i = i2;
            }
            return false;
        }
        while (i >= 0) {
            int i3 = i - 1;
            if (k.equals(kArr[i])) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public int c(K k) {
        K[] kArr = this.a;
        int i = 0;
        if (k == null) {
            int i2 = this.c;
            while (i < i2) {
                if (kArr[i] == k) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.c;
        while (i < i3) {
            if (k.equals(kArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void a(int i) {
        int i2 = this.c;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        K[] kArr = this.a;
        this.c = i2 - 1;
        if (this.d) {
            int i3 = i + 1;
            System.arraycopy(kArr, i3, kArr, i, this.c - i);
            V[] vArr = this.b;
            System.arraycopy(vArr, i3, vArr, i, this.c - i);
        } else {
            int i4 = this.c;
            kArr[i] = kArr[i4];
            V[] vArr2 = this.b;
            vArr2[i] = vArr2[i4];
        }
        int i5 = this.c;
        kArr[i5] = null;
        this.b[i5] = null;
    }

    public void a() {
        K[] kArr = this.a;
        V[] vArr = this.b;
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            kArr[i2] = null;
            vArr[i2] = null;
        }
        this.c = 0;
    }

    protected void b(int i) {
        K[] kArr = (K[]) ((Object[]) qt.a(this.a.getClass().getComponentType(), i));
        System.arraycopy(this.a, 0, kArr, 0, Math.min(this.c, kArr.length));
        this.a = kArr;
        V[] vArr = (V[]) ((Object[]) qt.a(this.b.getClass().getComponentType(), i));
        System.arraycopy(this.b, 0, vArr, 0, Math.min(this.c, vArr.length));
        this.b = vArr;
    }

    public int hashCode() {
        K[] kArr = this.a;
        V[] vArr = this.b;
        int i = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            V v = vArr[i3];
            if (k != null) {
                i2 += k.hashCode() * 31;
            }
            if (v != null) {
                i2 += v.hashCode();
            }
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i = bVar.c;
            int i2 = this.c;
            if (i != i2) {
                return false;
            }
            K[] kArr = this.a;
            V[] vArr = this.b;
            for (int i3 = 0; i3 < i2; i3++) {
                K k = kArr[i3];
                V v = vArr[i3];
                if (v == null) {
                    if (!bVar.b((b) k) || bVar.a((b) k) != null) {
                        return false;
                    }
                } else if (!v.equals(bVar.a((b) k))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        if (this.c == 0) {
            return "{}";
        }
        K[] kArr = this.a;
        V[] vArr = this.b;
        al alVar = new al(32);
        alVar.append('{');
        alVar.a(kArr[0]);
        alVar.append('=');
        alVar.a(vArr[0]);
        for (int i = 1; i < this.c; i++) {
            alVar.c(", ");
            alVar.a(kArr[i]);
            alVar.append('=');
            alVar.a(vArr[i]);
        }
        alVar.append('}');
        return alVar.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<v.b<K, V>> iterator() {
        return b();
    }

    public a<K, V> b() {
        if (this.e == null) {
            this.e = new a(this);
            this.f = new a(this);
        }
        if (!this.e.c) {
            a<K, V> aVar = this.e;
            aVar.b = 0;
            aVar.c = true;
            this.f.c = false;
            return aVar;
        }
        a<K, V> aVar2 = this.f;
        aVar2.b = 0;
        aVar2.c = true;
        this.e.c = false;
        return aVar2;
    }

    /* compiled from: ArrayMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> implements Iterable<v.b<K, V>>, Iterator<v.b<K, V>> {
        int b;
        private final b<K, V> d;
        v.b<K, V> a = new v.b<>();
        boolean c = true;

        @Override // java.lang.Iterable
        public Iterator<v.b<K, V>> iterator() {
            return this;
        }

        public a(b<K, V> bVar) {
            this.d = bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return this.b < this.d.c;
            }
            throw new k("#iterator() cannot be used nested.");
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public v.b<K, V> next() {
            if (this.b >= this.d.c) {
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            if (!this.c) {
                throw new k("#iterator() cannot be used nested.");
            }
            this.a.a = this.d.a[this.b];
            v.b<K, V> bVar = this.a;
            V[] vArr = this.d.b;
            int i = this.b;
            this.b = i + 1;
            bVar.b = vArr[i];
            return this.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.b--;
            this.d.a(this.b);
        }
    }
}
