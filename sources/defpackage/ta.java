package defpackage;

import android.util.Log;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.Iterator;
/* compiled from: ApRampEntity.java */
/* renamed from: ta  reason: default package */
/* loaded from: classes.dex */
public class ta extends aci {
    Animation<ko> a;
    Animation<ko> b;
    int c = 29;
    float d = 0.0695f;
    ko[] e;
    ko[] f;
    int g;
    float h;
    ko[] i;
    volatile boolean j;
    boolean k;
    float l;
    private boolean m;

    public ta() {
        int i = this.c;
        this.e = new ko[i];
        this.f = new ko[i];
        this.g = 37;
        this.h = 0.081f;
        this.i = new ko[this.g];
        this.j = true;
        this.k = false;
        this.l = 0.0f;
        this.m = false;
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        g();
    }

    private void g() {
        PerformanceTestUnit.logStart("ApRampEntity1");
        for (int i = 0; i < this.c; i++) {
            in inVar = io.e;
            ko koVar = new ko(inVar.internal("material/animation/ramp/day/" + (String.format("pass_ramp_%03d", Integer.valueOf(i)) + ".png")));
            Log.d("ApRampEntity1", "texture name = " + koVar);
            this.e[i] = koVar;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            in inVar2 = io.e;
            ko koVar2 = new ko(inVar2.internal("material/animation/ramp/night/" + (String.format("pass_ramp_%03d", Integer.valueOf(i2)) + ".png")));
            Log.d("ApRampEntity1", "night texture name = " + koVar2);
            this.f[i2] = koVar2;
        }
        this.a = new Animation<>(this.d, this.e);
        this.a.setPlayMode(Animation.PlayMode.NORMAL);
        this.b = new Animation<>(this.d, this.f);
        this.b.setPlayMode(Animation.PlayMode.NORMAL);
        PerformanceTestUnit.logEnd("ApRampEntity1", "createAnination.apReady");
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.L != null && this.j && this.m) {
            this.M.c();
            this.M.f(0.98f, 1.0f, 1.4f);
            this.L.f.c();
            this.L.f.b(this.M);
            this.l += io.b.getDeltaTime();
            a(this.l);
            kzVar.a(this.L);
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }

    public void e() {
        Log.i("ApRampEntity1", "onLoaded");
        if ((this.L == null || this.K == null) && C().an().c("model/virtual/load_animation.g3db")) {
            this.K = (ky) C().an().a("model/virtual/load_animation.g3db");
            this.L = new la(this.K);
            this.m = true;
            ThemeWatcher.getInstance().isNight();
        }
    }

    private void a(float f) {
        ko keyFrame;
        if (this.a.getKeyFrameIndex(f) == this.c - 1) {
            this.k = true;
        }
        if (ThemeWatcher.getInstance().isNight()) {
            keyFrame = this.b.getKeyFrame(f, true);
        } else {
            keyFrame = this.a.getKeyFrame(f, true);
        }
        this.L.b.a(0).a(ln.a(keyFrame));
        le leVar = new le(770, 771);
        leVar.f = 1.0f;
        Iterator<kx> it = k_().b.iterator();
        while (it.hasNext()) {
            it.next().a(leVar);
        }
    }

    public void f() {
        this.k = false;
        this.j = true;
        this.l = 0.0f;
    }
}
