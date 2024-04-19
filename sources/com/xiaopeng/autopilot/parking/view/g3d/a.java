package com.xiaopeng.autopilot.parking.view.g3d;

import android.content.Context;
import android.util.Log;
import com.badlogic.gdx.backends.android.AdapterViewApplication;
/* compiled from: AbsParking3DScene.java */
/* loaded from: classes.dex */
public abstract class a extends ach implements com.xiaopeng.autopilot.parking.view.f {
    protected Context h;
    protected tj j;
    protected tn k;
    protected AdapterViewApplication m;
    protected long n;
    protected int c = 0;
    protected String[] d = {"Top", "Find", "Animation", "WebP", "Test"};
    protected float e = 0.0f;
    protected float f = 0.0f;
    protected long g = 0;
    protected int i = 7;
    protected int l = 0;
    protected boolean o = false;
    protected int p = 0;

    public void Q() {
    }

    public void R() {
    }

    public int S() {
        return 0;
    }

    @Override // defpackage.ach
    protected void a(kz kzVar, com.badlogic.gdx.utils.a<la> aVar) {
    }

    public void a(tv tvVar) {
    }

    @Override // com.xiaopeng.autopilot.parking.view.f
    public void a_(int i) {
    }

    public void b(float f) {
    }

    public void e(int i) {
    }

    public void g(int i) {
    }

    public void h(int i) {
    }

    public void j(boolean z) {
    }

    public void k(boolean z) {
    }

    @Override // defpackage.ach
    protected void y() {
    }

    public boolean L() {
        return this.o;
    }

    public void i(boolean z) {
        this.o = z;
    }

    public void a(AdapterViewApplication adapterViewApplication) {
        this.m = adapterViewApplication;
    }

    public tj M() {
        return this.j;
    }

    public tn N() {
        return this.k;
    }

    public int O() {
        return this.l;
    }

    public void f(int i) {
        this.c = i;
    }

    public int P() {
        return this.c;
    }

    public void d(int i) {
        Log.i("3DSence", "onSurfaceDrawTypeChange " + i);
        f(i);
    }

    @Override // defpackage.ach, defpackage.acg, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        return super.a(i, i2, i3, i4);
    }
}
