package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* compiled from: VertexArray.java */
/* loaded from: classes.dex */
public class s implements w {
    final kt a;
    final FloatBuffer b;
    final ByteBuffer c;
    boolean d = false;

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void e() {
    }

    public s(int i, kt ktVar) {
        this.a = ktVar;
        this.c = BufferUtils.d(this.a.a * i);
        this.b = this.c.asFloatBuffer();
        this.b.flip();
        this.c.flip();
    }

    @Override // com.badlogic.gdx.graphics.glutils.w, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        BufferUtils.a(this.c);
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public FloatBuffer a() {
        return this.b;
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
    public void a(float[] fArr, int i, int i2) {
        BufferUtils.a(fArr, this.c, i2, i);
        this.b.position(0);
        this.b.limit(i2);
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void a(q qVar, int[] iArr) {
        int a = this.a.a();
        this.c.limit(this.b.limit() * 4);
        int i = 0;
        if (iArr == null) {
            while (i < a) {
                ks b = this.a.b(i);
                int b2 = qVar.b(b.f);
                if (b2 >= 0) {
                    qVar.b(b2);
                    if (b.d == 5126) {
                        this.b.position(b.e / 4);
                        qVar.a(b2, b.b, b.d, b.c, this.a.a, this.b);
                    } else {
                        this.c.position(b.e);
                        qVar.a(b2, b.b, b.d, b.c, this.a.a, this.c);
                    }
                }
                i++;
            }
        } else {
            while (i < a) {
                ks b3 = this.a.b(i);
                int i2 = iArr[i];
                if (i2 >= 0) {
                    qVar.b(i2);
                    if (b3.d == 5126) {
                        this.b.position(b3.e / 4);
                        qVar.a(i2, b3.b, b3.d, b3.c, this.a.a, this.b);
                    } else {
                        this.c.position(b3.e);
                        qVar.a(i2, b3.b, b3.d, b3.c, this.a.a, this.c);
                    }
                }
                i++;
            }
        }
        this.d = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public void b(q qVar, int[] iArr) {
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
        this.d = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.w
    public kt d() {
        return this.a;
    }
}
