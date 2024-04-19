package defpackage;

import android.os.Parcel;
/* compiled from: ValueActor.java */
/* renamed from: xl  reason: default package */
/* loaded from: classes.dex */
public class xl extends xc {
    protected String c;
    protected xu d;

    @Override // defpackage.xc, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, 0);
    }
}
