package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* renamed from: aen  reason: default package */
/* loaded from: classes.dex */
abstract class aen extends AtomicReference<Future<?>> implements ade {
    protected static final FutureTask<Void> c = new FutureTask<>(aea.b, null);
    protected static final FutureTask<Void> d = new FutureTask<>(aea.b, null);
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable a;
    protected Thread b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aen(Runnable runnable) {
        this.a = runnable;
    }

    @Override // defpackage.ade
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == c || future == (futureTask = d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.b != Thread.currentThread());
    }

    @Override // defpackage.ade
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == c || future == d;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == c) {
                return;
            }
            if (future2 == d) {
                future.cancel(this.b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
