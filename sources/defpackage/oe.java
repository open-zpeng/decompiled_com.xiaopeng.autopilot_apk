package defpackage;

import com.badlogic.gdx.utils.k;
import defpackage.iv;
import java.net.InetSocketAddress;
import java.net.Socket;
/* compiled from: NetJavaSocketImpl.java */
/* renamed from: oe  reason: default package */
/* loaded from: classes.dex */
public class oe implements oh {
    private Socket a;

    public oe(iv.d dVar, String str, int i, oi oiVar) {
        try {
            this.a = new Socket();
            a(oiVar);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (oiVar != null) {
                this.a.connect(inetSocketAddress, oiVar.a);
            } else {
                this.a.connect(inetSocketAddress);
            }
        } catch (Exception e) {
            throw new k("Error making a socket connection to " + str + ":" + i, e);
        }
    }

    private void a(oi oiVar) {
        if (oiVar != null) {
            try {
                this.a.setPerformancePreferences(oiVar.b, oiVar.c, oiVar.d);
                this.a.setTrafficClass(oiVar.e);
                this.a.setTcpNoDelay(oiVar.g);
                this.a.setKeepAlive(oiVar.f);
                this.a.setSendBufferSize(oiVar.h);
                this.a.setReceiveBufferSize(oiVar.i);
                this.a.setSoLinger(oiVar.j, oiVar.k);
                this.a.setSoTimeout(oiVar.l);
            } catch (Exception e) {
                throw new k("Error setting socket hints.", e);
            }
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        Socket socket = this.a;
        if (socket != null) {
            try {
                socket.close();
                this.a = null;
            } catch (Exception e) {
                throw new k("Error closing socket.", e);
            }
        }
    }
}
