package defpackage;

import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.parking.view.f;
import com.xiaopeng.autopilot.parking.view.g3d.b;
import com.xiaopeng.autopilot.parking.view.g3d.h;
/* compiled from: Parking3DSceneChange.java */
/* renamed from: uz  reason: default package */
/* loaded from: classes.dex */
public class uz implements ux {
    private boolean a;

    public void i(tj tjVar, f fVar, uw uwVar, int i) {
    }

    @Override // defpackage.ux
    public void r(tj tjVar, f fVar, uw uwVar, int i) {
    }

    @Override // defpackage.ux
    public void j(tj tjVar, f fVar, uw uwVar, int i) {
        Log.d("Parking3DSceneChange", "senceASearching.mParking3DView: " + fVar + ",lastSence = " + i + "," + a.g().a);
        if (fVar != null) {
            fVar.b(true);
        }
        float d = fVar.n().a.d(b.p.a);
        Log.d("Parking3DSceneChange", "onSceneToASearching.cameraTrainingDistance: " + d);
        if (d == 0.0f) {
            uwVar.l();
        } else if (i == 0 || i == 6) {
            if (a.g().a) {
                a.g().a = false;
                int r = tjVar.r();
                Log.d("Parking3DSceneChange", "senceASearching.items: " + r);
                if (r == 0) {
                    tjVar.a(true);
                    ((uy) uwVar).O();
                } else {
                    tjVar.a(false);
                    ((uy) uwVar).M();
                }
            } else {
                tjVar.a(false);
                uwVar.l();
            }
            if (tjVar.m() != null && i == 0) {
                tjVar.m().l();
            }
        } else if (i == 3) {
            if (!fVar.r()) {
                uwVar.f();
            }
        } else if (i == 9) {
            tjVar.a(false);
            ((uy) uwVar).b(100L);
        } else {
            a(fVar, uwVar, i);
        }
        Log.d("Parking3DSceneChange", "senceASearching.mHasNoParkingLots: " + tjVar.p());
    }

    public void a(f fVar, uw uwVar, int i) {
        if (fVar.r()) {
            return;
        }
        uwVar.l();
    }

    @Override // defpackage.ux
    public void k(tj tjVar, f fVar, uw uwVar, int i) {
        uf m = tjVar.m();
        if (m != null) {
            Log.i("Parking3DSceneChange", "senceInReady.drivingCarEntity.getCenter().z = " + m.h().c);
        }
        boolean booleanValue = ((i.w) i.a(i.w.class)).d().booleanValue();
        Log.i("Parking3DSceneChange", "isRPark = " + booleanValue + ",lastScene = " + i + "," + re.a().h());
        if (m != null && m.h().c == 0.0f && (booleanValue || i == 0)) {
            m.m();
        }
        float d = fVar.n().a.d(b.p.a);
        Log.d("Parking3DSceneChange", "onSceneToAReadyIn.cameraTrainingDistance: " + d);
        if (d == 0.0f) {
            uwVar.n();
        } else if (i == 0) {
            if (a.g().a) {
                a.g().a = false;
                ((uy) uwVar).N();
            } else {
                uwVar.n();
            }
        } else if (i == 2) {
            if (!fVar.r()) {
                uwVar.e();
            } else {
                if (m != null && m.h().c == 0.0f) {
                    m.m();
                }
                h hVar = (h) fVar;
                if (hVar.E != null) {
                    hVar.E.b(true);
                }
            }
        } else if (i == 6) {
            ((uy) uwVar).L();
            h hVar2 = (h) fVar;
            if (hVar2.E != null) {
                hVar2.E.a();
            }
        } else {
            b(fVar, uwVar, i);
        }
        Log.i("Parking3DSceneChange", "senceInReady.getDrivingCarEntity().getCenter().after = " + tjVar.m().h());
    }

    public void b(f fVar, uw uwVar, int i) {
        if (fVar.r()) {
            return;
        }
        uwVar.n();
    }

    @Override // defpackage.ux
    public void l(tj tjVar, f fVar, uw uwVar, int i) {
        uy uyVar = (uy) uwVar;
        uyVar.ae();
        if (i == 1) {
            uwVar.h();
        }
        if (!fVar.r() || i == 0) {
            uyVar.ab();
        }
        uf m = tjVar.m();
        if (m != null) {
            Log.i("Parking3DSceneChange", "senceOutReady.drivingCarEntity.getCenter() = " + m.h());
        }
        if (m == null || m.h().c != 0.0f) {
            return;
        }
        m.m();
        Log.i("Parking3DSceneChange", "senceOutReady.drivingCarEntity.getCenter().after = " + m.h());
    }

