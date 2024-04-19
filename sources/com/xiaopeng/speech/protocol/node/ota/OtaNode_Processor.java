package com.xiaopeng.speech.protocol.node.ota;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class OtaNode_Processor implements ICommandProcessor {
    private OtaNode a;

    public OtaNode_Processor(OtaNode otaNode) {
        this.a = otaNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 478800373) {
            if (hashCode == 1009711693 && str.equals("command://gui.otareservation.page.open")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("command://gui.ota.page.open")) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onOpenOtaPage(str, str2);
                return;
            case 1:
                this.a.onOpenReservationPage(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://gui.ota.page.open", "command://gui.otareservation.page.open"};
    }
}
