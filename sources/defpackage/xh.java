package defpackage;

import android.os.Parcel;
/* compiled from: ResultActor.java */
/* renamed from: xh  reason: default package */
/* loaded from: classes.dex */
public class xh extends xc {
    protected String c;
    protected String d;

    public xh(String str) {
        super("ResultActor");
        this.c = "";
        this.c = str;
    }

    @Override // defpackage.xc, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(a());
        parcel.writeString(this.d);
    }

    public String a() {
        return this.c;
    }

    public xh a(abc abcVar) {
        return a(abcVar.toString());
    }

    public xh a(String str) {
        this.d = str;
        return this;
    }
}
