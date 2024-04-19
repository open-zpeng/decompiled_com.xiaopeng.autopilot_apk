package com.xiaopeng.speech.protocol.node.command;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class CommandNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onJsonPost(String str, String str2) {
        Object[] a = this.b.a();
        zl b = zl.b(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(b);
            }
        }
    }
}
