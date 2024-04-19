package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;
/* compiled from: AccessibilityRecordCompat.java */
/* renamed from: ha  reason: default package */
/* loaded from: classes.dex */
public class ha {
    private final AccessibilityRecord a;

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ha) {
            ha haVar = (ha) obj;
            AccessibilityRecord accessibilityRecord = this.a;
            if (accessibilityRecord == null) {
                if (haVar.a != null) {
                    return false;
                }
            } else if (!accessibilityRecord.equals(haVar.a)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
