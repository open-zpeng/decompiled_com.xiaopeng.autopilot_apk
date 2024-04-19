package com.badlogic.gdx.utils;
/* compiled from: ShortArray.java */
/* loaded from: classes.dex */
public class ah {
    public short[] a;
    public int b;
    public boolean c;

    public ah() {
        this(true, 16);
    }

    public ah(boolean z, int i) {
        this.c = z;
        this.a = new short[i];
    }

    public void a(short s) {
        short[] sArr = this.a;
        int i = this.b;
        if (i == sArr.length) {
            sArr = d(Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.b;
        this.b = i2 + 1;
        sArr[i2] = s;
    }

    public short a(int i) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return this.a[i];
    }

    public void a(int i, short s) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        this.a[i] = s;
    }

    public short b(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        short[] sArr = this.a;
        short s = sArr[i];
        this.b = i2 - 1;
        if (this.c) {
            System.arraycopy(sArr, i + 1, sArr, i, this.b - i);
        } else {
            sArr[i] = sArr[this.b];
        }
        return s;
    }

    public void a() {
        this.b = 0;
    }

    public short[] c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            d(Math.max(8, i2));
        }
        return this.a;
    }

    protected short[] d(int i) {
        short[] sArr = new short[i];
        System.arraycopy(this.a, 0, sArr, 0, Math.min(this.b, sArr.length));
        this.a = sArr;
        return sArr;
    }

    public short[] b() {
        int i = this.b;
        short[] sArr = new short[i];
        System.arraycopy(this.a, 0, sArr, 0, i);
        return sArr;
    }

    public int hashCode() {
        if (this.c) {
            short[] sArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + sArr[i3];
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
        if (this.c && (obj instanceof ah)) {
            ah ahVar = (ah) obj;
            if (ahVar.c && (i = this.b) == ahVar.b) {
                short[] sArr = this.a;
                short[] sArr2 = ahVar.a;
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.a[i2] != ahVar.a[i2]) {
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
        short[] sArr = this.a;
        al alVar = new al(32);
        alVar.append('[');
        alVar.b(sArr[0]);
        for (int i = 1; i < this.b; i++) {
            alVar.c(", ");
            alVar.b(sArr[i]);
        }
        alVar.append(']');
        return alVar.toString();
    }
}
