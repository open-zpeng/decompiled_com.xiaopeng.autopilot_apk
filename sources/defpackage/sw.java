package defpackage;

import com.xiaopeng.autopilot.parking.view.g3d.d;
/* compiled from: TrafficConesEntity.java */
/* renamed from: sw  reason: default package */
/* loaded from: classes.dex */
public class sw extends sl {
    @Override // defpackage.sl
    public void a(float f) {
    }

    public sw() {
        this.J = "model/traffic_cones/traffic_cones.g3db";
        this.b = "mat_zixingche_shadow";
    }

    @Override // defpackage.sl, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (d.q) {
            kzVar = ((d) C()).U();
        }
        if (this.L != null) {
            kzVar.a(this.L);
        }
    }
}
