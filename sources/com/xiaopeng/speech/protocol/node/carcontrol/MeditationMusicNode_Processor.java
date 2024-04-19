package com.xiaopeng.speech.protocol.node.carcontrol;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class MeditationMusicNode_Processor implements ICommandProcessor {
    private MeditationMusicNode a;

    public MeditationMusicNode_Processor(MeditationMusicNode meditationMusicNode) {
        this.a = meditationMusicNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -2031117940) {
            if (str.equals("meditation.music.control.pause")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == 1520748375) {
            if (str.equals("meditation.music.control.resume")) {
                c = 3;
            }
            c = 65535;
        } else if (hashCode != 1874087069) {
            if (hashCode == 1874158557 && str.equals("meditation.music.control.prev")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("meditation.music.control.next")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onPrev(str, str2);
                return;
            case 1:
                this.a.onNext(str, str2);
                return;
            case 2:
                this.a.onPause(str, str2);
                return;
            case 3:
                this.a.onResume(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"meditation.music.control.prev", "meditation.music.control.next", "meditation.music.control.pause", "meditation.music.control.resume"};
    }
}
