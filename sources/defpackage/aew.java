package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: ScheduledRunnable.java */
/* renamed from: aew  reason: default package */
/* loaded from: classes.dex */
public final class aew extends AtomicReferenceArray<Object> implements ade, Runnable, Callable<Object> {
    static final Object b = new Object();
    static final Object c = new Object();
    static final Object d = new Object();
    static final Object e = new Object();
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable a;

    public aew(Runnable runnable, adv advVar) {
        super(3);
        this.a = runnable;
        lazySet(0, advVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.a.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != b) {
                    ((adv) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != c) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj5, e));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != b && compareAndSet(0, obj4, e) && obj4 != null) {
            ((adv) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != c || obj5 == d) {
                return;
            }
        } while (!compareAndSet(1, obj5, e));
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == e) {
                return;
            }
            if (obj == c) {
                future.cancel(false);
                return;
            } else if (obj == d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // defpackage.ade
    public void dispose() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = get(1);
            if (obj3 == e || obj3 == c || obj3 == d) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj3, z ? d : c)) {
                if (obj3 != null) {
                    ((Future) obj3).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == e || obj == (obj2 = b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((adv) obj).c(this);
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == b || obj == e;
    }
}
