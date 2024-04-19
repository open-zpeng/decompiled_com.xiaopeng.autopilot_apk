package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* renamed from: aeh  reason: default package */
/* loaded from: classes.dex */
public final class aeh<T> extends AtomicReference<ade> implements ada<T>, ade {
    private static final long serialVersionUID = -7251123623727029452L;
    final adr<? super T> a;
    final adr<? super Throwable> b;
    final ado c;
    final adr<? super ade> d;

    public aeh(adr<? super T> adrVar, adr<? super Throwable> adrVar2, ado adoVar, adr<? super ade> adrVar3) {
        this.a = adrVar;
        this.b = adrVar2;
        this.c = adoVar;
        this.d = adrVar3;
    }

    @Override // defpackage.ada
    public void onSubscribe(ade adeVar) {
        if (adw.setOnce(this, adeVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                adj.a(th);
                adeVar.dispose();
                onError(th);
            }
        }
    }

    @Override // defpackage.ada
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            adj.a(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // defpackage.ada
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        lazySet(adw.DISPOSED);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            adj.a(th2);
            afd.a(new adi(th, th2));
        }
    }

    @Override // defpackage.ada
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(adw.DISPOSED);
        try {
            this.c.a();
        } catch (Throwable th) {
            adj.a(th);
            afd.a(th);
        }
    }

    @Override // defpackage.ade
    public void dispose() {
        adw.dispose(this);
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return get() == adw.DISPOSED;
    }
}
