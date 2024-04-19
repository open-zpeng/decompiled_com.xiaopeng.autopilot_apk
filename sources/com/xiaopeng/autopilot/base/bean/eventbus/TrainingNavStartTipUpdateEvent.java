package com.xiaopeng.autopilot.base.bean.eventbus;
/* loaded from: classes.dex */
public class TrainingNavStartTipUpdateEvent {
    private int mFeatureDistance;
    private int mFeaturePercentage;
    private int mStartPointDistance;
    private int mTips;

    public TrainingNavStartTipUpdateEvent(int i, int i2, int i3, int i4) {
        this.mTips = i;
        this.mFeatureDistance = i2;
        this.mStartPointDistance = i3;
        this.mFeaturePercentage = i4;
    }

    public int getTips() {
        return this.mTips;
    }

    public int getFeatureDistance() {
        return this.mFeatureDistance;
    }

    public int getStartPointDistance() {
        return this.mStartPointDistance;
    }

    public int getFeaturePercentage() {
        return this.mFeaturePercentage;
    }
}
