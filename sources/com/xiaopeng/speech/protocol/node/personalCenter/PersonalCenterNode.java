package com.xiaopeng.speech.protocol.node.personalCenter;

import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonalCenterNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onControlProfileHabitSelect(String str, String str2) {
        int i;
        xx.b("PersonalCenterNode", "data = " + str2 + " , event = " + str);
        try {
            i = new JSONObject(str2).optInt(Constants.INDEX);
        } catch (Throwable unused) {
            xx.c("CaracNode", "onControlProfileHabitSelect string data error, data = " + str2);
            i = 0;
        }
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onControlProfileHabitSelectNext(String str, String str2) {
        xx.b("PersonalCenterNode", "data = " + str2 + " , event = " + str);
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }
}
