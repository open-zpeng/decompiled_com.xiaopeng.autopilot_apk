package com.badlogic.gdx.utils;

import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: StreamUtils.java */
/* loaded from: classes.dex */
public final class ak {
    public static final byte[] a = new byte[0];

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        a(inputStream, outputStream, new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE]);
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static byte[] a(InputStream inputStream, int i) throws IOException {
        a aVar = new a(Math.max(0, i));
        a(inputStream, aVar);
        return aVar.toByteArray();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: StreamUtils.java */
    /* loaded from: classes.dex */
    public static class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized byte[] toByteArray() {
            if (this.count == this.buf.length) {
                return this.buf;
            }
            return super.toByteArray();
        }
    }
}
