package defpackage;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.xiaopeng.libtheme.ThemeManager;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewTimeCycle.java */
/* renamed from: dc  reason: default package */
/* loaded from: classes.dex */
public abstract class dc extends bt {
    public abstract boolean a(View view, float f2, long j2, bi biVar);

    public float a(float f2, long j2, View view, bi biVar) {
        this.a.a(f2, this.g);
        float f3 = this.g[1];
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        boolean z = false;
        if (i2 == 0) {
            this.i = false;
            return this.g[2];
        }
        if (Float.isNaN(this.k)) {
            this.k = biVar.a(view, this.f, 0);
            if (Float.isNaN(this.k)) {
                this.k = 0.0f;
            }
        }
        this.k = (float) ((this.k + (((j2 - this.j) * 1.0E-9d) * f3)) % 1.0d);
        biVar.a(view, this.f, 0, this.k);
        this.j = j2;
        float f4 = this.g[0];
        float a2 = (a(this.k) * f4) + this.g[2];
        this.i = (f4 == 0.0f && i2 == 0) ? true : true;
        return a2;
    }

    public static dc a(String str, SparseArray<androidx.constraintlayout.widget.b> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static dc a(String str, long j2) {
        char c2;
        dc aVar;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 92909918:
                if (str.equals(ThemeManager.AttributeSet.ALPHA)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                aVar = new a();
                break;
            case 1:
                aVar = new c();
                break;
            case 2:
                aVar = new f();
                break;
            case 3:
                aVar = new g();
                break;
            case 4:
                aVar = new h();
                break;
            case 5:
                aVar = new d();
                break;
            case 6:
                aVar = new i();
                break;
            case 7:
                aVar = new j();
                break;
            case '\b':
                aVar = new k();
                break;
            case '\t':
                aVar = new l();
                break;
            case '\n':
                aVar = new m();
                break;
            case 11:
                aVar = new e();
                break;
            default:
                return null;
        }
        aVar.a(j2);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$c */
    /* loaded from: classes.dex */
    public static class c extends dc {
        c() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f, j, view, biVar));
            }
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$a */
    /* loaded from: classes.dex */
    public static class a extends dc {
        a() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setAlpha(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$f */
    /* loaded from: classes.dex */
    public static class f extends dc {
        f() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setRotation(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$g */
    /* loaded from: classes.dex */
    public static class g extends dc {
        g() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setRotationX(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$h */
    /* loaded from: classes.dex */
    public static class h extends dc {
        h() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setRotationY(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$d */
    /* loaded from: classes.dex */
    public static class d extends dc {
        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            return this.i;
        }

        public boolean a(View view, bi biVar, float f, long j, double d, double d2) {
            view.setRotation(a(f, j, view, biVar) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$i */
    /* loaded from: classes.dex */
    public static class i extends dc {
        i() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setScaleX(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$j */
    /* loaded from: classes.dex */
    public static class j extends dc {
        j() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setScaleY(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$k */
    /* loaded from: classes.dex */
    public static class k extends dc {
        k() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setTranslationX(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$l */
    /* loaded from: classes.dex */
    public static class l extends dc {
        l() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            view.setTranslationY(a(f, j, view, biVar));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$m */
    /* loaded from: classes.dex */
    public static class m extends dc {
        m() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f, j, view, biVar));
            }
            return this.i;
        }
    }

    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$b */
    /* loaded from: classes.dex */
    public static class b extends dc {
        String l;
        SparseArray<androidx.constraintlayout.widget.b> m;
        SparseArray<float[]> n = new SparseArray<>();
        float[] o;
        float[] p;

        public b(String str, SparseArray<androidx.constraintlayout.widget.b> sparseArray) {
            this.l = str.split(",")[1];
            this.m = sparseArray;
        }

        @Override // defpackage.bt
        public void a(int i) {
            float[] fArr;
            int size = this.m.size();
            int c = this.m.valueAt(0).c();
            double[] dArr = new double[size];
            int i2 = c + 2;
            this.o = new float[i2];
            this.p = new float[c];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.m.keyAt(i3);
                float[] valueAt = this.n.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                this.m.valueAt(i3).a(this.o);
                int i4 = 0;
                while (true) {
                    if (i4 < this.o.length) {
                        dArr2[i3][i4] = fArr[i4];
                        i4++;
                    }
                }
                dArr2[i3][c] = valueAt[0];
                dArr2[i3][c + 1] = valueAt[1];
            }
            this.a = bg.a(i, dArr, dArr2);
        }

        @Override // defpackage.bt
        public void a(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void a(int i, androidx.constraintlayout.widget.b bVar, float f, int i2, float f2) {
            this.m.append(i, bVar);
            this.n.append(i, new float[]{f, f2});
            this.b = Math.max(this.b, i2);
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            this.a.a(f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.j;
            if (Float.isNaN(this.k)) {
                this.k = biVar.a(view, this.l, 0);
                if (Float.isNaN(this.k)) {
                    this.k = 0.0f;
                }
            }
            this.k = (float) ((this.k + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.j = j;
            float a = a(this.k);
            this.i = false;
            for (int i = 0; i < this.p.length; i++) {
                this.i |= ((double) this.o[i]) != 0.0d;
                this.p[i] = (this.o[i] * a) + f3;
            }
            this.m.valueAt(0).a(view, this.p);
            if (f2 != 0.0f) {
                this.i = true;
            }
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTimeCycle.java */
    /* renamed from: dc$e */
    /* loaded from: classes.dex */
    public static class e extends dc {
        boolean l = false;

        e() {
        }

        @Override // defpackage.dc
        public boolean a(View view, float f, long j, bi biVar) {
            if (view instanceof dt) {
                ((dt) view).setProgress(a(f, j, view, biVar));
            } else if (this.l) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.l = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(a(f, j, view, biVar)));
                    } catch (IllegalAccessException e) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e2);
                    }
                }
            }
            return this.i;
        }
    }
}
