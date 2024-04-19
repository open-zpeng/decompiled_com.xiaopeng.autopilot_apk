package defpackage;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.g;
import java.util.Iterator;
/* compiled from: ParticleEffect.java */
/* renamed from: mp  reason: default package */
/* loaded from: classes.dex */
public class mp implements g {
    private a<mn> a = new a<>(true, 3, mn.class);

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        int i = this.a.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.a(i2).a();
        }
    }

    public void a(a<ms<?>> aVar) {
        Iterator<mn> it = this.a.iterator();
        while (it.hasNext()) {
            mn next = it.next();
            Iterator<ms<?>> it2 = aVar.iterator();
            while (it2.hasNext()) {
                if (next.d.a(it2.next())) {
                    break;
                }
            }
        }
    }

    public void a(jb jbVar, mr mrVar) {
        Iterator<mn> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(jbVar, mrVar);
        }
    }
}
