package defpackage;

import com.badlogic.gdx.utils.k;
/* compiled from: ColorAttribute.java */
/* renamed from: lf  reason: default package */
/* loaded from: classes.dex */
public class lf extends ku {
    public static final long b = b("diffuseColor");
    public static final long c = b("specularColor");
    public static final long d = b("ambientColor");
    public static final long e = b("emissiveColor");
    public static final long f = b("reflectionColor");
    public static final long g = b("ambientLightColor");
    public static final long h = b("fogColor");
    protected static long i = (((((d | b) | c) | e) | f) | g) | h;
    public final ka j;

    public static final boolean b(long j) {
        return (j & i) != 0;
    }

    public static final lf a(float f2, float f3, float f4, float f5) {
        return new lf(d, f2, f3, f4, f5);
    }

    public static final lf a(ka kaVar) {
        return new lf(b, kaVar);
    }

    public static final lf b(float f2, float f3, float f4, float f5) {
        return new lf(b, f2, f3, f4, f5);
    }

    public static final lf c(float f2, float f3, float f4, float f5) {
        return new lf(c, f2, f3, f4, f5);
    }

    public static final lf d(float f2, float f3, float f4, float f5) {
        return new lf(f, f2, f3, f4, f5);
    }

    public lf(long j) {
        super(j);
        this.j = new ka();
        if (!b(j)) {
            throw new k("Invalid type specified");
        }
    }

    public lf(long j, ka kaVar) {
        this(j);
        if (kaVar != null) {
            this.j.a(kaVar);
        }
    }

    public lf(long j, float f2, float f3, float f4, float f5) {
        this(j);
        this.j.a(f2, f3, f4, f5);
    }

    public lf(lf lfVar) {
        this(lfVar.a, lfVar.j);
    }

    @Override // defpackage.ku
    public ku a() {
        return new lf(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (super.hashCode() * 953) + this.j.c();
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        return this.a != kuVar.a ? (int) (this.a - kuVar.a) : ((lf) kuVar).j.c() - this.j.c();
    }
}
