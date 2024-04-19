package defpackage;

import android.os.Trace;
/* compiled from: TraceApi18Impl.java */
/* renamed from: hx  reason: default package */
/* loaded from: classes.dex */
final class hx {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void a() {
        Trace.endSection();
    }
}
