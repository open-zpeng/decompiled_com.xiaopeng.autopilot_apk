package com.xiaopeng.autopilot.x.protocol.bean.gson;

import java.util.List;
/* loaded from: classes.dex */
public class ShareMapBean {
    public static final int charging_pie = 1;
    public static final int elevator = 2;
    public static final int other = 4;
    public static final int stair = 3;
    public List<Integer> Dest;
    public int Floor;
    public long mapTime;

    public ShareMapBean(int i, List<Integer> list, long j) {
        this.mapTime = 0L;
        this.Floor = i;
        this.Dest = list;
        this.mapTime = j;
    }
}
