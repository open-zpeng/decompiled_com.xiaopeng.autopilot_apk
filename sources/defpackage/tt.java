package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.model.IParkingModelPro;
import com.xiaopeng.autopilot.parking.view.e;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSlotBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSpdBumpBean;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: Parking3DTrainingPresenterPro.java */
/* renamed from: tt  reason: default package */
/* loaded from: classes.dex */
public class tt implements tl {
    e a;
    IParkingModelPro b;
    tk c;
    private rx f;
    private List<up> i;
    private List<su> j;
    private List<p> g = new ArrayList();
    private List<p> h = new ArrayList();
    private List<up> k = new ArrayList();
    int d = 0;
    int e = 0;
    private Matrix4 l = new Matrix4();
    private Matrix4 m = new Matrix4();
    private p n = new p();

    private boolean a(su suVar) {
        return false;
    }

    private boolean a(up upVar) {
        return false;
    }

    public List<su> h() {
        if (this.j == null) {
            this.j = new CopyOnWriteArrayList();
        }
        return this.j;
    }

    public List<up> i() {
        if (this.i == null) {
            this.i = new CopyOnWriteArrayList();
        }
        return this.i;
    }

    public tt(e eVar, IParkingModelPro iParkingModelPro, tk tkVar) {
        this.a = eVar;
        this.b = iParkingModelPro;
        this.c = tkVar;
    }

    @Override // defpackage.tl
    public rx b() {
        List<p> dynaTrainingModelGuidelinePoints = this.b.getDynaTrainingModelGuidelinePoints();
        int size = dynaTrainingModelGuidelinePoints.size();
        if (dynaTrainingModelGuidelinePoints != null && size > 0) {
            p pVar = dynaTrainingModelGuidelinePoints.get(size - 1);
            if (this.f == null) {
                this.f = new rx(this.a.b());
            }
            a.c locationData = this.b.getLocationData();
            p f = tz.f(locationData.a().a(), locationData.a().b(), locationData.a().c());
            Matrix4 a = tz.a(locationData, f);
            this.f.a(dynaTrainingModelGuidelinePoints, a, f);
            this.f.a(this.b.getmFirstTrainingPathCduPoint(), a, pVar);
        }
        return this.f;
    }

    @Override // defpackage.tl
    public void c() {
        this.b.onStartTrainingModel();
        Log.i("Parking3DTrainingPresenterPro", "onStartTrainingModel");
        rx rxVar = this.f;
        if (rxVar != null) {
            rxVar.dispose();
        }
    }

