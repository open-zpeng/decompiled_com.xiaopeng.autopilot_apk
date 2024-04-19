package com.xiaopeng.speech.protocol.node.record;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class RecordNode_Processor implements ICommandProcessor {
    private RecordNode a;

    public RecordNode_Processor(RecordNode recordNode) {
        this.a = recordNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -2099844195:
                if (str.equals("jarvis.speech.volume")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -477025291:
                if (str.equals("jarvis.record.begin")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -473856684:
                if (str.equals("jarvis.record.error")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 223082937:
                if (str.equals("jarvis.asr.cloundresult")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 744773574:
                if (str.equals("jarvis.speech.begin")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 747146040:
                if (str.equals("jarvis.speech.end")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 871014183:
                if (str.equals("jarvis.record.end")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1711895190:
                if (str.equals("jarvis.record.maxlength")) {
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
                this.a.onAsrResult(str, str2);
                return;
            case 1:
                this.a.onRecordBegin(str, str2);
                return;
            case 2:
                this.a.onRecordEnd(str, str2);
                return;
            case 3:
                this.a.onRecordError(str, str2);
                return;
            case 4:
                this.a.onSpeechBegin(str, str2);
                return;
            case 5:
                this.a.onSpeechEnd(str, str2);
                return;
            case 6:
                this.a.onSpeechVolume(str, str2);
                return;
            case 7:
                this.a.onRecordMaxLength(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"jarvis.asr.cloundresult", "jarvis.record.begin", "jarvis.record.end", "jarvis.record.error", "jarvis.speech.begin", "jarvis.speech.end", "jarvis.speech.volume", "jarvis.record.maxlength"};
    }
}
