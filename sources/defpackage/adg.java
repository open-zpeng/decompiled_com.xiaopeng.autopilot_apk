package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* renamed from: adg  reason: default package */
/* loaded from: classes.dex */
abstract class adg<T> extends AtomicReference<T> implements ade {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public adg(T t) {
        super(aeb.a(t, "value is null"));
    }

    @Override // defpackage.ade
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // defpackage.ade
    public final boolean isDisposed() {
        return get() == null;
    }
}
