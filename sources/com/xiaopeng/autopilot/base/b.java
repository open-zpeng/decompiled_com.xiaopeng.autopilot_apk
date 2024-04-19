package com.xiaopeng.autopilot.base;

import android.car.Car;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
/* compiled from: BaseConstant.java */
/* loaded from: classes.dex */
public class b {
    public static final String a = d.class.getSimpleName();
    public static boolean b = false;
    public static String c = "0";
    public static String d = BuildInfoUtils.BID_WAN;
    public static volatile boolean e = true;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;

    public static String a(int i) {
        switch (i) {
            case 0:
                return "清楚所有数据，倒车";
            case 1:
                return "自动泊车准备就绪,点击开始";
            case 2:
                return "请松开刹车开始泊车,点击取消";
            case 3:
                return "自动泊车进行中";
            case 4:
                return "泊车暂停";
            case 5:
                return "自动泊车已退出";
            case 6:
                return "自动泊车已完成";
            case 7:
                return "自动泊车已取消";
            case 8:
                return "自动泊出进行中";
            case 9:
                return "泊出暂停";
            case 10:
                return "自动泊出已取消";
            case 11:
                return "自动泊出已完成";
            case 12:
                return "请松开刹车开始自动泊出，点击取消";
            case 13:
                return "自动泊车暂停，点击恢复泊车";
            case 14:
                return "自动泊出暂停，点击恢复泊出";
            case 15:
                return "自动泊出准备就绪，点击开始";
            case 16:
                return "无提示语，无按钮,进入钥匙泊车模式";
            case 17:
                return "不清除数据，倒车";
            case 18:
                return "超级泊车模式，请降低车速";
            case 19:
                return "超级泊车模式，车位搜索中";
            case 20:
                return "超级泊车模式，已经找到可泊车位";
            case 21:
                return "超级泊车模式，SCU判断当前出现超级泊车异常";
            case 22:
                return "超级泊车模式，车速为0，提示用户开始泊车";
            case 23:
                return "超级泊车模式，车速为0，提示用户踩刹车";
            case 24:
                return "找到车位停下后R挡，刹车松掉，速度>0，溜车";
            case 25:
                return "坡度过大 25";
            case 26:
                return "已暂停，如需恢复可松开刹车";
            case 27:
                return "倒车中，请注意周围环境安全";
            default:
                switch (i) {
                    case 33:
                        return "请注意后方有剐蹭风险";
                    case 34:
                        return "继续向前行驶，探索该车位";
                    case 35:
                        return "车位内有障碍物，换一个车位试试吧";
                    case 36:
                        return "找到车位停下后D挡，刹车松掉，速度>0，溜车";
                    default:
                        return "";
                }
        }
    }

    public static boolean b(int i) {
        return i >= 21 && i <= 30;
    }

    public static boolean c(int i) {
        return i >= 1 && i <= 20;
    }

    public static int d(int i) {
        if (i == 0) {
            return 0;
        }
        return (i == 2 || i == 3 || i == 34 || i == 4 || i == 5 || i == 35 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 26 || i == 33 || i == 15) ? 2 : 1;
    }

    public static boolean a() {
        String str = SystemProperties.get("persist.sys.auto_park_warning");
        if (d.equals(str) || TextUtils.isEmpty(str)) {
            return true;
        }
        return c.equals(str) ? false : false;
    }

    public static void a(boolean z) {
        if (z) {
            SystemProperties.set("persist.sys.auto_park_warning", d);
        } else {
            SystemProperties.set("persist.sys.auto_park_warning", c);
        }
    }

    public static boolean b() {
        return SystemProperties.getBoolean("persist.sys.auto_park_hold", false);
    }

    public static void b(boolean z) {
        SystemProperties.set("persist.sys.auto_park_hold", String.valueOf(z));
    }

    public static boolean c() {
        return f;
    }

    public static boolean d() {
        int i = Settings.System.getInt(a.g().getContentResolver(), "psn_srs_enable", 1);
        String str = a;
        LogUtils.i(str, "psn_srs_enable = " + i);
        return i == 1;
    }

    public static boolean e() {
        try {
            return !Car.getVersionInCountryCode().contains("ZH");
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
