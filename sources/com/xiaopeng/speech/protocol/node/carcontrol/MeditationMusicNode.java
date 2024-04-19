package com.xiaopeng.speech.protocol.node.carcontrol;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class MeditationMusicNode extends xa<b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPrev(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onNext(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPause(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onResume(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((b) obj).d();
            }
        }
    }
}
