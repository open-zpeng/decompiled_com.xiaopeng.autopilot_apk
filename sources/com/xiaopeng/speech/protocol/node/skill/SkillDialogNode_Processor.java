package com.xiaopeng.speech.protocol.node.skill;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class SkillDialogNode_Processor implements ICommandProcessor {
    private SkillDialogNode a;

    public SkillDialogNode_Processor(SkillDialogNode skillDialogNode) {
        this.a = skillDialogNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1594338748:
                if (str.equals("speech.skill.key.guide")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1248956104:
                if (str.equals("ai.show.skill.window")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -764162793:
                if (str.equals("ai.dismiss.skill.window")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -91367129:
                if (str.equals("ai.forward.screen.event")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2043108326:
                if (str.equals("speech.skill.refresh.data")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2110322600:
                if (str.equals("speech.skill.double.guide")) {
                    c = 4;
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
                this.a.onForwardScreenEvent(str, str2);
                return;
            case 3:
                this.a.onRefreshSkillData(str, str2);
                return;
            case 4:
                this.a.onShowDoubleGuide(str, str2);
                return;
            case 5:
                this.a.onShowKeyGuide(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"ai.dismiss.skill.window", "ai.show.skill.window", "ai.forward.screen.event", "speech.skill.refresh.data", "speech.skill.double.guide", "speech.skill.key.guide"};
    }
}
