package com.xiaopeng.autopilot.x.protocol.bean.eventbus;
/* loaded from: classes.dex */
public class SpeechApiRouteEvent {
    public static final int SPEECH_ACTIVATE = 1;
    public static final int SPEECH_EXIT = 2;
    public static final int SPEECH_MEMORY_PARKING_CONTINUE_FOUND_PARKLOT_START = 8;
    public static final int SPEECH_MEMORY_PARKING_FOUND_PARKLOT_EXIT = 9;
    public static final int SPEECH_MEMORY_PARKING_FOUND_PARKLOT_START = 7;
    public static final int SPEECH_MEMORY_PARKING_START = 5;
    public static final int SPEECH_PARK_CARPORT_COUNT = 4;
    public static final int SPEECH_PARK_START = 3;
    public static final int SPEECH_TRAINING_PARKING_START = 6;
    public int action;
    public String data;

    public SpeechApiRouteEvent(int i, String str) {
        this.action = 0;
        this.action = i;
        this.data = str;
    }
}
