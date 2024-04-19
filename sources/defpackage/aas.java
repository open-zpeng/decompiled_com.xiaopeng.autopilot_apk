package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.wr;
import defpackage.xw;
/* compiled from: QueryInjectorProxy.java */
/* renamed from: aas  reason: default package */
/* loaded from: classes.dex */
public class aas extends wr.a implements wn.a {
    private xw<wr> a = new xw<>("QueryInjectorProxy");
    private xz b;

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a.c(wuVar.j());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
    }

    public void a(xz xzVar) {
        this.b = xzVar;
        this.a.a(this.b);
    }

    @Override // defpackage.wr
    public void a(final String[] strArr, final ws wsVar) {
        this.a.a((xw<wr>) new xw.a<wr, Object>() { // from class: aas.1
            @Override // defpackage.xw.a
            public Object a(wr wrVar) {
                try {
                    wrVar.a(strArr, wsVar);
                    return null;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    @Override // defpackage.wr
    public void a(final String[] strArr) {
        this.a.a((xw<wr>) new xw.a<wr, Object>() { // from class: aas.2
            @Override // defpackage.xw.a
            public Object a(wr wrVar) {
                try {
                    wrVar.a(strArr);
                    return null;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    @Override // defpackage.wr
    public xu a(final String str, final String str2) {
        return (xu) this.a.a(new xw.a<wr, xu>() { // from class: aas.3
            @Override // defpackage.xw.a
            public xu a(wr wrVar) {
                try {
                    return wrVar.a(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return xu.a;
                }
            }
        }, xu.a);
    }

    @Override // defpackage.wr
    public boolean a(final String str) {
        return ((Boolean) this.a.a(new xw.a<wr, Boolean>() { // from class: aas.4
            @Override // defpackage.xw.a
            public Boolean a(wr wrVar) {
                try {
                    return Boolean.valueOf(wrVar.a(str));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.wr
    public xu b(final String str, final String str2) {
        return (xu) this.a.a(new xw.a<wr, xu>() { // from class: aas.5
            @Override // defpackage.xw.a
            public xu a(wr wrVar) {
                try {
                    return wrVar.b(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return xu.a;
                }
            }
        }, xu.a);
    }
}
