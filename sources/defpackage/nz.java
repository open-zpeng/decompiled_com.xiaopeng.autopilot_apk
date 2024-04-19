package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import java.io.Serializable;
/* compiled from: BoundingBox.java */
/* renamed from: nz  reason: default package */
/* loaded from: classes.dex */
public class nz implements Serializable {
    private static final p c = new p();
    private static final long serialVersionUID = -1286036817192127343L;
    public final p a = new p();
    public final p b = new p();
    private final p d = new p();
    private final p e = new p();

    static final float a(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    static final float b(float f, float f2) {
        return f > f2 ? f : f2;
    }

    public p a(p pVar) {
        return pVar.a(this.d);
    }

    public p b(p pVar) {
        return pVar.a(this.a.a, this.a.b, this.a.c);
    }

    public p c(p pVar) {
        return pVar.a(this.a.a, this.a.b, this.b.c);
    }

    public p d(p pVar) {
        return pVar.a(this.a.a, this.b.b, this.a.c);
    }

    public p e(p pVar) {
        return pVar.a(this.a.a, this.b.b, this.b.c);
    }

    public p f(p pVar) {
        return pVar.a(this.b.a, this.a.b, this.a.c);
    }

    public p g(p pVar) {
        return pVar.a(this.b.a, this.a.b, this.b.c);
    }

    public p h(p pVar) {
        return pVar.a(this.b.a, this.b.b, this.a.c);
    }

    public p i(p pVar) {
        return pVar.a(this.b.a, this.b.b, this.b.c);
    }

    public p j(p pVar) {
        return pVar.a(this.e);
    }

    public nz() {
        b();
    }

    public nz a(p pVar, p pVar2) {
        this.a.a(pVar.a < pVar2.a ? pVar.a : pVar2.a, pVar.b < pVar2.b ? pVar.b : pVar2.b, pVar.c < pVar2.c ? pVar.c : pVar2.c);
        this.b.a(pVar.a > pVar2.a ? pVar.a : pVar2.a, pVar.b > pVar2.b ? pVar.b : pVar2.b, pVar.c > pVar2.c ? pVar.c : pVar2.c);
        this.d.a(this.a).b(this.b).a(0.5f);
        this.e.a(this.b).c(this.a);
        return this;
    }

    public nz a() {
        this.a.a(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        this.b.a(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.d.a(0.0f, 0.0f, 0.0f);
        this.e.a(0.0f, 0.0f, 0.0f);
        return this;
    }

    public nz k(p pVar) {
        p pVar2 = this.a;
        p a = pVar2.a(a(pVar2.a, pVar.a), a(this.a.b, pVar.b), a(this.a.c, pVar.c));
        p pVar3 = this.b;
        return a(a, pVar3.a(Math.max(pVar3.a, pVar.a), Math.max(this.b.b, pVar.b), Math.max(this.b.c, pVar.c)));
    }

    public nz b() {
        return a(this.a.a(0.0f, 0.0f, 0.0f), this.b.a(0.0f, 0.0f, 0.0f));
    }

    public nz a(nz nzVar) {
        p pVar = this.a;
        p a = pVar.a(a(pVar.a, nzVar.a.a), a(this.a.b, nzVar.a.b), a(this.a.c, nzVar.a.c));
        p pVar2 = this.b;
        return a(a, pVar2.a(b(pVar2.a, nzVar.b.a), b(this.b.b, nzVar.b.b), b(this.b.c, nzVar.b.c)));
    }

    public nz a(Matrix4 matrix4) {
        float f = this.a.a;
        float f2 = this.a.b;
        float f3 = this.a.c;
        float f4 = this.b.a;
        float f5 = this.b.b;
        float f6 = this.b.c;
        a();
        k(c.a(f, f2, f3).a(matrix4));
        k(c.a(f, f2, f6).a(matrix4));
        k(c.a(f, f5, f3).a(matrix4));
        k(c.a(f, f5, f6).a(matrix4));
        k(c.a(f4, f2, f3).a(matrix4));
        k(c.a(f4, f2, f6).a(matrix4));
        k(c.a(f4, f5, f3).a(matrix4));
        k(c.a(f4, f5, f6).a(matrix4));
        return this;
    }

    public String toString() {
        return "[" + this.a + "|" + this.b + "]";
    }

    public nz a(float f, float f2, float f3) {
        p pVar = this.a;
        p a = pVar.a(a(pVar.a, f), a(this.a.b, f2), a(this.a.c, f3));
        p pVar2 = this.b;
        return a(a, pVar2.a(b(pVar2.a, f), b(this.b.b, f2), b(this.b.c, f3)));
    }
}
