package com.xiaopeng.speech.protocol.node.aiassistant;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AiAssistantNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayVideo(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayVideoTtsend(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onMessageOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onMessageClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onOpenVideo(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("video_name");
            String optString2 = jSONObject.optString("video_tag");
            String optString3 = jSONObject.optString("video_category");
            Object[] a = this.b.a();
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).a(optString, optString2, optString3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onXiaoPDance(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onXiaoPChangeClothe(String str, String str2) {
        try {
            int optInt = !TextUtils.isEmpty(str2) ? new JSONObject(str2).optInt("skin") : 0;
            Object[] a = this.b.a();
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).b(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
