package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: ChangeValue.java */
/* renamed from: zg  reason: default package */
/* loaded from: classes.dex */
public class zg {
    private int a;
    private int b;

    public static zg a(String str) {
        int parseInt;
        zg zgVar = new zg();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("number");
            String optString2 = jSONObject.optString("target");
            String optString3 = jSONObject.optString("scale");
            String optString4 = jSONObject.optString("d");
            if (!TextUtils.isEmpty(optString2)) {
                parseInt = Integer.parseInt(optString2);
            } else if (!TextUtils.isEmpty(optString3)) {
                parseInt = Integer.parseInt(optString3);
            } else {
                parseInt = !TextUtils.isEmpty(optString) ? Integer.parseInt(optString) : 1;
            }
            if (!TextUtils.isEmpty(optString4)) {
                zgVar.b = Integer.parseInt(optString4);
            }
            zgVar.a = parseInt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zgVar;
    }
}
