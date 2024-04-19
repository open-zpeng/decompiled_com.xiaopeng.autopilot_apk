package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ObjectSet.java */
/* loaded from: classes.dex */
public class w<T> implements Iterable<T> {
    public int a;
    T[] b;
    int c;
    int d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private a k;
    private a l;

    public w() {
        this(51, 0.8f);
    }

    public w(int i) {
        this(i, 0.8f);
    }

    public w(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        int b = com.badlogic.gdx.math.h.b((int) Math.ceil(i / f));
        if (b > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + b);
        }
        this.c = b;
        if (f <= 0.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.e = f;
        int i2 = this.c;
        this.h = (int) (i2 * f);
        this.g = i2 - 1;
        this.f = 31 - Integer.numberOfTrailingZeros(i2);
        this.i = Math.max(3, ((int) Math.ceil(Math.log(this.c))) * 2);
        this.j = Math.max(Math.min(this.c, 8), ((int) Math.sqrt(this.c)) / 8);
        this.b = (T[]) new Object[this.c + this.i];
    }

    public boolean a(T t) {
        if (t == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        T[] tArr = this.b;
        int hashCode = t.hashCode();
        int i = hashCode & this.g;
        T t2 = tArr[i];
        if (t.equals(t2)) {
            return false;
        }
        int e = e(hashCode);
        T t3 = tArr[e];
        if (t.equals(t3)) {
            return false;
        }
        int f = f(hashCode);
        T t4 = tArr[f];
        if (t.equals(t4)) {
            return false;
        }
        int i2 = this.c;
        int i3 = this.d + i2;
        while (i2 < i3) {
            if (t.equals(tArr[i2])) {
                return false;
            }
            i2++;
        }
        if (t2 == null) {
            tArr[i] = t;
            int i4 = this.a;
            this.a = i4 + 1;
            if (i4 >= this.h) {
                d(this.c << 1);
            }
            return true;
        } else if (t3 == null) {
            tArr[e] = t;
            int i5 = this.a;
            this.a = i5 + 1;
            if (i5 >= this.h) {
                d(this.c << 1);
            }
            return true;
        } else if (t4 == null) {
            tArr[f] = t;
            int i6 = this.a;
            this.a = i6 + 1;
            if (i6 >= this.h) {
                d(this.c << 1);
            }
            return true;
        } else {
            a(t, i, t2, e, t3, f, t4);
            return true;
        }
    }

    public void a(w<T> wVar) {
        c(wVar.a);
        a<T> it = wVar.iterator();
        while (it.hasNext()) {
            a((w<T>) it.next());
        }
    }

    private void e(T t) {
        int hashCode = t.hashCode();
        int i = hashCode & this.g;
        T[] tArr = this.b;
        T t2 = tArr[i];
        if (t2 == null) {
            tArr[i] = t;
            int i2 = this.a;
            this.a = i2 + 1;
            if (i2 >= this.h) {
                d(this.c << 1);
                return;
            }
            return;
        }
        int e = e(hashCode);
        T[] tArr2 = this.b;
        T t3 = tArr2[e];
        if (t3 == null) {
            tArr2[e] = t;
            int i3 = this.a;
            this.a = i3 + 1;
            if (i3 >= this.h) {
                d(this.c << 1);
                return;
            }
            return;
        }
        int f = f(hashCode);
        T[] tArr3 = this.b;
        T t4 = tArr3[f];
        if (t4 == null) {
            tArr3[f] = t;
            int i4 = this.a;
            this.a = i4 + 1;
            if (i4 >= this.h) {
                d(this.c << 1);
                return;
            }
            return;
        }
        a(t, i, t2, e, t3, f, t4);
    }

    private void a(T t, int i, T t2, int i2, T t3, int i3, T t4) {
        T[] tArr = this.b;
        int i4 = this.g;
        int i5 = this.j;
        int i6 = 0;
        while (true) {
            switch (com.badlogic.gdx.math.h.a(2)) {
                case 0:
                    tArr[i] = t;
                    t = t2;
                    break;
                case 1:
                    tArr[i2] = t;
                    t = t3;
                    break;
                default:
                    tArr[i3] = t;
                    t = t4;
                    break;
            }
            int hashCode = t.hashCode();
            int i7 = hashCode & i4;
            T t5 = tArr[i7];
            if (t5 == null) {
                tArr[i7] = t;
                int i8 = this.a;
                this.a = i8 + 1;
                if (i8 >= this.h) {
                    d(this.c << 1);
                    return;
                }
                return;
            }
            int e = e(hashCode);
            T t6 = tArr[e];
            if (t6 == null) {
                tArr[e] = t;
                int i9 = this.a;
                this.a = i9 + 1;
                if (i9 >= this.h) {
                    d(this.c << 1);
                    return;
                }
                return;
            }
            int f = f(hashCode);
            t4 = tArr[f];
            if (t4 == null) {
                tArr[f] = t;
                int i10 = this.a;
                this.a = i10 + 1;
                if (i10 >= this.h) {
                    d(this.c << 1);
                    return;
                }
                return;
            }
            i6++;
            if (i6 == i5) {
                f((w<T>) t);
                return;
            }
            i3 = f;
            i = i7;
            t2 = t5;
            i2 = e;
            t3 = t6;
        }
    }

    private void f(T t) {
        int i = this.d;
        if (i == this.i) {
            d(this.c << 1);
            e((w<T>) t);
            return;
        }
        this.b[this.c + i] = t;
        this.d = i + 1;
        this.a++;
    }

    public boolean b(T t) {
        int hashCode = t.hashCode();
        int i = this.g & hashCode;
        if (t.equals(this.b[i])) {
            this.b[i] = null;
            this.a--;
            return true;
        }
        int e = e(hashCode);
        if (t.equals(this.b[e])) {
            this.b[e] = null;
            this.a--;
            return true;
        }
        int f = f(hashCode);
        if (t.equals(this.b[f])) {
            this.b[f] = null;
            this.a--;
            return true;
        }
        return c((w<T>) t);
    }

    boolean c(T t) {
        T[] tArr = this.b;
        int i = this.c;
        int i2 = this.d + i;
        while (i < i2) {
            if (t.equals(tArr[i])) {
                a(i);
                this.a--;
                return true;
            }
            i++;
        }
        return false;
    }

    void a(int i) {
        this.d--;
        int i2 = this.c + this.d;
        if (i < i2) {
            T[] tArr = this.b;
            tArr[i] = tArr[i2];
            tArr[i2] = null;
        }
    }

    public void b(int i) {
        if (this.c <= i) {
            a();
            return;
        }
        this.a = 0;
        d(i);
    }

    public void a() {
        if (this.a == 0) {
            return;
        }
        T[] tArr = this.b;
        int i = this.c + this.d;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                tArr[i2] = null;
                i = i2;
            } else {
                this.a = 0;
                this.d = 0;
                return;
            }
        }
    }

    public boolean d(T t) {
        int hashCode = t.hashCode();
        if (!t.equals(this.b[this.g & hashCode])) {
            if (!t.equals(this.b[e(hashCode)])) {
                return t.equals(this.b[f(hashCode)]) || g(t) != null;
            }
        }
        return true;
    }

    private T g(T t) {
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = this.d + i;
        while (i < i2) {
            if (t.equals(objArr[i])) {
                return objArr[i];
            }
            i++;
        }
        return null;
    }

    public T b() {
        T[] tArr = this.b;
        int i = this.c + this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (tArr[i2] != null) {
                return tArr[i2];
            }
        }
        throw new IllegalStateException("ObjectSet is empty.");
    }

    public void c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.a + i;
        if (i2 >= this.h) {
            d(com.badlogic.gdx.math.h.b((int) Math.ceil(i2 / this.e)));
        }
    }

    private void d(int i) {
        int i2 = this.c + this.d;
        this.c = i;
        this.h = (int) (i * this.e);
        this.g = i - 1;
        this.f = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.i = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.j = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        T[] tArr = this.b;
        this.b = (T[]) new Object[i + this.i];
        int i3 = this.a;
        this.a = 0;
        this.d = 0;
        if (i3 > 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                T t = tArr[i4];
                if (t != null) {
                    e((w<T>) t);
                }
            }
        }
    }

    private int e(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f)) & this.g;
    }

    private int f(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f)) & this.g;
    }

    public int hashCode() {
        int i = this.c + this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            T[] tArr = this.b;
            if (tArr[i3] != null) {
                i2 += tArr[i3].hashCode();
            }
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (wVar.a != this.a) {
                return false;
            }
            T[] tArr = this.b;
            int i = this.c + this.d;
            for (int i2 = 0; i2 < i; i2++) {
                if (tArr[i2] != null && !wVar.d((w) tArr[i2])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return '{' + a(", ") + '}';
    }

    public String a(String str) {
        int i;
        if (this.a == 0) {
            return "";
        }
        al alVar = new al(32);
        T[] tArr = this.b;
        int length = tArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                T t = tArr[i];
                if (t != null) {
                    alVar.a(t);
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
                T t2 = tArr[i2];
                if (t2 != null) {
                    alVar.c(str);
                    alVar.a(t2);
                }
                i = i2;
            } else {
                return alVar.toString();
            }
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: c */
    public a<T> iterator() {
        if (this.k == null) {
            this.k = new a(this);
            this.l = new a(this);
        }
        if (!this.k.e) {
            this.k.a();
            a<T> aVar = this.k;
            aVar.e = true;
            this.l.e = false;
            return aVar;
        }
        this.l.a();
        a<T> aVar2 = this.l;
        aVar2.e = true;
        this.k.e = false;
        return aVar2;
    }

    /* compiled from: ObjectSet.java */
    /* loaded from: classes.dex */
    public static class a<K> implements Iterable<K>, Iterator<K> {
        public boolean a;
        final w<K> b;
        int c;
        int d;
        boolean e = true;

        @Override // java.lang.Iterable
        /* renamed from: b */
        public a<K> iterator() {
            return this;
        }

        public a(w<K> wVar) {
            this.b = wVar;
            a();
        }

        public void a() {
            this.d = -1;
            this.c = -1;
            c();
        }

        private void c() {
            this.a = false;
            K[] kArr = this.b.b;
            int i = this.b.c + this.b.d;
            do {
                int i2 = this.c + 1;
                this.c = i2;
                if (i2 >= i) {
                    return;
                }
            } while (kArr[this.c] == null);
            this.a = true;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.d;
            if (i < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            if (i >= this.b.c) {
                this.b.a(this.d);
                this.c = this.d - 1;
                c();
            } else {
                this.b.b[this.d] = null;
            }
            this.d = -1;
            w<K> wVar = this.b;
            wVar.a--;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            return this.a;
        }

        @Override // java.util.Iterator
        public K next() {
            if (!this.a) {
                throw new NoSuchElementException();
            }
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            K[] kArr = this.b.b;
            int i = this.c;
            K k = kArr[i];
            this.d = i;
            c();
            return k;
        }
    }
}
