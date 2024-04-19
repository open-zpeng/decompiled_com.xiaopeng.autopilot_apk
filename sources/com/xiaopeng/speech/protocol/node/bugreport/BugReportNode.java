package com.xiaopeng.speech.protocol.node.bugreport;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class BugReportNode extends xa<b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBugReportBegin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBugReportEnd(String str, String str2) {
        Object[] a = this.b.a();
        a a2 = a.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBugReportVolume(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBugReportEndtts(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).b();
            }
        }
    }
}
