package defpackage;

import defpackage.adb;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableInterval.java */
/* renamed from: aej  reason: default package */
/* loaded from: classes.dex */
public final class aej extends acy<Long> {
    final adb a;
    final long b;
    final long c;
    final TimeUnit d;

    public aej(long j, long j2, TimeUnit timeUnit, adb adbVar) {
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.a = adbVar;
    }

    @Override // defpackage.acy
    public void b(ada<? super Long> adaVar) {
        a aVar = new a(adaVar);
        adaVar.onSubscribe(aVar);
        adb adbVar = this.a;
        if (adbVar instanceof aez) {
            adb.c a2 = adbVar.a();
            aVar.a(a2);
            a2.a(aVar, this.b, this.c, this.d);
            return;
        }
        aVar.a(adbVar.a(aVar, this.b, this.c, this.d));
    }

    /* compiled from: ObservableInterval.java */
    /* renamed from: aej$a */
    /* loaded from: classes.dex */
    static final class a extends AtomicReference<ade> implements ade, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        final ada<? super Long> a;
        long b;

        a(ada<? super Long> adaVar) {
            this.a = adaVar;
        }

        @Override // defpackage.ade
        public void dispose() {
            adw.dispose(this);
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return get() == adw.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != adw.DISPOSED) {
                ada<? super Long> adaVar = this.a;
                long j = this.b;
                this.b = 1 + j;
                adaVar.onNext(Long.valueOf(j));
            }
        }

        public void a(ade adeVar) {
            adw.setOnce(this, adeVar);
        }
    }
}
