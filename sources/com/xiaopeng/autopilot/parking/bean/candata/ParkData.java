package com.xiaopeng.autopilot.parking.bean.candata;
/* loaded from: classes.dex */
public class ParkData {
    public int SCU_CDU_Slot1Att;
    public int SCU_CDU_Slot1VD;
    public float SCU_CDU_Slot1Xa;
    public float SCU_CDU_Slot1Xb;
    public float SCU_CDU_Slot1Xc;
    public float SCU_CDU_Slot1Ya;
    public float SCU_CDU_Slot1Yb;
    public float SCU_CDU_Slot1Yc;
    public int SCU_CDU_Slot2Att;
    public int SCU_CDU_Slot2VD;
    public float SCU_CDU_Slot2Xa;
    public float SCU_CDU_Slot2Xb;
    public float SCU_CDU_Slot2Xc;
    public float SCU_CDU_Slot2Ya;
    public float SCU_CDU_Slot2Yb;
    public float SCU_CDU_Slot2Yc;
    public int SCU_CDU_Slot3Att;
    public int SCU_CDU_Slot3VD;
    public float SCU_CDU_Slot3Xa;
    public float SCU_CDU_Slot3Xb;
    public float SCU_CDU_Slot3Xc;
    public float SCU_CDU_Slot3Ya;
    public float SCU_CDU_Slot3Yb;
    public float SCU_CDU_Slot3Yc;
    public int SCU_CDU_Slot4Att;
    public int SCU_CDU_Slot4VD;
    public float SCU_CDU_Slot4Xa;
    public float SCU_CDU_Slot4Xb;
    public float SCU_CDU_Slot4Xc;
    public float SCU_CDU_Slot4Ya;
    public float SCU_CDU_Slot4Yb;
    public float SCU_CDU_Slot4Yc;
    public int SCU_CDU_Slot5Att;
    public int SCU_CDU_Slot5VD;
    public float SCU_CDU_Slot5Xa;
    public float SCU_CDU_Slot5Xb;
    public float SCU_CDU_Slot5Xc;
    public float SCU_CDU_Slot5Ya;
    public float SCU_CDU_Slot5Yb;
    public float SCU_CDU_Slot5Yc;
    public int SCU_CDU_Slot6Att;
    public int SCU_CDU_Slot6VD;
    public float SCU_CDU_Slot6Xa;
    public float SCU_CDU_Slot6Xb;
    public float SCU_CDU_Slot6Xc;
    public float SCU_CDU_Slot6Ya;
    public float SCU_CDU_Slot6Yb;
    public float SCU_CDU_Slot6Yc;
    public int SCU_CDU_SlotNum;
    public int SCU_CDU_SlotShape;

    public ParkData() {
    }

    public ParkData(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.SCU_CDU_Slot1Xa = fArr[0];
        this.SCU_CDU_Slot1Ya = fArr[1];
        this.SCU_CDU_Slot1Xb = fArr[2];
        this.SCU_CDU_Slot1Yb = fArr[3];
        this.SCU_CDU_Slot1Xc = fArr[4];
        this.SCU_CDU_Slot1Yc = fArr[5];
        this.SCU_CDU_Slot1Att = (int) fArr[6];
        this.SCU_CDU_Slot2Xa = fArr[7];
        this.SCU_CDU_Slot2Ya = fArr[8];
        this.SCU_CDU_Slot2Xb = fArr[9];
        this.SCU_CDU_Slot2Yb = fArr[10];
        this.SCU_CDU_Slot2Xc = fArr[11];
        this.SCU_CDU_Slot2Yc = fArr[12];
        this.SCU_CDU_Slot2Att = (int) fArr[13];
        this.SCU_CDU_Slot3Xa = fArr[14];
        this.SCU_CDU_Slot3Ya = fArr[15];
        this.SCU_CDU_Slot3Xb = fArr[16];
        this.SCU_CDU_Slot3Yb = fArr[17];
        this.SCU_CDU_Slot3Xc = fArr[18];
        this.SCU_CDU_Slot3Yc = fArr[19];
        this.SCU_CDU_Slot3Att = (int) fArr[20];
        this.SCU_CDU_Slot4Xa = fArr[21];
        this.SCU_CDU_Slot4Ya = fArr[22];
        this.SCU_CDU_Slot4Xb = fArr[23];
        this.SCU_CDU_Slot4Yb = fArr[24];
        this.SCU_CDU_Slot4Xc = fArr[25];
        this.SCU_CDU_Slot4Yc = fArr[26];
        this.SCU_CDU_Slot4Att = (int) fArr[27];
        this.SCU_CDU_Slot5Xa = fArr[28];
        this.SCU_CDU_Slot5Ya = fArr[29];
        this.SCU_CDU_Slot5Xb = fArr[30];
        this.SCU_CDU_Slot5Yb = fArr[31];
        this.SCU_CDU_Slot5Xc = fArr[32];
        this.SCU_CDU_Slot5Yc = fArr[33];
        this.SCU_CDU_Slot5Att = (int) fArr[34];
        this.SCU_CDU_Slot6Xa = fArr[35];
        this.SCU_CDU_Slot6Ya = fArr[36];
        this.SCU_CDU_Slot6Xb = fArr[37];
        this.SCU_CDU_Slot6Yb = fArr[38];
        this.SCU_CDU_Slot6Xc = fArr[39];
        this.SCU_CDU_Slot6Yc = fArr[40];
        this.SCU_CDU_Slot6Att = (int) fArr[41];
        this.SCU_CDU_Slot1VD = (int) fArr[42];
        this.SCU_CDU_Slot2VD = (int) fArr[43];
        this.SCU_CDU_Slot3VD = (int) fArr[44];
        this.SCU_CDU_Slot4VD = (int) fArr[45];
        this.SCU_CDU_Slot5VD = (int) fArr[46];
        this.SCU_CDU_Slot6VD = (int) fArr[47];
        this.SCU_CDU_SlotShape = (int) fArr[48];
        int i = this.SCU_CDU_Slot1VD == 1 ? 1 : 0;
        i = this.SCU_CDU_Slot2VD == 1 ? i + 1 : i;
        i = this.SCU_CDU_Slot3VD == 1 ? i + 1 : i;
        i = this.SCU_CDU_Slot4VD == 1 ? i + 1 : i;
        i = this.SCU_CDU_Slot5VD == 1 ? i + 1 : i;
        this.SCU_CDU_SlotNum = this.SCU_CDU_Slot6VD == 1 ? i + 1 : i;
    }