    @Override // defpackage.ux
    public void m(tj tjVar, f fVar, uw uwVar, int i) {
        h hVar = (h) fVar;
        hVar.j(0);
        hVar.ai();
        up l = tjVar.l();
        Log.d("Parking3DSceneChange", "senceB.parklot: " + l + "," + i);
        uf m = tjVar.m();
        if (i == 3) {
            if (m != null && m.h().c == 0.0f) {
                Log.d("Parking3DSceneChange", "senceB driving car z is zero");
                m.m();
                uwVar.n();
                uwVar.g();
            }
            uwVar.g();
            if (hVar.E != null) {
                hVar.E.a(false);
            }
            fVar.a_(CarApiUtil.getGear());
            if (l != null) {
                ((uu) l).i();
            }
        } else if (i == 4) {
            this.a = true;
            ((uy) uwVar).af();
            if (m != null) {
                Log.i("Parking3DSceneChange", "senceB.drivingCarEntity.getCenter() = " + m.h());
            }
            if (m != null && m.h().c == 0.0f) {
                m.m();
                Log.i("Parking3DSceneChange", "senceB.drivingCarEntity.getCenter().after = " + m.h());
            }
            if (hVar.E != null) {
                hVar.E.a(true);
            }
        } else if (i == -2 || i == -1 || i == -3) {
            uwVar.n();
            uwVar.g();
        }
        ui W = hVar.W();
        if (W != null) {
            W.a(l);
        }
    }

    @Override // defpackage.ux
    public void n(tj tjVar, f fVar, uw uwVar, int i) {
        ((tr) tjVar).K();
        boolean booleanValue = ((i.w) i.a(i.w.class)).d().booleanValue();
        Log.i("Parking3DSceneChange", "isRPark = " + booleanValue);
        if (booleanValue) {
            return;
        }
        if (!fVar.r()) {
            if (i < 0) {
                uwVar.m();
                return;
            } else {
                ((uy) uwVar).K();
                return;
            }
        }
        uf m = tjVar.m();
        if (m != null && m.h() != null) {
            Log.i("Parking3DSceneChange", "senceSlideWarning.entity.getCenter() = " + m.h());
            if (m.h().c != 0.0f) {
                m.l();
                Log.i("Parking3DSceneChange", "senceSlideWarning.entity.getCenter().after = " + m.h());
            }
        }
        fVar.c(false);
    }

    @Override // defpackage.ux
    public void o(tj tjVar, f fVar, uw uwVar, int i) {
        h hVar = (h) fVar;
        if (hVar.E != null) {
            hVar.E.a();
        }
        uf m = tjVar.m();
        if (m != null) {
            Log.i("Parking3DSceneChange", "senceClear.drivingCarEntity.getCenter().z = " + m.h().c + ",lastSence = " + i);
        } else {
            Log.i("Parking3DSceneChange", "senceClear.lastSence = " + i);
        }
        if (m != null) {
            m.l();
            Log.i("Parking3DSceneChange", "senceClear.drivingCarEntity.getCenter().z.after = " + m.h().c + ",lastSence = " + i);
        }
        ((uy) uwVar).ae();
        if (i == 0) {
            uwVar.q();
        } else {
            uwVar.m();
        }
    }

    @Override // defpackage.ux
    public void p(tj tjVar, f fVar, uw uwVar, int i) {
        uwVar.a(true);
        if (i == 0) {
            ((uy) uwVar).O();
        } else if (i == 2) {
            tjVar.a(true);
            if (fVar.r()) {
                fVar.c(false);
            } else {
                ((uy) uwVar).a(100L);
            }
        } else {
            i(tjVar, fVar, uwVar, i);
        }
    }

    @Override // defpackage.ux
    public void q(tj tjVar, f fVar, uw uwVar, int i) {
        if (fVar.r()) {
            return;
        }
        uwVar.i();
    }

    @Override // defpackage.ux
    public void a(uw uwVar, int i, int i2) {
        uwVar.a(i2, i);
    }

    @Override // defpackage.ux
    public boolean a() {
        return this.a;
    }

    @Override // defpackage.ux
    public void a(boolean z) {
        this.a = z;
    }
}
