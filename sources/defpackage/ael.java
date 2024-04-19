package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* renamed from: ael  reason: default package */
/* loaded from: classes.dex */
public final class ael<T> extends aei<T, T> {
    final adb b;

    public ael(acz<T> aczVar, adb adbVar) {
        super(aczVar);
        this.b = adbVar;
    }

    @Override // defpackage.acy
    public void b(ada<? super T> adaVar) {
        a aVar = new a(adaVar);
        adaVar.onSubscribe(aVar);
        aVar.a(this.b.a(new b(aVar)));
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: ael$a */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<ade> implements ada<T>, ade {
        private static final long serialVersionUID = 8094547886072529208L;
        final ada<? super T> a;
        final AtomicReference<ade> b = new AtomicReference<>();

        a(ada<? super T> adaVar) {
            this.a = adaVar;
        }

        @Override // defpackage.ada
        public void onSubscribe(ade adeVar) {
            adw.setOnce(this.b, adeVar);
        }

        @Override // defpackage.ada
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // defpackage.ada
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // defpackage.ada
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // defpackage.ade
        public void dispose() {
            adw.dispose(this.b);
            adw.dispose(this);
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return adw.isDisposed(get());
        }

        void a(ade adeVar) {
            adw.setOnce(this, adeVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: ael$b */
    /* loaded from: classes.dex */
    final class b implements Runnable {
        private final a<T> b;

        b(a<T> aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ael.this.a.a(this.b);
        }
    }
}
