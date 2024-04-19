package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: CommandBean.java */
/* renamed from: zl  reason: default package */
/* loaded from: classes.dex */
public class zl extends xr {
    private String a;
    private String b;

    public static zl b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zl zlVar = new zl();
            zlVar.c(jSONObject.optString("packagename"));
            zlVar.d(jSONObject.optString("json"));
            return zlVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public String toString() {
        return "CommandBean{packagename='" + this.a + "', json='" + this.b + "'}";
    }
}
