package defpackage;

import com.badlogic.gdx.utils.ak;
import com.badlogic.gdx.utils.d;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import defpackage.km;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
/* compiled from: PixmapIO.java */
/* renamed from: kn  reason: default package */
/* loaded from: classes.dex */
public class kn {
    public static void a(jy jyVar, km kmVar) {
        a.a(jyVar, kmVar);
    }

    public static km a(jy jyVar) {
        return a.a(jyVar);
    }

    public static void b(jy jyVar, km kmVar) {
        try {
            b bVar = new b((int) (kmVar.b() * kmVar.c() * 1.5f));
            bVar.a(false);
            bVar.a(jyVar, kmVar);
            bVar.dispose();
        } catch (IOException e) {
            throw new k("Error writing PNG: " + jyVar, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PixmapIO.java */
    /* renamed from: kn$a */
    /* loaded from: classes.dex */
    public static class a {
        private static final byte[] a = new byte[32000];
        private static final byte[] b = new byte[32000];

        public static void a(jy jyVar, km kmVar) {
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    dataOutputStream = new DataOutputStream(new DeflaterOutputStream(jyVar.write(false)));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
            }
            try {
                dataOutputStream.writeInt(kmVar.b());
                dataOutputStream.writeInt(kmVar.c());
                dataOutputStream.writeInt(km.c.toGdx2DPixmapFormat(kmVar.h()));
                ByteBuffer g = kmVar.g();
                g.position(0);
                g.limit(g.capacity());
                int capacity = g.capacity() % 32000;
                int capacity2 = g.capacity() / 32000;
                synchronized (a) {
                    for (int i = 0; i < capacity2; i++) {
                        g.get(a);
                        dataOutputStream.write(a);
                    }
                    g.get(a, 0, capacity);
                    dataOutputStream.write(a, 0, capacity);
                }
                g.position(0);
                g.limit(g.capacity());
                ak.a(dataOutputStream);
            } catch (Exception e2) {
                e = e2;
                dataOutputStream2 = dataOutputStream;
                throw new k("Couldn't write Pixmap to file '" + jyVar + "'", e);
            } catch (Throwable th2) {
                th = th2;
                ak.a(dataOutputStream);
                throw th;
            }
        }

        public static km a(jy jyVar) {
            Exception e;
            try {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new InflaterInputStream(new BufferedInputStream(jyVar.read())));
                    try {
                        km kmVar = new km(dataInputStream.readInt(), dataInputStream.readInt(), km.c.fromGdx2DPixmapFormat(dataInputStream.readInt()));
                        ByteBuffer g = kmVar.g();
                        g.position(0);
                        g.limit(g.capacity());
                        synchronized (b) {
                            while (true) {
                                int read = dataInputStream.read(b);
                                if (read > 0) {
                                    g.put(b, 0, read);
                                }
                            }
                        }
                        g.position(0);
                        g.limit(g.capacity());
                        ak.a(dataInputStream);
                        return kmVar;
                    } catch (Exception e2) {
                        e = e2;
                        throw new k("Couldn't read Pixmap from file '" + jyVar + "'", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    ak.a(null);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                ak.a(null);
                throw th;
            }
        }
    }

    /* compiled from: PixmapIO.java */
    /* renamed from: kn$b */
    /* loaded from: classes.dex */
    public static class b implements g {
        private static final byte[] a = {-119, 80, 78, 71, 13, 10, 26, 10};
        private final a b;
        private final Deflater c;
        private d d;
        private d e;
        private d f;
        private boolean g;
        private int h;

        public b() {
            this(16384);
        }

        public b(int i) {
            this.g = true;
            this.b = new a(i);
            this.c = new Deflater();
        }

        public void a(boolean z) {
            this.g = z;
        }

        public void a(jy jyVar, km kmVar) throws IOException {
            OutputStream write = jyVar.write(false);
            try {
                a(write, kmVar);
            } finally {
                ak.a(write);
            }
        }

        public void a(OutputStream outputStream, km kmVar) throws IOException {
            byte[] a2;
            byte[] a3;
            byte[] a4;
            boolean z;
            int i;
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(this.b, this.c);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(a);
            this.b.writeInt(1229472850);
            this.b.writeInt(kmVar.b());
            this.b.writeInt(kmVar.c());
            this.b.writeByte(8);
            this.b.writeByte(6);
            int i2 = 0;
            this.b.writeByte(0);
            this.b.writeByte(0);
            this.b.writeByte(0);
            this.b.a(dataOutputStream);
            this.b.writeInt(1229209940);
            this.c.reset();
            int b = kmVar.b() * 4;
            d dVar = this.d;
            if (dVar == null) {
                d dVar2 = new d(b);
                this.d = dVar2;
                a2 = dVar2.a;
                d dVar3 = new d(b);
                this.e = dVar3;
                a3 = dVar3.a;
                d dVar4 = new d(b);
                this.f = dVar4;
                a4 = dVar4.a;
            } else {
                a2 = dVar.a(b);
                a3 = this.e.a(b);
                a4 = this.f.a(b);
                int i3 = this.h;
                for (int i4 = 0; i4 < i3; i4++) {
                    a4[i4] = 0;
                }
            }
            this.h = b;
            ByteBuffer g = kmVar.g();
            int position = g.position();
            int i5 = 1;
            boolean z2 = kmVar.h() == km.c.RGBA8888;
            int c = kmVar.c();
            byte[] bArr = a4;
            byte[] bArr2 = a3;
            int i6 = 0;
            while (i6 < c) {
                int i7 = this.g ? (c - i6) - i5 : i6;
                if (z2) {
                    g.position(i7 * b);
                    g.get(bArr2, i2, b);
                    i = i2;
                    z = z2;
                } else {
                    int i8 = i2;
                    int i9 = i8;
                    while (i8 < kmVar.b()) {
                        int a5 = kmVar.a(i8, i7);
                        int i10 = i9 + 1;
                        bArr2[i9] = (byte) ((a5 >> 24) & 255);
                        int i11 = i10 + 1;
                        int i12 = i7;
                        bArr2[i10] = (byte) ((a5 >> 16) & 255);
                        int i13 = i11 + 1;
                        bArr2[i11] = (byte) ((a5 >> 8) & 255);
                        int i14 = i13 + 1;
                        bArr2[i13] = (byte) (a5 & 255);
                        i8++;
                        i7 = i12;
                        z2 = z2;
                        i9 = i14;
                    }
                    z = z2;
                    i = 0;
                }
                a2[i] = (byte) (bArr2[i] - bArr[i]);
                a2[1] = (byte) (bArr2[1] - bArr[1]);
                a2[2] = (byte) (bArr2[2] - bArr[2]);
                a2[3] = (byte) (bArr2[3] - bArr[3]);
                int i15 = 4;
                while (i15 < b) {
                    int i16 = i15 - 4;
                    int i17 = bArr2[i16] & 255;
                    int i18 = bArr[i15] & 255;
                    int i19 = bArr[i16] & 255;
                    int i20 = (i17 + i18) - i19;
                    int i21 = i20 - i17;
                    if (i21 < 0) {
                        i21 = -i21;
                    }
                    int i22 = i20 - i18;
                    if (i22 < 0) {
                        i22 = -i22;
                    }
                    int i23 = c;
                    int i24 = i20 - i19;
                    if (i24 < 0) {
                        i24 = -i24;
                    }
                    if (i21 <= i22 && i21 <= i24) {
                        i18 = i17;
                    } else if (i22 > i24) {
                        i18 = i19;
                    }
                    a2[i15] = (byte) (bArr2[i15] - i18);
                    i15++;
                    c = i23;
                }
                deflaterOutputStream.write(4);
                i2 = 0;
                deflaterOutputStream.write(a2, 0, b);
                i6++;
                z2 = z;
                i5 = 1;
                byte[] bArr3 = bArr;
                bArr = bArr2;
                bArr2 = bArr3;
            }
            g.position(position);
            deflaterOutputStream.finish();
            this.b.a(dataOutputStream);
            this.b.writeInt(1229278788);
            this.b.a(dataOutputStream);
            outputStream.flush();
        }

        @Override // com.badlogic.gdx.utils.g, defpackage.ik
        public void dispose() {
            this.c.end();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PixmapIO.java */
        /* renamed from: kn$b$a */
        /* loaded from: classes.dex */
        public static class a extends DataOutputStream {
            final ByteArrayOutputStream a;
            final CRC32 b;

            a(int i) {
                this(new ByteArrayOutputStream(i), new CRC32());
            }

            private a(ByteArrayOutputStream byteArrayOutputStream, CRC32 crc32) {
                super(new CheckedOutputStream(byteArrayOutputStream, crc32));
                this.a = byteArrayOutputStream;
                this.b = crc32;
            }

            public void a(DataOutputStream dataOutputStream) throws IOException {
                flush();
                dataOutputStream.writeInt(this.a.size() - 4);
                this.a.writeTo(dataOutputStream);
                dataOutputStream.writeInt((int) this.b.getValue());
                this.a.reset();
                this.b.reset();
            }
        }
    }
}
