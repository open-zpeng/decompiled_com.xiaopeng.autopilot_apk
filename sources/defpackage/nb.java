package defpackage;

import com.badlogic.gdx.utils.a;
import java.util.Iterator;
/* compiled from: BaseShaderProvider.java */
/* renamed from: nb  reason: default package */
/* loaded from: classes.dex */
public abstract class nb implements nm {
    protected a<ld> a = new a<>();

    protected abstract ld b(lb lbVar);

    @Override // defpackage.nm
    public ld a(lb lbVar) {
        ld ldVar = lbVar.f;
        if (ldVar == null || !ldVar.a(lbVar)) {
            Iterator<ld> it = this.a.iterator();
            while (it.hasNext()) {
                ld next = it.next();
                if (next.a(lbVar)) {
                    return next;
                }
            }
            ld b = b(lbVar);
            b.a();
            this.a.a((a<ld>) b);
            return b;
        }
        return ldVar;
    }

    @Override // defpackage.nm
    public void a() {
        Iterator<ld> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
        this.a.d();
    }
}
