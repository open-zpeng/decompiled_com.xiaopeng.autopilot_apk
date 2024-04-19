package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: IDataUploadInterface.java */
/* renamed from: wd  reason: default package */
/* loaded from: classes.dex */
public interface wd extends IInterface {
    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(List<String> list) throws RemoteException;

    void a(List<String> list, String str) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(String str, String str2) throws RemoteException;

    void c(String str) throws RemoteException;

    /* compiled from: IDataUploadInterface.java */
    /* renamed from: wd$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements wd {
        public static wd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wd)) {
                return (wd) queryLocalInterface;
            }
            return new C0069a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    a(parcel.readString());
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    a(parcel.readString(), parcel.readString());
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    b(parcel.readString());
                    return true;
                case 4:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    b(parcel.readString(), parcel.readString());
                    return true;
                case 5:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    a(parcel.createStringArrayList());
                    return true;
                case 6:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    c(parcel.readString());
                    return true;
                case 7:
                    parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    a(parcel.createStringArrayList(), parcel.readString());
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IDataUploadInterface.java */
        /* renamed from: wd$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0069a implements wd {
            private IBinder a;

            C0069a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.wd
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.wd
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.wd
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.wd
            public void b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.wd
            public void a(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeStringList(list);
                    this.a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.wd
            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.wd
            public void a(List<String> list, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    this.a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
