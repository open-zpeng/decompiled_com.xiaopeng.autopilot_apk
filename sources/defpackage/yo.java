package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DMRecognized.java */
/* renamed from: yo  reason: default package */
/* loaded from: classes.dex */
public class yo extends yq {
    public int a = 0;

    public static final yo a(String str) {
        yo yoVar = new yo();
        try {
            yoVar.a = new JSONObject(str).optInt("errorId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return yoVar;
    }

    @Override // defpackage.yq
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorId", this.a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
