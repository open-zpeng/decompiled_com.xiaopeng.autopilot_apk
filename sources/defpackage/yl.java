package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IWakeupEngine.java */
/* renamed from: yl  reason: default package */
/* loaded from: classes.dex */
public interface yl extends IInterface {
    void a(IBinder iBinder) throws RemoteException;

    void a(IBinder iBinder, int i, String str, int i2) throws RemoteException;

    void a(IBinder iBinder, int i, String str, String str2, int i2) throws RemoteException;

    void a(IBinder iBinder, String str, int i) throws RemoteException;

    void a(IBinder iBinder, String str, String str2) throws RemoteException;

    void a(IBinder iBinder, String str, String str2, int i) throws RemoteException;

    void a(IBinder iBinder, boolean z) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2, String str3, String[] strArr) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(String[] strArr) throws RemoteException;

    void a(String[] strArr, String[] strArr2, String[] strArr3) throws RemoteException;

    void a(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5) throws RemoteException;

    void b() throws RemoteException;

    void b(IBinder iBinder) throws RemoteException;

    void b(IBinder iBinder, String str, String str2) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void b(String[] strArr) throws RemoteException;

    void b(String[] strArr, String[] strArr2, String[] strArr3) throws RemoteException;

    void b(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5) throws RemoteException;

    void c() throws RemoteException;

    void c(IBinder iBinder) throws RemoteException;

    void c(String str) throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void d(IBinder iBinder) throws RemoteException;

    void e() throws RemoteException;

    void e(IBinder iBinder) throws RemoteException;

    void f() throws RemoteException;

    void f(IBinder iBinder) throws RemoteException;

    void g() throws RemoteException;

    void g(IBinder iBinder) throws RemoteException;

    void h(IBinder iBinder) throws RemoteException;

    String[] h() throws RemoteException;

    String i() throws RemoteException;

    void j() throws RemoteException;

    void k() throws RemoteException;

    void l() throws RemoteException;

    void m() throws RemoteException;

    boolean n() throws RemoteException;

    boolean o() throws RemoteException;

    boolean p() throws RemoteException;

    boolean q() throws RemoteException;

    void r() throws RemoteException;

    void s() throws RemoteException;

    boolean t() throws RemoteException;

    void u() throws RemoteException;

    void v() throws RemoteException;

    void w() throws RemoteException;

    /* compiled from: IWakeupEngine.java */
    /* renamed from: yl$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements yl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xiaopeng.speech.coreapi.IWakeupEngine");
        }

        public static yl i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
            if (queryLocalInterface != null && (queryLocalInterface instanceof yl)) {
                return (yl) queryLocalInterface;
            }
            return new C0091a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.speech.coreapi.IWakeupEngine");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    e();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    f();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    g();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    String[] h = h();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(h);
                    return true;
                case 9:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    String i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeString(i3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    j();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    k();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    l();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    m();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    boolean n = n();
                    parcel2.writeNoException();
                    parcel2.writeInt(n ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    boolean o = o();
                    parcel2.writeNoException();
                    parcel2.writeInt(o ? 1 : 0);
                    return true;
                case 23:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    boolean p = p();
                    parcel2.writeNoException();
                    parcel2.writeInt(p ? 1 : 0);
                    return true;
                case 27:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    boolean q = q();
                    parcel2.writeNoException();
                    parcel2.writeInt(q ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    r();
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    s();
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    boolean t = t();
                    parcel2.writeNoException();
                    parcel2.writeInt(t ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    u();
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    v();
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    w();
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    c(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    d(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    e(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    f(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    g(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    h(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder(), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    a(parcel.readStrongBinder(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    b(parcel.readStrongBinder(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IWakeupEngine.java */
        /* renamed from: yl$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0091a implements yl {
            private IBinder a;

            C0091a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.yl
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public String[] h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(String str, String str2, String str3, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public String i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeStringArray(strArr3);
                    obtain.writeStringArray(strArr4);
                    obtain.writeStringArray(strArr5);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeStringArray(strArr3);
                    obtain.writeStringArray(strArr4);
                    obtain.writeStringArray(strArr5);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStringArray(strArr);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(String[] strArr, String[] strArr2, String[] strArr3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeStringArray(strArr3);
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(String[] strArr, String[] strArr2, String[] strArr3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeStringArray(strArr3);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStringArray(strArr);
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public boolean n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public boolean o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public boolean p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public boolean q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public boolean t() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void u() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void v() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    this.a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeString(str);
                    this.a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void c(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void d(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void e(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void f(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void g(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void h(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeString(str);
                    this.a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder, int i, String str, String str2, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    this.a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder, int i, String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder, String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void a(IBinder iBinder, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.yl
            public void b(IBinder iBinder, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.speech.coreapi.IWakeupEngine");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
