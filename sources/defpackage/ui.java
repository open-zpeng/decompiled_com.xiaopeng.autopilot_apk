package defpackage;

import android.util.Log;
import com.xiaopeng.autopilot.parking.view.g3d.g;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* compiled from: NetRoadEntity.java */
/* renamed from: ui  reason: default package */
/* loaded from: classes.dex */
public class ui extends aci {
    la a;
    ky b;
    la c;
    ky d;
    float e = 0.0f;
    float f = 2.8f;
    float g = 20.0f;
    float h = 18.0f;
    float i = 5.0f;
    float j = 1.0f;
    float k = 0.1f;
    float l = 4.0f;
    float m = 0.6f;
    float n = 0.35f;
    float o = 0.25f;
    ka p = new ka(0.8f, 0.8f, 0.8f, this.m);
    ka q = new ka(0.4f, 0.4f, 0.4f, this.n);
    float r = 0.0f;
    float s = 0.0f;
    float t = 0.0f;
    float u = 0.0f;
    float v = 0.0f;
    float w = 0.0f;
    float x = 4.0f;

    public void a(float f) {
        this.e = f;
    }

    public void b(float f) {
        this.j = f;
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
        io.g.glLineWidth(2.0f);
        h();
        e();
    }

    public void e() {
        if (ThemeWatcher.getInstance().isNight()) {
            g();
        } else {
            f();
        }
    }

    private void h() {
        i();
        j();
        k();
    }

    private void i() {
        if (ThemeWatcher.getInstance().isNight()) {
            this.m = 0.6f;
            this.n = 0.45f;
        } else {
            this.m = 0.81f;
            this.n = 0.18f;
        }
        this.p = new ka(0.8f, 0.8f, 0.8f, this.m);
        this.q = new ka(0.4f, 0.4f, 0.4f, this.n);
    }

