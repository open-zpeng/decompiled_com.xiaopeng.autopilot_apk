package defpackage;

import android.os.Parcel;
/* compiled from: TextActor.java */
/* renamed from: xk  reason: default package */
/* loaded from: classes.dex */
public class xk extends xc {
    private String c;
    private boolean d;
    private boolean e;

    public xk() {
        super("TextActor");
        this.d = false;
        this.e = false;
    }

    @Override // defpackage.xc, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }
}
