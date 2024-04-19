package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* compiled from: SliceData.java */
/* renamed from: xt  reason: default package */
/* loaded from: classes.dex */
public class xt implements Parcelable {
    public static final Parcelable.Creator<xt> CREATOR = new Parcelable.Creator<xt>() { // from class: xt.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xt createFromParcel(Parcel parcel) {
            return new xt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xt[] newArray(int i) {
            return new xt[i];
        }
    };
    private byte[] a;
    private int b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected xt(Parcel parcel) {
        this.a = parcel.readBlob();
        this.b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBlob(this.a);
        parcel.writeInt(this.b);
    }

    public String toString() {
        return "SliceData{data=" + Arrays.toString(this.a) + ", totalLength=" + this.b + '}';
    }
}
