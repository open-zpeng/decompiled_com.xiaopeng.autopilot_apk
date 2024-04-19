package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SchedulerPoolFactory.java */
/* renamed from: aex  reason: default package */
/* loaded from: classes.dex */
public final class aex {
    public static final boolean a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        a = aVar.a;
        b = aVar.b;
        a();
    }

    public static void a() {
        a(a);
    }

    static void a(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = c.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new aet("RxSchedulerPurge"));
            if (c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                b bVar = new b();
                int i = b;
                newScheduledThreadPool.scheduleAtFixedRate(bVar, i, i, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: aex$a */
    /* loaded from: classes.dex */
    static final class a {
        boolean a;
        int b;

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.a = true;
            }
            if (this.a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                    this.b = 1;
                    return;
                }
            }
            this.b = 1;
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: aex$b */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(aex.d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    aex.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
