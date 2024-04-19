package defpackage;

import com.badlogic.gdx.utils.k;
/* compiled from: CubemapAttribute.java */
/* renamed from: lg  reason: default package */
/* loaded from: classes.dex */
public class lg extends ku {
    public static final long b = b("environmentCubemap");
    protected static long c = b;
    public final no<kc> d;

    public static final boolean b(long j) {
        return (j & c) != 0;
    }

    public lg(long j) {
        super(j);
        if (!b(j)) {
            throw new k("Invalid type specified");
        }
        this.d = new no<>();
    }

    public <T extends kc> lg(long j, no<T> noVar) {
        this(j);
        this.d.a(noVar);
    }

    public lg(lg lgVar) {
        this(lgVar.a, lgVar.d);
    }

    @Override // defpackage.ku
    public ku a() {
        return new lg(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (super.hashCode() * 967) + this.d.hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        return this.a != kuVar.a ? (int) (this.a - kuVar.a) : this.d.compareTo(((lg) kuVar).d);
    }
}
