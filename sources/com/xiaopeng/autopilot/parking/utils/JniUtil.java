package com.xiaopeng.autopilot.parking.utils;

import com.xiaopeng.autopilot.parking.bean.caldata.DrivingData;
import com.xiaopeng.autopilot.parking.bean.caldata.FeatureRData;
import com.xiaopeng.autopilot.parking.bean.caldata.InLocatData;
import com.xiaopeng.autopilot.parking.bean.caldata.ParkLotRData;
import com.xiaopeng.autopilot.parking.bean.caldata.Point2D;
import com.xiaopeng.autopilot.x.protocol.bean.gson.FavorPos;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class JniUtil {
    public static native void drivingData(DrivingData drivingData);

    public static native void getLocus(InLocatData inLocatData, ArrayList<Point2D> arrayList);

    public static native void getRelativeData(InLocatData inLocatData, Object[] objArr, Object[] objArr2, Object[] objArr3, ArrayList<FeatureRData> arrayList, ArrayList<ParkLotRData> arrayList2, int i);

    public static native void getRelativeDataEdward(InLocatData inLocatData, Object[] objArr, Object[] objArr2, Object[] objArr3, ArrayList<ParkLotRData> arrayList, int i);

    public static native void init(int i);

    public static native void parkingInitAll();

    public static native void release();

    public static native void sendFavorite(FavorPos favorPos);

    static {
        System.loadLibrary("Autopilot");
    }
}
