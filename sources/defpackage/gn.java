package defpackage;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.xiaopeng.xui.app.XDialogSystemType;
import defpackage.dz;
import defpackage.fq;
import defpackage.gv;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: gn  reason: default package */
/* loaded from: classes.dex */
public class gn {
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static Field h;
    private static ThreadLocal<Rect> j;
    private static final AtomicInteger a = new AtomicInteger(1);
    private static WeakHashMap<View, gr> g = null;
    private static boolean i = false;
    private static final int[] k = {dz.b.accessibility_custom_action_0, dz.b.accessibility_custom_action_1, dz.b.accessibility_custom_action_2, dz.b.accessibility_custom_action_3, dz.b.accessibility_custom_action_4, dz.b.accessibility_custom_action_5, dz.b.accessibility_custom_action_6, dz.b.accessibility_custom_action_7, dz.b.accessibility_custom_action_8, dz.b.accessibility_custom_action_9, dz.b.accessibility_custom_action_10, dz.b.accessibility_custom_action_11, dz.b.accessibility_custom_action_12, dz.b.accessibility_custom_action_13, dz.b.accessibility_custom_action_14, dz.b.accessibility_custom_action_15, dz.b.accessibility_custom_action_16, dz.b.accessibility_custom_action_17, dz.b.accessibility_custom_action_18, dz.b.accessibility_custom_action_19, dz.b.accessibility_custom_action_20, dz.b.accessibility_custom_action_21, dz.b.accessibility_custom_action_22, dz.b.accessibility_custom_action_23, dz.b.accessibility_custom_action_24, dz.b.accessibility_custom_action_25, dz.b.accessibility_custom_action_26, dz.b.accessibility_custom_action_27, dz.b.accessibility_custom_action_28, dz.b.accessibility_custom_action_29, dz.b.accessibility_custom_action_30, dz.b.accessibility_custom_action_31};
    private static final gk l = new gk() { // from class: gn.1
        @Override // defpackage.gk
        public fs onReceiveContent(fs fsVar) {
            return fsVar;
        }
    };
    private static a m = new a();

