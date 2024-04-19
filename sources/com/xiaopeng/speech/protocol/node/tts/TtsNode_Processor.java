package com.xiaopeng.speech.protocol.node.tts;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class TtsNode_Processor implements ICommandProcessor {
    private TtsNode a;

    public TtsNode_Processor(TtsNode ttsNode) {
        this.a = ttsNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1878648165) {
            if (str.equals("speech.tts.start")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -1163978412) {
            if (hashCode == -201524934 && str.equals("tts.timbre.setting")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("speech.tts.end")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onTtsStart(str, str2);
                return;
            case 1:
                this.a.onTtsEnd(str, str2);
                return;
            case 2:
                this.a.onTtsTimbreSetting(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"speech.tts.start", "speech.tts.end", "tts.timbre.setting"};
    }
}
