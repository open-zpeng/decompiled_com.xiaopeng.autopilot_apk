package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.a;
import com.badlogic.gdx.math.h;
import defpackage.kj;
/* loaded from: classes.dex */
public class SpriteBatch implements Batch {
    @Deprecated
    public static kj.a defaultVertexDataType = kj.a.VertexArray;
    private int blendDstFunc;
    private int blendDstFuncAlpha;
    private int blendSrcFunc;
    private int blendSrcFuncAlpha;
    private boolean blendingDisabled;
    private final ka color;
    float colorPacked;
    private final Matrix4 combinedMatrix;
    private q customShader;
    boolean drawing;
    int idx;
    float invTexHeight;
    float invTexWidth;
    ko lastTexture;
    public int maxSpritesInBatch;
    private kj mesh;
    private boolean ownsShader;
    private final Matrix4 projectionMatrix;
    public int renderCalls;
    private final q shader;
    public int totalRenderCalls;
    private final Matrix4 transformMatrix;
    final float[] vertices;

    public SpriteBatch() {
        this(1000, null);
    }

    public SpriteBatch(int i) {
        this(i, null);
    }

    public SpriteBatch(int i, q qVar) {
        this.idx = 0;
        this.lastTexture = null;
        this.invTexWidth = 0.0f;
        this.invTexHeight = 0.0f;
        this.drawing = false;
        this.transformMatrix = new Matrix4();
        this.projectionMatrix = new Matrix4();
        this.combinedMatrix = new Matrix4();
        this.blendingDisabled = false;
        this.blendSrcFunc = 770;
        this.blendDstFunc = 771;
        this.blendSrcFuncAlpha = 770;
        this.blendDstFuncAlpha = 771;
        this.customShader = null;
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.colorPacked = ka.f;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.maxSpritesInBatch = 0;
        if (i > 8191) {
            throw new IllegalArgumentException("Can't have more than 8191 sprites per batch: " + i);
        }
        int i2 = i * 6;
        this.mesh = new kj(io.i != null ? kj.a.VertexBufferObjectWithVAO : defaultVertexDataType, false, i * 4, i2, new ks(1, 2, "a_position"), new ks(4, 4, "a_color"), new ks(16, 2, "a_texCoord0"));
        this.projectionMatrix.c(0.0f, 0.0f, io.b.getWidth(), io.b.getHeight());
        this.vertices = new float[i * 20];
        short[] sArr = new short[i2];
        int i3 = 0;
        short s = 0;
        while (i3 < i2) {
            sArr[i3] = s;
            sArr[i3 + 1] = (short) (s + 1);
            short s2 = (short) (s + 2);
            sArr[i3 + 2] = s2;
            sArr[i3 + 3] = s2;
            sArr[i3 + 4] = (short) (s + 3);
            sArr[i3 + 5] = s;
            i3 += 6;
            s = (short) (s + 4);
        }
        this.mesh.a(sArr);
        if (qVar == null) {
            this.shader = createDefaultShader();
            this.ownsShader = true;
            return;
        }
        this.shader = qVar;
    }

