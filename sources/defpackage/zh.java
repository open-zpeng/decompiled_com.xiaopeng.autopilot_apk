package defpackage;

import org.json.JSONObject;
/* compiled from: ControlReason.java */
/* renamed from: zh  reason: default package */
/* loaded from: classes.dex */
public class zh {
    private int a;

    public static zh a(String str) {
        zh zhVar = new zh();
        zhVar.a(0);
        try {
            zhVar.a(new JSONObject(str).optInt("reason"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zhVar;
    }

    public void a(int i) {
        this.a = i;
    }
}
