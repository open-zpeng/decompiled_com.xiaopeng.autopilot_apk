package com.xiaopeng.speech.protocol.node.scene;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SceneNode extends xa<a> {
    List<String> d;

    @SpeechAnnotation
    public void onSceneEvent(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String optString = new JSONObject(str2).optString("sceneId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            String str3 = null;
            if (optString.contains("-")) {
                str3 = optString.split("-")[0];
            } else if (optString.contains("_")) {
                str3 = optString.split("_")[0];
            }
            if (!TextUtils.isEmpty(str3) && this.d.contains(str3)) {
                b(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    @SpeechAnnotation
    public void onDMStart(String str, String str2) {
        b("jarvis.dm.start", str2);
    }

    @SpeechAnnotation
    public void onDMEnd(String str, String str2) {
        b("jarvis.dm.end", str2);
    }

    @SpeechAnnotation
    public void onVuiEnable(String str, String str2) {
        b("enable.vui.feature", str2);
    }

    @SpeechAnnotation
    public void onVuiDisable(String str, String str2) {
        b("disable.vui.feature", str2);
    }

    @SpeechAnnotation
    public void onRebuild(String str, String str2) {
        b(str, str2);
    }

    private void b(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).a(str, str2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
