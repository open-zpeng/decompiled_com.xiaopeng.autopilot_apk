package com.xiaopeng.autopilot.base.bean.eventbus;

import java.util.List;
/* loaded from: classes.dex */
public class TrainingFailPageEvent {
    public List<Integer> mFail;
    public int mFinishType;

    public TrainingFailPageEvent(List<Integer> list, int i) {
        this.mFinishType = 0;
        this.mFail = list;
        this.mFinishType = i;
    }
}
