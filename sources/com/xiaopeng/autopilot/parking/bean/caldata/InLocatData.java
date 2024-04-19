package com.xiaopeng.autopilot.parking.bean.caldata;
/* loaded from: classes.dex */
public class InLocatData {
    public float s;
    public float theta;
    public float x;
    public float y;

    public InLocatData(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.theta = f3;
        this.s = f4;
    }

    public String toString() {
        return "InLocatData{x=" + this.x + ", y=" + this.y + ", theta=" + this.theta + ", s=" + this.s + '}';
    }
}
