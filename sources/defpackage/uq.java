package defpackage;

import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import defpackage.a;
import java.util.Iterator;
/* compiled from: ParkLotEntityPoolCache.java */
/* renamed from: uq  reason: default package */
/* loaded from: classes.dex */
public class uq implements com.badlogic.gdx.utils.g {
    private tr d;
    private a a = new a(6, 6);
    private i b = new i(12, 30);
    private h c = new h(1, 1);
    private g e = new g(1, 1);
    private f f = new f(6, 6);
    private d g = new d(6, 6);
    private c h = new c(6, 6);
    private b i = new b(6, 6);
    private e j = new e(10, 10);

    public d a() {
        return this.g;
    }

    public c b() {
        return this.h;
    }

    public b c() {
        return this.i;
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$a */
    /* loaded from: classes.dex */
    public static class a extends acq<um> {
        public a(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public um b() {
            return new um();
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$i */
    /* loaded from: classes.dex */
    public static class i extends acq<uv> {
        public i(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public uv b() {
            return new uv();
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$h */
    /* loaded from: classes.dex */
    public static class h extends acq<uu> {
        public h(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public uu b() {
            return new uu();
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$d */
    /* loaded from: classes.dex */
    public static class d extends acq<ut> {
        public d(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public ut b() {
            return new ut();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        public void a(ut utVar) {
            utVar.b(false);
            utVar.c(false);
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$c */
    /* loaded from: classes.dex */
    public static class c extends acq<us> {
        public c(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public us b() {
            return new us();
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$b */
    /* loaded from: classes.dex */
    public static class b extends acq<ur> {
        public b(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public ur b() {
            return new ur();
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$e */
    /* loaded from: classes.dex */
    public static class e extends acq<ul> {
        public e(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public ul b() {
            return new ul();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$g */
    /* loaded from: classes.dex */
    public static class g extends acq<ky> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public ky b() {
            return f();
        }

        public g(int i, int i2) {
            super(i, i2);
        }

        private ky f() {
            nj njVar = new nj();
            njVar.a();
            kx kxVar = new kx();
            kxVar.a(new le(770, 771));
            njVar.c().a = "rect";
            njVar.a("rect", 4, 29L, kxVar).a(new p(-0.5f, 0.0f, 0.5f), new p(0.5f, 0.0f, 0.5f), new p(0.5f, 0.0f, -0.5f), new p(-0.5f, 0.0f, -0.5f), new p(0.0f, 1.0f, 0.0f));
            return njVar.b();
        }
    }

    /* compiled from: ParkLotEntityPoolCache.java */
    /* renamed from: uq$f */
    /* loaded from: classes.dex */
    public class f extends acq<la> {
        public f(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.acq
        /* renamed from: a */
        public la b() {
            return f();
        }

        private la f() {
            ky d = uq.this.d().d();
            la laVar = new la(d);
            uq.this.d().b(d);
            return laVar;
        }
    }

    public g d() {
        return this.e;
    }

    public a e() {
        return this.a;
    }

    public i f() {
        return this.b;
    }

    public h g() {
        return this.c;
    }

    public void a(tr trVar) {
        this.d = trVar;
    }

    public up a(a.k kVar, int i2) {
        um d2;
        if (kVar.j() == 1) {
            if (i2 == -11 || i2 == 2 || i2 == -1 || i2 == -3) {
                um d3 = e().d();
                if (kVar.h() == 1 || kVar.h() == 2) {
                    d3.b("model/entity/kebochewei_Lateral.g3db");
                } else {
                    d3.b("model/entity/kebochewei.g3db");
                }
                return d3;
            } else if (i2 == 3 || i2 == 4 || i2 == 1 || i2 == -10 || i2 == -9 || i2 == -13) {
                if (kVar == null ? false : this.d.b(kVar.f())) {
                    d2 = g().d();
                    d2.d(kVar.h());
                    if (kVar.h() == 1 || kVar.h() == 2) {
                        d2.b("model/entity/xuanzhongchewei_Lateral.g3db");
                    } else {
                        d2.b("model/entity/xuanzhongchewei.g3db");
                    }
                } else {
                    d2 = e().d();
                    if (kVar.h() == 1 || kVar.h() == 2) {
                        d2.b("model/entity/kebochewei_Lateral.g3db");
                    } else {
                        d2.b("model/entity/kebochewei.g3db");
                    }
                }
                return d2;
            } else {
                um d4 = e().d();
                if (kVar.h() == 1 || kVar.h() == 2) {
                    d4.b("model/entity/kebochewei_Lateral.g3db");
                } else {
                    d4.b("model/entity/kebochewei.g3db");
                }
                return d4;
            }
        }
        return null;
    }

    public up a(ParkLotItem parkLotItem, int i2) {
        um d2;
        if (!parkLotItem.isFree()) {
            if (parkLotItem.isFree()) {
                return null;
            }
            uv d3 = f().d();
            if (parkLotItem.getDir() == 1 || parkLotItem.getDir() == 2) {
                d3.b("model/entity/weizhichewei_Lateral.g3db");
            } else {
                d3.b("model/entity/weizhichewei.g3db");
            }
            return d3;
        } else if (i2 == 2) {
            um d4 = e().d();
            if (parkLotItem.getDir() == 1 || parkLotItem.getDir() == 2) {
                d4.b("model/entity/kebochewei_Lateral.g3db");
            } else {
                d4.b("model/entity/kebochewei.g3db");
            }
            return d4;
        } else if (i2 == 3 || i2 == 4 || i2 == 1) {
            if (parkLotItem == null ? false : this.d.b(parkLotItem.getSlotIndex())) {
                d2 = g().d();
                d2.d(parkLotItem.getDir());
                if (parkLotItem.getDir() == 1 || parkLotItem.getDir() == 2) {
                    d2.b("model/entity/xuanzhongchewei_Lateral.g3db");
                } else {
                    d2.b("model/entity/xuanzhongchewei.g3db");
                }
            } else {
                d2 = e().d();
                if (parkLotItem.getDir() == 1 || parkLotItem.getDir() == 2) {
                    d2.b("model/entity/kebochewei_Lateral.g3db");
                } else {
                    d2.b("model/entity/kebochewei.g3db");
                }
            }
            return d2;
        } else {
            um d5 = e().d();
            if (parkLotItem.getDir() == 1 || parkLotItem.getDir() == 2) {
                d5.b("model/entity/kebochewei_Lateral.g3db");
            } else {
                d5.b("model/entity/kebochewei.g3db");
            }
            return d5;
        }
    }

    public void h() {
        com.badlogic.gdx.utils.a aVar = new com.badlogic.gdx.utils.a();
        aVar.a((com.badlogic.gdx.utils.a) this.a.c());
        aVar.a((com.badlogic.gdx.utils.a) this.b.c());
        aVar.a((com.badlogic.gdx.utils.a) this.c.c());
        aVar.a((com.badlogic.gdx.utils.a) this.g.c());
        aVar.a((com.badlogic.gdx.utils.a) this.h.c());
        aVar.a((com.badlogic.gdx.utils.a) this.i.c());
        Iterator it = aVar.iterator();
        while (it.hasNext()) {
            ((up) it.next()).f();
        }
    }

    public void i() {
        com.badlogic.gdx.utils.a aVar = new com.badlogic.gdx.utils.a();
        aVar.a((com.badlogic.gdx.utils.a) this.a.c());
        aVar.a((com.badlogic.gdx.utils.a) this.b.c());
        aVar.a((com.badlogic.gdx.utils.a) this.c.c());
        aVar.a((com.badlogic.gdx.utils.a) this.g.c());
        aVar.a((com.badlogic.gdx.utils.a) this.h.c());
        aVar.a((com.badlogic.gdx.utils.a) this.i.c());
        Iterator it = aVar.iterator();
        while (it.hasNext()) {
            ((up) it.next()).e();
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.e();
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.e();
        }
        f fVar = this.f;
        if (fVar != null) {
            fVar.e();
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.e();
        }
        h hVar = this.c;
        if (hVar != null) {
            hVar.e();
        }
        d dVar = this.g;
        if (dVar != null) {
            dVar.e();
        }
        c cVar = this.h;
        if (cVar != null) {
            cVar.e();
        }
        b bVar = this.i;
        if (bVar != null) {
            bVar.e();
        }
    }
}
