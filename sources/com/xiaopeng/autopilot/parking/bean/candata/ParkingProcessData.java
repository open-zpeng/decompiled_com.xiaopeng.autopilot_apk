package com.xiaopeng.autopilot.parking.bean.candata;
/* loaded from: classes.dex */
public class ParkingProcessData {
    public float SCU_CDU_Tra_Percent;
    public float SCU_CDU_Tra_ds;

    public ParkingProcessData(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.SCU_CDU_Tra_Percent = fArr[1];
        this.SCU_CDU_Tra_ds = fArr[0];
    }

    public String toString() {
        return "ParkingProcessData{ \nSCU_CDU_Tra_ds=" + this.SCU_CDU_Tra_ds + ", \nSCU_CDU_Tra_Percent=" + this.SCU_CDU_Tra_Percent + '}';
    }
}
