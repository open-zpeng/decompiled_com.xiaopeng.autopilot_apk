package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Value.java */
/* renamed from: xu  reason: default package */
/* loaded from: classes.dex */
public class xu implements Parcelable {
    private Integer c;
    private Double d;
    private String e;
    private Boolean f;
    private int[] g;
    private float[] h;
    private int i;
    public static final xu a = new xu();
    public static final xu b = new xu();
    public static final Parcelable.Creator<xu> CREATOR = new Parcelable.Creator<xu>() { // from class: xu.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xu createFromParcel(Parcel parcel) {
            return new xu(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public xu[] newArray(int i) {
            return new xu[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public xu() {
    }

    public xu(Object obj) {
        a(obj);
    }

    private void a(Object obj) {
        if (obj instanceof Double) {
            this.i = 2;
            this.d = (Double) obj;
        } else if (obj instanceof String) {
            this.i = 4;
            this.e = (String) obj;
        } else if (obj instanceof Boolean) {
            this.i = 5;
            this.f = (Boolean) obj;
        } else if (obj instanceof int[]) {
            this.i = 6;
            this.g = (int[]) obj;
        } else if (obj instanceof float[]) {
            this.i = 7;
            this.h = (float[]) obj;
        } else if (obj instanceof Integer) {
            this.i = 1;
            this.c = (Integer) obj;
        } else if (obj instanceof Float) {
            this.i = 2;
            this.d = Double.valueOf(((Float) obj).doubleValue());
        } else {
            this.i = 0;
        }
    }

    protected xu(Parcel parcel) {
        this.i = parcel.readInt();
        int i = this.i;
        if (i == 2) {
            this.d = Double.valueOf(parcel.readDouble());
        } else if (i == 4) {
            this.e = parcel.readString();
        } else {
            if (i == 5) {
                this.f = Boolean.valueOf(parcel.readInt() == 1);
            } else if (i == 6) {
                this.g = parcel.createIntArray();
            } else if (i == 7) {
                this.h = parcel.createFloatArray();
            } else if (i == 1) {
                this.c = Integer.valueOf(parcel.readInt());
            }
        }
    }

    public boolean a() {
        return this.f.booleanValue();
    }

    public Integer b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.i);
        int i2 = this.i;
        if (i2 == 2) {
            parcel.writeDouble(this.d.doubleValue());
        } else if (i2 == 4) {
            parcel.writeString(this.e);
        } else if (i2 == 5) {
            parcel.writeInt(this.f.booleanValue() ? 1 : 0);
        } else if (i2 == 6) {
            parcel.writeIntArray(this.g);
        } else if (i2 == 7) {
            parcel.writeFloatArray(this.h);
        } else if (i2 == 1) {
            parcel.writeInt(this.c.intValue());
        }
    }

    public String toString() {
        return "Value{mInteger=" + this.c + ", mDouble=" + this.d + ", mString='" + this.e + "', mBoolean=" + this.f + ", classType=" + this.i + '}';
    }
}
