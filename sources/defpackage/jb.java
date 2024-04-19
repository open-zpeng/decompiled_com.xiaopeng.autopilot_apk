package defpackage;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonRegionLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.aq;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.l;
import com.badlogic.gdx.utils.p;
import com.badlogic.gdx.utils.s;
import com.badlogic.gdx.utils.u;
import com.badlogic.gdx.utils.v;
import com.badlogic.gdx.utils.w;
import java.util.Iterator;
import java.util.Stack;
/* compiled from: AssetManager.java */
/* renamed from: jb  reason: default package */
/* loaded from: classes.dex */
public class jb implements g {
    final v<Class, v<String, jc>> a;
    final v<String, Class> b;
    final v<String, a<String>> c;
    final w<String> d;
    final v<Class, v<String, jd>> e;
    final a<ix> f;
    final qp g;
    final Stack<ja> h;
    iy i;
    int j;
    int k;
    int l;
    final jh m;
    s n;

    public jb() {
        this(new jt());
    }

    public jb(jh jhVar) {
        this(jhVar, true);
    }

    public jb(jh jhVar, boolean z) {
        this.a = new v<>();
        this.b = new v<>();
        this.c = new v<>();
        this.d = new w<>();
        this.e = new v<>();
        this.f = new a<>();
        this.h = new Stack<>();
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.n = new s("AssetManager", 0);
        this.m = jhVar;
        if (z) {
            a(BitmapFont.class, new jf(jhVar));
            a(jw.class, new jk(jhVar));
            a(km.class, new jm(jhVar));
            a(jx.class, new jp(jhVar));
            a(TextureAtlas.class, new jr(jhVar));
            a(ko.class, new js(jhVar));
            a(pl.class, new jo(jhVar));
            a(ParticleEffect.class, new jl(jhVar));
            a(mp.class, new mq(jhVar));
            a(PolygonRegion.class, new PolygonRegionLoader(jhVar));
            a(l.class, new ji(jhVar));
            a(ky.class, ".g3dj", new lu(new p(), jhVar));
            a(ky.class, ".g3db", new lu(new aq(), jhVar));
            a(ky.class, ".obj", new lw(jhVar));
            a(q.class, new jn(jhVar));
            a(kc.class, new jg(jhVar));
        }
        this.g = new qp(1);
    }

    public synchronized <T> T a(String str) {
        T t;
        Class<T> a = this.b.a((v<String, Class>) str);
        if (a == null) {
            throw new k("Asset not loaded: " + str);
        }
        v<String, jc> a2 = this.a.a((v<Class, v<String, jc>>) a);
        if (a2 == null) {
            throw new k("Asset not loaded: " + str);
        }
        jc a3 = a2.a((v<String, jc>) str);
        if (a3 == null) {
            throw new k("Asset not loaded: " + str);
        }
        t = (T) a3.a(a);
        if (t == null) {
            throw new k("Asset not loaded: " + str);
        }
        return t;
    }

    public synchronized <T> T a(String str, Class<T> cls) {
        T t;
        v<String, jc> a = this.a.a((v<Class, v<String, jc>>) cls);
        if (a == null) {
            throw new k("Asset not loaded: " + str);
        }
        jc a2 = a.a((v<String, jc>) str);
        if (a2 == null) {
            throw new k("Asset not loaded: " + str);
        }
        t = (T) a2.a(cls);
        if (t == null) {
            throw new k("Asset not loaded: " + str);
        }
        return t;
    }