    private void j() {
        Log.i("NetRoadEntity", "createNetModelPointLine");
        long currentTimeMillis = System.currentTimeMillis();
        float f = this.f;
        float f2 = (-(this.h / 2.0f)) * f;
        float f3 = (-(this.g / 2.0f)) * f;
        kx kxVar = new kx();
        le leVar = new le(770, 771);
        leVar.f = this.o;
        kxVar.a(leVar);
        float f4 = ThemeWatcher.getInstance().isNight() ? 1.0f : 0.1f;
        kxVar.a(lf.b(f4, f4, f4, 1.0f));
        nj njVar = new nj();
        njVar.a();
        ni a = njVar.a("road", 1, 11L, kxVar);
        int i = 0;
        while (true) {
            float f5 = i;
            if (f5 >= this.g) {
                break;
            }
            int i2 = 0;
            while (true) {
                float f6 = i2;
                if (f6 < this.h - 1.0f) {
                    float f7 = this.f;
                    float f8 = f2 + (f6 * f7);
                    float f9 = f3 + (f7 * f5);
                    float f10 = f8 + this.k;
                    a.a(f8, 0.0f, f9, f10, 0.0f, f9);
                    float f11 = this.k;
                    float f12 = this.l;
                    float f13 = f10 + (f11 * f12);
                    float f14 = this.f;
                    a.a(f13, 0.0f, f3 + (f5 * f14), (f13 + f14) - (f11 * ((f12 * 2.0f) + 1.0f)), 0.0f, f9);
                    i2++;
                }
            }
            i++;
        }
        int i3 = 0;
        while (true) {
            float f15 = i3;
            if (f15 >= this.h) {
                this.b = njVar.b();
                this.a = new la(this.b);
                Log.i("NetRoadEntity", "cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            int i4 = 0;
            while (true) {
                float f16 = i4;
                if (f16 < this.g - 1.0f) {
                    float f17 = this.f;
                    float f18 = f2 + (f17 * f15);
                    float f19 = (f16 * f17) + f3;
                    float f20 = f18 + this.k;
                    a.a(f18, 0.0f, f19, f20, 0.0f, f19);
                    float f21 = f18 + ((f20 - f18) / 2.0f);
                    float f22 = this.k;
                    float f23 = this.l;
                    float f24 = f19 + (f22 * f23);
                    a.a(f21, 0.0f, f24, f21, 0.0f, (f24 + this.f) - (f22 * ((f23 * 2.0f) + 1.0f)));
                    i4++;
                }
            }
            i3++;
        }
    }

    private void k() {
        float f = this.f;
        float f2 = this.g;
        float f3 = (f2 - 1.0f) * f;
        float f4 = (-(this.h / 2.0f)) * f;
        float f5 = (-(f2 / 2.0f)) * f;
        kx kxVar = new kx();
        le leVar = new le(770, 771);
        leVar.f = this.o;
        kxVar.a(leVar);
        float f6 = ThemeWatcher.getInstance().isNight() ? 1.0f : 0.1f;
        kxVar.a(lf.b(f6, f6, f6, 1.0f));
        nj njVar = new nj();
        njVar.a();
        ni a = njVar.a("road", 1, 11L, kxVar);
        int i = 0;
        while (true) {
            float f7 = i;
            if (f7 >= this.g - 1.0f) {
                break;
            }
            int i2 = 0;
            while (true) {
                float f8 = i2;
                if (f8 < this.h - 1.0f) {
                    float f9 = this.f;
                    float f10 = f4 + (f8 * f9);
                    float f11 = ((f9 * f7) + f5) - f3;
                    float f12 = f10 + this.k;
                    a.a(f10, 0.0f, f11, f12, 0.0f, f11);
                    float f13 = this.k;
                    float f14 = this.l;
                    float f15 = f12 + (f13 * f14);
                    a.a(f15, 0.0f, f11, (this.f + f15) - (f13 * ((f14 * 2.0f) + 1.0f)), 0.0f, f11);
                    i2++;
                }
            }
            i++;
        }
        int i3 = 0;
        while (true) {
            float f16 = i3;
            if (f16 >= this.h) {
                this.d = njVar.b();
                this.c = new la(this.d);
                return;
            }
            int i4 = 0;
            while (true) {
                float f17 = i4;
                if (f17 < this.g - 1.0f) {
                    float f18 = this.f;
                    float f19 = f4 + (f18 * f16);
                    float f20 = ((f17 * f18) + f5) - f3;
                    float f21 = f19 + this.k;
                    a.a(f19, 0.0f, f20, f21, 0.0f, f20);
                    float f22 = f19 + ((f21 - f19) / 2.0f);
                    float f23 = this.k;
                    float f24 = this.l;
                    float f25 = f20 + (f23 * f24);
                    a.a(f22, 0.0f, f25, f22, 0.0f, (f25 + this.f) - (f23 * ((f24 * 2.0f) + 1.0f)));
                    i4++;
                }
            }
            i3++;
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if ((C() instanceof h) && ((h) C()).P() == 0) {
            return;
        }
        float a = g.a(ui.class);
        float f = this.f * this.g;
        this.u += io.b.getDeltaTime();
        float f2 = this.u;
        this.v = this.e * f2 * this.j;
        this.w = this.x * f2;
        if (Math.abs(this.v) > f) {
            this.u = 0.0f;
        }
        if (this.j < 0.0f) {
            this.v += f;
        }
        la laVar = this.a;
        if (laVar != null) {
            laVar.f.c();
            this.a.f.e(0.0f, 0.0f, this.v);
            if (kwVar != null) {
                kzVar.a(this.a, kwVar);
            } else {
                kzVar.a(this.a);
            }
        }
        la laVar2 = this.c;
        if (laVar2 != null) {
            laVar2.f.c();
            this.c.f.e(0.0f, a, this.v);
            if (kwVar != null) {
                kzVar.a(this.c, kwVar);
            } else {
                kzVar.a(this.c);
            }
        }
    }

    public void a(up upVar) {
        this.u = 0.0f;
        this.v = 0.0f;
    }

    public void c(float f) {
        if (f > 0.0f && f < 2.5f) {
            f = 1.5f;
        } else if (f >= 2.5f && f < 5.0f) {
            f = 4.0f;
        } else if (f >= 5.0f && f < 7.5f) {
            f = 6.5f;
        } else if (f >= 7.5f && f < 10.0f) {
            f = 9.0f;
        } else if (f >= 10.0f && f < 12.5f) {
            f = 11.5f;
        } else if (f >= 12.5f && f < 15.0f) {
            f = 14.0f;
        } else if (f >= 15.0f && f < 17.5f) {
            f = 16.5f;
        } else if (f >= 17.5f && f < 20.0f) {
            f = 19.0f;
        } else if (f > 20.0f && f < 24.0f) {
            f = 22.5f;
        }
        if (f >= 24.0f) {
            f = 24.0f;
        }
        a(1.4054755f * ((f * 1000.0f) / 3600.0f));
    }

    public void a(int i) {
        Log.i("NetRoadEntity", "onGearChange:\t" + i);
        if (i == 3) {
            b(-1.0f);
        }
        if (i == 1) {
            b(1.0f);
        }
        if (i == 4) {
            b(0.0f);
        }
    }

    public void f() {
        Log.i("NetRoadEntity", "updateDayMaterial");
        lf a = lf.a(new ka(0.7921569f, 0.84705883f, 0.85490197f, 1.0f));
        le leVar = new le(770, 771);
        leVar.f = 0.7f;
        kx a2 = this.a.b.a(0);
        a2.c();
        a2.a(a);
        a2.a(leVar);
        kx a3 = this.c.b.a(0);
        a3.c();
        a3.a(a);
        a3.a(leVar);
    }

    public void g() {
        Log.i("NetRoadEntity", "updateNightMaterial");
        lf a = lf.a(new ka(0.4f, 0.4f, 0.4f, 1.0f));
        le leVar = new le(770, 771);
        leVar.f = 0.055f;
        kx a2 = this.a.b.a(0);
        a2.c();
        a2.a(a);
        a2.a(leVar);
        kx a3 = this.c.b.a(0);
        a3.c();
        a3.a(a);
        a3.a(leVar);
    }

    public void a(kz kzVar, kw kwVar, int i, up upVar) {
        a(kzVar, kwVar);
    }
}
