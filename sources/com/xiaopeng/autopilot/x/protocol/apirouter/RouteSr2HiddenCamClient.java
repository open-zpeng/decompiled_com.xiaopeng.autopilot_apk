package com.xiaopeng.autopilot.x.protocol.apirouter;

import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import com.google.gson.Gson;
import com.xiaopeng.autopilot.x.protocol.bean.gson.EvaluateBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.HdmapConfirmBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.ShareMapBean;
import java.util.List;
/* loaded from: classes.dex */
public class RouteSr2HiddenCamClient {
    private static final String TAG = "hdcam";
    private static Gson gson = new Gson();
    private static final String hiddencam_SERVICE_CLASS = "com.xiaopeng.hiddenCam.RouteSrHdPkmap";

    public static void routeSr2HdPkmapConfirmInfo(int i, long j) {
        String json = gson.toJson(new HdmapConfirmBean(j, i), HdmapConfirmBean.class);
        try {
            vy.a(new Uri.Builder().authority(hiddencam_SERVICE_CLASS).path("routeSr2HdPkmapConfirmInfo").appendQueryParameter("info", json).build());
            Log.d(TAG, "routeSr2HdPkmapConfirmInfo: " + json);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeSr2HdPkmapShareInfo(int i, List<Integer> list, long j) {
        String json = gson.toJson(new ShareMapBean(i, list, j), ShareMapBean.class);
        Log.d(TAG, "routeSr2HdPkmapShareInfo: " + json);
        try {
            vy.a(new Uri.Builder().authority(hiddencam_SERVICE_CLASS).path("routeSr2HdPkmapShareInfo").appendQueryParameter("info", json).build());
            Log.d(TAG, "routeSr2HdPkmapShareInfo: " + json);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeSr2HdPkmapEvaluation(String str, int i, int i2, long j) {
        String json = gson.toJson(new EvaluateBean(str, i, i2, j), EvaluateBean.class);
        try {
            vy.a(new Uri.Builder().authority(hiddencam_SERVICE_CLASS).path("routeSr2HdPkmapEvaluation").appendQueryParameter("info", json).build());
            Log.d(TAG, "routeSr2HdPkmapEvaluation: " + json);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
