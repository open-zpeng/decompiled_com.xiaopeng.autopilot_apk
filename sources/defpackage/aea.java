package defpackage;

import java.util.Comparator;
import java.util.concurrent.Callable;
/* compiled from: Functions.java */
/* renamed from: aea  reason: default package */
/* loaded from: classes.dex */
public final class aea {
    static final ads<Object, Object> a = new g();
    public static final Runnable b = new d();
    public static final ado c = new a();
    static final adr<Object> d = new b();
    public static final adr<Throwable> e = new e();
    public static final adr<Throwable> f = new k();
    public static final adt g = new c();
    static final adu<Object> h = new l();
    static final adu<Object> i = new f();
    static final Callable<Object> j = new j();
    static final Comparator<Object> k = new i();
    public static final adr<agj> l = new h();

    public static <T> adr<T> a() {
        return (adr<T>) d;
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$g */
    /* loaded from: classes.dex */
    static final class g implements ads<Object, Object> {
        @Override // defpackage.ads
        public Object a(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        g() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$d */
    /* loaded from: classes.dex */
    static final class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        d() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$a */
    /* loaded from: classes.dex */
    static final class a implements ado {
        @Override // defpackage.ado
        public void a() {
        }

        public String toString() {
            return "EmptyAction";
        }

        a() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$b */
    /* loaded from: classes.dex */
    static final class b implements adr<Object> {
        @Override // defpackage.adr
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        b() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$e */
    /* loaded from: classes.dex */
    static final class e implements adr<Throwable> {
        e() {
        }

        @Override // defpackage.adr
        /* renamed from: a */
        public void accept(Throwable th) {
            afd.a(th);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$k */
    /* loaded from: classes.dex */
    static final class k implements adr<Throwable> {
        k() {
        }

        @Override // defpackage.adr
        /* renamed from: a */
        public void accept(Throwable th) {
            afd.a(new adl(th));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$c */
    /* loaded from: classes.dex */
    static final class c implements adt {
        c() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$l */
    /* loaded from: classes.dex */
    static final class l implements adu<Object> {
        l() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$f */
    /* loaded from: classes.dex */
    static final class f implements adu<Object> {
        f() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$j */
    /* loaded from: classes.dex */
    static final class j implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        j() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$i */
    /* loaded from: classes.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: aea$h */
    /* loaded from: classes.dex */
    static final class h implements adr<agj> {
        h() {
        }

        @Override // defpackage.adr
        /* renamed from: a */
        public void accept(agj agjVar) throws Exception {
            agjVar.a(Long.MAX_VALUE);
        }
    }
}
