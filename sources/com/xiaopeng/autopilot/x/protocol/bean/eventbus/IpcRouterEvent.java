package com.xiaopeng.autopilot.x.protocol.bean.eventbus;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* loaded from: classes.dex */
public class IpcRouterEvent {
    int mMsgID;
    JsonObject mPayloadData;
    String mSenderPackageName;
    String mStringData;

    public IpcRouterEvent() {
        this.mSenderPackageName = "com.xiaopeng.xxx";
        this.mStringData = "";
    }

    public IpcRouterEvent(int i, String str) {
        this.mSenderPackageName = "com.xiaopeng.xxx";
        this.mStringData = "";
        this.mMsgID = i;
        this.mPayloadData = JsonParser.parseString(str).getAsJsonObject();
        if (this.mPayloadData.has("senderPackageName")) {
            this.mSenderPackageName = this.mPayloadData.get("senderPackageName").getAsString();
        }
        if (this.mPayloadData.has(IpcConfig.IPCKey.STRING_MSG)) {
            this.mStringData = this.mPayloadData.get(IpcConfig.IPCKey.STRING_MSG).getAsString();
        }
    }

    public String getSenderPackageName() {
        return this.mSenderPackageName;
    }

    public void setSenderPackageName(String str) {
        this.mSenderPackageName = str;
    }

    public int getMsgID() {
        return this.mMsgID;
    }

    public void setMsgID(int i) {
        this.mMsgID = i;
    }

    public JsonObject getPayloadData() {
        return this.mPayloadData;
    }

    public void setPayloadData(JsonObject jsonObject) {
        this.mPayloadData = jsonObject;
    }

    public void setStringData(String str) {
        this.mStringData = str;
    }

    public String getStringData() {
        return this.mStringData;
    }

    public String toString() {
        return "IpcMessageEvent{mSenderPackageName='" + this.mSenderPackageName + "', mMsgID=" + this.mMsgID + ", mPayloadData=" + this.mPayloadData + '}';
    }
}
