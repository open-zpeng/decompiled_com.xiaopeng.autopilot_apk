package defpackage;

import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.v;
import defpackage.jj.a;
import defpackage.js;
import defpackage.ko;
import defpackage.np;
import java.util.Iterator;
/* compiled from: ModelLoader.java */
/* renamed from: jj  reason: default package */
/* loaded from: classes.dex */
public abstract class jj<P extends a> extends je<ky, P> {
    protected com.badlogic.gdx.utils.a<v.b<String, me>> a;
    protected a b;

    public abstract me a(jy jyVar, P p);

    public void a(jb jbVar, String str, jy jyVar, P p) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.je
    public /* bridge */ /* synthetic */ void a(jb jbVar, String str, jy jyVar, iz izVar) {
        a(jbVar, str, jyVar, (jy) ((a) izVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.je
    public /* bridge */ /* synthetic */ ky b(jb jbVar, String str, jy jyVar, iz izVar) {
        return b(jbVar, str, jyVar, (jy) ((a) izVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.jd
    public /* synthetic */ com.badlogic.gdx.utils.a getDependencies(String str, jy jyVar, iz izVar) {
        return a(str, jyVar, (jy) ((a) izVar));
    }

    public jj(jh jhVar) {
        super(jhVar);
        this.a = new com.badlogic.gdx.utils.a<>();
        this.b = new a();
    }

    public ky a(jy jyVar, np npVar, P p) {
        me a2 = a(jyVar, p);
        if (a2 == null) {
            return null;
        }
        return new ky(a2, npVar);
    }

    public ky a(jy jyVar) {
        return a(jyVar, new np.b(), (np.b) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, me] */
    public com.badlogic.gdx.utils.a<ix> a(String str, jy jyVar, P p) {
        com.badlogic.gdx.utils.a<ix> aVar = new com.badlogic.gdx.utils.a<>();
        ?? a2 = a(jyVar, p);
        if (a2 == 0) {
            return aVar;
        }
        v.b<String, me> bVar = new v.b<>();
        bVar.a = str;
        bVar.b = a2;
        synchronized (this.a) {
            this.a.a((com.badlogic.gdx.utils.a<v.b<String, me>>) bVar);
        }
        js.b bVar2 = p != null ? p.a : this.b.a;
        Iterator<mf> it = a2.d.iterator();
        while (it.hasNext()) {
            mf next = it.next();
            if (next.i != null) {
                Iterator<mm> it2 = next.i.iterator();
                while (it2.hasNext()) {
                    aVar.a((com.badlogic.gdx.utils.a<ix>) new ix(it2.next().b, ko.class, bVar2));
                }
            }
        }
        return aVar;
    }

    public ky b(jb jbVar, String str, jy jyVar, P p) {
        me meVar;
        synchronized (this.a) {
            meVar = null;
            for (int i = 0; i < this.a.b; i++) {
                if (this.a.a(i).a.equals(str)) {
                    meVar = this.a.a(i).b;
                    this.a.b(i);
                }
            }
        }
        if (meVar == null) {
            return null;
        }
        ky kyVar = new ky(meVar, new np.a(jbVar));
        Iterator<g> it = kyVar.a().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ko) {
                it.remove();
            }
        }
        return kyVar;
    }

    /* compiled from: ModelLoader.java */
    /* renamed from: jj$a */
    /* loaded from: classes.dex */
    public static class a extends iz<ky> {
        public js.b a = new js.b();

        public a() {
            js.b bVar = this.a;
            ko.a aVar = ko.a.Linear;
            bVar.f = aVar;
            bVar.e = aVar;
            js.b bVar2 = this.a;
            ko.b bVar3 = ko.b.Repeat;
            bVar2.h = bVar3;
            bVar2.g = bVar3;
        }
    }
}
