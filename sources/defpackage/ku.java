package defpackage;

import com.badlogic.gdx.utils.a;
/* compiled from: Attribute.java */
/* renamed from: ku  reason: default package */
/* loaded from: classes.dex */
public abstract class ku implements Comparable<ku> {
    private static final a<String> b = new a<>();
    public final long a;
    private final int c;

    public abstract ku a();

    public static final long a(String str) {
        for (int i = 0; i < b.b; i++) {
            if (b.a(i).compareTo(str) == 0) {
                return 1 << i;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r0 >= defpackage.ku.b.b) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        return defpackage.ku.b.a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(long r7) {
        /*
            r0 = -1
        L1:
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 == 0) goto L17
            int r0 = r0 + 1
            r3 = 63
            if (r0 >= r3) goto L17
            long r3 = r7 >> r0
            r5 = 1
            long r3 = r3 & r5
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L17
            goto L1
        L17:
            if (r0 < 0) goto L28
            com.badlogic.gdx.utils.a<java.lang.String> r7 = defpackage.ku.b
            int r7 = r7.b
            if (r0 >= r7) goto L28
            com.badlogic.gdx.utils.a<java.lang.String> r7 = defpackage.ku.b
            java.lang.Object r7 = r7.a(r0)
            java.lang.String r7 = (java.lang.String) r7
            goto L29
        L28:
            r7 = 0
        L29:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ku.a(long):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final long b(String str) {
        long a = a(str);
        if (a > 0) {
            return a;
        }
        b.a((a<String>) str);
        return 1 << (b.b - 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ku(long j) {
        this.a = j;
        this.c = Long.numberOfTrailingZeros(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ku kuVar) {
        return kuVar.hashCode() == hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof ku) {
            ku kuVar = (ku) obj;
            if (this.a != kuVar.a) {
                return false;
            }
            return a(kuVar);
        }
        return false;
    }

    public String toString() {
        return a(this.a);
    }

    public int hashCode() {
        return this.c * 7489;
    }
}
