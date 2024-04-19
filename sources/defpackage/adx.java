package defpackage;
/* compiled from: EmptyDisposable.java */
/* renamed from: adx  reason: default package */
/* loaded from: classes.dex */
public enum adx implements aec<Object> {
    INSTANCE,
    NEVER;

    @Override // defpackage.aef
    public void clear() {
    }

    @Override // defpackage.ade
    public void dispose() {
    }

    @Override // defpackage.aef
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.aef
    public Object poll() throws Exception {
        return null;
    }

    @Override // defpackage.aed
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(ada<?> adaVar) {
        adaVar.onSubscribe(INSTANCE);
        adaVar.onComplete();
    }

    public static void complete(acx<?> acxVar) {
        acxVar.a(INSTANCE);
        acxVar.a();
    }

    public static void error(Throwable th, ada<?> adaVar) {
        adaVar.onSubscribe(INSTANCE);
        adaVar.onError(th);
    }

    public static void complete(acv acvVar) {
        acvVar.a(INSTANCE);
        acvVar.a();
    }

    public static void error(Throwable th, acv acvVar) {
        acvVar.a(INSTANCE);
        acvVar.a(th);
    }

    public static void error(Throwable th, adc<?> adcVar) {
        adcVar.a(INSTANCE);
        adcVar.a(th);
    }

    public static void error(Throwable th, acx<?> acxVar) {
        acxVar.a(INSTANCE);
        acxVar.a(th);
    }

    @Override // defpackage.aef
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
