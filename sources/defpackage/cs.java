package defpackage;

import defpackage.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HelperReferences.java */
/* renamed from: cs  reason: default package */
/* loaded from: classes.dex */
public class cs extends cx {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public boolean a() {
        return false;
    }

    public cs(bz bzVar) {
        super(bzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void c() {
        this.e = null;
        this.j.a();
    }

    @Override // defpackage.cx
    void d() {
        this.j.j = false;
    }

    private void a(cn cnVar) {
        this.j.k.add(cnVar);
        cnVar.l.add(this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void f() {
        if (this.d instanceof bv) {
            this.j.b = true;
            bv bvVar = (bv) this.d;
            int b = bvVar.b();
            boolean c = bvVar.c();
            int i = 0;
            switch (b) {
                case 0:
                    this.j.e = cn.a.LEFT;
                    while (i < bvVar.ay) {
                        bz bzVar = bvVar.ax[i];
                        if (c || bzVar.B() != 8) {
                            cn cnVar = bzVar.f.j;
                            cnVar.k.add(this.j);
                            this.j.l.add(cnVar);
                        }
                        i++;
                    }
                    a(this.d.f.j);
                    a(this.d.f.k);
                    return;
                case 1:
                    this.j.e = cn.a.RIGHT;
                    while (i < bvVar.ay) {
                        bz bzVar2 = bvVar.ax[i];
                        if (c || bzVar2.B() != 8) {
                            cn cnVar2 = bzVar2.f.k;
                            cnVar2.k.add(this.j);
                            this.j.l.add(cnVar2);
                        }
                        i++;
                    }
                    a(this.d.f.j);
                    a(this.d.f.k);
                    return;
                case 2:
                    this.j.e = cn.a.TOP;
                    while (i < bvVar.ay) {
                        bz bzVar3 = bvVar.ax[i];
                        if (c || bzVar3.B() != 8) {
                            cn cnVar3 = bzVar3.g.j;
                            cnVar3.k.add(this.j);
                            this.j.l.add(cnVar3);
                        }
                        i++;
                    }
                    a(this.d.g.j);
                    a(this.d.g.k);
                    return;
                case 3:
                    this.j.e = cn.a.BOTTOM;
                    while (i < bvVar.ay) {
                        bz bzVar4 = bvVar.ax[i];
                        if (c || bzVar4.B() != 8) {
                            cn cnVar4 = bzVar4.g.k;
                            cnVar4.k.add(this.j);
                            this.j.l.add(cnVar4);
                        }
                        i++;
                    }
                    a(this.d.g.j);
                    a(this.d.g.k);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // defpackage.cx, defpackage.cl
    public void a(cl clVar) {
        bv bvVar = (bv) this.d;
        int b = bvVar.b();
        int i = 0;
        int i2 = -1;
        for (cn cnVar : this.j.l) {
            int i3 = cnVar.g;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (b == 0 || b == 2) {
            this.j.a(i2 + bvVar.g());
        } else {
            this.j.a(i + bvVar.g());
        }
    }

    @Override // defpackage.cx
    public void e() {
        if (this.d instanceof bv) {
            int b = ((bv) this.d).b();
            if (b == 0 || b == 1) {
                this.d.o(this.j.g);
            } else {
                this.d.p(this.j.g);
            }
        }
    }
}
