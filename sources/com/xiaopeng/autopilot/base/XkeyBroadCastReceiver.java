package com.xiaopeng.autopilot.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
/* loaded from: classes.dex */
public class XkeyBroadCastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("XkeyBroadCastReceiver", "onReceive");
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("keyfunc", 0);
        String stringExtra = intent.getStringExtra("keytype");
        Log.i("XkeyBroadCastReceiver", "action = " + action + ",func = " + intExtra + ",keyType = " + stringExtra);
        if ("com.xiaopeng.intent.action.xkey".equals(action) && intExtra == 4 && "short".equals(stringExtra)) {
            IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.carcontrol.ACTION_CARCONTROL_SUPER_PARK");
        }
    }
}
