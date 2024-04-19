package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.wp;
import defpackage.xw;
/* compiled from: CarSystemPropertyProxy.java */
/* renamed from: aap  reason: default package */
/* loaded from: classes.dex */
public class aap extends wp.a implements wn.a {
    private xw<wp> a = new xw<>("CarSystemPropertyProxy");

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            xx.a("CarSystemPropertyProxy", "onConnect.");
            this.a.c(wuVar.o());
            this.a.b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        xx.a("CarSystemPropertyProxy", "onDisconnect.");
        this.a.c(null);
    }

    @Override // defpackage.wp
    public String b() {
        return (String) this.a.a(new xw.a<wp, String>() { // from class: aap.1
            @Override // defpackage.xw.a
            public String a(wp wpVar) throws RemoteException {
                return wpVar.b();
            }
        }, "");
    }

    @Override // defpackage.wp
    public String c() {
        return (String) this.a.a(new xw.a<wp, String>() { // from class: aap.2
            @Override // defpackage.xw.a
            public String a(wp wpVar) throws RemoteException {
                return wpVar.c();
            }
        }, "");
    }
}
