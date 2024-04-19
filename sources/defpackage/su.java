package defpackage;

import com.badlogic.gdx.utils.aq;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
/* compiled from: SpeedBumpEntity.java */
/* renamed from: su  reason: default package */
/* loaded from: classes.dex */
public class su extends sl {
    private static String g = "SpeedBumpEntity";

    @Override // defpackage.sl
    public void a(float f) {
    }

    public su() {
        this.J = "model/speedbump/speed_bump.g3db";
    }

    @Override // defpackage.sl, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.L = null;
        this.f = null;
        this.e = null;
    }

    @Override // defpackage.sl
    public void k() {
        if (this.L == null || this.K == null) {
            aca an = C().an();
            if (an.c(this.J)) {
                this.K = (ky) C().an().a(this.J);
                this.L = new la(this.K);
                this.a = true;
                return;
            }
            this.K = new lu(new aq()).a(io.e.internal(this.J));
            this.L = new la(this.K);
            an.a(this.J, (Class<Class>) ky.class, (Class) this.K);
            this.a = true;
            PerformanceTestUnit.log(g + "_onloaded", "unloaded so init and put it to manager", true);
        }
    }
}