    public synchronized void b(String str) {
        if (this.h.size() > 0) {
            ja firstElement = this.h.firstElement();
            if (firstElement.b.a.equals(str)) {
                firstElement.m = true;
                this.n.b("Unload (from tasks): " + str);
                return;
            }
        }
        int i = 0;
        while (true) {
            if (i >= this.f.b) {
                i = -1;
                break;
            } else if (this.f.a(i).a.equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.k--;
            this.f.b(i);
            this.n.b("Unload (from queue): " + str);
            return;
        }
        Class a = this.b.a((v<String, Class>) str);
        if (a == null) {
            throw new k("Asset not loaded: " + str);
        }
        jc a2 = this.a.a((v<Class, v<String, jc>>) a).a((v<String, jc>) str);
        a2.b();
        if (a2.c() <= 0) {
            this.n.b("Unload (dispose): " + str);
            if (a2.a(Object.class) instanceof g) {
                ((g) a2.a(Object.class)).dispose();
            }
            this.b.b((v<String, Class>) str);
            this.a.a((v<Class, v<String, jc>>) a).b((v<String, jc>) str);
        } else {
            this.n.b("Unload (decrement): " + str);
        }
        a<String> a3 = this.c.a((v<String, a<String>>) str);
        if (a3 != null) {
            Iterator<String> it = a3.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (c(next)) {
                    b(next);
                }
            }
        }
        if (a2.c() <= 0) {
            this.c.b((v<String, a<String>>) str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[Catch: all -> 0x004c, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x000b, B:6:0x0011, B:7:0x0027, B:9:0x002d, B:11:0x0041), top: B:21:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized <T> java.lang.String a(T r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.badlogic.gdx.utils.v<java.lang.Class, com.badlogic.gdx.utils.v<java.lang.String, jc>> r0 = r6.a     // Catch: java.lang.Throwable -> L4c
            com.badlogic.gdx.utils.v$c r0 = r0.e()     // Catch: java.lang.Throwable -> L4c
            com.badlogic.gdx.utils.v$c r0 = r0.iterator()     // Catch: java.lang.Throwable -> L4c
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L4c
            if (r1 == 0) goto L49
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L4c
            java.lang.Class r1 = (java.lang.Class) r1     // Catch: java.lang.Throwable -> L4c
            com.badlogic.gdx.utils.v<java.lang.Class, com.badlogic.gdx.utils.v<java.lang.String, jc>> r2 = r6.a     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r1 = r2.a(r1)     // Catch: java.lang.Throwable -> L4c
            com.badlogic.gdx.utils.v r1 = (com.badlogic.gdx.utils.v) r1     // Catch: java.lang.Throwable -> L4c
            com.badlogic.gdx.utils.v$c r2 = r1.e()     // Catch: java.lang.Throwable -> L4c
            com.badlogic.gdx.utils.v$c r2 = r2.iterator()     // Catch: java.lang.Throwable -> L4c
        L27:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L4c
            if (r3 == 0) goto Lb
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r4 = r1.a(r3)     // Catch: java.lang.Throwable -> L4c
            jc r4 = (defpackage.jc) r4     // Catch: java.lang.Throwable -> L4c
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            java.lang.Object r4 = r4.a(r5)     // Catch: java.lang.Throwable -> L4c
            if (r4 == r7) goto L47
            boolean r4 = r7.equals(r4)     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L27
        L47:
            monitor-exit(r6)
            return r3
        L49:
            r7 = 0
            monitor-exit(r6)
            return r7
        L4c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jb.a(java.lang.Object):java.lang.String");
    }

    public synchronized boolean c(String str) {
        if (str == null) {
            return false;
        }
        return this.b.d((v<String, Class>) str);
    }

    public <T> jd a(Class<T> cls, String str) {
        v<String, jd> a = this.e.a((v<Class, v<String, jd>>) cls);
        jd jdVar = null;
        if (a == null || a.a < 1) {
            return null;
        }
        if (str == null) {
            return a.a((v<String, jd>) "");
        }
        int i = -1;
        v.a<String, jd> it = a.c().iterator();
        while (it.hasNext()) {
            v.b next = it.next();
            if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                jdVar = (jd) next.b;
                i = ((String) next.a).length();
            }
        }
        return jdVar;
    }

    public synchronized <T> void b(String str, Class<T> cls) {
        a(str, (Class) cls, (iz) null);
    }

    public synchronized <T> void a(String str, Class<T> cls, iz<T> izVar) {
        if (a(cls, str) == null) {
            throw new k("No loader for type: " + qu.a(cls));
        }
        if (this.f.b == 0) {
            this.j = 0;
            this.k = 0;
            this.l = 0;
        }
        for (int i = 0; i < this.f.b; i++) {
            ix a = this.f.a(i);
            if (a.a.equals(str) && !a.b.equals(cls)) {
                throw new k("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + qu.a(cls) + ", found: " + qu.a(a.b) + ")");
            }
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            ix ixVar = this.h.get(i2).b;
            if (ixVar.a.equals(str) && !ixVar.b.equals(cls)) {
                throw new k("Asset with name '" + str + "' already in task list, but has different type (expected: " + qu.a(cls) + ", found: " + qu.a(ixVar.b) + ")");
            }
        }
        Class a2 = this.b.a((v<String, Class>) str);
        if (a2 != null && !a2.equals(cls)) {
            throw new k("Asset with name '" + str + "' already loaded, but has different type (expected: " + qu.a(cls) + ", found: " + qu.a(a2) + ")");
        }
        this.k++;
        ix ixVar2 = new ix(str, cls, izVar);
        this.f.a((a<ix>) ixVar2);
        this.n.a("Queued: " + ixVar2);
    }

    public synchronized boolean a() {
        boolean z = false;
        try {
            if (this.h.size() == 0) {
                while (this.f.b != 0 && this.h.size() == 0) {
                    f();
                }
                if (this.h.size() == 0) {
                    return true;
                }
            }
            if (g() && this.f.b == 0) {
                if (this.h.size() == 0) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            a(th);
            return this.f.b == 0;
        }
    }

    public void b() {
        this.n.a("Waiting for loading to complete...");
        while (!a()) {
            qs.a();
        }
        this.n.a("Loading complete.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(String str, a<ix> aVar) {
        w<String> wVar = this.d;
        Iterator<ix> it = aVar.iterator();
        while (it.hasNext()) {
            ix next = it.next();
            if (!wVar.d((w<String>) next.a)) {
                wVar.a((w<String>) next.a);
                a(str, next);
            }
        }
        wVar.a();
    }

    private synchronized void a(String str, ix ixVar) {
        a<String> a = this.c.a((v<String, a<String>>) str);
        if (a == null) {
            a = new a<>();
            this.c.a((v<String, a<String>>) str, (String) a);
        }
        a.a((a<String>) ixVar.a);
        if (c(ixVar.a)) {
            s sVar = this.n;
            sVar.a("Dependency already loaded: " + ixVar);
            this.a.a((v<Class, v<String, jc>>) this.b.a((v<String, Class>) ixVar.a)).a((v<String, jc>) ixVar.a).a();
            f(ixVar.a);
        } else {
            s sVar2 = this.n;
            sVar2.b("Loading dependency: " + ixVar);
            a(ixVar);
        }
    }

    private void f() {
        ix b = this.f.b(0);
        if (c(b.a)) {
            this.n.a("Already loaded: " + b);
            this.a.a((v<Class, v<String, jc>>) this.b.a((v<String, Class>) b.a)).a((v<String, jc>) b.a).a();
            f(b.a);
            if (b.c != null && b.c.loadedCallback != null) {
                b.c.loadedCallback.a(this, b.a, b.b);
            }
            this.j++;
            return;
        }
        this.n.b("Loading: " + b);
        a(b);
    }

    private void a(ix ixVar) {
        jd a = a((Class) ixVar.b, ixVar.a);
        if (a == null) {
            throw new k("No loader for type: " + qu.a(ixVar.b));
        }
        this.h.push(new ja(this, ixVar, a, this.g));
        this.l++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void a(String str, Class<T> cls, T t) {
        this.b.a((v<String, Class>) str, (String) cls);
        v<String, jc> a = this.a.a((v<Class, v<String, jc>>) cls);
        if (a == null) {
            a = new v<>();
            this.a.a((v<Class, v<String, jc>>) cls, (Class<T>) a);
        }
        a.a((v<String, jc>) str, (String) new jc(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean g() {
        /*
            r8 = this;
            java.util.Stack<ja> r0 = r8.h
            java.lang.Object r0 = r0.peek()
            ja r0 = (defpackage.ja) r0
            r1 = 0
            r2 = 1
            boolean r3 = r0.m     // Catch: java.lang.RuntimeException -> L19
            if (r3 != 0) goto L17
            boolean r3 = r0.b()     // Catch: java.lang.RuntimeException -> L19
            if (r3 == 0) goto L15
            goto L17
        L15:
            r3 = r1
            goto L22
        L17:
            r3 = r2
            goto L22
        L19:
            r3 = move-exception
            r0.m = r2
            ix r4 = r0.b
            r8.a(r4, r3)
            r3 = r2
        L22:
            if (r3 == 0) goto L98
            java.util.Stack<ja> r3 = r8.h
            int r3 = r3.size()
            if (r3 != r2) goto L33
            int r3 = r8.j
            int r3 = r3 + r2
            r8.j = r3
            r8.l = r1
        L33:
            java.util.Stack<ja> r1 = r8.h
            r1.pop()
            boolean r1 = r0.m
            if (r1 == 0) goto L3d
            return r2
        L3d:
            ix r1 = r0.b
            java.lang.String r1 = r1.a
            ix r3 = r0.b
            java.lang.Class<T> r3 = r3.b
            java.lang.Object r4 = r0.c()
            r8.a(r1, r3, r4)
            ix r1 = r0.b
            iz r1 = r1.c
            if (r1 == 0) goto L6b
            ix r1 = r0.b
            iz r1 = r1.c
            iz$a r1 = r1.loadedCallback
            if (r1 == 0) goto L6b
            ix r1 = r0.b
            iz r1 = r1.c
            iz$a r1 = r1.loadedCallback
            ix r3 = r0.b
            java.lang.String r3 = r3.a
            ix r4 = r0.b
            java.lang.Class<T> r4 = r4.b
            r1.a(r8, r3, r4)
        L6b:
            long r3 = com.badlogic.gdx.utils.ao.a()
            com.badlogic.gdx.utils.s r1 = r8.n
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Loaded: "
            r5.append(r6)
            long r6 = r0.e
            long r3 = r3 - r6
            float r3 = (float) r3
            r4 = 1232348160(0x49742400, float:1000000.0)
            float r3 = r3 / r4
            r5.append(r3)
            java.lang.String r3 = "ms "
            r5.append(r3)
            ix r0 = r0.b
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r1.a(r0)
            return r2
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jb.g():boolean");
    }

    protected void a(ix ixVar, RuntimeException runtimeException) {
        throw runtimeException;
    }

    private void f(String str) {
        a<String> a = this.c.a((v<String, a<String>>) str);
        if (a == null) {
            return;
        }
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.a((v<Class, v<String, jc>>) this.b.a((v<String, Class>) next)).a((v<String, jc>) next).a();
            f(next);
        }
    }

    private void a(Throwable th) {
        this.n.a("Error loading asset.", th);
        if (this.h.isEmpty()) {
            throw new k(th);
        }
        ja pop = this.h.pop();
        ix ixVar = pop.b;
        if (pop.g && pop.h != null) {
            Iterator<ix> it = pop.h.iterator();
            while (it.hasNext()) {
                b(it.next().a);
            }
        }
        this.h.clear();
        iy iyVar = this.i;
        if (iyVar != null) {
            iyVar.a(ixVar, th);
            return;
        }
        throw new k(th);
    }

    public synchronized <T, P extends iz<T>> void a(Class<T> cls, jd<T, P> jdVar) {
        a(cls, (String) null, jdVar);
    }

    public synchronized <T, P extends iz<T>> void a(Class<T> cls, String str, jd<T, P> jdVar) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (jdVar == null) {
            throw new IllegalArgumentException("loader cannot be null.");
        }
        s sVar = this.n;
        sVar.a("Loader set: " + qu.a(cls) + " -> " + qu.a(jdVar.getClass()));
        v<String, jd> a = this.e.a((v<Class, v<String, jd>>) cls);
        if (a == null) {
            v<Class, v<String, jd>> vVar = this.e;
            v<String, jd> vVar2 = new v<>();
            vVar.a((v<Class, v<String, jd>>) cls, (Class<T>) vVar2);
            a = vVar2;
        }
        if (str == null) {
            str = "";
        }
        a.a((v<String, jd>) str, (String) jdVar);
    }

    public synchronized float c() {
        if (this.k == 0) {
            return 1.0f;
        }
        float f = this.j;
        if (this.l > 0) {
            f += (this.l - this.h.size()) / this.l;
        }
        return Math.min(1.0f, f / this.k);
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public synchronized void dispose() {
        this.n.a("Disposing.");
        d();
        this.g.dispose();
    }

    public synchronized void d() {
        this.f.d();
        while (!a()) {
        }
        u uVar = new u();
        while (this.b.a > 0) {
            uVar.a();
            a<String> b = this.b.e().b();
            Iterator<String> it = b.iterator();
            while (it.hasNext()) {
                uVar.a(it.next(), 0);
            }
            Iterator<String> it2 = b.iterator();
            while (it2.hasNext()) {
                a<String> a = this.c.a((v<String, a<String>>) it2.next());
                if (a != null) {
                    Iterator<String> it3 = a.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        uVar.a(next, uVar.b(next, 0) + 1);
                    }
                }
            }
            Iterator<String> it4 = b.iterator();
            while (it4.hasNext()) {
                String next2 = it4.next();
                if (uVar.b(next2, 0) == 0) {
                    b(next2);
                }
            }
        }
        this.a.a();
        this.b.a();
        this.c.a();
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f.d();
        this.h.clear();
    }

    public s e() {
        return this.n;
    }

    public synchronized int d(String str) {
        Class a;
        a = this.b.a((v<String, Class>) str);
        if (a == null) {
            throw new k("Asset not loaded: " + str);
        }
        return this.a.a((v<Class, v<String, jc>>) a).a((v<String, jc>) str).c();
    }

    public synchronized void a(String str, int i) {
        Class a = this.b.a((v<String, Class>) str);
        if (a == null) {
            throw new k("Asset not loaded: " + str);
        }
        this.a.a((v<Class, v<String, jc>>) a).a((v<String, jc>) str).a(i);
    }

    public synchronized a<String> e(String str) {
        return this.c.a((v<String, a<String>>) str);
    }
}
