package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.utils.WheelUtil;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.autopilot.parking.view.g3d.l;
import com.xiaopeng.lib.utils.view.UIUtils;
import java.util.Iterator;
/* compiled from: RadarEntity.java */
/* renamed from: ul  reason: default package */
/* loaded from: classes.dex */
public class ul extends aci {
    private static final int a = (int) (UIUtils.dip2px(a.g(), (a.g().getResources().getDimension(e.c.reversing_radar_surface_3d_r) / 488.0f) * 140.0f) * 2.0f);
    private float b;
    private float c;
    private ni d;
    private la e;
    private ky f;
    private float g;
    private int h;
    private l i;

    public ul() {
        int i = a;
        this.b = i;
        this.c = i;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(l lVar) {
        this.i = lVar;
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        C().an().b("material/radar.g3db", ky.class);
        C().an().b("material/stat_notify_error.png", ko.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.aci, com.badlogic.gdx.utils.z.a
    public void reset() {
        super.reset();
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.L != null && i()) {
            kzVar.a(this.L);
        }
        if (this.e == null || !j()) {
            return;
        }
        kzVar.a(this.e);
    }

    private boolean f() {
        return C().an().c("material/radar.g3db");
    }

    public void e() {
        g();
        k();
    }

    private void g() {
        if ((this.K == null || this.L == null) && f()) {
            this.K = (ky) C().an().a("material/radar.g3db");
            this.L = new la(this.K);
            le leVar = new le(770, 771);
            k_().b.a(0).a(leVar);
            Iterator<kx> it = k_().b.iterator();
            while (it.hasNext()) {
                it.next().a(leVar);
            }
        }
    }

    private void a(ln lnVar) {
        if (this.L != null) {
            this.L.b.a(0).a(lnVar);
        }
    }

    private void b(int i) {
        String str = null;
        switch (i) {
            case 1:
                str = "material/radargreed.png";
                break;
            case 2:
                str = "material/radaryellow.png";
                break;
            case 3:
                str = "material/radarred.png";
                break;
        }
        try {
            a(ln.a(C().an().f(str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(float f) {
        this.b = f;
    }

    private void h() {
        float f = this.c;
        float f2 = this.b;
        if (f != f2) {
            float abs = 1.5f > Math.abs(f - f2) ? Math.abs(this.c - this.b) : 1.5f;
            float f3 = this.c;
            if (f3 < this.b) {
                this.c = f3 + abs;
            } else {
                this.c = f3 - abs;
            }
        }
    }

    private boolean i() {
        l lVar = this.i;
        return (lVar == null || lVar.b() == null || this.i.b()[this.h] == 0) ? false : true;
    }

    private boolean j() {
        l lVar = this.i;
        return (lVar == null || lVar.c() == null || this.i.c()[this.h] != 1) ? false : true;
    }

    public void a(p pVar) {
        l lVar = this.i;
        if (lVar == null || lVar.a() == null || this.i.b() == null || this.i.c() == null || !i()) {
            return;
        }
        int[] b = this.i.b();
        int i = this.h;
        int i2 = b[i];
        switch (i) {
            case 0:
                this.g = -79.25f;
                break;
            case 1:
                this.g = -47.5f;
                break;
            case 2:
                this.g = -15.875f;
                break;
            case 3:
                this.g = 15.875f;
                break;
            case 4:
                this.g = 47.5f;
                break;
            case 5:
                this.g = 79.25f;
                break;
        }
        char c = 0;
        switch (i2) {
            case 1:
            case 7:
                c = 3;
                break;
            case 2:
                c = 2;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                c = 1;
                break;
        }
        h();
        float f = this.c + 90.0f;
        if (d.c()) {
            Log.i("RadarEntity", "index = " + this.h + ",isShow = " + i() + ",isFront = " + this.i.d() + ",target = " + this.b + ",cur = " + this.c + ",distance = " + f);
        }
        if (this.L != null && this.L.f != null) {
            this.L.f.c();
        }
        if (this.f != null && this.e.f != null) {
            this.e.f.c();
        }
        float a2 = g.a(ul.class);
        float f2 = pVar == null ? 0.0f : pVar.c;
        float f3 = ((0.915f * f) / a) + 0.0f;
        if (this.i.d()) {
            double d = f;
            float a3 = uk.a((float) (WheelUtil.sin(this.g) * d));
            float a4 = uk.a((float) (d * WheelUtil.cos(this.g)));
            Matrix4 matrix4 = new Matrix4();
            matrix4.e(a3, a2, -(a4 + (((uc.f * 6.858721f) - f2) - 2.55f)));
            matrix4.a(f3);
            matrix4.d(0.0f, 1.0f, 0.0f, -this.g);
            b(matrix4);
            if (k_() != null) {
                Matrix4 a5 = k_().f.a();
                Matrix4 matrix42 = new Matrix4();
                matrix42.a(0.4f);
                a5.b(matrix42);
                la laVar = this.e;
                if (laVar != null) {
                    laVar.f.b(a5);
                }
            }
        } else {
            double d2 = f;
            float a6 = uk.a((float) (WheelUtil.sin(this.g) * d2));
            float a7 = uk.a((float) (d2 * WheelUtil.cos(this.g)));
            Matrix4 matrix43 = new Matrix4();
            matrix43.e(-a6, a2, a7 + ((1.0f - uc.f) * 6.858721f) + f2 + 0.35f);
            matrix43.a(f3);
            matrix43.d(0.0f, 1.0f, 0.0f, (-this.g) + 180.0f);
            b(matrix43);
            if (k_() != null) {
                Matrix4 a8 = k_().f.a();
                Matrix4 matrix44 = new Matrix4();
                matrix44.a(0.4f);
                a8.b(matrix44);
                la laVar2 = this.e;
                if (laVar2 != null) {
                    laVar2.f.b(a8);
                }
            }
        }
        switch (c) {
            case 1:
                b(1);
                return;
            case 2:
                b(2);
                return;
            case 3:
                b(3);
                return;
            default:
                return;
        }
    }

    private void k() {
        if (j()) {
            if ((this.f == null || this.e == null) && f()) {
                nj njVar = new nj();
                ko koVar = new ko(io.e.internal("material/stat_notify_error.png"));
                kx kxVar = new kx();
                kxVar.a(ln.a(koVar));
                kxVar.a(new le(770, 771));
                njVar.a();
                njVar.a(koVar);
                njVar.c().a = "rect";
                this.d = njVar.a("rect", 4, 29L, kxVar);
                this.d.a(new p(1.0f, 0.0f, -1.0f), new p(-1.0f, 0.0f, -1.0f), new p(-1.0f, 0.0f, 1.0f), new p(1.0f, 0.0f, 1.0f), new p(0.0f, 1.0f, 0.0f));
                this.f = njVar.b();
                this.e = new la(this.f, new Matrix4().a(0.0f, 0.0f, 0.0f), "rect", true);
            }
        }
    }
}
