package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* renamed from: aev  reason: default package */
/* loaded from: classes.dex */
public final class aev extends aen implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public aev(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        this.b = Thread.currentThread();
        try {
            this.a.run();
            return null;
        } finally {
            lazySet(c);
            this.b = null;
        }
    }
}
