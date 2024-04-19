package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IASREngine.java */
/* renamed from: ya  reason: default package */
/* loaded from: classes.dex */
public interface ya extends IInterface {
    void a(long j) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b(long j) throws RemoteException;

    void b(boolean z) throws RemoteException;

    boolean b() throws RemoteException;

    boolean c() throws RemoteException;

    void d() throws RemoteException;

    void e() throws RemoteException;

    void f() throws RemoteException;

    /* compiled from: IASREngine.java */
    /* renamed from: ya$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements ya {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.IASREngine");
        }

        public static ya a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.IASREngine");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ya)) {
                return (ya) queryLocalInterface;
            }
            return new C0080a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.IASREngine");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    boolean b = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    boolean c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    e();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    f();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IASREngine");
                    b(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IASREngine.java */
        /* renamed from: ya$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0080a implements ya {
            private IBinder a;

            C0080a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.ya
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public void e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public void f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public void a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    obtain.writeLong(j);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ya
            public void b(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IASREngine");
                    obtain.writeLong(j);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
