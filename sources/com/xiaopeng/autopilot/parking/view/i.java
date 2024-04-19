package com.xiaopeng.autopilot.parking.view;

import android.util.Log;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.parking.view.g3d.b;
import defpackage.acc;
import defpackage.acf;
import defpackage.sd;
/* compiled from: Parking3DSceneCameraAnimationPro.java */
/* loaded from: classes.dex */
public class i extends uy {
    private ts C;
    private acf D;
    private Runnable E = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.i.1
        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.a(iVar.C);
        }
    };

    public void a(ts tsVar) {
        this.C = tsVar;
        rh.a().e(this.E);
        int ag = tsVar.ag();
        sd.a c = tsVar.ac().c(ag);
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToSinglePro.floorNum = " + ag + "," + c);
        if (c == null) {
            ag();
            return;
        }
        c.g();
        com.badlogic.gdx.math.p a = c.a();
        com.badlogic.gdx.math.p d = c.d();
        com.badlogic.gdx.math.p e = c.e();
        c.c();
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToSinglePro.offsetZ = " + a + "," + d + "," + e);
        if (a == null || d == null || e == null) {
            ag();
            return;
        }
        kl klVar = this.B.P;
        float max = Math.max(c.b(), c.c());
        klVar.a(a);
        klVar.b.a(b.g.b);
        klVar.c.a(b.g.c);
        klVar.a.a(a.a, 2.07f * max, a.c);
        klVar.a();
        Log.d("Parking3DSceneCameraAnimationPro", "needScale cam y = " + klVar.a.b + "needScale dis = " + max);
    }

    private void ag() {
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToMap");
        this.B.P.a.a(b.d.a);
        this.B.P.b.a(b.d.b);
        this.B.P.c.a(b.m.c);
        this.B.P.a();
    }

    public void a() {
        if (this.B == null || !(this.B instanceof com.xiaopeng.autopilot.parking.view.g3d.h)) {
            return;
        }
        com.xiaopeng.autopilot.parking.view.g3d.h hVar = this.B;
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToTraining.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        hVar.P.a.a(b.p.a);
        hVar.P.b.a(b.p.b);
        hVar.P.c.a(b.p.c);
        hVar.P.a();
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToTraining.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
    }

    public void b() {
        if (this.B == null || !(this.B instanceof com.xiaopeng.autopilot.parking.view.g3d.h)) {
            return;
        }
        com.xiaopeng.autopilot.parking.view.g3d.h hVar = this.B;
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToTrainingLearn.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        hVar.P.a.a(b.s.a);
        hVar.P.b.a(b.s.b);
        hVar.P.c.a(b.s.c);
        hVar.P.a();
        Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToTrainingLearn.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
    }

    public void c() {
        if (this.B == null || !(this.B instanceof com.xiaopeng.autopilot.parking.view.g3d.h)) {
            return;
        }
        final com.xiaopeng.autopilot.parking.view.g3d.h hVar = this.B;
        final jz n = this.B.n();
        if (this.D == null) {
            this.D = acf.b(0.0f, 1.0f);
            this.D.a(800L);
        }
        this.D.g();
        this.D.a(new acf.b() { // from class: com.xiaopeng.autopilot.parking.view.i.2
            @Override // defpackage.acf.b
            public void a(acf acfVar) {
                com.badlogic.gdx.math.p pVar = CarApiUtil.getGear() == 3 ? b.f.a : b.e.a;
                com.badlogic.gdx.math.p pVar2 = CarApiUtil.getGear() == 3 ? b.f.b : b.e.b;
                com.badlogic.gdx.math.p pVar3 = CarApiUtil.getGear() == 3 ? b.f.c : b.e.c;
                i iVar = i.this;
                jz jzVar = n;
                iVar.a(jzVar, jzVar.a, pVar, n.b, pVar2, n.c, pVar3, ((ace) acfVar).e());
            }
        });
        this.D.c();
        this.D.a(new acc.a() { // from class: com.xiaopeng.autopilot.parking.view.i.3
            @Override // defpackage.acc.a
            public void c(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToNavStartPoint.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("Parking3DSceneCameraAnimationPro", "changeCameraToNavStartPoint.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
            }
        });
        if (this.D.h()) {
            this.D.b();
        }
        this.D.a();
    }

    @Override // defpackage.uy, defpackage.uw
    public void d() {
        super.d();
        acf acfVar = this.D;
        if (acfVar == null || !acfVar.h()) {
            return;
        }
        this.D.b();
    }
}
