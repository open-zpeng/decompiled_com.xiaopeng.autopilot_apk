package com.xiaopeng.speech.protocol.node.internal;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class InternalNode_Processor implements ICommandProcessor {
    private InternalNode a;

    public InternalNode_Processor(InternalNode internalNode) {
        this.a = internalNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1771481023:
                if (str.equals("sys.reboot.complete")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 735086539:
                if (str.equals("input.dm.data")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1211476952:
                if (str.equals("local_wakeup.result")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1445372987:
                if (str.equals("sys.resource.updateFinish")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1795896838:
                if (str.equals("dm.output")) {
                    c = 0;
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
                this.a.onDmOutput(str, str2);
                return;
            case 1:
                this.a.onInputDmData(str, str2);
                return;
            case 2:
                this.a.onLocalWakeupResult(str, str2);
                return;
            case 3:
                this.a.onResourceUpdateFinish(str, str2);
                return;
            case 4:
                this.a.onRebootComplete(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"dm.output", "input.dm.data", "local_wakeup.result", "sys.resource.updateFinish", "sys.reboot.complete"};
    }
}
