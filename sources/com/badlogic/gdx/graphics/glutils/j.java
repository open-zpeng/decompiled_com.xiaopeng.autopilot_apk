package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
/* compiled from: IndexArray.java */
/* loaded from: classes.dex */
public class j implements m {
    final ShortBuffer a;
    final ByteBuffer b;
    private final boolean c;

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void d() {
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void e() {
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void f() {
    }

    public j(int i) {
        this.c = i == 0;
        this.b = BufferUtils.d((this.c ? 1 : i) * 2);
        this.a = this.b.asShortBuffer();
        this.a.flip();
        this.b.flip();
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public int a() {
        if (this.c) {
            return 0;
        }
        return this.a.limit();
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public int b() {
        if (this.c) {
            return 0;
        }
        return this.a.capacity();
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public void a(short[] sArr, int i, int i2) {
        this.a.clear();
        this.a.put(sArr, i, i2);
        this.a.flip();
        this.b.position(0);
        this.b.limit(i2 << 1);
    }

    @Override // com.badlogic.gdx.graphics.glutils.m
    public ShortBuffer c() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.m, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        BufferUtils.a(this.b);
    }
}
