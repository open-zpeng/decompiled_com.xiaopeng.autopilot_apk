package com.xiaopeng.autopilot.parking;

import com.xiaopeng.autopilot.base.bean.eventbus.ShortcutEvent;
import com.xiaopeng.autopilot.parking.utils.JniUtil;
import com.xiaopeng.autopilot.parking.view.ParkingViewContainer;
import com.xiaopeng.lib.utils.LogUtils;
import org.greenrobot.eventbus.m;
/* compiled from: ParkingFactory.java */
/* loaded from: classes.dex */
public class d {
    String a = "ParkingFactory";
    private tn b;

    public void a(ParkingViewContainer parkingViewContainer) {
        JniUtil.init(3);
        JniUtil.parkingInitAll();
        this.b = c.a(parkingViewContainer);
        org.greenrobot.eventbus.c.a().a(this);
    }

    @m
    public void onEvent(String str) {
        if (str.equalsIgnoreCase(ShortcutEvent.CLEAN_PARKING_JNI_CACHE_EVENT)) {
            LogUtils.i(this.a, "清除so缓存，JniUtil.parkingInitAll();");
            JniUtil.parkingInitAll();
        }
    }
}
