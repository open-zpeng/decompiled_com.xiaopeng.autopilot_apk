package com.xiaopeng.speech.protocol.node.fm;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class FMNode_Processor implements ICommandProcessor {
    private FMNode a;

    public FMNode_Processor(FMNode fMNode) {
        this.a = fMNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1616140812:
                if (str.equals("command://fm.local.off")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -627784393:
                if (str.equals("command://fm.network.off")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -297345769:
                if (str.equals("command://fm.network.on")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -190680902:
                if (str.equals("command://fm.local.on")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 616790465:
                if (str.equals("command://fm.play.channel")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1124241696:
                if (str.equals("command://fm.play.collection")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2103491480:
                if (str.equals("native://fm.play.channelname")) {
                    c = 5;
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
                this.a.onFmLocalOn(str, str2);
                return;
            case 1:
                this.a.onFmLocalOff(str, str2);
                return;
            case 2:
                this.a.onFmNetworkOn(str, str2);
                return;
            case 3:
                this.a.onFmNetworkOff(str, str2);
                return;
            case 4:
                this.a.onFmPlayChannel(str, str2);
                return;
            case 5:
                this.a.onFmPlayChannelName(str, str2);
                return;
            case 6:
                this.a.onPlayCollectFM(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://fm.local.on", "command://fm.local.off", "command://fm.network.on", "command://fm.network.off", "command://fm.play.channel", "native://fm.play.channelname", "command://fm.play.collection"};
    }
}
