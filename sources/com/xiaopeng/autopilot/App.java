package com.xiaopeng.autopilot;

import android.content.res.Configuration;
import android.util.Log;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.parking.bean.caldata.DrivingData;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IMcuController;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class App extends b {
    @Override // com.xiaopeng.autopilot.b, com.xiaopeng.autopilot.base.a, android.app.Application
    public void onCreate() {
        Log.i("AutopilotApp", "E28 App onCreate() called.");
        super.onCreate();
        if (!c.a().b(this)) {
            c.a().a(this);
        }
        com.xiaopeng.autopilot.parking.c.d();
        i.a(i.C0051i.class, true);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onEventIgStatusChanged(IMcuController.McuIgStatusEventMsg mcuIgStatusEventMsg) {
        Log.i("AutopilotApp", "onEventIgStatusChanged : " + mcuIgStatusEventMsg);
        if (mcuIgStatusEventMsg == null || mcuIgStatusEventMsg.getData() == null) {
            return;
        }
        switch (mcuIgStatusEventMsg.getData().intValue()) {
            case 0:
                DrivingData.getInstance().setPowerModel(0);
                boolean a = a();
                Log.i("AutopilotApp", "CDU进入休眠状态, isIgOn:" + a);
                if (a) {
                    CarApiUtil.activeSuperParkMode(false);
                    a(false);
                    if (((i.ac) i.a(i.ac.class)).d().intValue() != 1) {
                        if (((i.x) i.a(i.x.class)).d().booleanValue()) {
                            IntentUtil.startAutopilotService(this, "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
                        } else {
                            IntentUtil.startAutopilotService(this, "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
                        }
                    }
                    com.xiaopeng.autopilot.parking.c.q();
                    e();
                    return;
                }
                return;
            case 1:
                Log.i("AutopilotApp", "CDU进入唤醒状态");
                DrivingData.getInstance().setPowerModel(1);
                this.a = true;
                this.c = true;
                a(true);
                b(false);
                f();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ThemeWatcher.getInstance().onConfigurationChanged(configuration);
    }

    private void b(boolean z) {
        rf.a(this).b(z);
    }
}
