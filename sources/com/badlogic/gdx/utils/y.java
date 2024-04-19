package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.w;
import java.util.NoSuchElementException;
/* compiled from: OrderedSet.java */
/* loaded from: classes.dex */
public class y<T> extends w<T> {
    final com.badlogic.gdx.utils.a<T> e = new com.badlogic.gdx.utils.a<>();
    a f;
    a g;

    @Override // com.badlogic.gdx.utils.w
    public boolean a(T t) {
        if (super.a((y<T>) t)) {
            this.e.a((com.badlogic.gdx.utils.a<T>) t);
            return true;
        }
        return false;
    }

    @Override // com.badlogic.gdx.utils.w
    public boolean b(T t) {
        if (super.b((y<T>) t)) {
            this.e.c(t, false);
            return true;
        }
        return false;
    }

    public T d(int i) {
        T b = this.e.b(i);
        super.b((y<T>) b);
        return b;
    }

    @Override // com.badlogic.gdx.utils.w
    public void b(int i) {
        this.e.d();
        super.b(i);
    }

    @Override // com.badlogic.gdx.utils.w
    public void a() {
        this.e.d();
        super.a();
    }

    @Override // com.badlogic.gdx.utils.w, java.lang.Iterable
    /* renamed from: d */
    public a<T> iterator() {
        if (this.f == null) {
            this.f = new a(this);
            this.g = new a(this);
        }
        if (!this.f.e) {
            this.f.a();
            a<T> aVar = this.f;
            aVar.e = true;
            this.g.e = false;
            return aVar;
        }
        this.g.a();
        a<T> aVar2 = this.g;
        aVar2.e = true;
        this.f.e = false;
        return aVar2;
    }

    @Override // com.badlogic.gdx.utils.w
    public String toString() {
        if (this.a == 0) {
            return "{}";
        }
        T[] tArr = this.e.a;
        al alVar = new al(32);
        alVar.append('{');
        alVar.a(tArr[0]);
        for (int i = 1; i < this.a; i++) {
            alVar.c(", ");
            alVar.a(tArr[i]);
        }
        alVar.append('}');
        return alVar.toString();
    }

    @Override // com.badlogic.gdx.utils.w
    public String a(String str) {
        return this.e.a(str);
    }

    /* compiled from: OrderedSet.java */
    /* loaded from: classes.dex */
    public static class a<T> extends w.a<T> {
        private com.badlogic.gdx.utils.a<T> f;

        public a(y<T> yVar) {
            super(yVar);
            this.f = yVar.e;
        }

        @Override // com.badlogic.gdx.utils.w.a
        public void a() {
            this.c = 0;
            this.a = this.b.a > 0;
        }

        @Override // com.badlogic.gdx.utils.w.a, java.util.Iterator
        public T next() {
            if (!this.a) {
                throw new NoSuchElementException();
            }
            if (!this.e) {
                throw new k("#iterator() cannot be used nested.");
            }
            T a = this.f.a(this.c);
            this.c++;
            this.a = this.c < this.b.a;
            return a;
        }

        @Override // com.badlogic.gdx.utils.w.a, java.util.Iterator
        public void remove() {
            if (this.c < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            this.c--;
            ((y) this.b).d(this.c);
        }
    }
}
