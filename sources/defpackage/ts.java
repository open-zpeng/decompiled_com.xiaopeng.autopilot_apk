package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.model.IParkingModelPro;
import com.xiaopeng.autopilot.parking.model.ParkingModelPro;
import com.xiaopeng.autopilot.parking.view.e;
import com.xiaopeng.autopilot.parking.view.f;
import com.xiaopeng.autopilot.parking.view.g3d.b;
import com.xiaopeng.autopilot.parking.view.g3d.c;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.autopilot.parking.view.i;
import com.xiaopeng.autopilot.parking.view.j;
import com.xiaopeng.autopilot.parking.view.k;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.ThreadUtils;
import defpackage.a;
import defpackage.ahz;
import defpackage.b;
import defpackage.sd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: Parking3DPresenterPro.java */
/* renamed from: ts  reason: default package */
/* loaded from: classes.dex */
public class ts extends tr implements tk {
    private List<up> A;
    private List<sl> D;
    private sy K;
    private rw M;
    private sz P;
    private List<up> R;
    private List<su> S;
    private rx V;
    private sd Z;
    private se ab;
    private p ak;
    private j au;
    private i av;
    e o;
    private IParkingModelPro u;
    private tp v;
    private tq w;
    private tl x;
    private List<up> y = new ArrayList();
    private HashMap<Integer, List<up>> z = new HashMap<>();
    private Map<Integer, List<sl>> B = new HashMap();
    private HashMap<Integer, List<sl>> C = new HashMap<>();
    private ArrayList<up> E = new ArrayList<>();
    private List<sl> G = new ArrayList();
    private List<sl> H = new ArrayList();
    private List<sl> I = new ArrayList();
    private List<sl> J = new ArrayList();
    private a<rz> L = new a<>();
    private List<p> N = new ArrayList();
    private List<Integer> O = new ArrayList();
    private a<sf> Q = new a<>();
    private Matrix4 T = new Matrix4();
    private Matrix4 U = new Matrix4();
    private List<sc> W = new ArrayList();
    private List<sc> X = new ArrayList();
    private List<sc> Y = new ArrayList();
    private List<sc> aa = new ArrayList();
    private List<up> ac = new ArrayList();
    private List<p> ad = new ArrayList();
    private Matrix4 ae = null;
    private Matrix4 af = null;
    private a<rz> ag = new a<>();
    private LinkedList<Integer> ah = new LinkedList<>();
    private Matrix4 ai = new Matrix4();
    private Matrix4 aj = new Matrix4();
    private p al = new p();
    private p am = new p();
    private p an = new p();
    private p ao = new p();
    private volatile boolean ap = false;
    private Object aq = new Object();
    private final Matrix4 ar = new Matrix4().c();
    private int as = 0;
    private boolean at = true;
    boolean p = false;
    Runnable q = new Runnable() { // from class: ts.4
        @Override // java.lang.Runnable
        public void run() {
            if (ts.this.a != null) {
                k kVar = (k) ts.this.a;
                if (kVar.X() != null) {
                    ((c) kVar.X()).onDrivingDataRefresh(ts.this.u.getLocationData());
                }
            }
        }
    };
    Runnable r = new Runnable() { // from class: ts.5
        @Override // java.lang.Runnable
        public void run() {
            PerformanceTestUnit.logStart("Parking3DPresenterPro");
            if (!(((i.au) com.xiaopeng.autopilot.base.i.a(i.au.class)).d().intValue() == 1)) {
                ts tsVar = ts.this;
                tsVar.a(tsVar.u.getLocationData());
            }
            PerformanceTestUnit.logEnd("Parking3DPresenterPro", "refreshStaticMapData");
        }
    };
    int s = 0;
    int t = 0;
    private sk F = new sk();

    @Override // defpackage.tr
    protected void D() {
    }

    @Override // defpackage.tr
    protected void E() {
    }

    @Override // defpackage.tr, defpackage.tj
    public ArrayList<uj> k() {
        return null;
    }

    public p N() {
        if (this.ak == null) {
            this.ak = new p();
        }
        return this.ak;
    }

    public List<sl> O() {
        if (this.D == null) {
            this.D = new CopyOnWriteArrayList();
        }
        return this.D;
    }

    public void a(Matrix4 matrix4) {
        this.ae = matrix4;
    }

    public List<up> P() {
        if (this.R == null) {
            this.R = new CopyOnWriteArrayList();
        }
        return this.R;
    }

    public List<su> Q() {
        if (this.S == null) {
            this.S = new CopyOnWriteArrayList();
        }
        return this.S;
    }

    public List<up> R() {
        if (this.A == null) {
            this.A = new ArrayList();
        }
        return this.A;
    }

    private e as() {
        if (this.a instanceof e) {
            return (e) this.a;
        }
        return null;
    }

    @Override // defpackage.tr, defpackage.tj
    public void a(f fVar) {
        super.a(fVar);
        if (fVar instanceof e) {
            this.o = (e) fVar;
        }
        this.au = new j();
        this.av = new com.xiaopeng.autopilot.parking.view.i();
        this.av.a(fVar, this, this.au);
        this.v = new tx();
    }

    public void a(ParkingModelPro parkingModelPro) {
        this.u = parkingModelPro;
        this.u.bind3D(this);
        this.u.initMap();
        this.K = new sy(16, 16);
        this.P = new sz(24, 30);
    }

    private void a(float f, int i) {
        StringBuffer stringBuffer = PerformanceTestUnit.mTmpSb;
        stringBuffer.setLength(0);
        stringBuffer.append("floorInfo allPathRoad:\t");
        a.c locationData = this.u.getLocationData();
        if (locationData == null) {
            return;
        }
        System.currentTimeMillis();
        stringBuffer.append("{x:" + locationData.a().a() + ",y:" + locationData.a().b() + ",z:" + locationData.a().c() + "}\t");
        List<ahz.c.h> floorList = this.u.getFloorList();
        if (floorList != null) {
            for (ahz.c.h hVar : floorList) {
                stringBuffer.append("{");
                stringBuffer.append("level:");
                stringBuffer.append(hVar.a());
                stringBuffer.append("\tupper:");
                stringBuffer.append(hVar.b());
                stringBuffer.append("\tlower:");
                stringBuffer.append(hVar.c());
                stringBuffer.append("}\t");
            }
        }
        stringBuffer.append("\tresult floorNumInfo floorNum:" + i);
        PerformanceTestUnit.log("debugFloorInfo", stringBuffer.toString(), 5000L, true);
    }

