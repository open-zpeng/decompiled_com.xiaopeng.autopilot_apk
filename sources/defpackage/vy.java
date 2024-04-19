package defpackage;

import android.content.ContentProviderClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.apirouter.server.ServerConstants;
import java.util.List;
/* compiled from: ApiRouter.java */
/* renamed from: vy  reason: default package */
/* loaded from: classes.dex */
public class vy {
    private static vx a = new vx();

    private static wa a(wb wbVar, IBinder iBinder, String str) {
        wa a2 = wa.a(iBinder, str);
        a.a(wbVar, a2);
        return a2;
    }

    private static wa a(wb wbVar) throws RemoteException {
        if (ApiPublisherProvider.CONTEXT == null) {
            throw new RemoteException("ApiRouter can not route. If it is an asynchronous thread, please check your Context first!");
        }
        Uri.Builder builder = new Uri.Builder();
        if (TextUtils.isEmpty(wbVar.c)) {
            Uri.Builder scheme = builder.scheme("content");
            scheme.authority(wbVar.a + ".api.publisher");
        } else {
            Uri.Builder scheme2 = builder.scheme("content");
            scheme2.authority(wbVar.a + "." + wbVar.c + ".api.publisher");
        }
        ContentProviderClient acquireContentProviderClient = ApiPublisherProvider.CONTEXT.getContentResolver().acquireContentProviderClient(builder.build());
        if (acquireContentProviderClient == null) {
            throw new RemoteException("Unknown service " + wbVar);
        }
        try {
            Bundle call = acquireContentProviderClient.call(wbVar.b, null, null);
            if (call == null) {
                throw new RemoteException("Server does not implement call");
            }
            IBinder binder = call.getBinder(ServerConstants.BINDER.BINDER);
            String string = call.getString(ServerConstants.BINDER.MANIFEST);
            if (binder == null || TextUtils.isEmpty(string)) {
                throw new RemoteException("No matching method");
            }
            return a(wbVar, binder, string);
        } finally {
            acquireContentProviderClient.release();
        }
    }

    public static <T> T a(Uri uri) throws RemoteException {
        return (T) a(uri, false, (byte[]) null);
    }

    private static <T> T a(Uri uri, boolean z, byte[] bArr) throws RemoteException {
        wb b = b(uri);
        wa b2 = a.b(b);
        if (b2 == null) {
            b2 = a(b);
        } else if (!b2.c()) {
            a.a(b);
            b2 = a(b);
        }
        return (T) b2.a(uri, z, bArr);
    }

    private static wb b(Uri uri) throws RemoteException {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new RemoteException("Can not find authority in uri");
        }
        int lastIndexOf = authority.lastIndexOf(".");
        if (lastIndexOf == -1) {
            throw new RemoteException("Illegal uri authority");
        }
        String substring = authority.substring(0, lastIndexOf);
        String substring2 = authority.substring(lastIndexOf + 1);
        wb wbVar = new wb();
        wbVar.a = substring;
        wbVar.b = substring2;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments != null && pathSegments.size() > 1) {
            wbVar.c = pathSegments.get(1);
        }
        return wbVar;
    }
}
