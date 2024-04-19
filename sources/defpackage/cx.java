package defpackage;

import defpackage.bz;
/* compiled from: WidgetRun.java */
/* renamed from: cx  reason: default package */
/* loaded from: classes.dex */
public abstract class cx implements cl {
    public int c;
    bz d;
    cu e;
    protected bz.a f;
    co g = new co(this);
    public int h = 0;
    boolean i = false;
    public cn j = new cn(this);
    public cn k = new cn(this);
    protected a l = a.NONE;

    /* compiled from: WidgetRun.java */
    /* renamed from: cx$a */
    /* loaded from: classes.dex */
    enum a {
        NONE,
        START,
        END,
        CENTER
    }

    @Override // defpackage.cl
    public void a(cl clVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(cl clVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(cl clVar) {
    }

    abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    public cx(bz bzVar) {
        this.d = bzVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final cn a(by byVar) {
        if (byVar.c == null) {
            return null;
        }
        bz bzVar = byVar.c.a;
        switch (byVar.c.b) {
            case LEFT:
                return bzVar.f.j;
            case RIGHT:
                return bzVar.f.k;
            case TOP:
                return bzVar.g.j;
            case BASELINE:
                return bzVar.g.a;
            case BOTTOM:
                return bzVar.g.k;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cl clVar, by byVar, by byVar2, int i) {
        float O;
        cn a2 = a(byVar);
        cn a3 = a(byVar2);
        if (a2.j && a3.j) {
            int j = a2.g + byVar.j();
            int j2 = a3.g - byVar2.j();
            int i2 = j2 - j;
            if (!this.g.j && this.f == bz.a.MATCH_CONSTRAINT) {
                b(i, i2);
            }
            if (this.g.j) {
                if (this.g.g == i2) {
                    this.j.a(j);
                    this.k.a(j2);
                    return;
                }
                if (i == 0) {
                    O = this.d.N();
                } else {
                    O = this.d.O();
                }
                if (a2 == a3) {
                    j = a2.g;
                    j2 = a3.g;
                    O = 0.5f;
                }
                this.j.a((int) (j + 0.5f + (((j2 - j) - this.g.g) * O)));
                this.k.a(this.j.g + this.g.g);
            }
        }
    }

    private void b(int i, int i2) {
        int i3;
        switch (this.c) {
            case 0:
                this.g.a(a(i2, i));
                return;
            case 1:
                this.g.a(Math.min(a(this.g.m, i), i2));
                return;
            case 2:
                bz A = this.d.A();
                if (A != null) {
                    cx cxVar = i == 0 ? A.f : A.g;
                    if (cxVar.g.j) {
                        this.g.a(a((int) ((cxVar.g.g * (i == 0 ? this.d.r : this.d.u)) + 0.5f), i));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (this.d.f.f == bz.a.MATCH_CONSTRAINT && this.d.f.c == 3 && this.d.g.f == bz.a.MATCH_CONSTRAINT && this.d.g.c == 3) {
                    return;
                }
                cx cxVar2 = i == 0 ? this.d.g : this.d.f;
                if (cxVar2.g.j) {
                    float S = this.d.S();
                    if (i == 1) {
                        i3 = (int) ((cxVar2.g.g / S) + 0.5f);
                    } else {
                        i3 = (int) ((S * cxVar2.g.g) + 0.5f);
                    }
                    this.g.a(i3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i, int i2) {
        if (i2 == 0) {
            int i3 = this.d.q;
            int max = Math.max(this.d.p, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            return max != i ? max : i;
        }
        int i4 = this.d.t;
        int min = i4 > 0 ? Math.min(i4, i) : Math.max(this.d.s, i);
        return min != i ? min : i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final cn a(by byVar, int i) {
        if (byVar.c == null) {
            return null;
        }
        bz bzVar = byVar.c.a;
        cx cxVar = i == 0 ? bzVar.f : bzVar.g;
        int i2 = AnonymousClass1.a[byVar.c.b.ordinal()];
        if (i2 != 5) {
            switch (i2) {
                case 1:
                case 3:
                    return cxVar.j;
                case 2:
                    break;
                default:
                    return null;
            }
        }
        return cxVar.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(cn cnVar, cn cnVar2, int i) {
        cnVar.l.add(cnVar2);
        cnVar.f = i;
        cnVar2.k.add(cnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(cn cnVar, cn cnVar2, int i, co coVar) {
        cnVar.l.add(cnVar2);
        cnVar.l.add(this.g);
        cnVar.h = i;
        cnVar.i = coVar;
        cnVar2.k.add(cnVar);
        coVar.k.add(cnVar);
    }

    public long b() {
        if (this.g.j) {
            return this.g.g;
        }
        return 0L;
    }

    public boolean g() {
        return this.i;
    }
}
