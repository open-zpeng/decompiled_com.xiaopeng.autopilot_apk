package com.badlogic.gdx.utils;

import java.util.Arrays;
/* compiled from: StringBuilder.java */
/* loaded from: classes.dex */
public class al implements Appendable, CharSequence {
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public char[] a;
    public int b;

    public static int a(int i, int i2) {
        int i3 = i < 0 ? 2 : 1;
        while (true) {
            i /= i2;
            if (i == 0) {
                return i3;
            }
            i3++;
        }
    }

    public static int a(long j, int i) {
        int i2 = j < 0 ? 2 : 1;
        while (true) {
            j /= i;
            if (j == 0) {
                return i2;
            }
            i2++;
        }
    }

    public al() {
        this.a = new char[16];
    }

    public al(int i) {
        if (i < 0) {
            throw new NegativeArraySizeException();
        }
        this.a = new char[i];
    }

    public al(String str) {
        this.b = str.length();
        int i = this.b;
        this.a = new char[i + 16];
        str.getChars(0, i, this.a, 0);
    }

    private void c(int i) {
        char[] cArr = this.a;
        int length = (cArr.length >> 1) + cArr.length + 2;
        if (i <= length) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(this.a, 0, cArr2, 0, this.b);
        this.a = cArr2;
    }

    final void a() {
        int i = this.b + 4;
        if (i > this.a.length) {
            c(i);
        }
        char[] cArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        cArr[i2] = 'n';
        int i3 = this.b;
        this.b = i3 + 1;
        cArr[i3] = 'u';
        int i4 = this.b;
        this.b = i4 + 1;
        cArr[i4] = 'l';
        int i5 = this.b;
        this.b = i5 + 1;
        cArr[i5] = 'l';
    }

    final void a(char[] cArr) {
        int length = this.b + cArr.length;
        if (length > this.a.length) {
            c(length);
        }
        System.arraycopy(cArr, 0, this.a, this.b, cArr.length);
        this.b = length;
    }

    final void a(char[] cArr, int i, int i2) {
        if (i > cArr.length || i < 0) {
            throw new ArrayIndexOutOfBoundsException("Offset out of bounds: " + i);
        } else if (i2 < 0 || cArr.length - i < i2) {
            throw new ArrayIndexOutOfBoundsException("Length out of bounds: " + i2);
        } else {
            int i3 = this.b + i2;
            if (i3 > this.a.length) {
                c(i3);
            }
            System.arraycopy(cArr, i, this.a, this.b, i2);
            this.b = i3;
        }
    }

    final void a(char c2) {
        int i = this.b;
        if (i == this.a.length) {
            c(i + 1);
        }
        char[] cArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        cArr[i2] = c2;
    }

    final void a(String str) {
        if (str == null) {
            a();
            return;
        }
        int length = str.length();
        int i = this.b + length;
        if (i > this.a.length) {
            c(i);
        }
        str.getChars(0, length, this.a, this.b);
        this.b = i;
    }

    final void a(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        if (i < 0 || i2 < 0 || i > i2 || i2 > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        a(charSequence.subSequence(i, i2).toString());
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i < 0 || i >= this.b) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return this.a[i];
    }

