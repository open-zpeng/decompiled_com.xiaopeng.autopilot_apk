package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.g;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import defpackage.a;
import defpackage.ahz;
import defpackage.b;
import defpackage.ni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: StaticMapRoadLinkEnittyPro.java */
/* renamed from: sd  reason: default package */
/* loaded from: classes.dex */
public class sd extends rv {
    private static final float av = uc.c * 0.05f;
    p E;
    p F;
    private float as;
    private int at;
    private float au;
    private la aw;
    aca o;
    p s;
    private ka H = new ka(0.25490198f, 0.4117647f, 0.88235295f, 1.0f);
    private ka ak = new ka(0.4117647f, 0.4117647f, 0.4117647f, 1.0f);
    private List<sc> al = new ArrayList();
    private ka am = new ka(1.0f, 1.0f, 1.0f, 1.0f);
    private float an = uc.c * 0.08f;
    Map<Integer, a> a = new HashMap();
    Map<Integer, ArrayList<sc>> n = new HashMap();
    String p = "material/img_road_day.png";
    String q = "material/img_road_night.png";
    private String ao = "material/road_end.png";
    private String ap = "material/map_ramp.png";
    p r = new p();
    p t = new p();
    p u = new p();
    p v = new p();
    p w = new p();
    p x = new p();
    p y = new p();
    p z = new p();
    p A = new p();
    private ka aq = new ka(1.0f, 0.0f, 0.0f, 1.0f);
    private ka ar = new ka(0.11372549f, 0.15294118f, 0.22352941f, 1.0f);
    lf B = lf.a(this.ar);
    lf C = lf.b(0.7111111f, 0.7777778f, 0.84444445f, 1.0f);
    lf D = lf.b(0.5f, 0.5f, 0.5f, 0.8f);
    private p ax = new p();
    private boolean ay = false;
    private List<Integer> az = new ArrayList();
    private ka[] aA = {new ka(0.29333332f, 0.4977778f, 0.6755555f, 1.0f), new ka(0.41333333f, 0.61777776f, 0.79555553f, 1.0f), new ka(0.51555556f, 0.6844444f, 0.83555555f, 1.0f), new ka(0.61333334f, 0.7511111f, 0.8755556f, 1.0f), new ka(0.7022222f, 0.81333333f, 0.91555554f, 1.0f), new ka(0.80444443f, 0.88f, 0.95555556f, 1.0f), new ka(0.22666667f, 0.64444447f, 1.1333333f, 1.0f), new ka(0.45333335f, 0.7644445f, 1.1333333f, 1.0f), new ka(0.68f, 0.8888889f, 1.1333333f, 1.0f), new ka(0.9066667f, 1.0088888f, 1.1333333f, 1.0f)};
    private ka aB = new ka(0.7111111f, 0.7777778f, 0.84444445f, 1.0f);
    private ka aC = new ka(0.7111111f, 0.7777778f, 0.84444445f, 1.0f);
    private sc aD = null;
    private float aE = 0.0f;
    int G = 0;
    private float aF = 2.0f;
    private p aG = new p();

    public void a(int i) {
        this.at = i;
    }

    public void c(float f) {
        if (this.au != f) {
            Log.i("StaticMapRoadLinkEnittyPro", "setmRoadSpeedRate = " + f);
            this.au = f;
        }
    }

    public float m() {
        return this.au;
    }

    public float n() {
        return this.as;
    }

    public void d(float f) {
        this.as = f;
    }

    public p o() {
        if (this.F == null) {
            this.F = new p();
        }
        return this.F;
    }

    public void a(p pVar) {
        this.E = pVar;
    }

    public void b(p pVar) {
        this.r = pVar;
    }

    public void c(p pVar) {
        this.s = pVar;
    }

    public aca p() {
        return this.o;
    }

    public void a(aca acaVar) {
        this.o = acaVar;
    }

    public sd() {
        a(0.7490196f, 0.7921569f, 0.8392157f, 1.0f);
    }

