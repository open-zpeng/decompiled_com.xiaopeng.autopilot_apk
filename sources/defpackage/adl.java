package defpackage;
/* compiled from: OnErrorNotImplementedException.java */
/* renamed from: adl  reason: default package */
/* loaded from: classes.dex */
public final class adl extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public adl(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
