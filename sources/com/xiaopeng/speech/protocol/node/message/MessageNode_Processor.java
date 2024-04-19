package com.xiaopeng.speech.protocol.node.message;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class MessageNode_Processor implements ICommandProcessor {
    private MessageNode a;

    public MessageNode_Processor(MessageNode messageNode) {
        this.a = messageNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1618710173:
                if (str.equals("command://message.path.change")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1486791704:
                if (str.equals("command://message.parking.select")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1370113131:
                if (str.equals("command://common.message.cancel")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -893924045:
                if (str.equals("command://common.message.submit")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 738039525:
                if (str.equals("command://message.ai.to.speech")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 963627594:
                if (str.equals("command://common.message.ai.to.speech")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1482412654:
                if (str.equals("jarvis.message.engine.status")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1609816176:
                if (str.equals("command://message.cancel")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1843785962:
                if (str.equals("command://ai.message.disable")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1887912220:
                if (str.equals("command://ai.message.disable.seven.days")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.a.onCancel(str, str2);
                return;
            case 1:
                this.a.onParkingSelected(str, str2);
                return;
            case 2:
                this.a.onPathChanged(str, str2);
                return;
            case 3:
                this.a.onAIMessage(str, str2);
                return;
            case 4:
                this.a.onCommonAIMessage(str, str2);
                return;
            case 5:
                this.a.onCommonSubmit(str, str2);
                return;
            case 6:
                this.a.onCommonCancel(str, str2);
                return;
            case 7:
                this.a.onAIMessageDisable(str, str2);
                return;
            case '\b':
                this.a.onAIMessageDisableSevenDays(str, str2);
                return;
            case '\t':
                this.a.onHotWordEngineOK(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://message.cancel", "command://message.parking.select", "command://message.path.change", "command://message.ai.to.speech", "command://common.message.ai.to.speech", "command://common.message.submit", "command://common.message.cancel", "command://ai.message.disable", "command://ai.message.disable.seven.days", "jarvis.message.engine.status"};
    }
}
