package com.xiaopeng.speech.protocol.node.custom;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class WakeupTestNode_Processor implements ICommandProcessor {
    private WakeupTestNode a;

    public WakeupTestNode_Processor(WakeupTestNode wakeupTestNode) {
        this.a = wakeupTestNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -876394041) {
            if (str.equals("wakeup.test.vad.begin")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == -654737660) {
            if (str.equals("wakeup.test.wakeup.succ")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 1733167481) {
            if (hashCode == 1766842495 && str.equals("wakeup.test.wakeup.failed")) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals("wakeup.test.vad.end")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onVADBeginSpeech(str, str2);
                return;
            case 1:
                this.a.onVADEndSpeech(str, str2);
                return;
            case 2:
                this.a.onWakeupSucced(str, str2);
                return;
            case 3:
                this.a.onWakeupFailed(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"wakeup.test.vad.begin", "wakeup.test.vad.end", "wakeup.test.wakeup.succ", "wakeup.test.wakeup.failed"};
    }
}
