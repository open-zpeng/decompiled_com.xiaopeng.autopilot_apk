package com.xiaopeng.sr.bean;
/* loaded from: classes.dex */
public class ApMapBean {
    public static final int MAP_TERMINAL_ATTR_CHARGING_PIE = 1;
    public static final int MAP_TERMINAL_ATTR_ELEVATOR = 2;
    public static final int MAP_TERMINAL_ATTR_OTHER = 4;
    public static final int MAP_TERMINAL_ATTR_STAIR = 3;
    public static final int MAP_TYPE_PHONE_SHARE_MAP = 2;
    public static final int MAP_TYPE_RECOMMEND_MAP = 3;
    public static final int MAP_TYPE_SELF_MAP = 0;
    public static final int MAP_TYPE_SILENT_LEARN_MAP = 1;
    private long mMapId = -1;
    private int mMapType = -1;
    private int mTerminalAttr = -1;
    private int mTerminalFloor = -1;
    private long mMapTime = -1;

    public long getMapId() {
        return this.mMapId;
    }

    public void setMapId(long j) {
        this.mMapId = j;
    }

    public int getMapType() {
        return this.mMapType;
    }

    public void setMapType(int i) {
        this.mMapType = i;
    }

    public int getTerminalAttr() {
        return this.mTerminalAttr;
    }

    public void setTerminalAttr(int i) {
        this.mTerminalAttr = i;
    }

    public int getTerminalFloor() {
        return this.mTerminalFloor;
    }

    public void setTerminalFloor(int i) {
        this.mTerminalFloor = i;
    }

    public long getMapTime() {
        return this.mMapTime;
    }

    public void setMapTime(long j) {
        this.mMapTime = j;
    }
}
