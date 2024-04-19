package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.c;
/* compiled from: ResultReceiver.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: d  reason: default package */
/* loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: d.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    final boolean a = false;
    final Handler b = null;
    c c;

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: d$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final int a;
        final Bundle b;

        b(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.a, this.b);
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: d$a */
    /* loaded from: classes.dex */
    class a extends c.a {
        a() {
        }

        @Override // defpackage.c
        public void a(int i, Bundle bundle) {
            if (d.this.b != null) {
                d.this.b.post(new b(i, bundle));
            } else {
                d.this.a(i, bundle);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }

    d(Parcel parcel) {
        this.c = c.a.a(parcel.readStrongBinder());
    }
}
