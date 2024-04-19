package defpackage;

import android.os.Parcel;
/* compiled from: DataActor.java */
/* renamed from: xf  reason: default package */
/* loaded from: classes.dex */
public class xf extends xc {
    protected String c;
    protected String d;
    protected boolean e;

    @Override // defpackage.xc, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(a());
        parcel.writeString(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }

    public String a() {
        return this.c;
    }

    public String toString() {
        return "DataActor{mEvent='" + this.c + "', mResultData='" + this.d + "', mIsSupport=" + this.e + '}';
    }
}
