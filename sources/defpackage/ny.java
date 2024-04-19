package defpackage;

import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.ao;
import com.badlogic.gdx.utils.ap;
/* compiled from: GestureDetector.java */
/* renamed from: ny  reason: default package */
/* loaded from: classes.dex */
public class ny extends ir {
    final b A;
    boolean B;
    o C;
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
    private final c o;
    private float p;
    private float q;
    private long r;
    private final o s;
    private final o t;
    private final o u;
    private final ap.a v;

    /* compiled from: GestureDetector.java */
    /* renamed from: ny$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // defpackage.ny.b
        public boolean a(float f, float f2) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean a(float f, float f2, float f3, float f4) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean a(float f, float f2, int i) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean a(float f, float f2, int i, int i2) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean a(o oVar, o oVar2, o oVar3, o oVar4) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean b(float f, float f2) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean b(float f, float f2, int i, int i2) {
            return false;
        }

        @Override // defpackage.ny.b
        public boolean c(float f, float f2, int i, int i2) {
            return false;
        }

        @Override // defpackage.ny.b
        public void r_() {
        }
    }

    /* compiled from: GestureDetector.java */
    /* renamed from: ny$b */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(float f, float f2);

        boolean a(float f, float f2, float f3, float f4);

        boolean a(float f, float f2, int i);

        boolean a(float f, float f2, int i, int i2);

        boolean a(o oVar, o oVar2, o oVar3, o oVar4);

        boolean b(float f, float f2);

        boolean b(float f, float f2, int i, int i2);

        boolean c(float f, float f2, int i, int i2);

        void r_();
    }

    public ny(b bVar) {
        this(20.0f, 0.4f, 1.1f, 0.15f, bVar);
    }

    public ny(float f, float f2, float f3, float f4, b bVar) {
        this(f, f, f2, f3, f4, bVar);
    }

    public ny(float f, float f2, float f3, float f4, float f5, b bVar) {
        this.o = new c();
        this.C = new o();
        this.s = new o();
        this.t = new o();
        this.u = new o();
        this.v = new ap.a() { // from class: ny.1
            @Override // com.badlogic.gdx.utils.ap.a, java.lang.Runnable
            public void run() {
                if (ny.this.B) {
                    return;
                }
                ny nyVar = ny.this;
                nyVar.B = nyVar.A.a(ny.this.C.d, ny.this.C.e);
            }
        };
        this.a = f;
        this.b = f2;
        this.c = f3 * 1.0E9f;
        this.d = f4;
        this.e = f5 * 1.0E9f;
        this.A = bVar;
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
            this.C.a(f, f2);
            this.r = io.d.getCurrentEventTime();
            this.o.a(f, f2, this.r);
            if (io.d.isTouched(1)) {
                this.f = false;
                this.m = true;
                this.t.a(this.C);
                this.u.a(this.s);
                this.v.a();
            } else {
                this.f = true;
                this.m = false;
                this.B = false;
                this.p = f;
                this.q = f2;
                if (!this.v.b()) {
                    ap.b(this.v, this.d);
                }
            }
        } else {
            this.s.a(f, f2);
            this.f = false;
            this.m = true;
            this.t.a(this.C);
            this.u.a(this.s);
            this.v.a();
        }
        return this.A.a(f, f2, i, i2);
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3) {
        return b(i, i2, i3);
    }

    public boolean b(float f, float f2, int i) {
        if (i <= 1 && !this.B) {
            if (i == 0) {
                this.C.a(f, f2);
            } else {
                this.s.a(f, f2);
            }
            if (this.m) {
                b bVar = this.A;
                if (bVar != null) {
                    return this.A.b(this.t.b(this.u), this.C.b(this.s)) || bVar.a(this.t, this.u, this.C, this.s);
                }
                return false;
            }
            this.o.b(f, f2, io.d.getCurrentEventTime());
            if (this.f && !a(f, f2, this.p, this.q)) {
                this.v.a();
                this.f = false;
            }
            if (this.f) {
                return false;
            }
            this.n = true;
            return this.A.a(f, f2, this.o.d, this.o.e);
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
        if (this.f && !a(f, f2, this.p, this.q)) {
            this.f = false;
        }
        boolean z = this.n;
        this.n = false;
        this.v.a();
        if (this.B) {
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
            this.r = 0L;
            return this.A.b(f, f2, this.g, i2);
        } else if (this.m) {
            this.m = false;
            this.A.r_();
            this.n = true;
            if (i == 0) {
                this.o.a(this.s.d, this.s.e, io.d.getCurrentEventTime());
            } else {
                this.o.a(this.C.d, this.C.e, io.d.getCurrentEventTime());
            }
            return false;
        } else {
            boolean c2 = (!z || this.n) ? false : this.A.c(f, f2, i, i2);
            this.r = 0L;
            long currentEventTime = io.d.getCurrentEventTime();
            if (currentEventTime - this.o.f < this.e) {
                this.o.b(f, f2, currentEventTime);
                return this.A.a(this.o.a(), this.o.b(), i2) || c2;
            }
            return c2;
        }
    }

    private boolean a(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3) < this.a && Math.abs(f2 - f4) < this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GestureDetector.java */
    /* renamed from: ny$c */
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
