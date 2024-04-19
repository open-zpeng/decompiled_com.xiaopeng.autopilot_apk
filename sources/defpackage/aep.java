package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: InstantPeriodicTask.java */
/* renamed from: aep  reason: default package */
/* loaded from: classes.dex */
final class aep implements ade, Callable<Void> {
    static final FutureTask<Void> f = new FutureTask<>(aea.b, null);
    final Runnable a;
    final ExecutorService d;
    Thread e;
    final AtomicReference<Future<?>> c = new AtomicReference<>();
    final AtomicReference<Future<?>> b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public aep(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        this.e = Thread.currentThread();
        try {
            this.a.run();
            b(this.d.submit(this));
            this.e = null;
        } catch (Throwable th) {
            this.e = null;
            afd.a(th);
        }
        return null;
    }

    @Override // defpackage.ade
    public void dispose() {
        Future<?> andSet = this.c.getAndSet(f);
        if (andSet != null && andSet != f) {
            andSet.cancel(this.e != Thread.currentThread());
        }
        Future<?> andSet2 = this.b.getAndSet(f);
        if (andSet2 == null || andSet2 == f) {
            return;
        }
        andSet2.cancel(this.e != Thread.currentThread());
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return this.c.get() == f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.c.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!this.c.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.b.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!this.b.compareAndSet(future2, future));
    }
}
