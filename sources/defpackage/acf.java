package defpackage;

import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import defpackage.acc;
import java.util.ArrayList;
/* compiled from: ValueAnimator.java */
/* renamed from: acf  reason: default package */
/* loaded from: classes.dex */
public abstract class acf extends acc {
    public static long c = -1;
    private static float u = 1.0f;
    long d;
    protected int p;
    protected int q;
    protected int r;
    protected float[] s;
    protected boolean t;
    private long z;
    public static a f = new a();
    private static final Interpolator v = new AccelerateDecelerateInterpolator();
    long e = -1;
    boolean g = false;
    int h = 0;
    private float w = 0.0f;
    private float x = 0.0f;
    private boolean y = false;
    int i = 0;
    private boolean A = false;
    boolean j = false;
    private boolean B = false;
    protected boolean k = false;
    long l = u * 300.0f;
    private long C = 300;
    long m = 0;
    private long D = 0;
    int n = 0;
    int o = 1;
    private Interpolator E = v;
    private ArrayList<b> F = null;
    private ArrayList<acc.a> G = null;

    /* compiled from: ValueAnimator.java */
    /* renamed from: acf$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(acf acfVar);
    }

    protected abstract void a(float f2, int i, int i2);

    public static ace b(float... fArr) {
        ace aceVar = new ace();
        aceVar.a(fArr);
        return aceVar;
    }

    void f() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.t = true;
    }

    public acf a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.C = j;
        this.l = ((float) j) * u;
        return this;
    }

    public void b(long j) {
        f();
        if (c == -1) {
            c = AnimationUtils.currentAnimationTimeMillis();
        }
        long j2 = c;
        if (this.i != 1) {
            this.e = j;
            this.i = 2;
        }
        this.d = j2 - j;
        e(j2);
    }

    /* compiled from: ValueAnimator.java */
    /* renamed from: acf$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        private final ArrayList<acf> a;
        private final ArrayList<acf> b;
        private final ArrayList<acf> c;
        private final ArrayList<acf> d;
        private final C0008a<acf> e;
        private final ArrayList<acf> f;
        private final ArrayList<acf> g;
        private boolean h;

        a b() {
            return this;
        }

        private a() {
            this.a = new ArrayList<>();
            this.b = new ArrayList<>();
            this.c = new ArrayList<>();
            this.d = new ArrayList<>();
            this.e = new C0008a<>();
            this.f = new ArrayList<>();
            this.g = new ArrayList<>();
        }

        public void a() {
            c();
        }

        private void a(long j) {
            int i;
            while (true) {
                i = 0;
                if (this.c.size() <= 0) {
                    break;
                }
                ArrayList<acf> arrayList = this.d;
                int size = this.c.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(this.c.get(i2));
                }
                this.c.clear();
                while (i < size) {
                    acf acfVar = arrayList.get(i);
                    if (acfVar != null) {
                        if (acfVar.m == 0) {
                            acfVar.b(this);
                        } else {
                            this.e.add(acfVar);
                        }
                    }
                    i++;
                }
                arrayList.clear();
            }
            int size2 = this.e.size();
            if (size2 > 0) {
                size2 = this.e.size();
            }
            int i3 = size2;
            int i4 = 0;
            while (i4 < i3) {
                acf acfVar2 = this.e.get(i4);
                if (acfVar2 != null && acfVar2.f(j)) {
                    try {
                        i3--;
                        int i5 = i4 - 1;
                        try {
                            this.e.set(i4, this.e.get(i3));
                            i4 = i5;
                        } catch (IndexOutOfBoundsException unused) {
                            i4 = i5;
                            Log.e("graphics animator", "index out exception ！");
                            acfVar2.b(this);
                            acfVar2.A = true;
                            i4++;
                        }
                    } catch (IndexOutOfBoundsException unused2) {
                    }
                    acfVar2.b(this);
                    acfVar2.A = true;
                }
                i4++;
            }
            C0008a<acf> c0008a = this.e;
            c0008a.removeRange(i3, c0008a.size());
            int size3 = this.g.size();
            if (size3 > 0) {
                for (int i6 = 0; i6 < size3; i6++) {
                    acf acfVar3 = this.g.get(i6);
                    acfVar3.b(this);
                    acfVar3.A = true;
                    this.e.remove(acfVar3);
                }
                this.g.clear();
            }
            int size4 = this.a.size();
            for (int i7 = 0; i7 < size4; i7++) {
                try {
                    this.b.add(this.a.get(i7));
                } catch (IndexOutOfBoundsException unused3) {
                    Log.e("ValueAnimator", "animcation IndexOutOfBoundsException \tindex:\t" + i7 + "\tsize:\t" + this.a.size());
                }
            }
            for (int i8 = 0; i8 < size4; i8++) {
                try {
                    acf acfVar4 = this.b.get(i8);
                    if (this.a.contains(acfVar4) && acfVar4.e(j)) {
                        this.f.add(acfVar4);
                    }
                } catch (IndexOutOfBoundsException unused4) {
                    Log.e("ValueAnimator", "animcation end IndexOutOfBoundsException \tindex: \tsize:\t" + this.a.size());
                }
            }
            this.b.clear();
            if (this.f.size() > 0) {
                while (i < this.f.size()) {
                    this.f.get(i).a(this);
                    i++;
                }
                this.f.clear();
            }
            if (this.a.isEmpty() && this.e.isEmpty()) {
                return;
            }
            c();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h) {
                this.h = false;
                a(acf.c);
            }
        }

        private void c() {
            if (this.h) {
                return;
            }
            this.h = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ValueAnimator.java */
        /* renamed from: acf$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0008a<E> extends ArrayList<E> {
            private C0008a() {
            }

            @Override // java.util.ArrayList, java.util.AbstractList
            public void removeRange(int i, int i2) {
                if (i >= size() || i2 >= size()) {
                    return;
                }
                super.removeRange(i, i2);
            }
        }
    }

    public void c(long j) {
        this.m = ((float) j) * u;
        this.D = j;
    }

    public void a(int i) {
        this.n = i;
    }

    public void b(int i) {
        this.o = i;
    }

    public void a(b bVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(bVar);
    }

    public void g() {
        ArrayList<b> arrayList = this.F;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.F = null;
    }

    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.E = interpolator;
        } else {
            this.E = new LinearInterpolator();
        }
    }

    private ArrayList<acc.a> e() {
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.G.add(this.a.get(i));
        }
        return this.G;
    }

    private void k() {
        if (this.a != null && !this.B) {
            ArrayList<acc.a> e = e();
            int size = e.size();
            for (int i = 0; i < size; i++) {
                e.get(i).a(this);
            }
            e.clear();
        }
        this.B = true;
    }

    void a(boolean z) {
        this.g = z;
        this.h = 0;
        this.i = 0;
        this.j = true;
        this.y = false;
        a l = l();
        l.c.add(this);
        if (this.m == 0) {
            b(0L);
            this.i = 0;
            this.A = true;
            k();
        }
        l.a();
    }

    @Override // defpackage.acc
    public void a() {
        a(false);
    }

    @Override // defpackage.acc
    public void b() {
        a l = l();
        if (this.i != 0 || l.c.contains(this) || l.e.contains(this)) {
            if ((this.j || this.A) && this.a != null) {
                if (!this.A) {
                    k();
                }
                ArrayList<acc.a> e = e();
                int size = e.size();
                for (int i = 0; i < size; i++) {
                    e.get(i).c(this);
                }
                e.clear();
            }
            a(l);
        }
    }

    public boolean h() {
        return this.i == 1 || this.A;
    }

    public void i() {
        this.g = !this.g;
        if (this.i == 1) {
            if (c == -1) {
                c = AnimationUtils.currentAnimationTimeMillis();
            }
            long j = c;
            this.d = j - (this.l - (j - this.d));
            return;
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        aVar.a.remove(this);
        aVar.c.remove(this);
        aVar.e.remove(this);
        this.i = 0;
        if ((this.j || this.A) && this.a != null) {
            if (!this.A) {
                k();
            }
            ArrayList<acc.a> e = e();
            int size = e.size();
            for (int i = 0; i < size; i++) {
                e.get(i).b(this);
            }
            e.clear();
        }
        this.A = false;
        this.j = false;
        this.B = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        f();
        if (c(this, aVar)) {
            aVar.a.add(this);
        }
        if (this.m <= 0 || this.a == null) {
            return;
        }
        k();
    }

    private boolean c(acf acfVar, a aVar) {
        return !aVar.a.contains(acfVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(long j) {
        if (!this.y) {
            this.y = true;
            this.z = j;
            return false;
        }
        long j2 = j - this.z;
        long j3 = this.m;
        if (j2 > j3) {
            this.d = j - (j2 - j3);
            this.i = 1;
            return true;
        }
        return false;
    }

    boolean d(long j) {
        boolean z = false;
        switch (this.i) {
            case 1:
            case 2:
                long j2 = this.l;
                float f2 = j2 > 0 ? ((float) (j - this.d)) / ((float) j2) : 1.0f;
                if (f2 >= 1.0f) {
                    int i = this.h;
                    int i2 = this.n;
                    if (i < i2 || i2 == -1) {
                        if (this.a != null) {
                            int size = this.a.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                this.a.get(i3).d(this);
                            }
                        }
                        if (this.o == 2) {
                            this.g = !this.g;
                        }
                        this.h += (int) f2;
                        f2 %= 1.0f;
                        this.d += this.l;
                    } else {
                        f2 = Math.min(f2, 1.0f);
                        z = true;
                    }
                }
                if (this.g) {
                    f2 = 1.0f - f2;
                }
                a(f2);
                break;
        }
        return z;
    }

    final boolean e(long j) {
        if (this.p <= 0) {
            return false;
        }
        if (this.i == 0) {
            this.i = 1;
            long j2 = this.e;
            if (j2 < 0) {
                this.d = j;
            } else {
                this.d = j - j2;
                this.e = -1L;
            }
        }
        return d(Math.max(j, this.d));
    }

    void a(float f2) {
        this.x = f2;
        float interpolation = this.E.getInterpolation(f2);
        this.w = interpolation;
        b(interpolation);
        ArrayList<b> arrayList = this.F;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.F.get(i).a(this);
            }
        }
    }

    protected void b(float f2) {
        int i = this.p;
        if (i <= 2) {
            a(f2, this.q, this.r);
        } else if (f2 <= 0.0f) {
            float[] fArr = this.s;
            int i2 = this.q;
            float f3 = fArr[i2];
            a((f2 - f3) / (fArr[1] - f3), i2, 1);
        } else if (f2 >= 1.0f) {
            int i3 = i - 2;
            float[] fArr2 = this.s;
            float f4 = fArr2[i3];
            int i4 = this.r;
            a((f2 - f4) / (fArr2[i4] - f4), i3, i4);
        } else {
            int i5 = this.q;
            for (int i6 = 1; i6 < this.p; i6++) {
                float[] fArr3 = this.s;
                if (f2 < fArr3[i6]) {
                    float f5 = fArr3[i5];
                    a((f2 - f5) / (fArr3[i6] - f5), i5, i6);
                    return;
                }
                i5 = i6;
            }
        }
    }

    private a l() {
        return f.b();
    }

    public boolean j() {
        return this.g;
    }
}
