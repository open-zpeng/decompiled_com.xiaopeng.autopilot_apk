package defpackage;

import com.badlogic.gdx.utils.k;
import defpackage.iv;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
/* compiled from: NetJavaServerSocketImpl.java */
/* renamed from: od  reason: default package */
/* loaded from: classes.dex */
public class od implements of {
    private iv.d a;
    private ServerSocket b;

    public od(iv.d dVar, int i, og ogVar) {
        this(dVar, null, i, ogVar);
    }

    public od(iv.d dVar, String str, int i, og ogVar) {
        InetSocketAddress inetSocketAddress;
        this.a = dVar;
        try {
            this.b = new ServerSocket();
            if (ogVar != null) {
                this.b.setPerformancePreferences(ogVar.b, ogVar.c, ogVar.d);
                this.b.setReuseAddress(ogVar.e);
                this.b.setSoTimeout(ogVar.f);
                this.b.setReceiveBufferSize(ogVar.g);
            }
            if (str != null) {
                inetSocketAddress = new InetSocketAddress(str, i);
            } else {
                inetSocketAddress = new InetSocketAddress(i);
            }
            if (ogVar != null) {
                this.b.bind(inetSocketAddress, ogVar.a);
            } else {
                this.b.bind(inetSocketAddress);
            }
        } catch (Exception e) {
            throw new k("Cannot create a server socket at port " + i + ".", e);
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        ServerSocket serverSocket = this.b;
        if (serverSocket != null) {
            try {
                serverSocket.close();
                this.b = null;
            } catch (Exception e) {
                throw new k("Error closing server.", e);
            }
        }
    }
}
