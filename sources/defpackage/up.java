package defpackage;

import android.graphics.Point;
import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ParkLotEntity.java */
/* renamed from: up  reason: default package */
/* loaded from: classes.dex */
public class up extends aci implements ThemeWatcher.OnThemeSwitchListener {
    private static float a = 0.0242f;
    public static float h = 7.99f;
    public static float i = 3.781f;
    private int b;
    private boolean c;
    private p e;
    private float f;
    private int g;
    private Matrix4 l;
    private ParkLotItem m;
    private p n;
    private float o;
    private int p;
    private int q;
    private boolean d = false;
    private boolean j = false;
    private int k = 0;

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void a(int i2) {
        this.g = i2;
    }

    public void c(p pVar) {
        this.n = pVar;
    }

    public p o() {
        return this.n;
    }

    public void b(int i2) {
        this.p = i2;
    }

    public int p() {
        return this.p;
    }

    public int r() {
        return this.q;
    }

    public void c(int i2) {
        this.q = i2;
    }

    public void a(float f) {
        this.o = f;
    }

    public void a(ParkLotItem parkLotItem) {
        this.m = parkLotItem;
    }

    public ParkLotItem s() {
        return this.m;
    }

    public void c(Matrix4 matrix4) {
        this.l = matrix4;
    }

    public int t() {
        return this.k;
    }

    public void d(int i2) {
        this.k = i2;
    }

