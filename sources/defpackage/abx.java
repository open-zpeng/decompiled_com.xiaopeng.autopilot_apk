package defpackage;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import java.util.List;
/* compiled from: VuiElement.java */
/* renamed from: abx  reason: default package */
/* loaded from: classes.dex */
public class abx implements Cloneable {
    public String a = null;
    public String b = null;
    public String c = "";
    public String d = null;
    public Object e = null;
    private JsonObject j = null;
    public String f = null;
    public JsonObject g = null;
    private Boolean k = null;
    private String l = null;
    private String m = null;
    public List<String> h = null;
    public abw i = null;
    private int n = -1;
    private Boolean o = null;
    private Boolean p = null;
    private String q = null;
    private long r = -1;
    private int s = -1;
    private List<abx> t = null;

    public String a() {
        return this.m;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.s;
    }

    public int d() {
        return this.n;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.b;
    }

    public List<abx> i() {
        return this.t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VuiElement{id='");
        sb.append(this.a);
        sb.append('\'');
        sb.append(", fatherElementId='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", label='");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", fatherLabel='");
        sb.append(this.d);
        sb.append('\'');
        sb.append(", values=");
        sb.append(this.e);
        sb.append(", props=");
        sb.append(this.j);
        sb.append(", type='");
        sb.append(this.f);
        sb.append('\'');
        sb.append(", actions=");
        sb.append(this.g);
        sb.append(", layoutLoadable=");
        sb.append(this.k);
        sb.append(", resourceName='");
        sb.append(this.l);
        sb.append('\'');
        sb.append(", mode='");
        sb.append(this.m);
        sb.append('\'');
        sb.append(", resultActions=");
        sb.append(this.h);
        sb.append(", animation=");
        abw abwVar = this.i;
        sb.append(abwVar == null ? "" : abwVar.toString());
        sb.append(", position=");
        sb.append(this.n);
        sb.append(", visible=");
        sb.append(this.o);
        sb.append(", enabled=");
        sb.append(this.p);
        sb.append(", feedbackType='");
        sb.append(this.q);
        sb.append('\'');
        sb.append(", timestamp=");
        sb.append(this.r);
        sb.append(", priority=");
        sb.append(this.s);
        sb.append(", elements=");
        sb.append(this.t);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof abx) {
            abx abxVar = (abx) obj;
            if (a(this.f, abxVar.g()) && a(this.c, abxVar.e()) && a(this.b, abxVar.h()) && a(this.d, abxVar.f()) && a(this.m, abxVar.a()) && a(this.l, abxVar.b()) && this.n == abxVar.d() && this.s == abxVar.c() && a(this.k, abxVar.k) && a(this.o, abxVar.o) && a(this.g, abxVar.g) && a(this.j, abxVar.j) && a(this.e, abxVar.e)) {
                if (this.t == null && abxVar.i() == null) {
                    return true;
                }
                if (this.t == null || abxVar.i() == null || this.t.size() != abxVar.i().size()) {
                    return false;
                }
                for (int i = 0; i < this.t.size(); i++) {
                    if (!this.t.get(i).equals(abxVar.t.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }

    private boolean a(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        return (bool == null || bool2 == null || bool.booleanValue() != bool2.booleanValue()) ? false : true;
    }

    private boolean a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        return (obj == null || obj2 == null || !obj.equals(obj2)) ? false : true;
    }

    /* renamed from: j */
    public abx clone() {
        try {
            return (abx) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
