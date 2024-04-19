package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.e;
import com.badlogic.gdx.math.p;
/* compiled from: Camera.java */
/* renamed from: jz  reason: default package */
/* loaded from: classes.dex */
public abstract class jz {
    public final p a = new p();
    public final p b = new p(0.0f, 0.0f, -1.0f);
    public final p c = new p(0.0f, 1.0f, 0.0f);
    public final Matrix4 d = new Matrix4();
    public final Matrix4 e = new Matrix4();
    public final Matrix4 f = new Matrix4();
    public final Matrix4 g = new Matrix4();
    public float h = 1.0f;
    public float i = 100.0f;
    public float j = 0.0f;
    public float k = 0.0f;
    public final e l = new e();
    private final p m = new p();
    private final oa n = new oa(new p(), new p());

    public abstract void a();

    public void a(float f, float f2, float f3) {
        this.m.a(f, f2, f3).c(this.a).d();
        if (this.m.e()) {
            return;
        }
        float f4 = this.m.f(this.c);
        if (Math.abs(f4 - 1.0f) < 1.0E-9f) {
            this.c.a(this.b).a(-1.0f);
        } else if (Math.abs(f4 + 1.0f) < 1.0E-9f) {
            this.c.a(this.b);
        }
        this.b.a(this.m);
        b();
    }

    public void a(p pVar) {
        a(pVar.a, pVar.b, pVar.c);
    }

    public void b() {
        this.m.a(this.b).g(this.c).d();
        this.c.a(this.m).g(this.b).d();
    }

    public void a(p pVar, float f) {
        this.b.a(pVar, f);
        this.c.a(pVar, f);
    }

    public void a(p pVar, p pVar2, float f) {
        this.m.a(pVar);
        this.m.c(this.a);
        b(this.m);
        a(pVar2, f);
        this.m.a(pVar2, f);
        b(-this.m.a, -this.m.b, -this.m.c);
    }

    public void b(float f, float f2, float f3) {
        this.a.b(f, f2, f3);
    }

    public void b(p pVar) {
        this.a.b(pVar);
    }

    public p a(p pVar, float f, float f2, float f3, float f4) {
        float f5 = pVar.a;
        float f6 = pVar.b;
        pVar.a = (((f5 - f) * 2.0f) / f3) - 1.0f;
        pVar.b = (((((io.b.getHeight() - f6) - 1.0f) - f2) * 2.0f) / f4) - 1.0f;
        pVar.c = (pVar.c * 2.0f) - 1.0f;
        pVar.b(this.g);
        return pVar;
    }

    public p c(p pVar) {
        b(pVar, 0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
        return pVar;
    }

    public p b(p pVar, float f, float f2, float f3, float f4) {
        pVar.b(this.f);
        pVar.a = ((f3 * (pVar.a + 1.0f)) / 2.0f) + f;
        pVar.b = ((f4 * (pVar.b + 1.0f)) / 2.0f) + f2;
        pVar.c = (pVar.c + 1.0f) / 2.0f;
        return pVar;
    }

    public oa a(float f, float f2, float f3, float f4, float f5, float f6) {
        a(this.n.a.a(f, f2, 0.0f), f3, f4, f5, f6);
        a(this.n.b.a(f, f2, 1.0f), f3, f4, f5, f6);
        this.n.b.c(this.n.a).d();
        return this.n;
    }

    public oa a(float f, float f2) {
        return a(f, f2, 0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
    }
}
