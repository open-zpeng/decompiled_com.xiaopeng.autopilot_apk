package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.v;
import java.util.NoSuchElementException;
/* compiled from: OrderedMap.java */
/* loaded from: classes.dex */
public class x<K, V> extends v<K, V> {
    final com.badlogic.gdx.utils.a<K> f;
    private v.a g;
    private v.a h;
    private v.e i;
    private v.e j;
    private v.c k;
    private v.c l;

    public x() {
        this.f = new com.badlogic.gdx.utils.a<>();
    }

    public x(int i) {
        super(i);
        this.f = new com.badlogic.gdx.utils.a<>(this.d);
    }

    @Override // com.badlogic.gdx.utils.v
    public V a(K k, V v) {
        if (!d((x<K, V>) k)) {
            this.f.a((com.badlogic.gdx.utils.a<K>) k);
        }
        return (V) super.a((x<K, V>) k, (K) v);
    }

    @Override // com.badlogic.gdx.utils.v
    public V b(K k) {
        this.f.c(k, false);
        return (V) super.b((x<K, V>) k);
    }

    public V b(int i) {
        return (V) super.b((x<K, V>) this.f.b(i));
    }

    @Override // com.badlogic.gdx.utils.v
    public void a() {
        this.f.d();
        super.a();
    }

    @Override // com.badlogic.gdx.utils.v, java.lang.Iterable
    /* renamed from: b */
    public v.a<K, V> iterator() {
        return c();
    }

    @Override // com.badlogic.gdx.utils.v
    public v.a<K, V> c() {
        if (this.g == null) {
            this.g = new a(this);
            this.h = new a(this);
        }
        if (!this.g.f) {
            this.g.c();
            v.a<K, V> aVar = this.g;
            aVar.f = true;
            this.h.f = false;
            return aVar;
        }
        this.h.c();
        v.a<K, V> aVar2 = this.h;
        aVar2.f = true;
        this.g.f = false;
        return aVar2;
    }

    @Override // com.badlogic.gdx.utils.v
    public v.e<V> d() {
        if (this.i == null) {
            this.i = new c(this);
            this.j = new c(this);
        }
        if (!this.i.f) {
            this.i.c();
            v.e<V> eVar = this.i;
            eVar.f = true;
            this.j.f = false;
            return eVar;
        }
        this.j.c();
        v.e<V> eVar2 = this.j;
        eVar2.f = true;
        this.i.f = false;
        return eVar2;
    }

    @Override // com.badlogic.gdx.utils.v
    public v.c<K> e() {
        if (this.k == null) {
            this.k = new b(this);
            this.l = new b(this);
        }
        if (!this.k.f) {
            this.k.c();
            v.c<K> cVar = this.k;
            cVar.f = true;
            this.l.f = false;
            return cVar;
        }
        this.l.c();
        v.c<K> cVar2 = this.l;
        cVar2.f = true;
        this.k.f = false;
        return cVar2;
    }

    @Override // com.badlogic.gdx.utils.v
    public String toString() {
        if (this.a == 0) {
            return "{}";
        }
        al alVar = new al(32);
        alVar.append('{');
        com.badlogic.gdx.utils.a<K> aVar = this.f;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            K a2 = aVar.a(i2);
            if (i2 > 0) {
                alVar.c(", ");
            }
            alVar.a(a2);
            alVar.append('=');
            alVar.a(a((x<K, V>) a2));
        }
        alVar.append('}');
        return alVar.toString();
    }

    /* compiled from: OrderedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends v.a<K, V> {
        private com.badlogic.gdx.utils.a<K> g;

        public a(x<K, V> xVar) {
            super(xVar);
            this.g = xVar.f;
        }

        @Override // com.badlogic.gdx.utils.v.a, com.badlogic.gdx.utils.v.d
        public void c() {
            this.d = 0;
            this.b = this.c.a > 0;
        }

        @Override // com.badlogic.gdx.utils.v.a, java.util.Iterator
        /* renamed from: a */
        public v.b next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            this.a.a = this.g.a(this.d);
            this.a.b = this.c.a((v<K, V>) this.a.a);
            this.d++;
            this.b = this.d < this.c.a;
            return this.a;
        }

        @Override // com.badlogic.gdx.utils.v.a, com.badlogic.gdx.utils.v.d, java.util.Iterator
        public void remove() {
            if (this.e < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            this.c.b((v<K, V>) this.a.a);
            this.d--;
        }
    }

    /* compiled from: OrderedMap.java */
    /* loaded from: classes.dex */
    public static class b<K> extends v.c<K> {
        private com.badlogic.gdx.utils.a<K> a;

        public b(x<K, ?> xVar) {
            super(xVar);
            this.a = xVar.f;
        }

        @Override // com.badlogic.gdx.utils.v.c, com.badlogic.gdx.utils.v.d
        public void c() {
            this.d = 0;
            this.b = this.c.a > 0;
        }

        @Override // com.badlogic.gdx.utils.v.c, java.util.Iterator
        public K next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            K a = this.a.a(this.d);
            this.e = this.d;
            this.d++;
            this.b = this.d < this.c.a;
            return a;
        }

        @Override // com.badlogic.gdx.utils.v.c, com.badlogic.gdx.utils.v.d, java.util.Iterator
        public void remove() {
            if (this.e < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            ((x) this.c).b(this.d - 1);
            this.d = this.e;
            this.e = -1;
        }
    }

    /* compiled from: OrderedMap.java */
    /* loaded from: classes.dex */
    public static class c<V> extends v.e<V> {
        private com.badlogic.gdx.utils.a a;

        public c(x<?, V> xVar) {
            super(xVar);
            this.a = xVar.f;
        }

        @Override // com.badlogic.gdx.utils.v.e, com.badlogic.gdx.utils.v.d
        public void c() {
            this.d = 0;
            this.b = this.c.a > 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.utils.v.e, java.util.Iterator
        public V next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            if (!this.f) {
                throw new k("#iterator() cannot be used nested.");
            }
            V v = (V) this.c.a((v<K, V>) this.a.a(this.d));
            this.e = this.d;
            this.d++;
            this.b = this.d < this.c.a;
            return v;
        }

        @Override // com.badlogic.gdx.utils.v.e, com.badlogic.gdx.utils.v.d, java.util.Iterator
        public void remove() {
            if (this.e < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            ((x) this.c).b(this.e);
            this.d = this.e;
            this.e = -1;
        }
    }
}
