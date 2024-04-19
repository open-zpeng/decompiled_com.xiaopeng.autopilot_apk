package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.ya;
/* compiled from: ASREngineProxy.java */
/* renamed from: aam  reason: default package */
/* loaded from: classes.dex */
public class aam extends ya.a implements wn.a {
    private xw<ya> a = new xw<>("ASREngineProxy");

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a.c(wuVar.i());
            this.a.b();
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
    }

    @Override // defpackage.ya
    public void a(final boolean z) {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.1
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.a(z);
                return null;
            }
        });
    }

    @Override // defpackage.ya
    public boolean b() {
        return ((Boolean) this.a.a(new xw.a<ya, Boolean>() { // from class: aam.2
            @Override // defpackage.xw.a
            public Boolean a(ya yaVar) throws RemoteException {
                return Boolean.valueOf(yaVar.b());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.ya
    public boolean c() {
        return ((Boolean) this.a.a(new xw.a<ya, Boolean>() { // from class: aam.3
            @Override // defpackage.xw.a
            public Boolean a(ya yaVar) throws RemoteException {
                return Boolean.valueOf(yaVar.c());
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.ya
    public void b(final boolean z) {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.4
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.b(z);
                return null;
            }
        });
    }

    @Override // defpackage.ya
    public void d() {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.5
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.d();
                return null;
            }
        });
    }

    @Override // defpackage.ya
    public void e() {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.6
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.e();
                return null;
            }
        });
    }

    @Override // defpackage.ya
    public void f() {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.7
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.f();
                return null;
            }
        });
    }

    @Override // defpackage.ya
    public void a(final long j) {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.8
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.a(j);
                return null;
            }
        });
    }

    @Override // defpackage.ya
    public void b(final long j) {
        this.a.a((xw<ya>) new xw.a<ya, Object>() { // from class: aam.9
            @Override // defpackage.xw.a
            public Object a(ya yaVar) throws RemoteException {
                yaVar.b(j);
                return null;
            }
        });
    }
}
