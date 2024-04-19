package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.b;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.v;
import java.util.Iterator;
/* compiled from: Model.java */
/* renamed from: ky  reason: default package */
/* loaded from: classes.dex */
public class ky implements g {
    public final a<kx> a = new a<>();
    public final a<lz> b = new a<>();
    public final a<lx> c = new a<>();
    public final a<kj> d = new a<>();
    public final a<ly> e = new a<>();
    protected final a<g> f = new a<>();
    private v<mc, b<String, Matrix4>> g = new v<>();

    public ky() {
    }

    public ky(me meVar, np npVar) {
        a(meVar, npVar);
    }

    protected void a(me meVar, np npVar) {
        c(meVar.c);
        a(meVar.d, npVar);
        b(meVar.e);
        a(meVar.f);
        b();
    }

    protected void a(Iterable<md> iterable) {
        for (md mdVar : iterable) {
            lx lxVar = new lx();
            lxVar.a = mdVar.a;
            Iterator<mj> it = mdVar.b.iterator();
            while (it.hasNext()) {
                mj next = it.next();
                lz a = a(next.a);
                if (a != null) {
                    ma maVar = new ma();
                    maVar.a = a;
                    if (next.b != null) {
                        maVar.b = new a<>();
                        maVar.b.c(next.b.b);
                        Iterator<mk<p>> it2 = next.b.iterator();
                        while (it2.hasNext()) {
                            mk<p> next2 = it2.next();
                            if (next2.a > lxVar.b) {
                                lxVar.b = next2.a;
                            }
                            maVar.b.a((a<mb<p>>) new mb<>(next2.a, new p(next2.b == null ? a.d : next2.b)));
                        }
                    }
                    if (next.c != null) {
                        maVar.c = new a<>();
                        maVar.c.c(next.c.b);
                        Iterator<mk<l>> it3 = next.c.iterator();
                        while (it3.hasNext()) {
                            mk<l> next3 = it3.next();
                            if (next3.a > lxVar.b) {
                                lxVar.b = next3.a;
                            }
                            maVar.c.a((a<mb<l>>) new mb<>(next3.a, new l(next3.b == null ? a.e : next3.b)));
                        }
                    }
                    if (next.d != null) {
                        maVar.d = new a<>();
                        maVar.d.c(next.d.b);
                        Iterator<mk<p>> it4 = next.d.iterator();
                        while (it4.hasNext()) {
                            mk<p> next4 = it4.next();
                            if (next4.a > lxVar.b) {
                                lxVar.b = next4.a;
                            }
                            maVar.d.a((a<mb<p>>) new mb<>(next4.a, new p(next4.b == null ? a.f : next4.b)));
                        }
                    }
                    if ((maVar.b != null && maVar.b.b > 0) || ((maVar.c != null && maVar.c.b > 0) || (maVar.d != null && maVar.d.b > 0))) {
                        lxVar.c.a((a<ma>) maVar);
                    }
                }
            }
            if (lxVar.c.b > 0) {
                this.c.a((a<lx>) lxVar);
            }
        }
    }

    protected void b(Iterable<mi> iterable) {
        this.g.a();
        for (mi miVar : iterable) {
            this.b.a((a<lz>) a(miVar));
        }
        v.a<mc, b<String, Matrix4>> it = this.g.c().iterator();
        while (it.hasNext()) {
            v.b next = it.next();
            if (((mc) next.a).c == null) {
                ((mc) next.a).c = new b<>(lz.class, Matrix4.class);
            }
            ((mc) next.a).c.a();
            Iterator it2 = ((b) next.b).b().iterator();
            while (it2.hasNext()) {
                v.b bVar = (v.b) it2.next();
                ((mc) next.a).c.a(a((String) bVar.a), new Matrix4((Matrix4) bVar.b).d());
            }
        }
    }

