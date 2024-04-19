package com.xiaopeng.autopilot.x.protocol.bean.gson;
/* loaded from: classes.dex */
public class FavorPos {
    public float distance;
    public float x;
    public float y;
    public float z;

    public FavorPos(float[] fArr) {
        this.x = fArr[0];
        this.y = fArr[1];
        this.z = fArr[2];
        this.distance = fArr[3];
    }

    public float getX() {
        return this.x;
    }

    public void setX(float f) {
        this.x = f;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float f) {
        this.y = f;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float f) {
        this.z = f;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + "," + this.distance + ")";
    }
}
