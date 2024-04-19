package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: ISpeechConfigCallback.java */
/* renamed from: yg  reason: default package */
/* loaded from: classes.dex */
public interface yg extends IInterface {
    void a(int i, String str) throws RemoteException;

    /* compiled from: ISpeechConfigCallback.java */
    /* renamed from: yg$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yg {
        public static yg a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.ISpeechConfigCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yg)) {
                return (yg) queryLocalInterface;
            }
            return new C0086a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.xiaopeng.speech.coreapi.ISpeechConfigCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.xiaopeng.speech.coreapi.ISpeechConfigCallback");
            a(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: ISpeechConfigCallback.java */
        /* renamed from: yg$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0086a implements yg {
            private IBinder a;

            C0086a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yg
            public void a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ISpeechConfigCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
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
