package com.xiaopeng.autopilot.x.protocol.apirouter;

import android.util.Log;
import com.xiaopeng.autopilot.x.protocol.bean.eventbus.SpeechApiRouteEvent;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import org.greenrobot.eventbus.c;
/* loaded from: classes.dex */
public class ParkingSpeechObserver implements IServicePublisher {
    private static final String TAG = "ParkingSpeechObserver";

    @Publish
    public void onQuery(String str, String str2, String str3) {
    }

    @Publish
    public void onEvent(String str, String str2) {
        Log.i(TAG, "onEvent 消息接收 event== " + str + ",data:" + str2);
        if ("command://autoparking.activate".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(1, str2));
        } else if ("command://autoparking.exit".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(2, str2));
        } else if ("command://autoparking.park.start".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(3, str2));
        } else if ("native://autoparking.park.carport.count".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(4, str2));
        } else if ("command://control.car.favoriteslotparking.on".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(5, str2));
        } else if ("command://control.car.favoriteslotparking.learning".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(6, str2));
        } else if ("command://autoparking.find.parking.space.start".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(7, str2));
        } else if ("command://autoparking.find.parking.space.continue".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(8, str2));
        } else if ("command://autoparking.find.parking.space.exit".equals(str)) {
            c.a().d(new SpeechApiRouteEvent(9, str2));
        }
    }
}