    public la b(int i) {
        a aVar;
        if (this.a.size() <= 0 || (aVar = this.a.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return aVar.f();
    }

    @Override // defpackage.aci
    public la k_() {
        return this.L;
    }

    public a c(int i) {
        if (this.a.size() > 0) {
            return this.a.get(Integer.valueOf(i));
        }
        return null;
    }

    protected List<sc> b(List<sc> list, int i) {
        this.al.clear();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 % i == 0 || list.get(i2).e() || list.get(i2).f()) {
                    this.al.add(list.get(i2));
                }
            }
        }
        return this.al;
    }

    private void b(List<sc> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        c(list.get(list.size() - 1).h());
    }

    public void a(List<sc> list, List<ahz.c.h> list2) {
        if (list2 == null) {
            Log.i("StaticMapRoadLinkEnittyPro", "floor data is null!");
            return;
        }
        b(list);
        for (ahz.c.h hVar : list2) {
            int a2 = hVar.a();
            ArrayList arrayList = new ArrayList();
            for (sc scVar : list) {
                if (a2 == scVar.g()) {
                    arrayList.add(scVar);
                }
            }
            a aVar = new a();
            aVar.d(c(arrayList, aVar));
            la a3 = a(arrayList, aVar);
            aVar.a(a3);
            this.a.put(Integer.valueOf(a2), aVar);
            Log.i("StaticMapRoadLinkEnittyPro", "allRoadPath Road :\tfloorNum:\t" + a2 + "\t roadInstance:\t" + a3 + "\tfloorInfo:\t" + aVar.toString());
        }
        if (list.size() <= 0 || !d.j()) {
            return;
        }
        this.ax = list.get(0).h();
        a aVar2 = new a();
        aVar2.d(d(list, aVar2));
        aVar2.a(b(list, aVar2));
        this.a.put(666, aVar2);
    }

    public void a(List<sc> list) {
        b(list);
        HashMap hashMap = new HashMap();
        for (sc scVar : list) {
            if (!scVar.d() || scVar.e() || scVar.f()) {
                int c = scVar.c();
                if (hashMap.containsKey(Integer.valueOf(c))) {
                    ((ArrayList) hashMap.get(Integer.valueOf(c))).add(scVar);
                } else {
                    ArrayList arrayList = new ArrayList();
                    hashMap.put(Integer.valueOf(c), arrayList);
                    arrayList.add(scVar);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            ArrayList arrayList2 = (ArrayList) entry.getValue();
            a aVar = new a();
            la a2 = a(arrayList2, aVar);
            aVar.d(c(arrayList2, aVar));
            aVar.a(a2);
            this.a.put(Integer.valueOf(intValue), aVar);
            Log.i("StaticMapRoadLinkEnittyPro", "allRoadPath Road :floorNum:" + intValue + "floorInfo:allPoint size = " + arrayList2.size());
        }
        if (list.size() > 0) {
            this.ax = list.get(0).h();
            a aVar2 = new a();
            aVar2.d(d(list, aVar2));
            aVar2.a(b(list, aVar2));
            this.a.put(666, aVar2);
        }
    }

    public void a(b.m mVar, sc scVar) {
        a.C0000a d = mVar.d();
        Log.d("StaticMapRoadLinkEnittyPro", "parserRampStartEndPosition start level = " + d.a() + ";end level = " + d.b());
        if (d.a() != d.b()) {
            scVar.c(d.a());
            scVar.d(d.b());
            if (!this.ay) {
                scVar.a(true);
                this.ay = true;
            }
            if (d.a() > d.b()) {
                scVar.e(1);
                return;
            } else {
                scVar.e(2);
                return;
            }
        }
        scVar.c(d.a());
        if (this.ay) {
            scVar.b(true);
        }
        this.ay = false;
    }

    private ka a(sc scVar) {
        float f;
        int a2 = scVar.a();
        ka kaVar = this.aC;
        if (a2 == this.G) {
            return kaVar;
        }
        if (a2 <= 9) {
            kaVar = this.aA[a2];
        }
        int b = scVar.b();
        if (a2 == this.G - 1) {
            if (this.n.containsKey(Integer.valueOf(a2))) {
                f = ((b * 1000) / this.n.get(Integer.valueOf(a2)).size()) / 1000.0f;
                this.aB.M = kaVar.M;
                this.aB.J = kaVar.J + ((this.aC.J - kaVar.J) * f);
                this.aB.K = kaVar.K + ((this.aC.K - kaVar.K) * f);
                this.aB.L = kaVar.L + ((this.aC.L - kaVar.L) * f);
                return this.aB;
            }
            Log.i("StaticMapRoadLinkEnittyPro", "pathPoint not has floorColor = " + a2);
        }
        f = 0.0f;
        this.aB.M = kaVar.M;
        this.aB.J = kaVar.J + ((this.aC.J - kaVar.J) * f);
        this.aB.K = kaVar.K + ((this.aC.K - kaVar.K) * f);
        this.aB.L = kaVar.L + ((this.aC.L - kaVar.L) * f);
        return this.aB;
    }

    private void a(int i, sc scVar) {
        ArrayList<sc> arrayList = this.n.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.n.put(Integer.valueOf(i), arrayList);
        }
        arrayList.add(scVar);
        p h = scVar.h();
        float f = scVar.h().b;
        float f2 = this.aF;
        h.b = (f * f2) - (this.aE * (f2 - 1.0f));
        scVar.b(arrayList.size() - 1);
        scVar.a(i);
    }

    public la a(Matrix4 matrix4) {
        if (p().c("model/entity/ap_star_flag.g3db") && this.aw == null) {
            this.aw = new la((ky) p().a("model/entity/ap_star_flag.g3db"));
            Log.i("StaticMapRoadLinkEnittyPro", "start_flag model  loaded success!");
        }
        if (this.aw != null) {
            this.aG.a(this.ax);
            this.aG.a(matrix4);
            this.aw.f.c();
            this.aw.f.b(this.aG);
        }
        return this.aw;
    }

    private p c(List<sc> list, a aVar) {
        p pVar = new p(0.0f, 0.0f, 0.0f);
        if (list == null || list.size() == 0) {
            return pVar;
        }
        p h = list.get(0).h();
        float f = h.a;
        float f2 = h.a;
        float f3 = h.c;
        float f4 = h.c;
        for (sc scVar : list) {
            p h2 = scVar.h();
            if (h2.a < f) {
                f = h2.a;
            }
            if (h2.c < f3) {
                f3 = h2.c;
            }
            if (h2.a > f2) {
                f2 = h2.a;
            }
            if (h2.c > f4) {
                f4 = h2.c;
            }
        }
        float f5 = f2 - f;
        pVar.a = (f5 / 2.0f) + f;
        pVar.b = 0.0f;
        float f6 = f4 - f3;
        pVar.c = (f6 / 2.0f) + f3;
        aVar.b(new p(f, 0.0f, f4));
        aVar.c(new p(f2, 0.0f, f3));
        aVar.e(f5);
        aVar.f(f6);
        aVar.a(new p(pVar.a, 0.0f, pVar.c + (aVar.c() * 0.1f)));
        aVar.b(f2);
        aVar.a(f);
        aVar.d(f4);
        aVar.c(f3);
        return pVar;
    }

    private p d(List<sc> list, a aVar) {
        p pVar = new p(0.0f, 0.0f, 0.0f);
        if (list == null || list.size() == 0) {
            return pVar;
        }
        p h = list.get(0).h();
        float f = h.a;
        float f2 = h.a;
        float f3 = h.c;
        float f4 = h.c;
        this.n.clear();
        this.aD = list.get(list.size() - 1);
        this.aE = this.aD.h().b;
        this.G = 0;
        for (sc scVar : list) {
            p h2 = scVar.h();
            if (h2.a < f) {
                f = h2.a;
            }
            if (h2.c < f3) {
                f3 = h2.c;
            }
            if (h2.a > f2) {
                f2 = h2.a;
            }
            if (h2.c > f4) {
                f4 = h2.c;
            }
            if (scVar.f()) {
                this.G++;
            }
            a(this.G, scVar);
        }
        float f5 = f2 - f;
        pVar.a = (f5 / 2.0f) + f;
        pVar.b = 0.0f;
        float f6 = f4 - f3;
        pVar.c = (f6 / 2.0f) + f3;
        aVar.b(new p(f, 0.0f, f4));
        aVar.c(new p(f2, 0.0f, f3));
        aVar.e(f5);
        aVar.f(f6);
        aVar.a(new p(pVar.a, 0.0f, pVar.c + (aVar.c() * 0.1f)));
        aVar.b(f2);
        aVar.a(f);
        aVar.d(f4);
        aVar.c(f3);
        for (Integer num : this.n.keySet()) {
            Log.i("StaticMapRoadLinkEnittyPro", "allRoadPath Road :\tfloorNum: \t" + num + "\tfloorInfo: size = \t" + this.n.get(num).size());
        }
        return pVar;
    }

    public la a(List<sc> list, a aVar) {
        PerformanceTestUnit.logStart("StaticMapRoadLinkEnittyPro");
        double size = list != null ? list.size() : 0.0d;
        Log.i("StaticMapRoadLinkEnittyPro", "before filter : " + size);
        int i = 1;
        List<sc> b = b(list, size == 0.0d ? 1 : (int) Math.ceil(size / 8000.0d));
        StringBuilder sb = new StringBuilder();
        sb.append("after filter : ");
        sb.append(b != null ? Integer.valueOf(b.size()) : "0");
        Log.i("StaticMapRoadLinkEnittyPro", sb.toString());
        lf lfVar = ThemeWatcher.getInstance().isNight() ? this.B : this.C;
        Log.i("StaticMapRoadLinkEnittyPro", "after filter : ThemeWatcher.getInstance().isNight() " + ThemeWatcher.getInstance().isNight());
        kx kxVar = new kx("road_material");
        nj njVar = new nj();
        kxVar.a(lfVar);
        njVar.a();
        ni a2 = njVar.a("road", 4, 11L, kxVar);
        p pVar = new p(0.0f, 1.0f, 0.0f);
        float f = 0.9f;
        int i2 = 0;
        p pVar2 = null;
        p pVar3 = null;
        float f2 = 0.0f;
        while (i2 < b.size() - i) {
            p h = b.get(i2).h();
            int i3 = i2 + 1;
            sc scVar = b.get(i3);
            p h2 = b.get(i3).h();
            float i4 = b.get(i2).i();
            float j = b.get(i2).j();
            f2 += i4 + j;
            float f3 = j * f;
            float f4 = i4 * f * uc.c;
            this.t.a(h2).c(h);
            this.u.a(this.t);
            this.t.g(pVar);
            this.t.d();
            this.v.a(this.t).a(f4);
            this.w.a(this.t).a(f3 * uc.c);
            p pVar4 = this.x;
            if (pVar2 == null) {
                pVar2 = h.a().c(this.v);
            }
            pVar4.a(pVar2);
            p pVar5 = this.y;
            if (pVar3 == null) {
                pVar3 = h.a().b(this.w);
            }
            pVar5.a(pVar3);
            this.z.a(h2).b(this.w);
            this.A.a(h2).c(this.v);
            ni.a i5 = i();
            i5.a(this.x);
            i5.a(0.0f, 1.0f);
            ni.a j2 = j();
            j2.a(this.y);
            j2.a(1.0f, 1.0f);
            ni.a k = k();
            k.a(this.z);
            k.a(1.0f, 0.0f);
            ni.a l = l();
            l.a(this.A);
            l.a(0.0f, 0.0f);
            a2.a(i5, j2, k, l);
            pVar3 = this.z;
            pVar2 = this.A;
            if (h2.equals(this.s)) {
                b(this.t);
                a(this.z, this.A, this.u, njVar);
                Log.i("StaticMapRoadLinkEnittyPro", "roadEndFlag dir\t" + this.t);
            }
            if (d.j() && !h2.equals(this.s)) {
                if (scVar.f()) {
                    b(this.z, this.A, this.u, njVar);
                    Log.i("StaticMapRoadLinkEnittyPro", "RampEndFlag dir\t" + this.t);
                }
                if (scVar.e()) {
                    b(this.z, this.A, this.u, njVar);
                    Log.i("StaticMapRoadLinkEnittyPro", "RampStartFlag dir\t" + this.t);
                }
            }
            i2 = i3;
            i = 1;
            f = 0.9f;
        }
        la laVar = new la(njVar.b());
        a(f2, b.size());
        Log.i("StaticMapRoadLinkEnittyPro", "allpath object:\t" + laVar.toString());
        PerformanceTestUnit.logEnd("StaticMapRoadLinkEnittyPro", "DynaAllGuidelineEntityPro>initModelRoadPath");
        return laVar;
    }

    public la b(List<sc> list, a aVar) {
        PerformanceTestUnit.logStart("StaticMapRoadLinkEnittyPro");
        double size = list != null ? list.size() : 0.0d;
        Log.i("StaticMapRoadLinkEnittyPro", "before filter : " + size);
        int i = 1;
        List<sc> b = b(list, size == 0.0d ? 1 : (int) Math.ceil(size / 8000.0d));
        StringBuilder sb = new StringBuilder();
        sb.append("after filter : ");
        sb.append(b != null ? Integer.valueOf(b.size()) : "0");
        Log.i("StaticMapRoadLinkEnittyPro", sb.toString());
        kx kxVar = new kx("all_road_material");
        nj njVar = new nj();
        if (ThemeWatcher.getInstance().isNight()) {
            kxVar.a(this.D);
        }
        njVar.a();
        ni a2 = njVar.a("road", 4, 11L, kxVar);
        p pVar = new p(0.0f, 1.0f, 0.0f);
        float f = 0.9f;
        int i2 = 0;
        p pVar2 = null;
        p pVar3 = null;
        float f2 = 0.0f;
        while (i2 < b.size() - i) {
            sc scVar = b.get(i2);
            int i3 = i2 + 1;
            sc scVar2 = b.get(i3);
            p h = scVar.h();
            p h2 = scVar2.h();
            float i4 = b.get(i2).i();
            float j = b.get(i2).j();
            float f3 = f2 + i4 + j;
            float f4 = j * f;
            float f5 = i4 * f * uc.c;
            this.t.a(h2).c(h);
            this.u.a(this.t);
            this.t.g(pVar);
            this.t.d();
            this.v.a(this.t).a(f5);
            this.w.a(this.t).a(f4 * uc.c);
            p pVar4 = this.x;
            if (pVar2 == null) {
                pVar2 = h.a().c(this.v);
            }
            pVar4.a(pVar2);
            p pVar5 = this.y;
            if (pVar3 == null) {
                pVar3 = h.a().b(this.w);
            }
            pVar5.a(pVar3);
            this.z.a(h2).b(this.w);
            this.A.a(h2).c(this.v);
            ka a3 = a(scVar);
            ni.a e = e();
            e.a(this.x);
            e.a(0.0f, 1.0f);
            e.a(a3);
            ni.a f6 = f();
            f6.a(this.y);
            f6.a(1.0f, 1.0f);
            f6.a(a3);
            ni.a g = g();
            g.a(this.z);
            g.a(1.0f, 0.0f);
            g.a(a3);
            ni.a h3 = h();
            h3.a(this.A);
            h3.a(0.0f, 0.0f);
            h3.a(a3);
            a2.a(e, f6, g, h3);
            pVar3 = this.z;
            pVar2 = this.A;
            if (h2.equals(this.s)) {
                b(this.t);
                a(this.z, this.A, this.u, njVar);
                Log.i("StaticMapRoadLinkEnittyPro", "roadEndFlag dir\t" + this.t);
            }
            if (scVar2.f()) {
                b(this.z, this.A, this.u, njVar);
                Log.i("StaticMapRoadLinkEnittyPro", "RampEndFlag dir\t" + this.t);
            }
            if (scVar2.e()) {
                b(this.z, this.A, this.u, njVar);
                Log.i("StaticMapRoadLinkEnittyPro", "RampStartFlag dir\t" + this.t);
            }
            i2 = i3;
            f2 = f3;
            i = 1;
            f = 0.9f;
        }
        la laVar = new la(njVar.b());
        a(f2, b.size());
        Log.i("StaticMapRoadLinkEnittyPro", "allpath object:\t" + laVar.toString());
        PerformanceTestUnit.logEnd("StaticMapRoadLinkEnittyPro", "DynaAllGuidelineEntityPro>initModelRoadPath");
        return laVar;
    }

    private void a(p pVar, p pVar2, p pVar3, nj njVar) {
        p a2 = pVar.a();
        p a3 = pVar2.a();
        float f = uc.c * (-1.2f);
        ko f2 = this.o.f(this.ao);
        kx kxVar = new kx();
        kxVar.a(ln.a(f2));
        kxVar.a(new le(770, 771));
        p c = a3.a().c(pVar3.a().d().a(f));
        p c2 = a2.a().c(pVar3.a().d().a(f));
        njVar.c().a = "end";
        ni a4 = njVar.a("end", 4, 27L, kxVar);
        p pVar4 = new p(0.0f, 1.0f, 0.0f);
        c.b += 0.1f;
        c2.b += 0.1f;
        a2.b += 0.1f;
        a3.b += 0.1f;
        ni.a aVar = new ni.a();
        aVar.a(c);
        aVar.a(0.0f, 1.0f);
        aVar.b(pVar4);
        ni.a aVar2 = new ni.a();
        aVar2.a(c2);
        aVar2.a(1.0f, 1.0f);
        aVar2.b(pVar4);
        ni.a aVar3 = new ni.a();
        aVar3.a(a2);
        aVar3.a(1.0f, 0.0f);
        aVar3.b(pVar4);
        ni.a aVar4 = new ni.a();
        aVar4.a(a3);
        aVar4.a(0.0f, 0.0f);
        aVar4.b(pVar4);
        a4.a(aVar3, aVar2, aVar);
        a4.a(aVar, aVar4, aVar3);
    }

    private void b(p pVar, p pVar2, p pVar3, nj njVar) {
        p a2 = pVar.a();
        p a3 = pVar2.a();
        float f = uc.c * (-1.2f);
        ko f2 = this.o.f(this.ap);
        kx kxVar = new kx();
        kxVar.a(ln.a(f2));
        kxVar.a(new le(770, 771));
        p c = a3.a().c(pVar3.a().d().a(f));
        p c2 = a2.a().c(pVar3.a().d().a(f));
        njVar.c().a = "end";
        ni a4 = njVar.a("end", 4, 27L, kxVar);
        p pVar4 = new p(0.0f, 1.0f, 0.0f);
        c.b += 0.1f;
        c2.b += 0.1f;
        a2.b += 0.1f;
        a3.b += 0.1f;
        ni.a aVar = new ni.a();
        aVar.a(c);
        aVar.a(0.0f, 1.0f);
        aVar.b(pVar4);
        ni.a aVar2 = new ni.a();
        aVar2.a(c2);
        aVar2.a(1.0f, 1.0f);
        aVar2.b(pVar4);
        ni.a aVar3 = new ni.a();
        aVar3.a(a2);
        aVar3.a(1.0f, 0.0f);
        aVar3.b(pVar4);
        ni.a aVar4 = new ni.a();
        aVar4.a(a3);
        aVar4.a(0.0f, 0.0f);
        aVar4.b(pVar4);
        a4.a(aVar3, aVar2, aVar);
        a4.a(aVar, aVar4, aVar3);
    }

    private void a(float f, int i) {
        float f2 = f / i;
        try {
            d(f2);
            float n = n();
            r3 = n != 0.0f ? n / (5.9406f / uc.c) : 0.9f;
            c(r3);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("StaticMapRoadLinkEnittyPro", "count  error!");
            c(r3);
        }
    }

    @Override // defpackage.rv, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.ay = false;
        this.az.clear();
        Map<Integer, a> map = this.a;
        if (map != null) {
            for (Integer num : map.keySet()) {
                a aVar = this.a.get(num);
                if (aVar != null && aVar.m != null && aVar.m.e != null) {
                    aVar.m.e.dispose();
                    aVar.m = null;
                }
                aVar.dispose();
            }
            this.a.clear();
        }
    }

    /* compiled from: StaticMapRoadLinkEnittyPro.java */
    /* renamed from: sd$a */
    /* loaded from: classes.dex */
    public class a implements g {
        public p a;
        public Matrix4 b;
        public p c;
        public p d;
        public float e;
        public float f;
        public p g;
        public float h;
        public float i;
        public float j;
        public float k;
        private la m;
        private List<la> n = new ArrayList();

        public String toString() {
            return "";
        }

        public void a(float f) {
            this.h = f;
        }

        public void b(float f) {
            this.i = f;
        }

        public void c(float f) {
            this.j = f;
        }

        public void d(float f) {
            this.k = f;
        }

        public void a(p pVar) {
            this.g = pVar;
        }

        public p a() {
            return this.g;
        }

        public void e(float f) {
            this.e = f;
        }

        public void f(float f) {
            this.f = f;
        }

        public float b() {
            return this.e;
        }

        public float c() {
            return this.f;
        }

        public p d() {
            return this.c;
        }

        public p e() {
            return this.d;
        }

        public void b(p pVar) {
            this.c = pVar;
        }

        public void c(p pVar) {
            this.d = pVar;
        }

        public a() {
        }

        public void a(la laVar) {
            this.m = laVar;
        }

        public void d(p pVar) {
            this.a = pVar;
        }

        public la f() {
            return this.m;
        }

        public p g() {
            return this.a;
        }

        public float h() {
            return Math.max(this.i - this.h, this.k - this.j);
        }

        @Override // com.badlogic.gdx.utils.g, defpackage.ik
        public void dispose() {
            this.m = null;
            this.a = null;
            this.b = null;
        }
    }

    public float a(a.c cVar) {
        if (cVar == null || cVar.f() == 0) {
            PerformanceTestUnit.log("getDistanceOfLastPointLine", "location is not map pos ", 5000L);
            return -1.0f;
        }
        o().a(cVar.a().a(), cVar.a().b(), cVar.a().c());
        p pVar = this.E;
        if (pVar != null) {
            return pVar.d(o());
        }
        return 0.0f;
    }

    public void r() {
        a aVar;
        la f;
        for (Integer num : this.a.keySet()) {
            if (num.intValue() != 666 && (aVar = this.a.get(num)) != null && (f = aVar.f()) != null) {
                Log.i("StaticMapRoadLinkEnittyPro", "updateDayMaterial");
                kx b = f.b("road_material");
                b.c();
                b.a(this.C);
            }
        }
        la b2 = b(666);
        if (b2 != null) {
            Log.i("StaticMapRoadLinkEnittyPro", "updateDayMaterial allRoadInstance");
            b2.b("all_road_material").c();
        }
    }

    public void s() {
        a aVar;
        la f;
        Log.i("StaticMapRoadLinkEnittyPro", "updateNightMaterial");
        for (Integer num : this.a.keySet()) {
            if (num.intValue() != 666 && (aVar = this.a.get(num)) != null && (f = aVar.f()) != null) {
                Log.i("StaticMapRoadLinkEnittyPro", "updateNightMaterial");
                kx b = f.b("road_material");
                b.c();
                b.a(this.B);
            }
        }
        la b2 = b(666);
        if (b2 != null) {
            Log.i("StaticMapRoadLinkEnittyPro", "updateNightMaterial allRoadInstance");
            kx b3 = b2.b("all_road_material");
            b3.c();
            b3.a(this.D);
        }
    }
}
