package com.xiaopeng.autopilot.x.protocol.apirouter;

import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
/* loaded from: classes.dex */
public class Route2IpcService {
    private static final String TAG = "Route2IpcService";

    public static void sendData(int i, String str, String str2) {
        Log.i(TAG, "sendData id = " + i + " ; pkgName = " + str2 + " ; bundle = " + str);
        Uri.Builder builder = new Uri.Builder();
        try {
            vy.a(builder.authority(str2 + ".IpcRouterService").path("onReceiverData").appendQueryParameter(Constants.ID, String.valueOf(i)).appendQueryParameter("bundle", str).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
