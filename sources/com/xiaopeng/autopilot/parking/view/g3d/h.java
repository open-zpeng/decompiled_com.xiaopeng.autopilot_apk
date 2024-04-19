package com.xiaopeng.autopilot.parking.view.g3d;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import defpackage.ko;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: Parking3DScene.java */
/* loaded from: classes.dex */
public class h extends d implements com.xiaopeng.autopilot.base.e {
    protected ub A;
    public kw B;
    public kw C;
    public kw D;
    public i E;
    private ug a;
    private uo ak;
    private un al;
    private float am;
    private rk an;
    private long ao;
    private lt b;
    public uf r;
    public up t;
    protected ui u;
    protected ue v;
    protected ul w;
    protected f x;
    protected lt z;
    protected volatile ArrayList<up> s = new ArrayList<>();
    public boolean y = true;
    long F = System.currentTimeMillis();
    int G = 10;
    private List<ul> ap = new ArrayList();
    private SparseArray<ul> aq = new SparseArray<>();
    private SparseArray<ul> ar = new SparseArray<>();
    private l[] as = {new l(), new l()};
    private long at = 0;
    private Runnable au = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.h.1
        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.as = uk.a(hVar.as);
        }
    };

    private void A() {
    }

    private acl G() {
        return null;
    }

    private acl I() {
        return null;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.d
    void a(kz kzVar, kw kwVar) {
    }

    @Override // com.xiaopeng.autopilot.base.e
    public void a_(int i, int i2) {
    }

    public void ae() {
    }

    public void af() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.d
    protected void b(kz kzVar, kw kwVar) {
    }

    @Override // com.xiaopeng.autopilot.base.e
    public void e() {
    }

    @Override // com.xiaopeng.autopilot.base.e
    public void f() {
    }

    @Override // com.xiaopeng.autopilot.base.e
    public void g() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void k() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void l() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void m() {
    }

    public ug V() {
        return this.a;
    }

    public ui W() {
        return this.u;
    }

    @Override // defpackage.ach, defpackage.acg, defpackage.ik
    public void a(int i, int i2) {
        super.a(i, i2);
        int currentTheme = ThemeWatcher.getInstance().getCurrentTheme();
        Log.i("3DSence", "resize mParking3dPresenter = " + this.j + " ; mCurentTheme = " + this.p + " ;theme = " + currentTheme);
        if (this.j != null && this.p != currentTheme) {
            Log.i("3DSence", "performance resize syncEntityesThemeMaterial");
            this.j.n();
        }
        this.p = currentTheme;
        int i3 = this.c;
    }

    public void a(tj tjVar) {
        this.j = tjVar;
    }

    public void a(rk rkVar) {
        this.an = rkVar;
    }

    public h(Context context) {
        this.h = context;
    }

    public void a(f fVar) {
        this.x = fVar;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.d, defpackage.ach, defpackage.acg, defpackage.ik
    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        super.a();
        x();
        w();
        Y();
        E();
        J();
        B();
        C();
        D();
        v();
        F();
        A();
        Log.i("3DSence", "StartPerformance.create:\t" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void B() {
        PerformanceTestUnit.logStart("3DSence");
        acl G = G();
        this.D = new kw();
        this.b = new lt();
        this.b.a(0.0f, 12.5f, 0.0f);
        this.b.b(0.0f, -1.0f, 0.0f);
        this.b.b(45.0f);
        this.b.a(0.18359375f, 0.38671875f, 0.94921875f, 1.0f);
        this.b.a(0.25f);
        this.b.c(1.0f);
        kw kwVar = this.D;
        kwVar.d = G;
        kwVar.a(this.b);
        this.D.a(new lf(lf.g, 1.0f, 1.0f, 1.0f, 1.0f));
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initDayEnv");
    }

    private void C() {
        PerformanceTestUnit.logStart("3DSence");
        lq lqVar = new lq();
        lqVar.a(0.0f, -1.0f, 0.5f);
        lqVar.a(0.3f, 0.3f, 0.3f, 1.0f);
        this.B = new kw();
        this.B.a(lqVar);
        this.B.a(new lf(lf.g, 0.60784316f, 0.65882355f, 0.7294118f, 1.0f));
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initItemLight");
    }

    private void D() {
        PerformanceTestUnit.logStart("3DSence");
        lq lqVar = new lq();
        lqVar.a(0.0f, -1.0f, 0.5f);
        lqVar.a(0.3f, 0.3f, 0.3f, 1.0f);
        this.C = new kw();
        this.C.a(lqVar);
        this.C.a(new lf(lf.g, 0.3f, 0.3f, 0.3f, 1.0f));
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initNightItemLight");
    }

    protected void x() {
        this.P.m = 37.0f;
        this.P.h = 3.0f;
        this.P.i = 180.0f;
        this.P.a.a(0.0f, 23.039999f, 0.0f);
        this.P.a();
    }

    @Override // defpackage.ach, defpackage.acg, defpackage.ik
    public void o_() {
        super.o_();
        Log.i("3DSence", "resume");
    }

    @Override // defpackage.ach, defpackage.acg, defpackage.ik
    public void p_() {
        super.p_();
        Log.i("3DSence", "pause");
    }

    public uf X() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        ak().b(true);
        ak().a(false);
        ak().c(false);
        ak().g(false);
        ak().f(false);
        ak().e(false);
        ak().d(false);
    }

    protected void Y() {
        PerformanceTestUnit.logStart("3DSence");
        Log.i("3DSence", "initModels");
        ao();
        this.r = com.xiaopeng.autopilot.parking.c.a((ach) this);
        this.r.h(false);
        this.r.a();
        this.a = new ug();
        this.a.a(this);
        this.a.a();
        an().b("model/entity/jiaoche.g3db", ky.class);
        an().b("model/entity/kebochewei.g3db", ky.class);
        an().b("model/entity/kebochewei_Lateral.g3db", ky.class);
        an().b("model/entity/weizhichewei.g3db", ky.class);
        an().b("model/entity/weizhichewei_Lateral.g3db", ky.class);
        an().b("model/entity/xuanzhongchewei.g3db", ky.class);
        an().b("model/entity/xuanzhongchewei_Lateral.g3db", ky.class);
        an().b("model/entity/p_icon.g3db", ky.class);
        an().b("model/entity/p_icon_yellow.g3db", ky.class);
        an().b("model/entity/p_icon_gray.g3db", ky.class);
        an().b("model/entity/model_one.g3db", ky.class);
        an().b("model/entity/model_two.g3db", ky.class);
        an().b("model/entity/model_three.g3db", ky.class);
        an().b("model/entity/model_four.g3db", ky.class);
        an().b("model/entity/model_five.g3db", ky.class);
        an().b("model/entity/model_six.g3db", ky.class);
        this.A = new ub();
        this.A.a();
        this.ak = new uo();
        this.ak.a();
        this.ak.a(this);
        this.al = new un();
        this.al.a();
        this.al.a(this);
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initModels");
    }

    private void E() {
        PerformanceTestUnit.logStart("3DSence");
        an().b("model/entity/P_dot.png", ko.class);
        an().b("material/P_dot.png", ko.class);
        an().b("model/entity/night_gray.png", ko.class);
        an().b("model/entity/day_gray.png", ko.class);
        an().b("model/entity/d55_shadow.png", ko.class);
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initTexture");
    }

    private void F() {
        PerformanceTestUnit.logStart("3DSence");
        if (this.j != null && (this.j instanceof tr)) {
            ((tr) this.j).M();
        }
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initChangeCameraAnimation");
    }

    private void J() {
        PerformanceTestUnit.logStart("3DSence");
        acl I = I();
        this.z = new lt();
        this.z.a(0.0f, 12.5f, 0.0f);
        this.z.b(0.0f, -1.0f, 0.0f);
        this.z.b(45.0f);
        this.z.a(0.05078125f, 0.12109375f, 0.24609375f, 1.0f);
        this.z.a(1.8f);
        this.z.c(1.0f);
        this.ah.d = I;
        this.ah.a(this.z);
        this.ah.a(new lf(lf.g, 1.0f, 1.0f, 1.0f, 1.0f));
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initNightEnv");
    }

    protected void v() {
        PerformanceTestUnit.logStart("3DSence");
        this.v = new ue();
        this.v.a();
        this.w = new ul();
        this.w.a();
        this.u = new ui();
        this.u.a();
        PerformanceTestUnit.logEnd("3DSence", "StartPerformance.initEntity");
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void h() {
        K();
        for (ul ulVar : this.ap) {
            if (ulVar != null) {
                ulVar.a(this.L, this.ah);
            }
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void a(p pVar, float f, Matrix4 matrix4) {
        uf ufVar = this.r;
        if (ufVar == null || !ufVar.g()) {
            return;
        }
        this.r.a(this.L);
    }

    private void K() {
        l[] lVarArr;
        uf ufVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.at > 100) {
            this.at = currentTimeMillis;
            this.ap.clear();
            rh.a().a(this.au);
            l[] lVarArr2 = this.as;
            if (lVarArr2 == null) {
                return;
            }
            l lVar = lVarArr2[0];
            l lVar2 = lVarArr2[1];
            p pVar = null;
            if (this.j != null && (ufVar = this.r) != null) {
                pVar = ufVar.i();
            }
            for (int i = 0; i < vb.a.length; i++) {
                ul ulVar = this.aq.get(i);
                if (ulVar == null) {
                    ulVar = new ul();
                    ulVar.a(i);
                    this.aq.put(i, ulVar);
                }
                ulVar.a(lVar);
                ulVar.e();
                if (lVar.a() != null) {
                    float a = lVar.a().a(i);
                    if (i == 0 || i == 5) {
                        if (a > 60.0f) {
                        }
                        ulVar.a(a);
                        ulVar.a(pVar);
                        this.ap.add(ulVar);
                    } else if (i == 1 || i == 4) {
                        if (a > 100.0f) {
                        }
                        ulVar.a(a);
                        ulVar.a(pVar);
                        this.ap.add(ulVar);
                    } else {
                        if ((i == 2 || i == 3) && a > 140.0f) {
                        }
                        ulVar.a(a);
                        ulVar.a(pVar);
                        this.ap.add(ulVar);
                    }
                }
            }
            for (int i2 = 0; i2 < vb.a.length; i2++) {
                ul ulVar2 = this.ar.get(i2);
                if (ulVar2 == null) {
                    ulVar2 = new ul();
                    ulVar2.a(i2);
                    this.ar.put(i2, ulVar2);
                }
                ulVar2.a(lVar2);
                ulVar2.e();
                if (lVar2.a() != null) {
                    float a2 = lVar2.a().a((vb.a.length - 1) - i2);
                    if (i2 == 0 || i2 == 5) {
                        if (a2 > 60.0f) {
                        }
                        ulVar2.a(a2);
                        ulVar2.a(pVar);
                        this.ap.add(ulVar2);
                    } else if (i2 == 1 || i2 == 4) {
                        if (a2 > 100.0f) {
                        }
                        ulVar2.a(a2);
                        ulVar2.a(pVar);
                        this.ap.add(ulVar2);
                    } else {
                        if ((i2 == 2 || i2 == 3) && a2 > 140.0f) {
                        }
                        ulVar2.a(a2);
                        ulVar2.a(pVar);
                        this.ap.add(ulVar2);
                    }
                }
            }
            rk rkVar = this.an;
            if (rkVar == null || (lVarArr = this.as) == null) {
                return;
            }
            rkVar.a(lVarArr[0].e(), this.as[1].e(), this.as[0].c(), this.as[1].c());
        }
    }

    private void a(ArrayList<up> arrayList) {
        if (arrayList == null) {
            return;
        }
        up upVar = null;
        int i = -1;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            up upVar2 = arrayList.get(i2);
            if (upVar2 instanceof uu) {
                i = i2;
                upVar = upVar2;
            }
        }
        if (i == -1) {
            return;
        }
        arrayList.set(arrayList.size() - 1, upVar);
        arrayList.set(i, arrayList.get(arrayList.size() - 1));
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void a(boolean z) {
        ArrayList<up> j;
        if (this.j.o() && (j = this.j.j()) != null) {
            a(j);
            Iterator<up> it = j.iterator();
            while (it.hasNext()) {
                up next = it.next();
                if (next instanceof uu) {
                    this.t = next;
                }
                if (next instanceof um) {
                    ((um) next).a(this.L, this.L, this.P);
                } else {
                    next.a(this.L);
                }
            }
            this.s.addAll(j);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void i() {
        ArrayList<uj> k = this.j.k();
        if (k == null) {
            return;
        }
        if (this.c == 1 || this.c == 2 || this.c == 3 || this.c == 4 || this.c == 9) {
            this.j.a(k, ThemeWatcher.getInstance().isNight() ? 0.8f : 0.93f, false);
        }
        Iterator<uj> it = k.iterator();
        while (it.hasNext()) {
            uj next = it.next();
            if (ThemeWatcher.getInstance().isNight()) {
                next.a(this.L, this.C);
            } else {
                next.a(this.L, this.B);
            }
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void j() {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        if (this.a != null) {
            if (this.c == 0 || this.c == 6 || this.c == 6) {
                this.a.a(this.L, (kw) null);
            } else if (isNight) {
                this.a.a(this.L, this.ah);
            } else {
                this.a.a(this.L, this.D);
            }
        }
        if (this.u != null) {
            this.u.a(this.L, isNight ? this.ah : null, this.c, aa());
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void p() {
        ub ubVar = this.A;
        if (ubVar != null) {
            ubVar.a(this.L, (kw) null);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void q() {
        if (this.am <= 0.0f || ((i.u) com.xiaopeng.autopilot.base.i.a(i.u.class)).d().intValue() == 3) {
            this.ak.g();
            return;
        }
        uo uoVar = this.ak;
        if (uoVar != null) {
            uoVar.a(this.L, (kw) null);
        }
    }

    public uo Z() {
        return this.ak;
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void s() {
        up upVar;
        un unVar = this.al;
        if (unVar == null || (upVar = this.t) == null) {
            return;
        }
        unVar.a(upVar.u());
        this.al.a(this.L, (kw) null);
    }

    public up aa() {
        return this.t;
    }

    private void ap() {
        this.s.clear();
    }

    public boolean ab() {
        int intValue = ((i.ae) com.xiaopeng.autopilot.base.i.a(i.ae.class)).d().intValue();
        if (this.l != this.c) {
            return true;
        }
        if (intValue == this.c) {
            Log.i("3DSence", "isSenceChange.unConsumeType = " + intValue);
            com.xiaopeng.autopilot.base.i.a(i.ae.class, 10086);
            return true;
        }
        return false;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a, defpackage.ach
    protected void a(kz kzVar, com.badlogic.gdx.utils.a<la> aVar) {
        if ((this.j != null ? this.j.t() : false) && io.a.getGraphics().getDeltaTime() * 1000.0f < 40.0f) {
            long currentTimeMillis = System.currentTimeMillis() - this.ao;
            if (currentTimeMillis > 0 && currentTimeMillis < 40) {
                try {
                    Thread.sleep(40 - currentTimeMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        uf ufVar = this.r;
        if (ufVar == null || ufVar.k_() == null || !this.r.g()) {
            if (this.l != this.c) {
                this.l = this.c;
                com.xiaopeng.autopilot.base.i.a(i.ae.class, Integer.valueOf(this.c));
                return;
            }
            return;
        }
        ap();
        ah();
        z();
        this.ao = System.currentTimeMillis();
    }

    public void z() {
        if (this.j.o()) {
            switch (this.c) {
                case 0:
                case 10:
                    this.j.a();
                    break;
                case 1:
                    this.j.f();
                    break;
                case 2:
                    this.j.b();
                    break;
                case 3:
                    this.j.d();
                    break;
                case 4:
                    this.j.e();
                    break;
                case 6:
                    this.j.g();
                    break;
                case 7:
                    this.j.h();
                    break;
                case 8:
                    this.j.i();
                    break;
                case 9:
                    this.j.c();
                    break;
            }
            aq();
            this.P.a();
        }
    }

    private void aq() {
        if (ab()) {
            if (this.c != 6) {
                this.y = true;
            }
            this.j.a(this.l, this.c);
            this.l = this.c;
            Log.i("3DSence", "notifysenceChange.mLastDrawType = " + this.l + "," + this.c);
        }
    }

    @Override // defpackage.ach
    protected void a(Batch batch) {
        b(batch);
        c(batch);
    }

    private void b(Batch batch) {
        ko f;
        int i = this.c;
        if (ThemeWatcher.getInstance().isNight()) {
            if (this.c == 0) {
                f = an().f(ug.g);
            } else {
                f = an().f(ug.e);
            }
        } else if (this.c == 0) {
            f = an().f(ug.h);
        } else {
            f = an().f(ug.f);
        }
        if (f != null) {
            float height = f.getHeight();
            f.setFilter(ko.a.Linear, ko.a.Linear);
            f.setFilter(ko.a.Nearest, ko.a.Nearest);
            batch.draw(f, 0.0f, io.b.getHeight() - height, io.b.getWidth(), height);
        }
    }

    private void c(Batch batch) {
        if (this.j == null || !this.j.o()) {
            ko f = an().f(ThemeWatcher.getInstance().isNight() ? ug.i : ug.j);
            if (f != null) {
                batch.draw(f, 0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
            }
        }
    }

    @Override // defpackage.ach, defpackage.acg, defpackage.ik
    public void q_() {
        super.q_();
        i iVar = this.E;
        if (iVar != null) {
            iVar.b();
        }
    }

    @Override // defpackage.ach
    protected void ac() {
        Log.i("3DSence", "initInputController");
        io.d.setInputProcessor(new is(this, aj()));
        this.E = new i(this, this.P);
        io.d.setInputProcessor(new is(this, aj(), this.E));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.g3d.a, defpackage.ach
    public void y() {
        Log.i("performance", "onloaded cost time::\t" + (System.currentTimeMillis() - this.n));
        ul ulVar = this.w;
        if (ulVar != null) {
            ulVar.e();
        }
        ub ubVar = this.A;
        if (ubVar != null) {
            ubVar.f();
        }
        uo uoVar = this.ak;
        if (uoVar != null) {
            uoVar.e();
        }
        un unVar = this.al;
        if (unVar != null) {
            unVar.e();
        }
        i(true);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a
    public void a(tv tvVar) {
        this.k = tvVar;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a, defpackage.ach, defpackage.acg, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        Log.i("3DSence", "touchDown int 3dSence.screenX = " + i + ",screenY = " + i2);
        return super.a(i, i2, i3, i4);
    }

    @Override // defpackage.acg, defpackage.ir, defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        Log.i("3DSence", "touchUp int 3dSence.screenX = " + i + ",screenY = " + i2);
        return super.b(i, i2, i3, i4);
    }

    public void a(int i, int i2, boolean z) {
        ParkLotItem s;
        i iVar;
        Log.i("3DSence", "isTouchedInvalid = " + ad());
        if (ad()) {
            int[] c = c(i, i2);
            int i3 = c[1];
            up i4 = i(i3);
            boolean z2 = c[0] == 1;
            Log.i("3DSence", "resolveTouch.touchIndex = " + i3 + ",entity = " + i4 + ",touched = " + z2);
            if (!z2 || i4 == null || (s = i4.s()) == null) {
                return;
            }
            LogUtils.i("3DSence", "resolveTouch.onClick，点击选中车位 --> " + s.getSlotIndex() + ",entity.getmIndex() = " + i4.x() + ",item.getType() = " + s.getType());
            if (s.getType() == 2) {
                f fVar = this.x;
                if (fVar != null && z) {
                    fVar.b(i4.x(), false);
                }
                if (i4.w()) {
                    e(i4.x());
                }
            } else if (s.getType() != 3 || z || (iVar = this.E) == null || iVar.f()) {
            } else {
                SoundPlayer.getInstance().playSlotOccupy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ad() {
        Log.i("3DSence", "isTouchedInvalid.mDrawType = " + this.c + "," + this.k.e());
        if (this.c != 3 || this.k.e() == 23) {
            return (this.c == -9 && this.k.e() != 23) || this.c == -13;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] c(int i, int i2) {
        int[] iArr = {-1, -1};
        ArrayList<up> v = this.j.v();
        if (v != null && v.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(v);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                up upVar = (up) it.next();
                iArr[1] = upVar.x();
                if (upVar != null && upVar.a(this.P, i, i2) && upVar.w()) {
                    iArr[0] = 1;
                    Log.i("3DSence", "touched index is free:" + upVar.x() + "\tis free:" + upVar.w());
                    return iArr;
                } else if (upVar != null && upVar.a(this.P, i, i2)) {
                    Log.i("3DSence", "touched index is :" + upVar.w() + "," + upVar.x());
                    iArr[0] = 1;
                    return iArr;
                }
            }
        }
        return iArr;
    }

    public up i(int i) {
        ArrayList<up> v = this.j.v();
        if (v != null && v.size() != 0 && v != null && v.size() > 0) {
            Iterator<up> it = v.iterator();
            while (it.hasNext()) {
                up next = it.next();
                if (i == next.x()) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a
    public void d(final int i) {
        io.a.postRunnable(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.h.2
            @Override // java.lang.Runnable
            public void run() {
                Log.i("3DSence", "Parking3DScene.onSurfaceDrawTypeChange.type = " + i + "," + h.this.l);
                h hVar = h.this;
                int i2 = i;
                hVar.c = i2;
                com.xiaopeng.autopilot.base.i.a(i.ad.class, Integer.valueOf(i2));
            }
        });
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(final int i) {
        Log.i("3DSence", "onSwitchTheme change " + i);
        this.m.postRunnable(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.h.3
            @Override // java.lang.Runnable
            public void run() {
                h.this.j.a(i);
            }
        });
        A();
        this.p = i;
    }

    public void j(int i) {
        this.i = i;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a
    public int S() {
        return this.i;
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public jz n() {
        return this.P;
    }

    public void t() {
        Log.i("3DSence", "onAttachedToWindow");
        ae();
    }

    public void u() {
        Log.i("3DSence", "onDetachedFromWindow.mDrawType = " + this.c + "," + this.l);
        uf ufVar = this.r;
        if (ufVar != null && ufVar.h() != null) {
            Log.i("3DSence", "onDetachedFromWindow.mDrivingCar.center = " + this.r.h().c);
        }
        af();
        uf ufVar2 = this.r;
        if (ufVar2 != null && ufVar2.h() != null && this.r.h().c != 0.0f && (this.c == 7 || this.c == 8 || this.c == 10)) {
            this.r.l();
        }
        i iVar = this.E;
        if (iVar != null) {
            iVar.g();
        }
        if (this.c == -6 || this.c == -7 || this.c == 7) {
            this.j.u();
            d(0);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public tn o() {
        return this.k;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a
    public void b(float f) {
        super.b(f);
        this.am = f;
        ui uiVar = this.u;
        if (uiVar != null) {
            uiVar.c(f);
        }
        ub ubVar = this.A;
        if (ubVar != null) {
            ubVar.a(f);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a
    public void e(int i) {
        super.e(i);
        Log.i("3DSence", "onParkLotChoseIndex.index = " + i);
        j(i);
        this.k.a(i);
        re.a().a(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.a, com.xiaopeng.autopilot.parking.view.f
    public void a_(final int i) {
        super.a_(i);
        ui uiVar = this.u;
        if (uiVar != null) {
            uiVar.a(i);
        }
        Log.i("3DSence", "mLastDrawType = " + this.l + ",gearF = " + i);
        if (this.A != null) {
            this.m.postRunnable(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.A.a(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ach
    public void a(float f) {
        uf ufVar = this.r;
        if (ufVar == null || ufVar.g() || !an().c(this.r.j())) {
            return;
        }
        this.r.e();
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void b(boolean z) {
        Log.i("3DSence", "changeCircle.change = " + z + ",mCircleEntity = " + this.ak);
        if (z) {
            uo uoVar = this.ak;
            if (uoVar != null) {
                uoVar.a(this.r.h().c);
                this.ak.f();
                return;
            }
            return;
        }
        uo uoVar2 = this.ak;
        if (uoVar2 != null) {
            uoVar2.g();
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void d(boolean z) {
        Log.i("3DSence", "changeCircleB0.change = " + z + ",mCircleB0Entity = " + this.al);
        if (z) {
            un unVar = this.al;
            if (unVar != null) {
                unVar.f();
                return;
            }
            return;
        }
        un unVar2 = this.al;
        if (unVar2 != null) {
            unVar2.g();
        }
    }

    public int ag() {
        return this.k.e();
    }

    public void ah() {
        if (System.currentTimeMillis() - this.F > this.G * 1000) {
            Log.i("3DSence", "Sence Configuration: " + ak().toString());
            Log.i("3DSence", "render abs");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("position:");
            stringBuffer.append(this.P.a.toString());
            stringBuffer.append("\t");
            stringBuffer.append("direction:");
            stringBuffer.append(this.P.b.toString());
            stringBuffer.append("\t");
            stringBuffer.append("up:");
            stringBuffer.append(this.P.c.toString());
            stringBuffer.append("\t");
            stringBuffer.append("fieldOfView:");
            stringBuffer.append(this.P.m);
            stringBuffer.append("\t");
            stringBuffer.append("mDrawType:");
            stringBuffer.append(this.c);
            stringBuffer.append("\t");
            stringBuffer.append("near:");
            stringBuffer.append(this.P.h);
            stringBuffer.append("\t");
            stringBuffer.append("far:");
            stringBuffer.append(this.P.i);
            stringBuffer.append("\t");
            stringBuffer.append("canPrintLog:");
            stringBuffer.append(com.xiaopeng.autopilot.base.d.f);
            stringBuffer.append("\t");
            if (this.S != null) {
                stringBuffer.append("glProfiler:");
                stringBuffer.append(this.S.d());
                stringBuffer.append("\t");
            }
            if (this.r != null) {
                stringBuffer.append("mDrivingCarEntity:");
                stringBuffer.append(this.r.h());
                stringBuffer.append("\t");
            }
            if (this.u != null) {
                stringBuffer.append("mNetRoadEntity:");
                stringBuffer.append(this.u.H());
                stringBuffer.append("\t");
            }
            Log.i("3DSence", stringBuffer.toString());
            this.F = System.currentTimeMillis();
        }
    }

    public boolean H() {
        return this.j.p();
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void c(boolean z) {
        i iVar = this.E;
        if (iVar != null) {
            iVar.b(z);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public boolean r() {
        i iVar = this.E;
        if (iVar != null) {
            return iVar.f();
        }
        return false;
    }

    public void d(int i, int i2) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.a(i, i2);
        }
    }

    public void ai() {
        un unVar = this.al;
        if (unVar != null) {
            unVar.a(this.r.h().c - 4.5f);
        }
        d(true);
    }
}
