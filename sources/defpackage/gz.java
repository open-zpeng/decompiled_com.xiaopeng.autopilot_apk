package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AccessibilityNodeProviderCompat.java */
/* renamed from: gz  reason: default package */
/* loaded from: classes.dex */
public class gz {
    private final Object a;

    public gy a(int i) {
        return null;
    }

    public List<gy> a(String str, int i) {
        return null;
    }

    public void a(int i, gy gyVar, String str, Bundle bundle) {
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public gy b(int i) {
        return null;
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: gz$a */
    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {
        final gz a;

        a(gz gzVar) {
            this.a = gzVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            gy a = this.a.a(i);
            if (a == null) {
                return null;
            }
            return a.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<gy> a = this.a.a(str, i);
            if (a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a.get(i2).a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.a(i, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: gz$b */
    /* loaded from: classes.dex */
    static class b extends a {
        b(gz gzVar) {
            super(gzVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            gy b = this.a.b(i);
            if (b == null) {
                return null;
            }
            return b.a();
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: gz$c */
    /* loaded from: classes.dex */
    static class c extends b {
        c(gz gzVar) {
            super(gzVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.a(i, gy.a(accessibilityNodeInfo), str, bundle);
        }
    }

    public gz() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new c(this);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.a = new a(this);
        } else {
            this.a = null;
        }
    }

    public gz(Object obj) {
        this.a = obj;
    }

    public Object a() {
        return this.a;
    }
}
