package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DMListening.java */
/* renamed from: yn  reason: default package */
/* loaded from: classes.dex */
public class yn extends yr {
    public static final yn a(String str) {
        yn ynVar = new yn(0);
        try {
            JSONObject jSONObject = new JSONObject(str);
            ynVar.a = jSONObject.optInt("volume");
            ynVar.b = jSONObject.optInt("soundArea");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ynVar;
    }

    public yn(int i) {
        super(i, -1);
    }
}
