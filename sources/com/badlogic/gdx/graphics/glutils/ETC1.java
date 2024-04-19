package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ak;
import defpackage.km;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class ETC1 {
    public static int a = 16;
    public static int b = 36196;

    private static native void decodeImage(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4, int i5);

    static native int getHeightPKM(ByteBuffer byteBuffer, int i);

    static native int getWidthPKM(ByteBuffer byteBuffer, int i);

    static native boolean isValidPKM(ByteBuffer byteBuffer, int i);

    /* loaded from: classes.dex */
    public static final class a implements com.badlogic.gdx.utils.g {
        public final int a;
        public final int b;
        public final ByteBuffer c;
        public final int d;

        public a(int i, int i2, ByteBuffer byteBuffer, int i3) {
            this.a = i;
            this.b = i2;
            this.c = byteBuffer;
            this.d = i3;
            b();
        }

        public a(jy jyVar) {
            DataInputStream dataInputStream;
            byte[] bArr = new byte[10240];
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(jyVar.read())));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.c = BufferUtils.d(dataInputStream.readInt());
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read != -1) {
                        this.c.put(bArr, 0, read);
                    } else {
                        this.c.position(0);
                        this.c.limit(this.c.capacity());
                        ak.a(dataInputStream);
                        this.a = ETC1.getWidthPKM(this.c, 0);
                        this.b = ETC1.getHeightPKM(this.c, 0);
                        this.d = ETC1.a;
                        this.c.position(this.d);
                        b();
                        return;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                throw new com.badlogic.gdx.utils.k("Couldn't load pkm file '" + jyVar + "'", e);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                ak.a(dataInputStream2);
                throw th;
            }
        }

        private void b() {
            if (com.badlogic.gdx.math.h.c(this.a) && com.badlogic.gdx.math.h.c(this.b)) {
                return;
            }
            System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
        }

        public boolean a() {
            return this.d == 16;
        }

        @Override // com.badlogic.gdx.utils.g, defpackage.ik
        public void dispose() {
            BufferUtils.a(this.c);
        }

        public String toString() {
            if (a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(ETC1.isValidPKM(this.c, 0) ? "valid" : "invalid");
                sb.append(" pkm [");
                sb.append(ETC1.getWidthPKM(this.c, 0));
                sb.append("x");
                sb.append(ETC1.getHeightPKM(this.c, 0));
                sb.append("], compressed: ");
                sb.append(this.c.capacity() - ETC1.a);
                return sb.toString();
            }
            return "raw [" + this.a + "x" + this.b + "], compressed: " + (this.c.capacity() - ETC1.a);
        }
    }

    private static int a(km.c cVar) {
        if (cVar == km.c.RGB565) {
            return 2;
        }
        if (cVar == km.c.RGB888) {
            return 3;
        }
        throw new com.badlogic.gdx.utils.k("Can only handle RGB565 or RGB888 images");
    }

    public static km a(a aVar, km.c cVar) {
        int i;
        int i2;
        int i3;
        if (aVar.a()) {
            int widthPKM = getWidthPKM(aVar.c, 0);
            i2 = 16;
            i = getHeightPKM(aVar.c, 0);
            i3 = widthPKM;
        } else {
            int i4 = aVar.a;
            i = aVar.b;
            i2 = 0;
            i3 = i4;
        }
        int a2 = a(cVar);
        km kmVar = new km(i3, i, cVar);
        decodeImage(aVar.c, i2, kmVar.g(), 0, i3, i, a2);
        return kmVar;
    }
}
