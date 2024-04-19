package defpackage;

import android.text.TextUtils;
/* compiled from: SpeechUtils.java */
/* renamed from: yu  reason: default package */
/* loaded from: classes.dex */
public class yu {
    public static void a(String str, boolean z) {
        a(str, z, "");
    }

    public static void a(String str, boolean z, String str2) {
        abd abdVar = new abd();
        abdVar.a(z);
        abdVar.a(str2);
        wz.b().c().a(new xj(str).a(abdVar));
    }

    public static <T extends xa> T a(Class<T> cls) {
        return (T) wz.b().l().a(cls);
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith("}")) {
                return true;
            }
            if (trim.startsWith("[") && trim.endsWith("]")) {
                return true;
            }
        }
        return false;
    }
}
