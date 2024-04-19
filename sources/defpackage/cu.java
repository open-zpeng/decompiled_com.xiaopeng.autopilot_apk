package defpackage;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RunGroup.java */
/* renamed from: cu  reason: default package */
/* loaded from: classes.dex */
public class cu {
    public static int a;
    cx d;
    cx e;
    int g;
    int h;
    public int b = 0;
    public boolean c = false;
    ArrayList<cx> f = new ArrayList<>();

    public cu(cx cxVar, int i) {
        this.d = null;
        this.e = null;
        this.g = 0;
        int i2 = a;
        this.g = i2;
        a = i2 + 1;
        this.d = cxVar;
        this.e = cxVar;
        this.h = i;
    }

    public void a(cx cxVar) {
        this.f.add(cxVar);
        this.e = cxVar;
    }

    private long a(cn cnVar, long j) {
        cx cxVar = cnVar.d;
        if (cxVar instanceof cs) {
            return j;
        }
        int size = cnVar.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            cl clVar = cnVar.k.get(i);
            if (clVar instanceof cn) {
                cn cnVar2 = (cn) clVar;
                if (cnVar2.d != cxVar) {
                    j2 = Math.max(j2, a(cnVar2, cnVar2.f + j));
                }
            }
        }
        if (cnVar == cxVar.j) {
            long b = j + cxVar.b();
            return Math.max(Math.max(j2, a(cxVar.k, b)), b - cxVar.k.f);
        }
        return j2;
    }

    private long b(cn cnVar, long j) {
        cx cxVar = cnVar.d;
        if (cxVar instanceof cs) {
            return j;
        }
        int size = cnVar.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            cl clVar = cnVar.k.get(i);
            if (clVar instanceof cn) {
                cn cnVar2 = (cn) clVar;
                if (cnVar2.d != cxVar) {
                    j2 = Math.min(j2, b(cnVar2, cnVar2.f + j));
                }
            }
        }
        if (cnVar == cxVar.k) {
            long b = j - cxVar.b();
            return Math.min(Math.min(j2, b(cxVar.j, b)), b - cxVar.j.f);
        }
        return j2;
    }

    public long a(ca caVar, int i) {
        cx cxVar = this.d;
        if (cxVar instanceof ck) {
            if (((ck) cxVar).h != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(cxVar instanceof ct)) {
                return 0L;
            }
        } else if (!(cxVar instanceof cv)) {
            return 0L;
        }
        cn cnVar = i == 0 ? caVar.f.j : caVar.g.j;
        cn cnVar2 = i == 0 ? caVar.f.k : caVar.g.k;
        boolean contains = this.d.j.l.contains(cnVar);
        boolean contains2 = this.d.k.l.contains(cnVar2);
        long b = this.d.b();
        if (!contains || !contains2) {
            if (contains) {
                return Math.max(a(this.d.j, this.d.j.f), this.d.j.f + b);
            }
            if (contains2) {
                return Math.max(-b(this.d.k, this.d.k.f), (-this.d.k.f) + b);
            }
            return (this.d.j.f + this.d.b()) - this.d.k.f;
        }
        long a2 = a(this.d.j, 0L);
        long b2 = b(this.d.k, 0L);
        long j = a2 - b;
        if (j >= (-this.d.k.f)) {
            j += this.d.k.f;
        }
        long j2 = ((-b2) - b) - this.d.j.f;
        if (j2 >= this.d.j.f) {
            j2 -= this.d.j.f;
        }
        float n = this.d.d.n(i);
        float f = (float) (n > 0.0f ? (((float) j2) / n) + (((float) j) / (1.0f - n)) : 0L);
        return (this.d.j.f + ((((f * n) + 0.5f) + b) + ((f * (1.0f - n)) + 0.5f))) - this.d.k.f;
    }
}
