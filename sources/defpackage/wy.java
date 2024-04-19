package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import java.util.HashMap;
import java.util.Map;
/* compiled from: QueryManager.java */
/* renamed from: wy  reason: default package */
/* loaded from: classes.dex */
public class wy implements wn.a {
    private volatile wr a;
    private Map<Class<? extends xb>, xb> b = new HashMap();
    private xz c;

    public void a(xz xzVar) {
        this.c = xzVar;
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        xx.b("QueryManager", "onConnect " + wuVar);
        if (wuVar == null) {
            return;
        }
        try {
            this.a = wuVar.j();
            this.c.a(new Runnable() { // from class: wy.1
                @Override // java.lang.Runnable
                public void run() {
                    wy.this.a(true);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.a == null) {
            xx.b("mIQueryInjector == null");
            return;
        }
        for (Map.Entry<Class<? extends xb>, xb> entry : this.b.entrySet()) {
            xb value = entry.getValue();
            if (!value.a() || z) {
                xx.a(String.format("do inject query:%s", value));
                if (value.d() == null || value.d().length <= 0) {
                    xx.b("getInjectEvents.length == 0");
                } else {
                    try {
                        if (this.a != null) {
                            this.a.a(value.d(), value);
                            value.a(true);
                        }
                    } catch (RemoteException e) {
                        xx.a(this, "inject error ", e);
                    }
                }
            }
        }
    }
}
