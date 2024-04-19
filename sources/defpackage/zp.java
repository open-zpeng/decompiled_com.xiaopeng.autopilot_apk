package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: CollectHistoryMusic.java */
/* renamed from: zp  reason: default package */
/* loaded from: classes.dex */
public class zp {
    private int a;

    public static zp a(String str) {
        zp zpVar = new zp();
        try {
            zpVar.a(new JSONObject(str).optInt("type"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zpVar;
    }

    public void a(int i) {
        this.a = i;
    }
}
