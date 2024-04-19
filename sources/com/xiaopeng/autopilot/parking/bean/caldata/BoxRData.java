package com.xiaopeng.autopilot.parking.bean.caldata;
/* loaded from: classes.dex */
public class BoxRData {
    public int dir;
    public int index;
    public float loc_s;
    public float loc_theta;
    public float loc_x;
    public float loc_y;
    public int tag;
    public float xa;
    public float xb;
    public float xc;
    public float ya;
    public float yb;
    public float yc;

    public BoxRData(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, int i3) {
        this.index = i;
        this.dir = i2;
        this.xa = f;
        this.ya = f2;
        this.xb = f3;
        this.yb = f4;
        this.xc = f5;
        this.yc = f6;
        this.tag = i3;
    }

    public void setLocData(float f, float f2, float f3, float f4) {
        this.loc_x = f;
        this.loc_y = f2;
        this.loc_theta = f3;
        this.loc_s = f4;
    }

    public String toString() {
        return "BoxRData{dir=" + this.dir + ", tag=" + this.tag + ", xa=" + this.xa + ", ya=" + this.ya + ", xb=" + this.xb + ", yb=" + this.yb + ", xc=" + this.xc + ", yc=" + this.yc + ", index=" + this.index + '}';
    }
}
