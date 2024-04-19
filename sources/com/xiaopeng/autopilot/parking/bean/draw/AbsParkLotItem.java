package com.xiaopeng.autopilot.parking.bean.draw;

import android.graphics.Point;
import com.xiaopeng.autopilot.parking.bean.caldata.ParkLotRData;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AbsParkLotItem {
    public static final int CHOSE_INDEX_NONE = 7;
    public static final int PARK_IN_STYLE_FRONT = 2;
    public static final int PARK_IN_STYLE_NULL = 0;
    public static final int PARK_IN_STYLE_REAR = 1;
    public static final int PARK_LOT_DIR_ERROR = 0;
    public static final int PARK_LOT_PARALLEL_DAYTIME = 22;
    public static final int PARK_LOT_PARALLEL_LEFT = 1;
    public static final int PARK_LOT_PARALLEL_NIGHT = 11;
    public static final int PARK_LOT_PARALLEL_RIGHT = 2;
    public static final int PARK_LOT_VERTICAL_DAYTIME = 44;
    public static final int PARK_LOT_VERTICAL_LEFT = 3;
    public static final int PARK_LOT_VERTICAL_NIGHT = 33;
    public static final int PARK_LOT_VERTICAL_RIGHT = 4;
    public static final int TYPE_PARK_LOT = 2;
    public static final int TYPE_PARK_LOT_OCCUPY = 3;
    public static final int TYPE_VEHICLE = 1;
    protected boolean isFavorite;
    protected acp mCenter;
    protected int mCenterX;
    protected int mCenterY;
    protected int mEntranceMidX;
    protected int mEntranceMidY;
    protected float mLenthBC;
    protected float mLenthBE;
    protected float mLotLength;
    protected int[][] mParkLotScreenPoints;
    protected int mRay2X;
    protected int mRay2Y;
    protected int mRayX;
    protected int mRayY;
    protected float mRotateAngle;
    protected int mSlopShape;
    protected int mSlopTag;
    protected int mSlotIndex;
    protected boolean mIsFree = false;
    protected boolean mIsShowIndex = false;
    protected float[][] mSpacePoints = (float[][]) Array.newInstance(float.class, 6, 2);
    protected float mXb = 0.0f;
    protected float mYB = 0.0f;
    protected float mRtheta = 0.0f;

    public int[][] getParkLotScreenPoints() {
        return this.mParkLotScreenPoints;
    }

    public boolean isPointIn(int i, int i2) {
        int[][] iArr = this.mParkLotScreenPoints;
        if (iArr != null) {
            Point point = new Point(i, i2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Point(iArr[1][0], iArr[1][1]));
            arrayList.add(new Point(iArr[2][0], iArr[2][1]));
            arrayList.add(new Point(iArr[3][0], iArr[3][1]));
            arrayList.add(new Point(iArr[4][0], iArr[4][1]));
            if (ptInPolygon(point, arrayList)) {
                arrayList.clear();
                return true;
            }
        }
        return false;
    }

    public boolean ptInPolygon(Point point, List<Point> list) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Point point2 = list.get(i);
            i++;
            Point point3 = list.get(i % list.size());
            if (point2.y != point3.y && point.y >= Math.min(point2.y, point3.y) && point.y < Math.max(point2.y, point3.y) && (((point.y - point2.y) * (point3.x - point2.x)) / (point3.y - point2.y)) + point2.x > point.x) {
                i2++;
            }
        }
        return i2 % 2 == 1;
    }

    public int getCenterX() {
        return this.mCenterX;
    }

    public int getCenterY() {
        return this.mCenterY;
    }

    public int getEntranceMidX() {
        return this.mEntranceMidX;
    }

    public int getEntranceMidY() {
        return this.mEntranceMidY;
    }

    public int getRayX() {
        return this.mRayX;
    }

    public int getRayY() {
        return this.mRayY;
    }

    public int getRay2X() {
        return this.mRay2X;
    }

    public int getRay2Y() {
        return this.mRay2Y;
    }

    public int getDir() {
        return this.mSlopShape;
    }

    public boolean isFree() {
        return this.mIsFree;
    }

    public float[][] getSpacePoints() {
        return this.mSpacePoints;
    }

    public int getSlotIndex() {
        return this.mSlotIndex;
    }

    public void showIndex(boolean z) {
        this.mIsShowIndex = z;
    }

    public int getTag() {
        return this.mSlopTag;
    }

    public int getType() {
        return isFree() ? 2 : 3;
    }

    public float getmRotateAngle() {
        return this.mRotateAngle;
    }

    public boolean lowConfidence() {
        return ParkLotRData.isItemLowConfidence(this.mSlopTag);
    }

    public boolean narrow() {
        return ParkLotRData.isItemNarrow(this.mSlopTag);
    }

    public boolean isSupportFront() {
        return ParkLotRData.isSupportFront(this.mSlopTag);
    }

    public boolean isOnlySupportFront() {
        return ParkLotRData.isOnlySupportFront(this.mSlopTag);
    }

    public boolean isOnlySupportRear() {
        return ParkLotRData.isOnlySupportRear(this.mSlopTag);
    }

    public boolean isSupportFrontAndRear() {
        return ParkLotRData.isItemRearFront(this.mSlopTag);
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }

    public boolean isHorItem() {
        int i = this.mSlopShape;
        return i == 1 || i == 2;
    }

    public boolean isVerItem() {
        int i = this.mSlopShape;
        return i == 3 || i == 4;
    }

    public boolean isLeft() {
        int i = this.mSlopShape;
        return i == 1 || i == 3;
    }
}
