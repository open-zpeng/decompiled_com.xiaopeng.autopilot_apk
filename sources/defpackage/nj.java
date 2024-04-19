package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import java.util.Iterator;
/* compiled from: ModelBuilder.java */
/* renamed from: nj  reason: default package */
/* loaded from: classes.dex */
public class nj {
    private ky a;
    private lz b;
    private a<nh> c = new a<>();
    private Matrix4 d = new Matrix4();

    private nh a(kt ktVar) {
        Iterator<nh> it = this.c.iterator();
        while (it.hasNext()) {
            nh next = it.next();
            if (next.d().equals(ktVar) && next.f() < 16383) {
                return next;
            }
        }
        nh nhVar = new nh();
        nhVar.a(ktVar);
        this.c.a((a<nh>) nhVar);
        return nhVar;
    }

    public void a() {
        if (this.a != null) {
            throw new k("Call end() first");
        }
        this.b = null;
        this.a = new ky();
        this.c.d();
    }

    public ky b() {
        ky kyVar = this.a;
        if (kyVar == null) {
            throw new k("Call begin() first");
        }
        d();
        this.a = null;
        Iterator<nh> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.c.d();
        a(kyVar);
        return kyVar;
    }

    private void d() {
        if (this.b != null) {
            this.b = null;
        }
    }

    protected lz a(lz lzVar) {
        if (this.a == null) {
            throw new k("Call begin() first");
        }
        d();
        this.a.b.a((a<lz>) lzVar);
        this.b = lzVar;
        return lzVar;
    }

    public lz c() {
        lz lzVar = new lz();
        a(lzVar);
        lzVar.a = "node" + this.a.b.b;
        return lzVar;
    }

    public lz a(String str, ky kyVar) {
        lz lzVar = new lz();
        lzVar.a = str;
        lzVar.a(kyVar.b);
        a(lzVar);
        for (g gVar : kyVar.a()) {
            a(gVar);
        }
        return lzVar;
    }

    public void a(g gVar) {
        ky kyVar = this.a;
        if (kyVar == null) {
            throw new k("Call begin() first");
        }
        kyVar.a(gVar);
    }

    public void a(ly lyVar, kx kxVar) {
        if (this.b == null) {
            c();
        }
        this.b.i.a((a<mc>) new mc(lyVar, kxVar));
    }

    public ni a(String str, int i, kt ktVar, kx kxVar) {
        nh a = a(ktVar);
        a(a.a(str, i), kxVar);
        return a;
    }

    public ni a(String str, int i, long j, kx kxVar) {
        return a(str, i, nh.a(j), kxVar);
    }

    public ky a(float f, float f2, float f3, kx kxVar, long j) {
        return a(f, f2, f3, 4, kxVar, j);
    }

    public ky a(float f, float f2, float f3, int i, kx kxVar, long j) {
        a();
        a("box", i, j, kxVar).a(f, f2, f3);
        return b();
    }

    public static void a(ky kyVar) {
        kyVar.a.d();
        kyVar.d.d();
        kyVar.e.d();
        Iterator<lz> it = kyVar.b.iterator();
        while (it.hasNext()) {
            a(kyVar, it.next());
        }
    }

    private static void a(ky kyVar, lz lzVar) {
        Iterator<mc> it = lzVar.i.iterator();
        while (it.hasNext()) {
            mc next = it.next();
            if (!kyVar.a.a((a<kx>) next.b, true)) {
                kyVar.a.a((a<kx>) next.b);
            }
            if (!kyVar.e.a((a<ly>) next.a, true)) {
                kyVar.e.a((a<ly>) next.a);
                if (!kyVar.d.a((a<kj>) next.a.e, true)) {
                    kyVar.d.a((a<kj>) next.a.e);
                }
                kyVar.a(next.a.e);
            }
        }
        for (lz lzVar2 : lzVar.e()) {
            a(kyVar, lzVar2);
        }
    }
}
