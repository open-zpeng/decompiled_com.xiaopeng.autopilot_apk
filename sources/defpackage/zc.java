package defpackage;

import org.json.JSONObject;
/* compiled from: CommandValue.java */
/* renamed from: zc  reason: default package */
/* loaded from: classes.dex */
public class zc {
    private int a;
    private int b;
    private int c;

    public zc(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("color")) {
                this.c = Integer.valueOf(jSONObject.getString("color")).intValue();
            }
            if (jSONObject.has("number")) {
                this.b = jSONObject.getInt("number");
            }
            if (jSONObject.has("percent")) {
                this.a = jSONObject.getInt("percent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
