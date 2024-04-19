package com.xiaopeng.speech.protocol.node.error;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class ErrorNode_Processor implements ICommandProcessor {
    private ErrorNode a;

    public ErrorNode_Processor(ErrorNode errorNode) {
        this.a = errorNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == 780227936 && str.equals("command://error.asr.result")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.onErrorAsrResult(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://error.asr.result"};
    }
}
