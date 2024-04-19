package defpackage;

import android.os.RemoteException;
import defpackage.wn;
import defpackage.wt;
/* compiled from: SoundLockStateProxy.java */
/* renamed from: aau  reason: default package */
/* loaded from: classes.dex */
public class aau extends wt.a implements wn.a {
    private wt a;

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
        try {
            this.a = wuVar.h();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.wn.a
    public void a() {
        this.a = null;
    }

    @Override // defpackage.wt
    public int b() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.b();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.wt
    public void a(int i) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public void b(int i) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.b(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public int c() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.c();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.wt
    public boolean d() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.d();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wt
    public void a(boolean z) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.a(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public void b(boolean z) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.b(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public boolean e() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.e();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wt
    public int f() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.f();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.wt
    public void a(int i, int i2) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public void c(int i) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public int g() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.g();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.wt
    public void a(int i, long j, int i2) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.a(i, j, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public void c(boolean z) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.c(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public boolean h() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.h();
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // defpackage.wt
    public void d(int i) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public void e(int i) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.e(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public void f(int i) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.f(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public int i() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.i();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // defpackage.wt
    public void d(boolean z) {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.d(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.wt
    public boolean j() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                return wtVar.j();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.wt
    public void k() {
        wt wtVar = this.a;
        if (wtVar != null) {
            try {
                wtVar.k();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
