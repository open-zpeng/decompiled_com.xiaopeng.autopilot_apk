package defpackage;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ao;
import com.badlogic.gdx.utils.k;
import java.lang.reflect.GenericDeclaration;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetLoadingTask.java */
/* renamed from: ja  reason: default package */
/* loaded from: classes.dex */
public class ja implements qr<Void> {
    jb a;
    final ix b;
    final jd c;
    final qp d;
    final long e;
    volatile a<ix> h;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile qq<Void> i = null;
    volatile qq<Void> j = null;
    volatile Object k = null;
    int l = 0;
    volatile boolean m = false;

    public ja(jb jbVar, ix ixVar, jd jdVar, qp qpVar) {
        this.a = jbVar;
        this.b = ixVar;
        this.c = jdVar;
        this.d = qpVar;
        this.e = jbVar.n.a() == 3 ? ao.a() : 0L;
    }

    @Override // defpackage.qr
    /* renamed from: a */
    public Void d() throws Exception {
        je jeVar = (je) this.c;
        if (!this.g) {
            this.h = jeVar.getDependencies(this.b.a, a(this.c, this.b), this.b.c);
            if (this.h != null) {
                a(this.h);
                this.a.a(this.b.a, this.h);
                return null;
            }
            jeVar.a(this.a, this.b.a, a(this.c, this.b), this.b.c);
            this.f = true;
            return null;
        }
        jeVar.a(this.a, this.b.a, a(this.c, this.b), this.b.c);
        return null;
    }

    public boolean b() {
        this.l++;
        if (this.c instanceof jq) {
            e();
        } else {
            f();
        }
        return this.k != null;
    }

    private void e() {
        jq jqVar = (jq) this.c;
        if (!this.g) {
            this.g = true;
            this.h = jqVar.getDependencies(this.b.a, a(this.c, this.b), this.b.c);
            if (this.h == null) {
                this.k = jqVar.load(this.a, this.b.a, a(this.c, this.b), this.b.c);
                return;
            }
            a(this.h);
            this.a.a(this.b.a, this.h);
            return;
        }
        this.k = jqVar.load(this.a, this.b.a, a(this.c, this.b), this.b.c);
    }

    private void f() {
        je jeVar = (je) this.c;
        if (!this.g) {
            if (this.i == null) {
                this.i = this.d.a(this);
            } else if (this.i.a()) {
                try {
                    this.i.b();
                    this.g = true;
                    if (this.f) {
                        this.k = jeVar.b(this.a, this.b.a, a(this.c, this.b), this.b.c);
                    }
                } catch (Exception e) {
                    throw new k("Couldn't load dependencies of asset: " + this.b.a, e);
                }
            }
        } else if (this.j == null && !this.f) {
            this.j = this.d.a(this);
        } else if (this.f) {
            this.k = jeVar.b(this.a, this.b.a, a(this.c, this.b), this.b.c);
        } else if (this.j.a()) {
            try {
                this.j.b();
                this.k = jeVar.b(this.a, this.b.a, a(this.c, this.b), this.b.c);
            } catch (Exception e2) {
                throw new k("Couldn't load asset: " + this.b.a, e2);
            }
        }
    }

    private jy a(jd jdVar, ix ixVar) {
        if (ixVar.d == null) {
            ixVar.d = jdVar.resolve(ixVar.a);
        }
        return ixVar.d;
    }

    public Object c() {
        return this.k;
    }

    private void a(a<ix> aVar) {
        boolean z = aVar.c;
        aVar.c = true;
        for (int i = 0; i < aVar.b; i++) {
            String str = aVar.a(i).a;
            GenericDeclaration genericDeclaration = aVar.a(i).b;
            for (int i2 = aVar.b - 1; i2 > i; i2--) {
                if (genericDeclaration == aVar.a(i2).b && str.equals(aVar.a(i2).a)) {
                    aVar.b(i2);
                }
            }
        }
        aVar.c = z;
    }
}
