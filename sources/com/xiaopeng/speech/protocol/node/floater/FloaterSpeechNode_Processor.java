package com.xiaopeng.speech.protocol.node.floater;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class FloaterSpeechNode_Processor implements ICommandProcessor {
    private FloaterSpeechNode a;

    public FloaterSpeechNode_Processor(FloaterSpeechNode floaterSpeechNode) {
        this.a = floaterSpeechNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1829252700) {
            if (str.equals("command://xiaop.expression")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 1493310260) {
            if (hashCode == 1920721242 && str.equals("command://floater.close.window")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("command://floater.set.anim.state")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onCloseWindow(str, str2);
                return;
            case 1:
                this.a.onSetAnimState(str, str2);
                return;
            case 2:
                this.a.onXiaopExpression(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://floater.close.window", "command://floater.set.anim.state", "command://xiaop.expression"};
    }
}
