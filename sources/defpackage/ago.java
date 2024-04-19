package defpackage;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
/* renamed from: ago  reason: default package */
/* loaded from: classes.dex */
class ago extends agq {
    private agq a;
    private final ahd b;
    private final byte[] c = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
    private boolean d = false;
    private IOException e = null;
    private final byte[] f = new byte[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    public ago(agq agqVar, agn agnVar) {
        this.a = agqVar;
        this.b = new ahd(agnVar.a());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        agq agqVar = this.a;
        if (agqVar != null) {
            try {
                agqVar.close();
            } catch (IOException e) {
                if (this.e == null) {
                    this.e = e;
                }
            }
            this.a = null;
        }
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
        if (this.d) {
            throw new ahb("Stream finished or closed");
        }
        try {
            this.a.flush();
        } catch (IOException e) {
            this.e = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
        if (this.d) {
            throw new ahb("Stream finished");
        }
        while (i2 > 4096) {
            try {
                this.b.a(bArr, i, CodedOutputStream.DEFAULT_BUFFER_SIZE, this.c);
                this.a.write(this.c);
                i += CodedOutputStream.DEFAULT_BUFFER_SIZE;
                i2 -= 4096;
            } catch (IOException e) {
                this.e = e;
                throw e;
            }
        }
        this.b.a(bArr, i, i2, this.c);
        this.a.write(this.c, 0, i2);
    }
}
