package com.xiaopeng.autopilot.parking.view;

import android.util.Log;
import com.xiaopeng.autopilot.parking.view.g3d.b;
/* compiled from: Parking3DSceneChangePro.java */
/* loaded from: classes.dex */
public class j extends uz {
    public void a(ts tsVar, uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToFavorite");
        ((i) uwVar).a(tsVar);
    }

    public void a(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToTraining.lastScene = " + i + "," + tjVar.p());
        if (fVar != null) {
            fVar.b(true);
        }
        if (i == 0) {
            uwVar.d(b.j.a, b.p.a, b.j.b, b.p.b, b.m.c, b.p.c);
        } else if (i == 2) {
            if (tjVar.p()) {
                tjVar.a(false);
                uwVar.d(b.l.a, b.p.a, b.l.b, b.p.b, b.m.c, b.p.c);
                return;
            }
            uwVar.d(b.m.a, b.p.a, b.m.b, b.p.b, b.m.c, b.p.c);
        } else if (i == 3) {
            uwVar.d(b.n.a, b.p.a, b.n.b, b.p.b, b.m.c, b.p.c);
        } else if (i == -5) {
            uwVar.d(b.C0058b.a, b.p.a, b.C0058b.b, b.p.b, b.C0058b.c, b.p.c);
        } else if (i == -10 || i == -11 || i == -9) {
        } else {
            ((i) uwVar).a();
            com.xiaopeng.autopilot.base.d.e(2);
        }
    }

    public void a(ts tsVar, f fVar, uw uwVar, int i) {
        com.badlogic.gdx.math.p Y = tsVar.Y();
        float Z = tsVar.Z();
        int aa = tsVar.aa();
        Log.i("Parking3DSceneChangePro", "onSenceToTrainingFinish.lastScene = " + i + " ;dis = " + Z + " ;size = " + aa + " ;center = " + Y);
        uwVar.a(Y, Z, aa);
    }

    public void b(ts tsVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToTrainingFail.lastScene = " + i);
        uwVar.f(b.p.a, b.q.a, b.p.b, b.q.b, b.p.c, b.m.c);
    }

    public void c(ts tsVar, f fVar, uw uwVar, int i) {
        com.badlogic.gdx.math.p V = tsVar.V();
        float W = tsVar.W();
        int X = tsVar.X();
        Log.i("Parking3DSceneChangePro", "onSenceToAPFinish.lastScene = " + i + " ;dis = " + W + " ;size = " + X + " ;center = " + V);
        uwVar.a(b.h.a, b.p.a, b.h.b, b.p.b, b.m.c, b.p.c, b.r.b(V, W), b.r.c, b.r.d, X);
    }

    public void b(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToAP.lastScene = " + i + "," + tjVar.p());
        if (i == 0) {
            uwVar.c(b.j.a, b.a.a, b.j.b, b.a.b, b.m.c, b.m.c);
        } else if (i == 2) {
            if (tjVar.p()) {
                tjVar.a(false);
                uwVar.c(b.l.a, b.a.a, b.l.b, b.a.b, b.m.c, b.m.c);
                return;
            }
            uwVar.c(b.m.a, b.a.a, b.m.b, b.a.b, b.m.c, b.m.c);
        } else if (i == 3) {
            uwVar.c(b.n.a, b.a.a, b.n.b, b.a.b, b.m.c, b.m.c);
        } else if (i == -5) {
            uwVar.c(b.C0058b.a, b.a.a, b.C0058b.b, b.a.b, b.C0058b.c, b.m.c);
        } else if (i == -4 || i == -15 || i == -16) {
            uwVar.g(b.s.a, b.a.a, b.s.b, b.a.b, b.s.c, b.m.c);
        } else if (i == -14) {
            uwVar.c(b.i.a, b.a.a, b.i.b, b.a.b, b.m.c, b.m.c);
        } else {
            a(uwVar);
        }
    }

