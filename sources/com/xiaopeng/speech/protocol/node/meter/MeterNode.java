package com.xiaopeng.speech.protocol.node.meter;

import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MeterNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void setLeftCard(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt(Constants.INDEX);
        } catch (JSONException e) {
            e.printStackTrace();
            i = -1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void setRightCard(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt(Constants.INDEX);
        } catch (JSONException e) {
            e.printStackTrace();
            i = -1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDashboardLightsStatus(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }
}
