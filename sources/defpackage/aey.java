package defpackage;

import defpackage.adb;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* renamed from: aey  reason: default package */
/* loaded from: classes.dex */
public final class aey extends adb {
    static final aet d;
    static final ScheduledExecutorService e = Executors.newScheduledThreadPool(0);
    final ThreadFactory b;
    final AtomicReference<ScheduledExecutorService> c;

    static {
        e.shutdown();
        d = new aet("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public aey() {
        this(d);
    }

    public aey(ThreadFactory threadFactory) {
        this.c = new AtomicReference<>();
        this.b = threadFactory;
        this.c.lazySet(a(threadFactory));
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return aex.a(threadFactory);
    }

    @Override // defpackage.adb
    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.c.get();
            if (scheduledExecutorService != e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.b);
            }
        } while (!this.c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // defpackage.adb
    public adb.c a() {
        return new a(this.c.get());
    }

    @Override // defpackage.adb
    public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        aev aevVar = new aev(afd.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.c.get().submit(aevVar);
            } else {
                schedule = this.c.get().schedule(aevVar, j, timeUnit);
            }
            aevVar.a(schedule);
            return aevVar;
        } catch (RejectedExecutionException e2) {
            afd.a(e2);
            return adx.INSTANCE;
        }
    }

    @Override // defpackage.adb
    public ade a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a2 = afd.a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.c.get();
            aep aepVar = new aep(a2, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(aepVar);
                } else {
                    schedule = scheduledExecutorService.schedule(aepVar, j, timeUnit);
                }
                aepVar.a(schedule);
                return aepVar;
            } catch (RejectedExecutionException e2) {
                afd.a(e2);
                return adx.INSTANCE;
            }
        }
        aeu aeuVar = new aeu(a2);
        try {
            aeuVar.a(this.c.get().scheduleAtFixedRate(aeuVar, j, j2, timeUnit));
            return aeuVar;
        } catch (RejectedExecutionException e3) {
            afd.a(e3);
            return adx.INSTANCE;
        }
    }

    /* compiled from: SingleScheduler.java */
    /* renamed from: aey$a */
    /* loaded from: classes.dex */
    static final class a extends adb.c {
        final ScheduledExecutorService a;
        final add b = new add();
        volatile boolean c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // defpackage.adb.c
        public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.c) {
                return adx.INSTANCE;
            }
            aew aewVar = new aew(afd.a(runnable), this.b);
            this.b.a(aewVar);
            try {
                if (j <= 0) {
                    schedule = this.a.submit((Callable) aewVar);
                } else {
                    schedule = this.a.schedule((Callable) aewVar, j, timeUnit);
                }
                aewVar.a(schedule);
                return aewVar;
            } catch (RejectedExecutionException e) {
                dispose();
                afd.a(e);
                return adx.INSTANCE;
            }
        }

        @Override // defpackage.ade
        public void dispose() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.dispose();
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.c;
        }
    }
}
