package com.xiaopeng.autopilot.base.bean.eventbus;
/* loaded from: classes.dex */
public class TrainingPageEvent {
    public static final int STATE_AP_CANCEL = 7;
    public static final int STATE_AP_FINISH = 2;
    public static final int STATE_AP_FIRST = 1;
    public static final int STATE_AP_HIDE_SLIDE_WARNING = 12;
    public static final int STATE_AP_SLIDE_WARNING = 11;
    public static final int STATE_AP_TRAINING_CONFIRM = 10;
    public static final int STATE_AP_TRAINING_FIRST = 9;
    public static final int STATE_NAV_CLOSE_CONFIRM_CLOSE_DIALOG = 16;
    public static final int STATE_NAV_REMOVE_PAGE = 14;
    public static final int STATE_NAV_START_PAGE = 13;
    public static final int STATE_NAV_SWITCH_RAMP_STATE = 15;
    public static final int STATE_REMOVE_VIEW = 8;
    public static final int STATE_SWITCH_THEME = 5;
    public static final int STATE_TRAINING_CONFIRM = 6;
    public static final int STATE_TRAINING_FIRST = 3;
    public static final int STATE_TRAINING_LEARN = 4;
    public Object mData;
    public int mState;

    public TrainingPageEvent(int i) {
        this.mState = 0;
        this.mData = null;
        this.mState = i;
    }

    public TrainingPageEvent(int i, Object obj) {
        this.mState = 0;
        this.mData = null;
        this.mState = i;
        this.mData = obj;
    }
}
