package com.xiaopeng.speech.protocol.node.asr;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class AsrNode_Processor implements ICommandProcessor {
    private AsrNode a;

    public AsrNode_Processor(AsrNode asrNode) {
        this.a = asrNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == -1570875613 && str.equals("jarvis.asr.event")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.onAsrEvent(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"jarvis.asr.event"};
    }
}
