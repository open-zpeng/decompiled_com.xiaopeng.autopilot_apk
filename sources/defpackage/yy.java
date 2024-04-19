package defpackage;

import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import org.json.JSONObject;
/* compiled from: FeedListUIValue.java */
/* renamed from: yy  reason: default package */
/* loaded from: classes.dex */
public class yy {
    public String a;
    public int b;
    public String c = null;

    public static yy a(JSONObject jSONObject) {
        yy yyVar = new yy();
        if (jSONObject != null) {
            yyVar.a = jSONObject.optString("source");
            yyVar.b = jSONObject.optInt(Constants.INDEX);
            if (jSONObject.has("type")) {
                yyVar.c = jSONObject.optString("type");
            } else {
                yyVar.c = null;
            }
        }
        return yyVar;
    }
}
