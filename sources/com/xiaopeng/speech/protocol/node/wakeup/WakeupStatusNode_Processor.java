package com.xiaopeng.speech.protocol.node.wakeup;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class WakeupStatusNode_Processor implements ICommandProcessor {
    private WakeupStatusNode a;

    public WakeupStatusNode_Processor(WakeupStatusNode wakeupStatusNode) {
        this.a = wakeupStatusNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == -304962696 && str.equals("jarvis.wakeup.status")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.onWakeupStatusChanged(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"jarvis.wakeup.status"};
    }
}
