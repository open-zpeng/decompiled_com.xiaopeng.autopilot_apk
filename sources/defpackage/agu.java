package defpackage;

import com.xiaopeng.libtheme.ThemeManager;
import java.io.DataOutputStream;
import java.io.IOException;
/* renamed from: agu  reason: default package */
/* loaded from: classes.dex */
class agu extends agq {
    static final boolean a;
    static Class b;
    private agq c;
    private final DataOutputStream d;
    private final ahi e;
    private final ahr f;
    private final ahl g;
    private final int h;
    private boolean i;
    private boolean j = true;
    private boolean k = true;
    private int l = 0;
    private boolean m = false;
    private IOException n = null;
    private final byte[] o = new byte[1];

    static {
        Class cls = b;
        if (cls == null) {
            cls = a("agu");
            b = cls;
        }
        a = !cls.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public agu(agq agqVar, agt agtVar) {
        this.i = true;
        if (agqVar == null) {
            throw new NullPointerException();
        }
        this.c = agqVar;
        this.d = new DataOutputStream(agqVar);
        this.f = new ahr(65536);
        int a2 = agtVar.a();
        this.g = ahl.a(this.f, agtVar.c(), agtVar.d(), agtVar.e(), agtVar.f(), a2, a(a2), agtVar.g(), agtVar.h(), agtVar.i());
        this.e = this.g.c();
        byte[] b2 = agtVar.b();
        if (b2 != null && b2.length > 0) {
            this.e.a(a2, b2);
            this.i = false;
        }
        this.h = (((agtVar.e() * 5) + agtVar.d()) * 9) + agtVar.c();
    }

    private static int a(int i) {
        if (65536 > i) {
            return 65536 - i;
        }
        return 0;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void a() throws IOException {
        int c = this.f.c();
        int d = this.g.d();
        if (!a && c <= 0) {
            throw new AssertionError(c);
        }
        if (!a && d <= 0) {
            throw new AssertionError(d);
        }
        if (c + 2 < d) {
            a(d, c);
        } else {
            this.g.a();
            d = this.g.d();
            if (!a && d <= 0) {
                throw new AssertionError(d);
            }
            b(d);
        }
        this.l -= d;
        this.g.e();
        this.f.a();
    }

    private void a(int i, int i2) throws IOException {
        int i3 = i - 1;
        this.d.writeByte((this.k ? this.i ? 224 : ThemeManager.UI_MODE_THEME_MASK : this.j ? 160 : 128) | (i3 >>> 16));
        this.d.writeShort(i3);
        this.d.writeShort(i2 - 1);
        if (this.k) {
            this.d.writeByte(this.h);
        }
        this.f.a(this.c);
        this.k = false;
        this.j = false;
        this.i = false;
    }

    private void b() throws IOException {
        if (!a && this.m) {
            throw new AssertionError();
        }
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        this.e.d();
        while (this.l > 0) {
            try {
                this.g.f();
                a();
            } catch (IOException e) {
                this.n = e;
                throw e;
            }
        }
        this.c.write(0);
        this.m = true;
    }

    private void b(int i) throws IOException {
        while (true) {
            int i2 = 1;
            if (i <= 0) {
                this.j = true;
                return;
            }
            int min = Math.min(i, 65536);
            DataOutputStream dataOutputStream = this.d;
            if (!this.i) {
                i2 = 2;
            }
            dataOutputStream.writeByte(i2);
            this.d.writeShort(min - 1);
            this.e.a(this.c, i, min);
            i -= min;
            this.i = false;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c != null) {
            if (!this.m) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
            try {
                this.c.close();
            } catch (IOException e) {
                if (this.n == null) {
                    this.n = e;
                }
            }
            this.c = null;
        }
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        if (this.m) {
            throw new ahb("Stream finished or closed");
        }
        try {
            this.e.c();
            while (this.l > 0) {
                this.g.f();
                a();
            }
            this.c.flush();
        } catch (IOException e) {
            this.n = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.o;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        if (this.m) {
            throw new ahb("Stream finished or closed");
        }
        while (i2 > 0) {
            try {
                int a2 = this.e.a(bArr, i, i2);
                i += a2;
                i2 -= a2;
                this.l += a2;
                if (this.g.f()) {
                    a();
                }
            } catch (IOException e) {
                this.n = e;
                throw e;
            }
        }
    }
}
