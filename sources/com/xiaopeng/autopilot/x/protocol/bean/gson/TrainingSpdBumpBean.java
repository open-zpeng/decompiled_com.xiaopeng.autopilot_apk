package com.xiaopeng.autopilot.x.protocol.bean.gson;

import com.google.gson.annotations.SerializedName;
import defpackage.b;
/* loaded from: classes.dex */
public class TrainingSpdBumpBean {
    @SerializedName("flag")
    public int flag;
    @SerializedName("s")
    public double s;
    @SerializedName("theta")
    public double theta;
    @SerializedName("x")
    public double x;
    @SerializedName("y")
    public double y;
    @SerializedName("z")
    public double z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrainingSpdBumpBean(b.aa aaVar) {
        this.flag = aaVar.a();
        this.x = aaVar.b();
        this.y = aaVar.c();
        this.z = aaVar.d();
        this.s = aaVar.f();
        this.theta = aaVar.e();
    }

    public String toString() {
        return "TrainingSpdBumpBean{flag=" + this.flag + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", s=" + this.s + ", theta=" + this.theta + '}';
    }
}
