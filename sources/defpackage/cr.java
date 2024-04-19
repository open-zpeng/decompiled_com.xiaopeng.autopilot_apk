package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GuidelineReference.java */
/* renamed from: cr  reason: default package */
/* loaded from: classes.dex */
public class cr extends cx {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public boolean a() {
        return false;
    }

    public cr(bz bzVar) {
        super(bzVar);
        bzVar.f.c();
        bzVar.g.c();
        this.h = ((cc) bzVar).c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void c() {
        this.j.a();
    }

    @Override // defpackage.cx
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    private void a(cn cnVar) {
        this.j.k.add(cnVar);
        cnVar.l.add(this.j);
    }

    @Override // defpackage.cx, defpackage.cl
    public void a(cl clVar) {
        if (this.j.c && !this.j.j) {
            this.j.a((int) ((this.j.l.get(0).g * ((cc) this.d).f()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void f() {
        cc ccVar = (cc) this.d;
        int g = ccVar.g();
        int h = ccVar.h();
        ccVar.f();
        if (ccVar.c() == 1) {
            if (g != -1) {
                this.j.l.add(this.d.K.f.j);
                this.d.K.f.j.k.add(this.j);
                this.j.f = g;
            } else if (h != -1) {
                this.j.l.add(this.d.K.f.k);
                this.d.K.f.k.k.add(this.j);
                this.j.f = -h;
            } else {
                this.j.b = true;
                this.j.l.add(this.d.K.f.k);
                this.d.K.f.k.k.add(this.j);
            }
            a(this.d.f.j);
            a(this.d.f.k);
            return;
        }
        if (g != -1) {
            this.j.l.add(this.d.K.g.j);
            this.d.K.g.j.k.add(this.j);
            this.j.f = g;
        } else if (h != -1) {
            this.j.l.add(this.d.K.g.k);
            this.d.K.g.k.k.add(this.j);
            this.j.f = -h;
        } else {
            this.j.b = true;
            this.j.l.add(this.d.K.g.k);
            this.d.K.g.k.k.add(this.j);
        }
        a(this.d.g.j);
        a(this.d.g.k);
    }

    @Override // defpackage.cx
    public void e() {
        if (((cc) this.d).c() == 1) {
            this.d.o(this.j.g);
        } else {
            this.d.p(this.j.g);
        }
    }
}
