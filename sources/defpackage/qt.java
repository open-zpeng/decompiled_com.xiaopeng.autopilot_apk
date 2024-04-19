package defpackage;

import java.lang.reflect.Array;
/* compiled from: ArrayReflection.java */
/* renamed from: qt  reason: default package */
/* loaded from: classes.dex */
public final class qt {
    public static Object a(Class cls, int i) {
        return Array.newInstance(cls, i);
    }

    public static void a(Object obj, int i, Object obj2) {
        Array.set(obj, i, obj2);
    }
}
