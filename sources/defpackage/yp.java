package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DMWait.java */
/* renamed from: yp  reason: default package */
/* loaded from: classes.dex */
public class yp extends yq {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public int f;

    public yp() {
    }

    public yp(String str, String str2, String str3, String str4, boolean z, int i) {
        this.a = str;
        this.c = str3;
        this.b = str2;
        this.d = str4;
        this.e = z;
        this.f = i;
    }

    @Override // defpackage.yq
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", this.a);
            jSONObject.put("tips", this.c);
            jSONObject.put("sessionId", this.b);
            jSONObject.put("expression", this.d);
            jSONObject.put("speaking", this.e);
            jSONObject.put("soundArea", this.f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static yp a(String str) {
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        String str6 = "normal";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        boolean z2 = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str6 = jSONObject.optString("reason");
            str8 = jSONObject.optString("tips");
            str7 = jSONObject.optString("sessionId");
            str9 = jSONObject.optString("expression");
            z2 = jSONObject.optBoolean("speaking");
            i = jSONObject.optInt("soundArea");
            str2 = str6;
            str3 = str7;
            str4 = str8;
            str5 = str9;
            z = z2;
        } catch (JSONException e) {
            e.printStackTrace();
            i = -1;
            str2 = str6;
            str3 = str7;
            str4 = str8;
            str5 = str9;
            z = z2;
        }
        return new yp(str2, str3, str4, str5, z, i);
    }
}
