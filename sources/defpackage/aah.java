package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AsrResult.java */
/* renamed from: aah  reason: default package */
/* loaded from: classes.dex */
public class aah implements Parcelable {
    public static final Parcelable.Creator<aah> CREATOR = new Parcelable.Creator<aah>() { // from class: aah.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aah createFromParcel(Parcel parcel) {
            return new aah(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aah[] newArray(int i) {
            return new aah[i];
        }
    };
    public String a;
    public String b;
    public String c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static aah a(String str) {
        aah aahVar = new aah();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aahVar.a = jSONObject.optString("token");
            aahVar.c = jSONObject.optString(Constants.TEXT);
            aahVar.b = jSONObject.optString("filePath");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aahVar;
    }

    public aah() {
    }

    protected aah(Parcel parcel) {
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
    }
}
