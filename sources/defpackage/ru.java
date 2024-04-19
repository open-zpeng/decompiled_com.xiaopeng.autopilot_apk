package defpackage;
/* compiled from: DynaAllGuidelineEntityPro.java */
/* renamed from: ru  reason: default package */
/* loaded from: classes.dex */
public class ru extends rv {
    private static final float n = uc.c * 1.15f;
    public static final float a = uc.c * 0.18f;

    @Override // defpackage.aci
    public void a(kz kzVar) {
        if (this.L != null) {
            kzVar.a(this.L);
        }
    }

    @Override // defpackage.rv, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        super.a(kzVar, kwVar);
    }

    @Override // defpackage.rv, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (k_() != null) {
            k_().e.dispose();
            this.L = null;
        }
    }
}
