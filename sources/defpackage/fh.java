package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import defpackage.fi;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontRequestWorker.java */
/* renamed from: fh  reason: default package */
/* loaded from: classes.dex */
public class fh {
    static final as<String, Typeface> a = new as<>(16);
    private static final ExecutorService d = fj.a("fonts-androidx", 10, 10000);
    static final Object b = new Object();
    static final au<String, ArrayList<fl<a>>> c = new au<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface a(final Context context, final fg fgVar, fd fdVar, final int i, int i2) {
        final String a2 = a(fgVar, i);
        Typeface a3 = a.a((as<String, Typeface>) a2);
        if (a3 != null) {
            fdVar.a(new a(a3));
            return a3;
        } else if (i2 == -1) {
            a a4 = a(a2, context, fgVar, i);
            fdVar.a(a4);
            return a4.a;
        } else {
            try {
                a aVar = (a) fj.a(d, new Callable<a>() { // from class: fh.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public a call() {
                        return fh.a(a2, context, fgVar, i);
                    }
                }, i2);
                fdVar.a(aVar);
                return aVar.a;
            } catch (InterruptedException unused) {
                fdVar.a(new a(-3));
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface a(final Context context, final fg fgVar, final int i, Executor executor, final fd fdVar) {
        final String a2 = a(fgVar, i);
        Typeface a3 = a.a((as<String, Typeface>) a2);
        if (a3 != null) {
            fdVar.a(new a(a3));
            return a3;
        }
        fl<a> flVar = new fl<a>() { // from class: fh.2
            @Override // defpackage.fl
            public void a(a aVar) {
                fd.this.a(aVar);
            }
        };
        synchronized (b) {
            ArrayList<fl<a>> arrayList = c.get(a2);
            if (arrayList != null) {
                arrayList.add(flVar);
                return null;
            }
            ArrayList<fl<a>> arrayList2 = new ArrayList<>();
            arrayList2.add(flVar);
            c.put(a2, arrayList2);
            Callable<a> callable = new Callable<a>() { // from class: fh.3
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public a call() {
                    return fh.a(a2, context, fgVar, i);
                }
            };
            if (executor == null) {
                executor = d;
            }
            fj.a(executor, callable, new fl<a>() { // from class: fh.4
                @Override // defpackage.fl
                public void a(a aVar) {
                    synchronized (fh.b) {
                        ArrayList<fl<a>> arrayList3 = fh.c.get(a2);
                        if (arrayList3 == null) {
                            return;
                        }
                        fh.c.remove(a2);
                        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                            arrayList3.get(i2).a(aVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    private static String a(fg fgVar, int i) {
        return fgVar.f() + "-" + i;
    }

    static a a(String str, Context context, fg fgVar, int i) {
        Typeface a2 = a.a((as<String, Typeface>) str);
        if (a2 != null) {
            return new a(a2);
        }
        try {
            fi.a a3 = ff.a(context, fgVar, (CancellationSignal) null);
            int a4 = a(a3);
            if (a4 != 0) {
                return new a(a4);
            }
            Typeface a5 = eo.a(context, null, a3.b(), i);
            if (a5 != null) {
                a.a(str, a5);
                return new a(a5);
            }
            return new a(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new a(-1);
        }
    }

    @SuppressLint({"WrongConstant"})
    private static int a(fi.a aVar) {
        if (aVar.a() != 0) {
            return aVar.a() != 1 ? -3 : -2;
        }
        fi.b[] b2 = aVar.b();
        if (b2 == null || b2.length == 0) {
            return 1;
        }
        for (fi.b bVar : b2) {
            int e = bVar.e();
            if (e != 0) {
                if (e < 0) {
                    return -3;
                }
                return e;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* renamed from: fh$a */
    /* loaded from: classes.dex */
    public static final class a {
        final Typeface a;
        final int b;

        a(int i) {
            this.a = null;
            this.b = i;
        }

        @SuppressLint({"WrongConstant"})
        a(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.b == 0;
        }
    }
}
