package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PathBean.java */
/* renamed from: zv  reason: default package */
/* loaded from: classes.dex */
public class zv {
    private zw a;
    private zw b;
    private ArrayList<aad> c;
    private int d;
    private int e;
    private int f;
    private int g;
    private String h;
    private int i;
    private int j;

    public static zv a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("pathBean");
            if (optJSONObject != null) {
                zv zvVar = new zv();
                zvVar.a = zw.a(optJSONObject.optString("startPoint"));
                zvVar.b = zw.a(optJSONObject.optString("destPoint"));
                zvVar.d = optJSONObject.optInt("strategy");
                zvVar.e = optJSONObject.optInt("distance");
                zvVar.f = optJSONObject.optInt("time");
                zvVar.g = optJSONObject.optInt("toll");
                zvVar.h = optJSONObject.optString("rawAmapJson");
                zvVar.i = optJSONObject.optInt("naviType");
                zvVar.j = optJSONObject.optInt("routeSelectRef");
                JSONArray optJSONArray = optJSONObject.optJSONArray("viaPoints");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    zvVar.c = new ArrayList<>(optJSONArray.length());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        aad aadVar = new aad();
                        aadVar.a(zw.a(jSONObject.optString("pointInfo")));
                        aadVar.a(jSONObject.optInt("viaType"));
                        zvVar.c.add(aadVar);
                    }
                }
                return zvVar;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toString() {
        return "PathBean{destPoint=" + this.b + ", viaPoints=" + this.c + ", strategy=" + this.d + ", distance=" + this.e + ", time=" + this.f + ", toll=" + this.g + ", naviType=" + this.i + ", routeSelectRef=" + this.j + ", rawAmapJson='" + this.h + "'}";
    }
}
