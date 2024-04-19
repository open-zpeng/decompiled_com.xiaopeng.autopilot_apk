package com.xiaopeng.speech.protocol.node.bugreport;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: BugReportEndValue.java */
/* loaded from: classes.dex */
public class a {
    private boolean a;
    private String b;

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("suc");
            String optString = jSONObject.optString("reason");
            if (!TextUtils.isEmpty(optString)) {
                aVar.b = optString;
            }
            aVar.a = optBoolean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }
}
