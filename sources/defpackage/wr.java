package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.ws;
/* compiled from: IQueryInjector.java */
/* renamed from: wr  reason: default package */
/* loaded from: classes.dex */
public interface wr extends IInterface {
    xu a(String str, String str2) throws RemoteException;

    void a(String[] strArr) throws RemoteException;

    void a(String[] strArr, ws wsVar) throws RemoteException;

    boolean a(String str) throws RemoteException;

    xu b(String str, String str2) throws RemoteException;

    /* compiled from: IQueryInjector.java */
    /* renamed from: wr$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wr {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.IQueryInjector");
        }

        public static wr a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.IQueryInjector");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wr)) {
                return (wr) queryLocalInterface;
            }
            return new C0072a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.IQueryInjector");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.IQueryInjector");
                    a(parcel.createStringArray(), ws.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.IQueryInjector");
                    a(parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.IQueryInjector");
                    xu a = a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.IQueryInjector");
                    boolean a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.IQueryInjector");
                    xu b = b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (b != null) {
                        parcel2.writeInt(1);
                        b.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IQueryInjector.java */
        /* renamed from: wr$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0072a implements wr {
            private IBinder a;

            C0072a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wr
            public void a(String[] strArr, ws wsVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IQueryInjector");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(wsVar != null ? wsVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wr
            public void a(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IQueryInjector");
                    obtain.writeStringArray(strArr);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wr
            public xu a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IQueryInjector");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? xu.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wr
            public boolean a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IQueryInjector");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wr
            public xu b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IQueryInjector");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? xu.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
