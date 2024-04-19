package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: UserBookValue.java */
/* renamed from: zj  reason: default package */
/* loaded from: classes.dex */
public class zj {
    private String a;

    public static zj a(String str) {
        zj zjVar = new zj();
        try {
            String optString = new JSONObject(str).optString("keyword");
            if (!TextUtils.isEmpty(optString)) {
                zjVar.a = optString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zjVar;
    }
}
