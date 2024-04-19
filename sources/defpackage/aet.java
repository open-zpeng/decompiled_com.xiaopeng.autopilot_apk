package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* renamed from: aet  reason: default package */
/* loaded from: classes.dex */
public final class aet extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final String a;
    final int b;
    final boolean c;

    public aet(String str) {
        this(str, 5, false);
    }

    public aet(String str, int i) {
        this(str, i, false);
    }

    public aet(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.a + '-' + incrementAndGet();
        Thread aVar = this.c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.a + "]";
    }

    /* compiled from: RxThreadFactory.java */
    /* renamed from: aet$a */
    /* loaded from: classes.dex */
    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }
}
