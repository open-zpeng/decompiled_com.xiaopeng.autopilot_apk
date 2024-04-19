package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.g3d.Parking3DViewGroup;
import com.xiaopeng.autopilot.radar.view.ReversingView;
/* loaded from: classes.dex */
public class ParkingViewContainer extends FrameLayout implements g {
    private g a;
    private Parking3DViewGroup b;
    private ReversingView c;
    private tn d;
    private boolean e;

    public ParkingViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = com.xiaopeng.autopilot.parking.c.b(this);
        this.b = (Parking3DViewGroup) findViewById(e.C0055e.view_auto_parking);
        this.b.getParking3DSence().a((com.xiaopeng.autopilot.parking.view.g3d.f) this.a);
        this.b.setXpilotClick(this.e);
        Log.d("ParkingViewContainer", "mParkingView: " + this.a);
        Log.d("ParkingViewContainer", "m3DContainer: " + this.b);
    }

    public void setReversingView(ReversingView reversingView) {
        this.c = reversingView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Log.d("ParkingViewContainer", "dispatchTouchEvent : " + motionEvent.getAction());
        return super.dispatchTouchEvent(motionEvent);
    }

    public void a() {
        Log.i("ParkingViewContainer", "startSurfaceDraw");
        a(!((i.w) com.xiaopeng.autopilot.base.i.a(i.w.class)).d().booleanValue() ? 0 : 8);
        this.b.a();
        this.b.getParking3DSence().a(this.c.getRadar3DSenceListener());
    }

    public void e() {
        this.b.b();
        this.a.b();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(tv tvVar) {
        this.d = tvVar;
        this.a.a(tvVar);
        this.b.a(tvVar);
        com.xiaopeng.autopilot.parking.c.a((com.xiaopeng.autopilot.base.e) this.b.getParking3DSence());
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(String str, int i) {
        this.a.a(str, i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(String str, int i, View.OnClickListener onClickListener, boolean z) {
        this.a.a(str, i, onClickListener, z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(int i, View.OnClickListener onClickListener) {
        this.a.a(i, onClickListener);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(int i) {
        this.a.a(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(boolean z) {
        this.a.a(z);
    }

    public void d(boolean z) {
        this.b.getParking3DSence().j(z);
    }

    public void e(boolean z) {
        this.b.getParking3DSence().k(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b(int i) {
        this.a.b(i);
        this.b.getParking3DSence().e(i);
    }

    @Deprecated
    public int getParkLotChoseIndex() {
        return this.b.getParking3DSence().S();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c(int i) {
        this.a.c(i);
        this.b.getParking3DSence().a_(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(float f) {
        this.a.a(f);
        this.b.getParking3DSence().b(f);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void d(int i) {
        this.a.d(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void e(int i) {
        this.a.e(i);
    }

    public void h(int i) {
        if (com.xiaopeng.autopilot.base.d.c() || !com.xiaopeng.autopilot.base.d.n()) {
            Log.i("ParkingViewContainer", "onSurfaceDrawTypeChange:" + i);
        }
        ReversingView reversingView = this.c;
        if (reversingView != null) {
            reversingView.setDrawType(i);
        }
        com.xiaopeng.autopilot.parking.c.c(i);
        if (i < 0) {
            this.b.getParking3DSence().d(i);
            return;
        }
        tn tnVar = this.d;
        if (tnVar != null && tnVar.e() == 6) {
            boolean booleanValue = ((i.h) com.xiaopeng.autopilot.base.i.a(i.h.class)).d().booleanValue();
            Log.i("ParkingViewContainer", "onSurfaceDrawTypeChange.hasFinishActive:" + booleanValue);
            if (booleanValue) {
                i(-6);
                return;
            } else {
                this.b.getParking3DSence().d(7);
                return;
            }
        }
        tn tnVar2 = this.d;
        if (tnVar2 != null && (tnVar2.e() == 24 || this.d.e() == 36)) {
            this.b.getParking3DSence().d(6);
            return;
        }
        tn tnVar3 = this.d;
        if (tnVar3 != null && tnVar3.e() == 11) {
            this.b.getParking3DSence().d(8);
            return;
        }
        tn tnVar4 = this.d;
        if (tnVar4 != null && (tnVar4.e() == 21 || this.d.e() == 18)) {
            this.b.getParking3DSence().d(9);
            return;
        }
        tn tnVar5 = this.d;
        if (tnVar5 != null && (tnVar5.e() == 7 || this.d.e() == 10 || this.d.e() == 5 || this.d.e() == 35)) {
            this.b.getParking3DSence().d(10);
        } else {
            this.b.getParking3DSence().d(i);
        }
    }

    public void i(int i) {
        Log.i("ParkingViewContainer", "onDrawTypeChange.type:" + i);
        com.xiaopeng.autopilot.parking.c.c(i);
        ReversingView reversingView = this.c;
        if (reversingView != null) {
            reversingView.setDrawType(i);
        }
        this.b.getParking3DSence().d(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b(boolean z) {
        this.a.b(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(float f, float f2) {
        this.a.a(f, f2);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void f(int i) {
        this.a.f(i);
        this.b.getParking3DSence().g(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void g(int i) {
        this.a.g(i);
        this.b.getParking3DSence().h(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void a(boolean z, int i) {
        this.a.a(z, i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void setProgressBarVisible(int i) {
        this.a.setProgressBarVisible(i);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void b() {
        this.a.b();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c() {
        this.a.c();
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void d() {
        this.a.d();
    }

    public void setXpilotClick(boolean z) {
        Parking3DViewGroup parking3DViewGroup = this.b;
        if (parking3DViewGroup != null) {
            parking3DViewGroup.setXpilotClick(z);
        }
        this.e = z;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void c(boolean z) {
        this.a.c(z);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g
    public void setSlideWarningView(View view) {
        this.a.setSlideWarningView(view);
    }
}
