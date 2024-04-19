package defpackage;

import android.os.SystemProperties;
/* compiled from: CarTypeUtils.java */
/* renamed from: aak  reason: default package */
/* loaded from: classes.dex */
public class aak {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a() {
        char c;
        String str = c() + b();
        xx.a("CarTypeUtils", "isOverseasCarType, carType: " + str);
        switch (str.hashCode()) {
            case 64338291:
                if (str.equals("D21EU")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 64339252:
                if (str.equals("D22EU")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 64431508:
                if (str.equals("D55EU")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 65268539:
                if (str.equals("E28EU")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 65298330:
                if (str.equals("E38EU")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    private static String b() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return ("".equals(str) || str == null) ? str : str.substring(7, 9);
    }

    private static String c() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return ("".equals(str) || str == null) ? str : str.substring(9, 12);
    }
}
