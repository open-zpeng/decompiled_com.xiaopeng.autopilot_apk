package defpackage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: PoiExtraBean.java */
/* renamed from: zx  reason: default package */
/* loaded from: classes.dex */
public class zx {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private String g;
    private String h;
    private List<zs> i;

    public void a(List<zs> list) {
        this.i = list;
    }

    public static zx a(String str) {
        zx zxVar = new zx();
        boolean a = aak.a();
        xx.a("PoiExtraBean", "fromJson, isOverseasCarType: " + a);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("dcNums")) {
                zxVar.a = jSONObject.optInt("dcNums");
            }
            if (jSONObject.has("dcFreeNums")) {
                zxVar.b = jSONObject.optInt("dcFreeNums");
            }
            if (jSONObject.has("acNums")) {
                zxVar.c = jSONObject.optInt("acNums");
            }
            if (jSONObject.has("acFreeNums")) {
                if (!a) {
                    zxVar.d = jSONObject.optInt("acFreeNums");
                } else {
                    zxVar.a = jSONObject.optInt("acFreeNums");
                }
            }
            if (jSONObject.has("selfSupportFlag")) {
                zxVar.e = jSONObject.optInt("selfSupportFlag");
            }
            if (a) {
                if (jSONObject.has("busiState")) {
                    zxVar.f = jSONObject.optBoolean("busiState");
                }
                if (jSONObject.has("busiTime")) {
                    zxVar.g = jSONObject.optString("busiTime");
                }
                if (jSONObject.has("payment")) {
                    zxVar.h = jSONObject.optString("payment");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        zs a2 = a(optJSONArray.getJSONObject(i));
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                    zxVar.a(arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zxVar;
    }

    private static zs a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        zs zsVar = new zs();
        zsVar.a(jSONObject.optInt("total"));
        zsVar.b(jSONObject.optInt("available"));
        zsVar.a(jSONObject.optString("power"));
        return zsVar;
    }

    public String toString() {
        return "PoiExtraBean{dcNums='" + this.a + "', dcFreeNums='" + this.b + "', acNums='" + this.c + "', acFreeNums=" + this.d + ", selfSupportFlag=" + this.e + ", busiState='" + this.f + "', busiTime=" + this.g + ", payment='" + this.h + "', content='" + this.i + '}';
    }
}
