package defpackage;

import com.badlogic.gdx.math.p;
/* compiled from: DirectionalLight.java */
/* renamed from: lq  reason: default package */
/* loaded from: classes.dex */
public class lq extends lp<lq> {
    public final p b = new p();

    public lq a(float f, float f2, float f3) {
        this.b.a(f, f2, f3);
        return this;
    }

    public lq a(lq lqVar) {
        return a(lqVar.a, lqVar.b);
    }

    public lq a(ka kaVar, p pVar) {
        if (kaVar != null) {
            this.a.a(kaVar);
        }
        if (pVar != null) {
            this.b.a(pVar).d();
        }
        return this;
    }

    public lq a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a.a(f, f2, f3, 1.0f);
        this.b.a(f4, f5, f6).d();
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof lq) && b((lq) obj);
    }

    public boolean b(lq lqVar) {
        return lqVar != null && (lqVar == this || (this.a.equals(lqVar.a) && this.b.equals(lqVar.b)));
    }
}