    public String toString() {
        return "ParkData{\nSCU_CDU_Slot1Xa=" + this.SCU_CDU_Slot1Xa + ", \nSCU_CDU_Slot1Ya=" + this.SCU_CDU_Slot1Ya + ", \nSCU_CDU_Slot1Xb=" + this.SCU_CDU_Slot1Xb + ", \nSCU_CDU_Slot1Yb=" + this.SCU_CDU_Slot1Yb + ", \nSCU_CDU_Slot1Xc=" + this.SCU_CDU_Slot1Xc + ", \nSCU_CDU_Slot1Yc=" + this.SCU_CDU_Slot1Yc + ", \nSCU_CDU_Slot1Att=" + this.SCU_CDU_Slot1Att + ", \nSCU_CDU_Slot2Xa=" + this.SCU_CDU_Slot2Xa + ", \nSCU_CDU_Slot2Ya=" + this.SCU_CDU_Slot2Ya + ", \nSCU_CDU_Slot2Xb=" + this.SCU_CDU_Slot2Xb + ", \nSCU_CDU_Slot2Yb=" + this.SCU_CDU_Slot2Yb + ", \nSCU_CDU_Slot2Xc=" + this.SCU_CDU_Slot2Xc + ", \nSCU_CDU_Slot2Yc=" + this.SCU_CDU_Slot2Yc + ", \nSCU_CDU_Slot2Att=" + this.SCU_CDU_Slot2Att + ", \nSCU_CDU_Slot3Xa=" + this.SCU_CDU_Slot3Xa + ", \nSCU_CDU_Slot3Ya=" + this.SCU_CDU_Slot3Ya + ", \nSCU_CDU_Slot3Xb=" + this.SCU_CDU_Slot3Xb + ", \nSCU_CDU_Slot3Yb=" + this.SCU_CDU_Slot3Yb + ", \nSCU_CDU_Slot3Xc=" + this.SCU_CDU_Slot3Xc + ", \nSCU_CDU_Slot3Yc=" + this.SCU_CDU_Slot3Yc + ", \nSCU_CDU_Slot3Att=" + this.SCU_CDU_Slot3Att + ", \nSCU_CDU_Slot4Xa=" + this.SCU_CDU_Slot4Xa + ", \nSCU_CDU_Slot4Ya=" + this.SCU_CDU_Slot4Ya + ", \nSCU_CDU_Slot4Xb=" + this.SCU_CDU_Slot4Xb + ", \nSCU_CDU_Slot4Yb=" + this.SCU_CDU_Slot4Yb + ", \nSCU_CDU_Slot4Xc=" + this.SCU_CDU_Slot4Xc + ", \nSCU_CDU_Slot4Yc=" + this.SCU_CDU_Slot4Yc + ", \nSCU_CDU_Slot4Att=" + this.SCU_CDU_Slot4Att + ", \nSCU_CDU_Slot5Xa=" + this.SCU_CDU_Slot5Xa + ", \nSCU_CDU_Slot5Ya=" + this.SCU_CDU_Slot5Ya + ", \nSCU_CDU_Slot5Xb=" + this.SCU_CDU_Slot5Xb + ", \nSCU_CDU_Slot5Yb=" + this.SCU_CDU_Slot5Yb + ", \nSCU_CDU_Slot5Xc=" + this.SCU_CDU_Slot5Xc + ", \nSCU_CDU_Slot5Yc=" + this.SCU_CDU_Slot5Yc + ", \nSCU_CDU_Slot5Att=" + this.SCU_CDU_Slot5Att + ", \nSCU_CDU_Slot6Xa=" + this.SCU_CDU_Slot6Xa + ", \nSCU_CDU_Slot6Ya=" + this.SCU_CDU_Slot6Ya + ", \nSCU_CDU_Slot6Xb=" + this.SCU_CDU_Slot6Xb + ", \nSCU_CDU_Slot6Yb=" + this.SCU_CDU_Slot6Yb + ", \nSCU_CDU_Slot6Xc=" + this.SCU_CDU_Slot6Xc + ", \nSCU_CDU_Slot6Yc=" + this.SCU_CDU_Slot6Yc + ", \nSCU_CDU_Slot6Att=" + this.SCU_CDU_Slot6Att + ", \nSCU_CDU_Slot1VD=" + this.SCU_CDU_Slot1VD + ", \nSCU_CDU_Slot2VD=" + this.SCU_CDU_Slot2VD + ", \nSCU_CDU_Slot3VD=" + this.SCU_CDU_Slot3VD + ", \nSCU_CDU_Slot4VD=" + this.SCU_CDU_Slot4VD + ", \nSCU_CDU_Slot5VD=" + this.SCU_CDU_Slot5VD + ", \nSCU_CDU_Slot6VD=" + this.SCU_CDU_Slot6VD + ", \nSCU_CDU_SlotShape=" + this.SCU_CDU_SlotShape + ", \nSCU_CDU_SlotNum=" + this.SCU_CDU_SlotNum + '}';
    }
}
