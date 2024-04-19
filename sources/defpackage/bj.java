package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* compiled from: KeyCycleOscillator.java */
/* renamed from: bj  reason: default package */
/* loaded from: classes.dex */
public abstract class bj {
    private bg c;
    private a d;
    private String e;
    private int f = 0;
    private String g = null;
    public int a = 0;
    ArrayList<b> b = new ArrayList<>();

    protected void a(Object obj) {
    }

    public boolean a() {
        return this.a == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeyCycleOscillator.java */
    /* renamed from: bj$b */
    /* loaded from: classes.dex */
    public static class b {
        int a;
        float b;
        float c;
        float d;
        float e;

        public b(int i, float f, float f2, float f3, float f4) {
            this.a = i;
            this.b = f4;
            this.c = f2;
            this.d = f;
            this.e = f3;
        }
    }

    public String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            str = str + "[" + next.a + " , " + decimalFormat.format(next.b) + "] ";
        }
        return str;
    }

    public void a(String str) {
        this.e = str;
    }

    public float a(float f) {
        return (float) this.d.a(f);
    }

    public void a(int i, int i2, String str, int i3, float f, float f2, float f3, float f4, Object obj) {
        int i4;
        this.b.add(new b(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.a = i3;
            i4 = i2;
        } else {
            i4 = i2;
        }
        this.f = i4;
        a(obj);
        this.g = str;
    }

    public void a(int i, int i2, String str, int i3, float f, float f2, float f3, float f4) {
        int i4;
        this.b.add(new b(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.a = i3;
            i4 = i2;
        } else {
            i4 = i2;
        }
        this.f = i4;
        this.g = str;
    }

    public void b(float f) {
        int size = this.b.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.b, new Comparator<b>() { // from class: bj.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                return Integer.compare(bVar.a, bVar2.a);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, 3);
        this.d = new a(this.f, this.g, this.a, size);
        Iterator<b> it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            b next = it.next();
            dArr[i] = next.d * 0.01d;
            dArr2[i][0] = next.b;
            dArr2[i][1] = next.c;
            dArr2[i][2] = next.e;
            this.d.a(i, next.a, next.d, next.c, next.e, next.b);
            i++;
        }
        this.d.b(f);
        this.c = bg.a(0, dArr, dArr2);
    }

    /* compiled from: KeyCycleOscillator.java */
    /* renamed from: bj$a */
    /* loaded from: classes.dex */
    static class a {
        float[] b;
        double[] c;
        float[] d;
        float[] e;
        float[] f;
        float[] g;
        int h;
        bg i;
        double[] j;
        double[] k;
        float l;
        private final int m;
        bm a = new bm();
        private final int n = 0;
        private final int o = 1;
        private final int p = 2;

        a(int i, String str, int i2, int i3) {
            this.h = i;
            this.m = i2;
            this.a.a(i, str);
            this.b = new float[i3];
            this.c = new double[i3];
            this.d = new float[i3];
            this.e = new float[i3];
            this.f = new float[i3];
            this.g = new float[i3];
        }

        public double a(float f) {
            bg bgVar = this.i;
            if (bgVar != null) {
                bgVar.a(f, this.j);
            } else {
                double[] dArr = this.j;
                dArr[0] = this.e[0];
                dArr[1] = this.f[0];
                dArr[2] = this.b[0];
            }
            double[] dArr2 = this.j;
            return dArr2[0] + (this.a.a(f, dArr2[1]) * this.j[2]);
        }

        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            this.c[i] = i2 / 100.0d;
            this.d[i] = f;
            this.e[i] = f2;
            this.f[i] = f3;
            this.b[i] = f4;
        }

        public void b(float f) {
            this.l = f;
            double[][] dArr = (double[][]) Array.newInstance(double.class, this.c.length, 3);
            float[] fArr = this.b;
            this.j = new double[fArr.length + 2];
            this.k = new double[fArr.length + 2];
            if (this.c[0] > 0.0d) {
                this.a.a(0.0d, this.d[0]);
            }
            double[] dArr2 = this.c;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.a.a(1.0d, this.d[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                dArr[i][0] = this.e[i];
                dArr[i][1] = this.f[i];
                dArr[i][2] = this.b[i];
                this.a.a(this.c[i], this.d[i]);
            }
            this.a.a();
            double[] dArr3 = this.c;
            if (dArr3.length > 1) {
                this.i = bg.a(0, dArr3, dArr);
            } else {
                this.i = null;
            }
        }
    }
}
