package defpackage;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: ContextAwareHelper.java */
/* renamed from: e  reason: default package */
/* loaded from: classes.dex */
public final class e {
    private final Set<f> a = new CopyOnWriteArraySet();
    private volatile Context b;

    public Context a() {
        return this.b;
    }

    public void a(f fVar) {
        if (this.b != null) {
            fVar.a(this.b);
        }
        this.a.add(fVar);
    }

    public void b(f fVar) {
        this.a.remove(fVar);
    }

    public void a(Context context) {
        this.b = context;
        for (f fVar : this.a) {
            fVar.a(context);
        }
    }

    public void b() {
        this.b = null;
    }
}
