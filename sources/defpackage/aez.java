package defpackage;

import defpackage.adb;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* renamed from: aez  reason: default package */
/* loaded from: classes.dex */
public final class aez extends adb {
    private static final aez b = new aez();

    public static aez c() {
        return b;
    }

    @Override // defpackage.adb
    public adb.c a() {
        return new c();
    }

    aez() {
    }

    @Override // defpackage.adb
    public ade a(Runnable runnable) {
        afd.a(runnable).run();
        return adx.INSTANCE;
    }

    @Override // defpackage.adb
    public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            afd.a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            afd.a(e);
        }
        return adx.INSTANCE;
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: aez$c */
    /* loaded from: classes.dex */
    static final class c extends adb.c implements ade {
        volatile boolean c;
        final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();
        private final AtomicInteger d = new AtomicInteger();
        final AtomicInteger b = new AtomicInteger();

        c() {
        }

        @Override // defpackage.adb.c
        public ade a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // defpackage.adb.c
        public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        ade a(Runnable runnable, long j) {
            if (this.c) {
                return adx.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.b.incrementAndGet());
            this.a.add(bVar);
            if (this.d.getAndIncrement() == 0) {
                int i = 1;
                while (!this.c) {
                    b poll = this.a.poll();
                    if (poll != null) {
                        if (!poll.d) {
                            poll.a.run();
                        }
                    } else {
                        i = this.d.addAndGet(-i);
                        if (i == 0) {
                            return adx.INSTANCE;
                        }
                    }
                }
                this.a.clear();
                return adx.INSTANCE;
            }
            return adf.a(new a(bVar));
        }

        @Override // defpackage.ade
        public void dispose() {
            this.c = true;
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: aez$c$a */
        /* loaded from: classes.dex */
        public final class a implements Runnable {
            final b a;

            a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.d = true;
                c.this.a.remove(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* renamed from: aez$b */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {
        final Runnable a;
        final long b;
        final int c;
        volatile boolean d;

        b(Runnable runnable, Long l, int i) {
            this.a = runnable;
            this.b = l.longValue();
            this.c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int a = aeb.a(this.b, bVar.b);
            return a == 0 ? aeb.a(this.c, bVar.c) : a;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: aez$a */
    /* loaded from: classes.dex */
    static final class a implements Runnable {
        private final Runnable a;
        private final c b;
        private final long c;

        a(Runnable runnable, c cVar, long j) {
            this.a = runnable;
            this.b = cVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.c) {
                return;
            }
            long a = this.b.a(TimeUnit.MILLISECONDS);
            long j = this.c;
            if (j > a) {
                try {
                    Thread.sleep(j - a);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    afd.a(e);
                    return;
                }
            }
            if (this.b.c) {
                return;
            }
            this.a.run();
        }
    }
}
