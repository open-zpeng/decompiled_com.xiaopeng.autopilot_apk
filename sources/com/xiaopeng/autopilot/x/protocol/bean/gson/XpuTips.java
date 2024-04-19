package com.xiaopeng.autopilot.x.protocol.bean.gson;
/* loaded from: classes.dex */
public class XpuTips {
    private int abnormal;
    private int tips;

    public XpuTips(int i, int i2) {
        this.tips = i;
        this.abnormal = i2;
    }

    public int getTips() {
        return this.tips;
    }

    public void setTips(int i) {
        this.tips = i;
    }

    public int getAbnormal() {
        return this.abnormal;
    }

    public void setAbnormal(int i) {
        this.abnormal = i;
    }
}
