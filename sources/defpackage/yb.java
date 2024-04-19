package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import defpackage.yg;
/* compiled from: IAgent.java */
/* renamed from: yb  reason: default package */
/* loaded from: classes.dex */
public interface yb extends IInterface {
    void a(int i, String str) throws RemoteException;

    void a(IBinder iBinder, String str, String str2, String str3, String str4) throws RemoteException;

    void a(IBinder iBinder, boolean z) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, int i) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, int i) throws RemoteException;

    void a(String str, String str2, String str3, String str4) throws RemoteException;

    void a(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void a(String str, String str2, yg ygVar) throws RemoteException;

    void a(String str, xt xtVar, int i) throws RemoteException;

    void a(String str, String[] strArr, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(String str, String str2) throws RemoteException;

    void b(boolean z) throws RemoteException;

    boolean b() throws RemoteException;

    void c(String str) throws RemoteException;

    void c(String str, String str2) throws RemoteException;

    void c(boolean z) throws RemoteException;

    boolean c() throws RemoteException;

    void d(String str) throws RemoteException;

    void d(String str, String str2) throws RemoteException;

    boolean d() throws RemoteException;

    String e(String str) throws RemoteException;

    void e(String str, String str2) throws RemoteException;

    boolean e() throws RemoteException;

    String f(String str) throws RemoteException;

    void f(String str, String str2) throws RemoteException;

    String g(String str, String str2) throws RemoteException;

    void g(String str) throws RemoteException;

    String h(String str) throws RemoteException;

    /* compiled from: IAgent.java */
    /* renamed from: yb$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yb {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.IAgent");
        }

        public static yb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.IAgent");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yb)) {
                return (yb) queryLocalInterface;
            }
            return new C0081a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.IAgent");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    c(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    boolean b = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    boolean c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    boolean d = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(d ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    d(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    d(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    String e = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(e);
                    return true;
                case 18:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readStrongBinder(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    boolean e2 = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e2 ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    String f = f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(f);
                    return true;
                case 21:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    g(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    String h = h(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(h);
                    return true;
                case 23:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    e(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    f(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    String g = g(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(g);
                    return true;
                case 27:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readInt() != 0 ? xt.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readStrongBinder(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IAgent");
                    a(parcel.readString(), parcel.readString(), yg.a.a(parcel.readStrongBinder()));
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IAgent.java */
        /* renamed from: yb$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0081a implements yb {
            private IBinder a;

            C0081a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yb
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, String[] strArr, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void c(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public boolean d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void d(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(IBinder iBinder, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public boolean e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public String f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public String h(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void e(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void f(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public String g(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, xt xtVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    if (xtVar != null) {
                        obtain.writeInt(1);
                        xtVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(IBinder iBinder, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yb
            public void a(String str, String str2, yg ygVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IAgent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(ygVar != null ? ygVar.asBinder() : null);
                    this.a.transact(32, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
