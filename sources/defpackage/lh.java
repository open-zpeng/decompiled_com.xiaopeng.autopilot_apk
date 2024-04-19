package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.t;
/* compiled from: DepthTestAttribute.java */
/* renamed from: lh  reason: default package */
/* loaded from: classes.dex */
public class lh extends ku {
    public static final long b = b("depthStencil");
    protected static long c = b;
    public int d;
    public float e;
    public float f;
    public boolean g;

    public static final boolean b(long j) {
        return (j & c) != 0;
    }

    public lh() {
        this(515);
    }

    public lh(int i) {
        this(i, true);
    }

    public lh(int i, boolean z) {
        this(i, 0.0f, 1.0f, z);
    }

    public lh(int i, float f, float f2, boolean z) {
        this(b, i, f, f2, z);
    }

    public lh(long j, int i, float f, float f2, boolean z) {
        super(j);
        if (!b(j)) {
            throw new k("Invalid type specified");
        }
        this.d = i;
        this.e = f;
        this.f = f2;
        this.g = z;
    }

    public lh(lh lhVar) {
        this(lhVar.a, lhVar.d, lhVar.e, lhVar.f, lhVar.g);
    }

    @Override // defpackage.ku
    public ku a() {
        return new lh(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (((((((super.hashCode() * 971) + this.d) * 971) + t.b(this.e)) * 971) + t.b(this.f)) * 971) + (this.g ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        if (this.a != kuVar.a) {
            return (int) (this.a - kuVar.a);
        }
        lh lhVar = (lh) kuVar;
        int i = this.d;
        int i2 = lhVar.d;
        if (i != i2) {
            return i - i2;
        }
        boolean z = this.g;
        if (z != lhVar.g) {
            return z ? -1 : 1;
        } else if (!h.a(this.e, lhVar.e)) {
            return this.e < lhVar.e ? -1 : 1;
        } else if (h.a(this.f, lhVar.f)) {
            return 0;
        } else {
            return this.f < lhVar.f ? -1 : 1;
        }
    }
}
