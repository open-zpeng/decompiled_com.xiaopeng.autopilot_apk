package defpackage;

import com.badlogic.gdx.utils.k;
/* compiled from: ReverseUVAttribute.java */
/* renamed from: acm  reason: default package */
/* loaded from: classes.dex */
public class acm extends ku {
    public static final long b = b("reverseUV");
    protected static long c = b;

    @Override // defpackage.ku
    public ku a() {
        return null;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        return 0;
    }

    public acm(long j) {
        super(j);
        if (!b(j)) {
            throw new k("Invalid type specified");
        }
    }

    public static final boolean b(long j) {
        return (j & c) != 0;
    }
}
