package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: WaypointSearchBean.java */
/* renamed from: aae  reason: default package */
/* loaded from: classes.dex */
public class aae {
    private String a;
    private String b;
    private boolean c;

    public static aae a(String str) {
        aae aaeVar = new aae();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aaeVar.a = jSONObject.optString("destinationName");
            aaeVar.b = jSONObject.optString("destinationType");
            int optInt = jSONObject.optInt("isSetAsDestination", 0);
            boolean z = true;
            if (optInt != 1) {
                z = false;
            }
            aaeVar.c = z;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aaeVar;
    }

    public String toString() {
        return "WaypointSearchBean{destinationName='" + this.a + "', destinationType='" + this.b + "', isSetAsDestination=" + this.c + '}';
    }
}
