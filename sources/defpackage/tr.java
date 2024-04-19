package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.j;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.bean.caldata.ParkLotRData;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.autopilot.parking.view.f;
import com.xiaopeng.autopilot.parking.view.g3d.b;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.uq;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: Parking3DPresenter.java */
/* renamed from: tr  reason: default package */
/* loaded from: classes.dex */
public class tr implements tj {
    protected f a;
    public int l;
    protected ux m;
    protected uw n;
    private boolean w;
    private rm z;
    private int o = -999;
    Matrix4 d = new Matrix4();
    protected ArrayList<up> e = new ArrayList<>();
    a<ut> f = new a<>();
    a<uv> g = new a<>();
    a<um> h = new a<>();
    a<uu> i = new a<>();
    a<us> j = new a<>();
    a<uj> k = new a<>();
    private volatile int p = 0;
    private volatile int q = 0;
    private volatile int r = 0;
    private volatile int s = 0;
    private p t = new p();
    private p u = new p();
    private float v = -1.0f;
    private acp x = new acp();
    private boolean y = false;
    protected ud c = new ud(24, 32);
    protected uq b = new uq();

    @Override // defpackage.tj
    public void a(f fVar) {
        this.a = fVar;
        this.n.a((h) fVar, this, this.m);
    }

    public tr() {
        this.b.a(this);
        this.m = new uz();
        this.n = new uy();
    }

    @Override // defpackage.tj
    public void s() {
        this.n.l();
    }

    @Override // defpackage.tj
    public boolean t() {
        return C().c();
    }

    public rm C() {
        if (this.z == null) {
            this.z = new j();
        }
        return this.z;
    }

    @Override // defpackage.tj
    public void a() {
        this.a.j();
        this.a.k();
        this.a.h();
        this.a.a(null, 0.0f, null);
        PerformanceTestUnit.logEnd("Parking3DPresenter", "doSenceTypeFrameClean");
    }

    @Override // defpackage.tj
    public void b() {
        PerformanceTestUnit.logStart("Parking3DPresenter");
        f fVar = this.a;
        if (fVar != null && (fVar instanceof h)) {
            this.n.p();
        }
        this.a.k();
        this.a.j();
        this.a.a(null, 0.0f, null);
        this.a.a(false);
        this.a.i();
        this.a.h();
        this.a.m();
        this.a.q();
        PerformanceTestUnit.logEnd("Parking3DPresenter", "doSenceTypeFrameSuperParkSearching");
    }

    @Override // defpackage.tj
    public void c() {
        this.a.k();
        this.a.j();
        this.a.a(null, 0.0f, null);
        this.a.a(false);
        this.a.i();
        this.a.h();
        this.a.m();
    }

    @Override // defpackage.tj
    public void d() {
        PerformanceTestUnit.logStart("Parking3DPresenter");
        this.a.j();
        this.a.a(false);
        this.a.i();
        this.a.a(null, 0.0f, null);
        this.a.h();
        PerformanceTestUnit.logEnd("Parking3DPresenter", "doSenceTypeFrameSuperParkSlotInReady");
    }

    @Override // defpackage.tj
    public void e() {
        this.a.j();
        this.a.k();
        this.a.a(null, 0.0f, null);
        this.a.a(true);
        this.a.i();
        this.a.l();
        this.a.h();
    }

    @Override // defpackage.tj
    public void f() {
        PerformanceTestUnit.logStart("Parking3DPresenter");
        L();
        this.a.j();
        this.a.a(null, 0.0f, null);
        this.a.p();
        this.a.a(this.m.a());
        this.a.i();
        this.a.h();
        if (this.a.o().e() == 34) {
            this.a.s();
        }
        PerformanceTestUnit.logEnd("Parking3DPresenter", "dosenceTypeFrameParkingB");
    }

    @Override // defpackage.tj
    public void g() {
        B();
    }

    @Override // defpackage.tj
    public void h() {
        a();
    }

    @Override // defpackage.tj
    public void i() {
        a();
    }

