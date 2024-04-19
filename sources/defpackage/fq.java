package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import defpackage.dz;
import defpackage.gy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: fq  reason: default package */
/* loaded from: classes.dex */
public class fq {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b;
    private final View.AccessibilityDelegate c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: fq$a */
    /* loaded from: classes.dex */
    public static final class a extends View.AccessibilityDelegate {
        final fq a;

        a(fq fqVar) {
            this.a = fqVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            gy a = gy.a(accessibilityNodeInfo);
            a.b(gn.z(view));
            a.c(gn.B(view));
            a.d(gn.A(view));
            a.c(gn.f(view));
            this.a.a(view, a);
            a.a(accessibilityNodeInfo.getText(), view);
            List<gy.a> b = fq.b(view);
            for (int i = 0; i < b.size(); i++) {
                a.a(b.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            gz a = this.a.a(view);
            if (a != null) {
                return (AccessibilityNodeProvider) a.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.a(view, i, bundle);
        }
    }

    public fq() {
        this(a);
    }

    public fq(View.AccessibilityDelegate accessibilityDelegate) {
        this.b = accessibilityDelegate;
        this.c = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.c;
    }

    public void a(View view, int i) {
        this.b.sendAccessibilityEvent(view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, gy gyVar) {
        this.b.onInitializeAccessibilityNodeInfo(view, gyVar.a());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public gz a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new gz(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        List<gy.a> b = b(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= b.size()) {
                break;
            }
            gy.a aVar = b.get(i2);
            if (aVar.a() == i) {
                z = aVar.a(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.b.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != dz.b.accessibility_action_clickable_span) ? z : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(dz.b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (a(clickableSpan, view)) {
            clickableSpan.onClick(view);
            return true;
        }
        return false;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] b = gy.b(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; b != null && i < b.length; i++) {
                if (clickableSpan.equals(b[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<gy.a> b(View view) {
        List<gy.a> list = (List) view.getTag(dz.b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
