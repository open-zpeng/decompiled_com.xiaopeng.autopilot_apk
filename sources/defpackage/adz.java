package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* renamed from: adz  reason: default package */
/* loaded from: classes.dex */
public final class adz extends AtomicReference<ade> implements ade {
    private static final long serialVersionUID = -754898800686245608L;

    public adz() {
    }

    public adz(ade adeVar) {
        lazySet(adeVar);
    }

    public boolean a(ade adeVar) {
        return adw.replace(this, adeVar);
    }

    @Override // defpackage.ade
    public void dispose() {
        adw.dispose(this);
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return adw.isDisposed(get());
    }
}
