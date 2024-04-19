package defpackage;

import com.xiaopeng.lib.utils.config.CommonConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: WakeupStatus.java */
/* renamed from: ys  reason: default package */
/* loaded from: classes.dex */
public class ys extends yq {
    public int a;
    public int b;
    public String c;

    public ys(int i, int i2, String str) {
        this.a = -1;
        this.b = -1;
        this.c = null;
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // defpackage.yq
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonConfig.KEY_VALUE_STATUS, this.a);
            jSONObject.put("type", this.b);
            jSONObject.put("info", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static ys a(String str) {
        int i;
        String str2;
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i = jSONObject.optInt(CommonConfig.KEY_VALUE_STATUS);
            try {
                i2 = jSONObject.optInt("type");
                str2 = jSONObject.optString("info");
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                str2 = null;
                return new ys(i, i2, str2);
            }
        } catch (JSONException e2) {
            e = e2;
            i = -1;
        }
        return new ys(i, i2, str2);
    }
}
