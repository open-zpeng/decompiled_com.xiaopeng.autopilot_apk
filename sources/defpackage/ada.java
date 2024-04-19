package defpackage;
/* compiled from: Observer.java */
/* renamed from: ada  reason: default package */
/* loaded from: classes.dex */
public interface ada<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(ade adeVar);
}
