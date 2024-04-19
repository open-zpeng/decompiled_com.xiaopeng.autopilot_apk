package com.xiaopeng.autopilot.base.bean.eventbus;
/* loaded from: classes.dex */
public class TrainingSuccessPageEvent {
    public int mDistance;
    public int mFinishType;
    public int mRampCount;
    public int mSpdNum;

    public TrainingSuccessPageEvent(int i, int i2, int i3, int i4) {
        this.mDistance = 0;
        this.mSpdNum = 0;
        this.mRampCount = 0;
        this.mFinishType = 0;
        this.mDistance = i;
        this.mSpdNum = i2;
        this.mRampCount = i3;
        this.mFinishType = i4;
    }
}
