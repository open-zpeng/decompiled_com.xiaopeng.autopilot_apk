package com.xiaopeng.speech.protocol.node.bugreport;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class BugReportNode_Processor implements ICommandProcessor {
    private BugReportNode a;

    public BugReportNode_Processor(BugReportNode bugReportNode) {
        this.a = bugReportNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1272286452) {
            if (str.equals("command://bugreport.end.bug")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == -1272269173) {
            if (str.equals("command://bugreport.end.tts")) {
                c = 3;
            }
            c = 65535;
        } else if (hashCode != -1265421229) {
            if (hashCode == -508144235 && str.equals("command://bugreport.volume.bug")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("command://bugreport.start.bug")) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onBugReportBegin(str, str2);
                return;
            case 1:
                this.a.onBugReportEnd(str, str2);
                return;
            case 2:
                this.a.onBugReportVolume(str, str2);
                return;
            case 3:
                this.a.onBugReportEndtts(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://bugreport.start.bug", "command://bugreport.end.bug", "command://bugreport.volume.bug", "command://bugreport.end.tts"};
    }
}
