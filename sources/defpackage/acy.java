package defpackage;

import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* renamed from: acy  reason: default package */
/* loaded from: classes.dex */
public abstract class acy<T> implements acz<T> {
    protected abstract void b(ada<? super T> adaVar);

    public static int a() {
        return acw.a();
    }

    public static acy<Long> a(long j, long j2, TimeUnit timeUnit, adb adbVar) {
        aeb.a(timeUnit, "unit is null");
        aeb.a(adbVar, "scheduler is null");
        return afd.a(new aej(Math.max(0L, j), Math.max(0L, j2), timeUnit, adbVar));
    }

    public static acy<Long> a(long j, TimeUnit timeUnit) {
        return a(j, j, timeUnit, afe.a());
    }

    public final acy<T> a(adb adbVar) {
        return a(adbVar, false, a());
    }

    public final acy<T> a(adb adbVar, boolean z, int i) {
        aeb.a(adbVar, "scheduler is null");
        aeb.a(i, "bufferSize");
        return afd.a(new aek(this, adbVar, z, i));
    }

    public final ade a(adr<? super T> adrVar, adr<? super Throwable> adrVar2) {
        return a(adrVar, adrVar2, aea.c, aea.a());
    }

    public final ade a(adr<? super T> adrVar, adr<? super Throwable> adrVar2, ado adoVar, adr<? super ade> adrVar3) {
        aeb.a(adrVar, "onNext is null");
        aeb.a(adrVar2, "onError is null");
        aeb.a(adoVar, "onComplete is null");
        aeb.a(adrVar3, "onSubscribe is null");
        aeh aehVar = new aeh(adrVar, adrVar2, adoVar, adrVar3);
        a(aehVar);
        return aehVar;
    }

    @Override // defpackage.acz
    public final void a(ada<? super T> adaVar) {
        aeb.a(adaVar, "observer is null");
        try {
            ada<? super T> a = afd.a(this, adaVar);
            aeb.a(a, "Plugin returned null Observer");
            b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            adj.a(th);
            afd.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final acy<T> b(adb adbVar) {
        aeb.a(adbVar, "scheduler is null");
        return afd.a(new ael(this, adbVar));
    }
}