    final void a(int i, String str) {
        if (i >= 0 && i <= this.b) {
            if (str == null) {
                str = "null";
            }
            int length = str.length();
            if (length != 0) {
                d(length, i);
                str.getChars(0, length, this.a, i);
                this.b += length;
                return;
            }
            return;
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.b;
    }

    private void d(int i, int i2) {
        char[] cArr = this.a;
        int length = cArr.length;
        int i3 = this.b;
        if (length - i3 >= i) {
            System.arraycopy(cArr, i2, cArr, i + i2, i3 - i2);
            return;
        }
        int i4 = i3 + i;
        int length2 = (cArr.length << 1) + 2;
        if (i4 > length2) {
            length2 = i4;
        }
        char[] cArr2 = new char[length2];
        System.arraycopy(this.a, 0, cArr2, 0, i2);
        System.arraycopy(this.a, i2, cArr2, i + i2, this.b - i2);
        this.a = cArr2;
    }

    final void a(int i, int i2, String str) {
        if (i >= 0) {
            int i3 = this.b;
            if (i2 > i3) {
                i2 = i3;
            }
            if (i2 > i) {
                int length = str.length();
                int i4 = (i2 - i) - length;
                if (i4 > 0) {
                    char[] cArr = this.a;
                    System.arraycopy(cArr, i2, cArr, i + length, this.b - i2);
                } else if (i4 < 0) {
                    d(-i4, i2);
                }
                str.getChars(0, length, this.a, i);
                this.b -= i4;
                return;
            } else if (i == i2) {
                if (str == null) {
                    throw new NullPointerException();
                }
                a(i, str);
                return;
            }
        }
        throw new StringIndexOutOfBoundsException();
    }

    public void a(int i) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        char[] cArr = this.a;
        if (i > cArr.length) {
            c(i);
        } else {
            int i2 = this.b;
            if (i2 < i) {
                Arrays.fill(cArr, i2, i, (char) 0);
            }
        }
        this.b = i;
    }

