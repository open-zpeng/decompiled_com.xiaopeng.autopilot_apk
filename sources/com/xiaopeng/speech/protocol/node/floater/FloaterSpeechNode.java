package com.xiaopeng.speech.protocol.node.floater;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class FloaterSpeechNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCloseWindow(String str, String str2) {
        Object[] a = this.b.a();
        int parseInt = Integer.parseInt(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(parseInt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSetAnimState(String str, String str2) {
        zb a = zb.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onXiaopExpression(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str2);
            }
        }
    }
}
