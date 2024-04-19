package defpackage;

import com.badlogic.gdx.math.p;
/* compiled from: PointLight.java */
/* renamed from: lr  reason: default package */
/* loaded from: classes.dex */
public class lr extends lp<lr> {
    public final p b = new p();
    public float c;

    public lr a(lr lrVar) {
        return a(lrVar.a, lrVar.b, lrVar.c);
    }

    public lr a(ka kaVar, p pVar, float f) {
        if (kaVar != null) {
            this.a.a(kaVar);
        }
        if (pVar != null) {
            this.b.a(pVar);
        }
        this.c = f;
        return this;
    }

    public lr a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.a.a(f, f2, f3, 1.0f);
        this.b.a(f4, f5, f6);
        this.c = f7;
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof lr) && b((lr) obj);
    }

    public boolean b(lr lrVar) {
        return lrVar != null && (lrVar == this || (this.a.equals(lrVar.a) && this.b.equals(lrVar.b) && this.c == lrVar.c));
    }
}
