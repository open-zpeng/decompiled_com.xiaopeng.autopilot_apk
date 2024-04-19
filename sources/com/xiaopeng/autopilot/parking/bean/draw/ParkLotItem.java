package com.xiaopeng.autopilot.parking.bean.draw;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class ParkLotItem extends AbsParkLotItem {
    private static final float PARKLOT_PARALLEL_WID = 2.3f;
    private static final float PARKLOT_VERTICAL_WID = 4.86f;
    private static final String TAG = "ParkLotItem";
    private float[][] mWordPoints = (float[][]) Array.newInstance(float.class, 6, 3);

    public ParkLotItem(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i3, int i4, int i5) {
        this.isFavorite = i5 == 1;
        this.mSlotIndex = i;
        this.mSlopTag = i3;
        this.mSlopShape = i2;
        this.mRotateAngle = (float) (((-f) / 3.141592653589793d) * 180.0d);
        this.mIsFree = i4 == 1;
        this.mLotLength = f2;
        this.mRtheta = f;
        this.mXb = f5;
        this.mYB = f6;
        parkSpacePointCal(f3, f4, f5, f6, f7, f8);
        this.mCenter = calculateCenterPoint2(f3, f4, f5, f6, f7, f8);
    }

    private acp calculateCenterPoint2(float f, float f2, float f3, float f4, float f5, float f6) {
        acp acpVar = new acp(0.0f, 0.0f, 0.0f);
        acpVar.a = f5 + ((f - f5) / 2.0f);
        acpVar.b = f2 + ((f6 - f2) / 2.0f);
        return acpVar;
    }

    public void setTag(int i) {
        this.mSlopTag = i;
    }

    public void translationTo3DPosition() {
        float[][] fArr = (float[][]) Array.newInstance(float.class, 6, 3);
        int[][] parkLotScreenPoints = getParkLotScreenPoints();
        for (int i = 0; i < 6; i++) {
            float f = parkLotScreenPoints[i][0];
            float f2 = parkLotScreenPoints[i][1];
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = f;
                fArr[i][i2] = 0.0f;
                fArr[i][i2] = f2;
            }
        }
        this.mWordPoints = fArr;
    }

    private void parkSpacePointCal(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mSpacePoints[1][0] = f3;
        this.mSpacePoints[1][1] = f4;
        this.mSpacePoints[0][0] = this.mSpacePoints[1][0] - 0.001f;
        this.mSpacePoints[0][1] = this.mSpacePoints[1][1] - 0.001f;
        this.mSpacePoints[4][0] = f;
        this.mSpacePoints[4][1] = f2;
        this.mSpacePoints[5][0] = this.mSpacePoints[4][0] + 0.001f;
        this.mSpacePoints[5][1] = this.mSpacePoints[4][1] + 0.001f;
        this.mSpacePoints[2][0] = f5;
        this.mSpacePoints[2][1] = f6;
        this.mSpacePoints[3][0] = (f + f5) - f3;
        this.mSpacePoints[3][1] = (f2 + f6) - f4;
        float f7 = this.mSpacePoints[1][0];
        float f8 = this.mSpacePoints[1][1];
        float f9 = this.mSpacePoints[4][0];
        float f10 = this.mSpacePoints[4][1];
        float f11 = this.mSpacePoints[2][0];
        float f12 = this.mSpacePoints[2][1];
        this.mLenthBE = (float) Math.sqrt(Math.pow(f7 - f9, 2.0d) + Math.pow(f8 - f10, 2.0d));
        this.mLenthBC = (float) Math.sqrt(Math.pow(f7 - f11, 2.0d) + Math.pow(f8 - f12, 2.0d));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mWordPoints != null) {
            for (int i = 0; i < this.mWordPoints.length; i++) {
                sb.append("index:");
                sb.append(i);
                sb.append("\t");
                sb.append("x:");
                sb.append(this.mWordPoints[i][0]);
                sb.append("\t");
                sb.append("y:");
                sb.append(this.mWordPoints[i][0]);
                sb.append("\t");
                sb.append("z:");
                sb.append(this.mWordPoints[i][0]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public float getmRtheta() {
        return this.mRtheta;
    }

    public float getmXb() {
        return this.mXb;
    }

    public float getmYB() {
        return this.mYB;
    }

    public acp getmCenter() {
        return this.mCenter;
    }

    public float getAngle() {
        return this.mRotateAngle;
    }

    public float getmLenthBE() {
        return this.mLenthBE;
    }

    public float getmLenthBC() {
        return this.mLenthBC;
    }

    public float getmLotLength() {
        return this.mLotLength;
    }
}
