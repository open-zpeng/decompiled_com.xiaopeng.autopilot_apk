package defpackage;

import org.json.JSONObject;
/* compiled from: CardValue.java */
/* renamed from: yw  reason: default package */
/* loaded from: classes.dex */
public class yw {
    private double a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public static yw a(String str) {
        yw ywVar = new yw();
        try {
            ywVar.a = new JSONObject(str).optDouble("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw b(String str) {
        yw ywVar = new yw();
        try {
            ywVar.b = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw c(String str) {
        yw ywVar = new yw();
        try {
            ywVar.c = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw d(String str) {
        yw ywVar = new yw();
        try {
            ywVar.d = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw e(String str) {
        yw ywVar = new yw();
        try {
            ywVar.e = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw f(String str) {
        yw ywVar = new yw();
        try {
            ywVar.f = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw g(String str) {
        yw ywVar = new yw();
        try {
            ywVar.g = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public static yw h(String str) {
        yw ywVar = new yw();
        try {
            ywVar.h = new JSONObject(str).optInt("current");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywVar;
    }

    public String toString() {
        return "CardValue{acWindLv='" + this.a + "', acWindLv=" + this.b + ", atmosphereBrightness=" + this.c + ", atmosphereColor=" + this.d + ", acSeatHeatingLv=" + this.e + ", acSeatVentilateLv=" + this.f + ", screenBrightness=" + this.g + ", icmBrightness=" + this.h + '}';
    }
}
