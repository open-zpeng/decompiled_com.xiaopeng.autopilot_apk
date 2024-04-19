package defpackage;

import defpackage.adb;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* renamed from: aeq  reason: default package */
/* loaded from: classes.dex */
public final class aeq extends adb {
    static final aet b;
    static final aet c;
    static final a g;
    final ThreadFactory e;
    final AtomicReference<a> f;
    private static final TimeUnit h = TimeUnit.SECONDS;
    static final c d = new c(new aet("RxCachedThreadSchedulerShutdown"));

    static {
        d.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        b = new aet("RxCachedThreadScheduler", max);
        c = new aet("RxCachedWorkerPoolEvictor", max);
        g = new a(0L, null, b);
        g.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: aeq$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        final add a;
        private final long b;
        private final ConcurrentLinkedQueue<c> c;
        private final ScheduledExecutorService d;
        private final Future<?> e;
        private final ThreadFactory f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.c = new ConcurrentLinkedQueue<>();
            this.a = new add();
            this.f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, aeq.c);
                long j2 = this.b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.d = scheduledExecutorService;
            this.e = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }

        c a() {
            if (this.a.isDisposed()) {
                return aeq.d;
            }
            while (!this.c.isEmpty()) {
                c poll = this.c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f);
            this.a.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.a(c() + this.b);
            this.c.offer(cVar);
        }

        void b() {
            if (this.c.isEmpty()) {
                return;
            }
            long c = c();
            Iterator<c> it = this.c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a() > c) {
                    return;
                }
                if (this.c.remove(next)) {
                    this.a.b(next);
                }
            }
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.a.dispose();
            Future<?> future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public aeq() {
        this(b);
    }

    public aeq(ThreadFactory threadFactory) {
        this.e = threadFactory;
        this.f = new AtomicReference<>(g);
        b();
    }

    @Override // defpackage.adb
    public void b() {
        a aVar = new a(60L, h, this.e);
        if (this.f.compareAndSet(g, aVar)) {
            return;
        }
        aVar.d();
    }

    @Override // defpackage.adb
    public adb.c a() {
        return new b(this.f.get());
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: aeq$b */
    /* loaded from: classes.dex */
    static final class b extends adb.c {
        final AtomicBoolean a = new AtomicBoolean();
        private final add b = new add();
        private final a c;
        private final c d;

        b(a aVar) {
            this.c = aVar;
            this.d = aVar.a();
        }

        @Override // defpackage.ade
        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.b.dispose();
                this.c.a(this.d);
            }
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.a.get();
        }

        @Override // defpackage.adb.c
        public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.b.isDisposed()) {
                return adx.INSTANCE;
            }
            return this.d.a(runnable, j, timeUnit, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: aeq$c */
    /* loaded from: classes.dex */
    public static final class c extends aes {
        private long b;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.b = 0L;
        }

        public long a() {
            return this.b;
        }

        public void a(long j) {
            this.b = j;
        }
    }
}
