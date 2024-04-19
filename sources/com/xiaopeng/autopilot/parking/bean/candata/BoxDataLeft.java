package com.xiaopeng.autopilot.parking.bean.candata;
/* loaded from: classes.dex */
public class BoxDataLeft {
    public int SCU_CDU_LAVMSlotAtt;
    public int SCU_CDU_LAVMSlotCounter;
    public float SCU_CDU_LAVMSlotXa;
    public float SCU_CDU_LAVMSlotXb;
    public float SCU_CDU_LAVMSlotXc;
    public float SCU_CDU_LAVMSlotYa;
    public float SCU_CDU_LAVMSlotYb;
    public float SCU_CDU_LAVMSlotYc;

    public BoxDataLeft(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.SCU_CDU_LAVMSlotXa = fArr[0];
        this.SCU_CDU_LAVMSlotYa = fArr[1];
        this.SCU_CDU_LAVMSlotXb = fArr[2];
        this.SCU_CDU_LAVMSlotYb = fArr[3];
        this.SCU_CDU_LAVMSlotXc = fArr[4];
        this.SCU_CDU_LAVMSlotYc = fArr[5];
        this.SCU_CDU_LAVMSlotAtt = (int) fArr[6];
        this.SCU_CDU_LAVMSlotCounter = (int) fArr[7];
    }

    public String toString() {
        return "BoxDataLeft{\nSCU_CDU_LAVMSlotXa=" + this.SCU_CDU_LAVMSlotXa + ", \nSCU_CDU_LAVMSlotYa=" + this.SCU_CDU_LAVMSlotYa + ", \nSCU_CDU_LAVMSlotXb=" + this.SCU_CDU_LAVMSlotXb + ", \nSCU_CDU_LAVMSlotYb=" + this.SCU_CDU_LAVMSlotYb + ", \nSCU_CDU_LAVMSlotXc=" + this.SCU_CDU_LAVMSlotXc + ", \nSCU_CDU_LAVMSlotYc=" + this.SCU_CDU_LAVMSlotYc + ", \nSCU_CDU_LAVMSlotAtt=" + this.SCU_CDU_LAVMSlotAtt + ", \nSCU_CDU_LAVMSlotCounter=" + this.SCU_CDU_LAVMSlotCounter + '}';
    }
}
