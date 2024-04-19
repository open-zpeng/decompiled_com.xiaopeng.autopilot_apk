package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.math.Matrix4;
import com.xiaopeng.xui.app.XPopPanel;
/* compiled from: ShapeRenderer.java */
/* loaded from: classes.dex */
public class r implements com.badlogic.gdx.utils.g {
    private final h a;
    private boolean b;
    private final Matrix4 c;
    private final Matrix4 d;
    private final Matrix4 e;
    private final com.badlogic.gdx.math.o f;
    private final ka g;
    private a h;
    private boolean i;
    private float j;

    /* compiled from: ShapeRenderer.java */
    /* loaded from: classes.dex */
    public enum a {
        Point(0),
        Line(1),
        Filled(4);
        
        private final int a;

        a(int i) {
            this.a = i;
        }

        public int getGlType() {
            return this.a;
        }
    }

    public r() {
        this(XPopPanel.XPopPanelBuilder.LENGTH_LONG);
    }

    public r(int i) {
        this(i, null);
    }

    public r(int i, q qVar) {
        this.b = false;
        this.c = new Matrix4();
        this.d = new Matrix4();
        this.e = new Matrix4();
        this.f = new com.badlogic.gdx.math.o();
        this.g = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.j = 0.75f;
        if (qVar == null) {
            this.a = new i(i, false, true, 0);
        } else {
            this.a = new i(i, false, true, 0, qVar);
        }
        this.c.c(0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
        this.b = true;
    }

    public void a(ka kaVar) {
        this.g.a(kaVar);
    }

    public void a(Matrix4 matrix4) {
        this.c.a(matrix4);
        this.b = true;
    }

    public void b(Matrix4 matrix4) {
        this.d.a(matrix4);
        this.b = true;
    }

    public Matrix4 a() {
        return this.d;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b() {
        if (!this.i) {
            throw new IllegalStateException("autoShapeType must be true to use this method.");
        }
        a(a.Line);
    }

    public void a(a aVar) {
        if (this.h != null) {
            throw new IllegalStateException("Call end() before beginning a new shape batch.");
        }
        this.h = aVar;
        if (this.b) {
            this.e.a(this.c);
            Matrix4.mul(this.e.a, this.d.a);
            this.b = false;
        }
        this.a.a(this.e, this.h.getGlType());
    }

    public void b(a aVar) {
        a aVar2 = this.h;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 == null) {
            throw new IllegalStateException("begin must be called first.");
        }
        if (!this.i) {
            throw new IllegalStateException("autoShapeType must be enabled.");
        }
        c();
        a(aVar);
    }

    public void a(float f, float f2, float f3, float f4) {
        a(a.Line, a.Filled, 8);
        float b = this.g.b();
        if (this.h == a.Line) {
            this.a.a(b);
            this.a.a(f, f2, 0.0f);
            this.a.a(b);
            float f5 = f3 + f;
            this.a.a(f5, f2, 0.0f);
            this.a.a(b);
            this.a.a(f5, f2, 0.0f);
            this.a.a(b);
            float f6 = f4 + f2;
            this.a.a(f5, f6, 0.0f);
            this.a.a(b);
            this.a.a(f5, f6, 0.0f);
            this.a.a(b);
            this.a.a(f, f6, 0.0f);
            this.a.a(b);
            this.a.a(f, f6, 0.0f);
            this.a.a(b);
            this.a.a(f, f2, 0.0f);
            return;
        }
        this.a.a(b);
        this.a.a(f, f2, 0.0f);
        this.a.a(b);
        float f7 = f3 + f;
        this.a.a(f7, f2, 0.0f);
        this.a.a(b);
        float f8 = f4 + f2;
        this.a.a(f7, f8, 0.0f);
        this.a.a(b);
        this.a.a(f7, f8, 0.0f);
        this.a.a(b);
        this.a.a(f, f8, 0.0f);
        this.a.a(b);
        this.a.a(f, f2, 0.0f);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        ka kaVar = this.g;
        a(f, f2, f3, f4, f5, f6, f7, f8, f9, kaVar, kaVar, kaVar, kaVar);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, ka kaVar, ka kaVar2, ka kaVar3, ka kaVar4) {
        a(a.Line, a.Filled, 8);
        float d = com.badlogic.gdx.math.h.d(f9);
        float c = com.badlogic.gdx.math.h.c(f9);
        float f10 = -f3;
        float f11 = -f4;
        float f12 = f5 - f3;
        float f13 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f10 *= f7;
            f11 *= f8;
            f12 *= f7;
            f13 *= f8;
        }
        float f14 = f + f3;
        float f15 = f2 + f4;
        float f16 = c * f11;
        float f17 = ((d * f10) - f16) + f14;
        float f18 = f11 * d;
        float f19 = (f10 * c) + f18 + f15;
        float f20 = d * f12;
        float f21 = (f20 - f16) + f14;
        float f22 = f12 * c;
        float f23 = f18 + f22 + f15;
        float f24 = (f20 - (c * f13)) + f14;
        float f25 = f22 + (d * f13) + f15;
        float f26 = (f24 - f21) + f17;
        float f27 = f25 - (f23 - f19);
        if (this.h == a.Line) {
            this.a.a(kaVar.J, kaVar.K, kaVar.L, kaVar.M);
            this.a.a(f17, f19, 0.0f);
            this.a.a(kaVar2.J, kaVar2.K, kaVar2.L, kaVar2.M);
            this.a.a(f21, f23, 0.0f);
            this.a.a(kaVar2.J, kaVar2.K, kaVar2.L, kaVar2.M);
            this.a.a(f21, f23, 0.0f);
            this.a.a(kaVar3.J, kaVar3.K, kaVar3.L, kaVar3.M);
            this.a.a(f24, f25, 0.0f);
            this.a.a(kaVar3.J, kaVar3.K, kaVar3.L, kaVar3.M);
            this.a.a(f24, f25, 0.0f);
            this.a.a(kaVar4.J, kaVar4.K, kaVar4.L, kaVar4.M);
            this.a.a(f26, f27, 0.0f);
            this.a.a(kaVar4.J, kaVar4.K, kaVar4.L, kaVar4.M);
            this.a.a(f26, f27, 0.0f);
            this.a.a(kaVar.J, kaVar.K, kaVar.L, kaVar.M);
            this.a.a(f17, f19, 0.0f);
            return;
        }
        this.a.a(kaVar.J, kaVar.K, kaVar.L, kaVar.M);
        this.a.a(f17, f19, 0.0f);
        this.a.a(kaVar2.J, kaVar2.K, kaVar2.L, kaVar2.M);
        this.a.a(f21, f23, 0.0f);
        this.a.a(kaVar3.J, kaVar3.K, kaVar3.L, kaVar3.M);
        this.a.a(f24, f25, 0.0f);
        this.a.a(kaVar3.J, kaVar3.K, kaVar3.L, kaVar3.M);
        this.a.a(f24, f25, 0.0f);
        this.a.a(kaVar4.J, kaVar4.K, kaVar4.L, kaVar4.M);
        this.a.a(f26, f27, 0.0f);
        this.a.a(kaVar.J, kaVar.K, kaVar.L, kaVar.M);
        this.a.a(f17, f19, 0.0f);
    }

    private void a(a aVar, a aVar2, int i) {
        a aVar3 = this.h;
        if (aVar3 == null) {
            throw new IllegalStateException("begin must be called first.");
        }
        if (aVar3 != aVar && aVar3 != aVar2) {
            if (this.i) {
                c();
                a(aVar);
            } else if (aVar2 == null) {
                throw new IllegalStateException("Must call begin(ShapeType." + aVar + ").");
            } else {
                throw new IllegalStateException("Must call begin(ShapeType." + aVar + ") or begin(ShapeType." + aVar2 + ").");
            }
        } else if (this.b) {
            a aVar4 = this.h;
            c();
            a(aVar4);
        } else if (this.a.c() - this.a.b() < i) {
            a aVar5 = this.h;
            c();
            a(aVar5);
        }
    }

    public void c() {
        this.a.a();
        this.h = null;
    }

    public void d() {
        a aVar = this.h;
        c();
        a(aVar);
    }

    public boolean e() {
        return this.h != null;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.a.d();
    }
}
