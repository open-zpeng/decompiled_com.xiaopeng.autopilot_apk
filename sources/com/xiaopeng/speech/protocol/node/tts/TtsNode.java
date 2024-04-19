package com.xiaopeng.speech.protocol.node.tts;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TtsNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTtsStart(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTtsEnd(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTtsTimbreSetting(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt("timbre_type");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(i);
            }
        }
    }
}
