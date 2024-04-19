package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PhoneBean.java */
/* renamed from: aag  reason: default package */
/* loaded from: classes.dex */
public class aag extends xr {
    private String a;
    private String b;
    private String c;
    private String d;

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public static aag c(String str) {
        aag aagVar = new aag();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aagVar.a = jSONObject.optString("联系人");
            if (TextUtils.isEmpty(aagVar.a)) {
                aagVar.a = jSONObject.optString("任意联系人");
            }
            aagVar.b = jSONObject.optString("号码");
            aagVar.d = jSONObject.optString("归属地");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aagVar;
    }

    public String c() {
        return this.a;
    }

    public void d(String str) {
        this.a = str;
    }

    public String d() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }
}
