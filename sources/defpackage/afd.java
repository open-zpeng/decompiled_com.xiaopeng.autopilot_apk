package defpackage;

import java.util.concurrent.Callable;
/* compiled from: RxJavaPlugins.java */
/* renamed from: afd  reason: default package */
/* loaded from: classes.dex */
public final class afd {
    static volatile adr<? super Throwable> a;
    static volatile ads<? super Runnable, ? extends Runnable> b;
    static volatile ads<? super Callable<adb>, ? extends adb> c;
    static volatile ads<? super Callable<adb>, ? extends adb> d;
    static volatile ads<? super Callable<adb>, ? extends adb> e;
    static volatile ads<? super Callable<adb>, ? extends adb> f;
    static volatile ads<? super adb, ? extends adb> g;
    static volatile ads<? super adb, ? extends adb> h;
    static volatile ads<? super acy, ? extends acy> i;
    static volatile adp<? super acy, ? super ada, ? extends ada> j;

    public static adb a(Callable<adb> callable) {
        aeb.a(callable, "Scheduler Callable can't be null");
        ads<? super Callable<adb>, ? extends adb> adsVar = c;
        if (adsVar == null) {
            return e(callable);
        }
        return a(adsVar, callable);
    }

    public static adb b(Callable<adb> callable) {
        aeb.a(callable, "Scheduler Callable can't be null");
        ads<? super Callable<adb>, ? extends adb> adsVar = e;
        if (adsVar == null) {
            return e(callable);
        }
        return a(adsVar, callable);
    }

    public static adb c(Callable<adb> callable) {
        aeb.a(callable, "Scheduler Callable can't be null");
        ads<? super Callable<adb>, ? extends adb> adsVar = f;
        if (adsVar == null) {
            return e(callable);
        }
        return a(adsVar, callable);
    }

    public static adb d(Callable<adb> callable) {
        aeb.a(callable, "Scheduler Callable can't be null");
        ads<? super Callable<adb>, ? extends adb> adsVar = d;
        if (adsVar == null) {
            return e(callable);
        }
        return a(adsVar, callable);
    }

    public static adb a(adb adbVar) {
        ads<? super adb, ? extends adb> adsVar = g;
        return adsVar == null ? adbVar : (adb) a((ads<adb, Object>) adsVar, adbVar);
    }

    public static void a(Throwable th) {
        adr<? super Throwable> adrVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!b(th)) {
            th = new adn(th);
        }
        if (adrVar != null) {
            try {
                adrVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static boolean b(Throwable th) {
        return (th instanceof adl) || (th instanceof adk) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof adi);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static adb b(adb adbVar) {
        ads<? super adb, ? extends adb> adsVar = h;
        return adsVar == null ? adbVar : (adb) a((ads<adb, Object>) adsVar, adbVar);
    }

    public static Runnable a(Runnable runnable) {
        aeb.a(runnable, "run is null");
        ads<? super Runnable, ? extends Runnable> adsVar = b;
        return adsVar == null ? runnable : (Runnable) a((ads<Runnable, Object>) adsVar, runnable);
    }

    public static <T> ada<? super T> a(acy<T> acyVar, ada<? super T> adaVar) {
        adp<? super acy, ? super ada, ? extends ada> adpVar = j;
        return adpVar != null ? (ada) a(adpVar, acyVar, adaVar) : adaVar;
    }

    public static <T> acy<T> a(acy<T> acyVar) {
        ads<? super acy, ? extends acy> adsVar = i;
        return adsVar != null ? (acy) a((ads<acy<T>, Object>) adsVar, acyVar) : acyVar;
    }

    static <T, R> R a(ads<T, R> adsVar, T t) {
        try {
            return adsVar.a(t);
        } catch (Throwable th) {
            throw afa.a(th);
        }
    }

    static <T, U, R> R a(adp<T, U, R> adpVar, T t, U u) {
        try {
            return adpVar.a(t, u);
        } catch (Throwable th) {
            throw afa.a(th);
        }
    }

    static adb e(Callable<adb> callable) {
        try {
            return (adb) aeb.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw afa.a(th);
        }
    }

    static adb a(ads<? super Callable<adb>, ? extends adb> adsVar, Callable<adb> callable) {
        return (adb) aeb.a(a((ads<Callable<adb>, Object>) adsVar, callable), "Scheduler Callable result can't be null");
    }
}
