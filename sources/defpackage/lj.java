package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.t;
/* compiled from: FloatAttribute.java */
/* renamed from: lj  reason: default package */
/* loaded from: classes.dex */
public class lj extends ku {
    public static final long b = b("shininess");
    public static final long c = b("alphaTest");
    public float d;

    public static lj a(float f) {
        return new lj(b, f);
    }

    public static lj b(float f) {
        return new lj(c, f);
    }

    public lj(long j, float f) {
        super(j);
        this.d = f;
    }

    @Override // defpackage.ku
    public ku a() {
        return new lj(this.a, this.d);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (super.hashCode() * 977) + t.b(this.d);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        if (this.a != kuVar.a) {
            return (int) (this.a - kuVar.a);
        }
        float f = ((lj) kuVar).d;
        if (h.a(this.d, f)) {
            return 0;
        }
        return this.d < f ? -1 : 1;
    }
}
