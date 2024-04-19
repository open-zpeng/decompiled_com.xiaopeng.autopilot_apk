package com.xiaopeng.autopilot.x.protocol.bean.gson;
/* loaded from: classes.dex */
public class EvaluateBean {
    public static final int LIKE = 1;
    public static final int NONE = 2;
    public static final int NOT_LIKE = 3;
    public int evaluation;
    public String mapName;
    public long mapTime;
    public int type;

    public EvaluateBean(String str, int i, int i2, long j) {
        this.mapName = str;
        this.evaluation = i;
        this.type = i2;
        this.mapTime = j;
    }
}
