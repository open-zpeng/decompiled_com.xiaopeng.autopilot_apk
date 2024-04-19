package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.p;
/* compiled from: SpotLight.java */
/* renamed from: lt  reason: default package */
/* loaded from: classes.dex */
public class lt extends lp<lt> {
    public final p b = new p();
    public final p c = new p();
    public float d;
    public float e;
    public float f;

    public lt a(float f, float f2, float f3) {
        this.b.a(f, f2, f3);
        return this;
    }

    public lt b(float f, float f2, float f3) {
        this.c.a(f, f2, f3);
        return this;
    }

    public lt a(float f) {
        this.d = f;
        return this;
    }

    public lt b(float f) {
        this.e = f;
        return this;
    }

    public lt c(float f) {
        this.f = f;
        return this;
    }

    public lt a(lt ltVar) {
        return a(ltVar.a, ltVar.b, ltVar.c, ltVar.d, ltVar.e, ltVar.f);
    }

    public lt a(ka kaVar, p pVar, p pVar2, float f, float f2, float f3) {
        if (kaVar != null) {
            this.a.a(kaVar);
        }
        if (pVar != null) {
            this.b.a(pVar);
        }
        if (pVar2 != null) {
            this.c.a(pVar2).d();
        }
        this.d = f;
        this.e = f2;
        this.f = f3;
        return this;
    }

    public lt a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.a.a(f, f2, f3, 1.0f);
        this.b.a(f4, f5, f6);
        this.c.a(f7, f8, f9).d();
        this.d = f10;
        this.e = f11;
        this.f = f12;
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof lt) && b((lt) obj);
    }

    public boolean b(lt ltVar) {
        return ltVar != null && (ltVar == this || (this.a.equals(ltVar.a) && this.b.equals(ltVar.b) && this.c.equals(ltVar.c) && h.a(this.d, ltVar.d) && h.a(this.e, ltVar.e) && h.a(this.f, ltVar.f)));
    }
}
