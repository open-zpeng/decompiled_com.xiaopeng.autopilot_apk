package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import defpackage.oz;
/* compiled from: TextButton.java */
/* renamed from: pp  reason: default package */
/* loaded from: classes.dex */
public class pp extends oz {
    private pg H;
    private a I;

    /* compiled from: TextButton.java */
    /* renamed from: pp$a */
    /* loaded from: classes.dex */
    public static class a extends oz.a {
        public ka u;
        public ka v;
        public ka w;
        public ka x;
        public ka y;
        public ka z;
    }

    @Override // defpackage.oz, defpackage.po, defpackage.py, defpackage.on, defpackage.ok
    public void a(Batch batch, float f) {
        ka kaVar;
        if (K() && this.I.z != null) {
            kaVar = this.I.z;
        } else if (d_() && this.I.v != null) {
            kaVar = this.I.v;
        } else if (this.n && this.I.x != null) {
            kaVar = (!e_() || this.I.y == null) ? this.I.x : this.I.y;
        } else if (e_() && this.I.w != null) {
            kaVar = this.I.w;
        } else {
            kaVar = this.I.u;
        }
        if (kaVar != null) {
            this.H.C().b = kaVar;
        }
        super.a(batch, f);
    }
}
