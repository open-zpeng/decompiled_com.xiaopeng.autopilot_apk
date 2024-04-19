package com.xiaopeng.speech.protocol.node.media;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class MediaNode_Processor implements ICommandProcessor {
    private MediaNode a;

    public MediaNode_Processor(MediaNode mediaNode) {
        this.a = mediaNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1657429332:
                if (str.equals("command://media.forward")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1563074367:
                if (str.equals("command://media.control.loop.all")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1524827811:
                if (str.equals("command://media.control.next")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1524762210:
                if (str.equals("command://media.control.play")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1524756323:
                if (str.equals("command://media.control.prev")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1524664724:
                if (str.equals("command://media.control.stop")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -665165651:
                if (str.equals("command://media.control.random")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -661306345:
                if (str.equals("command://media.control.resume")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -23296820:
                if (str.equals("command://media.control.pause")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 226337192:
                if (str.equals("command://media.control.collect.cancel")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 826237568:
                if (str.equals("command://media.control.collect")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 999672104:
                if (str.equals("command://media.control.loop.single")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1005657622:
                if (str.equals("command://media.settime")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 1797961948:
                if (str.equals("command://media.backward")) {
                    c = '\f';
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
                this.a.onPlay(str, str2);
                return;
            case 1:
                this.a.onPlayLoopSingle(str, str2);
                return;
            case 2:
                this.a.onPlayLoopAll(str, str2);
                return;
            case 3:
                this.a.onPlayLoopRandom(str, str2);
                return;
            case 4:
                this.a.onPause(str, str2);
                return;
            case 5:
                this.a.onResume(str, str2);
                return;
            case 6:
                this.a.onPrev(str, str2);
                return;
            case 7:
                this.a.onNext(str, str2);
                return;
            case '\b':
                this.a.onStop(str, str2);
                return;
            case '\t':
                this.a.onControlCollect(str, str2);
                return;
            case '\n':
                this.a.onCancelCollect(str, str2);
                return;
            case 11:
                this.a.onForward(str, str2);
                return;
            case '\f':
                this.a.onBackward(str, str2);
                return;
            case '\r':
                this.a.onSettime(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://media.control.play", "command://media.control.loop.single", "command://media.control.loop.all", "command://media.control.random", "command://media.control.pause", "command://media.control.resume", "command://media.control.prev", "command://media.control.next", "command://media.control.stop", "command://media.control.collect", "command://media.control.collect.cancel", "command://media.forward", "command://media.backward", "command://media.settime"};
    }
}
