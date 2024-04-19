package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
/* compiled from: Widget.java */
/* renamed from: px  reason: default package */
/* loaded from: classes.dex */
public class px extends ok implements qh {
    private boolean m;
    private boolean l = true;
    private boolean n = true;

    public void B() {
    }

    @Override // defpackage.qh
    public float I() {
        return 0.0f;
    }

    @Override // defpackage.qh
    public float J() {
        return 0.0f;
    }

    public float L() {
        return 0.0f;
    }

    public float M() {
        return 0.0f;
    }

    public float N() {
        return L();
    }

    public float O() {
        return M();
    }

    @Override // defpackage.qh
    public void i_() {
        float n;
        float f;
        if (this.n) {
            on g = g();
            if (this.m && g != null) {
                oq e = e();
                if (e != null && g == e.j()) {
                    f = e.g();
                    n = e.h();
                } else {
                    float m = g.m();
                    n = g.n();
                    f = m;
                }
                c(f, n);
            }
            if (this.l) {
                this.l = false;
                B();
            }
        }
    }

    public void D() {
        this.l = true;
    }

    @Override // defpackage.qh
    public void g_() {
        if (this.n) {
            D();
            on g = g();
            if (g instanceof qh) {
                ((qh) g).g_();
            }
        }
    }

    @Override // defpackage.ok
    protected void r() {
        D();
    }

    @Override // defpackage.qh
    public void h_() {
        c(L(), M());
        i_();
    }

    @Override // defpackage.ok
    public void a(Batch batch, float f) {
        i_();
    }
}
