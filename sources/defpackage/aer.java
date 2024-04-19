package defpackage;

import defpackage.adb;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* renamed from: aer  reason: default package */
/* loaded from: classes.dex */
public final class aer extends adb {
    private static final aet c = new aet("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory b;

    public aer() {
        this(c);
    }

    public aer(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }

    @Override // defpackage.adb
    public adb.c a() {
        return new aes(this.b);
    }
}
