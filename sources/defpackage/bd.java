package defpackage;

import java.util.Arrays;
import java.util.HashSet;
/* compiled from: SolverVariable.java */
/* renamed from: bd  reason: default package */
/* loaded from: classes.dex */
public class bd implements Comparable<bd> {
    private static int q = 1;
    private static int r = 1;
    private static int s = 1;
    private static int t = 1;
    private static int u = 1;
    public boolean a;
    public float e;
    a i;
    private String v;
    public int b = -1;
    int c = -1;
    public int d = 0;
    public boolean f = false;
    float[] g = new float[9];
    float[] h = new float[9];
    ax[] j = new ax[16];
    int k = 0;
    public int l = 0;
    boolean m = false;
    int n = -1;
    float o = 0.0f;
    HashSet<ax> p = null;

    /* compiled from: SolverVariable.java */
    /* renamed from: bd$a */
    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        r++;
    }

    public bd(a aVar, String str) {
        this.i = aVar;
    }

    public final void a(ax axVar) {
        int i = 0;
        while (true) {
            int i2 = this.k;
            if (i < i2) {
                if (this.j[i] == axVar) {
                    return;
                }
                i++;
            } else {
                ax[] axVarArr = this.j;
                if (i2 >= axVarArr.length) {
                    this.j = (ax[]) Arrays.copyOf(axVarArr, axVarArr.length * 2);
                }
                ax[] axVarArr2 = this.j;
                int i3 = this.k;
                axVarArr2[i3] = axVar;
                this.k = i3 + 1;
                return;
            }
        }
    }

    public final void b(ax axVar) {
        int i = this.k;
        int i2 = 0;
        while (i2 < i) {
            if (this.j[i2] == axVar) {
                while (i2 < i - 1) {
                    ax[] axVarArr = this.j;
                    int i3 = i2 + 1;
                    axVarArr[i2] = axVarArr[i3];
                    i2 = i3;
                }
                this.k--;
                return;
            }
            i2++;
        }
    }

    public final void a(az azVar, ax axVar) {
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2].a(azVar, axVar, false);
        }
        this.k = 0;
    }

    public void a(az azVar, float f) {
        this.e = f;
        this.f = true;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int i = this.k;
        this.c = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2].a(azVar, this, false);
        }
        this.k = 0;
    }

    public void b() {
        this.v = null;
        this.i = a.UNKNOWN;
        this.d = 0;
        this.b = -1;
        this.c = -1;
        this.e = 0.0f;
        this.f = false;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2] = null;
        }
        this.k = 0;
        this.l = 0;
        this.a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public void a(a aVar, String str) {
        this.i = aVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(bd bdVar) {
        return this.b - bdVar.b;
    }

    public String toString() {
        if (this.v != null) {
            return "" + this.v;
        }
        return "" + this.b;
    }
}
