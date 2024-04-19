package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.wo;
import defpackage.wp;
import defpackage.wr;
import defpackage.wt;
import defpackage.wv;
import defpackage.ww;
import defpackage.xn;
import defpackage.ya;
import defpackage.yb;
import defpackage.yc;
import defpackage.ye;
import defpackage.yf;
import defpackage.yh;
import defpackage.yj;
import defpackage.yk;
import defpackage.yl;
/* compiled from: ISpeechEngine.java */
/* renamed from: wu  reason: default package */
/* loaded from: classes.dex */
public interface wu extends IInterface {
    wo a() throws RemoteException;

    yh b() throws RemoteException;

    yj c() throws RemoteException;

    yl d() throws RemoteException;

    yb e() throws RemoteException;

    yc f() throws RemoteException;

    wv g() throws RemoteException;

    wt h() throws RemoteException;

    ya i() throws RemoteException;

    wr j() throws RemoteException;

    yf k() throws RemoteException;

    ww l() throws RemoteException;

    xn m() throws RemoteException;

    ye n() throws RemoteException;

    wp o() throws RemoteException;

    yk p() throws RemoteException;

    /* compiled from: ISpeechEngine.java */
    /* renamed from: wu$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wu {
        public static wu a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.ISpeechEngine");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wu)) {
                return (wu) queryLocalInterface;
            }
            return new C0075a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.ISpeechEngine");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    wo a = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yh b = b();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(b != null ? b.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yj c = c();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(c != null ? c.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yl d = d();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yb e = e();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(e != null ? e.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yc f = f();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(f != null ? f.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    wv g = g();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(g != null ? g.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    wt h = h();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(h != null ? h.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    ya i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(i3 != null ? i3.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    wr j = j();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(j != null ? j.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yf k = k();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(k != null ? k.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    ww l = l();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(l != null ? l.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    xn m = m();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(m != null ? m.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    ye n = n();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(n != null ? n.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    wp o = o();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(o != null ? o.asBinder() : null);
                    return true;
                case 16:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechEngine");
                    yk p = p();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(p != null ? p.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ISpeechEngine.java */
        /* renamed from: wu$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0075a implements wu {
            private IBinder a;

            C0075a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wu
            public wo a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return wo.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yh b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return yh.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yj c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return yj.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yl d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return yl.a.i(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yb e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return yb.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yc f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return yc.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public wv g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return wv.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public wt h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return wt.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public ya i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return ya.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public wr j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return wr.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yf k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return yf.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public ww l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return ww.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public xn m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return xn.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public ye n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return ye.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public wp o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return wp.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wu
            public yk p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechEngine");
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return yk.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
