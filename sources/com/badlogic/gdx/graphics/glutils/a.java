package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.glutils.ETC1;
import defpackage.km;
import defpackage.kr;
/* compiled from: ETC1TextureData.java */
/* loaded from: classes.dex */
public class a implements kr {
    jy a;
    ETC1.a b;
    boolean c;
    int d = 0;
    int e = 0;
    boolean f = false;

    @Override // defpackage.kr
    public boolean f() {
        return true;
    }

    public a(jy jyVar, boolean z) {
        this.a = jyVar;
        this.c = z;
    }

    @Override // defpackage.kr
    public kr.b g() {
        return kr.b.Custom;
    }

    @Override // defpackage.kr
    public boolean a() {
        return this.f;
    }

    @Override // defpackage.kr
    public void b() {
        if (this.f) {
            throw new com.badlogic.gdx.utils.k("Already prepared");
        }
        if (this.a == null && this.b == null) {
            throw new com.badlogic.gdx.utils.k("Can only load once from ETC1Data");
        }
        jy jyVar = this.a;
        if (jyVar != null) {
            this.b = new ETC1.a(jyVar);
        }
        this.d = this.b.a;
        this.e = this.b.b;
        this.f = true;
    }

    @Override // defpackage.kr
    public void a(int i) {
        if (!this.f) {
            throw new com.badlogic.gdx.utils.k("Call prepare() before calling consumeCompressedData()");
        }
        if (!io.b.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
            km a = ETC1.a(this.b, km.c.RGB565);
            io.g.glTexImage2D(i, 0, a.e(), a.b(), a.c(), 0, a.d(), a.f(), a.g());
            if (this.c) {
                o.a(i, a, a.b(), a.c());
            }
            a.dispose();
            this.c = false;
        } else {
            io.g.glCompressedTexImage2D(i, 0, ETC1.b, this.d, this.e, 0, this.b.c.capacity() - this.b.d, this.b.c);
            if (k()) {
                io.h.glGenerateMipmap(3553);
            }
        }
        this.b.dispose();
        this.b = null;
        this.f = false;
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
        return this.d;
    }

    @Override // defpackage.kr
    public int e() {
        return this.e;
    }

    @Override // defpackage.kr
    public km.c j() {
        return km.c.RGB565;
    }

    @Override // defpackage.kr
    public boolean k() {
        return this.c;
    }
}
