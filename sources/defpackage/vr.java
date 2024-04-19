package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaopeng.datalog.bean.LogEvent;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.lib.utils.DateUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.ZipUtils;
import com.xiaopeng.lib.utils.crypt.AESUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import defpackage.wd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: DataCollectorHelper.java */
/* renamed from: vr  reason: default package */
/* loaded from: classes.dex */
public class vr {
    public static final String a;
    public static final String b;
    private static volatile vr c;
    private wd d;
    private Context e;
    private final List<String> f = new CopyOnWriteArrayList();
    private final List<Map<String, Object>> g = new CopyOnWriteArrayList();
    private Gson h = new Gson();
    private Handler i = new Handler(ThreadUtils.getLooper(0), new Handler.Callback() { // from class: vr.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    LogUtils.v("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CAN");
                    vr.this.e();
                    return true;
                case 2:
                    LogUtils.d("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CDU");
                    vr.this.f();
                    return true;
                case 3:
                    LogUtils.d("DataCollectorHelper", "handleMessage MESSAGE_CHECK_CONNECTION");
                    if (vr.this.d == null) {
                        vr.this.d();
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
    });
    private ServiceConnection j = new ServiceConnection() { // from class: vr.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtils.d("DataCollectorHelper", "onServiceConnected");
            vr.this.d = wd.a.a(iBinder);
            IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: vr.2.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    if (vr.this.d == null) {
                        return;
                    }
                    vr.this.d.asBinder().unlinkToDeath(this, 0);
                    vr.this.d = null;
                    vr.this.d();
                }
            };
            try {
                if (vr.this.d == null) {
                    return;
                }
                vr.this.d.asBinder().linkToDeath(deathRecipient, 0);
            } catch (RemoteException e) {
                LogUtils.w("DataCollectorHelper", "RemoteException occurs when reLink to Service, exception:", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.d("DataCollectorHelper", "onServiceDisconnected");
            vr.this.d = null;
            vr.this.d();
        }
    };

    static {
        a = BuildInfoUtils.isLanVersion() ? "xp-log-local" : "xp-log";
        b = "http://" + a + ".oss-cn-hangzhou.aliyuncs.com/";
    }

    private vr() {
    }

    public static vr a() {
        if (c == null) {
            synchronized (vr.class) {
                if (c == null) {
                    c = new vr();
                }
            }
        }
        return c;
    }

