package com.xiaopeng.speech.protocol.node.xpu;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XpuNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void laneChange(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("direction")) {
                String optString = jSONObject.optString("direction");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                int parseInt = Integer.parseInt(optString);
                Object[] a = this.b.a();
                if (a != null) {
                    for (Object obj : a) {
                        ((a) obj).a(parseInt);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
