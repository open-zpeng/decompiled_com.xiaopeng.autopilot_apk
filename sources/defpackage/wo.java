package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IActorBridge.java */
/* renamed from: wo  reason: default package */
/* loaded from: classes.dex */
public interface wo extends IInterface {
    void a(xc xcVar) throws RemoteException;

    /* compiled from: IActorBridge.java */
    /* renamed from: wo$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wo {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.IActorBridge");
        }

        public static wo a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.IActorBridge");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wo)) {
                return (wo) queryLocalInterface;
            }
            return new C0070a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.xiaopeng.speech.IActorBridge");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.xiaopeng.speech.IActorBridge");
            a(parcel.readInt() != 0 ? xc.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: IActorBridge.java */
        /* renamed from: wo$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0070a implements wo {
            private IBinder a;

            C0070a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wo
            public void a(xc xcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IActorBridge");
                    if (xcVar != null) {
                        obtain.writeInt(1);
                        xcVar.writeToParcel(obtain, 0);
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
