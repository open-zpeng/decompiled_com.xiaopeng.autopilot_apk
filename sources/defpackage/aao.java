package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.yc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: AppMgrProxy.java */
/* renamed from: aao  reason: default package */
/* loaded from: classes.dex */
public class aao extends yc.a implements wn.a {
    private Context a;
    private xw<yc> b = new xw<>("AppMgrProxy");
    private List<String> c = new ArrayList();

    public aao(Context context) {
        this.a = context;
        a(this.a.getPackageName(), a(this.a));
    }

    public void a(xz xzVar) {
        this.b.a(xzVar);
    }

    @Override // defpackage.yc
    public void a(final String str, final String str2) {
        this.b.a((xw<yc>) new xw.a<yc, Object>() { // from class: aao.1
            @Override // defpackage.xw.a
            public Object a(yc ycVar) throws RemoteException {
                if (!aao.this.c.contains(str2)) {
                    aao.this.c.add(str2);
                }
                ycVar.a(str, str2);
                return null;
            }
        });
    }

    @Override // defpackage.yc
    public String a(final String str) {
        return (String) this.b.a(new xw.a<yc, String>() { // from class: aao.2
            @Override // defpackage.xw.a
            public String a(yc ycVar) throws RemoteException {
                return ycVar.a(str);
            }
        }, "");
    }

    @Override // defpackage.yc
    public String[] b(final String str) {
        List list = (List) this.b.a(new xw.a<yc, List<String>>() { // from class: aao.3
            @Override // defpackage.xw.a
            public List<String> a(yc ycVar) throws RemoteException {
                return Arrays.asList(ycVar.b(str));
            }
        }, null);
        if (list != null) {
            return (String[]) list.toArray(new String[list.size()]);
        }
        return null;
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.b.c(wuVar.f());
            b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.b.b();
    }

    @Override // defpackage.wn.a
    public void a() {
        this.b.c(null);
    }

    private void b() {
        this.b.a((xw<yc>) new xw.a<yc, Object>() { // from class: aao.4
            @Override // defpackage.xw.a
            public Object a(yc ycVar) throws RemoteException {
                xx.b(this, "reRegisterApp...");
                for (String str : aao.this.c) {
                    ycVar.a(aao.this.a.getPackageName(), str);
                }
                return null;
            }
        });
    }

    private String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
