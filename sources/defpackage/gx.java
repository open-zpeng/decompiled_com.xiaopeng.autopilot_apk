package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: AccessibilityEventCompat.java */
/* renamed from: gx  reason: default package */
/* loaded from: classes.dex */
public final class gx {
    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
