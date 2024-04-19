package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.ye;
/* compiled from: HotwordEngineProxy.java */
/* renamed from: aaq  reason: default package */
/* loaded from: classes.dex */
public class aaq extends ye.a implements wn.a {
    private xw<ye> a = new xw<>("HotwordEngineProxy");
    private ye b;

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            if (wuVar.n() != null) {
                this.b = wuVar.n();
                this.a.c(this.b);
                this.a.b();
            } else {
                xx.c("HotwordEngineProxy", "mHotwordEngine = null");
            }
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
        this.b = null;
    }

    @Override // defpackage.ye
    public void a(String str) {
        xx.a("abandoned function: enjectHotwords.");
    }

    @Override // defpackage.ye
    public void b() {
        xx.a("abandoned function: removeHotwords.");
    }

    @Override // defpackage.ye
    public int c() {
        ye yeVar = this.b;
        if (yeVar != null) {
            try {
                return yeVar.c();
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }

    @Override // defpackage.ye
    public void b(final String str) {
        this.a.a((xw<ye>) new xw.a<ye, Object>() { // from class: aaq.1
            @Override // defpackage.xw.a
            public Object a(ye yeVar) throws RemoteException {
                yeVar.b(str);
                return null;
            }
        });
    }

    @Override // defpackage.ye
    public void a(final String str, final String str2) {
        this.a.a((xw<ye>) new xw.a<ye, Object>() { // from class: aaq.2
            @Override // defpackage.xw.a
            public Object a(ye yeVar) throws RemoteException {
                yeVar.a(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.ye
    public void a(final String str, final String str2, final IBinder iBinder) {
        this.a.a((xw<ye>) new xw.a<ye, Object>() { // from class: aaq.3
            @Override // defpackage.xw.a
            public Object a(ye yeVar) throws RemoteException {
                yeVar.a(str, str2, iBinder);
                return null;
            }
        });
    }
}
