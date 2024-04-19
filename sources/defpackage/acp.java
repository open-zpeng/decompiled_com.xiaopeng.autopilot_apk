package defpackage;
/* compiled from: Point.java */
/* renamed from: acp  reason: default package */
/* loaded from: classes.dex */
public final class acp {
    public float a;
    public float b;
    public float c;

    public acp() {
    }

    public acp(float f, float f2, float f3) {
        a(f, f2, f3);
    }

    public acp a(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        return this;
    }

    public String toString() {
        return "Point(" + this.a + ", " + this.b + ", " + this.c + ")";
    }
}
