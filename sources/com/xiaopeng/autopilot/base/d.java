package com.xiaopeng.autopilot.base;

import android.car.Car;
import android.os.SystemProperties;
import android.util.Log;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.xui.app.XToast;
/* compiled from: Constant.java */
/* loaded from: classes.dex */
public class d extends b {
    public static final int i = h.j.CustomXDialog;
    public static final boolean j = f();
    public static final float k;
    public static final String l;
    public static final String m;
    public static boolean n;
    public static boolean o;
    public static boolean p;
    public static boolean q;
    public static p r;
    public static p s;
    public static p t;
    public static p u;
    public static p v;
    public static p w;
    public static p x;
    public static p y;

    public static void e(int i2) {
    }

    public static boolean k() {
        return true;
    }

    public static int m() {
        return 0;
    }

    static {
        k = h() ? 1.0f : 0.4f;
        l = Car.getXpCduType().equalsIgnoreCase("Q3A") ? "model/entity/D55a_model.g3db" : "model/entity/car_model_d55.g3db";
        m = Car.getXpCduType().equalsIgnoreCase("Q3A") ? "model/entity/D55a_model.g3db" : "model/entity/car_model_d55.g3db";
        n = true;
        o = true;
        p = true;
        q = true;
        r = new p(0.0f, 8.975764f, 29.346453f);
        s = new p(0.0f, -0.28032845f, -0.97895336f);
        t = new p(12.659683f, 12.794575f, 15.475358f);
        u = new p(-0.6414108f, -0.5610344f, -0.9024883f);
        v = new p(-0.41380954f, 0.9829477f, -0.36591277f);
        w = new p(12.659683f, 12.794575f, 15.475358f);
        x = new p(-0.6414108f, -0.5610344f, -0.9024883f);
        y = new p(-0.41380954f, 0.9829477f, -0.36591277f);
    }

    public static boolean f() {
        return i() == 1;
    }

    public static boolean g() {
        return i() == 2;
    }

    public static boolean h() {
        return i() == 3;
    }

    public static int i() {
        if (SystemProperties.getInt("persist.sys.xiaopeng.XPU", 0) == 1) {
            return 3;
        }
        return (SystemProperties.getInt("persist.sys.xiaopeng.SCU", 0) == 1 && SystemProperties.getInt("persist.sys.xiaopeng.AVM", 0) == 1) ? 2 : 1;
    }

    public static boolean j() {
        return SystemProperties.getInt("persist.sys.xiaopeng.Lidar_F", 0) == 1 || SystemProperties.getInt("persist.sys.xiaopeng.Lidar_R", 0) == 1;
    }

    public static int l() {
        return SystemProperties.getInt("persist.sys.xiaopeng.bodyColor", -1);
    }

    public static void a(String str) {
        XToast.showShort(str);
    }

    public static boolean n() {
        return h() && a.g().getResources().getBoolean(h.b.IS_ENABLE_XPILOT_3);
    }

    public static String o() {
        int l2 = l();
        boolean equalsIgnoreCase = Car.getXpCduType().equalsIgnoreCase("Q3A");
        String str = a;
        Log.i(str, "updateTextureMaterial.bodyColor = " + l2);
        switch (l2) {
            case 1:
                return "model/entity/D55_Red.jpg";
            case 2:
                return "model/entity/D55_White.jpg";
            case 3:
                return equalsIgnoreCase ? "model/entity/d55a_black.jpg" : "model/entity/D55_Black.jpg";
            case 4:
                return equalsIgnoreCase ? "model/entity/d55a_gray.jpg" : "model/entity/D55_Gray.jpg";
            case 5:
            case 6:
            case 7:
            case 9:
            case 11:
            default:
                return "model/entity/D55_Purple.jpg";
            case 8:
                return "model/entity/D55_Purple.jpg";
            case 10:
                return "model/entity/D55_Green.jpg";
            case 12:
                return equalsIgnoreCase ? "model/entity/d55a_white.jpg" : "model/entity/D55_White.jpg";
            case 13:
                return "model/entity/d55a_green.jpg";
            case 14:
                return "model/entity/d55a_silver.jpg";
        }
    }
}
