package defpackage;

import android.os.Build;
import android.view.ViewGroup;
import defpackage.dz;
/* compiled from: ViewGroupCompat.java */
/* renamed from: gp  reason: default package */
/* loaded from: classes.dex */
public final class gp {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(dz.b.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && gn.m(viewGroup) == null) ? false : true;
    }
}
