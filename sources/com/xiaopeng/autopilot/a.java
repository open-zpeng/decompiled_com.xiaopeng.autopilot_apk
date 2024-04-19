package com.xiaopeng.autopilot;

import com.xiaopeng.autopilot.camera.view.CameraView;
import com.xiaopeng.autopilot.parking.d;
/* compiled from: AppManager.java */
/* loaded from: classes.dex */
public class a {
    private ri a;
    private com.xiaopeng.autopilot.view.a b;
    private d c;
    private vc d;
    private rn e;

    public a() {
        c();
    }

    private void c() {
        this.b = new com.xiaopeng.autopilot.view.a(com.xiaopeng.autopilot.base.a.g());
        this.c = new d();
        this.c.a(this.b.getParkingView());
        this.d = new vc();
        this.d.a(this.b.getReversingView());
        this.e = new rn();
        this.e.a(this.b.getCameraView());
    }

    public void a() {
        ((CameraView) this.b.getCameraView()).d();
        this.a = new com.xiaopeng.autopilot.view.b(com.xiaopeng.autopilot.base.a.g());
        this.a.a(this.b);
    }

    public void b() {
        ri riVar = this.a;
        if (riVar != null) {
            riVar.a();
            this.a = null;
        }
    }
}
