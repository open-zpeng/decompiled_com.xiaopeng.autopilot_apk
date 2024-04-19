package com.xiaopeng.autopilot.parking.bean.candata;
/* loaded from: classes.dex */
public class BoxDataRight {
    public int SCU_CDU_RAVMSlotAtt;
    public int SCU_CDU_RAVMSlotCounter;
    public float SCU_CDU_RAVMSlotXa;
    public float SCU_CDU_RAVMSlotXb;
    public float SCU_CDU_RAVMSlotXc;
    public float SCU_CDU_RAVMSlotYa;
    public float SCU_CDU_RAVMSlotYb;
    public float SCU_CDU_RAVMSlotYc;

    public BoxDataRight(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.SCU_CDU_RAVMSlotXa = fArr[0];
        this.SCU_CDU_RAVMSlotYa = fArr[1];
        this.SCU_CDU_RAVMSlotXb = fArr[2];
        this.SCU_CDU_RAVMSlotYb = fArr[3];
        this.SCU_CDU_RAVMSlotXc = fArr[4];
        this.SCU_CDU_RAVMSlotYc = fArr[5];
        this.SCU_CDU_RAVMSlotAtt = (int) fArr[6];
        this.SCU_CDU_RAVMSlotCounter = (int) fArr[7];
    }

    public String toString() {
        return "BoxDataRight{\nSCU_CDU_RAVMSlotXa=" + this.SCU_CDU_RAVMSlotXa + ", \nSCU_CDU_RAVMSlotYa=" + this.SCU_CDU_RAVMSlotYa + ", \nSCU_CDU_RAVMSlotXb=" + this.SCU_CDU_RAVMSlotXb + ", \nSCU_CDU_RAVMSlotYb=" + this.SCU_CDU_RAVMSlotYb + ", \nSCU_CDU_RAVMSlotXc=" + this.SCU_CDU_RAVMSlotXc + ", \nSCU_CDU_RAVMSlotYc=" + this.SCU_CDU_RAVMSlotYc + ", \nSCU_CDU_RAVMSlotAtt=" + this.SCU_CDU_RAVMSlotAtt + ", \nSCU_CDU_RAVMSlotCounter=" + this.SCU_CDU_RAVMSlotCounter + '}';
    }
}
