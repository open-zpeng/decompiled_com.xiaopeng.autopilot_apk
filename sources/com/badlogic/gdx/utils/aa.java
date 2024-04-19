package com.badlogic.gdx.utils;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class aa {
    private static final v<Class, z> a = new v<>();

    public static <T> z<T> a(Class<T> cls, int i) {
        z<T> a2 = a.a((v<Class, z>) cls);
        if (a2 == null) {
            ad adVar = new ad(cls, 4, i);
            a.a((v<Class, z>) cls, (Class<T>) adVar);
            return adVar;
        }
        return a2;
    }

    public static <T> z<T> a(Class<T> cls) {
        return a(cls, 100);
    }

    public static <T> T b(Class<T> cls) {
        return (T) a((Class) cls).obtain();
    }

    public static void a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object cannot be null.");
        }
        z a2 = a.a((v<Class, z>) obj.getClass());
        if (a2 == null) {
            return;
        }
        a2.free(obj);
    }

    public static void a(a aVar, boolean z) {
        if (aVar == null) {
            throw new IllegalArgumentException("Objects cannot be null.");
        }
        int i = aVar.b;
        z zVar = null;
        for (int i2 = 0; i2 < i; i2++) {
            Object a2 = aVar.a(i2);
            if (a2 != null && (zVar != null || (zVar = a.a((v<Class, z>) a2.getClass())) != null)) {
                zVar.free(a2);
                if (!z) {
                    zVar = null;
                }
            }
        }
    }
}
