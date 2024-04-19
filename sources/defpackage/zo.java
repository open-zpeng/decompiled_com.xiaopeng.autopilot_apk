package defpackage;

import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IndexBean.java */
/* renamed from: zo  reason: default package */
/* loaded from: classes.dex */
public class zo extends xr {
    private int a;

    public static final zo b(String str) {
        zo zoVar = new zo();
        try {
            zoVar.a = new JSONObject(str).optInt(Constants.INDEX);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zoVar;
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return "IndexBean{index='" + this.a + "'}";
    }
}
