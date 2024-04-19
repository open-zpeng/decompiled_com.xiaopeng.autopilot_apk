package defpackage;

import android.content.LocusId;
/* compiled from: LocusIdCompat.java */
/* renamed from: eb  reason: default package */
/* loaded from: classes.dex */
public final class eb {
    private final String a;
    private final LocusId b;

    public int hashCode() {
        String str = this.a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            eb ebVar = (eb) obj;
            String str = this.a;
            if (str == null) {
                return ebVar.a == null;
            }
            return str.equals(ebVar.a);
        }
        return false;
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }

    public LocusId a() {
        return this.b;
    }

    private String b() {
        int length = this.a.length();
        return length + "_chars";
    }
}
