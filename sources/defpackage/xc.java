package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Actor.java */
/* renamed from: xc  reason: default package */
/* loaded from: classes.dex */
public class xc implements Parcelable {
    protected String b;
    public static Map<String, Class<? extends xc>> a = new HashMap<String, Class<? extends xc>>() { // from class: xc.1
        {
            put("AvatarActor", xe.class);
            put("DialogActor", xg.class);
            put("ResultActor", xh.class);
            put("TextActor", xk.class);
            put("ShowActor", xi.class);
            put("SupportActor", xj.class);
            put("DataActor", xf.class);
            put("ValueActor", xl.class);
        }
    };
    public static final Parcelable.Creator<xc> CREATOR = new Parcelable.Creator<xc>() { // from class: xc.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xc createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            try {
                return xc.a.get(readString).getConstructor(String.class, Parcel.class).newInstance(readString, parcel);
            } catch (Exception e) {
                xx.a(this, "createFromParcel error:", e);
                return new xc(readString, parcel);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xc[] newArray(int i) {
            return new xc[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public xc() {
    }

    public xc(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
    }

    protected xc(String str, Parcel parcel) {
        this.b = str;
    }
}
