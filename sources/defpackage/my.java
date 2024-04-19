package defpackage;

import com.badlogic.gdx.graphics.glutils.q;
import defpackage.mx;
/* compiled from: DepthShader.java */
/* renamed from: my  reason: default package */
/* loaded from: classes.dex */
public class my extends mx {
    private static String aI;
    private static String aJ;
    private static final kv aL = new kv();
    public final int aG;
    public final int aH;
    private final lj aK;

    /* compiled from: DepthShader.java */
    /* renamed from: my$a */
    /* loaded from: classes.dex */
    public static class a extends mx.a {
        public boolean j;
        public float k;

        public a() {
            this.j = false;
            this.k = 0.5f;
            this.h = 1028;
        }

        public a(String str, String str2) {
            super(str, str2);
            this.j = false;
            this.k = 0.5f;
        }
    }

    public static final String e() {
        if (aI == null) {
            aI = io.e.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.vertex.glsl").readString();
        }
        return aI;
    }

    public static final String f() {
        if (aJ == null) {
            aJ = io.e.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.fragment.glsl").readString();
        }
        return aJ;
    }

    public static String a(lb lbVar, a aVar) {
        String a2 = mx.a(lbVar, aVar);
        if (aVar.j) {
            return a2;
        }
        return a2 + "#define PackedDepthFlag\n";
    }

    public my(lb lbVar, a aVar) {
        this(lbVar, aVar, a(lbVar, aVar));
    }

    public my(lb lbVar, a aVar, String str) {
        this(lbVar, aVar, str, aVar.a != null ? aVar.a : e(), aVar.b != null ? aVar.b : f());
    }

    public my(lb lbVar, a aVar, String str, String str2, String str3) {
        this(lbVar, aVar, new q(str + str2, str + str3));
    }

    public my(lb lbVar, a aVar, q qVar) {
        super(lbVar, aVar, qVar);
        c(lbVar);
        this.aG = lbVar.e == null ? 0 : aVar.f;
        int a2 = lbVar.b.e.f().a();
        int i = 0;
        for (int i2 = 0; i2 < a2; i2++) {
            ks b = lbVar.b.e.f().b(i2);
            if (b.a == 64) {
                i |= 1 << b.g;
            }
        }
        this.aH = i;
        this.aK = new lj(lj.c, aVar.k);
    }

    @Override // defpackage.mx, defpackage.mw, defpackage.ld
    public void a(jz jzVar, nk nkVar) {
        super.a(jzVar, nkVar);
    }

    @Override // defpackage.mx, defpackage.mw, defpackage.ld
    public void b() {
        super.b();
    }

    @Override // defpackage.mx, defpackage.ld
    public boolean a(lb lbVar) {
        kv c = c(lbVar);
        if (c.c(le.b)) {
            if ((this.aE & le.b) != le.b) {
                return false;
            }
            if (c.c(ln.b) != ((this.aE & ln.b) == ln.b)) {
                return false;
            }
        }
        boolean z = (lbVar.b.e.f().b() & 64) == 64;
        if (z != (this.aG > 0)) {
            return false;
        }
        if (z) {
            int a2 = lbVar.b.e.f().a();
            int i = 0;
            for (int i2 = 0; i2 < a2; i2++) {
                ks b = lbVar.b.e.f().b(i2);
                if (b.a == 64) {
                    i |= 1 << b.g;
                }
            }
            return i == this.aH;
        }
        return true;
    }

    @Override // defpackage.mx, defpackage.mw
    public void a(lb lbVar, kv kvVar) {
        if (kvVar.c(le.b)) {
            le leVar = (le) kvVar.a(le.b);
            kvVar.b(le.b);
            boolean c = kvVar.c(lj.c);
            if (!c) {
                kvVar.a(this.aK);
            }
            if (leVar.f >= ((lj) kvVar.a(lj.c)).d) {
                super.a(lbVar, kvVar);
            }
            if (!c) {
                kvVar.b(lj.c);
            }
            kvVar.a(leVar);
            return;
        }
        super.a(lbVar, kvVar);
    }

    private static final kv c(lb lbVar) {
        aL.c();
        if (lbVar.d != null) {
            aL.a((Iterable<ku>) lbVar.d);
        }
        if (lbVar.c != null) {
            aL.a((Iterable<ku>) lbVar.c);
        }
        return aL;
    }
}
