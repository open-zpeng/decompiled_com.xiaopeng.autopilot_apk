package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* compiled from: WindowInsetsCompat.java */
/* renamed from: gv  reason: default package */
/* loaded from: classes.dex */
public class gv {
    public static final gv a;
    private final g b;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            a = l.e;
        } else {
            a = g.a;
        }
    }

    private gv(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.b = new l(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.b = new k(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.b = new j(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.b = new i(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.b = new h(this, windowInsets);
        } else {
            this.b = new g(this);
        }
    }

    public gv(gv gvVar) {
        if (gvVar != null) {
            g gVar = gvVar.b;
            if (Build.VERSION.SDK_INT >= 30 && (gVar instanceof l)) {
                this.b = new l(this, (l) gVar);
            } else if (Build.VERSION.SDK_INT >= 29 && (gVar instanceof k)) {
                this.b = new k(this, (k) gVar);
            } else if (Build.VERSION.SDK_INT >= 28 && (gVar instanceof j)) {
                this.b = new j(this, (j) gVar);
            } else if (Build.VERSION.SDK_INT >= 21 && (gVar instanceof i)) {
                this.b = new i(this, (i) gVar);
            } else if (Build.VERSION.SDK_INT >= 20 && (gVar instanceof h)) {
                this.b = new h(this, (h) gVar);
            } else {
                this.b = new g(this);
            }
            gVar.b(this);
            return;
        }
        this.b = new g(this);
    }

    public static gv a(WindowInsets windowInsets) {
        return a(windowInsets, null);
    }

    public static gv a(WindowInsets windowInsets, View view) {
        gv gvVar = new gv((WindowInsets) fp.a(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            gvVar.a(gn.q(view));
            gvVar.a(view.getRootView());
        }
        return gvVar;
    }

    @Deprecated
    public int a() {
        return this.b.g().b;
    }

    @Deprecated
    public int b() {
        return this.b.g().c;
    }

    @Deprecated
    public int c() {
        return this.b.g().d;
    }

    @Deprecated
    public int d() {
        return this.b.g().e;
    }

    public boolean e() {
        return this.b.b();
    }

    @Deprecated
    public gv f() {
        return this.b.c();
    }

    @Deprecated
    public gv a(int i2, int i3, int i4, int i5) {
        return new b(this).a(em.a(i2, i3, i4, i5)).a();
    }

    @Deprecated
    public gv g() {
        return this.b.d();
    }

    @Deprecated
    public gv h() {
        return this.b.f();
    }

    public gv b(int i2, int i3, int i4, int i5) {
        return this.b.a(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gv) {
            return fn.a(this.b, ((gv) obj).b);
        }
        return false;
    }

    public int hashCode() {
        g gVar = this.b;
        if (gVar == null) {
            return 0;
        }
        return gVar.hashCode();
    }

    public WindowInsets i() {
        g gVar = this.b;
        if (gVar instanceof h) {
            return ((h) gVar).c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$g */
    /* loaded from: classes.dex */
    public static class g {
        static final gv a = new b().a().h().g().f();
        final gv b;

        void a(View view) {
        }

        void a(em emVar) {
        }

        void a(gv gvVar) {
        }

        public void a(em[] emVarArr) {
        }

        boolean a() {
            return false;
        }

        public void b(em emVar) {
        }

        void b(gv gvVar) {
        }

        boolean b() {
            return false;
        }

        ft e() {
            return null;
        }

        g(gv gvVar) {
            this.b = gvVar;
        }

        gv c() {
            return this.b;
        }

        gv d() {
            return this.b;
        }

        gv f() {
            return this.b;
        }

        em g() {
            return em.a;
        }

        em h() {
            return em.a;
        }

        gv a(int i, int i2, int i3, int i4) {
            return a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                return a() == gVar.a() && b() == gVar.b() && fn.a(g(), gVar.g()) && fn.a(h(), gVar.h()) && fn.a(e(), gVar.e());
            }
            return false;
        }

        public int hashCode() {
            return fn.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$h */
    /* loaded from: classes.dex */
    public static class h extends g {
        private static boolean e = false;
        private static Method f;
        private static Class<?> g;
        private static Class<?> h;
        private static Field i;
        private static Field j;
        final WindowInsets c;
        em d;
        private em[] k;
        private em l;
        private gv m;

        h(gv gvVar, WindowInsets windowInsets) {
            super(gvVar);
            this.l = null;
            this.c = windowInsets;
        }

        h(gv gvVar, h hVar) {
            this(gvVar, new WindowInsets(hVar.c));
        }

        @Override // defpackage.gv.g
        boolean a() {
            return this.c.isRound();
        }

        @Override // defpackage.gv.g
        final em g() {
            if (this.l == null) {
                this.l = em.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.l;
        }

        @Override // defpackage.gv.g
        gv a(int i2, int i3, int i4, int i5) {
            b bVar = new b(gv.a(this.c));
            bVar.a(gv.a(g(), i2, i3, i4, i5));
            bVar.b(gv.a(h(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // defpackage.gv.g
        void b(gv gvVar) {
            gvVar.a(this.m);
            gvVar.b(this.d);
        }

        @Override // defpackage.gv.g
        void a(gv gvVar) {
            this.m = gvVar;
        }

        @Override // defpackage.gv.g
        void a(em emVar) {
            this.d = emVar;
        }

        @Override // defpackage.gv.g
        void a(View view) {
            em b = b(view);
            if (b == null) {
                b = em.a;
            }
            a(b);
        }

        private em b(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!e) {
                i();
            }
            Method method = f;
            if (method == null || h == null || i == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(view, new Object[0]);
                if (invoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) i.get(j.get(invoke));
                if (rect != null) {
                    return em.a(rect);
                }
                return null;
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                return null;
            }
        }

        @Override // defpackage.gv.g
        public void a(em[] emVarArr) {
            this.k = emVarArr;
        }

        @SuppressLint({"PrivateApi"})
        private static void i() {
            try {
                f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                g = Class.forName("android.view.ViewRootImpl");
                h = Class.forName("android.view.View$AttachInfo");
                i = h.getDeclaredField("mVisibleInsets");
                j = g.getDeclaredField("mAttachInfo");
                i.setAccessible(true);
                j.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            e = true;
        }

        @Override // defpackage.gv.g
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.d, ((h) obj).d);
            }
            return false;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$i */
    /* loaded from: classes.dex */
    private static class i extends h {
        private em e;

        i(gv gvVar, WindowInsets windowInsets) {
            super(gvVar, windowInsets);
            this.e = null;
        }

        i(gv gvVar, i iVar) {
            super(gvVar, iVar);
            this.e = null;
            this.e = iVar.e;
        }

        @Override // defpackage.gv.g
        boolean b() {
            return this.c.isConsumed();
        }

        @Override // defpackage.gv.g
        gv d() {
            return gv.a(this.c.consumeStableInsets());
        }

        @Override // defpackage.gv.g
        gv c() {
            return gv.a(this.c.consumeSystemWindowInsets());
        }

        @Override // defpackage.gv.g
        final em h() {
            if (this.e == null) {
                this.e = em.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.e;
        }

        @Override // defpackage.gv.g
        public void b(em emVar) {
            this.e = emVar;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$j */
    /* loaded from: classes.dex */
    private static class j extends i {
        j(gv gvVar, WindowInsets windowInsets) {
            super(gvVar, windowInsets);
        }

        j(gv gvVar, j jVar) {
            super(gvVar, jVar);
        }

        @Override // defpackage.gv.g
        ft e() {
            return ft.a(this.c.getDisplayCutout());
        }

        @Override // defpackage.gv.g
        gv f() {
            return gv.a(this.c.consumeDisplayCutout());
        }

        @Override // defpackage.gv.h, defpackage.gv.g
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                return Objects.equals(this.c, jVar.c) && Objects.equals(this.d, jVar.d);
            }
            return false;
        }

        @Override // defpackage.gv.g
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$k */
    /* loaded from: classes.dex */
    private static class k extends j {
        private em e;
        private em f;
        private em g;

        @Override // defpackage.gv.i, defpackage.gv.g
        public void b(em emVar) {
        }

        k(gv gvVar, WindowInsets windowInsets) {
            super(gvVar, windowInsets);
            this.e = null;
            this.f = null;
            this.g = null;
        }

        k(gv gvVar, k kVar) {
            super(gvVar, kVar);
            this.e = null;
            this.f = null;
            this.g = null;
        }

        @Override // defpackage.gv.h, defpackage.gv.g
        gv a(int i, int i2, int i3, int i4) {
            return gv.a(this.c.inset(i, i2, i3, i4));
        }
    }

    static em a(em emVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, emVar.b - i2);
        int max2 = Math.max(0, emVar.c - i3);
        int max3 = Math.max(0, emVar.d - i4);
        int max4 = Math.max(0, emVar.e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? emVar : em.a(max, max2, max3, max4);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$l */
    /* loaded from: classes.dex */
    private static class l extends k {
        static final gv e = gv.a(WindowInsets.CONSUMED);

        @Override // defpackage.gv.h, defpackage.gv.g
        final void a(View view) {
        }

        l(gv gvVar, WindowInsets windowInsets) {
            super(gvVar, windowInsets);
        }

        l(gv gvVar, l lVar) {
            super(gvVar, lVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$b */
    /* loaded from: classes.dex */
    public static final class b {
        private final c a;

        public b() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.a = new f();
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.a = new e();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.a = new d();
            } else {
                this.a = new c();
            }
        }

        public b(gv gvVar) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.a = new f(gvVar);
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.a = new e(gvVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.a = new d(gvVar);
            } else {
                this.a = new c(gvVar);
            }
        }

        @Deprecated
        public b a(em emVar) {
            this.a.a(emVar);
            return this;
        }

        @Deprecated
        public b b(em emVar) {
            this.a.e(emVar);
            return this;
        }

        public gv a() {
            return this.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$c */
    /* loaded from: classes.dex */
    public static class c {
        em[] a;
        private final gv b;

        void a(em emVar) {
        }

        void b(em emVar) {
        }

        void c(em emVar) {
        }

        void d(em emVar) {
        }

        void e(em emVar) {
        }

        c() {
            this(new gv((gv) null));
        }

        c(gv gvVar) {
            this.b = gvVar;
        }

        protected final void a() {
            em[] emVarArr = this.a;
            if (emVarArr != null) {
                em emVar = emVarArr[m.a(1)];
                em emVar2 = this.a[m.a(2)];
                if (emVar != null && emVar2 != null) {
                    a(em.a(emVar, emVar2));
                } else if (emVar != null) {
                    a(emVar);
                } else if (emVar2 != null) {
                    a(emVar2);
                }
                em emVar3 = this.a[m.a(16)];
                if (emVar3 != null) {
                    b(emVar3);
                }
                em emVar4 = this.a[m.a(32)];
                if (emVar4 != null) {
                    c(emVar4);
                }
                em emVar5 = this.a[m.a(64)];
                if (emVar5 != null) {
                    d(emVar5);
                }
            }
        }

        gv b() {
            a();
            return this.b;
        }
    }

    void a(em[] emVarArr) {
        this.b.a(emVarArr);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$d */
    /* loaded from: classes.dex */
    private static class d extends c {
        private static Field b = null;
        private static boolean c = false;
        private static Constructor<WindowInsets> d = null;
        private static boolean e = false;
        private WindowInsets f;
        private em g;

        d() {
            this.f = c();
        }

        d(gv gvVar) {
            this.f = gvVar.i();
        }

        @Override // defpackage.gv.c
        void a(em emVar) {
            WindowInsets windowInsets = this.f;
            if (windowInsets != null) {
                this.f = windowInsets.replaceSystemWindowInsets(emVar.b, emVar.c, emVar.d, emVar.e);
            }
        }

        @Override // defpackage.gv.c
        void e(em emVar) {
            this.g = emVar;
        }

        @Override // defpackage.gv.c
        gv b() {
            a();
            gv a = gv.a(this.f);
            a.a(this.a);
            a.a(this.g);
            return a;
        }

        private static WindowInsets c() {
            if (!c) {
                try {
                    b = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                c = true;
            }
            Field field = b;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!e) {
                try {
                    d = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                e = true;
            }
            Constructor<WindowInsets> constructor = d;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }
    }

    void a(em emVar) {
        this.b.b(emVar);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$e */
    /* loaded from: classes.dex */
    private static class e extends c {
        final WindowInsets.Builder b;

        e() {
            this.b = new WindowInsets.Builder();
        }

        e(gv gvVar) {
            WindowInsets.Builder builder;
            WindowInsets i = gvVar.i();
            if (i != null) {
                builder = new WindowInsets.Builder(i);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.b = builder;
        }

        @Override // defpackage.gv.c
        void a(em emVar) {
            this.b.setSystemWindowInsets(emVar.a());
        }

        @Override // defpackage.gv.c
        void b(em emVar) {
            this.b.setSystemGestureInsets(emVar.a());
        }

        @Override // defpackage.gv.c
        void c(em emVar) {
            this.b.setMandatorySystemGestureInsets(emVar.a());
        }

        @Override // defpackage.gv.c
        void d(em emVar) {
            this.b.setTappableElementInsets(emVar.a());
        }

        @Override // defpackage.gv.c
        void e(em emVar) {
            this.b.setStableInsets(emVar.a());
        }

        @Override // defpackage.gv.c
        gv b() {
            a();
            gv a = gv.a(this.b.build());
            a.a(this.a);
            return a;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$f */
    /* loaded from: classes.dex */
    private static class f extends e {
        f() {
        }

        f(gv gvVar) {
            super(gvVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$m */
    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 32) {
                            if (i != 64) {
                                if (i != 128) {
                                    if (i != 256) {
                                        switch (i) {
                                            case 1:
                                                return 0;
                                            case 2:
                                                return 1;
                                            default:
                                                throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
                                        }
                                    }
                                    return 8;
                                }
                                return 7;
                            }
                            return 6;
                        }
                        return 5;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(gv gvVar) {
        this.b.a(gvVar);
    }

    void b(em emVar) {
        this.b.a(emVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        this.b.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: gv$a */
    /* loaded from: classes.dex */
    public static class a {
        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;

        static {
            try {
                a = View.class.getDeclaredField("mAttachInfo");
                a.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                b = cls.getDeclaredField("mStableInsets");
                b.setAccessible(true);
                c = cls.getDeclaredField("mContentInsets");
                c.setAccessible(true);
                d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static gv a(View view) {
            if (d && view.isAttachedToWindow()) {
                try {
                    Object obj = a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) b.get(obj);
                        Rect rect2 = (Rect) c.get(obj);
                        if (rect != null && rect2 != null) {
                            gv a2 = new b().b(em.a(rect)).a(em.a(rect2)).a();
                            a2.a(a2);
                            a2.a(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
                return null;
            }
            return null;
        }
    }
}
