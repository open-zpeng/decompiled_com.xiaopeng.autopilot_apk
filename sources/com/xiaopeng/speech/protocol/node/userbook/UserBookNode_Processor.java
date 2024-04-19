package com.xiaopeng.speech.protocol.node.userbook;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class UserBookNode_Processor implements ICommandProcessor {
    private UserBookNode a;

    public UserBookNode_Processor(UserBookNode userBookNode) {
        this.a = userBookNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1001296170) {
            if (str.equals("command://control.close.user.book")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 1414376552) {
            if (hashCode == 1829348592 && str.equals("command://control.manual.search")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("command://control.open.user.book")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                this.a.onCheckUserBook(str, str2);
                return;
            case 1:
                this.a.onOpenUserBook(str, str2);
                return;
            case 2:
                this.a.onCloseUserBook(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://control.manual.search", "command://control.open.user.book", "command://control.close.user.book"};
    }
}
