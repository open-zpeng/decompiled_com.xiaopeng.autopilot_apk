package defpackage;

import java.util.Iterator;
/* compiled from: Material.java */
/* renamed from: kx  reason: default package */
/* loaded from: classes.dex */
public class kx extends kv {
    private static int e;
    public String d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public kx() {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mtl"
            r0.append(r1)
            int r1 = defpackage.kx.e
            int r1 = r1 + 1
            defpackage.kx.e = r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kx.<init>():void");
    }

    public kx(String str) {
        this.d = str;
    }

    public kx(kx kxVar) {
        this(kxVar.d, kxVar);
    }

    public kx(String str, kx kxVar) {
        this(str);
        Iterator<ku> it = kxVar.iterator();
        while (it.hasNext()) {
            a(it.next().a());
        }
    }

    public kx e() {
        return new kx(this);
    }

    @Override // defpackage.kv
    public int hashCode() {
        return super.hashCode() + (this.d.hashCode() * 3);
    }

    @Override // defpackage.kv, java.util.Comparator
    public boolean equals(Object obj) {
        return (obj instanceof kx) && (obj == this || (((kx) obj).d.equals(this.d) && super.equals(obj)));
    }
}
