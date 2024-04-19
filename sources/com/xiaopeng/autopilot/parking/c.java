package com.xiaopeng.autopilot.parking;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingAPPageRemoveEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingPageEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.ParkingViewContainer;
import com.xiaopeng.autopilot.parking.view.ParkingViewPro;
import com.xiaopeng.autopilot.parking.view.g;
import com.xiaopeng.autopilot.parking.view.g3d.h;
import com.xiaopeng.autopilot.parking.view.k;
import com.xiaopeng.sr.bean.ApMapBean;
/* compiled from: LisenceUtil.java */
/* loaded from: classes.dex */
public class c {
    private static ParkingViewPro a;
    private static tw b;
    private static TrainingAPPageView c;
    private static ApInfoFlowReadyView d;
    private static ViewGroup e;
    private static h f;
    private static ts g;

    public static View a(ViewGroup viewGroup) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            return LayoutInflater.from(com.xiaopeng.autopilot.base.a.g()).inflate(e.f.layout_window_main_xpilot3, viewGroup, true);
        }
        return LayoutInflater.from(com.xiaopeng.autopilot.base.a.g()).inflate(e.f.layout_window_main, viewGroup, true);
    }

    public static g b(ViewGroup viewGroup) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            a = (ParkingViewPro) viewGroup.findViewById(e.C0055e.parking_pro_view);
            return a;
        }
        return (g) viewGroup.findViewById(e.C0055e.parking_2d_container);
    }

    public static tr a(tv tvVar) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            abg.a().a(com.xiaopeng.autopilot.base.a.g().getApplicationContext());
            g = new ts();
            g.a(((tw) tvVar).s());
            return g;
        }
        return new tr();
    }

    public static h a() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            f = new k(com.xiaopeng.autopilot.base.a.g());
            return f;
        }
        f = new h(com.xiaopeng.autopilot.base.a.g());
        return f;
    }

    public static tn a(ParkingViewContainer parkingViewContainer) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            b = new tw(parkingViewContainer, a);
            return b;
        }
        return new tv(parkingViewContainer);
    }

    public static void a(com.xiaopeng.autopilot.base.e eVar) {
        ParkingViewPro parkingViewPro;
        if (!com.xiaopeng.autopilot.base.d.n() || (parkingViewPro = a) == null) {
            return;
        }
        parkingViewPro.a(eVar);
    }

    public static void c(ViewGroup viewGroup) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            e = viewGroup;
            c = (TrainingAPPageView) viewGroup.findViewById(e.C0055e.training_ap_page_view);
        }
    }

    public static void d(ViewGroup viewGroup) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            d = (ApInfoFlowReadyView) viewGroup.findViewById(e.C0055e.ap_ready_start_view);
        }
    }

    public static void b() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            int intValue = ((i.ai) i.a(i.ai.class)).d().intValue();
            if (intValue == 1 || intValue == 2) {
                i.a(i.ai.class, 0);
                if (((i.c) i.a(i.c.class)).d().intValue() == 2) {
                    if (intValue == 1) {
                        e();
                    } else {
                        x();
                    }
                    d.a(0);
                } else if (b.A() == 4) {
                    rh.a().a(new Runnable() { // from class: com.xiaopeng.autopilot.parking.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(3));
                        }
                    }, 500L);
                }
            }
            i.a(i.C0051i.class, false);
        }
    }

    public static uf a(ach achVar) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            return new com.xiaopeng.autopilot.parking.view.g3d.c(achVar, com.xiaopeng.autopilot.parking.view.g3d.c.a);
        }
        return new uf(achVar, uf.k);
    }

    public static void c() {
        a.q();
    }

    public static void d() {
        com.xiaopeng.autopilot.base.d.n();
    }

    public static void a(int i) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            abg.a().c(i);
        }
    }

    public static void e() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            a.u();
        }
    }

    private static void x() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            a.v();
        }
    }

    public static void f() {
        b.w();
    }

    public static void g() {
        b.G();
    }

    public static void h() {
        b.x();
    }

    public static void i() {
        b.y();
        g.y();
    }

    public static void j() {
        b.z();
    }

    public static int k() {
        return b.q();
    }

    public static int l() {
        return (int) b.t();
    }

    public static int m() {
        return (int) b.u();
    }

    public static int n() {
        return b.r();
    }

    public static boolean o() {
        return c.d();
    }

    public static boolean p() {
        return c.f();
    }

    public static void q() {
        int intValue = ((i.y) i.a(i.y.class)).d().intValue();
        Log.i("LisenceUtil", "removeTrainingAPView.page = " + intValue);
        if (intValue != 0) {
            f();
            org.greenrobot.eventbus.c.a().d(new TrainingAPPageRemoveEvent());
        }
    }

    public static void b(int i) {
        d.a(i);
    }

    public static void c(int i) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            a.s(i);
        }
    }

    public static void r() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            g.A().i();
        }
    }

    public static void d(int i) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            abg.a().d(i);
        }
    }

    public static void e(int i) {
        if (com.xiaopeng.autopilot.base.d.n()) {
            f.e(i);
        }
    }

    public static ApMapBean s() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            return b.s().getApMapBean();
        }
        return new ApMapBean();
    }

    public static void t() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            f.E.a();
            g.ap();
        }
    }

    public static void u() {
        if (com.xiaopeng.autopilot.base.d.n()) {
            f.E.a();
            g.aq();
        }
    }

    public static void a(int i, int i2, boolean z) {
        f.a(i, i2, z);
    }

    public static void v() {
        if (com.xiaopeng.autopilot.base.d.n() && ((i.aj) i.a(i.aj.class)).d().intValue() == 2) {
            b.r(0);
        }
    }

    public static void a(boolean z) {
        g.d(z);
    }

    public static View a(View view) {
        if (com.xiaopeng.autopilot.base.d.n() || view == null) {
            return null;
        }
        return view.findViewById(e.C0055e.slide_warning_layout);
    }

    public static boolean w() {
        ApInfoFlowReadyView apInfoFlowReadyView = d;
        return apInfoFlowReadyView != null && apInfoFlowReadyView.getVisibility() == 0;
    }
}
