package com.xiaopeng.speech.protocol.node.oobe;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class OOBENode_Processor implements ICommandProcessor {
    private OOBENode a;

    public OOBENode_Processor(OOBENode oOBENode) {
        this.a = oOBENode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1653395749:
                if (str.equals("command://oobe.skip")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1548651618:
                if (str.equals("command://oobe.search.error")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1397629300:
                if (str.equals("command://oobe.address.set")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 176523582:
                if (str.equals("command://oobe.asr.error")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 177511753:
                if (str.equals("command://oobe.record.input")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 314263926:
                if (str.equals("command://oobe.volume")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 780227936:
                if (str.equals("command://error.asr.result")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 983678060:
                if (str.equals("command://oobe.network.error")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1457336958:
                if (str.equals("command://oobe.record.result")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1505323214:
                if (str.equals("command://oobe.other.error")) {
                    c = 7;
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
                this.a.onRecordResult(str, str2);
                return;
            case 1:
                this.a.onRecordInput(str, str2);
                return;
            case 2:
                this.a.onAddressSet(str, str2);
                return;
            case 3:
                this.a.onSkip(str, str2);
                return;
            case 4:
                this.a.onSearchError(str, str2);
                return;
            case 5:
                this.a.onNetError(str, str2);
                return;
            case 6:
                this.a.onASRError(str, str2);
                return;
            case 7:
                this.a.onError(str, str2);
                return;
            case '\b':
                this.a.onVolumeChange(str, str2);
                return;
            case '\t':
                this.a.onNetWorkError(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://oobe.record.result", "command://oobe.record.input", "command://oobe.address.set", "command://oobe.skip", "command://oobe.search.error", "command://error.asr.result", "command://oobe.asr.error", "command://oobe.other.error", "command://oobe.volume", "command://oobe.network.error"};
    }
}
