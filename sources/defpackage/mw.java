package defpackage;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.i;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.m;
import com.badlogic.gdx.utils.n;
/* compiled from: BaseShader.java */
/* renamed from: mw  reason: default package */
/* loaded from: classes.dex */
public abstract class mw implements ld {
    public q a;
    public nk b;
    public jz c;
    private int[] g;
    private kj k;
    private final com.badlogic.gdx.utils.a<String> d = new com.badlogic.gdx.utils.a<>();
    private final com.badlogic.gdx.utils.a<e> e = new com.badlogic.gdx.utils.a<>();
    private final com.badlogic.gdx.utils.a<c> f = new com.badlogic.gdx.utils.a<>();
    private final m h = new m();
    private final m i = new m();
    private final n j = new n();
    private final m l = new m();
    private kv m = new kv();

    /* compiled from: BaseShader.java */
    /* renamed from: mw$a */
    /* loaded from: classes.dex */
    public static abstract class a implements c {
        @Override // defpackage.mw.c
        public boolean a(mw mwVar, int i) {
            return true;
        }
    }

    /* compiled from: BaseShader.java */
    /* renamed from: mw$b */
    /* loaded from: classes.dex */
    public static abstract class b implements c {
        @Override // defpackage.mw.c
        public boolean a(mw mwVar, int i) {
            return false;
        }
    }

    /* compiled from: BaseShader.java */
    /* renamed from: mw$c */
    /* loaded from: classes.dex */
    public interface c {
        void a(mw mwVar, int i, lb lbVar, kv kvVar);

        boolean a(mw mwVar, int i);
    }

