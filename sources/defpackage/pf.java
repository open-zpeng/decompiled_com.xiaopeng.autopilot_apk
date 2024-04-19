package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import defpackage.pp;
/* compiled from: ImageTextButton.java */
/* renamed from: pf  reason: default package */
/* loaded from: classes.dex */
public class pf extends oz {
    private final pd H;
    private pg I;
    private a J;

    /* compiled from: ImageTextButton.java */
    /* renamed from: pf$a */
    /* loaded from: classes.dex */
    public static class a extends pp.a {
        public qf o;
        public qf p;
        public qf q;
        public qf r;
        public qf s;
        public qf t;
    }

    protected void P() {
        qf qfVar;
        if (K() && this.J.t != null) {
            qfVar = this.J.t;
        } else if (d_() && this.J.p != null) {
            qfVar = this.J.p;
        } else if (this.n && this.J.r != null) {
            qfVar = (this.J.s == null || !e_()) ? this.J.r : this.J.s;
        } else if (e_() && this.J.q != null) {
            qfVar = this.J.q;
        } else {
            qfVar = this.J.o != null ? this.J.o : null;
        }
        this.H.a(qfVar);
    }

    @Override // defpackage.oz, defpackage.po, defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        ka kaVar;
        P();
        if (K() && this.J.z != null) {
            kaVar = this.J.z;
        } else if (d_() && this.J.v != null) {
            kaVar = this.J.v;
        } else if (this.n && this.J.x != null) {
            kaVar = (!e_() || this.J.y == null) ? this.J.x : this.J.y;
        } else if (e_() && this.J.w != null) {
            kaVar = this.J.w;
        } else {
            kaVar = this.J.u;
        }
        if (kaVar != null) {
            this.I.C().b = kaVar;
        }
        super.a(batch, f);
    }
}
