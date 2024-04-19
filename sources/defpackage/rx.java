package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: DynaTrainingGuildelineEntityPro.java */
/* renamed from: rx  reason: default package */
/* loaded from: classes.dex */
public class rx extends rv {
    private static float an;
    private static float ao;
    private static float ap;
    private static float aq;
    private static p ar = new p(0.0f, 0.0f, 0.0f);
    private static final float au = uc.c * 1.15f;
    private static Matrix4 az;
    private la aA;
    private la aB;
    private la aC;
    private ky aE;
    private p aG;
    private p aH;
    private la aI;
    private ka ak = new ka(1.0f, 1.0f, 1.0f, 1.0f);
    private ka al = new ka(1.0f, 0.0f, 0.0f, 1.0f);
    private ka am = new ka(0.11372549f, 0.15294118f, 0.22352941f, 1.0f);
    lf a = lf.b(0.7111111f, 0.7777778f, 0.84444445f, 1.0f);
    lf n = lf.a(this.am);
    private p as = new p(0.0f, 0.0f, 0.0f);
    int o = 100;
    float p = 1.0f / this.o;
    final p q = new p();
    private float at = uc.c * 0.2f;
    private float av = uc.c * 0.08f;
    private p aw = null;
    private p ax = null;
    private p ay = null;
    public ArrayList<sb> r = new ArrayList<>();
    private int aD = 10;
    p s = new p();
    p t = new p();
    p u = new p();
    p v = new p();
    p w = new p();
    p x = new p();
    p y = new p();
    p z = new p();
    p A = new p();
    p B = new p();
    p C = new p();
    p D = new p();
    p E = new p();
    private p aF = new p();
    private p aJ = new p();
    private List<p> aK = new ArrayList();
    kx F = new kx("train_road_material");
    nj G = new nj();
    p H = new p(0.0f, 1.0f, 0.0f);
    private boolean aL = false;
    private int aM = 0;

    public p m() {
        return this.as;
    }

    public p n() {
        return this.aJ;
    }

    public static p o() {
        return q();
    }

    public static float p() {
        return Math.max(ao - an, ap - aq);
    }

    public rx(aca acaVar) {
        a(0.7111111f, 0.7777778f, 0.84444445f, 1.0f);
        b(uc.c * 2.5f * 0.7f);
        if (acaVar.c("model/entity/star_flag.g3db")) {
            this.aI = new la((ky) acaVar.a("model/entity/star_flag.g3db"));
            Log.i("DynaTrainingGuildelineEntityPro", "start_flag model  loaded success!");
            return;
        }
        Log.e("DynaTrainingGuildelineEntityPro", "start_flag model do not loaded!");
    }

    public rx() {
        a(0.7111111f, 0.7777778f, 0.84444445f, 1.0f);
        b(uc.c * 2.5f);
    }

    public void a(p pVar, Matrix4 matrix4, p pVar2) {
        if (pVar == null || matrix4 == null) {
            return;
        }
        a(pVar.d(pVar2));
        this.aJ = pVar.a().a(az);
    }

    private void a(List<p> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (an == 0.0f && ao == 0.0f && aq == 0.0f && ap == 0.0f) {
            p pVar = list.get(0);
            an = pVar.a;
            aq = pVar.c;
            ao = pVar.a;
            ap = pVar.c;
        }
        for (p pVar2 : list) {
            an = Math.min(pVar2.a, an);
            aq = Math.min(pVar2.c, aq);
            ao = Math.max(pVar2.a, ao);
            ap = Math.max(pVar2.c, ap);
        }
    }

    public static p q() {
        float f = ao;
        float f2 = an;
        float f3 = ap;
        float f4 = aq;
        p pVar = ar;
        pVar.a = f2 + ((f - f2) / 2.0f);
        pVar.b = 0.08f;
        pVar.c = f4 + ((f3 - f4) / 2.0f);
        Matrix4 matrix4 = az;
        if (matrix4 != null) {
            pVar.a(matrix4);
        }
        return ar;
    }

