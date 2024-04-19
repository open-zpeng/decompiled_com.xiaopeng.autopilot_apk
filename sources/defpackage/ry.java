package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import defpackage.ahz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: LinkPointEntityPro.java */
/* renamed from: ry  reason: default package */
/* loaded from: classes.dex */
public class ry extends aci {
    la a;
    ky b;
    float c = 0.0f;
    float d = 0.0f;
    float e = 0.0f;
    Map<Integer, la> f = new HashMap();
    protected List<p> g = new ArrayList();

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<p> a(List<p> list, int i) {
        this.g.clear();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 % i == 0) {
                    this.g.add(list.get(i2));
                }
            }
        }
        return this.g;
    }

    public void a(List<p> list, tk tkVar) {
        List<ahz.c.h> x = tkVar.x();
        if (x == null) {
            return;
        }
        for (ahz.c.h hVar : x) {
            int a = hVar.a();
            ArrayList arrayList = new ArrayList();
            for (p pVar : list) {
                if (a == tkVar.a(pVar.c)) {
                    arrayList.add(tz.a(pVar.a, pVar.b, pVar.c));
                }
            }
            Log.i("LinkPointEntity", "floor data:\t" + a + "\tsize:" + arrayList.size());
            this.f.put(Integer.valueOf(a), a(arrayList));
        }
        i(true);
    }

    public la a(List<p> list) {
        io.g.glLineWidth(4.0f);
        Log.i("LinkPointEntity", "createNetModelPointLine");
        long currentTimeMillis = System.currentTimeMillis();
        List<p> a = a(list, 3);
        kx kxVar = new kx();
        kxVar.a(new le(770, 771));
        nj njVar = new nj();
        njVar.a();
        ni a2 = njVar.a("road", 1, 11L, kxVar);
        new p(0.0f, 1.0f, 0.0f);
        for (int i = 0; i < a.size() - 1; i++) {
            if (i % 2 != 0) {
                p pVar = a.get(i);
                p pVar2 = a.get(i + 1);
                a2.a(ka.t);
                a2.a(pVar.a, pVar.b, pVar.c, pVar2.a, pVar2.b, pVar2.c);
            }
        }
        la laVar = new la(njVar.b());
        Log.i("LinkPointEntity", "cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        return laVar;
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        io.a.postRunnable(new Runnable() { // from class: ry.1
            @Override // java.lang.Runnable
            public void run() {
                PerformanceTestUnit.logStart("LinkPointEntity");
                if (ry.this.a != null && ry.this.a.e != null) {
                    ry.this.b.dispose();
                }
                if (ry.this.f != null) {
                    for (Integer num : ry.this.f.keySet()) {
                        la laVar = ry.this.f.get(num);
                        if (laVar != null && laVar.e != null) {
                            laVar.e.dispose();
                        }
                    }
                }
                PerformanceTestUnit.logEnd("LinkPointEntity", "LinkPointEntityPro.dispose");
            }
        });
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        la laVar = this.a;
        if (laVar != null) {
            kzVar.a(laVar);
        }
    }
}
