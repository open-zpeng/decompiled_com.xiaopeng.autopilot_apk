package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.autopilot.x.protocol.apirouter.ParkingSpeechObserver;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
/* loaded from: classes.dex */
public class ParkingSpeechObserver_Stub extends Binder implements IInterface {
    public ParkingSpeechObserver provider = new ParkingSpeechObserver();
    public ParkingSpeechObserver_Manifest manifest = new ParkingSpeechObserver_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1598968902) {
            parcel2.writeString(ParkingSpeechObserver_Manifest.DESCRIPTOR);
            return true;
        }
        switch (i) {
            case 0:
                parcel.enforceInterface(ParkingSpeechObserver_Manifest.DESCRIPTOR);
                Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                try {
                    this.provider.onEvent((String) TransactTranslator.read(uri.getQueryParameter("event"), "java.lang.String"), (String) TransactTranslator.read(uri.getQueryParameter(Constants.DATA), "java.lang.String"));
                    parcel2.writeNoException();
                    TransactTranslator.reply(parcel2, null);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    parcel2.writeException(new IllegalStateException(e.getMessage()));
                    return true;
                }
            case 1:
                parcel.enforceInterface(ParkingSpeechObserver_Manifest.DESCRIPTOR);
                Uri uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                try {
                    this.provider.onQuery((String) TransactTranslator.read(uri2.getQueryParameter("event"), "java.lang.String"), (String) TransactTranslator.read(uri2.getQueryParameter(Constants.DATA), "java.lang.String"), (String) TransactTranslator.read(uri2.getQueryParameter("callback"), "java.lang.String"));
                    parcel2.writeNoException();
                    TransactTranslator.reply(parcel2, null);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    parcel2.writeException(new IllegalStateException(e2.getMessage()));
                    return true;
                }
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
