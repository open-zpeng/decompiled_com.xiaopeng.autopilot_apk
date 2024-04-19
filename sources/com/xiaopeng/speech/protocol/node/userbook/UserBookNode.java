package com.xiaopeng.speech.protocol.node.userbook;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
import com.xiaopeng.speech.protocol.node.carcontrol.a;
/* loaded from: classes.dex */
public class UserBookNode extends xa<Object> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCheckUserBook(String str, String str2) {
        Object[] a = this.b.a();
        zj a2 = zj.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onOpenUserBook(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).K();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCloseUserBook(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).L();
            }
        }
    }
}