    public String b(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.b) {
            throw new StringIndexOutOfBoundsException();
        }
        return i == i2 ? "" : new String(this.a, i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        int i = this.b;
        return i == 0 ? "" : new String(this.a, 0, i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return b(i, i2);
    }

    public int b(String str) {
        return a(str, 0);
    }

    public int a(String str, int i) {
        boolean z;
        if (i < 0) {
            i = 0;
        }
        int length = str.length();
        if (length > 0) {
            if (length + i > this.b) {
                return -1;
            }
            char charAt = str.charAt(0);
            while (true) {
                if (i >= this.b) {
                    z = false;
                } else if (this.a[i] == charAt) {
                    z = true;
                } else {
                    i++;
                }
                if (!z || length + i > this.b) {
                    break;
                }
                int i2 = i;
                int i3 = 0;
                do {
                    i3++;
                    if (i3 >= length) {
                        break;
                    }
                    i2++;
                } while (this.a[i2] == str.charAt(i3));
                if (i3 == length) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i4 = this.b;
        return (i < i4 || i == 0) ? i : i4;
    }

    public al a(boolean z) {
        a(z ? "true" : "false");
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: b */
    public al append(char c2) {
        a(c2);
        return this;
    }

    public al b(int i) {
        return c(i, 0);
    }

    public al c(int i, int i2) {
        return a(i, i2, '0');
    }

    public al a(int i, int i2, char c2) {
        if (i == Integer.MIN_VALUE) {
            a("-2147483648");
            return this;
        }
        if (i < 0) {
            a('-');
            i = -i;
        }
        if (i2 > 1) {
            for (int a = i2 - a(i, 10); a > 0; a--) {
                append(c2);
            }
        }
        if (i >= 10000) {
            if (i >= 1000000000) {
                a(c[(int) ((i % 10000000000L) / 1000000000)]);
            }
            if (i >= 100000000) {
                a(c[(i % 1000000000) / 100000000]);
            }
            if (i >= 10000000) {
                a(c[(i % 100000000) / 10000000]);
            }
            if (i >= 1000000) {
                a(c[(i % 10000000) / 1000000]);
            }
            if (i >= 100000) {
                a(c[(i % 1000000) / 100000]);
            }
            a(c[(i % 100000) / 10000]);
        }
        if (i >= 1000) {
            a(c[(i % 10000) / 1000]);
        }
        if (i >= 100) {
            a(c[(i % 1000) / 100]);
        }
        if (i >= 10) {
            a(c[(i % 100) / 10]);
        }
        a(c[i % 10]);
        return this;
    }

    public al a(long j) {
        return b(j, 0);
    }

    public al b(long j, int i) {
        return a(j, i, '0');
    }

    public al a(long j, int i, char c2) {
        if (j == Long.MIN_VALUE) {
            a("-9223372036854775808");
            return this;
        }
        if (j < 0) {
            a('-');
            j = -j;
        }
        if (i > 1) {
            for (int a = i - a(j, 10); a > 0; a--) {
                append(c2);
            }
        }
        if (j >= 10000) {
            if (j >= 1000000000000000000L) {
                a(c[(int) ((j % 1.0E19d) / 1.0E18d)]);
            }
            if (j >= 100000000000000000L) {
                a(c[(int) ((j % 1000000000000000000L) / 100000000000000000L)]);
            }
            if (j >= 10000000000000000L) {
                a(c[(int) ((j % 100000000000000000L) / 10000000000000000L)]);
            }
            if (j >= 1000000000000000L) {
                a(c[(int) ((j % 10000000000000000L) / 1000000000000000L)]);
            }
            if (j >= 100000000000000L) {
                a(c[(int) ((j % 1000000000000000L) / 100000000000000L)]);
            }
            if (j >= 10000000000000L) {
                a(c[(int) ((j % 100000000000000L) / 10000000000000L)]);
            }
            if (j >= 1000000000000L) {
                a(c[(int) ((j % 10000000000000L) / 1000000000000L)]);
            }
            if (j >= 100000000000L) {
                a(c[(int) ((j % 1000000000000L) / 100000000000L)]);
            }
            if (j >= 10000000000L) {
                a(c[(int) ((j % 100000000000L) / 10000000000L)]);
            }
            if (j >= 1000000000) {
                a(c[(int) ((j % 10000000000L) / 1000000000)]);
            }
            if (j >= 100000000) {
                a(c[(int) ((j % 1000000000) / 100000000)]);
            }
            if (j >= 10000000) {
                a(c[(int) ((j % 100000000) / 10000000)]);
            }
            if (j >= 1000000) {
                a(c[(int) ((j % 10000000) / 1000000)]);
            }
            if (j >= 100000) {
                a(c[(int) ((j % 1000000) / 100000)]);
            }
            a(c[(int) ((j % 100000) / 10000)]);
        }
        if (j >= 1000) {
            a(c[(int) ((j % 10000) / 1000)]);
        }
        if (j >= 100) {
            a(c[(int) ((j % 1000) / 100)]);
        }
        if (j >= 10) {
            a(c[(int) ((j % 100) / 10)]);
        }
        a(c[(int) (j % 10)]);
        return this;
    }

    public al a(float f) {
        a(Float.toString(f));
        return this;
    }

    public al a(double d) {
        a(Double.toString(d));
        return this;
    }

    public al a(Object obj) {
        if (obj == null) {
            a();
        } else {
            a(obj.toString());
        }
        return this;
    }

    public al c(String str) {
        a(str);
        return this;
    }

    public al b(char[] cArr) {
        a(cArr);
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: a */
    public al append(CharSequence charSequence) {
        if (charSequence == null) {
            a();
        } else if (charSequence instanceof al) {
            al alVar = (al) charSequence;
            a(alVar.a, 0, alVar.b);
        } else {
            a(charSequence.toString());
        }
        return this;
    }

    public al a(al alVar) {
        if (alVar == null) {
            a();
        } else {
            a(alVar.a, 0, alVar.b);
        }
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: b */
    public al append(CharSequence charSequence, int i, int i2) {
        a(charSequence, i, i2);
        return this;
    }

    public al a(char c2, String str) {
        int length = str.length();
        int i = 0;
        while (i != this.b) {
            if (this.a[i] == c2) {
                a(i, i + 1, str);
                i += length;
            } else {
                i++;
            }
        }
        return this;
    }

    public int hashCode() {
        return ((this.b + 31) * 31) + Arrays.hashCode(this.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            al alVar = (al) obj;
            int i = this.b;
            if (i != alVar.b) {
                return false;
            }
            char[] cArr = this.a;
            char[] cArr2 = alVar.a;
            if (cArr == cArr2) {
                return true;
            }
            if (cArr == null || cArr2 == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (cArr[i2] != cArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
