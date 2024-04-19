package defpackage;

import com.xiaopeng.autopilot.base.g;
import com.xiaopeng.autopilot.base.j;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.model.TipChangeTaskStack;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
/* compiled from: ParkingTaskDispatchPresenter.java */
/* renamed from: ty  reason: default package */
/* loaded from: classes.dex */
public class ty extends j implements tq {
    private aca e;
    private volatile TipChangeTaskStack f;

    private TipChangeTaskStack j() {
        if (this.f == null) {
            this.f = new TipChangeTaskStack();
        }
        return this.f;
    }

    public ty(aca acaVar) {
        this.e = acaVar;
    }

    @Override // defpackage.tq
    public boolean n_() {
        aca acaVar = this.e;
        if (acaVar == null) {
            return false;
        }
        return acaVar.c("model/bike/zixingche.g3db") && this.e.c("model/bus/bus.g3db") && this.e.c("model/gate/gate.g3db") && this.e.c("model/man/cartoon_man.g3db") && this.e.c("model/dog/dog.g3db") && this.e.c("model/suv/SUV.g3db") && this.e.c("model/huoche/huoche.g3db") && this.e.c("model/mpv/MPV.g3db") && this.e.c("model/pika/pika.g3db") && this.e.c("model/jiaoche/jiaoche_sr.g3db") && this.e.c("model/moto/moto.g3db") && this.e.c("model/traffic_cones/traffic_cones.g3db");
    }

    @Override // defpackage.tq
    public boolean d() {
        return this.e.c("model/speedbump/speed_bump.g3db");
    }

    @Override // defpackage.tq
    public boolean e() {
        return this.e.c("model/entity/weizhichewei.g3db") && this.e.c("model/entity/weizhichewei_Lateral.g3db");
    }

    @Override // com.xiaopeng.autopilot.base.j, defpackage.rm
    public boolean c() {
        boolean z = true;
        if (this.a != null && this.a.size() > 0) {
            for (Integer num : this.a.keySet()) {
                Queue queue = this.a.get(num);
                if (queue != null && queue.size() > 0) {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // defpackage.tq
    public boolean f() {
        aca acaVar = this.e;
        if (acaVar == null) {
            return false;
        }
        boolean c = acaVar.c("model/speedbump/speed_bump.g3db");
        boolean c2 = this.e.c("model/pillar/model_column.g3db");
        boolean c3 = this.e.c("model/entity/weizhichewei_Lateral.g3db");
        boolean c4 = this.e.c("model/entity/weizhichewei.g3db");
        boolean c5 = this.e.c("model/entity/jiaoche.g3db");
        boolean c6 = this.e.c("model/anti_collision_pillar/anti_collision_pillar_red.g3db");
        if (c && c2 && c3 && c4 && c5 && c6) {
            for (Map.Entry<Integer, String> entry : g.a.entrySet()) {
                if (!this.e.c(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.tq
    public boolean g() {
        aca acaVar = this.e;
        if (acaVar == null) {
            return false;
        }
        boolean c = acaVar.c("model/entity/weizhichewei_Lateral.g3db");
        boolean c2 = this.e.c("model/entity/weizhichewei.g3db");
        boolean c3 = this.e.c("model/entity/jiaoche.g3db");
        if (c && c2 && c3) {
            for (Map.Entry<Integer, String> entry : g.a.entrySet()) {
                if (!this.e.c(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.tq
    public void a(TipChangeTaskStack.TipChangeInfo tipChangeInfo) {
        synchronized (this) {
            PerformanceTestUnit.log("ParkingTaskDispatchPresenter", "TIPS_TASK  pushTipChangeRunnableIntoStack " + tipChangeInfo.toString(), true);
            j().push(tipChangeInfo);
        }
    }

    @Override // defpackage.tq
    public TipChangeTaskStack.TipChangeInfo h() {
        synchronized (this) {
            if (j().isEmpty()) {
                return null;
            }
            return j().pop();
        }
    }

    @Override // defpackage.tq
    public void i() {
        synchronized (this) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!j().isEmpty()) {
                stringBuffer.append("TIPS_TASK: discard task\t");
                Iterator it = j().iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((TipChangeTaskStack.TipChangeInfo) it.next()).toString());
                }
                PerformanceTestUnit.log("ParkingTaskDispatchPresenter", stringBuffer.toString(), true);
            }
            j().clear();
        }
    }
}
