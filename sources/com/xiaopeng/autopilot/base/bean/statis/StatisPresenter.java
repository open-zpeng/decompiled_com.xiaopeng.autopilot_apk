package com.xiaopeng.autopilot.base.bean.statis;

import android.car.Car;
import android.graphics.Point;
import android.util.Log;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class StatisPresenter implements rl {
    public static final String TAG = "StatisPresenter";

    @Override // defpackage.rl
    public void statisEnterAutopilotMethod(String str) {
        if (d.h) {
            HashMap hashMap = new HashMap();
            hashMap.put("sence", "driving");
            hashMap.put("method", str);
            commmonStatis("enter_autopilot_method", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisGear(int i) {
        if (d.h) {
            String d = ((i.n) i.a(i.n.class)).d();
            if (i == 3 || !d.equalsIgnoreCase("driving")) {
                HashMap hashMap = new HashMap();
                hashMap.put("gear_value", i + "");
                commmonStatis("gear_state", hashMap);
            }
        }
    }

    @Override // defpackage.rl
    public void statisClickScreen(Point point) {
        if (d.h) {
            HashMap hashMap = new HashMap();
            hashMap.put("point", point.x + " " + point.y);
            commmonStatis("click_screen", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisChooseParkingLot(HashMap<String, String> hashMap) {
        if (d.h && ((i.n) i.a(i.n.class)).d().equalsIgnoreCase("at_a_parking")) {
            commmonStatis("choose_parking_lot", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisEnter360Camera(int i) {
        if (d.h) {
            HashMap hashMap = new HashMap();
            hashMap.put("navigation_type", i + "");
            commmonStatis("enter_360camera", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisEnterHelp() {
        if (d.h) {
            commmonStatis("enter_help", null);
        }
    }

    @Override // defpackage.rl
    public void statisExit() {
        if (d.h) {
            commmonStatis("exit_autopilot", new HashMap());
        }
    }

    @Override // defpackage.rl
    public void statisBrakeState(int i, int i2, int i3) {
        if (d.h && ((i.n) i.a(i.n.class)).d().equalsIgnoreCase("at_b_parking")) {
            HashMap hashMap = new HashMap();
            hashMap.put("change", i + "");
            hashMap.put("current_tip", i2 + "");
            hashMap.put("parking_life", i3 + "");
            commmonStatis("brake_state", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisGoOn() {
        if (d.h) {
            commmonStatis("enter_go_on", new HashMap());
        }
    }

    @Override // defpackage.rl
    public void statisParkingSuccess(String str) {
        if (d.h) {
            HashMap hashMap = new HashMap();
            hashMap.put("sence", "at_b_parking");
            hashMap.put("is_park_out", str);
            commmonStatis("parking_success", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisStartAutopilot(boolean z, boolean z2) {
        if (d.h) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_drag", z ? BuildInfoUtils.BID_WAN : "0");
            hashMap.put("is_speech", z2 ? BuildInfoUtils.BID_WAN : "0");
            commmonStatis("enter_start_autopilot", hashMap);
        }
    }

    @Override // defpackage.rl
    public void statisParkingError() {
        if (d.h) {
            commmonStatis("parking_error", null);
        }
    }

    public void commmonStatis(String str, Map<String, String> map) {
        if (d.h) {
            boolean z = true;
            try {
                z = true ^ Car.getVersionInCountryCode().contains("ZH");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                return;
            }
            IDataLog iDataLog = (IDataLog) Module.get(vi.class).get(IDataLog.class);
            IStatEventBuilder buildStat = iDataLog.buildStat();
            buildStat.setEventName("autopilot_" + str);
            String d = ((i.n) i.a(i.n.class)).d();
            if (map != null && map.keySet() != null && map.keySet().size() > 0) {
                map.containsKey("page_id");
                map.containsKey("button_id");
                if (!map.containsKey("sence")) {
                    buildStat.setProperty("sence", d);
                }
                for (String str2 : map.keySet()) {
                    buildStat.setProperty(str2, map.get(str2));
                }
            } else {
                buildStat.setProperty("sence", d);
            }
            IStatEvent build = buildStat.build();
            iDataLog.sendStatData(build);
            if (d.c()) {
                Log.i(TAG, build.toJson());
            }
        }
    }
}