    @Override // defpackage.tl
    public int d() {
        List<su> list = this.j;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // defpackage.tl
    public void e() {
        PerformanceTestUnit.logStart("Parking3DTrainingPresenterPro");
        PerformanceTestUnit.log("Parking3DTrainingPresenterPro", "releaseTrainingRes", true);
        IParkingModelPro iParkingModelPro = this.b;
        if (iParkingModelPro != null) {
            iParkingModelPro.getTrainingSpdbumpsQueue().clear();
            this.b.getTrainingParklotsQueue().clear();
        }
        rx rxVar = this.f;
        if (rxVar != null) {
            rxVar.dispose();
        }
        if (i() != null && i().size() > 0) {
            for (up upVar : i()) {
                if (upVar instanceof sf) {
                    ((sf) upVar).dispose();
                }
            }
            i().clear();
        }
        if (h() != null && h().size() > 0) {
            for (su suVar : h()) {
                suVar.dispose();
            }
            h().clear();
        }
        this.b.getDynaTrainingModelGuidelinePoints().clear();
        PerformanceTestUnit.logEnd("Parking3DTrainingPresenterPro", "releaseTrainingRes");
    }

    @Override // defpackage.tl
    public void a(int i) {
        PerformanceTestUnit.log("Parking3DTrainingPresenterPro", "onSwitchTheme training state:\t" + ((i.au) i.a(i.au.class)).d(), true);
        final boolean isNight = ThemeWatcher.getInstance().isNight();
        io.a.postRunnable(new Runnable() { // from class: tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.f != null) {
                    tt.this.f.t();
                }
                for (up upVar : tt.this.i()) {
                    if (upVar instanceof sf) {
                        sf sfVar = (sf) upVar;
                        if (isNight) {
                            sfVar.f();
                        } else {
                            sfVar.e();
                        }
                    }
                }
            }
        });
    }

    @Override // defpackage.tl
    public p f() {
        return rx.o();
    }

    @Override // defpackage.tl
    public float g() {
        return rx.p();
    }

    private List<up> a(List<up> list) {
        if (list == null || list.size() == 0) {
            return i();
        }
        for (up upVar : list) {
            if (!a(upVar)) {
                i().add(upVar);
            }
        }
        return i();
    }

    private void a(a.c cVar, boolean z) {
        List<up> i = i();
        int size = i.size();
        if (i == null || size <= 0) {
            return;
        }
        PerformanceTestUnit.logStart("Parking3DTrainingPresenterPro");
        Matrix4 j = j();
        if (j == null) {
            return;
        }
        Matrix4 d = j.d();
        p pVar = new p(cVar.a().a(), cVar.a().b(), cVar.a().c());
        for (up upVar : i) {
            boolean z2 = upVar instanceof sf;
            if (z2) {
                sf sfVar = (sf) upVar;
                p m_ = sfVar.m_();
                float d2 = m_.d(pVar);
                double abs = Math.abs(m_.c - pVar.c);
                boolean z3 = true;
                if (z) {
                    if (abs >= 2.0d) {
                        z3 = false;
                    }
                } else if (d2 >= 50.0f || abs >= 2.0d) {
                    z3 = false;
                }
                sfVar.b(z3);
                if (!z3) {
                    continue;
                }
            }
            if (upVar != null && upVar.k_() != null) {
                la k_ = upVar.k_();
                if (k_ == null) {
                    return;
                }
                k_.f.c();
                k_.f.b(d);
                if (z2 && k_ != null && k_.f != null) {
                    sf sfVar2 = (sf) upVar;
                    k_.f.b(sfVar2.k());
                    if (sfVar2.l() != null && sfVar2.l().k_() != null && (sfVar2.l() instanceof rz)) {
                        rz rzVar = (rz) sfVar2.l();
                        rzVar.a(k_.f);
                        if (sfVar2.n()) {
                            rzVar.k_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                            rzVar.l_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                        }
                    }
                    k_.f.f(0.845f, 1.0f, 0.845f);
                }
            }
        }
        PerformanceTestUnit.logEnd("Parking3DTrainingPresenterPro", "refreshTrainingModelParklots(),  parkLotEntities.zise = " + i.size());
    }

    @Override // defpackage.tl
    public List<up> a(boolean z) {
        List<up> a = a(k());
        a(this.b.getLocationData(), z);
        if (a != null && a.size() != this.d) {
            PerformanceTestUnit.mTrainingLog.append("  ;trainingmodel parklots after meger :");
            PerformanceTestUnit.mTrainingLog.append(a.size());
            Log.i("Parking3DTrainingPresenterPro", PerformanceTestUnit.mTrainingLog.toString());
            this.d = a.size();
        }
        return a;
    }

    private List<su> b(List<su> list) {
        if (list == null || list.size() == 0) {
            return h();
        }
        for (su suVar : list) {
            if (!a(suVar)) {
                h().add(suVar);
            }
        }
        return h();
    }

    private void m() {
        List<su> h = h();
        if (h == null || h.size() <= 0) {
            return;
        }
        PerformanceTestUnit.logStart("Parking3DTrainingPresenterPro");
        Matrix4 j = j();
        a.c locationData = this.b.getLocationData();
        new p(locationData.a().a(), locationData.a().b(), locationData.a().c());
        for (su suVar : h) {
            if (suVar != null && suVar.k_() != null && suVar.k_().f != null) {
                Matrix4 a = j.a();
                suVar.k_().f.c();
                suVar.k_().f.b(a.d());
                suVar.k_().f.b(suVar.i());
                suVar.k_().f.e(0.0f, 0.05f, 0.0f);
                suVar.k_().f.f(0.385f, 1.0f, 1.0f);
                suVar.k_().f.a(this.n);
                if (Math.abs(this.n.b) < 2.0d) {
                    suVar.a(true);
                } else {
                    suVar.a(false);
                }
            }
        }
        PerformanceTestUnit.logEnd("Parking3DTrainingPresenterPro", "refreshTrainningModelSpd(),  spdbumpEntities.zise = " + h.size());
    }

    @Override // defpackage.tl
    public List<su> a() {
        List<su> l = l();
        if (l != null) {
            l.size();
        }
        List<su> b = b(l);
        m();
        if (b != null && b.size() != this.e) {
            this.e = b.size();
        }
        return b;
    }

    public Matrix4 j() {
        return tz.d(this.b.getLocationData());
    }

    public List<up> k() {
        List<TrainingSlotBean> list = this.b.getmTrainingSlotList();
        PerformanceTestUnit.mTrainingLog.setLength(0);
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (list == null || size <= 0) {
            return null;
        }
        PerformanceTestUnit.mTrainingLog.append("initPerFrameTrainingParklotCaseTwo 消费 size:  ");
        PerformanceTestUnit.mTrainingLog.append(size);
        ArrayList arrayList = new ArrayList();
        Matrix4 j = j();
        for (TrainingSlotBean trainingSlotBean : list) {
            sf sfVar = new sf();
            int i = trainingSlotBean.slot_shape;
            if (i == 1 || i == 2) {
                sfVar.b("model/entity/weizhichewei_Lateral.g3db");
                PerformanceTestUnit.mTrainingLog.append("  ;(车位方向shape 平行 id = :  ");
                StringBuilder sb = PerformanceTestUnit.mTrainingLog;
                sb.append(trainingSlotBean.id + ")");
            } else {
                sfVar.b("model/entity/weizhichewei.g3db");
            }
            this.l.c();
            Matrix4 a = tz.a(trainingSlotBean);
            sf sfVar2 = sfVar;
            sfVar2.a(tz.b(trainingSlotBean));
            if (trainingSlotBean.attribute == 0) {
                sfVar2.a(new rz("model/entity/jiaoche.g3db"));
            }
            this.m.c();
            a.b(this.m);
            sfVar2.a(a);
            sfVar.a(false);
            if (j != null) {
                j = j.a();
                this.l.b(j.d());
                this.l.b(a);
                sfVar.k_().f.c();
                sfVar.k_().f.b(this.l.a());
                if (sfVar2.l() != null && sfVar2.l().k_() != null && (sfVar2.l() instanceof rz)) {
                    rz rzVar = (rz) sfVar2.l();
                    rzVar.a(this.l);
                    if (sfVar2.n()) {
                        rzVar.k_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                        rzVar.l_().f.d(0.0f, 1.0f, 0.0f, -90.0f);
                    }
                }
            }
            arrayList.add(sfVar);
        }
        return arrayList;
    }

    public List<su> l() {
        List<TrainingSpdBumpBean> list = this.b.getmTrainingSpdBumpList();
        if (list == null || list.size() <= 0) {
            return null;
        }
        Log.i("Parking3DTrainingPresenterPro", "TrainingSpdSize SIZE: 消费:\t" + list.size() + "");
        ArrayList arrayList = new ArrayList();
        for (TrainingSpdBumpBean trainingSpdBumpBean : list) {
            su suVar = new su();
            suVar.a();
            suVar.a((ach) this.a);
            this.l.c();
            this.m.c();
            Matrix4 a = tz.a(trainingSpdBumpBean);
            Matrix4 j = j();
            a.b(this.m);
            suVar.a(a);
            suVar.k();
            if (j != null) {
                this.l.b(j.d());
                this.l.b(a);
                suVar.k_().f.c();
                suVar.k_().f.b(this.l.a());
            }
            arrayList.add(suVar);
        }
        return arrayList;
    }
}
