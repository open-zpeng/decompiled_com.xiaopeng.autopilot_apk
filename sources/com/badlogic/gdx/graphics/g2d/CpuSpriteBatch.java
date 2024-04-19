package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.a;
import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.k;
/* loaded from: classes.dex */
public class CpuSpriteBatch extends SpriteBatch {
    private final a adjustAffine;
    private boolean adjustNeeded;
    private boolean haveIdentityRealMatrix;
    private final a tmpAffine;
    private final Matrix4 virtualMatrix;

    public CpuSpriteBatch() {
        this(1000);
    }

    public CpuSpriteBatch(int i) {
        this(i, null);
    }

    public CpuSpriteBatch(int i, q qVar) {
        super(i, qVar);
        this.virtualMatrix = new Matrix4();
        this.adjustAffine = new a();
        this.haveIdentityRealMatrix = true;
        this.tmpAffine = new a();
    }

    public void flushAndSyncTransformMatrix() {
        flush();
        if (this.adjustNeeded) {
            this.haveIdentityRealMatrix = checkIdt(this.virtualMatrix);
            if (!this.haveIdentityRealMatrix && this.virtualMatrix.e() == 0.0f) {
                throw new k("Transform matrix is singular, can't sync");
            }
            this.adjustNeeded = false;
            super.setTransformMatrix(this.virtualMatrix);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public Matrix4 getTransformMatrix() {
        return this.adjustNeeded ? this.virtualMatrix : super.getTransformMatrix();
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void setTransformMatrix(Matrix4 matrix4) {
        Matrix4 transformMatrix = super.getTransformMatrix();
        if (checkEqual(transformMatrix, matrix4)) {
            this.adjustNeeded = false;
        } else if (isDrawing()) {
            this.virtualMatrix.c(matrix4);
            this.adjustNeeded = true;
            if (this.haveIdentityRealMatrix) {
                this.adjustAffine.a(matrix4);
                return;
            }
            this.tmpAffine.a(matrix4);
            this.adjustAffine.a(transformMatrix).a().b(this.tmpAffine);
        } else {
            transformMatrix.c(matrix4);
            this.haveIdentityRealMatrix = checkIdt(transformMatrix);
        }
    }

    public void setTransformMatrix(a aVar) {
        Matrix4 transformMatrix = super.getTransformMatrix();
        if (checkEqual(transformMatrix, aVar)) {
            this.adjustNeeded = false;
            return;
        }
        this.virtualMatrix.b(aVar);
        if (isDrawing()) {
            this.adjustNeeded = true;
            if (this.haveIdentityRealMatrix) {
                this.adjustAffine.a(aVar);
                return;
            } else {
                this.adjustAffine.a(transformMatrix).a().b(aVar);
                return;
            }
        }
        transformMatrix.b(aVar);
        this.haveIdentityRealMatrix = checkIdt(transformMatrix);
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.adjustNeeded) {
            super.draw(koVar, f, f2, f3, f4, f5, f6, f7, f8, f9, i, i2, i3, i4, z, z2);
        } else {
            drawAdjusted(koVar, f, f2, f3, f4, f5, f6, f7, f8, f9, i, i2, i3, i4, z, z2);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.adjustNeeded) {
            super.draw(koVar, f, f2, f3, f4, i, i2, i3, i4, z, z2);
        } else {
            drawAdjusted(koVar, f, f2, 0.0f, 0.0f, f3, f4, 1.0f, 1.0f, 0.0f, i, i2, i3, i4, z, z2);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, int i, int i2, int i3, int i4) {
        if (!this.adjustNeeded) {
            super.draw(koVar, f, f2, i, i2, i3, i4);
        } else {
            drawAdjusted(koVar, f, f2, 0.0f, 0.0f, i3, i4, 1.0f, 1.0f, 0.0f, i, i2, i3, i4, false, false);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!this.adjustNeeded) {
            super.draw(koVar, f, f2, f3, f4, f5, f6, f7, f8);
        } else {
            drawAdjustedUV(koVar, f, f2, 0.0f, 0.0f, f3, f4, 1.0f, 1.0f, 0.0f, f5, f6, f7, f8, false, false);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2) {
        if (!this.adjustNeeded) {
            super.draw(koVar, f, f2);
        } else {
            drawAdjusted(koVar, f, f2, 0.0f, 0.0f, koVar.getWidth(), koVar.getHeight(), 1.0f, 1.0f, 0.0f, 0, 1, 1, 0, false, false);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float f, float f2, float f3, float f4) {
        if (!this.adjustNeeded) {
            super.draw(koVar, f, f2, f3, f4);
        } else {
            drawAdjusted(koVar, f, f2, 0.0f, 0.0f, f3, f4, 1.0f, 1.0f, 0.0f, 0, 1, 1, 0, false, false);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f, f2);
        } else {
            drawAdjusted(textureRegion, f, f2, 0.0f, 0.0f, textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), 1.0f, 1.0f, 0.0f);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f, f2, f3, f4);
        } else {
            drawAdjusted(textureRegion, f, f2, 0.0f, 0.0f, f3, f4, 1.0f, 1.0f, 0.0f);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f, f2, f3, f4, f5, f6, f7, f8, f9);
        } else {
            drawAdjusted(textureRegion, f, f2, f3, f4, f5, f6, f7, f8, f9);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f, f2, f3, f4, f5, f6, f7, f8, f9, z);
        } else {
            drawAdjusted(textureRegion, f, f2, f3, f4, f5, f6, f7, f8, f9, z);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(ko koVar, float[] fArr, int i, int i2) {
        if (i2 % 20 != 0) {
            throw new k("invalid vertex count");
        }
        if (!this.adjustNeeded) {
            super.draw(koVar, fArr, i, i2);
        } else {
            drawAdjusted(koVar, fArr, i, i2);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.SpriteBatch, com.badlogic.gdx.graphics.g2d.Batch
    public void draw(TextureRegion textureRegion, float f, float f2, a aVar) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f, f2, aVar);
        } else {
            drawAdjusted(textureRegion, f, f2, aVar);
        }
    }

    private void drawAdjusted(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        drawAdjustedUV(textureRegion.texture, f, f2, f3, f4, f5, f6, f7, f8, f9, textureRegion.u, textureRegion.v2, textureRegion.u2, textureRegion.v, false, false);
    }

    private void drawAdjusted(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float width = 1.0f / koVar.getWidth();
        float height = 1.0f / koVar.getHeight();
        drawAdjustedUV(koVar, f, f2, f3, f4, f5, f6, f7, f8, f9, i * width, (i2 + i4) * height, width * (i + i3), height * i2, z, z2);
    }

    private void drawAdjustedUV(ko koVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, boolean z, boolean z2) {
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        } else if (this.idx == this.vertices.length) {
            super.flush();
        }
        float f22 = f + f3;
        float f23 = f2 + f4;
        float f24 = -f3;
        float f25 = -f4;
        float f26 = f5 - f3;
        float f27 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f24 *= f7;
            f25 *= f8;
            f26 *= f7;
            f27 *= f8;
        }
        if (f9 != 0.0f) {
            float d = h.d(f9);
            float c = h.c(f9);
            float f28 = d * f24;
            float f29 = f28 - (c * f25);
            float f30 = f24 * c;
            f25 = (f25 * d) + f30;
            float f31 = c * f27;
            f16 = f28 - f31;
            float f32 = f27 * d;
            float f33 = f30 + f32;
            float f34 = (d * f26) - f31;
            float f35 = f32 + (c * f26);
            float f36 = f35 - (f33 - f25);
            f14 = (f34 - f16) + f29;
            f26 = f34;
            f15 = f35;
            f27 = f33;
            f24 = f29;
            f17 = f36;
        } else {
            f14 = f26;
            f15 = f27;
            f16 = f24;
            f17 = f25;
        }
        float f37 = f24 + f22;
        float f38 = f25 + f23;
        float f39 = f16 + f22;
        float f40 = f27 + f23;
        float f41 = f26 + f22;
        float f42 = f15 + f23;
        float f43 = f14 + f22;
        float f44 = f17 + f23;
        if (z) {
            f19 = f10;
            f18 = f12;
        } else {
            f18 = f10;
            f19 = f12;
        }
        if (z2) {
            f21 = f11;
            f20 = f13;
        } else {
            f20 = f11;
            f21 = f13;
        }
        a aVar = this.adjustAffine;
        this.vertices[this.idx + 0] = (aVar.a * f37) + (aVar.b * f38) + aVar.c;
        this.vertices[this.idx + 1] = (aVar.d * f37) + (aVar.e * f38) + aVar.f;
        this.vertices[this.idx + 2] = this.colorPacked;
        this.vertices[this.idx + 3] = f18;
        this.vertices[this.idx + 4] = f20;
        this.vertices[this.idx + 5] = (aVar.a * f39) + (aVar.b * f40) + aVar.c;
        this.vertices[this.idx + 6] = (aVar.d * f39) + (aVar.e * f40) + aVar.f;
        this.vertices[this.idx + 7] = this.colorPacked;
        this.vertices[this.idx + 8] = f18;
        this.vertices[this.idx + 9] = f21;
        this.vertices[this.idx + 10] = (aVar.a * f41) + (aVar.b * f42) + aVar.c;
        this.vertices[this.idx + 11] = (aVar.d * f41) + (aVar.e * f42) + aVar.f;
        this.vertices[this.idx + 12] = this.colorPacked;
        this.vertices[this.idx + 13] = f19;
        this.vertices[this.idx + 14] = f21;
        this.vertices[this.idx + 15] = (aVar.a * f43) + (aVar.b * f44) + aVar.c;
        this.vertices[this.idx + 16] = (aVar.d * f43) + (aVar.e * f44) + aVar.f;
        this.vertices[this.idx + 17] = this.colorPacked;
        this.vertices[this.idx + 18] = f19;
        this.vertices[this.idx + 19] = f20;
        this.idx += 20;
    }

    private void drawAdjusted(TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z) {
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
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (textureRegion.texture != this.lastTexture) {
            switchTexture(textureRegion.texture);
        } else if (this.idx == this.vertices.length) {
            super.flush();
        }
        float f23 = f + f3;
        float f24 = f2 + f4;
        float f25 = -f3;
        float f26 = -f4;
        float f27 = f5 - f3;
        float f28 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f25 *= f7;
            f26 *= f8;
            f27 *= f7;
            f28 *= f8;
        }
        if (f9 != 0.0f) {
            float d = h.d(f9);
            float c = h.c(f9);
            float f29 = d * f25;
            float f30 = f29 - (c * f26);
            float f31 = f25 * c;
            f26 = (f26 * d) + f31;
            float f32 = c * f28;
            f13 = f29 - f32;
            float f33 = f28 * d;
            float f34 = f31 + f33;
            f10 = (d * f27) - f32;
            float f35 = f33 + (c * f27);
            float f36 = f35 - (f34 - f26);
            f11 = (f10 - f13) + f30;
            f12 = f35;
            f28 = f34;
            f25 = f30;
            f14 = f36;
        } else {
            f10 = f27;
            f11 = f10;
            f12 = f28;
            f13 = f25;
            f14 = f26;
        }
        float f37 = f25 + f23;
        float f38 = f26 + f24;
        float f39 = f13 + f23;
        float f40 = f28 + f24;
        float f41 = f10 + f23;
        float f42 = f12 + f24;
        float f43 = f11 + f23;
        float f44 = f14 + f24;
        if (z) {
            float f45 = textureRegion.u2;
            f15 = textureRegion.v2;
            f16 = textureRegion.u;
            f17 = textureRegion.v2;
            f18 = textureRegion.u;
            f19 = textureRegion.v;
            float f46 = textureRegion.u2;
            f20 = textureRegion.v;
            f21 = f46;
            f22 = f45;
        } else {
            float f47 = textureRegion.u;
            f15 = textureRegion.v;
            f16 = textureRegion.u2;
            f17 = textureRegion.v;
            f18 = textureRegion.u2;
            f19 = textureRegion.v2;
            float f48 = textureRegion.u;
            f20 = textureRegion.v2;
            f21 = f48;
            f22 = f47;
        }
        a aVar = this.adjustAffine;
        this.vertices[this.idx + 0] = (aVar.a * f37) + (aVar.b * f38) + aVar.c;
        this.vertices[this.idx + 1] = (aVar.d * f37) + (aVar.e * f38) + aVar.f;
        this.vertices[this.idx + 2] = this.colorPacked;
        this.vertices[this.idx + 3] = f22;
        this.vertices[this.idx + 4] = f15;
        this.vertices[this.idx + 5] = (aVar.a * f39) + (aVar.b * f40) + aVar.c;
        this.vertices[this.idx + 6] = (aVar.d * f39) + (aVar.e * f40) + aVar.f;
        this.vertices[this.idx + 7] = this.colorPacked;
        this.vertices[this.idx + 8] = f16;
        this.vertices[this.idx + 9] = f17;
        this.vertices[this.idx + 10] = (aVar.a * f41) + (aVar.b * f42) + aVar.c;
        this.vertices[this.idx + 11] = (aVar.d * f41) + (aVar.e * f42) + aVar.f;
        this.vertices[this.idx + 12] = this.colorPacked;
        this.vertices[this.idx + 13] = f18;
        this.vertices[this.idx + 14] = f19;
        this.vertices[this.idx + 15] = (aVar.a * f43) + (aVar.b * f44) + aVar.c;
        this.vertices[this.idx + 16] = (aVar.d * f43) + (aVar.e * f44) + aVar.f;
        this.vertices[this.idx + 17] = this.colorPacked;
        this.vertices[this.idx + 18] = f21;
        this.vertices[this.idx + 19] = f20;
        this.idx += 20;
    }

    private void drawAdjusted(TextureRegion textureRegion, float f, float f2, a aVar) {
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (textureRegion.texture != this.lastTexture) {
            switchTexture(textureRegion.texture);
        } else if (this.idx == this.vertices.length) {
            super.flush();
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
        a aVar2 = this.adjustAffine;
        this.vertices[this.idx + 0] = (aVar2.a * f3) + (aVar2.b * f4) + aVar2.c;
        this.vertices[this.idx + 1] = (aVar2.d * f3) + (aVar2.e * f4) + aVar2.f;
        this.vertices[this.idx + 2] = this.colorPacked;
        this.vertices[this.idx + 3] = f11;
        this.vertices[this.idx + 4] = f12;
        this.vertices[this.idx + 5] = (aVar2.a * f5) + (aVar2.b * f6) + aVar2.c;
        this.vertices[this.idx + 6] = (aVar2.d * f5) + (aVar2.e * f6) + aVar2.f;
        this.vertices[this.idx + 7] = this.colorPacked;
        this.vertices[this.idx + 8] = f11;
        this.vertices[this.idx + 9] = f14;
        this.vertices[this.idx + 10] = (aVar2.a * f7) + (aVar2.b * f8) + aVar2.c;
        this.vertices[this.idx + 11] = (aVar2.d * f7) + (aVar2.e * f8) + aVar2.f;
        this.vertices[this.idx + 12] = this.colorPacked;
        this.vertices[this.idx + 13] = f13;
        this.vertices[this.idx + 14] = f14;
        this.vertices[this.idx + 15] = (aVar2.a * f9) + (aVar2.b * f10) + aVar2.c;
        this.vertices[this.idx + 16] = (aVar2.d * f9) + (aVar2.e * f10) + aVar2.f;
        this.vertices[this.idx + 17] = this.colorPacked;
        this.vertices[this.idx + 18] = f13;
        this.vertices[this.idx + 19] = f12;
        this.idx += 20;
    }

    private void drawAdjusted(ko koVar, float[] fArr, int i, int i2) {
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (koVar != this.lastTexture) {
            switchTexture(koVar);
        }
        a aVar = this.adjustAffine;
        int min = Math.min(this.vertices.length - this.idx, i2);
        do {
            i2 -= min;
            while (min > 0) {
                float f = fArr[i];
                float f2 = fArr[i + 1];
                this.vertices[this.idx] = (aVar.a * f) + (aVar.b * f2) + aVar.c;
                this.vertices[this.idx + 1] = (aVar.d * f) + (aVar.e * f2) + aVar.f;
                this.vertices[this.idx + 2] = fArr[i + 2];
                this.vertices[this.idx + 3] = fArr[i + 3];
                this.vertices[this.idx + 4] = fArr[i + 4];
                this.idx += 5;
                i += 5;
                min -= 5;
            }
            if (i2 > 0) {
                super.flush();
                min = Math.min(this.vertices.length, i2);
                continue;
            }
        } while (i2 > 0);
    }

    private static boolean checkEqual(Matrix4 matrix4, Matrix4 matrix42) {
        if (matrix4 == matrix42) {
            return true;
        }
        return matrix4.a[0] == matrix42.a[0] && matrix4.a[1] == matrix42.a[1] && matrix4.a[4] == matrix42.a[4] && matrix4.a[5] == matrix42.a[5] && matrix4.a[12] == matrix42.a[12] && matrix4.a[13] == matrix42.a[13];
    }

    private static boolean checkEqual(Matrix4 matrix4, a aVar) {
        float[] b = matrix4.b();
        return b[0] == aVar.a && b[1] == aVar.d && b[4] == aVar.b && b[5] == aVar.e && b[12] == aVar.c && b[13] == aVar.f;
    }

    private static boolean checkIdt(Matrix4 matrix4) {
        float[] b = matrix4.b();
        return b[0] == 1.0f && b[1] == 0.0f && b[4] == 0.0f && b[5] == 1.0f && b[12] == 0.0f && b[13] == 0.0f;
    }
}
