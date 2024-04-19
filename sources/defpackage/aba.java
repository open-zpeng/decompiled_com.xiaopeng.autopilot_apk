package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.ww;
import defpackage.xw;
/* compiled from: WindowEngineProxy.java */
/* renamed from: aba  reason: default package */
/* loaded from: classes.dex */
public class aba extends ww.a implements wn.a {
    private ww a;
    private xw<ww> b = new xw<>("WindowEngineProxy");

    @Override // defpackage.ww
    public int b() {
        ww wwVar = this.a;
        if (wwVar != null) {
            try {
                return wwVar.b();
            } catch (RemoteException e) {
                xx.c("WindowEngineProxy", e.getMessage());
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.ww
    public boolean a(int i) {
        ww wwVar = this.a;
        if (wwVar != null) {
            try {
                return wwVar.a(i);
            } catch (RemoteException e) {
                xx.c("WindowEngineProxy", e.getMessage());
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.ww
    public void b(int i) {
        ww wwVar = this.a;
        if (wwVar != null) {
            try {
                wwVar.b(i);
            } catch (RemoteException e) {
                xx.c("WindowEngineProxy", e.getMessage());
            }
        }
    }

    @Override // defpackage.ww
    public void c(final int i) {
        this.b.a((xw<ww>) new xw.a<ww, Object>() { // from class: aba.1
            @Override // defpackage.xw.a
            public Object a(ww wwVar) throws RemoteException {
                wwVar.c(i);
                return null;
            }
        });
    }

    @Override // defpackage.ww
    public void d(final int i) {
        this.b.a((xw<ww>) new xw.a<ww, Object>() { // from class: aba.2
            @Override // defpackage.xw.a
            public Object a(ww wwVar) throws RemoteException {
                wwVar.d(i);
                return null;
            }
        });
    }

    @Override // defpackage.ww
    public void a(int i, boolean z) {
        ww wwVar = this.a;
        if (wwVar != null) {
            try {
                wwVar.a(i, z);
            } catch (RemoteException e) {
                xx.c("WindowEngineProxy", e.getMessage());
            }
        }
    }

    @Override // defpackage.ww
    public void a(final int i, final int i2) {
        this.b.a((xw<ww>) new xw.a<ww, Object>() { // from class: aba.3
            @Override // defpackage.xw.a
            public Object a(ww wwVar) throws RemoteException {
                wwVar.a(i, i2);
                return null;
            }
        });
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        if (wuVar != null) {
            try {
                this.a = wuVar.l();
                this.b.c(this.a);
                this.b.b();
            } catch (RemoteException e) {
                xx.c("WindowEngineProxy", e.getMessage());
            }
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.b.c(null);
        this.a = null;
    }
}
