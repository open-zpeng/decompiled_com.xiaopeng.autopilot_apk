package defpackage;

import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: AsyncExecutor.java */
/* renamed from: qp  reason: default package */
/* loaded from: classes.dex */
public class qp implements g {
    private final ExecutorService a;

    public qp(int i) {
        this.a = Executors.newFixedThreadPool(i, new ThreadFactory() { // from class: qp.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AsynchExecutor-Thread");
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    public <T> qq<T> a(final qr<T> qrVar) {
        if (this.a.isShutdown()) {
            throw new k("Cannot run tasks on an executor that has been shutdown (disposed)");
        }
        return new qq<>(this.a.submit(new Callable<T>() { // from class: qp.2
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                return (T) qrVar.d();
            }
        }));
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.a.shutdown();
        try {
            this.a.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new k("Couldn't shutdown loading thread", e);
        }
    }
}
