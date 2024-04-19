package com.xiaopeng.autopilot.parking.model;

import android.graphics.Matrix;
import android.util.Log;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import defpackage.ahz;
import defpackage.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class MiniMapModel implements IMiniMapModel {
    private static final String TAG = "MiniMapModel";
    private static final p sMiniMapDir = new p(-1.0f, 1.0f, 0.0f);
    private List<p> mCduScreenFinished;
    private List<p> mCduScreenPointList;
    private int mCurrentFloorNum;
    private float mDiagoLength;
    private p mEndPoint;
    private p mEndPointDraw;
    private p mEndStartDirection;
    private List<p> mFilterTmp;
    private List<ahz.c.h> mFloorDatas;
    tm mIParkingMiniMapPresenter;
    private boolean mInitFinished;
    private p mMiniMapCenter;
    private p mStartPoint;
    Matrix mTransformation;
    Matrix mTransformationPic;
    private Map<Integer, List<p>> mCduScreenPointListMap = new HashMap();
    private int mCurrentIndex = -1;
    float mMiniMapWidth = 0.0f;
    float mMiniMapHeight = 0.0f;
    private Map<Integer, FloorInfo> mMultiFloorInfo = new HashMap();

    public Map<Integer, FloorInfo> getmMultiFloorInfo() {
        return this.mMultiFloorInfo;
    }

    public int getmCurrentIndex() {
        return this.mCurrentIndex;
    }

    public p getmStartPoint() {
        return this.mStartPoint;
    }

    public boolean ismInitFinished() {
        return this.mInitFinished;
    }

    public p getmEndPoint() {
        return this.mEndPoint;
    }

    public List<p> getmCduScreenPointList() {
        return this.mCduScreenPointList;
    }

    public float getmDiagoLength() {
        return this.mDiagoLength;
    }

    public p getmMiniMapCenter() {
        return this.mMiniMapCenter;
    }

    public p getmEndStartDirection() {
        return this.mEndStartDirection;
    }

    public int getmCurrentFloorNum() {
        return this.mCurrentFloorNum;
    }

    public void setmCurrentFloorNum(int i) {
        boolean containsKey = getmMultiFloorInfo().containsKey(Integer.valueOf(i));
        Log.d(TAG, "currentFloorNum = " + i + " ; hasData = " + containsKey);
        if (containsKey && this.mCurrentFloorNum != i) {
            this.mCurrentFloorNum = i;
            this.mInitFinished = true;
            this.mIParkingMiniMapPresenter.c();
        }
        this.mCurrentFloorNum = i;
    }

    public p getmEndPointDraw() {
        if (this.mEndPointDraw == null) {
            this.mEndPointDraw = new p();
        }
        return this.mEndPointDraw;
    }

    public List<p> getmFilterTmp() {
        if (this.mFilterTmp == null) {
            this.mFilterTmp = new ArrayList();
        }
        return this.mFilterTmp;
    }

    public Matrix getmTransformation() {
        if (this.mTransformation == null) {
            this.mTransformation = new Matrix();
        }
        return this.mTransformation;
    }

    public List<p> getmCduScreenFinished() {
        if (this.mCduScreenFinished == null) {
            this.mCduScreenFinished = new ArrayList();
        }
        return this.mCduScreenFinished;
    }

    public void setmCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    private boolean isInFloor(int i, float f) {
        float f2;
        float f3;
        List<ahz.c.h> list = this.mFloorDatas;
        if (list == null || list.size() <= 0) {
            f2 = 0.0f;
            f3 = 0.0f;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
            for (ahz.c.h hVar : this.mFloorDatas) {
                if (hVar.a() == i) {
                    f2 = hVar.b();
                    f3 = hVar.c();
                }
            }
        }
        return f2 != 0.0f && f3 != 0.0f && f > f3 && f < f2;
    }

    public List<p> filterPoint(List<p> list, int i) {
        getmFilterTmp().clear();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 % i == 0 || i2 == list.size() - 1 || i2 == list.size() - 2) {
                    getmFilterTmp().add(list.get(i2));
                }
            }
        }
        return getmFilterTmp();
    }

    public List<p> filterPoint_(List<p> list, int i, int i2) {
        getmFilterTmp().clear();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if ((i3 % i == 0 || i3 == list.size() - 1 || i3 == list.size() - 2) && isInFloor(i2, list.get(i3).c)) {
                    getmFilterTmp().add(list.get(i3));
                }
            }
        }
        return getmFilterTmp();
    }

    public List<p> fillFinishedRoadList(int i, int i2) {
        try {
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            Log.e(TAG, "index error " + getmCurrentIndex() + "\t size:" + getmAllLineCduScreenPointList().size());
        }
        if (getmCurrentIndex() >= 0 && getmAllLineCduScreenPointList().size() != 0 && i2 <= getmCurrentIndex()) {
            getmCduScreenFinished().clear();
            getmCduScreenFinished().addAll(filterPoint(getmAllLineCduScreenPointList().subList(i2, getmCurrentIndex()), 2));
            return getmCduScreenFinished();
        }
        return null;
    }

    public List<p> getmAllLineCduScreenPointList() {
        if (this.mCduScreenPointList == null) {
            this.mCduScreenPointList = new ArrayList();
        }
        return this.mCduScreenPointList;
    }

    private String initMultiFloorData(List<p> list, List<ahz.c.h> list2) {
        for (ahz.c.h hVar : list2) {
            int a = hVar.a();
            for (p pVar : list) {
                int floorNumByZPosition = getFloorNumByZPosition(pVar.c, list2);
                if (a == floorNumByZPosition) {
                    getMapPointsByFloorFromCache(floorNumByZPosition).add(pVar);
                }
            }
            this.mMultiFloorInfo.put(Integer.valueOf(a), new FloorInfo(getMapPointsByFloorFromCache(a), a));
        }
        getMapPointsByFloorFromCache(-999).addAll(getmAllLineCduScreenPointList());
        this.mMultiFloorInfo.put(-999, new FloorInfo(getMapPointsByFloorFromCache(-999), -999));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        Map<Integer, List<p>> map = this.mCduScreenPointListMap;
        if (map != null && map.size() > 0) {
            for (Integer num : this.mCduScreenPointListMap.keySet()) {
                stringBuffer.append("{");
                stringBuffer.append(num);
                stringBuffer.append(":");
                stringBuffer.append(this.mCduScreenPointListMap.get(num).size());
                stringBuffer.append("}");
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public int getFloorNumByZPosition(float f, List<ahz.c.h> list) {
        PerformanceTestUnit.logStart(TAG);
        int i = 0;
        if (list == null) {
            PerformanceTestUnit.log(TAG, "floor datas is null", 2000L);
            return 0;
        }
        Iterator<ahz.c.h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ahz.c.h next = it.next();
            float b = next.b();
            float c = next.c();
            int a = next.a();
            if (f > c && f < b) {
                i = a;
                break;
            }
        }
        PerformanceTestUnit.logEnd(TAG, "getFloorNumByZPosition");
        return i;
    }

    public void init(b.o oVar, List<ahz.c.h> list) {
        if (list == null) {
            PerformanceTestUnit.log("MiniMapModel_floordatas", "MINI_MAP_INFO floor data is null return:", true);
            return;
        }
        this.mFloorDatas = list;
        if (oVar == null || oVar.b() == null || oVar.b().size() == 0) {
            PerformanceTestUnit.log("MiniMapModel_init", "MINI_MAP_INFO init all line data is null ", true);
            return;
        }
        PerformanceTestUnit.log(TAG, "MINI_MAP_INFO init start", true);
        PerformanceTestUnit.logStart(TAG);
        int d = oVar.d();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i = 0; i < d; i++) {
            b.m a = oVar.a(i);
            float a2 = a.a().a() * (-1.0f);
            float b = a.a().b();
            float c = a.a().c();
            if (f >= a2) {
                f = a2;
            }
            if (f2 <= a2) {
                f2 = a2;
            }
            if (f3 >= b) {
                f3 = b;
            }
            if (f4 <= b) {
                f4 = b;
            }
            getmAllLineCduScreenPointList().add(new p(a2, b, c));
        }
        String initMultiFloorData = initMultiFloorData(getmAllLineCduScreenPointList(), list);
        if (getmAllLineCduScreenPointList().size() > 0) {
            this.mStartPoint = getmAllLineCduScreenPointList().get(0).a();
            this.mEndPoint = getmAllLineCduScreenPointList().get(getmAllLineCduScreenPointList().size() - 1).a();
            this.mEndStartDirection = new p(this.mEndPoint.a().c(this.mStartPoint.a())).d();
        }
        this.mDiagoLength = calculateDiagoLength(f, f2, f3, f4);
        float f5 = f2 - f;
        this.mMiniMapWidth = f5;
        float f6 = f4 - f3;
        this.mMiniMapHeight = f6;
        this.mMiniMapCenter = new p(f + (f5 / 2.0f), f3 + (f6 / 2.0f), 0.0f);
        debugLog(initMultiFloorData);
        PerformanceTestUnit.logEnd(TAG, "MiniMapModelinit");
    }

    private float calculateDiagoLength(float f, float f2, float f3, float f4) {
        float f5 = f2 - f;
        float f6 = f4 - f3;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    private String debugLog(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MINI_MAP_INFO init finished: ");
        stringBuffer.append(" size:" + getmAllLineCduScreenPointList().size());
        stringBuffer.append(" diaLength:" + this.mDiagoLength);
        stringBuffer.append(" miniMapCenter: " + this.mMiniMapCenter.toString());
        stringBuffer.append(" direction: " + this.mEndStartDirection.toString());
        stringBuffer.append(" start:" + this.mStartPoint.toString());
        stringBuffer.append(" end : " + this.mEndPoint.toString());
        stringBuffer.append("Matrix: " + this.mTransformation.toString());
        stringBuffer.append("floorPath: " + str);
        PerformanceTestUnit.log("MiniMapModel_debugLog", stringBuffer.toString(), true);
        return stringBuffer.toString();
    }

    public void dispose() {
        PerformanceTestUnit.log(TAG, "MINI_MAP dispose", true);
        getmAllLineCduScreenPointList().clear();
        getmTransformation().reset();
        getmFilterTmp().clear();
        this.mCduScreenPointListMap.clear();
        this.mMultiFloorInfo.clear();
        this.mStartPoint = null;
        this.mEndPoint = null;
        this.mMiniMapCenter = null;
        this.mEndStartDirection = null;
        this.mInitFinished = false;
        this.mCurrentIndex = -1;
        this.mCurrentFloorNum = -999;
    }

    public String toString() {
        return debugLog("");
    }

    @Override // com.xiaopeng.autopilot.parking.model.IMiniMapModel
    public void bindPresenter(tm tmVar) {
        this.mIParkingMiniMapPresenter = tmVar;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IMiniMapModel
    public tm getMiniMapPresenter() {
        return this.mIParkingMiniMapPresenter;
    }

    public List<p> getMapPointsByFloorFromCache(int i) {
        List<p> list = this.mCduScreenPointListMap.get(Integer.valueOf(i));
        if (list == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.mCduScreenPointListMap.put(Integer.valueOf(i), copyOnWriteArrayList);
            return copyOnWriteArrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public class FloorInfo {
        p mCenter;
        List<p> mDataList;
        p mEnd;
        float mFloorDiagoLength = 0.0f;
        int mFloorNum;
        p mStart;
        float x_max;
        float x_min;
        float y_max;
        float y_min;

        public List<p> getmDataList() {
            return this.mDataList;
        }

        public p getmStart() {
            return this.mStart;
        }

        public p getmEnd() {
            return this.mEnd;
        }

        public float getmFloorDiagoLength() {
            return this.mFloorDiagoLength;
        }

        public FloorInfo(List<p> list, int i) {
            setmDataList(list);
            this.mFloorNum = i;
        }

        public p getmCenter() {
            if (this.mCenter == null) {
                this.mCenter = new p();
            }
            return this.mCenter;
        }

        public void setmDataList(List<p> list) {
            this.mDataList = list;
            List<p> list2 = this.mDataList;
            if (list2 != null && list2.size() > 0) {
                this.x_min = 0.0f;
                this.x_max = 0.0f;
                this.y_min = 0.0f;
                this.y_max = 0.0f;
                for (int i = 0; i < this.mDataList.size(); i++) {
                    p pVar = this.mDataList.get(i);
                    float f = pVar.a;
                    float f2 = pVar.b;
                    float f3 = pVar.c;
                    float f4 = this.x_min;
                    if (f4 >= f) {
                        f4 = f;
                    }
                    this.x_min = f4;
                    float f5 = this.x_max;
                    if (f5 <= f) {
                        f5 = f;
                    }
                    this.x_max = f5;
                    float f6 = this.y_min;
                    if (f6 >= f2) {
                        f6 = f2;
                    }
                    this.y_min = f6;
                    float f7 = this.y_max;
                    if (f7 <= f2) {
                        f7 = f2;
                    }
                    this.y_max = f7;
                }
                p pVar2 = getmCenter();
                float f8 = this.x_min;
                pVar2.a = f8 + ((this.x_max - f8) / 2.0f);
                p pVar3 = getmCenter();
                float f9 = this.y_min;
                pVar3.b = f9 + ((this.y_max - f9) / 2.0f);
                this.mStart = list.get(0);
                this.mEnd = list.get(this.mDataList.size() - 1);
            }
            this.mFloorDiagoLength = calculateDiagoLength(this.x_min, this.x_max, this.y_min, this.y_max);
        }

        private float calculateDiagoLength(float f, float f2, float f3, float f4) {
            float f5 = f2 - f;
            float f6 = f4 - f3;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MINI_MAP floorInfo :");
            sb.append(" num: " + this.mFloorNum + "\t");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" center:");
            sb2.append(getmCenter().toString());
            sb.append(sb2.toString());
            sb.append(" dataSize : ");
            sb.append(getmDataList() != null ? Integer.valueOf(getmDataList().size()) : " 0");
            return sb.toString();
        }
    }
}
