package com.xiaopeng.speech.protocol.node.custom;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class WakeupWordSettingNode extends xa<b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onManualInput(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSettingDone(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).b(str2);
            }
        }
    }
}
