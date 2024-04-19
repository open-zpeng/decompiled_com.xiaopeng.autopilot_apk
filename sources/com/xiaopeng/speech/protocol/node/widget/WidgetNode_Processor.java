package com.xiaopeng.speech.protocol.node.widget;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class WidgetNode_Processor implements ICommandProcessor {
    private WidgetNode a;

    public WidgetNode_Processor(WidgetNode widgetNode) {
        this.a = widgetNode;
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        if (((str.hashCode() == -691162900 && str.equals("command://ac.widget.on")) ? (char) 0 : (char) 65535) != 0) {
            return;
        }
        this.a.onAcWidgetOn(str, str2);
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://ac.widget.on"};
    }
}
