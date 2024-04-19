package defpackage;

import android.graphics.Insets;
import android.graphics.Rect;
/* compiled from: Insets.java */
/* renamed from: em  reason: default package */
/* loaded from: classes.dex */
public final class em {
    public static final em a = new em(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    private em(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static em a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return a;
        }
        return new em(i, i2, i3, i4);
    }

    public static em a(Rect rect) {
        return a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static em a(em emVar, em emVar2) {
        return a(Math.max(emVar.b, emVar2.b), Math.max(emVar.c, emVar2.c), Math.max(emVar.d, emVar2.d), Math.max(emVar.e, emVar2.e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        em emVar = (em) obj;
        return this.e == emVar.e && this.b == emVar.b && this.d == emVar.d && this.c == emVar.c;
    }

    public int hashCode() {
        return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "Insets{left=" + this.b + ", top=" + this.c + ", right=" + this.d + ", bottom=" + this.e + '}';
    }

    public Insets a() {
        return Insets.of(this.b, this.c, this.d, this.e);
    }
}
