package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: NearbySearchBean.java */
/* renamed from: zu  reason: default package */
/* loaded from: classes.dex */
public class zu {
    private String a;
    private String b;
    private String c;

    public static zu a(String str) {
        zu zuVar = new zu();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("destinationPrefix", jSONObject.optString("终点修饰"));
            boolean a = aak.a();
            xx.a("NearbySearchBean", "fromJson, isOverseasCarType: " + a);
            if (!a) {
                zuVar.a = optString + jSONObject.optString("destination", jSONObject.optString("终点目标"));
            } else {
                zuVar.b = optString;
                zuVar.a = jSONObject.optString("destination", jSONObject.optString("终点目标"));
            }
            zuVar.c = jSONObject.optString("destinationType", jSONObject.optString("终点类型"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zuVar;
    }

    public String toString() {
        return "NearbySearchBean{destination='" + this.a + "', destinationAddr='" + this.b + "', destinationType='" + this.c + "'}";
    }
}
