package defpackage;

import android.util.Log;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.Iterator;
/* compiled from: ApReadyEntity.java */
/* renamed from: tb  reason: default package */
/* loaded from: classes.dex */
public class tb extends aci {
    Animation<ko> a;
    Animation<ko> e;
    int b = 36;
    float c = 0.0695f;
    ko[] d = new ko[this.b];
    int f = 37;
    float g = 0.081f;
    ko[] h = new ko[this.f];
    volatile boolean i = true;
    boolean j = false;
    float k = 0.0f;

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        h();
        g();
    }

    private void g() {
        PerformanceTestUnit.logStart("ApReadyEntity");
        for (int i = 0; i < this.b; i++) {
            in inVar = io.e;
            this.d[i] = new ko(inVar.internal("material/animation/apready/day/once/" + (String.format("ap_ready_once_%03d", Integer.valueOf(i)) + ".png")));
        }
        for (int i2 = 0; i2 < this.f; i2++) {
            in inVar2 = io.e;
            this.h[i2] = new ko(inVar2.internal("material/animation/apready/day/round/" + (String.format("ap_ready_round_%03d", Integer.valueOf(this.b + i2 + 1)) + ".png")));
        }
        this.a = new Animation<>(this.c, this.d);
        this.a.setPlayMode(Animation.PlayMode.NORMAL);
        this.e = new Animation<>(this.g, this.h);
        this.e.setPlayMode(Animation.PlayMode.LOOP);
        PerformanceTestUnit.logEnd("ApReadyEntity", "createAnination.apReady");
    }

    private void h() {
        nj njVar = new nj();
        njVar.a();
        kx kxVar = new kx();
        kxVar.a(ln.a(new ko(io.e.internal("material/p_icon_blue.jpg"))));
        njVar.c().a = "rect";
        njVar.a("rect", 4, 29L, kxVar).a(new p(-4.5f, 0.0f, 4.5f), new p(4.5f, 0.0f, 4.5f), new p(4.5f, 0.0f, -4.5f), new p(-4.5f, 0.0f, -4.5f), new p(0.0f, 1.0f, 0.0f));
        this.K = njVar.b();
        this.L = new la(this.K);
        le leVar = new le(770, 771);
        leVar.f = 0.75f;
        this.L.b.a(0).a(new acm(acm.b));
        this.L.b.a(0).a(leVar);
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.L == null || !this.i) {
            return;
        }
        this.M.c();
        this.M.e(0.0f, 0.15f, 0.0f);
        this.L.f.c();
        this.L.f.b(this.M);
        this.k += io.b.getDeltaTime();
        a(this.k);
        kzVar.a(this.L);
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }

    public void e() {
        Log.i("ApReadyEntity", "onLoaded");
        le leVar = new le(770, 771);
        leVar.f = 0.75f;
        this.L.b.a(0).a(new acm(acm.b));
        this.L.b.a(0).a(leVar);
    }

    private void a(float f) {
        ko keyFrame;
        if (!this.j) {
            if (this.a.getKeyFrameIndex(f) == this.b - 1) {
                this.j = true;
            }
            keyFrame = this.a.getKeyFrame(f, false);
        } else {
            keyFrame = this.e.getKeyFrame(f, true);
        }
        this.L.b.a(0).a(ln.a(keyFrame));
        float f2 = ThemeWatcher.getInstance().isNight() ? 0.2f : 1.0f;
        le leVar = new le(770, 771);
        leVar.f = f2;
        Iterator<kx> it = k_().b.iterator();
        while (it.hasNext()) {
            it.next().a(leVar);
        }
    }

    public void f() {
        this.j = false;
        this.i = true;
        this.k = 0.0f;
    }
}
