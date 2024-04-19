package defpackage;

import defpackage.adb;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* renamed from: aes  reason: default package */
/* loaded from: classes.dex */
public class aes extends adb.c implements ade {
    volatile boolean a;
    private final ScheduledExecutorService b;

    public aes(ThreadFactory threadFactory) {
        this.b = aex.a(threadFactory);
    }

    @Override // defpackage.adb.c
    public ade a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    @Override // defpackage.adb.c
    public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.a) {
            return adx.INSTANCE;
        }
        return a(runnable, j, timeUnit, (adv) null);
    }

    public ade b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        aev aevVar = new aev(afd.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.b.submit(aevVar);
            } else {
                schedule = this.b.schedule(aevVar, j, timeUnit);
            }
            aevVar.a(schedule);
            return aevVar;
        } catch (RejectedExecutionException e) {
            afd.a(e);
            return adx.INSTANCE;
        }
    }

    public ade b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a = afd.a(runnable);
        if (j2 <= 0) {
            aep aepVar = new aep(a, this.b);
            try {
                if (j <= 0) {
                    schedule = this.b.submit(aepVar);
                } else {
                    schedule = this.b.schedule(aepVar, j, timeUnit);
                }
                aepVar.a(schedule);
                return aepVar;
            } catch (RejectedExecutionException e) {
                afd.a(e);
                return adx.INSTANCE;
            }
        }
        aeu aeuVar = new aeu(a);
        try {
            aeuVar.a(this.b.scheduleAtFixedRate(aeuVar, j, j2, timeUnit));
            return aeuVar;
        } catch (RejectedExecutionException e2) {
            afd.a(e2);
            return adx.INSTANCE;
        }
    }

    public aew a(Runnable runnable, long j, TimeUnit timeUnit, adv advVar) {
        Future<?> schedule;
        aew aewVar = new aew(afd.a(runnable), advVar);
        if (advVar == null || advVar.a(aewVar)) {
            try {
                if (j <= 0) {
                    schedule = this.b.submit((Callable) aewVar);
                } else {
                    schedule = this.b.schedule((Callable) aewVar, j, timeUnit);
                }
                aewVar.a(schedule);
            } catch (RejectedExecutionException e) {
                if (advVar != null) {
                    advVar.b(aewVar);
                }
                afd.a(e);
            }
            return aewVar;
        }
        return aewVar;
    }

    @Override // defpackage.ade
    public void dispose() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.b.shutdownNow();
    }

    public void b() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.b.shutdown();
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return this.a;
    }
}