    public la a(List<p> list, Matrix4 matrix4, p pVar) {
        p pVar2;
        p pVar3;
        this.aH = pVar;
        int size = list.size();
        io.a.postRunnable(new Runnable() { // from class: rx.1
            @Override // java.lang.Runnable
            public void run() {
                if (rx.this.aB != null) {
                    rx.this.aB.e.dispose();
                    rx.this.aB = null;
                }
                if (rx.this.aA != null) {
                    rx.this.aA.e.dispose();
                    rx.this.aA = null;
                }
            }
        });
        az = matrix4.d();
        a(list);
        lf lfVar = ThemeWatcher.getInstance().isNight() ? this.n : this.a;
        this.F.c();
        this.F.a(lfVar);
        s();
        if (size > 0 && this.ay == null) {
            this.ay = list.get(0);
        }
        int i = 0;
        while (true) {
            pVar2 = null;
            if (i >= size - 2) {
                break;
            }
            this.G.a();
            ni a = this.G.a("road", 4, 11L, this.F);
            p pVar4 = this.ay;
            i++;
            p pVar5 = list.get(i);
            if (this.aG == null) {
                this.aG = pVar4;
            }
            this.s.a(pVar5).c(pVar4);
            this.s.g(this.H.a());
            this.s.d();
            this.s.a(this.b / 2.0f);
            p pVar6 = this.t;
            p pVar7 = this.ax;
            if (pVar7 == null) {
                pVar7 = pVar4.a().c(this.s);
            }
            pVar6.a(pVar7);
            p pVar8 = this.u;
            p pVar9 = this.aw;
            if (pVar9 == null) {
                pVar9 = pVar4.a().b(this.s);
            }
            pVar8.a(pVar9);
            this.v.a(pVar5).b(this.s);
            this.w.a(pVar5).c(this.s);
            a.a(this.t, this.u, this.v, this.w, this.aF);
            if (this.aE != null) {
                this.G.a("line" + this.aE.b.b, this.aE);
            }
            ky b = this.G.b();
            this.aE = b;
            int intValue = ((i.at) i.a(i.at.class)).d().intValue();
            if (intValue == 40) {
                if (!this.aL) {
                    this.aL = true;
                    this.aD = 0;
                    this.aM = this.r.size();
                }
            } else if (intValue == 41 && this.aL) {
                this.aL = false;
            }
            int i2 = this.aD;
            if (i2 > 0) {
                if (i2 == 10) {
                    this.aG = pVar4;
                }
                this.L = new la(b);
                this.aD--;
            } else {
                this.aD = 10;
                sb sbVar = new sb(b);
                if (this.r.size() >= 80) {
                    final sb sbVar2 = this.r.get(0);
                    io.a.postRunnable(new Runnable() { // from class: rx.2
                        @Override // java.lang.Runnable
                        public void run() {
                            sb sbVar3 = sbVar2;
                            if (sbVar3 != null) {
                                sbVar3.a.e.dispose();
                            }
                        }
                    });
                    this.r.remove(0);
                }
                sbVar.a(this.aG);
                sbVar.b(pVar5);
                sbVar.a(this.aL);
                this.r.add(sbVar);
                this.aE = null;
                this.L = null;
            }
            this.ay = pVar5;
            this.aw = this.v;
            this.ax = this.w;
        }
        int size2 = list.size();
        if (size2 < 2 || this.ay == null) {
            pVar3 = null;
        } else {
            this.G.a();
            ni a2 = this.G.a("road", 4, 11L, this.F);
            p pVar10 = this.ay;
            p pVar11 = list.get(size2 - 2);
            this.s.a(pVar11).c(pVar10);
            this.s.g(this.H.a());
            this.s.d();
            this.s.a(this.b / 2.0f);
            p pVar12 = this.x;
            p pVar13 = this.ax;
            if (pVar13 == null) {
                pVar13 = pVar10.a().c(this.s);
            }
            pVar12.a(pVar13);
            p pVar14 = this.y;
            p pVar15 = this.aw;
            if (pVar15 == null) {
                pVar15 = pVar10.a().b(this.s);
            }
            pVar14.a(pVar15);
            this.z.a(pVar11).b(this.s);
            this.A.a(pVar11).c(this.s);
            a2.a(this.x, this.y, this.z, this.A, this.aF);
            this.aA = new la(this.G.b());
            pVar2 = this.z;
            pVar3 = this.A;
        }
        int size3 = list.size();
        if (size3 >= 2) {
            this.G.a();
            ni a3 = this.G.a("road", 4, 11L, this.F);
            p pVar16 = list.get(size3 - 2);
            p pVar17 = list.get(size3 - 1);
            this.s.a(pVar17).c(pVar16);
            this.s.g(this.H.a());
            this.s.d();
            this.s.a(this.b / 2.0f);
            p pVar18 = this.B;
            if (pVar3 == null) {
                pVar3 = pVar16.a().c(this.s);
            }
            pVar18.a(pVar3);
            p pVar19 = this.C;
            if (pVar2 == null) {
                pVar2 = pVar16.a().b(this.s);
            }
            pVar19.a(pVar2);
            this.D.a(pVar17).b(this.s);
            this.E.a(pVar17).c(this.s);
            a3.a(this.B, this.C, this.D, this.E, this.aF);
            this.aB = new la(this.G.b());
        }
        la laVar = this.aB;
        if (laVar != null) {
            laVar.f.c();
            this.aB.f.b(az);
        }
        la laVar2 = this.aA;
        if (laVar2 != null) {
            laVar2.f.c();
            this.aA.f.b(az);
        }
        if (this.L != null) {
            this.L.f.c();
            this.L.f.b(az);
        }
        i(true);
        return this.L;
    }

