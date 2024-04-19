package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.yd;
/* compiled from: ISubscriber.java */
/* renamed from: yh  reason: default package */
/* loaded from: classes.dex */
public interface yh extends IInterface {
    void a(yd ydVar) throws RemoteException;

    void a(String[] strArr, yd ydVar) throws RemoteException;

    boolean a(String str) throws RemoteException;

    /* compiled from: ISubscriber.java */
    /* renamed from: yh$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yh {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.ISubscriber");
        }

        public static yh a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.ISubscriber");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yh)) {
                return (yh) queryLocalInterface;
            }
            return new C0087a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.ISubscriber");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ISubscriber");
                    a(parcel.createStringArray(), yd.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ISubscriber");
                    a(yd.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ISubscriber");
                    boolean a = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ISubscriber.java */
        /* renamed from: yh$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0087a implements yh {
            private IBinder a;

            C0087a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yh
            public void a(String[] strArr, yd ydVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ISubscriber");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(ydVar != null ? ydVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yh
            public void a(yd ydVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ISubscriber");
                    obtain.writeStrongBinder(ydVar != null ? ydVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yh
            public boolean a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ISubscriber");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
