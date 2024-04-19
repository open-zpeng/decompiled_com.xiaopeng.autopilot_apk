package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ParkingPositionBean.java */
/* renamed from: zf  reason: default package */
/* loaded from: classes.dex */
public class zf {
    private int a;

    public static final zf a(String str) {
        zf zfVar = new zf();
        try {
            zfVar.a = new JSONObject(str).optInt("position");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zfVar;
    }

    public int a() {
        return this.a;
    }

    public String toString() {
        return "ParkingPositionBean{position=" + this.a + '}';
    }
}
