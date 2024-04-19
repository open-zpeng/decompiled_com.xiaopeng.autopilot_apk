package defpackage;

import android.os.Build;
import android.view.Gravity;
/* compiled from: GravityCompat.java */
/* renamed from: fu  reason: default package */
/* loaded from: classes.dex */
public final class fu {
    public static int a(int i, int i2) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : i & (-8388609);
    }
}
