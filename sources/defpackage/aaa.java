package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SelectParkingBean.java */
/* renamed from: aaa  reason: default package */
/* loaded from: classes.dex */
public class aaa {
    private int a;

    public static aaa a(String str) {
        aaa aaaVar = new aaa();
        try {
            aaaVar.a = new JSONObject(str).optInt("num");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aaaVar;
    }

    public String toString() {
        return "SelectParkingBean{num=" + this.a + '}';
    }
}