    public void c(tj tjVar, f fVar, uw uwVar, int i) {
        uw uwVar2;
        Log.i("Parking3DSceneChangePro", "onSenceToAPReady.lastScene = " + i + "," + tjVar.p());
        if (i == 0) {
            uwVar.b(b.j.a, b.C0058b.a, b.j.b, b.C0058b.b, b.m.c, b.C0058b.c);
        } else if (i == 2) {
            if (tjVar.p()) {
                tjVar.a(false);
                uwVar.b(b.l.a, b.C0058b.a, b.l.b, b.C0058b.b, b.m.c, b.C0058b.c);
                return;
            }
            uwVar.b(b.m.a, b.C0058b.a, b.m.b, b.C0058b.b, b.m.c, b.C0058b.c);
        } else if (i == 3) {
            uwVar.b(b.n.a, b.C0058b.a, b.n.b, b.C0058b.b, b.m.c, b.C0058b.c);
        } else if (i == 9) {
            uwVar.b(b.k.a, b.C0058b.a, b.k.b, b.C0058b.b, b.m.c, b.C0058b.c);
        } else {
            com.xiaopeng.autopilot.base.d.e(3);
            uf m = tjVar.m();
            if (m == null || m.h() == null) {
                uwVar2 = uwVar;
            } else if (m.h().c != 0.0f) {
                Log.i("Parking3DSceneChangePro", "onSenceToApReady.drivingCarEntity.getCenter().z = " + m.h().c);
                m.l();
                uwVar2 = uwVar;
            } else {
                uwVar2 = uwVar;
            }
            b(uwVar2);
        }
    }

    public void d(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToTrainingLearn.lastScene = " + i + "," + fVar.n().a + "," + fVar.n().b + "," + fVar.n().c);
        if (i == -7) {
            uwVar.e(b.r.a, b.s.a, b.r.b, b.s.b, b.m.c, b.s.c);
        } else if (i == -8) {
            uwVar.e(b.q.a, b.s.a, b.q.b, b.s.b, b.m.c, b.s.c);
        } else {
            c(uwVar);
        }
    }

    public void e(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToTrainingLearn.lastScene = " + i + "," + fVar.n().a + "," + fVar.n().b + "," + fVar.n().c);
        uf m = tjVar.m();
        if (m != null && m.h() != null && m.h().c != 0.0f) {
            m.l();
        }
        d(uwVar);
    }

    public void f(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToFoundedParkLot.lastScene = " + i);
        uwVar.g();
        uf m = tjVar.m();
        if (m != null && m.h().c == 0.0f) {
            Log.d("Parking3DSceneChangePro", "onSenceToFoundedParkLot driving car z is zero");
            m.m();
        }
        uwVar.b(b.a.a, b.n.a, b.a.b, b.n.b);
    }

    public void g(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToSearchingParkLot.lastScene = " + i);
        uf m = tjVar.m();
        if (m != null && m.h() != null && m.h().c != 0.0f) {
            Log.i("Parking3DSceneChangePro", "onSenceToSearchingParkLot.drivingCarEntity.getCenter().z = " + m.h().c);
            m.l();
        }
        if (i == -13) {
            uwVar.h(b.n.a, b.a.a, b.n.b, b.a.b, b.m.c, b.m.c);
        } else if (i == -14) {
            uwVar.h(b.i.a, b.a.a, b.i.b, b.a.b, b.m.c, b.m.c);
        } else {
            a(uwVar);
        }
    }

    public void h(tj tjVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSenceToPassRamp.lastScene = " + i);
        uf m = tjVar.m();
        if (m != null && m.h() != null && m.h().c != 0.0f) {
            Log.i("Parking3DSceneChangePro", "onSenceToPassRamp.drivingCarEntity.getCenter().z = " + m.h().c);
            m.l();
        }
        uwVar.i(b.a.a, b.i.a, b.a.b, b.i.b, b.m.c, b.m.c);
    }

