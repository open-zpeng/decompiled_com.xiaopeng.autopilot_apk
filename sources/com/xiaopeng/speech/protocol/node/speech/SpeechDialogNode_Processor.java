package com.xiaopeng.speech.protocol.node.speech;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class SpeechDialogNode_Processor implements ICommandProcessor {
    private SpeechDialogNode a;

    public SpeechDialogNode_Processor(SpeechDialogNode speechDialogNode) {
        this.a = speechDialogNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1817558719:
                if (str.equals("command://refresh.carspeechservice.ui")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1676326235:
                if (str.equals("command://speech.continuous.enable")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1440570874:
                if (str.equals("command://speech.continuous.disable")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1181317093:
                if (str.equals("command://system.listentime.accompany.close")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -412443633:
                if (str.equals("ai.show.scene.guide.window")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -265464658:
                if (str.equals("ai.dismiss.scene.guide.window")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -176140078:
                if (str.equals("ai.dismiss.speech.window")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 239348679:
                if (str.equals("command://system.listentime.accompany.open")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1975136465:
                if (str.equals("ai.show.speech.window")) {
                    c = 1;
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
                this.a.onCloseWindow(str, str2);
                return;
            case 1:
                this.a.onOpenWindow(str, str2);
                return;
            case 2:
                this.a.onOpenSceneGuideWindow(str, str2);
                return;
            case 3:
                this.a.onCloseSceneGuideWindow(str, str2);
                return;
            case 4:
                this.a.onOpenSpeechSceneSetting(str, str2);
                return;
            case 5:
                this.a.onCloseSpeechSceneSetting(str, str2);
                return;
            case 6:
                this.a.onOpenSuperDialogue(str, str2);
                return;
            case 7:
                this.a.onCloseSuperDialogue(str, str2);
                return;
            case '\b':
                this.a.onRefreshUi(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"ai.dismiss.speech.window", "ai.show.speech.window", "ai.show.scene.guide.window", "ai.dismiss.scene.guide.window", "command://speech.continuous.enable", "command://speech.continuous.disable", "command://system.listentime.accompany.open", "command://system.listentime.accompany.close", "command://refresh.carspeechservice.ui"};
    }
}
