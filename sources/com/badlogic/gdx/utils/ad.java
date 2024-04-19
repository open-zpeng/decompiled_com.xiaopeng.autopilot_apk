package com.badlogic.gdx.utils;
/* compiled from: ReflectionPool.java */
/* loaded from: classes.dex */
public class ad<T> extends z<T> {
    private final qv a;

    public ad(Class<T> cls, int i, int i2) {
        super(i, i2);
        this.a = a(cls);
        if (this.a != null) {
            return;
        }
        throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName());
    }

    private qv a(Class<T> cls) {
        try {
            try {
                return qu.a(cls, (Class[]) null);
            } catch (qx unused) {
                return null;
            }
        } catch (Exception unused2) {
            qv b = qu.b(cls, null);
            b.a(true);
            return b;
        }
    }

    @Override // com.badlogic.gdx.utils.z
    protected T newObject() {
        try {
            return (T) this.a.a((Object[]) null);
        } catch (Exception e) {
            throw new k("Unable to create new instance: " + this.a.a().getName(), e);
        }
    }
}
