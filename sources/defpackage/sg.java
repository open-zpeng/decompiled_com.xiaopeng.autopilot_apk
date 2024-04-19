package defpackage;

import com.badlogic.gdx.math.p;
/* compiled from: AntiCollisionPillarEntity.java */
/* renamed from: sg  reason: default package */
/* loaded from: classes.dex */
public class sg extends sl {
    @Override // defpackage.sl
    public void a(float f) {
    }

    @Override // defpackage.sl
    public void e() {
    }

    @Override // defpackage.sl
    public void f() {
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        this.J = "model/anti_collision_pillar/anti_collision_pillar_red.g3db";
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        if (this.L != null) {
            kzVar.a(this.L);
        }
    }

    @Override // defpackage.sl, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        super.a(kzVar, kwVar);
    }

    @Override // defpackage.sl, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.L = null;
        this.f = null;
        this.e = null;
    }

    @Override // defpackage.sl
    public boolean a(p pVar) {
        return (this.e != null ? pVar.d(this.e) : 0.0f) < 11.5f;
    }
}
