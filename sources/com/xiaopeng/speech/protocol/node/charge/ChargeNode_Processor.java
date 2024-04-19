package com.xiaopeng.speech.protocol.node.charge;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class ChargeNode_Processor implements ICommandProcessor {
    private ChargeNode a;

    public ChargeNode_Processor(ChargeNode chargeNode) {
        this.a = chargeNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1965971708:
                if (str.equals("command://charge.restart")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1734769001:
                if (str.equals("command://charge.start")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1609014560:
                if (str.equals("command://charge.change.wltp.mileage")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1237470650:
                if (str.equals("command://charge.trankpower.power.on")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1025791187:
                if (str.equals("command://charge.stop")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -898173837:
                if (str.equals("command://charge.mode.smart.close")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -879718580:
                if (str.equals("command://charge.port.open")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -41146710:
                if (str.equals("command://charge.mode.smart.off")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 189571877:
                if (str.equals("command://charge.mode.percent")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 277827503:
                if (str.equals("command://charge.mode.full")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 293115368:
                if (str.equals("command://charge.trankpower.power.off")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 552862020:
                if (str.equals("command://charge.mode.smart.on")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 747198041:
                if (str.equals("command://charge.ui.open")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 970243195:
                if (str.equals("command://charge.discharge.limit.value.set")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1677111241:
                if (str.equals("command://charge.ui.close")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2089286213:
                if (str.equals("command://charge.change.nedc.mileage")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2126369895:
                if (str.equals("command://charge.change.cltc.mileage")) {
                    c = 16;
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
                this.a.onPortOpen(str, str2);
                return;
            case 1:
                this.a.onStart(str, str2);
                return;
            case 2:
                this.a.onRestart(str, str2);
                return;
            case 3:
                this.a.onStop(str, str2);
                return;
            case 4:
                this.a.onUiOpen(str, str2);
                return;
            case 5:
                this.a.onUiClose(str, str2);
                return;
            case 6:
                this.a.onModePercent(str, str2);
                return;
            case 7:
                this.a.onModeFull(str, str2);
                return;
            case '\b':
                this.a.onModeSmartOn(str, str2);
                return;
            case '\t':
                this.a.onModeSmartClose(str, str2);
                return;
            case '\n':
                this.a.onModeSmartOff(str, str2);
                return;
            case 11:
                this.a.onChangeWltpMileageMode(str, str2);
                return;
            case '\f':
                this.a.onChangeNedcMileageMode(str, str2);
                return;
            case '\r':
                this.a.onChargeTrunkPowerOpen(str, str2);
                return;
            case 14:
                this.a.onChargeTrunkPowerClose(str, str2);
                return;
            case 15:
                this.a.setDischargeLimit(str, str2);
                return;
            case 16:
                this.a.onChangeCltcMileageMode(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://charge.port.open", "command://charge.start", "command://charge.restart", "command://charge.stop", "command://charge.ui.open", "command://charge.ui.close", "command://charge.mode.percent", "command://charge.mode.full", "command://charge.mode.smart.on", "command://charge.mode.smart.close", "command://charge.mode.smart.off", "command://charge.change.wltp.mileage", "command://charge.change.nedc.mileage", "command://charge.trankpower.power.on", "command://charge.trankpower.power.off", "command://charge.discharge.limit.value.set", "command://charge.change.cltc.mileage"};
    }
}
