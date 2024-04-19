package defpackage;

import defpackage.adb;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* renamed from: aeo  reason: default package */
/* loaded from: classes.dex */
public final class aeo extends adb {
    static final b b;
    static final aet c;
    static final int d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c e = new c(new aet("RxComputationShutdown"));
    final ThreadFactory f;
    final AtomicReference<b> g;

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        e.dispose();
        c = new aet("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        b = new b(0, c);
        b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: aeo$b */
    /* loaded from: classes.dex */
    public static final class b {
        final int a;
        final c[] b;
        long c;

        b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return aeo.e;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }
    }

    public aeo() {
        this(c);
    }

    public aeo(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(b);
        b();
    }

    @Override // defpackage.adb
    public adb.c a() {
        return new a(this.g.get().a());
    }

    @Override // defpackage.adb
    public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, timeUnit);
    }

    @Override // defpackage.adb
    public ade a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, j2, timeUnit);
    }

    @Override // defpackage.adb
    public void b() {
        b bVar = new b(d, this.f);
        if (this.g.compareAndSet(b, bVar)) {
            return;
        }
        bVar.b();
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: aeo$a */
    /* loaded from: classes.dex */
    static final class a extends adb.c {
        volatile boolean a;
        private final ady b = new ady();
        private final add c = new add();
        private final ady d = new ady();
        private final c e;

        a(c cVar) {
            this.e = cVar;
            this.d.a(this.b);
            this.d.a(this.c);
        }

        @Override // defpackage.ade
        public void dispose() {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d.dispose();
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.a;
        }

        @Override // defpackage.adb.c
        public ade a(Runnable runnable) {
            if (this.a) {
                return adx.INSTANCE;
            }
            return this.e.a(runnable, 0L, TimeUnit.MILLISECONDS, this.b);
        }

        @Override // defpackage.adb.c
        public ade a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.a) {
                return adx.INSTANCE;
            }
            return this.e.a(runnable, j, timeUnit, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: aeo$c */
    /* loaded from: classes.dex */
    public static final class c extends aes {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
