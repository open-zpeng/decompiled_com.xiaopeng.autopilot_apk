package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.math.p;
import defpackage.ny;
/* compiled from: CameraInputController.java */
/* renamed from: nc  reason: default package */
/* loaded from: classes.dex */
public class nc extends ny {
    private float D;
    private float E;
    private final p F;
    private final p G;
    private int H;
    private boolean I;
    public int a;
    public float b;
    public int c;
    public float d;
    public int e;
    public int f;
    protected boolean g;
    public boolean h;
    public float i;
    public float j;
    public boolean k;
    public p l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    protected boolean q;
    public int r;
    protected boolean s;
    public int t;
    protected boolean u;
    public int v;
    protected boolean w;
    public jz x;
    protected int y;
    protected final a z;

    /* compiled from: CameraInputController.java */
    /* renamed from: nc$a */
    /* loaded from: classes.dex */
    protected static class a extends ny.a {
        public nc a;
        private float b;

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean a(float f, float f2) {
            return false;
        }

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean a(float f, float f2, float f3, float f4) {
            return false;
        }

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean a(float f, float f2, int i) {
            return false;
        }

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean a(o oVar, o oVar2, o oVar3, o oVar4) {
            return false;
        }

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean b(float f, float f2, int i, int i2) {
            return false;
        }

        protected a() {
        }

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean a(float f, float f2, int i, int i2) {
            this.b = 0.0f;
            return false;
        }

        @Override // defpackage.ny.a, defpackage.ny.b
        public boolean b(float f, float f2) {
            float f3 = f2 - f;
            float f4 = f3 - this.b;
            this.b = f3;
            float width = io.b.getWidth();
            float height = io.b.getHeight();
            nc ncVar = this.a;
            if (width > height) {
                width = height;
            }
            return ncVar.b(f4 / width);
        }
    }

    protected nc(a aVar, jz jzVar) {
        super(aVar);
        this.a = 0;
        this.b = 360.0f;
        this.c = 1;
        this.d = 10.0f;
        this.e = 2;
        this.f = 0;
        this.h = true;
        this.i = -0.1f;
        this.j = 10.0f;
        this.k = true;
        this.l = new p();
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = 51;
        this.r = 47;
        this.t = 29;
        this.v = 32;
        this.y = -1;
        this.F = new p();
        this.G = new p();
        this.z = aVar;
        this.z.a = this;
        this.x = jzVar;
    }

    public nc(jz jzVar) {
        this(new a(), jzVar);
    }

    public void a() {
        if (this.u || this.w || this.q || this.s) {
            float deltaTime = io.b.getDeltaTime();
            if (this.u) {
                jz jzVar = this.x;
                jzVar.a(jzVar.c, (-deltaTime) * this.b);
            }
            if (this.w) {
                jz jzVar2 = this.x;
                jzVar2.a(jzVar2.c, this.b * deltaTime);
            }
            if (this.q) {
                jz jzVar3 = this.x;
                jzVar3.b(this.F.a(jzVar3.b).a(this.d * deltaTime));
                if (this.n) {
                    this.l.b(this.F);
                }
            }
            if (this.s) {
                jz jzVar4 = this.x;
                jzVar4.b(this.F.a(jzVar4.b).a((-deltaTime) * this.d));
                if (this.n) {
                    this.l.b(this.F);
                }
            }
            if (this.k) {
                this.x.a();
            }
        }
    }

    @Override // defpackage.ny, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        this.H |= 1 << i3;
        this.I = !h.c(this.H);
        if (this.I) {
            this.y = -1;
        } else if (this.y < 0 && (this.f == 0 || this.g)) {
            this.D = i;
            this.E = i2;
            this.y = i4;
        }
        return super.a(i, i2, i3, i4) || this.f == 0 || this.g;
    }

    @Override // defpackage.ny, defpackage.ir, defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        this.H &= (1 << i3) ^ (-1);
        this.I = !h.c(this.H);
        if (i4 == this.y) {
            this.y = -1;
        }
        return super.b(i, i2, i3, i4) || this.g;
    }

    protected boolean a(float f, float f2, int i) {
        if (i == this.a) {
            this.F.a(this.x.b).g(this.x.c).b = 0.0f;
            this.x.a(this.l, this.F.d(), f2 * this.b);
            this.x.a(this.l, p.e, f * (-this.b));
        } else if (i == this.c) {
            jz jzVar = this.x;
            jzVar.b(this.F.a(jzVar.b).g(this.x.c).d().a((-f) * this.d));
            jz jzVar2 = this.x;
            jzVar2.b(this.G.a(jzVar2.c).a((-f2) * this.d));
            if (this.m) {
                this.l.b(this.F).b(this.G);
            }
        } else if (i == this.e) {
            jz jzVar3 = this.x;
            jzVar3.b(this.F.a(jzVar3.b).a(f2 * this.d));
            if (this.n) {
                this.l.b(this.F);
            }
        }
        if (this.k) {
            this.x.a();
            return true;
        }
        return true;
    }

    @Override // defpackage.ny, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3) {
        boolean a2 = super.a(i, i2, i3);
        if (a2 || this.y < 0) {
            return a2;
        }
        float f = i;
        float f2 = i2;
        this.D = f;
        this.E = f2;
        return a((f - this.D) / io.b.getWidth(), (this.E - f2) / io.b.getHeight(), this.y);
    }

    @Override // defpackage.ir, defpackage.it
    public boolean c(int i) {
        return a(i * this.i * this.d);
    }

    public boolean a(float f) {
        if (this.h || this.f == 0 || this.g) {
            jz jzVar = this.x;
            jzVar.b(this.F.a(jzVar.b).a(f));
            if (this.o) {
                this.l.b(this.F);
            }
            if (this.k) {
                this.x.a();
                return true;
            }
            return true;
        }
        return false;
    }

    protected boolean b(float f) {
        return a(this.j * f);
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i) {
        if (i == this.f) {
            this.g = true;
        }
        if (i == this.p) {
            this.q = true;
            return false;
        } else if (i == this.r) {
            this.s = true;
            return false;
        } else if (i == this.t) {
            this.u = true;
            return false;
        } else if (i == this.v) {
            this.w = true;
            return false;
        } else {
            return false;
        }
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i) {
        if (i == this.f) {
            this.g = false;
            this.y = -1;
        }
        if (i == this.p) {
            this.q = false;
        } else if (i == this.r) {
            this.s = false;
        } else if (i == this.t) {
            this.u = false;
        } else if (i == this.v) {
            this.w = false;
        }
        return false;
    }
}
