package com.badlogic.gdx.utils;
/* compiled from: ByteArray.java */
/* loaded from: classes.dex */
public class d {
    public byte[] a;
    public int b;
    public boolean c;

    public d() {
        this(true, 16);
    }

    public d(int i) {
        this(true, i);
    }

    public d(boolean z, int i) {
        this.c = z;
        this.a = new byte[i];
    }

    public byte[] a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            b(Math.max(8, i2));
        }
        return this.a;
    }

    protected byte[] b(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, 0, bArr, 0, Math.min(this.b, bArr.length));
        this.a = bArr;
        return bArr;
    }

    public int hashCode() {
        if (this.c) {
            byte[] bArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + bArr[i3];
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
        if (this.c && (obj instanceof d)) {
            d dVar = (d) obj;
            if (dVar.c && (i = this.b) == dVar.b) {
                byte[] bArr = this.a;
                byte[] bArr2 = dVar.a;
                for (int i2 = 0; i2 < i; i2++) {
                    if (bArr[i2] != bArr2[i2]) {
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
        byte[] bArr = this.a;
        al alVar = new al(32);
        alVar.append('[');
        alVar.b(bArr[0]);
        for (int i = 1; i < this.b; i++) {
            alVar.c(", ");
            alVar.b(bArr[i]);
        }
        alVar.append(']');
        return alVar.toString();
    }
}
