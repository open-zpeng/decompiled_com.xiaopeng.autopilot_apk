package defpackage;

import com.badlogic.gdx.utils.t;
/* compiled from: Color.java */
/* renamed from: ka  reason: default package */
/* loaded from: classes.dex */
public class ka {
    public float J;
    public float K;
    public float L;
    public float M;
    public static final ka a = new ka(1.0f, 1.0f, 1.0f, 1.0f);
    public static final ka b = new ka(-1077952513);
    public static final ka c = new ka(2139062271);
    public static final ka d = new ka(1061109759);
    public static final ka e = new ka(0.0f, 0.0f, 0.0f, 1.0f);
    public static final float f = a.b();
    public static final ka g = new ka(0.0f, 0.0f, 0.0f, 0.0f);
    public static final ka h = new ka(0.0f, 0.0f, 1.0f, 1.0f);
    public static final ka i = new ka(0.0f, 0.0f, 0.5f, 1.0f);
    public static final ka j = new ka(1097458175);
    public static final ka k = new ka(1887473919);
    public static final ka l = new ka(-2016482305);
    public static final ka m = new ka(0.0f, 1.0f, 1.0f, 1.0f);
    public static final ka n = new ka(0.0f, 0.5f, 0.5f, 1.0f);
    public static final ka o = new ka(16711935);
    public static final ka p = new ka(2147418367);
    public static final ka q = new ka(852308735);
    public static final ka r = new ka(579543807);
    public static final ka s = new ka(1804477439);
    public static final ka t = new ka(-65281);
    public static final ka u = new ka(-2686721);
    public static final ka v = new ka(-626712321);
    public static final ka w = new ka(-5963521);
    public static final ka x = new ka(-1958407169);
    public static final ka y = new ka(-759919361);
    public static final ka z = new ka(-1306385665);
    public static final ka A = new ka(-16776961);
    public static final ka B = new ka(-13361921);
    public static final ka C = new ka(-8433409);
    public static final ka D = new ka(-92245249);
    public static final ka E = new ka(-9849601);
    public static final ka F = new ka(1.0f, 0.0f, 1.0f, 1.0f);
    public static final ka G = new ka(-1608453889);
    public static final ka H = new ka(-293409025);
    public static final ka I = new ka(-1339006721);

    public static int c(float f2, float f3, float f4, float f5) {
        return (((int) (f2 * 255.0f)) << 24) | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 8) | ((int) (f5 * 255.0f));
    }

    public ka() {
    }

    public ka(int i2) {
        a(this, i2);
    }

    public ka(float f2, float f3, float f4, float f5) {
        this.J = f2;
        this.K = f3;
        this.L = f4;
        this.M = f5;
        a();
    }

    public ka(ka kaVar) {
        a(kaVar);
    }

    public ka a(ka kaVar) {
        this.J = kaVar.J;
        this.K = kaVar.K;
        this.L = kaVar.L;
        this.M = kaVar.M;
        return this;
    }

    public ka b(ka kaVar) {
        this.J *= kaVar.J;
        this.K *= kaVar.K;
        this.L *= kaVar.L;
        this.M *= kaVar.M;
        return a();
    }

    public ka a() {
        float f2 = this.J;
        if (f2 < 0.0f) {
            this.J = 0.0f;
        } else if (f2 > 1.0f) {
            this.J = 1.0f;
        }
        float f3 = this.K;
        if (f3 < 0.0f) {
            this.K = 0.0f;
        } else if (f3 > 1.0f) {
            this.K = 1.0f;
        }
        float f4 = this.L;
        if (f4 < 0.0f) {
            this.L = 0.0f;
        } else if (f4 > 1.0f) {
            this.L = 1.0f;
        }
        float f5 = this.M;
        if (f5 < 0.0f) {
            this.M = 0.0f;
        } else if (f5 > 1.0f) {
            this.M = 1.0f;
        }
        return this;
    }

    public ka a(float f2, float f3, float f4, float f5) {
        this.J = f2;
        this.K = f3;
        this.L = f4;
        this.M = f5;
        return a();
    }

    public ka a(int i2) {
        a(this, i2);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && c() == ((ka) obj).c();
    }

    public int hashCode() {
        float f2 = this.J;
        int a2 = (f2 != 0.0f ? t.a(f2) : 0) * 31;
        float f3 = this.K;
        int a3 = (a2 + (f3 != 0.0f ? t.a(f3) : 0)) * 31;
        float f4 = this.L;
        int a4 = (a3 + (f4 != 0.0f ? t.a(f4) : 0)) * 31;
        float f5 = this.M;
        return a4 + (f5 != 0.0f ? t.a(f5) : 0);
    }

    public float b() {
        return t.a((((int) (this.M * 255.0f)) << 24) | (((int) (this.L * 255.0f)) << 16) | (((int) (this.K * 255.0f)) << 8) | ((int) (this.J * 255.0f)));
    }

    public int c() {
        return (((int) (this.M * 255.0f)) << 24) | (((int) (this.L * 255.0f)) << 16) | (((int) (this.K * 255.0f)) << 8) | ((int) (this.J * 255.0f));
    }

    public String toString() {
        String hexString = Integer.toHexString((((int) (this.J * 255.0f)) << 24) | (((int) (this.K * 255.0f)) << 16) | (((int) (this.L * 255.0f)) << 8) | ((int) (this.M * 255.0f)));
        while (hexString.length() < 8) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    public static ka a(String str) {
        if (str.charAt(0) == '#') {
            str = str.substring(1);
        }
        return new ka(Integer.valueOf(str.substring(0, 2), 16).intValue() / 255.0f, Integer.valueOf(str.substring(2, 4), 16).intValue() / 255.0f, Integer.valueOf(str.substring(4, 6), 16).intValue() / 255.0f, (str.length() != 8 ? 255 : Integer.valueOf(str.substring(6, 8), 16).intValue()) / 255.0f);
    }

    public static float b(float f2, float f3, float f4, float f5) {
        return t.a(((int) (f2 * 255.0f)) | (((int) (f3 * 255.0f)) << 8) | (((int) (f4 * 255.0f)) << 16) | (((int) (f5 * 255.0f)) << 24));
    }

    public static void a(ka kaVar, int i2) {
        kaVar.J = (((-16777216) & i2) >>> 24) / 255.0f;
        kaVar.K = ((16711680 & i2) >>> 16) / 255.0f;
        kaVar.L = ((65280 & i2) >>> 8) / 255.0f;
        kaVar.M = (i2 & 255) / 255.0f;
    }

    public static void a(ka kaVar, float f2) {
        int c2 = t.c(f2);
        kaVar.M = (((-16777216) & c2) >>> 24) / 255.0f;
        kaVar.L = ((16711680 & c2) >>> 16) / 255.0f;
        kaVar.K = ((65280 & c2) >>> 8) / 255.0f;
        kaVar.J = (c2 & 255) / 255.0f;
    }
}
