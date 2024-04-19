package com.xiaopeng.autopilot.parking.view.g3d;

import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.parking.view.g3d.b;
import com.xiaopeng.autopilot.parking.view.g3d.j;
import defpackage.acc;
import defpackage.acf;
/* compiled from: ParkingCameraInputController.java */
/* loaded from: classes.dex */
public class i extends j {
    private static final Interpolator al = new DecelerateInterpolator() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.7
        private float a = 0.54f;

        @Override // android.view.animation.DecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.a;
            if (f2 == 1.0f) {
                float f3 = 1.0f - f;
                return 1.0f - (f3 * f3);
            }
            return (float) (1.0d - Math.pow(1.0f - f, f2 * 2.0f));
        }
    };
    protected int A;
    p B;
    p C;
    p D;
    protected final a E;
    private float J;
    private float K;
    private double L;
    private boolean M;
    private h N;
    private acf O;
    private acf P;
    private acf Q;
    private float R;
    private float S;
    private final p T;
    private final p U;
    private boolean V;
    private boolean W;
    private float X;
    private float Y;
    private float Z;
    public int a;
    private float aa;
    private boolean ab;
    private boolean ac;
    private long ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private Runnable ai;
    private int aj;
    private boolean ak;
    public float b;
    public float c;
    public float d;
    public int e;
    public float f;
    public int g;
    public int h;
    protected boolean i;
    public boolean j;
    public float k;
    public float l;
    public boolean m;
    public p n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    protected boolean s;
    public int t;
    protected boolean u;
    public int v;
    protected boolean w;
    public int x;
    protected boolean y;
    public jz z;

    public void a(boolean z) {
        this.ag = z;
    }

    /* compiled from: ParkingCameraInputController.java */
    /* loaded from: classes.dex */
    protected static class a extends j.a {
        public i a;
        private float b;

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2, float f3, float f4) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(o oVar, o oVar2, o oVar3, o oVar4) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean b(float f, float f2, int i, int i2) {
            return false;
        }

        protected a() {
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2, int i, int i2) {
            this.b = 0.0f;
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2, int i) {
            return this.a.b(f, f2, i);
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.a, com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean b(float f, float f2) {
            float f3 = f2 - f;
            float f4 = f3 - this.b;
            this.b = f3;
            float width = io.b.getWidth();
            float height = io.b.getHeight();
            i iVar = this.a;
            if (width > height) {
                width = height;
            }
            return iVar.b(f4 / width);
        }
    }

    protected i(a aVar, jz jzVar) {
        super(aVar);
        this.a = 0;
        this.b = 80.0f;
        this.c = 240.0f;
        this.d = 240.0f;
        this.e = 1;
        this.f = 10.0f;
        this.g = 2;
        this.h = 0;
        this.j = true;
        this.k = -0.1f;
        this.l = 18.0f;
        this.m = true;
        this.n = new p();
        this.o = true;
        this.p = true;
        this.q = false;
        this.r = 51;
        this.t = 47;
        this.v = 29;
        this.x = 32;
        this.A = -1;
        this.T = new p();
        this.U = new p();
        this.V = false;
        this.W = false;
        this.X = 0.0f;
        this.Y = 0.0f;
        this.Z = 0.0f;
        this.aa = 0.0f;
        this.ab = false;
        this.B = null;
        this.C = null;
        this.D = null;
        this.ac = false;
        this.ad = 0L;
        this.ae = false;
        this.af = true;
        this.ag = false;
        this.ah = false;
        this.ai = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingCameraInputController", "postBackground-Runnable mTapUpRunnable");
                if (i.this.ab) {
                    i.this.b(true);
                }
            }
        };
        this.E = aVar;
        this.E.a = this;
        this.z = jzVar;
    }

    public i(h hVar, jz jzVar) {
        this(new a(), jzVar);
        this.N = hVar;
    }

    public void b(boolean z) {
        Log.i("ParkingCameraInputController", "breakRotateAndZoom.mSumRotateX = " + this.X + ",mParking3DView.mDrawType = " + this.N.P() + "," + this.N.O() + ",canMove = " + z);
        rh.a().g(this.ai);
        d(this.N.P());
        if (this.N.P() == 1 || this.N.P() == -10) {
            this.z.a(this.n, p.e, -this.X);
            Log.i("ParkingCameraInputController", "breakRotateAndZoom.mParkingBOut = " + this.ag);
            if (this.ag) {
                this.z.a.b(b.o.a, 1.0f);
                this.z.b.b(b.o.b, 1.0f);
            }
            if (this.N.P() == 1) {
                this.z.c.b(b.m.c, 1.0f);
            }
            if (this.m) {
                this.z.a();
            }
            this.X = 0.0f;
            this.ab = false;
            Log.i("ParkingCameraInputController", "breakRotateAndZoom.camera = " + this.z.a + ", " + this.z.b + "," + this.z.c);
            return;
        }
        this.af = z;
        if (this.C == null || this.B == null) {
            return;
        }
        acf acfVar = this.P;
        if (acfVar != null && acfVar.h()) {
            this.P.b();
        }
        acf acfVar2 = this.Q;
        if (acfVar2 != null && acfVar2.h()) {
            this.Q.b();
        }
        this.P = acf.b(0.0f, 1.0f);
        this.P.a(3000L);
        this.P.a(new acf.b() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.2
            @Override // defpackage.acf.b
            public void a(acf acfVar3) {
                float e = ((ace) acfVar3).e();
                i.this.z.a.b(i.this.B, e);
                i.this.z.b.b(i.this.C, e);
                i.this.z.c.b(i.this.D, e);
                if (i.this.m) {
                    i.this.z.a();
                }
                if (com.xiaopeng.autopilot.base.d.c()) {
                    Log.i("ParkingCameraInputController", "breakRotateAndZoom.alpha = " + e + ",mSumRotateX = " + i.this.X + "," + i.this.z.a + "," + i.this.z.b + "," + i.this.z.c);
                }
            }
        });
        this.P.a(new acc.a() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.3
            @Override // defpackage.acc.a
            public void d(acc accVar) {
            }

            @Override // defpackage.acc.a
            public void a(acc accVar) {
                i.this.ac = false;
                i.this.L = 0.0d;
            }

            @Override // defpackage.acc.a
            public void b(acc accVar) {
                Log.i("ParkingCameraInputController", "breakRotateAndZoom.onAnimationEnd.mAnimationCancel = " + i.this.ac);
                if (!i.this.ac) {
                    i.this.X = 0.0f;
                    i.this.ab = false;
                    i.this.ae = false;
                    i.this.af = true;
                    if (i.this.N.c == 2) {
                        float d = i.this.N.P.a.d(b.m.a);
                        Log.i("ParkingCameraInputController", "breakRotateAndZoom.onAnimationEnd.TYPE_FRAME_SUPER_PARK_SEARCHING.distance = " + d);
                        if (d != 0.0f) {
                            i.this.N.j.s();
                        }
                    }
                }
                Log.i("ParkingCameraInputController", "breakRotateAndZoom.onAnimationEnd.camera = " + i.this.z.a + ", " + i.this.z.b + ", " + i.this.z.c);
            }

            @Override // defpackage.acc.a
            public void c(acc accVar) {
                Log.i("ParkingCameraInputController", "breakRotateAndZoom.onAnimationCancel");
                i.this.ac = true;
            }
        });
        this.P.a();
    }

    public void a() {
        Log.i("ParkingCameraInputController", "breakVectorAnim.mAnimatorVector = " + this.P);
        acf acfVar = this.P;
        if (acfVar != null && acfVar.h()) {
            Log.i("ParkingCameraInputController", "breakVectorAnim.mAnimatorVector.cancel");
            this.P.b();
        }
        this.X = 0.0f;
        this.ab = false;
        this.ae = false;
        this.af = true;
        rh.a().g(this.ai);
    }

    public void b() {
        if (this.w || this.y || this.s || this.u) {
            float deltaTime = io.b.getDeltaTime();
            if (this.w) {
                jz jzVar = this.z;
                jzVar.a(jzVar.c, (-deltaTime) * this.b);
            }
            if (this.y) {
                jz jzVar2 = this.z;
                jzVar2.a(jzVar2.c, this.b * deltaTime);
            }
            if (this.s) {
                jz jzVar3 = this.z;
                jzVar3.b(this.T.a(jzVar3.b).a(this.f * deltaTime));
                if (this.p) {
                    this.n.b(this.T);
                }
            }
            if (this.u) {
                jz jzVar4 = this.z;
                jzVar4.b(this.T.a(jzVar4.b).a((-deltaTime) * this.f));
                if (this.p) {
                    this.n.b(this.T);
                }
            }
            if (this.m) {
                this.z.a();
            }
        }
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.j, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        Log.i("ParkingCameraInputController", "touchDown.button = " + i4 + ",mHasZoomRotate = " + this.ab);
        this.aj = this.aj | (1 << i3);
        this.ak = com.badlogic.gdx.math.h.c(this.aj) ^ true;
        if (i()) {
            this.ab = false;
            return super.a(i, i2, i3, i4) || this.h == 0 || this.i;
        }
        Log.i("ParkingCameraInputController", "touchDown.multiTouch = " + this.ak + ",touched = " + this.aj + ",pointer = " + i3 + ",mCanMove = " + this.af);
        if (this.ak) {
            this.A = -1;
        } else if (this.A < 0 && (this.h == 0 || this.i)) {
            this.R = i;
            this.S = i2;
            this.A = i4;
            acf acfVar = this.P;
            if (acfVar != null && acfVar.h() && this.af) {
                this.P.b();
            }
            rh.a().g(this.ai);
            acf acfVar2 = this.O;
            if (acfVar2 != null && acfVar2.h() && this.af) {
                this.O.b();
            }
            if (System.currentTimeMillis() - this.ad <= 500 && this.ab && this.af) {
                b(true);
            }
            this.ad = System.currentTimeMillis();
        }
        return super.a(i, i2, i3, i4) || this.h == 0 || this.i;
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.j, defpackage.ir, defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        Log.i("ParkingCameraInputController", "touchUp.mHasZoomRotate = " + this.ab + ",pointer = " + i3 + "," + this.W);
        this.aj = this.aj & ((1 << i3) ^ (-1));
        this.ak = com.badlogic.gdx.math.h.c(this.aj) ^ true;
        StringBuilder sb = new StringBuilder();
        sb.append("touchUp.multiTouch = ");
        sb.append(this.ak);
        Log.i("ParkingCameraInputController", sb.toString());
        if (i4 == this.A) {
            this.A = -1;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.ad;
        Log.i("ParkingCameraInputController", "touchUp.time = " + currentTimeMillis);
        if (i3 == 0) {
            this.ah = false;
        }
        if (!this.ab && currentTimeMillis < 1000) {
            this.N.d(i, i2);
        } else if (this.ab) {
            rh.a().g(this.ai);
            rh.a().c(this.ai, 10000L);
        }
        if (i() || i3 != 0) {
            return super.b(i, i2, i3, i4) || this.i;
        } else if (this.V) {
            this.V = false;
            float d = d();
            float e = e();
            float f = e / d;
            Log.i("ParkingCameraInputController", "touchUp.camera.originDistance = " + d + ",distance = " + e + ",amount = " + f);
            if (e > 1.1f * d) {
                jz jzVar = this.z;
                jzVar.b(this.T.a(jzVar.b).a(f));
            } else if (e < d * 0.4896f) {
                jz jzVar2 = this.z;
                jzVar2.b(this.T.a(jzVar2.b).a(-f));
            }
            if (this.m) {
                this.z.a();
            }
            return super.b(i, i2, i3, i4) || this.i;
        } else if (!this.W || c() >= 32.0d) {
            return super.b(i, i2, i3, i4) || this.i;
        } else {
            acf acfVar = this.Q;
            if (acfVar != null && acfVar.h()) {
                this.Q.b();
            }
            this.W = false;
            final float c = (float) (32.0d - c());
            Log.i("ParkingCameraInputController", "touchUp.rotate.sumBackRotate = " + c + "," + c() + "," + (32.0d - c()));
            this.Q = acf.b(0.0f, 1.0f);
            this.Q.a(1000L);
            this.Q.a(new acf.b() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.4
                @Override // defpackage.acf.b
                public void a(acf acfVar2) {
                    float e2 = (c - i.this.Z) * ((ace) acfVar2).e();
                    i.this.Z += e2;
                    i.this.z.a(i.this.n, i.this.h(), -e2);
                    if (i.this.m) {
                        i.this.z.a();
                    }
                    Log.i("ParkingCameraInputController", "touchUp.mAnimatorBackRotate.onAnimationUpdate.degree = " + i.this.c() + ",rotate = " + e2);
                }
            });
            this.Q.a(new acc.a() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.5
                @Override // defpackage.acc.a
                public void a(acc accVar) {
                }

                @Override // defpackage.acc.a
                public void d(acc accVar) {
                }

                @Override // defpackage.acc.a
                public void b(acc accVar) {
                    i.this.Z = 0.0f;
                    Log.i("ParkingCameraInputController", "touchUp.mAnimatorBackRotate.onAnimationEnd.mIsRotate = " + i.this.W);
                }

                @Override // defpackage.acc.a
                public void c(acc accVar) {
                    Log.i("ParkingCameraInputController", "touchUp.mAnimatorBackRotate.onAnimationCancel.mIsRotate = " + i.this.W);
                }
            });
            float a2 = H.a();
            float b = H.b();
            Log.i("ParkingCameraInputController", "touchUp.velocityY = " + b + "," + a2);
            if (Math.abs(a2) < 1000.0f && Math.abs(b) < 500.0f) {
                this.Q.a();
            }
            return super.b(i, i2, i3, i4) || this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p h() {
        return this.T.d();
    }

    private boolean i() {
        Log.i("ParkingCameraInputController", "canNotMoveOrZoom.mParking3DView = " + this.N + ",mCanMove = " + this.af);
        h hVar = this.N;
        if (hVar == null) {
            return false;
        }
        int P = hVar.P();
        if (P < 0) {
            return true;
        }
        boolean booleanValue = ((i.am) com.xiaopeng.autopilot.base.i.a(i.am.class)).d().booleanValue();
        Log.i("ParkingCameraInputController", "canNotMoveOrZoom.type = " + P + "," + this.N.H() + "," + this.N.j.q() + "," + booleanValue);
        return P == 0 || P == 6 || P == 9 || this.N.H() || P == 7 || P == 8 || this.N.j.q() || P == -4 || P == -16 || P == -15 || P == -5 || P == -6 || P == -14 || P == -7 || P == -8 || P == -2;
    }

    protected boolean a(float f, float f2, int i) {
        Log.i("ParkingCameraInputController", "process.button= " + i + ",deltaX = " + f + ",deltaY = " + f2 + ",camera = " + this.z.a + "," + this.z.b + "," + i());
        if (i()) {
            this.ab = false;
            return true;
        }
        if (i == this.a) {
            this.T.a(this.z.b).g(this.z.c).b = 0.0f;
            float f3 = this.b * f2;
            double c = c();
            Log.i("ParkingCameraInputController", "process.degree= " + c + ",mLastDeltaY = " + this.J + ",rotateY= " + f3 + ",mLastDegrees = " + this.L);
            if (Math.abs(f2) > 0.005f || this.ah) {
                if (!this.ah) {
                    this.ah = true;
                }
                j();
                this.ab = true;
                this.ad = 0L;
                int i2 = (c > 90.0d ? 1 : (c == 90.0d ? 0 : -1));
                if (i2 <= 0 && c >= 32.0d) {
                    if (this.J < 0.0f && f3 < 0.0f && c <= this.L) {
                        this.M = true;
                        c(f);
                        if (this.m) {
                            this.z.a();
                        }
                        return true;
                    }
                    this.M = false;
                    d(f3);
                    this.J = f2;
                    this.L = c;
                } else if (this.J * f3 < 0.0f && i2 <= 0 && c >= 27.0d) {
                    d(f3);
                } else if (c < 32.0d && c >= 27.0d) {
                    float a2 = H.a();
                    float b = H.b();
                    Log.i("ParkingCameraInputController", "process.velocityY = " + b + "," + a2);
                    if (Math.abs(a2) < 1000.0f && Math.abs(b) < 500.0f) {
                        this.Y += f3;
                        this.W = true;
                        this.z.a(this.n, h(), f3);
                        Log.i("ParkingCameraInputController", "process.mSumBackRotate = " + this.Y + "," + this.z.a + "," + this.z.b);
                    }
                }
            }
            if (Math.abs(f) > 0.005f || this.ah) {
                if (!this.ah) {
                    this.ah = true;
                }
                j();
                this.ab = true;
                this.ad = 0L;
                c(f);
            }
        } else if (i == this.e) {
            jz jzVar = this.z;
            jzVar.b(this.T.a(jzVar.b).g(this.z.c).d().a((-f) * this.f));
            jz jzVar2 = this.z;
            jzVar2.b(this.U.a(jzVar2.c).a((-f2) * this.f));
            if (this.o) {
                this.n.b(this.T).b(this.U);
            }
        } else if (i == this.g) {
            jz jzVar3 = this.z;
            jzVar3.b(this.T.a(jzVar3.b).a(f2 * this.f));
            if (this.p) {
                this.n.b(this.T);
            }
        }
        if (this.m) {
            this.z.a();
        }
        return true;
    }

    private void c(float f) {
        float f2 = (-this.b) * f;
        this.X += f2;
        Log.i("ParkingCameraInputController", "process.rotateX.rotateX= " + f2 + ",deltaX = " + f + ",mLastDeltaX = " + this.K + ",mSumRotateX = " + this.X);
        this.z.a(this.n, p.e, f2);
        this.K = f;
    }

    private void d(float f) {
        p h = h();
        Log.i("ParkingCameraInputController", "process.rotateY.rotateY= " + f + ",target = " + this.n + ",tmpV1Nor = " + h);
        this.z.a(this.n, h, f);
    }

    private void j() {
        Log.i("ParkingCameraInputController", "process.zoomMin.hasZoomMin = " + this.ae);
        if (!this.ae && this.N.P() == 2) {
            if (e() <= d() * 1.1f) {
                jz jzVar = this.z;
                jzVar.b(this.T.a(jzVar.b).a(-6.0f));
                if (this.m) {
                    this.z.a();
                }
                this.ae = true;
            }
        }
    }

    public double c() {
        double degrees = Math.toDegrees(Math.asin(a(new p(0.0f, -1.0f, 0.0f))));
        Log.i("ParkingCameraInputController", "getDegree.degree = " + degrees);
        return degrees;
    }

    private double a(p pVar) {
        p d = this.z.b.a().d();
        p d2 = pVar.d();
        p g = d.a().g(d2.a());
        double f = d.f(d2) / (d.b() * d2.b());
        Log.i("ParkingCameraInputController", "getRad.rad = " + f + "," + g.c);
        return f;
    }

    public float d() {
        return b.n.a.d(b.n.c);
    }

    public float e() {
        uf ufVar;
        h hVar = this.N;
        p h = (hVar == null || (ufVar = hVar.r) == null) ? null : ufVar.h();
        Log.i("ParkingCameraInputController", "getDistance.center = " + h);
        return this.z.a.d(h);
    }

    @Override // com.xiaopeng.autopilot.parking.view.g3d.j, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3) {
        boolean a2 = super.a(i, i2, i3);
        Log.i("ParkingCameraInputController", "touchDragged.result = " + a2 + ",button = " + this.A);
        rh.a().g(this.ai);
        if (a2 || this.A < 0) {
            return a2;
        }
        float f = i;
        float f2 = i2;
        this.R = f;
        this.S = f2;
        return a((f - this.R) / io.b.getWidth(), (this.S - f2) / io.b.getHeight(), this.A);
    }

    @Override // defpackage.ir, defpackage.it
    public boolean c(int i) {
        Log.i("ParkingCameraInputController", "scrolled.amount = " + i);
        return a(i * this.k * this.f);
    }

    public boolean a(float f) {
        Log.i("ParkingCameraInputController", "zoom.canNotMoveOrZoom = " + i() + ",mHasMove = " + this.ah);
        if (i()) {
            this.ab = false;
            return true;
        } else if (this.ah) {
            return false;
        } else {
            if (this.j || this.h == 0 || this.i) {
                float e = e();
                float d = d();
                float f2 = 0.4396f * d;
                Log.i("ParkingCameraInputController", "zoom.distance = " + e + "," + d + "," + f2 + "," + f + "," + this.z.a);
                if (e >= f2 && f > 0.0f) {
                    this.V = true;
                    this.ab = true;
                    this.ad = 0L;
                    boolean z = e >= d * 0.4896f;
                    Log.i("ParkingCameraInputController", "zoom.isMax = " + z);
                    if (z) {
                        jz jzVar = this.z;
                        jzVar.b(this.T.a(jzVar.b).a(f));
                    } else {
                        jz jzVar2 = this.z;
                        jzVar2.b(this.T.a(jzVar2.b).a(0.1f));
                    }
                    Log.i("ParkingCameraInputController", "zoom.camera = " + this.z.a + "," + this.z.b);
                } else if (e <= d * 1.15f && f < 0.0f) {
                    this.V = true;
                    this.ab = true;
                    this.ad = 0L;
                    jz jzVar3 = this.z;
                    jzVar3.b(this.T.a(jzVar3.b).a(f));
                }
                if (this.q) {
                    this.n.b(this.T);
                }
                if (this.m) {
                    this.z.a();
                }
                return true;
            }
            return false;
        }
    }

    protected boolean b(float f) {
        Log.i("ParkingCameraInputController", "pinchZoom.amount = " + f);
        return a(this.l * f);
    }

    protected boolean b(float f, float f2, int i) {
        Log.i("ParkingCameraInputController", "fling.velocityX = " + f + ",velocityY = " + f2 + ",mMoreMaxRotateY = " + this.M + ",mIsZoom = " + this.V);
        if (this.M || this.V || i()) {
            return false;
        }
        if (Math.abs(f) >= 1000.0f || Math.abs(f2) >= 500.0f) {
            if (Math.abs(f) > 1000.0f) {
                acf acfVar = this.O;
                if (acfVar != null && acfVar.h()) {
                    this.O.b();
                }
                this.O = acf.b(f, 0.0f);
                this.O.a(al);
                this.O.a(500L);
                this.O.a(new acf.b() { // from class: com.xiaopeng.autopilot.parking.view.g3d.i.6
                    @Override // defpackage.acf.b
                    public void a(acf acfVar2) {
                        float e = ((ace) acfVar2).e() / 200000.0f;
                        float f3 = (-i.this.c) * e;
                        Log.i("ParkingCameraInputController", "mAnimatorX.onAnimationUpdate.rotateX= " + f3 + ",deltaX = " + e);
                        i iVar = i.this;
                        iVar.X = iVar.X + f3;
                        i.this.z.a(i.this.n, p.e, f3);
                        if (i.this.m) {
                            i.this.z.a();
                        }
                    }
                });
                this.O.a();
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i) {
        Log.i("ParkingCameraInputController", "keyDown");
        if (i == this.h) {
            this.i = true;
        }
        if (i == this.r) {
            this.s = true;
            return false;
        } else if (i == this.t) {
            this.u = true;
            return false;
        } else if (i == this.v) {
            this.w = true;
            return false;
        } else if (i == this.x) {
            this.y = true;
            return false;
        } else {
            return false;
        }
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i) {
        if (i == this.h) {
            this.i = false;
            this.A = -1;
        }
        if (i == this.r) {
            this.s = false;
        } else if (i == this.t) {
            this.u = false;
        } else if (i == this.v) {
            this.w = false;
        } else if (i == this.x) {
            this.y = false;
        }
        return false;
    }

    public boolean f() {
        return this.ab;
    }

    public void g() {
        Log.i("ParkingCameraInputController", "detachFromWindow.mHasZoomRotate = " + this.ab + ",camera = " + this.B + "," + this.C + "," + this.D);
        acf acfVar = this.P;
        if (acfVar != null && acfVar.h()) {
            this.P.b();
        }
        acf acfVar2 = this.Q;
        if (acfVar2 != null && acfVar2.h()) {
            this.Q.b();
        }
        if (this.ab) {
            rh.a().g(this.ai);
            int P = this.N.P();
            d(P);
            Log.i("ParkingCameraInputController", "detachFromWindow.drawType = " + P + ",camera = " + this.B + "," + this.C + "," + this.D);
            if (this.B != null) {
                this.z.a.b(this.B, 1.0f);
            }
            if (this.C != null) {
                this.z.b.b(this.C, 1.0f);
            }
            this.z.c.b(this.D, 1.0f);
            if (this.m) {
                this.z.a();
            }
            this.X = 0.0f;
            this.ab = false;
            this.ae = false;
            this.af = true;
            this.ag = false;
        }
    }

    private void d(int i) {
        Log.i("ParkingCameraInputController", "setVector3.drawType = " + i);
        this.D = b.m.c;
        this.B = null;
        this.C = null;
        if (i == 9) {
            this.B = b.k.a;
            this.C = b.m.b;
        } else if (i == 3 || i == -3) {
            this.B = b.n.a;
            this.C = b.n.b;
        } else if (i == 2) {
            this.B = b.m.a;
            this.C = b.m.b;
        } else if (i == 4) {
            this.B = b.o.a;
            this.C = b.o.b;
        } else if (i == 7 || i == 8 || i == 10 || i == 6) {
            this.B = new p(0.0f, 23.039999f, 0.0f);
            this.C = b.j.b;
        } else if (i == -1) {
            this.B = b.a.a;
            this.C = b.a.b;
        } else if (i == -2) {
            if (!((i.am) com.xiaopeng.autopilot.base.i.a(i.am.class)).d().booleanValue()) {
                this.B = null;
                this.C = null;
                return;
            }
            boolean booleanValue = ((i.an) com.xiaopeng.autopilot.base.i.a(i.an.class)).d().booleanValue();
            Log.i("ParkingCameraInputController", "setVector3.trainingCameraStateBool = " + booleanValue);
            if (booleanValue) {
                this.B = b.n.a;
                this.C = b.n.b;
                return;
            }
            this.B = b.p.a;
            this.C = b.p.b;
            this.D = b.p.c;
        } else if (i == -9) {
            this.B = b.n.a;
            this.C = b.n.b;
        } else if (i == -11) {
            this.B = b.n.a;
            this.C = b.n.b;
        } else if (i == -12) {
            this.B = b.a.a;
            this.C = b.a.b;
        } else if (i == -13) {
            this.B = b.n.a;
            this.C = b.n.b;
        }
    }
}
