package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IRemoteDataSensor.java */
/* renamed from: ws  reason: default package */
/* loaded from: classes.dex */
public interface ws extends IInterface {
    xu a(String str, String str2) throws RemoteException;

    /* compiled from: IRemoteDataSensor.java */
    /* renamed from: ws$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements ws {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.IRemoteDataSensor");
        }

        public static ws a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.IRemoteDataSensor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ws)) {
                return (ws) queryLocalInterface;
            }
            return new C0073a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.xiaopeng.speech.IRemoteDataSensor");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.xiaopeng.speech.IRemoteDataSensor");
            xu a = a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (a != null) {
                parcel2.writeInt(1);
                a.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        /* compiled from: IRemoteDataSensor.java */
        /* renamed from: ws$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0073a implements ws {
            private IBinder a;

            C0073a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.ws
            public xu a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.IRemoteDataSensor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(1, obtain, obtain2, 0);
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
