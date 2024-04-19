package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.m;
import java.nio.FloatBuffer;
/* loaded from: classes.dex */
public class SpriteCache implements g {
    private static final float[] tempVertices = new float[30];
    private a<Cache> caches;
    private final ka color;
    private float colorPacked;
    private final Matrix4 combinedMatrix;
    private final m counts;
    private Cache currentCache;
    private q customShader;
    private boolean drawing;
    private final kj mesh;
    private final Matrix4 projectionMatrix;
    public int renderCalls;
    private final q shader;
    private final a<ko> textures;
    public int totalRenderCalls;
    private final Matrix4 transformMatrix;

    public SpriteCache() {
        this(1000, false);
    }

    public SpriteCache(int i, boolean z) {
        this(i, createDefaultShader(), z);
    }

    public SpriteCache(int i, q qVar, boolean z) {
        this.transformMatrix = new Matrix4();
        this.projectionMatrix = new Matrix4();
        this.caches = new a<>();
        this.combinedMatrix = new Matrix4();
        this.textures = new a<>(8);
        this.counts = new m(8);
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.colorPacked = ka.f;
        this.customShader = null;
        int i2 = 0;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.shader = qVar;
        if (z && i > 8191) {
            throw new IllegalArgumentException("Can't have more than 8191 sprites per batch: " + i);
        }
        this.mesh = new kj(true, (z ? 4 : 6) * i, z ? i * 6 : 0, new ks(1, 2, "a_position"), new ks(4, 4, "a_color"), new ks(16, 2, "a_texCoord0"));
        this.mesh.a(false);
        if (z) {
            int i3 = i * 6;
            short[] sArr = new short[i3];
            short s = 0;
            while (i2 < i3) {
                sArr[i2 + 0] = s;
                sArr[i2 + 1] = (short) (s + 1);
                short s2 = (short) (s + 2);
                sArr[i2 + 2] = s2;
                sArr[i2 + 3] = s2;
                sArr[i2 + 4] = (short) (s + 3);
                sArr[i2 + 5] = s;
                i2 += 6;
                s = (short) (s + 4);
            }
            this.mesh.a(sArr);
        }
        this.projectionMatrix.c(0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
    }

    public void setColor(ka kaVar) {
        this.color.a(kaVar);
        this.colorPacked = kaVar.b();
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.color.a(f, f2, f3, f4);
        this.colorPacked = this.color.b();
    }

    public ka getColor() {
        return this.color;
    }

    public void setPackedColor(float f) {
        ka.a(this.color, f);
        this.colorPacked = f;
    }

    public float getPackedColor() {
        return this.colorPacked;
    }

    public void beginCache() {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before beginCache");
        }
        if (this.currentCache != null) {
            throw new IllegalStateException("endCache must be called before begin.");
        }
        this.mesh.a();
        this.currentCache = new Cache(this.caches.b, this.mesh.g().limit());
        this.caches.a((a<Cache>) this.currentCache);
        this.mesh.g().compact();
    }