    public void a(Context context) {
        this.e = context;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Intent intent = new Intent("com.xiaopeng.service.DATA_SERVICE");
        intent.setPackage("com.xiaopeng.data.uploader");
        this.e.startServiceAsUser(intent, UserHandle.CURRENT);
        this.e.bindServiceAsUser(intent, this.j, 1, UserHandle.CURRENT);
        if (this.i.hasMessages(3)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(3, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r4) {
        /*
            r3 = this;
            wd r0 = r3.d
            if (r0 == 0) goto L1c
            r0.a(r4)     // Catch: android.os.RemoteException -> L14
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r3.g     // Catch: android.os.RemoteException -> L14
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L14
            if (r0 <= 0) goto L12
            r3.f()     // Catch: android.os.RemoteException -> L14
        L12:
            r0 = 1
            goto L1d
        L14:
            r0 = move-exception
            java.lang.String r1 = "DataCollectorHelper"
            java.lang.String r2 = "uploadCdu error!"
            com.xiaopeng.lib.utils.LogUtils.w(r1, r2, r0)
        L1c:
            r0 = 0
        L1d:
            if (r0 != 0) goto L33
            com.google.gson.Gson r0 = r3.h
            vr$3 r1 = new vr$3
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r4 = r0.fromJson(r4, r1)
            java.util.Map r4 = (java.util.Map) r4
            r3.a(r4)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vr.a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            wd r0 = r2.d
            if (r0 == 0) goto L18
            r0.a(r3, r4)     // Catch: android.os.RemoteException -> L14
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r2.g     // Catch: android.os.RemoteException -> L14
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L14
            if (r0 <= 0) goto L12
            r2.f()     // Catch: android.os.RemoteException -> L14
        L12:
            r0 = 1
            goto L19
        L14:
            r0 = move-exception
            r0.printStackTrace()
        L18:
            r0 = 0
        L19:
            if (r0 != 0) goto L53
            java.lang.Class<vi> r0 = defpackage.vi.class
            com.xiaopeng.lib.framework.module.IModuleEntry r0 = com.xiaopeng.lib.framework.module.Module.get(r0)
            java.lang.Class<com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog> r1 = com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog.class
            java.lang.Object r0 = r0.get(r1)
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog r0 = (com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog) r0
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r0 = r0.buildStat()
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r3 = r0.setEventName(r3)
            java.lang.String r0 = "data"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r3 = r3.setProperty(r0, r4)
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent r3 = r3.build()
            java.lang.String r3 = r3.toJson()
            com.google.gson.Gson r4 = r2.h
            vr$4 r0 = new vr$4
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.Object r3 = r4.fromJson(r3, r0)
            java.util.Map r3 = (java.util.Map) r3
            r2.a(r3)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vr.a(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r5) {
        /*
            r4 = this;
            wd r0 = r4.d
            r1 = 1
            if (r0 == 0) goto L19
            r0.b(r5)     // Catch: android.os.RemoteException -> L15
            java.util.List<java.lang.String> r0 = r4.f     // Catch: android.os.RemoteException -> L15
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L15
            if (r0 <= 0) goto L13
            r4.e()     // Catch: android.os.RemoteException -> L15
        L13:
            r0 = r1
            goto L1a
        L15:
            r0 = move-exception
            r0.printStackTrace()
        L19:
            r0 = 0
        L1a:
            if (r0 != 0) goto L3f
            java.util.List<java.lang.String> r0 = r4.f
            r0.add(r5)
            java.util.List<java.lang.String> r5 = r4.f
            int r5 = r5.size()
            r0 = 20
            if (r5 < r0) goto L2f
            r4.e()
            goto L3f
        L2f:
            android.os.Handler r5 = r4.i
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto L3f
            android.os.Handler r5 = r4.i
            r2 = 60000(0xea60, double:2.9644E-319)
            r5.sendEmptyMessageDelayed(r1, r2)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vr.b(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f.isEmpty()) {
            LogUtils.d("DataCollectorHelper", "mCanDataCache.isEmpty(), return!");
            return;
        }
        vo.a().a("candata", ZipUtils.compressForGzipAndBase64NoWrap(h()), this.e);
        this.i.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.g.isEmpty()) {
            LogUtils.d("DataCollectorHelper", "mCduDataCache.isEmpty(), return!");
        }
        vo.a().a("cdudata", ZipUtils.compressForGzipAndBase64NoWrap(i()), this.e);
        this.i.removeMessages(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            wd r0 = r1.d
            if (r0 == 0) goto L11
            r0.b(r2, r3)     // Catch: android.os.RemoteException -> L9
            r2 = 1
            goto L12
        L9:
            r2 = move-exception
            java.lang.String r3 = "DataCollectorHelper"
            java.lang.String r0 = "uploadLogImmediately error!"
            com.xiaopeng.lib.utils.LogUtils.w(r3, r0, r2)
        L11:
            r2 = 0
        L12:
            if (r2 != 0) goto L1b
            java.lang.String r2 = "DataCollectorHelper"
            java.lang.String r3 = "uploadLogImmediately fail and ignore!"
            com.xiaopeng.lib.utils.LogUtils.w(r2, r3)
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vr.b(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final vl vlVar, final List<String> list) {
        final String[] g = g();
        ThreadUtils.postBackground(new Runnable() { // from class: vr.5
            @Override // java.lang.Runnable
            public void run() {
                vr.this.a(g[1], list);
                vlVar.put("address", g[0]);
                String json = vlVar.toJson();
                ArrayList arrayList = new ArrayList();
                arrayList.add(g[1].replace(".zip", "_en.zip"));
                vr.this.a(json);
                vr.this.a(arrayList);
            }
        });
    }

    private String[] g() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = a + "/log/" + BuildInfoUtils.getSystemVersion() + "/" + DateUtils.formatDate7(currentTimeMillis) + "/" + SystemPropertyUtil.getVehicleId();
        return new String[]{a(currentTimeMillis, str), b(currentTimeMillis, str)};
    }

    private String a(long j, String str) {
        return b + (str.substring(str.indexOf("/") + 1) + "/" + j + "_en.zip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list) {
        File file;
        try {
            file = ZipUtils.zipMultiFiles(str, list);
        } catch (IOException e) {
            e.printStackTrace();
            file = null;
        }
        a(file, AESUtils.encrypt(file, new File(str.replace(".zip", "_en.zip")), "@!chxpzi#0109$+/"));
    }

    private String b(long j, String str) {
        String str2 = "/sdcard/Log/upload-zip/" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + "/" + j + ".zip";
    }

    private void a(File file, boolean z) {
        if (z) {
            try {
                file.delete();
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<String> list) {
        wd wdVar = this.d;
        if (wdVar != null) {
            try {
                wdVar.a(list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private String h() {
        LogEvent create = LogEvent.create(LogEvent.a.CAN);
        try {
            create.setV(Integer.valueOf(SystemPropertyUtil.getDBCVersion()).intValue());
        } catch (Exception e) {
            LogUtils.w("DataCollectorHelper", "parse dbcVersion error!", e);
            create.setV(0);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(Constants.DATA, this.h.toJson(this.f));
        this.f.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(jsonObject);
        create.setMsg(arrayList);
        String json = this.h.toJson(create);
        arrayList.clear();
        return json;
    }

    private void a(Map<String, Object> map) {
        this.g.add(map);
        if (this.g.size() >= 20) {
            f();
        } else if (this.i.hasMessages(2)) {
        } else {
            this.i.sendEmptyMessageDelayed(2, 60000L);
        }
    }

    private String i() {
        LogEvent create = LogEvent.create(LogEvent.a.CDU);
        try {
            create.setV(Integer.valueOf(SystemPropertyUtil.getDBCVersion()).intValue());
        } catch (Exception e) {
            LogUtils.w("DataCollectorHelper", "parse dbcVersion error!", e);
            create.setV(0);
        }
        ArrayList arrayList = new ArrayList(this.g);
        this.g.clear();
        create.setMsg(arrayList);
        return this.h.toJson(create);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        final String str = g()[0];
        ThreadUtils.postBackground(new Runnable() { // from class: vr.6
            @Override // java.lang.Runnable
            public void run() {
                if (vr.this.b()) {
                    vr.this.c(str);
                } else {
                    ThreadUtils.postBackground(new Runnable() { // from class: vr.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            vr.this.c(str);
                        }
                    }, 1000L);
                }
            }
        });
        return str;
    }

    void c(String str) {
        wd wdVar = this.d;
        if (wdVar != null) {
            try {
                wdVar.c(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
