package defpackage;

import android.os.Parcel;
/* compiled from: DialogActor.java */
/* renamed from: xg  reason: default package */
/* loaded from: classes.dex */
public class xg extends xc {
    private int c;

    public xg() {
        super("DialogActor");
    }

    @Override // defpackage.xc, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(a());
    }

    public int a() {
        return this.c;
    }

    public String toString() {
        return "DialogActor{state='" + this.c + "'}";
    }
}
