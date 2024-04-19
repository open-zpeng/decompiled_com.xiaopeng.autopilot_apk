package com.xiaopeng.autopilot.parking.view.g3d;
/* compiled from: FixedInterference.java */
/* loaded from: classes.dex */
public abstract class d extends a {
    public static boolean q = true;
    private kz a;
    private kz b;

    abstract void a(kz kzVar, kw kwVar);

    protected abstract void b(kz kzVar, kw kwVar);

    @Override // defpackage.ach, defpackage.acg, defpackage.ik
    public void a() {
        super.a();
        if (ak().f()) {
            aco acoVar = new aco(io.e.internal("shader/vertex.glsl").readString(), io.e.internal("shader/fragment.glsl").readString());
            this.a = new kz(acoVar);
            this.b = new kz(acoVar);
            return;
        }
        String readString = io.e.internal("shader/default.vertex.glsl").readString();
        String readString2 = io.e.internal("shader/default.fragment.glsl").readString();
        this.a = new kz(readString, readString2);
        this.b = new kz(readString, readString2);
    }

    @Override // defpackage.ach
    public void a(com.badlogic.gdx.utils.a<la> aVar) {
        this.a.a(this.P);
        this.b.a(this.P);
        super.a(aVar);
        if (aVar != null) {
            a(this.a, this.ah);
        }
        this.a.b();
        if (aVar != null) {
            b(this.b, this.ah);
        }
        this.b.b();
    }

    @Override // defpackage.ach, defpackage.acg, defpackage.ik
    public void dispose() {
        super.dispose();
        kz kzVar = this.a;
        if (kzVar != null) {
            kzVar.dispose();
        }
        kz kzVar2 = this.b;
        if (kzVar2 != null) {
            kzVar2.dispose();
        }
    }

    public kz T() {
        return this.a;
    }

    public kz U() {
        return this.b;
    }
}
