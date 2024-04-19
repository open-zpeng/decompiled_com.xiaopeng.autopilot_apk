package com.xiaopeng.autopilot.x.protocol.bean.gson;
/* loaded from: classes.dex */
public class SpdBumpBean {
    private int flag;
    private double s;
    private double theta;
    private double x;
    private double y;
    private double z;

    public SpdBumpBean(int i, double d, double d2, double d3, double d4, double d5) {
        this.flag = i;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.s = d4;
        this.theta = d5;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double d) {
        this.x = d;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double d) {
        this.y = d;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double d) {
        this.z = d;
    }

    public double getS() {
        return this.s;
    }

    public void setS(double d) {
        this.s = d;
    }

    public double getTheta() {
        return this.theta;
    }

    public void setTheta(double d) {
        this.theta = d;
    }

    public String toString() {
        return "SpdBumpBean{flag=" + this.flag + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", s=" + this.s + ", theta=" + this.theta + '}';
    }
}
