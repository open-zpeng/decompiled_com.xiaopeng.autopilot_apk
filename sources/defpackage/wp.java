package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: ICarSystemProperty.java */
/* renamed from: wp  reason: default package */
/* loaded from: classes.dex */
public interface wp extends IInterface {
    String b() throws RemoteException;

    String c() throws RemoteException;

    /* compiled from: ICarSystemProperty.java */
    /* renamed from: wp$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wp {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.ICarSystemProperty");
        }

        public static wp a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.ICarSystemProperty");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wp)) {
                return (wp) queryLocalInterface;
            }
            return new C0071a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.ICarSystemProperty");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.ICarSystemProperty");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.ICarSystemProperty");
                    String c = c();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ICarSystemProperty.java */
        /* renamed from: wp$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0071a implements wp {
            private IBinder a;

            C0071a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wp
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ICarSystemProperty");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wp
            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ICarSystemProperty");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
