package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SelectRouteBean.java */
/* renamed from: aab  reason: default package */
/* loaded from: classes.dex */
public class aab {
    private int a;

    public static aab a(String str) {
        aab aabVar = new aab();
        try {
            aabVar.a = new JSONObject(str).optInt("num");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aabVar;
    }

    public String toString() {
        return "selectRouteBean{num=" + this.a + '}';
    }
}
