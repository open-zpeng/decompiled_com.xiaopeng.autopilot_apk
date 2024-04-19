package com.xiaopeng.autopilot.base.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* loaded from: classes.dex */
public class IPCUtil {
    private static final String[] APPS_D55 = {IpcConfig.App.MAP_NAVI, "com.xiaopeng.aiassistant"};
    private static final String[] APPS_REBOOT_D55 = {"com.xiaopeng.aiassistant"};
    private static final String TAG = "IPCUtil";

    public static void sendAutoPilotShowIPC() {
        Log.i("autopilotIPC", "sendAutoPilotShowIPC");
        ThreadUtils.postBackground(new Runnable() { // from class: com.xiaopeng.autopilot.base.utils.IPCUtil.1
            @Override // java.lang.Runnable
            public void run() {
                IPCUtil.sendToApps(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_WINDOW_OPENED);
            }
        });
    }

    public static void sendAutopilotCloseIPC() {
        Log.i("autopilotIPC", "sendAutopilotCloseIPC");
        ThreadUtils.postBackground(new Runnable() { // from class: com.xiaopeng.autopilot.base.utils.IPCUtil.2
            @Override // java.lang.Runnable
            public void run() {
                IPCUtil.sendToApps(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_WINDOW_CLOSED);
            }
        });
    }

    public static boolean isProcessExist(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.xiaopeng.aiassistant")) {
                    Log.i(TAG, "com.xiaopeng.aiassistantis exist");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void sendToAppsReboot() {
        if (!isProcessExist(a.g().getApplicationContext())) {
            Log.i(TAG, "Aiassistant is not exist !");
            return;
        }
        Log.i(TAG, "Aiassistant is  exist !");
        Log.i(TAG, "SEND_OPEN_CLOSE_IPC_D21B_LIST ");
        String[] strArr = APPS_REBOOT_D55;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            c.a().a(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_WINDOW_CLOSED, null, str);
            Log.i("autopilotIPC", "send Ipc msg id:" + IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_WINDOW_CLOSED + " \tto :\t" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendToApps(int i) {
        Log.i(TAG, "SEND_OPEN_CLOSE_IPC_D21B_LIST ");
        String[] strArr = APPS_D55;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            c.a().a(i, null, str);
            Log.i("autopilotIPC", "send Ipc msg id:" + i + " \tto :\t" + str);
        }
    }
}
