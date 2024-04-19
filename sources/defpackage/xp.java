package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
/* compiled from: Recognizer.java */
/* renamed from: xp  reason: default package */
/* loaded from: classes.dex */
public class xp {
    private final xz b;
    private volatile xn d;
    private final String a = "Recognizer";
    private xw<xn> c = new xw<>("IRecognizerProxy");
    private final wn.a e = new wn.a() { // from class: xp.4
        @Override // defpackage.wn.a
        public void a(wu wuVar) {
            xx.b("Recognizer", "on connect");
            try {
                xn m = wuVar.m();
                xp.this.c.c(m);
                xp.this.d = m;
            } catch (Throwable unused) {
                xx.c("Recognizer", "on connect error");
            }
        }

        @Override // defpackage.wn.a
        public void a() {
            xp.this.c.c(null);
            xp.this.d = null;
        }
    };

    public xp(xz xzVar) {
        this.b = xzVar;
        this.c.a(xzVar);
    }

    public void a(final String str, final String str2) {
        this.c.a((xw<xn>) new xw.a<xn, Object>() { // from class: xp.1
            @Override // defpackage.xw.a
            public Object a(xn xnVar) throws RemoteException {
                xp.this.b(str, str2);
                return null;
            }
        });
    }

    public void a(final String str, final int i) {
        this.c.a((xw<xn>) new xw.a<xn, Object>() { // from class: xp.2
            @Override // defpackage.xw.a
            public Object a(xn xnVar) throws RemoteException {
                xp.this.b(str, i);
                return null;
            }
        });
    }

    public void a(final String str, final boolean z) {
        this.c.a((xw<xn>) new xw.a<xn, Object>() { // from class: xp.3
            @Override // defpackage.xw.a
            public Object a(xn xnVar) throws RemoteException {
                xp.this.b(str, z);
                return null;
            }
        });
    }

    public wn.a a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) throws RemoteException {
        xn xnVar = this.d;
        if (xnVar != null) {
            xnVar.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i) throws RemoteException {
        xn xnVar = this.d;
        if (xnVar != null) {
            xnVar.a(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z) throws RemoteException {
        xn xnVar = this.d;
        if (xnVar != null) {
            xnVar.a(str, z);
        }
    }
}
