package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: CountingOutputStream.java */
/* renamed from: afz  reason: default package */
/* loaded from: classes.dex */
public class afz extends FilterOutputStream {
    private long a;

    public afz(OutputStream outputStream) {
        super(outputStream);
        this.a = 0L;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        a(1L);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        a(i2);
    }

    protected void a(long j) {
        if (j != -1) {
            this.a += j;
        }
    }

    public long a() {
        return this.a;
    }
}
