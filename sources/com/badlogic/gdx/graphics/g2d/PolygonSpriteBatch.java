package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.a;
import com.badlogic.gdx.math.h;
import defpackage.kj;
/* loaded from: classes.dex */
public class PolygonSpriteBatch implements PolygonBatch {
    private int blendDstFunc;
    private int blendDstFuncAlpha;
    private int blendSrcFunc;
    private int blendSrcFuncAlpha;
    private boolean blendingDisabled;
    private final ka color;
    float colorPacked;
    private final Matrix4 combinedMatrix;
    private q customShader;
    private boolean drawing;
    private float invTexHeight;
    private float invTexWidth;
    private ko lastTexture;
    public int maxTrianglesInBatch;
    private kj mesh;
    private boolean ownsShader;
    private final Matrix4 projectionMatrix;
    public int renderCalls;
    private final q shader;
    public int totalRenderCalls;
    private final Matrix4 transformMatrix;
    private int triangleIndex;
    private final short[] triangles;
    private int vertexIndex;
    private final float[] vertices;

    public PolygonSpriteBatch() {
        this(2000, null);
    }

    public PolygonSpriteBatch(int i) {
        this(i, i * 2, null);
    }

    public PolygonSpriteBatch(int i, q qVar) {
        this(i, i * 2, qVar);
    }

