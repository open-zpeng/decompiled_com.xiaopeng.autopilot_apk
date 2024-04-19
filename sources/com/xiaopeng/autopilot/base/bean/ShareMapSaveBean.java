package com.xiaopeng.autopilot.base.bean;
/* loaded from: classes.dex */
public class ShareMapSaveBean {
    private boolean IsShared;
    private long MapId;

    public ShareMapSaveBean(long j, boolean z) {
        this.MapId = j;
        this.IsShared = z;
    }

    public long getMapId() {
        return this.MapId;
    }

    public void setMapId(long j) {
        this.MapId = j;
    }

    public boolean isShared() {
        return this.IsShared;
    }

    public void setShared(boolean z) {
        this.IsShared = z;
    }
}
