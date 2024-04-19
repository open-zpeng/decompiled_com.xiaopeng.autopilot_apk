package defpackage;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
/* renamed from: agx  reason: default package */
/* loaded from: classes.dex */
class agx extends agq {
    static final boolean a;
    static Class b;
    private agq c;
    private final ahx d;
    private final byte[] e = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
    private int f = 0;
    private int g = 0;
    private IOException h = null;
    private boolean i = false;
    private final byte[] j = new byte[1];

    static {
        Class cls = b;
        if (cls == null) {
            cls = a("agx");
            b = cls;
        }
        a = !cls.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public agx(agq agqVar, ahx ahxVar) {
        if (agqVar == null) {
            throw new NullPointerException();
        }
        this.c = agqVar;
        this.d = ahxVar;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void a() throws IOException {
        if (!a && this.i) {
            throw new AssertionError();
        }
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        try {
            this.c.write(this.e, this.f, this.g);
            this.i = true;
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c != null) {
            if (!this.i) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
            try {
                this.c.close();
            } catch (IOException e) {
                if (this.h == null) {
                    this.h = e;
                }
            }
            this.c = null;
        }
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw new agz("Flushing is not supported");
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.j;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        if (this.i) {
            throw new ahb("Stream finished or closed");
        }
        while (i2 > 0) {
            int min = Math.min(i2, 4096 - (this.f + this.g));
            System.arraycopy(bArr, i, this.e, this.f + this.g, min);
            i += min;
            i2 -= min;
            this.g += min;
            int a2 = this.d.a(this.e, this.f, this.g);
            if (!a && a2 > this.g) {
                throw new AssertionError();
            }
            this.g -= a2;
            try {
                this.c.write(this.e, this.f, a2);
                this.f += a2;
                int i4 = this.f;
                int i5 = this.g;
                if (i4 + i5 == 4096) {
                    byte[] bArr2 = this.e;
                    System.arraycopy(bArr2, i4, bArr2, 0, i5);
                    this.f = 0;
                }
            } catch (IOException e) {
                this.h = e;
                throw e;
            }
        }
    }
}
