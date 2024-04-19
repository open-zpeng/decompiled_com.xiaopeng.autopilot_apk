package com.xiaopeng.autopilot.x.protocol.bean.gson;

import com.google.gson.annotations.SerializedName;
import defpackage.a;
import defpackage.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TrainingMapObjects {
    @SerializedName("slot")
    public List<TrainingSlotBean> slot = new ArrayList();
    @SerializedName("spdbump")
    public List<TrainingSpdBumpBean> spdbump = new ArrayList();

    public TrainingMapObjects(List<a.k> list, List<b.aa> list2) {
        for (a.k kVar : list) {
            this.slot.add(new TrainingSlotBean(kVar));
        }
        for (b.aa aaVar : list2) {
            this.spdbump.add(new TrainingSpdBumpBean(aaVar));
        }
    }

    public String toString() {
        return "TrainingMapObjects{slot=" + this.slot.toString() + ", spdbump=" + this.spdbump.toString() + '}';
    }
}
