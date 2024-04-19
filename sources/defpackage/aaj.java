package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Volume.java */
/* renamed from: aaj  reason: default package */
/* loaded from: classes.dex */
public class aaj implements Parcelable {
    public static final Parcelable.Creator<aaj> CREATOR = new Parcelable.Creator<aaj>() { // from class: aaj.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aaj createFromParcel(Parcel parcel) {
            return new aaj(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aaj[] newArray(int i) {
            return new aaj[i];
        }
    };
    public double a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static aaj a(String str) {
        aaj aajVar = new aaj();
        try {
            aajVar.a = new JSONObject(str).optDouble("volume");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aajVar;
    }

    public aaj() {
    }

    protected aaj(Parcel parcel) {
        this.a = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
    }
}
