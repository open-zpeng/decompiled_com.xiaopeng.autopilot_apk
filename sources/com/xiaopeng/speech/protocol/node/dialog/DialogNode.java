package com.xiaopeng.speech.protocol.node.dialog;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class DialogNode extends xa<b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDialogStart(String str, String str2) {
        Object[] a = this.b.a();
        zn a2 = zn.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDialogError(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDialogEnd(String str, String str2) {
        Object[] a = this.b.a();
        zm a2 = zm.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDialogWait(String str, String str2) {
        Object[] a = this.b.a();
        yp ypVar = new yp();
        if (!TextUtils.isEmpty(str2)) {
            ypVar = yp.a(str2);
        }
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(ypVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDialogContinue(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWakeupResult(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVadBegin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVadEnd(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDialogStatusChanged(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(str2);
            }
        }
    }
}
