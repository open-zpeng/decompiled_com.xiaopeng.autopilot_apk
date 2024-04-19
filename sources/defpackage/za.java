package defpackage;

import org.json.JSONObject;
/* compiled from: VolumeValue.java */
/* renamed from: za  reason: default package */
/* loaded from: classes.dex */
public class za {
    private int a;
    private yv b;

    public static za a(String str) {
        za zaVar = new za();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("stream_type", "3");
            if (!aal.a(optString)) {
                optString = "3";
            }
            zaVar.a = Integer.valueOf(optString).intValue();
            zaVar.b = yv.a(jSONObject.optString("change_value"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zaVar;
    }

    public String toString() {
        return "VolumeValue{streamType=" + this.a + ", adjustValue=" + this.b + '}';
    }
}
