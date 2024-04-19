package defpackage;

import com.badlogic.gdx.math.f;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ap;
/* compiled from: TooltipManager.java */
/* renamed from: pt  reason: default package */
/* loaded from: classes.dex */
public class pt {
    public float a;
    public boolean b;
    public float c;
    public float d;
    public float e;
    final a<ps> f;
    float g;
    final ap.a h;
    ps i;
    final ap.a j;

    public void a(ps psVar) {
        this.j.a();
        if (psVar.b.a()) {
            this.h.a();
        }
        this.h.run();
        if (this.b || psVar.d) {
            this.i = psVar;
            ap.b(this.j, this.g);
        }
    }

    public void b(ps psVar) {
        this.i = psVar;
        this.j.a();
        if (this.b || psVar.d) {
            if (this.g == 0.0f || psVar.c) {
                this.j.run();
            } else {
                ap.b(this.j, this.g);
            }
        }
    }

    public void c(ps psVar) {
        this.i = null;
        this.j.a();
        if (psVar.b.f()) {
            this.f.c(psVar, true);
            d(psVar);
            this.h.a();
            ap.b(this.h, this.a);
        }
    }

    protected void d(ps psVar) {
        psVar.b.a(os.a(os.b(os.a(0.2f, 0.2f, f.e), os.a(0.05f, 0.05f, 0.2f, f.e)), os.a()));
    }
}
