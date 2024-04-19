package com.xiaopeng.autopilot.base.bean.eventbus;
/* loaded from: classes.dex */
public class CameraStateEvent {
    public static final int STATE_LEFT = 1;
    public static final int STATE_MIDDLE = 3;
    public static final int STATE_RIGHT = 2;
    public int mState;

    public CameraStateEvent(int i) {
        this.mState = 0;
        this.mState = i;
    }
}
