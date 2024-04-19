package com.badlogic.gdx.graphics.glutils;

import defpackage.km;
import defpackage.kr;
/* compiled from: GLOnlyTextureData.java */
/* loaded from: classes.dex */
public class e implements kr {
    int a;
    int b;
    boolean c = false;
    int d;
    int e;
    int f;
    int g;

    @Override // defpackage.kr
    public boolean f() {
        return false;
    }

    @Override // defpackage.kr
    public boolean k() {
        return false;
    }

    public e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = 0;
        this.b = 0;
        this.d = 0;
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
    }

    @Override // defpackage.kr
    public kr.b g() {
        return kr.b.Custom;
    }

    @Override // defpackage.kr
    public boolean a() {
        return this.c;
    }

    @Override // defpackage.kr
    public void b() {
        if (this.c) {
            throw new com.badlogic.gdx.utils.k("Already prepared");
        }
        this.c = true;
    }

    @Override // defpackage.kr
    public void a(int i) {
        io.g.glTexImage2D(i, this.d, this.e, this.a, this.b, 0, this.f, this.g, null);
    }

    @Override // defpackage.kr
    public km h() {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation does not return a Pixmap");
    }

    @Override // defpackage.kr
    public boolean i() {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation does not return a Pixmap");
    }

    @Override // defpackage.kr
    public int d() {
        return this.a;
    }

    @Override // defpackage.kr
    public int e() {
        return this.b;
    }

    @Override // defpackage.kr
    public km.c j() {
        return km.c.RGBA8888;
    }
}
