package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: IpcMessage.java */
/* renamed from: vw  reason: default package */
/* loaded from: classes.dex */
public class vw implements Parcelable {
    public static final Parcelable.Creator<vw> CREATOR = new Parcelable.Creator<vw>() { // from class: vw.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public vw createFromParcel(Parcel parcel) {
            return new vw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public vw[] newArray(int i) {
            return new vw[i];
        }
    };
    String a;
    int b;
    Bundle c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public vw() {
    }

    protected vw(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeBundle(this.c);
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public Bundle c() {
        return this.c;
    }

    public void a(Bundle bundle) {
        this.c = bundle;
    }
}
