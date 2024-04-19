package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IHotwordEngine.java */
/* renamed from: ye  reason: default package */
/* loaded from: classes.dex */
public interface ye extends IInterface {
    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, IBinder iBinder) throws RemoteException;

    void b() throws RemoteException;

    void b(String str) throws RemoteException;

    int c() throws RemoteException;

    /* compiled from: IHotwordEngine.java */
    /* renamed from: ye$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements ye {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.IHotwordEngine");
        }

        public static ye a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ye)) {
                return (ye) queryLocalInterface;
            }
            return new C0084a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.IHotwordEngine");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    int c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    a(parcel.readString(), parcel.readString(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IHotwordEngine.java */
        /* renamed from: ye$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0084a implements ye {
            private IBinder a;

            C0084a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.ye
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ye
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ye
            public int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ye
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ye
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.ye
            public void a(String str, String str2, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IHotwordEngine");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
