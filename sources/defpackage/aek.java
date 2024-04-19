package defpackage;

import defpackage.adb;
/* compiled from: ObservableObserveOn.java */
/* renamed from: aek  reason: default package */
/* loaded from: classes.dex */
public final class aek<T> extends aei<T, T> {
    final adb b;
    final boolean c;
    final int d;

    public aek(acz<T> aczVar, adb adbVar, boolean z, int i) {
        super(aczVar);
        this.b = adbVar;
        this.c = z;
        this.d = i;
    }

    @Override // defpackage.acy
    protected void b(ada<? super T> adaVar) {
        adb adbVar = this.b;
        if (adbVar instanceof aez) {
            this.a.a(adaVar);
            return;
        }
        this.a.a(new a(adaVar, adbVar.a(), this.c, this.d));
    }

    /* compiled from: ObservableObserveOn.java */
    /* renamed from: aek$a */
    /* loaded from: classes.dex */
    static final class a<T> extends aeg<T> implements ada<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final ada<? super T> a;
        final adb.c b;
        final boolean c;
        final int d;
        aef<T> e;
        ade f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        a(ada<? super T> adaVar, adb.c cVar, boolean z, int i) {
            this.a = adaVar;
            this.b = cVar;
            this.c = z;
            this.d = i;
        }

        @Override // defpackage.ada
        public void onSubscribe(ade adeVar) {
            if (adw.validate(this.f, adeVar)) {
                this.f = adeVar;
                if (adeVar instanceof aec) {
                    aec aecVar = (aec) adeVar;
                    int requestFusion = aecVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = aecVar;
                        this.h = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = aecVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new aem(this.d);
                this.a.onSubscribe(this);
            }
        }

        @Override // defpackage.ada
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.offer(t);
            }
            a();
        }

        @Override // defpackage.ada
        public void onError(Throwable th) {
            if (this.h) {
                afd.a(th);
                return;
            }
            this.g = th;
            this.h = true;
            a();
        }

        @Override // defpackage.ada
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            a();
        }

        @Override // defpackage.ade
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.dispose();
            this.b.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // defpackage.ade
        public boolean isDisposed() {
            return this.i;
        }

        void a() {
            if (getAndIncrement() == 0) {
                this.b.a(this);
            }
        }

        void b() {
            aef<T> aefVar = this.e;
            ada<? super T> adaVar = this.a;
            int i = 1;
            while (!a(this.h, aefVar.isEmpty(), adaVar)) {
                while (true) {
                    boolean z = this.h;
                    try {
                        Object obj = (T) aefVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, adaVar)) {
                            return;
                        }
                        if (!z2) {
                            adaVar.onNext(obj);
                        } else {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        adj.a(th);
                        this.f.dispose();
                        aefVar.clear();
                        adaVar.onError(th);
                        this.b.dispose();
                        return;
                    }
                }
            }
        }

        void c() {
            int i = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (!this.c && z && th != null) {
                    this.a.onError(th);
                    this.b.dispose();
                    return;
                }
                this.a.onNext(null);
                if (z) {
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        this.a.onError(th2);
                    } else {
                        this.a.onComplete();
                    }
                    this.b.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                c();
            } else {
                b();
            }
        }

        boolean a(boolean z, boolean z2, ada<? super T> adaVar) {
            if (this.i) {
                this.e.clear();
                return true;
            } else if (z) {
                Throwable th = this.g;
                if (this.c) {
                    if (z2) {
                        if (th != null) {
                            adaVar.onError(th);
                        } else {
                            adaVar.onComplete();
                        }
                        this.b.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.e.clear();
                    adaVar.onError(th);
                    this.b.dispose();
                    return true;
                } else if (z2) {
                    adaVar.onComplete();
                    this.b.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // defpackage.aed
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.k = true;
                return 2;
            }
            return 0;
        }

        @Override // defpackage.aef
        public T poll() throws Exception {
            return this.e.poll();
        }

        @Override // defpackage.aef
        public void clear() {
            this.e.clear();
        }

        @Override // defpackage.aef
        public boolean isEmpty() {
            return this.e.isEmpty();
        }
    }
}
