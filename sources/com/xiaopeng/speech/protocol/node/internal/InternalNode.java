package com.xiaopeng.speech.protocol.node.internal;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class InternalNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDmOutput(String str, String str2) {
        try {
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject("dm");
            if (optJSONObject.optString("dataFrom", "").equals("native")) {
                String optString = optJSONObject.optString("api");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                String str3 = "native://" + optString;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("command");
            if (optJSONObject2 != null) {
                String optString2 = optJSONObject2.optString("api");
                if (!TextUtils.isEmpty(optString2)) {
                    String str4 = "command://" + optString2;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onInputDmData(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onLocalWakeupResult(String str, String str2) {
        String str3 = "";
        String str4 = "";
        String str5 = "";
        try {
            JSONObject jSONObject = new JSONObject(str2);
            str3 = jSONObject.optString("type");
            str4 = jSONObject.optString("word");
            str5 = jSONObject.optString("channel");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Object[] a = this.b.a();
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                ((a) a[i]).b(str3, str4);
                ((a) a[i]).a(str3, str4, str5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onResourceUpdateFinish(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRebootComplete(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d(str, str2);
            }
        }
    }
}
