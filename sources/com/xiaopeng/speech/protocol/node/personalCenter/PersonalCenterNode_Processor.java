package com.xiaopeng.speech.protocol.node.personalCenter;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class PersonalCenterNode_Processor implements ICommandProcessor {
    private PersonalCenterNode a;

    public PersonalCenterNode_Processor(PersonalCenterNode personalCenterNode) {
        this.a = personalCenterNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 911050310) {
            if (hashCode == 1416411835 && str.equals("command://control.profile.habit.select")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("command://control.profile.habit.select.next")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onControlProfileHabitSelect(str, str2);
                return;
            case 1:
                this.a.onControlProfileHabitSelectNext(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://control.profile.habit.select", "command://control.profile.habit.select.next"};
    }
}
