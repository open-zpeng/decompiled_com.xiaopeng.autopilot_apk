package com.badlogic.gdx.graphics.glutils;

import defpackage.km;
import defpackage.kr;
/* compiled from: FileTextureData.java */
/* loaded from: classes.dex */
public class b implements kr {
    final jy a;
    int b;
    int c;
    km.c d;
    km e;
    boolean f;
    boolean g = false;

    @Override // defpackage.kr
    public boolean f() {
        return true;
    }

    @Override // defpackage.kr
    public boolean i() {
        return true;
    }

    public b(jy jyVar, km kmVar, km.c cVar, boolean z) {
        this.b = 0;
        this.c = 0;
        this.a = jyVar;
        this.e = kmVar;
        this.d = cVar;
        this.f = z;
        km kmVar2 = this.e;
        if (kmVar2 != null) {
            this.b = kmVar2.b();
            this.c = this.e.c();
            if (cVar == null) {
                this.d = this.e.h();
            }
        }
    }

    @Override // defpackage.kr
    public boolean a() {
        return this.g;
    }

    @Override // defpackage.kr
    public void b() {
        if (this.g) {
            throw new com.badlogic.gdx.utils.k("Already prepared");
        }
        if (this.e == null) {
            if (this.a.extension().equals("cim")) {
                this.e = kn.a(this.a);
            } else {
                this.e = new km(this.a);
            }
            this.b = this.e.b();
            this.c = this.e.c();
            if (this.d == null) {
                this.d = this.e.h();
            }
        }
        this.g = true;
    }

    @Override // defpackage.kr
    public km h() {
        if (!this.g) {
            throw new com.badlogic.gdx.utils.k("Call prepare() before calling getPixmap()");
        }
        this.g = false;
        km kmVar = this.e;
        this.e = null;
        return kmVar;
    }

    @Override // defpackage.kr
    public int d() {
        return this.b;
    }

    @Override // defpackage.kr
    public int e() {
        return this.c;
    }

    @Override // defpackage.kr
    public km.c j() {
        return this.d;
    }

    @Override // defpackage.kr
    public boolean k() {
        return this.f;
    }

    @Override // defpackage.kr
    public kr.b g() {
        return kr.b.Pixmap;
    }

    @Override // defpackage.kr
    public void a(int i) {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation does not upload data itself");
    }

    public String toString() {
        return this.a.toString();
    }
}
