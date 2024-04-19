package defpackage;

import android.os.Handler;
import android.os.Looper;
/* compiled from: WorkerHandler.java */
/* renamed from: xz  reason: default package */
/* loaded from: classes.dex */
public class xz extends Handler {
    public xz(Looper looper) {
        super(looper);
    }

    public void a(Runnable runnable) {
        if (getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            super.post(runnable);
        }
    }

    public void a(Runnable runnable, long j) {
        if (getLooper() == Looper.myLooper() && j == 0) {
            runnable.run();
        } else {
            super.postDelayed(runnable, j);
        }
    }
}
