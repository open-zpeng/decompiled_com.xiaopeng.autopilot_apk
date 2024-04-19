package com.xiaopeng.autopilot.parking.view.g3d;

import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.ao;
import com.badlogic.gdx.utils.ap;
/* compiled from: ParkingGestureDetector.java */
/* loaded from: classes.dex */
public class j extends ir {
    static final c H = new c();
    final b F;
    boolean G;
    o I;
    private float a;
    private float b;
    private long c;
    private float d;
    private long e;
    private boolean f;
    private int g;
    private long h;
    private float i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private float o;
    private float p;
    private long q;
    private final o r;
    private final o s;
    private final o t;
    private final ap.a u;

    /* compiled from: ParkingGestureDetector.java */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2, float f3, float f4) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2, int i) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(float f, float f2, int i, int i2) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean a(o oVar, o oVar2, o oVar3, o oVar4) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean b(float f, float f2) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean b(float f, float f2, int i, int i2) {
            return false;
        }

        @Override // com.xiaopeng.autopilot.parking.view.g3d.j.b
        public boolean c(float f, float f2, int i, int i2) {
            return false;
        }
    }

    /* compiled from: ParkingGestureDetector.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        boolean a(float f, float f2);

        boolean a(float f, float f2, float f3, float f4);

        boolean a(float f, float f2, int i);

        boolean a(float f, float f2, int i, int i2);

        boolean a(o oVar, o oVar2, o oVar3, o oVar4);

        boolean b(float f, float f2);

        boolean b(float f, float f2, int i, int i2);

        boolean c(float f, float f2, int i, int i2);
    }

    public j(b bVar) {
        this(20.0f, 0.4f, 1.1f, 0.15f, bVar);
    }

    public j(float f, float f2, float f3, float f4, b bVar) {
        this(f, f, f2, f3, f4, bVar);
    }

    public j(float f, float f2, float f3, float f4, float f5, b bVar) {
        this.I = new o();
        this.r = new o();
        this.s = new o();
        this.t = new o();
        this.u = new ap.a() { // from class: com.xiaopeng.autopilot.parking.view.g3d.j.1
            @Override // com.badlogic.gdx.utils.ap.a, java.lang.Runnable
            public void run() {
                if (j.this.G) {
                    return;
                }
                j jVar = j.this;
                jVar.G = jVar.F.a(j.this.I.d, j.this.I.e);
            }
        };
        this.a = f;
        this.b = f2;
        this.c = f3 * 1.0E9f;
        this.d = f4;
        this.e = f5 * 1.0E9f;
        this.F = bVar;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, i4);
    }

    public boolean a(float f, float f2, int i, int i2) {
        if (i > 1) {
            return false;
        }
        if (i == 0) {
            this.I.a(f, f2);
            this.q = io.d.getCurrentEventTime();
            H.a(f, f2, this.q);
            if (io.d.isTouched(1)) {
                this.f = false;
                this.m = true;
                this.s.a(this.I);
                this.t.a(this.r);
                this.u.a();
            } else {
                this.f = true;
                this.m = false;
                this.G = false;
                this.o = f;
                this.p = f2;
                if (!this.u.b()) {
                    ap.b(this.u, this.d);
                }
            }
        } else {
            this.r.a(f, f2);
            this.f = false;
            this.m = true;
            this.s.a(this.I);
            this.t.a(this.r);
            this.u.a();
        }
        return this.F.a(f, f2, i, i2);
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3) {
        return c(i, i2, i3);
    }

    public boolean c(float f, float f2, int i) {
        if (i <= 1 && !this.G) {
            if (i == 0) {
                this.I.a(f, f2);
            } else {
                this.r.a(f, f2);
            }
            if (this.m) {
                b bVar = this.F;
                if (bVar != null) {
                    return this.F.b(this.s.b(this.t), this.I.b(this.r)) || bVar.a(this.s, this.t, this.I, this.r);
                }
                return false;
            }
            H.b(f, f2, io.d.getCurrentEventTime());
            if (this.f && !a(f, f2, this.o, this.p)) {
                this.u.a();
                this.f = false;
            }
            if (this.f) {
                return false;
            }
            this.n = true;
            return this.F.a(f, f2, H.d, H.e);
        }
        return false;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        return b(i, i2, i3, i4);
    }

    public boolean b(float f, float f2, int i, int i2) {
        if (i > 1) {
            return false;
        }
        if (this.f && !a(f, f2, this.o, this.p)) {
            this.f = false;
        }
        boolean z = this.n;
        this.n = false;
        this.u.a();
        if (this.G) {
            return false;
        }
        if (this.f) {
            if (this.k != i2 || this.l != i || ao.a() - this.h > this.c || !a(f, f2, this.i, this.j)) {
                this.g = 0;
            }
            this.g++;
            this.h = ao.a();
            this.i = f;
            this.j = f2;
            this.k = i2;
            this.l = i;
            this.q = 0L;
            return this.F.b(f, f2, this.g, i2);
        } else if (this.m) {
            this.m = false;
            this.F.a();
            this.n = true;
            if (i == 0) {
                H.a(this.r.d, this.r.e, io.d.getCurrentEventTime());
            } else {
                H.a(this.I.d, this.I.e, io.d.getCurrentEventTime());
            }
            return false;
        } else {
            boolean c2 = (!z || this.n) ? false : this.F.c(f, f2, i, i2);
            this.q = 0L;
            long currentEventTime = io.d.getCurrentEventTime();
            if (currentEventTime - H.f < this.e) {
                H.b(f, f2, currentEventTime);
                return this.F.a(H.a(), H.b(), i2) || c2;
            }
            return c2;
        }
    }

    private boolean a(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3) < this.a && Math.abs(f2 - f4) < this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParkingGestureDetector.java */
    /* loaded from: classes.dex */
    public static class c {
        int a = 10;
        float b;
        float c;
        float d;
        float e;
        long f;
        int g;
        float[] h;
        float[] i;
        long[] j;

        c() {
            int i = this.a;
            this.h = new float[i];
            this.i = new float[i];
            this.j = new long[i];
        }

        public void a(float f, float f2, long j) {
            this.b = f;
            this.c = f2;
            this.d = 0.0f;
            this.e = 0.0f;
            this.g = 0;
            for (int i = 0; i < this.a; i++) {
                this.h[i] = 0.0f;
                this.i[i] = 0.0f;
                this.j[i] = 0;
            }
            this.f = j;
        }

        public void b(float f, float f2, long j) {
            this.d = f - this.b;
            this.e = f2 - this.c;
            this.b = f;
            this.c = f2;
            long j2 = j - this.f;
            this.f = j;
            int i = this.g;
            int i2 = i % this.a;
            this.h[i2] = this.d;
            this.i[i2] = this.e;
            this.j[i2] = j2;
            this.g = i + 1;
        }

        public float a() {
            float a = a(this.h, this.g);
            float a2 = ((float) a(this.j, this.g)) / 1.0E9f;
            if (a2 == 0.0f) {
                return 0.0f;
            }
            return a / a2;
        }

        public float b() {
            float a = a(this.i, this.g);
            float a2 = ((float) a(this.j, this.g)) / 1.0E9f;
            if (a2 == 0.0f) {
                return 0.0f;
            }
            return a / a2;
        }

        private float a(float[] fArr, int i) {
            int min = Math.min(this.a, i);
            float f = 0.0f;
            for (int i2 = 0; i2 < min; i2++) {
                f += fArr[i2];
            }
            return f / min;
        }

        private long a(long[] jArr, int i) {
            int min = Math.min(this.a, i);
            long j = 0;
            for (int i2 = 0; i2 < min; i2++) {
                j += jArr[i2];
            }
            if (min == 0) {
                return 0L;
            }
            return j / min;
        }
    }
}
