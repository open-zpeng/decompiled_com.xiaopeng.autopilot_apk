package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IRecognizeListener.java */
/* renamed from: xm  reason: default package */
/* loaded from: classes.dex */
public interface xm extends IInterface {
    void a(int i, int i2) throws RemoteException;

    void a(int i, int i2, int i3, String str, byte[] bArr) throws RemoteException;

    void a(int i, String str) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    /* compiled from: IRecognizeListener.java */
    /* renamed from: xm$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements xm {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static xm a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.asr.IRecognizeListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof xm)) {
                return (xm) queryLocalInterface;
            }
            return new C0078a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.asr.IRecognizeListener");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizeListener");
                    a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizeListener");
                    a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizeListener");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizeListener");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IRecognizeListener.java */
        /* renamed from: xm$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0078a implements xm {
            private IBinder a;

            C0078a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.xm
            public void a(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizeListener");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xm
            public void a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizeListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xm
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizeListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xm
            public void a(int i, int i2, int i3, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizeListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
