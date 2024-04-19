package defpackage;

import com.badlogic.gdx.graphics.glutils.g;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.math.p;
/* compiled from: Viewport.java */
/* renamed from: qz  reason: default package */
/* loaded from: classes.dex */
public abstract class qz {
    private jz a;
    private float b;
    private float c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final p h = new p();

    public void a(boolean z) {
        g.b(this.d, this.e, this.f, this.g);
        jz jzVar = this.a;
        jzVar.j = this.b;
        jzVar.k = this.c;
        if (z) {
            jzVar.a.a(this.b / 2.0f, this.c / 2.0f, 0.0f);
        }
        this.a.a();
    }

    public void a(int i, int i2, boolean z) {
        a(z);
    }

    public o a(o oVar) {
        this.h.a(oVar.d, oVar.e, 1.0f);
        this.a.a(this.h, this.d, this.e, this.f, this.g);
        oVar.a(this.h.a, this.h.b);
        return oVar;
    }

    public void a(Matrix4 matrix4, n nVar, n nVar2) {
        qj.a(this.a, this.d, this.e, this.f, this.g, matrix4, nVar, nVar2);
    }

    public jz a() {
        return this.a;
    }

    public void a(jz jzVar) {
        this.a = jzVar;
    }

    public float b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    public void a(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }
}
