package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ThreadPoolHelper.java */
/* renamed from: rh  reason: default package */
/* loaded from: classes.dex */
public class rh {
    private static volatile HandlerThread a;
    private static Handler b;
    private static volatile HandlerThread c;
    private static Handler d;
    private ExecutorService e;
    private Handler f;

    private rh() {
        this.e = Executors.newFixedThreadPool(4, new b().a("order-%d").a(false).a());
        this.f = new Handler(Looper.getMainLooper());
        a = new HandlerThread("ThreadPoolHelper-bg", 10);
        a.start();
        b = new Handler(a.getLooper());
        c = new HandlerThread("CameraThreadPoolHelper-bg", 10);
        c.start();
        d = new Handler(c.getLooper());
    }

    public static rh a() {
        return a.a;
    }

    /* compiled from: ThreadPoolHelper.java */
    /* renamed from: rh$a */
    /* loaded from: classes.dex */
    private static class a {
        private static rh a = new rh();
    }

    public void a(Runnable runnable) {
        a(runnable, 10);
    }

    public void a(final Runnable runnable, final int i) {
        try {
            if (this.e.isShutdown()) {
                return;
            }
            this.e.execute(new Runnable() { // from class: rh.1
                @Override // java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(i);
                    runnable.run();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(Runnable runnable) {
        this.f.post(runnable);
    }

    public void c(Runnable runnable) {
        this.f.post(runnable);
    }

    public void a(Runnable runnable, long j) {
        this.f.postDelayed(runnable, j);
    }

    public void b(Runnable runnable, long j) {
        this.f.postDelayed(runnable, j);
    }

    public void d(Runnable runnable) {
        this.f.removeCallbacks(runnable);
    }

    public void e(Runnable runnable) {
        this.f.removeCallbacks(runnable);
    }

    public void f(Runnable runnable) {
        b.post(runnable);
    }

    public void c(Runnable runnable, long j) {
        b.postDelayed(runnable, j);
    }

    public void g(Runnable runnable) {
        b.removeCallbacks(runnable);
    }

    public void d(Runnable runnable, long j) {
        b.postDelayed(runnable, j);
    }

    public void e(Runnable runnable, long j) {
        d.postDelayed(runnable, j);
    }

    public void h(Runnable runnable) {
        d.removeCallbacks(runnable);
    }

    /* compiled from: ThreadPoolHelper.java */
    /* renamed from: rh$b */
    /* loaded from: classes.dex */
    private static class b {
        private String a;
        private boolean b;
        private ThreadFactory c;
        private String d;

        private b() {
            this.a = "newFixedThreadPool";
            this.b = false;
        }

        b a(String str) {
            this.d = str;
            return this;
        }

        b a(boolean z) {
            this.b = z;
            return this;
        }

        ThreadFactory a() {
            return new ThreadFactory() { // from class: rh.b.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread newThread = (b.this.c != null ? b.this.c : Executors.defaultThreadFactory()).newThread(runnable);
                    AtomicLong atomicLong = b.this.d != null ? new AtomicLong(0L) : null;
                    if (b.this.d != null) {
                        newThread.setName(String.format(Locale.ROOT, b.this.d, Long.valueOf(atomicLong.getAndIncrement())));
                    }
                    newThread.setDaemon(b.this.b);
                    return newThread;
                }
            };
        }
    }
}