    protected lz a(mi miVar) {
        ml[] mlVarArr;
        ly lyVar;
        lz lzVar = new lz();
        lzVar.a = miVar.a;
        if (miVar.b != null) {
            lzVar.d.a(miVar.b);
        }
        if (miVar.c != null) {
            lzVar.e.a(miVar.c);
        }
        if (miVar.d != null) {
            lzVar.f.a(miVar.d);
        }
        if (miVar.f != null) {
            for (ml mlVar : miVar.f) {
                kx kxVar = null;
                if (mlVar.b != null) {
                    Iterator<ly> it = this.e.iterator();
                    while (it.hasNext()) {
                        lyVar = it.next();
                        if (mlVar.b.equals(lyVar.a)) {
                            break;
                        }
                    }
                }
                lyVar = null;
                if (mlVar.a != null) {
                    Iterator<kx> it2 = this.a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        kx next = it2.next();
                        if (mlVar.a.equals(next.d)) {
                            kxVar = next;
                            break;
                        }
                    }
                }
                if (lyVar == null || kxVar == null) {
                    throw new k("Invalid node: " + lzVar.a);
                }
                if (lyVar != null && kxVar != null) {
                    mc mcVar = new mc();
                    mcVar.a = lyVar;
                    mcVar.b = kxVar;
                    lzVar.i.a((a<mc>) mcVar);
                    if (mlVar.c != null) {
                        this.g.a((v<mc, b<String, Matrix4>>) mcVar, (mc) mlVar.c);
                    }
                }
            }
        }
        if (miVar.g != null) {
            for (mi miVar2 : miVar.g) {
                lzVar.a(a(miVar2));
            }
        }
        return lzVar;
    }

    protected void c(Iterable<mg> iterable) {
        for (mg mgVar : iterable) {
            a(mgVar);
        }
    }

    protected void a(mg mgVar) {
        mh[] mhVarArr;
        int i = 0;
        for (mh mhVar : mgVar.d) {
            i += mhVar.b.length;
        }
        kt ktVar = new kt(mgVar.b);
        kj kjVar = new kj(true, mgVar.c.length / (ktVar.a / 4), i, ktVar);
        this.d.a((a<kj>) kjVar);
        this.f.a((a<g>) kjVar);
        BufferUtils.a(mgVar.c, kjVar.g(), mgVar.c.length, 0);
        kjVar.h().clear();
        int i2 = 0;
        for (mh mhVar2 : mgVar.d) {
            ly lyVar = new ly();
            lyVar.a = mhVar2.a;
            lyVar.b = mhVar2.c;
            lyVar.c = i2;
            lyVar.d = mhVar2.b.length;
            lyVar.e = kjVar;
            kjVar.h().put(mhVar2.b);
            i2 += lyVar.d;
            this.e.a((a<ly>) lyVar);
        }
        kjVar.h().position(0);
        Iterator<ly> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    protected void a(Iterable<mf> iterable, np npVar) {
        for (mf mfVar : iterable) {
            this.a.a((a<kx>) a(mfVar, npVar));
        }
    }

    protected kx a(mf mfVar, np npVar) {
        ko a;
        kx kxVar = new kx();
        kxVar.d = mfVar.a;
        if (mfVar.b != null) {
            kxVar.a(new lf(lf.d, mfVar.b));
        }
        if (mfVar.c != null) {
            kxVar.a(new lf(lf.b, mfVar.c));
        }
        if (mfVar.d != null) {
            kxVar.a(new lf(lf.c, mfVar.d));
        }
        if (mfVar.e != null) {
            kxVar.a(new lf(lf.e, mfVar.e));
        }
        if (mfVar.f != null) {
            kxVar.a(new lf(lf.f, mfVar.f));
        }
        if (mfVar.g > 0.0f) {
            kxVar.a(new lj(lj.b, mfVar.g));
        }
        if (mfVar.h != 1.0f) {
            kxVar.a(new le(770, 771, mfVar.h));
        }
        v vVar = new v();
        if (mfVar.i != null) {
            Iterator<mm> it = mfVar.i.iterator();
            while (it.hasNext()) {
                mm next = it.next();
                if (vVar.d((v) next.b)) {
                    a = (ko) vVar.a((v) next.b);
                } else {
                    a = npVar.a(next.b);
                    vVar.a((v) next.b, (String) a);
                    this.f.a((a<g>) a);
                }
                no noVar = new no(a);
                noVar.b = a.getMinFilter();
                noVar.c = a.getMagFilter();
                noVar.d = a.getUWrap();
                noVar.e = a.getVWrap();
                float f = next.c == null ? 0.0f : next.c.d;
                float f2 = next.c == null ? 0.0f : next.c.e;
                float f3 = next.d == null ? 1.0f : next.d.d;
                float f4 = next.d == null ? 1.0f : next.d.e;
                switch (next.e) {
                    case 2:
                        kxVar.a(new ln(ln.b, noVar, f, f2, f3, f4));
                        break;
                    case 3:
                        kxVar.a(new ln(ln.g, noVar, f, f2, f3, f4));
                        break;
                    case 4:
                        kxVar.a(new ln(ln.f, noVar, f, f2, f3, f4));
                        break;
                    case 5:
                        kxVar.a(new ln(ln.c, noVar, f, f2, f3, f4));
                        break;
                    case 7:
                        kxVar.a(new ln(ln.e, noVar, f, f2, f3, f4));
                        break;
                    case 8:
                        kxVar.a(new ln(ln.d, noVar, f, f2, f3, f4));
                        break;
                    case 10:
                        kxVar.a(new ln(ln.h, noVar, f, f2, f3, f4));
                        break;
                }
            }
        }
        return kxVar;
    }

    public void a(g gVar) {
        if (this.f.a((a<g>) gVar, true)) {
            return;
        }
        this.f.a((a<g>) gVar);
    }

    public Iterable<g> a() {
        return this.f;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        Iterator<g> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
    }

    public void b() {
        int i = this.b.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.b.a(i2).a(true);
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.b.a(i3).b(true);
        }
    }

    public lz a(String str) {
        return a(str, true);
    }

    public lz a(String str, boolean z) {
        return a(str, z, false);
    }

    public lz a(String str, boolean z, boolean z2) {
        return lz.a(this.b, str, z, z2);
    }
}
