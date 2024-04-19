package com.xiaopeng.sr.bean;

import com.google.gson.JsonElement;
/* loaded from: classes.dex */
public class JsonMsgBean {
    private String MsgType;
    private JsonElement data;
    private int id;
    private int status;
    private String ver;

    public String getVer() {
        return this.ver;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public String getMsgType() {
        return this.MsgType;
    }

    public void setMsgType(String str) {
        this.MsgType = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public JsonElement getData() {
        return this.data;
    }

    public void setData(JsonElement jsonElement) {
        this.data = jsonElement;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }
}
