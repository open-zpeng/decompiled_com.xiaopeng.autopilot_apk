package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.xm;
/* compiled from: IRecognizer.java */
/* renamed from: xn  reason: default package */
/* loaded from: classes.dex */
public interface xn extends IInterface {
    void a() throws RemoteException;

    void a(String str, double d) throws RemoteException;

    void a(String str, int i) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(xm xmVar) throws RemoteException;

    void a(byte[] bArr, int i, int i2) throws RemoteException;

    boolean b() throws RemoteException;

    void c() throws RemoteException;

    /* compiled from: IRecognizer.java */
    /* renamed from: xn$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements xn {
        public static xn a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.asr.IRecognizer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof xn)) {
                return (xn) queryLocalInterface;
            }
            return new C0079a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.asr.IRecognizer");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a(xm.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    boolean b = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a(parcel.createByteArray(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.asr.IRecognizer");
                    a(parcel.readString(), parcel.readDouble());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IRecognizer.java */
        /* renamed from: xn$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0079a implements xn {
            private IBinder a;

            C0079a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.xn
            public void a(xm xmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    obtain.writeStrongBinder(xmVar != null ? xmVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void a(byte[] bArr, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void a(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void a(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.xn
            public void a(String str, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.asr.IRecognizer");
                    obtain.writeString(str);
                    obtain.writeDouble(d);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
