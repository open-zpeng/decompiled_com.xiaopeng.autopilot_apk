package defpackage;

import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* renamed from: afe  reason: default package */
/* loaded from: classes.dex */
public final class afe {
    static final adb a = afd.d(new h());
    static final adb b = afd.a(new b());
    static final adb c = afd.b(new c());
    static final adb d = aez.c();
    static final adb e = afd.c(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: afe$a */
    /* loaded from: classes.dex */
    public static final class a {
        static final adb a = new aeo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: afe$d */
    /* loaded from: classes.dex */
    public static final class d {
        static final adb a = new aeq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: afe$e */
    /* loaded from: classes.dex */
    public static final class e {
        static final adb a = new aer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: afe$g */
    /* loaded from: classes.dex */
    public static final class g {
        static final adb a = new aey();
    }

    public static adb a() {
        return afd.a(b);
    }

    public static adb b() {
        return afd.b(c);
    }

    /* compiled from: Schedulers.java */
    /* renamed from: afe$c */
    /* loaded from: classes.dex */
    static final class c implements Callable<adb> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public adb call() throws Exception {
            return d.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: afe$f */
    /* loaded from: classes.dex */
    static final class f implements Callable<adb> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public adb call() throws Exception {
            return e.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: afe$h */
    /* loaded from: classes.dex */
    static final class h implements Callable<adb> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public adb call() throws Exception {
            return g.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: afe$b */
    /* loaded from: classes.dex */
    static final class b implements Callable<adb> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public adb call() throws Exception {
            return a.a;
        }
    }
}
