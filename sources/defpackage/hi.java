package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AbsSavedState.java */
/* renamed from: hi  reason: default package */
/* loaded from: classes.dex */
public abstract class hi implements Parcelable {
    private final Parcelable a;
    public static final hi c = new hi() { // from class: hi.1
    };
    public static final Parcelable.Creator<hi> CREATOR = new Parcelable.ClassLoaderCreator<hi>() { // from class: hi.2
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a */
        public hi createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return hi.c;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public hi createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public hi[] newArray(int i) {
            return new hi[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private hi() {
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public hi(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.a = parcelable == c ? null : parcelable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public hi(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.a = readParcelable == null ? c : readParcelable;
    }

    public final Parcelable a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }
}
