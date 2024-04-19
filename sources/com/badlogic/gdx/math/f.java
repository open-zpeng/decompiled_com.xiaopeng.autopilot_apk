package com.badlogic.gdx.math;
/* compiled from: Interpolation.java */
/* loaded from: classes.dex */
public abstract class f {
    public static final f a = new f() { // from class: com.badlogic.gdx.math.f.1
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return f2;
        }
    };
    public static final f b = new f() { // from class: com.badlogic.gdx.math.f.7
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return f2 * f2 * (3.0f - (f2 * 2.0f));
        }
    };
    public static final f c = new f() { // from class: com.badlogic.gdx.math.f.8
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            float f3 = f2 * f2 * (3.0f - (f2 * 2.0f));
            return f3 * f3 * (3.0f - (f3 * 2.0f));
        }
    };
    public static final f d = new f() { // from class: com.badlogic.gdx.math.f.9
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return f2 * f2 * f2 * ((f2 * ((6.0f * f2) - 15.0f)) + 10.0f);
        }
    };
    public static final f e = d;
    public static final j f = new j(2);
    public static final k g = new k(2);
    public static final k h = g;
    public static final l i = new l(2);
    public static final l j = i;
    public static final f k = new f() { // from class: com.badlogic.gdx.math.f.10
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return (float) Math.sqrt(f2);
        }
    };
    public static final f l = new f() { // from class: com.badlogic.gdx.math.f.11
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return 1.0f - ((float) Math.sqrt(-(f2 - 1.0f)));
        }
    };
    public static final j m = new j(3);
    public static final k n = new k(3);
    public static final l o = new l(3);
    public static final f p = new f() { // from class: com.badlogic.gdx.math.f.12
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return (float) Math.cbrt(f2);
        }
    };
    public static final f q = new f() { // from class: com.badlogic.gdx.math.f.13
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return 1.0f - ((float) Math.cbrt(-(f2 - 1.0f)));
        }
    };
    public static final j r = new j(4);
    public static final k s = new k(4);
    public static final l t = new l(4);
    public static final j u = new j(5);
    public static final k v = new k(5);
    public static final l w = new l(5);
    public static final f x = new f() { // from class: com.badlogic.gdx.math.f.14
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return (1.0f - com.badlogic.gdx.math.h.b(f2 * 3.1415927f)) / 2.0f;
        }
    };
    public static final f y = new f() { // from class: com.badlogic.gdx.math.f.2
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return 1.0f - com.badlogic.gdx.math.h.b((f2 * 3.1415927f) / 2.0f);
        }
    };
    public static final f z = new f() { // from class: com.badlogic.gdx.math.f.3
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return com.badlogic.gdx.math.h.a((f2 * 3.1415927f) / 2.0f);
        }
    };
    public static final g A = new g(2.0f, 10.0f);
    public static final h B = new h(2.0f, 10.0f);
    public static final i C = new i(2.0f, 10.0f);
    public static final g D = new g(2.0f, 5.0f);
    public static final h E = new h(2.0f, 5.0f);
    public static final i F = new i(2.0f, 5.0f);
    public static final f G = new f() { // from class: com.badlogic.gdx.math.f.4
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            if (f2 <= 0.5f) {
                float f3 = f2 * 2.0f;
                return (1.0f - ((float) Math.sqrt(1.0f - (f3 * f3)))) / 2.0f;
            }
            float f4 = (f2 - 1.0f) * 2.0f;
            return (((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f) / 2.0f;
        }
    };
    public static final f H = new f() { // from class: com.badlogic.gdx.math.f.5
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            return 1.0f - ((float) Math.sqrt(1.0f - (f2 * f2)));
        }
    };
    public static final f I = new f() { // from class: com.badlogic.gdx.math.f.6
        @Override // com.badlogic.gdx.math.f
        public float a(float f2) {
            float f3 = f2 - 1.0f;
            return (float) Math.sqrt(1.0f - (f3 * f3));
        }
    };
    public static final d J = new d(2.0f, 10.0f, 7, 1.0f);
    public static final e K = new e(2.0f, 10.0f, 6, 1.0f);
    public static final C0047f L = new C0047f(2.0f, 10.0f, 7, 1.0f);
    public static final m M = new m(1.5f);
    public static final n N = new n(2.0f);
    public static final o O = new o(2.0f);
    public static final a P = new a(4);
    public static final b Q = new b(4);
    public static final c R = new c(4);

    public abstract float a(float f2);

    public float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * a(f4));
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class j extends f {
        final int S;

        public j(int i) {
            this.S = i;
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            if (f <= 0.5f) {
                return ((float) Math.pow(f * 2.0f, this.S)) / 2.0f;
            }
            return (((float) Math.pow((f - 1.0f) * 2.0f, this.S)) / (this.S % 2 == 0 ? -2 : 2)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class k extends j {
        public k(int i) {
            super(i);
        }

        @Override // com.badlogic.gdx.math.f.j, com.badlogic.gdx.math.f
        public float a(float f) {
            return (float) Math.pow(f, this.S);
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class l extends j {
        public l(int i) {
            super(i);
        }

        @Override // com.badlogic.gdx.math.f.j, com.badlogic.gdx.math.f
        public float a(float f) {
            return (((float) Math.pow(f - 1.0f, this.S)) * (this.S % 2 == 0 ? -1 : 1)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class g extends f {
        final float S;
        final float T;
        final float U;
        final float V;

        public g(float f, float f2) {
            this.S = f;
            this.T = f2;
            this.U = (float) Math.pow(f, -f2);
            this.V = 1.0f / (1.0f - this.U);
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            if (f <= 0.5f) {
                return ((((float) Math.pow(this.S, this.T * ((f * 2.0f) - 1.0f))) - this.U) * this.V) / 2.0f;
            }
            return (2.0f - ((((float) Math.pow(this.S, (-this.T) * ((f * 2.0f) - 1.0f))) - this.U) * this.V)) / 2.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class h extends g {
        public h(float f, float f2) {
            super(f, f2);
        }

        @Override // com.badlogic.gdx.math.f.g, com.badlogic.gdx.math.f
        public float a(float f) {
            return (((float) Math.pow(this.S, this.T * (f - 1.0f))) - this.U) * this.V;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class i extends g {
        public i(float f, float f2) {
            super(f, f2);
        }

        @Override // com.badlogic.gdx.math.f.g, com.badlogic.gdx.math.f
        public float a(float f) {
            return 1.0f - ((((float) Math.pow(this.S, (-this.T) * f)) - this.U) * this.V);
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class d extends f {
        final float S;
        final float T;
        final float U;
        final float V;

        public d(float f, float f2, int i, float f3) {
            this.S = f;
            this.T = f2;
            this.U = f3;
            this.V = i * 3.1415927f * (i % 2 == 0 ? 1 : -1);
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                return ((((float) Math.pow(this.S, this.T * (f2 - 1.0f))) * com.badlogic.gdx.math.h.a(f2 * this.V)) * this.U) / 2.0f;
            }
            float f3 = (1.0f - f) * 2.0f;
            return 1.0f - (((((float) Math.pow(this.S, this.T * (f3 - 1.0f))) * com.badlogic.gdx.math.h.a(f3 * this.V)) * this.U) / 2.0f);
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class e extends d {
        public e(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.badlogic.gdx.math.f.d, com.badlogic.gdx.math.f
        public float a(float f) {
            if (f >= 0.99d) {
                return 1.0f;
            }
            return ((float) Math.pow(this.S, this.T * (f - 1.0f))) * com.badlogic.gdx.math.h.a(f * this.V) * this.U;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.badlogic.gdx.math.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0047f extends d {
        public C0047f(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.badlogic.gdx.math.f.d, com.badlogic.gdx.math.f
        public float a(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            float f2 = 1.0f - f;
            return 1.0f - ((((float) Math.pow(this.S, this.T * (f2 - 1.0f))) * com.badlogic.gdx.math.h.a(f2 * this.V)) * this.U);
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class a extends c {
        public a(int i) {
            super(i);
        }

        private float b(float f) {
            float f2 = (this.S[0] / 2.0f) + f;
            return f2 < this.S[0] ? (f2 / (this.S[0] / 2.0f)) - 1.0f : super.a(f);
        }

        @Override // com.badlogic.gdx.math.f.c, com.badlogic.gdx.math.f
        public float a(float f) {
            if (f <= 0.5f) {
                return (1.0f - b(1.0f - (f * 2.0f))) / 2.0f;
            }
            return (b((f * 2.0f) - 1.0f) / 2.0f) + 0.5f;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class c extends f {
        final float[] S;
        final float[] T;

        public c(int i) {
            if (i < 2 || i > 5) {
                throw new IllegalArgumentException("bounces cannot be < 2 or > 5: " + i);
            }
            this.S = new float[i];
            this.T = new float[i];
            float[] fArr = this.T;
            fArr[0] = 1.0f;
            switch (i) {
                case 2:
                    float[] fArr2 = this.S;
                    fArr2[0] = 0.6f;
                    fArr2[1] = 0.4f;
                    fArr[1] = 0.33f;
                    break;
                case 3:
                    float[] fArr3 = this.S;
                    fArr3[0] = 0.4f;
                    fArr3[1] = 0.4f;
                    fArr3[2] = 0.2f;
                    fArr[1] = 0.33f;
                    fArr[2] = 0.1f;
                    break;
                case 4:
                    float[] fArr4 = this.S;
                    fArr4[0] = 0.34f;
                    fArr4[1] = 0.34f;
                    fArr4[2] = 0.2f;
                    fArr4[3] = 0.15f;
                    fArr[1] = 0.26f;
                    fArr[2] = 0.11f;
                    fArr[3] = 0.03f;
                    break;
                case 5:
                    float[] fArr5 = this.S;
                    fArr5[0] = 0.3f;
                    fArr5[1] = 0.3f;
                    fArr5[2] = 0.2f;
                    fArr5[3] = 0.1f;
                    fArr5[4] = 0.1f;
                    fArr[1] = 0.45f;
                    fArr[2] = 0.3f;
                    fArr[3] = 0.15f;
                    fArr[4] = 0.06f;
                    break;
            }
            float[] fArr6 = this.S;
            fArr6[0] = fArr6[0] * 2.0f;
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.S;
            int i = 0;
            float f2 = f + (fArr[0] / 2.0f);
            int length = fArr.length;
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (true) {
                if (i >= length) {
                    break;
                }
                f4 = this.S[i];
                if (f2 <= f4) {
                    f3 = this.T[i];
                    break;
                }
                f2 -= f4;
                i++;
            }
            float f5 = f2 / f4;
            float f6 = (4.0f / f4) * f3 * f5;
            return 1.0f - ((f6 - (f5 * f6)) * f4);
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class b extends c {
        public b(int i) {
            super(i);
        }

        @Override // com.badlogic.gdx.math.f.c, com.badlogic.gdx.math.f
        public float a(float f) {
            return 1.0f - super.a(1.0f - f);
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class m extends f {
        private final float S;

        public m(float f) {
            this.S = f * 2.0f;
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                float f3 = this.S;
                return ((f2 * f2) * (((1.0f + f3) * f2) - f3)) / 2.0f;
            }
            float f4 = (f - 1.0f) * 2.0f;
            float f5 = this.S;
            return (((f4 * f4) * (((f5 + 1.0f) * f4) + f5)) / 2.0f) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class o extends f {
        private final float S;

        public o(float f) {
            this.S = f;
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            float f2 = f - 1.0f;
            float f3 = this.S;
            return (f2 * f2 * (((f3 + 1.0f) * f2) + f3)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* loaded from: classes.dex */
    public static class n extends f {
        private final float S;

        public n(float f) {
            this.S = f;
        }

        @Override // com.badlogic.gdx.math.f
        public float a(float f) {
            float f2 = this.S;
            return f * f * (((1.0f + f2) * f) - f2);
        }
    }
}
