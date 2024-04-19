package defpackage;
/* compiled from: ScheduledDirectPeriodicTask.java */
/* renamed from: aeu  reason: default package */
/* loaded from: classes.dex */
public final class aeu extends aen implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public aeu(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b = Thread.currentThread();
        try {
            this.a.run();
            this.b = null;
        } catch (Throwable th) {
            this.b = null;
            lazySet(c);
            afd.a(th);
        }
    }
}
