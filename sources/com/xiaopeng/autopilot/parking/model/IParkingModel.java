package com.xiaopeng.autopilot.parking.model;

import com.xiaopeng.autopilot.parking.bean.caldata.Point2D;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IParkingModel {
    void enableCaculateThread(boolean z);

    ArrayList<Point2D> getLocatPointList();

    int getParkLotHighNum();

    ArrayList<ParkLotItem> getParkLotItemList();

    int getParkLotLowNum();

    int getParkLotNarrowNum();

    int getParkLotNum();

    void init();

    void release();

    void sendParkLotRecv(int i);
}
