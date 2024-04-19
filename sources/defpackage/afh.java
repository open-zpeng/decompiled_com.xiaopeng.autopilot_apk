package defpackage;
/* compiled from: Archive.java */
/* renamed from: afh  reason: default package */
/* loaded from: classes.dex */
class afh {
    long a;
    long[] b;
    long[] c;
    afn[] d;
    afp[] e;
    afu f;

    public String toString() {
        return "Archive with packed streams starting at offset " + this.a + ", " + a(this.b) + " pack sizes, " + a(this.c) + " CRCs, " + a(this.d) + " folders, " + a(this.e) + " files and " + this.f;
    }

    private static String a(long[] jArr) {
        return jArr == null ? "(null)" : String.valueOf(jArr.length);
    }

    private static String a(Object[] objArr) {
        return objArr == null ? "(null)" : String.valueOf(objArr.length);
    }
}
