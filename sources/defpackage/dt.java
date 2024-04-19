package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import defpackage.bz;
import defpackage.dv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MotionLayout.java */
/* renamed from: dt  reason: default package */
/* loaded from: classes.dex */
public class dt extends ConstraintLayout implements gg {
    public static boolean a;
    int A;
    int B;
    int C;
    int D;
    float E;
    int F;
    int G;
    HashMap<View, db> H;
    Rect I;
    h J;
    c K;
    ArrayList<Integer> L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private float S;
    private long T;
    private boolean U;
    private g V;
    private float W;
    private RectF aA;
    private View aB;
    private Matrix aC;
    private float aa;
    private boolean ab;
    private cy ac;
    private a ad;
    private de ae;
    private boolean af;
    private ArrayList<dq> ag;
    private ArrayList<dq> ah;
    private ArrayList<dq> ai;
    private CopyOnWriteArrayList<g> aj;
    private int ak;
    private long al;
    private float am;
    private int an;
    private float ao;
    private bi ap;
    private boolean aq;
    private f ar;
    private Runnable as;
    private int[] at;
    private boolean au;
    private int av;
    private int aw;
    private int ax;
    private boolean ay;
    private boolean az;
    dv b;
    Interpolator c;
    Interpolator d;
    float e;
    int f;
    HashMap<View, dp> g;
    float h;
    float i;
    float j;
    boolean k;
    int l;
    b m;
    int n;
    int o;
    int p;
    int q;
    boolean r;
    float s;
    float t;
    long u;
    float v;
    boolean w;
    protected boolean x;
    int y;
    int z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MotionLayout.java */
    /* renamed from: dt$d */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void a(int i);

        void a(MotionEvent motionEvent);

        float b();

