package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import defpackage.wn;
import defpackage.xw;
import defpackage.yi;
import defpackage.yj;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: TTSEngineProxy.java */
/* renamed from: aax  reason: default package */
/* loaded from: classes.dex */
public class aax extends yj.a implements wn.a {
    private xz c;
    private Map<String, aar> a = new ConcurrentHashMap();
    private volatile boolean b = false;
    private xw<yj> d = new xw<>("TTSEngineProxy");
    private yi e = new yi.a() { // from class: aax.1
        @Override // defpackage.yi
        public void a(final String str, final String str2) {
            aax.this.c.a(new Runnable() { // from class: aax.1.1
                @Override // java.lang.Runnable
                public void run() {
                    aar aarVar = (aar) aax.this.a.get(str);
                    if (aarVar != null) {
                        aarVar.a(str, str2);
                    }
                }
            });
        }

        @Override // defpackage.yi
        public void a(final byte[] bArr) {
            aax.this.c.a(new Runnable() { // from class: aax.1.2
                @Override // java.lang.Runnable
                public void run() {
                    for (Map.Entry entry : aax.this.a.entrySet()) {
                        ((aar) entry.getValue()).a(bArr);
                    }
                }
            });
        }

        @Override // defpackage.yi
        public void a(final String str, final int i, final String str2) {
            aax.this.c.a(new Runnable() { // from class: aax.1.3
                @Override // java.lang.Runnable
                public void run() {
                    aar aarVar = (aar) aax.this.a.get(str);
                    if (aarVar != null) {
                        aarVar.a(str, i, str2);
                        aax.this.a.remove(str);
                    }
                }
            });
        }

        @Override // defpackage.yi
        public void b(final String str, final String str2) {
            aax.this.c.a(new Runnable() { // from class: aax.1.4
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = aax.this.a.entrySet().iterator();
                    while (it.hasNext()) {
                        ((aar) ((Map.Entry) it.next()).getValue()).b(str, str2);
                        it.remove();
                    }
                }
            });
        }
    };

    public void a(xz xzVar) {
        this.c = xzVar;
        this.d.a(this.c);
    }

    public String c(final String str) {
        this.c.a(new Runnable() { // from class: aax.12
            @Override // java.lang.Runnable
            public void run() {
                aax.this.a(str, 1, 3, -1, null);
            }
        }, 50L);
        return "";
    }

    public String a(String str, int i, int i2, int i3, aar aarVar) {
        String uuid = UUID.randomUUID().toString();
        a(str, i, uuid, i2, i3, xq.a, xq.d);
        g();
        if (aarVar != null) {
            this.a.put(uuid, aarVar);
            xx.a("speak callback size:" + this.a.size());
        }
        return uuid;
    }

    @Override // defpackage.yj
    public boolean a(final String str, final int i, final String str2, final int i2, final int i3, final int i4, final long j) {
        return ((Boolean) this.d.a(new xw.a<yj, Boolean>() { // from class: aax.14
            @Override // defpackage.xw.a
            public Boolean a(yj yjVar) throws RemoteException {
                try {
                    return Boolean.valueOf(yjVar.a(str, i, str2, i2, i3, i4, j));
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return false;
                }
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yj
    public boolean a(final String str, final int i, final String str2, final int i2) {
        return ((Boolean) this.d.a(new xw.a<yj, Boolean>() { // from class: aax.15
            @Override // defpackage.xw.a
            public Boolean a(yj yjVar) throws RemoteException {
                try {
                    return Boolean.valueOf(yjVar.a(str, i, str2, i2));
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return false;
                }
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yj
    public void a(final String str) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.16
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(str);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public String b() {
        return (String) this.d.a(new xw.a<yj, String>() { // from class: aax.17
            @Override // defpackage.xw.a
            public String a(yj yjVar) throws RemoteException {
                try {
                    return yjVar.b();
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        }, null);
    }

    @Override // defpackage.yj
    public void a(final float f) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.18
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(f);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public float c() {
        return ((Float) this.d.a(new xw.a<yj, Float>() { // from class: aax.19
            @Override // defpackage.xw.a
            public Float a(yj yjVar) throws RemoteException {
                try {
                    return Float.valueOf(yjVar.c());
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return Float.valueOf(0.0f);
                }
            }
        }, Float.valueOf(0.0f))).floatValue();
    }

    @Override // defpackage.yj
    public void a(final int i) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.20
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(i);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public int d() {
        return ((Integer) this.d.a(new xw.a<yj, Integer>() { // from class: aax.2
            @Override // defpackage.xw.a
            public Integer a(yj yjVar) throws RemoteException {
                try {
                    return Integer.valueOf(yjVar.d());
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return 0;
                }
            }
        }, 0)).intValue();
    }

    @Override // defpackage.yj
    public void b(final int i) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.3
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.b(i);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public void a(final boolean z) throws RemoteException {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.4
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(z);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public void a(final String str, final String str2) throws RemoteException {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.5
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(str, str2);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public void b(final String str) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.6
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.b(str);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public void a(final yi yiVar) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.7
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(yiVar);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public void b(final yi yiVar) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.8
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.b(yiVar);
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public void a(final boolean z, final IBinder iBinder) {
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.9
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    if (iBinder == null) {
                        yjVar.a(z, yjVar.asBinder());
                    } else {
                        yjVar.a(z, iBinder);
                    }
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.yj
    public boolean e() {
        return ((Boolean) this.d.a(new xw.a<yj, Boolean>() { // from class: aax.10
            @Override // defpackage.xw.a
            public Boolean a(yj yjVar) throws RemoteException {
                try {
                    return Boolean.valueOf(yjVar.e());
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return false;
                }
            }
        }, false)).booleanValue();
    }

    @Override // defpackage.yj
    public boolean f() {
        return ((Boolean) this.d.a(new xw.a<yj, Boolean>() { // from class: aax.11
            @Override // defpackage.xw.a
            public Boolean a(yj yjVar) throws RemoteException {
                try {
                    return Boolean.valueOf(yjVar.f());
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return false;
                }
            }
        }, false)).booleanValue();
    }

    private synchronized void g() {
        if (this.b) {
            return;
        }
        this.d.a((xw<yj>) new xw.a<yj, Object>() { // from class: aax.13
            @Override // defpackage.xw.a
            public Object a(yj yjVar) throws RemoteException {
                try {
                    yjVar.a(aax.this.e);
                    aax.this.b = true;
                    return null;
                } catch (Throwable th) {
                    xx.b("IPC Excption:" + th.getMessage());
                    return null;
                }
            }
        });
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.d.c(wuVar.c());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        this.d.b();
    }

    @Override // defpackage.wn.a
    public void a() {
        this.b = false;
        this.d.c(null);
    }
}
