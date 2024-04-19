package defpackage;

import com.badlogic.gdx.utils.k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* compiled from: AsyncResult.java */
/* renamed from: qq  reason: default package */
/* loaded from: classes.dex */
public class qq<T> {
    private final Future<T> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qq(Future<T> future) {
        this.a = future;
    }

    public boolean a() {
        return this.a.isDone();
    }

    public T b() {
        try {
            return this.a.get();
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException e) {
            throw new k(e.getCause());
        }
    }
}