        float c();
    }

    /* compiled from: MotionLayout.java */
    /* renamed from: dt$g */
    /* loaded from: classes.dex */
    public interface g {
        void a(dt dtVar, int i);

        void a(dt dtVar, int i, int i2);

        void a(dt dtVar, int i, int i2, float f);

        void a(dt dtVar, int i, boolean z, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionLayout.java */
    /* renamed from: dt$h */
    /* loaded from: classes.dex */
    public enum h {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private static boolean a(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    @Override // defpackage.gf
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, defpackage.ge
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, defpackage.ge
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp a(int i) {
        return this.g.get(findViewById(i));
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d a() {
        return e.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(h hVar) {
        if (hVar == h.FINISHED && this.f == -1) {
            return;
        }
        h hVar2 = this.J;
        this.J = hVar;
        if (hVar2 == h.MOVING && hVar == h.MOVING) {
            l();
        }
        switch (hVar2) {
            case UNDEFINED:
            case SETUP:
                if (hVar == h.MOVING) {
                    l();
                }
                if (hVar == h.FINISHED) {
                    e();
                    return;
                }
                return;
            case MOVING:
                if (hVar == h.FINISHED) {
                    e();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* compiled from: MotionLayout.java */
    /* renamed from: dt$e */
    /* loaded from: classes.dex */
    private static class e implements d {
        private static e b = new e();
        VelocityTracker a;

        private e() {
        }

        public static e d() {
            b.a = VelocityTracker.obtain();
            return b;
        }

        @Override // defpackage.dt.d
        public void a() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.a = null;
            }
        }

        @Override // defpackage.dt.d
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // defpackage.dt.d
        public void a(int i) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        @Override // defpackage.dt.d
        public float b() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // defpackage.dt.d
        public float c() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }
    }

    void setStartState(int i) {
        if (!isAttachedToWindow()) {
            if (this.ar == null) {
                this.ar = new f();
            }
            this.ar.b(i);
            this.ar.a(i);
            return;
        }
        this.f = i;
    }

    public void a(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.ar == null) {
                this.ar = new f();
            }
            this.ar.b(i);
            this.ar.a(i2);
            return;
        }
        dv dvVar = this.b;
        if (dvVar != null) {
            this.M = i;
            this.N = i2;
            dvVar.a(i, i2);
            this.K.a(this.mLayoutWidget, this.b.c(i), this.b.c(i2));
            f();
            this.i = 0.0f;
            b();
        }
    }

    public void setTransition(int i) {
        if (this.b != null) {
            dv.a d2 = d(i);
            int i2 = this.f;
            this.M = d2.d();
            this.N = d2.c();
            if (!isAttachedToWindow()) {
                if (this.ar == null) {
                    this.ar = new f();
                }
                this.ar.b(this.M);
                this.ar.a(this.N);
                return;
            }
            float f2 = Float.NaN;
            int i3 = this.f;
            if (i3 == this.M) {
                f2 = 0.0f;
            } else if (i3 == this.N) {
                f2 = 1.0f;
            }
            this.b.a(d2);
            this.K.a(this.mLayoutWidget, this.b.c(this.M), this.b.c(this.N));
            f();
            if (this.i != f2) {
                if (f2 == 0.0f) {
                    a(true);
                    this.b.c(this.M).c(this);
                } else if (f2 == 1.0f) {
                    a(false);
                    this.b.c(this.N).c(this);
                }
            }
            this.i = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                Log.v("MotionLayout", dd.a() + " transitionToStart ");
                b();
                return;
            }
            setProgress(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(dv.a aVar) {
        this.b.a(aVar);
        setState(h.SETUP);
        if (this.f == this.b.e()) {
            this.i = 1.0f;
            this.h = 1.0f;
            this.j = 1.0f;
        } else {
            this.i = 0.0f;
            this.h = 0.0f;
            this.j = 0.0f;
        }
        this.T = aVar.c(1) ? -1L : getNanoTime();
        int d2 = this.b.d();
        int e2 = this.b.e();
        if (d2 == this.M && e2 == this.N) {
            return;
        }
        this.M = d2;
        this.N = e2;
        this.b.a(this.M, this.N);
        this.K.a(this.mLayoutWidget, this.b.c(this.M), this.b.c(this.N));
        this.K.b(this.M, this.N);
        this.K.a();
        f();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.b = new dv(getContext(), this, i);
                if (this.f == -1 && this.b != null) {
                    this.f = this.b.d();
                    this.M = this.b.d();
                    this.N = this.b.e();
                }
                if (Build.VERSION.SDK_INT >= 19 && !isAttachedToWindow()) {
                    this.b = null;
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        Display display = getDisplay();
                        this.ax = display == null ? 0 : display.getRotation();
                    }
                    if (this.b != null) {
                        androidx.constraintlayout.widget.e c2 = this.b.c(this.f);
                        this.b.a(this);
                        if (this.ai != null) {
                            Iterator<dq> it = this.ai.iterator();
                            while (it.hasNext()) {
                                it.next().a(this);
                            }
                        }
                        if (c2 != null) {
                            c2.c(this);
                        }
                        this.M = this.f;
                    }
                    d();
                    if (this.ar != null) {
                        if (this.ay) {
                            post(new Runnable() { // from class: dt.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    dt.this.ar.a();
                                }
                            });
                            return;
                        } else {
                            this.ar.a();
                            return;
                        }
                    } else if (this.b == null || this.b.b == null || this.b.b.b() != 4) {
                        return;
                    } else {
                        c();
                        setState(h.SETUP);
                        setState(h.MOVING);
                        return;
                    }
                } catch (Exception e2) {
                    throw new IllegalArgumentException("unable to parse MotionScene file", e2);
                }
            } catch (Exception e3) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e3);
            }
        }
        this.b = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(h.SETUP);
        this.f = i;
        this.M = -1;
        this.N = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.a(i, i2, i3);
            return;
        }
        dv dvVar = this.b;
        if (dvVar != null) {
            dvVar.c(i).c(this);
        }
    }

    public void setInterpolatedProgress(float f2) {
        if (this.b != null) {
            setState(h.MOVING);
            Interpolator f3 = this.b.f();
            if (f3 != null) {
                setProgress(f3.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void a(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.ar == null) {
                this.ar = new f();
            }
            this.ar.a(f2);
            this.ar.b(f3);
            return;
        }
        setProgress(f2);
        setState(h.MOVING);
        this.e = f3;
        a(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionLayout.java */
    /* renamed from: dt$f */
    /* loaded from: classes.dex */
    public class f {
        float a = Float.NaN;
        float b = Float.NaN;
        int c = -1;
        int d = -1;
        final String e = "motion.progress";
        final String f = "motion.velocity";
        final String g = "motion.StartState";
        final String h = "motion.EndState";

        f() {
        }

        void a() {
            if (this.c != -1 || this.d != -1) {
                int i = this.c;
                if (i == -1) {
                    dt.this.b(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        dt.this.setState(i, -1, -1);
                    } else {
                        dt.this.a(i, i2);
                    }
                }
                dt.this.setState(h.SETUP);
            }
            if (Float.isNaN(this.b)) {
                if (Float.isNaN(this.a)) {
                    return;
                }
                dt.this.setProgress(this.a);
                return;
            }
            dt.this.a(this.a, this.b);
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = -1;
            this.d = -1;
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void a(Bundle bundle) {
            this.a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void a(float f) {
            this.a = f;
        }

        public void a(int i) {
            this.d = i;
        }

        public void b(float f) {
            this.b = f;
        }

        public void b(int i) {
            this.c = i;
        }

        public void c() {
            this.d = dt.this.N;
            this.c = dt.this.M;
            this.b = dt.this.getVelocity();
            this.a = dt.this.getProgress();
        }
    }

    public void setTransitionState(Bundle bundle) {
        if (this.ar == null) {
            this.ar = new f();
        }
        this.ar.a(bundle);
        if (isAttachedToWindow()) {
            this.ar.a();
        }
    }

    public Bundle getTransitionState() {
        if (this.ar == null) {
            this.ar = new f();
        }
        this.ar.c();
        return this.ar.b();
    }

    public void setProgress(float f2) {
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i < 0 || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.ar == null) {
                this.ar = new f();
            }
            this.ar.a(f2);
            return;
        }
        if (i <= 0) {
            if (this.i == 1.0f && this.f == this.N) {
                setState(h.MOVING);
            }
            this.f = this.M;
            if (this.i == 0.0f) {
                setState(h.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.i == 0.0f && this.f == this.M) {
                setState(h.MOVING);
            }
            this.f = this.N;
            if (this.i == 1.0f) {
                setState(h.FINISHED);
            }
        } else {
            this.f = -1;
            setState(h.MOVING);
        }
        if (this.b == null) {
            return;
        }
        this.U = true;
        this.j = f2;
        this.h = f2;
        this.T = -1L;
        this.R = -1L;
        this.c = null;
        this.k = true;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int childCount = getChildCount();
        this.K.b();
        boolean z = true;
        this.k = true;
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            sparseArray.put(childAt.getId(), this.g.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int h2 = this.b.h();
        if (h2 != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                dp dpVar = this.g.get(getChildAt(i3));
                if (dpVar != null) {
                    dpVar.b(h2);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.g.size()];
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            dp dpVar2 = this.g.get(getChildAt(i5));
            if (dpVar2.c() != -1) {
                sparseBooleanArray.put(dpVar2.c(), true);
                iArr[i4] = dpVar2.c();
                i4++;
            }
        }
        if (this.ai != null) {
            for (int i6 = 0; i6 < i4; i6++) {
                dp dpVar3 = this.g.get(findViewById(iArr[i6]));
                if (dpVar3 != null) {
                    this.b.a(dpVar3);
                }
            }
            Iterator<dq> it = this.ai.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.g);
            }
            for (int i7 = 0; i7 < i4; i7++) {
                dp dpVar4 = this.g.get(findViewById(iArr[i7]));
                if (dpVar4 != null) {
                    dpVar4.a(width, height, this.S, getNanoTime());
                }
            }
        } else {
            for (int i8 = 0; i8 < i4; i8++) {
                dp dpVar5 = this.g.get(findViewById(iArr[i8]));
                if (dpVar5 != null) {
                    this.b.a(dpVar5);
                    dpVar5.a(width, height, this.S, getNanoTime());
                }
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            dp dpVar6 = this.g.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && dpVar6 != null) {
                this.b.a(dpVar6);
                dpVar6.a(width, height, this.S, getNanoTime());
            }
        }
        float i10 = this.b.i();
        if (i10 != 0.0f) {
            boolean z2 = ((double) i10) < 0.0d;
            float abs = Math.abs(i10);
            float f2 = -3.4028235E38f;
            float f3 = Float.MAX_VALUE;
            int i11 = 0;
            float f4 = -3.4028235E38f;
            float f5 = Float.MAX_VALUE;
            while (true) {
                if (i11 >= childCount) {
                    z = false;
                    break;
                }
                dp dpVar7 = this.g.get(getChildAt(i11));
                if (!Float.isNaN(dpVar7.e)) {
                    break;
                }
                float a2 = dpVar7.a();
                float b2 = dpVar7.b();
                float f6 = z2 ? b2 - a2 : b2 + a2;
                f5 = Math.min(f5, f6);
                f4 = Math.max(f4, f6);
                i11++;
            }
            if (!z) {
                while (i < childCount) {
                    dp dpVar8 = this.g.get(getChildAt(i));
                    float a3 = dpVar8.a();
                    float b3 = dpVar8.b();
                    float f7 = z2 ? b3 - a3 : b3 + a3;
                    dpVar8.g = 1.0f / (1.0f - abs);
                    dpVar8.f = abs - (((f7 - f5) * abs) / (f4 - f5));
                    i++;
                }
                return;
            }
            for (int i12 = 0; i12 < childCount; i12++) {
                dp dpVar9 = this.g.get(getChildAt(i12));
                if (!Float.isNaN(dpVar9.e)) {
                    f3 = Math.min(f3, dpVar9.e);
                    f2 = Math.max(f2, dpVar9.e);
                }
            }
            while (i < childCount) {
                dp dpVar10 = this.g.get(getChildAt(i));
                if (!Float.isNaN(dpVar10.e)) {
                    dpVar10.g = 1.0f / (1.0f - abs);
                    if (z2) {
                        dpVar10.f = abs - (((f2 - dpVar10.e) / (f2 - f3)) * abs);
                    } else {
                        dpVar10.f = abs - (((dpVar10.e - f3) * abs) / (f2 - f3));
                    }
                }
                i++;
            }
        }
    }

    public void a(int i, float f2, float f3) {
        if (this.b == null || this.i == f2) {
            return;
        }
        this.ab = true;
        this.R = getNanoTime();
        this.S = this.b.g() / 1000.0f;
        this.j = f2;
        this.k = true;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 6:
            case 7:
                if (i == 1 || i == 7) {
                    f2 = 0.0f;
                } else if (i == 2 || i == 6) {
                    f2 = 1.0f;
                }
                if (this.b.q() == 0) {
                    this.ac.a(this.i, f2, f3, this.S, this.b.j(), this.b.k());
                } else {
                    this.ac.a(this.i, f2, f3, this.b.m(), this.b.l(), this.b.n(), this.b.o(), this.b.p());
                }
                int i2 = this.f;
                this.j = f2;
                this.f = i2;
                this.c = this.ac;
                break;
            case 4:
                this.ad.a(f3, this.i, this.b.j());
                this.c = this.ad;
                break;
            case 5:
                if (a(f3, this.i, this.b.j())) {
                    this.ad.a(f3, this.i, this.b.j());
                    this.c = this.ad;
                    break;
                } else {
                    this.ac.a(this.i, f2, f3, this.S, this.b.j(), this.b.k());
                    this.e = 0.0f;
                    int i3 = this.f;
                    this.j = f2;
                    this.f = i3;
                    this.c = this.ac;
                    break;
                }
        }
        this.U = false;
        this.R = getNanoTime();
        invalidate();
    }

    /* compiled from: MotionLayout.java */
    /* renamed from: dt$a */
    /* loaded from: classes.dex */
    class a extends ds {
        float a;
        float b;
        float c;
        final /* synthetic */ dt d;

        public void a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.a;
            if (f2 > 0.0f) {
                float f3 = this.c;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                dt dtVar = this.d;
                float f4 = this.a;
                float f5 = this.c;
                dtVar.e = f4 - (f5 * f);
                return ((f4 * f) - (((f5 * f) * f) / 2.0f)) + this.b;
            }
            float f6 = this.c;
            if ((-f2) / f6 < f) {
                f = (-f2) / f6;
            }
            dt dtVar2 = this.d;
            float f7 = this.a;
            float f8 = this.c;
            dtVar2.e = (f8 * f) + f7;
            return (f7 * f) + (((f8 * f) * f) / 2.0f) + this.b;
        }

        @Override // defpackage.ds
        public float a() {
            return this.d.e;
        }
    }

    void a(float f2) {
        if (this.b == null) {
            return;
        }
        float f3 = this.i;
        float f4 = this.h;
        if (f3 != f4 && this.U) {
            this.i = f4;
        }
        float f5 = this.i;
        if (f5 == f2) {
            return;
        }
        this.ab = false;
        this.j = f2;
        this.S = this.b.g() / 1000.0f;
        setProgress(this.j);
        this.c = null;
        this.d = this.b.f();
        this.U = false;
        this.R = getNanoTime();
        this.k = true;
        this.h = f5;
        this.i = f5;
        invalidate();
    }

    private void j() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            dp dpVar = this.g.get(childAt);
            if (dpVar != null) {
                dpVar.b(childAt);
            }
        }
    }

    public void b() {
        a(0.0f);
    }

    public void c() {
        a(1.0f);
        this.as = null;
    }

    public void a(Runnable runnable) {
        a(1.0f);
        this.as = runnable;
    }

    public void b(int i) {
        if (!isAttachedToWindow()) {
            if (this.ar == null) {
                this.ar = new f();
            }
            this.ar.a(i);
            return;
        }
        a(i, -1, -1);
    }

    public void a(int i, int i2, int i3) {
        a(i, i2, i3, -1);
    }

    public void a(int i, int i2, int i3, int i4) {
        int a2;
        dv dvVar = this.b;
        if (dvVar != null && dvVar.a != null && (a2 = this.b.a.a(this.f, i, i2, i3)) != -1) {
            i = a2;
        }
        int i5 = this.f;
        if (i5 == i) {
            return;
        }
        if (this.M == i) {
            a(0.0f);
            if (i4 > 0) {
                this.S = i4 / 1000.0f;
            }
        } else if (this.N == i) {
            a(1.0f);
            if (i4 > 0) {
                this.S = i4 / 1000.0f;
            }
        } else {
            this.N = i;
            if (i5 != -1) {
                a(i5, i);
                a(1.0f);
                this.i = 0.0f;
                c();
                if (i4 > 0) {
                    this.S = i4 / 1000.0f;
                    return;
                }
                return;
            }
            this.ab = false;
            this.j = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.T = getNanoTime();
            this.R = getNanoTime();
            this.U = false;
            this.c = null;
            if (i4 == -1) {
                this.S = this.b.g() / 1000.0f;
            }
            this.M = -1;
            this.b.a(this.M, this.N);
            SparseArray sparseArray = new SparseArray();
            if (i4 == 0) {
                this.S = this.b.g() / 1000.0f;
            } else if (i4 > 0) {
                this.S = i4 / 1000.0f;
            }
            int childCount = getChildCount();
            this.g.clear();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                this.g.put(childAt, new dp(childAt));
                sparseArray.put(childAt.getId(), this.g.get(childAt));
            }
            this.k = true;
            this.K.a(this.mLayoutWidget, null, this.b.c(i));
            f();
            this.K.b();
            j();
            int width = getWidth();
            int height = getHeight();
            if (this.ai != null) {
                for (int i7 = 0; i7 < childCount; i7++) {
                    dp dpVar = this.g.get(getChildAt(i7));
                    if (dpVar != null) {
                        this.b.a(dpVar);
                    }
                }
                Iterator<dq> it = this.ai.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.g);
                }
                for (int i8 = 0; i8 < childCount; i8++) {
                    dp dpVar2 = this.g.get(getChildAt(i8));
                    if (dpVar2 != null) {
                        dpVar2.a(width, height, this.S, getNanoTime());
                    }
                }
            } else {
                for (int i9 = 0; i9 < childCount; i9++) {
                    dp dpVar3 = this.g.get(getChildAt(i9));
                    if (dpVar3 != null) {
                        this.b.a(dpVar3);
                        dpVar3.a(width, height, this.S, getNanoTime());
                    }
                }
            }
            float i10 = this.b.i();
            if (i10 != 0.0f) {
                float f2 = -3.4028235E38f;
                float f3 = Float.MAX_VALUE;
                for (int i11 = 0; i11 < childCount; i11++) {
                    dp dpVar4 = this.g.get(getChildAt(i11));
                    float b2 = dpVar4.b() + dpVar4.a();
                    f3 = Math.min(f3, b2);
                    f2 = Math.max(f2, b2);
                }
                for (int i12 = 0; i12 < childCount; i12++) {
                    dp dpVar5 = this.g.get(getChildAt(i12));
                    float a3 = dpVar5.a();
                    float b3 = dpVar5.b();
                    dpVar5.g = 1.0f / (1.0f - i10);
                    dpVar5.f = i10 - ((((a3 + b3) - f3) * i10) / (f2 - f3));
                }
            }
            this.h = 0.0f;
            this.i = 0.0f;
            this.k = true;
            invalidate();
        }
    }

    public float getVelocity() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionLayout.java */
    /* renamed from: dt$c */
    /* loaded from: classes.dex */
    public class c {
        ca a;
        ca b;
        androidx.constraintlayout.widget.e c;
        androidx.constraintlayout.widget.e d;
        int e;
        int f;
        final /* synthetic */ dt g;

        void a(ca caVar, ca caVar2) {
            bz bzVar;
            ArrayList<bz> ah = caVar.ah();
            HashMap<bz, bz> hashMap = new HashMap<>();
            hashMap.put(caVar, caVar2);
            caVar2.ah().clear();
            caVar2.a(caVar, hashMap);
            Iterator<bz> it = ah.iterator();
            while (it.hasNext()) {
                bz next = it.next();
                if (next instanceof bv) {
                    bzVar = new bv();
                } else if (next instanceof cc) {
                    bzVar = new cc();
                } else if (next instanceof cb) {
                    bzVar = new cb();
                } else if (next instanceof cd) {
                    bzVar = new ce();
                } else {
                    bzVar = new bz();
                }
                caVar2.b(bzVar);
                hashMap.put(next, bzVar);
            }
            Iterator<bz> it2 = ah.iterator();
            while (it2.hasNext()) {
                bz next2 = it2.next();
                hashMap.get(next2).a(next2, hashMap);
            }
        }

        void a(ca caVar, androidx.constraintlayout.widget.e eVar, androidx.constraintlayout.widget.e eVar2) {
            this.c = eVar;
            this.d = eVar2;
            this.a = new ca();
            this.b = new ca();
            this.a.a(this.g.mLayoutWidget.g());
            this.b.a(this.g.mLayoutWidget.g());
            this.a.ai();
            this.b.ai();
            a(this.g.mLayoutWidget, this.a);
            a(this.g.mLayoutWidget, this.b);
            if (this.g.i > 0.5d) {
                if (eVar != null) {
                    a(this.a, eVar);
                }
                a(this.b, eVar2);
            } else {
                a(this.b, eVar2);
                if (eVar != null) {
                    a(this.a, eVar);
                }
            }
            this.a.g(this.g.isRtl());
            this.a.f();
            this.b.g(this.g.isRtl());
            this.b.f();
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.a.a(bz.a.WRAP_CONTENT);
                    this.b.a(bz.a.WRAP_CONTENT);
                }
                if (layoutParams.height == -2) {
                    this.a.b(bz.a.WRAP_CONTENT);
                    this.b.b(bz.a.WRAP_CONTENT);
                }
            }
        }

        private void a(ca caVar, androidx.constraintlayout.widget.e eVar) {
            SparseArray<bz> sparseArray = new SparseArray<>();
            f.a aVar = new f.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, caVar);
            sparseArray.put(this.g.getId(), caVar);
            if (eVar != null && eVar.c != 0) {
                dt dtVar = this.g;
                dtVar.resolveSystem(this.b, dtVar.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.g.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.g.getWidth(), 1073741824));
            }
            Iterator<bz> it = caVar.ah().iterator();
            while (it.hasNext()) {
                bz next = it.next();
                sparseArray.put(((View) next.R()).getId(), next);
            }
            Iterator<bz> it2 = caVar.ah().iterator();
            while (it2.hasNext()) {
                bz next2 = it2.next();
                View view = (View) next2.R();
                eVar.a(view.getId(), aVar);
                next2.q(eVar.e(view.getId()));
                next2.r(eVar.d(view.getId()));
                if (view instanceof androidx.constraintlayout.widget.c) {
                    eVar.a((androidx.constraintlayout.widget.c) view, next2, aVar, sparseArray);
                    if (view instanceof androidx.constraintlayout.widget.a) {
                        ((androidx.constraintlayout.widget.a) view).d();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar.resolveLayoutDirection(this.g.getLayoutDirection());
                } else {
                    aVar.resolveLayoutDirection(0);
                }
                this.g.applyConstraintsFromLayoutParams(false, view, next2, aVar, sparseArray);
                if (eVar.b(view.getId()) == 1) {
                    next2.l(view.getVisibility());
                } else {
                    next2.l(eVar.c(view.getId()));
                }
            }
            Iterator<bz> it3 = caVar.ah().iterator();
            while (it3.hasNext()) {
                bz next3 = it3.next();
                if (next3 instanceof cg) {
                    cd cdVar = (cd) next3;
                    ((androidx.constraintlayout.widget.c) next3.R()).a(caVar, cdVar, sparseArray);
                    ((cg) cdVar).i();
                }
            }
        }

        bz a(ca caVar, View view) {
            if (caVar.R() == view) {
                return caVar;
            }
            ArrayList<bz> ah = caVar.ah();
            int size = ah.size();
            for (int i = 0; i < size; i++) {
                bz bzVar = ah.get(i);
                if (bzVar.R() == view) {
                    return bzVar;
                }
            }
            return null;
        }

        public void a() {
            a(this.g.O, this.g.P);
            this.g.i();
        }

        public void a(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            dt dtVar = this.g;
            dtVar.C = mode;
            dtVar.D = mode2;
            int optimizationLevel = dtVar.getOptimizationLevel();
            if (this.g.f == this.g.getStartState()) {
                dt dtVar2 = this.g;
                ca caVar = this.b;
                androidx.constraintlayout.widget.e eVar = this.d;
                int i3 = (eVar == null || eVar.c == 0) ? i : i2;
                androidx.constraintlayout.widget.e eVar2 = this.d;
                dtVar2.resolveSystem(caVar, optimizationLevel, i3, (eVar2 == null || eVar2.c == 0) ? i2 : i);
                androidx.constraintlayout.widget.e eVar3 = this.c;
                if (eVar3 != null) {
                    this.g.resolveSystem(this.a, optimizationLevel, eVar3.c == 0 ? i : i2, this.c.c == 0 ? i2 : i);
                }
            } else {
                androidx.constraintlayout.widget.e eVar4 = this.c;
                if (eVar4 != null) {
                    this.g.resolveSystem(this.a, optimizationLevel, eVar4.c == 0 ? i : i2, this.c.c == 0 ? i2 : i);
                }
                dt dtVar3 = this.g;
                ca caVar2 = this.b;
                androidx.constraintlayout.widget.e eVar5 = this.d;
                int i4 = (eVar5 == null || eVar5.c == 0) ? i : i2;
                androidx.constraintlayout.widget.e eVar6 = this.d;
                dtVar3.resolveSystem(caVar2, optimizationLevel, i4, (eVar6 == null || eVar6.c == 0) ? i2 : i);
            }
            if (((this.g.getParent() instanceof dt) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                dt dtVar4 = this.g;
                dtVar4.C = mode;
                dtVar4.D = mode2;
                if (dtVar4.f == this.g.getStartState()) {
                    this.g.resolveSystem(this.b, optimizationLevel, this.d.c == 0 ? i : i2, this.d.c == 0 ? i2 : i);
                    androidx.constraintlayout.widget.e eVar7 = this.c;
                    if (eVar7 != null) {
                        this.g.resolveSystem(this.a, optimizationLevel, eVar7.c == 0 ? i : i2, this.c.c == 0 ? i2 : i);
                    }
                } else {
                    androidx.constraintlayout.widget.e eVar8 = this.c;
                    if (eVar8 != null) {
                        this.g.resolveSystem(this.a, optimizationLevel, eVar8.c == 0 ? i : i2, this.c.c == 0 ? i2 : i);
                    }
                    this.g.resolveSystem(this.b, optimizationLevel, this.d.c == 0 ? i : i2, this.d.c == 0 ? i2 : i);
                }
                this.g.y = this.a.F();
                this.g.z = this.a.G();
                this.g.A = this.b.F();
                this.g.B = this.b.G();
                dt dtVar5 = this.g;
                dtVar5.x = (dtVar5.y == this.g.A && this.g.z == this.g.B) ? false : true;
            }
            this.g.resolveMeasuredDimension(i, i2, (this.g.C == Integer.MIN_VALUE || this.g.C == 0) ? (int) (this.g.y + (this.g.E * (this.g.A - this.g.y))) : this.g.y, (this.g.D == Integer.MIN_VALUE || this.g.D == 0) ? (int) (this.g.z + (this.g.E * (this.g.B - this.g.z))) : this.g.z, this.a.i() || this.b.i(), this.a.ac() || this.b.ac());
        }

        public void b() {
            int childCount = this.g.getChildCount();
            this.g.g.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i = 0; i < childCount; i++) {
                View childAt = this.g.getChildAt(i);
                dp dpVar = new dp(childAt);
                int id = childAt.getId();
                iArr[i] = id;
                sparseArray.put(id, dpVar);
                this.g.g.put(childAt, dpVar);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = this.g.getChildAt(i2);
                dp dpVar2 = this.g.g.get(childAt2);
                if (dpVar2 != null) {
                    if (this.c == null) {
                        if (this.g.au) {
                            dpVar2.a(this.g.H.get(childAt2), childAt2, this.g.G, this.g.av, this.g.aw);
                        }
                    } else {
                        bz a = a(this.a, childAt2);
                        if (a != null) {
                            dpVar2.a(this.g.a(a), this.c, this.g.getWidth(), this.g.getHeight());
                        } else if (this.g.l != 0) {
                            Log.e("MotionLayout", dd.a() + "no widget for  " + dd.a(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.d != null) {
                        bz a2 = a(this.b, childAt2);
                        if (a2 != null) {
                            dpVar2.b(this.g.a(a2), this.d, this.g.getWidth(), this.g.getHeight());
                        } else if (this.g.l != 0) {
                            Log.e("MotionLayout", dd.a() + "no widget for  " + dd.a(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                dp dpVar3 = (dp) sparseArray.get(iArr[i3]);
                int c = dpVar3.c();
                if (c != -1) {
                    dpVar3.a((dp) sparseArray.get(c));
                }
            }
        }

        public void b(int i, int i2) {
            this.e = i;
            this.f = i2;
        }

        public boolean c(int i, int i2) {
            return (i == this.e && i2 == this.f) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect a(bz bzVar) {
        this.I.top = bzVar.E();
        this.I.left = bzVar.D();
        this.I.right = bzVar.F() + this.I.left;
        this.I.bottom = bzVar.G() + this.I.top;
        return this.I;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        dv dvVar;
        if (this.x || this.f != -1 || (dvVar = this.b) == null || dvVar.b == null || this.b.b.a() != 0) {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return dd.a(context, this.M) + "->" + dd.a(context, this.N) + " (pos:" + this.i + " Dpos/Dt:" + this.e;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.b == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z = false;
        boolean z2 = (this.O == i && this.P == i2) ? false : true;
        if (this.az) {
            this.az = false;
            d();
            m();
            z2 = true;
        }
        if (this.mDirtyHierarchy) {
            z2 = true;
        }
        this.O = i;
        this.P = i2;
        int d2 = this.b.d();
        int e2 = this.b.e();
        if ((z2 || this.K.c(d2, e2)) && this.M != -1) {
            super.onMeasure(i, i2);
            this.K.a(this.mLayoutWidget, this.b.c(d2), this.b.c(e2));
            this.K.a();
            this.K.b(d2, e2);
        } else {
            if (z2) {
                super.onMeasure(i, i2);
            }
            z = true;
        }
        if (this.x || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int F = this.mLayoutWidget.F() + getPaddingLeft() + getPaddingRight();
            int G = this.mLayoutWidget.G() + paddingTop;
            int i5 = this.C;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                F = (int) (this.y + (this.E * (this.A - i3)));
                requestLayout();
            }
            int i6 = this.D;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                G = (int) (this.z + (this.E * (this.B - i4)));
                requestLayout();
            }
            setMeasuredDimension(F, G);
        }
        k();
    }

    @Override // defpackage.gf
    public boolean a(View view, View view2, int i, int i2) {
        dv dvVar = this.b;
        return (dvVar == null || dvVar.b == null || this.b.b.e() == null || (this.b.b.e().g() & 2) != 0) ? false : true;
    }

    @Override // defpackage.gf
    public void b(View view, View view2, int i, int i2) {
        this.u = getNanoTime();
        this.v = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
    }

    @Override // defpackage.gf
    public void a(View view, int i) {
        dv dvVar = this.b;
        if (dvVar != null) {
            float f2 = this.v;
            if (f2 == 0.0f) {
                return;
            }
            dvVar.b(this.s / f2, this.t / f2);
        }
    }

    @Override // defpackage.gg
    public void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.r || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.r = false;
    }

    @Override // defpackage.gf
    public void a(final View view, int i, int i2, int[] iArr, int i3) {
        dv.a aVar;
        dw e2;
        int f2;
        dv dvVar = this.b;
        if (dvVar == null || (aVar = dvVar.b) == null || !aVar.f()) {
            return;
        }
        int i4 = -1;
        if (!aVar.f() || (e2 = aVar.e()) == null || (f2 = e2.f()) == -1 || view.getId() == f2) {
            if (dvVar.s()) {
                dw e3 = aVar.e();
                if (e3 != null && (e3.g() & 4) != 0) {
                    i4 = i2;
                }
                float f3 = this.h;
                if ((f3 == 1.0f || f3 == 0.0f) && view.canScrollVertically(i4)) {
                    return;
                }
            }
            if (aVar.e() != null && (aVar.e().g() & 1) != 0) {
                float c2 = dvVar.c(i, i2);
                if ((this.i <= 0.0f && c2 < 0.0f) || (this.i >= 1.0f && c2 > 0.0f)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() { // from class: dt.2
                            @Override // java.lang.Runnable
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            float f4 = this.h;
            long nanoTime = getNanoTime();
            float f5 = i;
            this.s = f5;
            float f6 = i2;
            this.t = f6;
            this.v = (float) ((nanoTime - this.u) * 1.0E-9d);
            this.u = nanoTime;
            dvVar.a(f5, f6);
            if (f4 != this.h) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            b(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.r = true;
        }
    }

    /* compiled from: MotionLayout.java */
    /* renamed from: dt$b */
    /* loaded from: classes.dex */
    private class b {
        float[] a;
        int[] b;
        float[] c;
        Path d;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        DashPathEffect o;
        int p;
        int s;
        private float[] u;
        final int j = -21965;
        final int k = -2067046;
        final int l = -13391360;
        final int m = 1996488704;
        final int n = 10;
        Rect q = new Rect();
        boolean r = false;
        Paint e = new Paint();

        public b() {
            this.s = 1;
            this.e.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint.Style.STROKE);
            this.f = new Paint();
            this.f.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            this.g = new Paint();
            this.g.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            this.h = new Paint();
            this.h.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(dt.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.u = new float[8];
            this.i = new Paint();
            this.i.setAntiAlias(true);
            this.o = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.g.setPathEffect(this.o);
            this.c = new float[100];
            this.b = new int[50];
            if (this.r) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.s = 4;
            }
        }

        public void a(Canvas canvas, HashMap<View, dp> hashMap, int i, int i2) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!dt.this.isInEditMode() && (i2 & 1) == 2) {
                String str = dt.this.getContext().getResources().getResourceName(dt.this.N) + ":" + dt.this.getProgress();
                canvas.drawText(str, 10.0f, dt.this.getHeight() - 30, this.h);
                canvas.drawText(str, 11.0f, dt.this.getHeight() - 29, this.e);
            }
            for (dp dpVar : hashMap.values()) {
                int g = dpVar.g();
                if (i2 > 0 && g == 0) {
                    g = 1;
                }
                if (g != 0) {
                    this.p = dpVar.a(this.c, this.b);
                    if (g >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.a;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.a = new float[i3 * 2];
                            this.d = new Path();
                        }
                        int i4 = this.s;
                        canvas.translate(i4, i4);
                        this.e.setColor(1996488704);
                        this.i.setColor(1996488704);
                        this.f.setColor(1996488704);
                        this.g.setColor(1996488704);
                        dpVar.a(this.a, i3);
                        a(canvas, g, this.p, dpVar);
                        this.e.setColor(-21965);
                        this.f.setColor(-2067046);
                        this.i.setColor(-2067046);
                        this.g.setColor(-13391360);
                        int i5 = this.s;
                        canvas.translate(-i5, -i5);
                        a(canvas, g, this.p, dpVar);
                        if (g == 5) {
                            a(canvas, dpVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void a(Canvas canvas, int i, int i2, dp dpVar) {
            if (i == 4) {
                c(canvas);
            }
            if (i == 2) {
                b(canvas);
            }
            if (i == 3) {
                d(canvas);
            }
            a(canvas);
            b(canvas, i, i2, dpVar);
        }

        private void a(Canvas canvas) {
            canvas.drawLines(this.a, this.e);
        }

        private void b(Canvas canvas, int i, int i2, dp dpVar) {
            int i3;
            int i4;
            float f;
            float f2;
            if (dpVar.b != null) {
                i3 = dpVar.b.getWidth();
                i4 = dpVar.b.getHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            for (int i5 = 1; i5 < i2 - 1; i5++) {
                if (i != 4 || this.b[i5 - 1] != 0) {
                    float[] fArr = this.c;
                    int i6 = i5 * 2;
                    float f3 = fArr[i6];
                    float f4 = fArr[i6 + 1];
                    this.d.reset();
                    this.d.moveTo(f3, f4 + 10.0f);
                    this.d.lineTo(f3 + 10.0f, f4);
                    this.d.lineTo(f3, f4 - 10.0f);
                    this.d.lineTo(f3 - 10.0f, f4);
                    this.d.close();
                    int i7 = i5 - 1;
                    dpVar.a(i7);
                    if (i == 4) {
                        int[] iArr = this.b;
                        if (iArr[i7] == 1) {
                            a(canvas, f3 - 0.0f, f4 - 0.0f);
                            f = f4;
                            f2 = f3;
                        } else if (iArr[i7] == 0) {
                            b(canvas, f3 - 0.0f, f4 - 0.0f);
                            f = f4;
                            f2 = f3;
                        } else if (iArr[i7] == 2) {
                            f = f4;
                            f2 = f3;
                            a(canvas, f3 - 0.0f, f4 - 0.0f, i3, i4);
                        } else {
                            f = f4;
                            f2 = f3;
                        }
                        canvas.drawPath(this.d, this.i);
                    } else {
                        f = f4;
                        f2 = f3;
                    }
                    if (i == 2) {
                        a(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 3) {
                        b(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        a(canvas, f2 - 0.0f, f - 0.0f, i3, i4);
                    }
                    canvas.drawPath(this.d, this.i);
                }
            }
            float[] fArr2 = this.a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        private void a(Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.g);
            canvas.drawLine(f, f2, f3, f4, this.g);
        }

        private void b(Canvas canvas) {
            float[] fArr = this.a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        private void c(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.p; i++) {
                if (this.b[i] == 1) {
                    z = true;
                }
                if (this.b[i] == 0) {
                    z2 = true;
                }
            }
            if (z) {
                b(canvas);
            }
            if (z2) {
                d(canvas);
            }
        }

        private void a(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            a(str, this.h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.q.width() / 2), -20.0f, this.h);
            canvas.drawLine(f, f2, f10, f11, this.g);
        }

        void a(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.q);
        }

        private void d(Canvas canvas) {
            float[] fArr = this.a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.g);
        }

        private void b(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
            a(str, this.h);
            canvas.drawText(str, ((min2 / 2.0f) - (this.q.width() / 2)) + min, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.g);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            a(str2, this.h);
            canvas.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - (this.q.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.g);
        }

        private void a(Canvas canvas, float f, float f2, int i, int i2) {
            String str = "" + (((int) ((((f - (i / 2)) * 100.0f) / (dt.this.getWidth() - i)) + 0.5d)) / 100.0f);
            a(str, this.h);
            canvas.drawText(str, ((f / 2.0f) - (this.q.width() / 2)) + 0.0f, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.g);
            String str2 = "" + (((int) ((((f2 - (i2 / 2)) * 100.0f) / (dt.this.getHeight() - i2)) + 0.5d)) / 100.0f);
            a(str2, this.h);
            canvas.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.q.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.g);
        }

        private void a(Canvas canvas, dp dpVar) {
            this.d.reset();
            for (int i = 0; i <= 50; i++) {
                dpVar.a(i / 50, this.u, 0);
                Path path = this.d;
                float[] fArr = this.u;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.d;
                float[] fArr2 = this.u;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.d;
                float[] fArr3 = this.u;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.d;
                float[] fArr4 = this.u;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.d.close();
            }
            this.e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.d, this.e);
            canvas.translate(-2.0f, -2.0f);
            this.e.setColor(-65536);
            canvas.drawPath(this.d, this.e);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long j;
        ArrayList<dq> arrayList = this.ai;
        if (arrayList != null) {
            Iterator<dq> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(canvas);
            }
        }
        b(false);
        dv dvVar = this.b;
        if (dvVar != null && dvVar.c != null) {
            this.b.c.a();
        }
        super.dispatchDraw(canvas);
        if (this.b == null) {
            return;
        }
        if ((this.l & 1) == 1 && !isInEditMode()) {
            this.ak++;
            long nanoTime = getNanoTime();
            long j2 = this.al;
            if (j2 != -1) {
                if (nanoTime - j2 > 200000000) {
                    this.am = ((int) ((this.ak / (((float) j) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.ak = 0;
                    this.al = nanoTime;
                }
            } else {
                this.al = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            StringBuilder sb = new StringBuilder();
            sb.append(this.am + " fps " + dd.a(this, this.M) + " -> ");
            sb.append(dd.a(this, this.N));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i = this.f;
            sb.append(i == -1 ? "undefined" : dd.a(this, i));
            String sb2 = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.l > 1) {
            if (this.m == null) {
                this.m = new b();
            }
            this.m.a(canvas, this.g, this.b.g(), this.l);
        }
        ArrayList<dq> arrayList2 = this.ai;
        if (arrayList2 != null) {
            Iterator<dq> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().b(canvas);
            }
        }
    }

    private void k() {
        boolean z;
        float signum = Math.signum(this.j - this.i);
        long nanoTime = getNanoTime();
        float f2 = this.i + (!(this.c instanceof cy) ? ((((float) (nanoTime - this.T)) * signum) * 1.0E-9f) / this.S : 0.0f);
        if (this.U) {
            f2 = this.j;
        }
        int i = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i <= 0 || f2 < this.j) && (signum > 0.0f || f2 > this.j)) {
            z = false;
        } else {
            f2 = this.j;
            z = true;
        }
        Interpolator interpolator = this.c;
        if (interpolator != null && !z) {
            if (this.ab) {
                f2 = interpolator.getInterpolation(((float) (nanoTime - this.R)) * 1.0E-9f);
            } else {
                f2 = interpolator.getInterpolation(f2);
            }
        }
        if ((i > 0 && f2 >= this.j) || (signum <= 0.0f && f2 <= this.j)) {
            f2 = this.j;
        }
        this.E = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.d;
        if (interpolator2 != null) {
            f2 = interpolator2.getInterpolation(f2);
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            dp dpVar = this.g.get(childAt);
            if (dpVar != null) {
                dpVar.a(childAt, f2, nanoTime2, this.ap);
            }
        }
        if (this.x) {
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dp dpVar = this.g.get(getChildAt(i));
            if (dpVar != null) {
                dpVar.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        if (this.T == -1) {
            this.T = getNanoTime();
        }
        float f2 = this.i;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f = -1;
        }
        if (this.af || (this.k && (z || this.j != this.i))) {
            float signum = Math.signum(this.j - this.i);
            long nanoTime = getNanoTime();
            float f3 = !(this.c instanceof ds) ? ((((float) (nanoTime - this.T)) * signum) * 1.0E-9f) / this.S : 0.0f;
            float f4 = this.i + f3;
            if (this.U) {
                f4 = this.j;
            }
            int i2 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i2 <= 0 || f4 < this.j) && (signum > 0.0f || f4 > this.j)) {
                z2 = false;
            } else {
                f4 = this.j;
                this.k = false;
                z2 = true;
            }
            this.i = f4;
            this.h = f4;
            this.T = nanoTime;
            Interpolator interpolator = this.c;
            if (interpolator != null && !z2) {
                if (this.ab) {
                    float interpolation = interpolator.getInterpolation(((float) (nanoTime - this.R)) * 1.0E-9f);
                    Interpolator interpolator2 = this.c;
                    cy cyVar = this.ac;
                    if (interpolator2 == cyVar) {
                        z3 = cyVar.b() ? true : true;
                    } else {
                        z3 = false;
                    }
                    this.i = interpolation;
                    this.T = nanoTime;
                    Interpolator interpolator3 = this.c;
                    if (interpolator3 instanceof ds) {
                        float a2 = ((ds) interpolator3).a();
                        this.e = a2;
                        if (Math.abs(a2) * this.S <= 1.0E-5f && z3) {
                            this.k = false;
                        }
                        if (a2 > 0.0f && interpolation >= 1.0f) {
                            this.i = 1.0f;
                            this.k = false;
                            interpolation = 1.0f;
                        }
                        if (a2 >= 0.0f || interpolation > 0.0f) {
                            f4 = interpolation;
                        } else {
                            this.i = 0.0f;
                            this.k = false;
                            f4 = 0.0f;
                        }
                    } else {
                        f4 = interpolation;
                    }
                } else {
                    float interpolation2 = interpolator.getInterpolation(f4);
                    Interpolator interpolator4 = this.c;
                    if (interpolator4 instanceof ds) {
                        this.e = ((ds) interpolator4).a();
                    } else {
                        this.e = ((interpolator4.getInterpolation(f4 + f3) - interpolation2) * signum) / f3;
                    }
                    f4 = interpolation2;
                    z3 = false;
                }
            } else {
                this.e = f3;
                z3 = false;
            }
            if (Math.abs(this.e) > 1.0E-5f) {
                setState(h.MOVING);
                z4 = true;
            } else {
                z4 = true;
            }
            if (z3 != z4) {
                if ((i2 > 0 && f4 >= this.j) || (signum <= 0.0f && f4 <= this.j)) {
                    f4 = this.j;
                    this.k = false;
                }
                if (f4 >= 1.0f || f4 <= 0.0f) {
                    this.k = false;
                    setState(h.FINISHED);
                }
            }
            int childCount = getChildCount();
            this.af = false;
            long nanoTime2 = getNanoTime();
            this.E = f4;
            Interpolator interpolator5 = this.d;
            float interpolation3 = interpolator5 == null ? f4 : interpolator5.getInterpolation(f4);
            Interpolator interpolator6 = this.d;
            if (interpolator6 != null) {
                this.e = interpolator6.getInterpolation((signum / this.S) + f4);
                this.e -= this.d.getInterpolation(f4);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                dp dpVar = this.g.get(childAt);
                if (dpVar != null) {
                    this.af = dpVar.a(childAt, interpolation3, nanoTime2, this.ap) | this.af;
                }
            }
            boolean z7 = (i2 > 0 && f4 >= this.j) || (signum <= 0.0f && f4 <= this.j);
            if (!this.af && !this.k && z7) {
                setState(h.FINISHED);
            }
            if (this.x) {
                requestLayout();
            }
            z5 = true;
            this.af = (!z7) | this.af;
            if (f4 > 0.0f || (i = this.M) == -1 || this.f == i) {
                z6 = false;
            } else {
                this.f = i;
                this.b.c(i).d(this);
                setState(h.FINISHED);
                z6 = true;
            }
            if (f4 >= 1.0d) {
                int i4 = this.f;
                int i5 = this.N;
                if (i4 != i5) {
                    this.f = i5;
                    this.b.c(i5).d(this);
                    setState(h.FINISHED);
                    z6 = true;
                }
            }
            if (this.af || this.k) {
                invalidate();
            } else if ((i2 > 0 && f4 == 1.0f) || (signum < 0.0f && f4 == 0.0f)) {
                setState(h.FINISHED);
            }
            if (!this.af && !this.k && ((i2 > 0 && f4 == 1.0f) || (signum < 0.0f && f4 == 0.0f))) {
                d();
            }
        } else {
            z6 = false;
            z5 = true;
        }
        float f5 = this.i;
        if (f5 >= 1.0f) {
            if (this.f != this.N) {
                z6 = z5;
            }
            this.f = this.N;
        } else if (f5 <= 0.0f) {
            if (this.f != this.M) {
                z6 = z5;
            }
            this.f = this.M;
        }
        this.az |= z6;
        if (z6 && !this.aq) {
            requestLayout();
        }
        this.h = this.i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.aq = true;
        try {
            if (this.b == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.p != i5 || this.q != i6) {
                f();
                b(true);
            }
            this.p = i5;
            this.q = i6;
            this.n = i5;
            this.o = i6;
        } finally {
            this.aq = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    public void setScene(dv dvVar) {
        this.b = dvVar;
        this.b.a(isRtl());
        f();
    }

    public void setDebugMode(int i) {
        this.l = i;
        invalidate();
    }

    private boolean a(View view, MotionEvent motionEvent, float f2, float f3) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f2, f3);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f2, -f3);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f2, f3);
        if (this.aC == null) {
            this.aC = new Matrix();
        }
        matrix.invert(this.aC);
        obtain.transform(this.aC);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private boolean a(float f2, float f3, View view, MotionEvent motionEvent) {
        boolean z;
        View childAt;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (a((childAt.getLeft() + f2) - view.getScrollX(), (childAt.getTop() + f3) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return z;
        }
        this.aA.set(f2, f3, (view.getRight() + f2) - view.getLeft(), (view.getBottom() + f3) - view.getTop());
        if ((motionEvent.getAction() != 0 || this.aA.contains(motionEvent.getX(), motionEvent.getY())) && a(view, motionEvent, -f2, -f3)) {
            return true;
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dw e2;
        int f2;
        RectF a2;
        dv dvVar = this.b;
        if (dvVar == null || !this.Q) {
            return false;
        }
        if (dvVar.c != null) {
            this.b.c.a(motionEvent);
        }
        dv.a aVar = this.b.b;
        if (aVar != null && aVar.f() && (e2 = aVar.e()) != null && ((motionEvent.getAction() != 0 || (a2 = e2.a(this, new RectF())) == null || a2.contains(motionEvent.getX(), motionEvent.getY())) && (f2 = e2.f()) != -1)) {
            View view = this.aB;
            if (view == null || view.getId() != f2) {
                this.aB = findViewById(f2);
            }
            View view2 = this.aB;
            if (view2 != null) {
                this.aA.set(view2.getLeft(), this.aB.getTop(), this.aB.getRight(), this.aB.getBottom());
                if (this.aA.contains(motionEvent.getX(), motionEvent.getY()) && !a(this.aB.getLeft(), this.aB.getTop(), this.aB, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        dv dvVar = this.b;
        if (dvVar != null && this.Q && dvVar.c()) {
            dv.a aVar = this.b.b;
            if (aVar != null && !aVar.f()) {
                return super.onTouchEvent(motionEvent);
            }
            this.b.a(motionEvent, getCurrentState(), this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i;
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            this.ax = display.getRotation();
        }
        dv dvVar = this.b;
        if (dvVar != null && (i = this.f) != -1) {
            androidx.constraintlayout.widget.e c2 = dvVar.c(i);
            this.b.a(this);
            ArrayList<dq> arrayList = this.ai;
            if (arrayList != null) {
                Iterator<dq> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().a(this);
                }
            }
            if (c2 != null) {
                c2.c(this);
            }
            this.M = this.f;
        }
        d();
        f fVar = this.ar;
        if (fVar != null) {
            if (this.ay) {
                post(new Runnable() { // from class: dt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        dt.this.ar.a();
                    }
                });
                return;
            } else {
                fVar.a();
                return;
            }
        }
        dv dvVar2 = this.b;
        if (dvVar2 == null || dvVar2.b == null || this.b.b.b() != 4) {
            return;
        }
        c();
        setState(h.SETUP);
        setState(h.MOVING);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        dv dvVar = this.b;
        if (dvVar != null) {
            dvVar.a(isRtl());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        dv dvVar = this.b;
        if (dvVar == null) {
            return;
        }
        if (dvVar.b(this, this.f)) {
            requestLayout();
            return;
        }
        int i = this.f;
        if (i != -1) {
            this.b.a(this, i);
        }
        if (this.b.c()) {
            this.b.r();
        }
    }

    public int getCurrentState() {
        return this.f;
    }

    public float getProgress() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f2, float f3, float f4, float[] fArr) {
        String resourceName;
        HashMap<View, dp> hashMap = this.g;
        View viewById = getViewById(i);
        dp dpVar = hashMap.get(viewById);
        if (dpVar != null) {
            dpVar.a(f2, f3, f4, fArr);
            float y = viewById.getY();
            float f5 = this.aa;
            int i2 = ((f2 - this.W) > 0.0f ? 1 : ((f2 - this.W) == 0.0f ? 0 : -1));
            this.W = f2;
            this.aa = y;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    public long getTransitionTimeMs() {
        dv dvVar = this.b;
        if (dvVar != null) {
            this.S = dvVar.g() / 1000.0f;
        }
        return this.S * 1000.0f;
    }

    public void setTransitionListener(g gVar) {
        this.V = gVar;
    }

    public void a(int i, boolean z, float f2) {
        g gVar = this.V;
        if (gVar != null) {
            gVar.a(this, i, z, f2);
        }
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.aj;
        if (copyOnWriteArrayList != null) {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this, i, z, f2);
            }
        }
    }

    private void l() {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        if ((this.V == null && ((copyOnWriteArrayList = this.aj) == null || copyOnWriteArrayList.isEmpty())) || this.ao == this.h) {
            return;
        }
        if (this.an != -1) {
            g gVar = this.V;
            if (gVar != null) {
                gVar.a(this, this.M, this.N);
            }
            CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.aj;
            if (copyOnWriteArrayList2 != null) {
                Iterator<g> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.M, this.N);
                }
            }
            this.w = true;
        }
        this.an = -1;
        float f2 = this.h;
        this.ao = f2;
        g gVar2 = this.V;
        if (gVar2 != null) {
            gVar2.a(this, this.M, this.N, f2);
        }
        CopyOnWriteArrayList<g> copyOnWriteArrayList3 = this.aj;
        if (copyOnWriteArrayList3 != null) {
            Iterator<g> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.M, this.N, this.h);
            }
        }
        this.w = true;
    }

    protected void e() {
        int i;
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        if ((this.V != null || ((copyOnWriteArrayList = this.aj) != null && !copyOnWriteArrayList.isEmpty())) && this.an == -1) {
            this.an = this.f;
            if (this.L.isEmpty()) {
                i = -1;
            } else {
                ArrayList<Integer> arrayList = this.L;
                i = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i2 = this.f;
            if (i != i2 && i2 != -1) {
                this.L.add(Integer.valueOf(i2));
            }
        }
        m();
        Runnable runnable = this.as;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.at;
        if (iArr == null || this.F <= 0) {
            return;
        }
        b(iArr[0]);
        int[] iArr2 = this.at;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.F--;
    }

    private void m() {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        if (this.V == null && ((copyOnWriteArrayList = this.aj) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.w = false;
        Iterator<Integer> it = this.L.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            g gVar = this.V;
            if (gVar != null) {
                gVar.a(this, next.intValue());
            }
            CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.aj;
            if (copyOnWriteArrayList2 != null) {
                Iterator<g> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, next.intValue());
                }
            }
        }
        this.L.clear();
    }

    public de getDesignTool() {
        if (this.ae == null) {
            this.ae = new de(this);
        }
        return this.ae;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof dq) {
            dq dqVar = (dq) view;
            if (this.aj == null) {
                this.aj = new CopyOnWriteArrayList<>();
            }
            this.aj.add(dqVar);
            if (dqVar.a()) {
                if (this.ag == null) {
                    this.ag = new ArrayList<>();
                }
                this.ag.add(dqVar);
            }
            if (dqVar.b()) {
                if (this.ah == null) {
                    this.ah = new ArrayList<>();
                }
                this.ah.add(dqVar);
            }
            if (dqVar.c()) {
                if (this.ai == null) {
                    this.ai = new ArrayList<>();
                }
                this.ai.add(dqVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<dq> arrayList = this.ag;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<dq> arrayList2 = this.ah;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void setOnShow(float f2) {
        ArrayList<dq> arrayList = this.ag;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.ag.get(i).setProgress(f2);
            }
        }
    }

    public void setOnHide(float f2) {
        ArrayList<dq> arrayList = this.ah;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.ah.get(i).setProgress(f2);
            }
        }
    }

    public int[] getConstraintSetIds() {
        dv dvVar = this.b;
        if (dvVar == null) {
            return null;
        }
        return dvVar.b();
    }

    public androidx.constraintlayout.widget.e c(int i) {
        dv dvVar = this.b;
        if (dvVar == null) {
            return null;
        }
        return dvVar.c(i);
    }

    public void f() {
        this.K.a();
        invalidate();
    }

    public void a(int i, androidx.constraintlayout.widget.e eVar) {
        dv dvVar = this.b;
        if (dvVar != null) {
            dvVar.a(i, eVar);
        }
        g();
        if (this.f == i) {
            eVar.c(this);
        }
    }

    public void g() {
        this.K.a(this.mLayoutWidget, this.b.c(this.M), this.b.c(this.N));
        f();
    }

    public ArrayList<dv.a> getDefinedTransitions() {
        dv dvVar = this.b;
        if (dvVar == null) {
            return null;
        }
        return dvVar.a();
    }

    public int getStartState() {
        return this.M;
    }

    public int getEndState() {
        return this.N;
    }

    public float getTargetPosition() {
        return this.j;
    }

    public void setTransitionDuration(int i) {
        dv dvVar = this.b;
        if (dvVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            dvVar.d(i);
        }
    }

    public dv.a d(int i) {
        return this.b.b(i);
    }

    public void setInteractionEnabled(boolean z) {
        this.Q = z;
    }

    public boolean h() {
        return this.Q;
    }

    public void a(int i, View... viewArr) {
        dv dvVar = this.b;
        if (dvVar != null) {
            dvVar.a(i, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.ay = z;
    }
}
