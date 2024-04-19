package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
/* compiled from: WidgetGroup.java */
/* renamed from: py  reason: default package */
/* loaded from: classes.dex */
public class py extends on implements qh {
    private boolean o;
    private boolean n = true;
    private boolean p = true;

    public float I() {
        return 0.0f;
    }

    public float J() {
        return 0.0f;
    }

    public float L() {
        return 0.0f;
    }

    public float M() {
        return 0.0f;
    }

    public void f_() {
    }

    public float N() {
        return L();
    }

    public float O() {
        return M();
    }

    @Override // defpackage.qh
    public void i_() {
        float m;
        float n;
        if (this.p) {
            on g = g();
            if (this.o && g != null) {
                oq e = e();
                if (e != null && g == e.j()) {
                    m = e.g();
                    n = e.h();
                } else {
                    m = g.m();
                    n = g.n();
                }
                if (m() != m || n() != n) {
                    c(m);
                    d(n);
                    j_();
                }
            }
            if (this.n) {
                this.n = false;
                f_();
                if (this.n) {
                    while (g != null) {
                        if (g instanceof py) {
                            return;
                        }
                        g = g.g();
                    }
                    for (int i = 0; i < 5; i++) {
                        this.n = false;
                        f_();
                        if (!this.n) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void j_() {
        this.n = true;
    }

    @Override // defpackage.qh
    public void g_() {
        j_();
        on g = g();
        if (g instanceof qh) {
            ((qh) g).g_();
        }
    }

    @Override // defpackage.on
    protected void C() {
        g_();
    }

    @Override // defpackage.ok
    protected void r() {
        j_();
    }

    @Override // defpackage.qh
    public void h_() {
        c(L(), M());
        i_();
        c(L(), M());
        i_();
    }

    @Override // defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        super.a(batch, f);
    }
}
