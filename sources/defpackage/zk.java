package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ChangbaBean.java */
/* renamed from: zk  reason: default package */
/* loaded from: classes.dex */
public class zk extends xr {
    private String a;
    private String b;

    public static zk b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zk zkVar = new zk();
            zkVar.c(jSONObject.optString("artist"));
            zkVar.d(jSONObject.optString("song"));
            return zkVar;
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
        return "ChangbaBean{artist='" + this.a + "', song='" + this.b + "'}";
    }
}
