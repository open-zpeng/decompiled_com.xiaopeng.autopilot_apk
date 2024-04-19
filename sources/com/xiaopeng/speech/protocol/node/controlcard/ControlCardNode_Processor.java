package com.xiaopeng.speech.protocol.node.controlcard;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class ControlCardNode_Processor implements ICommandProcessor {
    private ControlCardNode a;

    public ControlCardNode_Processor(ControlCardNode controlCardNode) {
        this.a = controlCardNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1874400088:
                if (str.equals("command://card.ac.seat.ventilate.driver")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -778931165:
                if (str.equals("command://card.system.screen.brightness")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -205168772:
                if (str.equals("command://card.system.icm.brightness")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 90422065:
                if (str.equals("command://card.ac.temp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 90515301:
                if (str.equals("command://card.ac.wind")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 463841200:
                if (str.equals("command://card.ac.seat.heating.driver")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 551410205:
                if (str.equals("command://card.ac.temp.passenger")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1167636869:
                if (str.equals("command://card.ac.temp.driver")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1804974098:
                if (str.equals("command://card.ac.seat.heating.passenger")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1905039599:
                if (str.equals("command://card.control.light.atmosphere.color")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2107431493:
                if (str.equals("command://card.control.light.atmosphere.brightness")) {
                    c = 4;
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
                this.a.showAcTempCard(str, str2);
                return;
            case 1:
                this.a.showAcDriverTempCard(str, str2);
                return;
            case 2:
                this.a.showAcPassengerTempCard(str, str2);
                return;
            case 3:
                this.a.showAcWindCard(str, str2);
                return;
            case 4:
                this.a.showAtmosphereBrightnessCard(str, str2);
                return;
            case 5:
                this.a.showAtmosphereBrightnessColorCard(str, str2);
                return;
            case 6:
                this.a.showAcSeatHeatingDriverCard(str, str2);
                return;
            case 7:
                this.a.showAcSeatHeatingPassengerCard(str, str2);
                return;
            case '\b':
                this.a.showAcSeatVentilateDriverCard(str, str2);
                return;
            case '\t':
                this.a.showSystemScreenBrightnessCard(str, str2);
                return;
            case '\n':
                this.a.showSystemIcmBrightnessCard(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://card.ac.temp", "command://card.ac.temp.driver", "command://card.ac.temp.passenger", "command://card.ac.wind", "command://card.control.light.atmosphere.brightness", "command://card.control.light.atmosphere.color", "command://card.ac.seat.heating.driver", "command://card.ac.seat.heating.passenger", "command://card.ac.seat.ventilate.driver", "command://card.system.screen.brightness", "command://card.system.icm.brightness"};
    }
}
