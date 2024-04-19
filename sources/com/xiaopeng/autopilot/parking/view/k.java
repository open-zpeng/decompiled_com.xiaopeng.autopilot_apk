package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.model.CameraConfig;
import com.xiaopeng.autopilot.parking.model.CameraConfigFactory;
import com.xiaopeng.autopilot.parking.model.TipChangeTaskStack;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: Parking3DSencePro.java */
/* loaded from: classes.dex */
public class k extends com.xiaopeng.autopilot.parking.view.g3d.h implements e {
    public ts a;
    private CameraConfig ak;
    private boolean al;
    private com.xiaopeng.autopilot.parking.view.g3d.e am;
    private td an;
    private tg ao;
    private te ap;
    private tf aq;
    private tb ar;
    private ta as;
    private tc at;
    private float au;
    private uh av;
    private Matrix4 aw;
    public com.xiaopeng.autopilot.parking.view.g3d.c b;

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.base.e
    public void g() {
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.f
    public void i() {
    }

    public k(Context context) {
        super(context);
        this.al = false;
        this.au = 90.0f;
        this.aw = new Matrix4();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public void a(tj tjVar) {
        PerformanceTestUnit.log("Parking3DSencePro", "setParking3dPresenter.mParking3dPresenter = " + tjVar, true);
        super.a(tjVar);
        this.a = (ts) tjVar;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public void t() {
        super.t();
        this.a.al().a(true, null, null);
        ap();
        PerformanceTestUnit.log("Parking3DSencePro", "StartPerformance BaiP onAttachedToWindow", true);
    }

    private void ap() {
        PerformanceTestUnit.log("Parking3DSencePro", "STATIC_MAP_TASK > onAttachedToWindow > executeRunnableTask ", true);
        if (this.a.A().f()) {
            PerformanceTestUnit.log("Parking3DSencePro", "STATIC_MAP_TASK >  onAttachedToWindow > executeRefreshStateMapTask resource ready！", true);
            this.a.am();
        }
        this.a.an();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public void u() {
        super.u();
        this.a.al().a(false, null, null);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.g3d.d, defpackage.ach, defpackage.acg, defpackage.ik
    public void a() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        PerformanceTestUnit.log("Parking3DSencePro", "StartPerformance create", true);
        super.a();
        aq();
        aw();
        ar();
        this.b = (com.xiaopeng.autopilot.parking.view.g3d.c) this.r;
        PerformanceTestUnit.logEnd("Parking3DSencePro", "StartPerformance.create");
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.g3d.a
    public void d(final int i) {
        ts tsVar = this.a;
        boolean ao = tsVar == null ? false : tsVar.ao();
        int intValue = ((i.c) com.xiaopeng.autopilot.base.i.a(i.c.class)).d().intValue();
        Log.i("Parking3DSencePro", "Parking3DSencePro.onSurfaceDrawTypeChange.type = " + i + "," + this.l + "," + ao + "," + intValue);
        if (!ao || i < 0) {
            if ((intValue == 3 || intValue == 7 || intValue == 8 || intValue == 9) && i >= 0 && i != 1) {
                return;
            }
            this.a.A().a(new TipChangeTaskStack.TipChangeInfo(i, this.c, new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.k(i);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        PerformanceTestUnit.log("Parking3DSencePro", "TIPS_TASK Parking3DSencePro.onSurfaceDrawTypeChange.type = " + i + "," + this.l, true);
        this.c = i;
        com.xiaopeng.autopilot.base.i.a(i.ad.class, Integer.valueOf(i));
    }

    private void aq() {
        this.ak = new CameraConfigFactory().getDefaultCamera();
    }

    private void ar() {
        this.am = new com.xiaopeng.autopilot.parking.view.g3d.e();
        this.am.a(this);
        this.am.a();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    protected void v() {
        this.a.A().a(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.2
            @Override // java.lang.Runnable
            public void run() {
                PerformanceTestUnit.logStart("Parking3DSencePro");
                k.this.w = new ul();
                k.this.w.a();
                if (k.this.ar == null) {
                    k.this.ar = new tb();
                    k.this.ar.a();
                    k.this.ar.a(k.this);
                    k.this.ar.e();
                }
                PerformanceTestUnit.logEnd("Parking3DSencePro", "StartPerformance.initEntity");
            }
        }, 0);
    }

    private void as() {
        this.a.A().a(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.3
            @Override // java.lang.Runnable
            public void run() {
                PerformanceTestUnit.logStart("Parking3DSencePro");
                k.this.u = new ui();
                k.this.u.a();
                PerformanceTestUnit.logEnd("Parking3DSencePro", "StartPerformance.loadSearchingTask");
            }
        }, 2);
    }

    private void at() {
        this.a.A().a(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.4
            @Override // java.lang.Runnable
            public void run() {
                PerformanceTestUnit.logStart("Parking3DSencePro");
                k.this.ao();
                k.this.an().b("model/virtual/model_text_ground.g3db", ky.class);
                k.this.an().b("model/virtual/model_text_metre.g3db", ky.class);
                k.this.an().b("model/virtual/model_text_start.g3db", ky.class);
                k.this.an().b("model/virtual/model_text_parking.g3db", ky.class);
                PerformanceTestUnit.logEnd("Parking3DSencePro", "StartPerformance.loadLearningModel");
            }
        }, -2);
    }

    private void au() {
        this.a.A().a(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.5
            @Override // java.lang.Runnable
            public void run() {
                PerformanceTestUnit.logStart("Parking3DSencePro");
                k.this.ao();
                k.this.an().b("model/nav_road/Mesh_AP_RoadSpeed.g3db", ky.class);
                k.this.an().b("model/virtual/load_animation.g3db", ky.class);
                PerformanceTestUnit.logEnd("Parking3DSencePro", "StartPerformance.loadNavModel");
            }
        }, -15);
    }

    private void av() {
        this.a.A().a(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.6
            @Override // java.lang.Runnable
            public void run() {
                k.this.ao();
                PerformanceTestUnit.logStart("Parking3DSencePro");
                k.this.an().b("model/speedbump/speed_bump.g3db", ky.class);
                k.this.an().b("model/anti_collision_pillar/anti_collision_pillar_red.g3db", ky.class);
                k.this.an().b("model/pillar/model_column.g3db", ky.class);
                k.this.an().b("model/bike/zixingche.g3db", ky.class);
                k.this.an().b("model/moto/moto.g3db", ky.class);
                k.this.an().b("model/bus/bus.g3db", ky.class);
                k.this.an().b("model/gate/gate.g3db", ky.class);
                k.this.an().b("model/man/cartoon_man.g3db", ky.class);
                k.this.an().b("model/dog/dog.g3db", ky.class);
                k.this.an().b("model/pika/pika.g3db", ky.class);
                k.this.an().b("model/jiaoche/jiaoche_sr.g3db", ky.class);
                k.this.an().b("model/suv/SUV.g3db", ky.class);
                k.this.an().b("model/huoche/huoche.g3db", ky.class);
                k.this.an().b("model/mpv/MPV.g3db", ky.class);
                k.this.an().b("model/traffic_cones/traffic_cones.g3db", ky.class);
                for (Map.Entry<Integer, String> entry : com.xiaopeng.autopilot.base.g.a.entrySet()) {
                    k.this.an().b(entry.getValue(), ky.class);
                }
                k.this.an().b("model/virtual/load_animation.g3db", ky.class);
                PerformanceTestUnit.logEnd("Parking3DSencePro", "StartPerformance.loadApModelRunnable");
            }
        }, -1);
    }

    private void aw() {
        av();
        as();
        at();
        au();
        an().b("model/start_p/Mesh_Start_Dot.g3db", ky.class);
        an().b("model/entity/star_flag.g3db", ky.class);
        an().b("model/entity/ap_star_flag.g3db", ky.class);
        PerformanceTestUnit.log("Parking3DSencePro", "initModelPro finish", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public void w() {
        super.w();
        ak().a(false);
        ak().b(true);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    protected void x() {
        this.P.m = 37.0f;
        this.P.h = 3.0f;
        this.P.i = 5850.0f;
        this.P.a.a(0.0f, 23.039999f, 0.0f);
        this.P.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, defpackage.ach
    public void a(float f) {
        super.a(f);
        boolean f2 = this.a.A().f();
        PerformanceTestUnit.log("Parking3DSencePro", "onLoadPercentChange:\t" + f + "\tready:" + f2, true);
        if (f2) {
            this.a.am();
            this.a.an();
        }
        tc tcVar = this.at;
        if (tcVar == null || tcVar.h() || !an().c("model/start_p/Mesh_Start_Dot.g3db")) {
            return;
        }
        this.at.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.g3d.a, defpackage.ach
    public void y() {
        super.y();
        this.a.al().a(null, true, true);
        int numManagedTextures = ko.getNumManagedTextures();
        String managedStatus = ko.getManagedStatus();
        PerformanceTestUnit.log("Parking3DSencePro", "StartPerformance onLoaded textureNum:\t" + numManagedTextures + "\tstate:\t" + managedStatus, true);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public void z() {
        PerformanceTestUnit.log(4000L, "is training model:\t" + this.al + "draw type:\t" + this.c, "Parking3DSencePro");
        super.z();
        if (this.A != null && this.c != 1 && this.c != -4 && this.c != -15 && this.c != -16 && this.A.i()) {
            this.A.h();
        }
        switch (this.c) {
            case -16:
            case -15:
                aI();
                break;
            case -14:
                aE();
                break;
            case -13:
                aC();
                break;
            case -12:
                aB();
                break;
            case -11:
                I();
                break;
            case -10:
                K();
                break;
            case -9:
                J();
                break;
            case -8:
                aH();
                break;
            case -7:
                aG();
                break;
            case -6:
                aF();
                break;
            case -5:
                aD();
                break;
            case -4:
                aK();
                break;
            case -3:
            case -1:
                aA();
                break;
            case -2:
                if (this.al) {
                    C();
                    break;
                } else {
                    aL();
                    break;
                }
        }
        ay();
        az();
        l(this.c);
        ax();
    }

    private void ax() {
        if (this.c == -2 && !this.al) {
            this.a.d(2);
        } else {
            this.a.d(1);
        }
    }

    private void ay() {
        TipChangeTaskStack.TipChangeInfo h = this.a.A().h();
        if (h != null) {
            k(h.getCurrentTip());
            PerformanceTestUnit.log("Parking3DSencePro", "TIPS_TASK  popTipChangeStackElement \t" + h.toString(), true);
        }
        this.a.A().i();
    }

    private void az() {
        this.a.A().b();
    }

    private void l(int i) {
        this.a.A().b(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.f
    public void a(boolean z) {
        a((List<up>) this.a.j());
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.g3d.a
    public void b(float f) {
        super.b(f);
        com.xiaopeng.autopilot.base.i.a(i.p.class, Float.valueOf(f));
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.f
    public void a(com.badlogic.gdx.math.p pVar, float f, Matrix4 matrix4) {
        if (!(i.r.e().intValue() == 2)) {
            super.a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        } else {
            this.b.a(this.L, this.ah);
        }
        if (this.ar != null && this.l == -5 && this.c != -5) {
            this.ar.f();
        }
        if (this.as == null || this.l != -14 || this.c == -14) {
            return;
        }
        this.as.f();
    }

    public void A() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        boolean isNight = ThemeWatcher.getInstance().isNight();
        i.r.e().intValue();
        if (this.am != null) {
            if (this.c == -2 && !this.al) {
                this.am.a(this.L, (kw) null);
            } else if (isNight) {
                this.am.a(this.L, this.ah);
            } else {
                this.am.a(this.L, this.D);
            }
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawStaticencePro");
    }

    public void B() {
        A();
        boolean isNight = ThemeWatcher.getInstance().isNight();
        if (this.u != null) {
            this.u.a(this.L, isNight ? this.ah : null, this.c, aa());
        }
    }

    public void C() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        g(false);
        f(false);
        G();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        q();
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTrainingCaseTwo");
    }

    @Override // com.xiaopeng.autopilot.parking.view.e
    public boolean c() {
        return L();
    }

    @Override // com.xiaopeng.autopilot.parking.view.e
    public com.xiaopeng.autopilot.parking.view.g3d.e d() {
        return this.am;
    }

    private void aA() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        this.a.d(1);
        A();
        h(false);
        F();
        a(true, false);
        h();
        D();
        E();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        e(true);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameSr");
    }

    private void aB() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        this.a.d(1);
        A();
        h(false);
        a(false);
        D();
        E();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        q();
        e(true);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameAPSearching");
    }

    private void aC() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        this.a.d(1);
        A();
        a(false);
        D();
        E();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        e(true);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameAPFound");
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, defpackage.ach, defpackage.acg, defpackage.ik
    public void a(int i, int i2) {
        int currentTheme = ThemeWatcher.getInstance().getCurrentTheme();
        Log.i("Parking3DSencePro", "resize mParking3dPresenter = " + this.j + " ; mCurentTheme = " + this.p + " ;theme = " + currentTheme);
        if (this.j != null && this.p != currentTheme) {
            this.a.n();
            this.a.c(currentTheme);
        }
        this.p = currentTheme;
    }

    private void aD() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        h();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        aN();
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameAPReady");
    }

    private void aE() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        h();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        aO();
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameAPReady");
    }

    private void aF() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        h(true);
        a(true, true);
        h();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        e(false);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameAPFinish");
    }

    private void aG() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        g(true);
        h();
        f(true);
        G();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameTrainingFinish");
    }

    private void aH() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        h();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameTrainingFail");
    }

    private void aI() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        B();
        aJ();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameNavStartPoint");
    }

    private void aJ() {
        if (this.at == null && an().c("model/start_p/Mesh_Start_Dot.g3db")) {
            this.at = new tc();
            this.at.a();
            this.at.a(this);
            this.at.g();
        }
        if (this.at != null && this.a.ar()) {
            this.at.a(this.L, (kw) null);
        }
        if (this.A != null) {
            if (!this.A.i()) {
                this.A.g();
            }
            this.A.a(this.L, (kw) null);
        }
        if (this.av == null && an().c("model/nav_road/Mesh_AP_RoadSpeed.g3db")) {
            this.av = new uh();
            this.av.a();
            this.av.a(this);
            this.av.e();
        }
        uh uhVar = this.av;
        if (uhVar != null) {
            uhVar.a(this.L, (kw) null);
        }
    }

    private void aK() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        B();
        aM();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameTrainingLearn");
    }

    private void aL() {
        this.a.d(2);
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        h(false);
        a(true, true);
        e(false);
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "doSenceTypeFrameParamara");
    }

    public void D() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        if (!this.a.A().n_()) {
            PerformanceTestUnit.log(4000L, "unready for dyna object;", "Parking3DSencePro");
            return;
        }
        ArrayList<sl> S = this.a.S();
        if (S == null) {
            return;
        }
        Iterator<sl> it = S.iterator();
        while (it.hasNext()) {
            it.next().a(this.L, ThemeWatcher.getInstance().isNight() ? this.C : this.B);
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawApDynaObjects");
    }

    public void E() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        if (!this.a.A().n_()) {
            PerformanceTestUnit.log(4000L, "unready for ApStatic object;", "Parking3DSencePro");
            return;
        }
        new ArrayList();
        ArrayList<sl> T = this.a.T();
        if (T == null) {
            return;
        }
        if (T != null && T.size() > 0) {
            Iterator<sl> it = T.iterator();
            while (it.hasNext()) {
                it.next().a(this.L, this.B);
            }
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawApStaticObject");
    }

    public void e(boolean z) {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        List<sl> c = this.a.c(z);
        if (c == null) {
            return;
        }
        for (sl slVar : c) {
            slVar.a(this.L);
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawLandmarksObjects");
    }

    @Override // com.xiaopeng.autopilot.parking.view.e
    public aca b() {
        return an();
    }

    public void a(List<up> list) {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        if (list == null) {
            return;
        }
        for (up upVar : list) {
            if (upVar instanceof uu) {
                this.t = upVar;
            }
            if (upVar instanceof um) {
                ((um) upVar).a(this.L, this.L, this.P);
            } else if (upVar instanceof sf) {
                if (this.c == 1 || this.c == 2 || this.c == 3 || this.c == 4 || this.c == 9) {
                    ((sf) upVar).a(ThemeWatcher.getInstance().isNight() ? 0.8f : 0.93f, false);
                }
                ((sf) upVar).a(this.L, ThemeWatcher.getInstance().isNight() ? this.C : this.B);
            } else {
                upVar.a(this.L);
            }
        }
        this.s.addAll(list);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawDynaParkedLots");
    }

    public void F() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        rv ad = this.a.ad();
        if (ad != null && ad.k_() != null) {
            ad.a(this.L);
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawDynaPartOfGuidelineForD");
    }

    public void f(boolean z) {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        if (!this.a.A().e()) {
            PerformanceTestUnit.log(4000L, "un ready for training parklots", "Parking3DSencePro");
            return;
        }
        List<up> a = this.a.w().a(z);
        if (a != null && a.size() > 0) {
            for (up upVar : a) {
                if (upVar instanceof sf) {
                    sf sfVar = (sf) upVar;
                    if (sfVar.h()) {
                        if (ThemeWatcher.getInstance().isNight()) {
                            sfVar.a(this.L, this.C);
                        } else {
                            sfVar.a(this.L, this.B);
                        }
                    }
                }
            }
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawTrainingModelParklotCaseTwo");
    }

    public void G() {
        if (!this.a.A().d()) {
            PerformanceTestUnit.log("Parking3DSencePro_drawTrainingModelSpdbumpCaseTwo", "un ready for spd", 4000L);
            return;
        }
        PerformanceTestUnit.logStart("Parking3DSencePro");
        List<su> a = this.a.w().a();
        if (a != null && a.size() > 0) {
            for (su suVar : a) {
                if (suVar.g()) {
                    suVar.a(this.L);
                }
            }
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawTrainingModelSpdbumpCaseTwo");
    }

    public rx g(boolean z) {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        rx b = this.a.w().b();
        if (b != null) {
            b.a(this.L, z);
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawTrainingGuidelineCaseTwo");
        return b;
    }

    public void h(boolean z) {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        sd ac = this.a.ac();
        if (ac != null) {
            int ag = this.a.ag();
            ArrayList<la> arrayList = new ArrayList();
            la laVar = null;
            Matrix4 ae = this.a.ae();
            if (z && com.xiaopeng.autopilot.base.d.j()) {
                arrayList = new ArrayList();
                arrayList.add(this.a.ac().b(666));
                laVar = this.a.ac().a(ae);
            } else {
                arrayList.add(this.a.ac().b(ag));
            }
            ac.a(ag);
            boolean z2 = i.r.e().intValue() == 1;
            for (la laVar2 : arrayList) {
                if (laVar2 != null) {
                    if (laVar2.f != null && z2) {
                        laVar2.f.c();
                        laVar2.f.b(ae);
                    } else {
                        laVar2.f.c();
                    }
                    PerformanceTestUnit.log("drawStaticMapRoadAndLink_Road-0", "allPathRoad RoadPath instance :\t" + laVar2.toString() + "\tis not null\t current floorNum" + ag, 5000L, true);
                    if (ThemeWatcher.getInstance().isNight()) {
                        this.L.a(laVar2, this.ah);
                        if (com.xiaopeng.autopilot.base.d.j() && laVar != null) {
                            this.L.a(laVar, this.ah);
                        }
                    } else {
                        this.L.a(laVar2);
                        if (com.xiaopeng.autopilot.base.d.j() && laVar != null) {
                            this.L.a(laVar);
                        }
                    }
                } else {
                    PerformanceTestUnit.log("drawStaticMapRoadAndLink_Road-0", "allPathRoad RoadPath instance is null\t current floorNum" + ag, 5000L, true);
                }
            }
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawStaticMapRoadAndLink");
    }

    public void a(boolean z, boolean z2) {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        if (this.a.o() && this.b != null) {
            int ag = this.a.ag();
            ArrayList<up> b = this.a.b(z);
            List<up> a = this.a.a(ag, z2);
            if (ack.b().c()) {
                StringBuilder sb = new StringBuilder();
                sb.append("drawStaticMapParklots staticMapParkslots floorNum:");
                sb.append(ag);
                sb.append("\t");
                sb.append(a != null ? Integer.valueOf(a.size()) : "0");
                PerformanceTestUnit.log("Parking3DSencePro", sb.toString(), 5000L);
            }
            if (a != null) {
                for (up upVar : a) {
                    if (upVar instanceof um) {
                        ((um) upVar).a(this.L, this.L, this.P);
                    } else if (ThemeWatcher.getInstance().isNight()) {
                        upVar.a(this.L, this.C);
                    } else {
                        upVar.a(this.L, this.B);
                    }
                }
            }
            a((List<up>) b);
            PerformanceTestUnit.logEnd("Parking3DSencePro", "drawStaticMapParklots");
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public boolean H() {
        return this.a.p();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h
    public void a(int i, int i2, boolean z) {
        PerformanceTestUnit.log("Parking3DSencePro", "isTouchedInvalid = " + ad(), true);
        if (ad()) {
            int[] c = c(i, i2);
            int i3 = c[1];
            up i4 = i(i3);
            boolean z2 = c[0] == 1;
            PerformanceTestUnit.log("Parking3DSencePro", "resolveTouch.touchIndex = " + i3 + ",entity = " + i4 + ",touched = " + z2, true);
            if (!z2 || i4 == null) {
                return;
            }
            PerformanceTestUnit.log("Parking3DSencePro", "resolveTouch.onClick，点击选中车位 --> " + i4.w() + ",entity.getmIndex() = " + i4.x(), true);
            if (i4.w()) {
                if (this.x != null && z) {
                    this.x.b(i4.x(), false);
                }
                e(i4.x());
            } else if (i4.w() || z || this.E == null || this.E.f()) {
            } else {
                SoundPlayer.getInstance().playSlotOccupy();
            }
        }
    }

    @Override // defpackage.ach, defpackage.acg
    protected void a(pg pgVar) {
        if (ak().e()) {
            ak().c();
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.parking.view.g3d.a
    public void e(int i) {
        super.e(i);
        if (this.t != null) {
            com.badlogic.gdx.math.p o = this.t.o();
            this.a.a(o.a, o.b, o.c);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.base.e
    public void e() {
        PerformanceTestUnit.log("Parking3DSencePro", "TrainingModel_flag >> odoPoint car_position on start training model", true);
        this.a.ak();
        if (Z() != null) {
            Z().f();
        }
        com.xiaopeng.autopilot.base.i.a(i.au.class, 1);
        this.al = true;
        io.a.postRunnable(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.7
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.b != null && k.this.b.k_() != null) {
                    k.this.b.l();
                }
                k.this.au = 90.0f;
                k.this.a.w().c();
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.base.e
    public void f() {
        PerformanceTestUnit.log("Parking3DSencePro", "TrainingModel_flag >>  odoPoint >> car_positon on end training model", true);
        if (Z() != null) {
            Z().g();
        }
        io.a.postRunnable(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.this.a.ak();
                k.this.a.w().e();
                if (k.this.b != null && k.this.b.k_() != null) {
                    k.this.b.l();
                }
                com.xiaopeng.autopilot.base.i.a(i.au.class, 0);
                k.this.al = false;
                PerformanceTestUnit.log("Parking3DSencePro", "TrainingModel_flag >>  odoPoint >> car_positon on end training model exe", true);
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.autopilot.base.e
    public void a_(int i, int i2) {
        if (i2 == 13 || i2 == 14) {
            com.xiaopeng.autopilot.base.i.a(i.au.class, 0);
        }
        if (i2 == 13) {
            com.xiaopeng.autopilot.base.i.a(i.av.class, 1);
        }
        if (i2 == 14) {
            com.xiaopeng.autopilot.base.i.a(i.av.class, 0);
        }
    }

    private void aM() {
        i.ar arVar = (i.ar) com.xiaopeng.autopilot.base.i.a(i.ar.class);
        if (arVar.d().equals(1) || arVar.d().equals(5)) {
            if (this.an == null && an().c("model/virtual/model_text_ground.g3db")) {
                this.an = new td();
                this.an.a();
                this.an.a(this);
                this.an.g();
            }
            td tdVar = this.an;
            if (tdVar != null) {
                tdVar.a(this.L, (kw) null);
            }
            if (this.A != null) {
                if (!this.A.i()) {
                    this.A.g();
                }
                this.A.a(this.L, (kw) null);
            }
        } else if (arVar.d().equals(2) || arVar.d().equals(6)) {
            if (this.ao == null && an().c("model/virtual/model_text_metre.g3db")) {
                this.ao = new tg();
                this.ao.a();
                this.ao.a(this);
                this.ao.g();
            }
            tg tgVar = this.ao;
            if (tgVar != null) {
                tgVar.a(this.L, (kw) null);
            }
            if (this.A != null) {
                if (!this.A.i()) {
                    this.A.g();
                }
                this.A.a(this.L, (kw) null);
            }
        } else if (arVar.d().equals(3) || arVar.d().equals(4)) {
            if (this.ap == null && an().c("model/virtual/model_text_start.g3db")) {
                this.ap = new te();
                this.ap.a();
                this.ap.a(this);
                this.ap.g();
            }
            te teVar = this.ap;
            if (teVar != null) {
                teVar.a(this.L, (kw) null);
            }
            if (this.A != null) {
                if (!this.A.i()) {
                    this.A.g();
                }
                this.A.a(this.L, (kw) null);
            }
        } else if (arVar.d().equals(7) || arVar.d().equals(8)) {
            if (this.aq == null && an().c("model/virtual/model_text_parking.g3db")) {
                this.aq = new tf();
                this.aq.a();
                this.aq.a(this);
                this.aq.g();
            }
            tf tfVar = this.aq;
            if (tfVar != null) {
                tfVar.a(this.L, (kw) null);
            }
            if (this.A != null) {
                if (!this.A.i()) {
                    this.A.g();
                }
                this.A.a(this.L, (kw) null);
            }
        }
    }

    private void aN() {
        if (this.ar != null) {
            if (this.l != -5) {
                this.ar.f();
            }
            this.ar.a(this.L, (kw) null);
        }
    }

    private void aO() {
        if (this.as == null && an().c("model/virtual/load_animation.g3db")) {
            this.as = new ta();
            this.as.a();
            this.as.a(this);
            this.as.e();
        }
        if (this.as != null) {
            if (this.l != -14) {
                this.as.f();
            }
            this.as.a(this.L, (kw) null);
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.h, com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        super.onSwitchTheme(i);
        io.a.postRunnable(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.k.9
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.an != null) {
                    if (ThemeWatcher.getInstance().isNight()) {
                        k.this.an.e();
                    } else {
                        k.this.an.f();
                    }
                }
                if (k.this.ao != null) {
                    if (ThemeWatcher.getInstance().isNight()) {
                        k.this.ao.e();
                    } else {
                        k.this.ao.f();
                    }
                }
                if (k.this.ap != null) {
                    if (ThemeWatcher.getInstance().isNight()) {
                        k.this.ap.e();
                    } else {
                        k.this.ap.f();
                    }
                }
                if (k.this.aq != null) {
                    if (ThemeWatcher.getInstance().isNight()) {
                        k.this.aq.e();
                    } else {
                        k.this.aq.f();
                    }
                }
                if (k.this.av != null) {
                    k.this.av.a(ThemeWatcher.getInstance().getCurrentTheme());
                }
            }
        });
    }

    public void I() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        g(false);
        a(false);
        G();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        q();
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawFrameTypeTrainingSearching");
    }

    public void J() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        g(false);
        a(false);
        G();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawFrameTypeTrainingInReady");
    }

    public void K() {
        PerformanceTestUnit.logStart("Parking3DSencePro");
        A();
        g(false);
        a(false);
        G();
        p();
        a((com.badlogic.gdx.math.p) null, 0.0f, (Matrix4) null);
        if (o().e() == 34) {
            s();
        }
        PerformanceTestUnit.logEnd("Parking3DSencePro", "drawFrameTypeTrainingParkingB");
    }
}
