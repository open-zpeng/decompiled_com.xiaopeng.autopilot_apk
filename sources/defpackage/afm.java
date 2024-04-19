package defpackage;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: DeltaDecoder.java */
/* renamed from: afm  reason: default package */
/* loaded from: classes.dex */
class afm extends afk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public afm() {
        super(Number.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.afk
    public OutputStream a(OutputStream outputStream, Object obj) throws IOException {
        try {
            return new agn(a(obj, 1)).a(new agr(outputStream));
        } catch (agz e) {
            throw new IOException(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.afk
    public byte[] b(Object obj) {
        return new byte[]{(byte) (a(obj, 1) - 1)};
    }
}
