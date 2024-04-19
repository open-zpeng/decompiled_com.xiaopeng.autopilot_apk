package com.xiaopeng.speech.protocol.node.xpu;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class XpuNode_Processor implements ICommandProcessor {
    private XpuNode a;

    public XpuNode_Processor(XpuNode xpuNode) {
        this.a = xpuNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == -47958497 && str.equals("command://voice.change.lane")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.laneChange(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://voice.change.lane"};
    }
}