    public static q createDefaultShader() {
        q qVar = new q("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        if (qVar.c()) {
            return qVar;
        }
        throw new IllegalArgumentException("Error compiling shader: " + qVar.b());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void begin() {
        if (this.drawing) {
            throw new IllegalStateException("SpriteBatch.end must be called before begin.");
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
            throw new IllegalStateException("SpriteBatch.begin must be called before end.");
        }
        if (this.idx > 0) {
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
    public ka getColor() {
        return this.color;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setPackedColor(float f) {
        ka.a(this.color, f);
        this.colorPacked = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public float getPackedColor() {
        return this.colorPacked;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
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
        int i5 = this.idx;
        fArr[i5] = f29;
        fArr[i5 + 1] = f30;
        fArr[i5 + 2] = f43;
        fArr[i5 + 3] = f41;
        fArr[i5 + 4] = f42;
        fArr[i5 + 5] = f31;
        fArr[i5 + 6] = f32;
        fArr[i5 + 7] = f43;
        fArr[i5 + 8] = f41;
        fArr[i5 + 9] = f40;
        fArr[i5 + 10] = f33;
        fArr[i5 + 11] = f34;
        fArr[i5 + 12] = f43;
        fArr[i5 + 13] = f38;
        fArr[i5 + 14] = f40;
        fArr[i5 + 15] = f35;
        fArr[i5 + 16] = f36;
        fArr[i5 + 17] = f43;
        fArr[i5 + 18] = f38;
        fArr[i5 + 19] = f42;
        this.idx = i5 + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
        float f5 = this.invTexWidth;
        float f6 = i * f5;
        float f7 = this.invTexHeight;
        float f8 = (i4 + i2) * f7;
        float f9 = (i + i3) * f5;
        float f10 = i2 * f7;
        float f11 = f3 + f;
        float f12 = f4 + f2;
        if (z) {
            f9 = f6;
            f6 = f9;
        }
        if (!z2) {
            f8 = f10;
            f10 = f8;
        }
        float f13 = this.colorPacked;
        int i5 = this.idx;
        fArr[i5] = f;
        fArr[i5 + 1] = f2;
        fArr[i5 + 2] = f13;
        fArr[i5 + 3] = f6;
        fArr[i5 + 4] = f10;
        fArr[i5 + 5] = f;
        fArr[i5 + 6] = f12;
        fArr[i5 + 7] = f13;
        fArr[i5 + 8] = f6;
        fArr[i5 + 9] = f8;
        fArr[i5 + 10] = f11;
        fArr[i5 + 11] = f12;
        fArr[i5 + 12] = f13;
        fArr[i5 + 13] = f9;
        fArr[i5 + 14] = f8;
        fArr[i5 + 15] = f11;
        fArr[i5 + 16] = f2;
        fArr[i5 + 17] = f13;
        fArr[i5 + 18] = f9;
        fArr[i5 + 19] = f10;
        this.idx = i5 + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, int i, int i2, int i3, int i4) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
        float f3 = this.invTexWidth;
        float f4 = i * f3;
        float f5 = this.invTexHeight;
        float f6 = (i2 + i4) * f5;
        float f7 = (i + i3) * f3;
        float f8 = i2 * f5;
        float f9 = i3 + f;
        float f10 = i4 + f2;
        float f11 = this.colorPacked;
        int i5 = this.idx;
        fArr[i5] = f;
        fArr[i5 + 1] = f2;
        fArr[i5 + 2] = f11;
        fArr[i5 + 3] = f4;
        fArr[i5 + 4] = f6;
        fArr[i5 + 5] = f;
        fArr[i5 + 6] = f10;
        fArr[i5 + 7] = f11;
        fArr[i5 + 8] = f4;
        fArr[i5 + 9] = f8;
        fArr[i5 + 10] = f9;
        fArr[i5 + 11] = f10;
        fArr[i5 + 12] = f11;
        fArr[i5 + 13] = f7;
        fArr[i5 + 14] = f8;
        fArr[i5 + 15] = f9;
        fArr[i5 + 16] = f2;
        fArr[i5 + 17] = f11;
        fArr[i5 + 18] = f7;
        fArr[i5 + 19] = f6;
        this.idx = i5 + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
        float f9 = f3 + f;
        float f10 = f4 + f2;
        float f11 = this.colorPacked;
        int i = this.idx;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f11;
        fArr[i + 3] = f5;
        fArr[i + 4] = f6;
        fArr[i + 5] = f;
        fArr[i + 6] = f10;
        fArr[i + 7] = f11;
        fArr[i + 8] = f5;
        fArr[i + 9] = f8;
        fArr[i + 10] = f9;
        fArr[i + 11] = f10;
        fArr[i + 12] = f11;
        fArr[i + 13] = f7;
        fArr[i + 14] = f8;
        fArr[i + 15] = f9;
        fArr[i + 16] = f2;
        fArr[i + 17] = f11;
        fArr[i + 18] = f7;
        fArr[i + 19] = f6;
        this.idx = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2) {
        draw(koVar, f, f2, koVar.getWidth(), koVar.getHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = this.colorPacked;
        int i = this.idx;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f7;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 1.0f;
        fArr[i + 5] = f;
        fArr[i + 6] = f6;
        fArr[i + 7] = f7;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 10] = f5;
        fArr[i + 11] = f6;
        fArr[i + 12] = f7;
        fArr[i + 13] = 1.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = f5;
        fArr[i + 16] = f2;
        fArr[i + 17] = f7;
        fArr[i + 18] = 1.0f;
        fArr[i + 19] = 1.0f;
        this.idx = i + 20;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[LOOP:0: B:12:0x002a->B:13:0x002c, LOOP_END] */
    @Override // com.badlogic.gdx.graphics.g2d.Batch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(defpackage.ko r4, float[] r5, int r6, int r7) {
        /*
            r3 = this;
            boolean r0 = r3.drawing
            if (r0 == 0) goto L42
            float[] r0 = r3.vertices
            int r0 = r0.length
            ko r1 = r3.lastTexture
            if (r4 == r1) goto Lf
            r3.switchTexture(r4)
            goto L18
        Lf:
            int r4 = r3.idx
            int r4 = r0 - r4
            if (r4 != 0) goto L19
            r3.flush()
        L18:
            r4 = r0
        L19:
            int r4 = java.lang.Math.min(r4, r7)
            float[] r1 = r3.vertices
            int r2 = r3.idx
            java.lang.System.arraycopy(r5, r6, r1, r2, r4)
            int r1 = r3.idx
            int r1 = r1 + r4
            r3.idx = r1
            int r7 = r7 - r4
        L2a:
            if (r7 <= 0) goto L41
            int r6 = r6 + r4
            r3.flush()
            int r4 = java.lang.Math.min(r0, r7)
            float[] r1 = r3.vertices
            r2 = 0
            java.lang.System.arraycopy(r5, r6, r1, r2, r4)
            int r1 = r3.idx
            int r1 = r1 + r4
            r3.idx = r1
            int r7 = r7 - r4
            goto L2a
        L41:
            return
        L42:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "SpriteBatch.begin must be called before draw."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.SpriteBatch.draw(ko, float[], int, int):void");
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2) {
        draw(textureRegion, f, f2, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = textureRegion.u;
        float f8 = textureRegion.v2;
        float f9 = textureRegion.u2;
        float f10 = textureRegion.v;
        float f11 = this.colorPacked;
        int i = this.idx;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f11;
        fArr[i + 3] = f7;
        fArr[i + 4] = f8;
        fArr[i + 5] = f;
        fArr[i + 6] = f6;
        fArr[i + 7] = f11;
        fArr[i + 8] = f7;
        fArr[i + 9] = f10;
        fArr[i + 10] = f5;
        fArr[i + 11] = f6;
        fArr[i + 12] = f11;
        fArr[i + 13] = f9;
        fArr[i + 14] = f10;
        fArr[i + 15] = f5;
        fArr[i + 16] = f2;
        fArr[i + 17] = f11;
        fArr[i + 18] = f9;
        fArr[i + 19] = f8;
        this.idx = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
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
            f13 = f21 - (c * f18);
            float f22 = f17 * c;
            f18 = (f18 * d) + f22;
            float f23 = c * f20;
            f12 = f21 - f23;
            float f24 = f20 * d;
            float f25 = f22 + f24;
            f10 = (d * f19) - f23;
            float f26 = f24 + (c * f19);
            f19 = f13 + (f10 - f12);
            f14 = f26 - (f25 - f18);
            f11 = f26;
            f20 = f25;
        } else {
            f10 = f19;
            f11 = f20;
            f12 = f17;
            f13 = f12;
            f14 = f18;
        }
        float f27 = f13 + f15;
        float f28 = f18 + f16;
        float f29 = f12 + f15;
        float f30 = f20 + f16;
        float f31 = f10 + f15;
        float f32 = f11 + f16;
        float f33 = f19 + f15;
        float f34 = f14 + f16;
        float f35 = textureRegion.u;
        float f36 = textureRegion.v2;
        float f37 = textureRegion.u2;
        float f38 = textureRegion.v;
        float f39 = this.colorPacked;
        int i = this.idx;
        fArr[i] = f27;
        fArr[i + 1] = f28;
        fArr[i + 2] = f39;
        fArr[i + 3] = f35;
        fArr[i + 4] = f36;
        fArr[i + 5] = f29;
        fArr[i + 6] = f30;
        fArr[i + 7] = f39;
        fArr[i + 8] = f35;
        fArr[i + 9] = f38;
        fArr[i + 10] = f31;
        fArr[i + 11] = f32;
        fArr[i + 12] = f39;
        fArr[i + 13] = f37;
        fArr[i + 14] = f38;
        fArr[i + 15] = f33;
        fArr[i + 16] = f34;
        fArr[i + 17] = f39;
        fArr[i + 18] = f37;
        fArr[i + 19] = f36;
        this.idx = i + 20;
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
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
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
        int i = this.idx;
        fArr[i] = f38;
        fArr[i + 1] = f39;
        fArr[i + 2] = f52;
        fArr[i + 3] = f21;
        fArr[i + 4] = f15;
        fArr[i + 5] = f40;
        fArr[i + 6] = f41;
        fArr[i + 7] = f52;
        fArr[i + 8] = f16;
        fArr[i + 9] = f17;
        fArr[i + 10] = f42;
        fArr[i + 11] = f43;
        fArr[i + 12] = f52;
        fArr[i + 13] = f18;
        fArr[i + 14] = f22;
        fArr[i + 15] = f44;
        fArr[i + 16] = f23;
        fArr[i + 17] = f52;
        fArr[i + 18] = f20;
        fArr[i + 19] = f19;
        this.idx = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, a aVar) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.vertices;
        ko koVar = textureRegion.texture;
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == fArr.length) {
            flush();
        }
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
        int i = this.idx;
        fArr[i] = f3;
        fArr[i + 1] = f4;
        fArr[i + 2] = f15;
        fArr[i + 3] = f11;
        fArr[i + 4] = f12;
        fArr[i + 5] = f5;
        fArr[i + 6] = f6;
        fArr[i + 7] = f15;
        fArr[i + 8] = f11;
        fArr[i + 9] = f14;
        fArr[i + 10] = f7;
        fArr[i + 11] = f8;
        fArr[i + 12] = f15;
        fArr[i + 13] = f13;
        fArr[i + 14] = f14;
        fArr[i + 15] = f9;
        fArr[i + 16] = f10;
        fArr[i + 17] = f15;
        fArr[i + 18] = f13;
        fArr[i + 19] = f12;
        this.idx = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void flush() {
        int i = this.idx;
        if (i == 0) {
            return;
        }
        this.renderCalls++;
        this.totalRenderCalls++;
        int i2 = i / 20;
        if (i2 > this.maxSpritesInBatch) {
            this.maxSpritesInBatch = i2;
        }
        int i3 = i2 * 6;
        this.lastTexture.bind();
        kj kjVar = this.mesh;
        kjVar.a(this.vertices, 0, this.idx);
        kjVar.h().position(0);
        kjVar.h().limit(i3);
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
        kjVar.a(qVar, 4, 0, i3);
        this.idx = 0;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void disableBlending() {
        if (this.blendingDisabled) {
            return;
        }
        flush();
        this.blendingDisabled = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void enableBlending() {
        if (this.blendingDisabled) {
            flush();
            this.blendingDisabled = false;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void switchTexture(ko koVar) {
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