    @Override // defpackage.tj
    public ArrayList<up> j() {
        float f;
        float f2;
        float a = g.a(up.class);
        float a2 = g.a(uu.class);
        float a3 = g.a(um.class);
        float a4 = g.a(uv.class);
        H();
        f fVar = this.a;
        ArrayList<up> arrayList = null;
        if (fVar != null && (fVar instanceof h)) {
            h hVar = (h) fVar;
            ArrayList<ParkLotItem> d = hVar.N().d();
            ArrayList<up> arrayList2 = (d == null || d.size() <= 0) ? null : new ArrayList<>();
            if (arrayList2 == null) {
                this.e.clear();
                return null;
            }
            int i = 0;
            while (i < d.size()) {
                ParkLotItem parkLotItem = d.get(i);
                if (parkLotItem != null && parkLotItem.getDir() > 0) {
                    acp acpVar = parkLotItem.getmCenter();
                    float a5 = a(parkLotItem);
                    float angle = parkLotItem.getAngle();
                    Matrix4 b = b(parkLotItem);
                    up a6 = this.b.a(parkLotItem, hVar.P());
                    if (a6 instanceof uu) {
                        f2 = a2;
                    } else if (a6 instanceof um) {
                        f2 = a3;
                    } else {
                        f2 = a6 instanceof uv ? a4 : a;
                    }
                    f = a2;
                    p pVar = new p((-acpVar.b) * uc.c, f2, (-acpVar.a) * uc.c);
                    a6.a(parkLotItem, a5, pVar, b);
                    if (!parkLotItem.isFree()) {
                        if (d.c()) {
                            Log.i("Parking3DPresenter", "parkLotEntity = " + a6);
                        }
                        if (a6 instanceof uv) {
                            ((uv) a6).f(hVar.P() == 1);
                        }
                    }
                    a(parkLotItem.isFavorite(), false, hVar.P(), a6, pVar, angle);
                    arrayList2.add(a6);
                    a = f2;
                } else {
                    f = a2;
                }
                i++;
                a2 = f;
            }
            b(arrayList2);
            arrayList = arrayList2;
        }
        this.e.clear();
        if (arrayList != null) {
            this.e.addAll(arrayList);
        }
        return arrayList;
    }

    protected void a(ArrayList<uj> arrayList) {
        if (this.q == 1) {
            Log.i("Parking3DPresenter", "updateCarEntityThemeMaterial");
            boolean isNight = ThemeWatcher.getInstance().isNight();
            Iterator<uj> it = this.c.c().iterator();
            while (it.hasNext()) {
                uj next = it.next();
                if (isNight) {
                    next.j();
                } else {
                    next.f();
                }
            }
            this.q--;
        }
    }

    private void w() {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        uq uqVar = this.b;
        if (uqVar != null) {
            if (isNight) {
                uqVar.h();
            } else {
                uqVar.i();
            }
        }
    }

    private void x() {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        if (this.c.c() == null) {
            return;
        }
        Iterator<uj> it = this.c.c().iterator();
        while (it.hasNext()) {
            uj next = it.next();
            if (isNight) {
                next.j();
            } else {
                next.f();
            }
        }
    }

    @Override // defpackage.tj
    public void n() {
        x();
        w();
        A();
        z();
        y();
    }

    private void y() {
        if (P() != null) {
            boolean isNight = ThemeWatcher.getInstance().isNight();
            uo Z = P().Z();
            if (Z == null) {
                return;
            }
            if (isNight) {
                Z.i();
            } else {
                Z.h();
            }
        }
    }

    private void z() {
        if (P() != null) {
            boolean isNight = ThemeWatcher.getInstance().isNight();
            ug V = P().V();
            if (V == null) {
                return;
            }
            if (isNight) {
                V.f();
            } else {
                V.e();
            }
        }
    }

    private void A() {
        if (P() != null) {
            boolean isNight = ThemeWatcher.getInstance().isNight();
            ui W = P().W();
            if (W == null) {
                return;
            }
            if (isNight) {
                W.g();
            } else {
                W.f();
            }
        }
    }

    protected void D() {
        this.n.j();
    }

    protected void E() {
        this.n.k();
    }

    public void F() {
        Log.i("Parking3DPresenter", "changeCameraParkingBOut.zoomRotate = " + this.a.r() + "," + this.a.n().a + "," + this.a.n().b + "," + this.a.n().c);
    }

