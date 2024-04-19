package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: ChangeValue.java */
/* renamed from: yx  reason: default package */
/* loaded from: classes.dex */
public class yx {
    private boolean a = false;
    private boolean b = false;
    private int c;

    public static yx a(String str) {
        yx yxVar = new yx();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("target");
            String optString2 = jSONObject.optString("scale");
            int i = 0;
            if (!TextUtils.isEmpty(optString)) {
                yxVar.b = false;
                i = Integer.parseInt(optString);
            } else if (!TextUtils.isEmpty(optString2)) {
                yxVar.b = true;
                i = Integer.parseInt(optString2);
            }
            String optString3 = jSONObject.optString("percent");
            if (!TextUtils.isEmpty(optString3)) {
                yxVar.a = true;
                i = Integer.parseInt(optString3);
            }
            yxVar.c = i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yxVar;
    }
}
