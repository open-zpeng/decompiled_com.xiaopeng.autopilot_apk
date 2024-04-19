package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import defpackage.oz;
/* compiled from: ImageButton.java */
/* renamed from: pe  reason: default package */
/* loaded from: classes.dex */
public class pe extends oz {
    private final pd H;
    private a I;

    /* compiled from: ImageButton.java */
    /* renamed from: pe$a */
    /* loaded from: classes.dex */
    public static class a extends oz.a {
        public qf o;
        public qf p;
        public qf q;
        public qf r;
        public qf s;
        public qf t;
    }

    protected void P() {
        qf qfVar;
        if (K() && this.I.t != null) {
            qfVar = this.I.t;
        } else if (d_() && this.I.p != null) {
            qfVar = this.I.p;
        } else if (this.n && this.I.r != null) {
            qfVar = (this.I.s == null || !e_()) ? this.I.r : this.I.s;
        } else if (e_() && this.I.q != null) {
            qfVar = this.I.q;
        } else {
            qfVar = this.I.o != null ? this.I.o : null;
        }
        this.H.a(qfVar);
    }

    @Override // defpackage.oz, defpackage.po, defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        P();
        super.a(batch, f);
    }
}
