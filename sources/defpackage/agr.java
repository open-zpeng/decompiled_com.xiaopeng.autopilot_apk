package defpackage;

import java.io.IOException;
import java.io.OutputStream;
/* renamed from: agr  reason: default package */
/* loaded from: classes.dex */
public class agr extends agq {
    protected OutputStream a;

    public agr(OutputStream outputStream) {
        this.a = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }
}
