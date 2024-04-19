package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.t;
/* compiled from: TextureAttribute.java */
/* renamed from: ln  reason: default package */
/* loaded from: classes.dex */
public class ln extends ku {
    public static final long b = b("diffuseTexture");
    public static final long c = b("specularTexture");
    public static final long d = b("bumpTexture");
    public static final long e = b("normalTexture");
    public static final long f = b("ambientTexture");
    public static final long g = b("emissiveTexture");
    public static final long h = b("reflectionTexture");
    protected static long i = (((((b | c) | d) | e) | f) | g) | h;
    public final no<ko> j;
    public float k;
    public float l;
    public float m;
    public float n;
    public int o;

    public static final boolean b(long j) {
        return (j & i) != 0;
    }

    public static ln a(ko koVar) {
        return new ln(b, koVar);
    }

    public ln(long j) {
        super(j);
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 1.0f;
        this.n = 1.0f;
        this.o = 0;
        if (!b(j)) {
            throw new k("Invalid type specified");
        }
        this.j = new no<>();
    }

    public <T extends ko> ln(long j, no<T> noVar) {
        this(j);
        this.j.a(noVar);
    }

    public <T extends ko> ln(long j, no<T> noVar, float f2, float f3, float f4, float f5, int i2) {
        this(j, noVar);
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.n = f5;
        this.o = i2;
    }

    public <T extends ko> ln(long j, no<T> noVar, float f2, float f3, float f4, float f5) {
        this(j, noVar, f2, f3, f4, f5, 0);
    }

    public ln(long j, ko koVar) {
        this(j);
        this.j.a = koVar;
    }

    public ln(ln lnVar) {
        this(lnVar.a, lnVar.j, lnVar.k, lnVar.l, lnVar.m, lnVar.n, lnVar.o);
    }

    @Override // defpackage.ku
    public ku a() {
        return new ln(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (((((((((((super.hashCode() * 991) + this.j.hashCode()) * 991) + t.b(this.k)) * 991) + t.b(this.l)) * 991) + t.b(this.m)) * 991) + t.b(this.n)) * 991) + this.o;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        if (this.a != kuVar.a) {
            return this.a < kuVar.a ? -1 : 1;
        }
        ln lnVar = (ln) kuVar;
        int compareTo = this.j.compareTo(lnVar.j);
        if (compareTo != 0) {
            return compareTo;
        }
        int i2 = this.o;
        int i3 = lnVar.o;
        if (i2 != i3) {
            return i2 - i3;
        }
        if (!h.a(this.m, lnVar.m)) {
            return this.m > lnVar.m ? 1 : -1;
        } else if (!h.a(this.n, lnVar.n)) {
            return this.n > lnVar.n ? 1 : -1;
        } else if (!h.a(this.k, lnVar.k)) {
            return this.k > lnVar.k ? 1 : -1;
        } else if (h.a(this.l, lnVar.l)) {
            return 0;
        } else {
            return this.l > lnVar.l ? 1 : -1;
        }
    }
}
