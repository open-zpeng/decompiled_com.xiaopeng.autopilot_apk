package defpackage;
/* compiled from: Folder.java */
/* renamed from: afn  reason: default package */
/* loaded from: classes.dex */
class afn {
    afj[] a;
    long b;
    long c;
    afi[] d;
    long[] e;
    long[] f;
    boolean g;
    long h;
    int i;

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Folder with ");
        sb.append(this.a.length);
        sb.append(" coders, ");
        sb.append(this.b);
        sb.append(" input streams, ");
        sb.append(this.c);
        sb.append(" output streams, ");
        sb.append(this.d.length);
        sb.append(" bind pairs, ");
        sb.append(this.e.length);
        sb.append(" packed streams, ");
        sb.append(this.f.length);
        sb.append(" unpack sizes, ");
        if (this.g) {
            str = "with CRC " + this.h;
        } else {
            str = "without CRC";
        }
        sb.append(str);
        sb.append(" and ");
        sb.append(this.i);
        sb.append(" unpack streams");
        return sb.toString();
    }
}
