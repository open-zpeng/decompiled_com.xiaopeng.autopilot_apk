package defpackage;

import org.json.JSONObject;
/* compiled from: WindowAnimState.java */
/* renamed from: zb  reason: default package */
/* loaded from: classes.dex */
public class zb {
    private int a;
    private int b;

    public static zb a(String str) {
        zb zbVar = new zb();
        try {
            JSONObject jSONObject = new JSONObject(str);
            zbVar.a = jSONObject.optInt("from");
            zbVar.b = jSONObject.optInt("state");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zbVar;
    }
}