    public PolygonSpriteBatch(int i, int i2, q qVar) {
        this.invTexWidth = 0.0f;
        this.invTexHeight = 0.0f;
        this.transformMatrix = new Matrix4();
        this.projectionMatrix = new Matrix4();
        this.combinedMatrix = new Matrix4();
        this.blendSrcFunc = 770;
        this.blendDstFunc = 771;
        this.blendSrcFuncAlpha = 770;
        this.blendDstFuncAlpha = 771;
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.colorPacked = ka.f;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.maxTrianglesInBatch = 0;
        if (i > 32767) {
            throw new IllegalArgumentException("Can't have more than 32767 vertices per batch: " + i);
        }
        int i3 = i2 * 3;
        this.mesh = new kj(io.i != null ? kj.a.VertexBufferObjectWithVAO : kj.a.VertexArray, false, i, i3, new ks(1, 2, "a_position"), new ks(4, 4, "a_color"), new ks(16, 2, "a_texCoord0"));
        this.vertices = new float[i * 5];
        this.triangles = new short[i3];
        if (qVar == null) {
            this.shader = SpriteBatch.createDefaultShader();
            this.ownsShader = true;
        } else {
            this.shader = qVar;
        }
        this.projectionMatrix.c(0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void begin() {
        if (this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.end must be called before begin.");
        }
        this.renderCalls = 0;
        io.g.glDepthMask(false);
        q qVar = this.customShader;
        if (qVar != null) {
            qVar.d();
        } else {
            this.shader.d();
        }
        setupMatrices();
        this.drawing = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void end() {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before end.");
        }
        if (this.vertexIndex > 0) {
            flush();
        }
        this.lastTexture = null;
        this.drawing = false;
        kg kgVar = io.g;
        kgVar.glDepthMask(true);
        if (isBlendingEnabled()) {
            kgVar.glDisable(3042);
        }
        q qVar = this.customShader;
        if (qVar != null) {
            qVar.e();
        } else {
            this.shader.e();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(ka kaVar) {
        this.color.a(kaVar);
        this.colorPacked = kaVar.b();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(float f, float f2, float f3, float f4) {
        this.color.a(f, f2, f3, f4);
        this.colorPacked = this.color.b();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setPackedColor(float f) {
        ka.a(this.color, f);
        this.colorPacked = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public ka getColor() {
        return this.color;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public float getPackedColor() {
        return this.colorPacked;
    }

    @Override // com.badlogic.gdx.graphics.g2d.PolygonBatch
    public void draw(PolygonRegion polygonRegion, float f, float f2) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        short[] sArr2 = polygonRegion.triangles;
        int length = sArr2.length;
        float[] fArr = polygonRegion.vertices;
        int length2 = fArr.length;
        ko koVar = polygonRegion.region.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + length > sArr.length || this.vertexIndex + ((length2 * 5) / 2) > this.vertices.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex;
        int i3 = i2 / 5;
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        while (i6 < length) {
            sArr[i5] = (short) (sArr2[i6] + i3);
            i6++;
            i5++;
        }
        this.triangleIndex = i5;
        float[] fArr2 = this.vertices;
        float f3 = this.colorPacked;
        float[] fArr3 = polygonRegion.textureCoords;
        while (i4 < length2) {
            int i7 = i2 + 1;
            fArr2[i2] = fArr[i4] + f;
            int i8 = i7 + 1;
            int i9 = i4 + 1;
            fArr2[i7] = fArr[i9] + f2;
            int i10 = i8 + 1;
            fArr2[i8] = f3;
            int i11 = i10 + 1;
            fArr2[i10] = fArr3[i4];
            fArr2[i11] = fArr3[i9];
            i4 += 2;
            i2 = i11 + 1;
        }
        this.vertexIndex = i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.PolygonBatch
    public void draw(PolygonRegion polygonRegion, float f, float f2, float f3, float f4) {
        TextureRegion textureRegion;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        short[] sArr2 = polygonRegion.triangles;
        int length = sArr2.length;
        float[] fArr = polygonRegion.vertices;
        int length2 = fArr.length;
        ko koVar = polygonRegion.region.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + length > sArr.length || this.vertexIndex + ((length2 * 5) / 2) > this.vertices.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex;
        int i3 = i2 / 5;
        int length3 = sArr2.length;
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        while (i6 < length3) {
            sArr[i5] = (short) (sArr2[i6] + i3);
            i6++;
            i5++;
        }
        this.triangleIndex = i5;
        float[] fArr2 = this.vertices;
        float f5 = this.colorPacked;
        float[] fArr3 = polygonRegion.textureCoords;
        float f6 = f3 / textureRegion.regionWidth;
        float f7 = f4 / textureRegion.regionHeight;
        while (i4 < length2) {
            int i7 = i2 + 1;
            fArr2[i2] = (fArr[i4] * f6) + f;
            int i8 = i7 + 1;
            int i9 = i4 + 1;
            fArr2[i7] = (fArr[i9] * f7) + f2;
            int i10 = i8 + 1;
            fArr2[i8] = f5;
            int i11 = i10 + 1;
            fArr2[i10] = fArr3[i4];
            fArr2[i11] = fArr3[i9];
            i4 += 2;
            i2 = i11 + 1;
        }
        this.vertexIndex = i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.PolygonBatch
    public void draw(PolygonRegion polygonRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        TextureRegion textureRegion;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        short[] sArr2 = polygonRegion.triangles;
        int length = sArr2.length;
        float[] fArr = polygonRegion.vertices;
        int length2 = fArr.length;
        ko koVar = polygonRegion.region.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + length > sArr.length || this.vertexIndex + ((length2 * 5) / 2) > this.vertices.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex;
        int i3 = i2 / 5;
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        while (i6 < length) {
            sArr[i5] = (short) (sArr2[i6] + i3);
            i6++;
            i5++;
        }
        this.triangleIndex = i5;
        float[] fArr2 = this.vertices;
        float f10 = this.colorPacked;
        float[] fArr3 = polygonRegion.textureCoords;
        float f11 = f + f3;
        float f12 = f2 + f4;
        float f13 = f5 / textureRegion.regionWidth;
        float f14 = f6 / textureRegion.regionHeight;
        float d = h.d(f9);
        float c = h.c(f9);
        while (i4 < length2) {
            float f15 = ((fArr[i4] * f13) - f3) * f7;
            int i7 = i4 + 1;
            float f16 = ((fArr[i7] * f14) - f4) * f8;
            int i8 = i2 + 1;
            fArr2[i2] = ((d * f15) - (c * f16)) + f11;
            int i9 = i8 + 1;
            fArr2[i8] = (f15 * c) + (f16 * d) + f12;
            int i10 = i9 + 1;
            fArr2[i9] = f10;
            int i11 = i10 + 1;
            fArr2[i10] = fArr3[i4];
            fArr2[i11] = fArr3[i7];
            i4 += 2;
            i2 = i11 + 1;
        }
        this.vertexIndex = i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.PolygonBatch
    public void draw(ko koVar, float[] fArr, int i, int i2, short[] sArr, int i3, int i4) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr2 = this.triangles;
        float[] fArr2 = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + i4 > sArr2.length || this.vertexIndex + i2 > fArr2.length) {
            flush();
        }
        int i5 = this.triangleIndex;
        int i6 = this.vertexIndex;
        int i7 = i6 / 5;
        int i8 = i4 + i3;
        while (i3 < i8) {
            sArr2[i5] = (short) (sArr[i3] + i7);
            i3++;
            i5++;
        }
        this.triangleIndex = i5;
        System.arraycopy(fArr, i, fArr2, i6, i2);
        this.vertexIndex += i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i5 = this.triangleIndex;
        int i6 = this.vertexIndex / 5;
        int i7 = i5 + 1;
        short s = (short) i6;
        sArr[i5] = s;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i6 + 1);
        int i9 = i8 + 1;
        short s2 = (short) (i6 + 2);
        sArr[i8] = s2;
        int i10 = i9 + 1;
        sArr[i9] = s2;
        int i11 = i10 + 1;
        sArr[i10] = (short) (i6 + 3);
        sArr[i11] = s;
        this.triangleIndex = i11 + 1;
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
        float f37 = this.invTexWidth;
        float f38 = i * f37;
        float f39 = this.invTexHeight;
        float f40 = (i2 + i4) * f39;
        float f41 = (i + i3) * f37;
        float f42 = i2 * f39;
        if (!z) {
            f38 = f41;
            f41 = f38;
        }
        if (!z2) {
            f40 = f42;
            f42 = f40;
        }
        float f43 = this.colorPacked;
        int i12 = this.vertexIndex;
        int i13 = i12 + 1;
        fArr[i12] = f29;
        int i14 = i13 + 1;
        fArr[i13] = f30;
        int i15 = i14 + 1;
        fArr[i14] = f43;
        int i16 = i15 + 1;
        fArr[i15] = f41;
        int i17 = i16 + 1;
        fArr[i16] = f42;
        int i18 = i17 + 1;
        fArr[i17] = f31;
        int i19 = i18 + 1;
        fArr[i18] = f32;
        int i20 = i19 + 1;
        fArr[i19] = f43;
        int i21 = i20 + 1;
        fArr[i20] = f41;
        int i22 = i21 + 1;
        fArr[i21] = f40;
        int i23 = i22 + 1;
        fArr[i22] = f33;
        int i24 = i23 + 1;
        fArr[i23] = f34;
        int i25 = i24 + 1;
        fArr[i24] = f43;
        int i26 = i25 + 1;
        fArr[i25] = f38;
        int i27 = i26 + 1;
        fArr[i26] = f40;
        int i28 = i27 + 1;
        fArr[i27] = f35;
        int i29 = i28 + 1;
        fArr[i28] = f36;
        int i30 = i29 + 1;
        fArr[i29] = f43;
        int i31 = i30 + 1;
        fArr[i30] = f38;
        fArr[i31] = f42;
        this.vertexIndex = i31 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i5 = this.triangleIndex;
        int i6 = this.vertexIndex / 5;
        int i7 = i5 + 1;
        short s = (short) i6;
        sArr[i5] = s;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i6 + 1);
        int i9 = i8 + 1;
        short s2 = (short) (i6 + 2);
        sArr[i8] = s2;
        int i10 = i9 + 1;
        sArr[i9] = s2;
        int i11 = i10 + 1;
        sArr[i10] = (short) (i6 + 3);
        sArr[i11] = s;
        this.triangleIndex = i11 + 1;
        float f5 = this.invTexWidth;
        float f6 = i * f5;
        float f7 = this.invTexHeight;
        float f8 = (i2 + i4) * f7;
        float f9 = (i + i3) * f5;
        float f10 = i2 * f7;
        float f11 = f + f3;
        float f12 = f2 + f4;
        if (!z) {
            f6 = f9;
            f9 = f6;
        }
        if (z2) {
            f8 = f10;
            f10 = f8;
        }
        float f13 = this.colorPacked;
        int i12 = this.vertexIndex;
        int i13 = i12 + 1;
        fArr[i12] = f;
        int i14 = i13 + 1;
        fArr[i13] = f2;
        int i15 = i14 + 1;
        fArr[i14] = f13;
        int i16 = i15 + 1;
        fArr[i15] = f9;
        int i17 = i16 + 1;
        fArr[i16] = f8;
        int i18 = i17 + 1;
        fArr[i17] = f;
        int i19 = i18 + 1;
        fArr[i18] = f12;
        int i20 = i19 + 1;
        fArr[i19] = f13;
        int i21 = i20 + 1;
        fArr[i20] = f9;
        int i22 = i21 + 1;
        fArr[i21] = f10;
        int i23 = i22 + 1;
        fArr[i22] = f11;
        int i24 = i23 + 1;
        fArr[i23] = f12;
        int i25 = i24 + 1;
        fArr[i24] = f13;
        int i26 = i25 + 1;
        fArr[i25] = f6;
        int i27 = i26 + 1;
        fArr[i26] = f10;
        int i28 = i27 + 1;
        fArr[i27] = f11;
        int i29 = i28 + 1;
        fArr[i28] = f2;
        int i30 = i29 + 1;
        fArr[i29] = f13;
        int i31 = i30 + 1;
        fArr[i30] = f6;
        fArr[i31] = f8;
        this.vertexIndex = i31 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, int i, int i2, int i3, int i4) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i5 = this.triangleIndex;
        int i6 = this.vertexIndex;
        int i7 = i6 / 5;
        int i8 = i5 + 1;
        short s = (short) i7;
        sArr[i5] = s;
        int i9 = i8 + 1;
        sArr[i8] = (short) (i7 + 1);
        int i10 = i9 + 1;
        short s2 = (short) (i7 + 2);
        sArr[i9] = s2;
        int i11 = i10 + 1;
        sArr[i10] = s2;
        int i12 = i11 + 1;
        sArr[i11] = (short) (i7 + 3);
        sArr[i12] = s;
        this.triangleIndex = i12 + 1;
        float f3 = this.invTexWidth;
        float f4 = i * f3;
        float f5 = this.invTexHeight;
        float f6 = (i2 + i4) * f5;
        float f7 = (i + i3) * f3;
        float f8 = i2 * f5;
        float f9 = i3 + f;
        float f10 = i4 + f2;
        float f11 = this.colorPacked;
        int i13 = i6 + 1;
        fArr[i6] = f;
        int i14 = i13 + 1;
        fArr[i13] = f2;
        int i15 = i14 + 1;
        fArr[i14] = f11;
        int i16 = i15 + 1;
        fArr[i15] = f4;
        int i17 = i16 + 1;
        fArr[i16] = f6;
        int i18 = i17 + 1;
        fArr[i17] = f;
        int i19 = i18 + 1;
        fArr[i18] = f10;
        int i20 = i19 + 1;
        fArr[i19] = f11;
        int i21 = i20 + 1;
        fArr[i20] = f4;
        int i22 = i21 + 1;
        fArr[i21] = f8;
        int i23 = i22 + 1;
        fArr[i22] = f9;
        int i24 = i23 + 1;
        fArr[i23] = f10;
        int i25 = i24 + 1;
        fArr[i24] = f11;
        int i26 = i25 + 1;
        fArr[i25] = f7;
        int i27 = i26 + 1;
        fArr[i26] = f8;
        int i28 = i27 + 1;
        fArr[i27] = f9;
        int i29 = i28 + 1;
        fArr[i28] = f2;
        int i30 = i29 + 1;
        fArr[i29] = f11;
        int i31 = i30 + 1;
        fArr[i30] = f7;
        fArr[i31] = f6;
        this.vertexIndex = i31 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex;
        int i3 = i2 / 5;
        int i4 = i + 1;
        short s = (short) i3;
        sArr[i] = s;
        int i5 = i4 + 1;
        sArr[i4] = (short) (i3 + 1);
        int i6 = i5 + 1;
        short s2 = (short) (i3 + 2);
        sArr[i5] = s2;
        int i7 = i6 + 1;
        sArr[i6] = s2;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i3 + 3);
        sArr[i8] = s;
        this.triangleIndex = i8 + 1;
        float f9 = f + f3;
        float f10 = f2 + f4;
        float f11 = this.colorPacked;
        int i9 = i2 + 1;
        fArr[i2] = f;
        int i10 = i9 + 1;
        fArr[i9] = f2;
        int i11 = i10 + 1;
        fArr[i10] = f11;
        int i12 = i11 + 1;
        fArr[i11] = f5;
        int i13 = i12 + 1;
        fArr[i12] = f6;
        int i14 = i13 + 1;
        fArr[i13] = f;
        int i15 = i14 + 1;
        fArr[i14] = f10;
        int i16 = i15 + 1;
        fArr[i15] = f11;
        int i17 = i16 + 1;
        fArr[i16] = f5;
        int i18 = i17 + 1;
        fArr[i17] = f8;
        int i19 = i18 + 1;
        fArr[i18] = f9;
        int i20 = i19 + 1;
        fArr[i19] = f10;
        int i21 = i20 + 1;
        fArr[i20] = f11;
        int i22 = i21 + 1;
        fArr[i21] = f7;
        int i23 = i22 + 1;
        fArr[i22] = f8;
        int i24 = i23 + 1;
        fArr[i23] = f9;
        int i25 = i24 + 1;
        fArr[i24] = f2;
        int i26 = i25 + 1;
        fArr[i25] = f11;
        int i27 = i26 + 1;
        fArr[i26] = f7;
        fArr[i27] = f6;
        this.vertexIndex = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2) {
        draw(koVar, f, f2, koVar.getWidth(), koVar.getHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex;
        int i3 = i2 / 5;
        int i4 = i + 1;
        short s = (short) i3;
        sArr[i] = s;
        int i5 = i4 + 1;
        sArr[i4] = (short) (i3 + 1);
        int i6 = i5 + 1;
        short s2 = (short) (i3 + 2);
        sArr[i5] = s2;
        int i7 = i6 + 1;
        sArr[i6] = s2;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i3 + 3);
        sArr[i8] = s;
        this.triangleIndex = i8 + 1;
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = this.colorPacked;
        int i9 = i2 + 1;
        fArr[i2] = f;
        int i10 = i9 + 1;
        fArr[i9] = f2;
        int i11 = i10 + 1;
        fArr[i10] = f7;
        int i12 = i11 + 1;
        fArr[i11] = 0.0f;
        int i13 = i12 + 1;
        fArr[i12] = 1.0f;
        int i14 = i13 + 1;
        fArr[i13] = f;
        int i15 = i14 + 1;
        fArr[i14] = f6;
        int i16 = i15 + 1;
        fArr[i15] = f7;
        int i17 = i16 + 1;
        fArr[i16] = 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = 0.0f;
        int i19 = i18 + 1;
        fArr[i18] = f5;
        int i20 = i19 + 1;
        fArr[i19] = f6;
        int i21 = i20 + 1;
        fArr[i20] = f7;
        int i22 = i21 + 1;
        fArr[i21] = 1.0f;
        int i23 = i22 + 1;
        fArr[i22] = 0.0f;
        int i24 = i23 + 1;
        fArr[i23] = f5;
        int i25 = i24 + 1;
        fArr[i24] = f2;
        int i26 = i25 + 1;
        fArr[i25] = f7;
        int i27 = i26 + 1;
        fArr[i26] = 1.0f;
        fArr[i27] = 1.0f;
        this.vertexIndex = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float[] fArr, int i, int i2) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr2 = this.vertices;
        int i3 = (i2 / 20) * 6;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + i3 > sArr.length || this.vertexIndex + i2 > fArr2.length) {
            flush();
        }
        int i4 = this.vertexIndex;
        int i5 = this.triangleIndex;
        short s = (short) (i4 / 5);
        int i6 = i3 + i5;
        while (i5 < i6) {
            sArr[i5] = s;
            sArr[i5 + 1] = (short) (s + 1);
            short s2 = (short) (s + 2);
            sArr[i5 + 2] = s2;
            sArr[i5 + 3] = s2;
            sArr[i5 + 4] = (short) (s + 3);
            sArr[i5 + 5] = s;
            i5 += 6;
            s = (short) (s + 4);
        }
        this.triangleIndex = i5;
        System.arraycopy(fArr, i, fArr2, i4, i2);
        this.vertexIndex += i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2) {
        draw(textureRegion, f, f2, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex / 5;
        int i3 = i + 1;
        short s = (short) i2;
        sArr[i] = s;
        int i4 = i3 + 1;
        sArr[i3] = (short) (i2 + 1);
        int i5 = i4 + 1;
        short s2 = (short) (i2 + 2);
        sArr[i4] = s2;
        int i6 = i5 + 1;
        sArr[i5] = s2;
        int i7 = i6 + 1;
        sArr[i6] = (short) (i2 + 3);
        sArr[i7] = s;
        this.triangleIndex = i7 + 1;
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = textureRegion.u;
        float f8 = textureRegion.v2;
        float f9 = textureRegion.u2;
        float f10 = textureRegion.v;
        float f11 = this.colorPacked;
        int i8 = this.vertexIndex;
        int i9 = i8 + 1;
        fArr[i8] = f;
        int i10 = i9 + 1;
        fArr[i9] = f2;
        int i11 = i10 + 1;
        fArr[i10] = f11;
        int i12 = i11 + 1;
        fArr[i11] = f7;
        int i13 = i12 + 1;
        fArr[i12] = f8;
        int i14 = i13 + 1;
        fArr[i13] = f;
        int i15 = i14 + 1;
        fArr[i14] = f6;
        int i16 = i15 + 1;
        fArr[i15] = f11;
        int i17 = i16 + 1;
        fArr[i16] = f7;
        int i18 = i17 + 1;
        fArr[i17] = f10;
        int i19 = i18 + 1;
        fArr[i18] = f5;
        int i20 = i19 + 1;
        fArr[i19] = f6;
        int i21 = i20 + 1;
        fArr[i20] = f11;
        int i22 = i21 + 1;
        fArr[i21] = f9;
        int i23 = i22 + 1;
        fArr[i22] = f10;
        int i24 = i23 + 1;
        fArr[i23] = f5;
        int i25 = i24 + 1;
        fArr[i24] = f2;
        int i26 = i25 + 1;
        fArr[i25] = f11;
        int i27 = i26 + 1;
        fArr[i26] = f9;
        fArr[i27] = f8;
        this.vertexIndex = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex / 5;
        int i3 = i + 1;
        short s = (short) i2;
        sArr[i] = s;
        int i4 = i3 + 1;
        sArr[i3] = (short) (i2 + 1);
        int i5 = i4 + 1;
        short s2 = (short) (i2 + 2);
        sArr[i4] = s2;
        int i6 = i5 + 1;
        sArr[i5] = s2;
        int i7 = i6 + 1;
        sArr[i6] = (short) (i2 + 3);
        sArr[i7] = s;
        this.triangleIndex = i7 + 1;
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
        float f41 = this.colorPacked;
        int i8 = this.vertexIndex;
        int i9 = i8 + 1;
        fArr[i8] = f29;
        int i10 = i9 + 1;
        fArr[i9] = f30;
        int i11 = i10 + 1;
        fArr[i10] = f41;
        int i12 = i11 + 1;
        fArr[i11] = f37;
        int i13 = i12 + 1;
        fArr[i12] = f38;
        int i14 = i13 + 1;
        fArr[i13] = f31;
        int i15 = i14 + 1;
        fArr[i14] = f32;
        int i16 = i15 + 1;
        fArr[i15] = f41;
        int i17 = i16 + 1;
        fArr[i16] = f37;
        int i18 = i17 + 1;
        fArr[i17] = f40;
        int i19 = i18 + 1;
        fArr[i18] = f33;
        int i20 = i19 + 1;
        fArr[i19] = f34;
        int i21 = i20 + 1;
        fArr[i20] = f41;
        int i22 = i21 + 1;
        fArr[i21] = f39;
        int i23 = i22 + 1;
        fArr[i22] = f40;
        int i24 = i23 + 1;
        fArr[i23] = f35;
        int i25 = i24 + 1;
        fArr[i24] = f36;
        int i26 = i25 + 1;
        fArr[i25] = f41;
        int i27 = i26 + 1;
        fArr[i26] = f39;
        fArr[i27] = f38;
        this.vertexIndex = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex / 5;
        int i3 = i + 1;
        short s = (short) i2;
        sArr[i] = s;
        int i4 = i3 + 1;
        sArr[i3] = (short) (i2 + 1);
        int i5 = i4 + 1;
        short s2 = (short) (i2 + 2);
        sArr[i4] = s2;
        int i6 = i5 + 1;
        sArr[i5] = s2;
        int i7 = i6 + 1;
        sArr[i6] = (short) (i2 + 3);
        sArr[i7] = s;
        this.triangleIndex = i7 + 1;
        float f24 = f + f3;
        float f25 = f2 + f4;
        float f26 = -f3;
        float f27 = -f4;
        float f28 = f5 - f3;
        float f29 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f26 *= f7;
            f27 *= f8;
            f28 *= f7;
            f29 *= f8;
        }
        if (f9 != 0.0f) {
            float d = h.d(f9);
            float c = h.c(f9);
            float f30 = d * f26;
            float f31 = f30 - (c * f27);
            float f32 = f26 * c;
            f27 = (f27 * d) + f32;
            float f33 = c * f29;
            f13 = f30 - f33;
            float f34 = f29 * d;
            float f35 = f32 + f34;
            f10 = (d * f28) - f33;
            float f36 = f34 + (c * f28);
            float f37 = f36 - (f35 - f27);
            f11 = (f10 - f13) + f31;
            f12 = f36;
            f29 = f35;
            f26 = f31;
            f14 = f37;
        } else {
            f10 = f28;
            f11 = f10;
            f12 = f29;
            f13 = f26;
            f14 = f27;
        }
        float f38 = f26 + f24;
        float f39 = f27 + f25;
        float f40 = f13 + f24;
        float f41 = f29 + f25;
        float f42 = f10 + f24;
        float f43 = f12 + f25;
        float f44 = f11 + f24;
        float f45 = f14 + f25;
        if (z) {
            float f46 = textureRegion.u2;
            f15 = textureRegion.v2;
            f16 = textureRegion.u;
            f17 = textureRegion.v2;
            f18 = textureRegion.u;
            float f47 = textureRegion.v;
            float f48 = textureRegion.u2;
            f19 = textureRegion.v;
            f20 = f48;
            f21 = f46;
            f22 = f47;
            f23 = f45;
        } else {
            float f49 = textureRegion.u;
            f15 = textureRegion.v;
            f16 = textureRegion.u2;
            f17 = textureRegion.v;
            f18 = textureRegion.u2;
            float f50 = textureRegion.v2;
            float f51 = textureRegion.u;
            f19 = textureRegion.v2;
            f20 = f51;
            f21 = f49;
            f22 = f50;
            f23 = f45;
        }
        float f52 = this.colorPacked;
        int i8 = this.vertexIndex;
        int i9 = i8 + 1;
        fArr[i8] = f38;
        int i10 = i9 + 1;
        fArr[i9] = f39;
        int i11 = i10 + 1;
        fArr[i10] = f52;
        int i12 = i11 + 1;
        fArr[i11] = f21;
        int i13 = i12 + 1;
        fArr[i12] = f15;
        int i14 = i13 + 1;
        fArr[i13] = f40;
        int i15 = i14 + 1;
        fArr[i14] = f41;
        int i16 = i15 + 1;
        fArr[i15] = f52;
        int i17 = i16 + 1;
        fArr[i16] = f16;
        int i18 = i17 + 1;
        fArr[i17] = f17;
        int i19 = i18 + 1;
        fArr[i18] = f42;
        int i20 = i19 + 1;
        fArr[i19] = f43;
        int i21 = i20 + 1;
        fArr[i20] = f52;
        int i22 = i21 + 1;
        fArr[i21] = f18;
        int i23 = i22 + 1;
        fArr[i22] = f22;
        int i24 = i23 + 1;
        fArr[i23] = f44;
        int i25 = i24 + 1;
        fArr[i24] = f23;
        int i26 = i25 + 1;
        fArr[i25] = f52;
        int i27 = i26 + 1;
        fArr[i26] = f20;
        fArr[i27] = f19;
        this.vertexIndex = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, a aVar) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.triangles;
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.triangleIndex + 6 > sArr.length || this.vertexIndex + 20 > fArr.length) {
            flush();
        }
        int i = this.triangleIndex;
        int i2 = this.vertexIndex / 5;
        int i3 = i + 1;
        short s = (short) i2;
        sArr[i] = s;
        int i4 = i3 + 1;
        sArr[i3] = (short) (i2 + 1);
        int i5 = i4 + 1;
        short s2 = (short) (i2 + 2);
        sArr[i4] = s2;
        int i6 = i5 + 1;
        sArr[i5] = s2;
        int i7 = i6 + 1;
        sArr[i6] = (short) (i2 + 3);
        sArr[i7] = s;
        this.triangleIndex = i7 + 1;
        float f3 = aVar.c;
        float f4 = aVar.f;
        float f5 = (aVar.b * f2) + aVar.c;
        float f6 = (aVar.e * f2) + aVar.f;
        float f7 = (aVar.a * f) + (aVar.b * f2) + aVar.c;
        float f8 = (aVar.d * f) + (aVar.e * f2) + aVar.f;
        float f9 = (aVar.a * f) + aVar.c;
        float f10 = (aVar.d * f) + aVar.f;
        float f11 = textureRegion.u;
        float f12 = textureRegion.v2;
        float f13 = textureRegion.u2;
        float f14 = textureRegion.v;
        float f15 = this.colorPacked;
        int i8 = this.vertexIndex;
        int i9 = i8 + 1;
        fArr[i8] = f3;
        int i10 = i9 + 1;
        fArr[i9] = f4;
        int i11 = i10 + 1;
        fArr[i10] = f15;
        int i12 = i11 + 1;
        fArr[i11] = f11;
        int i13 = i12 + 1;
        fArr[i12] = f12;
        int i14 = i13 + 1;
        fArr[i13] = f5;
        int i15 = i14 + 1;
        fArr[i14] = f6;
        int i16 = i15 + 1;
        fArr[i15] = f15;
        int i17 = i16 + 1;
        fArr[i16] = f11;
        int i18 = i17 + 1;
        fArr[i17] = f14;
        int i19 = i18 + 1;
        fArr[i18] = f7;
        int i20 = i19 + 1;
        fArr[i19] = f8;
        int i21 = i20 + 1;
        fArr[i20] = f15;
        int i22 = i21 + 1;
        fArr[i21] = f13;
        int i23 = i22 + 1;
        fArr[i22] = f14;
        int i24 = i23 + 1;
        fArr[i23] = f9;
        int i25 = i24 + 1;
        fArr[i24] = f10;
        int i26 = i25 + 1;
        fArr[i25] = f15;
        int i27 = i26 + 1;
        fArr[i26] = f13;
        fArr[i27] = f12;
        this.vertexIndex = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void flush() {
        if (this.vertexIndex == 0) {
            return;
        }
        this.renderCalls++;
        this.totalRenderCalls++;
        int i = this.triangleIndex;
        if (i > this.maxTrianglesInBatch) {
            this.maxTrianglesInBatch = i;
        }
        this.lastTexture.bind();
        kj kjVar = this.mesh;
        kjVar.a(this.vertices, 0, this.vertexIndex);
        kjVar.a(this.triangles, 0, this.triangleIndex);
        if (this.blendingDisabled) {
            io.g.glDisable(3042);
        } else {
            io.g.glEnable(3042);
            if (this.blendSrcFunc != -1) {
                io.g.glBlendFuncSeparate(this.blendSrcFunc, this.blendDstFunc, this.blendSrcFuncAlpha, this.blendDstFuncAlpha);
            }
        }
        q qVar = this.customShader;
        if (qVar == null) {
            qVar = this.shader;
        }
        kjVar.a(qVar, 4, 0, i);
        this.vertexIndex = 0;
        this.triangleIndex = 0;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void disableBlending() {
        flush();
        this.blendingDisabled = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void enableBlending() {
        flush();
        this.blendingDisabled = false;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setBlendFunction(int i, int i2) {
        setBlendFunctionSeparate(i, i2, i, i2);
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setBlendFunctionSeparate(int i, int i2, int i3, int i4) {
        if (this.blendSrcFunc == i && this.blendDstFunc == i2 && this.blendSrcFuncAlpha == i3 && this.blendDstFuncAlpha == i4) {
            return;
        }
        flush();
        this.blendSrcFunc = i;
        this.blendDstFunc = i2;
        this.blendSrcFuncAlpha = i3;
        this.blendDstFuncAlpha = i4;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendSrcFunc() {
        return this.blendSrcFunc;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendDstFunc() {
        return this.blendDstFunc;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendSrcFuncAlpha() {
        return this.blendSrcFuncAlpha;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendDstFuncAlpha() {
        return this.blendDstFuncAlpha;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        q qVar;
        this.mesh.dispose();
        if (!this.ownsShader || (qVar = this.shader) == null) {
            return;
        }
        qVar.dispose();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setProjectionMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            flush();
        }
        this.projectionMatrix.a(matrix4);
        if (this.drawing) {
            setupMatrices();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setTransformMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            flush();
        }
        this.transformMatrix.a(matrix4);
        if (this.drawing) {
            setupMatrices();
        }
    }

    private void setupMatrices() {
        this.combinedMatrix.a(this.projectionMatrix).b(this.transformMatrix);
        q qVar = this.customShader;
        if (qVar != null) {
            qVar.a("u_projTrans", this.combinedMatrix);
            this.customShader.a("u_texture", 0);
            return;
        }
        this.shader.a("u_projTrans", this.combinedMatrix);
        this.shader.a("u_texture", 0);
    }

    private void switchTexture(ko koVar) {
        flush();
        this.lastTexture = koVar;
        this.invTexWidth = 1.0f / koVar.getWidth();
        this.invTexHeight = 1.0f / koVar.getHeight();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setShader(q qVar) {
        if (this.drawing) {
            flush();
            q qVar2 = this.customShader;
            if (qVar2 != null) {
                qVar2.e();
            } else {
                this.shader.e();
            }
        }
        this.customShader = qVar;
        if (this.drawing) {
            q qVar3 = this.customShader;
            if (qVar3 != null) {
                qVar3.d();
            } else {
                this.shader.d();
            }
            setupMatrices();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public q getShader() {
        q qVar = this.customShader;
        return qVar == null ? this.shader : qVar;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public boolean isBlendingEnabled() {
        return !this.blendingDisabled;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public boolean isDrawing() {
        return this.drawing;
    }
}
