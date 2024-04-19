package defpackage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SpeechWidget.java */
/* renamed from: abc  reason: default package */
/* loaded from: classes.dex */
public class abc {
    protected JSONObject a = new JSONObject();
    protected JSONObject b = new JSONObject();
    protected List<abc> c = new ArrayList();

    public abc() {
    }

    public abc(String str) {
        try {
            this.a.put("type", str);
            this.a.put("duiWidget", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public abc b(String str) {
        return b("extraType", str);
    }

    public abc c(String str, String str2) {
        try {
            this.a.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public abc b(String str, String str2) {
        try {
            this.b.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String toString() {
        if (this.b.length() > 0) {
            try {
                this.a.put("extra", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String optString = this.a.optString("type", "");
        if ("list".equals(optString) || "media".equals(optString)) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (abc abcVar : this.c) {
                    jSONArray.put(new JSONObject(abcVar.toString()));
                }
                this.a.put("count", jSONArray.length());
                this.a.put("content", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.a.toString();
    }
}
