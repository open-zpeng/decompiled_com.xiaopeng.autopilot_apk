package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: BaseBean.java */
/* renamed from: xr  reason: default package */
/* loaded from: classes.dex */
public class xr implements Parcelable {
    public static final Parcelable.Creator<xr> CREATOR = new Parcelable.Creator<xr>() { // from class: xr.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xr createFromParcel(Parcel parcel) {
            return new xr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xr[] newArray(int i) {
            return new xr[i];
        }
    };
    private String a;
    private String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public xr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public xr(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
