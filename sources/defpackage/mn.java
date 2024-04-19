package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.o;
import com.badlogic.gdx.utils.q;
import java.util.Iterator;
/* compiled from: ParticleController.java */
/* renamed from: mn  reason: default package */
/* loaded from: classes.dex */
public class mn implements o.c {
    public String a;
    public mt b;
    public mv<?, ?> d;
    public float g;
    public float h;
    public Matrix4 e = new Matrix4();
    public p f = new p(1.0f, 1.0f, 1.0f);
    public a<mu> c = new a<>(true, 3, mu.class);

    public mn() {
        a(0.016666668f);
    }

    private void a(float f) {
        this.g = f;
        float f2 = this.g;
        this.h = f2 * f2;
    }

    public void a() {
        this.b.dispose();
        Iterator<mu> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
    }

    @Override // com.badlogic.gdx.utils.o.c
    public void a(o oVar, q qVar) {
        this.a = (String) oVar.a("name", String.class, qVar);
        this.b = (mt) oVar.a("emitter", mt.class, qVar);
        this.c.a((a) oVar.a("influencers", (Class<Object>) a.class, mu.class, qVar));
        this.d = (mv) oVar.a("renderer", mv.class, qVar);
    }

    public void a(jb jbVar, mr mrVar) {
        this.b.a(jbVar, mrVar);
        Iterator<mu> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(jbVar, mrVar);
        }
        this.d.a(jbVar, mrVar);
    }
}