    @Override // defpackage.tk
    public int a(float f) {
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        List<ahz.c.h> floorList = this.u.getFloorList();
        int i = 0;
        if (floorList == null) {
            PerformanceTestUnit.log("Parking3DPresenterPro", "floor datas is null", 2000L);
            return 0;
        }
        Iterator<ahz.c.h> it = floorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ahz.c.h next = it.next();
            float b = next.b();
            float c = next.c();
            int a = next.a();
            if (f > c && f < b) {
                i = a;
                break;
            }
        }
        a(f, i);
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "getFloorNumByZPosition");
        return i;
    }

    private boolean a(up upVar) {
        if (upVar instanceof sf) {
            return ((sf) upVar).h();
        }
        return true;
    }

    public List<up> a(int i, boolean z) {
        synchronized (this.aq) {
            if (this.ap) {
                if (this.z.containsKey(Integer.valueOf(i))) {
                    boolean z2 = i.r.e().intValue() == 2;
                    this.ag.d();
                    R().clear();
                    a.c locationData = this.u.getLocationData();
                    Matrix4 c = z2 ? this.ai.c() : tz.a(locationData).d();
                    this.as = this.z.get(Integer.valueOf(i)).size();
                    for (up upVar : this.z.get(Integer.valueOf(i))) {
                        if (a(locationData, c, upVar, z) && upVar.p() == i && b(upVar) && a(upVar)) {
                            R().add(upVar);
                        }
                    }
                    List<up> R = R();
                    this.K.a((com.badlogic.gdx.utils.a) this.ag);
                    return R;
                }
                return null;
            }
            return null;
        }
    }

    private boolean a(a.c cVar, Matrix4 matrix4, up upVar, boolean z) {
        boolean z2;
        if (cVar == null || cVar.a() == null) {
            return false;
        }
        p pVar = new p(cVar.a().a(), cVar.a().b(), cVar.a().c());
        if (upVar == null || upVar.k_() == null || !(upVar instanceof sf)) {
            return false;
        }
        sf sfVar = (sf) upVar;
        float d = pVar.d(sfVar.i());
        if (z) {
            z2 = true;
        } else {
            z2 = d < 50.0f;
        }
        sfVar.b(z2);
        if (z2) {
            Matrix4 I = upVar.I();
            if (I != null && upVar.k_() != null && upVar.k_().f != null) {
                upVar.k_().f.c();
                upVar.k_().f.b(matrix4);
                upVar.k_().f.b(I);
                upVar.k_().f.b(this.ai.c().e(0.0f, 0.1f, 0.0f));
                if (sfVar.m()) {
                    up l = sfVar.l();
                    if (l instanceof rz) {
                        if (sfVar.k_() != null) {
                            l.b(sfVar.k_().f);
                        }
                        if (sfVar.n()) {
                            l.k_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                            ((rz) l).l_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                        }
                    }
                }
            }
            if (sfVar.j()) {
                a(sfVar.j(), false, ((k) this.a).P(), (up) sfVar, sfVar.z(), sfVar.A());
            } else {
                sfVar.a((la) null, false, false);
            }
            sfVar.g(true);
            if (upVar.k_() != null && upVar.k_().f != null) {
                upVar.k_().f.f(0.825f, 1.0f, 0.845f);
            }
            if (!this.ah.contains(Integer.valueOf(sfVar.r())) || sfVar.m()) {
                return z2;
            }
            rz rzVar = new rz("model/entity/jiaoche.g3db");
            rzVar.a((ach) this.o);
            rzVar.a(false);
            rzVar.a(sfVar.k_().f);
            if (sfVar.n()) {
                rzVar.k_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                rzVar.l_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
            }
            sfVar.a(rzVar);
            return z2;
        }
        return z2;
    }

    public ArrayList<up> b(boolean z) {
        List<a.k> dynamicSlotLists;
        IParkingModelPro iParkingModelPro = this.u;
        ArrayList<up> arrayList = null;
        if (iParkingModelPro == null || (dynamicSlotLists = iParkingModelPro.getDynamicSlotLists()) == null) {
            return null;
        }
        this.ah.clear();
        this.O.clear();
        boolean booleanValue = ((i.e) com.xiaopeng.autopilot.base.i.a(i.e.class)).d().booleanValue();
        int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
        a.c locationData = this.u.getLocationData();
        Matrix4 d = locationData.f() == 1 ? tz.a(locationData).d() : this.ar.c();
        for (a.k kVar : dynamicSlotLists) {
            int j = kVar.j();
            int e = kVar.e();
            int n = kVar.n();
            if (j == 0 && e == 0) {
                this.ah.add(Integer.valueOf(n));
            }
            if (n > 0) {
                if (booleanValue) {
                    if (kVar.o() == 1) {
                        this.O.add(Integer.valueOf(n));
                    }
                } else {
                    this.O.add(Integer.valueOf(n));
                }
            }
            if (booleanValue) {
                if (kVar.o() == 1) {
                    if (i.r.e().intValue() == 2) {
                        d = this.ar.c();
                    }
                    if (z) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        up a = a(kVar, d);
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
            } else if (intValue == -3 && kVar.o() != 1 && kVar.j() != 0) {
            }
        }
        return arrayList;
    }

    private boolean b(up upVar) {
        return !this.O.contains(new Integer(upVar.r()));
    }

    @Override // defpackage.tr
    protected void H() {
        super.H();
        if (this.Q.b > 0) {
            this.Q.d();
        }
        if (this.L.b > 0) {
            this.L.d();
        }
    }

    @Override // defpackage.tr
    protected void b(ArrayList<up> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<up> it = arrayList.iterator();
            while (it.hasNext()) {
                up next = it.next();
                if (next instanceof sf) {
                    this.Q.a((com.badlogic.gdx.utils.a<sf>) ((sf) next));
                } else if (next instanceof um) {
                    this.h.a((com.badlogic.gdx.utils.a<um>) ((um) next));
                } else if (next instanceof uv) {
                    this.g.a((com.badlogic.gdx.utils.a<uv>) ((uv) next));
                } else if (next instanceof uu) {
                    this.i.a((com.badlogic.gdx.utils.a<uu>) ((uu) next));
                }
            }
            if (this.Q.b > 0) {
                this.P.freeAll(this.Q);
            }
            if (this.h.b > 0) {
                this.b.e().a((com.badlogic.gdx.utils.a) this.h);
            }
            if (this.g.b > 0) {
                this.b.f().a((com.badlogic.gdx.utils.a) this.g);
            }
            if (this.i.b > 0) {
                this.b.g().a((com.badlogic.gdx.utils.a) this.i);
            }
        }
        if (this.f.b > 0) {
            this.b.a().a((com.badlogic.gdx.utils.a) this.f);
        }
        if (this.j.b > 0) {
            this.b.b().a((com.badlogic.gdx.utils.a) this.j);
        }
        if (this.L.b > 0) {
            this.K.a((com.badlogic.gdx.utils.a) this.L);
        }
    }

    public ArrayList<sl> S() {
        List<b.d> apDynaObjectDataList = this.u.getApDynaObjectDataList();
        if (apDynaObjectDataList == null) {
            return null;
        }
        this.F.a(this.G);
        ArrayList<sl> arrayList = new ArrayList<>();
        for (b.d dVar : apDynaObjectDataList) {
            sl a = this.F.a(dVar);
            if (a != null) {
                float a2 = dVar.d().a();
                float b = dVar.d().b();
                float c = dVar.d().c();
                dVar.c().c();
                dVar.c().b();
                float a3 = (dVar.c().a() * 57.29578f) - 90.0f;
                p a4 = tz.a(a2, b, c);
                a.a(a4.a, a4.b, a4.c);
                a.a();
                a.a((ach) as());
                a.k();
                a.a(dVar.e());
                if (a.k_() != null) {
                    a.c locationData = this.u.getLocationData();
                    Matrix4 a5 = tz.a(a4, a3);
                    Matrix4 d = tz.a(locationData).d();
                    a.k_().f.c();
                    a.k_().f.b(d);
                    a.k_().f.b(a5);
                    a.k_().f.e(0.0f, g.a(sl.class), 0.0f);
                }
                arrayList.add(a);
            }
        }
        this.G.clear();
        this.G.addAll(arrayList);
        return arrayList;
    }

    public ArrayList<sl> T() {
        List<b.q> apStaticObjectDataList = this.u.getApStaticObjectDataList();
        if (apStaticObjectDataList == null) {
            return null;
        }
        this.F.a(this.H);
        ArrayList<sl> arrayList = new ArrayList<>();
        for (b.q qVar : apStaticObjectDataList) {
            Log.i("Parking3DPresenterPro", "position id" + qVar.a() + "   x:" + qVar.a(0) + "   y:" + qVar.a(1));
            sl a = this.F.a(qVar);
            if (a != null) {
                float a2 = (((float) qVar.a(3)) * 57.29578f) - 90.0f;
                p a3 = tz.a((float) qVar.a(0), (float) qVar.a(1), (float) qVar.a(2));
                a.a(a3.a, a3.b, a3.c);
                a.a();
                a.a((ach) as());
                a.k();
                if (a.k_() != null) {
                    a.c locationData = this.u.getLocationData();
                    Matrix4 a4 = tz.a(a3, a2);
                    Matrix4 d = tz.a(locationData).d();
                    a.k_().f.c();
                    a.k_().f.b(d);
                    a.k_().f.b(a4);
                    a.k_().f.e(0.0f, g.a(sl.class), 0.0f);
                }
                arrayList.add(a);
            }
        }
        this.H.clear();
        this.H.addAll(arrayList);
        return arrayList;
    }

    @Override // defpackage.tr, defpackage.tj
    public ArrayList<up> j() {
        List<a.k> dynamicSlotLists = this.u.getDynamicSlotLists();
        H();
        if (dynamicSlotLists == null || dynamicSlotLists.size() == 0) {
            this.e.clear();
            return null;
        }
        boolean booleanValue = ((i.e) com.xiaopeng.autopilot.base.i.a(i.e.class)).d().booleanValue();
        int intValue = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
        ArrayList<up> arrayList = new ArrayList<>();
        a.c locationData = this.u.getLocationData();
        Matrix4 d = locationData.f() == 1 ? tz.a(locationData).d() : new Matrix4().c();
        if (intValue == -9 || intValue == -10) {
            d = tz.b(locationData).d();
        }
        for (a.k kVar : dynamicSlotLists) {
            if (intValue != -12 && intValue != -13) {
                if (booleanValue) {
                    if (kVar.o() != 1) {
                    }
                } else if (intValue == -3 && kVar.o() != 1 && kVar.j() != 0) {
                }
            }
            up a = a(kVar, d);
            if (a != null) {
                arrayList.add(a);
            }
        }
        b(arrayList);
        this.e.clear();
        this.e.addAll(arrayList);
        return arrayList;
    }

    private up a(a.k kVar, Matrix4 matrix4) {
        up upVar;
        int i;
        sf sfVar;
        a.c locationData = this.u.getLocationData();
        boolean z = locationData.f() == 1;
        float a = g.a(up.class);
        float a2 = g.a(uu.class);
        float a3 = g.a(um.class);
        float a4 = g.a(uv.class);
        a(kVar);
        p c = tz.c(kVar);
        this.al.a(kVar.a().a(), kVar.a().b(), kVar.a().c());
        this.am.a(kVar.b().a(), kVar.b().b(), kVar.b().c());
        this.an.a(kVar.c().a(), kVar.c().b(), kVar.c().c());
        this.ao.a(kVar.d().a(), kVar.d().b(), kVar.d().c());
        c cVar = (c) m();
        up upVar2 = null;
        if (kVar.j() == 0) {
            int P = ((k) this.a).P();
            int h = kVar.h();
            sf obtain = this.P.obtain();
            if (h == 1 || h == 2) {
                obtain.b("model/entity/weizhichewei_Lateral.g3db");
            } else {
                obtain.b("model/entity/weizhichewei.g3db");
            }
            if (kVar.e() == 0 && kVar.o() != 1) {
                obtain.a(this.K.d());
            } else {
                obtain.a((rz) null);
            }
            obtain.a(true);
            if (obtain.k_() == null) {
                Log.w("Parking3DPresenterPro", "modelinstance is null ");
                return null;
            }
            obtain.a(matrix4, tz.a(kVar, locationData, a4));
            obtain.e(kVar.f());
            obtain.e(false);
            obtain.d(kVar.h());
            obtain.b(a(kVar.a().c()));
            obtain.c(kVar.o() == 1);
            if (kVar.o() != 1) {
                sfVar = obtain;
            } else if (obtain.a(z, cVar.f(), this.al, this.am, this.an, this.ao)) {
                sfVar = obtain;
                a(kVar.o() == 1, kVar.e() == 0, P, obtain, obtain.z(), obtain.A());
                upVar2 = sfVar;
            } else {
                sfVar = obtain;
            }
            sfVar.a((la) null, false, false);
            upVar2 = sfVar;
        } else if (kVar.j() == 1) {
            int P2 = ((k) this.a).P();
            up a5 = this.b.a(kVar, P2);
            a5.a(false);
            if (a5 instanceof uu) {
                a = a2;
            } else if (a5 instanceof um) {
                a = a3;
            }
            Matrix4 a6 = tz.a(kVar, locationData, a);
            if (a5.k_() == null) {
                Log.w("Parking3DPresenterPro", "parkLotEntity modelinstance is null ");
                return null;
            }
            a5.k_().f.c();
            if (matrix4 != null) {
                a5.k_().f.b(matrix4);
            }
            a5.k_().f.b(a6);
            int h2 = kVar.h();
            a5.d((h2 == 3) | (h2 == 1));
            a5.d(kVar.h());
            a5.b(a(kVar.a().c()));
            a5.c(c);
            a5.a(kVar.n());
            a5.e(kVar.f());
            a5.e(true);
            if (kVar.o() == 1) {
                upVar = a5;
                i = P2;
                if (a5.a(z, cVar.f(), this.al, this.am, this.an, this.ao)) {
                    a(kVar.o() == 1, false, i, upVar, upVar.z(), upVar.A());
                    upVar2 = upVar;
                }
            } else {
                upVar = a5;
                i = P2;
            }
            a(false, false, i, upVar, upVar.z(), upVar.A());
            upVar2 = upVar;
        }
        if (upVar2 != null) {
            upVar2.k_().f.f(0.845f, 1.0f, 0.845f);
        }
        return upVar2;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IMapMessageChangeListener
    public void onMapMessageRefresh() {
        af();
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IMapMessageChangeListener
    public void onStaticRoadMapRefresh() {
        PerformanceTestUnit.log("Parking3DPresenterPro", "allRoad >> allPathRoad onStaticRoadMapRefresh!", true);
        io.a.postRunnable(new Runnable() { // from class: ts.1
            @Override // java.lang.Runnable
            public void run() {
                ts.this.ah();
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IMapMessageChangeListener
    public void onMapTrainingRsMessageRefresh() {
        PerformanceTestUnit.log("Parking3DPresenterPro", "TrainingModel_flag Training Rs ！", true);
        if (this.o != null) {
            ai();
            aj();
        }
    }

    public void U() {
        int a;
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK >  initStaticMapLandmarks start", true);
        List<ahz.c.n> landmarksTypeDataList = this.u.getLandmarksTypeDataList();
        if (landmarksTypeDataList == null || landmarksTypeDataList.size() == 0) {
            Log.i("Parking3DPresenterPro", "initStaticMapLandmarks staticMap  no landmarks ");
            return;
        }
        PerformanceTestUnit.log("Parking3DPresenterPro", "initStaticMapLandmarks staticMap >  getLandmarksTypeDataList = " + landmarksTypeDataList.size() + "\tthread:" + Thread.currentThread().getName(), true);
        ArrayList arrayList = new ArrayList(landmarksTypeDataList);
        Map<Integer, List<sl>> map = this.B;
        if (map != null && map.size() > 0) {
            for (Integer num : this.B.keySet()) {
                List<sl> list = this.B.get(num);
                if (list != null && list.size() > 0) {
                    for (sl slVar : list) {
                        slVar.dispose();
                    }
                }
            }
        }
        this.B.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ahz.c.n nVar = (ahz.c.n) it.next();
            if (d.k()) {
                a = nVar.h().a();
                if (a != nVar.h().b()) {
                }
            } else {
                a = a(nVar.d());
            }
            int a2 = nVar.a();
            sl slVar2 = null;
            if (a2 == 1) {
                slVar2 = new su();
            } else if (a2 == 7) {
                slVar2 = new ss();
            } else if (a2 == 9) {
                slVar2 = new sg();
            } else if (a2 != 10) {
                Log.e("Parking3DPresenterPro", "unsupport type :\t" + a2);
            } else if (nVar.e() >= 0 && nVar.e() <= 10) {
                slVar2 = new sq(nVar.e());
            } else {
                Log.e("Parking3DPresenterPro", "unsupport arrow type: " + nVar.e());
            }
            if (slVar2 != null) {
                float b = nVar.b();
                float c = nVar.c();
                float d = nVar.d();
                float f = nVar.f();
                p c2 = tz.c(b, c, d);
                slVar2.a(c2.a, c2.b, c2.c);
                slVar2.a();
                slVar2.a((ach) as());
                boolean z = slVar2 instanceof ss;
                if (z) {
                    ((ss) slVar2).b(true);
                } else {
                    slVar2.k();
                }
                if (slVar2.k_() != null) {
                    if (slVar2 instanceof su) {
                        Matrix4 a3 = tz.a(c2, f);
                        slVar2.k_().f.c();
                        slVar2.k_().f.b(a3);
                        su suVar = (su) slVar2;
                        suVar.a(a3);
                        suVar.b(new p(b, c, d));
                    } else if (z) {
                        Matrix4 a4 = tz.a(c2, 0.0f);
                        slVar2.k_().f.c();
                        slVar2.k_().f.b(a4);
                        ss ssVar = (ss) slVar2;
                        ssVar.a(a4);
                        ssVar.b(new p(b, c, d));
                    } else if (slVar2 instanceof sg) {
                        Matrix4 a5 = tz.a(c2, 0.0f);
                        slVar2.k_().f.c();
                        slVar2.k_().f.b(a5);
                        sg sgVar = (sg) slVar2;
                        sgVar.a(a5);
                        sgVar.b(new p(b, c, d));
                    } else if (slVar2 instanceof sq) {
                        Matrix4 a6 = tz.a(c2, f);
                        slVar2.k_().f.c();
                        slVar2.k_().f.b(a6);
                        sq sqVar = (sq) slVar2;
                        sqVar.a(a6);
                        sqVar.b(new p(nVar.b(), nVar.c(), nVar.d()));
                    }
                }
                slVar2.a(a);
                f(a).add(slVar2);
            }
        }
        at();
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "initStaticMapLandmarks");
    }

    private void at() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer num : this.B.keySet()) {
            stringBuffer.append("\tfloorNum:");
            stringBuffer.append(num);
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (sl slVar : this.B.get(num)) {
                if (slVar instanceof ss) {
                    i++;
                }
                if (slVar instanceof su) {
                    i2++;
                }
                if (slVar instanceof sg) {
                    i3++;
                }
                if (slVar instanceof sq) {
                    i4++;
                }
            }
            stringBuffer.append("\tpillarsNum:");
            stringBuffer.append(i);
            stringBuffer.append("\tspeedNum:");
            stringBuffer.append(i2);
            stringBuffer.append("\tantiCollisionPilarNum:");
            stringBuffer.append(i3);
            stringBuffer.append("\tpathArrowNum:");
            stringBuffer.append(i4);
        }
        PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK > initStaticMapLandmarks finish staticMapLandmraksInfo: " + stringBuffer.toString(), true);
    }

    public p V() {
        sd.a c;
        p g;
        p pVar = new p();
        a.c locationData = this.u.getLocationData();
        if (d.j()) {
            c = ac().c(666);
        } else {
            c = ac().c(ag());
        }
        if (c != null && (g = c.g()) != null) {
            pVar.a(g);
        }
        Log.i("Parking3DPresenterPro", "singFloorCenter = " + pVar);
        pVar.a(tz.a(locationData).d());
        return pVar;
    }

    public float W() {
        sd.a c;
        if (d.j()) {
            c = ac().c(666);
        } else {
            c = ac().c(ag());
        }
        if (c != null) {
            return c.h();
        }
        return 0.0f;
    }

    public int X() {
        return this.as;
    }

    public p Y() {
        return this.x.f();
    }

    public float Z() {
        return this.x.g();
    }

    public int aa() {
        return this.x.a(true).size();
    }

    public void ab() {
        int a;
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        if (as() != null && !this.w.g()) {
            PerformanceTestUnit.log("Parking3DPresenterPro", "initStaticMapParklotEntities initStaticMap data process > asset load unfinished error!", true);
            return;
        }
        synchronized (this.aq) {
            for (Map.Entry<Integer, List<up>> entry : this.z.entrySet()) {
                for (up upVar : entry.getValue()) {
                    upVar.dispose();
                }
            }
            this.z.clear();
        }
        List<ahz.c.ab> slotTypeList = this.u.getSlotTypeList();
        if (slotTypeList == null) {
            Log.e("Parking3DPresenterPro", "initStaticMapParklotEntities  initStaticMap data process slots-typs is null");
            return;
        }
        Iterator<ahz.c.ab> it = slotTypeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ahz.c.ab next = it.next();
            p c = tz.c(next.c(), next.d(), next.e());
            int a2 = next.a();
            float f = next.f() + 180.0f;
            int b = next.b();
            sf sfVar = new sf();
            if (b == 1 || b == 2) {
                sfVar.b("model/entity/weizhichewei_Lateral.g3db");
            } else {
                sfVar.b("model/entity/weizhichewei.g3db");
            }
            sfVar.a(next.e());
            sfVar.a(true);
            sfVar.a(c, f);
            sfVar.a(c.a, c.b, c.c);
            sfVar.b(new p(next.c(), next.d(), next.e()));
            sfVar.c(a2);
            if (d.k()) {
                a = next.i().a();
                if (a != next.i().b()) {
                }
            } else {
                a = a(next.e());
            }
            sfVar.b(a);
            sfVar.c(next.h().a() == 1);
            if (this.z.containsKey(Integer.valueOf(a))) {
                this.z.get(Integer.valueOf(a)).add(sfVar);
            } else {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(sfVar);
                this.z.put(Integer.valueOf(a), copyOnWriteArrayList);
            }
        }
        this.ap = true;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(0);
        if (this.z.size() > 0) {
            stringBuffer.append("{");
            for (Integer num : this.z.keySet()) {
                stringBuffer.append(num);
                stringBuffer.append(":");
                stringBuffer.append(this.z.get(num) != null ? Integer.valueOf(this.z.get(num).size()) : "0");
            }
            stringBuffer.append(" ; mStaticMapParkLotDataReady : true");
            stringBuffer.append("}");
        }
        PerformanceTestUnit.log("Parking3DPresenterPro", "initStaticMapParklotEntities initStaticMap data process > parklots after init " + stringBuffer.toString(), true);
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "initStaticMapParklotEntities");
    }

    public sd ac() {
        if (this.Z == null) {
            this.Z = new sd();
            this.Z.a(this.o.b());
        }
        return this.Z;
    }

    @Override // defpackage.tk
    public List<ahz.c.h> x() {
        return this.u.getFloorList();
    }

    public rv ad() {
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        if (this.w.n_()) {
            float a = ac().a(this.u.getLocationData());
            float remainDis = this.u.getRemainDis();
            boolean z = true;
            boolean z2 = a == -1.0f;
            z = (a >= 5.0f || remainDis >= 5.0f || a == 0.0f) ? false : false;
            if (z2 || z) {
                return null;
            }
            ArrayList<b.o> dynaGuidelineByType = this.u.getDynaGuidelineByType(2);
            a.c locationData = this.u.getLocationData();
            if (dynaGuidelineByType != null && dynaGuidelineByType.size() > 0) {
                if (this.M == null) {
                    this.M = new rw();
                }
                this.M.dispose();
                this.N.clear();
                Matrix4 d = tz.c(locationData).d();
                for (b.o oVar : dynaGuidelineByType) {
                    for (b.m mVar : oVar.b()) {
                        this.N.add(tz.b(mVar.a().a(), mVar.a().b(), mVar.a().c()));
                    }
                }
                la a2 = this.M.a(this.N, this.o.b(), locationData.c() * 3.6f);
                if (a2 != null) {
                    a2.f.c();
                    a2.f.b(d);
                    a2.f.b(this.ai.c().e(0.0f, 0.5f, 0.0f));
                }
            }
            PerformanceTestUnit.logEnd("Parking3DPresenterPro", "initDynaPartOfGuidelineForD");
            return this.M;
        }
        return null;
    }

    public void c(int i) {
        com.badlogic.gdx.utils.a<rz> c;
        PerformanceTestUnit.log("Parking3DPresenterPro", "onSwitchTheme  switchThemeFor30:\t" + i, true);
        w().a(i);
        final boolean isNight = ThemeWatcher.getInstance().isNight();
        io.a.postRunnable(new Runnable() { // from class: ts.2
            @Override // java.lang.Runnable
            public void run() {
                sd ac = ts.this.ac();
                if (ac != null) {
                    if (ThemeWatcher.getInstance().isNight()) {
                        ac.s();
                    } else {
                        ac.r();
                    }
                }
            }
        });
        io.a.postRunnable(new Runnable() { // from class: ts.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : ts.this.z.entrySet()) {
                    for (up upVar : (List) entry.getValue()) {
                        if (isNight) {
                            upVar.f();
                        } else {
                            upVar.e();
                        }
                    }
                }
            }
        });
        sy syVar = this.K;
        if (syVar != null && (c = syVar.c()) != null && c.b > 0) {
            Iterator<rz> it = c.iterator();
            while (it.hasNext()) {
                rz next = it.next();
                if (isNight) {
                    next.f();
                } else {
                    next.e();
                }
            }
        }
        Map<Integer, List<sl>> map = this.B;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Integer num : this.B.keySet()) {
            List<sl> list = this.B.get(num);
            if (list != null && list.size() > 0) {
                for (sl slVar : list) {
                    if (isNight) {
                        slVar.f();
                    } else {
                        slVar.e();
                    }
                }
            }
        }
    }

    @Override // defpackage.tr, defpackage.tj
    public void a(int i) {
        super.a(i);
        c(i);
    }

    @Override // defpackage.tr, defpackage.tj
    public void n() {
        super.n();
        boolean isNight = ThemeWatcher.getInstance().isNight();
        com.xiaopeng.autopilot.parking.view.g3d.e d = this.o.d();
        if (d == null) {
            return;
        }
        if (isNight) {
            d.f();
        } else {
            d.e();
        }
    }

    private void a(a.k kVar) {
        StringBuffer stringBuffer = new StringBuffer("XSlotaData :\t");
        stringBuffer.append("[");
        stringBuffer.append("location z:");
        stringBuffer.append(this.u.getLocationData().a().c());
        stringBuffer.append("hasMap:");
        stringBuffer.append(this.u.getLocationData().f() == 1);
        stringBuffer.append(",");
        stringBuffer.append("id:");
        stringBuffer.append(kVar.n());
        stringBuffer.append(",");
        stringBuffer.append("B_pos:");
        stringBuffer.append("{");
        stringBuffer.append(kVar.a().a());
        stringBuffer.append(",");
        stringBuffer.append(kVar.a().b());
        stringBuffer.append(",");
        stringBuffer.append(kVar.a().c());
        stringBuffer.append("}");
        stringBuffer.append(",");
        stringBuffer.append("type:");
        stringBuffer.append(kVar.j());
        stringBuffer.append(",");
        stringBuffer.append("shape:");
        stringBuffer.append(kVar.h());
        stringBuffer.append("]");
        Log.i("Parking3DPresenterPro", stringBuffer.toString());
    }

    public Matrix4 ae() {
        IParkingModelPro iParkingModelPro = this.u;
        if (iParkingModelPro == null) {
            return this.ai.c();
        }
        Matrix4 d = tz.a(iParkingModelPro.getLocationData()).d();
        Matrix4 matrix4 = this.ae;
        return matrix4 != null ? matrix4.a(d, io.a.getGraphics().getDeltaTime() / 0.4f) : d;
    }

    @Override // defpackage.tr, defpackage.tj
    public boolean t() {
        tq tqVar = this.w;
        boolean c = tqVar != null ? tqVar.c() : false;
        if (c != this.p) {
            this.p = c;
            PerformanceTestUnit.log("canLowFpsRunning", "can lowFpsRunning:" + c, 5000L, true);
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.c cVar) {
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        Matrix4 d = tz.a(cVar).d();
        Matrix4 matrix4 = this.ae;
        if (matrix4 != null) {
            matrix4.a(d, io.a.getGraphics().getDeltaTime() / 1.0f);
        }
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "refreshStaticMapData");
        d.a(new p());
        this.ae = d;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IDrivingDataChangeListener
    public void onDrivingDataRefresh(a.c cVar) {
        io.a.postRunnable(this.q);
        io.a.postRunnable(this.r);
    }

    private void g(int i) {
        if (i == -1 || i == -3 || i == -12 || i == -13) {
            com.xiaopeng.autopilot.parking.view.g3d.d.q = false;
        } else {
            com.xiaopeng.autopilot.parking.view.g3d.d.q = true;
        }
    }

    @Override // defpackage.tr, defpackage.tj
    public void a(int i, int i2) {
        int intValue = ((i.y) com.xiaopeng.autopilot.base.i.a(i.y.class)).d().intValue();
        Log.i("Parking3DPresenterPro", "onSenceChange.curentSence = " + i2 + "," + intValue);
        super.a(i, i2);
        if (i2 >= 0) {
            b.g.d = null;
            b.g.a = null;
            b.g.e = false;
        } else if (((h) this.a).E != null) {
            ((h) this.a).E.a();
        }
        g(i2);
        switch (i2) {
            case -16:
            case -15:
                this.au.e(this, this.a, this.av, i);
                break;
            case -14:
                this.au.h(this, this.a, this.n, i);
                break;
            case -13:
                this.au.f(this, this.a, this.n, i);
                break;
            case -12:
                this.au.g(this, this.a, this.n, i);
                break;
            case -11:
            case -9:
                Log.i("Parking3DPresenterPro", "onSenceChange.TYPE_FRAME_TRAINING_APA");
                break;
            case -10:
                ((h) this.a).j(0);
                ((h) this.a).ai();
                up l = l();
                Log.d("Parking3DPresenterPro", "TYPE_FRAME_TRAINING_PARKING_B.parklot: " + l);
                if (l != null) {
                    ((uu) l).i();
                    if (ThemeWatcher.getInstance().isNight()) {
                        l.f();
                        break;
                    } else {
                        l.e();
                        break;
                    }
                }
                break;
            case -8:
                this.au.b(this, this.a, this.n, i);
                break;
            case -7:
                this.au.a(this, this.a, this.n, i);
                break;
            case -6:
                this.au.c(this, this.a, this.n, i);
                break;
            case -5:
                d.e(3);
                this.au.c((tj) this, this.a, this.n, i);
                break;
            case -4:
                this.au.d(this, this.a, this.av, i);
                d.e(3);
                break;
            case -3:
                this.au.a((tr) this, this.a, this.n, i);
                break;
            case -2:
                Log.i("Parking3DPresenterPro", "onSenceChange.TYPE_FRAME_MAP");
                if (!this.u.isStartTraining()) {
                    this.au.a(this, this.av);
                    break;
                } else {
                    this.au.a((tj) this, this.a, (uw) this.av, i);
                    break;
                }
            case -1:
                this.au.b((tj) this, this.a, this.n, i);
                boolean booleanValue = ((i.e) com.xiaopeng.autopilot.base.i.a(i.e.class)).d().booleanValue();
                Log.i("Parking3DPresenterPro", "onSenceChange.TYPE_FRAME_SR.apActive = " + booleanValue);
                if (!booleanValue) {
                    d.e(1);
                    break;
                } else {
                    d.e(2);
                    break;
                }
            default:
                boolean booleanValue2 = ((i.h) com.xiaopeng.autopilot.base.i.a(i.h.class)).d().booleanValue();
                boolean booleanValue3 = ((i.g) com.xiaopeng.autopilot.base.i.a(i.g.class)).d().booleanValue();
                int intValue2 = ((i.ad) com.xiaopeng.autopilot.base.i.a(i.ad.class)).d().intValue();
                Log.i("Parking3DPresenterPro", "onSenceChange.hasFinishActive = " + booleanValue2 + "," + booleanValue3 + "," + intValue + "," + intValue2);
                if (i2 == -3 || booleanValue2 || intValue == 4 || intValue == 2 || intValue == 7) {
                    Log.i("Parking3DPresenterPro", "onSenceChange.default can not move left");
                    break;
                } else if (this.u.isStartTraining()) {
                    Log.i("Parking3DPresenterPro", "onSenceChange.default can not move left because of training");
                    break;
                } else {
                    d.e(1);
                    break;
                }
        }
        a((Matrix4) null);
    }

    @Override // defpackage.tr
    public void b(int i, int i2) {
        int intValue = ((i.y) com.xiaopeng.autopilot.base.i.a(i.y.class)).d().intValue();
        Log.i("Parking3DPresenterPro", "do3DSceneChange.lastSence = " + i + "," + i2 + "," + intValue);
        switch (i2) {
            case 0:
                this.au.o(this, this.a, this.n, i);
                return;
            case 1:
                this.au.m(this, this.a, this.n, i);
                return;
            case 2:
                this.au.j(this, this.a, this.n, i);
                return;
            case 3:
                this.au.k(this, this.a, this.n, i);
                return;
            case 4:
                this.au.l(this, this.a, this.n, i);
                return;
            case 5:
            default:
                this.au.a(this.n, i2, i);
                return;
            case 6:
                this.au.n(this, this.a, this.n, i);
                return;
            case 7:
                this.au.q(this, this.a, this.n, i);
                return;
            case 8:
                this.au.r(this, this.a, this.n, i);
                return;
            case 9:
                this.au.p(this, this.a, this.n, i);
                return;
        }
    }

    public void a(float f, float f2, float f3) {
        this.u.routeAp2SrParkLotChoseCoordi(f, f2, f3);
    }

    public void af() {
        PerformanceTestUnit.log("Parking3DPresenterPro", "refreshStaticMap initStaticMap data process", true);
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        Log.i("Parking3DPresenterPro", "postBackground-Runnable refreshStaticMap");
        ab();
        U();
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "refreshStaticMap");
    }

    @Override // defpackage.tk
    public void y() {
        this.ap = false;
        Log.i("Parking3DPresenterPro", "mStaticMapParkLotDataReady = false");
    }

    public int ag() {
        a.c locationData = this.u.getLocationData();
        if (locationData == null) {
            Log.e("Parking3DPresenterPro", "locationData is null!");
            return 999;
        }
        float c = locationData.a().c();
        if (d.k()) {
            return locationData.g().a();
        }
        return a(c);
    }

    public sd ah() {
        int a;
        PerformanceTestUnit.logStart("Parking3DPresenterPro");
        if (this.u.getLocationData() == null) {
            Log.w("Parking3DPresenterPro", "STATIC_MAP_TASK > initStaticMapRoadLinkeEntity > allPathRoad location is null");
            return null;
        }
        PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK init_Map_Road start allPathRoad initStaticMapRoadLinkeEntity: " + Thread.currentThread().getName(), true);
        b.o dynaAllGuildeline = this.u.getDynaAllGuildeline();
        int size = dynaAllGuildeline.b().size();
        if (dynaAllGuildeline != null && size > 0) {
            ac().dispose();
            this.aa.clear();
            List<b.m> b = dynaAllGuildeline.b();
            for (b.m mVar : b) {
                p c = tz.c(mVar.a().a(), mVar.a().b(), mVar.a().c());
                if (d.k()) {
                    a = mVar.d().a();
                } else {
                    a = a(mVar.a().c());
                }
                sc scVar = new sc(c, mVar.b(), mVar.c(), a);
                if (d.k()) {
                    ac().a(mVar, scVar);
                }
                this.aa.add(scVar);
            }
            if (d.k()) {
                ac().a(this.aa);
            } else {
                ac().a(this.aa, x());
            }
            PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK > initStaticMapRoadLinkeEntity > initStaticMapRoad >  allPathRoad checkdata  all_road_data size is " + size + "\tfloorSize:" + x(), true);
            a.e a2 = (b == null || b.size() <= 0) ? null : b.get(b.size() - 1).a();
            ac().a(a2 != null ? new p(a2.a(), a2.b(), a2.c()) : null);
        } else {
            PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK > initStaticMapRoadLinkeEntity >  all_road_data size is  null", true);
        }
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "initStaticMapRoadLinkeEntity");
        return ac();
    }

    public se ai() {
        PerformanceTestUnit.log("Parking3DPresenterPro", "TrainingModel_flag>>initStaticTrainingRsRoadEntity", true);
        List<ahz.c.v> trainingRsLinkList = this.u.getTrainingRsLinkList();
        if (trainingRsLinkList == null) {
            return null;
        }
        if (this.ab == null) {
            this.ab = new se();
        }
        se seVar = this.ab;
        if (seVar != null) {
            seVar.dispose();
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        for (ahz.c.v vVar : trainingRsLinkList) {
            List<ahz.c.al> a = vVar.a();
            vVar.e();
            for (ahz.c.al alVar : a) {
                p c = tz.c(alVar.a(), alVar.b(), alVar.c());
                p pVar = new p(alVar.a(), alVar.b(), alVar.c());
                vector.add(c);
                vector2.add(pVar);
            }
        }
        this.ab = new se();
        this.ab.a(vector2, this);
        return this.ab;
    }

    public void aj() {
        List<ahz.c.ab> slotTypeListRs = this.u.getSlotTypeListRs();
        if (slotTypeListRs == null || slotTypeListRs.size() <= 0) {
            Log.w("Parking3DPresenterPro", "parklot list size is empty!");
            return;
        }
        this.ac.clear();
        ArrayList arrayList = new ArrayList();
        for (ahz.c.ab abVar : slotTypeListRs) {
            p c = tz.c(abVar.c(), abVar.d(), abVar.e());
            int a = abVar.a();
            float f = abVar.f();
            int b = abVar.b();
            sf sfVar = new sf();
            if (b == 1 || b == 2) {
                sfVar.b("model/entity/weizhichewei_Lateral.g3db");
            } else {
                sfVar.b("model/entity/weizhichewei.g3db");
            }
            sfVar.a(abVar.e());
            sfVar.a(true);
            sfVar.a(c, f);
            sfVar.a(c.a, c.b, c.c);
            sfVar.c(a);
            sfVar.b(a(abVar.e()));
            arrayList.add(sfVar);
        }
        this.ac.addAll(arrayList);
        PerformanceTestUnit.logEnd("Parking3DPresenterPro", "initStaticMapRsSenceParklotEntity");
    }

    public void ak() {
        P().clear();
        Q().clear();
        this.u.getDynaTrainingModelGuidelinePoints().clear();
        rx rxVar = this.V;
        if (rxVar != null) {
            rxVar.a(0.0f);
        }
    }

    @Override // defpackage.tk
    public boolean z() {
        boolean c = this.o.c();
        i.d a = com.xiaopeng.autopilot.base.i.a(i.o.class);
        if (a != null) {
            boolean z = ((i.o) a).d().a;
            if (ack.b().e()) {
                PerformanceTestUnit.log(2000L, "ready for render :\t" + c + "\tisReady3dSence:\t" + z, "Parking3DPresenterPro");
            }
            return c && z;
        }
        return false;
    }

    public tp al() {
        return this.v;
    }

    public void am() {
        PerformanceTestUnit.log("Parking3DPresenterPro", "executeRefreshStateMapTask", true);
        Runnable poll = this.u.getUnExecuteRefreshRunnable().poll();
        if (poll != null) {
            PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK > executeRefreshStaticMapTask >   poll  initStaticMapTask: " + poll.toString() + " from queue!:\t", true);
            ThreadUtils.postBackground(poll, 500L);
        }
    }

    public void an() {
        Runnable poll = this.u.getUnExecuteRefreshRoadQueue().poll();
        long j = this.w.f() ? 500L : 2500L;
        if (poll != null) {
            PerformanceTestUnit.log("Parking3DPresenterPro", "STATIC_MAP_TASK > executeInitStaticMapRoadRunnable >   poll  initMapRoadRunnable" + poll.toString() + " from queue!:\t", true);
            ThreadUtils.postBackground(poll, j);
        }
    }

    public void d(int i) {
        com.xiaopeng.autopilot.base.i.a(i.r.class, Integer.valueOf(i));
    }

    @Override // defpackage.tk
    public tq A() {
        if (this.w == null && as() != null) {
            this.w = new ty(as().b());
        }
        return this.w;
    }

    @Override // defpackage.tk
    public tl w() {
        if (this.x == null) {
            this.x = new tt(as(), this.u, this);
        }
        return this.x;
    }

    public List<sl> e(int i) {
        if (this.B.size() == 0) {
            return null;
        }
        return f(i);
    }

    public List<sl> c(boolean z) {
        if (this.u.getLocationData() == null) {
            PerformanceTestUnit.log("Parking3DPresenterPro_location", "location data is null error!", 4000L, true);
            return null;
        }
        int ag = ag();
        O().clear();
        List<sl> e = e(ag);
        if (e == null || e.size() == 0) {
            PerformanceTestUnit.log("Parking3DPresenterPro_cache", "staticLandmarks from cache is null ", 4000L);
            return null;
        }
        boolean z2 = i.r.e().intValue() == 2;
        a.c locationData = this.u.getLocationData();
        Matrix4 d = !z2 ? tz.a(locationData).d() : this.ar.c();
        for (sl slVar : e) {
            if (slVar.a(N().a(this.u.getLocationData().a().a(), this.u.getLocationData().a().b(), this.u.getLocationData().a().c()))) {
                a(slVar, locationData, d);
                O().add(slVar);
            }
        }
        List<sl> O = O();
        StringBuilder sb = new StringBuilder();
        sb.append("current staticObject num is : ");
        sb.append(O != null ? Integer.valueOf(O.size()) : "0");
        sb.append("\tcurrent floorNum is: ");
        sb.append(ag);
        PerformanceTestUnit.log("Parking3DPresenterPro_rs", sb.toString(), 5000L);
        return O;
    }

    private void a(sl slVar, a.c cVar, Matrix4 matrix4) {
        p pVar = new p(cVar.a().a(), cVar.a().b(), cVar.a().c());
        float m = ac().m() * 0.85f;
        if (slVar != null && (slVar instanceof su)) {
            su suVar = (su) slVar;
            p h = suVar.h();
            if (h != null) {
                suVar.a(pVar.d(h) < 50.0f);
            } else {
                suVar.a(true);
            }
            Matrix4 i = suVar.i();
            if (suVar.k_() != null) {
                suVar.k_().f.c();
                suVar.k_().f.b(matrix4);
                suVar.k_().f.b(i);
                suVar.k_().f.b(this.ai.c().f(m, 1.0f, 1.0f));
            }
        }
        if (slVar != null && (slVar instanceof sq)) {
            sq sqVar = (sq) slVar;
            p h2 = sqVar.h();
            if (h2 != null) {
                sqVar.a(pVar.d(h2) < 50.0f);
            } else {
                sqVar.a(true);
            }
            Matrix4 i2 = sqVar.i();
            if (sqVar.k_() != null) {
                sqVar.k_().f.c();
                sqVar.k_().f.b(matrix4);
                sqVar.k_().f.b(i2);
                sqVar.k_().f.b(this.ai.c().f(m, 1.0f, 1.0f));
                sqVar.k_().f.e(0.0f, g.a(sq.class), 0.0f);
            }
        }
        if (slVar != null && (slVar instanceof ss)) {
            ss ssVar = (ss) slVar;
            Matrix4 i3 = ssVar.i();
            if (ssVar.k_() != null) {
                ssVar.k_().f.c();
                ssVar.k_().f.b(matrix4);
                ssVar.k_().f.b(i3);
            }
        }
        if (slVar == null || !(slVar instanceof sg)) {
            return;
        }
        sg sgVar = (sg) slVar;
        Matrix4 i4 = sgVar.i();
        if (sgVar.k_() != null) {
            sgVar.k_().f.c();
            sgVar.k_().f.b(matrix4);
            sgVar.k_().f.b(i4);
        }
    }

    @Override // defpackage.tr, defpackage.tj
    public int r() {
        IParkingModelPro iParkingModelPro = this.u;
        if (iParkingModelPro == null || iParkingModelPro.getDynamicSlotLists() == null) {
            return 0;
        }
        return this.u.getDynamicSlotLists().size();
    }

    public List<sl> f(int i) {
        List<sl> list = this.B.get(Integer.valueOf(i));
        if (list == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.B.put(Integer.valueOf(i), copyOnWriteArrayList);
            return copyOnWriteArrayList;
        }
        return list;
    }

    @Override // defpackage.tk
    public int B() {
        Log.i("Parking3DPresenterPro", "getAPSpdCount.mStaticMapLandmarksDataCache = " + this.B);
        return this.B.size();
    }

    public boolean ao() {
        return this.u.isStartTraining();
    }

    public void ap() {
        this.au.e(this.av);
    }

    public void aq() {
        this.au.f(this.av);
    }

    public void d(boolean z) {
        this.at = z;
    }

    public boolean ar() {
        return this.at;
    }
}
