package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: SeatValue.java */
/* renamed from: zi  reason: default package */
/* loaded from: classes.dex */
public class zi {
    private int a;
    private int b;
    private int c;

    public static zi a(String str) {
        zi ziVar = new zi();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("xtarget");
            String optString2 = jSONObject.optString("vtarget");
            String optString3 = jSONObject.optString("htarget");
            int parseInt = !TextUtils.isEmpty(optString) ? Integer.parseInt(optString) : -1;
            int parseInt2 = !TextUtils.isEmpty(optString2) ? Integer.parseInt(optString2) : -1;
            int parseInt3 = TextUtils.isEmpty(optString3) ? -1 : Integer.parseInt(optString3);
            ziVar.a = parseInt;
            ziVar.b = parseInt2;
            ziVar.c = parseInt3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ziVar;
    }

    public String toString() {
        return "SeatValue{xValue=" + this.a + ", yValue=" + this.b + ", zValue=" + this.c + '}';
    }
}
