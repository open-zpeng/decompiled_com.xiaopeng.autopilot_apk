package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaopeng.libtheme.ThemeManager;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SearchMusic.java */
/* renamed from: zq  reason: default package */
/* loaded from: classes.dex */
public class zq extends xr {
    public static final Parcelable.Creator<zq> CREATOR = new Parcelable.Creator<zq>() { // from class: zq.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public zq createFromParcel(Parcel parcel) {
            return new zq(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public zq[] newArray(int i) {
            return new zq[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    @Override // defpackage.xr, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public zq() {
    }

    protected zq(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.f = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
    }

    public static zq b(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static zq a(JSONObject jSONObject) {
        zq zqVar = new zq();
        try {
            zqVar.d(jSONObject.optString("album"));
            zqVar.c(jSONObject.optString("artist"));
            zqVar.a(jSONObject.optString("title"));
            zqVar.e(jSONObject.optString("module"));
            zqVar.g(jSONObject.optString("age"));
            zqVar.f(jSONObject.optString("gen"));
            zqVar.i(jSONObject.optString("mood"));
            zqVar.h(jSONObject.optString("region"));
            zqVar.j(jSONObject.optString(ThemeManager.AttributeSet.THEME));
            zqVar.k(jSONObject.optString("lan"));
            zqVar.l(jSONObject.optString("typ"));
            zqVar.m(jSONObject.optString("mode"));
            if (TextUtils.isEmpty(zqVar.c()) && TextUtils.isEmpty(zqVar.b()) && TextUtils.isEmpty(zqVar.a()) && TextUtils.isEmpty(zqVar.d()) && TextUtils.isEmpty(zqVar.f()) && TextUtils.isEmpty(zqVar.e()) && TextUtils.isEmpty(zqVar.h()) && TextUtils.isEmpty(zqVar.g()) && TextUtils.isEmpty(zqVar.i()) && TextUtils.isEmpty(zqVar.j()) && TextUtils.isEmpty(zqVar.k())) {
                throw new IllegalArgumentException("Album, artist, module, title and age are all empty string !");
            }
            return zqVar;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.a;
    }

    public void c(String str) {
        this.a = str;
    }

    @Override // defpackage.xr
    public String a() {
        return this.b;
    }

    @Override // defpackage.xr
    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void f(String str) {
        this.e = str;
    }

    public String f() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public String g() {
        return this.h;
    }

    public void h(String str) {
        this.h = str;
    }

    public String h() {
        return this.i;
    }

    public void i(String str) {
        this.i = str;
    }

    public String i() {
        return this.j;
    }

    public void j(String str) {
        this.j = str;
    }

    public String j() {
        return this.f;
    }

    public void k(String str) {
        this.f = str;
    }

    public String k() {
        return this.k;
    }

    public void l(String str) {
        this.k = str;
    }

    public void m(String str) {
        this.l = str;
    }

    public String toString() {
        return "SearchMusic{artist='" + this.a + "', title='" + this.b + "', album='" + this.c + "', module='" + this.d + "', genre='" + this.e + "', language='" + this.f + "', age='" + this.g + "', region='" + this.h + "', mood='" + this.i + "', theme='" + this.j + "', type='" + this.k + "', mode='" + this.l + "'}";
    }

    @Override // defpackage.xr, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }
}
