package com.xiaopeng.speech.protocol.node.avatar;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class AvatarNode_Processor implements ICommandProcessor {
    private AvatarNode a;

    public AvatarNode_Processor(AvatarNode avatarNode) {
        this.a = avatarNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1543075995:
                if (str.equals("jarvis.avatar.wakeup.disable")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1187871553:
                if (str.equals("jarvis.dm.listening")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -671951780:
                if (str.equals("context.widget.custom")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -229200237:
                if (str.equals("context.widget.search")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -206519100:
                if (str.equals("jarvis.avatar.expression")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 260029798:
                if (str.equals("jarvis.avatar.wakeup.enable")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 402709913:
                if (str.equals("context.widget.media")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 843973307:
                if (str.equals("context.widget.card")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 844249161:
                if (str.equals("context.widget.list")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 844483800:
                if (str.equals("context.widget.text")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1330018892:
                if (str.equals("jarvis.dm.speaking")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1386014226:
                if (str.equals("jarvis.dm.recognized")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1566189864:
                if (str.equals("jarvis.dm.understanding")) {
                    c = 3;
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
                this.a.onSilence(str, str2);
                return;
            case 1:
                this.a.onListening(str, str2);
                return;
            case 2:
                this.a.onSpeaking(str, str2);
                return;
            case 3:
                this.a.onUnderstanding(str, str2);
                return;
            case 4:
                this.a.onAvatarExpression(str, str2);
                return;
            case 5:
                this.a.onWidgetCustom(str, str2);
                return;
            case 6:
                this.a.onWidgetText(str, str2);
                return;
            case 7:
                this.a.onWidgetList(str, str2);
                return;
            case '\b':
                this.a.onWidgetMedia(str, str2);
                return;
            case '\t':
                this.a.onWidgetCard(str, str2);
                return;
            case '\n':
                this.a.onWidgetSearch(str, str2);
                return;
            case 11:
                this.a.onAvatarWakerupEnable(str, str2);
                return;
            case '\f':
                this.a.onAvatarWakerupDisable(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"jarvis.dm.recognized", "jarvis.dm.listening", "jarvis.dm.speaking", "jarvis.dm.understanding", "jarvis.avatar.expression", "context.widget.custom", "context.widget.text", "context.widget.list", "context.widget.media", "context.widget.card", "context.widget.search", "jarvis.avatar.wakeup.enable", "jarvis.avatar.wakeup.disable"};
    }
}
