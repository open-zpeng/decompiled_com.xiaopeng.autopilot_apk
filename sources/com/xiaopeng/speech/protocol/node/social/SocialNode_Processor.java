package com.xiaopeng.speech.protocol.node.social;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class SocialNode_Processor implements ICommandProcessor {
    private SocialNode a;

    public SocialNode_Processor(SocialNode socialNode) {
        this.a = socialNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1489293258:
                if (str.equals("command://social.motorcade.open")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1174519421:
                if (str.equals("jarvis.voice.click")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1000693031:
                if (str.equals("command://social.reply.topic")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -967605051:
                if (str.equals("command://social.quit.chat")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -470207025:
                if (str.equals("command://social.create.topic")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -411700335:
                if (str.equals("command://social.grab.mic.cancel")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1065357708:
                if (str.equals("command://social.motorcade.close")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1292442478:
                if (str.equals("command://social.confirm")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1454210858:
                if (str.equals("jarvis.back.click")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1829874700:
                if (str.equals("command://social.cancel")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 2077193399:
                if (str.equals("command://social.grab.mic")) {
                    c = 2;
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
                this.a.onSocialMotorcadeOpen(str, str2);
                return;
            case 1:
                this.a.onSocialMotorcadeClose(str, str2);
                return;
            case 2:
                this.a.onSocialGrabMic(str, str2);
                return;
            case 3:
                this.a.onSocialGrabMicCancel(str, str2);
                return;
            case 4:
                this.a.onSocialCreateTopic(str, str2);
                return;
            case 5:
                this.a.onSocialReplyTopic(str, str2);
                return;
            case 6:
                this.a.onSocialQuitChat(str, str2);
                return;
            case 7:
                this.a.onSocialConfirm(str, str2);
                return;
            case '\b':
                this.a.onSocialCancel(str, str2);
                return;
            case '\t':
                this.a.onVoiceButtonClick(str, str2);
                return;
            case '\n':
                this.a.onBackButtonClick(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://social.motorcade.open", "command://social.motorcade.close", "command://social.grab.mic", "command://social.grab.mic.cancel", "command://social.create.topic", "command://social.reply.topic", "command://social.quit.chat", "command://social.confirm", "command://social.cancel", "jarvis.voice.click", "jarvis.back.click"};
    }
}
