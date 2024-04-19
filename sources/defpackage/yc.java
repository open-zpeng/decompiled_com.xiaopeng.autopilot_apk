package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IAppMgr.java */
/* renamed from: yc  reason: default package */
/* loaded from: classes.dex */
public interface yc extends IInterface {
    String a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    String[] b(String str) throws RemoteException;

    /* compiled from: IAppMgr.java */
    /* renamed from: yc$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yc {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.IAppMgr");
        }

        public static yc a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.IAppMgr");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yc)) {
                return (yc) queryLocalInterface;
            }
            return new C0082a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.IAppMgr");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAppMgr");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAppMgr");
                    String a = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAppMgr");
                    String[] b = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(b);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IAppMgr.java */
        /* renamed from: yc$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0082a implements yc {
            private IBinder a;

            C0082a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yc
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAppMgr");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yc
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAppMgr");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yc
            public String[] b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAppMgr");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
