package defpackage;

import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.i;
import com.badlogic.gdx.utils.k;
/* compiled from: ModelBatch.java */
/* renamed from: kz  reason: default package */
/* loaded from: classes.dex */
public class kz implements g {
    protected jz a;
    protected final a b;
    protected final com.badlogic.gdx.utils.a<lb> c;
    protected final nk d;
    protected final nm e;
    protected final nl f;
    private final boolean g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: ModelBatch.java */
    /* renamed from: kz$a */
    /* loaded from: classes.dex */
    public static class a extends i<lb> {
        protected a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.badlogic.gdx.utils.z
        /* renamed from: a */
        public lb newObject() {
            return new lb();
        }

        @Override // com.badlogic.gdx.utils.i, com.badlogic.gdx.utils.z
        /* renamed from: b */
        public lb obtain() {
            lb lbVar = (lb) super.obtain();
            lbVar.d = null;
            lbVar.c = null;
            lbVar.b.a("", null, 0, 0, 0);
            lbVar.f = null;
            lbVar.g = null;
            return lbVar;
        }
    }

    public kz(nk nkVar, nm nmVar, nl nlVar) {
        this.b = new a();
        this.c = new com.badlogic.gdx.utils.a<>();
        this.f = nlVar == null ? new nd() : nlVar;
        this.g = nkVar == null;
        this.d = nkVar == null ? new nk(new nf(1, 1)) : nkVar;
        this.e = nmVar == null ? new ne() : nmVar;
    }

    public kz(nm nmVar) {
        this(null, nmVar, null);
    }

    public kz(String str, String str2) {
        this(null, new ne(str, str2), null);
    }

    public kz() {
        this(null, null, null);
    }

    public void a(jz jzVar) {
        if (this.a != null) {
            throw new k("Call end() first.");
        }
        this.a = jzVar;
        if (this.g) {
            this.d.a();
        }
    }

    public void a() {
        this.f.a(this.a, this.c);
        ld ldVar = null;
        for (int i = 0; i < this.c.b; i++) {
            lb a2 = this.c.a(i);
            if (ldVar != a2.f) {
                if (ldVar != null) {
                    ldVar.b();
                }
                ldVar = a2.f;
                ldVar.a(this.a, this.d);
            }
            ldVar.b(a2);
        }
        if (ldVar != null) {
            ldVar.b();
        }
        this.b.c();
        this.c.d();
    }

    public void b() {
        a();
        if (this.g) {
            this.d.b();
        }
        this.a = null;
    }

    public void a(lc lcVar) {
        lcVar.a(this.c, this.b);
        for (int i = this.c.b; i < this.c.b; i++) {
            lb a2 = this.c.a(i);
            a2.f = this.e.a(a2);
        }
    }

    public void a(lc lcVar, kw kwVar) {
        lcVar.a(this.c, this.b);
        for (int i = this.c.b; i < this.c.b; i++) {
            lb a2 = this.c.a(i);
            a2.d = kwVar;
            a2.f = this.e.a(a2);
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.e.a();
    }
}
