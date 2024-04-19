package defpackage;

import com.badlogic.gdx.math.o;
import defpackage.ok;
/* compiled from: Tooltip.java */
/* renamed from: ps  reason: default package */
/* loaded from: classes.dex */
public class ps<T extends ok> extends op {
    static o a = new o();
    final pc<T> b;
    boolean c;
    boolean d;
    ok e;
    private final pt f;

    @Override // defpackage.op
    public boolean a(oo ooVar, float f, float f2, int i, int i2) {
        if (this.c) {
            this.b.y();
            return false;
        }
        this.f.a(this);
        return false;
    }

    @Override // defpackage.op
    public boolean a(oo ooVar, float f, float f2) {
        if (this.b.f()) {
            return false;
        }
        a(ooVar.c(), f, f2);
        return true;
    }

    private void a(ok okVar, float f, float f2) {
        this.e = okVar;
        oq e = okVar.e();
        if (e == null) {
            return;
        }
        this.b.h_();
        float f3 = this.f.c;
        float f4 = this.f.d;
        float f5 = this.f.e;
        float f6 = f + f3;
        o c = okVar.c(a.a(f6, (f2 - f4) - this.b.n()));
        if (c.e < f5) {
            c = okVar.c(a.a(f6, f2 + f4));
        }
        if (c.d < f5) {
            c.d = f5;
        }
        if (c.d + this.b.m() > e.g() - f5) {
            c.d = (e.g() - f5) - this.b.m();
        }
        if (c.e + this.b.n() > e.h() - f5) {
            c.e = (e.h() - f5) - this.b.n();
        }
        this.b.a(c.d, c.e);
        o c2 = okVar.c(a.a(okVar.m() / 2.0f, okVar.n() / 2.0f));
        c2.b(this.b.k(), this.b.l());
        this.b.d(c2.d, c2.e);
    }

    @Override // defpackage.op
    public void a(oo ooVar, float f, float f2, int i, ok okVar) {
        if (i == -1 && !io.d.isTouched()) {
            ok c = ooVar.c();
            if (okVar == null || !okVar.a(c)) {
                a(c, f, f2);
                this.f.b(this);
            }
        }
    }

    @Override // defpackage.op
    public void b(oo ooVar, float f, float f2, int i, ok okVar) {
        if (okVar == null || !okVar.a(ooVar.c())) {
            a();
        }
    }

    public void a() {
        this.f.c(this);
    }
}
