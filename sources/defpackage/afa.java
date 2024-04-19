package defpackage;
/* compiled from: ExceptionHelper.java */
/* renamed from: afa  reason: default package */
/* loaded from: classes.dex */
public final class afa {
    public static final Throwable a = new a();

    public static RuntimeException a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        return new RuntimeException(th);
    }

    /* compiled from: ExceptionHelper.java */
    /* renamed from: afa$a */
    /* loaded from: classes.dex */
    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        a() {
            super("No further exceptions");
        }
    }
}
