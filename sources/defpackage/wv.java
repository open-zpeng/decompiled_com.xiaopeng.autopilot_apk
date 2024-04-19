package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: ISpeechState.java */
/* renamed from: wv  reason: default package */
/* loaded from: classes.dex */
public interface wv extends IInterface {
    void a(int i) throws RemoteException;

    void a(int i, boolean z) throws RemoteException;

    void a(IBinder iBinder, int i) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    String b(String str) throws RemoteException;

    void b(int i) throws RemoteException;

    void b(boolean z) throws RemoteException;

    boolean b() throws RemoteException;

    int c() throws RemoteException;

    boolean c(int i) throws RemoteException;

    boolean d() throws RemoteException;

    int e() throws RemoteException;

    boolean f() throws RemoteException;

    boolean g() throws RemoteException;

    String h() throws RemoteException;

    boolean i() throws RemoteException;

    boolean j() throws RemoteException;

    boolean k() throws RemoteException;

    boolean l() throws RemoteException;

    boolean m() throws RemoteException;

    /* compiled from: ISpeechState.java */
    /* renamed from: wv$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wv {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.ISpeechState");
        }

        public static wv a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.ISpeechState");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wv)) {
                return (wv) queryLocalInterface;
            }
            return new C0076a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.ISpeechState");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean b = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    int c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c);
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean d = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(d ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    int e = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e);
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean g = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    String h = h();
                    parcel2.writeNoException();
                    parcel2.writeString(h);
                    return true;
                case 12:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    a(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean c2 = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3 ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean j = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(j ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean k = k();
                    parcel2.writeNoException();
                    parcel2.writeInt(k ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean l = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(l ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    boolean m = m();
                    parcel2.writeNoException();
                    parcel2.writeInt(m ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    a(parcel.readStrongBinder(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.xiaopeng.speech.ISpeechState");
                    String b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ISpeechState.java */
        /* renamed from: wv$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0076a implements wv {
            private IBinder a;

            C0076a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wv
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeInt(i);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeInt(i);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public int e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public String h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeString(str);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void a(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeInt(i);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public boolean m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public void a(IBinder iBinder, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.wv
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.ISpeechState");
                    obtain.writeString(str);
                    this.a.transact(21, obtain, obtain2, 0);
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
