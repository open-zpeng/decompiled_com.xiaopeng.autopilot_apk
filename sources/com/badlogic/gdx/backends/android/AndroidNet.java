package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import defpackage.iv;
/* loaded from: classes.dex */
public class AndroidNet implements iv {
    final AndroidApplicationBase app;
    oc netJavaImpl = new oc();

    public AndroidNet(AndroidApplicationBase androidApplicationBase) {
        this.app = androidApplicationBase;
    }

    public void sendHttpRequest(iv.a aVar, iv.c cVar) {
        this.netJavaImpl.a(aVar, cVar);
    }

    public void cancelHttpRequest(iv.a aVar) {
        this.netJavaImpl.a(aVar);
    }

    public of newServerSocket(iv.d dVar, String str, int i, og ogVar) {
        return new od(dVar, str, i, ogVar);
    }

    public of newServerSocket(iv.d dVar, int i, og ogVar) {
        return new od(dVar, i, ogVar);
    }

    public oh newClientSocket(iv.d dVar, String str, int i, oi oiVar) {
        return new oe(dVar, str, i, oiVar);
    }

    public boolean openURI(String str) {
        final Uri parse = Uri.parse(str);
        if (this.app.getContext().getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", parse), 65536) != null) {
            this.app.runOnUiThread(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidNet.1
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    if (!(AndroidNet.this.app.getContext() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    AndroidNet.this.app.startActivity(intent);
                }
            });
            return true;
        }
        return false;
    }
}
