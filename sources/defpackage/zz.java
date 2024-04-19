package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PoiSearchBean.java */
/* renamed from: zz  reason: default package */
/* loaded from: classes.dex */
public class zz {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public static zz a(String str) {
        zz zzVar = new zz();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("destinationPrefix");
            String optString2 = jSONObject.optString("destinationTarget");
            String optString3 = jSONObject.optString("destinationName");
            boolean a = aak.a();
            xx.a("PoiSearchBean", "fromJson, isOverseasCarType: " + a);
            if (!a) {
                zzVar.a = optString;
                StringBuilder sb = new StringBuilder();
                sb.append(zzVar.a);
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = optString3;
                }
                sb.append(optString2);
                zzVar.a = sb.toString();
            } else {
                zzVar.b = optString;
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = optString3;
                }
                zzVar.a = optString2;
            }
            zzVar.c = jSONObject.optString("travelMode");
            zzVar.d = jSONObject.optString("destinationType");
            zzVar.e = jSONObject.optString("pref");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zzVar;
    }

    public String toString() {
        return "PoiSearchBean{destination='" + this.a + "', destinationAddr='" + this.b + "', travelMode='" + this.c + "', destinationType='" + this.d + "', pathPref='" + this.e + "'}";
    }
}
