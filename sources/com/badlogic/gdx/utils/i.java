package com.badlogic.gdx.utils;
/* compiled from: FlushablePool.java */
/* loaded from: classes.dex */
public abstract class i<T> extends z<T> {
    protected a<T> a = new a<>();

    @Override // com.badlogic.gdx.utils.z
    public T obtain() {
        T t = (T) super.obtain();
        this.a.a((a<T>) t);
        return t;
    }

    public void c() {
        super.freeAll(this.a);
        this.a.d();
    }

    @Override // com.badlogic.gdx.utils.z
    public void free(T t) {
        this.a.c(t, true);
        super.free(t);
    }

    @Override // com.badlogic.gdx.utils.z
    public void freeAll(a<T> aVar) {
        this.a.a((a) aVar, true);
        super.freeAll(aVar);
    }
}
