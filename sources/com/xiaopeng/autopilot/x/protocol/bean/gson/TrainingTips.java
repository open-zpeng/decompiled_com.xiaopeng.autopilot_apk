package com.xiaopeng.autopilot.x.protocol.bean.gson;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
/* loaded from: classes.dex */
public class TrainingTips {
    @SerializedName("fail")
    public int[] fail;
    @SerializedName("st")
    public int st;
    @SerializedName("tips")
    public int tips;

    public TrainingTips(int i, int i2, int[] iArr) {
        this.st = i;
        this.tips = i2;
        this.fail = iArr;
    }

    public String toString() {
        return "TrainingTips{st=" + this.st + ", tips=" + this.tips + ", fail=" + Arrays.toString(this.fail) + '}';
    }
}
