package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RecordErrReason.java */
/* renamed from: aai  reason: default package */
/* loaded from: classes.dex */
public class aai implements Parcelable {
    public static final Parcelable.Creator<aai> CREATOR = new Parcelable.Creator<aai>() { // from class: aai.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aai createFromParcel(Parcel parcel) {
            return new aai(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aai[] newArray(int i) {
            return new aai[i];
        }
    };
    public String a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static aai a(String str) {
        aai aaiVar = new aai();
        try {
            aaiVar.a = new JSONObject(str).optString("msg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aaiVar;
    }

    public aai() {
    }

    protected aai(Parcel parcel) {
        this.a = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
    }
}
