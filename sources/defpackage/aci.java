package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.g;
/* compiled from: BaseEntity.java */
/* renamed from: aci  reason: default package */
/* loaded from: classes.dex */
public abstract class aci implements g, ik {
    protected static ach Y;
    protected String J;
    protected ky K;
    protected la L;
    protected nz N;
    protected nz O;
    protected float P;
    protected float Q;
    protected float R;
    protected la Z;
    private boolean a;
    protected ky aa;
    protected boolean I = true;
    protected Matrix4 M = new Matrix4();
    protected float S = 1.0f;
    protected float T = 1.0f;
    protected float U = 1.0f;
    protected float V = 0.0f;
    protected p W = new p();
    protected p X = new p();
    protected boolean ab = false;
    protected boolean ac = false;
    public p ad = new p(0.0f, 0.0f, 0.0f);
    public Matrix4 ae = new Matrix4();
    public Matrix4 af = new Matrix4();
    public Matrix4 ag = new Matrix4();
    public Matrix4 ah = new Matrix4();
    protected boolean ai = false;
    protected Matrix4 aj = new Matrix4();

    @Override // defpackage.ik
    public void a(int i, int i2) {
    }

    @Override // defpackage.ik
    public void o_() {
    }

    @Override // defpackage.ik
    public void p_() {
    }

    @Override // defpackage.ik
    public void q_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset() {
    }

    public void h(boolean z) {
        this.ab = z;
    }

    public void B() {
        nj njVar = new nj();
        njVar.a();
        kx kxVar = new kx();
        njVar.c().a = "cycle";
        ni a = njVar.a("cycle", 4, 29L, kxVar);
        a.a(ka.A);
        a.a(0.5f, 0.5f, 0.5f, 10, 10);
        this.aa = njVar.b();
        this.Z = new la(this.aa);
    }

    public static ach C() {
        return Y;
    }

    public void a(ach achVar) {
        Y = achVar;
    }

    public void b(String str) {
        this.J = str;
    }

    public nz D() {
        if (this.N == null) {
            this.N = new nz();
        }
        return this.N;
    }

    public nz E() {
        if (this.O == null) {
            this.O = new nz();
        }
        return this.O;
    }

    @Override // defpackage.ik
    public void a() {
        if (this.ab) {
            Log.i("BaseEntity", "create test position model");
            B();
        }
    }

    public la F() {
        if (this.Z == null) {
            B();
        }
        return this.Z;
    }

    public void a(kz kzVar) {
        if (this.ab) {
            this.Z = F();
            la laVar = this.Z;
            if (laVar != null) {
                laVar.f.b(this.ad);
                kzVar.a(this.Z);
            }
        }
        if (this.L == null || !G()) {
            return;
        }
        kzVar.a(this.L);
    }

    public void a(kz kzVar, kw kwVar) {
        if (this.ab) {
            this.Z = F();
            la laVar = this.Z;
            if (laVar != null) {
                kzVar.a(laVar);
            }
        }
        if (this.L == null || !G()) {
            return;
        }
        if (kwVar != null) {
            kzVar.a(this.L, kwVar);
        } else {
            kzVar.a(this.L);
        }
    }

    public la k_() {
        return this.L;
    }

    public boolean G() {
        return this.I;
    }

    public void i(boolean z) {
        this.I = z;
    }

    public void e(float f) {
        this.P = f;
        this.a = true;
    }

    public void f(float f) {
        this.Q = f;
        this.a = true;
    }

    public void g(float f) {
        this.R = f;
        this.a = true;
    }

    public void a(float f, float f2, float f3) {
        this.P = f;
        this.Q = f2;
        this.R = f3;
        this.a = true;
    }

    public p H() {
        return new p(this.P, this.Q, this.R);
    }

    public void b(Matrix4 matrix4) {
        la laVar = this.L;
        if (laVar != null) {
            laVar.f.b(matrix4);
        }
    }

    public boolean a(jz jzVar, int i, int i2) {
        la laVar = this.L;
        if (laVar != null) {
            laVar.a(E());
            oa a = jzVar.a(i, i2);
            this.O.a(this.L.f);
            return com.badlogic.gdx.math.g.a(a, this.O);
        }
        return false;
    }

    public Matrix4 I() {
        return this.aj;
    }

    public void a(p pVar, float f) {
        if (k_() == null) {
            return;
        }
        k_().f.c();
        Matrix4 matrix4 = new Matrix4();
        matrix4.e(pVar.a, pVar.b, pVar.c);
        this.W.a(0.0f, 1.0f, 0.0f);
        this.ag.c();
        this.ag.c(this.W, (float) ((f / 180.0f) * 3.141592653589793d));
        this.ah.c();
        this.ah.b(matrix4);
        this.ah.b(this.ag);
        k_().f.b(this.ah);
        this.aj = this.ah.a();
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        ky kyVar;
        ky kyVar2;
        if (this.L != null && (kyVar2 = this.K) != null) {
            kyVar2.dispose();
        }
        if (!this.ab || (kyVar = this.aa) == null) {
            return;
        }
        kyVar.dispose();
    }

    public void d(Matrix4 matrix4) {
        if (k_() == null) {
            return;
        }
        this.L.f.b(matrix4);
    }

    public void e(Matrix4 matrix4) {
        if (k_() == null) {
            return;
        }
        this.L.f.b(matrix4);
    }
}
