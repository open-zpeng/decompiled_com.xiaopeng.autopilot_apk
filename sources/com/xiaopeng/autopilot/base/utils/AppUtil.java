package com.xiaopeng.autopilot.base.utils;

import android.content.Context;
/* loaded from: classes.dex */
public class AppUtil {
    private static Boolean isDebug;

    public static boolean isDebug() {
        Boolean bool = isDebug;
        return bool != null && bool.booleanValue();
    }

    public static void syncIsDebug(Context context) {
        if (isDebug == null) {
            isDebug = Boolean.valueOf((context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true);
        }
    }
}
