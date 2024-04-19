package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: AdjustValue.java */
/* renamed from: yv  reason: default package */
/* loaded from: classes.dex */
public class yv {
    private boolean a = false;
    private int b;

    public static yv a(String str) {
        yv yvVar = new yv();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            String optString = jSONObject.optString("target");
            String optString2 = jSONObject.optString("scale");
            String optString3 = jSONObject.optString("number");
            if (!TextUtils.isEmpty(optString)) {
                i = Integer.parseInt(optString);
            } else if (!TextUtils.isEmpty(optString2)) {
                i = Integer.parseInt(optString2);
            } else if (!TextUtils.isEmpty(optString3)) {
                i = Integer.parseInt(optString3);
            }
            String optString4 = jSONObject.optString("percent");
            if (!TextUtils.isEmpty(optString4)) {
                yvVar.a = true;
                i = Integer.parseInt(optString4);
            }
            yvVar.b = i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yvVar;
    }
}
