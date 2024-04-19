package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: ISoundLockState.java */
/* renamed from: wt  reason: default package */
/* loaded from: classes.dex */
public interface wt extends IInterface {
    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(int i, long j, int i2) throws RemoteException;

    void a(boolean z) throws RemoteException;

    int b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(boolean z) throws RemoteException;

    int c() throws RemoteException;

    void c(int i) throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d(int i) throws RemoteException;

    void d(boolean z) throws RemoteException;

    boolean d() throws RemoteException;

    void e(int i) throws RemoteException;

    boolean e() throws RemoteException;

    int f() throws RemoteException;

    void f(int i) throws RemoteException;

    int g() throws RemoteException;

    boolean h() throws RemoteException;

    int i() throws RemoteException;

    boolean j() throws RemoteException;

    void k() throws RemoteException;

    /* compiled from: ISoundLockState.java */
    /* renamed from: wt$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wt {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.ISoundLockState");
        }

        public static wt a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.ISoundLockState");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wt)) {
                return (wt) queryLocalInterface;
            }
            return new C0074a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.ISoundLockState");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    int b = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b);
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    int c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c);
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    boolean d = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(d ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    boolean e = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    int f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f);
                    return true;
                case 10:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    c(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    int g = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g);
                    return true;
                case 13:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    a(parcel.readInt(), parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    boolean h = h();
                    parcel2.writeNoException();
                    parcel2.writeInt(h ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    e(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    f(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    int i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    d(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    boolean j = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(j ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface("com.xiaopeng.speech.ISoundLockState");
                    k();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ISoundLockState.java */
        /* renamed from: wt$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0074a implements wt {
            private IBinder a;

            C0074a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wt
            public int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public boolean d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public boolean e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public int f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public int g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void a(int i, long j, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(i2);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public boolean h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(i);
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public int i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void d(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public boolean j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wt
            public void k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISoundLockState");
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
