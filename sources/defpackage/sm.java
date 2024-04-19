package defpackage;
/* compiled from: GateEntity.java */
/* renamed from: sm  reason: default package */
/* loaded from: classes.dex */
public class sm extends sl {
    private mz g;

    @Override // defpackage.sl
    public void a(float f) {
    }

    public sm() {
        this.J = "model/gate/gate.g3db";
    }

    @Override // defpackage.sl, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        super.a(kzVar, kwVar);
        if (this.g != null) {
            this.g.a(io.b.getDeltaTime());
        }
    }

    @Override // defpackage.sl
    public void k() {
        super.k();
        if (j()) {
            this.g = new mz(this.L);
        }
    }
}
