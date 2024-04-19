package defpackage;

import android.os.Build;
import android.os.CancellationSignal;
/* compiled from: CancellationSignal.java */
/* renamed from: fb  reason: default package */
/* loaded from: classes.dex */
public final class fb {
    private boolean a;
    private a b;
    private Object c;
    private boolean d;

    /* compiled from: CancellationSignal.java */
    /* renamed from: fb$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void b() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            a aVar = this.b;
            Object obj = this.c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public void a(a aVar) {
        synchronized (this) {
            c();
            if (this.b == aVar) {
                return;
            }
            this.b = aVar;
            if (this.a && aVar != null) {
                aVar.a();
            }
        }
    }

    private void c() {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
