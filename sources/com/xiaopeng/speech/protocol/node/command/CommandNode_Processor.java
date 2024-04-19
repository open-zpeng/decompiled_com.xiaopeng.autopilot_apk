package com.xiaopeng.speech.protocol.node.command;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class CommandNode_Processor implements ICommandProcessor {
    private CommandNode a;

    public CommandNode_Processor(CommandNode commandNode) {
        this.a = commandNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == 380439127 && str.equals("command://json.post")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.onJsonPost(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://json.post"};
    }
}
