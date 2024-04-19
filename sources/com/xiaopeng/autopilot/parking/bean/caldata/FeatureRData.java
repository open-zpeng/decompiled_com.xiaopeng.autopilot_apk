package com.xiaopeng.autopilot.parking.bean.caldata;
/* loaded from: classes.dex */
public class FeatureRData {
    public int dir;
    public int index;
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    public FeatureRData(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.x1 = fArr[0];
        this.x2 = fArr[1];
        this.index = (int) fArr[2];
        this.y1 = fArr[3];
        this.y2 = fArr[4];
        this.dir = (int) fArr[5];
    }

    public String toString() {
        return "FeatureData1{\nPK_SENSORFUSION_A_ARR_CCP1_x1=" + this.x1 + ", \nPK_SENSORFUSION_A_ARR_CCP1_x2=" + this.x2 + ", \nPK_SENSORFUSION_ARR_NUM_CCP=" + this.index + ", \nPK_SENSORFUSION_ARR_CCP1_y1=" + this.y1 + ", \nPK_SENSORFUSION_ARR_CCP1_y2=" + this.y2 + ", \nPK_SENSORFUSION_ARR_DIR_CCP=" + this.dir + '}';
    }
}
