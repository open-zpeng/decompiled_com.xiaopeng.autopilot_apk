package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import java.util.Iterator;
/* compiled from: Node.java */
/* renamed from: lz  reason: default package */
/* loaded from: classes.dex */
public class lz {
    public String a;
    public boolean c;
    protected lz j;
    public boolean b = true;
    public final p d = new p();
    public final l e = new l(0.0f, 0.0f, 0.0f, 1.0f);
    public final p f = new p(1.0f, 1.0f, 1.0f);
    public final Matrix4 g = new Matrix4();
    public final Matrix4 h = new Matrix4();
    public a<mc> i = new a<>(2);
    private final a<lz> k = new a<>(2);

    public Matrix4 a() {
        if (!this.c) {
            this.g.a(this.d, this.e, this.f);
        }
        return this.g;
    }

    public Matrix4 b() {
        lz lzVar;
        if (this.b && (lzVar = this.j) != null) {
            this.h.a(lzVar.h).b(this.g);
        } else {
            this.h.a(this.g);
        }
        return this.h;
    }

    public void a(boolean z) {
        a();
        b();
        if (z) {
            Iterator<lz> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
        }
    }

    public void b(boolean z) {
        Iterator<mc> it = this.i.iterator();
        while (it.hasNext()) {
            mc next = it.next();
            if (next.c != null && next.d != null && next.c.c == next.d.length) {
                int i = next.c.c;
                for (int i2 = 0; i2 < i; i2++) {
                    next.d[i2].a(next.c.a[i2].h).b(next.c.b[i2]);
                }
            }
        }
        if (z) {
            Iterator<lz> it2 = this.k.iterator();
            while (it2.hasNext()) {
                it2.next().b(true);
            }
        }
    }

    public nz a(nz nzVar) {
        return a(nzVar, true);
    }

    public nz a(nz nzVar, boolean z) {
        int i = this.i.b;
        for (int i2 = 0; i2 < i; i2++) {
            mc a = this.i.a(i2);
            if (a.e) {
                ly lyVar = a.a;
                if (z) {
                    lyVar.e.a(nzVar, lyVar.c, lyVar.d, this.h);
                } else {
                    lyVar.e.b(nzVar, lyVar.c, lyVar.d);
                }
            }
        }
        int i3 = this.k.b;
        for (int i4 = 0; i4 < i3; i4++) {
            this.k.a(i4).a(nzVar);
        }
        return nzVar;
    }

    public void c() {
        lz lzVar = this.j;
        if (lzVar != null) {
            lzVar.b(this);
            this.j = null;
        }
    }

    public int d() {
        return this.k.b;
    }

    public lz a(int i) {
        return this.k.a(i);
    }

    public <T extends lz> int a(T t) {
        return a(-1, (int) t);
    }

    public <T extends lz> int a(Iterable<T> iterable) {
        return a(-1, iterable);
    }

    public <T extends lz> int a(int i, T t) {
        for (lz lzVar = this; lzVar != null; lzVar = lzVar.f()) {
            if (lzVar == t) {
                throw new k("Cannot add a parent as a child");
            }
        }
        lz f = t.f();
        if (f == null || f.b(t)) {
            if (i < 0 || i >= this.k.b) {
                i = this.k.b;
                this.k.a((a<lz>) t);
            } else {
                this.k.b(i, (int) t);
            }
            t.j = this;
            return i;
        }
        throw new k("Could not remove child from its current parent");
    }

    public <T extends lz> int a(int i, Iterable<T> iterable) {
        if (i < 0 || i > this.k.b) {
            i = this.k.b;
        }
        int i2 = i;
        for (T t : iterable) {
            a(i2, (int) t);
            i2++;
        }
        return i;
    }

    public <T extends lz> boolean b(T t) {
        if (this.k.c(t, true)) {
            t.j = null;
            return true;
        }
        return false;
    }

    public Iterable<lz> e() {
        return this.k;
    }

    public lz f() {
        return this.j;
    }

    public boolean g() {
        return this.j != null;
    }

    public lz h() {
        return new lz().c(this);
    }

    protected lz c(lz lzVar) {
        c();
        this.a = lzVar.a;
        this.c = lzVar.c;
        this.b = lzVar.b;
        this.d.a(lzVar.d);
        this.e.a(lzVar.e);
        this.f.a(lzVar.f);
        this.g.a(lzVar.g);
        this.h.a(lzVar.h);
        this.i.d();
        Iterator<mc> it = lzVar.i.iterator();
        while (it.hasNext()) {
            this.i.a((a<mc>) it.next().a());
        }
        this.k.d();
        for (lz lzVar2 : lzVar.e()) {
            a(lzVar2.h());
        }
        return this;
    }

    public static lz a(a<lz> aVar, String str, boolean z, boolean z2) {
        int i = aVar.b;
        if (z2) {
            for (int i2 = 0; i2 < i; i2++) {
                lz a = aVar.a(i2);
                if (a.a.equalsIgnoreCase(str)) {
                    return a;
                }
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                lz a2 = aVar.a(i3);
                if (a2.a.equals(str)) {
                    return a2;
                }
            }
        }
        if (z) {
            for (int i4 = 0; i4 < i; i4++) {
                lz a3 = a(aVar.a(i4).k, str, true, z2);
                if (a3 != null) {
                    return a3;
                }
            }
            return null;
        }
        return null;
    }
}
