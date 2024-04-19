package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* renamed from: aeg  reason: default package */
/* loaded from: classes.dex */
public abstract class aeg<T> extends AtomicInteger implements aec<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // defpackage.aef
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
