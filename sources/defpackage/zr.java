package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AddressBean.java */
/* renamed from: zr  reason: default package */
/* loaded from: classes.dex */
public class zr {
    private String a;
    private String b;

    public static final zr a(String str) {
        zr zrVar = new zr();
        try {
            JSONObject jSONObject = new JSONObject(str);
            zrVar.a = jSONObject.optString("addressType");
            zrVar.b = jSONObject.optString("from");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zrVar;
    }

    public void b(String str) {
        this.a = str;
    }

    public String toString() {
        return "AddressBean{addressType='" + this.a + "', from='" + this.b + "'}";
    }
}
