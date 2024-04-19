package defpackage;

import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import java.nio.ByteBuffer;
/* compiled from: Pixmap.java */
/* renamed from: km  reason: default package */
/* loaded from: classes.dex */
public class km implements g {
    final Gdx2DPixmap a;
    private boolean e;
    private a c = a.SourceOver;
    private b d = b.BiLinear;
    int b = 0;

    /* compiled from: Pixmap.java */
    /* renamed from: km$a */
    /* loaded from: classes.dex */
    public enum a {
        None,
        SourceOver
    }

    /* compiled from: Pixmap.java */
    /* renamed from: km$b */
    /* loaded from: classes.dex */
    public enum b {
        NearestNeighbour,
        BiLinear
    }

    /* compiled from: Pixmap.java */
    /* renamed from: km$c */
    /* loaded from: classes.dex */
    public enum c {
        Alpha,
        Intensity,
        LuminanceAlpha,
        RGB565,
        RGBA4444,
        RGB888,
        RGBA8888;

        public static int toGdx2DPixmapFormat(c cVar) {
            if (cVar == Alpha || cVar == Intensity) {
                return 1;
            }
            if (cVar == LuminanceAlpha) {
                return 2;
            }
            if (cVar == RGB565) {
                return 5;
            }
            if (cVar == RGBA4444) {
                return 6;
            }
            if (cVar == RGB888) {
                return 3;
            }
            if (cVar == RGBA8888) {
                return 4;
            }
            throw new k("Unknown Format: " + cVar);
        }

        public static c fromGdx2DPixmapFormat(int i) {
            if (i == 1) {
                return Alpha;
            }
            if (i == 2) {
                return LuminanceAlpha;
            }
            if (i == 5) {
                return RGB565;
            }
            if (i == 6) {
                return RGBA4444;
            }
            if (i == 3) {
                return RGB888;
            }
            if (i == 4) {
                return RGBA8888;
            }
            throw new k("Unknown Gdx2DPixmap Format: " + i);
        }

        public static int toGlFormat(c cVar) {
            return Gdx2DPixmap.toGlFormat(toGdx2DPixmapFormat(cVar));
        }

        public static int toGlType(c cVar) {
            return Gdx2DPixmap.toGlType(toGdx2DPixmapFormat(cVar));
        }
    }

    public void a(a aVar) {
        this.c = aVar;
        this.a.setBlend(aVar == a.None ? 0 : 1);
    }

    public km(int i, int i2, c cVar) {
        this.a = new Gdx2DPixmap(i, i2, c.toGdx2DPixmapFormat(cVar));
        a(0.0f, 0.0f, 0.0f, 0.0f);
        a();
    }

    public km(jy jyVar) {
        try {
            byte[] readBytes = jyVar.readBytes();
            this.a = new Gdx2DPixmap(readBytes, 0, readBytes.length, 0);
        } catch (Exception e) {
            throw new k("Couldn't load file: " + jyVar, e);
        }
    }

    public void a(float f, float f2, float f3, float f4) {
        this.b = ka.c(f, f2, f3, f4);
    }

    public void a(ka kaVar) {
        this.b = ka.c(kaVar.J, kaVar.K, kaVar.L, kaVar.M);
    }

    public void a() {
        this.a.clear(this.b);
    }

    public void a(km kmVar, int i, int i2) {
        a(kmVar, i, i2, 0, 0, kmVar.b(), kmVar.c());
    }

    public void a(km kmVar, int i, int i2, int i3, int i4, int i5, int i6) {
        this.a.drawPixmap(kmVar.a, i3, i4, i, i2, i5, i6);
    }

    public void a(km kmVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a.drawPixmap(kmVar.a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public int a(int i, int i2) {
        return this.a.getPixel(i, i2);
    }

    public int b() {
        return this.a.getWidth();
    }

    public int c() {
        return this.a.getHeight();
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.e) {
            throw new k("Pixmap already disposed!");
        }
        this.a.dispose();
        this.e = true;
    }

    public int d() {
        return this.a.getGLFormat();
    }

    public int e() {
        return this.a.getGLInternalFormat();
    }

    public int f() {
        return this.a.getGLType();
    }

    public ByteBuffer g() {
        if (this.e) {
            throw new k("Pixmap already disposed");
        }
        return this.a.getPixels();
    }

    public c h() {
        return c.fromGdx2DPixmapFormat(this.a.getFormat());
    }
}
