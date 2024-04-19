package defpackage;
/* compiled from: Vector3.java */
/* renamed from: act  reason: default package */
/* loaded from: classes.dex */
public class act {
    public float a;
    public float b;
    public float c;

    public act() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
    }

    public act(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public act(act actVar) {
        a(actVar);
    }

    public void a(act actVar) {
        this.a = actVar.a;
        this.b = actVar.b;
        this.c = actVar.c;
    }

    public void a(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    void a() {
        a(0.0f, 0.0f, 0.0f);
    }

    void b() {
        a(0.0f, 0.0f, -1.0f);
    }

    void c() {
        a(0.0f, 0.0f, 1.0f);
    }

    void d() {
        a(0.0f, 1.0f, 0.0f);
    }

    void e() {
        a(1.0f, 0.0f, 0.0f);
    }

    public float f() {
        float f = this.a;
        float f2 = this.b;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.c;
        return f3 + (f4 * f4);
    }

    public String toString() {
        return "[x=" + this.a + ", y=" + this.b + ", z=" + this.c + "]";
    }

    public act g() {
        act actVar = new act(this);
        float a = a(this, this);
        if (acr.a(a, 0.0f)) {
            actVar.a();
        } else if (a != 1.0f) {
            actVar.a(a((float) (1.0d / Math.sqrt(a))));
        }
        return actVar;
    }

    public act a(float f) {
        return new act(this.a * f, this.b * f, this.c * f);
    }

    public static float a(act actVar, act actVar2) {
        return (actVar.a * actVar2.a) + (actVar.b * actVar2.b) + (actVar.c * actVar2.c);
    }

    public static act b(act actVar, act actVar2) {
        float f = actVar.a;
        float f2 = actVar.b;
        float f3 = actVar.c;
        float f4 = actVar2.a;
        float f5 = actVar2.b;
        float f6 = actVar2.c;
        return new act((f2 * f6) - (f3 * f5), (f3 * f4) - (f6 * f), (f * f5) - (f2 * f4));
    }

    public static boolean c(act actVar, act actVar2) {
        return acr.a(actVar.c, actVar2.c) & acr.a(actVar.a, actVar2.a) & true & acr.a(actVar.b, actVar2.b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof act) {
            if (this == obj) {
                return true;
            }
            return c(this, (act) obj);
        }
        return false;
    }

    public int hashCode() {
        return ((((Float.floatToIntBits(this.a) + 31) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c);
    }

    public static act h() {
        act actVar = new act();
        actVar.b();
        return actVar;
    }

    public static act i() {
        act actVar = new act();
        actVar.c();
        return actVar;
    }

    public static act j() {
        act actVar = new act();
        actVar.d();
        return actVar;
    }

    public static act k() {
        act actVar = new act();
        actVar.e();
        return actVar;
    }
}
