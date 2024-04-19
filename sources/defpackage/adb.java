package defpackage;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* renamed from: adb  reason: default package */
/* loaded from: classes.dex */
public abstract class adb {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c a();

    public void b() {
    }

    public ade a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(afd.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    public ade a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(afd.a(runnable), a2);
        ade a3 = a2.a(bVar, j, j2, timeUnit);
        return a3 == adx.INSTANCE ? a3 : bVar;
    }

    /* compiled from: Scheduler.java */
    /* renamed from: adb$c */
    /* loaded from: classes.dex */
    public static abstract class c implements ade {
        public abstract ade a(Runnable runnable, long j, TimeUnit timeUnit);

        public ade a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public ade a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            adz adzVar = new adz();
            adz adzVar2 = new adz(adzVar);
            Runnable a2 = afd.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a3 = a(TimeUnit.NANOSECONDS);
            ade a4 = a(new a(a3 + timeUnit.toNanos(j), a2, a3, adzVar2, nanos), j, timeUnit);
            if (a4 == adx.INSTANCE) {
                return a4;
            }
            adzVar.a(a4);
            return adzVar2;
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Scheduler.java */
        /* renamed from: adb$c$a */
        /* loaded from: classes.dex */
        public final class a implements Runnable {
            final Runnable a;
            final adz b;
            final long c;
            long d;
            long e;
            long f;

            a(long j, Runnable runnable, long j2, adz adzVar, long j3) {
                this.a = runnable;
                this.b = adzVar;
                this.c = j3;
                this.e = j2;
                this.f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.a.run();
                if (this.b.isDisposed()) {
                    return;
                }
                long a = c.this.a(TimeUnit.NANOSECONDS);
                long j2 = this.e;
                if (adb.a + a < j2 || a >= j2 + this.c + adb.a) {
                    long j3 = this.c;
                    long j4 = a + j3;
                    long j5 = this.d + 1;
                    this.d = j5;
                    this.f = j4 - (j3 * j5);
                    j = j4;
                } else {
                    long j6 = this.f;
                    long j7 = this.d + 1;
                    this.d = j7;
                    j = j6 + (j7 * this.c);
                }
                this.e = a;
                this.b.a(c.this.a(this, j - a, TimeUnit.NANOSECONDS));
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: adb$b */
    /* loaded from: classes.dex */
    static final class b implements ade, Runnable {
        final Runnable a;
        final c b;
        volatile boolean c;

        b(Runnable runnable, c cVar) {
            this.a = runnable;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            try {
                this.a.run();
            } catch (Throwable th) {
                adj.a(th);
                this.b.dispose();
                throw afa.a(th);
            }
        }

        @Override // defpackage.ade
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* renamed from: adb$a */
    /* loaded from: classes.dex */
    public static final class a implements ade, Runnable {
        final Runnable a;
        final c b;
        Thread c;

        a(Runnable runnable, c cVar) {
            this.a = runnable;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.c = null;
            }
        }

        @Override // defpackage.ade
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                c cVar = this.b;
                if (cVar instanceof aes) {
                    ((aes) cVar).b();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.b.isDisposed();
        }
    }
}
