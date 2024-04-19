package com.badlogic.gdx.utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: Array.java */
/* loaded from: classes.dex */
public class a<T> implements Iterable<T> {
    public T[] a;
    public int b;
    public boolean c;
    private C0048a d;

    public a() {
        this(true, 16);
    }

    public a(int i) {
        this(true, i);
    }

    public a(boolean z, int i) {
        this.c = z;
        this.a = (T[]) new Object[i];
    }

    public a(boolean z, int i, Class cls) {
        this.c = z;
        this.a = (T[]) ((Object[]) qt.a(cls, i));
    }

    public a(Class cls) {
        this(true, 16, cls);
    }

    public a(a<? extends T> aVar) {
        this(aVar.c, aVar.b, aVar.a.getClass().getComponentType());
        this.b = aVar.b;
        System.arraycopy(aVar.a, 0, this.a, 0, this.b);
    }

    public a(T[] tArr) {
        this(true, tArr, 0, tArr.length);
    }

    public a(boolean z, T[] tArr, int i, int i2) {
        this(z, i2, tArr.getClass().getComponentType());
        this.b = i2;
        System.arraycopy(tArr, i, this.a, 0, this.b);
    }

    public void a(T t) {
        T[] tArr = this.a;
        int i = this.b;
        if (i == tArr.length) {
            tArr = d(Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.b;
        this.b = i2 + 1;
        tArr[i2] = t;
    }

    public void a(a<? extends T> aVar) {
        a(aVar.a, 0, aVar.b);
    }

    public void a(a<? extends T> aVar, int i, int i2) {
        if (i + i2 > aVar.b) {
            throw new IllegalArgumentException("start + count must be <= size: " + i + " + " + i2 + " <= " + aVar.b);
        }
        a(aVar.a, i, i2);
    }

    public void a(T... tArr) {
        a(tArr, 0, tArr.length);
    }

    public void a(T[] tArr, int i, int i2) {
        T[] tArr2 = this.a;
        int i3 = this.b + i2;
        if (i3 > tArr2.length) {
            tArr2 = d(Math.max(8, (int) (i3 * 1.75f)));
        }
        System.arraycopy(tArr, i, tArr2, this.b, i2);
        this.b += i2;
    }

    public T a(int i) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return this.a[i];
    }

    public void a(int i, T t) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        this.a[i] = t;
    }

    public void b(int i, T t) {
        int i2 = this.b;
        if (i > i2) {
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.b);
        }
        T[] tArr = this.a;
        if (i2 == tArr.length) {
            tArr = d(Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.c) {
            System.arraycopy(tArr, i, tArr, i + 1, this.b - i);
        } else {
            tArr[this.b] = tArr[i];
        }
        this.b++;
        tArr[i] = t;
    }

