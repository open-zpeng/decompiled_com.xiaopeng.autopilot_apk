package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* compiled from: VertexBufferObject.java */
/* loaded from: classes.dex */
public class t implements w {
    private kt c;
    private FloatBuffer d;
    private ByteBuffer e;
    private boolean f;
    private int h;
    boolean a = false;
    boolean b = false;
    private int g = io.h.glGenBuffer();

    public t(boolean z, int i, kt ktVar) {
        ByteBuffer d = BufferUtils.d(ktVar.a * i);
        d.limit(0);
        a((Buffer) d, true, ktVar);
        a(z ? 35044 : 35048);
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public kt d() {
        return this.c;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public int b() {
        return (this.d.limit() * 4) / this.c.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public int c() {
        return this.e.capacity() / this.c.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public FloatBuffer a() {
        this.a = true;
        return this.d;
    }

    protected void a(Buffer buffer, boolean z, kt ktVar) {
        ByteBuffer byteBuffer;
        if (this.b) {
            throw new com.badlogic.gdx.utils.k("Cannot change attributes while VBO is bound");
        }
        if (this.f && (byteBuffer = this.e) != null) {
            BufferUtils.a(byteBuffer);
        }
        this.c = ktVar;
        if (buffer instanceof ByteBuffer) {
            this.e = (ByteBuffer) buffer;
            this.f = z;
            int limit = this.e.limit();
            ByteBuffer byteBuffer2 = this.e;
            byteBuffer2.limit(byteBuffer2.capacity());
            this.d = this.e.asFloatBuffer();
            this.e.limit(limit);
            this.d.limit(limit / 4);
            return;
        }
        throw new com.badlogic.gdx.utils.k("Only ByteBuffer is currently supported");
    }

    private void f() {
        if (this.b) {
            io.h.glBufferData(34962, this.e.limit(), this.e, this.h);
            this.a = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(float[] fArr, int i, int i2) {
        this.a = true;
        BufferUtils.a(fArr, this.e, i2, i);
        this.d.position(0);
        this.d.limit(i2);
        f();
    }

    protected void a(int i) {
        if (this.b) {
            throw new com.badlogic.gdx.utils.k("Cannot change usage while VBO is bound");
        }
        this.h = i;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(q qVar, int[] iArr) {
        kg kgVar = io.h;
        kgVar.glBindBuffer(34962, this.g);
        int i = 0;
        if (this.a) {
            this.e.limit(this.d.limit() * 4);
            kgVar.glBufferData(34962, this.e.limit(), this.e, this.h);
            this.a = false;
        }
        int a = this.c.a();
        if (iArr == null) {
            while (i < a) {
                ks b = this.c.b(i);
                int b2 = qVar.b(b.f);
                if (b2 >= 0) {
                    qVar.b(b2);
                    qVar.a(b2, b.b, b.d, b.c, this.c.a, b.e);
                }
                i++;
            }
        } else {
            while (i < a) {
                ks b3 = this.c.b(i);
                int i2 = iArr[i];
                if (i2 >= 0) {
                    qVar.b(i2);
                    qVar.a(i2, b3.b, b3.d, b3.c, this.c.a, b3.e);
                }
                i++;
            }
        }
        this.b = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void b(q qVar, int[] iArr) {
        kg kgVar = io.h;
        int a = this.c.a();
        if (iArr == null) {
            for (int i = 0; i < a; i++) {
                qVar.a(this.c.b(i).f);
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
        this.b = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void e() {
        this.g = io.h.glGenBuffer();
        this.a = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        kg kgVar = io.h;
        kgVar.glBindBuffer(34962, 0);
        kgVar.glDeleteBuffer(this.g);
        this.g = 0;
        if (this.f) {
            BufferUtils.a(this.e);
        }
    }
}
