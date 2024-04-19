package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ViaBean.java */
/* renamed from: aad  reason: default package */
/* loaded from: classes.dex */
public class aad implements Parcelable {
    protected static final Parcelable.Creator<aad> a = new Parcelable.Creator<aad>() { // from class: aad.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aad createFromParcel(Parcel parcel) {
            return new aad(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public aad[] newArray(int i) {
            return new aad[i];
        }
    };
    private zw b;
    private int c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public aad() {
    }

    public aad(Parcel parcel) {
        this.b = (zw) parcel.readParcelable(zw.class.getClassLoader());
        this.c = parcel.readInt();
    }

    public void a(zw zwVar) {
        this.b = zwVar;
    }

    public void a(int i) {
        this.c = i;
    }

    public String toString() {
        return "ViaBean{pointInfo=" + this.b + ", viaType=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c);
    }
}
