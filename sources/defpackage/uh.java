package defpackage;

import android.util.Log;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import defpackage.km;
/* compiled from: NavRoadEntity.java */
/* renamed from: uh  reason: default package */
/* loaded from: classes.dex */
public class uh extends aci {
    public uh() {
        this.J = "model/nav_road/Mesh_AP_RoadSpeed.g3db";
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        C().an().b("model/nav_road/Mesh_AP_RoadSpeed.g3db", ky.class);
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        if (this.L != null) {
            kzVar.a(this.L);
        }
    }

    public void e() {
        aca an = C().an();
        if ((this.L == null || this.K == null) && an.c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            try {
                this.L = new la(this.K);
            } catch (k e) {
                e.printStackTrace();
                Log.e("NavRoadEntity", "init NavRoadEntity error!");
            }
            le leVar = new le(770, 771);
            a<kx> aVar = k_().b;
            try {
                if (aVar.b > 0) {
                    for (int i = 0; i < aVar.b; i++) {
                        aVar.a(i).a(leVar);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(ThemeWatcher.getInstance().isNight());
        }
    }

    private void a(boolean z) {
        LogUtils.i("NavRoadEntity", "updateMaterial isNight:" + z);
        this.L.b.a(0).a(ln.a(C().an().a(z ? "model/nav_road/Tex_AP_RoadSpeed_Night.png" : "model/nav_road/Tex_AP_RoadSpeed.png", km.c.RGBA8888, false)));
    }

    public void a(int i) {
        a(i == 2);
    }
}
