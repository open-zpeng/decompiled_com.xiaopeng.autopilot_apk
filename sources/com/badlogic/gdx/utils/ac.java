package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: Queue.java */
/* loaded from: classes.dex */
public class ac<T> implements Iterable<T> {
    protected T[] a;
    protected int b;
    protected int c;
    public int d;
    private a e;

    public ac() {
        this(16);
    }

    public ac(int i) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.a = (T[]) new Object[i];
    }

    public void a(T t) {
        T[] tArr = this.a;
        if (this.d == tArr.length) {
            a(tArr.length << 1);
            tArr = this.a;
        }
        int i = this.c;
        this.c = i + 1;
        tArr[i] = t;
        if (this.c == tArr.length) {
            this.c = 0;
        }
        this.d++;
    }

    protected void a(int i) {
        T[] tArr = this.a;
        int i2 = this.b;
        int i3 = this.c;
        T[] tArr2 = (T[]) ((Object[]) qt.a(tArr.getClass().getComponentType(), i));
        if (i2 < i3) {
            System.arraycopy(tArr, i2, tArr2, 0, i3 - i2);
        } else if (this.d > 0) {
            int length = tArr.length - i2;
            System.arraycopy(tArr, i2, tArr2, 0, length);
            System.arraycopy(tArr, 0, tArr2, length, i3);
        }
        this.a = tArr2;
        this.b = 0;
        this.c = this.d;
    }

    public T b(int i) {
        T t;
        if (i < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        } else if (i >= this.d) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.d);
        } else {
            T[] tArr = this.a;
            int i2 = this.b;
            int i3 = this.c;
            int i4 = i + i2;
            if (i2 < i3) {
                t = tArr[i4];
                System.arraycopy(tArr, i4 + 1, tArr, i4, i3 - i4);
                tArr[i3] = null;
                this.c--;
            } else if (i4 >= tArr.length) {
                int length = i4 - tArr.length;
                t = tArr[length];
                System.arraycopy(tArr, length + 1, tArr, length, i3 - length);
                this.c--;
            } else {
                T t2 = tArr[i4];
                System.arraycopy(tArr, i2, tArr, i2 + 1, i4 - i2);
                tArr[i2] = null;
                this.b++;
                if (this.b == tArr.length) {
                    this.b = 0;
                }
                t = t2;
            }
            this.d--;
            return t;
        }
    }

    public T c(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        } else if (i >= this.d) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.d);
        } else {
            T[] tArr = this.a;
            int i2 = this.b + i;
            if (i2 >= tArr.length) {
                i2 -= tArr.length;
            }
            return tArr[i2];
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        if (this.e == null) {
            this.e = new a(this);
        }
        return this.e.iterator();
    }

    public String toString() {
        if (this.d == 0) {
            return "[]";
        }
        T[] tArr = this.a;
        int i = this.b;
        int i2 = this.c;
        al alVar = new al(64);
        alVar.append('[');
        alVar.a(tArr[i]);
        while (true) {
            i = (i + 1) % tArr.length;
            if (i != i2) {
                alVar.c(", ").a(tArr[i]);
            } else {
                alVar.append(']');
                return alVar.toString();
            }
        }
    }

    public int hashCode() {
        int i = this.d;
        T[] tArr = this.a;
        int length = tArr.length;
        int i2 = i + 1;
        int i3 = this.b;
        for (int i4 = 0; i4 < i; i4++) {
            T t = tArr[i3];
            i2 *= 31;
            if (t != null) {
                i2 += t.hashCode();
            }
            i3++;
            if (i3 == length) {
                i3 = 0;
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r11 != r12) goto L4
            return r0
        L4:
            r1 = 0
            if (r12 == 0) goto L41
            boolean r2 = r12 instanceof com.badlogic.gdx.utils.ac
            if (r2 != 0) goto Lc
            goto L41
        Lc:
            com.badlogic.gdx.utils.ac r12 = (com.badlogic.gdx.utils.ac) r12
            int r2 = r11.d
            int r3 = r12.d
            if (r3 == r2) goto L15
            return r1
        L15:
            T[] r3 = r11.a
            int r4 = r3.length
            T[] r5 = r12.a
            int r6 = r5.length
            int r7 = r11.b
            int r12 = r12.b
            r8 = r12
            r12 = r1
        L21:
            if (r12 >= r2) goto L40
            r9 = r3[r7]
            r10 = r5[r8]
            if (r9 != 0) goto L2c
            if (r10 != 0) goto L32
            goto L33
        L2c:
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L33
        L32:
            return r1
        L33:
            int r7 = r7 + 1
            int r8 = r8 + 1
            if (r7 != r4) goto L3a
            r7 = r1
        L3a:
            if (r8 != r6) goto L3d
            r8 = r1
        L3d:
            int r12 = r12 + 1
            goto L21
        L40:
            return r0
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.ac.equals(java.lang.Object):boolean");
    }

    /* compiled from: Queue.java */
    /* loaded from: classes.dex */
    public static class b<T> implements Iterable<T>, Iterator<T> {
        int a;
        boolean b = true;
        private final ac<T> c;
        private final boolean d;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this;
        }

        public b(ac<T> acVar, boolean z) {
            this.c = acVar;
            this.d = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return this.a < this.c.d;
            }
            throw new k("#iterator() cannot be used nested.");
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.a >= this.c.d) {
                throw new NoSuchElementException(String.valueOf(this.a));
            }
            if (!this.b) {
                throw new k("#iterator() cannot be used nested.");
            }
            ac<T> acVar = this.c;
            int i = this.a;
            this.a = i + 1;
            return acVar.c(i);
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

    /* compiled from: Queue.java */
    /* loaded from: classes.dex */
    public static class a<T> implements Iterable<T> {
        private final ac<T> a;
        private final boolean b;
        private b c;
        private b d;

        public a(ac<T> acVar) {
            this(acVar, true);
        }

        public a(ac<T> acVar, boolean z) {
            this.a = acVar;
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
