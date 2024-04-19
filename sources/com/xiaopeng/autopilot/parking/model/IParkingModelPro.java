package com.xiaopeng.autopilot.parking.model;

import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.x.protocol.bean.gson.SpdBumpBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSlotBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSpdBumpBean;
import com.xiaopeng.sr.bean.ApMapBean;
import defpackage.a;
import defpackage.ahz;
import defpackage.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes.dex */
public interface IParkingModelPro {

    /* loaded from: classes.dex */
    public interface IApFailReasonListener {
        void onApFailReason(int i);
    }

    /* loaded from: classes.dex */
    public interface IArrowChangeListener {
        void onArrowChange(int i);
    }

    /* loaded from: classes.dex */
    public interface IDrivingDataChangeListener {
        void onDrivingDataRefresh(a.c cVar);
    }

    /* loaded from: classes.dex */
    public interface IGlobalTrajectoryIndexListener {
        void onGlobalIndex(int i);
    }

    /* loaded from: classes.dex */
    public interface IMapMessageChangeListener {
        void onMapMessageRefresh();

        void onMapTrainingRsMessageRefresh();

        void onStaticRoadMapRefresh();
    }

    /* loaded from: classes.dex */
    public interface IRemainDistanceListener {
        void onRemainDistance(float f);
    }

    /* loaded from: classes.dex */
    public interface ISpdBumpListener {
        void onSpdBump(SpdBumpBean spdBumpBean);
    }

    /* loaded from: classes.dex */
    public interface IStatusIndicateChangeListener {
        void onStatusIndicateChange(int i);
    }

    /* loaded from: classes.dex */
    public interface ITipsChangeListener {
        void onTipsChange(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface ITrainingMapReqListener {
        void onTrainingTips(int i, int i2, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface IVoiceChangeListener {
        void onVoiceChange(int i);
    }

    /* loaded from: classes.dex */
    public interface IXpuShowToastListener {
        void onShowToast(int i);
    }

    void bind(to toVar);

    void bind3D(tk tkVar);

    void clearMapData();

    void clearTrainingModelGuildeline();

    void continueFoundParkLot();

    void exitFoundParkLot();

    int getAPSpdBumpCount();

    int getAPStatus();

    List<b.d> getApDynaObjectDataList();

    List<b.h> getApLaneLineInfoList();

    ApMapBean getApMapBean();

    Queue getApPillarsQueue();

    List<b.q> getApStaticObjectDataList();

    float getCurrentS();

    int getCurrentTrainingSpdBumpCount();

    b.o getDynaAllGuildeline();

    ArrayList<b.o> getDynaGuidelineByType(int i);

    List<p> getDynaTrainingModelGuidelinePoints();

    String getDynamicDebugInfo();

    List<b.h> getDynamicLaneLineInfoDataList();

    List<a.k> getDynamicSlotLists();

    List<ahz.c.h> getFloorList();

    int getFloorNumByZValue(float f);

    int getIndexOfAllGuildLine();

    List<ahz.c.n> getLandmarksTypeDataList();

    List<ahz.c.p> getLaneLines();

    List<ahz.c.v> getLinkList();

    List<ahz.c.v> getLinkListError();

    a.c getLocationData();

    MiniMapModel getMimiMapModel();

    int getParkLotNum();

    float getRemainDis();

    List<b.w> getSlotIdMappingList();

    List<ahz.c.ab> getSlotTypeList();

    List<ahz.c.ab> getSlotTypeListRs();

    List<SpdBumpBean> getSpdBumpBeanList();

    a.c getStartTrainingOdoMeterInfo();

    float getStartTrainingS();

    List<sc> getStaticMapAllRoadPathCduPoint();

    Queue getTrainingParklotsQueue();

    List<ahz.c.v> getTrainingRsLinkList();

    Queue getTrainingSpdbumpsQueue();

    Queue<Runnable> getUnExecuteRefreshRoadQueue();

    Queue<Runnable> getUnExecuteRefreshRunnable();

    ahz.c.aj getVenueData();

    p getmFirstTrainingPathCduPoint();

    List<TrainingSlotBean> getmTrainingSlotList();

    List<TrainingSpdBumpBean> getmTrainingSpdBumpList();

    boolean hasAvailableParklot();

    boolean hasParklots();

    boolean hasReadAllGuideLineData();

    boolean hasReadyFloorData();

    void initMap();

    boolean isInNavStartPointProcedure();

    boolean isStartTraining();

    void onEndTrainingModel();

    void onStartTrainingModel();

    void resetNavStateWhenStart();

    void resetSlotIdMappingList();

    void routeAp2SrAutoParkReq(int i);

    void routeAp2SrMapReq();

    void routeAp2SrParkLotChoseCoordi(float f, float f2, float f3);

    void routeAp2SrParkLotChoseIndex(int i);

    void routeAp2SrTrainingCmd(int i);

    void routeAp2SrTrainingMapReq();

    void setIsStartTraining(boolean z);

    void startAP();

    void startFoundParkLot();
}
