package com.xiaopeng.autopilot;

import android.content.pm.PackageInfo;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.parking.c;
import com.xiaopeng.lib.utils.LogUtils;
/* compiled from: BaseApp.java */
/* loaded from: classes.dex */
public abstract class b extends com.xiaopeng.autopilot.base.a {
    private a d;
    private Runnable e = new Runnable() { // from class: com.xiaopeng.autopilot.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("AutopilotApp", "mKillTask.run");
            Process.killProcess(Process.myPid());
        }
    };

    @Override // com.xiaopeng.autopilot.base.a, android.app.Application
    public void onCreate() {
        super.onCreate();
        LogUtils.i("AutopilotApp", "当前GIT_COMMIT_ID = b022d8b6433aadf2bdf09e1171786ddb35862533");
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            LogUtils.i("AutopilotApp", "versionName = " + packageInfo.versionName + " , versionCode = " + packageInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rd.a();
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.XPU = " + SystemProperties.getInt("persist.sys.xiaopeng.XPU", 0));
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.SCU = " + SystemProperties.getInt("persist.sys.xiaopeng.SCU", 0));
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.AVM = " + SystemProperties.getInt("persist.sys.xiaopeng.AVM", 0));
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.configCode = " + SystemProperties.getInt("persist.sys.xiaopeng.configCode", 0));
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.cfcIndex = " + SystemProperties.getInt("persist.sys.xiaopeng.cfcIndex", 0));
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.cfcIndex1 = " + SystemProperties.getInt("persist.sys.xiaopeng.cfcIndex1", 0));
        LogUtils.i("AutopilotApp", "persist.sys.auto_park_warning = " + SystemProperties.get("persist.sys.auto_park_warning"));
        LogUtils.i("AutopilotApp", "persist.sys.auto_park_hold = " + SystemProperties.get("persist.sys.auto_park_hold"));
        LogUtils.i("AutopilotApp", "persist.sys.xiaopeng.camera.module = " + SystemProperties.getInt("persist.sys.xiaopeng.camera.module", 0));
        if (d.h()) {
            LogUtils.i("AutopilotApp", "泊车Config = 高");
        } else if (d.g()) {
            LogUtils.i("AutopilotApp", "泊车Config = 中");
        } else if (d.f()) {
            LogUtils.i("AutopilotApp", "泊车Config = 低");
        } else {
            LogUtils.i("AutopilotApp", "泊车Config = 未知");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        return rf.a(this).b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        rf.a(this).a(z);
    }

    @Override // com.xiaopeng.autopilot.base.a
    protected void b() {
        this.d = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.base.a
    public void c() {
        if (d.n()) {
            c.d(1);
        }
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.base.a
    public void d() {
        if (d.n()) {
            c.d(0);
        }
        this.d.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        Log.i("AutopilotApp", "delayKillProcess");
        rh.a().b(this.e, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        Log.i("AutopilotApp", "clearKillProcess");
        rh.a().d(this.e);
    }
}