    public boolean a(T t, boolean z) {
        T[] tArr = this.a;
        int i = this.b - 1;
        if (z || t == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (tArr[i] == t) {
                    return true;
                }
                i = i2;
            }
            return false;
        }
        while (i >= 0) {
            int i3 = i - 1;
            if (t.equals(tArr[i])) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public int b(T t, boolean z) {
        T[] tArr = this.a;
        int i = 0;
        if (z || t == null) {
            int i2 = this.b;
            while (i < i2) {
                if (tArr[i] == t) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.b;
        while (i < i3) {
            if (t.equals(tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean c(T t, boolean z) {
        T[] tArr = this.a;
        if (z || t == null) {
            int i = this.b;
            for (int i2 = 0; i2 < i; i2++) {
                if (tArr[i2] == t) {
                    b(i2);
                    return true;
                }
            }
        } else {
            int i3 = this.b;
            for (int i4 = 0; i4 < i3; i4++) {
                if (t.equals(tArr[i4])) {
                    b(i4);
                    return true;
                }
            }
        }
        return false;
    }

    public T b(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        T[] tArr = this.a;
        T t = tArr[i];
        this.b = i2 - 1;
        if (this.c) {
            System.arraycopy(tArr, i + 1, tArr, i, this.b - i);
        } else {
            tArr[i] = tArr[this.b];
        }
        tArr[this.b] = null;
        return t;
    }

    public void a(int i, int i2) {
        int i3 = this.b;
        if (i2 >= i3) {
            throw new IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.b);
        } else if (i > i2) {
            throw new IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        } else {
            T[] tArr = this.a;
            int i4 = (i2 - i) + 1;
            if (this.c) {
                int i5 = i + i4;
                System.arraycopy(tArr, i5, tArr, i, i3 - i5);
            } else {
                int i6 = i3 - 1;
                for (int i7 = 0; i7 < i4; i7++) {
                    tArr[i + i7] = tArr[i6 - i7];
                }
            }
            this.b -= i4;
        }
    }

    public boolean a(a<? extends T> aVar, boolean z) {
        int i;
        int i2 = this.b;
        T[] tArr = this.a;
        if (z) {
            int i3 = aVar.b;
            i = i2;
            for (int i4 = 0; i4 < i3; i4++) {
                T a = aVar.a(i4);
                int i5 = 0;
                while (true) {
                    if (i5 >= i) {
                        break;
                    } else if (a == tArr[i5]) {
                        b(i5);
                        i--;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        } else {
            int i6 = aVar.b;
            i = i2;
            for (int i7 = 0; i7 < i6; i7++) {
                T a2 = aVar.a(i7);
                int i8 = 0;
                while (true) {
                    if (i8 >= i) {
                        break;
                    } else if (a2.equals(tArr[i8])) {
                        b(i8);
                        i--;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        }
        return i != i2;
    }

    public T a() {
        int i = this.b;
        if (i == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        this.b = i - 1;
        T[] tArr = this.a;
        int i2 = this.b;
        T t = tArr[i2];
        tArr[i2] = null;
        return t;
    }

    public T b() {
        int i = this.b;
        if (i == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        return this.a[i - 1];
    }

    public T c() {
        if (this.b == 0) {
            throw new IllegalStateException("Array is empty.");
        }
        return this.a[0];
    }

    public void d() {
        T[] tArr = this.a;
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            tArr[i2] = null;
        }
        this.b = 0;
    }

    public T[] c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            d(Math.max(8, i2));
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T[] d(int i) {
        T[] tArr = this.a;
        T[] tArr2 = (T[]) ((Object[]) qt.a(tArr.getClass().getComponentType(), i));
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.b, tArr2.length));
        this.a = tArr2;
        return tArr2;
    }

    public void a(Comparator<? super T> comparator) {
        aj.a().a(this.a, comparator, 0, this.b);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        if (this.d == null) {
            this.d = new C0048a(this);
        }
        return this.d.iterator();
    }

    public void e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + i);
        } else if (this.b > i) {
            for (int i2 = i; i2 < this.b; i2++) {
                this.a[i2] = null;
            }
            this.b = i;
        }
    }

    public T e() {
        int i = this.b;
        if (i == 0) {
            return null;
        }
        return this.a[com.badlogic.gdx.math.h.a(0, i - 1)];
    }

    public <V> V[] a(Class cls) {
        V[] vArr = (V[]) ((Object[]) qt.a(cls, this.b));
        System.arraycopy(this.a, 0, vArr, 0, this.b);
        return vArr;
    }

    public int hashCode() {
        if (this.c) {
            T[] tArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 *= 31;
                T t = tArr[i3];
                if (t != null) {
                    i2 += t.hashCode();
                }
            }
            return i2;
        }
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (this.c && (obj instanceof a)) {
            a aVar = (a) obj;
            if (aVar.c && (i = this.b) == aVar.b) {
                T[] tArr = this.a;
                T[] tArr2 = aVar.a;
                for (int i2 = 0; i2 < i; i2++) {
                    T t = tArr[i2];
                    T t2 = tArr2[i2];
                    if (t == null) {
                        if (t2 != null) {
                            return false;
                        }
                    } else if (!t.equals(t2)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        if (this.b == 0) {
            return "[]";
        }
        T[] tArr = this.a;
        al alVar = new al(32);
        alVar.append('[');
        alVar.a(tArr[0]);
        for (int i = 1; i < this.b; i++) {
            alVar.c(", ");
            alVar.a(tArr[i]);
        }
        alVar.append(']');
        return alVar.toString();
    }

    public String a(String str) {
        if (this.b == 0) {
            return "";
        }
        T[] tArr = this.a;
        al alVar = new al(32);
        alVar.a(tArr[0]);
        for (int i = 1; i < this.b; i++) {
            alVar.c(str);
            alVar.a(tArr[i]);
        }
        return alVar.toString();
    }

    public static <T> a<T> b(T... tArr) {
        return new a<>(tArr);
    }

    /* compiled from: Array.java */
    /* loaded from: classes.dex */
    public static class b<T> implements Iterable<T>, Iterator<T> {
        int a;
        boolean b = true;
        private final a<T> c;
        private final boolean d;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this;
        }

        public b(a<T> aVar, boolean z) {
            this.c = aVar;
            this.d = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return this.a < this.c.b;
            }
            throw new k("#iterator() cannot be used nested.");
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.a >= this.c.b) {
                throw new NoSuchElementException(String.valueOf(this.a));
            }
            if (!this.b) {
                throw new k("#iterator() cannot be used nested.");
            }
            T[] tArr = this.c.a;
            int i = this.a;
            this.a = i + 1;
            return tArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new k("Remove not allowed.");
            }
            this.a--;
            this.c.b(this.a);
        }
    }

    /* compiled from: Array.java */
    /* renamed from: com.badlogic.gdx.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0048a<T> implements Iterable<T> {
        private final a<T> a;
        private final boolean b;
        private b c;
        private b d;

        public C0048a(a<T> aVar) {
            this(aVar, true);
        }

        public C0048a(a<T> aVar, boolean z) {
            this.a = aVar;
            this.b = z;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            if (this.c == null) {
                this.c = new b(this.a, this.b);
                this.d = new b(this.a, this.b);
            }
            if (!this.c.b) {
                b bVar = this.c;
                bVar.a = 0;
                bVar.b = true;
                this.d.b = false;
                return bVar;
            }
            b bVar2 = this.d;
            bVar2.a = 0;
            bVar2.b = true;
            this.c.b = false;
            return bVar2;
        }
    }
}
