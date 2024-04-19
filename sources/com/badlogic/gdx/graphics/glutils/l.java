package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
/* compiled from: IndexBufferObjectSubData.java */
/* loaded from: classes.dex */
public class l implements m {
    final ShortBuffer a;
    final ByteBuffer b;
    int c;
    final int g;
    boolean e = true;
    boolean f = false;
    final boolean d = true;

    public l(boolean z, int i) {
        this.b = BufferUtils.b(i * 2);
        this.g = z ? 35044 : 35048;
        this.a = this.b.asShortBuffer();
        this.a.flip();
        this.b.flip();
        this.c = g();
    }

    private int g() {
        int glGenBuffer = io.h.glGenBuffer();
        io.h.glBindBuffer(34963, glGenBuffer);
        io.h.glBufferData(34963, this.b.capacity(), null, this.g);
        io.h.glBindBuffer(34963, 0);
        return glGenBuffer;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public int a() {
        return this.a.limit();
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public int b() {
        return this.a.capacity();
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void a(short[] sArr, int i, int i2) {
        this.e = true;
        this.a.clear();
        this.a.put(sArr, i, i2);
        this.a.flip();
        this.b.position(0);
        this.b.limit(i2 << 1);
        if (this.f) {
            io.h.glBufferSubData(34963, 0, this.b.limit(), this.b);
            this.e = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public ShortBuffer c() {
        this.e = true;
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void d() {
        if (this.c == 0) {
            throw new com.badlogic.gdx.utils.k("IndexBufferObject cannot be used after it has been disposed.");
        }
        io.h.glBindBuffer(34963, this.c);
        if (this.e) {
            this.b.limit(this.a.limit() * 2);
            io.h.glBufferSubData(34963, 0, this.b.limit(), this.b);
            this.e = false;
        }
        this.f = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void e() {
        io.h.glBindBuffer(34963, 0);
        this.f = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void f() {
        this.c = g();
        this.e = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        kg kgVar = io.h;
        kgVar.glBindBuffer(34963, 0);
        kgVar.glDeleteBuffer(this.c);
        this.c = 0;
    }
}
