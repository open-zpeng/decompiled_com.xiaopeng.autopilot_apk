package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import defpackage.pp;
/* compiled from: CheckBox.java */
/* renamed from: pb  reason: default package */
/* loaded from: classes.dex */
public class pb extends pp {
    private pd H;
    private a I;

    /* compiled from: CheckBox.java */
    /* renamed from: pb$a */
    /* loaded from: classes.dex */
    public static class a extends pp.a {
        public qf o;
        public qf p;
        public qf q;
        public qf r;
        public qf s;
        public qf t;
    }

    @Override // defpackage.pp, defpackage.oz, defpackage.po, defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        qf qfVar;
        if (!K()) {
            qfVar = null;
        } else if (this.n && this.I.s != null) {
            qfVar = this.I.s;
        } else {
            qfVar = this.I.t;
        }
        if (qfVar == null) {
            boolean z = e_() && !K();
            if (this.n && this.I.o != null) {
                qfVar = (!z || this.I.q == null) ? this.I.o : this.I.q;
            } else if (z && this.I.r != null) {
                qfVar = this.I.r;
            } else {
                qfVar = this.I.p;
            }
        }
        this.H.a(qfVar);
        super.a(batch, f);
    }
}
