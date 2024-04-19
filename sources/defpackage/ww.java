package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IWindowEngine.java */
/* renamed from: ww  reason: default package */
/* loaded from: classes.dex */
public interface ww extends IInterface {
    void a(int i, int i2) throws RemoteException;

    void a(int i, boolean z) throws RemoteException;

    boolean a(int i) throws RemoteException;

    int b() throws RemoteException;

    void b(int i) throws RemoteException;

    void c(int i) throws RemoteException;

    void d(int i) throws RemoteException;

    /* compiled from: IWindowEngine.java */
    /* renamed from: ww$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements ww {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.IWindowEngine");
        }

        public static ww a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.IWindowEngine");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ww)) {
                return (ww) queryLocalInterface;
            }
            return new C0077a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.IWindowEngine");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    int b = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b);
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    boolean a = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    b(parcel.readInt());
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    c(parcel.readInt());
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    d(parcel.readInt());
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    a(parcel.readInt(), parcel.readInt());
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.IWindowEngine");
                    a(parcel.readInt(), parcel.readInt() != 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IWindowEngine.java */
        /* renamed from: ww$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0077a implements ww {
            private IBinder a;

            C0077a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.ww
            public int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ww
            public boolean a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    obtain.writeInt(i);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ww
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    obtain.writeInt(i);
                    this.a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.ww
            public void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    obtain.writeInt(i);
                    this.a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.ww
            public void d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    obtain.writeInt(i);
                    this.a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.ww
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.ww
            public void a(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IWindowEngine");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
