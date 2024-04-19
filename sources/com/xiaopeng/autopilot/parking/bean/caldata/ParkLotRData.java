package com.xiaopeng.autopilot.parking.bean.caldata;
/* loaded from: classes.dex */
public class ParkLotRData extends AbsParkLotRData {
    public int dir;
    public int index;
    public int isFavor;
    public int isParkingable;
    public float rTheta;
    public float slotLen;
    public int tag = -1;
    private int vd;
    public float xa;
    public float xb;
    public float xc;
    public float ya;
    public float yb;
    public float yc;

    public void assignIn(float f, float f2, float f3, float f4, float f5, float f6, int i, int i2) {
        this.xa = f;
        this.ya = f2;
        this.xb = f3;
        this.yb = f4;
        this.xc = f5;
        this.yc = f6;
        this.tag = i;
        this.vd = i2;
    }

    public void assignIn(int i, float f, float f2, float f3, float f4, float f5, float f6, int i2, int i3) {
        assignIn(f, f2, f3, f4, f5, f6, i2, i3);
        this.dir = i;
    }

    public boolean isVaildVd() {
        return this.vd == 1;
    }

    public String toString() {
        return "ParkLotRData{dir=" + this.dir + ", xa=" + this.xa + ", ya=" + this.ya + ", xb=" + this.xb + ", yb=" + this.yb + ", xc=" + this.xc + ", yc=" + this.yc + ", tag=" + this.tag + ", vd=" + this.vd + ", index=" + this.index + ", rTheta=" + this.rTheta + ", slotLen=" + this.slotLen + ", isParkingable=" + this.isParkingable + '}';
    }
}
