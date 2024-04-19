package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.yf;
/* compiled from: RecordEngineProxy.java */
/* renamed from: aat  reason: default package */
/* loaded from: classes.dex */
public class aat extends yf.a implements wn.a {
    private xw<yf> a = new xw<>("RecordEngineProxy");

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a.c(wuVar.k());
            this.a.b();
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
    }

    @Override // defpackage.yf
    public void a(final String str, final int i, final int i2) {
        this.a.a((xw<yf>) new xw.a<yf, Object>() { // from class: aat.1
            @Override // defpackage.xw.a
            public Object a(yf yfVar) throws RemoteException {
                yfVar.a(str, i, i2);
                return null;
            }
        });
    }

    @Override // defpackage.yf
    public void b() {
        this.a.a((xw<yf>) new xw.a<yf, Object>() { // from class: aat.2
            @Override // defpackage.xw.a
            public Object a(yf yfVar) throws RemoteException {
                yfVar.b();
                return null;
            }
        });
    }

    @Override // defpackage.yf
    public void a(final String str, final String str2) {
        this.a.a((xw<yf>) new xw.a<yf, String>() { // from class: aat.3
            @Override // defpackage.xw.a
            public String a(yf yfVar) throws RemoteException {
                yfVar.a(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yf
    public boolean a(final String str, final String str2, final boolean z) throws RemoteException {
        return ((Boolean) this.a.a(new xw.a<yf, Boolean>() { // from class: aat.4
            @Override // defpackage.xw.a
            public Boolean a(yf yfVar) throws RemoteException {
                return Boolean.valueOf(yfVar.a(str, str2, z));
            }
        }, false)).booleanValue();
    }
}
