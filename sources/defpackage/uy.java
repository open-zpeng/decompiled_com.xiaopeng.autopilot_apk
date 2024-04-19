package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.view.f;
import com.xiaopeng.autopilot.parking.view.g3d.b;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import defpackage.acc;
import defpackage.acf;
/* compiled from: Parking3DSceneCameraAnimation.java */
/* renamed from: uy  reason: default package */
/* loaded from: classes.dex */
public class uy implements uw {
    acf A;
    protected h B;
    private tr X;
    private uz Y;
    acf a;
    acf b;
    acf c;
    acf d;
    acf e;
    acf f;
    acf g;
    acf h;
    acf i;
    acf j;
    acf k;
    acf l;
    acf m;
    acf n;
    acf o;
    acf p;
    acf q;
    acf r;
    acf s;
    acf t;
    acf u;
    acf v;
    acf w;
    acf x;
    acf y;
    acf z;
    private Runnable C = null;
    private Runnable D = null;
    private Runnable E = null;
    private Runnable F = null;
    private Runnable G = null;
    private Runnable H = null;
    private Runnable I = null;
    private Runnable J = null;
    private Runnable K = null;
    private Runnable L = null;
    private Runnable M = null;
    private Runnable N = null;
    private Runnable O = null;
    private Runnable P = null;
    private Runnable Q = null;
    private long R = 1000;
    private long S = 800;
    private long T = 0;
    private long U = 0;
    private long V = 0;
    private boolean W = false;
    private boolean Z = false;
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private boolean ad = false;
    private final int ae = 400;

    @Override // defpackage.uw
    public void a(int i, int i2) {
    }

    @Override // defpackage.uw
    public void a(f fVar, tj tjVar, ux uxVar) {
        this.B = (h) fVar;
        this.X = (tr) tjVar;
        this.Y = (uz) uxVar;
    }

