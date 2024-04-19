package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PoiBean.java */
/* renamed from: zw  reason: default package */
/* loaded from: classes.dex */
public class zw implements Parcelable {
    protected static final Parcelable.Creator<zw> a = new Parcelable.Creator<zw>() { // from class: zw.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public zw createFromParcel(Parcel parcel) {
            return new zw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public zw[] newArray(int i) {
            return new zw[i];
        }
    };
    private String b;
    private String c;
    private String d;
    private double e;
    private double f;
    private String g;
    private long h;
    private String i;
    private String j;
    private String k;
    private double l;
    private double m;
    private int n;
    private String o;
    private String p;
    private String q;
    private int r;
    private zy s;
    private zy t;
    private zx u;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public zw() {
        this.s = new zy(0.0d, 0.0d);
        this.t = new zy(0.0d, 0.0d);
    }

    public static zw a(String str) {
        try {
            zw zwVar = new zw();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("poiId")) {
                zwVar.d = jSONObject.optString("poiId");
            }
            if (jSONObject.has("name")) {
                zwVar.b = jSONObject.optString("name");
            }
            if (jSONObject.has("dst_name")) {
                zwVar.c = jSONObject.optString("dst_name");
            }
            if (jSONObject.has("latitude")) {
                zwVar.e = jSONObject.optDouble("latitude", 0.0d);
            }
            if (jSONObject.has("longitude")) {
                zwVar.f = jSONObject.optDouble("longitude", 0.0d);
            }
            if (jSONObject.has("address")) {
                zwVar.g = jSONObject.optString("address");
            }
            if (jSONObject.has("distance")) {
                zwVar.h = jSONObject.optLong("distance");
            }
            if (jSONObject.has("displayDistance")) {
                zwVar.j = jSONObject.optString("displayDistance");
            }
            if (jSONObject.has("tel")) {
                zwVar.i = jSONObject.optString("tel");
            }
            if (jSONObject.has("category")) {
                zwVar.n = jSONObject.optInt("category");
            }
            if (jSONObject.has("categoryExtra")) {
                zwVar.o = jSONObject.optString("categoryExtra");
            }
            if (jSONObject.has("naviLon")) {
                zwVar.l = jSONObject.optDouble("naviLon", 0.0d);
            }
            if (jSONObject.has("naviLat")) {
                zwVar.m = jSONObject.optDouble("naviLat", 0.0d);
            }
            if (jSONObject.has("typeCode")) {
                zwVar.p = jSONObject.optString("typeCode");
            }
            if (jSONObject.has("source")) {
                zwVar.q = jSONObject.optString("source");
            }
            if (jSONObject.has("scenario")) {
                zwVar.r = jSONObject.optInt("scenario");
            }
            if (jSONObject.has("entrLocation")) {
                zwVar.s = zy.a(jSONObject.optString("entrLocation"));
            }
            if (jSONObject.has("exitLocation")) {
                zwVar.t = zy.a(jSONObject.optString("exitLocation"));
            }
            if (jSONObject.has("poiExtra")) {
                zwVar.u = zx.a(jSONObject.optString("poiExtra"));
            }
            return zwVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public zw(Parcel parcel) {
        this.s = new zy(0.0d, 0.0d);
        this.t = new zy(0.0d, 0.0d);
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readDouble();
        this.f = parcel.readDouble();
        this.g = parcel.readString();
        this.h = parcel.readLong();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readString();
        this.l = parcel.readDouble();
        this.m = parcel.readDouble();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = (zy) parcel.readParcelable(zy.class.getClassLoader());
        this.t = (zy) parcel.readParcelable(zy.class.getClassLoader());
        this.u = (zx) parcel.readParcelable(zx.class.getClassLoader());
    }

    public String toString() {
        return "PoiBean{name='" + this.b + "', dst_name='" + this.c + "', poiId='" + this.d + "', latitude=" + this.e + ", longitude=" + this.f + ", address='" + this.g + "', distance=" + this.h + ", categoryExtra='" + this.o + "', telephone='" + this.i + "', displayDistance='" + this.j + "', cityName='" + this.k + "', naviLon=" + this.l + ", naviLat=" + this.m + ", category=" + this.n + ", typeCode='" + this.p + "', source='" + this.q + "', scenario='" + this.r + "', entrLocation=" + this.s + ", exitLocation=" + this.t + ", poiExtra=" + this.u + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeDouble(this.e);
        parcel.writeDouble(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.n);
        parcel.writeString(this.o);
        parcel.writeDouble(this.l);
        parcel.writeDouble(this.m);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeParcelable(this.s, 0);
        parcel.writeParcelable(this.t, 0);
    }
}
