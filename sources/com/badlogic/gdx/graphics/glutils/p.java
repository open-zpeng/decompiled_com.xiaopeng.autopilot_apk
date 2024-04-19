package com.badlogic.gdx.graphics.glutils;

import defpackage.km;
import defpackage.kr;
/* compiled from: PixmapTextureData.java */
/* loaded from: classes.dex */
public class p implements kr {
    final km a;
    final km.c b;
    final boolean c;
    final boolean d;
    final boolean e;

    @Override // defpackage.kr
    public boolean a() {
        return true;
    }

    public p(km kmVar, km.c cVar, boolean z, boolean z2) {
        this(kmVar, cVar, z, z2, false);
    }

    public p(km kmVar, km.c cVar, boolean z, boolean z2, boolean z3) {
        this.a = kmVar;
        this.b = cVar == null ? kmVar.h() : cVar;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    @Override // defpackage.kr
    public boolean i() {
        return this.d;
    }

    @Override // defpackage.kr
    public km h() {
        return this.a;
    }

    @Override // defpackage.kr
    public int d() {
        return this.a.b();
    }

    @Override // defpackage.kr
    public int e() {
        return this.a.c();
    }

    @Override // defpackage.kr
    public km.c j() {
        return this.b;
    }

    @Override // defpackage.kr
    public boolean k() {
        return this.c;
    }

    @Override // defpackage.kr
    public boolean f() {
        return this.e;
    }

    @Override // defpackage.kr
    public kr.b g() {
        return kr.b.Pixmap;
    }

    @Override // defpackage.kr
    public void a(int i) {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation does not upload data itself");
    }

    @Override // defpackage.kr
    public void b() {
        throw new com.badlogic.gdx.utils.k("prepare() must not be called on a PixmapTextureData instance as it is already prepared.");
    }
}
