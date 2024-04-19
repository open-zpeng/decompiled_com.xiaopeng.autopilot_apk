package com.badlogic.gdx.utils;
/* compiled from: IntArray.java */
/* loaded from: classes.dex */
public class m {
    public int[] a;
    public int b;
    public boolean c;

    public m() {
        this(true, 16);
    }

    public m(int i) {
        this(true, i);
    }

    public m(boolean z, int i) {
        this.c = z;
        this.a = new int[i];
    }

    public void a(int i) {
        int[] iArr = this.a;
        int i2 = this.b;
        if (i2 == iArr.length) {
            iArr = e(Math.max(8, (int) (i2 * 1.75f)));
        }
        int i3 = this.b;
        this.b = i3 + 1;
        iArr[i3] = i;
    }

    public void a(int... iArr) {
        a(iArr, 0, iArr.length);
    }

    public void a(int[] iArr, int i, int i2) {
        int[] iArr2 = this.a;
        int i3 = this.b + i2;
        if (i3 > iArr2.length) {
            iArr2 = e(Math.max(8, (int) (i3 * 1.75f)));
        }
        System.arraycopy(iArr, i, iArr2, this.b, i2);
        this.b += i2;
    }

    public int b(int i) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return this.a[i];
    }

    public void a(int i, int i2) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        int[] iArr = this.a;
        iArr[i] = iArr[i] + i2;
    }

    public void b(int i, int i2) {
        int i3 = this.b;
        if (i > i3) {
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.b);
        }
        int[] iArr = this.a;
        if (i3 == iArr.length) {
            iArr = e(Math.max(8, (int) (i3 * 1.75f)));
        }
        if (this.c) {
            System.arraycopy(iArr, i, iArr, i + 1, this.b - i);
        } else {
            iArr[this.b] = iArr[i];
        }
        this.b++;
        iArr[i] = i2;
    }

    public int c(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        int[] iArr = this.a;
        int i3 = iArr[i];
        this.b = i2 - 1;
        if (this.c) {
            System.arraycopy(iArr, i + 1, iArr, i, this.b - i);
        } else {
            iArr[i] = iArr[this.b];
        }
        return i3;
    }

    public int a() {
        int[] iArr = this.a;
        int i = this.b - 1;
        this.b = i;
        return iArr[i];
    }

    public void b() {
        this.b = 0;
    }

    public int[] c() {
        int length = this.a.length;
        int i = this.b;
        if (length != i) {
            e(i);
        }
        return this.a;
    }

    public int[] d(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            e(Math.max(8, i2));
        }
        return this.a;
    }

    protected int[] e(int i) {
        int[] iArr = new int[i];
        System.arraycopy(this.a, 0, iArr, 0, Math.min(this.b, iArr.length));
        this.a = iArr;
        return iArr;
    }

    public int hashCode() {
        if (this.c) {
            int[] iArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + iArr[i3];
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
        if (this.c && (obj instanceof m)) {
            m mVar = (m) obj;
            if (mVar.c && (i = this.b) == mVar.b) {
                int[] iArr = this.a;
                int[] iArr2 = mVar.a;
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.a[i2] != mVar.a[i2]) {
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
        int[] iArr = this.a;
        al alVar = new al(32);
        alVar.append('[');
        alVar.b(iArr[0]);
        for (int i = 1; i < this.b; i++) {
            alVar.c(", ");
            alVar.b(iArr[i]);
        }
        alVar.append(']');
        return alVar.toString();
    }
}
