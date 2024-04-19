package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* compiled from: VertexBufferObjectWithVAO.java */
/* loaded from: classes.dex */
public class v implements w {
    static final IntBuffer a = BufferUtils.c(1);
    final kt b;
    final FloatBuffer c;
    final ByteBuffer d;
    int e;
    final boolean f;
    final int g;
    boolean h = false;
    boolean i = false;
    int j = -1;
    com.badlogic.gdx.utils.m k = new com.badlogic.gdx.utils.m();

    public v(boolean z, int i, kt ktVar) {
        this.f = z;
        this.b = ktVar;
        this.d = BufferUtils.d(this.b.a * i);
        this.c = this.d.asFloatBuffer();
        this.c.flip();
        this.d.flip();
        this.e = io.h.glGenBuffer();
        this.g = z ? 35044 : 35048;
        g();
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public kt d() {
        return this.b;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public int b() {
        return (this.c.limit() * 4) / this.b.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public int c() {
        return this.d.capacity() / this.b.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public FloatBuffer a() {
        this.h = true;
        return this.c;
    }

    private void f() {
        if (this.i) {
            io.h.glBufferData(34962, this.d.limit(), this.d, this.g);
            this.h = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(float[] fArr, int i, int i2) {
        this.h = true;
        BufferUtils.a(fArr, this.d, i2, i);
        this.c.position(0);
        this.c.limit(i2);
        f();
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(q qVar, int[] iArr) {
        kh khVar = io.i;
        khVar.glBindVertexArray(this.j);
        c(qVar, iArr);
        a(khVar);
        this.i = true;
    }

    private void c(q qVar, int[] iArr) {
        boolean z = this.k.b != 0;
        int a2 = this.b.a();
        if (z) {
            if (iArr == null) {
                for (int i = 0; z && i < a2; i++) {
                    z = qVar.b(this.b.b(i).f) == this.k.b(i);
                }
            } else {
                z = iArr.length == this.k.b;
                for (int i2 = 0; z && i2 < a2; i2++) {
                    z = iArr[i2] == this.k.b(i2);
                }
            }
        }
        if (z) {
            return;
        }
        io.g.glBindBuffer(34962, this.e);
        a(qVar);
        this.k.b();
        for (int i3 = 0; i3 < a2; i3++) {
            ks b = this.b.b(i3);
            if (iArr == null) {
                this.k.a(qVar.b(b.f));
            } else {
                this.k.a(iArr[i3]);
            }
            int b2 = this.k.b(i3);
            if (b2 >= 0) {
                qVar.b(b2);
                qVar.a(b2, b.b, b.d, b.c, this.b.a, b.e);
            }
        }
    }

    private void a(q qVar) {
        if (this.k.b == 0) {
            return;
        }
        int a2 = this.b.a();
        for (int i = 0; i < a2; i++) {
            int b = this.k.b(i);
            if (b >= 0) {
                qVar.a(b);
            }
        }
    }

    private void a(kg kgVar) {
        if (this.h) {
            kgVar.glBindBuffer(34962, this.e);
            this.d.limit(this.c.limit() * 4);
            kgVar.glBufferData(34962, this.d.limit(), this.d, this.g);
            this.h = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void b(q qVar, int[] iArr) {
        io.i.glBindVertexArray(0);
        this.i = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void e() {
        this.e = io.i.glGenBuffer();
        g();
        this.h = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        kh khVar = io.i;
        khVar.glBindBuffer(34962, 0);
        khVar.glDeleteBuffer(this.e);
        this.e = 0;
        BufferUtils.a(this.d);
        h();
    }

    private void g() {
        a.clear();
        io.i.glGenVertexArrays(1, a);
        this.j = a.get();
    }

    private void h() {
        if (this.j != -1) {
            a.clear();
            a.put(this.j);
            a.flip();
            io.i.glDeleteVertexArrays(1, a);
            this.j = -1;
        }
    }
}
