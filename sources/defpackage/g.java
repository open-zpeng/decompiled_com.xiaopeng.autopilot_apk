package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
/* compiled from: ActivityResultContract.java */
/* renamed from: g  reason: default package */
/* loaded from: classes.dex */
public abstract class g<I, O> {
    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i);

    @SuppressLint({"UnknownNullness"})
    public abstract O a(int i, Intent intent);

    public a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    /* compiled from: ActivityResultContract.java */
    /* renamed from: g$a */
    /* loaded from: classes.dex */
    public static final class a<T> {
        @SuppressLint({"UnknownNullness"})
        private final T a;

        public a(@SuppressLint({"UnknownNullness"}) T t) {
            this.a = t;
        }

        @SuppressLint({"UnknownNullness"})
        public T a() {
            return this.a;
        }
    }
}
