package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.yi;
/* compiled from: ITTSEngine.java */
/* renamed from: yj  reason: default package */
/* loaded from: classes.dex */
public interface yj extends IInterface {
    void a(float f) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(yi yiVar) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(boolean z, IBinder iBinder) throws RemoteException;

    boolean a(String str, int i, String str2, int i2) throws RemoteException;

    boolean a(String str, int i, String str2, int i2, int i3, int i4, long j) throws RemoteException;

    String b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(yi yiVar) throws RemoteException;

    float c() throws RemoteException;

    int d() throws RemoteException;

    boolean e() throws RemoteException;

    boolean f() throws RemoteException;

    /* compiled from: ITTSEngine.java */
    /* renamed from: yj$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yj {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.ITTSEngine");
        }

        public static yj a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yj)) {
                return (yj) queryLocalInterface;
            }
            return new C0089a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.ITTSEngine");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    boolean a = a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    float c = c();
                    parcel2.writeNoException();
                    parcel2.writeFloat(c);
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    int d = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(d);
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(yi.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    b(yi.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(parcel.readInt() != 0, parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    boolean e = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    boolean f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    boolean a2 = a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.ITTSEngine");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ITTSEngine.java */
        /* renamed from: yj$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0089a implements yj {
            private IBinder a;

            C0089a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yj
            public boolean a(String str, int i, String str2, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeFloat(f);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public float c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeInt(i);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public int d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeString(str);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(yi yiVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeStrongBinder(yiVar != null ? yiVar.asBinder() : null);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void b(yi yiVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeStrongBinder(yiVar != null ? yiVar.asBinder() : null);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(boolean z, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public boolean e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public boolean f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public boolean a(String str, int i, String str2, int i2, int i3, int i4, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeLong(j);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeInt(i);
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yj
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.ITTSEngine");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
