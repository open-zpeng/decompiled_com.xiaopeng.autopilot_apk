package com.xiaopeng.autopilot.parking.model;

import com.badlogic.gdx.math.p;
/* loaded from: classes.dex */
public class CameraConfig {
    private p mCamDir;
    private p mCamLookAt;
    private p mCamPos;
    private p mCamUp;

    public void setmCamDir(p pVar) {
        this.mCamDir = pVar;
    }

    public void setmCamPos(p pVar) {
        this.mCamPos = pVar;
    }

    public p getmCamPos() {
        if (this.mCamPos == null) {
            this.mCamPos = new p();
        }
        return this.mCamPos;
    }

    public void setmCamLookAt(p pVar) {
        this.mCamLookAt = pVar;
    }

    public p getmCamDir() {
        return this.mCamDir;
    }

    public p getmCamLookAt() {
        return this.mCamLookAt;
    }

    public p getmCamUp() {
        return this.mCamUp;
    }

    public void initDefaultValue() {
        p pVar = new p(0.0f, -((float) Math.tan(0.25f)), -1.0f);
        p g = pVar.a().g(new p(-1.0f, 0.0f, 0.0f));
        p pVar2 = new p();
        pVar2.f();
        this.mCamPos = pVar2.a().c(pVar.a().a(40.0f));
        this.mCamDir = pVar;
        this.mCamLookAt = pVar2;
        this.mCamUp = g;
    }
}
