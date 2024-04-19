package com.xiaopeng.speech.protocol.node.asr;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class AsrNode extends xa<com.xiaopeng.speech.protocol.node.app.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onAsrEvent(String str, String str2) {
        Object[] a = this.b.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ym a2 = ym.a(str2);
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                ((a) a[i]).a(a2.a);
                ((a) a[i]).a(a2);
            }
        }
    }
}