    /* compiled from: ViewCompat.java */
    /* renamed from: gn$f */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(View view, KeyEvent keyEvent);
    }

    private static Rect a() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void a(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void a(View view, fq fqVar) {
        if (fqVar == null && (C(view) instanceof fq.a)) {
            fqVar = new fq();
        }
        view.setAccessibilityDelegate(fqVar == null ? null : fqVar.a());
    }

    @SuppressLint({"InlinedApi"})
    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static fq b(View view) {
        View.AccessibilityDelegate C = C(view);
        if (C == null) {
            return null;
        }
        if (C instanceof fq.a) {
            return ((fq.a) C).a;
        }
        return new fq(C);
    }

    private static View.AccessibilityDelegate C(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return D(view);
    }

    private static View.AccessibilityDelegate D(View view) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                h = View.class.getDeclaredField("mAccessibilityDelegate");
                h.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return null;
            }
        }
        try {
            Object obj = h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            i = true;
            return null;
        }
    }

    public static boolean c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void b(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static final CharSequence f(View view) {
        return d().c(view);
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int h(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static int i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                b = View.class.getDeclaredField("mMinWidth");
                b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            c = true;
        }
        Field field = b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinHeight");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            e = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static gr k(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        gr grVar = g.get(view);
        if (grVar == null) {
            gr grVar2 = new gr(view);
            g.put(view, grVar2);
            return grVar2;
        }
        return grVar;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float l(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    public static String m(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void o(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void a(View view, gi giVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.a(view, giVar);
        }
    }

    public static gv a(View view, gv gvVar) {
        WindowInsets i2;
        if (Build.VERSION.SDK_INT >= 21 && (i2 = gvVar.i()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(i2);
            if (!onApplyWindowInsets.equals(i2)) {
                return gv.a(onApplyWindowInsets, view);
            }
        }
        return gvVar;
    }

    public static gv b(View view, gv gvVar) {
        WindowInsets i2;
        if (Build.VERSION.SDK_INT >= 21 && (i2 = gvVar.i()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(i2);
            if (!dispatchApplyWindowInsets.equals(i2)) {
                return gv.a(dispatchApplyWindowInsets, view);
            }
        }
        return gvVar;
    }

    public static gv q(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a(view);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return c.a(view);
        }
        return null;
    }

    public static gv a(View view, gv gvVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(view, gvVar, rect) : gvVar;
    }

    public static String[] r(View view) {
        return (String[]) view.getTag(dz.b.tag_on_receive_content_mime_types);
    }

    public static fs a(View view, fs fsVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + fsVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        gj gjVar = (gj) view.getTag(dz.b.tag_on_receive_content_listener);
        if (gjVar != null) {
            fs a2 = gjVar.a(view, fsVar);
            if (a2 == null) {
                return null;
            }
            return E(view).onReceiveContent(a2);
        }
        return E(view).onReceiveContent(fsVar);
    }

    private static gk E(View view) {
        if (view instanceof gk) {
            return (gk) view;
        }
        return l;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static ColorStateList s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof gm) {
            return ((gm) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof gm) {
            ((gm) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof gm) {
            return ((gm) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof gm) {
            ((gm) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof ga) {
            ((ga) view).stopNestedScroll();
        }
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect a2 = a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            f(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
            }
        } else {
            f(view, i2);
        }
    }

    private static void f(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            F(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                F((View) parent);
            }
        }
    }

    public static void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect a2 = a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            g(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
            }
        } else {
            g(view, i2);
        }
    }

    private static void g(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            F(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                F((View) parent);
            }
        }
    }

    private static void F(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static boolean w(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static Display y(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (w(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(view, keyEvent);
    }

    public static boolean z(View view) {
        Boolean c2 = b().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static b<Boolean> b() {
        return new b<Boolean>(dz.b.tag_screen_reader_focusable, Boolean.class, 28) { // from class: gn.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // defpackage.gn.b
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        };
    }

    public static CharSequence A(View view) {
        return c().c(view);
    }

    private static b<CharSequence> c() {
        return new b<CharSequence>(dz.b.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: gn.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // defpackage.gn.b
            /* renamed from: a */
            public CharSequence b(View view) {
                return view.getAccessibilityPaneTitle();
            }
        };
    }

    private static b<CharSequence> d() {
        return new b<CharSequence>(dz.b.tag_state_description, CharSequence.class, 64, 30) { // from class: gn.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // defpackage.gn.b
            /* renamed from: a */
            public CharSequence b(View view) {
                return view.getStateDescription();
            }
        };
    }

    public static boolean B(View view) {
        Boolean c2 = e().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static b<Boolean> e() {
        return new b<Boolean>(dz.b.tag_accessibility_heading, Boolean.class, 28) { // from class: gn.5
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // defpackage.gn.b
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* renamed from: gn$b */
    /* loaded from: classes.dex */
    public static abstract class b<T> {
        private final int a;
        private final Class<T> b;
        private final int c;
        private final int d;

        abstract T b(View view);

        b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        b(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }

        T c(View view) {
            if (a()) {
                return b(view);
            }
            if (b()) {
                T t = (T) view.getTag(this.a);
                if (this.b.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }
    }

    static void e(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = A(view) != null && view.getVisibility() == 0;
            if (h(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : XDialogSystemType.TYPE_LIFECYCLE_DIALOG);
                obtain.setContentChangeTypes(i2);
                if (z) {
                    obtain.getText().add(A(view));
                    G(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(A(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    private static void G(View view) {
        if (e(view) == 0) {
            b(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (e((View) parent) == 4) {
                b(view, 2);
                return;
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: gn$a */
    /* loaded from: classes.dex */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private WeakHashMap<View, Boolean> a = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.a.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                gn.e(view, z2 ? 16 : 32);
                this.a.put(view, Boolean.valueOf(z2));
            }
        }

        private void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: gn$g */
    /* loaded from: classes.dex */
    static class g {
        private static final ArrayList<WeakReference<View>> a = new ArrayList<>();
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        g() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        static g a(View view) {
            g gVar = (g) view.getTag(dz.b.tag_unhandled_key_event_manager);
            if (gVar == null) {
                g gVar2 = new g();
                view.setTag(dz.b.tag_unhandled_key_event_manager, gVar2);
                return gVar2;
            }
            return gVar;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b));
                }
            }
            return b != null;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View b = b(viewGroup.getChildAt(childCount), keyEvent);
                    if (b != null) {
                        return b;
                    }
                }
            }
            if (c(view, keyEvent)) {
                return view;
            }
            return null;
        }

        boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.d;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.d = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> a2 = a();
                if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = a2.valueAt(indexOfKey);
                    a2.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = a2.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && gn.w(view)) {
                        c(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(dz.b.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((f) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (a.isEmpty()) {
                return;
            }
            synchronized (a) {
                if (this.b == null) {
                    this.b = new WeakHashMap<>();
                }
                for (int size = a.size() - 1; size >= 0; size--) {
                    View view = a.get(size).get();
                    if (view == null) {
                        a.remove(size);
                    } else {
                        this.b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: gn$c */
    /* loaded from: classes.dex */
    private static class c {
        public static gv a(View view) {
            return gv.a.a(view);
        }

        static gv a(View view, gv gvVar, Rect rect) {
            WindowInsets i = gvVar.i();
            if (i != null) {
                return gv.a(view.computeSystemWindowInsets(i, rect), view);
            }
            rect.setEmpty();
            return gvVar;
        }

        static void a(final View view, final gi giVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(dz.b.tag_on_apply_window_listener, giVar);
            }
            if (giVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(dz.b.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: gn.c.1
                    gv a = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        gv a = gv.a(windowInsets, view2);
                        if (Build.VERSION.SDK_INT < 30) {
                            c.a(windowInsets, view);
                            if (a.equals(this.a)) {
                                return giVar.a(view2, a).i();
                            }
                        }
                        this.a = a;
                        gv a2 = giVar.a(view2, a);
                        if (Build.VERSION.SDK_INT >= 30) {
                            return a2.i();
                        }
                        gn.o(view2);
                        return a2.i();
                    }
                });
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(dz.b.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: gn$d */
    /* loaded from: classes.dex */
    private static class d {
        public static gv a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            gv a = gv.a(rootWindowInsets);
            a.a(a);
            a.a(view.getRootView());
            return a;
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: gn$e */
    /* loaded from: classes.dex */
    private static class e {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }
}
