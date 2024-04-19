package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
/* compiled from: IndexBufferObject.java */
/* loaded from: classes.dex */
public class k implements m {
    final ShortBuffer a;
    final ByteBuffer b;
    int c;
    final boolean d;
    boolean e = true;
    boolean f = false;
    final int g;
    private final boolean h;

    public k(boolean z, int i) {
        this.h = i == 0;
        this.b = BufferUtils.d((this.h ? 1 : i) * 2);
        this.d = true;
        this.a = this.b.asShortBuffer();
        this.a.flip();
        this.b.flip();
        this.c = io.h.glGenBuffer();
        this.g = z ? 35044 : 35048;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public int a() {
        if (this.h) {
            return 0;
        }
        return this.a.limit();
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public int b() {
        if (this.h) {
            return 0;
        }
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
            io.h.glBufferData(34963, this.b.limit(), this.b, this.g);
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
            throw new com.badlogic.gdx.utils.k("No buffer allocated!");
        }
        io.h.glBindBuffer(34963, this.c);
        if (this.e) {
            this.b.limit(this.a.limit() * 2);
            io.h.glBufferData(34963, this.b.limit(), this.b, this.g);
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
        this.c = io.h.glGenBuffer();
        this.e = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        io.h.glBindBuffer(34963, 0);
        io.h.glDeleteBuffer(this.c);
        this.c = 0;
        BufferUtils.a(this.b);
    }
}
