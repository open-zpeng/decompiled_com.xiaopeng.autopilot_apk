package defpackage;

import android.view.MotionEvent;
/* compiled from: MotionEventCompat.java */
/* renamed from: fz  reason: default package */
/* loaded from: classes.dex */
public final class fz {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