    public Runnable u() {
        if (this.C == null) {
            this.C = new Runnable() { // from class: uy.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real ChangeSenceToAsearch animation.mCurrentSence = " + uy.this.X.l);
                    if (uy.this.X.l == 2) {
                        uy.this.b.i();
                    }
                }
            };
        }
        return this.C;
    }

    public Runnable v() {
        if (this.D == null) {
            this.D = new Runnable() { // from class: uy.12
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start ExeChangeSenceToSelect animation.mCurrentSence = " + uy.this.X.l);
                    if (uy.this.X.l == 3) {
                        uy.this.B.y = true;
                        uy.this.b.a();
                    }
                }
            };
        }
        return this.D;
    }

    public Runnable w() {
        if (this.E == null) {
            this.E = new Runnable() { // from class: uy.23
                @Override // java.lang.Runnable
                public void run() {
                    uy.this.d();
                    Log.i("Parking3DSceneCameraAnimation", " real start mChangeSenceInSlide animation.mCurrentSence = " + uy.this.X.l);
                    uy.this.e.i();
                }
            };
        }
        return this.E;
    }

    public Runnable x() {
        if (this.F == null) {
            this.F = new Runnable() { // from class: uy.34
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getRadarMinDistStart animation");
                    uy.this.f.i();
                }
            };
        }
        return this.F;
    }

    public Runnable y() {
        if (this.G == null) {
            this.G = new Runnable() { // from class: uy.45
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getRadarMinDistStop animation");
                    uy.this.f.a();
                }
            };
        }
        return this.G;
    }

    public Runnable z() {
        if (this.I == null) {
            this.I = new Runnable() { // from class: uy.48
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start mChangeSenceOutSelectSlide animation.mCurrentSence = " + uy.this.X.l);
                    uy.this.e.a();
                }
            };
        }
        return this.I;
    }

    public Runnable A() {
        if (this.H == null) {
            this.H = new Runnable() { // from class: uy.49
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getRadarToSelect animation");
                    uy.this.e.a();
                }
            };
        }
        return this.H;
    }

    public Runnable B() {
        if (this.J == null) {
            this.J = new Runnable() { // from class: uy.50
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceInSearch animation.mCurrentSence = " + uy.this.X.l);
                    uy.this.c.a();
                }
            };
        }
        return this.J;
    }

    public Runnable C() {
        if (this.K == null) {
            this.K = new Runnable() { // from class: uy.51
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceInSelect animation");
                    uy.this.d.a();
                }
            };
        }
        return this.K;
    }

    public Runnable D() {
        if (this.L == null) {
            this.L = new Runnable() { // from class: uy.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceDefault animation");
                    uy.this.g.a();
                }
            };
        }
        return this.L;
    }

    public Runnable E() {
        if (this.M == null) {
            this.M = new Runnable() { // from class: uy.3
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceTranslate animation");
                    uy.this.h.a();
                }
            };
        }
        return this.M;
    }

    public Runnable F() {
        if (this.N == null) {
            this.N = new Runnable() { // from class: uy.4
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceTranslateReverse animation");
                    uy.this.h.i();
                }
            };
        }
        return this.N;
    }

    public Runnable G() {
        if (this.O == null) {
            this.O = new Runnable() { // from class: uy.5
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceSlotOut animation");
                    uy.this.i.a();
                }
            };
        }
        return this.O;
    }

    public Runnable H() {
        if (this.P == null) {
            this.P = new Runnable() { // from class: uy.6
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceSlotIn animation");
                }
            };
        }
        return this.P;
    }

    public Runnable I() {
        if (this.Q == null) {
            this.Q = new Runnable() { // from class: uy.7
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("Parking3DSceneCameraAnimation", " real start getChangeSenceSlotFinish animation");
                    uy.this.k.a();
                }
            };
        }
        return this.Q;
    }

    public void J() {
        rh.a().h(v());
        rh.a().h(u());
        rh.a().h(w());
        rh.a().h(z());
        rh.a().h(B());
        rh.a().h(C());
        rh.a().h(D());
        rh.a().h(E());
        rh.a().h(F());
        rh.a().h(G());
        rh.a().h(H());
        rh.a().h(x());
        rh.a().h(y());
        rh.a().h(A());
        rh.a().h(I());
    }

    public void K() {
        J();
        rh.a().e(w(), 100L);
    }

    public void L() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceSlideWarningToSelect");
        J();
        rh.a().e(z(), 100L);
    }

    public void M() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceInSearch");
        m();
        J();
        rh.a().e(B(), 100L);
    }

    public void N() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceInSelect");
        m();
        J();
        rh.a().e(C(), 100L);
    }

    public void O() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceDefault");
        m();
        J();
        rh.a().e(D(), 100L);
    }

    public void a(long j) {
        Log.i("Parking3DSceneCameraAnimation", "onSenceTranlate");
        J();
        rh.a().e(E(), j);
    }

    public void b(long j) {
        Log.i("Parking3DSceneCameraAnimation", "onSenceTranlateReverse");
        J();
        this.V = System.currentTimeMillis();
        rh.a().e(F(), j);
    }

    public void P() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceSlotOut");
        J();
        rh.a().e(G(), 100L);
    }

    public void Q() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceSlotIn");
        J();
        rh.a().e(H(), 100L);
    }

    @Override // defpackage.uw
    public void e() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceASearchToInReady 移除到找车动画,开始选车动画");
        acf acfVar = this.a;
        if (acfVar != null && acfVar.h()) {
            this.a.b();
        }
        J();
        long currentTimeMillis = System.currentTimeMillis() - this.T;
        long currentTimeMillis2 = System.currentTimeMillis() - this.U;
        this.T = System.currentTimeMillis();
        Log.i("Parking3DSceneCameraAnimation", "interval_current:" + currentTimeMillis + "\tinterval_last:" + currentTimeMillis2);
        if (currentTimeMillis < this.R && a()) {
            Log.i("Parking3DSceneCameraAnimation", "interval_current low delay time do not  ExeChangeSenceToSelect");
        } else if (currentTimeMillis2 < this.R && a()) {
            Log.i("Parking3DSceneCameraAnimation", " interval_last low delay time do not  ExeChangeSenceToSelect");
        } else {
            rh.a().e(v(), 100L);
            this.T = System.currentTimeMillis();
        }
    }

    @Override // defpackage.uw
    public void f() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceInReadyToASearch 开始找车动画");
        J();
        long currentTimeMillis = System.currentTimeMillis() - this.U;
        long currentTimeMillis2 = System.currentTimeMillis() - this.T;
        this.U = System.currentTimeMillis();
        Log.i("Parking3DSceneCameraAnimation", "interval_curent:" + currentTimeMillis + "\tinterval_last:" + currentTimeMillis2);
        if (currentTimeMillis < this.R && b()) {
            Log.i("Parking3DSceneCameraAnimation", " interval_curent low delay time do not  onSenceInReadyToASearch");
        } else if (currentTimeMillis2 < this.R && b()) {
            Log.i("Parking3DSceneCameraAnimation", "interval_last low delay time do not  onSenceInReadyToASearch");
        } else {
            rh.a().e(u(), this.R);
        }
    }

    private boolean a() {
        return ((int) this.B.n().a.b) == ((int) b.n.a.b) && ((int) this.B.n().a.c) == ((int) b.n.a.c);
    }

    private boolean b() {
        return ((int) this.B.n().a.b) == ((int) b.m.a.b) && ((int) this.B.n().a.c) == ((int) b.m.a.c);
    }

    @Override // defpackage.uw
    public void g() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceInReadyToParkB");
        this.X.K();
        Q();
    }

    @Override // defpackage.uw
    public void h() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceParkBToOutReady");
    }

    @Override // defpackage.uw
    public void i() {
        J();
        rh.a().e(I(), 100L);
    }

    @Override // defpackage.uw
    public void j() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceChangeToDefault");
        h hVar = this.B;
        m();
        if (hVar != null) {
            hVar.X().l();
        }
    }

    @Override // defpackage.uw
    public void k() {
        Log.i("Parking3DSceneCameraAnimation", "onSenchaneToUnDefault");
    }

    @Override // defpackage.uw
    public void l() {
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToFindCar.mParking3DView = " + this.B);
        h hVar = this.B;
        if (hVar == null || !(hVar instanceof h)) {
            return;
        }
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToFindCar.sence.mCam = " + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        a(b.m.a, b.m.b);
    }

    public void a(final p pVar, final p pVar2) {
        final jz n = this.B.n();
        if (this.X.l == 2 || this.X.l == -1 || this.X.l == -6 || this.X.l == 0) {
            n.a.a(pVar);
            n.b.a(pVar2);
            n.c.a(b.m.c);
            n.a();
            return;
        }
        if (this.z == null) {
            this.z = acf.b(0.0f, 1.0f);
            this.z.a(800L);
        }
        this.z.g();
        this.z.a(new acf.b() { // from class: uy.8
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy uyVar = uy.this;
                jz jzVar = n;
                uyVar.a(jzVar, jzVar.a, pVar, n.b, pVar2, n.c, b.m.c, ((ace) acfVar).e());
            }
        });
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToFindValue.after.position" + this.B.P.a + "," + this.B.P.b + "," + this.B.P.c);
        if (this.z.h()) {
            this.z.b();
        }
        this.z.a();
    }

    @Override // defpackage.uw
    public void m() {
        h hVar = this.B;
        if (hVar == null || !(hVar instanceof h)) {
            return;
        }
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToSingleCar.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        hVar.P.a.a(new p(0.0f, 23.039999f, 0.0f));
        hVar.P.b.a(b.j.b);
        hVar.P.c.a(b.m.c);
        hVar.P.a();
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToSingleCar.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
    }

    @Override // defpackage.uw
    public void n() {
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToSelectCar.zoomRotate = " + this.B.r());
        h hVar = this.B;
        if (hVar == null || !(hVar instanceof h)) {
            return;
        }
        hVar.y = false;
        final jz n = hVar.n();
        if (this.A == null) {
            this.A = acf.b(0.0f, 1.0f);
            this.A.a(800L);
        }
        this.A.g();
        this.A.a(new acf.b() { // from class: uy.9
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy uyVar = uy.this;
                jz jzVar = n;
                uyVar.a(jzVar, jzVar.a, b.n.a, n.b, b.n.b, n.c, b.m.c, ((ace) acfVar).e());
            }
        });
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToSelectCar.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        if (this.A.h()) {
            this.A.b();
        }
        this.A.a();
    }

    public void R() {
        h hVar = this.B;
        if (hVar == null || !(hVar instanceof h)) {
            return;
        }
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToSlotOut.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        hVar.P.a.a(b.o.a);
        hVar.P.b.a(b.o.b);
        hVar.P.c.a(b.m.c);
        hVar.P.a();
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToSlotOut.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
    }

    @Override // defpackage.uw
    public void d() {
        Log.i("Parking3DSceneCameraAnimation", "cancelAnimator");
        J();
        acf acfVar = this.a;
        if (acfVar != null && acfVar.h()) {
            this.a.b();
        }
        acf acfVar2 = this.b;
        if (acfVar2 != null && acfVar2.h()) {
            this.b.b();
        }
        acf acfVar3 = this.c;
        if (acfVar3 != null && acfVar3.h()) {
            this.c.b();
        }
        acf acfVar4 = this.d;
        if (acfVar4 != null && acfVar4.h()) {
            this.d.b();
        }
        acf acfVar5 = this.e;
        if (acfVar5 != null && acfVar5.h()) {
            this.e.b();
        }
        acf acfVar6 = this.g;
        if (acfVar6 != null && acfVar6.h()) {
            this.g.b();
        }
        acf acfVar7 = this.h;
        if (acfVar7 != null && acfVar7.h()) {
            this.h.b();
        }
        acf acfVar8 = this.i;
        if (acfVar8 != null && acfVar8.h()) {
            this.i.b();
        }
        acf acfVar9 = this.j;
        if (acfVar9 != null && acfVar9.h()) {
            this.j.b();
        }
        acf acfVar10 = this.l;
        if (acfVar10 != null && acfVar10.h()) {
            this.l.b();
        }
        acf acfVar11 = this.n;
        if (acfVar11 != null && acfVar11.h()) {
            this.n.b();
        }
        acf acfVar12 = this.o;
        if (acfVar12 != null && acfVar12.h()) {
            this.o.b();
        }
        acf acfVar13 = this.p;
        if (acfVar13 != null && acfVar13.h()) {
            this.p.b();
        }
        acf acfVar14 = this.q;
        if (acfVar14 != null && acfVar14.h()) {
            this.q.b();
        }
        acf acfVar15 = this.r;
        if (acfVar15 != null && acfVar15.h()) {
            this.r.b();
        }
        acf acfVar16 = this.t;
        if (acfVar16 != null && acfVar16.h()) {
            this.t.b();
        }
        acf acfVar17 = this.u;
        if (acfVar17 != null && acfVar17.h()) {
            this.u.b();
        }
        acf acfVar18 = this.v;
        if (acfVar18 != null && acfVar18.h()) {
            this.v.b();
        }
        acf acfVar19 = this.m;
        if (acfVar19 != null && acfVar19.h()) {
            this.m.b();
        }
        acf acfVar20 = this.f;
        if (acfVar20 != null && acfVar20.h()) {
            this.f.b();
        }
        acf acfVar21 = this.w;
        if (acfVar21 != null && acfVar21.h()) {
            this.w.b();
        }
        acf acfVar22 = this.x;
        if (acfVar22 != null && acfVar22.h()) {
            this.x.b();
        }
        acf acfVar23 = this.z;
        if (acfVar23 != null && acfVar23.h()) {
            this.z.b();
        }
        acf acfVar24 = this.A;
        if (acfVar24 == null || !acfVar24.h()) {
            return;
        }
        this.A.b();
    }

    public void S() {
        this.c = a(false, false, 23.039999f, 54.0f, 0.0f, 58.0f, 800, 800, false);
    }

    public void T() {
        this.d = a(false, false, 23.039999f, 54.0f, 0.0f, 38.0f, 800, 800, false);
    }

    public void U() {
        this.e = a(false, true, 23.039999f, 54.0f, 0.0f, 38.0f, 800, 800, false);
    }

    public void V() {
        this.f = a(true, true, 23.039999f, 54.0f, 0.0f, 58.0f, IInputController.KEYCODE_KNOB_WIND_SPD_UP, IInputController.KEYCODE_KNOB_WIND_SPD_UP, false);
    }

    public void W() {
        this.j = a(false, false, 54.0f, 54.0f, 38.0f, 25.0f, 400, 400, false);
    }

    private acf a(final boolean z, final boolean z2, final float f, final float f2, float f3, final float f4, int i, int i2, boolean z3) {
        Log.i("Parking3DSceneCameraAnimation", "createSearchSelectAnimator.start.x = " + this.B.n().a.a + ",y = " + this.B.n().a.b + ",z = " + this.B.n().a.c);
        ace b = acf.b(f3, f4);
        b.a((long) i2);
        b.a(new acf.b() { // from class: uy.10
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                float e = ((ace) acfVar).e();
                float f5 = e / f4;
                float f6 = 4.2000003f * f5;
                float f7 = f;
                float f8 = f7 + ((f2 - f7) * f5);
                jz n = uy.this.B.n();
                double d = (e / 180.0f) * 3.141592653589793d;
                float f9 = f6 + 0.0f;
                float sin = (((float) Math.sin(d)) * f8) + f6;
                n.a.a(n.a.a, ((float) Math.cos(d)) * f8, sin);
                n.a(0.0f, 0.0f, f9);
                n.c.a(b.m.c);
                n.a();
                if (z2 && uy.this.B.O() != 0 && uy.this.X.m() != null) {
                    uy.this.X.m().a(f5);
                    uy.this.B.Z().a(uy.this.X.m().h().c);
                    Log.i("Parking3DSceneCameraAnimation", "createSearchSelectAnimator.center = " + uy.this.X.m().h().c);
                }
                io.b.requestRendering();
            }
        });
        b.a(new acc.a() { // from class: uy.11
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                uy.this.B.y = false;
                Log.i("Parking3DSceneCameraAnimation", "createSearchSelectAnimator.mCurrentSence = " + uy.this.X.l + ",isRadar = " + z + ",mCam.position = " + uy.this.B.n().a + "," + uy.this.B.n().b + "," + uy.this.B.n().c);
            }
        });
        return b;
    }

    public void X() {
        this.g = a(23.039999f, 0.0f, 58.0f, 800);
    }

    private acf a(final float f, float f2, float f3, int i) {
        Log.i("Parking3DSceneCameraAnimation", "createDefaultAnimator");
        ace b = acf.b(f2, f3);
        b.a(i);
        b.a(new acf.b() { // from class: uy.13
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                float e = ((ace) acfVar).e();
                jz n = uy.this.B.n();
                double d = (e / 180.0f) * 3.141592653589793d;
                float sin = ((float) Math.sin(d)) * f;
                n.a.a(n.a.a, ((float) Math.cos(d)) * f, sin);
                n.a(0.0f, 0.0f, 0.0f);
                n.c.a(b.m.c);
                n.a();
                io.b.requestRendering();
            }
        });
        b.a(new acc.a() { // from class: uy.14
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                h hVar = uy.this.B;
                hVar.y = false;
                Log.i("Parking3DSceneCameraAnimation", "position:\t" + hVar.P.a + "\t" + hVar.P.b + "\tdirection:\tup\t" + hVar.P.c);
            }
        });
        return b;
    }

    public void Y() {
        this.h = a(800);
    }

    private acf a(int i) {
        ace b = acf.b(0.0f, 1.0f);
        b.a(i);
        b.b(1);
        b.a(new acf.b() { // from class: uy.15
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                float e = ((ace) acfVar).e();
                jz n = uy.this.B.n();
                if (acfVar.j()) {
                    float f = 1.0f - e;
                    n.a.b(b.m.a, f);
                    n.b.b(b.m.b, f);
                } else {
                    n.a.b(b.k.a, e);
                    n.b.b(b.m.b, e);
                }
                n.c.a(b.m.c);
                n.a();
                io.b.requestRendering();
            }
        });
        return b;
    }

    public void Z() {
        this.i = b(800);
    }

    private acf b(int i) {
        final jz n = this.B.n();
        ace b = acf.b(23.039999f, 41.471996f);
        b.a(i);
        b.a(new acf.b() { // from class: uy.16
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                float e = ((ace) acfVar).e();
                n.a.a(n.a.a, e, n.a.c);
                n.c.a(b.m.c);
                n.a();
                io.b.requestRendering();
            }
        });
        return b;
    }

    public void aa() {
        this.k = c(100);
    }

    private acf c(int i) {
        final jz n = this.B.n();
        ace b = acf.b(b.n.a.b * 0.65f, 23.039999f);
        b.a(i);
        b.a(new acf.b() { // from class: uy.17
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                n.a.a(n.a.a, ((ace) acfVar).e(), n.a.c);
                n.c.a(b.m.c);
                n.a();
                io.b.requestRendering();
            }
        });
        b.a(new acc.a() { // from class: uy.18
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "slotFinishAnimator.position:\t" + n.a + "\t" + n.b + "\tdirection:\tup\t" + n.c);
            }
        });
        return b;
    }

    public void ab() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceSlotOutReady.zoomRotate = " + this.B.r());
        m();
        P();
    }

    public void ac() {
        this.a = a(false, false, 23.039999f, 54.0f, 0.0f, 58.0f, 1000, 1500, true);
    }

    public void ad() {
        ace b = acf.b(58.0f, 38.0f);
        b.a(this.S);
        b.a(new acf.b() { // from class: uy.19
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                float e = ((ace) acfVar).e();
                jz n = uy.this.B.n();
                double d = (e / 180.0f) * 3.141592653589793d;
                n.a.a(n.a.a, ((float) Math.cos(d)) * 54.0f, (((float) Math.sin(d)) * 54.0f) + 4.2000003f);
                n.a(0.0f, 0.0f, 4.2000003f);
                n.c.a(b.m.c);
                n.a();
                if (uy.this.X.m() != null) {
                    uy.this.X.m().m();
                    uy.this.B.Z().a(uy.this.X.m().h().c);
                }
                io.b.requestRendering();
            }
        });
        b.a(new acd() { // from class: uy.20
            @Override // defpackage.acd, defpackage.acc.a
            public void b(acc accVar) {
                super.b(accVar);
                Log.i("Parking3DSceneCameraAnimation", "createAnimationSetSingle.position = " + uy.this.B.n().a + "," + uy.this.B.n().b + "," + uy.this.B.n().c);
                uy.this.B.y = false;
            }
        });
        this.b = b;
    }

    @Override // defpackage.uw
    public void p() {
        if (System.currentTimeMillis() - this.V < 1000 || this.W) {
            return;
        }
        if (d.c()) {
            Log.i("Parking3DSceneCameraAnimation", "mParking3DPresenter.notHasParkLots() = " + this.X.p());
        }
        if (this.X.p()) {
            int r = this.B.M().r();
            if (d.c()) {
                Log.i("Parking3DSceneCameraAnimation", "size = " + r);
            }
            if (r > 0) {
                this.X.a(false);
                b(500L);
            }
        }
    }

    @Override // defpackage.uw
    public boolean o() {
        acf acfVar = this.a;
        if (acfVar == null || this.b == null || this.g == null || this.c == null || this.d == null || this.h == null || this.e == null || this.j == null || this.i == null) {
            return false;
        }
        return acfVar.h() | this.b.h() | this.g.h() | this.c.h() | this.d.h() | this.h.h() | this.e.h() | this.j.h() | this.i.h();
    }

    @Override // defpackage.uw
    public void a(boolean z) {
        this.W = z;
    }

    @Override // defpackage.uw
    public void r() {
        ac();
        ad();
        S();
        T();
        U();
        X();
        Y();
        Z();
        W();
        V();
        aa();
    }

    public void ae() {
        acf acfVar = this.k;
        if (acfVar == null || !acfVar.h()) {
            return;
        }
        this.k.b();
    }

    public void af() {
        Log.i("Parking3DSceneCameraAnimation", "onSenceOutReadyToParkingB");
        R();
    }

    @Override // defpackage.uw
    public void q() {
        Log.i("Parking3DSceneCameraAnimation", "doEnterAnimation");
        m();
        final h hVar = this.B;
        if (hVar == null || !(hVar instanceof h)) {
            return;
        }
        ace b = acf.b(0.5f, 1.0f);
        b.a(650L);
        b.b(1);
        b.a("alpAnimator");
        b.a(acb.a(0));
        b.a(new acf.b() { // from class: uy.21
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                float e = ((ace) acfVar).e();
                le leVar = new le(770, 771);
                leVar.f = e;
                hVar.X().k_().b.a(0).a(leVar);
                io.b.requestRendering();
            }
        });
        b.a();
        Log.i("Parking3DSceneCameraAnimation", "start do enter alp anmimation");
    }

    @Override // defpackage.uw
    public void a(final p pVar, final p pVar2, final p pVar3, final p pVar4) {
        Log.i("Parking3DSceneCameraAnimation", "onSenceToAPArrive");
        final jz n = this.B.n();
        if (this.l == null) {
            this.l = acf.b(0.0f, 1.0f);
            this.l.a(800L);
        }
        this.l.g();
        this.l.a(new acf.b() { // from class: uy.22
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, null, null, ((ace) acfVar).e());
            }
        });
        this.l.c();
        this.l.a(new acc.a() { // from class: uy.24
            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                if (uy.this.X.m() == null || uy.this.X.m().h().c != 0.0f) {
                    uy.this.Z = false;
                } else {
                    uy.this.Z = true;
                }
                uy.this.ac = true;
                Log.i("Parking3DSceneCameraAnimation", "mApArriveAnimator.onAnimationStart.mCarCanPush = " + uy.this.Z);
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "mApArriveAnimator.onAnimationEnd.mAPArriveCameraMove = " + uy.this.ac);
                if (uy.this.ac) {
                    uy.this.ac = false;
                    d.e(1);
                }
                uy.this.Z = false;
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
                uy.this.Z = false;
                uy.this.ac = false;
            }
        });
        if (this.l.h()) {
            this.l.b();
        }
        this.l.a();
    }

    @Override // defpackage.uw
    public void a(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.m == null) {
            this.m = acf.b(0.0f, 1.0f);
            this.m.a(800L);
        }
        this.m.g();
        this.m.a(new acf.b() { // from class: uy.25
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        this.m.c();
        this.m.a(new acc.a() { // from class: uy.26
            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                if (uy.this.X.l == 3) {
                    if (uy.this.X.m() == null || uy.this.X.m().h().c != 0.0f) {
                        uy.this.Z = false;
                    } else {
                        uy.this.Z = true;
                    }
                } else {
                    uy.this.Z = false;
                }
                Log.i("Parking3DSceneCameraAnimation", "mBackToApaAnimator.onAnimationStart.mCarCanPush = " + uy.this.Z);
                uy.this.aa = true;
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "onSenceBackToAPA.onAnimationEnd.mParking3DPresenter.mCurrentSence = " + uy.this.X.l);
                uy.this.Z = false;
                if (uy.this.X.l == -5 || uy.this.X.l == -4 || uy.this.X.l == -15 || uy.this.X.l == -16) {
                    return;
                }
                Log.i("Parking3DSceneCameraAnimation", "onSenceBackToAPA.mAPABackCameraMove = " + uy.this.aa);
                if (uy.this.aa) {
                    uy.this.aa = false;
                    d.e(1);
                }
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
                uy.this.Z = false;
                uy.this.aa = false;
            }
        });
        if (this.m.h()) {
            this.m.b();
        }
        this.m.a();
    }

    @Override // defpackage.uw
    public void s() {
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToAPReady");
        h hVar = this.B;
        if (hVar == null || !(hVar instanceof h)) {
            return;
        }
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToAPReady.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        hVar.P.a.a(b.C0058b.a);
        hVar.P.b.a(b.C0058b.b);
        hVar.P.c.a(b.C0058b.c);
        hVar.P.a();
        Log.i("Parking3DSceneCameraAnimation", "changeCameraToAPReady.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
    }

    @Override // defpackage.uw
    public void b(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.n == null) {
            this.n = acf.b(0.0f, 1.0f);
            this.n.a(600L);
        }
        uf m = this.X.m();
        if (m != null && m.h() != null && m.h().c != 0.0f) {
            Log.i("Parking3DSceneCameraAnimation", "onSenceToApReady.drivingCarEntity.getCenter().z = " + m.h().c);
            m.l();
        }
        this.n.g();
        this.n.a(new acf.b() { // from class: uy.27
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        if (this.n.h()) {
            this.n.b();
        }
        this.n.a();
    }

    @Override // defpackage.uw
    public void c(p pVar, final p pVar2, p pVar3, final p pVar4, p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.o == null) {
            this.o = acf.b(0.0f, 1.0f);
            this.o.a(800L);
        }
        this.o.g();
        this.o.a(new acf.b() { // from class: uy.28
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy uyVar = uy.this;
                jz jzVar = n;
                uyVar.a(jzVar, jzVar.a, pVar2, n.b, pVar4, n.c, pVar6, ((ace) acfVar).e());
            }
        });
        this.o.c();
        this.o.a(new acc.a() { // from class: uy.29
            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "mAPAnimator.onAnimationStart");
                i.a(i.ag.class, true);
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                d.e(2);
                i.a(i.ag.class, false);
                Log.i("Parking3DSceneCameraAnimation", "mAPAnimator.onAnimationEnd.mCam = " + n.a + "," + n.c + "," + n.b);
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "mAPAnimator.onAnimationCancel");
            }
        });
        if (this.o.h()) {
            this.o.b();
        }
        this.o.a();
    }

    @Override // defpackage.uw
    public void a(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6, final p pVar7, final p pVar8, final p pVar9, int i) {
        final jz n = this.B.n();
        if (i > 400) {
            a(n, pVar2, pVar7, pVar4, pVar8, pVar6, pVar9, 1.0f);
            return;
        }
        if (this.p == null) {
            this.p = acf.b(0.0f, 1.0f);
        }
        if (this.q == null) {
            this.q = acf.b(0.0f, 1.0f);
        }
        this.p.a(1000L);
        this.q.a(400L);
        this.p.g();
        this.p.a(new acf.b() { // from class: uy.30
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        this.q.g();
        this.q.a(new acf.b() { // from class: uy.31
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar2, pVar7, pVar4, pVar8, pVar6, pVar9, ((ace) acfVar).e());
            }
        });
        this.p.c();
        this.p.a(new acc.a() { // from class: uy.32
            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                uy.this.ad = true;
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                if (uy.this.q != null && uy.this.q.h()) {
                    uy.this.q.b();
                }
                Log.i("Parking3DSceneCameraAnimation", "onSenceToApFinish.mAPFinishCanAnimTwo = " + uy.this.ad + "," + n.a + "," + n.c + "," + n.b);
                if (uy.this.ad && uy.this.B.P() == -6) {
                    uy.this.q.a();
                }
                uy.this.ad = false;
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
                uy.this.ad = false;
            }
        });
        if (this.p.h()) {
            this.p.b();
        }
        if (this.q.h()) {
            this.q.b();
        }
        this.p.a();
    }

    @Override // defpackage.uw
    public void d(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.r == null) {
            this.r = acf.b(0.0f, 1.0f);
            this.r.a(800L);
        }
        this.r.g();
        this.r.a(new acf.b() { // from class: uy.33
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        this.r.c();
        this.r.a(new acc.a() { // from class: uy.35
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                int intValue = ((i.at) i.a(i.at.class)).d().intValue();
                Log.i("Parking3DSceneCameraAnimation", "mTrainingAnimator.onAnimationEnd.trainingTips = " + intValue);
                if (intValue <= 4 || intValue >= 17) {
                    return;
                }
                d.e(2);
                if (uy.this.B == null || !(uy.this.B instanceof h)) {
                    return;
                }
                h hVar = uy.this.B;
                Log.i("Parking3DSceneCameraAnimation", "mTrainingAnimator.onAnimationEnd.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
                hVar.P.a.a(b.p.a);
                hVar.P.b.a(b.p.b);
                hVar.P.c.a(b.p.c);
                hVar.P.a();
                Log.i("Parking3DSceneCameraAnimation", "mTrainingAnimator.onAnimationEnd.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
            }
        });
        if (this.r.h()) {
            this.r.b();
        }
        this.r.a();
    }

    @Override // defpackage.uw
    public void e(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.s == null) {
            this.s = acf.b(0.0f, 1.0f);
            this.s.a(800L);
        }
        this.s.g();
        this.s.a(new acf.b() { // from class: uy.36
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        if (this.s.h()) {
            this.s.b();
        }
        this.s.a();
    }

    @Override // defpackage.uw
    public void a(final p pVar, final float f, int i) {
        final jz n = this.B.n();
        if (this.t == null) {
            this.t = acf.b(0.0f, 1.0f);
        }
        if (i > 400) {
            this.t.a(0L);
        } else {
            this.t.a(1500L);
        }
        this.t.g();
        this.t.a(new acf.b() { // from class: uy.37
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, b.p.a, b.r.a(pVar, f), b.p.b, b.r.c, b.p.c, b.r.d, ((ace) acfVar).e());
            }
        });
        if (this.t.h()) {
            this.t.b();
        }
        this.t.a();
    }

    @Override // defpackage.uw
    public void f(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.u == null) {
            this.u = acf.b(0.0f, 1.0f);
            this.u.a(800L);
        }
        this.u.g();
        this.u.a(new acf.b() { // from class: uy.38
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        if (this.u.h()) {
            this.u.b();
        }
        this.u.a();
    }

    @Override // defpackage.uw
    public void g(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        final jz n = this.B.n();
        if (this.v == null) {
            this.v = acf.b(0.0f, 1.0f);
            this.v.a(800L);
        }
        this.v.g();
        this.v.a(new acf.b() { // from class: uy.39
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        this.v.c();
        this.v.a(new acc.a() { // from class: uy.40
            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                uy.this.ab = true;
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "onSenceTrainingBack.onAnimationEnd.mParking3DPresenter.mCurrentSence = " + uy.this.X.l);
                if (uy.this.X.l != -1) {
                    Log.i("Parking3DSceneCameraAnimation", "onSenceTrainingBack.mTrainingBackCameraMove = " + uy.this.ab);
                    if (uy.this.ab) {
                        uy.this.ab = false;
                        d.e(1);
                    }
                }
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
                uy.this.ab = false;
            }
        });
        if (this.v.h()) {
            this.v.b();
        }
        this.v.a();
    }

    @Override // defpackage.uw
    public void h(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        Log.i("Parking3DSceneCameraAnimation", "onSenceToAPSearching");
        final jz n = this.B.n();
        if (this.x == null) {
            this.x = acf.b(0.0f, 1.0f);
            this.x.a(800L);
        }
        this.x.g();
        this.x.a(new acf.b() { // from class: uy.41
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        this.x.c();
        this.x.a(new acc.a() { // from class: uy.42
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "onSenceToAPSearching.onAnimationEnd.mParking3DPresenter.mCurrentSence = " + uy.this.X.l);
                if (uy.this.X.l == -12) {
                    uy.this.t();
                }
            }
        });
        if (this.x.h()) {
            this.x.b();
        }
        this.x.a();
    }

    @Override // defpackage.uw
    public void i(final p pVar, final p pVar2, final p pVar3, final p pVar4, final p pVar5, final p pVar6) {
        Log.i("Parking3DSceneCameraAnimation", "onSenceToAPSearching");
        final jz n = this.B.n();
        if (this.y == null) {
            this.y = acf.b(0.0f, 1.0f);
            this.y.a(800L);
        }
        this.y.g();
        this.y.a(new acf.b() { // from class: uy.43
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy.this.a(n, pVar, pVar2, pVar3, pVar4, pVar5, pVar6, ((ace) acfVar).e());
            }
        });
        this.y.c();
        this.y.a(new acc.a() { // from class: uy.44
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "onSenceToAPSearching.onAnimationEnd.mParking3DPresenter.mCurrentSence = " + uy.this.X.l);
                if (uy.this.X.l == -12) {
                    uy.this.t();
                }
            }
        });
        if (this.y.h()) {
            this.y.b();
        }
        this.y.a();
    }

    @Override // defpackage.uw
    public void b(p pVar, final p pVar2, p pVar3, final p pVar4) {
        Log.i("Parking3DSceneCameraAnimation", "onSenceToFoundedParkLot");
        final jz n = this.B.n();
        if (this.w == null) {
            this.w = acf.b(0.0f, 1.0f);
            this.w.a(800L);
        }
        this.w.g();
        this.w.a(new acf.b() { // from class: uy.46
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                uy uyVar = uy.this;
                jz jzVar = n;
                uyVar.a(jzVar, jzVar.a, pVar2, n.b, pVar4, n.c, b.m.c, ((ace) acfVar).e());
            }
        });
        this.w.c();
        this.w.a(new acc.a() { // from class: uy.47
            @Override // defpackage.acc.a
            public void a(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimation", "onSenceToFoundedParkLot.onAnimationEnd.mParking3DPresenter.mCurrentSence = " + uy.this.X.l);
                if (uy.this.X.l == -12) {
                    uy.this.n();
                }
            }
        });
        if (this.w.h()) {
            this.w.b();
        }
        this.w.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(jz jzVar, p pVar, p pVar2, p pVar3, p pVar4, p pVar5, p pVar6, float f) {
        uf m = this.X.m();
        if (this.Z && m != null) {
            Matrix4 matrix4 = new Matrix4();
            matrix4.e(0.0f, uf.l, (-1.7146802f) * f);
            m.k_().f.c();
            m.k_().f.b(matrix4);
        }
        jzVar.a.a(pVar.a + ((pVar2.a - pVar.a) * f), pVar.b + ((pVar2.b - pVar.b) * f), pVar.c + ((pVar2.c - pVar.c) * f));
        jzVar.b.a(pVar3.a + ((pVar4.a - pVar3.a) * f), pVar3.b + ((pVar4.b - pVar3.b) * f), pVar3.c + ((pVar4.c - pVar3.c) * f));
        if (pVar5 != null && pVar6 != null) {
            jzVar.c.a(pVar5.a + ((pVar6.a - pVar5.a) * f), pVar5.b + ((pVar6.b - pVar5.b) * f), pVar5.c + ((pVar6.c - pVar5.c) * f));
        } else {
            jzVar.c.a(b.m.c);
        }
        jzVar.a();
        io.b.requestRendering();
    }

    @Override // defpackage.uw
    public void t() {
        Log.i("Parking3DSceneCameraAnimation", "chaneCameraToSR");
        a(b.a.a, b.a.b);
    }
}
