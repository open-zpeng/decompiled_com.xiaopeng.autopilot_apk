package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPCCallback.java */
/* renamed from: vv  reason: default package */
/* loaded from: classes.dex */
public interface vv extends IInterface {
    void onReceive(vw vwVar) throws RemoteException;

    /* compiled from: IPCCallback.java */
    /* renamed from: vv$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements vv {
        private static final String DESCRIPTOR = "com.xiaopeng.ipc.IPCCallback";
        static final int TRANSACTION_onReceive = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static vv asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof vv)) {
                return (vv) queryLocalInterface;
            }
            return new C0068a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onReceive(parcel.readInt() != 0 ? vw.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: IPCCallback.java */
        /* renamed from: vv$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0068a implements vv {
            private IBinder a;

            C0068a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.vv
            public void onReceive(vw vwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (vwVar != null) {
                        obtain.writeInt(1);
                        vwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
