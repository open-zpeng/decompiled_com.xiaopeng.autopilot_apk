package defpackage;
/* compiled from: Quaternion.java */
/* renamed from: acs  reason: default package */
/* loaded from: classes.dex */
public class acs {
    public float a;
    public float b;
    public float c;
    public float d;

    public acs() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
    }

    public acs(float f, float f2, float f3, float f4) {
        a(f, f2, f3, f4);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        b();
    }

    public void a() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
    }

    public boolean b() {
        float b = b(this, this);
        if (acr.a(b, 0.0f)) {
            a();
            return false;
        } else if (b != 1.0f) {
            float sqrt = (float) (1.0d / Math.sqrt(b));
            this.a *= sqrt;
            this.b *= sqrt;
            this.c *= sqrt;
            this.d *= sqrt;
            return true;
        } else {
            return true;
        }
    }

    public String toString() {
        return "[x=" + this.a + ", y=" + this.b + ", z=" + this.c + ", w=" + this.d + "]";
    }

    public static act a(acs acsVar, act actVar) {
        act actVar2 = new act();
        float f = acsVar.d;
        float f2 = f * f;
        float f3 = acsVar.a;
        float f4 = f3 * f3;
        float f5 = acsVar.b;
        float f6 = f5 * f5;
        float f7 = acsVar.c;
        float f8 = f7 * f7;
        float f9 = f7 * f;
        float f10 = f3 * f5;
        float f11 = f3 * f7;
        float f12 = f5 * f;
        float f13 = f5 * f7;
        float f14 = f3 * f;
        float f15 = f10 + f9 + f9 + f10;
        float f16 = (((-f9) + f10) - f9) + f10;
        float f17 = f13 + f13;
        float f18 = f17 + f14 + f14;
        float f19 = (f17 - f14) - f14;
        float f20 = ((f8 - f6) - f4) + f2;
        float f21 = actVar.a;
        float f22 = actVar.b;
        float f23 = actVar.c;
        actVar2.a = ((((f2 + f4) - f8) - f6) * f21) + (f16 * f22) + ((f12 + f11 + f11 + f12) * f23);
        actVar2.b = (f15 * f21) + ((((f6 - f8) + f2) - f4) * f22) + (f19 * f23);
        actVar2.c = ((((f11 - f12) + f11) - f12) * f21) + (f18 * f22) + (f20 * f23);
        return actVar2;
    }

    public static acs a(acs acsVar, acs acsVar2) {
        float f = acsVar.a;
        float f2 = acsVar.b;
        float f3 = acsVar.c;
        float f4 = acsVar.d;
        float f5 = acsVar2.a;
        float f6 = acsVar2.b;
        float f7 = acsVar2.c;
        float f8 = acsVar2.d;
        return new acs((((f4 * f5) + (f * f8)) + (f2 * f7)) - (f3 * f6), ((f4 * f6) - (f * f7)) + (f2 * f8) + (f3 * f5), (((f4 * f7) + (f * f6)) - (f2 * f5)) + (f3 * f8), (((f4 * f8) - (f * f5)) - (f2 * f6)) - (f3 * f7));
    }

    static float b(acs acsVar, acs acsVar2) {
        return (acsVar.a * acsVar2.a) + (acsVar.b * acsVar2.b) + (acsVar.c * acsVar2.c) + (acsVar.d * acsVar2.d);
    }

    public static acs a(act actVar, float f) {
        acs acsVar = new acs();
        double radians = Math.toRadians(f) / 2.0d;
        double sin = Math.sin(radians);
        acsVar.a = (float) (actVar.a * sin);
        acsVar.b = (float) (actVar.b * sin);
        acsVar.c = (float) (actVar.c * sin);
        acsVar.d = (float) Math.cos(radians);
        acsVar.b();
        return acsVar;
    }

    public static acs a(act actVar, act actVar2) {
        act g = actVar.g();
        act g2 = actVar2.g();
        float a = act.a(g, g2);
        if (a < -0.999f) {
            act b = act.b(act.i(), g);
            if (b.f() < 0.01f) {
                b = act.b(act.k(), g);
            }
            return a(b.g(), 180.0f);
        }
        act b2 = act.b(g, g2);
        float sqrt = (float) Math.sqrt((a + 1.0d) * 2.0d);
        float f = 1.0f / sqrt;
        return new acs(b2.a * f, b2.b * f, b2.c * f, sqrt * 0.5f);
    }

    public static acs b(act actVar, act actVar2) {
        acs a = a(act.h(), actVar);
        return a(a(a(a, act.j()), act.b(act.b(actVar, actVar2), actVar)), a);
    }

    public static boolean c(acs acsVar, acs acsVar2) {
        return acr.a(b(acsVar, acsVar2), 1.0f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof acs) {
            if (this == obj) {
                return true;
            }
            return c(this, (acs) obj);
        }
        return false;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.d) + 31) * 31) + Float.floatToIntBits(this.a)) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c);
    }
}
