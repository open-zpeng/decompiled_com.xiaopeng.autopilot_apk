package defpackage;

import android.content.Context;
import android.os.RemoteException;
import defpackage.wn;
import defpackage.wo;
import defpackage.xw;
/* compiled from: ActorBridge.java */
/* renamed from: xd  reason: default package */
/* loaded from: classes.dex */
public class xd extends wo.a implements wn.a {
    private Context a;
    private xz b;
    private xw<wo> c = new xw<>("ActorBridge");

    public xd(Context context) {
        this.a = context;
    }

    public void a(xz xzVar) {
        this.b = xzVar;
        this.c.a(xzVar);
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.c.c(wuVar.a());
            this.c.b();
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.c.c(null);
    }

    @Override // defpackage.wo
    public void a(final xc xcVar) {
        this.c.a((xw<wo>) new xw.a<wo, Object>() { // from class: xd.1
            @Override // defpackage.xw.a
            public Object a(wo woVar) throws RemoteException {
                woVar.a(xcVar);
                return null;
            }
        });
    }
}
