package defpackage;

import androidx.lifecycle.i;
import androidx.lifecycle.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManager.java */
/* renamed from: hs  reason: default package */
/* loaded from: classes.dex */
public abstract class hs {

    /* compiled from: LoaderManager.java */
    /* renamed from: hs$a */
    /* loaded from: classes.dex */
    public interface a<D> {
        void a(hu<D> huVar);

        void a(hu<D> huVar, D d);
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends i & w> hs a(T t) {
        return new ht(t, t.getViewModelStore());
    }
}
