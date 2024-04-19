package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Volume.java */
/* renamed from: yr  reason: default package */
/* loaded from: classes.dex */
public abstract class yr extends yq {
    public int a;
    public int b;

    public yr(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // defpackage.yq
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("volume", this.a);
            jSONObject.put("soundArea", this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
