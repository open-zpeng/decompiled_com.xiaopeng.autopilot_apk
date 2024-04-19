package com.badlogic.gdx.utils;
/* compiled from: FloatArray.java */
/* loaded from: classes.dex */
public class h {
    public float[] a;
    public int b;
    public boolean c;

    public h() {
        this(true, 16);
    }

    public h(int i) {
        this(true, i);
    }

    public h(boolean z, int i) {
        this.c = z;
        this.a = new float[i];
    }

    public void a(float f) {
        float[] fArr = this.a;
        int i = this.b;
        if (i == fArr.length) {
            fArr = c(Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.b;
        this.b = i2 + 1;
        fArr[i2] = f;
    }

    public void a(h hVar) {
        a(hVar.a, 0, hVar.b);
    }

    public void a(h hVar, int i, int i2) {
        if (i + i2 > hVar.b) {
            throw new IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + hVar.b);
        }
        a(hVar.a, i, i2);
    }

    public void a(float... fArr) {
        a(fArr, 0, fArr.length);
    }

    public void a(float[] fArr, int i, int i2) {
        float[] fArr2 = this.a;
        int i3 = this.b + i2;
        if (i3 > fArr2.length) {
            fArr2 = c(Math.max(8, (int) (i3 * 1.75f)));
        }
        System.arraycopy(fArr, i, fArr2, this.b, i2);
        this.b += i2;
    }

    public float a(int i) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return this.a[i];
    }

    public void a(int i, float f) {
        if (i >= this.b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        this.a[i] = f;
    }

    public void a(int i, int i2) {
        int i3 = this.b;
        if (i2 >= i3) {
            throw new IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.b);
        } else if (i > i2) {
            throw new IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        } else {
            float[] fArr = this.a;
            int i4 = (i2 - i) + 1;
            if (this.c) {
                int i5 = i + i4;
                System.arraycopy(fArr, i5, fArr, i, i3 - i5);
            } else {
                int i6 = i3 - 1;
                for (int i7 = 0; i7 < i4; i7++) {
                    fArr[i + i7] = fArr[i6 - i7];
                }
            }
            this.b -= i4;
        }
    }

    public float a() {
        return this.a[this.b - 1];
    }

    public void b() {
        this.b = 0;
    }

    public float[] b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            c(Math.max(8, i2));
        }
        return this.a;
    }

    protected float[] c(int i) {
        float[] fArr = new float[i];
        System.arraycopy(this.a, 0, fArr, 0, Math.min(this.b, fArr.length));
        this.a = fArr;
        return fArr;
    }

    public void d(int i) {
        if (this.b > i) {
            this.b = i;
        }
    }

    public float[] c() {
        int i = this.b;
        float[] fArr = new float[i];
        System.arraycopy(this.a, 0, fArr, 0, i);
        return fArr;
    }

    public int hashCode() {
        if (this.c) {
            float[] fArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + Float.floatToIntBits(fArr[i3]);
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
        if (this.c && (obj instanceof h)) {
            h hVar = (h) obj;
            if (hVar.c && (i = this.b) == hVar.b) {
                float[] fArr = this.a;
                float[] fArr2 = hVar.a;
                for (int i2 = 0; i2 < i; i2++) {
                    if (fArr[i2] != fArr2[i2]) {
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
        float[] fArr = this.a;
        al alVar = new al(32);
        alVar.append('[');
        alVar.a(fArr[0]);
        for (int i = 1; i < this.b; i++) {
            alVar.c(", ");
            alVar.a(fArr[i]);
        }
        alVar.append(']');
        return alVar.toString();
    }
}
