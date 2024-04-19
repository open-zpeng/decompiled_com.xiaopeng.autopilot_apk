package defpackage;

import android.graphics.Matrix;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.model.IParkingModelPro;
import com.xiaopeng.autopilot.parking.model.MiniMapModel;
import com.xiaopeng.autopilot.parking.model.ParkingModelPro;
import com.xiaopeng.autopilot.parking.view.d;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ParkingMiniMapPresenter.java */
/* renamed from: tu  reason: default package */
/* loaded from: classes.dex */
public class tu implements tm {
    Matrix a;
    Matrix b;
    Matrix c;
    Matrix d;
    Matrix e;
    private IParkingModelPro f;
    private List<d> g;
    private a h;

    /* compiled from: ParkingMiniMapPresenter.java */
    /* renamed from: tu$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    private tu() {
        this.g = new ArrayList();
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new Matrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ParkingMiniMapPresenter.java */
    /* renamed from: tu$b */
    /* loaded from: classes.dex */
    public static class b {
        private static final tu a = new tu();
    }

    public static tu d() {
        return b.a;
    }

    public float a(float f, float f2, float f3) {
        float sqrt = ((float) (f3 / Math.sqrt((f * f) + (f2 * f2)))) * 1.41f;
        PerformanceTestUnit.log("ParkingMiniMapPresenter_calcMiniMapRate:", "rate:" + sqrt, 1000L, true);
        return sqrt;
    }

    @Override // defpackage.tm
    public MiniMapModel a() {
        return this.f.getMimiMapModel();
    }

    @Override // defpackage.tm
    public void a(IParkingModelPro iParkingModelPro) {
        this.f = iParkingModelPro;
        iParkingModelPro.getMimiMapModel().bindPresenter(this);
    }

    @Override // defpackage.tm
    public void a(d dVar) {
        this.g.add(dVar);
    }

    @Override // defpackage.tm
    public void b() {
        PerformanceTestUnit.log("ParkingMiniMapPresenter", "MINI_MAP dispose ", true);
        for (d dVar : this.g) {
            dVar.a();
        }
        IParkingModelPro iParkingModelPro = this.f;
        if (iParkingModelPro == null || iParkingModelPro.getMimiMapModel() == null) {
            return;
        }
        this.f.getMimiMapModel().dispose();
    }

    @Override // defpackage.tm
    public Matrix a(int i, int i2, MiniMapModel.FloorInfo floorInfo) {
        Matrix matrix = new Matrix();
        IParkingModelPro iParkingModelPro = this.f;
        if ((iParkingModelPro instanceof ParkingModelPro ? (ParkingModelPro) iParkingModelPro : null) == null) {
            this.d.reset();
        }
        this.d.reset();
        p pVar = floorInfo.getmCenter();
        float a2 = a(i2, i, floorInfo.getmFloorDiagoLength());
        this.a.reset();
        this.a.postTranslate((i / 2) - pVar.a, (i2 / 2) - pVar.b);
        float f = (1.0f / a2) * 0.75f;
        this.c.reset();
        this.c.postScale(f, f, pVar.a, pVar.b);
        this.d.reset();
        this.d.postConcat(this.c);
        this.d.postConcat(this.a);
        matrix.set(this.d);
        return matrix;
    }

    @Override // defpackage.tm
    public void c() {
        for (d dVar : this.g) {
            dVar.b();
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(a aVar) {
        this.h = aVar;
    }
}
