package defpackage;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* compiled from: InterpolatorFactory.java */
/* renamed from: acb  reason: default package */
/* loaded from: classes.dex */
public class acb {
    private static Interpolator a = new LinearInterpolator();
    private static Interpolator b = new c();
    private static Interpolator c = new Interpolator() { // from class: acb.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (((float) Math.sin(f2 * 6.2831855f)) * 0.5f) + 0.5f;
        }
    };
    private static Interpolator d = new Interpolator() { // from class: acb.4
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (((float) Math.sin((f2 + 0.5f) * 6.2831855f)) * 0.5f) + 0.5f;
        }
    };
    private static Interpolator e = new Interpolator() { // from class: acb.5
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = 1.0f - f2;
            return 1.0f - (f3 * f3);
        }
    };
    private static Interpolator f = new Interpolator() { // from class: acb.6
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            return f2 * f2;
        }
    };
    private static Interpolator g = new Interpolator() { // from class: acb.7
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3;
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                f3 = f4 * f4;
            } else {
                float f5 = 2.0f - f4;
                f3 = 2.0f - (f5 * f5);
            }
            return f3 * 0.5f;
        }
    };
    private static Interpolator h = new Interpolator() { // from class: acb.8
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = 1.0f - f2;
            return 1.0f - ((f3 * f3) * f3);
        }
    };
    private static Interpolator i = new Interpolator() { // from class: acb.9
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            return f2 * f2 * f2;
        }
    };
    private static Interpolator j = new Interpolator() { // from class: acb.10
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3;
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                f3 = f4 * f4 * f4;
            } else {
                float f5 = 2.0f - f4;
                f3 = 2.0f - ((f5 * f5) * f5);
            }
            return f3 * 0.5f;
        }
    };
    private static Interpolator k = new Interpolator() { // from class: acb.11
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = 1.0f - f2;
            float f4 = f3 * f3;
            return 1.0f - (f4 * f4);
        }
    };
    private static Interpolator l = new Interpolator() { // from class: acb.2
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = f2 * f2;
            return f3 * f3;
        }
    };
    private static Interpolator m = new Interpolator() { // from class: acb.3
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3;
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                float f5 = f4 * f4;
                f3 = f5 * f5;
            } else {
                float f6 = 2.0f - f4;
                float f7 = f6 * f6;
                f3 = 2.0f - (f7 * f7);
            }
            return f3 * 0.5f;
        }
    };
    private static Interpolator n = new a(0.25f, 0.25f);

    public static Interpolator a(int i2) {
        return a(i2, 0, null);
    }

    public static Interpolator a(int i2, int i3, float[] fArr) {
        switch (i2) {
            case 1:
                if (fArr != null && fArr.length > 0) {
                    return new b(i3, fArr[0]);
                }
                return new b(i3);
            case 2:
                return b;
            case 3:
                return c;
            case 4:
                return d;
            case 5:
                switch (i3) {
                    case 0:
                        return e;
                    case 1:
                        return f;
                    case 2:
                        return g;
                }
            case 6:
                switch (i3) {
                    case 0:
                        return h;
                    case 1:
                        return i;
                    case 2:
                        return j;
                }
            case 7:
                switch (i3) {
                    case 0:
                        return k;
                    case 1:
                        return l;
                    case 2:
                        return m;
                }
            case 8:
                switch (i3) {
                    case 0:
                        if (fArr == null) {
                            return n;
                        }
                        if (fArr.length >= 2) {
                            return new a(fArr[0], fArr[1]);
                        }
                        throw new RuntimeException("Elastic Interpolator only supports EaseOut now.");
                    case 1:
                    case 2:
                        throw new RuntimeException("Elastic Interpolator only supports EaseOut now.");
                }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InterpolatorFactory.java */
    /* renamed from: acb$b */
    /* loaded from: classes.dex */
    public static class b implements Interpolator {
        int a;
        float b;
        float c;

        public b(int i, float f) {
            this.a = 0;
            this.b = 10.0f;
            this.a = i;
            if (i == 0) {
                this.b = f;
                this.c = (1.0f / (1.0f - ((float) Math.pow(2.0d, -10.0d)))) - 1.0f;
            }
        }

        public b(int i) {
            this(i, 10.0f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            switch (this.a) {
                case 0:
                    float f2 = this.b;
                    return ((this.c * f) + 1.0f) * (1.0f - ((float) Math.pow(2.0d, (-(f2 + ((10.0f - f2) * f))) * f)));
                case 1:
                    float f3 = this.b;
                    return (float) Math.pow(2.0d, (f * f3) - f3);
                case 2:
                    float f4 = f * 2.0f;
                    if (f4 < 1.0f) {
                        float f5 = this.b;
                        return ((float) Math.pow(2.0d, (f4 * f5) - f5)) * 0.5f;
                    }
                    float f6 = this.b;
                    return 1.0f - (((float) Math.pow(2.0d, f6 - (f4 * f6))) * 0.5f);
                default:
                    return f;
            }
        }
    }

    /* compiled from: InterpolatorFactory.java */
    /* renamed from: acb$c */
    /* loaded from: classes.dex */
    private static class c implements Interpolator {
        static float a = 1.0f / a(1.0f);

        private c() {
        }

        public static float a(float f) {
            float exp;
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                exp = f2 - (1.0f - ((float) Math.exp(-f2)));
            } else {
                exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f);
            }
            return exp * a;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return a(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InterpolatorFactory.java */
    /* renamed from: acb$a */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        float a;
        float b;
        float c;

        public a(float f, float f2) {
            this.b = Math.max(0.0f, Math.min(f, 1.0f));
            this.a = Math.max(1.0f, f2 * ((float) Math.pow(2.0d, this.b * 10.0f * 0.5d)));
            this.c = ((float) Math.asin(1.0f / this.a)) / 6.2831855f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            return (float) ((Math.pow(2.0d, (-10.0f) * f) * this.a * Math.sin(((f / this.b) - this.c) * 6.2831855f)) + 1.0d);
        }
    }
}
