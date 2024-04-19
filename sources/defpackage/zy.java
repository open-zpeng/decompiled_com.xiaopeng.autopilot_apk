package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* compiled from: PoiLocation.java */
/* renamed from: zy  reason: default package */
/* loaded from: classes.dex */
public class zy implements Parcelable {
    public static final Parcelable.Creator<zy> CREATOR = new Parcelable.Creator<zy>() { // from class: zy.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public zy createFromParcel(Parcel parcel) {
            return new zy(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public zy[] newArray(int i) {
            return new zy[i];
        }
    };
    private double a;
    private double b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public zy() {
    }

    public zy(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public static zy a(String str) {
        zy zyVar = new zy();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("latitude")) {
                Double valueOf = Double.valueOf(jSONObject.optDouble("latitude"));
                if (valueOf != null) {
                    zyVar.a = valueOf.doubleValue();
                } else {
                    zyVar.a = 0.0d;
                }
            }
            if (jSONObject.has("longitude")) {
                Double valueOf2 = Double.valueOf(jSONObject.optDouble("longitude"));
                if (valueOf2 != null) {
                    zyVar.b = valueOf2.doubleValue();
                } else {
                    zyVar.b = 0.0d;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zyVar;
    }

    public zy(Parcel parcel) {
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }

    public String toString() {
        return "PoiLocation{latitude=" + this.a + ", longitude=" + this.b + '}';
    }
}
