package defpackage;

import android.os.Handler;
import android.os.RemoteException;
import defpackage.wn;
import java.util.HashMap;
import java.util.Map;
/* compiled from: NodeManager.java */
/* renamed from: wx  reason: default package */
/* loaded from: classes.dex */
public class wx implements wn.a {
    private volatile yh a;
    private Map<Class<? extends xa>, xa> b = new HashMap();
    private xz c;

    public void a(xz xzVar) {
        this.c = xzVar;
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        xx.a("onConnect " + wuVar);
        if (wuVar == null) {
            return;
        }
        try {
            this.a = wuVar.b();
            this.c.a(new Runnable() { // from class: wx.1
                @Override // java.lang.Runnable
                public void run() {
                    wx.this.a(true);
                }
            });
        } catch (RemoteException e) {
            xx.a(this, e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a = null;
    }

    public <T extends xa> T a(Class<T> cls) {
        return (T) b(cls);
    }

    public void a(final Class<? extends xa> cls, final wq wqVar) {
        this.c.a(new Runnable() { // from class: wx.2
            @Override // java.lang.Runnable
            public void run() {
                xa b = wx.this.b(cls);
                if (b != null) {
                    b.a((xa) wqVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public xa b(Class<? extends xa> cls) {
        xa xaVar;
        xa xaVar2 = this.b.get(cls);
        if (xaVar2 != null) {
            return xaVar2;
        }
        synchronized (this.b) {
            xaVar = this.b.get(cls);
            if (xaVar == null) {
                try {
                    xaVar = cls.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    xx.b(String.format("create %s error", cls));
                }
                if (xaVar != null) {
                    a(xaVar);
                    xaVar.a((Handler) this.c);
                }
            }
        }
        return xaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(xa xaVar) {
        if (this.b.containsKey(xaVar.getClass())) {
            xx.b(String.format("node %s had register", xaVar));
            return;
        }
        xx.a(String.format("register node:%s", xaVar));
        this.b.put(xaVar.getClass(), xaVar);
        this.c.a(new Runnable() { // from class: wx.3
            @Override // java.lang.Runnable
            public void run() {
                wx.this.a(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.a == null) {
            xx.b("mSubscriber == null");
            return;
        }
        for (Map.Entry<Class<? extends xa>, xa> entry : this.b.entrySet()) {
            xa value = entry.getValue();
            if (!value.a() || z) {
                xx.a(String.format("do subscribe node:%s", value));
                if (value.d() == null || value.d().length <= 0) {
                    xx.b("getSubscribeEvents.length == 0");
                } else {
                    try {
                        if (this.a != null) {
                            this.a.a(value.d(), value);
                            value.a(true);
                        }
                    } catch (RemoteException e) {
                        xx.a(this, "subscribe error ", e);
                    }
                }
            }
        }
    }
}