    public void G() {
        boolean booleanValue = ((i.am) i.a(i.am.class)).d().booleanValue();
        PerformanceTestUnit.log("Parking3DPresenter", "changeCameraParkingBIn = " + this.w + "," + this.a.r() + "," + booleanValue, 1000L);
        if (!this.w || this.a.r() || booleanValue) {
            return;
        }
        tn N = ((h) this.a).N();
        if (N != null) {
            int e = N.e();
            int n = ((tv) N).n();
            if (d.c()) {
                Log.i("Parking3DPresenter", "changeCameraParkingBIn.tips = " + e + ",lastTips = " + n);
            }
            if (e == 34 || e == 6) {
                return;
            }
            if (e == 3 && n == 34) {
                K();
            }
        }
        if (m() != null && m().h().c == 0.0f) {
            Log.i("Parking3DPresenter", "changeCameraParkingBIn.pushCarEntity");
            m().m();
        }
        jz n2 = this.a.n();
        if (d.c()) {
            Log.i("Parking3DPresenter", "changeCameraParkingBIn.camera = " + n2 + ",mOriginParkingBDst = " + this.v + ",getParkingBDst() = " + N());
        }
        if (n2 == null) {
            return;
        }
        if (!Float.isNaN(this.v)) {
            float f = this.v;
            if (f >= 0.0f) {
                float N2 = (f - N()) / this.v;
                if (d.c()) {
                    Log.i("Parking3DPresenter", "changeCameraParkingBIn.percent = " + N2);
                }
                if (N2 <= 0.0f || Float.isNaN(N2)) {
                    K();
                    return;
                }
                this.t.a(b.n.a);
                this.u.a(b.n.b);
                acp acpVar = new acp(this.t.a, this.t.b, this.t.c);
                acp acpVar2 = new acp(this.t.a * 0.65f, this.t.b * 0.65f, this.t.c * 0.59999996f);
                n2.a.a = acpVar.a + ((acpVar2.a - acpVar.a) * N2);
                n2.a.b = acpVar.b + ((acpVar2.b - acpVar.b) * N2);
                float f2 = 1.0f - N2;
                n2.a.c = (acpVar.c + ((acpVar2.c - acpVar.c) * N2)) * f2;
                this.x.a(0.0f, 0.0f, 0.0f);
                p b = this.u.b(new p(this.x.a - acpVar2.a, this.x.b - acpVar2.b, this.x.c - acpVar2.c), N2);
                b.c = (b.c * f2) + (b.c * N2 * 0.1f);
                n2.b.a(b);
                if (d.c()) {
                    Log.i("Parking3DPresenter", N2 + "\t" + n2.a + "\t" + n2.b + "\t" + n2.c);
                }
                n2.a();
                return;
            }
        }
        this.v = N();
    }

    @Override // defpackage.tj
    public boolean o() {
        aca an = P().an();
        boolean c = an.c("model/entity/p_icon.g3db");
        boolean c2 = an.c("model/entity/weizhichewei.g3db");
        boolean c3 = an.c("model/entity/weizhichewei_Lateral.g3db");
        boolean c4 = an.c("model/entity/kebochewei.g3db");
        boolean c5 = an.c("model/entity/kebochewei_Lateral.g3db");
        return c && c2 && c3 && c5 && c5 && an.c("model/entity/xuanzhongchewei_Lateral.g3db") && c4 && an.c("model/entity/xuanzhongchewei.g3db");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        this.f.d();
        this.h.d();
        this.g.d();
        this.i.d();
        this.j.d();
    }

