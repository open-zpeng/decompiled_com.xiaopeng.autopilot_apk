package defpackage;

import defpackage.by;
import defpackage.bz;
import defpackage.cn;
import defpackage.cx;
/* compiled from: VerticalWidgetRun.java */
/* renamed from: cv  reason: default package */
/* loaded from: classes.dex */
public class cv extends cx {
    public cn a;
    co b;

    public cv(bz bzVar) {
        super(bzVar);
        this.a = new cn(this);
        this.b = null;
        this.j.e = cn.a.TOP;
        this.k.e = cn.a.BOTTOM;
        this.a.e = cn.a.BASELINE;
        this.h = 1;
    }

    public String toString() {
        return "VerticalRun " + this.d.C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void c() {
        this.e = null;
        this.j.a();
        this.k.a();
        this.a.a();
        this.g.a();
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void d() {
        this.i = false;
        this.j.a();
        this.j.j = false;
        this.k.a();
        this.k.j = false;
        this.a.a();
        this.a.j = false;
        this.g.j = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public boolean a() {
        return this.f != bz.a.MATCH_CONSTRAINT || this.d.n == 0;
    }

    @Override // defpackage.cx, defpackage.cl
    public void a(cl clVar) {
        int S;
        switch (this.l) {
            case START:
                b(clVar);
                break;
            case END:
                c(clVar);
                break;
            case CENTER:
                a(clVar, this.d.A, this.d.C, 1);
                return;
        }
        if (this.g.c && !this.g.j && this.f == bz.a.MATCH_CONSTRAINT) {
            switch (this.d.n) {
                case 2:
                    bz A = this.d.A();
                    if (A != null && A.g.g.j) {
                        this.g.a((int) ((A.g.g.g * this.d.u) + 0.5f));
                        break;
                    }
                    break;
                case 3:
                    if (this.d.f.g.j) {
                        switch (this.d.T()) {
                            case -1:
                                S = (int) ((this.d.f.g.g / this.d.S()) + 0.5f);
                                break;
                            case 0:
                                S = (int) ((this.d.f.g.g * this.d.S()) + 0.5f);
                                break;
                            case 1:
                                S = (int) ((this.d.f.g.g / this.d.S()) + 0.5f);
                                break;
                            default:
                                S = 0;
                                break;
                        }
                        this.g.a(S);
                        break;
                    }
                    break;
            }
        }
        if (this.j.c && this.k.c) {
            if (this.j.j && this.k.j && this.g.j) {
                return;
            }
            if (!this.g.j && this.f == bz.a.MATCH_CONSTRAINT && this.d.m == 0 && !this.d.aa()) {
                int i = this.j.l.get(0).g + this.j.f;
                int i2 = this.k.l.get(0).g + this.k.f;
                this.j.a(i);
                this.k.a(i2);
                this.g.a(i2 - i);
                return;
            }
            if (!this.g.j && this.f == bz.a.MATCH_CONSTRAINT && this.c == 1 && this.j.l.size() > 0 && this.k.l.size() > 0) {
                int i3 = (this.k.l.get(0).g + this.k.f) - (this.j.l.get(0).g + this.j.f);
                if (i3 < this.g.m) {
                    this.g.a(i3);
                } else {
                    this.g.a(this.g.m);
                }
            }
            if (this.g.j && this.j.l.size() > 0 && this.k.l.size() > 0) {
                cn cnVar = this.j.l.get(0);
                cn cnVar2 = this.k.l.get(0);
                int i4 = cnVar.g + this.j.f;
                int i5 = cnVar2.g + this.k.f;
                float O = this.d.O();
                if (cnVar == cnVar2) {
                    i4 = cnVar.g;
                    i5 = cnVar2.g;
                    O = 0.5f;
                }
                this.j.a((int) (i4 + 0.5f + (((i5 - i4) - this.g.g) * O)));
                this.k.a(this.j.g + this.g.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void f() {
        bz A;
        bz A2;
        if (this.d.b) {
            this.g.a(this.d.G());
        }
        if (!this.g.j) {
            this.f = this.d.Y();
            if (this.d.P()) {
                this.b = new ci(this);
            }
            if (this.f != bz.a.MATCH_CONSTRAINT) {
                if (this.f == bz.a.MATCH_PARENT && (A2 = this.d.A()) != null && A2.Y() == bz.a.FIXED) {
                    int G = (A2.G() - this.d.A.j()) - this.d.C.j();
                    a(this.j, A2.g.j, this.d.A.j());
                    a(this.k, A2.g.k, -this.d.C.j());
                    this.g.a(G);
                    return;
                } else if (this.f == bz.a.FIXED) {
                    this.g.a(this.d.G());
                }
            }
        } else if (this.f == bz.a.MATCH_PARENT && (A = this.d.A()) != null && A.Y() == bz.a.FIXED) {
            a(this.j, A.g.j, this.d.A.j());
            a(this.k, A.g.k, -this.d.C.j());
            return;
        }
        if (this.g.j && this.d.b) {
            if (this.d.H[2].c != null && this.d.H[3].c != null) {
                if (this.d.aa()) {
                    this.j.f = this.d.H[2].j();
                    this.k.f = -this.d.H[3].j();
                } else {
                    cn a = a(this.d.H[2]);
                    if (a != null) {
                        a(this.j, a, this.d.H[2].j());
                    }
                    cn a2 = a(this.d.H[3]);
                    if (a2 != null) {
                        a(this.k, a2, -this.d.H[3].j());
                    }
                    this.j.b = true;
                    this.k.b = true;
                }
                if (this.d.P()) {
                    a(this.a, this.j, this.d.Q());
                    return;
                }
                return;
            } else if (this.d.H[2].c != null) {
                cn a3 = a(this.d.H[2]);
                if (a3 != null) {
                    a(this.j, a3, this.d.H[2].j());
                    a(this.k, this.j, this.g.g);
                    if (this.d.P()) {
                        a(this.a, this.j, this.d.Q());
                        return;
                    }
                    return;
                }
                return;
            } else if (this.d.H[3].c != null) {
                cn a4 = a(this.d.H[3]);
                if (a4 != null) {
                    a(this.k, a4, -this.d.H[3].j());
                    a(this.j, this.k, -this.g.g);
                }
                if (this.d.P()) {
                    a(this.a, this.j, this.d.Q());
                    return;
                }
                return;
            } else if (this.d.H[4].c != null) {
                cn a5 = a(this.d.H[4]);
                if (a5 != null) {
                    a(this.a, a5, 0);
                    a(this.j, this.a, -this.d.Q());
                    a(this.k, this.j, this.g.g);
                    return;
                }
                return;
            } else if ((this.d instanceof cd) || this.d.A() == null || this.d.a(by.a.CENTER).c != null) {
                return;
            } else {
                a(this.j, this.d.A().g.j, this.d.E());
                a(this.k, this.j, this.g.g);
                if (this.d.P()) {
                    a(this.a, this.j, this.d.Q());
                    return;
                }
                return;
            }
        }
        if (!this.g.j && this.f == bz.a.MATCH_CONSTRAINT) {
            int i = this.d.n;
            if (i != 0) {
                switch (i) {
                    case 2:
                        bz A3 = this.d.A();
                        if (A3 != null) {
                            co coVar = A3.g.g;
                            this.g.l.add(coVar);
                            coVar.k.add(this.g);
                            this.g.b = true;
                            this.g.k.add(this.j);
                            this.g.k.add(this.k);
                            break;
                        }
                        break;
                    case 3:
                        if (!this.d.aa() && this.d.m != 3) {
                            co coVar2 = this.d.f.g;
                            this.g.l.add(coVar2);
                            coVar2.k.add(this.g);
                            this.g.b = true;
                            this.g.k.add(this.j);
                            this.g.k.add(this.k);
                            break;
                        }
                        break;
                }
            }
        } else {
            this.g.b(this);
        }
        if (this.d.H[2].c != null && this.d.H[3].c != null) {
            if (this.d.aa()) {
                this.j.f = this.d.H[2].j();
                this.k.f = -this.d.H[3].j();
            } else {
                cn a6 = a(this.d.H[2]);
                cn a7 = a(this.d.H[3]);
                if (a6 != null) {
                    a6.b(this);
                }
                if (a7 != null) {
                    a7.b(this);
                }
                this.l = cx.a.CENTER;
            }
            if (this.d.P()) {
                a(this.a, this.j, 1, this.b);
            }
        } else if (this.d.H[2].c != null) {
            cn a8 = a(this.d.H[2]);
            if (a8 != null) {
                a(this.j, a8, this.d.H[2].j());
                a(this.k, this.j, 1, this.g);
                if (this.d.P()) {
                    a(this.a, this.j, 1, this.b);
                }
                if (this.f == bz.a.MATCH_CONSTRAINT && this.d.S() > 0.0f && this.d.f.f == bz.a.MATCH_CONSTRAINT) {
                    this.d.f.g.k.add(this.g);
                    this.g.l.add(this.d.f.g);
                    this.g.a = this;
                }
            }
        } else if (this.d.H[3].c != null) {
            cn a9 = a(this.d.H[3]);
            if (a9 != null) {
                a(this.k, a9, -this.d.H[3].j());
                a(this.j, this.k, -1, this.g);
                if (this.d.P()) {
                    a(this.a, this.j, 1, this.b);
                }
            }
        } else if (this.d.H[4].c != null) {
            cn a10 = a(this.d.H[4]);
            if (a10 != null) {
                a(this.a, a10, 0);
                a(this.j, this.a, -1, this.b);
                a(this.k, this.j, 1, this.g);
            }
        } else if (!(this.d instanceof cd) && this.d.A() != null) {
            a(this.j, this.d.A().g.j, this.d.E());
            a(this.k, this.j, 1, this.g);
            if (this.d.P()) {
                a(this.a, this.j, 1, this.b);
            }
            if (this.f == bz.a.MATCH_CONSTRAINT && this.d.S() > 0.0f && this.d.f.f == bz.a.MATCH_CONSTRAINT) {
                this.d.f.g.k.add(this.g);
                this.g.l.add(this.d.f.g);
                this.g.a = this;
            }
        }
        if (this.g.l.size() == 0) {
            this.g.c = true;
        }
    }

    @Override // defpackage.cx
    public void e() {
        if (this.j.j) {
            this.d.p(this.j.g);
        }
    }
}
