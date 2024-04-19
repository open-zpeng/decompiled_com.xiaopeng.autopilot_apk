package com.badlogic.gdx.utils;

import java.util.Comparator;
/* compiled from: DelayedRemovalArray.java */
/* loaded from: classes.dex */
public class f<T> extends a<T> {
    private int d;
    private m e;
    private int f;

    public f() {
        this.e = new m(0);
    }

    public f(int i) {
        super(i);
        this.e = new m(0);
    }

    public void f() {
        this.d++;
    }

    public void g() {
        int i = this.d;
        if (i == 0) {
            throw new IllegalStateException("begin must be called before end.");
        }
        this.d = i - 1;
        if (this.d == 0) {
            int i2 = this.f;
            if (i2 > 0 && i2 == this.b) {
                this.e.b();
                d();
            } else {
                int i3 = this.e.b;
                for (int i4 = 0; i4 < i3; i4++) {
                    int a = this.e.a();
                    if (a >= this.f) {
                        b(a);
                    }
                }
                for (int i5 = this.f - 1; i5 >= 0; i5--) {
                    b(i5);
                }
            }
            this.f = 0;
        }
    }

    private void f(int i) {
        if (i < this.f) {
            return;
        }
        int i2 = this.e.b;
        for (int i3 = 0; i3 < i2; i3++) {
            int b = this.e.b(i3);
            if (i == b) {
                return;
            }
            if (i < b) {
                this.e.b(i3, i);
                return;
            }
        }
        this.e.a(i);
    }

    @Override // com.badlogic.gdx.utils.a
    public boolean c(T t, boolean z) {
        if (this.d > 0) {
            int b = b((f<T>) t, z);
            if (b == -1) {
                return false;
            }
            f(b);
            return true;
        }
        return super.c(t, z);
    }

    @Override // com.badlogic.gdx.utils.a
    public T b(int i) {
        if (this.d > 0) {
            f(i);
            return a(i);
        }
        return (T) super.b(i);
    }

    @Override // com.badlogic.gdx.utils.a
    public void a(int i, int i2) {
        if (this.d <= 0) {
            super.a(i, i2);
            return;
        }
        while (i2 >= i) {
            f(i2);
            i2--;
        }
    }

    @Override // com.badlogic.gdx.utils.a
    public void d() {
        if (this.d > 0) {
            this.f = this.b;
        } else {
            super.d();
        }
    }

    @Override // com.badlogic.gdx.utils.a
    public void a(int i, T t) {
        if (this.d > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.a(i, (int) t);
    }

    @Override // com.badlogic.gdx.utils.a
    public void b(int i, T t) {
        if (this.d > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.b(i, (int) t);
    }

    @Override // com.badlogic.gdx.utils.a
    public T a() {
        if (this.d > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        return (T) super.a();
    }

    @Override // com.badlogic.gdx.utils.a
    public void a(Comparator<? super T> comparator) {
        if (this.d > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.a((Comparator) comparator);
    }

    @Override // com.badlogic.gdx.utils.a
    public void e(int i) {
        if (this.d > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.e(i);
    }
}