    public boolean u() {
        return this.j;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public p v() {
        p pVar;
        this.N = D();
        if (this.L != null && this.N == null) {
            this.L.a(this.N);
        }
        if (this.N != null) {
            pVar = new p();
            this.N.a(pVar);
        } else {
            pVar = null;
        }
        if (pVar != null && this.L != null && this.L.f != null) {
            pVar.a(this.L.f);
        }
        return pVar;
    }

    public void d(p pVar) {
        this.e = pVar;
    }

    public void b(float f) {
        this.f = f;
    }

    public boolean w() {
        return this.c;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public int x() {
        return this.b;
    }

    public void e(int i2) {
        this.b = i2;
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        C().an().b(this.J, ky.class);
    }

    @Override // defpackage.aci
    public void a(kz kzVar) {
        if (this.ab && G()) {
            this.Z = F();
            this.Z.f.c();
            this.Z.f.b(this.ad);
            if (this.Z != null) {
                kzVar.a(this.Z);
            }
        }
        if (this.L == null || !G()) {
            return;
        }
        kzVar.a(this.L);
    }

    public void a(boolean z) {
        aca an = C().an();
        if ((this.K == null || this.L == null) && an.c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            try {
                this.L = new la(this.K);
            } catch (k e) {
                Log.i("ParkLotEntity22", "GdxRuntimeException mModelPath = " + this.J);
                e.printStackTrace();
            }
            if (z && k_() != null) {
                le leVar = new le(770, 771);
                a<kx> aVar = k_().b;
                try {
                    if (aVar.b > 0) {
                        for (int i2 = 0; i2 < aVar.b; i2++) {
                            aVar.a(i2).a(leVar);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (ThemeWatcher.getInstance().isNight()) {
                g();
                f();
                return;
            }
            g();
            e();
        }
    }

    @Override // defpackage.aci
    public void b(Matrix4 matrix4) {
        if (this.L != null) {
            this.L.f.c();
            this.L.f.b(matrix4);
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
        if (this.K != null) {
            this.K.dispose();
        }
    }

    public void a(ParkLotItem parkLotItem, float f, p pVar, Matrix4 matrix4) {
        a(parkLotItem);
        b(f);
        d(pVar);
        d(parkLotItem.getDir());
        d(parkLotItem.isLeft());
        e(parkLotItem.isFree());
        a(!parkLotItem.isFree());
        e(parkLotItem.getSlotIndex());
        i(true);
        a(pVar, f);
        d(matrix4);
        c(matrix4);
        if (this instanceof uu) {
            y();
        }
    }

    public void y() {
        kx a2;
        new le(770, 771).f = 0.999f;
        le leVar = new le(770, 771);
        if (k_() == null || k_().b == null || (a2 = k_().b.a(0)) == null) {
            return;
        }
        a2.a(leVar);
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i2) {
        if (i2 == 1) {
            e();
        }
        if (i2 == 2) {
            f();
        }
    }

    @Override // defpackage.aci
    public boolean a(jz jzVar, int i2, int i3) {
        boolean a2;
        if (Math.abs(this.f) > 15.0f) {
            a2 = b(jzVar, i2, i3);
        } else {
            a2 = super.a(jzVar, i2, i3);
        }
        Log.i("ParkLotEntity22", "angle is :\t" + this.f + "is touched :\t " + a2);
        return a2;
    }

    protected boolean b(jz jzVar, int i2, int i3) {
        nz nzVar = new nz();
        if (this.L != null) {
            this.L.a(nzVar);
        }
        p pVar = new p();
        p pVar2 = new p();
        p pVar3 = new p();
        p pVar4 = new p();
        p pVar5 = new p();
        p pVar6 = new p();
        p pVar7 = new p();
        p pVar8 = new p();
        nzVar.b(pVar);
        nzVar.d(pVar2);
        nzVar.e(pVar3);
        nzVar.c(pVar4);
        nzVar.f(pVar5);
        nzVar.h(pVar6);
        nzVar.i(pVar7);
        nzVar.g(pVar8);
        if (this.L != null) {
            pVar2 = pVar2.a(this.L.f);
            pVar6 = pVar6.a(this.L.f);
            pVar7 = pVar7.a(this.L.f);
            pVar3 = pVar3.a(this.L.f);
        }
        p c = jzVar.c(pVar2);
        p c2 = jzVar.c(pVar6);
        p c3 = jzVar.c(pVar7);
        p c4 = jzVar.c(pVar3);
        int height = io.a.getGraphics().getHeight() - i3;
        ArrayList arrayList = new ArrayList();
        Point point = new Point((int) c.a, (int) c.b);
        Point point2 = new Point((int) c2.a, (int) c2.b);
        Point point3 = new Point((int) c3.a, (int) c3.b);
        Point point4 = new Point((int) c4.a, (int) c4.b);
        arrayList.add(point);
        arrayList.add(point2);
        arrayList.add(point3);
        arrayList.add(point4);
        return a(i2, height, arrayList);
    }

    public static boolean a(int i2, int i3, List<Point> list) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            Point point = list.get(i4);
            i4++;
            Point point2 = list.get(i4 % list.size());
            if (point.y != point2.y && i3 >= Math.min(point.y, point2.y) && i3 < Math.max(point.y, point2.y) && (((i3 - point.y) * (point2.x - point.x)) / (point2.y - point.y)) + point.x > i2) {
                i5++;
            }
        }
        return i5 % 2 == 1;
    }

    public p z() {
        p pVar = new p();
        if (this.L == null) {
            return null;
        }
        return this.L.f.a(pVar);
    }

    public float A() {
        if (this.L == null) {
            return 0.0f;
        }
        l lVar = new l();
        this.L.f.b(lVar);
        return lVar.f();
    }

    public boolean a(boolean z, p pVar, p pVar2, p pVar3, p pVar4, p pVar5) {
        float b;
        if (((i.ad) i.a(i.ad.class)).d().intValue() != 2) {
            return true;
        }
        p a2 = a(pVar2, pVar3, pVar4, pVar5);
        a2.c = 0.0f;
        pVar.c = 0.0f;
        if (z) {
            b = a2.d(pVar);
        } else {
            b = a2.b();
        }
        boolean z2 = b >= 3.172f;
        PerformanceTestUnit.log("ParkLotEntity22", "distance = " + b + "," + pVar + "," + a2, 1000L);
        return z2;
    }

    public static p a(p pVar, p pVar2, p pVar3, p pVar4) {
        return new p(pVar.a + ((pVar3.a - pVar.a) / 2.0f), pVar3.b + ((pVar.b - pVar3.b) / 2.0f), pVar.c);
    }
}
