package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import defpackage.wn;
import defpackage.xw;
import defpackage.yl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: WakeupEngineProxy.java */
/* renamed from: aaz  reason: default package */
/* loaded from: classes.dex */
public class aaz extends yl.a implements wn.a {
    private xw<yl> a = new xw<>("WakeupEngineProxy");
    private Map<String, xs> b = new ConcurrentHashMap();

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a.c(wuVar.d());
            this.a.b();
            xx.b("WakeupEngineProxy", "reset:   onConnect");
            x();
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
    }

    @Override // defpackage.yl
    public void b() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.1
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.b();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void c() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.12
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.c();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final String str) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.23
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.a(str);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void d() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.34
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.d();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void e() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.45
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.e();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void f() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.47
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.f();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void g() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.48
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.g();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public String[] h() {
        return (String[]) this.a.a(new xw.a<yl, String[]>() { // from class: aaz.49
            @Override // defpackage.xw.a
            public String[] a(yl ylVar) throws RemoteException {
                return ylVar.h();
            }
        }, new String[0]);
    }

    @Override // defpackage.yl
    public void a(final String str, final String str2, final String str3, final String[] strArr) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.50
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.a(str, str2, str3, strArr);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public String i() {
        return (String) this.a.a(new xw.a<yl, String>() { // from class: aaz.2
            @Override // defpackage.xw.a
            public String a(yl ylVar) throws RemoteException {
                return ylVar.i();
            }
        }, null);
    }

    @Override // defpackage.yl
    public void a(final String[] strArr, final String[] strArr2, final String[] strArr3, final String[] strArr4, final String[] strArr5) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.3
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.a(strArr, strArr2, strArr3, strArr4, strArr5);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void j() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.4
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.j();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void b(final String[] strArr, final String[] strArr2, final String[] strArr3, final String[] strArr4, final String[] strArr5) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.5
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.b(strArr, strArr2, strArr3, strArr4, strArr5);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final String[] strArr) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.6
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.a(strArr);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final String[] strArr, final String[] strArr2, final String[] strArr3) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.7
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.a(strArr, strArr2, strArr3);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void k() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.8
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.k();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void b(final String[] strArr, final String[] strArr2, final String[] strArr3) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.9
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.b(strArr, strArr2, strArr3);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void b(final String[] strArr) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.10
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.b(strArr);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void l() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.11
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.l();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void m() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.13
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.m();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public boolean n() {
        return ((Boolean) this.a.a(new xw.a<yl, Boolean>() { // from class: aaz.14
            @Override // defpackage.xw.a
            public Boolean a(yl ylVar) throws RemoteException {
                return Boolean.valueOf(ylVar.n());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yl
    public boolean o() {
        return ((Boolean) this.a.a(new xw.a<yl, Boolean>() { // from class: aaz.15
            @Override // defpackage.xw.a
            public Boolean a(yl ylVar) throws RemoteException {
                return Boolean.valueOf(ylVar.o());
            }
        }, true)).booleanValue();
    }

    @Override // defpackage.yl
    public void a(final boolean z) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.16
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.a(z);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.17
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder());
                    return null;
                }
                ylVar.a(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void b(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.18
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.b(ylVar.asBinder());
                    return null;
                }
                ylVar.b(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public boolean p() {
        return ((Boolean) this.a.a(new xw.a<yl, Boolean>() { // from class: aaz.19
            @Override // defpackage.xw.a
            public Boolean a(yl ylVar) throws RemoteException {
                return Boolean.valueOf(ylVar.p());
            }
        }, true)).booleanValue();
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder, final boolean z) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.20
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder(), z);
                    return null;
                }
                ylVar.a(iBinder2, z);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public boolean q() {
        return ((Boolean) this.a.a(new xw.a<yl, Boolean>() { // from class: aaz.21
            @Override // defpackage.xw.a
            public Boolean a(yl ylVar) throws RemoteException {
                return Boolean.valueOf(ylVar.q());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yl
    public void b(final boolean z) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.22
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.b(z);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void r() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.24
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.r();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void s() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.25
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.s();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public boolean t() {
        return ((Boolean) this.a.a(new xw.a<yl, Boolean>() { // from class: aaz.26
            @Override // defpackage.xw.a
            public Boolean a(yl ylVar) throws RemoteException {
                return Boolean.valueOf(ylVar.t());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yl
    public void c(final boolean z) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.27
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.c(z);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void u() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.28
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.u();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void v() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.29
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.v();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void w() {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.30
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.w();
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void b(final String str) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.31
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.b(str);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void c(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.32
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.c(ylVar.asBinder());
                    return null;
                }
                ylVar.c(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void d(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.33
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.d(ylVar.asBinder());
                    return null;
                }
                ylVar.d(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void e(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.35
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.e(ylVar.asBinder());
                    return null;
                }
                ylVar.e(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void f(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.36
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.f(ylVar.asBinder());
                    return null;
                }
                ylVar.f(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void g(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.37
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.g(ylVar.asBinder());
                    return null;
                }
                ylVar.g(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void h(final IBinder iBinder) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.38
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.h(ylVar.asBinder());
                    return null;
                }
                ylVar.h(iBinder2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void c(final String str) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.39
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                ylVar.c(str);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder, final int i, final String str, final String str2, final int i2) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.40
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder(), i, str, str2, i2);
                } else {
                    ylVar.a(iBinder2, i, str, str2, i2);
                }
                aaz aazVar = aaz.this;
                IBinder iBinder3 = iBinder;
                aazVar.b(iBinder3 == null ? ylVar.asBinder() : iBinder3, i, str, str2, i2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder, final int i, final String str, final int i2) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.41
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder(), i, str, i2);
                } else {
                    ylVar.a(iBinder2, i, str, i2);
                }
                aaz aazVar = aaz.this;
                IBinder iBinder3 = iBinder;
                if (iBinder3 == null) {
                    iBinder3 = ylVar.asBinder();
                }
                aazVar.a(iBinder3, i, str);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder, final String str, final String str2, final int i) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.42
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder(), str, str2, i);
                } else {
                    ylVar.a(iBinder2, str, str2, i);
                }
                aaz aazVar = aaz.this;
                IBinder iBinder3 = iBinder;
                aazVar.b(iBinder3 == null ? ylVar.asBinder() : iBinder3, -1, str, str2, i);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder, final String str, final int i) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.43
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder(), str, i);
                } else {
                    ylVar.a(iBinder2, str, i);
                }
                aaz aazVar = aaz.this;
                IBinder iBinder3 = iBinder;
                if (iBinder3 == null) {
                    iBinder3 = ylVar.asBinder();
                }
                aazVar.a(iBinder3, -1, str);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void a(final IBinder iBinder, final String str, final String str2) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.44
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.a(ylVar.asBinder(), str, str2);
                    return null;
                }
                ylVar.a(iBinder2, str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yl
    public void b(final IBinder iBinder, final String str, final String str2) {
        this.a.a((xw<yl>) new xw.a<yl, Object>() { // from class: aaz.46
            @Override // defpackage.xw.a
            public Object a(yl ylVar) throws RemoteException {
                IBinder iBinder2 = iBinder;
                if (iBinder2 == null) {
                    ylVar.b(ylVar.asBinder(), str, str2);
                    return null;
                }
                ylVar.b(iBinder2, str, str2);
                return null;
            }
        });
    }

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IBinder iBinder, int i, String str, String str2, int i2) {
        String b = b(iBinder, i, str);
        xx.b("WakeupEngineProxy", "setDisableInfoCache :  " + b);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        xs xsVar = new xs(iBinder, i, str, str2, i2);
        if (this.b.containsKey(b)) {
            return;
        }
        xx.b("WakeupEngineProxy", "put data  :  " + b + ": " + xsVar.toString());
        this.b.put(b, xsVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IBinder iBinder, int i, String str) {
        String b = b(iBinder, i, str);
        xx.b("WakeupEngineProxy", "removeDisableInfoCache :  " + b);
        if (TextUtils.isEmpty(b) || !this.b.containsKey(b)) {
            return;
        }
        xx.b("WakeupEngineProxy", "remove  :  " + b + ": " + this.b.size());
        this.b.remove(b);
        xx.b("WakeupEngineProxy", "remove after :  " + b + ": " + this.b.size());
    }

    private String b(IBinder iBinder, int i, String str) {
        if (iBinder != null) {
            String obj = iBinder.toString();
            if (i == -1) {
                return obj + "_" + str;
            }
            return obj + "_" + i + "_" + str;
        }
        return null;
    }

    private void x() {
        xx.b("WakeupEngineProxy", "resumeCarSpeechStatus  disableInfoCache size " + this.b.size());
        if (this.b.size() > 0) {
            for (Map.Entry<String, xs> entry : this.b.entrySet()) {
                xs value = entry.getValue();
                if (value != null) {
                    xx.b("WakeupEngineProxy", "disable from cache:    = ====  " + value.toString());
                    if (value.c() == -1) {
                        a(value.b(), value.d(), value.e(), value.f());
                    } else {
                        a(value.b(), value.c(), value.d(), value.e(), value.f());
                    }
                }
            }
        }
    }
}
