package com.xiaopeng.autopilot.base.bean.eventbus;
/* loaded from: classes.dex */
public class SpeechSuperParkEvent {
    public static final int SPEECH_EXIT = 3;
    public static final int SPEECH_LEARNING_SUMMON_START = 7;
    public static final int SPEECH_MEMORY_PARKING_CONTINUE_FOUND_PARKLOT_START = 5;
    public static final int SPEECH_MEMORY_PARKING_FOUND_PARKLOT_EXIT = 6;
    public static final int SPEECH_SELECT = 1;
    public static final int SPEECH_START = 2;
    public static final int SPEECH_TRAINING_START = 4;
    public int action;
    public int index;

    public SpeechSuperParkEvent(int i, int i2) {
        this.action = 0;
        this.index = 0;
        this.action = i;
        this.index = i2;
    }
}
