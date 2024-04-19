package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
/* compiled from: CarEntity.java */
@Deprecated
/* renamed from: uc  reason: default package */
/* loaded from: classes.dex */
public abstract class uc extends aci {
    public static float c = 1.4054755f;
    public static float d = 0.0014054755f;
    public static float e = 0.0014054755f;
    public static float f = 0.75f;
    public static float g = 0.71150297f;
    private boolean a = false;
    private boolean b = false;
    Matrix4 h = new Matrix4();
    protected p i = new p(0.0f, 1.0f, 0.0f);
    p j = new p();

    public boolean g() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.a = z;
    }

    public uc() {
    }

    public p h() {
        this.N = D();
        if (this.L != null && this.N == null) {
            this.L.a(this.N);
        }
        if (this.N != null) {
            this.N.a(this.j);
        }
        if (this.j != null && this.L != null && this.L.f != null) {
            this.j.a(this.L.f);
        }
        return this.j;
    }

    public p i() {
        return h();
    }

    public uc(ach achVar, String str) {
        Y = achVar;
        this.J = str;
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        C().an().b(this.J, ky.class);
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.ab) {
            this.Z = F();
            if (this.Z != null) {
                kzVar.a(this.Z);
            }
        }
        if (this.L != null) {
            if (kwVar != null) {
                kzVar.a(this.L, kwVar);
            } else {
                kzVar.a(this.L);
            }
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.K != null) {
            this.K.dispose();
        }
    }
}
