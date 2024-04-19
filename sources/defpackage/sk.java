package defpackage;

import com.xiaopeng.autopilot.base.g;
import defpackage.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: DynaObjectCacheManager.java */
/* renamed from: sk  reason: default package */
/* loaded from: classes.dex */
public class sk {
    private acq<sn> a = new acq<sn>(1, 5) { // from class: sk.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sn b() {
            return new sn();
        }
    };
    private acq<sj> b = new acq<sj>(1, 5) { // from class: sk.9
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sj b() {
            return new sj();
        }
    };
    private acq<sh> c = new acq<sh>(1, 5) { // from class: sk.10
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sh b() {
            return new sh();
        }
    };
    private acq<so> d = new acq<so>(1, 5) { // from class: sk.11
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public so b() {
            return new so();
        }
    };
    private acq<sx> e = new acq<sx>(1, 5) { // from class: sk.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sx b() {
            return new sx();
        }
    };
    private acq<sp> f = new acq<sp>(1, 5) { // from class: sk.13
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sp b() {
            return new sp();
        }
    };
    private acq<si> g = new acq<si>(1, 5) { // from class: sk.14
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public si b() {
            return new si();
        }
    };
    private acq<sr> h = new acq<sr>(1, 5) { // from class: sk.15
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sr b() {
            return new sr();
        }
    };
    private acq<st> i = new acq<st>(1, 5) { // from class: sk.16
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public st b() {
            return new st();
        }
    };
    private acq<sv> j = new acq<sv>(1, 5) { // from class: sk.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sv b() {
            return new sv();
        }
    };
    private acq<su> m = new acq<su>(1, 5) { // from class: sk.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public su b() {
            return new su();
        }
    };
    private acq<sm> l = new acq<sm>(1, 5) { // from class: sk.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sm b() {
            return new sm();
        }
    };
    private acq<sw> k = new acq<sw>(1, 5) { // from class: sk.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sw b() {
            return new sw();
        }
    };
    private acq<sg> n = new acq<sg>(1, 5) { // from class: sk.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public sg b() {
            return new sg();
        }
    };
    private HashMap<Integer, acq<sq>> o = new HashMap<>();

    public sk() {
        for (Map.Entry<Integer, String> entry : g.a.entrySet()) {
            final int intValue = entry.getKey().intValue();
            this.o.put(Integer.valueOf(intValue), new acq<sq>(1, 5) { // from class: sk.7
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // defpackage.acq
                /* renamed from: a */
                public sq b() {
                    return new sq(intValue);
                }
            });
        }
    }

    public sl a(b.q qVar) {
        switch (qVar.b()) {
            case kWheelStopper:
            case kPillar:
            case kWall:
            case kCurb:
            case kDoor:
            case kHydrantBox:
            case kHydrant:
            case kBollardPost:
            case kSpeedBump:
            case kDrainage:
            case kEntrance:
            case kBarrierGate:
            default:
                return null;
            case kTrafficCone:
                return this.k.d();
        }
    }

    public sl a(b.d dVar) {
        switch (dVar.b()) {
            case OBJ_TYPE_BUS:
                return this.g.d();
            case OBJ_TYPE_TRUCK:
                return this.e.d();
            case OBJ_TYPE_VAN:
                return this.f.d();
            case OBJ_TYPE_PICKUP:
                return this.h.d();
            case OBJ_TYPE_SEDAN:
                return this.i.d();
            case OBJ_TYPE_SUV:
                return this.j.d();
            case OBJ_TYPE_TRICYCLE:
            case OBJ_TYPE_MOTORCYCLE:
                return this.d.d();
            case OBJ_TYPE_BICYCLE:
                return this.c.d();
            case OBJ_TYPE_PERSON:
                return this.a.d();
            case OBJ_TYPE_ANIMAL:
                return this.b.d();
            default:
                return null;
        }
    }

    public void a(List<sl> list) {
        if (list == null) {
            return;
        }
        for (sl slVar : list) {
            if (slVar != null) {
                if (slVar instanceof sn) {
                    this.a.b((sn) slVar);
                } else if (slVar instanceof sj) {
                    this.b.b((sj) slVar);
                } else if (slVar instanceof sh) {
                    this.c.b((sh) slVar);
                } else if (slVar instanceof so) {
                    this.d.b((so) slVar);
                } else if (slVar instanceof sx) {
                    this.e.b((sx) slVar);
                } else if (slVar instanceof sp) {
                    this.f.b((sp) slVar);
                } else if (slVar instanceof si) {
                    this.g.b((si) slVar);
                } else if (slVar instanceof sr) {
                    this.h.b((sr) slVar);
                } else if (slVar instanceof st) {
                    this.i.b((st) slVar);
                } else if (slVar instanceof sv) {
                    this.j.b((sv) slVar);
                } else if (slVar instanceof sm) {
                    this.l.b((sm) slVar);
                } else if (slVar instanceof su) {
                    this.m.b((su) slVar);
                } else if (slVar instanceof sg) {
                    this.n.b((sg) slVar);
                } else if (slVar instanceof sq) {
                    sq sqVar = (sq) slVar;
                    if (this.o.containsKey(Integer.valueOf(sqVar.l()))) {
                        this.o.get(Integer.valueOf(sqVar.l())).b(sqVar);
                    }
                } else if (slVar instanceof sw) {
                    this.k.b((sw) slVar);
                }
            }
        }
    }
}
