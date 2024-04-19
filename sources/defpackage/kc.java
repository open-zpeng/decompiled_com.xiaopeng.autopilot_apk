package defpackage;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import defpackage.iz;
import defpackage.jg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: Cubemap.java */
/* renamed from: kc  reason: default package */
/* loaded from: classes.dex */
public class kc extends ki {
    static final Map<ij, a<kc>> a = new HashMap();
    private static jb c;
    protected kd b;

    @Override // defpackage.ki
    public int getDepth() {
        return 0;
    }

    public kc(kd kdVar) {
        super(34067);
        this.b = kdVar;
        a(kdVar);
    }

    public void a(kd kdVar) {
        if (!kdVar.a()) {
            kdVar.b();
        }
        bind();
        unsafeSetFilter(this.minFilter, this.magFilter, true);
        unsafeSetWrap(this.uWrap, this.vWrap, true);
        kdVar.c();
        io.g.glBindTexture(this.glTarget, 0);
    }

    public kd a() {
        return this.b;
    }

    @Override // defpackage.ki
    public boolean isManaged() {
        return this.b.f();
    }

    @Override // defpackage.ki
    protected void reload() {
        if (!isManaged()) {
            throw new k("Tried to reload an unmanaged Cubemap");
        }
        this.glHandle = io.g.glGenTexture();
        a(this.b);
    }

    @Override // defpackage.ki
    public int getWidth() {
        return this.b.d();
    }

    @Override // defpackage.ki
    public int getHeight() {
        return this.b.e();
    }

    @Override // defpackage.ki, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.glHandle == 0) {
            return;
        }
        delete();
        if (!this.b.f() || a.get(io.a) == null) {
            return;
        }
        a.get(io.a).c(this, true);
    }

    public static void a(ij ijVar) {
        a.remove(ijVar);
    }

    public static void b(ij ijVar) {
        a<kc> aVar = a.get(ijVar);
        if (aVar == null) {
            return;
        }
        jb jbVar = c;
        if (jbVar == null) {
            for (int i = 0; i < aVar.b; i++) {
                aVar.a(i).reload();
            }
            return;
        }
        jbVar.b();
        a<? extends kc> aVar2 = new a<>(aVar);
        Iterator<? extends kc> it = aVar2.iterator();
        while (it.hasNext()) {
            kc next = it.next();
            String a2 = c.a((jb) next);
            if (a2 == null) {
                next.reload();
            } else {
                final int d = c.d(a2);
                c.a(a2, 0);
                next.glHandle = 0;
                jg.b bVar = new jg.b();
                bVar.c = next.a();
                bVar.d = next.getMinFilter();
                bVar.e = next.getMagFilter();
                bVar.f = next.getUWrap();
                bVar.g = next.getVWrap();
                bVar.b = next;
                bVar.loadedCallback = new iz.a() { // from class: kc.1
                    @Override // defpackage.iz.a
                    public void a(jb jbVar2, String str, Class cls) {
                        jbVar2.a(str, d);
                    }
                };
                c.b(a2);
                next.glHandle = io.g.glGenTexture();
                c.a(a2, kc.class, (iz) bVar);
            }
        }
        aVar.d();
        aVar.a(aVar2);
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Managed cubemap/app: { ");
        for (ij ijVar : a.keySet()) {
            sb.append(a.get(ijVar).b);
            sb.append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
