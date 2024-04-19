package defpackage;

import android.os.RemoteException;
/* compiled from: IPCRunner.java */
/* renamed from: xw  reason: default package */
/* loaded from: classes.dex */
public class xw<Proxy> extends xv<a> {
    private volatile Proxy c;

    /* compiled from: IPCRunner.java */
    /* renamed from: xw$a */
    /* loaded from: classes.dex */
    public interface a<Proxy, R> {
        R a(Proxy proxy) throws RemoteException;
    }

    public xw(String str) {
        super(str);
    }

    public synchronized void c(Proxy proxy) {
        String str = this.a;
        xx.b(str, "proxy = " + proxy);
        this.c = proxy;
    }

    @Override // defpackage.xv
    protected synchronized boolean a() {
        return this.c != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.xv
    /* renamed from: a */
    public synchronized Object b(a aVar) {
        try {
        } catch (Throwable th) {
            xx.a(this.a, "ipc run catch exception ", th);
            return null;
        }
        return aVar.a(this.c);
    }
}
