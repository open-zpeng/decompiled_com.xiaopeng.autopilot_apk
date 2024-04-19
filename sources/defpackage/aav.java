package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import defpackage.wn;
import defpackage.wv;
import defpackage.xw;
/* compiled from: SpeechStateProxy.java */
/* renamed from: aav  reason: default package */
/* loaded from: classes.dex */
public class aav extends wv.a implements wn.a {
    private wv a;
    private xw<wv> b = new xw<>("SpeechStateProxy");

    @Override // defpackage.wv
    public boolean b() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.b();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public void a(final int i) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.1
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.a(i);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public void a(final IBinder iBinder, final int i) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.2
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.a(iBinder, i);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public int c() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.c();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.wv
    public void a(final boolean z) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.3
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.a(z);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public boolean d() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.d();
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            if (wuVar.g() != null) {
                this.a = wuVar.g();
                this.b.c(this.a);
                this.b.b();
            } else {
                xx.c("SpeechStateProxy", "isInitOK false, speechEngine.getSpeechState() = null");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.b.c(null);
        this.a = null;
    }

    @Override // defpackage.wv
    public void b(final int i) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.4
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.b(i);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public int e() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.e();
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    @Override // defpackage.wv
    public void b(final boolean z) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.5
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.b(z);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public boolean f() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.f();
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // defpackage.wv
    public boolean g() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.g();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public void a(final String str) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.6
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.a(str);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public String h() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.h();
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // defpackage.wv
    public void a(final int i, final boolean z) {
        this.b.a((xw<wv>) new xw.a<wv, Object>() { // from class: aav.7
            @Override // defpackage.xw.a
            public Object a(wv wvVar) throws RemoteException {
                wvVar.a(i, z);
                return null;
            }
        });
    }

    @Override // defpackage.wv
    public boolean c(int i) {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public boolean i() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.i();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public boolean j() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.j();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public boolean k() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.k();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public boolean l() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.l();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wv
    public boolean m() {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.m();
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // defpackage.wv
    public String b(String str) {
        wv wvVar = this.a;
        if (wvVar != null) {
            try {
                return wvVar.b(str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
