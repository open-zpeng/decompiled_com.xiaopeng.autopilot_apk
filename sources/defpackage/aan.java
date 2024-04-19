package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.yb;
/* compiled from: AgentProxy.java */
/* renamed from: aan  reason: default package */
/* loaded from: classes.dex */
public class aan extends yb.a implements wn.a {
    private volatile yb b;
    private xw<yb> a = new xw<>("AgentProxy");
    private final String c = "AgentProxy";

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            yb e = wuVar.e();
            this.b = e;
            this.a.c(e);
            this.a.b();
        } catch (RemoteException e2) {
            xx.a(this, "onConnect exception ", e2);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.b = null;
        this.a.c(null);
    }

    @Override // defpackage.yb
    public void a(final String str) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.1
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(str);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final String str2) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.12
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void b(final String str, final String str2) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.23
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.b(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void b(final String str) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.26
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.b(str);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final String str2, final String str3, final String str4) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.27
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(str, str2, str3, str4);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final String[] strArr, final boolean z) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.28
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(str, strArr, z);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void c(final String str, final String str2) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.29
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.c(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    @Deprecated
    public void a(final boolean z) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.30
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(z);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    @Deprecated
    public boolean b() {
        return ((Boolean) this.a.a(new xw.a<yb, Boolean>() { // from class: aan.31
            @Override // defpackage.xw.a
            public Boolean a(yb ybVar) throws RemoteException {
                return Boolean.valueOf(ybVar.b());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yb
    public void c(final String str) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.2
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.c(str);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    @Deprecated
    public boolean c() {
        return ((Boolean) this.a.a(new xw.a<yb, Boolean>() { // from class: aan.3
            @Override // defpackage.xw.a
            public Boolean a(yb ybVar) throws RemoteException {
                return Boolean.valueOf(ybVar.c());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yb
    @Deprecated
    public void b(final boolean z) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.4
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.b(z);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void c(final boolean z) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.5
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.c(z);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public boolean d() {
        return ((Boolean) this.a.a(new xw.a<yb, Boolean>() { // from class: aan.6
            @Override // defpackage.xw.a
            public Boolean a(yb ybVar) throws RemoteException {
                return Boolean.valueOf(ybVar.d());
            }
        }, false)).booleanValue();
    }

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }

    @Override // defpackage.yb
    public void d(final String str) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.7
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.d(str);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void d(final String str, final String str2) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.8
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.d(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final IBinder iBinder, final boolean z) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.9
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.a(iBinder, z);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public boolean e() {
        yb ybVar = this.b;
        if (ybVar != null) {
            try {
                return ybVar.e();
            } catch (Throwable th) {
                xx.a("AgentProxy", "remote error: ", th);
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.yb
    public String e(final String str) {
        return (String) this.a.a(new xw.a<yb, String>() { // from class: aan.10
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                return ybVar.e(str);
            }
        }, "");
    }

    @Override // defpackage.yb
    public String f(final String str) {
        return (String) this.a.a(new xw.a<yb, String>() { // from class: aan.11
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                return ybVar.f(str);
            }
        }, "");
    }

    @Override // defpackage.yb
    public void g(final String str) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.13
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.g(str);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public String h(final String str) {
        return (String) this.a.a(new xw.a<yb, String>() { // from class: aan.14
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                return ybVar.h(str);
            }
        }, "");
    }

    @Override // defpackage.yb
    public void e(final String str, final String str2) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.15
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.e(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final int i, final String str) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.16
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(i, str);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void f(final String str, final String str2) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.17
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.f(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public String g(final String str, final String str2) {
        return (String) this.a.a(new xw.a<yb, String>() { // from class: aan.18
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                return ybVar.g(str, str2);
            }
        }, "");
    }

    @Override // defpackage.yb
    public void a(final String str, final String str2, final String str3, final String str4, final String str5) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.19
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.a(str, str2, str3, str4, str5);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final int i) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.20
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.a(str, i);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final String str2, final int i) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.21
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.a(str, str2, i);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final xt xtVar, final int i) {
        this.a.a((xw<yb>) new xw.a<yb, String>() { // from class: aan.22
            @Override // defpackage.xw.a
            public String a(yb ybVar) throws RemoteException {
                ybVar.a(str, xtVar, i);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final IBinder iBinder, final String str, final String str2, final String str3, final String str4) {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.24
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(iBinder, str, str2, str3, str4);
                return null;
            }
        });
    }

    @Override // defpackage.yb
    public void a(final String str, final String str2, final yg ygVar) throws RemoteException {
        this.a.a((xw<yb>) new xw.a<yb, Object>() { // from class: aan.25
            @Override // defpackage.xw.a
            public Object a(yb ybVar) throws RemoteException {
                ybVar.a(str, str2, ygVar);
                return null;
            }
        });
    }
}
