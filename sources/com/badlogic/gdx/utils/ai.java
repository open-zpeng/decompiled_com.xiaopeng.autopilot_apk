package com.badlogic.gdx.utils;

import java.util.Comparator;
/* compiled from: SnapshotArray.java */
/* loaded from: classes.dex */
public class ai<T> extends a<T> {
    private T[] d;
    private T[] e;
    private int f;

    public ai() {
    }

    public ai(boolean z, int i, Class cls) {
        super(z, i, cls);
    }

    public ai(Class cls) {
        super(cls);
    }

    public ai(int i) {
        super(i);
    }

    public T[] f() {
        h();
        this.d = this.a;
        this.f++;
        return this.a;
    }

    public void g() {
        this.f = Math.max(0, this.f - 1);
        T[] tArr = this.d;
        if (tArr == null) {
            return;
        }
        if (tArr != this.a && this.f == 0) {
            this.e = this.d;
            int length = this.e.length;
            for (int i = 0; i < length; i++) {
                this.e[i] = null;
            }
        }
        this.d = null;
    }

    private void h() {
        T[] tArr = this.d;
        if (tArr == null || tArr != this.a) {
            return;
        }
        T[] tArr2 = this.e;
        if (tArr2 != null && tArr2.length >= this.b) {
            System.arraycopy(this.a, 0, this.e, 0, this.b);
            this.a = this.e;
            this.e = null;
            return;
        }
        d(this.a.length);
    }

    @Override // com.badlogic.gdx.utils.a
    public void a(int i, T t) {
        h();
        super.a(i, (int) t);
    }

    @Override // com.badlogic.gdx.utils.a
    public void b(int i, T t) {
        h();
        super.b(i, (int) t);
    }

    @Override // com.badlogic.gdx.utils.a
    public boolean c(T t, boolean z) {
        h();
        return super.c(t, z);
    }

    @Override // com.badlogic.gdx.utils.a
    public T b(int i) {
        h();
        return (T) super.b(i);
    }

    @Override // com.badlogic.gdx.utils.a
    public void a(int i, int i2) {
        h();
        super.a(i, i2);
    }

    @Override // com.badlogic.gdx.utils.a
    public boolean a(a<? extends T> aVar, boolean z) {
        h();
        return super.a((a) aVar, z);
    }

    @Override // com.badlogic.gdx.utils.a
    public T a() {
        h();
        return (T) super.a();
    }

    @Override // com.badlogic.gdx.utils.a
    public void d() {
        h();
        super.d();
    }

    @Override // com.badlogic.gdx.utils.a
    public void a(Comparator<? super T> comparator) {
        h();
        super.a((Comparator) comparator);
    }

    @Override // com.badlogic.gdx.utils.a
    public void e(int i) {
        h();
        super.e(i);
    }
}
