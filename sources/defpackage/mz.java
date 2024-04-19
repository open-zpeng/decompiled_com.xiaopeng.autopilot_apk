package defpackage;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.z;
/* compiled from: AnimationController.java */
/* renamed from: mz  reason: default package */
/* loaded from: classes.dex */
public class mz extends na {
    protected final z<a> a;
    public a b;
    public a c;
    public float d;
    public a e;
    public float f;
    public float g;
    public boolean h;
    public boolean i;
    public boolean j;
    private boolean l;

    /* compiled from: AnimationController.java */
    /* renamed from: mz$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);

        void b(a aVar);
    }

    /* compiled from: AnimationController.java */
    /* renamed from: mz$a */
    /* loaded from: classes.dex */
    public static class a {
        public b a;
        public lx b;
        public float c;
        public float d;
        public float e;
        public float f;
        public int g;

        protected a() {
        }

        protected float a(float f) {
            int i;
            b bVar;
            if (this.g == 0 || this.b == null) {
                return f;
            }
            float f2 = this.c * f;
            if (h.f(this.f)) {
                i = 1;
            } else {
                this.d += f2;
                i = (int) Math.abs(this.d / this.f);
                if (this.d < 0.0f) {
                    i++;
                    while (true) {
                        float f3 = this.d;
                        if (f3 >= 0.0f) {
                            break;
                        }
                        this.d = f3 + this.f;
                    }
                }
                this.d = Math.abs(this.d % this.f);
            }
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = this.g;
                if (i3 > 0) {
                    this.g = i3 - 1;
                }
                if (this.g != 0 && (bVar = this.a) != null) {
                    bVar.b(this);
                }
                if (this.g == 0) {
                    float f4 = this.f;
                    int i4 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    float f5 = (((i - 1) - i2) * f4) + (i4 < 0 ? f4 - this.d : this.d);
                    this.d = i4 >= 0 ? this.f : 0.0f;
                    b bVar2 = this.a;
                    if (bVar2 != null) {
                        bVar2.a(this);
                    }
                    return f5;
                }
            }
            return 0.0f;
        }
    }

    public mz(la laVar) {
        super(laVar);
        this.a = new z<a>() { // from class: mz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.badlogic.gdx.utils.z
            /* renamed from: a */
            public a newObject() {
                return new a();
            }
        };
        this.l = false;
    }

    private a a(lx lxVar, float f, float f2, int i, float f3, b bVar) {
        if (lxVar == null) {
            return null;
        }
        a obtain = this.a.obtain();
        obtain.b = lxVar;
        obtain.a = bVar;
        obtain.g = i;
        obtain.c = f3;
        obtain.e = f;
        if (f2 < 0.0f) {
            f2 = lxVar.b - f;
        }
        obtain.f = f2;
        obtain.d = f3 < 0.0f ? obtain.f : 0.0f;
        return obtain;
    }

    private a b(String str, float f, float f2, int i, float f3, b bVar) {
        if (str == null) {
            return null;
        }
        lx a2 = this.k.a(str);
        if (a2 == null) {
            throw new k("Unknown animation: " + str);
        }
        return a(a2, f, f2, i, f3, bVar);
    }

    private a b(a aVar) {
        return a(aVar.b, aVar.e, aVar.f, aVar.g, aVar.c, aVar.a);
    }

    public void a(float f) {
        a aVar;
        if (this.i) {
            return;
        }
        a aVar2 = this.e;
        if (aVar2 != null) {
            float f2 = this.f + f;
            this.f = f2;
            if (f2 >= this.g) {
                a(aVar2.b);
                this.l = true;
                this.a.free(this.e);
                this.e = null;
            }
        }
        if (this.l) {
            this.k.a();
            this.l = false;
        }
        a aVar3 = this.b;
        if (aVar3 == null || aVar3.g == 0 || this.b.b == null) {
            return;
        }
        float a2 = this.b.a(f);
        if (a2 != 0.0f && (aVar = this.c) != null) {
            this.h = false;
            a(aVar, this.d);
            this.c = null;
            a(a2);
            return;
        }
        a aVar4 = this.e;
        if (aVar4 != null) {
            a(aVar4.b, this.e.e + this.e.d, this.b.b, this.b.e + this.b.d, this.f / this.g);
        } else {
            a(this.b.b, this.b.e + this.b.d);
        }
    }

    public a a(String str) {
        return a(str, 1, 1.0f, null);
    }

    public a a(String str, int i, float f, b bVar) {
        return a(str, 0.0f, -1.0f, i, f, bVar);
    }

    public a a(String str, float f, float f2, int i, float f3, b bVar) {
        return a(b(str, f, f2, i, f3, bVar));
    }

    protected a a(a aVar) {
        a aVar2 = this.b;
        if (aVar2 == null) {
            this.b = aVar;
        } else {
            if (!this.j && aVar != null && aVar2.b == aVar.b) {
                aVar.d = this.b.d;
            } else {
                a(this.b.b);
            }
            this.a.free(this.b);
            this.b = aVar;
        }
        this.l = true;
        return aVar;
    }

    protected a a(a aVar, float f) {
        a aVar2 = this.b;
        if (aVar2 == null) {
            this.b = aVar;
        } else if (this.h) {
            b(aVar, f);
        } else if (!this.j && aVar != null && aVar2.b == aVar.b) {
            aVar.d = this.b.d;
            this.a.free(this.b);
            this.b = aVar;
        } else {
            a aVar3 = this.e;
            if (aVar3 != null) {
                a(aVar3.b);
                this.a.free(this.e);
            }
            this.e = this.b;
            this.b = aVar;
            this.f = 0.0f;
            this.g = f;
        }
        return aVar;
    }

    protected a b(a aVar, float f) {
        a aVar2 = this.b;
        if (aVar2 == null || aVar2.g == 0) {
            a(aVar, f);
        } else {
            a aVar3 = this.c;
            if (aVar3 != null) {
                this.a.free(aVar3);
            }
            this.c = aVar;
            this.d = f;
            if (this.b.g < 0) {
                this.b.g = 1;
            }
        }
        return aVar;
    }

    public a a(String str, int i, float f, b bVar, float f2) {
        return a(str, 0.0f, -1.0f, i, f, bVar, f2);
    }

    public a a(String str, float f, float f2, int i, float f3, b bVar, float f4) {
        return c(b(str, f, f2, i, f3, bVar), f4);
    }

    protected a c(a aVar, float f) {
        if (aVar.g < 0) {
            throw new k("An action cannot be continuous");
        }
        a aVar2 = this.b;
        if (aVar2 == null || aVar2.g == 0) {
            a(aVar, f);
        } else {
            a b2 = this.h ? null : b(this.b);
            this.h = false;
            a(aVar, f);
            this.h = true;
            if (b2 != null) {
                b(b2, f);
            }
        }
        return aVar;
    }
}
