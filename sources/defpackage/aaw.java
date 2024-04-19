package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.yh;
/* compiled from: SubscriberProxy.java */
/* renamed from: aaw  reason: default package */
/* loaded from: classes.dex */
public class aaw extends yh.a implements wn.a {
    private xw<yh> a = new xw<>("SubscriberProxy");

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a.c(wuVar.b());
            this.a.b();
        } catch (RemoteException e) {
            xx.a(this, "onConnect exception ", e);
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a.c(null);
    }

    @Override // defpackage.yh
    public void a(final String[] strArr, final yd ydVar) {
        this.a.a((xw<yh>) new xw.a<yh, Object>() { // from class: aaw.1
            @Override // defpackage.xw.a
            public Object a(yh yhVar) throws RemoteException {
                yhVar.a(strArr, ydVar);
                return null;
            }
        });
    }

    @Override // defpackage.yh
    public void a(final yd ydVar) {
        this.a.a((xw<yh>) new xw.a<yh, Object>() { // from class: aaw.2
            @Override // defpackage.xw.a
            public Object a(yh yhVar) throws RemoteException {
                yhVar.a(ydVar);
                return null;
            }
        });
    }

    @Override // defpackage.yh
    public boolean a(final String str) {
        return ((Boolean) this.a.a(new xw.a<yh, Boolean>() { // from class: aaw.3
            @Override // defpackage.xw.a
            public Boolean a(yh yhVar) throws RemoteException {
                return Boolean.valueOf(yhVar.a(str));
            }
        }, false)).booleanValue();
    }

    public void a(xz xzVar) {
        this.a.a(xzVar);
    }
}
