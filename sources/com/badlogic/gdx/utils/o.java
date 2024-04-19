package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.r;
import com.badlogic.gdx.utils.v;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* compiled from: Json.java */
/* loaded from: classes.dex */
public class o {
    private boolean d;
    private boolean e;
    private boolean f;
    private d h;
    private String a = "class";
    private boolean b = true;
    private boolean g = true;
    private final v<Class, x<String, a>> i = new v<>();
    private final v<String, Class> j = new v<>();
    private final v<Class, String> k = new v<>();
    private final v<Class, d> l = new v<>();
    private final v<Class, Object[]> m = new v<>();
    private final Object[] n = {null};
    private final Object[] o = {null};
    private r.b c = r.b.minimal;

    /* compiled from: Json.java */
    /* loaded from: classes.dex */
    public static abstract class b<T> implements d<T> {
    }

    /* compiled from: Json.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(o oVar, q qVar);
    }

    /* compiled from: Json.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        T b(o oVar, q qVar, Class cls);
    }

    protected boolean a(Class cls, String str) {
        return false;
    }

    public void a(String str, Class cls) {
        this.j.a((v<String, Class>) str, (String) cls);
        this.k.a((v<Class, String>) cls, (Class) str);
    }

    public Class a(String str) {
        return this.j.a((v<String, Class>) str);
    }

    public void b(String str) {
        this.a = str;
    }

    public <T> void a(Class<T> cls, d<T> dVar) {
        this.l.a((v<Class, d>) cls, (Class<T>) dVar);
    }

    public void a(boolean z) {
        this.b = z;
    }

    private x<String, a> b(Class cls) {
        x<String, a> a2 = this.i.a((v<Class, x<String, a>>) cls);
        if (a2 != null) {
            return a2;
        }
        com.badlogic.gdx.utils.a aVar = new com.badlogic.gdx.utils.a();
        for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            aVar.a((com.badlogic.gdx.utils.a) cls2);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = aVar.b - 1; i >= 0; i--) {
            Collections.addAll(arrayList, qu.e((Class) aVar.a(i)));
        }
        x<String, a> xVar = new x<>(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            qw qwVar = (qw) arrayList.get(i2);
            if (!qwVar.f() && !qwVar.e() && !qwVar.g()) {
                if (!qwVar.d()) {
                    try {
                        qwVar.a(true);
                    } catch (AccessControlException unused) {
                    }
                }
                if (!this.e || this.f || !qwVar.a(Deprecated.class)) {
                    xVar.a((x<String, a>) qwVar.a(), (String) new a(qwVar));
                }
            }
        }
        this.i.a((v<Class, x<String, a>>) cls, (Class) xVar);
        return xVar;
    }

    public <T> T a(Class<T> cls, jy jyVar) {
        try {
            return (T) a(cls, (Class) null, new p().a(jyVar));
        } catch (Exception e) {
            throw new af("Error reading file: " + jyVar, e);
        }
    }

    public void a(Object obj, q qVar) {
        Class<?> cls = obj.getClass();
        x<String, a> b2 = b(cls);
        for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
            a a2 = b2.a((x<String, a>) qVar2.t().replace(" ", "_"));
            if (a2 == null) {
                if (!qVar2.a.equals(this.a) && !this.d && !a((Class) cls, qVar2.a)) {
                    af afVar = new af("Field not found: " + qVar2.a + " (" + cls.getName() + ")");
                    afVar.a(qVar2.v());
                    throw afVar;
                }
            } else {
                qw qwVar = a2.a;
                try {
                    qwVar.a(obj, a(qwVar.b(), a2.b, qVar2));
                } catch (af e) {
                    e.a(qwVar.a() + " (" + cls.getName() + ")");
                    throw e;
                } catch (RuntimeException e2) {
                    af afVar2 = new af(e2);
                    afVar2.a(qVar2.v());
                    afVar2.a(qwVar.a() + " (" + cls.getName() + ")");
                    throw afVar2;
                } catch (qx e3) {
                    throw new af("Error accessing field: " + qwVar.a() + " (" + cls.getName() + ")", e3);
                }
            }
        }
    }

    public <T> T a(String str, Class<T> cls, q qVar) {
        return (T) a(cls, (Class) null, qVar.a(str));
    }

    public <T> T a(String str, Class<T> cls, T t, q qVar) {
        q a2 = qVar.a(str);
        return a2 == null ? t : (T) a(cls, (Class) null, a2);
    }

    public <T> T a(String str, Class<T> cls, Class cls2, q qVar) {
        return (T) a(cls, cls2, qVar.a(str));
    }

    public <T> T a(Class<T> cls, q qVar) {
        return (T) a(cls, (Class) null, qVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0147, code lost:
        if (r6 == java.lang.Object.class) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x02a4, code lost:
        if (r6 != java.lang.Boolean.class) goto L199;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x038d A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, T] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.badlogic.gdx.utils.o] */
    /* JADX WARN: Type inference failed for: r6v49, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v50, types: [com.badlogic.gdx.utils.b, T] */
    /* JADX WARN: Type inference failed for: r6v51, types: [T, com.badlogic.gdx.utils.v] */
    /* JADX WARN: Type inference failed for: r6v83, types: [com.badlogic.gdx.utils.ac] */
    /* JADX WARN: Type inference failed for: r6v87, types: [com.badlogic.gdx.utils.a] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.badlogic.gdx.utils.q, T] */
    /* JADX WARN: Type inference failed for: r8v33, types: [com.badlogic.gdx.utils.q, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T a(java.lang.Class<T> r6, java.lang.Class r7, com.badlogic.gdx.utils.q r8) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.o.a(java.lang.Class, java.lang.Class, com.badlogic.gdx.utils.q):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    public void a(Object obj, Object obj2) {
        x<String, a> b2 = b(obj.getClass());
        v.a<String, a> it = b(obj.getClass()).iterator();
        while (it.hasNext()) {
            v.b next = it.next();
            a a2 = b2.a((x<String, a>) next.a);
            qw qwVar = ((a) next.b).a;
            if (a2 == null) {
                throw new af("To object is missing field" + ((String) next.a));
            }
            try {
                a2.a.a(obj2, qwVar.a(obj));
            } catch (qx e) {
                throw new af("Error copying field: " + qwVar.a(), e);
            }
        }
    }

    private String a(Enum r2) {
        return this.g ? r2.name() : r2.toString();
    }

    protected Object a(Class cls) {
        try {
            return qu.d(cls);
        } catch (Exception e) {
            e = e;
            try {
                qv b2 = qu.b(cls, new Class[0]);
                b2.a(true);
                return b2.a(new Object[0]);
            } catch (SecurityException unused) {
                throw new af("Error constructing instance of class: " + cls.getName(), e);
            } catch (qx unused2) {
                if (qu.a(Enum.class, cls)) {
                    if (cls.getEnumConstants() == null) {
                        cls = cls.getSuperclass();
                    }
                    return cls.getEnumConstants()[0];
                } else if (cls.isArray()) {
                    throw new af("Encountered JSON object when expected array of type: " + cls.getName(), e);
                } else if (qu.b(cls) && !qu.c(cls)) {
                    throw new af("Class cannot be created (non-static member class): " + cls.getName(), e);
                } else {
                    throw new af("Class cannot be created (missing no-arg constructor): " + cls.getName(), e);
                }
            } catch (Exception e2) {
                e = e2;
                throw new af("Error constructing instance of class: " + cls.getName(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Json.java */
    /* loaded from: classes.dex */
    public static class a {
        final qw a;
        Class b;

        public a(qw qwVar) {
            this.a = qwVar;
            this.b = qwVar.a((qu.a(v.class, qwVar.b()) || qu.a(Map.class, qwVar.b())) ? 1 : 0);
        }
    }
}
