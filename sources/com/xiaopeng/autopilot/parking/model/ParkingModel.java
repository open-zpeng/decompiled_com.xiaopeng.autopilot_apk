package com.xiaopeng.autopilot.parking.model;

import android.annotation.TargetApi;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.base.utils.WheelUtil;
import com.xiaopeng.autopilot.parking.bean.caldata.BoxRData;
import com.xiaopeng.autopilot.parking.bean.caldata.DrivingData;
import com.xiaopeng.autopilot.parking.bean.caldata.FeatureRData;
import com.xiaopeng.autopilot.parking.bean.caldata.InLocatData;
import com.xiaopeng.autopilot.parking.bean.caldata.ParkLotRData;
import com.xiaopeng.autopilot.parking.bean.caldata.Point2D;
import com.xiaopeng.autopilot.parking.bean.candata.BoxDataLeft;
import com.xiaopeng.autopilot.parking.bean.candata.BoxDataRight;
import com.xiaopeng.autopilot.parking.bean.candata.LocatData;
import com.xiaopeng.autopilot.parking.bean.candata.ParkData;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.autopilot.parking.utils.JniUtil;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IAvmController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IScuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IScuController;
import com.xiaopeng.lib.utils.LogUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class ParkingModel implements IParkingModel {
    private static final String TAG = "ParkingModel";
    private ScheduledExecutorService mExecutorService;
    private LocatData mLocatData;
    private long mLogTime;
    private ParkData mParkData;
    @Deprecated
    private tn mPresenter;
    private Object mParkLock = new Object();
    private Object mBoxLock = new Object();
    private Object mFeatureLock = new Object();
    private int mFeatureNum = 0;
    private int mLeftAvmNum = 0;
    private int mRightAvmNum = 0;
    private int mParkLotNum = 0;
    private int mLowConfidenceNum = 0;
    private int mHightConfidenceNum = 0;
    private int mNarrowNum = 0;
    private int mCurrentTip = 0;
    private ArrayList<ParkLotRData> mCacheParkLotList = new ArrayList<>(6);
    private ArrayBlockingQueue<FeatureRData> mCacheFeatureQueue = new ArrayBlockingQueue<>(30);
    private ArrayBlockingQueue<BoxRData> mCacheBoxQueue = new ArrayBlockingQueue<>(30);
    private ArrayList<ParkLotItem> mDrawParkLotIemList = new ArrayList<>();
    private ArrayList<Point2D> mDrawLocatPointList = new ArrayList<>();
    public volatile boolean mIsCaculateFeature = false;
    private Runnable mCollecteDrivingData = new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModel.2
        private SimpleDateFormat tempSimpleFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        @Override // java.lang.Runnable
        public void run() {
            a.g().getBaseContext().getFilesDir();
            long currentTimeMillis = System.currentTimeMillis();
            DrivingData drivingData = DrivingData.getInstance();
            Location lastKnownLocation = ((LocationManager) a.g().getSystemService("location")).getLastKnownLocation("gps");
            if (lastKnownLocation != null) {
                double longitude = lastKnownLocation.getLongitude();
                double latitude = lastKnownLocation.getLatitude();
                double altitude = lastKnownLocation.getAltitude();
                double accuracy = lastKnownLocation.getAccuracy();
                drivingData.setCDU_SCU_GPS_LONG_itude((float) longitude);
                drivingData.setCDU_SCU_GPS_Latitude((float) latitude);
                drivingData.setCDU_SCU_GPS_ALtitude((float) altitude);
                drivingData.setCDU_SCU_GPS_Accuracy((float) accuracy);
            }
            drivingData.setVCU_CurrentGearLev(((i.u) i.a(i.u.class)).d().intValue());
            try {
                drivingData.setBCM_DriverDroorLockSt(c.a().f().getDoorLockState() ? 1 : 0);
            } catch (Exception unused) {
                Log.i(ParkingModel.TAG, "get door state error");
                drivingData.setBCM_DriverDroorLockSt(-1);
            }
            drivingData.setTime(this.tempSimpleFormat.format(Long.valueOf(Calendar.getInstance().getTimeInMillis())));
            if (d.c()) {
                Log.i(ParkingModel.TAG, drivingData.toString());
            }
            JniUtil.drivingData(drivingData);
            if (d.c()) {
                Log.i("GPS", "cost  time:\t" + (System.currentTimeMillis() - currentTimeMillis));
                Log.i("GPS", "value :\t" + drivingData.toString());
            }
        }
    };
    private Runnable mFeatureParkingRunnable = new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModel.3
        private ArrayList<ParkLotRData> mTempOutParkLotList = new ArrayList<>();
        private ArrayList<FeatureRData> mTmpOutFeatureList = new ArrayList<>();
        private boolean tempHasFavor = false;
        private int temoHomeSlotId = 0;
        private int mJniOutSlotNum = 0;
        private int mJniOuthightConfidenceNum = 0;
        private int mJniOutlowConfidenceNum = 0;
        private int mJniOutnarrowNum = 0;

        @Override // java.lang.Runnable
        public void run() {
            AnonymousClass3 anonymousClass3 = this;
            try {
                if (System.currentTimeMillis() - ParkingModel.this.mLogTime > 30000) {
                    ParkingModel.this.mLogTime = System.currentTimeMillis();
                    Log.i(ParkingModel.TAG, "mIsCaculateFeature = " + ParkingModel.this.mIsCaculateFeature + ",mLocatData = " + ParkingModel.this.mLocatData);
                }
                if (ParkingModel.this.mIsCaculateFeature) {
                    ParkingModel.this.combineParkData();
                    if (ParkingModel.this.mLocatData == null) {
                        return;
                    }
                    anonymousClass3.mTempOutParkLotList.clear();
                    anonymousClass3.mTmpOutFeatureList.clear();
                    Object[] array = ParkingModel.this.mCacheParkLotList.toArray();
                    Object[] array2 = ParkingModel.this.mCacheFeatureQueue.toArray();
                    Object[] array3 = ParkingModel.this.mCacheBoxQueue.toArray();
                    InLocatData inLocatData = new InLocatData(ParkingModel.this.mLocatData.SCU_Locat_x, ParkingModel.this.mLocatData.SCU_Locat_y, ParkingModel.this.mLocatData.SCU_Locat_theta, ParkingModel.this.mLocatData.SCU_Locat_S);
                    if (d.c()) {
                        ParkingModel.this.inLog(array3, array);
                    }
                    JniUtil.getRelativeDataEdward(inLocatData, array2, array3, array, anonymousClass3.mTempOutParkLotList, d.d(ParkingModel.this.mCurrentTip));
                    if (d.c()) {
                        ParkingModel.this.outLog(anonymousClass3.mTmpOutFeatureList, anonymousClass3.mTempOutParkLotList);
                    }
                    for (int length = array3.length; length > 0; length--) {
                        ParkingModel.this.mCacheBoxQueue.poll();
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<ParkLotRData> it = anonymousClass3.mTempOutParkLotList.iterator();
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (it.hasNext()) {
                        ParkLotRData next = it.next();
                        if (!ParkLotRData.isItemHightConfidence(next.tag) && !ParkLotRData.isItemLowConfidence(next.tag) && !ParkLotRData.isItemNarrow(next.tag)) {
                            next.index = -1;
                        }
                        if (ParkLotRData.isItemHightConfidence(next.tag)) {
                            i3++;
                        } else if (ParkLotRData.isItemLowConfidence(next.tag)) {
                            i2++;
                        } else if (ParkLotRData.isItemNarrow(next.tag)) {
                            i4++;
                        }
                        int i5 = i3 + i2 + i4;
                        Iterator<ParkLotRData> it2 = it;
                        int i6 = i2;
                        int i7 = i3;
                        int i8 = i4;
                        try {
                            arrayList.add(new ParkLotItem(next.index, next.dir, next.rTheta, next.slotLen, next.xa, next.ya, next.xb, next.yb, next.xc, next.yc, next.tag, next.isParkingable, next.isFavor));
                            anonymousClass3 = this;
                            if (!anonymousClass3.tempHasFavor && next.isFavor == 1) {
                                anonymousClass3.tempHasFavor = true;
                                anonymousClass3.temoHomeSlotId = next.index + 1;
                            }
                            it = it2;
                            i2 = i6;
                            i3 = i7;
                            i4 = i8;
                            i = i5;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return;
                        }
                    }
                    ParkingModel.this.sendDataToFavoritePark(anonymousClass3.temoHomeSlotId, anonymousClass3.tempHasFavor, arrayList);
                    if (anonymousClass3.mJniOutSlotNum != i) {
                        LogUtils.i(ParkingModel.TAG, "jni out 可泊车位数 = " + i + ", out高置信度 = " + i3 + ", out低置信度 = " + i2 + ", out窄车位 = " + i4);
                        anonymousClass3.mJniOutSlotNum = i;
                    }
                    if (anonymousClass3.mJniOutlowConfidenceNum != i2) {
                        LogUtils.i(ParkingModel.TAG, "jni out 可泊车位数 = " + i + ", out高置信度 = " + i3 + ", out低置信度 = " + i2 + ", out窄车位 = " + i4);
                        anonymousClass3.mJniOutlowConfidenceNum = i2;
                    }
                    if (anonymousClass3.mJniOutnarrowNum != i4) {
                        LogUtils.i(ParkingModel.TAG, "jni out 可泊车位数 = " + i + ", out高置信度 = " + i3 + ", out低置信度 = " + i2 + ", out窄车位 = " + i4);
                        anonymousClass3.mJniOutnarrowNum = i4;
                    }
                    if (anonymousClass3.mJniOuthightConfidenceNum != i3) {
                        LogUtils.i(ParkingModel.TAG, "jni out 可泊车位数 = " + i + ", out高置信度 = " + i3 + ", out低置信度 = " + i2 + ", out窄车位 = " + i4);
                        anonymousClass3.mJniOuthightConfidenceNum = i3;
                    }
                    ParkingModel.this.mDrawParkLotIemList.clear();
                    ParkingModel.this.mDrawParkLotIemList.addAll(arrayList);
                    arrayList.clear();
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    };

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public void sendParkLotRecv(int i) {
    }

    public ParkingModel(tn tnVar) {
        this.mPresenter = tnVar;
        if (d.f() || d.n()) {
            return;
        }
        Log.i(TAG, "中高配车，ParkingModel注册后台线程任务");
        this.mExecutorService = new ScheduledThreadPoolExecutor(2);
        this.mExecutorService.scheduleAtFixedRate(this.mFeatureParkingRunnable, 50L, 50L, TimeUnit.MILLISECONDS);
        ((ThreadPoolExecutor) this.mExecutorService).setKeepAliveTime(50L, TimeUnit.MILLISECONDS);
    }

    @TargetApi(28)
    private void registerGness() {
        if (Build.VERSION.SDK_INT >= 28) {
            ((LocationManager) a.g().getSystemService("location")).registerGnssStatusCallback(new GnssStatus.Callback() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModel.1
                @Override // android.location.GnssStatus.Callback
                public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
                    rh.a().f(new Runnable() { // from class: com.xiaopeng.autopilot.parking.model.ParkingModel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.i(ParkingModel.TAG, "postBackground-Runnable registerGnssStatusCallback");
                            DrivingData.getInstance().setGsv_info(gnssStatus);
                        }
                    });
                }
            });
        }
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.ScuOperationTipUpdateEventMsg scuOperationTipUpdateEventMsg) {
        int intValue = scuOperationTipUpdateEventMsg.getData().intValue();
        LogUtils.i(TAG, "SCU状态信号OperationTip = " + intValue + " " + d.a(intValue));
        this.mPresenter.l(intValue);
        if (intValue != this.mCurrentTip) {
            if (intValue == 0) {
                resetData();
            } else if (intValue != 0 && intValue != 17 && intValue != 27) {
                enableCaculateThread(true);
            }
        }
        this.mCurrentTip = intValue;
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.ScuLocationUpdateEventMsg scuLocationUpdateEventMsg) {
        this.mLocatData = new LocatData(scuLocationUpdateEventMsg.getData());
        if (d.c()) {
            LogUtils.v(TAG, this.mLocatData.toString());
        }
        if (d.e && scuLocationUpdateEventMsg.getData() != null) {
            DrivingData.getInstance().setSCU_Locat_x(scuLocationUpdateEventMsg.getData()[0]);
            DrivingData.getInstance().setSCU_Locat_y(scuLocationUpdateEventMsg.getData()[1]);
            DrivingData.getInstance().setSCU_Locat_theta(scuLocationUpdateEventMsg.getData()[4]);
            DrivingData.getInstance().setSCU_Locat_S(scuLocationUpdateEventMsg.getData()[5]);
            DrivingData.getInstance().setSCU_Locat_theta_roll(scuLocationUpdateEventMsg.getData()[6]);
            DrivingData.getInstance().setSCU_Locat_theta_pitch(scuLocationUpdateEventMsg.getData()[7]);
            DrivingData.getInstance().setSCU_Locat_CurSpd(scuLocationUpdateEventMsg.getData()[8]);
        }
        this.mPresenter.b(this.mLocatData.SCU_Veh_Speed);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEventSteeringAngle(IAvmController.CameraSteerAngleEventMsg cameraSteerAngleEventMsg) {
        if (!d.e || d.f()) {
            return;
        }
        Float data = cameraSteerAngleEventMsg.getData();
        WheelUtil.calculateWheelAngle(data.floatValue());
        DrivingData.getInstance().setEPS_SAS_SteeringAngle(data.floatValue());
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.AllParklotDataEventMsg allParklotDataEventMsg) {
        this.mParkData = new ParkData(allParklotDataEventMsg.getData());
        if (d.c()) {
            LogUtils.v(TAG, this.mParkData.toString());
        }
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.SensorDataUpdateEventMsg sensorDataUpdateEventMsg) {
        FeatureRData featureRData = new FeatureRData(sensorDataUpdateEventMsg.getData());
        if (featureRData.index == this.mFeatureNum) {
            return;
        }
        initFeatureDataToDrivingData(featureRData);
        this.mFeatureNum = featureRData.index;
    }

    private void initFeatureDataToDrivingData(FeatureRData featureRData) {
        DrivingData drivingData = DrivingData.getInstance();
        drivingData.setA_ARR_CCP1_x1(featureRData.x1);
        drivingData.setA_ARR_CCP1_x2(featureRData.x2);
        drivingData.setARR_CCP1_y1(featureRData.y1);
        drivingData.setARR_CCP1_y2(featureRData.y2);
        drivingData.setARR_DIR_CCP(featureRData.dir);
        drivingData.setARR_NUM_CCP(featureRData.index);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.LeftAvmDataUpdateEventMsg leftAvmDataUpdateEventMsg) {
        BoxDataLeft boxDataLeft = new BoxDataLeft(leftAvmDataUpdateEventMsg.getData());
        if (d.c()) {
            LogUtils.v(TAG, boxDataLeft.toString());
        }
        if (boxDataLeft.SCU_CDU_LAVMSlotCounter == this.mLeftAvmNum) {
            return;
        }
        this.mLeftAvmNum = boxDataLeft.SCU_CDU_LAVMSlotCounter;
        BoxRData boxRData = new BoxRData(boxDataLeft.SCU_CDU_LAVMSlotCounter, 1, boxDataLeft.SCU_CDU_LAVMSlotXa, boxDataLeft.SCU_CDU_LAVMSlotYa, boxDataLeft.SCU_CDU_LAVMSlotXb, boxDataLeft.SCU_CDU_LAVMSlotYb, boxDataLeft.SCU_CDU_LAVMSlotXc, boxDataLeft.SCU_CDU_LAVMSlotYc, boxDataLeft.SCU_CDU_LAVMSlotAtt);
        DrivingData.getInstance().syncParkingPtNFData(1, boxDataLeft.SCU_CDU_LAVMSlotAtt, boxDataLeft.SCU_CDU_LAVMSlotXa, boxDataLeft.SCU_CDU_LAVMSlotYa, boxDataLeft.SCU_CDU_LAVMSlotXb, boxDataLeft.SCU_CDU_LAVMSlotYb);
        LocatData locatData = this.mLocatData;
        if (locatData != null) {
            boxRData.setLocData(locatData.SCU_Locat_x, this.mLocatData.SCU_Locat_y, this.mLocatData.SCU_Locat_theta, this.mLocatData.SCU_Locat_S);
        }
        if (this.mCacheBoxQueue.offer(boxRData)) {
            return;
        }
        this.mCacheBoxQueue.remove();
        this.mCacheBoxQueue.add(boxRData);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.RightAvmDataUpdateEventMsg rightAvmDataUpdateEventMsg) {
        BoxDataRight boxDataRight = new BoxDataRight(rightAvmDataUpdateEventMsg.getData());
        if (d.c()) {
            LogUtils.v(TAG, boxDataRight.toString());
        }
        if (boxDataRight.SCU_CDU_RAVMSlotCounter == this.mRightAvmNum) {
            return;
        }
        this.mRightAvmNum = boxDataRight.SCU_CDU_RAVMSlotCounter;
        BoxRData boxRData = new BoxRData(boxDataRight.SCU_CDU_RAVMSlotCounter, 2, boxDataRight.SCU_CDU_RAVMSlotXa, boxDataRight.SCU_CDU_RAVMSlotYa, boxDataRight.SCU_CDU_RAVMSlotXb, boxDataRight.SCU_CDU_RAVMSlotYb, boxDataRight.SCU_CDU_RAVMSlotXc, boxDataRight.SCU_CDU_RAVMSlotYc, boxDataRight.SCU_CDU_RAVMSlotAtt);
        DrivingData.getInstance().syncParkingPtNFData(2, boxDataRight.SCU_CDU_RAVMSlotAtt, boxDataRight.SCU_CDU_RAVMSlotXa, boxDataRight.SCU_CDU_RAVMSlotYa, boxDataRight.SCU_CDU_RAVMSlotXb, boxDataRight.SCU_CDU_RAVMSlotYb);
        LocatData locatData = this.mLocatData;
        if (locatData != null) {
            boxRData.setLocData(locatData.SCU_Locat_x, this.mLocatData.SCU_Locat_y, this.mLocatData.SCU_Locat_theta, this.mLocatData.SCU_Locat_S);
        }
        if (this.mCacheBoxQueue.offer(boxRData)) {
            return;
        }
        this.mCacheBoxQueue.remove();
        this.mCacheBoxQueue.add(boxRData);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.ErrorTipsUpdateEventMsg errorTipsUpdateEventMsg) {
        this.mPresenter.k(errorTipsUpdateEventMsg.getData().intValue());
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public void init() {
        org.greenrobot.eventbus.c.a().a(this);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public void release() {
        org.greenrobot.eventbus.c.a().c(this);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public ArrayList<ParkLotItem> getParkLotItemList() {
        return this.mDrawParkLotIemList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public ArrayList<Point2D> getLocatPointList() {
        return this.mDrawLocatPointList;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public int getParkLotNum() {
        return this.mParkLotNum;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public int getParkLotHighNum() {
        return this.mHightConfidenceNum;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public int getParkLotLowNum() {
        return this.mLowConfidenceNum;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public int getParkLotNarrowNum() {
        return this.mNarrowNum;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModel
    public void enableCaculateThread(boolean z) {
        this.mIsCaculateFeature = z;
        LogUtils.i(TAG, "绘制线程开关：enableCaculateThread = " + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataToFavoritePark(int i, boolean z, ArrayList<ParkLotItem> arrayList) {
        if (d.e) {
            DrivingData drivingData = DrivingData.getInstance();
            try {
                if (z) {
                    CarApiUtil.setComonHomeSlotId(i);
                } else {
                    CarApiUtil.setComonHomeSlotId(0);
                }
                ParkLotItem parkLotItem = null;
                if (arrayList != null && arrayList.size() > 0) {
                    parkLotItem = arrayList.get(0);
                }
                if (parkLotItem != null) {
                    parkLotItem.getSpacePoints();
                    if (d.c()) {
                        Log.i(TAG, "drving_data , " + drivingData.toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combineParkData() {
        int i;
        ParkData parkData = this.mParkData;
        if (parkData == null) {
            return;
        }
        int i2 = 0;
        if (this.mCacheParkLotList.size() < 6) {
            this.mCacheParkLotList.clear();
            for (int i3 = 0; i3 < 6; i3++) {
                this.mCacheParkLotList.add(new ParkLotRData());
            }
        }
        ParkLotRData parkLotRData = this.mCacheParkLotList.get(0);
        ParkLotRData parkLotRData2 = this.mCacheParkLotList.get(3);
        ParkLotRData parkLotRData3 = this.mCacheParkLotList.get(4);
        ParkLotRData parkLotRData4 = this.mCacheParkLotList.get(5);
        parkLotRData.assignIn(parkData.SCU_CDU_SlotShape, parkData.SCU_CDU_Slot1Xa, parkData.SCU_CDU_Slot1Ya, parkData.SCU_CDU_Slot1Xb, parkData.SCU_CDU_Slot1Yb, parkData.SCU_CDU_Slot1Xc, parkData.SCU_CDU_Slot1Yc, parkData.SCU_CDU_Slot1Att, parkData.SCU_CDU_Slot1VD);
        this.mCacheParkLotList.get(1).assignIn(parkData.SCU_CDU_Slot2Xa, parkData.SCU_CDU_Slot2Ya, parkData.SCU_CDU_Slot2Xb, parkData.SCU_CDU_Slot2Yb, parkData.SCU_CDU_Slot2Xc, parkData.SCU_CDU_Slot2Yc, parkData.SCU_CDU_Slot2Att, parkData.SCU_CDU_Slot2VD);
        this.mCacheParkLotList.get(2).assignIn(parkData.SCU_CDU_Slot3Xa, parkData.SCU_CDU_Slot3Ya, parkData.SCU_CDU_Slot3Xb, parkData.SCU_CDU_Slot3Yb, parkData.SCU_CDU_Slot3Xc, parkData.SCU_CDU_Slot3Yc, parkData.SCU_CDU_Slot3Att, parkData.SCU_CDU_Slot3VD);
        parkLotRData2.assignIn(parkData.SCU_CDU_Slot4Xa, parkData.SCU_CDU_Slot4Ya, parkData.SCU_CDU_Slot4Xb, parkData.SCU_CDU_Slot4Yb, parkData.SCU_CDU_Slot4Xc, parkData.SCU_CDU_Slot4Yc, parkData.SCU_CDU_Slot4Att, parkData.SCU_CDU_Slot4VD);
        parkLotRData3.assignIn(parkData.SCU_CDU_Slot5Xa, parkData.SCU_CDU_Slot5Ya, parkData.SCU_CDU_Slot5Xb, parkData.SCU_CDU_Slot5Yb, parkData.SCU_CDU_Slot5Xc, parkData.SCU_CDU_Slot5Yc, parkData.SCU_CDU_Slot5Att, parkData.SCU_CDU_Slot5VD);
        parkLotRData4.assignIn(parkData.SCU_CDU_Slot6Xa, parkData.SCU_CDU_Slot6Ya, parkData.SCU_CDU_Slot6Xb, parkData.SCU_CDU_Slot6Yb, parkData.SCU_CDU_Slot6Xc, parkData.SCU_CDU_Slot6Yc, parkData.SCU_CDU_Slot6Att, parkData.SCU_CDU_Slot6VD);
        int i4 = parkData.SCU_CDU_SlotNum;
        Iterator<ParkLotRData> it = this.mCacheParkLotList.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            ParkLotRData next = it.next();
            if (next.isVaildVd()) {
                if (ParkLotRData.isCanH(next.tag)) {
                    i2++;
                } else if (ParkLotRData.isCanL(next.tag)) {
                    i5++;
                } else if (ParkLotRData.isCanN(next.tag)) {
                    i6++;
                }
            }
        }
        if (this.mParkLotNum != i4) {
            LogUtils.i(TAG, "SCU可泊车位数 = " + i4 + ", 高置信度 = " + i2 + ", 低置信度 = " + i5 + ", 窄车位 = " + i6);
            this.mParkLotNum = i4;
        }
        if (this.mLowConfidenceNum != i5) {
            LogUtils.i(TAG, "SCU可泊车位数 = " + i4 + ", 高置信度 = " + i2 + ", 低置信度 = " + i5 + ", 窄车位 = " + i6);
            this.mLowConfidenceNum = i5;
        }
        if (this.mNarrowNum != i6) {
            LogUtils.i(TAG, "SCU可泊车位数 = " + i4 + ", 高置信度 = " + i2 + ", 低置信度 = " + i5 + ", 窄车位 = " + i6);
            this.mNarrowNum = i6;
        }
        if (this.mHightConfidenceNum != i2) {
            LogUtils.i(TAG, "SCU可泊车位数 = " + i4 + ", 高置信度 = " + i2 + ", 低置信度 = " + i5 + ", 窄车位 = " + i6);
            i.x xVar = (i.x) i.a(i.x.class);
            if (i2 > this.mHightConfidenceNum && xVar.d().booleanValue() && ((i = this.mCurrentTip) == 18 || i == 19 || i == 20 || i == 21 || i == 23 || i == 22)) {
                SoundPlayer.getInstance().playParkLotFound();
            }
            this.mHightConfidenceNum = i2;
        }
    }

    private void resetData() {
        LogUtils.i(TAG, "resetData， 清除CDU缓存数据");
        this.mParkLotNum = 0;
        this.mLowConfidenceNum = 0;
        this.mHightConfidenceNum = 0;
        this.mNarrowNum = 0;
        this.mFeatureNum = 0;
        this.mCacheFeatureQueue.clear();
        this.mCacheParkLotList.clear();
        this.mCacheBoxQueue.clear();
        this.mDrawParkLotIemList.clear();
    }

    private void combineLog(ArrayList<ParkLotRData> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d(TAG, "\ncombineParkLotList:" + arrayList.get(i).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inLog(Object[] objArr, Object[] objArr2) {
        Log.d(TAG, "\ninLog");
        Log.d(TAG, "\ninParkLotList.size = " + objArr2.length);
        for (int i = 0; i < objArr2.length; i++) {
            Log.d(TAG, "\ninParkLotList:" + ((ParkLotRData) objArr2[i]).toString());
        }
        Log.d(TAG, "\ninBoxList.size = " + objArr.length);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Log.d(TAG, "\ninBoxList:" + ((BoxRData) objArr[i2]).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void outLog(ArrayList<FeatureRData> arrayList, ArrayList<ParkLotRData> arrayList2) {
        Log.d(TAG, "\noutLog");
        Log.d(TAG, "\noutParkLotList.size = " + arrayList2.size());
        for (int i = 0; i < arrayList2.size(); i++) {
            Log.d(TAG, "\noutParkLotList:" + arrayList2.get(i).toString());
        }
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IVcuController.RawCarSpeedEventMsg rawCarSpeedEventMsg) {
        this.mPresenter.a(rawCarSpeedEventMsg.getData().floatValue());
    }
}
