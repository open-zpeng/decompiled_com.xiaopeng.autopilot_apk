package defpackage;

import defpackage.bz;
import java.util.ArrayList;
/* compiled from: ChainHead.java */
/* renamed from: bx  reason: default package */
/* loaded from: classes.dex */
public class bx {
    protected bz a;
    protected bz b;
    protected bz c;
    protected bz d;
    protected bz e;
    protected bz f;
    protected bz g;
    protected ArrayList<bz> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    private int t;
    private boolean u;
    private boolean v;

    public bx(bz bzVar, int i, boolean z) {
        this.u = false;
        this.a = bzVar;
        this.t = i;
        this.u = z;
    }

    private static boolean a(bz bzVar, int i) {
        return bzVar.B() != 8 && bzVar.J[i] == bz.a.MATCH_CONSTRAINT && (bzVar.o[i] == 0 || bzVar.o[i] == 3);
    }

    private void b() {
        int i = this.t * 2;
        bz bzVar = this.a;
        boolean z = true;
        this.o = true;
        bz bzVar2 = bzVar;
        bz bzVar3 = bzVar2;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            bz bzVar4 = null;
            bzVar2.as[this.t] = null;
            bzVar2.ar[this.t] = null;
            if (bzVar2.B() != 8) {
                this.l++;
                if (bzVar2.x(this.t) != bz.a.MATCH_CONSTRAINT) {
                    this.m += bzVar2.m(this.t);
                }
                this.m += bzVar2.H[i].j();
                int i2 = i + 1;
                this.m += bzVar2.H[i2].j();
                this.n += bzVar2.H[i].j();
                this.n += bzVar2.H[i2].j();
                if (this.b == null) {
                    this.b = bzVar2;
                }
                this.d = bzVar2;
                if (bzVar2.J[this.t] == bz.a.MATCH_CONSTRAINT) {
                    if (bzVar2.o[this.t] == 0 || bzVar2.o[this.t] == 3 || bzVar2.o[this.t] == 2) {
                        this.j++;
                        float f = bzVar2.aq[this.t];
                        if (f > 0.0f) {
                            this.k += bzVar2.aq[this.t];
                        }
                        if (a(bzVar2, this.t)) {
                            if (f < 0.0f) {
                                this.p = true;
                            } else {
                                this.q = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(bzVar2);
                        }
                        if (this.f == null) {
                            this.f = bzVar2;
                        }
                        bz bzVar5 = this.g;
                        if (bzVar5 != null) {
                            bzVar5.ar[this.t] = bzVar2;
                        }
                        this.g = bzVar2;
                    }
                    if (this.t == 0) {
                        if (bzVar2.m != 0) {
                            this.o = false;
                        } else if (bzVar2.p != 0 || bzVar2.q != 0) {
                            this.o = false;
                        }
                    } else if (bzVar2.n != 0) {
                        this.o = false;
                    } else if (bzVar2.s != 0 || bzVar2.t != 0) {
                        this.o = false;
                    }
                    if (bzVar2.N != 0.0f) {
                        this.o = false;
                        this.s = true;
                    }
                }
            }
            if (bzVar3 != bzVar2) {
                bzVar3.as[this.t] = bzVar2;
            }
            by byVar = bzVar2.H[i + 1].c;
            if (byVar != null) {
                bz bzVar6 = byVar.a;
                if (bzVar6.H[i].c != null && bzVar6.H[i].c.a == bzVar2) {
                    bzVar4 = bzVar6;
                }
            }
            if (bzVar4 == null) {
                z2 = true;
                bzVar4 = bzVar2;
            }
            bzVar3 = bzVar2;
            bzVar2 = bzVar4;
        }
        bz bzVar7 = this.b;
        if (bzVar7 != null) {
            this.m -= bzVar7.H[i].j();
        }
        bz bzVar8 = this.d;
        if (bzVar8 != null) {
            this.m -= bzVar8.H[i + 1].j();
        }
        this.c = bzVar2;
        if (this.t == 0 && this.u) {
            this.e = this.c;
        } else {
            this.e = this.a;
        }
        if (!this.q || !this.p) {
            z = false;
        }
        this.r = z;
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }
}
