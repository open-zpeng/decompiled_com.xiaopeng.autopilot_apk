package com.xiaopeng.speech.protocol.node.autoparking;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class AutoParkingNode_Processor implements ICommandProcessor {
    private AutoParkingNode a;

    public AutoParkingNode_Processor(AutoParkingNode autoParkingNode) {
        this.a = autoParkingNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case 60390650:
                if (str.equals("native://autoparking.park.carport.count")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 658676530:
                if (str.equals("command://autoparking.exit")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 744299561:
                if (str.equals("command://control.car.favoriteslotparking.on")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 897056882:
                if (str.equals("command://autoparking.park.start")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1563921671:
                if (str.equals("command://autoparking.activate")) {
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
                this.a.onActivate(str, str2);
                return;
            case 1:
                this.a.onExit(str, str2);
                return;
            case 2:
                this.a.onParkStart(str, str2);
                return;
            case 3:
                this.a.onParkCarportCount(str, str2);
                return;
            case 4:
                this.a.onMemoryParkingStart(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://autoparking.activate", "command://autoparking.exit", "command://autoparking.park.start", "native://autoparking.park.carport.count", "command://control.car.favoriteslotparking.on"};
    }
}
