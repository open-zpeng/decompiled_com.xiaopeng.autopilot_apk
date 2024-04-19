package com.xiaopeng.speech.protocol.node.error;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class ErrorNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onErrorAsrResult(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }
}
