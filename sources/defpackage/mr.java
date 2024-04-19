package defpackage;

import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.m;
import com.badlogic.gdx.utils.o;
import com.badlogic.gdx.utils.q;
import com.badlogic.gdx.utils.v;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import java.util.Iterator;
/* compiled from: ResourceData.java */
/* renamed from: mr  reason: default package */
/* loaded from: classes.dex */
public class mr<T> implements o.c {
    public T b;
    private v<String, b> c = new v<>();
    private com.badlogic.gdx.utils.a<b> d = new com.badlogic.gdx.utils.a<>(true, 3, b.class);
    com.badlogic.gdx.utils.a<a> a = new com.badlogic.gdx.utils.a<>();
    private int e = 0;

    /* compiled from: ResourceData.java */
    /* renamed from: mr$b */
    /* loaded from: classes.dex */
    public static class b implements o.c {
        protected mr c;
        v<String, Object> a = new v<>();
        m b = new m();
        private int d = 0;

        @Override // com.badlogic.gdx.utils.o.c
        public void a(o oVar, q qVar) {
            this.a = (v) oVar.a(Constants.DATA, v.class, qVar);
            this.b.a((int[]) oVar.a("indices", int[].class, qVar));
        }
    }

    /* compiled from: ResourceData.java */
    /* renamed from: mr$a */
    /* loaded from: classes.dex */
    public static class a<T> implements o.c {
        public String a;
        public Class<T> b;

        @Override // com.badlogic.gdx.utils.o.c
        public void a(o oVar, q qVar) {
            this.a = (String) oVar.a("filename", String.class, qVar);
            String str = (String) oVar.a("type", String.class, qVar);
            try {
                this.b = qu.a(str);
            } catch (qx e) {
                throw new k("Class not found: " + str, e);
            }
        }
    }

    public com.badlogic.gdx.utils.a<a> a() {
        return this.a;
    }

    @Override // com.badlogic.gdx.utils.o.c
    public void a(o oVar, q qVar) {
        this.c = (v) oVar.a("unique", v.class, qVar);
        v.a<String, b> it = this.c.c().iterator();
        while (it.hasNext()) {
            ((b) it.next().b).c = this;
        }
        this.d = (com.badlogic.gdx.utils.a) oVar.a(Constants.DATA, (Class<Object>) com.badlogic.gdx.utils.a.class, b.class, qVar);
        Iterator<b> it2 = this.d.iterator();
        while (it2.hasNext()) {
            it2.next().c = this;
        }
        this.a.a((com.badlogic.gdx.utils.a) oVar.a("assets", (Class<Object>) com.badlogic.gdx.utils.a.class, a.class, qVar));
        this.b = (T) oVar.a("resource", (Class<Object>) null, qVar);
    }
}
