package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* compiled from: VertexBufferObjectSubData.java */
/* loaded from: classes.dex */
public class u implements w {
    final kt a;
    final FloatBuffer b;
    final ByteBuffer c;
    int d;
    final boolean f;
    final int g;
    boolean h = false;
    boolean i = false;
    final boolean e = true;

    public u(boolean z, int i, kt ktVar) {
        this.f = z;
        this.a = ktVar;
        this.c = BufferUtils.b(this.a.a * i);
        this.g = z ? 35044 : 35048;
        this.b = this.c.asFloatBuffer();
        this.d = f();
        this.b.flip();
        this.c.flip();
    }

    private int f() {
        int glGenBuffer = io.h.glGenBuffer();
        io.h.glBindBuffer(34962, glGenBuffer);
        io.h.glBufferData(34962, this.c.capacity(), null, this.g);
        io.h.glBindBuffer(34962, 0);
        return glGenBuffer;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public kt d() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public int b() {
        return (this.b.limit() * 4) / this.a.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public int c() {
        return this.c.capacity() / this.a.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public FloatBuffer a() {
        this.h = true;
        return this.b;
    }

    private void g() {
        if (this.i) {
            io.h.glBufferSubData(34962, 0, this.c.limit(), this.c);
            this.h = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(float[] fArr, int i, int i2) {
        this.h = true;
        if (this.e) {
            BufferUtils.a(fArr, this.c, i2, i);
            this.b.position(0);
            this.b.limit(i2);
        } else {
            this.b.clear();
            this.b.put(fArr, i, i2);
            this.b.flip();
            this.c.position(0);
            this.c.limit(this.b.limit() << 2);
        }
        g();
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(q qVar, int[] iArr) {
        kg kgVar = io.h;
        kgVar.glBindBuffer(34962, this.d);
        int i = 0;
        if (this.h) {
            this.c.limit(this.b.limit() * 4);
            kgVar.glBufferData(34962, this.c.limit(), this.c, this.g);
            this.h = false;
        }
        int a = this.a.a();
        if (iArr == null) {
            while (i < a) {
                ks b = this.a.b(i);
                int b2 = qVar.b(b.f);
                if (b2 >= 0) {
                    qVar.b(b2);
                    qVar.a(b2, b.b, b.d, b.c, this.a.a, b.e);
                }
                i++;
            }
        } else {
            while (i < a) {
                ks b3 = this.a.b(i);
                int i2 = iArr[i];
                if (i2 >= 0) {
                    qVar.b(i2);
                    qVar.a(i2, b3.b, b3.d, b3.c, this.a.a, b3.e);
                }
                i++;
            }
        }
        this.i = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void b(q qVar, int[] iArr) {
        kg kgVar = io.h;
        int a = this.a.a();
        if (iArr == null) {
            for (int i = 0; i < a; i++) {
                qVar.a(this.a.b(i).f);
            }
        } else {
            for (int i2 = 0; i2 < a; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    qVar.a(i3);
                }
            }
        }
        kgVar.glBindBuffer(34962, 0);
        this.i = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void e() {
        this.d = f();
        this.h = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        kg kgVar = io.h;
        kgVar.glBindBuffer(34962, 0);
        kgVar.glDeleteBuffer(this.d);
        this.d = 0;
    }
}
