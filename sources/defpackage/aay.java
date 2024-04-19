package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.yk;
/* compiled from: VADEngineProxy.java */
/* renamed from: aay  reason: default package */
/* loaded from: classes.dex */
public class aay extends yk.a implements wn.a {
    private xw<yk> a = new xw<>("VADEngineProxy");

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a.c(wuVar.p());
            this.a.b();
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
    }

    @Override // defpackage.yk
    public void a(final String str) {
        this.a.a((xw<yk>) new xw.a<yk, Object>() { // from class: aay.1
            @Override // defpackage.xw.a
            public Object a(yk ykVar) throws RemoteException {
                ykVar.a(str);
                return null;
            }
        });
    }

    @Override // defpackage.yk
    public void b() {
        this.a.a((xw<yk>) new xw.a<yk, Object>() { // from class: aay.2
            @Override // defpackage.xw.a
            public Object a(yk ykVar) throws RemoteException {
                ykVar.b();
                return null;
            }
        });
    }

    @Override // defpackage.yk
    public void c() {
        this.a.a((xw<yk>) new xw.a<yk, Object>() { // from class: aay.3
            @Override // defpackage.xw.a
            public Object a(yk ykVar) throws RemoteException {
                ykVar.c();
                return null;
            }
        });
    }

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }
}
