package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.FileUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import defpackage.wh;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: BugHunter.java */
/* renamed from: wc  reason: default package */
/* loaded from: classes.dex */
public class wc {
    private static boolean a;

    public static void a(Context context) {
        a(context, false, true, false);
    }

    public static void a(Context context, boolean z, boolean z2, boolean z3) {
        try {
            b(context.getApplicationContext(), z, z2, z3);
            Module.register(vi.class, new vi(context));
            Module.get(vi.class).get(IDataLog.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void b(final Context context, boolean z, boolean z2, boolean z3) {
        long j = 400;
        long j2 = 100;
        if (BuildInfoUtils.isUserVersion()) {
            j = 60000;
            j2 = 1000;
        } else if (z) {
            j = 100;
        } else if (new File("/sdcard/Log/catonflag").exists()) {
            j = 100;
        } else {
            j2 = 400;
        }
        if (z3) {
            a = true;
        } else if (new File("/sdcard/Log/catondumpflag").exists()) {
            a = true;
        }
        wh.a(new wh.a(context.getApplicationContext()).a(wh.c.LOOPER).a(z2).b(j).a(j2).a(new wh.b() { // from class: wc.1
            /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00ec  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // defpackage.wh.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.lang.String[] r16, boolean r17, long... r18) {
                /*
                    Method dump skipped, instructions count: 269
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.AnonymousClass1.a(java.lang.String[], boolean, long[]):void");
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        int indexOf = str.indexOf("\n");
        if (indexOf > 0) {
            str = str.substring(indexOf + 1);
        }
        return we.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str, String str2, long j, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(IStatEvent.CUSTOM_EVENT, "perf_caton");
            jSONObject.putOpt(IStatEvent.CUSTOM_MODULE, "perf");
            jSONObject.putOpt(IStatEvent.CUSTOM_DEVICE_MCUVER, wm.a());
            jSONObject.putOpt(IStatEvent.CUSTOM_MODULE_VERSION, str2);
            jSONObject.putOpt(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
            jSONObject.putOpt(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt(IStatEvent.CUSTOM_NETWORK, wm.a(context));
            jSONObject.putOpt("appName", str);
            jSONObject.putOpt("appVer", str2);
            jSONObject.putOpt("anr", false);
            jSONObject.putOpt("elapseTime", Long.valueOf(j));
            jSONObject.putOpt("md5", str3);
            jSONObject.putOpt("stackInfo", str4);
            return jSONObject.toString();
        } catch (Throwable th) {
            Log.e("libBugHunter", "error in function getJsonCatonLog, " + th.getMessage());
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, Context context, String str2, String[] strArr, long j, long j2) {
        long j3;
        long j4;
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer("");
        long j5 = 0;
        if (context != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j6 = memoryInfo.availMem / FileUtils.SIZE_1MB;
            j4 = memoryInfo.totalMem / FileUtils.SIZE_1MB;
            j3 = memoryInfo.threshold / FileUtils.SIZE_1MB;
            stringBuffer.append("availMem:");
            stringBuffer.append(j6);
            stringBuffer.append("totalMem:");
            stringBuffer.append(j4);
            stringBuffer.append("threshold:");
            stringBuffer.append(j3);
            j5 = j6;
        } else {
            j3 = 0;
            j4 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n----------------caton log [ ");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        sb.append(" ]");
        for (int length = strArr.length - 1; length >= 0; length--) {
            String str3 = strArr[length];
            sb.append("\n");
            sb.append(str3);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        try {
            jSONObject.put("md5", str);
            jSONObject.put("pkgName", str2);
            jSONObject.put("time", simpleDateFormat.format(Calendar.getInstance().getTime()));
            jSONObject.put("ElapseTime", j);
            jSONObject.put("threadElapseTime", j2);
            jSONObject.put("availMem", j5);
            jSONObject.put("totalMem", j4);
            jSONObject.put("threshold", j3);
            jSONObject.put("catonLog", sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        wj.a("libBugHunter", jSONObject.toString());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L4d
            boolean r1 = r0.mkdirs()
            if (r1 == 0) goto L46
            r1 = 0
            r2 = 1
            boolean r3 = r0.setReadable(r2, r1)
            boolean r4 = r0.setWritable(r2, r1)
            boolean r0 = r0.setExecutable(r2, r1)
            java.lang.String r1 = "libBugHunter"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "caton LogDir setReadable: "
            r2.append(r5)
            r2.append(r3)
            java.lang.String r3 = "; setWritable: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = "; setExecutable: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaopeng.lib.utils.LogUtils.d(r1, r0)
            goto L4d
        L46:
            java.lang.String r0 = "libBugHunter"
            java.lang.String r1 = "make caton LogDir failed"
            com.xiaopeng.lib.utils.LogUtils.w(r0, r1)
        L4d:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = "/"
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = ".log"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            r7 = 0
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L94
            java.lang.String r1 = "rw"
            r8.<init>(r0, r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L94
            long r0 = r8.length()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9f
            r8.seek(r0)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9f
            r8.write(r9)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9f
            java.lang.String r7 = "\n\n"
            r8.writeBytes(r7)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9f
            java.io.FileDescriptor r7 = r8.getFD()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9f
            r7.sync()     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L9f
        L89:
            r8.close()     // Catch: java.lang.Exception -> L9e
            goto L9e
        L8d:
            r7 = move-exception
            goto L98
        L8f:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto La0
        L94:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L98:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9f
            if (r8 == 0) goto L9e
            goto L89
        L9e:
            return
        L9f:
            r7 = move-exception
        La0:
            if (r8 == 0) goto La5
            r8.close()     // Catch: java.lang.Exception -> La5
        La5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.b(java.lang.String, java.lang.String, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str) {
        PackageInfo c = c(context, str);
        return c == null ? "" : c.versionName;
    }

    private static PackageInfo c(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (str == null) {
                str = context.getPackageName();
            }
            return packageManager.getPackageInfo(str, 16384);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
