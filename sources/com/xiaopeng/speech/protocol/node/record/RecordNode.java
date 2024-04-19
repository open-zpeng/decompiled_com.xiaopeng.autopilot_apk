package com.xiaopeng.speech.protocol.node.record;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RecordNode extends xa<a> {
    @SpeechAnnotation
    public void onAsrResult(String str, String str2) {
        Object[] a = this.b.a();
        aah a2 = aah.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    @SpeechAnnotation
    public void onRecordBegin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    @SpeechAnnotation
    public void onRecordEnd(String str, String str2) {
        boolean z;
        Object[] a = this.b.a();
        try {
            z = new JSONObject(str2).optBoolean("isStopRecord");
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(z);
            }
        }
    }

    @SpeechAnnotation
    public void onRecordError(String str, String str2) {
        Object[] a = this.b.a();
        aai a2 = aai.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    @SpeechAnnotation
    public void onSpeechBegin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    @SpeechAnnotation
    public void onSpeechEnd(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    @SpeechAnnotation
    public void onSpeechVolume(String str, String str2) {
        Object[] a = this.b.a();
        aaj a2 = aaj.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    @SpeechAnnotation
    public void onRecordMaxLength(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }
}
