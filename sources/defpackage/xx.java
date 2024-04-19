package defpackage;

import android.app.ActivityThread;
import android.util.Log;
/* compiled from: LogUtils.java */
/* renamed from: xx  reason: default package */
/* loaded from: classes.dex */
public class xx {
    public static int a = 2;
    public static String b = b();
    public static b c = new a();
    public static boolean d = true;

    /* compiled from: LogUtils.java */
    /* renamed from: xx$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, String str2, String str3);
    }

    public static boolean a() {
        return d;
    }

    public static boolean a(int i) {
        return a <= i && a();
    }

    public static void a(Object obj, String str) {
        if (a(3)) {
            a(3, obj, str, (Throwable) null, true);
        }
    }

    public static void a(Object obj, String str, Object... objArr) {
        if (a(3)) {
            a(3, obj, String.format(str, objArr), (Throwable) null, true);
        }
    }

    public static void a(String str) {
        if (a(4)) {
            a(4, (Object) null, str, (Throwable) null, true);
        }
    }

    public static void b(Object obj, String str) {
        if (a(4)) {
            a(4, obj, str, (Throwable) null, true);
        }
    }

    public static void b(Object obj, String str, Object... objArr) {
        if (a(4)) {
            a(4, obj, String.format(str, objArr), (Throwable) null, true);
        }
    }

    public static void b(String str) {
        if (a(6)) {
            a(6, (Object) null, str, (Throwable) null, true);
        }
    }

    public static void c(Object obj, String str) {
        if (a(6)) {
            a(6, obj, str, (Throwable) null, true);
        }
    }

    public static void a(Object obj, String str, Throwable th) {
        if (a(6)) {
            a(6, obj, str, th, true);
        }
    }

    public static void a(Object obj, Throwable th) {
        if (a(6)) {
            a(6, obj, "Exception occurs at", th, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(int r5, java.lang.Object r6, java.lang.String r7, java.lang.Throwable r8, boolean r9) {
        /*
            java.lang.String r0 = ""
            if (r9 == 0) goto L20
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            r2 = 0
            if (r1 == 0) goto L15
            int r3 = r1.length
            r4 = 4
            if (r3 <= r4) goto L15
            r2 = r1[r4]
        L15:
            if (r2 == 0) goto L20
            java.lang.String r0 = r2.getFileName()
            int r1 = r2.getLineNumber()
            goto L21
        L20:
            r1 = 0
        L21:
            java.lang.String r7 = a(r0, r1, r7, r8, r9)
            java.lang.String r6 = a(r6)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L30
            r6 = r0
        L30:
            a(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xx.a(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }

    private static void a(int i, String str, String str2) {
        c.a(i, str2, str, null);
    }

    private static String a(String str, int i, String str2, Throwable th, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (z) {
            sb.append("(T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (b != null) {
                sb.append("(C:");
                sb.append(b);
                sb.append(")");
            }
            sb.append("at (");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(")");
        }
        if (th != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Class) {
            return ((Class) obj).getSimpleName();
        }
        return obj.getClass().getSimpleName();
    }

    /* compiled from: LogUtils.java */
    /* renamed from: xx$a */
    /* loaded from: classes.dex */
    private static class a implements b {
        private a() {
        }

        @Override // defpackage.xx.b
        public void a(int i, String str, String str2, String str3) {
            switch (i) {
                case 2:
                    Log.v(str2, str);
                    return;
                case 3:
                    Log.d(str2, str);
                    String str4 = "DEBUG: " + str;
                    return;
                case 4:
                    Log.i(str2, str);
                    String str5 = "INFO: " + str;
                    return;
                case 5:
                    Log.w(str2, str);
                    String str6 = "WARN: " + str;
                    return;
                case 6:
                    Log.e(str2, str);
                    String str7 = "ERROR: " + str;
                    return;
                default:
                    return;
            }
        }
    }

    private static String b() {
        String[] split = ActivityThread.currentApplication().getPackageName().split("\\.");
        return split[split.length - 1];
    }
}
