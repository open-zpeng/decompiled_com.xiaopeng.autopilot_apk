package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import java.util.Comparator;
/* compiled from: DefaultRenderableSorter.java */
/* renamed from: nd  reason: default package */
/* loaded from: classes.dex */
public class nd implements Comparator<lb>, nl {
    private jz a;
    private final p b = new p();
    private final p c = new p();

    @Override // defpackage.nl
    public void a(jz jzVar, a<lb> aVar) {
        this.a = jzVar;
        aVar.a(this);
    }

    private p a(Matrix4 matrix4, p pVar, p pVar2) {
        if (pVar.e()) {
            matrix4.a(pVar2);
        } else if (!matrix4.g()) {
            matrix4.a(pVar2).b(pVar);
        } else {
            pVar2.a(pVar).a(matrix4);
        }
        return pVar2;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(lb lbVar, lb lbVar2) {
        int i = 0;
        boolean z = lbVar.c.c(le.b) && ((le) lbVar.c.a(le.b)).c;
        if (z != (lbVar2.c.c(le.b) && ((le) lbVar2.c.a(le.b)).c)) {
            return z ? 1 : -1;
        }
        a(lbVar.a, lbVar.b.f, this.b);
        a(lbVar2.a, lbVar2.b.f, this.c);
        float e = ((int) (this.a.a.e(this.b) * 1000.0f)) - ((int) (this.a.a.e(this.c) * 1000.0f));
        if (e < 0.0f) {
            i = -1;
        } else if (e > 0.0f) {
            i = 1;
        }
        return z ? -i : i;
    }
}
