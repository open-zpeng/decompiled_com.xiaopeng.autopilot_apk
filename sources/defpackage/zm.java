package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DialogEndReason.java */
/* renamed from: zm  reason: default package */
/* loaded from: classes.dex */
public class zm {
    public String a;
    public String b;
    public String c;

    public zm(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static zm a(String str) {
        String str2 = "normal";
        String str3 = "";
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("reason");
            str3 = jSONObject.optString("event");
            str4 = jSONObject.optString("sessionId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new zm(str2, str3, str4);
    }
}
