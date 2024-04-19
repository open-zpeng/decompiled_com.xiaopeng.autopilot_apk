package com.xiaopeng.speech.protocol.node.meter;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class MeterNode_Processor implements ICommandProcessor {
    private MeterNode a;

    public MeterNode_Processor(MeterNode meterNode) {
        this.a = meterNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1943195853) {
            if (str.equals("set.meter.right.card")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != -1464668575) {
            if (hashCode == 432832230 && str.equals("set.meter.left.card")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("native://meter.dashboard.lights.status")) {
                c = 2;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.setLeftCard(str, str2);
                return;
            case 1:
                this.a.setRightCard(str, str2);
                return;
            case 2:
                this.a.onDashboardLightsStatus(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"set.meter.left.card", "set.meter.right.card", "native://meter.dashboard.lights.status"};
    }
}
