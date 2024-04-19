package com.xiaopeng.speech.protocol.node.aiassistant;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class AiAssistantNode_Processor implements ICommandProcessor {
    private AiAssistantNode a;

    public AiAssistantNode_Processor(AiAssistantNode aiAssistantNode) {
        this.a = aiAssistantNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1808972678:
                if (str.equals("command://ai.message.close")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -874525820:
                if (str.equals("native://ai.play.video")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -473634936:
                if (str.equals("command://ai.message.open")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 67809134:
                if (str.equals("command://system.avatar.dance")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 422503758:
                if (str.equals("command://ai.open.video")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1345769982:
                if (str.equals("command://ai.play.video.ttsend")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1715275603:
                if (str.equals("command://system.avatar.changeclothes")) {
                    c = 6;
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
                this.a.onPlayVideo(str, str2);
                return;
            case 1:
                this.a.onPlayVideoTtsend(str, str2);
                return;
            case 2:
                this.a.onMessageOpen(str, str2);
                return;
            case 3:
                this.a.onMessageClose(str, str2);
                return;
            case 4:
                this.a.onOpenVideo(str, str2);
                return;
            case 5:
                this.a.onXiaoPDance(str, str2);
                return;
            case 6:
                this.a.onXiaoPChangeClothe(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"native://ai.play.video", "command://ai.play.video.ttsend", "command://ai.message.open", "command://ai.message.close", "command://ai.open.video", "command://system.avatar.dance", "command://system.avatar.changeclothes"};
    }
}
