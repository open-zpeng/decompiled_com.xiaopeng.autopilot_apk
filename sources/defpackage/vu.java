package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.vv;
/* compiled from: IPC.java */
/* renamed from: vu  reason: default package */
/* loaded from: classes.dex */
public interface vu extends IInterface {
    void a(String str, vv vvVar) throws RemoteException;

    void a(String str, vw vwVar) throws RemoteException;

    void b(String str, vv vvVar) throws RemoteException;

    /* compiled from: IPC.java */
    /* renamed from: vu$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements vu {
        public static vu a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.ipc.IPC");
            if (queryLocalInterface != null && (queryLocalInterface instanceof vu)) {
                return (vu) queryLocalInterface;
            }
            return new C0067a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.ipc.IPC");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.ipc.IPC");
                    a(parcel.readString(), vv.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.ipc.IPC");
                    b(parcel.readString(), vv.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.ipc.IPC");
                    a(parcel.readString(), parcel.readInt() != 0 ? vw.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IPC.java */
        /* renamed from: vu$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0067a implements vu {
            private IBinder a;

            C0067a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.vu
            public void a(String str, vv vvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(vvVar != null ? vvVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.vu
            public void b(String str, vv vvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(vvVar != null ? vvVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.vu
            public void a(String str, vw vwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    if (vwVar != null) {
                        obtain.writeInt(1);
                        vwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
