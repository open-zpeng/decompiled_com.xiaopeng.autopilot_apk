package com.xiaopeng.speech.protocol.node.changba;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class ChangbaNode_Processor implements ICommandProcessor {
    private ChangbaNode a;

    public ChangbaNode_Processor(ChangbaNode changbaNode) {
        this.a = changbaNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == -2072002904 && str.equals("command://changba.search.music")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.onMusicChangbaSearch(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://changba.search.music"};
    }
}
