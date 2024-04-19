package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.protobuf.CodedOutputStream;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.xui.app.XDialogSystemType;
import defpackage.dz;
import defpackage.hb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: gy  reason: default package */
/* loaded from: classes.dex */
public class gy {
    private static int d;
    private final AccessibilityNodeInfo b;
    public int a = -1;
    private int c = -1;

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case 4:
                                        return "ACTION_SELECT";
                                    case 8:
                                        return "ACTION_CLEAR_SELECTION";
                                    case 16:
                                        return "ACTION_CLICK";
                                    case 32:
                                        return "ACTION_LONG_CLICK";
                                    case 64:
                                        return "ACTION_ACCESSIBILITY_FOCUS";
                                    case 128:
                                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                                    case IRadioController.TEF663x_PCHANNEL /* 256 */:
                                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                                    case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                                    case 1024:
                                        return "ACTION_NEXT_HTML_ELEMENT";
                                    case XDialogSystemType.TYPE_LIFECYCLE_DIALOG /* 2048 */:
                                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                                    case CodedOutputStream.DEFAULT_BUFFER_SIZE /* 4096 */:
                                        return "ACTION_SCROLL_FORWARD";
                                    case 8192:
                                        return "ACTION_SCROLL_BACKWARD";
                                    case 16384:
                                        return "ACTION_COPY";
                                    case 32768:
                                        return "ACTION_PASTE";
                                    case 65536:
                                        return "ACTION_CUT";
                                    case 131072:
                                        return "ACTION_SET_SELECTION";
                                    case 262144:
                                        return "ACTION_EXPAND";
                                    case 524288:
                                        return "ACTION_COLLAPSE";
                                    case 2097152:
                                        return "ACTION_SET_TEXT";
                                    case 16908354:
                                        return "ACTION_MOVE_WINDOW";
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: gy$a */
    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a a = new a(1, null);
        public static final a b = new a(2, null);
        public static final a c = new a(4, null);
        public static final a d = new a(8, null);
        public static final a e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(IRadioController.TEF663x_PCHANNEL, null, hb.b.class);
        public static final a j = new a(IInputController.KEYCODE_BACK_BUTTON, null, hb.b.class);
        public static final a k = new a(1024, null, hb.c.class);
        public static final a l = new a(XDialogSystemType.TYPE_LIFECYCLE_DIALOG, null, hb.c.class);
        public static final a m = new a(CodedOutputStream.DEFAULT_BUFFER_SIZE, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null, hb.g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null, hb.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object N;
        protected final hb O;
        private final int P;
        private final Class<? extends hb.a> Q;

        static {
            w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, hb.e.class);
            y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, hb.f.class);
            I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, hb.d.class);
            J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            L = new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            M = new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends hb.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, hb hbVar, Class<? extends hb.a> cls) {
            this.P = i2;
            this.O = hbVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.N = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.N = obj;
            }
            this.Q = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getLabel();
            }
            return null;
        }

        public boolean a(View view, Bundle bundle) {
            hb.a newInstance;
            if (this.O != null) {
                hb.a aVar = null;
                Class<? extends hb.a> cls = this.Q;
                if (cls != null) {
                    try {
                        newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        newInstance.a(bundle);
                        aVar = newInstance;
                    } catch (Exception e3) {
                        e = e3;
                        aVar = newInstance;
                        Class<? extends hb.a> cls2 = this.Q;
                        String name = cls2 == null ? "null" : cls2.getName();
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                        return this.O.a(view, aVar);
                    }
                }
                return this.O.a(view, aVar);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.N;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                Object obj2 = this.N;
                return obj2 == null ? aVar.N == null : obj2.equals(aVar.N);
            }
            return false;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: gy$b */
    /* loaded from: classes.dex */
    public static class b {
        final Object a;

        public static b a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b(null);
        }

        b(Object obj) {
            this.a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: gy$c */
    /* loaded from: classes.dex */
    public static class c {
        final Object a;

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c(null);
        }

        c(Object obj) {
            this.a = obj;
        }
    }

    private gy(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    public static gy a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new gy(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.b;
    }

    public int b() {
        return this.b.getActions();
    }

    public void a(int i) {
        this.b.addAction(i);
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.b.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.b.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.N);
        }
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.performAction(i, bundle);
        }
        return false;
    }

    public void a(View view) {
        this.a = -1;
        this.b.setParent(view);
    }

    @Deprecated
    public void a(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    public void b(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public boolean c() {
        return this.b.isCheckable();
    }

    public boolean d() {
        return this.b.isChecked();
    }

    public boolean e() {
        return this.b.isFocusable();
    }

    public boolean f() {
        return this.b.isFocused();
    }

    public boolean g() {
        return this.b.isSelected();
    }

    public boolean h() {
        return this.b.isClickable();
    }

    public boolean i() {
        return this.b.isLongClickable();
    }

    public boolean j() {
        return this.b.isEnabled();
    }

    public boolean k() {
        return this.b.isPassword();
    }

    public boolean l() {
        return this.b.isScrollable();
    }

    public void a(boolean z) {
        this.b.setScrollable(z);
    }

    public CharSequence m() {
        return this.b.getPackageName();
    }

    public CharSequence n() {
        return this.b.getClassName();
    }

    public void a(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public CharSequence o() {
        if (t()) {
            List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.b.getText(), 0, this.b.getText().length()));
            for (int i = 0; i < a2.size(); i++) {
                spannableString.setSpan(new gw(a5.get(i).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
            }
            return spannableString;
        }
        return this.b.getText();
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        u();
        d(view);
        ClickableSpan[] b2 = b(charSequence);
        if (b2 == null || b2.length <= 0) {
            return;
        }
        s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", dz.b.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> b3 = b(view);
        for (int i = 0; b2 != null && i < b2.length; i++) {
            int a2 = a(b2[i], b3);
            b3.put(a2, new WeakReference<>(b2[i]));
            a(b2[i], (Spanned) charSequence, a2);
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> b(View view) {
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        if (c2 == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(dz.b.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return c2;
    }

    private SparseArray<WeakReference<ClickableSpan>> c(View view) {
        return (SparseArray) view.getTag(dz.b.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] b(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    private boolean t() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void u() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void d(View view) {
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < c2.size(); i++) {
                if (c2.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                c2.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public CharSequence p() {
        return this.b.getContentDescription();
    }

    public void c(CharSequence charSequence) {
        if (fa.a()) {
            this.b.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public String q() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.b.getViewIdResourceName();
        }
        return null;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).a);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).a);
        }
    }

    public List<a> r() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.b.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new a(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public Bundle s() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.b.getExtras();
        }
        return new Bundle();
    }

    public void d(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void b(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void c(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof gy)) {
            gy gyVar = (gy) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.b;
            if (accessibilityNodeInfo == null) {
                if (gyVar.b != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(gyVar.b)) {
                return false;
            }
            return this.c == gyVar.c && this.a == gyVar.a;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m());
        sb.append("; className: ");
        sb.append(n());
        sb.append("; text: ");
        sb.append(o());
        sb.append("; contentDescription: ");
        sb.append(p());
        sb.append("; viewId: ");
        sb.append(q());
        sb.append("; checkable: ");
        sb.append(c());
        sb.append("; checked: ");
        sb.append(d());
        sb.append("; focusable: ");
        sb.append(e());
        sb.append("; focused: ");
        sb.append(f());
        sb.append("; selected: ");
        sb.append(g());
        sb.append("; clickable: ");
        sb.append(h());
        sb.append("; longClickable: ");
        sb.append(i());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(k());
        sb.append("; scrollable: " + l());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> r = r();
            for (int i = 0; i < r.size(); i++) {
                a aVar = r.get(i);
                String b2 = b(aVar.a());
                if (b2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    b2 = aVar.b().toString();
                }
                sb.append(b2);
                if (i != r.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int b3 = b();
            while (b3 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b3);
                b3 &= ~numberOfTrailingZeros;
                sb.append(b(numberOfTrailingZeros));
                if (b3 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(int i, boolean z) {
        Bundle s = s();
        if (s != null) {
            int i2 = s.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            s.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
