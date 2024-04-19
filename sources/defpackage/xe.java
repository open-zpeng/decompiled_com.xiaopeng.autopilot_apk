package defpackage;

import android.os.Parcel;
/* compiled from: AvatarActor.java */
/* renamed from: xe  reason: default package */
/* loaded from: classes.dex */
public class xe extends xc {
    private int c;

    public xe() {
        super("AvatarActor");
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
        return "AvatarActor{state='" + this.c + "'}";
    }
}