    protected void b(ArrayList<up> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<up> it = arrayList.iterator();
            while (it.hasNext()) {
                up next = it.next();
                if (next instanceof um) {
                    this.h.a((a<um>) ((um) next));
                } else if (next instanceof uv) {
                    this.g.a((a<uv>) ((uv) next));
                } else if (next instanceof uu) {
                    this.i.a((a<uu>) ((uu) next));
                }
            }
            if (this.h.b > 0) {
                this.b.e().a((a) this.h);
            }
            if (this.g.b > 0) {
                this.b.f().a((a) this.g);
            }
            if (this.i.b > 0) {
                this.b.g().a((a) this.i);
            }
        }
        if (this.f.b > 0) {
            this.b.a().a((a) this.f);
        }
        if (this.j.b > 0) {
            this.b.b().a((a) this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public la a(boolean z, boolean z2, int i, up upVar, p pVar, float f) {
        if ((upVar instanceof uu) || (upVar instanceof um) || (upVar instanceof uv)) {
            return a(z, z2, i, pVar, upVar, f);
        }
        return null;
    }

    private la a(boolean z, boolean z2, int i, p pVar, up upVar, float f) {
        float f2;
        float f3;
        float f4;
        uq.d dVar;
        ko koVar;
        float f5;
        float f6;
        float f7;
        aca an = P().an();
        uq.d a = this.b.a();
        ut d = a.d();
        d.b(z);
        d.c(z2);
        la k_ = d.k_();
        this.f.a((a<ut>) d);
        if (k_ == null) {
            return k_;
        }
        k_.f.c();
        if (!d.n()) {
            f2 = pVar.b + 0.1f;
            float f8 = pVar.c + 0.2f;
            f3 = pVar.a;
            f4 = f8;
        } else {
            f2 = pVar.b;
            if (upVar.t() == 3) {
                f3 = pVar.a;
                f4 = pVar.c;
            } else if (upVar.t() == 2 || upVar.t() == 1) {
                f3 = pVar.a;
                f4 = pVar.c + 0.5f;
            } else {
                f3 = pVar.a + 0.5f;
                f4 = pVar.c;
            }
        }
        k_.f.e(f3, f2, f4);
        ko koVar2 = null;
        if (upVar instanceof um) {
            um umVar = (um) upVar;
            umVar.a(k_, z);
            ko a2 = umVar.a(this.l, an);
            if (i == 3 || i == -9 || i == -12 || i == -13) {
                us d2 = this.b.b().d();
                this.j.a((a<us>) d2);
                la a3 = umVar.a(i, d2);
                la a4 = umVar.a(this.b.c().d());
                if (a4 != null) {
                    a4.f.c();
                    if (upVar.t() == 3) {
                        f6 = 2.0f + f3;
                        f7 = f4 - 1.1f;
                        f5 = -f;
                        koVar = a2;
                    } else {
                        f5 = f;
                        if (upVar.t() == 4) {
                            f6 = 2.7f + f3;
                            f7 = f4 - 1.1f;
                            koVar = a2;
                        } else if (upVar.t() == 2 || upVar.t() == 1) {
                            f6 = 0.5f + f3;
                            f7 = f4 - 3.1f;
                            koVar = a2;
                        } else {
                            f7 = f4;
                            koVar = a2;
                            f6 = f3;
                        }
                    }
                    a4.f.e(f6, f2, f7);
                    dVar = a;
                    a4.f.b(new p(0.0f, 1.0f, 0.0f), f5);
                    umVar.a(a4);
                } else {
                    dVar = a;
                    koVar = a2;
                }
                float f9 = f4 - 0.2f;
                float f10 = f2 - 0.1f;
                Log.i("Parking3DPresenter", "parkLotEntity.getDir()1 = " + upVar.t());
                if (upVar.t() == 1) {
                    f3 -= 0.3f;
                    if (d.n()) {
                        f10 += 0.03f;
                        f9 -= 0.1f;
                    }
                } else if (upVar.t() == 2) {
                    f3 -= 0.3f;
                    if (d.n()) {
                        f10 += 0.03f;
                        f9 -= 0.1f;
                    }
                } else if (upVar.u()) {
                    f3 = d.n() ? f3 - 0.4f : f3 - 0.6f;
                } else if (d.n()) {
                    f3 -= 0.3f;
                }
                if (a3 != null) {
                    if (i == -9 || i == -11 || i == -12 || i == -13) {
                        f10 += 0.3f;
                    }
                    a3.f.c();
                    a3.f.e(f3, f10, f9);
                    umVar.b(a3);
                }
            } else {
                dVar = a;
                koVar = a2;
            }
            koVar2 = koVar;
        } else {
            dVar = a;
            if (upVar instanceof uv) {
                if (d.n()) {
                    ((uv) upVar).a(k_, z, z2);
                } else {
                    ((uv) upVar).a((la) null, z, z2);
                }
                koVar2 = ((uv) upVar).a(this.l, an);
            } else if (upVar instanceof uu) {
                uu uuVar = (uu) upVar;
                uuVar.a(k_, z);
                koVar2 = uuVar.a(this.l, an);
            }
        }
        k_.b.a(0).a(ln.a(koVar2));
        k_.b("mat_dot").a(lf.b(0.5176471f, 0.627451f, 0.6862745f, 1.0f));
        dVar.b(d);
        return k_;
    }

    protected void I() {
        this.k.d();
    }

    protected void c(ArrayList<uj> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<uj> it = arrayList.iterator();
        while (it.hasNext()) {
            this.k.a((a<uj>) it.next());
        }
        this.c.a((a) this.k);
    }

    @Override // defpackage.tj
    public ArrayList<uj> k() {
        uj d;
        float a = g.a(uj.class);
        I();
        f fVar = this.a;
        if (fVar == null || !(fVar instanceof h)) {
            return null;
        }
        h hVar = (h) fVar;
        ArrayList<ParkLotItem> d2 = hVar.N().d();
        ArrayList<uj> arrayList = (d2 == null || d2.size() <= 0) ? null : new ArrayList<>();
        if (arrayList == null) {
            return null;
        }
        for (int i = 0; i < d2.size(); i++) {
            ParkLotItem parkLotItem = d2.get(i);
            if (parkLotItem != null) {
                acp acpVar = parkLotItem.getmCenter();
                float a2 = a(parkLotItem);
                p pVar = new p((-acpVar.b) * uc.c, a, (-acpVar.a) * uc.c);
                parkLotItem.isFree();
                if (ParkLotRData.isItemUnfree(parkLotItem.getTag()) && (d = this.c.d()) != null) {
                    d.a(hVar);
                    d.b("model/entity/jiaoche.g3db");
                    d.e();
                    if (parkLotItem.getDir() == 1) {
                        d.a(pVar, a2 + 90.0f);
                    } else if (parkLotItem.getDir() == 2) {
                        d.a(pVar, a2 - 90.0f);
                    } else {
                        d.a(pVar, a2);
                    }
                    arrayList.add(d);
                }
            }
        }
        c(arrayList);
        a(arrayList);
        return arrayList;
    }

    protected float a(ParkLotItem parkLotItem) {
        float angle;
        if (!parkLotItem.isLeft()) {
            angle = parkLotItem.getAngle();
        } else {
            angle = parkLotItem.getAngle() + 180.0f;
        }
        return -angle;
    }

    private Matrix4 b(ParkLotItem parkLotItem) {
        float f;
        Matrix4 matrix4 = new Matrix4();
        float f2 = parkLotItem.getmLenthBE();
        float f3 = parkLotItem.getmLenthBC();
        float f4 = up.h * uc.g;
        int i = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
        float f5 = f2 / (up.i * uc.g);
        if (parkLotItem.getDir() == 1 || parkLotItem.getDir() == 2) {
            if (f2 > f3) {
                f2 = f3;
            }
            f = f2 / f4;
        } else {
            if (f2 <= f3) {
                f2 = f3;
            }
            f = f2 / f4;
        }
        if (parkLotItem.getDir() != 1 && parkLotItem.getDir() != 2) {
            matrix4.d(f, 1.0f, f5);
        } else {
            matrix4.d(1.0f, 1.0f, 0.85f);
        }
        return matrix4;
    }

    public int J() {
        f fVar = this.a;
        if (fVar == null || !(fVar instanceof h)) {
            return 0;
        }
        return ((h) fVar).S();
    }

    @Override // defpackage.tj
    public up l() {
        f fVar = this.a;
        if (fVar == null || !(fVar instanceof h)) {
            return null;
        }
        return ((h) fVar).aa();
    }

    @Override // defpackage.tj
    public uf m() {
        f fVar = this.a;
        if (fVar == null || !(fVar instanceof h)) {
            return null;
        }
        return ((h) fVar).X();
    }

    @Override // defpackage.tj
    public void a(ArrayList<uj> arrayList, float f, boolean z) {
        le leVar = new le(770, 771);
        Iterator<uj> it = arrayList.iterator();
        while (it.hasNext()) {
            uj next = it.next();
            leVar.f = f;
            if (next != null && next.k_() != null) {
                Iterator<kx> it2 = next.k_().b.iterator();
                while (it2.hasNext()) {
                    it2.next().a(leVar);
                }
            }
        }
    }

    public boolean b(int i) {
        return i == J();
    }

    @Override // defpackage.tj
    public void a(int i, int i2) {
        Log.i("Parking3DPresenter", "last sence:" + i + "\tcurentSence:" + i2 + "\tcurrenTip :" + ((h) this.a).o().e());
        this.l = i2;
        this.n.a(false);
        f fVar = this.a;
        if (fVar instanceof h) {
            fVar.b(false);
            this.a.d(false);
        }
        if (i2 != 0) {
            E();
        } else if (i2 != 7) {
            D();
        }
        if (i2 != 1) {
            O();
        }
        int i3 = this.l;
        if (i3 != -9 && i3 != -11) {
            this.n.d();
        }
        this.m.a(false);
        up l = l();
        if (l != null) {
            ((uu) l).j();
        }
        b(i, i2);
    }

    @Override // defpackage.tj
    public void u() {
        this.n.d();
    }

    @Override // defpackage.tj
    public ArrayList<up> v() {
        return this.e;
    }

    public void b(int i, int i2) {
        switch (i2) {
            case 0:
                this.m.o(this, this.a, this.n, i);
                return;
            case 1:
                this.m.m(this, this.a, this.n, i);
                return;
            case 2:
                this.m.j(this, this.a, this.n, i);
                return;
            case 3:
                this.m.k(this, this.a, this.n, i);
                return;
            case 4:
                this.m.l(this, this.a, this.n, i);
                return;
            case 5:
            default:
                this.m.a(this.n, i2, i);
                return;
            case 6:
                this.m.n(this, this.a, this.n, i);
                return;
            case 7:
                this.m.q(this, this.a, this.n, i);
                return;
            case 8:
                this.m.r(this, this.a, this.n, i);
                return;
            case 9:
                this.m.p(this, this.a, this.n, i);
                return;
        }
    }

    private void B() {
        this.a.j();
        this.a.a(null, 0.0f, null);
        this.a.a(false);
        this.a.i();
        this.a.h();
    }

    private float N() {
        if (l() == null || m() == null) {
            return 0.0f;
        }
        p v = l().v();
        p h = m().h();
        if (d.c()) {
            Log.i("Parking3DPresenter", "getParkingBDst.selectedPos = " + v + ",carPos = " + h);
        }
        return v.d(h);
    }

    private void O() {
        Log.d("Parking3DPresenter", "parkingBParams");
        this.v = -1.0f;
        this.w = false;
    }

    public void K() {
        Log.d("Parking3DPresenter", "enableParkingBCamChange.mParking3DView.getCurrentCamera().position = " + this.a.n().a);
        this.t.a(this.a.n().a);
        this.u.a(this.a.n().b);
        this.v = N();
        this.w = true;
        Log.d("Parking3DPresenter", "enableParkingBCamChange: " + this.t + "," + this.v);
    }

    public void L() {
        if (P().N().g()) {
            F();
        } else {
            G();
        }
    }

    @Override // defpackage.tj
    public void a(int i) {
        n();
    }

    private h P() {
        return (h) this.a;
    }

    @Override // defpackage.tj
    public boolean p() {
        return this.y;
    }

    @Override // defpackage.tj
    public boolean q() {
        return this.n.o();
    }

    public void M() {
        this.n.r();
    }

    @Override // defpackage.tj
    public int r() {
        f fVar = this.a;
        if (fVar == null || !(fVar instanceof h)) {
            return 0;
        }
        h hVar = (h) fVar;
        if (hVar.N().d() != null) {
            return hVar.N().d().size();
        }
        return 0;
    }

    @Override // defpackage.tj
    public void a(boolean z) {
        Log.i("Parking3DPresenter", "setNoHasParkingLots.hasNoParkingLots = " + z);
        this.y = z;
    }
}
