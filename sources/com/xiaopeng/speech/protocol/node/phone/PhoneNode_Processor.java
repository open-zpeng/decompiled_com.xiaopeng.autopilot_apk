package com.xiaopeng.speech.protocol.node.phone;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class PhoneNode_Processor implements ICommandProcessor {
    private PhoneNode a;

    public PhoneNode_Processor(PhoneNode phoneNode) {
        this.a = phoneNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1366657894:
                if (str.equals("native://phone.query.detail.phone")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249983198:
                if (str.equals("command://phone.in.accept")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1094036411:
                if (str.equals("native://phone.query.bluetooth")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1090067804:
                if (str.equals("native://phone.query.bluetooth.sync")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -991558775:
                if (str.equals("native://phone.callback.support")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -761232455:
                if (str.equals("command://phone.in.reject")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -666255396:
                if (str.equals("native://phone.query.contacts")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -500460440:
                if (str.equals("command://phone.out.customerservice")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -307844569:
                if (str.equals("native://phone.redial.support")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 478397247:
                if (str.equals("command://phone.out")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1301635730:
                if (str.equals("command://phone.redial")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1330499435:
                if (str.equals("command://phone.select")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1640880884:
                if (str.equals("command://phone.callback")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1710160883:
                if (str.equals("command://phone.contact.sync.result")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1821930640:
                if (str.equals("command://phone.out.help")) {
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
                this.a.onQuerySyncBluetooth(str, str2);
                return;
            case 1:
                this.a.onQueryContacts(str, str2);
                return;
            case 2:
                this.a.onQueryDetailPhoneInfo(str, str2);
                return;
            case 3:
                this.a.onOut(str, str2);
                return;
            case 4:
                this.a.onPhoneSelectOut(str, str2);
                return;
            case 5:
                this.a.onInAccept(str, str2);
                return;
            case 6:
                this.a.onInReject(str, str2);
                return;
            case 7:
                this.a.onRedialSupport(str, str2);
                return;
            case '\b':
                this.a.onRedial(str, str2);
                return;
            case '\t':
                this.a.onCallbackSupport(str, str2);
                return;
            case '\n':
                this.a.onCallback(str, str2);
                return;
            case 11:
                this.a.onOutCustomerservice(str, str2);
                return;
            case '\f':
                this.a.onOutHelp(str, str2);
                return;
            case '\r':
                this.a.onQueryBluetooth(str, str2);
                return;
            case 14:
                this.a.onSyncContactResult(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"native://phone.query.bluetooth.sync", "native://phone.query.contacts", "native://phone.query.detail.phone", "command://phone.out", "command://phone.select", "command://phone.in.accept", "command://phone.in.reject", "native://phone.redial.support", "command://phone.redial", "native://phone.callback.support", "command://phone.callback", "command://phone.out.customerservice", "command://phone.out.help", "native://phone.query.bluetooth", "command://phone.contact.sync.result"};
    }
}