    @Override // defpackage.uz
    public void a(f fVar, uw uwVar, int i) {
        if (i != -2 && i != -1) {
            if (i == -5) {
                uwVar.a(b.C0058b.a, b.m.a, b.C0058b.b, b.m.b, b.C0058b.c, b.m.c);
                return;
            } else if (i == -4 || i == -15 || i == -16) {
                uwVar.g(b.s.a, b.m.a, b.s.b, b.m.b, b.s.c, b.m.c);
                return;
            } else if (fVar.r()) {
                return;
            } else {
                uwVar.l();
                return;
            }
        }
        float d = fVar.n().a.d(b.p.a);
        Log.d("Parking3DSceneChangePro", "onSearchOther.cameraTrainingDistance: " + d);
        float d2 = fVar.n().a.d(b.s.a);
        Log.d("Parking3DSceneChangePro", "onSearchOther.cameraTrainingLearnDistance: " + d2);
        if (d == 0.0f) {
            uwVar.g(b.p.a, b.m.a, b.p.b, b.m.b, b.p.c, b.m.c);
        } else if (d2 == 0.0f) {
            uwVar.g(b.s.a, b.m.a, b.s.b, b.m.b, b.s.c, b.m.c);
        } else {
            uwVar.a(b.a.a, b.m.a, b.a.b, b.m.b, b.m.c, b.m.c);
        }
    }

    @Override // defpackage.uz
    public void b(f fVar, uw uwVar, int i) {
        if (i != -2 && i != -1) {
            if (i == -5) {
                uwVar.a(b.C0058b.a, b.n.a, b.C0058b.b, b.n.b, b.C0058b.c, b.m.c);
                return;
            } else if (i == -4 || i == -15 || i == -16) {
                uwVar.g(b.s.a, b.n.a, b.s.b, b.n.b, b.s.c, b.m.c);
                return;
            } else if (fVar.r()) {
                return;
            } else {
                uwVar.n();
                return;
            }
        }
        float d = fVar.n().a.d(b.p.a);
        Log.d("Parking3DSceneChangePro", "onReadyInOther.senceInReady.cameraDistance: " + d);
        float d2 = fVar.n().a.d(b.s.a);
        Log.d("Parking3DSceneChangePro", "onReadyInOther.cameraTrainingLearnDistance: " + d2);
        if (d == 0.0f) {
            uwVar.g(b.p.a, b.n.a, b.p.b, b.n.b, b.p.c, b.m.c);
        } else if (d2 == 0.0f) {
            uwVar.g(b.s.a, b.n.a, b.s.b, b.n.b, b.s.c, b.m.c);
        } else {
            uwVar.a(b.a.a, b.n.a, b.a.b, b.n.b, b.m.c, b.m.c);
        }
    }

    public void a(uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToSR");
        uwVar.t();
    }

    public void b(uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToAPReady");
        uwVar.s();
    }

    public void c(uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToTrainingLearn");
        ((i) uwVar).b();
    }

    public void d(uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToNavStartPoint");
        ((i) uwVar).c();
    }

    public void a(tr trVar, f fVar, uw uwVar, int i) {
        Log.i("Parking3DSceneChangePro", "onSceneToAPArrive.lastScene = " + i);
        if (i == -1) {
            uwVar.a(b.a.a, b.n.a, b.a.b, b.n.b);
        } else if (i == -2) {
            uwVar.n();
            uwVar.g();
            uf m = trVar.m();
            if (m == null || m.h().c != 0.0f) {
                return;
            }
            Log.d("Parking3DSceneChangePro", "onSceneToAPArrive driving car z is zero");
            m.m();
        }
    }

    @Override // defpackage.uz
    public void i(tj tjVar, f fVar, uw uwVar, int i) {
        if (i == -8) {
            uwVar.g(b.q.a, b.k.a, b.q.b, b.k.b, b.m.c, b.m.c);
            return;
        }
        com.xiaopeng.autopilot.parking.view.g3d.h hVar = (com.xiaopeng.autopilot.parking.view.g3d.h) fVar;
        Log.i("Parking3DSceneChangePro", "onSceneToWarningOther.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
        hVar.P.a.a(b.k.a);
        hVar.P.b.a(b.k.b);
        hVar.P.c.a(b.m.c);
        hVar.P.a();
        Log.i("Parking3DSceneChangePro", "onSceneToWarningOther.after.position" + hVar.P.a + "," + hVar.P.b + "," + hVar.P.c);
    }

    public void e(uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToTrainingR");
        uwVar.g(b.p.a, b.n.a, b.p.b, b.n.b, b.p.c, b.m.c);
    }

    public void f(uw uwVar) {
        Log.i("Parking3DSceneChangePro", "changeCameraToTrainingD");
        uwVar.d(b.m.a, b.p.a, b.m.b, b.p.b, b.m.c, b.p.c);
    }
}
