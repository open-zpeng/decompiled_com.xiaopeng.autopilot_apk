package com.xiaopeng.autopilot.parking.model;

import android.text.TextUtils;
import android.util.Log;
import com.badlogic.gdx.math.p;
import com.google.gson.Gson;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.NavStartGuideDialogUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.o;
import com.xiaopeng.autopilot.x.protocol.bean.gson.FavorPos;
import com.xiaopeng.autopilot.x.protocol.bean.gson.SpdBumpBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingMapObjects;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSlotBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSpdBumpBean;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.sr.bean.ApMapBean;
import com.xiaopeng.xui.app.XToast;
import defpackage.a;
import defpackage.ahz;
import defpackage.b;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.c;
/* loaded from: classes.dex */
public class ParkingModelPro implements IParkingModelPro {
    private static final boolean DEBUG_DUIDELINE = true;
    private static final boolean DEBUG_DUIDELINE_DETAIL = false;
    private static final boolean DEBUG_SLOTE = true;
    private static final String MAP_REQUEST = "read_map";
    private static final long M_INTERVAL_CALCFLOOR_TIME = 1000;
    private static final String TAG = "ParkingModelPro";
    private static final String TRAINING_MAP_REQUEST = "read_training_map";
    public static final float sDistanceFilterValue = 0.05f;
    private static final int sMaxCachePoint = 950;
    private static final int sMaxSubIndex = 100;
    public static final float sTimeFilterValue = 60.0f;
    private tk m3DPresenterPro;
    private int mApAbnormal;
    private List<b.d> mApDynaObjectDataList;
    private int mApFail;
    private ConcurrentLinkedDeque mApPillarsQueue;
    private int mApSt;
    private List<b.q> mApStaticObjectDataList;
    private int mApTips;
    private vh mClient;
    List<Integer> mCurfloorList;
    private int[] mCurrentErrTips;
    private int mCurrentFloor;
    private int mCurrentTrainingSt;
    private int mCurrentTrainingTips;
    private b.o mDynaAllGuildeline;
    private p mFirstTrainingPathCduPoint;
    private List<ahz.c.h> mFloorList;
    private List<ahz.c.h> mFloorListCP;
    private Gson mGson;
    private int mIndexOfAllGuildLine;
    private List<ahz.c.n> mLandmarksTypeDataList;
    private List<ahz.c.p> mLaneLines;
    private List<ahz.c.v> mLinkList;
    private List<ahz.c.v> mLinkListRs;
    private a.c mLocationData;
    private MiniMapModel mMimiMapModel;
    private tw mPresenterPro;
    private ConcurrentLinkedDeque mRefreshMapQueue;
    private ConcurrentLinkedDeque mRefreshRoadQueue;
    private List<a.k> mSlotDataList;
    private List<ahz.c.ab> mSlotTypeList;
    private List<ahz.c.ab> mSlotTypeListRs;
    private List<SpdBumpBean> mSpdBumpBeanList;
    private float mStartS;
    private List<sc> mStaticMapAllRoadPathCduPointCache;
    private CopyOnWriteArrayList<p> mTrainingOdoPointCache;
    private ConcurrentLinkedDeque mTrainingParklotsQueue;
    private ConcurrentLinkedDeque mTrainingSpdbumpsQueue;
    private a.c mTrainingStartLocationData;
    private ahz.c.aj mVenue;
    List<b.h> mXApLaneLineInfoDataList;
    List<b.o> mXpApTraTrajectoryDataTypeDataList;
    private boolean mIsStartTraining = false;
    private int mFavorNum = 0;
    private int mFreeNum = 0;
    private int mAvmUnknowNum = 0;
    private int mAvmParkedNum = 0;
    private int mAvmErrAttrNum = 0;
    private int mErrSlotTypeNum = 0;
    private boolean mCanPlaySlotFound = true;
    private List<p> mPointList = new ArrayList();
    private List<p> mPoints = new ArrayList();
    private long mLastDrivingDataRecordTime = 0;
    private long mLastCalcFloorNumTime = 0;
    private int mCurrentFloorNum = 0;
    private ApMapBean mApMapBean = new ApMapBean();
    private int mNavSt = -1;
    private int mNavTips = -1;
    private int mNavHillState = -1;
    private List<b.w> mSlotIdMappingList = new ArrayList();
    private float mRemainDis = 0.0f;
    private ArrayList<b.o> mGuildLineTemp = new ArrayList<>();
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private boolean mMapRequest = false;
    private abi mXpuMessageListener = new abi() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1
        private int mMapPoseState;
        private long mLastRecordTime = 0;
        private a.c mLastLocation = null;
        private long mLastFrameTime = 0;
        Runnable refreshModelOnDrivingDataRun = new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.3
            @Override // java.lang.Runnable
            public void run() {
                if (ParkingModelPro.this.m3DPresenterPro != null) {
                    ParkingModelPro.this.m3DPresenterPro.onDrivingDataRefresh(ParkingModelPro.this.mLocationData);
                    AnonymousClass1.this.mLastFrameTime = System.currentTimeMillis();
                }
            }
        };
        Runnable speedRunnable = new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.4
            float lastVcuSpeed = 0.0f;

            @Override // java.lang.Runnable
            public void run() {
                if (ParkingModelPro.this.mLocationData != null) {
                    float c = ParkingModelPro.this.mLocationData.c();
                    float f = 3.6f * c;
                    if (Math.abs(f - this.lastVcuSpeed) > 1.0f || (f == 0.0f && this.lastVcuSpeed != 0.0f)) {
                        this.lastVcuSpeed = f;
                        ParkingModelPro.this.mPresenterPro.a(Math.abs(f));
                    }
                    ParkingModelPro.this.mPresenterPro.b(c);
                }
                List<Integer> list = ParkingModelPro.this.mCurfloorList;
                if (list == null || list.size() <= 1) {
                    return;
                }
                int intValue = list.get(0).intValue();
                int intValue2 = list.get(1).intValue();
                ParkingModelPro.this.mCurrentFloor = intValue;
                if (intValue != intValue2) {
                    Log.i(ParkingModelPro.TAG, "floorList.curFloor: " + intValue + ",nextFloor = " + intValue2);
                    if (intValue > intValue2) {
                        ParkingModelPro.this.mPresenterPro.onArrowChange(4);
                    } else {
                        ParkingModelPro.this.mPresenterPro.onArrowChange(5);
                    }
                }
            }
        };
        private float debugLocation_mappos = -1.0f;
        private float debugLocation_x = -1.0f;
        private float debugLocation_y = -1.0f;
        private float debugLocation_z = -1.0f;
        Runnable mapPoseRunnable = new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.10
            @Override // java.lang.Runnable
            public void run() {
                if (AnonymousClass1.this.mMapPoseState == 2) {
                    if (!ParkingModelPro.this.mMapRequest) {
                        ParkingModelPro.this.routeAp2SrMapReq();
                        ParkingModelPro.this.mMapRequest = true;
                    }
                    ParkingModelPro.this.mPresenterPro.q(AnonymousClass1.this.mMapPoseState);
                    return;
                }
                boolean booleanValue = ((i.h) i.a(i.h.class)).d().booleanValue();
                Log.i(ParkingModelPro.TAG, "mapPoseRunnable.hasFinish = " + booleanValue);
                if (booleanValue) {
                    return;
                }
                ParkingModelPro.this.clearMapData();
            }
        };
        private float mNavFeatureTotalDistance = 0.0f;
        private boolean mResetMap4NavStartPoint = false;
        private boolean mHasExecutedNavGuide = false;

        private void debugGuideline() {
        }

        private void debugSlotData() {
        }

        public void onMessage(String str) {
            Log.i(ParkingModelPro.TAG, "Received: " + str);
        }

        public void onTrainingMapMessage(ahz.c cVar) {
            String str;
            String str2;
            if (cVar == null) {
                Log.i(ParkingModelPro.TAG, " TrainingModel_flag onTrainingMapMessage Rs  byte = null or size = 0, return");
                ParkingModelPro.this.mPresenterPro.onShowToast(e.i.xpu_map_request_error);
                return;
            }
            Log.i(ParkingModelPro.TAG, "TrainingModel_flag onTrainingMapMessage: size = " + cVar.toByteArray().length);
            if (ParkingModelPro.this.mSlotTypeListRs != null) {
                ParkingModelPro.this.mSlotTypeListRs.clear();
            }
            if (ParkingModelPro.this.mLinkListRs != null) {
                ParkingModelPro.this.mLinkListRs.clear();
            }
            ParkingModelPro.this.mFloorList = cVar.f();
            ParkingModelPro.this.mSlotTypeListRs = cVar.d();
            ParkingModelPro.this.mLinkListRs = cVar.b();
            StringBuilder sb = new StringBuilder();
            sb.append("TrainingModel_flag training rs links:\t ");
            if (ParkingModelPro.this.mLinkListRs != null) {
                str = ParkingModelPro.this.mLinkListRs.size() + "";
            } else {
                str = "0";
            }
            sb.append(str);
            sb.append("\tslots size:\t");
            if (ParkingModelPro.this.mSlotTypeListRs != null) {
                str2 = ParkingModelPro.this.mSlotTypeListRs.size() + "";
            } else {
                str2 = "0";
            }
            sb.append(str2);
            Log.i(ParkingModelPro.TAG, sb.toString());
            if (ParkingModelPro.this.m3DPresenterPro != null) {
                ParkingModelPro.this.m3DPresenterPro.onMapTrainingRsMessageRefresh();
            }
        }

        @Override // defpackage.abi
        public void onMapMessage(ahz.c cVar) {
            if (cVar == null) {
                Log.i(ParkingModelPro.TAG, "onMapMessage byte = null or size = 0, return");
                ParkingModelPro.this.mPresenterPro.onShowToast(e.i.xpu_map_request_error);
            } else {
                Log.i(ParkingModelPro.TAG, "DataSource onMapMessage: size = " + cVar.toByteArray().length);
            }
            ParkingModelPro.this.mFloorList = cVar.f();
            ParkingModelPro.this.mSlotTypeList = cVar.d();
            ParkingModelPro.this.mLinkList = cVar.b();
            ParkingModelPro.this.mLandmarksTypeDataList = cVar.c();
            StringBuilder sb = new StringBuilder();
            sb.append("mLandmarksTypeDataList = ");
            sb.append(ParkingModelPro.this.mLandmarksTypeDataList == null ? 0 : ParkingModelPro.this.mLandmarksTypeDataList.size());
            Log.i(ParkingModelPro.TAG, sb.toString());
            ParkingModelPro.this.mVenue = cVar.a();
            ParkingModelPro.this.mLaneLines = cVar.e();
            initMiniComponentData();
            ParkingModelPro.this.getmFloorListCP().clear();
            ParkingModelPro.this.getmFloorListCP().addAll(ParkingModelPro.this.mFloorList);
            debugOnMapMessage(cVar);
            resolverefreshMapMessage();
        }

        private void debugOnMapMessage(ahz.c cVar) {
            if (cVar == null) {
                PerformanceTestUnit.log(ParkingModelPro.TAG, "DataSource map data is null", true);
                return;
            }
            StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
            stringBuffer.setLength(0);
            stringBuffer.append("STATIC_MAP_TASK DataSource > onMapMessage:");
            stringBuffer.append("\tmapInfo: {mapId: ");
            stringBuffer.append(cVar.a().a());
            StringBuilder sb = new StringBuilder();
            sb.append("\tfloorListSize: ");
            sb.append(ParkingModelPro.this.mFloorList != null ? Integer.valueOf(ParkingModelPro.this.mFloorList.size()) : "0");
            stringBuffer.append(sb.toString());
            if (ParkingModelPro.this.mFloorList != null && ParkingModelPro.this.mFloorList.size() > 0) {
                stringBuffer.append("\t{");
                for (ahz.c.h hVar : ParkingModelPro.this.mFloorList) {
                    stringBuffer.append("level:");
                    stringBuffer.append(hVar.a());
                    stringBuffer.append(",");
                    stringBuffer.append("upper:");
                    stringBuffer.append(hVar.b());
                    stringBuffer.append(",");
                    stringBuffer.append("lower:");
                    stringBuffer.append(hVar.c());
                    stringBuffer.append(",");
                }
                stringBuffer.append("}");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tmSlotTypeList: ");
            sb2.append(ParkingModelPro.this.mSlotTypeList != null ? Integer.valueOf(ParkingModelPro.this.mSlotTypeList.size()) : "0");
            stringBuffer.append(sb2.toString());
            stringBuffer.append("}");
            PerformanceTestUnit.log(ParkingModelPro.TAG, stringBuffer.toString(), true);
        }

        private Runnable refreshRoadRunnable() {
            return new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.1
                @Override // java.lang.Runnable
                public void run() {
                    PerformanceTestUnit.logStart(ParkingModelPro.TAG);
                    if (ParkingModelPro.this.mFloorList != null && ParkingModelPro.this.mFloorList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("STATIC_MAP_TASK > DataSource allPathRoad  >> execute refreshRoadRunnable!\t");
                        sb.append(ParkingModelPro.this.mFloorList.size());
                        sb.append("\troad data:");
                        sb.append(ParkingModelPro.this.mDynaAllGuildeline != null ? Integer.valueOf(ParkingModelPro.this.mDynaAllGuildeline.b().size()) : "0");
                        PerformanceTestUnit.log(ParkingModelPro.TAG, sb.toString(), true);
                        ParkingModelPro.this.m3DPresenterPro.onStaticRoadMapRefresh();
                    } else {
                        PerformanceTestUnit.log(ParkingModelPro.TAG, "STATIC_MAP_TASK > DataSource allPathRoad >> foolList is null", true);
                    }
                    PerformanceTestUnit.logEnd(ParkingModelPro.TAG, "allPathRoad.refreshRoad!");
                }
            };
        }

        private Runnable refreshMapMessageRunnable() {
            return new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i(ParkingModelPro.TAG, "postBackground-Runnable BaiP execute refreshMapMessageRunnable");
                    if (ParkingModelPro.this.m3DPresenterPro != null) {
                        ParkingModelPro.this.m3DPresenterPro.onMapMessageRefresh();
                    }
                }
            };
        }

        private boolean floorDataReady() {
            return ParkingModelPro.this.mFloorList != null && ParkingModelPro.this.mFloorList.size() > 0;
        }

        private void resolverefreshMapMessage() {
            boolean z = ParkingModelPro.this.m3DPresenterPro.z();
            boolean f = ParkingModelPro.this.m3DPresenterPro.A().f();
            PerformanceTestUnit.log(ParkingModelPro.TAG, "STATIC_MAP_TASK  > DataSource > onMapMessage > resolverefreshMapMessage readyFormRender = " + z + " ; readyForApStart = " + f, true);
            ParkingModelPro.this.m3DPresenterPro.y();
            if (!z || !f) {
                ParkingModelPro.this.getUnExecuteRefreshRunnable().clear();
                ParkingModelPro.this.getUnExecuteRefreshRunnable().add(refreshMapMessageRunnable());
                ParkingModelPro.this.getUnExecuteRefreshRoadQueue().clear();
                ParkingModelPro.this.getUnExecuteRefreshRoadQueue().add(refreshRoadRunnable());
                Log.i(ParkingModelPro.TAG, "STATIC_MAP_TASK > DataSource onMapMessage > resolverefreshMapMessage unReadyForRender so  put initInitMapRunnable /put initMapRoadRunnable into queue! ");
                return;
            }
            Log.i(ParkingModelPro.TAG, "STATIC_MAP_TASK  >  DataSource > onMapMessage > resolverefreshMapMessage ready for render so execute initInitMapRunnable / initMapRoadRunnable");
            rh.a().a(refreshMapMessageRunnable());
            rh.a().a(refreshRoadRunnable());
        }

        private float distanceOfTwoLocation(a.c cVar, a.c cVar2) {
            if (cVar == null) {
                return 0.15f;
            }
            return new p(cVar.a().a(), cVar.a().b(), cVar.a().c()).d(new p(cVar2.a().a(), cVar2.a().b(), cVar2.a().c()));
        }

        private float getTimeFilter() {
            float f;
            try {
                f = ((i.p) i.a(i.p.class)).d().floatValue();
            } catch (Exception e) {
                Log.e(ParkingModelPro.TAG, "getTimeFilter error!");
                e.printStackTrace();
                f = 0.0f;
            }
            if (f > 18.0f) {
                return 50.0f;
            }
            if (f < 10.0f || f > 18.0f) {
                if (f > 5.0f) {
                    int i = (f > 10.0f ? 1 : (f == 10.0f ? 0 : -1));
                    return 100.0f;
                }
                return 100.0f;
            }
            return 80.0f;
        }

        private void addTrainingPoint(a.c cVar) {
            if (((i.au) i.a(i.au.class)).d().intValue() == 0) {
                ParkingModelPro.this.getTraingOdoPointsCache().clear();
                ParkingModelPro.this.setmFirstTrainingPathCduPoint(null);
                return;
            }
            boolean z = ((float) (System.currentTimeMillis() - this.mLastRecordTime)) > getTimeFilter();
            boolean z2 = distanceOfTwoLocation(this.mLastLocation, ParkingModelPro.this.getLocationData()) > 0.05f;
            if (z && z2 && cVar.f() == 0) {
                p c = tz.c(cVar.a().a(), cVar.a().b(), cVar.a().c());
                if (ParkingModelPro.this.getmFirstTrainingPathCduPoint() == null) {
                    ParkingModelPro.this.setmFirstTrainingPathCduPoint(c);
                }
                ParkingModelPro.this.getTraingOdoPointsCache().add(c);
                if (ParkingModelPro.this.getTraingOdoPointsCache().size() > ParkingModelPro.sMaxCachePoint) {
                    ParkingModelPro.this.getTraingOdoPointsCache().removeAll(ParkingModelPro.this.getTraingOdoPointsCache().subList(0, 100));
                }
                this.mLastRecordTime = System.currentTimeMillis();
                this.mLastLocation = ParkingModelPro.this.getLocationData();
            }
        }

        private void refreshModelOnDrivingDataChange(a.c cVar) {
            if (((float) (System.currentTimeMillis() - this.mLastFrameTime)) > io.a.getGraphics().getDeltaTime() * 1000.0f * 1.0f) {
                rh.a().f(this.refreshModelOnDrivingDataRun);
            }
        }

        @Override // defpackage.abi
        public void onDrivingDataMessage(b.C0040b c0040b) {
            if (c0040b == null) {
                Log.i(ParkingModelPro.TAG, "onDrivingDataMessage byte = null or size = 0, return");
                ParkingModelPro.this.mPresenterPro.onShowToast(e.i.xpu_driving_request_error);
                return;
            }
            boolean booleanValue = ((i.h) i.a(i.h.class)).d().booleanValue();
            int f = c0040b.a().f();
            if (booleanValue) {
                if (c0040b != null && c0040b.a() != null && f == 1) {
                    Log.i(ParkingModelPro.TAG, "onDrivingDataMessage is map");
                    ParkingModelPro.this.mLocationData = c0040b.a();
                    ParkingModelPro.this.mSlotDataList = c0040b.b();
                } else {
                    Log.i(ParkingModelPro.TAG, "onDrivingDataMessage is not  map");
                }
            } else {
                ParkingModelPro.this.mLocationData = c0040b.a();
                ParkingModelPro.this.mSlotDataList = c0040b.b();
            }
            ParkingModelPro.this.mApDynaObjectDataList = c0040b.f();
            ParkingModelPro.this.mApStaticObjectDataList = c0040b.m();
            ParkingModelPro.this.mXApLaneLineInfoDataList = c0040b.c();
            ParkingModelPro.this.mXpApTraTrajectoryDataTypeDataList = c0040b.e();
            ParkingModelPro.this.mCurfloorList = c0040b.d();
            calculateCurrentFloorNum(f);
            debugLocation();
            if (ParkingModelPro.this.m3DPresenterPro.z()) {
                debugDrivingData();
                addTrainingPoint(ParkingModelPro.this.mLocationData);
                refreshModelOnDrivingDataChange(ParkingModelPro.this.mLocationData);
                ParkingModelPro.this.combineSlot();
                rh.a().b(this.speedRunnable);
            }
        }

        private void calculateCurrentFloorNum(int i) {
            if (ParkingModelPro.this.getFloorList() == null || ParkingModelPro.this.getFloorList().size() == 0 || System.currentTimeMillis() - ParkingModelPro.this.mLastCalcFloorNumTime < ParkingModelPro.M_INTERVAL_CALCFLOOR_TIME) {
                return;
            }
            List<ahz.c.h> floorList = ParkingModelPro.this.getFloorList();
            float c = ParkingModelPro.this.mLocationData.a().c();
            int i2 = -999;
            Iterator<ahz.c.h> it = floorList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ahz.c.h next = it.next();
                float b = next.b();
                float c2 = next.c();
                int a = next.a();
                if (c > c2 && c < b) {
                    i2 = a;
                    break;
                }
            }
            ParkingModelPro.this.setmCurrentFloorNum(i2);
            if (i == 1) {
                ParkingModelPro.this.getMimiMapModel().setmCurrentFloorNum(i2);
            }
            ParkingModelPro.this.mLastCalcFloorNumTime = System.currentTimeMillis();
        }

        private void debugLocation() {
            i.d a = i.a(i.o.class);
            boolean z = a != null ? ((i.o) a).d().a : false;
            if (ParkingModelPro.this.getLocationData() == null || !z) {
                return;
            }
            if (this.debugLocation_mappos == ParkingModelPro.this.getLocationData().f() && this.debugLocation_x == ParkingModelPro.this.getLocationData().a().a() && this.debugLocation_y == ParkingModelPro.this.getLocationData().a().b() && this.debugLocation_z == ParkingModelPro.this.getLocationData().a().c()) {
                return;
            }
            this.debugLocation_mappos = ParkingModelPro.this.getLocationData().f();
            this.debugLocation_x = ParkingModelPro.this.getLocationData().a().a();
            this.debugLocation_y = ParkingModelPro.this.getLocationData().a().b();
            this.debugLocation_z = ParkingModelPro.this.getLocationData().a().c();
            int a2 = ParkingModelPro.this.getLocationData().g().a();
            int b = ParkingModelPro.this.getLocationData().g().b();
            StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
            stringBuffer.setLength(0);
            stringBuffer.append("car_position");
            stringBuffer.append("{");
            stringBuffer.append("hasMap:");
            stringBuffer.append(this.debugLocation_mappos);
            stringBuffer.append(",");
            stringBuffer.append("x :");
            stringBuffer.append(this.debugLocation_x);
            stringBuffer.append(",");
            stringBuffer.append("y :");
            stringBuffer.append(this.debugLocation_y);
            stringBuffer.append(",");
            stringBuffer.append("z :");
            stringBuffer.append(this.debugLocation_z);
            stringBuffer.append(",");
            stringBuffer.append("startLevel :");
            stringBuffer.append(a2);
            stringBuffer.append(",");
            stringBuffer.append("endLevel :");
            stringBuffer.append(b);
            stringBuffer.append(",");
            stringBuffer.append("}");
            PerformanceTestUnit.log("debugLocation_carposition", "debugLocation:\t" + stringBuffer.toString(), (long) ParkingModelPro.M_INTERVAL_CALCFLOOR_TIME);
        }

        public void debugDrivingData() {
            if (System.currentTimeMillis() - ParkingModelPro.this.mLastDrivingDataRecordTime > 4000) {
                StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
                stringBuffer.setLength(0);
                stringBuffer.append("DynamicData:\t");
                stringBuffer.append("[ ");
                stringBuffer.append("hasMap:");
                stringBuffer.append(ParkingModelPro.this.getLocationData().f() == 1);
                stringBuffer.append("\tloc:");
                stringBuffer.append(ParkingModelPro.this.getLocationData().a().a());
                stringBuffer.append(",\t");
                stringBuffer.append("sloteDatas:");
                stringBuffer.append(ParkingModelPro.this.getDynamicSlotLists() == null ? "0" : Integer.valueOf(ParkingModelPro.this.getDynamicSlotLists().size()));
                stringBuffer.append(",\t");
                stringBuffer.append("\tAp:");
                stringBuffer.append(ParkingModelPro.this.mApDynaObjectDataList == null ? "0" : Integer.valueOf(ParkingModelPro.this.mApDynaObjectDataList.size()));
                stringBuffer.append(",\t");
                stringBuffer.append("\tApStatic:");
                stringBuffer.append(ParkingModelPro.this.mApStaticObjectDataList == null ? "0" : Integer.valueOf(ParkingModelPro.this.mApStaticObjectDataList.size()));
                stringBuffer.append("\tGLines:");
                stringBuffer.append(ParkingModelPro.this.mXpApTraTrajectoryDataTypeDataList == null ? "0" : Integer.valueOf(ParkingModelPro.this.mXpApTraTrajectoryDataTypeDataList.size()));
                stringBuffer.append("]");
                debugSlotData();
                debugGuideline();
                ParkingModelPro.this.mLastDrivingDataRecordTime = System.currentTimeMillis();
                PerformanceTestUnit.log(ParkingModelPro.TAG, stringBuffer.toString(), true);
            }
        }

        @Override // defpackage.abi
        public void onArrow(int i) {
            Log.i(ParkingModelPro.TAG, "onArrow.arrow: " + i);
            ParkingModelPro.this.mPresenterPro.onArrowChange(i);
        }

        @Override // defpackage.abi
        public void onTips(final int i, final int i2) {
            ParkingModelPro.this.mApTips = i;
            ParkingModelPro.this.mApAbnormal = i2;
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.5
                @Override // java.lang.Runnable
                public void run() {
                    ParkingModelPro.this.mPresenterPro.onTipsChange(i, i2);
                }
            });
        }

        @Override // defpackage.abi
        public void onVoice(int i) {
            Log.i(ParkingModelPro.TAG, "onVoice.voice: " + i);
            ParkingModelPro.this.mPresenterPro.onVoiceChange(i);
        }

        @Override // defpackage.abi
        public void onStatusIndicate(final int i) {
            ParkingModelPro.this.mApSt = i;
            if (i == 3 || i == 7) {
                i.a(i.e.class, true);
            } else {
                i.a(i.e.class, false);
            }
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.6
                @Override // java.lang.Runnable
                public void run() {
                    ParkingModelPro.this.mPresenterPro.onStatusIndicateChange(i);
                }
            });
        }

        @Override // defpackage.abi
        public void onApFailReason(final int i) {
            ParkingModelPro.this.mApFail = i;
            Log.i(ParkingModelPro.TAG, "onApFailReason.reason: " + i);
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.7
                @Override // java.lang.Runnable
                public void run() {
                    ParkingModelPro.this.mPresenterPro.onApFailReason(i);
                }
            });
        }

        @Override // defpackage.abi
        public void onRemainDistance(float f) {
            ParkingModelPro.this.mPresenterPro.onRemainDistance(f);
            ParkingModelPro.this.mRemainDis = f;
        }

        @Override // defpackage.abi
        public void onGlobalTrajectoryIndex(int i) {
            if (d.c()) {
                Log.i(ParkingModelPro.TAG, "onGlobalTrajectoryIndex.index: " + i);
            }
            ParkingModelPro.this.mIndexOfAllGuildLine = i;
            ParkingModelPro.this.getMimiMapModel().setmCurrentIndex(ParkingModelPro.this.mIndexOfAllGuildLine);
        }

        public void onSpdBump(SpdBumpBean spdBumpBean) {
            Log.i(ParkingModelPro.TAG, "onSpdBump.bean: " + spdBumpBean.toString());
            if (ParkingModelPro.this.mSpdBumpBeanList == null) {
                ParkingModelPro.this.mSpdBumpBeanList = new ArrayList();
            }
            ParkingModelPro.this.mSpdBumpBeanList.clear();
            ParkingModelPro.this.mSpdBumpBeanList.add(spdBumpBean);
        }

        private void initMiniComponentData() {
            PerformanceTestUnit.log(ParkingModelPro.TAG, "MINI_MAP initMiniComponentData ", true);
            if (ParkingModelPro.this.getMimiMapModel().getMiniMapPresenter() != null) {
                ParkingModelPro.this.getMimiMapModel().getMiniMapPresenter().b();
            }
            ParkingModelPro.this.getMimiMapModel().init(ParkingModelPro.this.mDynaAllGuildeline, ParkingModelPro.this.mFloorList);
        }

        @Override // defpackage.abi
        public void onAllGuildlineChange(b.o oVar) {
            if (oVar != null) {
                ParkingModelPro.this.mDynaAllGuildeline = oVar;
                boolean z = ParkingModelPro.this.m3DPresenterPro.z();
                boolean floorDataReady = floorDataReady();
                calculateAllRoadPathCduPoint();
                StringBuffer stringBuffer = new StringBuffer("STATIC_MAP_TASK > DataSource > onAllGuildlineChange > allPathRoad:");
                stringBuffer.append("readyForRender:");
                stringBuffer.append(z);
                stringBuffer.append("\tfloorDataReady:");
                stringBuffer.append(floorDataReady);
                stringBuffer.append("\troad size:");
                stringBuffer.append(ParkingModelPro.this.mDynaAllGuildeline.b().size());
                PerformanceTestUnit.log(ParkingModelPro.TAG, stringBuffer.toString(), true);
                return;
            }
            Log.i(ParkingModelPro.TAG, "DataSource allPathRoad onAllGuildlineChange byte = null or size = 0, return");
            ParkingModelPro.this.mPresenterPro.onShowToast(e.i.xpu_allline_request_error);
        }

        private void calculateAllRoadPathCduPoint() {
            Log.i(ParkingModelPro.TAG, "DataSource > allPathRoad -calculateAllRoadPathCduPoint");
            long currentTimeMillis = System.currentTimeMillis();
            ParkingModelPro.this.getStaticMapAllRoadPathCduPoint().clear();
            List<b.m> b = ParkingModelPro.this.mDynaAllGuildeline.b();
            int size = b.size();
            Log.i(ParkingModelPro.TAG, "allPathRoadCurVe start" + size);
            p pVar = null;
            int i = 0;
            while (i < size - 1) {
                b.m mVar = b.get(i);
                int i2 = i + 1;
                b.m mVar2 = b.get(i2);
                p a = tz.a(mVar.a().a(), mVar.a().b(), mVar.a().c());
                p a2 = tz.a(mVar2.a().a(), mVar2.a().b(), mVar2.a().c());
                int a3 = ParkingModelPro.this.m3DPresenterPro.a(mVar.a().c());
                a.b += ru.a;
                sc scVar = new sc(a, mVar.b(), mVar.c(), a3);
                p c = a2.a().c(a);
                if (pVar != null) {
                    scVar.c(!pVar.c(c.a().d(), 0.003f));
                } else {
                    Log.i(ParkingModelPro.TAG, "allPathRoadCurVe lastRoadDir is null");
                }
                pVar = c.a().d();
                ParkingModelPro.this.getStaticMapAllRoadPathCduPoint().add(scVar);
                if (i == size - 2) {
                    sc scVar2 = new sc(a2, mVar2.b(), mVar2.c(), a3);
                    scVar2.c(true);
                    ParkingModelPro.this.getStaticMapAllRoadPathCduPoint().add(scVar2);
                }
                i = i2;
            }
            Log.i(ParkingModelPro.TAG, "allPathRoadCurVe end  allPathRoadCurVe size:\t" + size + "\tafter size:\t" + ParkingModelPro.this.getStaticMapAllRoadPathCduPoint().size());
            StringBuilder sb = new StringBuilder();
            sb.append("DataSource cost time:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            Log.i(ParkingModelPro.TAG, sb.toString());
        }

        @Override // defpackage.abi
        public void onBDistancePercent(final float f, final float f2) {
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.8
                @Override // java.lang.Runnable
                public void run() {
                    Log.d(ParkingModelPro.TAG, "b.distance = " + f + ",b.percent = " + f2);
                    ParkingModelPro.this.mPresenterPro.a(f, f2);
                }
            });
        }

        @Override // defpackage.abi
        public void onTrainingTips(final int i, final int i2, final int[] iArr) {
            ParkingModelPro.this.mCurrentTrainingSt = i;
            ParkingModelPro.this.mCurrentTrainingTips = i2;
            ParkingModelPro.this.mCurrentErrTips = iArr;
            Log.i(ParkingModelPro.TAG, "onTrainingTips : st = " + i + ", tips = " + i2 + ",fail = " + iArr);
            rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.9
                @Override // java.lang.Runnable
                public void run() {
                    ParkingModelPro.this.mPresenterPro.onTrainingTips(i, i2, iArr);
                }
            });
        }

        @Override // defpackage.abi
        public void onTrainingMapObjects(TrainingMapObjects trainingMapObjects) {
            if (((i.au) i.a(i.au.class)).d().intValue() == 0) {
                return;
            }
            if (trainingMapObjects.slot != null && trainingMapObjects.slot.size() > 0) {
                Log.i(ParkingModelPro.TAG, "TrainingSize SIZE: 生产:\t" + trainingMapObjects.slot.size() + "\t{" + ParkingModelPro.this.getLocationData().a().a() + " ," + ParkingModelPro.this.getLocationData().a().b() + " ," + ParkingModelPro.this.getLocationData().a().c() + "}");
                ParkingModelPro.this.getTrainingParklotsQueue().add(trainingMapObjects.slot);
            }
            if (trainingMapObjects.spdbump == null || trainingMapObjects.spdbump.size() <= 0) {
                return;
            }
            Log.i(ParkingModelPro.TAG, "TrainingSpdSize SIZE: 生产:\t" + trainingMapObjects.spdbump.size() + ":\t{" + ParkingModelPro.this.getLocationData().a().a() + " ," + ParkingModelPro.this.getLocationData().a().b() + " ," + ParkingModelPro.this.getLocationData().a().c() + "}");
            ParkingModelPro.this.getTrainingSpdbumpsQueue().add(trainingMapObjects.spdbump);
        }

        public void onNetworkStatus(int i) {
            if (i == 1) {
                Log.i(ParkingModelPro.TAG, "onNetworkStatus = XPU网络建立");
                ParkingModelPro.this.mPresenterPro.onShowToast(e.i.xpu_connected_title);
                return;
            }
            Log.i(ParkingModelPro.TAG, "onNetworkStatus = XPU网络断开");
            ParkingModelPro.this.mPresenterPro.onShowToast(e.i.xpu_error_title);
        }

        @Override // defpackage.abi
        public void onMapPoseState(int i) {
            this.mMapPoseState = i;
            Log.i(ParkingModelPro.TAG, "onMapPoseState: " + i + ",mMapRequest = " + ParkingModelPro.this.mMapRequest);
            rh.a().a(this.mapPoseRunnable);
        }

        public void onMapMessagePillar(String str) {
            if (str == null || TextUtils.isEmpty(str)) {
                Log.i(ParkingModelPro.TAG, "pillar is null ");
                return;
            }
            Log.i(ParkingModelPro.TAG, "pillar 生产:onMapMessagePillar\t" + str);
            ParkingModelPro.this.getApPillarsQueue().add((sa) ParkingModelPro.this.getmGson().fromJson(str, (Class<Object>) sa.class));
        }

        @Override // defpackage.abi
        public void onSilentFavoriteState(int i, final long j) {
            if (i == 1 || i == 2) {
                rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.11
                    @Override // java.lang.Runnable
                    public void run() {
                        o.a(j);
                    }
                });
            } else {
                rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModelPro.1.12
                    @Override // java.lang.Runnable
                    public void run() {
                        o.b(j);
                    }
                });
            }
        }

        public void onFavoritePos(FavorPos favorPos) {
            c.a().d(new FavorPosEvent(new Gson().toJson(favorPos, FavorPos.class)));
        }

        @Override // defpackage.abi
        public void onHDMapCallBack(int i, int i2) {
            ParkingModelPro.this.mPresenterPro.b(i, i2);
        }

        @Override // defpackage.abi
        public void onTrainingParkSlotChange(List<b.w> list) {
            ParkingModelPro.this.mSlotIdMappingList = list;
            for (b.w wVar : list) {
                int a = wVar.a();
                int b = wVar.b();
                Log.i(ParkingModelPro.TAG, "onTrainingParkSlotChange.avmId = " + a + "," + b);
            }
        }

        @Override // defpackage.abi
        public void onStartNavMapReset() {
            this.mResetMap4NavStartPoint = true;
        }

        @Override // defpackage.abi
        public void onApMapStateChange(ApMapBean apMapBean) {
            ParkingModelPro.this.mApMapBean.setMapId(apMapBean.getMapId());
            ParkingModelPro.this.mApMapBean.setMapType(apMapBean.getMapType());
            ParkingModelPro.this.mApMapBean.setTerminalAttr(apMapBean.getTerminalAttr());
            ParkingModelPro.this.mApMapBean.setTerminalFloor(apMapBean.getTerminalFloor());
            ParkingModelPro.this.mApMapBean.setMapTime(apMapBean.getMapTime());
        }

        @Override // defpackage.abi
        public void onStartNavStateChange(int i) {
            int i2 = ParkingModelPro.this.mNavSt;
            ParkingModelPro.this.mNavSt = i;
            LogUtils.i(ParkingModelPro.TAG, "onStartNavStateChange:" + i + ", previous state:" + i2);
            i.aj ajVar = (i.aj) i.a(i.aj.class);
            if (ajVar != null) {
                ajVar.a(Integer.valueOf(ParkingModelPro.this.mNavSt));
            }
            if (i2 != 0 || ParkingModelPro.this.mNavSt != 1) {
                if (i2 != 1 || ParkingModelPro.this.mNavSt != 2) {
                    if (ParkingModelPro.this.mNavSt == 0) {
                        ParkingModelPro.this.mPresenterPro.T();
                        ((i.y) i.a(i.y.class)).d().intValue();
                        if (this.mHasExecutedNavGuide) {
                            i.a(i.ah.class, true);
                            IntentUtil.sendCloseInfoFlowCard();
                            this.mHasExecutedNavGuide = false;
                        }
                        if (IntentUtil.getTips() == -2) {
                            IntentUtil.sendCloseInfoFlowCard();
                        }
                        i.a(i.al.class, false);
                        i.a(i.k.class, false);
                        if (NavStartGuideDialogUtil.isDialogShown()) {
                            NavStartGuideDialogUtil.dissmissDialog();
                            if (i2 == 1) {
                                XToast.show(tw.g[13]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    int unused = ParkingModelPro.this.mNavSt;
                    return;
                }
                ParkingModelPro.this.mPresenterPro.r(ParkingModelPro.this.mNavHillState);
                i.a(i.ah.class, false);
                i.a(i.al.class, false);
                this.mHasExecutedNavGuide = true;
                rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.nav_start_tips));
            } else if (this.mResetMap4NavStartPoint) {
                this.mResetMap4NavStartPoint = false;
                int terminalAttr = ParkingModelPro.this.mApMapBean != null ? ParkingModelPro.this.mApMapBean.getTerminalAttr() : 4;
                if (abg.a().d() == 0) {
                    IntentUtil.sendNavStartFlowCard(terminalAttr);
                    return;
                }
                LogUtils.i(ParkingModelPro.TAG, "queue info flow tips for nav start after app exit for 28009");
                i.a(i.al.class, true);
            }
        }

        @Override // defpackage.abi
        public void onStartNavTipsChange(int i, float f, float f2, int i2) {
            ParkingModelPro.this.mNavHillState = i2;
            if (ParkingModelPro.this.mNavTips != i) {
                int unused = ParkingModelPro.this.mNavTips;
                ParkingModelPro.this.mNavTips = i;
                LogUtils.i(ParkingModelPro.TAG, "onStartNavTipsChange, tips:" + i + ", featureDistance:" + f + ", startPointDistance:" + f2 + ", hillState:" + i2);
                ParkingModelPro.this.mPresenterPro.a(ParkingModelPro.this.mNavTips, (int) f, (int) f2, 0, i2);
                this.mNavFeatureTotalDistance = f;
            } else if (ParkingModelPro.this.mNavTips == 2 || ParkingModelPro.this.mNavTips == 1 || ParkingModelPro.this.mNavTips == 5 || ParkingModelPro.this.mNavTips == 3 || ParkingModelPro.this.mNavTips == 8 || ParkingModelPro.this.mNavTips == 9 || ParkingModelPro.this.mNavTips == 6 || ((ParkingModelPro.this.mNavTips <= 21 && ParkingModelPro.this.mNavTips >= 14) || ParkingModelPro.this.mNavTips == 7 || ParkingModelPro.this.mNavTips == 4)) {
                LogUtils.d(ParkingModelPro.TAG, "nav refresh direction:" + ParkingModelPro.this.mNavTips + ", rest distance:" + f + ", total feature distance:" + this.mNavFeatureTotalDistance);
                float f3 = this.mNavFeatureTotalDistance;
                float f4 = 0.0f;
                if (f3 > 0.0f && f3 - 6.0f != 0.0f) {
                    float f5 = 1.0f - ((f - 6.0f) / (f3 - 6.0f));
                    if (f5 >= 0.0f && f5 <= 1.0f) {
                        f4 = f5;
                    }
                }
                ParkingModelPro.this.mPresenterPro.a(ParkingModelPro.this.mNavTips, (int) f, (int) f2, (int) (f4 * 100.0f), i2);
            }
        }
    };

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<b.h> getApLaneLineInfoList() {
        return null;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void routeAp2SrParkLotChoseIndex(int i) {
    }

    public void setmCurrentFloorNum(int i) {
        PerformanceTestUnit.log(TAG, "currentFloorNum:" + i, 2000L, true);
        this.mCurrentFloorNum = this.mCurrentFloorNum;
    }

    public int getmCurrentFloor() {
        return this.mCurrentFloor;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public int getIndexOfAllGuildLine() {
        return this.mIndexOfAllGuildLine;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void setIsStartTraining(boolean z) {
        this.mIsStartTraining = z;
        if (!this.mIsStartTraining) {
            this.mStartS = 0.0f;
        }
        Log.i(TAG, "setIsStartTraining.mStartS = " + this.mStartS + "," + z);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public float getStartTrainingS() {
        return this.mStartS;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public float getCurrentS() {
        a.c cVar = this.mLocationData;
        if (cVar == null) {
            return 0.0f;
        }
        return cVar.e();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public boolean isStartTraining() {
        return this.mIsStartTraining;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public MiniMapModel getMimiMapModel() {
        if (this.mMimiMapModel == null) {
            this.mMimiMapModel = new MiniMapModel();
        }
        return this.mMimiMapModel;
    }

    public Gson getmGson() {
        if (this.mGson == null) {
            this.mGson = new Gson();
        }
        return this.mGson;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public Queue getApPillarsQueue() {
        if (this.mApPillarsQueue == null) {
            this.mApPillarsQueue = new ConcurrentLinkedDeque();
            initPillars();
        }
        return this.mApPillarsQueue;
    }

    private void initPillars() {
        int length = sa.a.length;
        for (int i = 0; i < length; i++) {
            this.mApPillarsQueue.add((sa) getmGson().fromJson(sa.a[i], (Class<Object>) sa.class));
        }
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<sc> getStaticMapAllRoadPathCduPoint() {
        if (this.mStaticMapAllRoadPathCduPointCache == null) {
            this.mStaticMapAllRoadPathCduPointCache = new ArrayList();
        }
        return this.mStaticMapAllRoadPathCduPointCache;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public p getmFirstTrainingPathCduPoint() {
        return this.mFirstTrainingPathCduPoint;
    }

    public void setmFirstTrainingPathCduPoint(p pVar) {
        this.mFirstTrainingPathCduPoint = pVar;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public Queue<Runnable> getUnExecuteRefreshRoadQueue() {
        if (this.mRefreshRoadQueue == null) {
            this.mRefreshRoadQueue = new ConcurrentLinkedDeque();
        }
        return this.mRefreshRoadQueue;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public Queue<Runnable> getUnExecuteRefreshRunnable() {
        if (this.mRefreshMapQueue == null) {
            this.mRefreshMapQueue = new ConcurrentLinkedDeque();
        }
        return this.mRefreshMapQueue;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public Queue getTrainingSpdbumpsQueue() {
        if (this.mTrainingSpdbumpsQueue == null) {
            this.mTrainingSpdbumpsQueue = new ConcurrentLinkedDeque();
        }
        return this.mTrainingSpdbumpsQueue;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public Queue getTrainingParklotsQueue() {
        if (this.mTrainingParklotsQueue == null) {
            this.mTrainingParklotsQueue = new ConcurrentLinkedDeque();
        }
        return this.mTrainingParklotsQueue;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public int getCurrentTrainingSpdBumpCount() {
        return this.m3DPresenterPro.w().d();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public int getAPSpdBumpCount() {
        return this.m3DPresenterPro.B();
    }

    public List<ahz.c.h> getmFloorListCP() {
        if (this.mFloorListCP == null) {
            this.mFloorListCP = new CopyOnWriteArrayList();
        }
        return this.mFloorListCP;
    }

    public CopyOnWriteArrayList<p> getTraingOdoPointsCache() {
        if (this.mTrainingOdoPointCache == null) {
            this.mTrainingOdoPointCache = new CopyOnWriteArrayList<>();
        }
        return this.mTrainingOdoPointCache;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<TrainingSlotBean> getmTrainingSlotList() {
        return (List) getTrainingParklotsQueue().poll();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<TrainingSpdBumpBean> getmTrainingSpdBumpList() {
        return (List) getTrainingSpdbumpsQueue().poll();
    }

    public void setmTrainingStartLocationData(a.c cVar) {
        this.mTrainingStartLocationData = cVar;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public a.c getStartTrainingOdoMeterInfo() {
        return this.mTrainingStartLocationData;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<p> getDynaTrainingModelGuidelinePoints() {
        filterPoint(5);
        return this.mPoints;
    }

    protected void filterPoint(int i) {
        p pVar;
        List<p> list;
        this.mPoints.clear();
        this.mPointList.clear();
        this.mPointList.addAll(getTraingOdoPointsCache());
        p pVar2 = null;
        if (this.mPointList.size() > 0) {
            List<p> list2 = this.mPointList;
            pVar = list2.get(list2.size() - 1);
        } else {
            pVar = null;
        }
        if (this.mPointList.size() > 1) {
            pVar2 = this.mPointList.get(list.size() - 2);
        }
        if (this.mPointList.size() >= i + 2) {
            int size = this.mPointList.size() - ((this.mPointList.size() - 2) % i);
            int i2 = 0;
            while (i2 < this.mPointList.size() - 2) {
                if (i2 == 0 && this.mPointList.get(i2).equals(getmFirstTrainingPathCduPoint())) {
                    this.mPoints.add(getmFirstTrainingPathCduPoint());
                }
                int i3 = i2 + 1;
                if (i3 % i == 0) {
                    this.mPoints.add(this.mPointList.get(i2));
                }
                if (i2 < size) {
                    getTraingOdoPointsCache().remove(0);
                }
                i2 = i3;
            }
        }
        if (pVar2 != null) {
            this.mPoints.add(pVar2);
        }
        if (pVar != null) {
            this.mPoints.add(pVar);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void clearTrainingModelGuildeline() {
        Log.i(TAG, "odoPoint >> clearTrainingModelGuildeline");
        getTraingOdoPointsCache().clear();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void onStartTrainingModel() {
        if (getLocationData() != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
            stringBuffer.setLength(0);
            stringBuffer.append("HasMap:  ");
            stringBuffer.append(getLocationData().f() == 1);
            stringBuffer.append("carPos:  ");
            stringBuffer.append("x,");
            stringBuffer.append(decimalFormat.format(this.mLocationData.a().a()));
            stringBuffer.append("y,");
            stringBuffer.append(decimalFormat.format(this.mLocationData.a().b()));
            stringBuffer.append("z,");
            stringBuffer.append(decimalFormat.format(this.mLocationData.a().c()));
            stringBuffer.append("angle: ");
            stringBuffer.append(decimalFormat.format(this.mLocationData.b().a()));
            Log.i(TAG, "TrainingModel >> start training  reset car pos location  ");
            setmTrainingStartLocationData(getLocationData());
            this.mStartS = this.mLocationData.e();
            return;
        }
        Log.w(TAG, "location is null can not start !");
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void onEndTrainingModel() {
        clearTrainingModelGuildeline();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public boolean hasReadyFloorData() {
        return getFloorList() != null && getFloorList().size() > 0;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public boolean hasReadAllGuideLineData() {
        b.o oVar = this.mDynaAllGuildeline;
        return (oVar == null || oVar.b() == null || this.mDynaAllGuildeline.c().size() <= 0) ? false : true;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.v> getTrainingRsLinkList() {
        return this.mLinkListRs;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public b.o getDynaAllGuildeline() {
        return this.mDynaAllGuildeline;
    }

    public List<b.o> getmDynamicXpApTraTrajectoryList() {
        return this.mXpApTraTrajectoryDataTypeDataList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<b.h> getDynamicLaneLineInfoDataList() {
        return this.mXApLaneLineInfoDataList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public ArrayList<b.o> getDynaGuidelineByType(int i) {
        List<b.o> list = getmDynamicXpApTraTrajectoryList();
        if (list == null || list.size() == 0) {
            return null;
        }
        this.mGuildLineTemp.clear();
        for (b.o oVar : list) {
            if (i != 0 && i == oVar.a()) {
                this.mGuildLineTemp.add(oVar);
            }
        }
        return this.mGuildLineTemp;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public String getDynamicDebugInfo() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
        int i7 = 0;
        stringBuffer.setLength(0);
        stringBuffer.append("ap:  ");
        stringBuffer.append("{ ");
        stringBuffer.append("apSt: " + this.mApSt);
        stringBuffer.append(", ");
        stringBuffer.append("apFail: " + this.mApFail);
        stringBuffer.append(" }");
        stringBuffer.append("\n");
        stringBuffer.append("apTips:  ");
        stringBuffer.append("{ ");
        stringBuffer.append("tip: " + this.mApTips);
        stringBuffer.append(", ");
        stringBuffer.append("abnormal: " + this.mApAbnormal);
        stringBuffer.append(" }");
        stringBuffer.append("\n");
        stringBuffer.append("trainningTips:  ");
        stringBuffer.append("{ ");
        stringBuffer.append("st: " + this.mCurrentTrainingSt);
        stringBuffer.append(", ");
        stringBuffer.append("tip: " + this.mCurrentTrainingTips);
        stringBuffer.append(", ");
        stringBuffer.append("fail: ");
        int[] iArr = this.mCurrentErrTips;
        if (iArr == null) {
            stringBuffer.append(iArr);
        } else {
            stringBuffer.append("[ ");
            for (int i8 = 0; i8 < this.mCurrentErrTips.length; i8++) {
                if (i8 != 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(this.mCurrentErrTips[i8]);
            }
            stringBuffer.append(" ]");
        }
        stringBuffer.append(" }");
        stringBuffer.append("\n");
        if (getLocationData() != null) {
            stringBuffer.append("HasMap:  ");
            stringBuffer.append(getLocationData().f() == 1);
            stringBuffer.append("\n");
            stringBuffer.append("carPos:  ");
            stringBuffer.append("x: ");
            stringBuffer.append(this.decimalFormat.format(this.mLocationData.a().a()));
            stringBuffer.append(", y: ");
            stringBuffer.append(this.decimalFormat.format(this.mLocationData.a().b()));
            stringBuffer.append(", z: ");
            stringBuffer.append(this.decimalFormat.format(this.mLocationData.a().c()));
            stringBuffer.append("    angle: ");
            stringBuffer.append(this.decimalFormat.format(this.mLocationData.b().a()));
            stringBuffer.append("\n");
        }
        if (getDynamicSlotLists() != null) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            for (a.k kVar : getDynamicSlotLists()) {
                if (kVar.j() == 1) {
                    i3++;
                } else if (kVar.j() != 0) {
                    i2++;
                } else if (kVar.e() == 0) {
                    i4++;
                } else if (kVar.e() == 1) {
                    i5++;
                } else {
                    i++;
                }
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        stringBuffer.append("Slots:  ");
        stringBuffer.append("{");
        stringBuffer.append("free: " + i3);
        stringBuffer.append(", ");
        stringBuffer.append("parked: " + i4);
        stringBuffer.append(", ");
        stringBuffer.append("unkonw: " + i5);
        stringBuffer.append(", ");
        stringBuffer.append("errSlotType: " + i2);
        stringBuffer.append(", ");
        stringBuffer.append("errAttr: " + i);
        stringBuffer.append("}");
        stringBuffer.append("\n");
        stringBuffer.append("DynaObjCount:  ");
        stringBuffer.append(getApDynaObjectDataList() == null ? "0" : Integer.valueOf(getApDynaObjectDataList().size()));
        stringBuffer.append("\n");
        stringBuffer.append("MapSpdBump:  ");
        if (getLandmarksTypeDataList() != null) {
            i6 = 0;
            for (ahz.c.n nVar : getLandmarksTypeDataList()) {
                if (nVar.a() == 1) {
                    i6++;
                }
            }
        } else {
            i6 = 0;
        }
        stringBuffer.append(i6);
        stringBuffer.append("\n");
        stringBuffer.append("GuideLines:  ");
        List<b.o> list = this.mXpApTraTrajectoryDataTypeDataList;
        stringBuffer.append(list == null ? "0" : Integer.valueOf(list.size()));
        stringBuffer.append("\n");
        stringBuffer.append("GuildLineIndex:  " + getIndexOfAllGuildLine());
        stringBuffer.append("\n");
        StringBuilder sb = new StringBuilder();
        sb.append("AllGuildlines: ");
        b.o oVar = this.mDynaAllGuildeline;
        sb.append((oVar == null || oVar.b() == null) ? "0" : Integer.valueOf(this.mDynaAllGuildeline.b().size()));
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        List<b.o> list2 = this.mXpApTraTrajectoryDataTypeDataList;
        if (list2 != null && list2.size() > 0) {
            stringBuffer.append("[");
            for (b.o oVar2 : this.mXpApTraTrajectoryDataTypeDataList) {
                stringBuffer.append("{");
                stringBuffer.append("type:" + oVar2.a());
                stringBuffer.append(",");
                stringBuffer.append("count:" + oVar2.d());
                stringBuffer.append("}");
            }
            stringBuffer.append("]");
        }
        stringBuffer.append("\n");
        stringBuffer.append("lanelines:   ");
        stringBuffer.append(this.mXApLaneLineInfoDataList != null ? Integer.valueOf(this.mXpApTraTrajectoryDataTypeDataList.size()) : "0");
        List<b.h> list3 = this.mXApLaneLineInfoDataList;
        if (list3 != null && list3.size() > 0) {
            for (b.h hVar : this.mXApLaneLineInfoDataList) {
                stringBuffer.append("{");
                stringBuffer.append(i7);
                stringBuffer.append(":");
                stringBuffer.append(hVar.a());
                stringBuffer.append("}");
                i7++;
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void bind3D(tk tkVar) {
        this.m3DPresenterPro = (ts) tkVar;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void bind(to toVar) {
        this.mPresenterPro = (tw) toVar;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void initMap() {
        abg.a().a(this.mXpuMessageListener);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<a.k> getDynamicSlotLists() {
        return this.mSlotDataList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<b.d> getApDynaObjectDataList() {
        return this.mApDynaObjectDataList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<b.q> getApStaticObjectDataList() {
        return this.mApStaticObjectDataList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.n> getLandmarksTypeDataList() {
        return this.mLandmarksTypeDataList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<SpdBumpBean> getSpdBumpBeanList() {
        return this.mSpdBumpBeanList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public int getFloorNumByZValue(float f) {
        List<ahz.c.h> list = this.mFloorList;
        if (list == null) {
            return 0;
        }
        for (ahz.c.h hVar : list) {
            int a = hVar.a();
            float c = hVar.c();
            float b = hVar.b();
            if (f > c && f < b) {
                return a;
            }
        }
        return 0;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.p> getLaneLines() {
        return this.mLaneLines;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void routeAp2SrMapReq() {
        Log.i(TAG, "data process -> request Sr Map data");
        abg.a().a(MAP_REQUEST);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void routeAp2SrTrainingMapReq() {
        Log.i(TAG, "data process -> request Sr training Map data");
        abg.a().a(TRAINING_MAP_REQUEST);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void routeAp2SrTrainingCmd(int i) {
        abg.a().c(i);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<b.w> getSlotIdMappingList() {
        return this.mSlotIdMappingList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void resetSlotIdMappingList() {
        this.mSlotIdMappingList = new ArrayList();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public int getAPStatus() {
        return this.mApSt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineSlot() {
        int i;
        boolean z = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (a.k kVar : getDynamicSlotLists()) {
            if (kVar.o() == 1) {
                i2++;
                i8 = kVar.n();
                f = kVar.g().a();
                f2 = kVar.g().b();
                f3 = kVar.g().c();
            }
            if (kVar.j() == 1) {
                i3++;
            } else if (kVar.j() != 0) {
                i6++;
            } else if (kVar.e() == 0) {
                i5++;
            } else if (kVar.e() == 1) {
                i4++;
            } else {
                i7++;
            }
        }
        if (this.mFavorNum != i2) {
            this.mFavorNum = i2;
            z = true;
        }
        if (this.mFreeNum != i3) {
            i.x xVar = (i.x) i.a(i.x.class);
            this.mCanPlaySlotFound = ((i.ah) i.a(i.ah.class)).d().booleanValue();
            Log.i(TAG, "mCanPlaySlotFound = " + this.mCanPlaySlotFound);
            if (i3 > this.mFreeNum && xVar.d().booleanValue() && this.mCanPlaySlotFound && ((i = this.mApTips) == 18 || i == 19 || i == 20 || i == 21 || i == 23 || i == 22)) {
                SoundPlayer.getInstance().playParkLotFound();
            }
            this.mFreeNum = i3;
            z = true;
        }
        if (this.mAvmUnknowNum != i4) {
            this.mAvmUnknowNum = i4;
            z = true;
        }
        if (this.mAvmParkedNum != i5) {
            this.mAvmParkedNum = i5;
            z = true;
        }
        if (this.mAvmErrAttrNum != i7) {
            this.mAvmErrAttrNum = i7;
            z = true;
        }
        if (this.mErrSlotTypeNum != i6) {
            this.mErrSlotTypeNum = i6;
            z = true;
        }
        if (!z || this.mApSt == 3) {
            return;
        }
        String str = "常用 = " + i2;
        if (i2 > 0) {
            str = ", {MapSlotId=" + i8 + ", X=" + f + ", Y=" + f2 + ", Z=" + f3 + "}";
        }
        LogUtils.i(TAG, "XPU实时车位，" + str + ", 可泊 = " + i3 + ", 未知 = " + i4 + ", 不可泊占位 = " + i5 + ", 错误属性 = " + i7 + ", 错误类型 = " + i6);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void clearMapData() {
        String str;
        String str2;
        String str3;
        StringBuilder sb;
        String str4;
        StringBuilder sb2;
        String str5;
        String str6;
        Log.i(TAG, "STATIC_MAP_TASK > clearMapData !");
        this.mMapRequest = false;
        try {
            try {
                if (this.mFloorList != null) {
                    this.mFloorList = null;
                }
                if (this.mSlotTypeList != null) {
                    this.mSlotTypeList = null;
                }
                if (this.mLinkList != null) {
                    this.mLinkList = null;
                }
                if (this.mLandmarksTypeDataList != null) {
                    this.mLandmarksTypeDataList = null;
                }
                if (this.mLaneLines != null) {
                    this.mLaneLines = null;
                }
                this.mVenue = null;
                str3 = TAG;
                sb = new StringBuilder();
                sb.append("STATIC_MAP_TASK  finish clearMapData :\tfloorSize:\t");
                if (this.mFloorList != null) {
                    str6 = this.mFloorList.size() + "";
                } else {
                    str6 = "0";
                }
                sb.append(str6);
                sb.append("\tSlotTypeListSize:\t");
            } catch (Exception e) {
                Log.e(TAG, "clear data exception!");
                e.printStackTrace();
                str3 = TAG;
                sb = new StringBuilder();
                sb.append("STATIC_MAP_TASK  finish clearMapData :\tfloorSize:\t");
                if (this.mFloorList != null) {
                    str4 = this.mFloorList.size() + "";
                } else {
                    str4 = "0";
                }
                sb.append(str4);
                sb.append("\tSlotTypeListSize:\t");
                if (this.mSlotTypeList != null) {
                    sb2 = new StringBuilder();
                }
            }
            if (this.mSlotTypeList != null) {
                sb2 = new StringBuilder();
                sb2.append(this.mSlotTypeList.size());
                sb2.append("");
                str5 = sb2.toString();
                sb.append(str5);
                Log.i(str3, sb.toString());
            }
            str5 = "0";
            sb.append(str5);
            Log.i(str3, sb.toString());
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("STATIC_MAP_TASK  finish clearMapData :\tfloorSize:\t");
            if (this.mFloorList != null) {
                str = this.mFloorList.size() + "";
            } else {
                str = "0";
            }
            sb3.append(str);
            sb3.append("\tSlotTypeListSize:\t");
            if (this.mSlotTypeList != null) {
                str2 = this.mSlotTypeList.size() + "";
            } else {
                str2 = "0";
            }
            sb3.append(str2);
            Log.i(TAG, sb3.toString());
            throw th;
        }
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.h> getFloorList() {
        return getmFloorListCP();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.v> getLinkList() {
        return this.mLinkList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.v> getLinkListError() {
        return this.mLinkListRs;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.ab> getSlotTypeList() {
        return this.mSlotTypeList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public List<ahz.c.ab> getSlotTypeListRs() {
        return this.mSlotTypeListRs;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public ahz.c.aj getVenueData() {
        return this.mVenue;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public a.c getLocationData() {
        return this.mLocationData;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void startAP() {
        abg.a().b(1);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void routeAp2SrAutoParkReq(int i) {
        abg.a().a(i);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void routeAp2SrParkLotChoseCoordi(float f, float f2, float f3) {
        abg.a().a(f, f2, f3);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public boolean hasAvailableParklot() {
        if (getDynamicSlotLists() == null || getDynamicSlotLists().size() <= 0) {
            return false;
        }
        for (a.k kVar : getDynamicSlotLists()) {
            if (kVar.j() == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public boolean hasParklots() {
        return getDynamicSlotLists() != null && getDynamicSlotLists().size() > 0;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public int getParkLotNum() {
        return this.mFreeNum;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public ApMapBean getApMapBean() {
        return this.mApMapBean;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public float getRemainDis() {
        return this.mRemainDis;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public boolean isInNavStartPointProcedure() {
        i.a(i.k.class);
        return this.mNavSt == 2 && ((i.k) i.a(i.k.class)).d().booleanValue();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void startFoundParkLot() {
        abg.a().b(2);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void continueFoundParkLot() {
        abg.a().b(3);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void exitFoundParkLot() {
        abg.a().b(4);
    }

    public int getNavHillState() {
        return this.mNavHillState;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro
    public void resetNavStateWhenStart() {
        this.mNavTips = -1;
        this.mNavHillState = -1;
    }
}
