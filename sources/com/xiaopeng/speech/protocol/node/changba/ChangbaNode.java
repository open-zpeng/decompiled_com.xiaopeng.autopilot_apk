package com.xiaopeng.speech.protocol.node.changba;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class ChangbaNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onMusicChangbaSearch(String str, String str2) {
        Object[] a = this.b.a();
        zk b = zk.b(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(b);
            }
        }
    }
}
