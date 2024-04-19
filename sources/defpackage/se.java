package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.p;
import java.util.List;
/* compiled from: StaticRsTrainingMapRoadEntityPro.java */
/* renamed from: se  reason: default package */
/* loaded from: classes.dex */
public class se extends ry {
    protected float h = uc.c * 1.2f;
    protected ka i = new ka(1.1333333f, 1.1333333f, 0.0f, 1.0f);
    private float j;
    private float k;
    private float l;
    private float m;
    private p n;

    public void a(p pVar) {
        this.n = pVar;
    }

    public void a(float f) {
        this.h = f;
    }

    public void a(ka kaVar) {
        this.i = kaVar;
    }

    public se() {
        a(new ka(0.6862745f, 0.95686275f, 0.9019608f, 1.0f));
        a(uc.c * 2.5f);
    }

    private void b(List<p> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        p pVar = new p();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (p pVar2 : list) {
            if (pVar2.a < f) {
                f = pVar2.a;
            }
            if (pVar2.c < f3) {
                f3 = pVar2.c;
            }
            if (pVar2.a > f2) {
                f2 = pVar2.a;
            }
            if (pVar2.c > f4) {
                f4 = pVar2.c;
            }
        }
        pVar.a = ((f2 - f) / 2.0f) + f;
        pVar.b = 0.0f;
        pVar.c = ((f4 - f3) / 2.0f) + f3;
        this.j = f2;
        this.k = f;
        this.l = f4;
        this.m = f3;
        a(pVar);
        Log.i("StaticRsTrainingMapRoadEntityPro", "Rect center:\t" + this.X.toString());
    }

    @Override // defpackage.ry
    public la a(List<p> list) {
        io.g.glLineWidth(4.0f);
        Log.i("StaticRsTrainingMapRoadEntityPro", "createNetModelPointLine");
        long currentTimeMillis = System.currentTimeMillis();
        List<p> a = a(list, 3);
        if (a != null && a.size() > 0) {
            b(a);
        }
        kx kxVar = new kx();
        kxVar.a(new le(770, 771));
        nj njVar = new nj();
        njVar.a();
        ni a2 = njVar.a("road", 4, 11L, kxVar);
        p pVar = new p(0.0f, 1.0f, 0.0f);
        int i = 0;
        p pVar2 = null;
        p pVar3 = null;
        while (i < a.size() - 1) {
            p pVar4 = a.get(i);
            i++;
            p pVar5 = a.get(i);
            p d = pVar5.a().c(pVar4).a().g(pVar.a()).d();
            if (pVar2 == null) {
                pVar2 = pVar4.a().c(d.a().a(this.h / 2.0f));
            }
            if (pVar3 == null) {
                pVar3 = pVar4.a().b(d.a().a(this.h / 2.0f));
            }
            p pVar6 = pVar3;
            pVar3 = pVar5.a().b(d.a().a(this.h / 2.0f));
            p c = pVar5.a().c(d.a().a(this.h / 2.0f));
            ka kaVar = this.i;
            a2.a(pVar2, kaVar, pVar6, kaVar, pVar3, kaVar);
            ka kaVar2 = this.i;
            a2.a(pVar3, kaVar2, c, kaVar2, pVar2, kaVar2);
            pVar2 = c;
        }
        la laVar = new la(njVar.b());
        Log.i("StaticRsTrainingMapRoadEntityPro", "cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        return laVar;
    }

    @Override // defpackage.ry, defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }
}
