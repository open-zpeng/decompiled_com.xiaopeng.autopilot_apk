package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.t;
/* compiled from: BlendingAttribute.java */
/* renamed from: le  reason: default package */
/* loaded from: classes.dex */
public class le extends ku {
    public static final long b = b("blended");
    public boolean c;
    public int d;
    public int e;
    public float f;

    public static final boolean b(long j) {
        return (b & j) == j;
    }

    public le() {
        this(null);
    }

    public le(boolean z, int i, int i2, float f) {
        super(b);
        this.f = 1.0f;
        this.c = z;
        this.d = i;
        this.e = i2;
        this.f = f;
    }

    public le(int i, int i2, float f) {
        this(true, i, i2, f);
    }

    public le(int i, int i2) {
        this(i, i2, 1.0f);
    }

    public le(le leVar) {
        this(leVar == null || leVar.c, leVar == null ? 770 : leVar.d, leVar == null ? 771 : leVar.e, leVar == null ? 1.0f : leVar.f);
    }

    @Override // defpackage.ku
    /* renamed from: b */
    public le a() {
        return new le(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (((((((super.hashCode() * 947) + (this.c ? 1 : 0)) * 947) + this.d) * 947) + this.e) * 947) + t.b(this.f);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        if (this.a != kuVar.a) {
            return (int) (this.a - kuVar.a);
        }
        le leVar = (le) kuVar;
        boolean z = this.c;
        if (z != leVar.c) {
            return z ? 1 : -1;
        }
        int i = this.d;
        int i2 = leVar.d;
        if (i != i2) {
            return i - i2;
        }
        int i3 = this.e;
        int i4 = leVar.e;
        if (i3 != i4) {
            return i3 - i4;
        }
        if (h.a(this.f, leVar.f)) {
            return 0;
        }
        return this.f < leVar.f ? 1 : -1;
    }
}
