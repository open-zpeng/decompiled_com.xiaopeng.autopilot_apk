package defpackage;

import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DynaPartOfGuidelineEntityPro.java */
/* renamed from: rw  reason: default package */
/* loaded from: classes.dex */
public class rw extends rv {
    public static final float a = uc.c * 0.15f;
    private List<p> w = new ArrayList();
    private List<p> x = new ArrayList();
    private float y = 0.0f;
    private p z = new p(0.0f, 1.0f, 0.0f);
    kx n = new kx();
    le o = new le(770, 771);
    nj p = new nj();
    p q = new p();
    p r = new p();
    p s = new p();
    p t = new p();
    p u = new p();
    p v = new p();

    public rw() {
        a(0.11764706f, 0.5647059f, 1.0f, 1.0f);
        b(uc.c * 1.15f);
    }

    @Override // defpackage.rv, defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.L == null || !G()) {
            return;
        }
        kzVar.a(this.L);
    }

    private void a(List<p> list, List<p> list2) {
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        list.clear();
        for (p pVar : list2) {
            list.add(pVar);
        }
    }

    private List b(List<p> list, List<p> list2) {
        if (list == null || list.size() == 0 || list2.size() == 0) {
            return list2;
        }
        if ((list.size() <= 0 || list2.size() <= 0 || (list.get(0).a().d(list2.get(0).a()) <= 6.858721f && list.size() == list2.size())) && list.size() == list2.size()) {
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                list2.set(i, list.get(i).a().b(list2.get(i), io.a.getGraphics().getDeltaTime() / 0.4f));
            }
            return list2;
        }
        return list2;
    }

    @Override // defpackage.rv
    protected List<p> a(List<p> list, int i) {
        this.d.clear();
        if (list != null && list.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 % i == 0 || i3 == list.size() - 1 || i3 == list.size() - 2) {
                    int i4 = i2 + 1;
                    if (i2 > 2) {
                        this.d.add(list.get(i3));
                    }
                    i2 = i4;
                }
            }
        }
        return this.d;
    }

    protected float b(List<p> list, int i) {
        float f = 0.0f;
        if (list == null || list.size() == 0 || list.size() == 1) {
            return 0.0f;
        }
        int i2 = 0;
        while (i2 < i - 1) {
            i2++;
            f += list.get(i2).d(list.get(i2));
        }
        return f;
    }

    private boolean a(List<p> list, float f) {
        float b = b(list, 42) / uc.c;
        boolean z = false;
        if ((b > 3.66f) && f < 7.0f) {
            z = true;
        }
        if (z) {
            PerformanceTestUnit.log("DynaPartOfGuidelineEntityPro_filterSlowDown", "filterSlowDown length:\t" + b + "\tresult:" + z, true);
        }
        return z;
    }

    public la a(List<p> list, aca acaVar, float f) {
        PerformanceTestUnit.logStart("DynaPartOfGuidelineEntityPro");
        p pVar = null;
        if (a(list, f)) {
            this.w.clear();
            this.L = null;
            return null;
        }
        List<p> a2 = a(list, 14);
        float f2 = uc.c;
        b(this.w, a2);
        this.n.a(ln.a(acaVar.f(ThemeWatcher.getInstance().isNight() ? "material/path_night.png" : "material/path_day.png")));
        this.n.a(this.o);
        this.p.a();
        ni a3 = this.p.a("road", 4, 27L, this.n);
        int i = 0;
        p pVar2 = null;
        while (i < a2.size() - 1) {
            p a4 = a2.get(i).a();
            int i2 = i + 1;
            p a5 = a2.get(i2).a();
            this.q.a(a5).c(a4);
            this.q.g(this.z.a());
            this.q.d();
            this.q.a(this.b / 2.0f);
            p pVar3 = this.r;
            if (pVar == null) {
                pVar = a4.a().c(this.q);
            }
            pVar3.a(pVar);
            p pVar4 = this.s;
            if (pVar2 == null) {
                pVar2 = a4.a().b(this.q);
            }
            pVar4.a(pVar2);
            this.t.a(a5).b(this.q);
            this.u.a(a5).c(this.q);
            float f3 = i;
            float size = a2.size() - 1;
            float f4 = f3 / size;
            float f5 = (f3 + 1.0f) / size;
            e().a(this.r);
            e().a(0.0f, f4);
            f().a(this.s);
            f().a(1.0f, f4);
            g().a(this.t);
            g().a(1.0f, f5);
            h().a(this.u);
            h().a(0.0f, f5);
            a3.a(e(), f(), g(), h());
            pVar2 = this.t;
            pVar = this.u;
            i = i2;
        }
        this.L = new la(this.p.b());
        i(true);
        a(this.w, a2);
        PerformanceTestUnit.logEnd("DynaPartOfGuidelineEntityPro", "initModelTexture");
        return this.L;
    }

    @Override // defpackage.rv, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        io.a.postRunnable(new Runnable() { // from class: rw.1
            @Override // java.lang.Runnable
            public void run() {
                if (rw.this.L == null || rw.this.L.e == null) {
                    return;
                }
                rw.this.L.e.dispose();
                rw.this.L = null;
            }
        });
    }
}
