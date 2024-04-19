package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AsrEvent.java */
/* renamed from: ym  reason: default package */
/* loaded from: classes.dex */
public class ym extends yq {
    public int a;
    public int b;

    public ym() {
        this.a = -1;
        this.b = -1;
    }

    public ym(int i, int i2) {
        this.a = -1;
        this.b = -1;
        this.a = i;
        this.b = i2;
    }

    @Override // defpackage.yq
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", this.a);
            jSONObject.put("soundArea", this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static ym a(String str) {
        int i;
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i = jSONObject.optInt("event");
            try {
                i2 = jSONObject.optInt("soundArea");
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                return new ym(i, i2);
            }
        } catch (JSONException e2) {
            e = e2;
            i = -1;
        }
        return new ym(i, i2);
    }
}