    public void beginCache(int i) {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before beginCache");
        }
        if (this.currentCache != null) {
            throw new IllegalStateException("endCache must be called before begin.");
        }
        if (i == this.caches.b - 1) {
            this.mesh.g().limit(this.caches.b(i).offset);
            beginCache();
            return;
        }
        this.currentCache = this.caches.a(i);
        this.mesh.g().position(this.currentCache.offset);
    }

    public int endCache() {
        a<Cache> aVar;
        Cache cache = this.currentCache;
        if (cache == null) {
            throw new IllegalStateException("beginCache must be called before endCache.");
        }
        int position = this.mesh.g().position() - cache.offset;
        if (cache.textures == null) {
            cache.maxCount = position;
            cache.textureCount = this.textures.b;
            cache.textures = (ko[]) this.textures.a(ko.class);
            cache.counts = new int[cache.textureCount];
            int i = this.counts.b;
            for (int i2 = 0; i2 < i; i2++) {
                cache.counts[i2] = this.counts.b(i2);
            }
            this.mesh.g().flip();
        } else if (position > cache.maxCount) {
            throw new k("If a cache is not the last created, it cannot be redefined with more entries than when it was first created: " + position + " (" + cache.maxCount + " max)");
        } else {
            cache.textureCount = this.textures.b;
            if (cache.textures.length < cache.textureCount) {
                cache.textures = new ko[cache.textureCount];
            }
            int i3 = cache.textureCount;
            for (int i4 = 0; i4 < i3; i4++) {
                cache.textures[i4] = this.textures.a(i4);
            }
            if (cache.counts.length < cache.textureCount) {
                cache.counts = new int[cache.textureCount];
            }
            int i5 = cache.textureCount;
            for (int i6 = 0; i6 < i5; i6++) {
                cache.counts[i6] = this.counts.b(i6);
            }
            FloatBuffer g = this.mesh.g();
            g.position(0);
            Cache a = this.caches.a(aVar.b - 1);
            g.limit(a.offset + a.maxCount);
        }
        this.currentCache = null;
        this.textures.d();
        this.counts.b();
        return cache.id;
    }

    public void clear() {
        this.caches.d();
        this.mesh.g().clear().flip();
    }

    public void add(ko koVar, float[] fArr, int i, int i2) {
        if (this.currentCache == null) {
            throw new IllegalStateException("beginCache must be called before add.");
        }
        int i3 = (i2 / ((this.mesh.a() > 0 ? 4 : 6) * 5)) * 6;
        int i4 = this.textures.b - 1;
        if (i4 < 0 || this.textures.a(i4) != koVar) {
            this.textures.a((a<ko>) koVar);
            this.counts.a(i3);
        } else {
            this.counts.a(i4, i3);
        }
        this.mesh.g().put(fArr, i, i2);
    }

    public void add(ko koVar, float f, float f2) {
        float width = koVar.getWidth() + f;
        float height = koVar.getHeight() + f2;
        float[] fArr = tempVertices;
        fArr[0] = f;
        fArr[1] = f2;
        float f3 = this.colorPacked;
        fArr[2] = f3;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = f;
        fArr[6] = height;
        fArr[7] = f3;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = width;
        fArr[11] = height;
        fArr[12] = f3;
        fArr[13] = 1.0f;
        fArr[14] = 0.0f;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = width;
            fArr2[16] = f2;
            fArr2[17] = this.colorPacked;
            fArr2[18] = 1.0f;
            fArr2[19] = 1.0f;
            add(koVar, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = width;
        fArr3[16] = height;
        float f4 = this.colorPacked;
        fArr3[17] = f4;
        fArr3[18] = 1.0f;
        fArr3[19] = 0.0f;
        fArr3[20] = width;
        fArr3[21] = f2;
        fArr3[22] = f4;
        fArr3[23] = 1.0f;
        fArr3[24] = 1.0f;
        fArr3[25] = f;
        fArr3[26] = f2;
        fArr3[27] = f4;
        fArr3[28] = 0.0f;
        fArr3[29] = 1.0f;
        add(koVar, fArr3, 0, 30);
    }

    public void add(ko koVar, float f, float f2, int i, int i2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = i + f;
        float f9 = i2 + f2;
        float[] fArr = tempVertices;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f7;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f;
        fArr[6] = f9;
        fArr[7] = f7;
        fArr[8] = f3;
        fArr[9] = f6;
        fArr[10] = f8;
        fArr[11] = f9;
        fArr[12] = f7;
        fArr[13] = f5;
        fArr[14] = f6;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f8;
            fArr2[16] = f2;
            fArr2[17] = f7;
            fArr2[18] = f5;
            fArr2[19] = f4;
            add(koVar, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f8;
        fArr3[16] = f9;
        fArr3[17] = f7;
        fArr3[18] = f5;
        fArr3[19] = f6;
        fArr3[20] = f8;
        fArr3[21] = f2;
        fArr3[22] = f7;
        fArr3[23] = f5;
        fArr3[24] = f4;
        fArr3[25] = f;
        fArr3[26] = f2;
        fArr3[27] = f7;
        fArr3[28] = f3;
        fArr3[29] = f4;
        add(koVar, fArr3, 0, 30);
    }

    public void add(ko koVar, float f, float f2, int i, int i2, int i3, int i4) {
        float width = 1.0f / koVar.getWidth();
        float height = 1.0f / koVar.getHeight();
        float f3 = i * width;
        float f4 = (i2 + i4) * height;
        float f5 = (i + i3) * width;
        float f6 = i2 * height;
        float f7 = f + i3;
        float f8 = f2 + i4;
        float[] fArr = tempVertices;
        fArr[0] = f;
        fArr[1] = f2;
        float f9 = this.colorPacked;
        fArr[2] = f9;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f;
        fArr[6] = f8;
        fArr[7] = f9;
        fArr[8] = f3;
        fArr[9] = f6;
        fArr[10] = f7;
        fArr[11] = f8;
        fArr[12] = f9;
        fArr[13] = f5;
        fArr[14] = f6;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f7;
            fArr2[16] = f2;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f5;
            fArr2[19] = f4;
            add(koVar, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f7;
        fArr3[16] = f8;
        float f10 = this.colorPacked;
        fArr3[17] = f10;
        fArr3[18] = f5;
        fArr3[19] = f6;
        fArr3[20] = f7;
        fArr3[21] = f2;
        fArr3[22] = f10;
        fArr3[23] = f5;
        fArr3[24] = f4;
        fArr3[25] = f;
        fArr3[26] = f2;
        fArr3[27] = f10;
        fArr3[28] = f3;
        fArr3[29] = f4;
        add(koVar, fArr3, 0, 30);
    }

    public void add(ko koVar, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float width = 1.0f / koVar.getWidth();
        float height = 1.0f / koVar.getHeight();
        float f5 = i * width;
        float f6 = (i2 + i4) * height;
        float f7 = (i + i3) * width;
        float f8 = i2 * height;
        float f9 = f + f3;
        float f10 = f2 + f4;
        if (z) {
            f5 = f7;
            f7 = f5;
        }
        if (z2) {
            f6 = f8;
            f8 = f6;
        }
        float[] fArr = tempVertices;
        fArr[0] = f;
        fArr[1] = f2;
        float f11 = this.colorPacked;
        fArr[2] = f11;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f;
        fArr[6] = f10;
        fArr[7] = f11;
        fArr[8] = f5;
        fArr[9] = f8;
        fArr[10] = f9;
        fArr[11] = f10;
        fArr[12] = f11;
        fArr[13] = f7;
        fArr[14] = f8;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f9;
            fArr2[16] = f2;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f7;
            fArr2[19] = f6;
            add(koVar, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f9;
        fArr3[16] = f10;
        float f12 = this.colorPacked;
        fArr3[17] = f12;
        fArr3[18] = f7;
        fArr3[19] = f8;
        fArr3[20] = f9;
        fArr3[21] = f2;
        fArr3[22] = f12;
        fArr3[23] = f7;
        fArr3[24] = f6;
        fArr3[25] = f;
        fArr3[26] = f2;
        fArr3[27] = f12;
        fArr3[28] = f5;
        fArr3[29] = f6;
        add(koVar, fArr3, 0, 30);
    }

    public void add(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14 = f + f3;
        float f15 = f2 + f4;
        float f16 = -f3;
        float f17 = -f4;
        float f18 = f5 - f3;
        float f19 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f16 *= f7;
            f17 *= f8;
            f18 *= f7;
            f19 *= f8;
        }
        if (f9 != 0.0f) {
            float d = h.d(f9);
            float c = h.c(f9);
            float f20 = d * f16;
            float f21 = f20 - (c * f17);
            float f22 = f16 * c;
            f17 = (f17 * d) + f22;
            float f23 = c * f19;
            f12 = f20 - f23;
            float f24 = f19 * d;
            float f25 = f22 + f24;
            float f26 = (d * f18) - f23;
            float f27 = f24 + (c * f18);
            float f28 = f27 - (f25 - f17);
            f10 = (f26 - f12) + f21;
            f18 = f26;
            f11 = f27;
            f19 = f25;
            f16 = f21;
            f13 = f28;
        } else {
            f10 = f18;
            f11 = f19;
            f12 = f16;
            f13 = f17;
        }
        float f29 = f16 + f14;
        float f30 = f17 + f15;
        float f31 = f12 + f14;
        float f32 = f19 + f15;
        float f33 = f18 + f14;
        float f34 = f11 + f15;
        float f35 = f10 + f14;
        float f36 = f13 + f15;
        float width = 1.0f / koVar.getWidth();
        float height = 1.0f / koVar.getHeight();
        float f37 = i * width;
        float f38 = (i2 + i4) * height;
        float f39 = (i + i3) * width;
        float f40 = i2 * height;
        if (!z) {
            f37 = f39;
            f39 = f37;
        }
        if (z2) {
            f38 = f40;
            f40 = f38;
        }
        float[] fArr = tempVertices;
        fArr[0] = f29;
        fArr[1] = f30;
        float f41 = this.colorPacked;
        fArr[2] = f41;
        fArr[3] = f39;
        fArr[4] = f38;
        fArr[5] = f31;
        fArr[6] = f32;
        fArr[7] = f41;
        fArr[8] = f39;
        fArr[9] = f40;
        fArr[10] = f33;
        fArr[11] = f34;
        fArr[12] = f41;
        fArr[13] = f37;
        fArr[14] = f40;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f35;
            fArr2[16] = f36;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f37;
            fArr2[19] = f38;
            add(koVar, fArr2, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f33;
        fArr3[16] = f34;
        float f42 = this.colorPacked;
        fArr3[17] = f42;
        fArr3[18] = f37;
        fArr3[19] = f40;
        fArr3[20] = f35;
        fArr3[21] = f36;
        fArr3[22] = f42;
        fArr3[23] = f37;
        fArr3[24] = f38;
        fArr3[25] = f29;
        fArr3[26] = f30;
        fArr3[27] = f42;
        fArr3[28] = f39;
        fArr3[29] = f38;
        add(koVar, fArr3, 0, 30);
    }

    public void add(TextureRegion textureRegion, float f, float f2) {
        add(textureRegion, f, f2, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public void add(TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        float f5 = f + f3;
        float f6 = f2 + f4;
        float f7 = textureRegion.u;
        float f8 = textureRegion.v2;
        float f9 = textureRegion.u2;
        float f10 = textureRegion.v;
        float[] fArr = tempVertices;
        fArr[0] = f;
        fArr[1] = f2;
        float f11 = this.colorPacked;
        fArr[2] = f11;
        fArr[3] = f7;
        fArr[4] = f8;
        fArr[5] = f;
        fArr[6] = f6;
        fArr[7] = f11;
        fArr[8] = f7;
        fArr[9] = f10;
        fArr[10] = f5;
        fArr[11] = f6;
        fArr[12] = f11;
        fArr[13] = f9;
        fArr[14] = f10;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f5;
            fArr2[16] = f2;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f9;
            fArr2[19] = f8;
            add(textureRegion.texture, tempVertices, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f5;
        fArr3[16] = f6;
        float f12 = this.colorPacked;
        fArr3[17] = f12;
        fArr3[18] = f9;
        fArr3[19] = f10;
        fArr3[20] = f5;
        fArr3[21] = f2;
        fArr3[22] = f12;
        fArr3[23] = f9;
        fArr3[24] = f8;
        fArr3[25] = f;
        fArr3[26] = f2;
        fArr3[27] = f12;
        fArr3[28] = f7;
        fArr3[29] = f8;
        add(textureRegion.texture, tempVertices, 0, 30);
    }

    public void add(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15 = f + f3;
        float f16 = f2 + f4;
        float f17 = -f3;
        float f18 = -f4;
        float f19 = f5 - f3;
        float f20 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f17 *= f7;
            f18 *= f8;
            f19 *= f7;
            f20 *= f8;
        }
        if (f9 != 0.0f) {
            float d = h.d(f9);
            float c = h.c(f9);
            float f21 = d * f17;
            float f22 = f21 - (c * f18);
            float f23 = f17 * c;
            f18 = (f18 * d) + f23;
            float f24 = c * f20;
            f13 = f21 - f24;
            float f25 = f20 * d;
            float f26 = f23 + f25;
            f10 = (d * f19) - f24;
            float f27 = f25 + (c * f19);
            float f28 = f27 - (f26 - f18);
            f11 = (f10 - f13) + f22;
            f12 = f27;
            f20 = f26;
            f17 = f22;
            f14 = f28;
        } else {
            f10 = f19;
            f11 = f10;
            f12 = f20;
            f13 = f17;
            f14 = f18;
        }
        float f29 = f17 + f15;
        float f30 = f18 + f16;
        float f31 = f13 + f15;
        float f32 = f20 + f16;
        float f33 = f10 + f15;
        float f34 = f12 + f16;
        float f35 = f11 + f15;
        float f36 = f14 + f16;
        float f37 = textureRegion.u;
        float f38 = textureRegion.v2;
        float f39 = textureRegion.u2;
        float f40 = textureRegion.v;
        float[] fArr = tempVertices;
        fArr[0] = f29;
        fArr[1] = f30;
        float f41 = this.colorPacked;
        fArr[2] = f41;
        fArr[3] = f37;
        fArr[4] = f38;
        fArr[5] = f31;
        fArr[6] = f32;
        fArr[7] = f41;
        fArr[8] = f37;
        fArr[9] = f40;
        fArr[10] = f33;
        fArr[11] = f34;
        fArr[12] = f41;
        fArr[13] = f39;
        fArr[14] = f40;
        if (this.mesh.a() > 0) {
            float[] fArr2 = tempVertices;
            fArr2[15] = f35;
            fArr2[16] = f36;
            fArr2[17] = this.colorPacked;
            fArr2[18] = f39;
            fArr2[19] = f38;
            add(textureRegion.texture, tempVertices, 0, 20);
            return;
        }
        float[] fArr3 = tempVertices;
        fArr3[15] = f33;
        fArr3[16] = f34;
        float f42 = this.colorPacked;
        fArr3[17] = f42;
        fArr3[18] = f39;
        fArr3[19] = f40;
        fArr3[20] = f35;
        fArr3[21] = f36;
        fArr3[22] = f42;
        fArr3[23] = f39;
        fArr3[24] = f38;
        fArr3[25] = f29;
        fArr3[26] = f30;
        fArr3[27] = f42;
        fArr3[28] = f37;
        fArr3[29] = f38;
        add(textureRegion.texture, tempVertices, 0, 30);
    }

    public void add(Sprite sprite) {
        if (this.mesh.a() > 0) {
            add(sprite.getTexture(), sprite.getVertices(), 0, 20);
            return;
        }
        float[] vertices = sprite.getVertices();
        System.arraycopy(vertices, 0, tempVertices, 0, 15);
        System.arraycopy(vertices, 10, tempVertices, 15, 5);
        System.arraycopy(vertices, 15, tempVertices, 20, 5);
        System.arraycopy(vertices, 0, tempVertices, 25, 5);
        add(sprite.getTexture(), tempVertices, 0, 30);
    }

    public void begin() {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before begin.");
        }
        if (this.currentCache != null) {
            throw new IllegalStateException("endCache must be called before begin");
        }
        this.renderCalls = 0;
        this.combinedMatrix.a(this.projectionMatrix).b(this.transformMatrix);
        io.h.glDepthMask(false);
        q qVar = this.customShader;
        if (qVar != null) {
            qVar.d();
            this.customShader.a("u_proj", this.projectionMatrix);
            this.customShader.a("u_trans", this.transformMatrix);
            this.customShader.a("u_projTrans", this.combinedMatrix);
            this.customShader.a("u_texture", 0);
            this.mesh.a(this.customShader);
        } else {
            this.shader.d();
            this.shader.a("u_projectionViewMatrix", this.combinedMatrix);
            this.shader.a("u_texture", 0);
            this.mesh.a(this.shader);
        }
        this.drawing = true;
    }

    public void end() {
        if (!this.drawing) {
            throw new IllegalStateException("begin must be called before end.");
        }
        this.drawing = false;
        this.shader.e();
        io.h.glDepthMask(true);
        q qVar = this.customShader;
        if (qVar != null) {
            this.mesh.b(qVar);
        } else {
            this.mesh.b(this.shader);
        }
    }

    public void draw(int i) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteCache.begin must be called before draw.");
        }
        Cache a = this.caches.a(i);
        int i2 = (a.offset / ((this.mesh.a() > 0 ? 4 : 6) * 5)) * 6;
        ko[] koVarArr = a.textures;
        int[] iArr = a.counts;
        int i3 = a.textureCount;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            koVarArr[i4].bind();
            q qVar = this.customShader;
            if (qVar != null) {
                this.mesh.a(qVar, 4, i2, i5);
            } else {
                this.mesh.a(this.shader, 4, i2, i5);
            }
            i2 += i5;
        }
        this.renderCalls += i3;
        this.totalRenderCalls += i3;
    }

    public void draw(int i, int i2, int i3) {
        int i4;
        if (!this.drawing) {
            throw new IllegalStateException("SpriteCache.begin must be called before draw.");
        }
        Cache a = this.caches.a(i);
        int i5 = (i2 * 6) + a.offset;
        int i6 = i3 * 6;
        ko[] koVarArr = a.textures;
        int[] iArr = a.counts;
        int i7 = a.textureCount;
        int i8 = 0;
        while (i8 < i7) {
            koVarArr[i8].bind();
            int i9 = iArr[i8];
            if (i9 > i6) {
                i4 = i6;
                i8 = i7;
            } else {
                i4 = i6 - i9;
                i6 = i9;
            }
            q qVar = this.customShader;
            if (qVar != null) {
                this.mesh.a(qVar, 4, i5, i6);
            } else {
                this.mesh.a(this.shader, 4, i5, i6);
            }
            i5 += i6;
            i8++;
            i6 = i4;
        }
        this.renderCalls += a.textureCount;
        this.totalRenderCalls += i7;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.mesh.dispose();
        q qVar = this.shader;
        if (qVar != null) {
            qVar.dispose();
        }
    }

    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public void setProjectionMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            throw new IllegalStateException("Can't set the matrix within begin/end.");
        }
        this.projectionMatrix.a(matrix4);
    }

    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            throw new IllegalStateException("Can't set the matrix within begin/end.");
        }
        this.transformMatrix.a(matrix4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Cache {
        int[] counts;
        final int id;
        int maxCount;
        final int offset;
        int textureCount;
        ko[] textures;

        public Cache(int i, int i2) {
            this.id = i;
            this.offset = i2;
        }
    }

    static q createDefaultShader() {
        q qVar = new q("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n", "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        if (qVar.c()) {
            return qVar;
        }
        throw new IllegalArgumentException("Error compiling shader: " + qVar.b());
    }

    public void setShader(q qVar) {
        this.customShader = qVar;
    }
}
