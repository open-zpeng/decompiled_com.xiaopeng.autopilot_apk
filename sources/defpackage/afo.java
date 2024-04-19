package defpackage;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: LZMA2Decoder.java */
/* renamed from: afo  reason: default package */
/* loaded from: classes.dex */
class afo extends afk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public afo() {
        super(agt.class, Number.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.afk
    public OutputStream a(OutputStream outputStream, Object obj) throws IOException {
        return d(obj).a(new agr(outputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.afk
    public byte[] b(Object obj) {
        int c = c(obj);
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(c);
        return new byte[]{(byte) (((19 - numberOfLeadingZeros) * 2) + ((c >>> (30 - numberOfLeadingZeros)) - 2))};
    }

    private int c(Object obj) {
        if (obj instanceof agt) {
            return ((agt) obj).a();
        }
        return e(obj);
    }

    private agt d(Object obj) throws IOException {
        if (obj instanceof agt) {
            return (agt) obj;
        }
        agt agtVar = new agt();
        agtVar.b(e(obj));
        return agtVar;
    }

    private int e(Object obj) {
        return a(obj, 8388608);
    }
}
