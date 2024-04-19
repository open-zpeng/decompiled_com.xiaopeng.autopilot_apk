package com.badlogic.gdx.utils;
/* compiled from: Pool.java */
/* loaded from: classes.dex */
public abstract class z<T> {
    private final com.badlogic.gdx.utils.a<T> freeObjects;
    public final int max;
    public int peak;

    /* compiled from: Pool.java */
    /* loaded from: classes.dex */
    public interface a {
        void reset();
    }

    protected abstract T newObject();

    public z() {
        this(16, Integer.MAX_VALUE);
    }

    public z(int i) {
        this(i, Integer.MAX_VALUE);
    }

    public z(int i, int i2) {
        this.freeObjects = new com.badlogic.gdx.utils.a<>(false, i);
        this.max = i2;
    }

    public T obtain() {
        return this.freeObjects.b == 0 ? newObject() : this.freeObjects.a();
    }

    public void free(T t) {
        if (t == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (this.freeObjects.b < this.max) {
            this.freeObjects.a((com.badlogic.gdx.utils.a<T>) t);
            this.peak = Math.max(this.peak, this.freeObjects.b);
        }
        reset(t);
    }

    protected void reset(T t) {
        if (t instanceof a) {
            ((a) t).reset();
        }
    }

    public void freeAll(com.badlogic.gdx.utils.a<T> aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("objects cannot be null.");
        }
        com.badlogic.gdx.utils.a<T> aVar2 = this.freeObjects;
        int i = this.max;
        for (int i2 = 0; i2 < aVar.b; i2++) {
            T a2 = aVar.a(i2);
            if (a2 != null) {
                if (aVar2.b < i) {
                    aVar2.a((com.badlogic.gdx.utils.a<T>) a2);
                }
                reset(a2);
            }
        }
        this.peak = Math.max(this.peak, aVar2.b);
    }

    public void clear() {
        this.freeObjects.d();
    }

    public int getFree() {
        return this.freeObjects.b;
    }
}
