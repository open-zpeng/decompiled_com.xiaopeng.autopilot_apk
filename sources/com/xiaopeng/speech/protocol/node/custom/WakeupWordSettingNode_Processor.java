package com.xiaopeng.speech.protocol.node.custom;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class WakeupWordSettingNode_Processor implements ICommandProcessor {
    private WakeupWordSettingNode a;

    public WakeupWordSettingNode_Processor(WakeupWordSettingNode wakeupWordSettingNode) {
        this.a = wakeupWordSettingNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1752205390) {
            if (hashCode == -376932620 && str.equals("custom.wakeup.word.manual.input")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("custom.wakeup.word.setting.done")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onManualInput(str, str2);
                return;
            case 1:
                this.a.onSettingDone(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"custom.wakeup.word.manual.input", "custom.wakeup.word.setting.done"};
    }
}
