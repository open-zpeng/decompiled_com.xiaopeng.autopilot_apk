package com.xiaopeng.speech.protocol.node.speech.carcontrol;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class SpeechCarControlNode_Processor implements ICommandProcessor {
    private SpeechCarControlNode a;

    public SpeechCarControlNode_Processor(SpeechCarControlNode speechCarControlNode) {
        this.a = speechCarControlNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1772666300) {
            if (hashCode == 81725566 && str.equals("command://charge.power.open")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("command://charge.power.close")) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onCloseSoc(str, str2);
                return;
            case 1:
                this.a.onOpenSoc(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://charge.power.close", "command://charge.power.open"};
    }
}
