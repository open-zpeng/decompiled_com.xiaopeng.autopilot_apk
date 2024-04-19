package defpackage;

import com.badlogic.gdx.utils.o;
import com.badlogic.gdx.utils.v;
import defpackage.mr;
import java.util.Iterator;
/* compiled from: ParticleEffectLoader.java */
/* renamed from: mq  reason: default package */
/* loaded from: classes.dex */
public class mq extends je<mp, a> {
    protected com.badlogic.gdx.utils.a<v.b<String, mr<mp>>> a;

    /* compiled from: ParticleEffectLoader.java */
    /* renamed from: mq$a */
    /* loaded from: classes.dex */
    public static class a extends iz<mp> {
        com.badlogic.gdx.utils.a<ms<?>> a;
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
    }

    public mq(jh jhVar) {
        super(jhVar);
        this.a = new com.badlogic.gdx.utils.a<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [mr, V] */
    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        com.badlogic.gdx.utils.a<mr.a> a2;
        ?? r0 = (mr) new o().a((Class<Object>) mr.class, jyVar);
        synchronized (this.a) {
            v.b<String, mr<mp>> bVar = new v.b<>();
            bVar.a = str;
            bVar.b = r0;
            this.a.a((com.badlogic.gdx.utils.a<v.b<String, mr<mp>>>) bVar);
            a2 = r0.a();
        }
        com.badlogic.gdx.utils.a<ix> aVar2 = new com.badlogic.gdx.utils.a<>();
        Iterator<mr.a> it = a2.iterator();
        while (it.hasNext()) {
            mr.a next = it.next();
            if (!resolve(next.a).exists()) {
                next.a = jyVar.parent().child(io.e.internal(next.a).name()).path();
            }
            if (next.b == mp.class) {
                aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(next.a, next.b, aVar));
            } else {
                aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(next.a, next.b));
            }
        }
        return aVar2;
    }

    @Override // defpackage.je
    public mp b(jb jbVar, String str, jy jyVar, a aVar) {
        mr<mp> mrVar;
        synchronized (this.a) {
            int i = 0;
            while (true) {
                if (i >= this.a.b) {
                    mrVar = null;
                    break;
                }
                v.b<String, mr<mp>> a2 = this.a.a(i);
                if (a2.a.equals(str)) {
                    mrVar = a2.b;
                    this.a.b(i);
                    break;
                }
                i++;
            }
        }
        mrVar.b.a(jbVar, mrVar);
        if (aVar != null) {
            if (aVar.a != null) {
                Iterator<ms<?>> it = aVar.a.iterator();
                while (it.hasNext()) {
                    it.next().a(jbVar, mrVar);
                }
            }
            mrVar.b.a(aVar.a);
        }
        return mrVar.b;
    }
}