    public void a(kz kzVar, boolean z) {
        if (this.aC != null && G()) {
            kzVar.a(this.aC);
        }
        if (G()) {
            if (z) {
                Iterator<sb> it = this.r.iterator();
                while (it.hasNext()) {
                    sb next = it.next();
                    if (next.c(this.aH)) {
                        le leVar = new le(770, 771);
                        leVar.f = 0.5f;
                        kx b = next.a.b("train_road_material");
                        if (b != null) {
                            b.a(leVar);
                        }
                        next.a.f.c();
                        next.a.f.b(az);
                    } else {
                        next.a.f.c();
                        next.a.f.b(az);
                    }
                    kzVar.a(next.a);
                }
            } else if (this.aL) {
                for (int i = this.aM; i < this.r.size(); i++) {
                    sb sbVar = this.r.get(i);
                    if (sbVar.a(this.aH, z)) {
                        sbVar.a.f.c();
                        sbVar.a.f.b(az);
                        kzVar.a(sbVar.a);
                    }
                }
            } else {
                Iterator<sb> it2 = this.r.iterator();
                while (it2.hasNext()) {
                    sb next2 = it2.next();
                    if (next2.b(this.aH, z)) {
                        next2.a.f.c();
                        next2.a.f.b(az);
                        kzVar.a(next2.a);
                    }
                }
            }
        }
        if (this.aB != null && G()) {
            kzVar.a(this.aB);
        }
        if (this.aA != null && G()) {
            kzVar.a(this.aA);
        }
        if (this.L != null && G()) {
            kzVar.a(this.L);
        }
        if ((this.aI != null && this.e > 3.4293604f && G() && r()) || z) {
            this.aI.f.c();
            this.aI.f.b(n());
            kzVar.a(this.aI);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("render flag :\t");
        sb.append(this.aI == null);
        sb.append("\t length:\t");
        sb.append(this.e > 3.4293604f);
        PerformanceTestUnit.log("render_flag", sb.toString(), 2000L);
    }

    public boolean r() {
        double abs = Math.abs(n().b);
        Log.d("DynaTrainingGuildelineEntityPro", "isSameFloor = " + abs);
        return abs <= 2.0d;
    }

    public void s() {
        if (this.aC == null) {
            p pVar = new p(0.0f, 0.0f, 0.0f);
            this.G.a();
            ni a = this.G.a("road", 4, 11L, this.F);
            float f = (this.b / 2.0f) + 0.04f;
            p pVar2 = new p(pVar.a + f, 0.08f, pVar.c + f);
            a.a(new p(pVar.a + f, 0.08f, pVar.c), new p(pVar.a - f, 0.08f, pVar.c), new p(pVar.a - f, 0.08f, pVar.c + f), pVar2, new p());
            this.aC = new la(this.G.b());
        }
    }

    @Override // defpackage.rv, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        Log.d("DynaTrainingGuildelineEntityPro", "initModelCaseTwo dispose");
        this.aL = false;
        this.aM = 0;
        an = 0.0f;
        ao = 0.0f;
        ap = 0.0f;
        aq = 0.0f;
        io.a.postRunnable(new Runnable() { // from class: rx.3
            @Override // java.lang.Runnable
            public void run() {
                rx.this.i(false);
                Iterator<sb> it = rx.this.r.iterator();
                while (it.hasNext()) {
                    it.next().a.e.dispose();
                }
                rx.this.r.clear();
                if (rx.this.L != null && rx.this.L.e != null) {
                    rx.this.L.e.dispose();
                    rx.this.L = null;
                }
                if (rx.this.aB != null) {
                    rx.this.aB.e.dispose();
                    rx.this.aB = null;
                }
                if (rx.this.aA != null) {
                    rx.this.aA.e.dispose();
                    rx.this.aA = null;
                }
                if (rx.this.aC != null) {
                    rx.this.aC.e.dispose();
                    rx.this.aC = null;
                }
                rx.this.aw = null;
                rx.this.ax = null;
                rx.this.ay = null;
                rx.this.aE = null;
                if (rx.this.aK != null) {
                    rx.this.aK.clear();
                    rx.this.aK = null;
                }
            }
        });
    }

    public void t() {
        kx b;
        kx b2;
        kx b3;
        kx b4;
        lf lfVar = ThemeWatcher.getInstance().isNight() ? this.n : this.a;
        la laVar = this.aC;
        if (laVar != null && (b4 = laVar.b("train_road_material")) != null) {
            b4.c();
            b4.a(lfVar);
        }
        Iterator<sb> it = this.r.iterator();
        while (it.hasNext()) {
            kx b5 = it.next().a.b("train_road_material");
            if (b5 != null) {
                b5.c();
                b5.a(lfVar);
            }
        }
        if (this.L != null && (b3 = this.L.b("train_road_material")) != null) {
            b3.c();
            b3.a(lfVar);
        }
        la laVar2 = this.aB;
        if (laVar2 != null && (b2 = laVar2.b("train_road_material")) != null) {
            b2.c();
            b2.a(lfVar);
        }
        if (this.aA == null || (b = this.aB.b("train_road_material")) == null) {
            return;
        }
        b.c();
        b.a(lfVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("x_min: " + an);
        stringBuffer.append("\t");
        stringBuffer.append("x_max: " + ao);
        stringBuffer.append("\t");
        stringBuffer.append("z_min: " + aq);
        stringBuffer.append("\t");
        stringBuffer.append("z_max: " + ap);
        stringBuffer.append("\t");
        stringBuffer.append("center:" + o().toString());
        stringBuffer.append("\t");
        stringBuffer.append("right_Down:" + m().toString());
        return stringBuffer.toString();
    }
}
