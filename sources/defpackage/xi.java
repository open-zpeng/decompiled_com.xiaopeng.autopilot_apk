package defpackage;

import android.os.Parcel;
/* compiled from: ShowActor.java */
/* renamed from: xi  reason: default package */
/* loaded from: classes.dex */
public class xi extends xc {
    private String c;

    public xi() {
        super("ShowActor");
    }

    @Override // defpackage.xc, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
    }
}