    /* compiled from: BaseShader.java */
    /* renamed from: mw$e */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(mw mwVar, int i, lb lbVar);
    }

    /* compiled from: BaseShader.java */
    /* renamed from: mw$d */
    /* loaded from: classes.dex */
    public static class d implements e {
        public final String a;
        public final long b;
        public final long c;
        public final long d;

        public d(String str, long j, long j2, long j3) {
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = j3;
        }

        public d(String str, long j, long j2) {
            this(str, j, j2, 0L);
        }

        public d(String str, long j) {
            this(str, 0L, 0L, j);
        }

        public d(String str) {
            this(str, 0L, 0L);
        }

        @Override // defpackage.mw.e
        public boolean a(mw mwVar, int i, lb lbVar) {
            long j = 0;
            long b = (lbVar == null || lbVar.c == null) ? 0L : lbVar.c.b();
            if (lbVar != null && lbVar.d != null) {
                j = lbVar.d.b();
            }
            long j2 = this.b;
            if ((b & j2) == j2) {
                long j3 = this.c;
                if ((j & j3) == j3) {
                    long j4 = j | b;
                    long j5 = this.d;
                    if ((j4 & j5) == j5) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public int a(String str, e eVar, c cVar) {
        if (this.g != null) {
            throw new k("Cannot register an uniform after initialization");
        }
        int a2 = a(str);
        if (a2 >= 0) {
            this.e.a(a2, (int) eVar);
            this.f.a(a2, (int) cVar);
            return a2;
        }
        this.d.a((com.badlogic.gdx.utils.a<String>) str);
        this.e.a((com.badlogic.gdx.utils.a<e>) eVar);
        this.f.a((com.badlogic.gdx.utils.a<c>) cVar);
        return this.d.b - 1;
    }

    public int a(d dVar, c cVar) {
        return a(dVar.a, dVar, cVar);
    }

    public int a(d dVar) {
        return a(dVar, (c) null);
    }

    public int a(String str) {
        int i = this.d.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.d.a(i2).equals(str)) {
                return i2;
            }
        }
        return -1;
    }

    public void a(q qVar, lb lbVar) {
        if (this.g != null) {
            throw new k("Already initialized");
        }
        if (!qVar.c()) {
            throw new k(qVar.b());
        }
        this.a = qVar;
        int i = this.d.b;
        this.g = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            String a2 = this.d.a(i2);
            e a3 = this.e.a(i2);
            c a4 = this.f.a(i2);
            if (a3 != null && !a3.a(this, i2, lbVar)) {
                this.g[i2] = -1;
            } else {
                this.g[i2] = qVar.a(a2, false);
                if (this.g[i2] >= 0 && a4 != null) {
                    if (a4.a(this, i2)) {
                        this.h.a(i2);
                    } else {
                        this.i.a(i2);
                    }
                }
            }
            if (this.g[i2] < 0) {
                this.e.a(i2, (int) null);
                this.f.a(i2, (int) null);
            }
        }
        if (lbVar != null) {
            kt f = lbVar.b.e.f();
            int a5 = f.a();
            for (int i3 = 0; i3 < a5; i3++) {
                ks b2 = f.b(i3);
                int b3 = qVar.b(b2.f);
                if (b3 >= 0) {
                    this.j.a(b2.g(), b3);
                }
            }
        }
    }

    @Override // defpackage.ld
    public void a(jz jzVar, nk nkVar) {
        this.c = jzVar;
        this.b = nkVar;
        this.a.d();
        this.k = null;
        for (int i = 0; i < this.h.b; i++) {
            com.badlogic.gdx.utils.a<c> aVar = this.f;
            int b2 = this.h.b(i);
            if (aVar.a(b2) != null) {
                this.f.a(b2).a(this, b2, null, null);
            }
        }
    }

    private final int[] a(kt ktVar) {
        this.l.b();
        int a2 = ktVar.a();
        for (int i = 0; i < a2; i++) {
            this.l.a(this.j.b(ktVar.b(i).g(), -1));
        }
        this.l.c();
        return this.l.a;
    }

    @Override // defpackage.ld
    public void b(lb lbVar) {
        if (lbVar.a.f() == 0.0f) {
            return;
        }
        this.m.c();
        if (lbVar.d != null) {
            this.m.a((Iterable<ku>) lbVar.d);
        }
        if (lbVar.c != null) {
            this.m.a((Iterable<ku>) lbVar.c);
        }
        a(lbVar, this.m);
    }

    public void a(lb lbVar, kv kvVar) {
        for (int i = 0; i < this.i.b; i++) {
            com.badlogic.gdx.utils.a<c> aVar = this.f;
            int b2 = this.i.b(i);
            if (aVar.a(b2) != null) {
                this.f.a(b2).a(this, b2, lbVar, kvVar);
            }
        }
        if (this.k != lbVar.b.e) {
            kj kjVar = this.k;
            if (kjVar != null) {
                kjVar.b(this.a, this.l.a);
            }
            this.k = lbVar.b.e;
            this.k.a(this.a, a(lbVar.b.e.f()));
        }
        lbVar.b.a(this.a, false);
    }

    @Override // defpackage.ld
    public void b() {
        kj kjVar = this.k;
        if (kjVar != null) {
            kjVar.b(this.a, this.l.a);
            this.k = null;
        }
        this.a.e();
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.a = null;
        this.d.d();
        this.e.d();
        this.f.d();
        this.i.b();
        this.h.b();
        this.g = null;
    }

    public final boolean a(int i) {
        if (i >= 0) {
            int[] iArr = this.g;
            if (i < iArr.length && iArr[i] >= 0) {
                return true;
            }
        }
        return false;
    }

    public final int b(int i) {
        if (i >= 0) {
            int[] iArr = this.g;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return -1;
    }

    public final boolean a(int i, Matrix4 matrix4) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], matrix4);
        return true;
    }

    public final boolean a(int i, i iVar) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], iVar);
        return true;
    }

    public final boolean a(int i, p pVar) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], pVar);
        return true;
    }

    public final boolean a(int i, ka kaVar) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], kaVar);
        return true;
    }

    public final boolean a(int i, float f) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], f);
        return true;
    }

    public final boolean a(int i, float f, float f2) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], f, f2);
        return true;
    }

    public final boolean a(int i, float f, float f2, float f3, float f4) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], f, f2, f3, f4);
        return true;
    }

    public final boolean a(int i, int i2) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], i2);
        return true;
    }

    public final boolean a(int i, no noVar) {
        int[] iArr = this.g;
        if (iArr[i] < 0) {
            return false;
        }
        this.a.a(iArr[i], this.b.a.a(noVar));
        return true;
    }
}
