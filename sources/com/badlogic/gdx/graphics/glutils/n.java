package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.glutils.ETC1;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ak;
import defpackage.km;
import defpackage.kr;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.zip.GZIPInputStream;
/* compiled from: KTXTextureData.java */
/* loaded from: classes.dex */
public class n implements kd, kr {
    private jy a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j;
    private int k;
    private int l;
    private int m;
    private ByteBuffer n;
    private boolean o;

    @Override // defpackage.kd, defpackage.kr
    public boolean f() {
        return true;
    }

    public n(jy jyVar, boolean z) {
        this.a = jyVar;
        this.o = z;
    }

    @Override // defpackage.kr
    public kr.b g() {
        return kr.b.Custom;
    }

    @Override // defpackage.kd, defpackage.kr
    public boolean a() {
        return this.n != null;
    }

    @Override // defpackage.kd, defpackage.kr
    public void b() {
        DataInputStream dataInputStream;
        if (this.n != null) {
            throw new com.badlogic.gdx.utils.k("Already prepared");
        }
        jy jyVar = this.a;
        if (jyVar == null) {
            throw new com.badlogic.gdx.utils.k("Need a file to load from");
        }
        if (jyVar.name().endsWith(".zktx")) {
            byte[] bArr = new byte[10240];
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(this.a.read())));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                this.n = BufferUtils.d(dataInputStream.readInt());
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    this.n.put(bArr, 0, read);
                }
                this.n.position(0);
                this.n.limit(this.n.capacity());
                ak.a(dataInputStream);
            } catch (Exception e2) {
                e = e2;
                throw new com.badlogic.gdx.utils.k("Couldn't load zktx file '" + this.a + "'", e);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                ak.a(dataInputStream2);
                throw th;
            }
        } else {
            this.n = ByteBuffer.wrap(this.a.readBytes());
        }
        if (this.n.get() != -85) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 75) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 84) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 88) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 32) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 49) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 49) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != -69) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 13) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 10) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 26) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (this.n.get() != 10) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        int i = this.n.getInt();
        if (i != 67305985 && i != 16909060) {
            throw new com.badlogic.gdx.utils.k("Invalid KTX Header");
        }
        if (i != 67305985) {
            ByteBuffer byteBuffer = this.n;
            byteBuffer.order(byteBuffer.order() == ByteOrder.BIG_ENDIAN ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        }
        this.b = this.n.getInt();
        this.c = this.n.getInt();
        this.d = this.n.getInt();
        this.e = this.n.getInt();
        this.f = this.n.getInt();
        this.g = this.n.getInt();
        this.h = this.n.getInt();
        this.i = this.n.getInt();
        this.j = this.n.getInt();
        this.k = this.n.getInt();
        this.l = this.n.getInt();
        if (this.l == 0) {
            this.l = 1;
            this.o = true;
        }
        this.m = this.n.position() + this.n.getInt();
        if (this.n.isDirect()) {
            return;
        }
        int i2 = this.m;
        for (int i3 = 0; i3 < this.l; i3++) {
            i2 += (((this.n.getInt(i2) + 3) & (-4)) * this.k) + 4;
        }
        this.n.limit(i2);
        this.n.position(0);
        ByteBuffer d = BufferUtils.d(i2);
        d.order(this.n.order());
        d.put(this.n);
        this.n = d;
    }

    @Override // defpackage.kd
    public void c() {
        a(34067);
    }

    @Override // defpackage.kr
    public void a(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        if (this.n == null) {
            throw new com.badlogic.gdx.utils.k("Call prepare() before calling consumeCompressedData()");
        }
        IntBuffer c = BufferUtils.c(16);
        int i6 = 1;
        if (this.b != 0 && this.d != 0) {
            z = false;
        } else if (this.b + this.d != 0) {
            throw new com.badlogic.gdx.utils.k("either both or none of glType, glFormat must be zero");
        } else {
            z = true;
        }
        if (this.h > 0) {
            i3 = 3553;
            i2 = 2;
        } else {
            i2 = 1;
            i3 = 4660;
        }
        if (this.i > 0) {
            i3 = 4660;
            i2 = 3;
        }
        int i7 = this.k;
        if (i7 == 6) {
            if (i2 != 2) {
                throw new com.badlogic.gdx.utils.k("cube map needs 2D faces");
            }
            i3 = 34067;
        } else if (i7 != 1) {
            throw new com.badlogic.gdx.utils.k("numberOfFaces must be either 1 or 6");
        }
        if (this.j > 0) {
            if (i3 != 4660 && i3 != 3553) {
                throw new com.badlogic.gdx.utils.k("No API for 3D and cube arrays yet");
            }
            i2++;
            i3 = 4660;
        }
        if (i3 == 4660) {
            throw new com.badlogic.gdx.utils.k("Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
        }
        int i8 = -1;
        int i9 = 34069;
        if (this.k != 6 || i == 34067) {
            if (this.k == 6 && i == 34067) {
                i4 = -1;
            } else if (i != i3 && (34069 > i || i > 34074 || i != 3553)) {
                throw new com.badlogic.gdx.utils.k("Invalid target requested : 0x" + Integer.toHexString(i) + ", expecting : 0x" + Integer.toHexString(i3));
            } else {
                i9 = i;
                i4 = -1;
            }
        } else if (34069 > i || i > 34074) {
            throw new com.badlogic.gdx.utils.k("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
        } else {
            i4 = i - 34069;
        }
        io.g.glGetIntegerv(3317, c);
        int i10 = c.get(0);
        int i11 = 4;
        if (i10 != 4) {
            io.g.glPixelStorei(3317, 4);
        }
        int i12 = this.e;
        int i13 = this.d;
        int i14 = this.m;
        int i15 = 0;
        while (i15 < this.l) {
            int max = Math.max(i6, this.g >> i15);
            int max2 = Math.max(i6, this.h >> i15);
            Math.max(i6, this.i >> i15);
            this.n.position(i14);
            int i16 = this.n.getInt();
            int i17 = (i16 + 3) & (-4);
            i14 += i11;
            int i18 = max2;
            int i19 = 0;
            while (i19 < this.k) {
                this.n.position(i14);
                i14 += i17;
                if (i4 == i8 || i4 == i19) {
                    ByteBuffer slice = this.n.slice();
                    slice.limit(i17);
                    if (i2 == 1) {
                        i5 = i4;
                        z2 = z;
                    } else if (i2 == 2) {
                        int i20 = this.j;
                        if (i20 <= 0) {
                            i20 = i18;
                        }
                        if (z) {
                            i5 = i4;
                            if (i12 == ETC1.b) {
                                z2 = z;
                                if (!io.b.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
                                    km a = ETC1.a(new ETC1.a(max, i20, slice, 0), km.c.RGB888);
                                    io.g.glTexImage2D(i9 + i19, i15, a.e(), a.b(), a.c(), 0, a.d(), a.f(), a.g());
                                    a.dispose();
                                } else {
                                    io.g.glCompressedTexImage2D(i9 + i19, i15, i12, max, i20, 0, i16, slice);
                                }
                            } else {
                                z2 = z;
                                io.g.glCompressedTexImage2D(i9 + i19, i15, i12, max, i20, 0, i16, slice);
                            }
                        } else {
                            i5 = i4;
                            z2 = z;
                            io.g.glTexImage2D(i9 + i19, i15, i12, max, i20, 0, i13, this.b, slice);
                        }
                        i18 = i20;
                    } else {
                        i5 = i4;
                        z2 = z;
                        if (i2 == 3) {
                            int i21 = this.j;
                        }
                    }
                } else {
                    i5 = i4;
                    z2 = z;
                }
                i19++;
                i4 = i5;
                z = z2;
                i8 = -1;
            }
            i15++;
            i4 = i4;
            z = z;
            i6 = 1;
            i11 = 4;
            i8 = -1;
        }
        if (i10 != i11) {
            io.g.glPixelStorei(3317, i10);
        }
        if (k()) {
            io.g.glGenerateMipmap(i9);
        }
        l();
    }

    public void l() {
        ByteBuffer byteBuffer = this.n;
        if (byteBuffer != null) {
            BufferUtils.a(byteBuffer);
        }
        this.n = null;
    }

    @Override // defpackage.kr
    public km h() {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation does not return a Pixmap");
    }

    @Override // defpackage.kr
    public boolean i() {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation does not return a Pixmap");
    }

    @Override // defpackage.kd, defpackage.kr
    public int d() {
        return this.g;
    }

    @Override // defpackage.kd, defpackage.kr
    public int e() {
        return this.h;
    }

    @Override // defpackage.kr
    public km.c j() {
        throw new com.badlogic.gdx.utils.k("This TextureData implementation directly handles texture formats.");
    }

    @Override // defpackage.kr
    public boolean k() {
        return this.o;
    }
}
