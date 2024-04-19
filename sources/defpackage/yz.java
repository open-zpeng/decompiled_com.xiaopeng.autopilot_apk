package defpackage;

import org.json.JSONObject;
/* compiled from: SpeechParam.java */
/* renamed from: yz  reason: default package */
/* loaded from: classes.dex */
public class yz {
    private boolean a;
    private boolean b;

    public static yz a(String str) {
        yz yzVar = new yz();
        try {
            JSONObject jSONObject = new JSONObject(str);
            yzVar.a = jSONObject.optBoolean("app_tts", true);
            yzVar.b = jSONObject.optBoolean("animation");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yzVar;
    }
}
