package com.xiaopeng.autopilot.x.protocol.bean.gson;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import defpackage.a;
/* loaded from: classes.dex */
public class TrainingSlotBean {
    @SerializedName("attribute")
    public int attribute;
    @SerializedName("b")
    public PointXpu b;
    @SerializedName("c")
    public PointXpu c;
    @SerializedName("charger_type")
    public int charger_type;
    @SerializedName("d")
    public PointXpu d;
    @SerializedName("e")
    public PointXpu e;
    @SerializedName("height")
    public float height;
    @SerializedName(Constants.ID)
    public int id;
    @SerializedName("location")
    public int location;
    @SerializedName("map_slot_id")
    public int map_slot_id;
    @SerializedName("slot_shape")
    public int slot_shape;
    @SerializedName("slot_type")
    public int slot_type;
    @SerializedName("theta")
    public float theta;
    @SerializedName("width")
    public float width;

    public PointXpu getC() {
        return this.c;
    }

    public PointXpu getD() {
        return this.d;
    }

    public PointXpu getE() {
        return this.e;
    }

    public PointXpu getB() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrainingSlotBean(a.k kVar) {
        this.b = new PointXpu(kVar.a());
        this.c = new PointXpu(kVar.b());
        this.d = new PointXpu(kVar.c());
        this.e = new PointXpu(kVar.d());
        this.attribute = kVar.e();
        this.id = kVar.f();
        this.charger_type = kVar.i();
        this.slot_type = kVar.j();
        this.slot_shape = kVar.h();
        this.theta = kVar.k();
        this.width = kVar.l();
        this.height = kVar.m();
        this.map_slot_id = kVar.n();
    }

    public String toString() {
        return "TrainingSlotBean{b=" + this.b.toString() + ", c=" + this.c.toString() + ", d=" + this.d.toString() + ", e=" + this.e.toString() + ", attribute=" + this.attribute + ", id=" + this.id + ", location=" + this.location + ", slot_shape=" + this.slot_shape + ", charger_type=" + this.charger_type + ", slot_type=" + this.slot_type + ", theta=" + this.theta + ", width=" + this.width + ", height=" + this.height + ", map_slot_id=" + this.map_slot_id + '}';
    }

    /* loaded from: classes.dex */
    public static class PointXpu {
        @SerializedName("x")
        public float x;
        @SerializedName("y")
        public float y;
        @SerializedName("z")
        public float z;

        public PointXpu(float f, float f2, float f3) {
            this.x = f;
            this.y = f2;
            this.z = f3;
        }

        public PointXpu(a.e eVar) {
            this.x = eVar.a();
            this.y = eVar.b();
            this.z = eVar.c();
        }

        public String toString() {
            return "PointXpu{x=" + this.x + ", y=" + this.y + ", z=" + this.z + '}';
        }
    }
}
