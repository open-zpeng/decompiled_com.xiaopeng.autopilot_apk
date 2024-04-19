package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IEventObserver.java */
/* renamed from: yd  reason: default package */
/* loaded from: classes.dex */
public interface yd extends IInterface {
    void a(String str, String str2) throws RemoteException;

    /* compiled from: IEventObserver.java */
    /* renamed from: yd$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yd {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.IEventObserver");
        }

        public static yd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.IEventObserver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yd)) {
                return (yd) queryLocalInterface;
            }
            return new C0083a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.xiaopeng.speech.coreapi.IEventObserver");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.xiaopeng.speech.coreapi.IEventObserver");
            a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: IEventObserver.java */
        /* renamed from: yd$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0083a implements yd {
            private IBinder a;

            C0083a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yd
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IEventObserver");
                    obtain.writeString(str);
                    obtain.writeString(str2);
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
