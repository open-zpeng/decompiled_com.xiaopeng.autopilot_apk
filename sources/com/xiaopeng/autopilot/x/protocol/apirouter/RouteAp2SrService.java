package com.xiaopeng.autopilot.x.protocol.apirouter;

import android.net.Uri;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.xiaopeng.autopilot.x.protocol.bean.gson.OneIntBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.OneStringBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.ParkLotChooseBean;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
/* loaded from: classes.dex */
public class RouteAp2SrService {
    private static final String SR_SERVICE_CLASS = "com.xiaopeng.sr.RouteSrPKService";

    public static void routeAp2SrAutoParkReq(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrAutoParkReq").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrFavoriteAutoParkReq(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrFavoriteAutoParkReq").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrParkLotChoseCoordi(float f, float f2, float f3) {
        ParkLotChooseBean parkLotChooseBean = new ParkLotChooseBean();
        parkLotChooseBean.setX(f);
        parkLotChooseBean.setY(f2);
        parkLotChooseBean.setZ(f3);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrParkLotChoseCoordi").appendQueryParameter("info", new Gson().toJson(parkLotChooseBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrSuperParkMode(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrSuperParkMode").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrParkStyle(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrParkStyle").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrTrainingCmd(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrTrainingCmd").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrMapReq(String str) {
        OneStringBean oneStringBean = new OneStringBean();
        oneStringBean.setValue(str);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrMapReq").appendQueryParameter("info", new Gson().toJson(oneStringBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrCallbackFirstReq() {
        OneStringBean oneStringBean = new OneStringBean();
        oneStringBean.setValue(BuildInfoUtils.BID_WAN);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrCallbackFirstReq").appendQueryParameter("info", new Gson().toJson(oneStringBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrSilentFavoriteCmd(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrSilentFavoriteCmd").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void routeAp2SrWindowOpenCmd(int i) {
        OneIntBean oneIntBean = new OneIntBean();
        oneIntBean.setValue(i);
        try {
            vy.a(new Uri.Builder().authority(SR_SERVICE_CLASS).path("routeAp2SrWindowOpenCmd").appendQueryParameter("info", new Gson().toJson(oneIntBean)).build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
