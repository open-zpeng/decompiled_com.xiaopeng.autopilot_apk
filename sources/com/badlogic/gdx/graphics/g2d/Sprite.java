package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.utils.t;
/* loaded from: classes.dex */
public class Sprite extends TextureRegion {
    static final int SPRITE_SIZE = 20;
    static final int VERTEX_SIZE = 5;
    private n bounds;
    private final ka color;
    private boolean dirty;
    float height;
    private float originX;
    private float originY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    final float[] vertices;
    float width;
    private float x;
    private float y;

    public Sprite() {
        this.vertices = new float[20];
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public Sprite(ko koVar) {
        this(koVar, 0, 0, koVar.getWidth(), koVar.getHeight());
    }

    public Sprite(ko koVar, int i, int i2) {
        this(koVar, 0, 0, i, i2);
    }

    public Sprite(ko koVar, int i, int i2, int i3, int i4) {
        this.vertices = new float[20];
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        if (koVar == null) {
            throw new IllegalArgumentException("texture cannot be null.");
        }
        this.texture = koVar;
        setRegion(i, i2, i3, i4);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize(Math.abs(i3), Math.abs(i4));
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(TextureRegion textureRegion) {
        this.vertices = new float[20];
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        setRegion(textureRegion);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.vertices = new float[20];
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        setRegion(textureRegion, i, i2, i3, i4);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize(Math.abs(i3), Math.abs(i4));
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(Sprite sprite) {
        this.vertices = new float[20];
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        set(sprite);
    }

    public void set(Sprite sprite) {
        if (sprite == null) {
            throw new IllegalArgumentException("sprite cannot be null.");
        }
        System.arraycopy(sprite.vertices, 0, this.vertices, 0, 20);
        this.texture = sprite.texture;
        this.u = sprite.u;
        this.v = sprite.v;
        this.u2 = sprite.u2;
        this.v2 = sprite.v2;
        this.x = sprite.x;
        this.y = sprite.y;
        this.width = sprite.width;
        this.height = sprite.height;
        this.regionWidth = sprite.regionWidth;
        this.regionHeight = sprite.regionHeight;
        this.originX = sprite.originX;
        this.originY = sprite.originY;
        this.rotation = sprite.rotation;
        this.scaleX = sprite.scaleX;
        this.scaleY = sprite.scaleY;
        this.color.a(sprite.color);
        this.dirty = sprite.dirty;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        if (this.dirty) {
            return;
        }
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float[] fArr = this.vertices;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[5] = f;
        fArr[6] = f6;
        fArr[10] = f5;
        fArr[11] = f6;
        fArr[15] = f5;
        fArr[16] = f2;
        if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
            return;
        }
        this.dirty = true;
    }

    public void setSize(float f, float f2) {
        this.width = f;
        this.height = f2;
        if (this.dirty) {
            return;
        }
        float f3 = this.x;
        float f4 = f + f3;
        float f5 = this.y;
        float f6 = f2 + f5;
        float[] fArr = this.vertices;
        fArr[0] = f3;
        fArr[1] = f5;
        fArr[5] = f3;
        fArr[6] = f6;
        fArr[10] = f4;
        fArr[11] = f6;
        fArr[15] = f4;
        fArr[16] = f5;
        if (this.rotation == 0.0f && this.scaleX == 1.0f && this.scaleY == 1.0f) {
            return;
        }
        this.dirty = true;
    }

    public void setPosition(float f, float f2) {
        translate(f - this.x, f2 - this.y);
    }

    public void setOriginBasedPosition(float f, float f2) {
        setPosition(f - this.originX, f2 - this.originY);
    }

    public void setX(float f) {
        translateX(f - this.x);
    }

    public void setY(float f) {
        translateY(f - this.y);
    }

    public void setCenterX(float f) {
        setX(f - (this.width / 2.0f));
    }

    public void setCenterY(float f) {
        setY(f - (this.height / 2.0f));
    }

    public void setCenter(float f, float f2) {
        setCenterX(f);
        setCenterY(f2);
    }

    public void translateX(float f) {
        this.x += f;
        if (this.dirty) {
            return;
        }
        float[] fArr = this.vertices;
        fArr[0] = fArr[0] + f;
        fArr[5] = fArr[5] + f;
        fArr[10] = fArr[10] + f;
        fArr[15] = fArr[15] + f;
    }

    public void translateY(float f) {
        this.y += f;
        if (this.dirty) {
            return;
        }
        float[] fArr = this.vertices;
        fArr[1] = fArr[1] + f;
        fArr[6] = fArr[6] + f;
        fArr[11] = fArr[11] + f;
        fArr[16] = fArr[16] + f;
    }

    public void translate(float f, float f2) {
        this.x += f;
        this.y += f2;
        if (this.dirty) {
            return;
        }
        float[] fArr = this.vertices;
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] + f2;
        fArr[5] = fArr[5] + f;
        fArr[6] = fArr[6] + f2;
        fArr[10] = fArr[10] + f;
        fArr[11] = fArr[11] + f2;
        fArr[15] = fArr[15] + f;
        fArr[16] = fArr[16] + f2;
    }

    public void setColor(ka kaVar) {
        this.color.a(kaVar);
        float b = kaVar.b();
        float[] fArr = this.vertices;
        fArr[2] = b;
        fArr[7] = b;
        fArr[12] = b;
        fArr[17] = b;
    }

    public void setAlpha(float f) {
        ka kaVar = this.color;
        kaVar.M = f;
        float b = kaVar.b();
        float[] fArr = this.vertices;
        fArr[2] = b;
        fArr[7] = b;
        fArr[12] = b;
        fArr[17] = b;
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.color.a(f, f2, f3, f4);
        float b = this.color.b();
        float[] fArr = this.vertices;
        fArr[2] = b;
        fArr[7] = b;
        fArr[12] = b;
        fArr[17] = b;
    }

    public void setPackedColor(float f) {
        ka.a(this.color, f);
        float[] fArr = this.vertices;
        fArr[2] = f;
        fArr[7] = f;
        fArr[12] = f;
        fArr[17] = f;
    }

    public void setOrigin(float f, float f2) {
        this.originX = f;
        this.originY = f2;
        this.dirty = true;
    }

    public void setOriginCenter() {
        this.originX = this.width / 2.0f;
        this.originY = this.height / 2.0f;
        this.dirty = true;
    }

    public void setRotation(float f) {
        this.rotation = f;
        this.dirty = true;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void rotate(float f) {
        if (f == 0.0f) {
            return;
        }
        this.rotation += f;
        this.dirty = true;
    }

    public void rotate90(boolean z) {
        float[] fArr = this.vertices;
        if (z) {
            float f = fArr[4];
            fArr[4] = fArr[19];
            fArr[19] = fArr[14];
            fArr[14] = fArr[9];
            fArr[9] = f;
            float f2 = fArr[3];
            fArr[3] = fArr[18];
            fArr[18] = fArr[13];
            fArr[13] = fArr[8];
            fArr[8] = f2;
            return;
        }
        float f3 = fArr[4];
        fArr[4] = fArr[9];
        fArr[9] = fArr[14];
        fArr[14] = fArr[19];
        fArr[19] = f3;
        float f4 = fArr[3];
        fArr[3] = fArr[8];
        fArr[8] = fArr[13];
        fArr[13] = fArr[18];
        fArr[18] = f4;
    }

    public void setScale(float f) {
        this.scaleX = f;
        this.scaleY = f;
        this.dirty = true;
    }

    public void setScale(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
        this.dirty = true;
    }

    public void scale(float f) {
        this.scaleX += f;
        this.scaleY += f;
        this.dirty = true;
    }

    public float[] getVertices() {
        if (this.dirty) {
            this.dirty = false;
            float[] fArr = this.vertices;
            float f = -this.originX;
            float f2 = -this.originY;
            float f3 = this.width + f;
            float f4 = this.height + f2;
            float f5 = this.x - f;
            float f6 = this.y - f2;
            if (this.scaleX != 1.0f || this.scaleY != 1.0f) {
                float f7 = this.scaleX;
                f *= f7;
                float f8 = this.scaleY;
                f2 *= f8;
                f3 *= f7;
                f4 *= f8;
            }
            float f9 = this.rotation;
            if (f9 != 0.0f) {
                float d = h.d(f9);
                float c = h.c(this.rotation);
                float f10 = f * d;
                float f11 = f * c;
                float f12 = f2 * d;
                float f13 = f3 * d;
                float f14 = d * f4;
                float f15 = f4 * c;
                float f16 = (f10 - (f2 * c)) + f5;
                float f17 = f12 + f11 + f6;
                fArr[0] = f16;
                fArr[1] = f17;
                float f18 = (f10 - f15) + f5;
                float f19 = f11 + f14 + f6;
                fArr[5] = f18;
                fArr[6] = f19;
                float f20 = (f13 - f15) + f5;
                float f21 = f14 + (f3 * c) + f6;
                fArr[10] = f20;
                fArr[11] = f21;
                fArr[15] = f16 + (f20 - f18);
                fArr[16] = f21 - (f19 - f17);
            } else {
                float f22 = f + f5;
                float f23 = f2 + f6;
                float f24 = f3 + f5;
                float f25 = f4 + f6;
                fArr[0] = f22;
                fArr[1] = f23;
                fArr[5] = f22;
                fArr[6] = f25;
                fArr[10] = f24;
                fArr[11] = f25;
                fArr[15] = f24;
                fArr[16] = f23;
            }
        }
        return this.vertices;
    }

    public n getBoundingRectangle() {
        float[] vertices = getVertices();
        float f = vertices[0];
        float f2 = vertices[1];
        float f3 = vertices[0];
        float f4 = vertices[1];
        if (f > vertices[5]) {
            f = vertices[5];
        }
        if (f > vertices[10]) {
            f = vertices[10];
        }
        if (f > vertices[15]) {
            f = vertices[15];
        }
        if (f3 < vertices[5]) {
            f3 = vertices[5];
        }
        if (f3 < vertices[10]) {
            f3 = vertices[10];
        }
        if (f3 < vertices[15]) {
            f3 = vertices[15];
        }
        if (f2 > vertices[6]) {
            f2 = vertices[6];
        }
        if (f2 > vertices[11]) {
            f2 = vertices[11];
        }
        if (f2 > vertices[16]) {
            f2 = vertices[16];
        }
        if (f4 < vertices[6]) {
            f4 = vertices[6];
        }
        if (f4 < vertices[11]) {
            f4 = vertices[11];
        }
        if (f4 < vertices[16]) {
            f4 = vertices[16];
        }
        if (this.bounds == null) {
            this.bounds = new n();
        }
        n nVar = this.bounds;
        nVar.x = f;
        nVar.y = f2;
        nVar.width = f3 - f;
        nVar.height = f4 - f2;
        return nVar;
    }

    public void draw(Batch batch) {
        batch.draw(this.texture, getVertices(), 0, 20);
    }

    public void draw(Batch batch, float f) {
        float f2 = getColor().M;
        setAlpha(f * f2);
        draw(batch);
        setAlpha(f2);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public ka getColor() {
        int c = t.c(this.vertices[2]);
        ka kaVar = this.color;
        kaVar.J = (c & 255) / 255.0f;
        kaVar.K = ((c >>> 8) & 255) / 255.0f;
        kaVar.L = ((c >>> 16) & 255) / 255.0f;
        kaVar.M = ((c >>> 24) & 255) / 255.0f;
        return kaVar;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setRegion(float f, float f2, float f3, float f4) {
        super.setRegion(f, f2, f3, f4);
        float[] fArr = this.vertices;
        fArr[3] = f;
        fArr[4] = f4;
        fArr[8] = f;
        fArr[9] = f2;
        fArr[13] = f3;
        fArr[14] = f2;
        fArr[18] = f3;
        fArr[19] = f4;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setU(float f) {
        super.setU(f);
        float[] fArr = this.vertices;
        fArr[3] = f;
        fArr[8] = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setV(float f) {
        super.setV(f);
        float[] fArr = this.vertices;
        fArr[9] = f;
        fArr[14] = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setU2(float f) {
        super.setU2(f);
        float[] fArr = this.vertices;
        fArr[13] = f;
        fArr[18] = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setV2(float f) {
        super.setV2(f);
        float[] fArr = this.vertices;
        fArr[4] = f;
        fArr[19] = f;
    }

    public void setFlip(boolean z, boolean z2) {
        flip(isFlipX() != z, isFlipY() != z2);
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void flip(boolean z, boolean z2) {
        super.flip(z, z2);
        float[] fArr = this.vertices;
        if (z) {
            float f = fArr[3];
            fArr[3] = fArr[13];
            fArr[13] = f;
            float f2 = fArr[8];
            fArr[8] = fArr[18];
            fArr[18] = f2;
        }
        if (z2) {
            float f3 = fArr[4];
            fArr[4] = fArr[14];
            fArr[14] = f3;
            float f4 = fArr[9];
            fArr[9] = fArr[19];
            fArr[19] = f4;
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void scroll(float f, float f2) {
        float[] fArr = this.vertices;
        if (f != 0.0f) {
            float f3 = (fArr[3] + f) % 1.0f;
            float width = (this.width / this.texture.getWidth()) + f3;
            this.u = f3;
            this.u2 = width;
            fArr[3] = f3;
            fArr[8] = f3;
            fArr[13] = width;
            fArr[18] = width;
        }
        if (f2 != 0.0f) {
            float f4 = (fArr[9] + f2) % 1.0f;
            float height = (this.height / this.texture.getHeight()) + f4;
            this.v = f4;
            this.v2 = height;
            fArr[4] = height;
            fArr[9] = f4;
            fArr[14] = f4;
            fArr[19] = height;
        }
    }
}
