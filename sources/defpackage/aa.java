package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultTaskExecutor.java */
/* renamed from: aa  reason: default package */
/* loaded from: classes.dex */
public class aa extends ab {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: aa.1
        private final AtomicInteger b = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.b.getAndIncrement())));
            return thread;
        }
    });
    private volatile Handler c;

    @Override // defpackage.ab
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // defpackage.ab
    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = a(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // defpackage.ab
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private static Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
